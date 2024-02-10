package com.cellrebel.sdk.utils;

class a {
    private int a = 0;
    private long b = 0;
    private long c = 0;

    public int a() {
        return this.a;
    }

    public void a(String[] strArr) {
        long parseLong = Long.parseLong(strArr[4], 10);
        long j = 0;
        boolean z = true;
        for (String str : strArr) {
            if (z) {
                z = false;
            } else {
                j += Long.parseLong(str, 10);
            }
        }
        long j2 = j - this.b;
        this.a = (int) ((((float) (j2 - (parseLong - this.c))) / ((float) j2)) * 100.0f);
        this.b = j;
        this.c = parseLong;
    }
}
