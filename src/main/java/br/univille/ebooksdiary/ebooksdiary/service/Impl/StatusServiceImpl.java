package br.univille.ebooksdiary.ebooksdiary.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.Status;
import br.univille.ebooksdiary.ebooksdiary.repository.StatusRepository;
import br.univille.ebooksdiary.ebooksdiary.service.StatusService;

@Service
public class StatusServiceImpl implements StatusService{

	@Autowired
	private StatusRepository repository;
	
	@Override
	public List<Status> getAll() {
		return repository.findAll();
	}

	@Override
	public void save(Status status) {
		repository.save(status);		
	}	
	
	@Override
	public void delete(Status status) {
		repository.delete(status);
	}
}
