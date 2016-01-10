package com.starboard.b2b.web.controller.backend;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.starboard.b2b.common.Page;
import com.starboard.b2b.dto.ContactUsDTO;
import com.starboard.b2b.service.ContactUsService;
import com.starboard.b2b.web.form.CreateContactUsForm;
import com.starboard.b2b.web.form.SearchContactUsForm;

@Controller
@RequestMapping("/backend/contactus/")
public class BackendContactUsController {

	private static final Logger log = LoggerFactory.getLogger(BackendContactUsController.class);

	@Autowired
	private ContactUsService contactUsService;

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	String index(Model model) {
		return search(new SearchContactUsForm(), model);
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	String search(@ModelAttribute("searchForm") SearchContactUsForm form, Model model) {
		Page<ContactUsDTO> resultPage = contactUsService.search(form);
		model.addAttribute("resultPage", resultPage);
		model.addAttribute("searchForm", form);

		return "pages-back/contact-us/index";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	String add(Model model) {
		model.addAttribute("createForm", new CreateContactUsForm());
		return "pages-back/contact-us/add";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	String add(@Valid @ModelAttribute("createForm") CreateContactUsForm createForm, BindingResult binding, Model model) {
		log.info("POST /add");
		log.info("form: " + createForm);

		if (binding.hasErrors()) {
			return "pages-back/contact-us/add";
		}

		contactUsService.save(createForm);

		return index(model);
	}
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	String delete(@RequestParam("id") long id, Model model){
		contactUsService.delete(id);
		return search(new SearchContactUsForm(), model);
	}
}
