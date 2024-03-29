CREATE TABLE "cao" (
  "id" bigint GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "nome" text NOT NULL,
  "cor" text NOT NULL,
  "data_nascimento" date NOT NULL,
  "localizacao" point NOT NULL,
  "id_genero" smallserial NOT NULL,
  "created_at" timestamp DEFAULT (now()),
  "updated_at" timestamp DEFAULT (now())
);

CREATE TABLE "genero" (
  "id" smallserial PRIMARY KEY,
  "descricao" text NOT NULL
);

CREATE TABLE "plano_ensino" (
  "id_cao" bigint PRIMARY KEY,
  "descricao" text
);

CREATE TABLE "tutor_cao" (
  "id" BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "id_cao" bigint NOT NULL,
  "id_usuario" bigint NOT NULL,
  "id_situacao_tutor_cao" smallserial NOT NULL,
  "created_at" timestamp DEFAULT (now()),
  "updated_at" timestamp DEFAULT (now())
);

CREATE TABLE "situacao_tutor_cao" (
  "id" smallserial PRIMARY KEY,
  "descricao" text NOT NULL
);

CREATE TABLE "evento" (
  "id" BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "id_tipo_evento" bigint NOT NULL,
  "descricao" text NOT NULL,
  "data" timestamp NOT NULL,
  "notificar_tutor" boolean NOT NULL,
  "id_cao" smallserial NOT NULL,
  "created_at" timestamp DEFAULT (now()),
  "updated_at" timestamp DEFAULT (now())
);

CREATE TABLE "tipo_evento" (
  "id" smallserial PRIMARY KEY,
  "descricao" text NOT NULL
);

CREATE TABLE "usuario" (
  "id" BIGINT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
  "nome" text NOT NULL,
  "email" text NOT NULL, -- create unique index below
  "cpf" character(11) NOT NULL, -- create unique index below
  "password" text NOT NULL,
  "data_nascimento" date NOT NULL,
  "telefone_celular" text NOT NULL,
  "telefone_fixo" text,
  "ativo" boolean NOT NULL DEFAULT TRUE,
  "created_at" timestamp DEFAULT (now()),
  "updated_at" timestamp DEFAULT (now())
);

-- CREATE TABLE "perfil" (
--   "id" smallserial GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
--   "nome" text NOT NULL,
--   "descricao" text NOT NULL,
--   "created_at" timestamp DEFAULT (now()),
--   "updated_at" timestamp DEFAULT (now())
-- );

-- CREATE TABLE "perfil_usuario" (
--   "id_usuario" bigint,
--   "id_perfil" int,
--   PRIMARY KEY ("id_usuario", "id_perfil")
-- );

-- CREATE TABLE "permissao" (
--   "id" INT GENERATED BY DEFAULT AS IDENTITY PRIMARY KEY,
--   "nome" text NOT NULL,
--   "descricao" text NOT NULL,
--   "created_at" timestamp DEFAULT (now()),
--   "updated_at" timestamp DEFAULT (now())
-- );

-- CREATE TABLE "permissao_perfil" (
--   "id_perfil" int,
--   "id_permissao" int,
--   PRIMARY KEY ("id_perfil", "id_permissao")
-- );

COMMENT ON TABLE "tutor_cao" IS 'Estrutura para de relação entre um usuário e um cao. Esta relação possui uma situação ativa ou inativa, sendo que poderá existir somente uma relação ativa por vez entre cao e usuário.';

COMMENT ON TABLE "situacao_tutor_cao" IS 'Representa a situação atual da relação do tutor com o cão, podendo esta relação estar ativa ou inativa.';

COMMENT ON TABLE "evento" IS 'O campo "data" representa qual a data do evento, devendo o próprio usuário informá-la. Quando for exibido em formato de notificação para o tutor, basta buscar os eventos >= data atual. Quando for exibido em histórico basta buscar todos os eventos.';

COMMENT ON TABLE "usuario" IS 'Email e cpf poderão ser utilizados como login, pois são chaves únicas.';

ALTER TABLE "cao" ADD FOREIGN KEY ("id_genero") REFERENCES "genero" ("id");

ALTER TABLE "plano_ensino" ADD FOREIGN KEY ("id_cao") REFERENCES "cao" ("id");

ALTER TABLE "tutor_cao" ADD FOREIGN KEY ("id_cao") REFERENCES "cao" ("id");

ALTER TABLE "tutor_cao" ADD FOREIGN KEY ("id_usuario") REFERENCES "usuario" ("id");

ALTER TABLE "tutor_cao" ADD FOREIGN KEY ("id_situacao_tutor_cao") REFERENCES "situacao_tutor_cao" ("id");

ALTER TABLE "evento" ADD FOREIGN KEY ("id_tipo_evento") REFERENCES "tipo_evento" ("id");

ALTER TABLE "evento" ADD FOREIGN KEY ("id_cao") REFERENCES "cao" ("id");

CREATE UNIQUE INDEX unique_email_on_usuario ON usuario (lower(email));
CREATE UNIQUE INDEX unique_cpf_on_usuario ON usuario (cpf);

-- ALTER TABLE "perfil_usuario" ADD FOREIGN KEY ("id_usuario") REFERENCES "usuario" ("id");

-- ALTER TABLE "perfil_usuario" ADD FOREIGN KEY ("id_perfil") REFERENCES "perfil" ("id");

-- ALTER TABLE "permissao_perfil" ADD FOREIGN KEY ("id_perfil") REFERENCES "perfil" ("id");

-- ALTER TABLE "permissao_perfil" ADD FOREIGN KEY ("id_permissao") REFERENCES "permissao" ("id");

-- Cargas iniciais
insert into genero(descricao) values('Masculino');
insert into genero(descricao) values('Feminino');

insert into situacao_tutor_cao(descricao) values ('Ativo');
insert into situacao_tutor_cao(descricao) values ('Inativo');