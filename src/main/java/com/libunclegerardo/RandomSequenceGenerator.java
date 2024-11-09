package com.libunclegerardo;

import java.util.Random;

public class RandomSequenceGenerator implements NucleotideoRandomGenerator {

    // Definir o conjunto de nucleotídeos possíveis
    private static final char[] NUCLEOTIDE_CHOICES = {'A', 'C', 'G', 'T'};

    @Override
    public String generate(int sequenceSize) {
        // Cria um objeto Random para gerar números aleatórios
        Random random = new Random();

        StringBuilder sequence = new StringBuilder(sequenceSize);

        // Gera a sequência aleatória
        for (int i = 0; i < sequenceSize; i++) {
            char randomNucleotide = NUCLEOTIDE_CHOICES[random.nextInt(NUCLEOTIDE_CHOICES.length)];
            sequence.append(randomNucleotide);
        }

        return sequence.toString();
    }
}
