# categorytheoryforprogrammers-java
My answers to challenges of the book Category Theory For Programmers From Bartosz Milewski

## Chapter 1

![image](https://user-images.githubusercontent.com/11744276/181304279-538ff9b0-61b7-4ba9-9e39-38174b09bb64.png)

### Answers
1 The identity function in Java
```
    <T> T identity(T x) {
        return x;
    }
```

2  Composition in Java
```
    <A,B,C> Function<A,C> compose(Function<A,B> f, Function<B,C> g) {
        return a -> g.apply(f.apply(a));
    }
```
