package com.starboard.b2b.web.controller.login;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.starboard.b2b.common.B2BConstant;
import com.starboard.b2b.dto.B2BFile;
import com.starboard.b2b.util.B2BFileUtil;

@Controller
@RequestMapping("/login")
public class LoginController {

	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@Autowired
	private Environment env;

	@RequestMapping(method = RequestMethod.GET)
	String form(Model model) {
		log.info("/login GET");
		
		Map<String, List<String>> response = new HashMap<String, List<String>>();
		Gson gson = new GsonBuilder().disableHtmlEscaping().create();
		List<String> file_list = new ArrayList<String>();
		String rootPath = env.getProperty("upload.path");
		log.info("path: " + B2BConstant.TEMPLATE_IMAGE_FOLDER + "/" + B2BConstant.TEMPLATE_IMAGE_SLIDE_END);
		log.info("current : " + B2BConstant.TEMPLATE_IMAGE_SLIDE_END);
		List<B2BFile> listFile = B2BFileUtil.list(rootPath, B2BConstant.TEMPLATE_IMAGE_FOLDER + "/" + B2BConstant.TEMPLATE_IMAGE_SLIDE_END);
		for (B2BFile b2bFile : listFile) {
			if (b2bFile.getNameWithPath().length() > 0) {
				file_list.add(b2bFile.getNameWithPath());
			}
		}
		
		response.put("data", file_list);
		
		model.addAttribute("loginForm", new LoginForm());
		model.addAttribute("background", gson.toJson(response));
		
		return "login";
	}

}
