package com.hsbc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.LongStream;
import java.util.stream.Stream;

// https://dzone.com/articles/java-8-master-permutations
final class Permutations {

    private Permutations() {}

    /**
     * @param n at least zero and at most 20 (20! is the highest number that can be calculated in a long)
     */
    public static long factorial(final int n) {
        if (n > 20 || n < 0) {
            throw new IllegalArgumentException (n + "! can't be calculated");
        }
        return LongStream.rangeClosed(2, n).reduce(1, (a, b) -> a * b);
    }

    /**
     * @param no permutation's ordinal number starting from zero.
     * @return A single, predictable permutation of items that is consistently reproducible for the same input.
     * @throws IndexOutOfBoundsException if 'no' is negative, greater or equal to number of all possible permutations.
     * @throws NullPointerException if items is null.
     */
    public static <T> List<T> permutation(final long no, final List<T> items) {
        return permutationHelper(no,
                new LinkedList<>(Objects.requireNonNull(items)),	// Items will be removed from different positions
                new ArrayList<>(items.size()));
    }

    // At most 20 recursive calls
    private static <T> List<T> permutationHelper(final long no, LinkedList<T> in, List<T> out) {
        if (in.isEmpty()) {
            return out;
        }
        final long subFactorial = factorial(in.size() - 1);
        out.add(in.remove((int) (no / subFactorial)));
        return permutationHelper(no % subFactorial, in, out);
    }

    /**
     * @return Stream so that you can calculate them in parallel or lazily.
     * @throws NullPointerException if items is null.
     */
    public static <T> Stream<List<T>> allPermutations(final List<T> items) {
        return LongStream.range(0, factorial(items.size()))
                .mapToObj(no -> permutation(no, items));
    }
}
