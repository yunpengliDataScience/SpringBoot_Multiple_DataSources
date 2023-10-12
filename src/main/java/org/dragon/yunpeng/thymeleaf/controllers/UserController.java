package org.dragon.yunpeng.thymeleaf.controllers;

import javax.validation.Valid;

import org.dragon.yunpeng.thymeleaf.datasource1.entities.User;
import org.dragon.yunpeng.thymeleaf.datasource1.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping("/user/signup")
	public String showSignUpForm(User user) {

		return "addUser";
	}

	@PostMapping("/user/adduser")
	public String addUser(@Valid User user, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "addUser";
		}

		userRepository.save(user);

		return "redirect:/";
	}

	@GetMapping("/user/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		model.addAttribute("user", user);

		return "updateUser";
	}

	@PostMapping("/user/update/{id}")
	public String updateUser(@PathVariable("id") long id, @Valid User user, BindingResult result, Model model) {
		if (result.hasErrors()) {
			user.setId(id);
			return "update-user";
		}

		userRepository.save(user);

		return "redirect:/";
	}

	@GetMapping("/user/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {

		User user = userRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
		userRepository.delete(user);

		return "redirect:/";
	}

}
