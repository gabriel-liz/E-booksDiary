package br.univille.ebooksdiary.ebooksdiary.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.ebooksdiary.ebooksdiary.model.Livros;
import br.univille.ebooksdiary.ebooksdiary.model.Status;


@Repository

public interface LivrosRepository extends JpaRepository<Livros, Long> {
	public List<Livros> findAllByStatus(Status status);
}
