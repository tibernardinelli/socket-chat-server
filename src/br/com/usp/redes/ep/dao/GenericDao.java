package br.com.usp.redes.ep.dao;

import javax.persistence.EntityManager;

public class GenericDao<T> {
	
	public void persist(T t) {
		EntityManager em = EntityManagerHolder.getEntityManager();
		em.getTransaction().begin();
		em.persist(t);
		em.getTransaction().commit();
	}

	public void merge(T t) {
		EntityManager em = EntityManagerHolder.getEntityManager();
		em.getTransaction().begin();
		em.merge(t);
		em.getTransaction().commit();

	}
}
