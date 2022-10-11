package servidortcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import entities.Operacao;
import servidortcp.service.EfetuarOperacao;

public class ThreadServidorTCP extends Thread {

	private Socket socket;

	private Operacao solicitacao = null;

	private Operacao resposta = null;

	private ObjectInputStream objectInputStream = null;

	private ObjectOutputStream objectOutputStream = null;

	public ThreadServidorTCP(Socket socket) {
		this.socket = socket;
	}

	private ObjectInputStream iniciarObjectInputStream() {
		ObjectInputStream objectInputStream = null;
		try {
			objectInputStream = new ObjectInputStream(socket.getInputStream());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(0);
		}
		return objectInputStream;
	}

	private ObjectOutputStream iniciarObjectOutputStream() {
		ObjectOutputStream objectOutputStream = null;
		try {
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(0);
		}
		return objectOutputStream;
	}

	private void iniciarStreams() {
		objectOutputStream = iniciarObjectOutputStream();
		objectInputStream = iniciarObjectInputStream();
	}

	private void obterSolicitacao() {
		try {
			solicitacao = (Operacao) objectInputStream.readObject();
		} catch (IOException | ClassNotFoundException ex) {
			System.out.println(ex.getMessage());
			System.exit(0);
		}
	}

	private void logicaResposta() {
		EfetuarOperacao efetuarOperacao = new EfetuarOperacao(solicitacao);
		resposta = efetuarOperacao.realizarOperacao();
	}

	private void enviarResposta() {
		try {
			objectOutputStream.writeObject(resposta);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
			System.exit(0);
		}
	}

	@Override
	public void run() {
		iniciarStreams();
		obterSolicitacao();
		logicaResposta();
		enviarResposta();
	}

}
