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


import br.univille.ebooksdiary.ebooksdiary.model.Escritor;

import br.univille.ebooksdiary.ebooksdiary.service.EscritorService;

@Controller
@RequestMapping("/escritor")
public class EscritorController {
	@Autowired
	private EscritorService escritorService;
	
	
	@GetMapping()
	public ModelAndView index() {
		List<Escritor> lista = escritorService.getAll();
		return new ModelAndView("escritor/index", "escritor", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Escritor escritor) {
		return new ModelAndView("escritor/form");
	}	
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Escritor escritor, BindingResult result)
	{
		
		if(result.hasErrors()) {
			return new ModelAndView("escritor/form");
		}
		escritorService.save(escritor);
		return new ModelAndView("redirect:/escritor");
	}
	
	@GetMapping(value="/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Escritor escritor) {
		return new ModelAndView("escritor/form","escritor",escritor);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Escritor escritor) {
		escritorService.delete(escritor);
		return new ModelAndView("redirect:/escritor");
	}
}
