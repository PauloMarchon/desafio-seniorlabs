<h1 align="center">Projeto Desafio Seniorlabs</h1>

 Resolucao do desafio da Seniorlabs proposto pelo [repositorio](https://github.com/SeniorSA/seniorlabs-challenge/blob/main/software-engineering.md).

O desafio descreve um cenario em que o sistema recebe milhares de requisicoes de marcacao de ponto em um curto periodo de tempo e essas marcacoes precisam ser enviadas a um sistema legado que possui um tempo de resposta lento.
 
# Projetos
 A organizacao dos projetos foram divididas em responsabilidades:

* producer - O Producer é responsavel por receber as requisicoes das marcacoes de ponto atraves de chamadas HTTP e envia-las para o Kafka.
* processor - O Processor é responsavel por coletar as marcacoes de ponto do Kafka e envia-las ao sistema legado.
   
# Tecnologias

Apache Kafka - A utilizacao do Apache Kafka prove muitas vantagens para a resolucao do problema em questao. A baixa latencia garante um processamento rapido das mensagens, a consistencia e replicacao garante que as marcacoes de pontos nao sejam perdidas mesmo em caso de falhas e tambem dispoe da possibilidade de escalabilidade horizontal, de acordo com a necessidade das requisicoes recebidas.

# Teste de Carga
Os testes foram realizados utilizando o JMeter, com um topico Kafka contendo 20 particoes e fator de replicação 1.

<h3 align="center">Resultados de 100 mil requisicoes (1000 threads x 100):</h3>

![100k 20p](https://github.com/PauloMarchon/desafio-seniorlabs/assets/28858219/f4157109-315f-4563-827f-7644beb454c2)

![100k 20p graph](https://github.com/PauloMarchon/desafio-seniorlabs/assets/28858219/b123e14b-f17b-47ca-89cc-3b14f3a6873f)

<h3 align="center">Resultados de 200 mil requisicoes (2000 threads x 100):</h3>

![200k 20p](https://github.com/PauloMarchon/desafio-seniorlabs/assets/28858219/08748dba-c86c-4a0b-9446-9441b7883a32)

![200k 20p graph](https://github.com/PauloMarchon/desafio-seniorlabs/assets/28858219/57782532-8b9d-43dc-bbb4-2ae2d41a39e7)


# Executando a aplicacao

Requisitos:
 - Java 21
 - Gradle
 - Docker / Docker Compose
   
Ao clonar o repositorio, navegue ate a raiz do repositorio utilizando o comando ***cd desafio-seniorlabs*** e execute o comando ***docker-compose up*** para subir os containers do Zookeeper o do Kafka.

Para testar a aplicacao podemos rodar e testar diretamente os projetos atraves do comando ***./gradlew bootRun***  ou construir seus executaveis com o comando ***./gradlew build***

O repositorio possui dois projetos, cada projeto esta em um diretorio separado, portanto, apos subir as imagens Docker é necessario navegar para o diretorio de cada projeto e executa-los individualmente. \
(Neste caso, é necessario utilizar uma janela de terminal para cada aplicacao):

***cd seniorlabs-producer*** -> ***./gradlew bootRun OU ./gradlew build*** \
***cd seniorlabs-processor*** -> ***./gradlew bootRun_ OU ./gradlew build***

Caso opte por construir/buildar as aplicacoes, é necessario executar os arquivos JAR gerados por cada aplicacao: 

_java -jar desafio-seniorlabs/seniorlabs-producer/build/libs/seniorlabs-producer-0.0.1-SNAPSHOT.jar_ \
_java -jar desafio-seniorlabs/seniorlabs-processor/build/libs/seniorlabs-processor-0.0.1-SNAPSHOT.jar_

A requisicao de envio da marcacao de ponto com o objeto JSON pode ser feita para http://localhost:8082/clock
