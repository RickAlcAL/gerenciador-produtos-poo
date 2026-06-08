# 📦 Sistema de Gerenciamento e Precificação de Produtos

Este é um sistema de terminal desenvolvido em Java projetado para gerenciar e calcular etiquetas de preço (*price tags*) de diferentes categorias de produtos de forma dinâmica. O projeto foi estruturado simulando um ambiente real de persistência em memória (banco de dados fictício).

## 🛠️ Tecnologias, Conceitos e Paradigmas

* **Linguagem:** Java (Java SE)
* **Paradigma:** Programação Orientada a Objetos (POO)
* **Pilares de POO Aplicados:**
    * **Herança:** Reutilização de estrutura da classe base `Product` para as subclasses especializadas `ImportedProduct` e `UsedProduct`.
    * **Polimorfismo:** Uso de herança dinâmica onde a coleção armazena o tipo genérico, mas invoca o comportamento específico de cada classe filha via `@Override`.
    * **Encapsulamento:** Atributos privados protegidos por métodos acessores (*getters* e *setters*).
* **Estrutura de Dados:** Uso da API de coleções (`List` e `ArrayList`) para gerenciamento dinâmico de objetos.
* **Controle de Fluxo e Estados:** Centralização de mensagens de feedback de sistema utilizando `Enums`.
* **Tratamento de Exceções:** Bloqueio e tratamento de falhas de entrada com `try-catch` na conversão de formatos de data (`SimpleDateFormat`).

---

## 🎯 Funcionalidades

* **Cadastro Multi-Categorias:**
    * **Produto Comum:** Registro básico com nome e preço de custo.
    * **Produto Usado:** Exibe a etiqueta acrescida da data de fabricação formatada no padrão brasileiro (`dd/MM/yyyy`).
    * **Produto Importado:** Calcula automaticamente a taxa alfandegária (*customs fee*) e exibe o valor final unificado.
* **Polimorfismo na Prática:** O loop final varre a lista genérica invocando o método `.priceTag()`, gerando saídas de texto personalizadas em tempo de execução de acordo com o tipo real do objeto instanciado.

---

## 📁 Estrutura de Pacotes (Arquitetura)

O projeto adota uma arquitetura modular baseada em responsabilidades:

```text
src/
└── main/
    └── java/
        ├── Applications/
        │   ├── Main/        # Ponto de entrada (Bootstrapping do sistema)
        │   └── Menu/        # Camada de interface de usuário (I/O) e controle
        └── Entities/
            ├── Enums/       # Dicionário de estados e mensagens fixas (Avisos)
            ├── Product/     # Classe base (Modelo abstrato/concreto de produto)
            ├── ImportProduct/# Especialização para produtos tributados
            └── UsedProduct/ # Especialização para produtos com depreciação cronológica
