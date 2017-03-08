package com.karmios.nat.handyutils.functional;

@SuppressWarnings("unused")
public interface ESupplier <T, E extends Throwable> {
    T get() throws E;
}
