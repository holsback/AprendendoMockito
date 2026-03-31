package agendamento.notificacao.apinotificacaoagendamento.repository;

import agendamento.notificacao.apinotificacaoagendamento.model.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
    public interface AgendamentoRepository extends JpaRepository<Agendamento, UUID> {
}
