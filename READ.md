# Checkpoint 2 

## Integrantes do Grupo
- Nome:**Lucca Alexandre**                          RM:**99700**
- Nome:**Juan Pinheiro de França**                  RM:**552202**
- Nome:**Vitor da Silva Santana**                   RM:**99586**
- Nome:**Victor Augusto Wittner**                   RM:**98667**

## Descrição

O programa gera uma sequência aleatória de nucleotídeos (A, C, T, G) com um tamanho especificado pelo usuário. 
A sequência gerada é salva em um arquivo de texto, cujo nome também é especificado nos parâmetros de entrada.

## Funcionalidade

- **Geração de Sequência Aleatória**: O programa gera uma sequência de nucleotídeos com o tamanho definido pelo usuário.
- **Saída em Arquivo**: A sequência gerada é salva em um arquivo de texto cujo nome é fornecido pelo usuário.
- **Validação de Parâmetros**: O programa valida a entrada do usuário, garantindo que os parâmetros fornecidos sejam corretos (tamanho positivo para a sequência e nome do arquivo de saída).

## Como Usar

Para rodar o aplicativo, use o seguinte comando no terminal:

```bash
java -jar target/libunclegerardo-1.0-SNAPSHOT.jar size:<numero-inteiro> output:<nome-do-arquivo>.txt
```

### Parâmetros de Entrada

1. **`size:<numero-inteiro>`**: Define o tamanho da sequência de nucleotídeos que será gerada. O número deve ser um inteiro positivo.
2. **`output:<nome-do-arquivo>.txt`**: Define o nome do arquivo onde a sequência será salva.

### Exemplo

```bash
java -jar target/libunclegerardo-1.0-SNAPSHOT.jar size:100 output:sequencia.txt
```

Esse comando irá gerar uma sequência de 100 nucleotídeos e salvar no arquivo `sequencia.txt`.

## Estrutura do Projeto

- **`NucleotideoApp.java`**: Classe principal, responsável pela validação dos parâmetros, geração da sequência e salvamento no arquivo.
- **`NucleotideoSequenceGenerator.java`**: Interface que define o contrato para a geração de sequências de nucleotídeos.
- **`NucleotideoSequenceGeneratorImpl.java`**: Implementação da interface `NucleotideoSequenceGenerator`, que gera a sequência aleatória de nucleotídeos.
- **`Parameters.java`**: Classe que armazena os parâmetros de entrada (tamanho da sequência e nome do arquivo de saída).
