package br.univille.ebooksdiary.ebooksdiary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.Revisor;

@Service
public interface RevisorService {
	List<Revisor> getAll();
	void save(Revisor revisor);
	void delete(Revisor revisor);
}
