package com.startapp;

import java.util.Collection;
import java.util.Locale;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: Sta */
public class x4 {
    public static final x4 d = new x4();
    public final String a;
    public final String b;
    public final String c;

    public x4(Locale locale, Collection<Locale> collection) {
        this.a = locale.toString();
        this.b = a((Locale) null, collection, ';');
        this.c = a(locale, collection, AbstractJsonLexerKt.COMMA);
    }

    public static String a(Locale locale, Iterable<Locale> iterable, char c2) {
        boolean z;
        StringBuilder sb;
        if (locale != null) {
            sb = new StringBuilder();
            sb.append(locale);
            z = true;
        } else {
            z = false;
            sb = null;
        }
        if (iterable != null) {
            for (Locale next : iterable) {
                if (next != null) {
                    if (sb == null) {
                        sb = new StringBuilder();
                    }
                    if (z) {
                        sb.append(c2);
                    }
                    sb.append(next);
                    z = true;
                }
            }
        }
        if (sb != null) {
            return sb.toString();
        }
        return null;
    }

    public x4() {
        this.a = null;
        this.b = null;
        this.c = null;
    }
}
