package br.com.conta.api.mensagem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/mensagem")
public class MensagemController {

    @Autowired
    public  MensagemService mensagemService;


    @GetMapping
    public String getMensagem() {
        return "Mensagem";
    }

    // --- 1  e 2 ---

    @PostMapping("/texto")
    public MensagemTexto createMensagemTexto(@RequestBody @Valid MensagemTexto mensagem ) {
        return mensagemService.createTextMessage(mensagem);
    }
    
    @PostMapping("/arquivo")
    public MensagemArquivo creareMensagemArquivo(@RequestBody @Valid MensagemArquivo mensagem ) {
        return mensagemService.createArquivoMessage(mensagem );
    }

    // --- 3 ---

    @GetMapping("/texto")
    public List<MensagemTexto> getAllMensagensTexto() {
        return mensagemService.getAllMensagensTexto();
    }

    @GetMapping("/arquivo")
    public List<MensagemArquivo> getAllMensagensArquivo() {
        return mensagemService.getAllMensagensArquivo();
    }

    // --- 4 ---

    @GetMapping("/texto/{msgId}")
    public MensagemTexto getMensagemTexto(@PathVariable String msgId) {
        return mensagemService.getMensagensTexto(msgId);
    }

    @GetMapping("/arquivo/{msgId}")
    public MensagemArquivo getMensagemArquivo(@PathVariable String msgId) {
        return mensagemService.getMensagensArquivo(msgId);
    }

    // --- 5 ---
    @GetMapping("/arquivo/{userId}/user")
    public List<MensagemArquivo> getMensagensArquivoUser(@PathVariable Integer userId) {
        return mensagemService.getMensagensArquivoByUser(userId);
    }
   
    @GetMapping("/texto/{userId}/user")
    public List<MensagemTexto> getMensagensTextoUser(@PathVariable Integer userId) {
        return mensagemService.getMensagensTextoByUser(userId);
    }
    
}
