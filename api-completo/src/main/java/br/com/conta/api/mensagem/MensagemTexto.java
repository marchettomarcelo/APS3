
package br.com.conta.api.mensagem;
import br.com.conta.api.Usuario.Usuario;

public class MensagemTexto extends Mensagen {

    private String texto;

    public MensagemTexto(Usuario sender , Usuario receiver, String data, String texto) {
        super(sender, receiver, data);
        this.texto = texto;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    @Override
    public String toString() {
        return  getData() +" de " + getSender().getNome() + " para " + getReceiver().getNome() + ": " + getTexto();
    }
    
}
