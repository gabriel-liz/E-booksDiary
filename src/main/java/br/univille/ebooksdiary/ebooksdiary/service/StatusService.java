package br.univille.ebooksdiary.ebooksdiary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.Status;

@Service
public interface StatusService {	
	List<Status> getAll();
	void save(Status status);
	void delete(Status status);	
}
