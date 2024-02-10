package com.pgl.ssdk;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;

public class A extends HandlerThread {
    /* access modifiers changed from: private */
    public int a = 2;
    public int b = 0;
    /* access modifiers changed from: private */
    public int c = 10000;
    /* access modifiers changed from: private */
    public Context d;
    /* access modifiers changed from: private */
    public String e;
    /* access modifiers changed from: private */
    public byte[] f;
    public Handler g;
    public Handler.Callback h = new z(this);

    public A(String str, Context context, String str2, byte[] bArr) {
        super(str);
        this.d = context;
        this.e = str2;
        this.f = bArr;
    }
}
