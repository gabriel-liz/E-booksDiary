
package br.univille.ebooksdiary.ebooksdiary.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.univille.ebooksdiary.ebooksdiary.model.Itens;

@Repository
public interface ItensRepository extends JpaRepository<Itens, Long> {

}
