
package br.com.conta.api.mensagem;
import br.com.conta.api.Usuario.Usuario;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.GeneratedValue;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mensagem_texto")
@NoArgsConstructor
public class MensagemTexto  {

    @Column(name = "texto")
    private String texto;

    @Column(name = "sender")
    private Usuario sender;

    @Column(name = "receiver")
    private Usuario receiver;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    
}
