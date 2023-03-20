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
        msg.setIdentifier(UUID.randomUUID().toString());
        Usuario u = UsuarioServiceInstance.getUsuario(msg.getSender().getIdentifier());

        msg.setSender(u);
        return mensagemTextoRepository.save(msg);
        
    }

    public MensagemArquivo createArquivoMessage(MensagemArquivo msg)  {
        msg.setIdentifier(UUID.randomUUID().toString());
        Usuario u = UsuarioServiceInstance.getUsuario(msg.getSender().getIdentifier());
        
        msg.setSender(u);
        return mensagemArquivoRepository.save(msg);
        
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

    public List<MensagemArquivo> getMensagensArquivoByUser( String userId) {
        
        return mensagemArquivoRepository.findBySender(UsuarioServiceInstance.getUsuario(userId));
    
    }
    
    public List<MensagemTexto> getMensagensTextoByUser( String userId) {
        return mensagemTextoRepository.findBySender(UsuarioServiceInstance.getUsuario(userId));
    }

}
