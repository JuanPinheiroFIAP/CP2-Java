package com.libunclegerardo;

import java.util.Random;

public class NucleotideoSequenceGeneratorImpl implements NucleotideoSequenceGenerator {
    // Array de caracteres representando os nucleotídeos possíveis.
    private static final char[] NUCLEOTIDES = {'A', 'C', 'T', 'G'};
    private final Random random; // Objeto Random para geração de números aleatórios.

    // Construtor da classe, inicializa o gerador de números aleatórios.
    public NucleotideoSequenceGeneratorImpl() {
        this.random = new Random();
    }

    @Override
    public String generateSequence(int size) {
        // Gera uma sequência de inteiros aleatórios no intervalo 0 - NUCLEOTIDES.length
        // e converte cada número em um nucleotídeo correspondente.
        return random.ints(size, 0, NUCLEOTIDES.length)
                .mapToObj(i -> String.valueOf(NUCLEOTIDES[i]))
                .reduce(new StringBuilder(), StringBuilder::append, StringBuilder::append)
                .toString(); // Retorna a sequência completa como String
    }
}
