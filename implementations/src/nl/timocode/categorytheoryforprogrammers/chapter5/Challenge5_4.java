package nl.timocode.categorytheoryforprogrammers.chapter5;

import nl.timocode.categorytheoryforprogrammers.Challenge;
import nl.timocode.categorytheoryforprogrammers.OutputWriter;

public class Challenge5_4 implements Challenge {

    @Override
    public int getChapter() {
        return 5;
    }

    @Override
    public int getChallengeNumber() {
        return 4;
    }

    @Override
    public void run(OutputWriter outputWriter) {
        Either<Integer, String> e1 = Either.newLeft(10);
        Either<Integer, String> e2 = Either.newRight("TEN");
        outputWriter.writeOutput(String.format("Either 1: %d", e1.left()));
        outputWriter.writeOutput(String.format("Either 2: %s", e2.right()));
    }

    static class Either<A,B> {

        private final A left;
        private final B right;

        public static <A,B> Either<A,B> newLeft(A left) {
            return new Either<>(left, null);
        }

        public static <A,B> Either<A,B> newRight(B right) {
            return new Either<>(null, right);
        }

        private Either(A left, B right) {
            this.left = left;
            this.right = right;
        }

        public A left() {
            return left;
        }

        public B right() {
            return right;
        }

        public boolean isLeft() {
            return left != null;
        }

        public boolean isRight() {
            return right != null;
        }
    }
}
