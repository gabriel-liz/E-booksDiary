package br.univille.ebooksdiary.ebooksdiary.controller;

import java.util.HashMap;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.univille.ebooksdiary.ebooksdiary.model.Livros;
import br.univille.ebooksdiary.ebooksdiary.model.RealizarRevisao;
import br.univille.ebooksdiary.ebooksdiary.model.Revisor;
import br.univille.ebooksdiary.ebooksdiary.repository.LivrosRepository;
import br.univille.ebooksdiary.ebooksdiary.repository.RevisorRepository;
import br.univille.ebooksdiary.ebooksdiary.service.RealizarRevisaoService;

@Controller
@RequestMapping("/realizarRevisao")
public class RealizarRevisaoController {
	
	@Autowired
	private RealizarRevisaoService realizarRevisaoService;
	
	@Autowired
    private RevisorRepository revisorRepository;
	
	@Autowired
    private LivrosRepository livrosRepository;
	
	
	@GetMapping()
	public ModelAndView index() {
		List<RealizarRevisao> lista = realizarRevisaoService.getAll();
		return new ModelAndView("realizarRevisao/index", "realizarRevisao", lista);
	}
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute RealizarRevisao realizarRevisao) {
		
		List<Revisor> listaRevisores = revisorRepository.findAll();
		List<Livros> listaLivros = livrosRepository.findAll();
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("realizarRevisao", realizarRevisao);
		dados.put("listaRevisores", listaRevisores);
		dados.put("listaLivros", listaLivros);
		return new ModelAndView("realizarRevisao/form", dados);
	}		

	
	@PostMapping(params="form")
	public ModelAndView save(@Valid RealizarRevisao realizarRevisao)
	{		
		realizarRevisaoService.save(realizarRevisao);
		return new ModelAndView("redirect:/realizarRevisao");
	}
	
	@GetMapping(value="/alterar/{id}")
	public ModelAndView alterarForm(@PathVariable("id") RealizarRevisao realizarRevisao) {
		List<Revisor> listaRevisores = revisorRepository.findAll();
		List<Livros> listaLivros = livrosRepository.findAll();		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("realizarRevisao", realizarRevisao);
		dados.put("listaRevisores", listaRevisores);
		dados.put("listaLivros", listaLivros);
		return new ModelAndView("realizarRevisao/form", dados);
	}	

	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") RealizarRevisao realizarRevisao) {
		realizarRevisaoService.delete(realizarRevisao);
		return new ModelAndView("redirect:/realizarRevisao");
	}
}

