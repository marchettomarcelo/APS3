package br.com.conta.api.Usuario;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "usuario")
public class Usuario {
    
    @Column(name = "nome", nullable = false)
    private  String nome;

    @Column(name = "email", unique = true)
    private  String email;

    @Column(name = "aniversario")
    private String aniversario;

    @Column(name = "identifier", nullable = false, unique = true)
    private String identifier;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
}
