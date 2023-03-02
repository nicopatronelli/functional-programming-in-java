package lambdas;

public interface Mapper<T,U> {
    U apply(T T);
}
