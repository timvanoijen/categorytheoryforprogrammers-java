package nl.timocode.categorytheoryforprogrammers.chapter1;

import nl.timocode.categorytheoryforprogrammers.Challenge;
import nl.timocode.categorytheoryforprogrammers.OutputWriter;

import java.util.function.Function;
import java.util.stream.IntStream;

public class Challenge1_3 implements Challenge {

    @Override
    public int getChapter() {
        return 1;
    }

    @Override
    public int getChallengeNumber() {
        return 3;
    }

    @Override
    public void run(OutputWriter outputWriter) {
        Function<Integer,String> f = Integer::toBinaryString;
        Function<Integer,String> f2 = compose(f, this::identity);
        boolean match = IntStream.range(0, 100).allMatch(i -> f.apply(i).equals(f2.apply(i)));
        outputWriter.writeOutput(match ? "Composition respects identity" : "Composition does not respect identity");
    }

    <T> T identity(T x) {
        return x;
    }

    <A,B,C> Function<A,C> compose(Function<A,B> f, Function<B,C> g) {
        return a -> g.apply(f.apply(a));
    }
}
