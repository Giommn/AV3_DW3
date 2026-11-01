# AutoManager

API REST da ATVIII para gerenciamento de empresas de manutenção veicular, usuários, veículos, mercadorias, serviços e vendas. O modelo segue as entidades do projeto-base fornecido no PDF e expõe os recursos com Spring Data REST e HAL/HATEOAS.

## Tecnologias

- Java 17
- Spring Boot 3.3.5
- Spring Data JPA e Spring Data REST
- H2 em modo arquivo
- Jakarta Bean Validation

## Executar

Com Java 17 e Maven instalados:

```bash
mvn spring-boot:run
```

A API fica em `http://localhost:8080/api`. O banco persiste em `./data/automanager`. O console H2 fica em `http://localhost:8080/h2-console`, com JDBC URL `jdbc:h2:file:./data/automanager`, usuário `sa` e senha vazia.

## Endpoints CRUD e HATEOAS

| Recurso | Endpoint | Descrição |
|---|---|---|
| Empresas | `/api/empresas` | Unidade comercial, endereço, telefones, usuários, mercadorias, serviços e vendas |
| Usuários | `/api/usuarios` | Nome, nome social, perfis, contatos, documentos, credenciais, veículos e empresa |
| Telefones | `/api/telefones` | DDD e número; associação com empresa ou usuário |
| E-mails | `/api/emails` | Endereço de e-mail associado ao usuário |
| Documentos | `/api/documentos` | Tipo, data de emissão e número único |
| Endereços | `/api/enderecos` | Endereço completo de empresa ou usuário |
| Mercadorias | `/api/mercadorias` | Validade, fabricação, cadastro, quantidade, valor, empresa e fornecedor |
| Serviços | `/api/servicos` | Nome, valor, descrição e empresa responsável |
| Veículos | `/api/veiculos` | Tipo, modelo, placa, proprietário e vendas |
| Vendas | `/api/vendas` | Identificação, cliente, funcionário, veículo, itens e empresa |
| Credenciais | `/api/credenciais` | Consulta da hierarquia de credenciais |
| Credencial usuário/senha | `/api/credenciais-usuario-senha` | Nome de usuário único e hash de senha |
| Credencial código de barras | `/api/credenciais-codigo-barras` | Código único |

As coleções concretas oferecem `GET` e `POST`; cada item dessas coleções oferece `GET`, `PUT`, `PATCH` e `DELETE`. A coleção `/api/credenciais` é somente consulta (`GET` na coleção e no item), pois `Credencial` é abstrata. As respostas HAL incluem links para navegação e associação. Para os relacionamentos, siga os links `.../{id}/{associacao}` retornados pela API. Associações são atualizadas com `PUT`, `Content-Type: text/uri-list` e o URI do recurso relacionado no corpo. Em coleções, o `PUT` associa os itens informados; para remover um vínculo, exclua o recurso filho. Para credenciais, use os endpoints concretos `/api/credenciais-usuario-senha/{id}/usuario` e `/api/credenciais-codigo-barras/{id}/usuario`.

## Tipos e perfis

Os perfis de usuário aceitos são `CLIENTE`, `FUNCIONARIO` e `FORNECEDOR`. Tipos de documento: `CPF`, `CNPJ`, `RG`, `CNH` e `PASSAPORTE`. Tipos de veículo: `HATCH`, `SEDA`, `SUV`, `PICKUP` e `SW`.

O usuário pode ter mais de um perfil, como definido no modelo do diagrama. Os enums são persistidos como texto.

## Exemplo: empresa, usuário e associação

Crie a empresa:

```bash
curl -i -X POST http://localhost:8080/api/empresas \
  -H 'Content-Type: application/json' \
  -d '{"razaoSocial":"AutoManager Serviços Ltda.","nomeFantasia":"AutoManager Centro Automotivo","cadastro":"2026-11-01T10:00:00"}'
```

Crie um usuário com perfil de funcionário:

```bash
curl -i -X POST http://localhost:8080/api/usuarios \
  -H 'Content-Type: application/json' \
  -d '{"nome":"Ana Silva","perfis":["FUNCIONARIO"]}'
```

Associe o usuário à empresa. Substitua os IDs pelos valores criados:

```bash
curl -i -X PUT http://localhost:8080/api/usuarios/1/empresa \
  -H 'Content-Type: text/uri-list' \
  --data 'http://localhost:8080/api/empresas/1'
```

## Credenciais

Crie a credencial de usuário/senha pelo endpoint `/api/credenciais-usuario-senha` já vinculada ao usuário, informando `usuario` no corpo. Envie `senhaHash` como hash BCrypt. A senha nunca é incluída nas respostas da API.

```bash
curl -i -X POST http://localhost:8080/api/credenciais-usuario-senha \
  -H 'Content-Type: application/json' \
  -d '{"criacao":"2026-11-01T10:00:00","inativo":false,"nomeUsuario":"ana.silva","senhaHash":"$2a$10$substitua-por-um-hash-bcrypt","usuario":{"id":1}}'
```

Para trocar o usuário da credencial, use `PUT /api/credenciais-usuario-senha/{id}/usuario` com `Content-Type: text/uri-list` e o URI do novo usuário.

Para criar telefones, e-mails, documentos ou credenciais, envie também o `usuario` (ou `empresa`, no caso de telefone) com o ID no corpo. O `endereco` pode ser enviado aninhado no usuário ou na empresa.

## Entidades implementadas

O modelo contempla `Empresa`, `Usuario`, `Telefone`, `Email`, `Documento`, `Endereco`, `Mercadoria`, `Servico`, `Veiculo`, `Venda`, `Credencial`, `CredencialUsuarioSenha` e `CredencialCodigoBarra`, além dos enums `PerfilUsuario`, `TipoDocumento` e `TipoVeiculo`. O modelo mantém os relacionamentos do diagrama e acrescenta validações de campos obrigatórios e unicidade nos identificadores relevantes. Campos obrigatórios ausentes ou inválidos retornam `400`, e violações de unicidade retornam `409`.
