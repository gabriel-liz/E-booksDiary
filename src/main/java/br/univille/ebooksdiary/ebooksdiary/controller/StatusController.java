package br.univille.ebooksdiary.ebooksdiary.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.ebooksdiary.ebooksdiary.model.Status;
import br.univille.ebooksdiary.ebooksdiary.service.StatusService;



@Controller
@RequestMapping("/status")
public class StatusController {

	@Autowired
	private StatusService statusService;
	
	@GetMapping()
	public ModelAndView index() {
		List<Status> lista = statusService.getAll();
		return new ModelAndView("status/index", "status", lista);
	}	
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Status status) {
		return new ModelAndView("status/form");
	}	
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Status status, BindingResult result)
	{
		
		if(result.hasErrors()) {
			return new ModelAndView("status/form");
		}
		statusService.save(status);
		return new ModelAndView("redirect:/status");
	}
	
	
	@GetMapping(value="/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Status status) {
		return new ModelAndView("status/form","status",status);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Status status) {
		statusService.delete(status);
		return new ModelAndView("redirect:/status");
	}
	
}
