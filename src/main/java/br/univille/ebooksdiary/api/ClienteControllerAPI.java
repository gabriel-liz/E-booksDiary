package br.univille.ebooksdiary.api;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.univille.ebooksdiary.ebooksdiary.model.Cliente;
import br.univille.ebooksdiary.ebooksdiary.service.ClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteControllerAPI {

	@Autowired
	private ClienteService clienteService;
	
	@GetMapping()
	public ResponseEntity<List<Cliente>> getAll(){
		return new ResponseEntity(clienteService.getAll(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> save(@RequestBody @Valid Cliente cliente){
		clienteService.save(cliente);
		return ResponseEntity.ok().build();
	}
}
