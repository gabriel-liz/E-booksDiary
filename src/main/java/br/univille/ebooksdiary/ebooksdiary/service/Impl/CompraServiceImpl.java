package br.univille.ebooksdiary.ebooksdiary.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.Compra;
import br.univille.ebooksdiary.ebooksdiary.repository.CompraRepository;
import br.univille.ebooksdiary.ebooksdiary.service.CompraService;

@Service
public class CompraServiceImpl implements CompraService {
	
	@Autowired
	private CompraRepository repository;
	
	@Override
	public List<Compra> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Compra compra) {
		repository.save(compra);		
	}	
	
	@Override
	public void delete(Compra compra) {
		repository.delete(compra);
	}

}
