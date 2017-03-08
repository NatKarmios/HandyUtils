package com.karmios.nat.handyutils;

import java.nio.file.FileSystems;

import static com.karmios.nat.handyutils.Constants.rng;

@SuppressWarnings("unused")
public final class Misc {

    private Misc(){}

    public static String getClassDir(Class cls) {
        String sep = FileSystems.getDefault().getSeparator();
        return System.getProperty("user.dir") + sep + "src" + sep + cls.getPackage().getName().replace(".", sep) + sep;
    }

    public static int randInt(int lowerBound, int upperBound) {
        return rng.nextInt(upperBound-lowerBound) + lowerBound;
    }

}
