package com.startapp;

import android.content.Context;
import android.net.Uri;
import com.startapp.sdk.adsbase.a;
import com.startapp.sdk.adsbase.commontracking.TrackingParams;
import com.startapp.sdk.adsbase.remoteconfig.ImpressionsTrackingMetadata;
import com.startapp.sdk.common.SDKException;
import com.startapp.sdk.common.utils.Pair;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.z5;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: Sta */
public class h3 implements h2<String, z5.a, Throwable, Void> {
    public final Context a;
    public final List<String> b;
    public final TrackingParams c;
    public final i2<ImpressionsTrackingMetadata> d;
    public final Map<String, Pair<Integer, String>> e;
    public final AtomicInteger f;
    public AtomicReference<ImpressionsTrackingMetadata> g;
    public String h;

    public h3(Context context, List<String> list, TrackingParams trackingParams, i2<ImpressionsTrackingMetadata> i2Var) {
        this.a = context;
        this.b = list;
        this.c = trackingParams;
        this.d = i2Var;
        this.e = Collections.synchronizedMap(new LinkedHashMap(list.size()));
        this.f = new AtomicInteger(list.size());
    }

    public Object a(Object obj, Object obj2, Object obj3) {
        Pair pair;
        String str = (String) obj;
        Throwable th = (Throwable) obj3;
        if (((z5.a) obj2) != null) {
            pair = new Pair(4, String.valueOf(200));
        } else {
            if (th instanceof SDKException) {
                SDKException sDKException = (SDKException) th;
                if (sDKException.a() > 0) {
                    pair = new Pair(1, String.valueOf(sDKException.a()));
                } else {
                    th = th.getCause();
                }
            }
            pair = null;
        }
        if (pair == null) {
            if (th != null) {
                pair = new Pair(2, th.getClass().getName());
            } else {
                pair = new Pair(2, String.valueOf(-1));
            }
        }
        this.e.put(str, pair);
        a();
        return null;
    }

    public static void a(Context context, List<String> list, TrackingParams trackingParams) {
        h3 h3Var = (h3) ComponentLocator.a(context).K.a().a(context, list, trackingParams);
        if (h3Var != null) {
            k9.a(h3Var.a, 4, "Sending impression", true);
            for (String next : h3Var.b) {
                if (next == null || next.length() <= 0) {
                    h3Var.e.put(next, (Object) null);
                    h3Var.a();
                } else {
                    if (h3Var.h == null) {
                        h3Var.h = a.a(next, (String) null);
                    }
                    Pair<String, Boolean> a2 = t8.a(h3Var.a, next, h3Var.c, (h2<String, z5.a, Throwable, Void>) h3Var);
                    boolean equals = Boolean.TRUE.equals(a2.second);
                    h3Var.e.put((String) a2.first, (Object) null);
                    if (!equals) {
                        h3Var.a();
                    }
                }
            }
        }
    }

    public final void a() {
        String str;
        if (this.f.decrementAndGet() == 0) {
            AtomicReference<ImpressionsTrackingMetadata> atomicReference = this.g;
            String str2 = null;
            if (atomicReference == null) {
                ImpressionsTrackingMetadata a2 = this.d.a();
                if (a2 == null || a2.a() <= Math.random()) {
                    a2 = null;
                }
                AtomicReference<ImpressionsTrackingMetadata> atomicReference2 = new AtomicReference<>(a2);
                this.g = atomicReference2;
                atomicReference = atomicReference2;
            }
            ImpressionsTrackingMetadata impressionsTrackingMetadata = atomicReference.get();
            if (impressionsTrackingMetadata != null) {
                StringBuilder sb = new StringBuilder();
                StringBuilder sb2 = new StringBuilder();
                String str3 = "";
                boolean z = false;
                for (Map.Entry next : this.e.entrySet()) {
                    Integer num = next.getValue() != null ? (Integer) ((Pair) next.getValue()).first : 2;
                    if (num != null && (impressionsTrackingMetadata.b() & num.intValue()) == num.intValue()) {
                        String valueOf = next.getValue() != null ? (String) ((Pair) next.getValue()).second : String.valueOf(-2);
                        String str4 = (String) next.getKey();
                        sb.append(str3);
                        sb.append(valueOf);
                        sb2.append(str3);
                        if (str4 != null) {
                            try {
                                Uri parse = Uri.parse(str4);
                                str = parse.getAuthority() + parse.getPath();
                            } catch (Throwable th) {
                                str = th.getClass().getName();
                            }
                        } else {
                            str = String.valueOf((char[]) null);
                        }
                        sb2.append(str);
                        str3 = ",";
                        z = true;
                    }
                }
                if (z) {
                    i3 i3Var = new i3(j3.l);
                    i3Var.e = sb + ";" + sb2;
                    i3Var.g = this.h;
                    StringBuilder a3 = p0.a("adTag: ");
                    TrackingParams trackingParams = this.c;
                    if (trackingParams != null) {
                        str2 = trackingParams.a();
                    }
                    a3.append(str2);
                    i3Var.d = a3.toString();
                    i3Var.a();
                }
            }
        }
    }
}
