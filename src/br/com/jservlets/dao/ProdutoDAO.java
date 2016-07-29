package br.com.jservlets.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import br.com.jservlets.model.Produto;

public class ProdutoDAO extends GenericDAO<Integer, Produto>{

	public ProdutoDAO() {
		super(Produto.class);
	}

	public List<Produto> lista() {
		String sql = "select p from Produto p";
		Query query = super.getEntityManager().createQuery(sql);
		
		@SuppressWarnings("unchecked")
		List<Produto> retorno = query.getResultList();
		return retorno;
	}
	
	public List<Produto> findByProduto(String produto){
		Query query = super.getEntityManager().
				createNamedQuery("Produto.findByProduto");
		query.setParameter("produto", "%" + produto + "%");
		try{
			@SuppressWarnings("unchecked")
			List<Produto> retorno = query.getResultList();
			return retorno;
		}catch(NoResultException nr){
			return null;
		}
	}
	
}
