package clientetcp;

import entities.Operacao;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import javax.swing.JOptionPane;

public class ClienteTCP {

    private static final int PORTA_SERVICO = 2000;

    private static final String nomeServidor = "127.0.0.1";

    private Socket socket = null;

    private InetAddress enderecoServidor = null;

    private Operacao solicitacao;

    private Operacao resposta = null;

    private ObjectInputStream objectInputStream = null;

    private ObjectOutputStream objectOutputStream = null;

    public ClienteTCP(Operacao solicitacao) {
        this.solicitacao = solicitacao;
    }

    private void validarSolicitacaoServidor() {
        if (!this.solicitacao.getOperacao().getNomeOperacao().equals("Salvar")
                && !this.solicitacao.getOperacao().getNomeOperacao().equals("Atualizar")
                && !this.solicitacao.getOperacao().getNomeOperacao().equals("Apriori")) {
            JOptionPane.showMessageDialog(null, "Solicitação inválida para o servidor!");
        }
    }

    private InetAddress iniciarEnderecoServidor() {
        InetAddress servidor = null;
        try {
            servidor = InetAddress.getByName(nomeServidor);
        } catch (UnknownHostException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        return servidor;
    }

    private Socket iniciarSocket() {
        Socket socket = null;
        try {
            socket = new Socket(enderecoServidor, PORTA_SERVICO);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
        return socket;
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

    private void enviarSolicitacaoOperacao() {
        try {
            objectOutputStream.writeObject(solicitacao);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    private void aguardarRespostaServidor() {
        try {
            resposta = (Operacao) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    private void fecharConexaoServidor() {
        try {
            socket.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(0);
        }
    }

    public Operacao enviarSolicitacaoServidor() {
        validarSolicitacaoServidor();
        enderecoServidor = iniciarEnderecoServidor();
        socket = iniciarSocket();
        iniciarStreams();
        enviarSolicitacaoOperacao();
        aguardarRespostaServidor();
        fecharConexaoServidor();
        return resposta;
    }

}
