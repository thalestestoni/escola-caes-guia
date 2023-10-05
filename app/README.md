## Rodando a aplicação localmente

 **Pré-requisitos**
- [Java 1.8+](https://www.oracle.com/java/technologies/downloads/)
- [Gradle 7.5+](https://gradle.org/install/)
- IDE com suporte a Java
- [Docker](https://www.docker.com/)

## Banco de dados

O SGBD utilizado é o Postgres na versão `15.2`.

### Instalação da infraestrutura

Os passos abaixo guiarão você na instalação de um banco de dados postgres, versão 15.2, usando o docker. Caso você já tenha um banco postgres instalado poderá usa-lo, não necessitando seguir os passos abaixo.

Baixe e instale o [docker](https://www.docker.com/).

Após instalar o docker, abra o terminal e execute:

```bash
docker run --name postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=escola-caes-guia -d -p 5432:5432 postgres:15.2
```

Observe que no comando estamos passando qual será a senha do postgres (POSTGRES_PASSWORD), e qual é será o nome do banco de dados (POSTGRES_DB).

Este comando irá criar um container docker com a imagem do postgres. Dados de acesso ao banco:


`host`: localhost

`port`: 5432

`database name`: escola-caes-guia

`postgres user`: postgres

`password`: postgres


Verificar status do container:

```bash
docker ps
```

Agora você já deve ter uma instância do PostgreSQL rodando no container docker.

Para parar o container

```bash
docker stop postgres
```

Para iniciar o container novamente

```bash
docker run postgres
```

### Configurando variáveis de ambiente

Acesse o arquivo [resources/application.properties](./src/main/resources/application.properties) e configure as variáveis
- spring.datasource.url=jdbc:postgresql
- spring.datasource.username
- spring.datasource.password

Se você está usando o banco de dados configurado na etapa acima, as variáveis devem ficar assim:

- spring.datasource.url=jdbc:postgresql://localhost:5432/escola-caes-guia
- spring.datasource.username=postgres
- spring.datasource.password=postgres

### Criando as tabelas

Utilize um administrador de banco de dados como [dbeaver](https://dbeaver.io/download/) ou o próprio [pgAdmin](https://www.pgadmin.org/) para se conectar ao banco de dados e executar os scripts sql.

Execute os comandos do [script de criação das tabelas](../docs/files/script_criacao_tabelas.sql) no software escolhido para se conectar ao banco.

Agora importe nas tabelas `cidade`, `estado` e `endereco` os dados contidos respectivamente nos arquivos [cidades.zip](../docs/data/cidade-estado-endereco/cidades.zip), [estados.zip](../docs/data/cidade-estado-endereco/estados.zip) e [enderecos.zip](../docs/data/cidade-estado-endereco/enderecos.zip).

### Rodando a aplicação

Abra o terminal na pasta [app](./) e execute o comando

```shell
./gradlew bootRun
```
