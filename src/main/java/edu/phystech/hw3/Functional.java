package edu.phystech.hw3;

import java.util.List;
import java.util.ArrayList;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class Functional {

    public static <T, R> List<R> map(List<? extends T> collection, Function<? super T, ? extends R> function) {
        List<R> ans = new ArrayList<>();
        for (T item : collection) {
            ans.add(function.apply(item));
        }
        return ans;
    }

    public static <T, R> T reduce(List<T> collection, BinaryOperator<T> operator, T identity) {
        T ans = identity;
        for (T item : collection) {
            ans = operator.apply(ans, item);
        }
        return ans;
    }
}




