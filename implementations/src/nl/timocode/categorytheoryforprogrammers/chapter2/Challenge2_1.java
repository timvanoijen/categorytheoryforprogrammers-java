package nl.timocode.categorytheoryforprogrammers.chapter2;

import nl.timocode.categorytheoryforprogrammers.Challenge;
import nl.timocode.categorytheoryforprogrammers.OutputWriter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.LongStream;

public class Challenge2_1 implements Challenge {

    @Override
    public int getChapter() {
        return 2;
    }

    @Override
    public int getChallengeNumber() {
        return 1;
    }

    @Override
    public void run(OutputWriter outputWriter) {
        Function<Long,Long> f = i -> LongStream.range(0, i).sum();
        Function<Long,Long> fMem = memoize(f);

        long n = 99999999L;
        Runnable r = () -> {
            long begin = System.currentTimeMillis();
            long result = fMem.apply(n);
            outputWriter.writeOutput(String.format("Result = %d, duration = %d ms",
                    result, System.currentTimeMillis() - begin));
        };

        r.run();
        r.run();
    }

    private <A,B> Function<A,B> memoize(Function<A,B> f) {
        Map<A, B> cache = new ConcurrentHashMap<>();
        return a -> cache.computeIfAbsent(a, f);
    }
}
