# telzir
Projeto para execução do calculo dos planos fale mais

[Tela1](https://imgur.com/lgZFqxd)
[Tela2](https://imgur.com/22rLQcL)

[Tela3](https://imgur.com/7cfGVxM)
[Tela4](https://imgur.com/ruZ0d8P)

# Iniciando
Essas instruções fornecerão uma cópia do projeto em execução na sua máquina local para fins de desenvolvimento e teste. Consulte implantação para obter notas sobre como implantar o projeto em um sistema ativo.

## Pré-requisitos:
- Para execução do projeto é necessário, ou que tenha o java8 instalado, ou Docker.
- Maven
- Pacote JDK

## Desenvolvido com
 - [Spring](https://spring.io/)
 - [Maven](https://maven.apache.org/)
 - [Java](https://www.java.com/pt_BR/download/)

## Executando os testes
- Para execução dos testes unitários basta utilizar o comando ``` mvn test ``` na pasta raiz do projeto.

## Para execução do projeto com docker

executar os seguintes comandos dentro da pasta do projeto após a instalação do docker e maven:
 ```
 mvn clean
 mvn install
 docker build -f Dockerfile -t telzir_teste .
 docker run -p 8080:8080 telzir_teste

 ```

 A Aplicação ficará disponível na porta 8080 na rota /telzir-form
- localhost:8080/telzir-form

## Autores
- Jadiel Elias Mouchrek dos Santos.
