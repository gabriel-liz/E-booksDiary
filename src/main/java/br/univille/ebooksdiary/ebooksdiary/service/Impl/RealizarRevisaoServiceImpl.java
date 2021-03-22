package br.univille.ebooksdiary.ebooksdiary.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.RealizarRevisao;
import br.univille.ebooksdiary.ebooksdiary.repository.RealizarRevisaoRepository;
import br.univille.ebooksdiary.ebooksdiary.service.RealizarRevisaoService;

@Service

public class RealizarRevisaoServiceImpl implements RealizarRevisaoService {

	
	@Autowired
	private RealizarRevisaoRepository repository;
	
	@Override
	public List<RealizarRevisao> getAll() {
		
		return repository.findAll();
	}

	@Override
	public void save(RealizarRevisao realizarRevisao) {
		repository.save(realizarRevisao);
		
	}

	@Override
	public void delete(RealizarRevisao realizarRevisao) {
		repository.delete(realizarRevisao);
		
	}
	
	

}
