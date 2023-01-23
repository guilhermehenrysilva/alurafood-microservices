<h2 align="center"><b>Alura Food MicroService's</b></h2>

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
 - <b>Eureka Server</b> é o serviço que faz o service registry e mantém o catálogo de todos os serviços registrados.
 
 - <b>Spring Cloud Gateway</b>, obtém a lista de endereços de todos os serviços registrados no Eureka Server, configura uma rota dinâmica para esses serviços e já faz o balanceamento de carga nas requisições.

 - <b>OpenFeign</b>, utilizado para a comunicação síncrona dos microserviços.

 - <b>Resilience4j (Circuit Breaker)</b>, utilizado para elaboração de um FallBack (Plano B) caso não consigamos comunicação com algum microserviço.
---

Made with 💟 by [Guilherme Silva.](https://github.com/guilhermehenrysilva) 
