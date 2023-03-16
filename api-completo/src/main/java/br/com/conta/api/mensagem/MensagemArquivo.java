package br.com.conta.api.mensagem;


import br.com.conta.api.Usuario.Usuario;

public class MensagemArquivo extends Mensagen {
    
    private String nomeArquivo;
    private String linkArquivo;


    public MensagemArquivo(Usuario sender, Usuario receiver, String data, String nomeArquivo,
            String linkArquivo) {
        super(sender, receiver, data);
        this.nomeArquivo = nomeArquivo;
      
        this.linkArquivo = linkArquivo;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getLinkArquivo() {
        return linkArquivo;
    }

    public void setLinkArquivo(String linkArquivo) {
        this.linkArquivo = linkArquivo;
    }

    @Override
    public String toString() {
        return  getData() +" de " + getSender().getNome() + " para " + getReceiver().getNome() + ": " + getNomeArquivo();
    }

}
