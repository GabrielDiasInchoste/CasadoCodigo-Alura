package br.com.casadocodigo.loja.models;

import java.util.Calendar;
import java.util.List;

public class RelatorioProdutos {

		private Integer quantidade;
		private Calendar data;
		private List<Produto> produtos;
		
		public Integer getQuantidade() {
			return quantidade;
		}
		public void setQuantidade(Integer quantidade) {
			this.quantidade = quantidade;
		}
		public Calendar getData() {
			return data;
		}
		public void setData(Calendar data) {
			this.data = data;
		}
		public List<Produto> getProdutos() {
			return produtos;
		}
		public void setProdutos(List<Produto> produtos) {
			this.produtos = produtos;
		}	
}
