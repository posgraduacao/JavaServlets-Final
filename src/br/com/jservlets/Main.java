package br.com.jservlets;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.jservlets.model.Produto;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory factory = null;
		EntityManager em = null;
		
		try {
			factory = Persistence.createEntityManagerFactory("jservlets");
			em = factory.createEntityManager();
			
			Produto p = new Produto();
//			p.setNome("Celular");
//			p.setDescricao("Aparelho Móvel");
//			p.setPreco(200.50);
//			p.setEstoque(10);
			
			em.getTransaction().begin();
//			em.persist(p);
			p = em.find(Produto.class, 2);
			p.setNome("Headset");
//			em.remove(p);
			em.getTransaction().commit();
			
			System.out.println(p.getNome());
		} catch (Exception e) {
			if (em!=null && em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		} finally {
			if (em!=null) {
				em.close();
			}
			if (factory!=null) {
				factory.close();
			}
		}
		
		

	}

}
