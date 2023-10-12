package org.dragon.yunpeng.thymeleaf.controllers;

import org.dragon.yunpeng.thymeleaf.datasource1.repositories.UserRepository;
import org.dragon.yunpeng.thymeleaf.datasource2.repositories.EssayRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	Logger logger = LoggerFactory.getLogger(HomeController.class);

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private EssayRepository essayRepository;

	@GetMapping("/")
	public String showUserList(Model model) {
		model.addAttribute("users", userRepository.findAll());
		model.addAttribute("essays", essayRepository.findAll());
		
		return "index";
	}

}
