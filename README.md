Projeto de micro serviço que permite fazer um CRUD (acrónimo do inglês Create, Read, Update and Delete).

Especificação Funcional: Cadastro de pessoas (Nome, Endereço, Cpf e Data de Nascimento).

Especificação Técnica:
 O Sistema foi desenvolvido em um Intel Core I3, com 3 GB de memória Windows 8.1 de 32 bits, processador com base em x64.
Foi usado:
- javac 1.8.0_151 – versão do java 1.8.0_151
- maven versão 4.0.
- spring-boot  e spring data - versão 1.5.4
- lombok versão 1.16.16
- junit versão 3.8.1
- Postman versão 7.3.5. ( arquivos para testes comitados no Git  “arquivo postman.postman_collection.json”.
- Restfull – os conceitos estão seguindo as regras dos verbos http e os status.
- API
- JPA
- Hibernate
-Tomcat 8.5.
Testei em 2 Banco de Dados : ( para escolher qual banco de dados usar, basta entrar no arquivo “application.properties” e descomentar as linhas do seu preferido.
-Postgres 1.22.2
Usuário: postgres
Senha:root
-MySql  - HeidiSQL 9.5.0
Usuário:root
Senha:root

Antes de qualquer coisa é preciso criar um novo Banco de Dados com o nome de “pessoas”. Para isso basta executar o código abaixo, ou simplesmente cria-lo dentro da ferramenta:
CREATE DATABASE `pessoas`;
USE `pessoas`;

Assim que executar o comando “POST” dentro do Postman, a tabela “employees” será criada automaticamente. ( arquivos do postman já estão comitados no git conforme dito acima junto com o projeto (“arquivo postman.postman_collection.json”)

O padrão de requisição implementado é o seguinte
•	GET http://localhost:8080/company/employees/
•	GET http://localhost:8080/company/employees /{id}
•	POST http://localhost:8080/company/employees /{id}
•	PUT http://localhost:8080/company/employees /{id}
•	DELETE http://localhost:8080/company/employees /{id}

Para iniciar, executar o Run as Java Application na classe “EmployeeApplication” dentro do pacote “com.zup.testeselecao”.

Após isso já pode executar os comandos no Postman e se o banco de dados e o Tomcat estiver configurado corretamente será possível Criar, Ler, Alterar e Deletar com os códigos de status http nas respostas.

JUNIT

Os testes do JUNIT estão no pacote “testezup” dentro de “src/test”
Para executar basta entrar em Run as => JUnit Test a classe “EmployeeControllerTest”
 Será executado na sequencia : Criação do registro , Leituro desse mesmo registro, Exclusão desse registro e uma nova leitura para garantir que esse registro foi excluído.




