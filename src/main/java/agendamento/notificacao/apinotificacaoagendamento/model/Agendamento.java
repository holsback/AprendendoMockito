package agendamento.notificacao.apinotificacaoagendamento.model;

import java.util.Date;
import java.util.UUID;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
public class Agendamento {

    private UUID id;
    private String nome;
    private String email;
    private String status;

}
