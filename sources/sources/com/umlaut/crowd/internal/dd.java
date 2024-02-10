package com.umlaut.crowd.internal;

import java.io.PrintStream;

public class dd extends Thread {
    private static final long f = 200000000;
    private long a = 0;
    private xc b;
    private vc c;
    private boolean d = false;
    private long e = Long.MAX_VALUE;

    public dd(xc xcVar, vc vcVar) {
        this.b = xcVar;
        this.c = vcVar;
        PrintStream printStream = System.out;
        printStream.println("Creating UDP sender " + this);
    }

    public long a() {
        return this.a;
    }

    public void b() {
        this.d = true;
        if (isAlive()) {
            try {
                join();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void run() {
        try {
            System.out.println("running UDP sender " + this);
            xc xcVar = this.b;
            long j = ((long) xcVar.pkgInterval) * 1000000;
            long j2 = j / ((long) xcVar.pkgAmount);
            long nanoTime = System.nanoTime();
            long j3 = nanoTime + j;
            int i = 0;
            while (true) {
                if (this.d) {
                    break;
                }
                if (System.nanoTime() - nanoTime >= 0) {
                    if (i < this.b.pkgAmount) {
                        this.c.b();
                        i++;
                        long j4 = this.a + 1;
                        this.a = j4;
                        if (j4 >= this.e) {
                            break;
                        }
                    }
                    nanoTime += j2;
                    if (nanoTime >= j3) {
                        if (i < this.b.pkgAmount) {
                            nanoTime -= j2;
                        } else {
                            i = 0;
                            nanoTime = j3;
                            j3 += j;
                        }
                    }
                }
                long nanoTime2 = nanoTime - System.nanoTime();
                if (nanoTime2 > 0) {
                    if (nanoTime2 > f) {
                        nanoTime2 = 200000000;
                    }
                    if (!q9.b(nanoTime2)) {
                        this.d = true;
                    }
                }
            }
        } catch (Error | Exception e2) {
            e2.printStackTrace();
        } finally {
            System.out.println("END UDP Sender " + this);
        }
    }

    public void a(long j) {
        this.e = j;
    }
}
