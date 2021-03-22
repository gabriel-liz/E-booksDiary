package br.univille.ebooksdiary.ebooksdiary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.RealizarRevisao;

@Service
public interface RealizarRevisaoService {
	
	List<RealizarRevisao> getAll();
	void save(RealizarRevisao realizarRevisao);
	void delete(RealizarRevisao realizarRevisao);

}
