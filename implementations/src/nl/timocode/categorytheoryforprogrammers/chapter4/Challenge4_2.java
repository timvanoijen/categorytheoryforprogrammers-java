package nl.timocode.categorytheoryforprogrammers.chapter4;

import nl.timocode.categorytheoryforprogrammers.Challenge;
import nl.timocode.categorytheoryforprogrammers.OutputWriter;

import java.util.Optional;

public class Challenge4_2 implements Challenge {

    @Override
    public int getChapter() {
        return 4;
    }

    @Override
    public int getChallengeNumber() {
        return 2;
    }

    @Override
    public void run(OutputWriter outputWriter) {
        outputWriter.writeOutput(safe_reciprocal(3).toString());
        outputWriter.writeOutput(safe_reciprocal(0).toString());
    }

    private Optional<Double> safe_reciprocal(double x) {
        return x != 0 ? Optional.of(1/x) : Optional.empty();
    }
}
