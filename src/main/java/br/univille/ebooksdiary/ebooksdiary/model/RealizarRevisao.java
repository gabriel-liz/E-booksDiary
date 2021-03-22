package br.univille.ebooksdiary.ebooksdiary.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RealizarRevisao {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String comentarios;	
	
	private String data;	
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH}, optional = true)
	private Revisor revisor;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH}, optional = true)
	private Livros livros = new Livros();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getComentarios() {
		return comentarios;
	}

	public void setComentarios(String comentarios) {
		this.comentarios = comentarios;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public Revisor getRevisor() {
		return revisor;
	}

	public void setRevisor(Revisor revisor) {
		this.revisor = revisor;
	}

	public Livros getLivros() {
		return livros;
	}

	public void setLivros(Livros livros) {
		this.livros = livros;
	}		

}
