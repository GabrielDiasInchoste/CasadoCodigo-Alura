package br.com.casadocodigo.loja.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.casadocodigo.loja.dao.UsuarioDAO;
import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.RolesList;
import br.com.casadocodigo.loja.models.Usuario;
import br.com.casadocodigo.loja.validation.UsuarioValidation;


@Controller
@RequestMapping(value="/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioDAO usuarioDao;
		
	@InitBinder("usuario")
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new UsuarioValidation());
	}
	
	@RequestMapping("/form")
	public ModelAndView form(Usuario usuarios) {
		ModelAndView modelAndView = new ModelAndView("form");
		modelAndView.addObject("usuario", usuarios);
		return modelAndView;
	}
	
	@RequestMapping(value="/form",method=RequestMethod.POST)
	public ModelAndView gravar(@Valid Usuario usuario, BindingResult result){
		
		if(result.hasErrors()) {
			return form(usuario);
		}
		System.out.println(usuario.getSenha()+ "AIUJHIUHSAIUHSADIUH");
		String senhaCriptografada = new BCryptPasswordEncoder().encode(usuario.getSenha());
		usuario.setSenha(senhaCriptografada);
		System.out.println(usuario.getSenha() + " adsaiudihusaiud");
		usuarioDao.gravar(usuario);		
		return new ModelAndView("redirect:/usuario");
	}
	
	@RequestMapping( method=RequestMethod.GET)
	public ModelAndView listar() {
		List<Usuario> usuario = usuarioDao.listar();
		ModelAndView modelAndView = new ModelAndView("usuario");
		modelAndView.addObject("usuario", usuario);
		return modelAndView;
	}
	
	
	@RequestMapping("/alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Integer id ) {
		Usuario usuario = usuarioDao.listarUsuario(id);
		ModelAndView modelAndView = new ModelAndView("alterar");
		modelAndView.addObject("usuario", usuario);
		modelAndView.addObject("rolesList", new RolesList());
		return modelAndView;
	}
	
	
	@RequestMapping(value="/alterar/{id}",method=RequestMethod.POST)
	public ModelAndView gravarRole(@PathVariable("id")Integer id, @ModelAttribute("rolesList") RolesList roleslist){
		Usuario usuario = usuarioDao.listarUsuario(id);
		List<Role> roles = new ArrayList<>();
		
		for (String iteration : roleslist.getRolesList()) {
			Role role = new Role();
			role.setNome(iteration);
			roles.add(role);
			usuario.setRoles(roles);
			usuarioDao.gravarRole(usuario);
		}
		return new ModelAndView("redirect:/usuario");
	}
}