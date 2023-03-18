package br.com.conta.api.mensagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MensagemTextoRepository extends JpaRepository<MensagemTexto, Integer> {

    MensagemTexto findByIdentifier(String identifier);

}