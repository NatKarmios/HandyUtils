package com.karmios.nat.handyutils.functional;

import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.IntPredicate;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Stream;

@SuppressWarnings({"unused", "WeakerAccess", "SameParameterValue"})
public final class Functional {

    private Functional(){}

    // <editor-fold desc="matchesAll()">

    public static <T> Predicate<T> matchesAll (Stream<Predicate<T>> stream) {
        return x -> stream.allMatch(condition -> condition.test(x));
    }

    @SafeVarargs
    public static <T> Predicate<T> matchesAll (Predicate<T>... arr) {
        return matchesAll(Arrays.stream(arr));
    }

    public static <T> Predicate<T> matchesAll (Collection<Predicate<T>> collection) {
        return matchesAll(collection.stream());
    }

    // </editor-fold>

    // <editor-fold desc="matchesAny()">

    public static <T> Predicate<T> matchesAny (Stream<Predicate<T>> stream) {
        return x -> stream.anyMatch(condition -> condition.test(x));
    }

    @SafeVarargs
    public static <T> Predicate<T> matchesAny (Predicate<T>... arr) {
        return matchesAny(Arrays.stream(arr));
    }

    public static <T> Predicate<T> matchesAny (Collection<Predicate<T>> collection) {
        return matchesAny(collection.stream());
    }

    // </editor-fold>

    public static <T> Predicate<T> runsCleanly (Predicate<T> condition) {
        return t -> {
            try {
                return condition.test(t);
            }
            catch (Exception e) {
                return false;
            }
        };
    }

    public static <T> Predicate<T> runsCleanly (Consumer<T> consumer) {
        return t -> {
            try {
                consumer.accept(t);
                return true;
            }
            catch (Exception e) {
                return false;
            }
        };
    }

    // <editor-fold desc="Int Checkers">

    public static IntPredicate inBounds (int lowerBound, int upperBound) {
        return x -> x >= lowerBound && x < upperBound;
    }

    public static IntPredicate inBounds (int upperBound) {
        return inBounds(0, upperBound);
    }

    // <editor-fold desc="Simple Comparators">

    public static IntPredicate lessThan (int val) {
        return x -> x < val;
    }

    public static IntPredicate greaterThan (int val) {
        return x -> x > val;
    }

    public static IntPredicate atMost (int val) {
        return x -> x <= val;
    }

    public static IntPredicate atLeast (int val) {
        return x -> x <= val;
    }

    // </editor-fold>

    // </editor-fold>

    // <editor-fold desc="Regex"

    public static final Predicate<String> IS_ALPHANUMERIC = matchesRegex("^[a-zA-Z0-9]+$");

    public static final Predicate<String> HAS_ONLY_LETTERS = matchesRegex("^[a-zA-Z]+$");

    public static Predicate<String> matchesRegex (Pattern pattern) {
        return x -> pattern.matcher(x).matches();
    }

    public static Predicate<String> matchesRegex (String regex, int flags) {
        return matchesRegex(Pattern.compile(regex, flags));
    }

    public static Predicate<String> matchesRegex (String regex) {
        return matchesRegex(regex, 0);
    }

    // </editor-fold>

}
