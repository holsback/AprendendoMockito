🚀 Projeto de Estudo: Aprendendo Mockito & Testes Unitários em Java
Este repositório foi criado para isolar e fixar os fundamentos de Testes Unitários utilizando o framework Mockito num ambiente Spring Boot 3. O foco principal foi aprender a validar regras de negócio de forma isolada, garantindo a funcionalidade do sistema sem a necessidade de instanciar dependências reais, como bases de dados ou serviços de rede.

🎯 Objetivo do Projeto
Demonstrar a aplicação prática de padrões de projeto voltados para a testabilidade, garantindo que a lógica de uma API de Notificação de Agendamento esteja protegida contra falhas e dados inconsistentes através de uma cobertura de testes sólida.

🧠 Aprendizagens Implementadas
1. Injeção de Dependência via Construtor
Aplicação do princípio de Inversão de Dependência (SOLID), garantindo que o AgendamentoService seja desacoplado das implementações concretas. O uso de Interfaces (EmailService) permitiu que o sistema aceite diferentes implementações (Mocks) sem alterar o código principal.

2. Fundamentos de Mockito
@Mock & @InjectMocks: Criação de objetos simulados para as camadas de Repository e Service, injetando-os automaticamente na classe real sob teste.

Ciclo AAA (Arrange, Act, Assert): Organização dos testes para preparar o cenário, executar a ação e validar os resultados de forma clara e padronizada.

Verificação de Comportamento: Utilização de verify() aliado a never() para garantir que métodos externos (como o envio de e-mail) só sejam executados quando as regras de negócio forem satisfeitas.

3. Testes de Fluxo de Exceção
Implementação de testes que validam a robustez do código através do assertThrows, garantindo o lançamento de exceções em cenários críticos:

Agendamentos sem Identificador (ID nulo).

Tentativa de confirmação sem e-mail do cliente cadastrado.

🛠️ Tecnologias Utilizadas
Java 21

Spring Boot 3

JUnit 5

Mockito

Lombok (para redução de código boilerplate)
