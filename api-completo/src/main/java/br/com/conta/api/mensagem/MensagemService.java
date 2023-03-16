package br.com.conta.api.mensagem;

import br.com.conta.api.Usuario.Usuario;
import br.com.conta.api.Usuario.UsuarioService;

import java.util.ArrayList;
import java.util.List;

public class MensagemService {
    
    private static MensagemService mensagemService = null;

    private static UsuarioService UsuarioServiceInstance = UsuarioService.getInstance();
    

    private final List<MensagemTexto> mensagensTexto = new ArrayList<>(); 
    private final List<MensagemArquivo> mensagensArquivo = new ArrayList<>(); 


    private MensagemService() {}

    public static MensagemService getInstance() {
        if (mensagemService == null) {
            mensagemService = new MensagemService();
        }
        return mensagemService;
    }

    public MensagemTexto createTextMessage(String userId, String receiverId, String data, String texto) {    
        Usuario sender = UsuarioServiceInstance.getUsuario(userId);
        if (sender == null) {
            return null;
        }
        Usuario receiver = UsuarioServiceInstance.getUsuario(receiverId);
        if (receiver == null) {
            return null;
        }
        MensagemTexto msg = new MensagemTexto(sender, receiver, data, texto);
        mensagensTexto.add(msg);
        return msg;

        
    }

    public MensagemArquivo createArquivoMessage(String userId, String receiverId, String data, String nomeArquivo, String linkArquivo) {
        Usuario sender = UsuarioServiceInstance.getUsuario(userId);
        if (sender == null) {
            return null;
        }

        Usuario receiver = UsuarioServiceInstance.getUsuario(receiverId);
        if (receiver == null) {
            return null;
        }
        MensagemArquivo msg = new MensagemArquivo(sender, receiver, data, nomeArquivo, linkArquivo);
        mensagensArquivo.add(msg);
        return msg;
    }

    public List<MensagemTexto> getAllMensagensTexto() {
        return mensagensTexto;
    }

    public List<MensagemArquivo> getAllMensagensArquivo() {
        return mensagensArquivo;
    }

    public MensagemTexto getMensagensTexto(String id) {
        for (MensagemTexto mensagem : mensagensTexto) {
            if (mensagem.getId().equals(id)) {
                return mensagem;
            }
        }
        return null;
    }

    public MensagemArquivo getMensagensArquivo(String id) {
        for (MensagemArquivo mensagem : mensagensArquivo) {
            if (mensagem.getId().equals(id)) {
                return mensagem;
            }
        }
        return null;
    }

    public List<MensagemArquivo> getMensagensArquivoByUser( String userId) {

        List<MensagemArquivo> msg = new ArrayList<>(); 

        for (MensagemArquivo mensagem : mensagensArquivo) {
            if (mensagem.getSender().getId().equals(userId)) {
                msg.add(mensagem);
            }
        }
        return msg;
    }
    
    public List<MensagemTexto> getMensagensTextoByUser( String userId) {

        List<MensagemTexto> msg = new ArrayList<>(); 

        for (MensagemTexto mensagem : mensagensTexto) {
            if (mensagem.getSender().getId().equals(userId)) {
                msg.add(mensagem);
            }
        }
        return msg;
    }

  



}
