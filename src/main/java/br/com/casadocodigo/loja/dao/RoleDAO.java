package br.com.casadocodigo.loja.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.casadocodigo.loja.models.Role;
import br.com.casadocodigo.loja.models.Usuario;

@Repository
@Transactional
public class RoleDAO {

	@PersistenceContext
	private EntityManager manager;

	public void gravar(Role role) {
		manager.persist(role);
	}
	public List<Role> listar() {
        return manager.createQuery("select r from Role r",
        		Role.class)
        		.getResultList();
	}
	public Role listarRole(String nome) {
        return manager.createQuery("select r from Role r where nome = :nome",Role.class)
        		.setParameter("nome", nome)
        		.getSingleResult();
	}
	public void gravarList(Usuario usuario, String[] roles) { 
		manager.persist(roles);
	}
}

