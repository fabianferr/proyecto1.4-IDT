package com.startapp;

/* compiled from: Sta */
public class l9 {
    public static double a(double d, double d2, double d3) {
        return 1.0d / (Math.exp((d2 - d) * d3) + 1.0d);
    }

    public static double a(double d, double d2, double d3, double d4) {
        return (a(d, d2, d3) - d4) / (1.0d - d4);
    }
}
