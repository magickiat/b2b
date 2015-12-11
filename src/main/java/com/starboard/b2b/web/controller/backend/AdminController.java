package com.starboard.b2b.web.controller.backend;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

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

	@RequestMapping(value = "/image/list", method = RequestMethod.GET)
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

	@RequestMapping(value = "new-folder", method = RequestMethod.POST)
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
}
