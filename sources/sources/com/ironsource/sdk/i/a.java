package com.ironsource.sdk.i;

import android.app.Activity;
import android.content.Context;
import com.facebook.internal.NativeProtocol;
import com.ironsource.sdk.controller.A;
import com.ironsource.sdk.g.d;
import com.ironsource.sdk.utils.b;

public final class a {

    /* renamed from: com.ironsource.sdk.i.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|(2:1|2)|3|5|6|7|8|10) */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0016 */
        static {
            /*
                int[] r0 = com.ironsource.sdk.g.d.a.a()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                r1 = 1
                int r2 = com.ironsource.sdk.g.d.a.a     // Catch:{ NoSuchFieldError -> 0x000f }
                r2 = 0
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x000f }
            L_0x000f:
                r0 = 2
                int[] r2 = a     // Catch:{ NoSuchFieldError -> 0x0016 }
                int r3 = com.ironsource.sdk.g.d.a.b     // Catch:{ NoSuchFieldError -> 0x0016 }
                r2[r1] = r0     // Catch:{ NoSuchFieldError -> 0x0016 }
            L_0x0016:
                int[] r1 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                int r2 = com.ironsource.sdk.g.d.a.c     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 3
                r1[r0] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.sdk.i.a.AnonymousClass1.<clinit>():void");
        }
    }

    public static boolean a(Activity activity) {
        int parseInt = Integer.parseInt(b.a().a.getString("back_button_state", "2"));
        if (AnonymousClass1.a[(parseInt == 0 ? d.a.a : parseInt == 1 ? d.a.b : d.a.c) - 1] != 3) {
            return false;
        }
        try {
            A a = (A) com.ironsource.sdk.d.b.a((Context) activity).a.a;
            if (a != null) {
                a.b(A.b("nativeNavigationPressed", A.a(NativeProtocol.WEB_DIALOG_ACTION, "back", (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, false)));
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
