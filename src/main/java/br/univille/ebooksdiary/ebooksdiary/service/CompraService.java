package br.univille.ebooksdiary.ebooksdiary.service;

import java.util.List;

import org.springframework.stereotype.Service;
import br.univille.ebooksdiary.ebooksdiary.model.Compra;

@Service
public interface CompraService {
	
	List<Compra> getAll();
	void save(Compra compra);
	void delete(Compra compra);

}
