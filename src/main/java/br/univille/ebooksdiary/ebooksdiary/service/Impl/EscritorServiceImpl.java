package br.univille.ebooksdiary.ebooksdiary.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.Escritor;
import br.univille.ebooksdiary.ebooksdiary.repository.EscritorRepository;
import br.univille.ebooksdiary.ebooksdiary.service.EscritorService;


@Service
public class EscritorServiceImpl implements EscritorService{

	@Autowired
	private EscritorRepository repository;
	
	@Override
	public List<Escritor> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Escritor escritor) {
		repository.save(escritor);		
	}	
	
	@Override
	public void delete(Escritor escritor) {
		repository.delete(escritor);
	}
}
