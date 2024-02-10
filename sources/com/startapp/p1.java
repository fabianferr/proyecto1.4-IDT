package com.startapp;

import java.nio.charset.Charset;
import org.apache.commons.codec.CharEncoding;

/* compiled from: Sta */
public class p1 {
    public static final Charset a = Charset.forName("UTF-8");

    static {
        Charset.forName("ISO-8859-1");
        Charset.forName("US-ASCII");
        Charset.forName("UTF-16");
        Charset.forName(CharEncoding.UTF_16BE);
        Charset.forName("UTF-16LE");
    }
}
