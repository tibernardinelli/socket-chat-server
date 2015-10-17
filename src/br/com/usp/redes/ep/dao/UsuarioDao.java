package br.com.usp.redes.ep.dao;

import javax.persistence.TypedQuery;

import br.com.usp.redes.ep.entity.Usuario;

public class UsuarioDao extends GenericDao<Usuario> {

	public Usuario ObterUsuarioPorNome(String nome) {
		TypedQuery<Usuario> usuario = EntityManagerHolder.getEntityManager().createQuery("select A from Usuario A where A.nome = ?", Usuario.class);
		usuario.setParameter(1, nome);
		return usuario.getSingleResult();
	}

		
}
