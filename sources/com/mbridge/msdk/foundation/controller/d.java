package com.mbridge.msdk.foundation.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.aa;

/* compiled from: TCStringManager */
public final class d implements SharedPreferences.OnSharedPreferenceChangeListener {
    private String a = "";
    private String b = "";
    private String c = "";
    private String d = "";
    private int e = 0;
    private boolean f = false;
    private boolean g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private a l;
    private final SharedPreferences m;

    /* compiled from: TCStringManager */
    public interface a {
        void a();
    }

    public d(Context context) {
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        this.m = defaultSharedPreferences;
        if (defaultSharedPreferences != null) {
            defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
        }
        if (defaultSharedPreferences != null) {
            this.a = defaultSharedPreferences.getString("IABTCF_TCString", "");
            this.e = defaultSharedPreferences.getInt("IABTCF_gdprApplies", 0);
            a(defaultSharedPreferences.getString("IABTCF_PurposeConsents", ""));
            b(defaultSharedPreferences.getString("IABTCF_VendorConsents", ""));
            c(defaultSharedPreferences.getString("IABTCF_AddtlConsent", ""));
        }
    }

    public final void a(a aVar) {
        if (aVar != null) {
            this.l = aVar;
        }
    }

    public final String a() {
        return this.a;
    }

    private void a(String str) {
        this.g = a(str, 1);
        this.h = a(str, 2);
        this.b = str;
    }

    private void b(String str) {
        this.i = a(str, 867);
        this.c = str;
    }

    private void c(String str) {
        this.d = str;
        if (TextUtils.isEmpty(str)) {
            this.j = true;
        } else if (MBridgeConstans.GOOGLE_ATP_ID == -1) {
            this.k = false;
        } else {
            this.k = true;
            try {
                String[] split = str.split("~");
                if (split.length <= 1) {
                    return;
                }
                if (TextUtils.isEmpty(split[1])) {
                    this.j = false;
                } else {
                    this.j = str.contains(String.valueOf(MBridgeConstans.GOOGLE_ATP_ID));
                }
            } catch (Throwable th) {
                aa.d("TCStringManager", th.getMessage());
            }
        }
    }

    public final boolean b() {
        boolean z = true;
        if (this.e == 0) {
            this.f = true;
            return true;
        }
        if (d(this.b) && d(this.c)) {
            if (MBridgeConstans.VERIFY_ATP_CONSENT) {
                if (!(this.i || (this.k && this.j)) || !this.g || !this.h) {
                    z = false;
                }
                this.f = z;
                return this.f;
            } else if (!this.i || !this.g || !this.h) {
                z = false;
            }
        }
        this.f = z;
        return this.f;
    }

    private boolean d(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.matches("[01]+");
        }
        return false;
    }

    private boolean a(String str, int i2) {
        if (!d(str) || i2 > str.length() || i2 < 1 || '1' != str.charAt(i2 - 1)) {
            return false;
        }
        return true;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onSharedPreferenceChanged(android.content.SharedPreferences r12, java.lang.String r13) {
        /*
            r11 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r13)     // Catch:{ all -> 0x0080 }
            if (r0 != 0) goto L_0x008a
            int r0 = r13.hashCode()     // Catch:{ all -> 0x0080 }
            r1 = 0
            java.lang.String r2 = "IABTCF_VendorConsents"
            java.lang.String r3 = "IABTCF_AddtlConsent"
            java.lang.String r4 = "IABTCF_TCString"
            java.lang.String r5 = "IABTCF_gdprApplies"
            java.lang.String r6 = "IABTCF_PurposeConsents"
            r7 = 4
            r8 = 3
            r9 = 2
            r10 = 1
            switch(r0) {
                case -2004976699: goto L_0x003d;
                case 83641339: goto L_0x0035;
                case 1218895378: goto L_0x002d;
                case 1342914771: goto L_0x0025;
                case 1450203731: goto L_0x001d;
                default: goto L_0x001c;
            }
        L_0x001c:
            goto L_0x0045
        L_0x001d:
            boolean r13 = r13.equals(r2)     // Catch:{ all -> 0x0080 }
            if (r13 == 0) goto L_0x0045
            r13 = 3
            goto L_0x0046
        L_0x0025:
            boolean r13 = r13.equals(r3)     // Catch:{ all -> 0x0080 }
            if (r13 == 0) goto L_0x0045
            r13 = 4
            goto L_0x0046
        L_0x002d:
            boolean r13 = r13.equals(r4)     // Catch:{ all -> 0x0080 }
            if (r13 == 0) goto L_0x0045
            r13 = 0
            goto L_0x0046
        L_0x0035:
            boolean r13 = r13.equals(r5)     // Catch:{ all -> 0x0080 }
            if (r13 == 0) goto L_0x0045
            r13 = 1
            goto L_0x0046
        L_0x003d:
            boolean r13 = r13.equals(r6)     // Catch:{ all -> 0x0080 }
            if (r13 == 0) goto L_0x0045
            r13 = 2
            goto L_0x0046
        L_0x0045:
            r13 = -1
        L_0x0046:
            java.lang.String r0 = ""
            if (r13 == 0) goto L_0x0072
            if (r13 == r10) goto L_0x006b
            if (r13 == r9) goto L_0x0063
            if (r13 == r8) goto L_0x005b
            if (r13 == r7) goto L_0x0053
            goto L_0x0078
        L_0x0053:
            java.lang.String r12 = r12.getString(r3, r0)     // Catch:{ all -> 0x0080 }
            r11.c(r12)     // Catch:{ all -> 0x0080 }
            goto L_0x0078
        L_0x005b:
            java.lang.String r12 = r12.getString(r2, r0)     // Catch:{ all -> 0x0080 }
            r11.b(r12)     // Catch:{ all -> 0x0080 }
            goto L_0x0078
        L_0x0063:
            java.lang.String r12 = r12.getString(r6, r0)     // Catch:{ all -> 0x0080 }
            r11.a((java.lang.String) r12)     // Catch:{ all -> 0x0080 }
            goto L_0x0078
        L_0x006b:
            int r12 = r12.getInt(r5, r1)     // Catch:{ all -> 0x0080 }
            r11.e = r12     // Catch:{ all -> 0x0080 }
            goto L_0x0078
        L_0x0072:
            java.lang.String r12 = r12.getString(r4, r0)     // Catch:{ all -> 0x0080 }
            r11.a = r12     // Catch:{ all -> 0x0080 }
        L_0x0078:
            com.mbridge.msdk.foundation.controller.d$a r12 = r11.l     // Catch:{ all -> 0x0080 }
            if (r12 == 0) goto L_0x008a
            r12.a()     // Catch:{ all -> 0x0080 }
            goto L_0x008a
        L_0x0080:
            r12 = move-exception
            java.lang.String r13 = "TCStringManager"
            java.lang.String r12 = r12.getMessage()
            com.mbridge.msdk.foundation.tools.aa.d(r13, r12)
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.controller.d.onSharedPreferenceChanged(android.content.SharedPreferences, java.lang.String):void");
    }
}
