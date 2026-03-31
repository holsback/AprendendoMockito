package agendamento.notificacao.apinotificacaoagendamento.service;

import agendamento.notificacao.apinotificacaoagendamento.model.Agendamento;
import agendamento.notificacao.apinotificacaoagendamento.repository.AgendamentoRepository;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {

    private final AgendamentoRepository agendamentoRepository;
    private final EmailService emailService;

    public AgendamentoService(AgendamentoRepository agendamentoRepository, EmailService emailService) {
        this.agendamentoRepository = agendamentoRepository;
        this.emailService = emailService;
    }

    public void confirmaAgendamento(Agendamento agendamento) {
        if (agendamento.getId() == null) {
            throw new RuntimeException("Esse agendamento não existe");
        } else if (agendamento.getId() != null && agendamento.getEmail() == null) {
            throw new RuntimeException("Impossivel enviar email pois não há e-mail cadastrado!");
        } else {
            agendamento.setStatus("CONFIRMADO");
            agendamentoRepository.save(agendamento);
            String mensagem = "Ola " + agendamento.getNome() + ", o agendamento foi realizado com sucesso!";
            emailService.enviarEmail(agendamento.getEmail(), mensagem);
        }
    }

}
