package com.bytedance.sdk.openadsdk.multipro.aidl.a;

import android.content.ContentValues;
import android.net.Uri;
import com.bytedance.sdk.component.e.a.g;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.settings.k;
import com.bytedance.sdk.openadsdk.multipro.a.a;
import com.bytedance.sdk.openadsdk.multipro.e;
import java.util.Map;

/* compiled from: ProviderListenerManagerImpl */
public class f extends g.a {
    private static volatile f a;

    public static f b() {
        if (a == null) {
            synchronized (f.class) {
                if (a == null) {
                    a = new f();
                }
            }
        }
        return a;
    }

    public Map a(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        if (!k.a()) {
            return null;
        }
        try {
            return a.a(e.a(o.a()).a(uri, strArr, str, strArr2, str2));
        } catch (Throwable unused) {
            return null;
        }
    }

    public String a(Uri uri) {
        if (!k.a()) {
            return null;
        }
        return e.a(o.a()).a(uri);
    }

    public String a(Uri uri, ContentValues contentValues) {
        Uri a2;
        if (k.a() && (a2 = e.a(o.a()).a(uri, contentValues)) != null) {
            return a2.toString();
        }
        return null;
    }

    public int a(Uri uri, String str, String[] strArr) {
        if (!k.a()) {
            return 0;
        }
        return e.a(o.a()).a(uri, str, strArr);
    }

    public int a(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        if (!k.a()) {
            return 0;
        }
        return e.a(o.a()).a(uri, contentValues, str, strArr);
    }
}
