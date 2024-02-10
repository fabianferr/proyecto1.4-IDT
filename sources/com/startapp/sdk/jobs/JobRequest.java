package com.startapp.sdk.jobs;

import com.startapp.l7;
import java.util.ArrayList;
import java.util.UUID;

/* compiled from: Sta */
public abstract class JobRequest {
    public final String[] a;
    public final UUID b = UUID.randomUUID();
    public final Network c;
    public final boolean d;

    /* compiled from: Sta */
    public enum Network {
        ANY,
        UNMETERED
    }

    /* compiled from: Sta */
    public static abstract class a<B extends a<?>> {
        public final String[] a;
        public Network b;
        public boolean c;

        @SafeVarargs
        public a(Class<? extends b>... clsArr) {
            ArrayList arrayList = new ArrayList();
            for (Class<? extends b> name : clsArr) {
                arrayList.add(name.getName());
            }
            this.a = (String[]) arrayList.toArray(new String[0]);
        }
    }

    public JobRequest(a<?> aVar) {
        this.a = aVar.a;
        this.c = aVar.b;
        this.d = aVar.c;
    }

    @SafeVarargs
    public static int a(Class<? extends b>... clsArr) {
        if (clsArr.length == 0) {
            return 0;
        }
        String[] strArr = new String[clsArr.length];
        for (int i = 0; i < clsArr.length; i++) {
            strArr[i] = clsArr[i].getName();
        }
        return a(strArr);
    }

    public abstract boolean a(l7 l7Var);

    public static int a(String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String append : strArr) {
            sb.append(append);
        }
        return sb.toString().hashCode();
    }
}
