package br.univille.ebooksdiary.ebooksdiary.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Livros {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull()
	@NotEmpty(message = "O campo nome não pode ser branco")
	private String nome;
	private String preco;
	private String editora;
	private int ano;
	private String genero;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private Escritor escritor = new Escritor();
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private Status status = new Status();

	public long getId() {
		return id;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}

	public Escritor getEscritor() {
		return escritor;
	}

	public void setEscritor(Escritor escritor) {
		this.escritor = escritor;
	} 
	
	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	
}