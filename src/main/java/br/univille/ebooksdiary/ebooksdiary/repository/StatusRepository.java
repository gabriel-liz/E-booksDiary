package br.univille.ebooksdiary.ebooksdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.ebooksdiary.ebooksdiary.model.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long>  {
	public Status findByDescricao(String descricao);

}
