package com.karmios.nat.handyutils.functional;

@SuppressWarnings("unused")
public interface ERunnable <E extends Throwable> {
    void run() throws E;
}
