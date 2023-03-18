package br.com.conta.api.Usuario;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario createUsuario(Usuario usuario) {
        usuario.setIdentifier(UUID.randomUUID().toString());
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> getUsuarios() {
        return usuarioRepository.findAll();
    }


    public Usuario getUsuario(Integer userId) {
        return usuarioRepository.findByIdentifier(userId);
    }

    
}
