## Sumário
- [Sumário](#sumário)
- [📍 Intro](#-intro)
- [📕 Manual do usuário](#-manual-do-usuário)
- [💾 Modelo de banco de dados](#-modelo-de-banco-de-dados)
- [🔐 Controle de acesso de usuário (ACL - User access control list)](#-controle-de-acesso-de-usuário-acl---user-access-control-list)
  - [Perfil](#perfil)
  - [Permissão](#permissão)
  - [Permissão por perfil](#permissão-por-perfil)
- [Infraestrutura](#infraestrutura)
  - [Banco de dados](#banco-de-dados)

## 📍 Intro

Neste documento encontra-se todos os arquivos pertinentes a documentação do projeto [Escola de cães-guia HKeller](../README.md)

## 📕 Manual do usuário

Dentro da pasta files encontra-se o pdf do [manual do usuário](./files/Manual%20do%20Usuario%20-%20Escola%20de%20caes%20guia%20Helen%20Keller.pdf).

## 💾 Modelo de banco de dados

<img src="./images/modelagem_banco.png" />

Este modelo foi criado com [dbdiagram.io](https://dbdiagram.io). Para editá-lo basta copiar o código abaixo e inseri-lo no dbdiagram.

```dbml
Table cao {
  id bigint [pk,increment]
  nome varchar [not null]
  cor varchar [not null]
  data_nascimento date [not null]
  localizacao point [not null]
  sexo varchar [not null]
  created_at timestamp [default: `now()`]
  updated_at timestamp [default: `now()`]
}

Table plano_ensino {
  id_cao bigint [pk, ref: - cao.id]
  descricao varchar
}

Table tutor_cao {
  id bigint [pk, increment]
  id_cao bigint [not null, ref: > cao.id]
  id_usuario bigint [not null, ref: > usuario.id]
  id_situacao_tutor_cao bigint [not null, ref: > situacao_tutor_cao.id]
  created_at timestamp [default: `now()`]
  updated_at timestamp [default: `now()`]
  
  Note: 'Estrutura para de relação entre um usuário e um cao. Esta relação possuirá uma situação ativa ou inativa, sendo que poderá existir somente uma relação ativa por vez entre cao e usuário.'
}

Table situacao_tutor_cao {
  id bit [pk, increment]
  descricao varchar [not null]
  
  Note: 'Representa a situação atual da relação do tutor com o cão, podendo esta relação estar ativa ou inativa.'
}

Table evento {
  id bigint [pk,increment]
  titulo varchar [not null]
  descricao varchar [not null]
  data datetime [not null]
  notificar_tutor bit [not null, default: 0]
  id_cao bigint [not null, ref: > cao.id]
  created_at timestamp [default: `now()`]
  updated_at timestamp [default: `now()`]
  
  Note: 'O campo "data" representa qual a data do evento, devendo o próprio usuário informá-la. Quando for exibido em formato de notificação para o tutor, basta buscar os eventos >= data atual. Quando for exibido em histórico basta buscar todos os eventos.'
}

Table usuario {
  id bigint [pk, increment]
  nome varchar [not null]
  email varchar [unique, not null]
  cpf varchar [unique, not null]
  password varchar [not null]
  data_nascimento datetime [not null]
  telefone_celular varchar [not null]
  telefone_fixo varchar
  created_at timestamp [default: `now()`]
  updated_at timestamp [default: `now()`]

  Note: 'Email e cpf poderão ser utilizados como login, pois são chaves únicas.'
}

Table perfil {
  id int [pk, increment]
  nome varchar [not null]
  descricao varchar [not null]
  created_at timestamp [default: `now()`]
  updated_at timestamp [default: `now()`]
}

Table perfil_usuario {
  id_usuario bigint [pk, ref: > usuario.id]
  id_perfil int [pk, ref: > perfil.id]
}

Table permissao {
  id int [pk, increment]
  nome varchar [not null]
  descricao varchar [not null]
  created_at timestamp [default: `now()`]
  updated_at timestamp [default: `now()`]
}

Table permissao_perfil {
  id_perfil int [pk, ref: > perfil.id]
  id_permissao int [pk, ref: > permissao.id]
}

Table form_cadastro_inicial_socializador {
  id bigint [pk, increment]
  email varchar [not null]
  nome_completo varchar [not null]
  data_nascimento date [not null]
  rg varchar [not null]
  orgao_emissor varchar [not null]
  cpf varchar [not null]
  endereco varchar [not null]
  telefone_celular varchar [not null]
  telefone_fixo varchar
  grau_instrucao enum_grau_instrucao [not null]
  profissao varchar [not null]
  local_trabalho varchar [not null]
  estuda boolean [not null]
  local_estudo varchar [not null]
  estado_civil enum_estado_civil [not null]
}

Enum enum_grau_instrucao {
  nao_alfabetizado
  ensino_fundamental_incompleto
  ensino_fundamental_completo
  ensino_medio_incompleto
  ensino_medio_completo
  graduacao_incompleta
  graduacao_completa
  pos_graduacao
  mestrado_ou_doutorado_incompleto
  mestrado_ou_douturado_completo
}

Enum enum_estado_civil {
  solteiro
  uniao_estavel
  casado
  divorciado
  viuvo
}
```

## 🔐 Controle de acesso de usuário (ACL - User access control list)

### Perfil

| nome | descricao |
| -- | -- |
| admin | Administrador |
| funcionario | Funcionário |
| tutor | Tutor |

### Permissão

| nome | descricao |
| -- | -- |
| criar_cao | Criar cão |
| editar_cao | Editar cão |
| visualizar_cao | Visualizar cão |
| listar_caes | Listar cães |
| criar_tutor | Criar tutor |
| editar_tutor | Editar tutor |
| visualizar_tutor | Visualizar tutor |
| inativar_tutor | Inativar tutor |
| criar_evento | Criar evento |
| editar_evento | Editar evento |
| visualizar_evento | Visualizar evento |
| listar_eventos | Listar eventos |

### Permissão por perfil

| permissao | perfis  |
| -- | -- |
| criar_cao | admin, funcionario |
| editar_cao | admin, funcionario |
| visualizar_cao | admin, funcionario, tutor |
| listar_caes | admin, funcionario |
| criar_tutor | admin, funcionario |
| editar_tutor | admin, funcionario |
| visualizar_tutor | admin, funcionario, tutor |
| inativar_tutor | admin, funcionario |
| criar_evento | admin, funcionario |
| editar_evento | admin, funcionario |
| visualizar_evento | admin, funcionario, tutor |
| listar_eventos | admin, funcionario, tutor |

## Infraestrutura
Esta seção descreve os recursos de infraestrutura utilizados.

### Banco de dados
Foi escolhido o Postgres como SGBD (Sistema gerenciador de banco de dados), pois um dos requisitos do projeto era poder crescer sem necessidade de grandes investimentos. O Postgres é um projeto open source (código aberto), o que exclui a necessidade de pagamento por licenças de uso. É necessário somente custos com infraestrutura para alocar o SGBD.
