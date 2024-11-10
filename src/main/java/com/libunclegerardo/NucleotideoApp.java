package com.libunclegerardo;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NucleotideoApp {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Uso correto: java -jar target/libunclegerardo-1.0-SNAPSHOT.jar size:<numero-inteiro> output:<nome-do-arquivo>.txt");
            return;
        }
        int size = 0;
        String outputFileName = null;
        for (String arg : args) {
            if (arg.startsWith("size:")) {
                try {
                    size = Integer.parseInt(arg.substring(5));
                } catch (NumberFormatException e) {
                    System.out.println("Tamanho inválido.");
                    return;
                }
            } else if (arg.startsWith("output:")) {
                outputFileName = arg.substring(7);
            }
        }
        if (size <= 0 || outputFileName == null) {
            System.out.println("Por favor, forneça parâmetros válidos.");
            return;
        }
        NucleotideoRandomGenerator generator = new RandomSequenceGenerator();
        String sequence = generator.generate(size);
        System.out.println("Entrada: " + size);
        System.out.println("Saída: " + sequence);
        try (FileWriter writer = new FileWriter(new File(outputFileName))) {
            writer.write(sequence);
            System.out.println("Sequência salva no arquivo " + outputFileName);
        } catch (IOException e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }
}
