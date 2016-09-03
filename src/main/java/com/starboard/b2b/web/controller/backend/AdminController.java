package com.starboard.b2b.web.controller.backend;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.B2BFile;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.util.ApplicationConfig;
import com.starboard.b2b.util.B2BFileUtil;
import com.starboard.b2b.web.form.SearchImageForm;

@Controller
@RequestMapping("/backend/admin")
public class AdminController {

	private static final Logger log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private Environment env;
	
	@Autowired
	private ApplicationConfig applicationConfig;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	String index(Model model) {
		return "pages-back/admin/index";
	}

	@GetMapping("/file/index")
	String file(Model model) {
		return list(new SearchImageForm(), model);
	}

	@RequestMapping(value = "/file/list", method = RequestMethod.GET)
	String list(@ModelAttribute("searchForm") SearchImageForm form, Model model) throws B2BException {
		log.info("selected folder = " + form.getFolder());
		String rootPath = env.getProperty("upload.path");
		if (rootPath == null) {
			throw new B2BException("Not found upload path");
		}

		// List folder
		ArrayList<String> files = new ArrayList<>();
		files.add("BIG");
		files.add("Category");
		files.add("Thumbnail");

		model.addAttribute("folders", files);

		String selectedFolder = form.getFolder();
		if (StringUtils.isNotEmpty(form.getFolder())) {
			if (form.getFolder().startsWith(B2BConstant.PRODUCT_IMAGE_FOLDER)) {
				selectedFolder = form.getFolder().split("/")[1];
			}
		}
		model.addAttribute("selectedFolder", selectedFolder);

		if (!files.isEmpty()) {
			List<B2BFile> listFile = new ArrayList<>();

			String subFolder = "";
			if (StringUtils.isEmpty(form.getFolder())) {
				subFolder = B2BConstant.PRODUCT_IMAGE_FOLDER + "/" + files.get(0);
			} else if (!form.getFolder().startsWith(B2BConstant.PRODUCT_IMAGE_FOLDER)) {
				subFolder = B2BConstant.PRODUCT_IMAGE_FOLDER + "/" + form.getFolder();
			} else {
				subFolder = form.getFolder();
			}

			listFile = B2BFileUtil.list(rootPath, subFolder);
			log.info("listFile size: " + (listFile == null ? 0 : listFile.size()));
			model.addAttribute("listFile", listFile);
			model.addAttribute("subFolder", subFolder);
			
			Page<B2BFile> result = new Page<>();
			result.setCurrent(form.getPage());
			result.setResult(listFile);
			result.setPageSize(applicationConfig.getPageSize());
			result.setTotal(listFile.size());

			model.addAttribute("resultPage", result);
			model.addAttribute("searchForm", form);
		}

		return "pages-back/admin/image/index";
	}

	@RequestMapping(value = "/file/new-folder", method = RequestMethod.POST)
	String newFolder(@ModelAttribute("searchForm") SearchImageForm form, Model model) {

		log.info("Sub folder = {}\tNew folder name: {}", form.getSubFolder(), form.getFolderName());

		String rootPath = env.getProperty("upload.path");
		if (rootPath == null) {
			throw new B2BException("Not found upload path");
		}

		if (form.getSubFolder().contains("..") || form.getFolderName().contains("..")) {
			throw new B2BException("Invalid path");
		}

		File rootFolder = new File(rootPath, form.getSubFolder());
		if (!rootFolder.isDirectory()) {
			rootFolder.mkdirs();
			// throw new B2BException("Invalid path");
		}

		File newFolder = new File(rootFolder.getAbsolutePath(), form.getFolderName());
		if (newFolder.exists()) {
			throw new B2BException("Exist folder: " + form.getFolderName());
		}

		log.info("new folder path: " + newFolder.getAbsolutePath());
		boolean success = newFolder.mkdirs();
		log.info("success: " + success);

		if (!success) {
			throw new B2BException("Cannot create folder");
		}

		return list(form, model);

	}

	@RequestMapping(value = "/file/upload", method = RequestMethod.POST)
	public @ResponseBody List<B2BFile> upload(@RequestParam String subFolder, MultipartHttpServletRequest request, HttpServletResponse response)
			throws IOException {

		Map<String, MultipartFile> fileMap = request.getFileMap();
		// Maintain a list to send back the files info. to the client side
		List<B2BFile> uploadedFiles = new ArrayList<>();

		// Iterate through the map
		for (MultipartFile uploadFile : fileMap.values()) {

			log.info("uploaded file: {}\tContent type: {}", uploadFile.getOriginalFilename(), uploadFile.getContentType());
			B2BFile file = new B2BFile();
			file.setName(uploadFile.getName());
			file.setNameWithPath(subFolder + uploadFile.getName());
			file.setSize(uploadFile.getSize());
			file.setContentType(uploadFile.getContentType());

			if (uploadFile.getSize() < 1) {
				file.setRemark("File size is zero");
			} else if (!B2BFileUtil.isImage(uploadFile.getContentType())) {
				file.setImage(false);
			} else {
				file.setImage(true);

				// Save the file to local disk
				String rootPath = env.getProperty("upload.path");
				if (rootPath == null) {
					throw new B2BException("Not found upload path");
				}
				try {
					B2BFileUtil.saveFileToLocalDisk(rootPath, subFolder, uploadFile);
				} catch (Exception e) {
					log.error(e.getMessage(), e);
					file.setRemark(e.getMessage());
				}
			}
			// adding the file info to the list
			uploadedFiles.add(file);
		}

		return uploadedFiles;
	}

	@RequestMapping(value = "/file/delete")
	@ResponseBody
	int deleteFile(@RequestParam("subFolder") String subFolder, @RequestParam("files[]") String[] files, Model model) {
		log.info("delete file in subfolder " + subFolder);
		String rootPath = env.getProperty("upload.path");
		if (rootPath == null) {
			throw new B2BException("Not found upload path");
		}

		int deletedFile = B2BFileUtil.delete(rootPath, files);
		log.info("Deleted {} files", deletedFile);
		return deletedFile;
	}
}
