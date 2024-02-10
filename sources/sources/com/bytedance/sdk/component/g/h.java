package com.bytedance.sdk.component.g;

/* compiled from: TTRunnable */
public abstract class h implements Comparable<h>, Runnable {
    private int a = 5;
    private String b;

    public h(String str, int i) {
        this.a = i == 0 ? 5 : i;
        this.b = str;
    }

    public h(String str) {
        this.b = str;
    }

    public void setPriority(int i) {
        this.a = i;
    }

    public int getPriority() {
        return this.a;
    }

    public int compareTo(h hVar) {
        if (getPriority() < hVar.getPriority()) {
            return 1;
        }
        return getPriority() >= hVar.getPriority() ? -1 : 0;
    }

    public String getName() {
        return this.b;
    }
}
