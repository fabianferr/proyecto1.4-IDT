package com.teragence.library;

import java.util.Deque;

public class k2 implements l2 {
    /* access modifiers changed from: private */
    public final l2 a;
    private final Deque<d> b;

    class a implements d {
        final /* synthetic */ int a;

        a(int i) {
            this.a = i;
        }

        public void a() {
            k2.this.a.a(this.a);
        }
    }

    class b implements d {
        b() {
        }

        public void a() {
            k2.this.a.a();
        }
    }

    class c implements d {
        final /* synthetic */ int a;

        c(int i) {
            this.a = i;
        }

        public void a() {
            k2.this.a.b(this.a);
        }
    }

    public interface d {
        void a();
    }

    public k2(l2 l2Var, Deque<d> deque) {
        this.a = l2Var;
        this.b = deque;
    }

    public void a() {
        this.b.push(new b());
    }

    public void a(int i) {
        this.b.push(new a(i));
    }

    public void b(int i) {
        this.b.push(new c(i));
    }
}
