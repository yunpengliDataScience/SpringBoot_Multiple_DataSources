package org.dragon.yunpeng.thymeleaf.controllers;

import java.util.Optional;

import org.dragon.yunpeng.thymeleaf.datasource2.entities.Essay;
import org.dragon.yunpeng.thymeleaf.datasource2.repositories.EssayRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EssayController {

	@Autowired
	private EssayRepository essayRepository;

	public EssayController() {
	}

	@GetMapping("/essay/create")
	public String showEssayForm(Essay essay) {
		return "addEssay";
	}

	@PostMapping("/essay/saveNewEssay")
	public String saveNewEssay(Essay essay, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "addEssay";
		}

		essayRepository.save(essay);

		return "redirect:/";
	}

	@GetMapping("/essay/edit/{id}")
	public String showUpdateForm(@PathVariable("id") long id, Model model) {
		Essay essay = essayRepository.findById(id).get();

		model.addAttribute("essay", essay);

		return "updateEssay";
	}

	@PostMapping("/essay/update/{id}")
	public String updateEssay(@PathVariable("id") long id, Essay essay, BindingResult result, Model model) {
		if (result.hasErrors()) {
			essay.setId(id);
			return "updateEssay";
		}

		essayRepository.save(essay);

		return "redirect:/";
	}

	@GetMapping("/essay/delete/{id}")
	public String deleteEssay(@PathVariable("id") long id, Model model) {
		Essay essay =essayRepository.findById(id).get();

		essayRepository.delete(essay);

		return "redirect:/";
	}
}
