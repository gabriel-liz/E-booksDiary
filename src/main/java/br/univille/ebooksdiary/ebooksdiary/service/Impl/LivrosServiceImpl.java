package br.univille.ebooksdiary.ebooksdiary.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.Livros;
import br.univille.ebooksdiary.ebooksdiary.repository.LivrosRepository;
import br.univille.ebooksdiary.ebooksdiary.service.LivrosService;

@Service
public class LivrosServiceImpl implements LivrosService  {
	
	
	
	@Autowired
	private LivrosRepository repository;
	
	@Override
	public List<Livros> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Livros livros) {
		repository.save(livros);
		
	}	
	
	@Override
	public void delete(Livros livros) {
		repository.delete(livros);
	}
	
	

}
