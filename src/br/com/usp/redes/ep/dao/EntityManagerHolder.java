package br.com.usp.redes.ep.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public abstract class EntityManagerHolder {

	public static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("server");;
	public static EntityManager em = null;
	
	public static EntityManager getEntityManager(){
		if (em == null || !em.isOpen()){
			em = emf.createEntityManager();
		}
		return em;
	}
}
