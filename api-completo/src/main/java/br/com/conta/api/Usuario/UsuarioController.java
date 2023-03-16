package br.com.conta.api.Usuario;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    
    public final static UsuarioService usuarioService = UsuarioService.getInstance();

    @GetMapping("/{id}")
    public Usuario getUsuario(@PathVariable String id) {
        
        return usuarioService.getUsuario(id);
    }

    @GetMapping
    public List<Usuario> getUsuarios() {
        return usuarioService.getUsuarios();
    }

    @PostMapping
    public Usuario createUsuario(String nome, String email, String aniversario) {
        return usuarioService.createUsuario(nome, email, aniversario);
    }
}
