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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.starboard.b2b.dto.B2BFile;
import com.starboard.b2b.exception.B2BException;
import com.starboard.b2b.util.B2BFileUtil;

@Controller
@RequestMapping("/backend/admin")
public class AdminController {

	private static final Logger log = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private Environment env;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	String index(Model model) {
		return "pages-back/admin/index";
	}

	@RequestMapping(value = "/file/list", method = RequestMethod.GET)
	String list(@RequestParam(name = "folder", required = false) String folder, Model model) throws B2BException {

		String rootPath = env.getProperty("upload.path");
		if (rootPath == null) {
			throw new B2BException("Not found upload path");
		}

		// List folder
		ArrayList<String> files = new ArrayList<>();
		files.add("BIG");
		files.add("Medium");
		files.add("Technology");

		model.addAttribute("folders", files);

		String selectedFolder = folder;
		if (StringUtils.isNotEmpty(folder)) {
			if (folder.startsWith("product_image")) {
				selectedFolder = folder.split("/")[1];
			}
		}
		model.addAttribute("selectedFolder", selectedFolder);

		if (!files.isEmpty()) {
			List<B2BFile> listFile = new ArrayList<>();

			String subFolder = "";
			if (StringUtils.isEmpty(folder)) {
				subFolder = "product_image" + File.separator + files.get(0);
			} else if (!folder.startsWith("product_image")) {
				subFolder = "product_image" + File.separator + folder;
			} else {
				subFolder = folder;
			}

			listFile = B2BFileUtil.list(rootPath, subFolder);
			log.info("listFile size: " + (listFile == null ? 0 : listFile.size()));
			model.addAttribute("listFile", listFile);
			model.addAttribute("subFolder", subFolder);

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
			throw new B2BException("Invalid path");
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

		return list(subFolder, model);

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
}
