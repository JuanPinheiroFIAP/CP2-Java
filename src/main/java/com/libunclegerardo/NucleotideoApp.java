package com.libunclegerardo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Arrays;
import java.util.Optional;

public class NucleotideoApp {
    // Prefixos para identificar os parâmetros de tamanho e saída
    private static final String SIZE_PREFIX = "size:";
    private static final String OUTPUT_PREFIX = "output:";

    public static void main(String[] args) {
        try {
            // Valida os argumentos de entrada e executa a geração de sequência
            validateAndRun(args);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            printUsage(); // Mostra instruções de uso em caso de erro
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    private static void validateAndRun(String[] args) throws IOException {
        // Verifica se o número de argumentos é exatamente 2
        if (args.length != 2) {
            throw new IllegalArgumentException("Número incorreto de argumentos.");
        }

        // Faz o parsing dos parâmetros
        Parameters params = parseParameters(args);
        NucleotideoSequenceGenerator generator = new NucleotideoSequenceGeneratorImpl();
        String sequence = generator.generateSequence(params.getSize());

        // Mostra a entrada e a sequência gerada no console
        System.out.println("Entrada: " + params.getSize());
        System.out.println("Saída: " + sequence);

        // Salva a sequência gerada em um arquivo especificado
        saveToFile(sequence, params.getOutputFile());
        System.out.println("Sequência salva no arquivo " + params.getOutputFile());
    }

    private static Parameters parseParameters(String[] args) {
        // Encontra e converte o argumento de tamanho
        Optional<Integer> size = Arrays.stream(args)
                .filter(arg -> arg.startsWith(SIZE_PREFIX))
                .map(arg -> parseSize(arg))
                .findFirst();

        // Encontra e obtém o nome do arquivo de saída
        Optional<String> outputFile = Arrays.stream(args)
                .filter(arg -> arg.startsWith(OUTPUT_PREFIX))
                .map(arg -> arg.substring(OUTPUT_PREFIX.length()))
                .findFirst();

        // Verifica se os parâmetros são válidos
        if (size.isEmpty() || outputFile.isEmpty()) {
            throw new IllegalArgumentException("Parâmetros inválidos ou ausentes.");
        }

        return new Parameters(size.get(), outputFile.get());
    }

    private static int parseSize(String sizeArg) {
        try {
            int size = Integer.parseInt(sizeArg.substring(SIZE_PREFIX.length()));
            if (size <= 0) {
                throw new IllegalArgumentException("Tamanho deve ser maior que zero.");
            }
            return size;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Tamanho inválido.");
        }
    }

    private static void saveToFile(String content, String fileName) throws IOException {
        Path path = Paths.get(fileName);
        Files.writeString(path, content);
    }

    private static void printUsage() {
        System.out.println("Uso correto: java -jar target/libunclegerardo-1.0-SNAPSHOT.jar size:<numero-inteiro> output:<nome-do-arquivo>.txt");
    }
}

// Classe para armazenar os parâmetros de entrada
class Parameters {
    private final int size; // Tamanho da sequência de nucleotídeos
    private final String outputFile; // Nome do arquivo de saída

    public Parameters(int size, String outputFile) {
        this.size = size;
        this.outputFile = outputFile;
    }

    public int getSize() {
        return size;
    }

    public String getOutputFile() {
        return outputFile;
    }
}
