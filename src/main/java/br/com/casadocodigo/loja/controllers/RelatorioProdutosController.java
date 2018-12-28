package br.com.casadocodigo.loja.controllers;

import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;


@Controller
public class RelatorioProdutosController {
	
	@Autowired
	private ProdutoDAO dao;
	
	
	@RequestMapping("/relatorio-produtos")
	@ResponseBody
	public List<Produto> detalheJsoon(){
		GregorianCalendar data = new GregorianCalendar(2017, 11, 21);
	    List<Produto> produto = dao.findData(data);
	    return produto;
	}
}
