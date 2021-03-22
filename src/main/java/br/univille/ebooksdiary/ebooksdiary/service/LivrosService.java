package br.univille.ebooksdiary.ebooksdiary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.Livros;

@Service
public interface LivrosService {
	
	List<Livros> getAll();
	void save(Livros livros);
	void delete(Livros livros);
	
}
