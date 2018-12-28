package br.com.casadocodigo.loja.models;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.ElementCollection;

import org.springframework.format.annotation.DateTimeFormat;

public class OrderProduto {
private int id;
	
	private String titulo;
	private String descricao;
	private int paginas;
	
	@ElementCollection
	private List<Preco> precos = new ArrayList<>();
	
	@DateTimeFormat
	private Calendar dataLancamento;

	
	public int getId() {
		return id;
	}
	public String getTitulo() {
		return titulo;
	}
	public String getDescricao() {
		return descricao;
	}
	public int getPaginas() {
		return paginas;
	}
	public List<Preco> getPrecos() {
		return precos;
	}
	public Calendar getDataLancamento() {
		return dataLancamento;
	}
}