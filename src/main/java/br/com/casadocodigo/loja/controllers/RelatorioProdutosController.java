package br.com.casadocodigo.loja.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import br.com.casadocodigo.loja.dao.ProdutoDAO;
import br.com.casadocodigo.loja.models.Produto;
import br.com.casadocodigo.loja.models.RelatorioProdutos;


@Controller
public class RelatorioProdutosController {
	
	@Autowired
	private ProdutoDAO dao;
	
	RelatorioProdutos relatorioProdutos = new RelatorioProdutos();

	@DateTimeFormat
	@RequestMapping("/relatorio-produtos")
	@ResponseBody
	public RelatorioProdutos detalheJsoon(@RequestParam(value="data", required=false) String data) throws ParseException{

		GregorianCalendar calendar = new GregorianCalendar();
		SimpleDateFormat  formatter= new SimpleDateFormat("yyyy-MM-dd");
		
		Date date =  formatter.parse(data);
		calendar.setTime(date);
		
	    List<Produto> produto = dao.findData(calendar);
		
	    relatorioProdutos.setQuantidade(produto.size());
	    relatorioProdutos.setProdutos(produto);
	    relatorioProdutos.setData(calendar);
	    
	    return relatorioProdutos;
	}
}
