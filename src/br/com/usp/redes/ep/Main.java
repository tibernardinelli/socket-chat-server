package br.com.usp.redes.ep;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {

	private static ServerSocket welcomeSocket;

	public static void main(String[] args) throws IOException {
		welcomeSocket = new ServerSocket(2020);

		while (true) {
			Socket connectionSocket = welcomeSocket.accept();
			ThreadChat t = new ThreadChat(connectionSocket);
			t.start();
		}
	}
}
