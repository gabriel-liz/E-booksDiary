
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
import br.univille.ebooksdiary.ebooksdiary.model.Itens;
import br.univille.ebooksdiary.ebooksdiary.model.Livros;
import br.univille.ebooksdiary.ebooksdiary.repository.LivrosRepository;
import br.univille.ebooksdiary.ebooksdiary.service.ItensService;


@Controller
@RequestMapping("/itens")

public class ItensController {
	
	@Autowired
	private ItensService itensService;
	
	@Autowired
    private LivrosRepository livrosRepository;
	
	@GetMapping()
	public ModelAndView index() {
		List<Itens> lista = itensService.getAll();
		return new ModelAndView("itens/index", "itens", lista);
	}
	
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Itens itens) {
		List<Livros> listaLivros = livrosRepository.findAll();
		return new ModelAndView("itens/form", "listalivros",listaLivros);
	}
	
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Itens itens)
	{
		itensService.save(itens);
		return new ModelAndView("redirect:/itens");
	}
	
	@GetMapping(value="/alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Itens itens) {
        List<Livros> listaLivros = livrosRepository.findAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("itens",itens);
        dados.put("listalivros",listaLivros);
        
        return new ModelAndView("itens/form",dados);
    }
		
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Itens itens) {
		itensService.delete(itens);
		return new ModelAndView("redirect:/itens");
	}	

}

