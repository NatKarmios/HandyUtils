package com.karmios.nat.handyutils.functional;

@SuppressWarnings("unused")
public interface EFunction <T, R, E extends Throwable> {
    R apply(T t) throws E;
}
