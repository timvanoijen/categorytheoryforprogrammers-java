package nl.timocode.categorytheoryforprogrammers.chapter1;

import nl.timocode.categorytheoryforprogrammers.Challenge;
import nl.timocode.categorytheoryforprogrammers.OutputWriter;

import java.util.function.UnaryOperator;

public class Challenge1_1 implements Challenge {

    @Override
    public int getChapter() {
        return 1;
    }

    @Override
    public int getChallengeNumber() {
        return 1;
    }

    @Override
    public void run(OutputWriter outputWriter) {
        UnaryOperator<String> identityString = this::identity;
        outputWriter.writeOutput(identityString.apply("MyInvariant"));
    }

    <T> T identity(T x) {
        return x;
    }
}
