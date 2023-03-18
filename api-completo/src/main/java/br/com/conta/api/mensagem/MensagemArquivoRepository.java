package br.com.conta.api.mensagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemArquivoRepository extends JpaRepository<MensagemArquivo, Integer> {

    MensagemArquivo findByIdentifier(String identifier);

}