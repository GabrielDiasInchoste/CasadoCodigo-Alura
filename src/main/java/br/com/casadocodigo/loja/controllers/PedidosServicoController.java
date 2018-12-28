package br.com.casadocodigo.loja.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.casadocodigo.loja.models.Order;
import br.com.casadocodigo.loja.models.Usuario;


@Controller
public class PedidosServicoController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping(value="/pedidos")
	public ModelAndView pedidos(@AuthenticationPrincipal Usuario usuario, RedirectAttributes model){
		String uri = "https://book-payment.herokuapp.com/orders";
	try {
		
		ResponseEntity<Order[]> response = restTemplate.getForEntity(uri, Order[].class);
		ModelAndView modelAndView = new ModelAndView("pedidos");
		modelAndView.addObject("order", response.getBody());
		System.out.println(response);		
		return modelAndView;
		
	} catch (HttpClientErrorException e) {
		e.printStackTrace();
		return new ModelAndView("pedidos");
	}
	
	}
}
