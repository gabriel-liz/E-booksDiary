package br.univille.ebooksdiary.ebooksdiary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.Escritor;

@Service
public interface EscritorService {
	List<Escritor> getAll();
	void save(Escritor escritor);
	void delete(Escritor escritor);
}
