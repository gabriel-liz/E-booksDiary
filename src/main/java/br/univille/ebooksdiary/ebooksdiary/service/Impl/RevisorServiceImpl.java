package br.univille.ebooksdiary.ebooksdiary.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.Revisor;
import br.univille.ebooksdiary.ebooksdiary.repository.RevisorRepository;
import br.univille.ebooksdiary.ebooksdiary.service.RevisorService;

@Service
public class RevisorServiceImpl implements RevisorService {
	
	@Autowired
	private RevisorRepository repository;
	
	@Override
	public List<Revisor> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Revisor revisor) {
		repository.save(revisor);		
	}	
	
	@Override
	public void delete(Revisor revisor) {
		repository.delete(revisor);
	}

}
