package br.univille.ebooksdiary.ebooksdiary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.Cliente;

@Service
public interface ClienteService {
	List<Cliente> getAll();
	void save(Cliente cliente);
	void delete(Cliente cliente);
}
