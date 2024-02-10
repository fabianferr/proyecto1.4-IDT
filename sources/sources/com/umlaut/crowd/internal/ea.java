package com.umlaut.crowd.internal;

import java.util.ArrayList;

public class ea {
    private ArrayList<Long> a = new ArrayList<>();
    private int b = -1;
    private long c;
    private long d = 0;
    private boolean e;
    private final long f;
    private long g;

    public ea(long j) {
        this.f = j;
    }

    public void a(long j, boolean z) {
        this.a.clear();
        a(1);
        this.b = 0;
        this.e = true;
        if (z) {
            this.d = 0;
        } else {
            this.a.set(0, Long.valueOf(this.d));
        }
        this.c = j;
        this.g = j;
    }

    public synchronized long b(int i) {
        a(i + 1);
        return this.a.get(i).longValue();
    }

    public synchronized int b() {
        return this.a.size() - 1;
    }

    private void a(int i) {
        int size = this.a.size();
        if (i > size) {
            while (size < i) {
                this.a.add(0L);
                size++;
            }
        }
    }

    public synchronized void a(long j, long j2) {
        if (j2 >= 0) {
            this.d += j2;
            if (this.e) {
                if (j - this.c >= 0) {
                    int i = (int) ((j - this.g) / this.f);
                    if (i >= 0) {
                        a(i + 1);
                        if (this.b < i) {
                            long j3 = this.g;
                            long j4 = (long) i;
                            long j5 = this.f;
                            Long.signum(j4);
                            long j6 = j3 + (j4 * j5);
                            long j7 = this.c;
                            long j8 = j - j7;
                            long j9 = j6 - j7;
                            if (j9 <= j5) {
                                j5 = j9;
                            }
                            long j10 = (j5 * j2) / j8;
                            if (j10 >= 0) {
                                j2 -= j10;
                                if (j2 >= 0) {
                                    ArrayList<Long> arrayList = this.a;
                                    int i2 = i - 1;
                                    arrayList.set(i2, Long.valueOf(arrayList.get(i2).longValue() + j10));
                                    this.b = i;
                                } else {
                                    throw new IllegalArgumentException("Number of bytes has to be positive(3)");
                                }
                            } else {
                                throw new RuntimeException("Number of bytes has to be positive(2)");
                            }
                        }
                        if (j2 >= 0) {
                            ArrayList<Long> arrayList2 = this.a;
                            arrayList2.set(i, Long.valueOf(arrayList2.get(i).longValue() + j2));
                        } else {
                            throw new IllegalArgumentException("Number of bytes has to be positive(3)");
                        }
                    } else {
                        throw new IllegalArgumentException("time is not stright forward (initTime)");
                    }
                } else {
                    throw new IllegalArgumentException("time is not stright forward (lastReceivedTime)?");
                }
            }
            this.c = j;
        } else {
            throw new IllegalArgumentException("Number of bytes has to be positive: " + j2);
        }
    }

    public synchronized long a() {
        return this.d;
    }
}
