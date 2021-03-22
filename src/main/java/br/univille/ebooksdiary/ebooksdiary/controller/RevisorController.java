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

import br.univille.ebooksdiary.ebooksdiary.model.Revisor;
import br.univille.ebooksdiary.ebooksdiary.service.RevisorService;

@Controller
@RequestMapping("/revisor")
public class RevisorController {
	@Autowired
	private RevisorService revisorService;
	
	@GetMapping()
	public ModelAndView index() {
		List<Revisor> lista = revisorService.getAll();
		return new ModelAndView("revisor/index", "revisor", lista);
	}
	
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Revisor revisor) {
		return new ModelAndView("revisor/form");
	}	
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Revisor revisor, BindingResult result)
	{
		if(result.hasErrors()) {
			return new ModelAndView("revisor/form");
		}
		
		revisorService.save(revisor);
		return new ModelAndView("redirect:/revisor");
	}
	
	
	@GetMapping(value="/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Revisor revisor) {
		return new ModelAndView("revisor/form","revisor",revisor);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Revisor revisor) {
		revisorService.delete(revisor);
		return new ModelAndView("redirect:/revisor");
	}
}