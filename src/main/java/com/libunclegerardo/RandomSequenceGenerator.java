package com.libunclegerardo;
import java.util.Random;

public class RandomSequenceGenerator implements NucleotideoRandomGenerator {
    private static final char[] NUCLEOTIDE_CHOICES = {'A', 'C', 'G', 'T'};
    @Override
    public String generate(int sequenceSize) {
        Random random = new Random();
        StringBuilder sequence = new StringBuilder(sequenceSize);
        for (int i = 0; i < sequenceSize; i++) {
            char randomNucleotide = NUCLEOTIDE_CHOICES[random.nextInt(NUCLEOTIDE_CHOICES.length)];
            sequence.append(randomNucleotide);
        }
        return sequence.toString();
    }
}
