package br.univille.ebooksdiary.ebooksdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.ebooksdiary.ebooksdiary.model.Revisor;

@Repository
public interface RevisorRepository extends JpaRepository<Revisor, Long> {
	Revisor findByNome(String nome);
}
