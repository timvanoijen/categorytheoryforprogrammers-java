package nl.timocode.categorytheoryforprogrammers.chapter1;

import nl.timocode.categorytheoryforprogrammers.Challenge;
import nl.timocode.categorytheoryforprogrammers.OutputWriter;

import java.util.function.Function;

public class Challenge1_2 implements Challenge {

    @Override
    public int getChapter() {
        return 1;
    }

    @Override
    public int getChallengeNumber() {
        return 2;
    }

    @Override
    public void run(OutputWriter outputWriter) {
        Function<Integer,String> f = Integer::toBinaryString;
        Function<String,Integer> g = String::length;
        Function<Integer,Integer> numberOfBits = compose(f, g);
        outputWriter.writeOutput(String.format("Number of bits of %d is %d", 11, numberOfBits.apply(11)));
    }

    <A,B,C> Function<A,C> compose(Function<A,B> f, Function<B,C> g) {
        return a -> g.apply(f.apply(a));
    }
}
