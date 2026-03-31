package agendamento.notificacao.apinotificacaoagendamento.service;

import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {

    @Override
    public void enviarEmail(String destinatario, String mensagem) {
        System.out.println("Enviado e-mail para: " + destinatario + " | Conteúdo: " + mensagem);
    }

}
