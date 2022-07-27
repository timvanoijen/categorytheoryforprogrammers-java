package nl.timocode.categorytheoryforprogrammers;

import nl.timocode.categorytheoryforprogrammers.chapter1.Challenge1_1;

import java.util.Arrays;
import java.util.List;

public class Main {

    private final static List<Challenge> challenges = Arrays.asList(
            new Challenge1_1()
    );

    public static void main(String[] args) {

        OutputWriter outputWriter = System.out::println;

        for(Challenge challenge : challenges) {
            outputWriter.writeOutput(String.format("---- Challenge %d.%d", challenge.getChapter(),
                    challenge.getChallengeNumber()));
            challenge.run(outputWriter);
        }
    }
}
