package agendamento.notificacao.apinotificacaoagendamento;

import agendamento.notificacao.apinotificacaoagendamento.model.Agendamento;
import agendamento.notificacao.apinotificacaoagendamento.repository.AgendamentoRepository;
import agendamento.notificacao.apinotificacaoagendamento.service.AgendamentoService;
import agendamento.notificacao.apinotificacaoagendamento.service.EmailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class AgendamentoServiceTest {

    @Mock
    private AgendamentoRepository repository;

    @Mock
    private EmailService emailService;

    @InjectMocks
    private AgendamentoService service;

    @Test
    void deveConfirmarAgendamentoComSucesso() {

        Agendamento agendamento = new Agendamento();
        agendamento.setId(UUID.randomUUID());
        agendamento.setNome("Bruno");
        agendamento.setEmail("bruno@email.com");
        agendamento.setStatus("PENDENTE");

        service.confirmaAgendamento(agendamento);

        assertEquals("CONFIRMADO", agendamento.getStatus());

        verify(repository).save(agendamento);

        verify(emailService).enviarEmail(eq("bruno@email.com"), anyString());
    }

    @Test
    void deveLancarExcecaoQuandoEmailForNulo() {

        Agendamento agendamento = new Agendamento();
        agendamento.setId(UUID.randomUUID());
        agendamento.setNome("Bruno");
        agendamento.setEmail(null);
        agendamento.setStatus("PENDENTE");

        assertThrows(RuntimeException.class, () -> service.confirmaAgendamento(agendamento));

        verify(emailService, never()).enviarEmail(anyString(), anyString());
    }

    @Test
    void deveLancarExecaoQuandoIdForNulo() {
        Agendamento agendamento = new Agendamento();
        agendamento.setId(null);
        agendamento.setNome("Bruno");
        agendamento.setEmail("bruno@email.com");
        agendamento.setStatus("PENDENTE");

        assertThrows(RuntimeException.class, () -> service.confirmaAgendamento(agendamento));

        verify(emailService, never()).enviarEmail(anyString(), anyString());
    }

}
