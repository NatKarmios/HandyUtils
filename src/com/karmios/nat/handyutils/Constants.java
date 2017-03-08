package com.karmios.nat.handyutils;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Random;
import java.util.function.DoublePredicate;
import java.util.function.IntPredicate;
import java.util.function.Predicate;

@SuppressWarnings({"WeakerAccess", "unused"})
public final class Constants {

    private Constants(){}

    public static final Random rng = new Random();

    // <editor-fold desc="Predicates">

    public static final IntPredicate INT_TRUE = x -> true;

    public static final DoublePredicate DOUBLE_TRUE = x -> true;

    public static final Predicate<String> STRING_TRUE = x -> true;

    public static final Predicate<String> IS_DATE = x -> {
        try {
            LocalDate.parse(x);
            return true;
        }
        catch (DateTimeParseException e) {
            return false;
        }
    };

    // </editor-fold>

}
