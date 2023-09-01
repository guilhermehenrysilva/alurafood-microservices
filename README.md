<h2 align="center"> <b> Alura Food MicroServices - Java com arquitetura de Microsserviços, Spring e RabbitMQ </b> </h2>

https://github.com/guilhermehenrysilva/alurafood-microservices/assets/78513892/a143e87b-d48e-4a46-8184-fc1414e3cf8e

## ✅ Trilha de formação
https://cursos.alura.com.br/formacao-java-microsservicos

## ✅ Information
Microservices:
- Pagamentos 
- Pedidos 
- Avaliacao

Server Discovery (Netflix Eureka Server - Microservices address registry)
- server

Gateway (Centralization of Microservice addresses)
- gateway 

## 🔶 How to execute
```bash
### Microservices Database - Mysql Container
docker-compose up

### Run project Sequence
1- server
2- gateway
3- microservices
```

## 🔶 Service's description
### Capitulo 1: Microserviços
 - <b>Eureka Server</b> é o serviço que faz o service registry e mantém o catálogo de todos os serviços registrados.
 
 - <b>Spring Cloud Gateway</b>, obtém a lista de endereços de todos os serviços registrados no Eureka Server, configura uma rota dinâmica para esses serviços e já faz o balanceamento de carga nas requisições.

 - <b>OpenFeign</b>, utilizado para a comunicação síncrona dos microserviços.

 - <b>Resilience4j (Circuit Breaker)</b>, utilizado para elaboração de um FallBack (Plano B) caso não consigamos comunicação com algum microserviço.

### Capitulo 2: AWS
 - Como opção de Cloud, utilizamos a AWS para hospedagem de nossa API.

 - <b>AWS IAM (Identity and Access Manager)</b> gerencia com segurança as identidades e especifica quem ou o que pode acessar cada serviço ou recurso na AWS.

 - <b>AWS CLI (AWS Command Line Interface)</b> utilizado como intermédio para realizar nossas ações pelo terminal atraves de uma credencial IAM configurada na aws.   
Doc: https://docs.aws.amazon.com/pt_br/cli/latest/userguide/getting-started-install.html

 - <b>AWS CDK (AWS Cloud Development Kit)</b> utilizado para a construção de nossa infraestrutura através de uma linguagem especifica.
Doc: https://docs.aws.amazon.com/cdk/v2/guide/getting_started.html

### Capitulo 3: Mensageria (RabbitMq)
Tipos de exchange: 
- **Direct**: Esse tipo de exchange é usada, geralmente, quando desejamos enviar mensagens para um consumidor específico. Para isso, utilizamos uma routing key, que é uma chave enviada junto com a mensagem para que a exchange identifique qual a fila irá receber a mensagem.

- **Fanout**: Quando enviamos uma mensagem para uma exchange desse tipo, ela vai ser enviada para todas as filas que estiverem ligadas a essa exchange. Ou seja, se existirem 30 filas ligadas a essa exchange, essas 30 filas receberão a mensagem. Para conectar uma fila a uma exchange é preciso criar um bind, que é uma relação (ou vínculo) entre uma fila e uma exchange. Nomeia-se como binding key essa chave de ligação entre a fila e a exchange.

- **Headers**: É um tipo muito menos usado, mas basicamente ignora o routing key e passa no próprio cabeçalho da mensagem para qual binding key deve ser encaminhada a mensagem.

- **Topic**: A palavra-chave desse tipo de exchange é flexibilidade. Você pode nomear as binding keys de uma forma a criar padrões e/ou regras para que o envio seja de forma personalizada. Essas binding keys são descritas como se fossem expressões regulares. Dessa forma, podemos fazer composições para que mais de um consumidor receba as mensagens.

---

Made with 💟 by [Guilherme Silva.](https://github.com/guilhermehenrysilva) 
