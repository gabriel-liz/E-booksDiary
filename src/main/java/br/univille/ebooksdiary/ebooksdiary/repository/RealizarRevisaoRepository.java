package br.univille.ebooksdiary.ebooksdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.ebooksdiary.ebooksdiary.model.RealizarRevisao;

@Repository
public interface RealizarRevisaoRepository extends JpaRepository<RealizarRevisao, Long> {

	
}
