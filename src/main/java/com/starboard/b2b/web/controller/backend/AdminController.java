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

@Controller
@RequestMapping("/backend/admin")
public class AdminController {

	private static final Logger log = LoggerFactory.getLogger(AdminController.class);
	private static final String DEFAULT_CURRENT_PATH = B2BConstant.PRODUCT_IMAGE_FOLDER + "/" + B2BConstant.PRODUCT_IMAGE_BIG;

	@Autowired
	private Environment env;

	@Autowired
	private ApplicationConfig applicationConfig;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	String index(Model model) {
		return "pages-back/admin/index";
	}

	@RequestMapping(value = "/sync-ax", method = RequestMethod.GET)
	String syncAxSearch(@RequestParam(name = "page", defaultValue = "1") int page, Model model) {
		return "pages-back/admin/sync";
	}

	@RequestMapping(value = "/sync-ax", method = RequestMethod.POST)
	String syncAxAction(Model model) {
		log.info("-----------------------------------------------");
		log.info("\tBEGIN SYNC AX");
		log.info("-----------------------------------------------");
		
		
		//TODO call sync service
		
		
		log.info("-----------------------------------------------");
		log.info("\tFINISHED lSYNC AX");
		log.info("-----------------------------------------------");
		return syncAxSearch(1, model);
	}

	@GetMapping("/file/list")
	String list(@RequestParam(name = "page", defaultValue = "1") int page,
			@RequestParam(name = "folder", defaultValue = B2BConstant.PRODUCT_IMAGE_BIG) String folder,
			@RequestParam(name = "currentPath", defaultValue = DEFAULT_CURRENT_PATH) String currentPath,
			@RequestParam(name = "keyword", required = false) String keyword, Model model) throws B2BException {

		log.info("folder = " + folder);
		log.info("keyword = " + keyword);
		log.info("currentPath = " + currentPath);

		model.addAttribute("keyword", keyword);
		model.addAttribute("folder", folder);
		model.addAttribute("currentPath", currentPath);

		if (currentPath.contains("..")) {
			throw new IllegalArgumentException("Invalid path");
		}
		if (!currentPath.startsWith(B2BConstant.PRODUCT_IMAGE_FOLDER)) {
			currentPath = B2BConstant.PRODUCT_IMAGE_FOLDER + "/" + currentPath;
		}

		String rootPath = env.getProperty("upload.path");
		if (rootPath == null) {
			throw new B2BException("Not found upload path");
		}

		// List folder
		ArrayList<String> files = new ArrayList<>(3);
		files.add(B2BConstant.PRODUCT_IMAGE_BIG);
		files.add(B2BConstant.PRODUCT_IMAGE_CATEGORY);
		files.add(B2BConstant.PRODUCT_IMAGE_THUMBNAIL);

		model.addAttribute("folders", files);

		if (!files.isEmpty()) {

			List<B2BFile> listFile = B2BFileUtil.list(rootPath, currentPath);

			if (!listFile.isEmpty() && StringUtils.isNotEmpty(keyword)) {
				log.info("Filter by keyword: " + keyword);

				List<B2BFile> tmpList = new ArrayList<>();
				for (B2BFile b2bFile : listFile) {
					if (b2bFile.getName().toLowerCase().contains(keyword.toLowerCase())) {
						tmpList.add(b2bFile);
					}
				}

				listFile = tmpList;
			}

			log.info("listFile size: " + (listFile == null ? 0 : listFile.size()));

			int pageSize = applicationConfig.getPageSize();
			int firstItem = (page - 1) * pageSize;
			int lastItem = firstItem + pageSize;

			if (listFile.size() < lastItem) {
				lastItem = listFile.size();
			}

			List<B2BFile> pagingItem = new ArrayList<>();
			for (int i = firstItem; i < lastItem; i++) {
				pagingItem.add(listFile.get(i));
			}

			Page<B2BFile> result = new Page<>();
			result.setCurrent(page);
			result.setResult(pagingItem);
			result.setPageSize(pageSize);
			result.setTotal(listFile.size());

			model.addAttribute("resultPage", result);

		}

		return "pages-back/admin/image/index";
	}

	@RequestMapping(value = "/file/new-folder", method = RequestMethod.POST)
	String newFolder(@RequestParam(name = "subFolder", required = true) String subFolder,
			@RequestParam(name = "folderName", required = true) String folderName, Model model) {

		log.info("Sub folder = {}\tNew folder name: {}", subFolder, folderName);

		String rootPath = env.getProperty("upload.path");
		if (rootPath == null) {
			throw new B2BException("Not found upload path");
		}

		if (subFolder.contains("..") || folderName.contains("..")) {
			throw new B2BException("Invalid path");
		}

		File rootFolder = new File(rootPath, subFolder);
		if (!rootFolder.isDirectory()) {
			rootFolder.mkdirs();
			// throw new B2BException("Invalid path");
		}

		File newFolder = new File(rootFolder.getAbsolutePath(), folderName);
		if (newFolder.exists()) {
			throw new B2BException("Exist folder: " + folderName);
		}

		log.info("new folder path: " + newFolder.getAbsolutePath());
		boolean success = newFolder.mkdirs();
		log.info("success: " + success);

		if (!success) {
			throw new B2BException("Cannot create folder");
		}

		return list(1, null, null, null, model);

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
		String rootPath = env.getProperty("upload.path");
		if (rootPath == null) {
			throw new B2BException("Not found upload path");
		}

		int deletedFile = B2BFileUtil.delete(rootPath, files);
		log.info("Deleted {} files", deletedFile);
		return deletedFile;
	}
}
