package com.startapp;

import com.startapp.sb;
import java.util.ArrayDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: Sta */
public class yb implements sb.a {
    public final ThreadPoolExecutor a = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingQueue());
    public final ArrayDeque<sb> b = new ArrayDeque<>();
    public sb c = null;

    public void a(sb sbVar) {
        sbVar.a = this;
        this.b.add(sbVar);
        if (this.c == null) {
            sb poll = this.b.poll();
            this.c = poll;
            if (poll != null) {
                poll.executeOnExecutor(this.a, new Object[0]);
            }
        }
    }
}
