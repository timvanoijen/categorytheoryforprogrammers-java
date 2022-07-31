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
   - (a) Pure function. Can be memoized.
   - (b) Dirty function (different output on same input). The memoized function will keep returning the character that was typed when the function was called for the first time.
   - (c) Dirty function (side-effect). The memoized function will only output "Hello" the first time the function is called.
   - (d) Dirty function (side-effect, modifying a local static variable). The memoized function will only increment its previous output when it is called with a value which has not been used before.

5.
```
Function<Boolean, Boolean> f1 = b -> true;
Function<Boolean, Boolean> f2 = b -> false;
Function<Boolean, Boolean> f3 = b -> b;
Function<Boolean, Boolean> f4 = b -> !b;
```
6. 
![image](https://user-images.githubusercontent.com/11744276/181492889-e2c51e99-32da-4185-a0ab-ab8f5dc562e5.png)

## Chapter 3
![image](https://user-images.githubusercontent.com/11744276/181926015-bb8bc6a1-0a0b-4b3c-b282-63b250dbde47.png)

### Answers
1.
   - (a) Add one edge from the single node to itself (identity).
   - (b) Assuming the existing edge is the identity morphism, we don't need to add anything. Otherwise the identity edge needs to be added and all self-compositions of the existing edge need to be added.
   - (c) Add an edge from the two nodes to themselves (identity).
   - (d) An edge needs to be added for each possible word that can be formed plus the identity edge.

2.
   - (a) A partial order
   - (b) A partial order

3. 
The Bool type with the operation AND is a monoid because the operation
   * is associative, because ```((x AND y) AND z) = (x AND (y AND z))```
   * has the identity element True, because ```(x AND True) = x```
   
The Bool type with the operation OR is a monoid because the operation
   * is associative, because ```((x OR y) OR z) = (x OR (y OR z))```
   * has the identity element False, because ```(x OR False) = x```

4. The Bool type with the operation AND can be represented as a set with the identity morphisms ```(Bool x) -> x AND True``` and the non-identity morphism ```(Bool x) -> x AND False``` which equals ```(Bool x) -> False```. With ```id = (Bool x) -> x AND True``` and ```f = (Bool x) -> False```, the rules of composition become:
   * ```id ∘ id = (Bool x) -> x AND True = id```
   * ```id ∘ f = (Bool x) -> False = f```
   * ```f ∘ id = (Bool x) -> False = f```
   * ```f ∘ f = (Bool x) -> False = f```

5. The monoid category of addition modulo 3 has three possible values for its object: 0, 1 and 2. The identity morphism equals ```id = (Integer i) -> i + 0```, because ```(i + 0) % 3 = i % 3```. The two other non-identity morphisms are ```f = (Integer i) -> (i + 1) % 3``` and ```g = (Integer i) -> (i + 2) % 3```. Composition of the morphisms is as follows:
   * ```id ∘ id = id```
   * ```id ∘ f = f```
   * ```id ∘ g = g```
   * ```f ∘ id = f```
   * ```f ∘ f = (Integer i) -> f((i + 1) % 3) = (Integer i) -> (i + 2) % 3 = g```
   * ```f ∘ g = (Integer i) -> f((i + 2) % 3) = (Integer i) -> (i + 3) % 3 = id```
   * ```g ∘ id = g```
   * ```g ∘ f = (Integer i) -> g((i + 1) % 3) = (Integer i) -> (i + 3) % 3 = id```
   * ```g ∘ g = (Integer i) -> g((i + 2) % 3) = (Integer i) -> (i + 4) % 3 = f```
 
## Chapter 4
![image](https://user-images.githubusercontent.com/11744276/182012572-bfe16b09-e090-470c-bc05-c3c4b2c204da.png)
![image](https://user-images.githubusercontent.com/11744276/182012586-cc430667-c9ad-48e6-aa41-8591ce8361ed.png)

### Answers
1. The Optional catory is defined as follows. Morphisms from type A to type B are defined as embellished functions that convert an element of type A to an element of ```Optional<B>```. The identity morphism is ```id = (A a) -> Optional<A>(a)```. Composition of functions f and g is defined as ```g(value(f(a))``` if ```isvalid(f(a))```, otherwise it is an invalid ```Optional<C>```, where ```Optional<C>``` is the result type of function g.
2. 
```
Optional<Double> safe_reciprocal(double x) {
    return x != 0 ? Optional.of(1/x) : Optional.empty();
}
```
3.
```
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
```

## Chapter 5
![image](https://user-images.githubusercontent.com/11744276/182038524-040744d3-beb6-451c-b37b-6d2635f186e6.png)
![image](https://user-images.githubusercontent.com/11744276/182038531-5b4f4a4f-dc0c-49a2-86ea-5a50bc7bf0bb.png)

### Answers
1. There is exactly one morphism from each object to the terminal object. Imagine two terminal objects t and t'. Since both objects are a terminal object, there is a morphism from f from t to t' and a morphism g from t' to t. The composition g ∘ f should be a morphism in the category as well and maps the object t on itself. Since t is a terminal object there is exactly one morphism from t to t, which is the identity morphism id. This implies that g ∘ f = id. Similarly, we can show that f ∘ g = id. Apparantly, the f and g are each others inverses, which proves that t and t' are isomorphic. Since f and g are unique, the isomorphism is unique as well. 
2. It is the largest object that is less than or equal to both objects (assuming that the direction of the morphism is a->b when a <= b)
3. It is the smallest object that is larger than or equal to both objects (assuming that the direction of the morphism is a->b when a <= b)
