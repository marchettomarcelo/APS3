package br.com.conta.api.Usuario;

import java.util.UUID;

public class Usuario {
    private  String nome;
    private  String email;
    private String aniversario;
    private String id;

    public Usuario(String nome, String email, String aniversario) {
        this.nome = nome;
        this.email = email;
        this.aniversario = aniversario;
        this.id = UUID.randomUUID().toString();

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    
}
