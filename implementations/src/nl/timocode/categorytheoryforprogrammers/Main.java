package nl.timocode.categorytheoryforprogrammers;

import nl.timocode.categorytheoryforprogrammers.chapter1.Challenge1_1;
import nl.timocode.categorytheoryforprogrammers.chapter1.Challenge1_2;
import nl.timocode.categorytheoryforprogrammers.chapter1.Challenge1_3;
import nl.timocode.categorytheoryforprogrammers.chapter2.Challenge2_1;

import java.util.Arrays;
import java.util.List;

public class Main {

    private final static List<Challenge> challenges = Arrays.asList(
            new Challenge1_1(),
            new Challenge1_2(),
            new Challenge1_3(),
            new Challenge2_1()
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
