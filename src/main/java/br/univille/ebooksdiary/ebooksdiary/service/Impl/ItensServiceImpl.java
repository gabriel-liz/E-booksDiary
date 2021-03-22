
package br.univille.ebooksdiary.ebooksdiary.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.Itens;
import br.univille.ebooksdiary.ebooksdiary.repository.ItensRepository;
import br.univille.ebooksdiary.ebooksdiary.service.ItensService;


@Service
public class ItensServiceImpl implements ItensService {
	
	@Autowired
	private ItensRepository repository;
	
	@Override
	public List<Itens> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Itens itens) {
		repository.save(itens);
		
	}	
	
	@Override
	public void delete(Itens itens) {
		repository.delete(itens);
	}
	

}

