package br.com.conta.api.mensagem;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.conta.api.Usuario.Usuario;

@Repository
public interface MensagemArquivoRepository extends JpaRepository<MensagemArquivo, Integer> {

    MensagemArquivo findByIdentifier(String identifier);

    List<MensagemArquivo> findBySender(Usuario sender);

}