package agendamento.notificacao.apinotificacaoagendamento.service;

import org.springframework.stereotype.Service;

public interface EmailService {

    void enviarEmail(String destinatario, String mensagem);

}

