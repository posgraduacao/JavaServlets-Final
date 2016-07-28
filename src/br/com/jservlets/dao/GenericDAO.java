package br.com.jservlets.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Persistence;

public abstract class GenericDAO<ID,U> {
	private static final EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("jservlets");
	private EntityManager em;
	private Class<U> entityClass;
	
	public GenericDAO(Class<U> entityClass) {
		this.entityClass = entityClass;
	}
	
	public EntityManager getEntityManager(){
		return em;
	}
	
	public void beginTransaction() {
		em = emf.createEntityManager();
		em.getTransaction().begin();
	}
	public void commit() {
		em.getTransaction().commit();
	}
	public void rollback() {
		em.getTransaction().rollback();
	}
	public void rollbackAndCloseTransaction() {
		try{
			this.em.getTransaction().rollback();
		}finally{
			this.closeTransaction();
		}
	}
	private void closeTransaction() {
		this.em.close();
	}	 
	public void commitAndCloseTransaction() {
		try{
			this.commit();
		}finally{
			this.closeTransaction();
		}
	}
	public void flush() {
		em.flush();
	}
	
	public void save(U entity) {
		em.persist(entity);
	}
	public void delete(U entity) {
		em.refresh(entity);
		em.remove(entity);
	}
	public U update(U entity) {
		return em.merge(entity);
	}
	public U find(ID entityID) {
		return em.find(entityClass, entityID);
	}
	public U findReferenceOnly(ID entityID) {
		try{
			return em.getReference(entityClass, entityID);
		}catch(EntityNotFoundException e){
			return null;
		}
	}
	
	public static void fecharEntityManagerFactory(){
		emf.close();
	}
}
