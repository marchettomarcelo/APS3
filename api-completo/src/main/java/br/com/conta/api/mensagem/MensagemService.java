package br.com.conta.api.mensagem;

import br.com.conta.api.Usuario.Usuario;
import br.com.conta.api.Usuario.UsuarioService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MensagemService {
    
    @Autowired
    private static MensagemArquivoRepository mensagemArquivoRepository;
    
    @Autowired
    private static MensagemTextoRepository mensagemTextoRepository;


    @Autowired
    private static UsuarioService UsuarioServiceInstance;
    

    public MensagemTexto createTextMessage(MensagemTexto msg)  {    
        Usuario sender = UsuarioServiceInstance.getUsuario(msg.getSender().getId());
        if (sender == null) { 
            return null;
        }
        Usuario receiver = UsuarioServiceInstance.getUsuario(msg.getReceiver().getId());
        if (receiver == null) {
            return null;
        }

        msg.setIdentifier(UUID.randomUUID().toString());
        return msg;
        
    }

    public MensagemArquivo createArquivoMessage(MensagemArquivo msg)  {
        Usuario sender = UsuarioServiceInstance.getUsuario(msg.getSender().getId());
        if (sender == null) {
            return null;
        }

        Usuario receiver = UsuarioServiceInstance.getUsuario(msg.getReceiver().getId());
        if (receiver == null) {
            return null;
        }
        
        msg.setIdentifier(UUID.randomUUID().toString());
        return msg;
    }

    public List<MensagemTexto> getAllMensagensTexto() {
        return mensagemTextoRepository.findAll();
    }

    public List<MensagemArquivo> getAllMensagensArquivo() {
        return mensagemArquivoRepository.findAll();
    }

    public MensagemTexto getMensagensTexto(String id) {
        return mensagemTextoRepository.findByIdentifier(id);
    }

    public MensagemArquivo getMensagensArquivo(String id) {
        return mensagemArquivoRepository.findByIdentifier(id);
    }

    public List<MensagemArquivo> getMensagensArquivoByUser( Integer userId) {
        
        return mensagemArquivoRepository.findBySender(UsuarioServiceInstance.getUsuario(userId));
    
    }
    
    public List<MensagemTexto> getMensagensTextoByUser( Integer userId) {
        return mensagemTextoRepository.findBySender(UsuarioServiceInstance.getUsuario(userId));
    }

}
