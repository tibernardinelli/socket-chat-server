package br.com.usp.redes.ep.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Usuario {

	@Id
	@GeneratedValue
	private int id;
	
	private String nome;
	
	private Boolean connected;
	
	private String addres;
	
	private String portAvailable;

	@ManyToMany
	@JoinTable(name="UsuarioXUsuario", joinColumns={
			@JoinColumn(name="id")
	}, inverseJoinColumns={
			@JoinColumn(name="Contato")
	})
	private List<Usuario> contatos;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Usuario> getContatos() {
		return contatos;
	}

	public void setContatos(List<Usuario> contatos) {
		this.contatos = contatos;
	}
	public Boolean getConnected() {
		return connected;
	}

	public void setConnected(Boolean connected) {
		this.connected = connected;
	}

	public String getAddres() {
		return addres;
	}

	public void setAddres(String addres) {
		this.addres = addres;
	}

	public String getPortAvailable() {
		return portAvailable;
	}

	public void setPortAvailable(String portAvailable) {
		this.portAvailable = portAvailable;
	}
	
	@Override
	public String toString() {
		return String.format("id: %d; nome: %s; contatos {%s}", getId(), getNome(), getContatosNome());
	}

	private String getContatosNome() {
		String retorno = "";
		for(Usuario u: getContatos()){
			retorno += u.getNome() + "; ";
		}
		return retorno;
	}
}
