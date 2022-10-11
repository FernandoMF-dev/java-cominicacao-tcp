package servidortcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

	private static final int PORTA_SERVICO = 2000;

	public static ServerSocket iniciarServerSocket() {
		ServerSocket serverSocket = null;
		try {
			serverSocket = new ServerSocket(PORTA_SERVICO);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(0);
		}
		return serverSocket;
	}

	public static void main(String[] args) {

		ServerSocket serverSocket = null;
		Socket socket = null;

		serverSocket = iniciarServerSocket();

		while (true) {
			try {
				socket = serverSocket.accept();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
				System.exit(0);
			}

			Thread threadServidorTCP = new ThreadServidorTCP(socket);
			threadServidorTCP.start();
		}

	}

}
