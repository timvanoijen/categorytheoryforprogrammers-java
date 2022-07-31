package nl.timocode.categorytheoryforprogrammers.chapter4;

import nl.timocode.categorytheoryforprogrammers.Challenge;
import nl.timocode.categorytheoryforprogrammers.OutputWriter;

import java.util.Optional;
import java.util.function.Function;

public class Challenge4_3 implements Challenge {

    @Override
    public int getChapter() {
        return 4;
    }

    @Override
    public int getChallengeNumber() {
        return 3;
    }

    @Override
    public void run(OutputWriter outputWriter) {
        Function<Double,Optional<Double>> safe_root_reciprocal = compose(this::safe_root, this::safe_reciprocal);
        outputWriter.writeOutput(safe_root_reciprocal.apply(-1.0).toString());
        outputWriter.writeOutput(safe_root_reciprocal.apply(0.0).toString());
        outputWriter.writeOutput(safe_root_reciprocal.apply(4.0).toString());
    }

    private Optional<Double> safe_root(double x) {
        return x >= 0 ? Optional.of(Math.sqrt(x)) : Optional.empty();
    }

    private Optional<Double> safe_reciprocal(double x) {
        return x != 0 ? Optional.of(1/x) : Optional.empty();
    }

    private <A,B,C> Function<A,Optional<C>> compose(Function<A,Optional<B>> f, Function<B,Optional<C>> g) {
        return a -> {
            Optional<B> fa = f.apply(a);
            return fa.isEmpty() ? Optional.empty() : g.apply(fa.get());
        };
    }
}
