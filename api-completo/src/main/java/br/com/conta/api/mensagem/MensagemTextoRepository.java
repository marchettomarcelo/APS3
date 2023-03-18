package br.com.conta.api.mensagem;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.conta.api.Usuario.Usuario;
import java.util.List;

@Repository
public interface MensagemTextoRepository extends JpaRepository<MensagemTexto, Integer> {

    MensagemTexto findByIdentifier(String identifier);

    List<MensagemTexto> findBySender(Usuario sender);
}