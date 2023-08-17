<h2 align="center"> <b> Alura Food MicroServices - Java com arquitetura de Microsserviços, Spring e RabbitMQ </b> </h2>

https://github.com/guilhermehenrysilva/alurafood-microservices/assets/78513892/a143e87b-d48e-4a46-8184-fc1414e3cf8e

## ✅ Trilha de formação
https://cursos.alura.com.br/formacao-java-microsservicos

## ✅ Information
Microservices:
- Pagamentos 
- Pedidos 

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
### Capitulo 1:
 - <b>Eureka Server</b> é o serviço que faz o service registry e mantém o catálogo de todos os serviços registrados.
 
 - <b>Spring Cloud Gateway</b>, obtém a lista de endereços de todos os serviços registrados no Eureka Server, configura uma rota dinâmica para esses serviços e já faz o balanceamento de carga nas requisições.

 - <b>OpenFeign</b>, utilizado para a comunicação síncrona dos microserviços.

 - <b>Resilience4j (Circuit Breaker)</b>, utilizado para elaboração de um FallBack (Plano B) caso não consigamos comunicação com algum microserviço.

### Capitulo 2:
 - Como opção de Cloud, utilizamos a AWS para hospedagem de nossa API.

 - <b>AWS IAM (Identity and Access Manager)</b> gerencia com segurança as identidades e especifica quem ou o que pode acessar cada serviço ou recurso na AWS.

 - <b>AWS CLI (AWS Command Line Interface)</b> utilizado como intermédio para realizar nossas ações pelo terminal atraves de uma credencial IAM configurada na aws.   
Doc: https://docs.aws.amazon.com/pt_br/cli/latest/userguide/getting-started-install.html

 - <b>AWS CDK (AWS Cloud Development Kit)</b> utilizado para a construção de nossa infraestrutura através de uma linguagem especifica.
Doc: https://docs.aws.amazon.com/cdk/v2/guide/getting_started.html

---

Made with 💟 by [Guilherme Silva.](https://github.com/guilhermehenrysilva) 
