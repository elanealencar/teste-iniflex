# Teste Prático de Programação - Iniflex

Projeto desenvolvido em Java como parte do teste prático de programação da Iniflex.

A aplicação realiza o cadastro e processamento de uma lista de funcionários, utilizando conceitos de orientação a objetos, coleções, manipulação de datas, `BigDecimal`, `Map` e Streams.

## Funcionalidades

O projeto contempla os requisitos propostos no teste:

- Cadastro dos funcionários conforme os dados fornecidos;
- Remoção do funcionário João da lista;
- Exibição dos funcionários com datas e valores formatados;
- Aplicação de reajuste salarial de 10%;
- Agrupamento dos funcionários por função;
- Exibição dos funcionários agrupados por função;
- Identificação dos aniversariantes dos meses 10 e 12;
- Identificação do funcionário com maior idade;
- Ordenação dos funcionários por ordem alfabética;
- Cálculo do total dos salários;
- Cálculo da quantidade de salários mínimos recebida por cada funcionário.

## Estrutura do projeto

```text
src/
├── Pessoa.java
├── Funcionario.java
└── Principal.java
```

- `Pessoa`: representa uma pessoa, contendo nome e data de nascimento.
- `Funcionario`: estende `Pessoa` e adiciona salário e função.
- `Principal`: contém a execução das operações solicitadas no teste.

## Tecnologias e recursos utilizados

- Java 24
- Orientação a Objetos
- Collections (`List` e `Map`)
- Stream API
- `LocalDate` e `Period`
- `BigDecimal`
- `Comparator`
- `DateTimeFormatter`
- `NumberFormat`

## Como executar

É necessário possuir um JDK compatível com o projeto.
O desenvolvimento e os testes foram realizados utilizando Java 24.

Na raiz do projeto, compile os arquivos:

```bash
javac -d out src/*.java
```

Em seguida, execute:

```bash
java -cp out Principal
```

## Autora

**Elane Alencar**

Desenvolvedora Full Stack

LinkedIn: [linkedin.com/in/elanealencar](https://www.linkedin.com/in/elanealencar/)