## Rodando a aplicação localmente

 **Pré-requisitos**
- [Java 1.8+](https://www.oracle.com/java/technologies/downloads/)
- [Gradle 7.5+](https://gradle.org/install/)
- IDE com suporte a Java
- [Docker](https://www.docker.com/)

## Banco de dados

O SGBD utilizado é o Postgres na versão `15.2`.

Baixe e instale o [docker](https://www.docker.com/).

Após instalar o docker, abra o terminal e execute:

```bash
docker run --name postgres -e POSTGRES_PASSWORD=postgres -e POSTGRES_DB=escola-caes-guia -d -p 5432:5432 postgres:15.2
```

Este comando irá criar um container docker com a imagem do postgres. Dados de acesso ao banco:


`host`: localhost

`port`: 5432

`database name`: escola-caes-guia

`password`: postgres


Verificar status do container:

```bash
docker ps
```

Agora você já deve ter uma instância do PostgreSQL rodando no container docker.

Para para o container

```bash
docker stop postgres
```

Para iniciar o container novamente

```bash
docker run postgres
```