package com.startapp;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Pair;
import java.util.Arrays;
import java.util.Map;

/* compiled from: Sta */
public class x6 extends a7 {
    public BroadcastReceiver c;

    /* compiled from: Sta */
    public class a extends BroadcastReceiver {
        public final /* synthetic */ c7 a;

        public a(c7 c7Var) {
            this.a = c7Var;
        }

        public void onReceive(Context context, Intent intent) {
            this.a.a((Object) new Pair(x6.this, intent));
        }
    }

    public x6(String str, Map<String, String> map) {
        super(str, map);
    }

    public void a(Context context, c7 c7Var) throws Exception {
        if (this.c == null) {
            a aVar = new a(c7Var);
            this.c = aVar;
            context.registerReceiver(aVar, new IntentFilter(this.a));
            return;
        }
        throw new IllegalStateException();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x6.class != obj.getClass()) {
            return false;
        }
        return k9.a(this.c, ((x6) obj).c);
    }

    public int hashCode() {
        Object[] objArr = {this.c};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }

    public void a(Context context) throws Exception {
        BroadcastReceiver broadcastReceiver = this.c;
        if (broadcastReceiver != null) {
            context.unregisterReceiver(broadcastReceiver);
            this.c = null;
            return;
        }
        throw new IllegalStateException();
    }
}
