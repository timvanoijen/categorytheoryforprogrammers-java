# categorytheoryforprogrammers-java
My answers to challenges of the book Category Theory For Programmers From Bartosz Milewski

## Chapter 1

![image](https://user-images.githubusercontent.com/11744276/181304279-538ff9b0-61b7-4ba9-9e39-38174b09bb64.png)

### Answers
1. The identity function in Java
```
    <T> T identity(T x) {
        return x;
    }
```

2. Composition in Java
```
    <A,B,C> Function<A,C> compose(Function<A,B> f, Function<B,C> g) {
        return a -> g.apply(f.apply(a));
    }
```

3.
```
    public void run(OutputWriter outputWriter) {
        Function<Integer,String> f = Integer::toBinaryString;
        Function<Integer,String> f2 = compose(f, this::identity);
        boolean match = IntStream.range(0, 100).allMatch(i -> f.apply(i).equals(f2.apply(i)));
        outputWriter.writeOutput(match ? "Composition respects identity" : "Composition does not respect identity");
    }
```

4. Websites can be represented as objects. If site B can be reached from site A, following hyperlinks, an arrow (morphism) van be placed between these two objects. Site A is trivially reachable from site A, so an identity morphism is present. Reachability is associative, so the worls-wide-web can be modelled as a category.
5. Facebook can be represented as a category. People are represented as objects, direct and indirect friendships can be represented as arrows (morphisms). Friendship relations are associative. Assuming that people are friends with themselves gives us the identity morphism.
6. A directed graph is a category when there is a direct edge connecting node A and node B in case node B is reachable from node A. 
