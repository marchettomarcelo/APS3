package br.com.conta.api.Usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.conta.api.mensagem.MensagemArquivo;
import br.com.conta.api.mensagem.MensagemTexto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "tb_usuario")
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
    
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<MensagemArquivo> mensagemArquivo;

    
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<MensagemTexto> mensagemTexto;


    
}
