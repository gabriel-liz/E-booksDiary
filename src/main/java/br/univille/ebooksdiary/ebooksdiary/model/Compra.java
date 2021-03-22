package br.univille.ebooksdiary.ebooksdiary.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Compra {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String data;
	
	@ManyToOne(cascade= {CascadeType.MERGE,CascadeType.REFRESH})
	private Cliente cliente = new Cliente();
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Itens> listalivros = new ArrayList<Itens>();	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public List<Itens> getListalivros() {
		return listalivros;
	}
	public void setListalivros(List<Itens> listalivros) {
		this.listalivros = listalivros;
	}
	

}
