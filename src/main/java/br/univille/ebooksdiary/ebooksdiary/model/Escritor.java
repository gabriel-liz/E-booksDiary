package br.univille.ebooksdiary.ebooksdiary.model;

import java.util.ArrayList;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
public class Escritor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotNull()
	@NotEmpty(message = "O campo nome deve ser informado")
	private String nome;
	@NotNull()
	@NotEmpty(message = "O campo cpf deve ser informado")
	private String cpf;
	private String endereco;

	
	@ManyToMany(cascade=CascadeType.ALL)
	private List<Livros> livros = new ArrayList<Livros>();

	public long getId() {
		return id;
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public List<Livros> getLivros() {
		return livros;
	}

	public void setLivros(List<Livros> livros) {
		this.livros = livros;
	}
	
	
}
