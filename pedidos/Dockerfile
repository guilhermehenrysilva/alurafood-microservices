# Construindo imagem da API
# Instruções para criar e subir a img no repositorio do DockerHub -> "encurtador.com.br/mxLMZ"

# 1- Necessario rodar o cmd "mvn clean package" na raiz do projeto para gerar o .jar da API
# 2- Executar o DockerFile -> "docker build -t guilhermehenrysilva/pedidos-ms:1.0 ."
# 3- No DockerHub, criar um repositorio com o nome "pedidos-ms"
# 4- Dar push na img -> docker push guilhermehenrysilva/pedidos-ms:1.0

FROM openjdk:17-alpine
RUN addgroup -S spring && adduser -S spring -G spring
USER spring:spring
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]