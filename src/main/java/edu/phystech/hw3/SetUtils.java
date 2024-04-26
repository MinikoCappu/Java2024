package edu.phystech.hw3;

import java.util.Set;
import java.util.HashSet;

public class SetUtils {
    public static <E> Set<E> union(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> union = new HashSet<>(s1);
        union.addAll(s2);
        return union;
    }

    public static <E> Set<E> intersection(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> intersection = new HashSet<>(s1);
        intersection.retainAll(s2);
        return intersection;
    }

    public static <E> Set<E> difference(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> difference = new HashSet<>(s1);
        difference.removeAll(s2);
        return difference;
    }

    public static <E> Set<E> symmetricDifference(Set<? extends E> s1, Set<? extends E> s2) {
        Set<E> symmetricDifference = new HashSet<>(union(s1, s2));
        symmetricDifference.removeAll(intersection(s1, s2));
        return symmetricDifference;
    }
}
