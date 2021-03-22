package br.univille.ebooksdiary.ebooksdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.ebooksdiary.ebooksdiary.model.Escritor;

@Repository
public interface EscritorRepository  extends JpaRepository<Escritor, Long> {
	Escritor findByNome(String nome);
}
