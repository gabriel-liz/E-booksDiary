
package br.univille.ebooksdiary.ebooksdiary.model;


import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Itens {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long valor;	
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private Livros livros = new Livros();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Livros getLivros() {
		return livros;
	}

	public void setLivros(Livros livros) {
		this.livros = livros;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}	

}
