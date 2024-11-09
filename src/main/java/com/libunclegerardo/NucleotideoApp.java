package com.libunclegerardo;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NucleotideoApp {

    public static void main(String[] args) {
        // Verifica se os argumentos são válidos
        if (args.length != 2) {
            System.out.println("Uso correto: java -jar <jar-file> size:<numero-inteiro> output:<nome-do-arquivo>.txt");
            return;
        }

        // Extraí os parâmetros da linha de comando
        int size = 0;
        String outputFileName = null;
        for (String arg : args) {
            if (arg.startsWith("size:")) {
                try {
                    size = Integer.parseInt(arg.substring(5));  // Pega o número após "size:"
                } catch (NumberFormatException e) {
                    System.out.println("Tamanho inválido.");
                    return;
                }
            } else if (arg.startsWith("output:")) {
                outputFileName = arg.substring(7);  // Pega o nome do arquivo após "output:"
            }
        }

        if (size <= 0 || outputFileName == null) {
            System.out.println("Por favor, forneça parâmetros válidos.");
            return;
        }

        // Cria a sequência aleatória
        NucleotideoRandomGenerator generator = new RandomSequenceGenerator();
        String sequence = generator.generate(size);

        // Exibe a entrada e a saída no terminal
        System.out.println("entrada: " + size);
        System.out.println("saída: " + sequence);

        // Salva a sequência em um arquivo de texto
        try (FileWriter writer = new FileWriter(new File(outputFileName))) {
            writer.write(sequence);
            System.out.println("Sequência salva no arquivo " + outputFileName);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}
