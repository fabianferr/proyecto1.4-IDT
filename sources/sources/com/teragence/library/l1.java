package com.teragence.library;

public class l1 {
    private final Exception a;

    public l1(Exception exc) {
        this.a = exc;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(this.a.toString() + 10);
        for (StackTraceElement stackTraceElement : this.a.getStackTrace()) {
            sb.append(stackTraceElement.toString());
            sb.append(10);
        }
        return sb.toString();
    }
}
