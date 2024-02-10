package com.mbridge.msdk.videocommon.download;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.videocommon.download.g;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: DownLoadH5SourceListener */
public final class b implements g.c {
    private static String a = "DownLoadH5SourceListener";
    private ConcurrentMap<String, b> b;
    private k c;
    private CopyOnWriteArrayList<g.d> d;
    private String e;

    public final void a() {
    }

    public b(ConcurrentMap<String, b> concurrentMap, k kVar, g.d dVar, String str) {
        CopyOnWriteArrayList<g.d> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.d = copyOnWriteArrayList;
        this.b = concurrentMap;
        this.c = kVar;
        copyOnWriteArrayList.add(dVar);
        this.e = str;
    }

    public final void a(g.d dVar) {
        this.d.add(dVar);
    }

    public final void a(String str, byte[] bArr, String str2) {
        String str3;
        String str4 = "";
        try {
            ConcurrentMap<String, b> concurrentMap = this.b;
            if (concurrentMap == null) {
                Iterator<g.d> it = this.d.iterator();
                while (it.hasNext()) {
                    g.d next = it.next();
                    if (next != null) {
                        next.a(str2, "mResDownloadingMap  is null");
                        this.d.remove(next);
                    }
                }
                return;
            }
            if (concurrentMap.containsKey(str2)) {
                this.b.remove(str2);
            }
            if (bArr == null || bArr.length <= 0) {
                str3 = "response data is error";
            } else {
                String a2 = this.c.a(str2, bArr);
                if (TextUtils.isEmpty(a2)) {
                    Iterator<g.d> it2 = this.d.iterator();
                    while (it2.hasNext()) {
                        g.d next2 = it2.next();
                        if (next2 != null) {
                            next2.a(str2, str4, false);
                            this.d.remove(next2);
                        }
                    }
                    return;
                }
                str3 = "data save failed:" + a2;
            }
            str4 = str3;
            Iterator<g.d> it3 = this.d.iterator();
            while (it3.hasNext()) {
                g.d next3 = it3.next();
                if (next3 != null) {
                    next3.a(str2, str4);
                }
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
            str4 = e2.getMessage();
        } catch (Throwable th) {
            aa.b(a, th.getMessage(), th);
        }
    }

    public final void a(String str) {
        try {
            ConcurrentMap<String, b> concurrentMap = this.b;
            if (concurrentMap == null) {
                Iterator<g.d> it = this.d.iterator();
                while (it.hasNext()) {
                    g.d next = it.next();
                    if (next != null) {
                        next.a(this.e, "mResDownloadingMap  is null");
                        this.d.remove(next);
                    }
                }
                return;
            }
            if (concurrentMap.containsKey(this.e)) {
                this.b.remove(this.e);
            }
            Iterator<g.d> it2 = this.d.iterator();
            while (it2.hasNext()) {
                g.d next2 = it2.next();
                if (next2 != null) {
                    next2.a(this.e, str);
                    this.d.remove(next2);
                }
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                e2.printStackTrace();
            }
            str = e2.getMessage();
        } catch (Throwable th) {
            aa.b(a, th.getMessage(), th);
        }
    }
}
