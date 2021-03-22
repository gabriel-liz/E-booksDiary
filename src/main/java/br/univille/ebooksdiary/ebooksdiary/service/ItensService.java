
package br.univille.ebooksdiary.ebooksdiary.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.univille.ebooksdiary.ebooksdiary.model.Itens;

@Service
public interface ItensService {
	List<Itens> getAll();
	void save(Itens itens);
	void delete(Itens itens);

}

