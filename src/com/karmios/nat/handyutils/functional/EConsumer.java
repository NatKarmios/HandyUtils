package com.karmios.nat.handyutils.functional;

@SuppressWarnings("unused")
public interface EConsumer <T, E extends Throwable> {
    void accept(T t) throws E;
}
