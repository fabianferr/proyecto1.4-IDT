package com.wortise.ads;

import com.mbridge.msdk.foundation.tools.SameMD5;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\b\u0010\tJ\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¨\u0006\n"}, d2 = {"Lcom/wortise/ads/r3;", "", "", "data", "Lcom/wortise/ads/q3;", "a", "", "list", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: HashedDataFactory.kt */
public final class r3 {
    public static final r3 a = new r3();

    private r3() {
    }

    public final q3 a(String str) {
        if (str == null) {
            return null;
        }
        return new q3(p3.b(str, SameMD5.TAG), p3.b(str, "SHA-1"));
    }

    public final List<q3> a(List<String> list) {
        q3 q3Var;
        if (list == null) {
            return null;
        }
        if (!(!list.isEmpty())) {
            list = null;
        }
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String a2 : list) {
            try {
                q3Var = a.a(a2);
            } catch (Throwable unused) {
                q3Var = null;
            }
            if (q3Var != null) {
                arrayList.add(q3Var);
            }
        }
        return arrayList;
    }
}
