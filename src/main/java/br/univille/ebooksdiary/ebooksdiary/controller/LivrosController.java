package br.univille.ebooksdiary.ebooksdiary.controller;

import java.util.HashMap;
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
import br.univille.ebooksdiary.ebooksdiary.model.Livros;
import br.univille.ebooksdiary.ebooksdiary.model.RealizarRevisao;

import br.univille.ebooksdiary.ebooksdiary.model.Status;
import br.univille.ebooksdiary.ebooksdiary.repository.EscritorRepository;
import br.univille.ebooksdiary.ebooksdiary.repository.StatusRepository;
import br.univille.ebooksdiary.ebooksdiary.service.LivrosService;
import br.univille.ebooksdiary.ebooksdiary.service.RealizarRevisaoService;

@Controller
@RequestMapping("/livros")

public class LivrosController {

	@Autowired
	private RealizarRevisaoService realizarRevisaoService;
	
	@Autowired
	private LivrosService livrosService;
	
	@Autowired
    private EscritorRepository escritorRepository;
	
	@Autowired
    private StatusRepository statusRepository;
	
	@GetMapping()
	public ModelAndView index() {
		List<Livros> lista = livrosService.getAll();
		return new ModelAndView("livros/index", "livros", lista);
	}	
	
	@GetMapping("/novo")
    public ModelAndView createForm(@ModelAttribute Livros livros) {
        List<Escritor> listaEscritores = escritorRepository.findAll();
        List<Status> listaStatus = statusRepository.findAll();
        
        Status pend = statusRepository.findByDescricao("Pendente");
        if(pend != null) {
        	livros.setStatus(pend);
        }
        
    	HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("Livros", livros);		
		dados.put("listaescritores", listaEscritores);
		dados.put("listastatus", listaStatus);    			
        return new ModelAndView("livros/form",dados);
    }	
	
	@PostMapping(params="form")
	public ModelAndView save(@Valid Livros livros, BindingResult result)
	{
		if(result.hasErrors()) {
			return new ModelAndView("livros/form");
		}
		RealizarRevisao r = new RealizarRevisao();
		r.setLivros(livros);
		livrosService.save(livros);
		realizarRevisaoService.save(r);		
		return new ModelAndView("redirect:/livros");
	}
	
	@GetMapping(value="/alterar/{id}")
    public ModelAndView alterarForm(@PathVariable("id") Livros livros) {
        List<Escritor> listaEscritores = escritorRepository.findAll();
        List<Status> listaStatus = statusRepository.findAll();
        HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("livros", livros);		
		dados.put("listaescritor", listaEscritores);
		dados.put("listaStatus", listaStatus);         
        return new ModelAndView("livros/form",dados);
    }
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Livros livros) {
		livrosService.delete(livros);
		return new ModelAndView("redirect:/livros");
	}	
}
