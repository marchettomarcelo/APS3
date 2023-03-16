package br.com.conta.api.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private static UsuarioService usuarioService = null;
    private final List<Usuario> usuarios = new ArrayList<>();

    private UsuarioService() {}

    public static UsuarioService getInstance() {
        if (usuarioService == null) {
            usuarioService = new UsuarioService();
        }
        return usuarioService;
    }



    public Usuario createUsuario(String nome, String email, String aniversario) {
        Usuario usuario = new Usuario(nome, email, aniversario);
        usuarios.add(usuario);
        return usuario;

    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }


    public Usuario getUsuario(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    
}
