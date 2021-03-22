package br.univille.ebooksdiary.ebooksdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.ebooksdiary.ebooksdiary.model.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {	
	Cliente findByNome(String nome);
}
