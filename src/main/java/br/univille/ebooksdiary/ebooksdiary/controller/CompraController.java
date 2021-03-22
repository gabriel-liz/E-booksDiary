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

import br.univille.ebooksdiary.ebooksdiary.model.Cliente;
import br.univille.ebooksdiary.ebooksdiary.model.Compra;
import br.univille.ebooksdiary.ebooksdiary.model.Itens;
import br.univille.ebooksdiary.ebooksdiary.model.Livros;
import br.univille.ebooksdiary.ebooksdiary.model.Status;
import br.univille.ebooksdiary.ebooksdiary.repository.ClienteRepository;
import br.univille.ebooksdiary.ebooksdiary.repository.CompraRepository;
import br.univille.ebooksdiary.ebooksdiary.repository.LivrosRepository;
import br.univille.ebooksdiary.ebooksdiary.repository.StatusRepository;
import br.univille.ebooksdiary.ebooksdiary.service.CompraService;

@Controller
@RequestMapping("/compra")
public class CompraController {
	
	@Autowired
	private CompraService compraService;
	
	@Autowired
	private CompraRepository compraRepository;
	
	@Autowired
	private LivrosRepository livrosRepository;
	
	@Autowired
    private ClienteRepository clienteRepository;
	
	@Autowired 
	private StatusRepository statusRepository;
	
	@GetMapping()
	public ModelAndView index() {
		//List<Compra> lista = compraService.getAll();
		List<Compra> listaCompra = this.compraRepository.findAll();
		return new ModelAndView("compra/index","listaCompra", listaCompra);
		//return new ModelAndView("compra/index", "compra", lista);		
	}	
	
	@GetMapping("/novo")
	public ModelAndView createForm(@ModelAttribute Compra compra) {
		List<Cliente> listaCliente = clienteRepository.findAll();
		List<Livros> listalivros = livrosRepository.findAll();
		Status aprov = statusRepository.findByDescricao("Aprovado");
		if(aprov != null) {
			listalivros = livrosRepository.findAllByStatus(aprov);
		}
		
		
		HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("listaCliente", listaCliente);
		dados.put("listalivros", listalivros);
		dados.put("novoitem", new Itens());
		
		
		return new ModelAndView("compra/form", dados);		
	}	
	
	@PostMapping(params= {"save"})
	public ModelAndView save(@Valid Compra compra, BindingResult result)
	{
		/*
		if(result.hasErrors()) {
			return new ModelAndView("compra/form");
		}
		*/
		compraService.save(compra);
		return new ModelAndView("redirect:/compra");
	}
	
	@PostMapping(params= {"insertiten"})
    public ModelAndView insertiten(Compra compra, Itens novoitem) {


		List<Cliente> listaCliente = clienteRepository.findAll();
		List<Livros> listalivros = livrosRepository.findAll();		
       
        compra.getListalivros().add(novoitem);
   
        HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("listaCliente", listaCliente);
		dados.put("listalivros", listalivros);
		dados.put("novoitem", new Itens());		
		
		return new ModelAndView("compra/form", dados);
    }
	/*
    @PostMapping(params= {"removeiten"})
    public ModelAndView removeiten(@RequestParam(name = "removeiten") int index, Compra compra, Compra novoitem, BindingResult result, RedirectAttributes redirect) {
    	List<Cliente> listaCliente = clienteRepository.findAll();
		List<Livros> listaLivros = livrosRepository.findAll();		
       
        compra.getListalivros().remove(index);
   
        HashMap<String, Object> dados = new HashMap<String, Object>();
		dados.put("listaCliente", listaCliente);
		dados.put("listalivros", listaLivros);
		dados.put("novoitem", new Itens());		
		
		return new ModelAndView("compra/form", dados);
    }
	*/
	
	@GetMapping(value="/alterar/{id}")
	public ModelAndView edit(@PathVariable("id") Compra compra) {
		List<Cliente> listaCliente = clienteRepository.findAll();
		HashMap<String, Object> dados = new HashMap<String, Object>();
        dados.put("compra",compra);
        dados.put("listacliente",listaCliente);
		return new ModelAndView("compra/form","compra",compra);
	}
	
	@GetMapping(value="/delete/{id}")
	public ModelAndView delete(@PathVariable("id") Compra compra) {
		compraService.delete(compra);
		return new ModelAndView("redirect:/compra");
	}
}
