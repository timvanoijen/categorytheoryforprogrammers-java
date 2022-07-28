# Category Theory For Programmers - challenges solved in Java
My answers (so far) to challenges of the book Category Theory For Programmers From Bartosz Milewski.

## Chapter 1

![image](https://user-images.githubusercontent.com/11744276/181304279-538ff9b0-61b7-4ba9-9e39-38174b09bb64.png)

### Answers
1. 
```
    <T> T identity(T x) {
        return x;
    }
```
2.
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

## Chapter 2
![image](https://user-images.githubusercontent.com/11744276/181350302-60b33fc9-9e90-41e6-bd74-22b04ad262d8.png)
![image](https://user-images.githubusercontent.com/11744276/181350444-028296dd-1323-417c-b371-4c5bdd989096.png)

### Answers
1.
```
<A,B> Function<A,B> memoize(Function<A,B> f) {
    Map<A, B> cache = new ConcurrentHashMap<>();
    return a -> cache.computeIfAbsent(a, f::apply);
}
```
2. This doesn't work since the same value will be returned on every call.
3. This doesn't work since the same value will be returned on every call.
4. 
a) Pure function. Can be memoized.
b) Dirty function (different output on same input). The memoized function will keep returning the character that was typed when the function was called for the first time.
c) Dirty function (side-effect). The memoized function will only output "Hello" the first time the function is called.
d) Dirty function (side-effect, modifying a local static variable). The memoized function will only increment its previous output when it is called with a value which has not been used before.

5.
```
Function<Boolean, Boolean> f1 = b -> true;
Function<Boolean, Boolean> f2 = b -> false;
Function<Boolean, Boolean> f3 = b -> b;
Function<Boolean, Boolean> f4 = b -> !b;
```
6. 
![image](https://user-images.githubusercontent.com/11744276/181492889-e2c51e99-32da-4185-a0ab-ab8f5dc562e5.png)


