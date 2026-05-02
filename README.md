# Gerenciador de Descontos

Um sistema de terminal desenvolvido em Java puro para solucionar o problema de precificação dinâmica em lojas. Ele permite a aplicação de uma taxa promocional global instantânea, sem a necessidade de iterar sobre cada produto individualmente na memória.

## Conceitos Aplicados

Durante o desenvolvimento deste projeto, foram aplicados os seguintes pilares da Orientação a Objetos e recursos do Java:

*   **Encapsulamento**: Proteção dos dados da classe `Produto` através de modificadores de acesso (`private`) e métodos Getters/Setters.
*   **Atributos Estáticos (`static`)**: Diferenciação prática entre atributos de instância (nome, preço individual) e de classe (desconto global compartilhado).
*   **Estruturas de Dados**: Gerenciamento de coleções de objetos utilizando `List` e `ArrayList`.
*   **Expressões Lambda**: Utilização do método `removeIf` para remoção de itens na lista baseada em condições.
*   **Arquitetura**: Separação clara de responsabilidades dividindo o sistema em `model`, `service` e `main`.

## Como Executar

1. Clone este repositório na sua máquina.
2. Abra o projeto na sua IDE de preferência.
3. Execute a classe `Main.java` localizada no pacote `main`.
4. Interaja com o sistema através do menu no terminal.
