package br.com.usp.redes.ep;
import java.io.*;
import java.net.*;
import java.util.*;

import br.com.usp.redes.ep.dao.UsuarioDao;
import br.com.usp.redes.ep.entity.Usuario;

class ThreadChat extends Thread {

	Socket connectionSocket;
	private int id;

	private UsuarioDao usuarioDao = new UsuarioDao();

	public ThreadChat(Socket s) {
		connectionSocket = s;
	}

	public void run() {

		try {
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());
			
			String nome = inFromClient.readLine();
			
			Usuario u = null;
			
			if ((u = usuarioDao.ObterUsuarioPorNome(nome)) == null){
				u = new Usuario();
				u.setNome(nome);
				usuarioDao.persist(u);
				id = u.getId();
			}
			
			
			
			retornaListaUsuarios(outToClient, u);
			
		} catch (IOException e) {
			System.err.println("Caught IOException: " + e.getMessage());
		}

	}

	private void retornaListaUsuarios(DataOutputStream outToClient, Usuario u) throws IOException {
		outToClient.writeBytes("Lista de contato: \n");
		for (Usuario s: u.getContatos()){
			outToClient.writeBytes(s.getNome() + "\n");
		}
		outToClient.writeBytes("$$D\n");
	}

}
