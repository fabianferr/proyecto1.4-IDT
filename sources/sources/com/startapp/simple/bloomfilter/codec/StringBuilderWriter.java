package com.startapp.simple.bloomfilter.codec;

import java.io.Serializable;
import java.io.Writer;

/* compiled from: Sta */
public class StringBuilderWriter extends Writer implements Serializable {
    private static final long serialVersionUID = -8956169446715407818L;
    private final StringBuilder builder;

    public StringBuilderWriter() {
        this.builder = new StringBuilder();
    }

    public void close() {
    }

    public void flush() {
    }

    public String toString() {
        return this.builder.toString();
    }

    public void write(String str) {
        if (str != null) {
            this.builder.append(str);
        }
    }

    public void write(char[] cArr, int i, int i2) {
        if (cArr != null) {
            this.builder.append(cArr, i, i2);
        }
    }

    public StringBuilderWriter(int i) {
        this.builder = new StringBuilder(i);
    }

    public Writer append(char c) {
        this.builder.append(c);
        return this;
    }

    public Writer append(CharSequence charSequence) {
        this.builder.append(charSequence);
        return this;
    }

    public Writer append(CharSequence charSequence, int i, int i2) {
        this.builder.append(charSequence, i, i2);
        return this;
    }
}
