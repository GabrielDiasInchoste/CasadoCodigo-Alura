package br.com.casadocodigo.loja.models;

import java.util.Calendar;
import java.util.List;

public class Order {
	
	private int id;
	
	private String titulo;
	private String valor;
	private Calendar data;
	
	
	private List<OrderProduto> produtos;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public Calendar getData() {
		return data;
	}
	public void setData(Calendar data) {
		this.data = data;
	}
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
		public List<OrderProduto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<OrderProduto> produto) {
		this.produtos = produto;
	}
}
