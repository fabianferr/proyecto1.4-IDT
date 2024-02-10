package com.umlaut.crowd.internal;

public interface tc extends e3 {

    public enum a {
        RUNNING(0),
        DONE(1),
        UNDEFINEDERROR(2),
        PACKAGETIMEOUT(3),
        TOOMUCHLOAD(4);
        
        int a;

        private a(int i) {
            this.a = i;
        }

        public int a() {
            return this.a;
        }

        public static a a(int i) {
            for (a aVar : values()) {
                if (aVar.a == i) {
                    return aVar;
                }
            }
            return null;
        }
    }

    void a(kb kbVar, long j);

    void a(kb kbVar, a aVar, j7 j7Var, int i, j7[] j7VarArr);

    void b(kb kbVar, a aVar, j7 j7Var, int i, j7[] j7VarArr);
}
