package br.com.jservlets.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.jservlets.model.Usuario;

public class UsuarioDAO extends GenericDAO<Integer, Usuario> {

	public UsuarioDAO() {
		super(Usuario.class);
	}

	public Usuario findByUsuario(String usuario){
		Query query = super.getEntityManager().
				createNamedQuery("Usuario.findByUsuario");
		query.setParameter("usuario", usuario);
		try{
			Usuario retorno = (Usuario)query.getSingleResult();
			return retorno;
		}catch(NoResultException nr){
			return null;
		}
	}
}
