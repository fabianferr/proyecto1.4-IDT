package com.mbridge.msdk.foundation.controller.authoritycontroller;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.d;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.out.OnCompletionListener;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SDKAuthorityController */
public class a {
    private static volatile a b = null;
    private static boolean e = true;
    private static boolean f = true;
    public ArrayList<String> a = new ArrayList<>();
    private AuthorityInfoBean c = new AuthorityInfoBean();
    private int d = 3;
    private String g = "";
    private d h;

    private a() {
        try {
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_GENERAL_DATA).equals("")) {
                this.c.b(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_DEVICE_ID).equals("")) {
                this.c.c(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_SERIAL_ID).equals("")) {
                this.c.d(1);
            }
            if (com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_OTHER).equals("")) {
                this.c.e(1);
            }
            this.a.add(MBridgeConstans.AUTHORITY_GENERAL_DATA);
            this.a.add(MBridgeConstans.AUTHORITY_DEVICE_ID);
            this.a.add(MBridgeConstans.AUTHORITY_SERIAL_ID);
            this.a.add(MBridgeConstans.AUTHORITY_OTHER);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static a a() {
        if (b == null) {
            synchronized (a.class) {
                if (b == null) {
                    b = new a();
                }
            }
        }
        return b;
    }

    public final void a(String str, int i) {
        if (this.c == null) {
            return;
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            this.c.b(i);
        } else if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            this.c.c(i);
        } else if (str.equals(MBridgeConstans.AUTHORITY_ALL_INFO)) {
            this.c.a(i);
        } else if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            this.c.d(i);
        } else if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            this.c.e(i);
        }
    }

    public final AuthorityInfoBean b() {
        AuthorityInfoBean authorityInfoBean = this.c;
        if (authorityInfoBean != null) {
            return authorityInfoBean;
        }
        return new AuthorityInfoBean().a(1);
    }

    private int b(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String b2 = com.mbridge.msdk.foundation.a.a.a.a().b(str);
                if (TextUtils.isEmpty(b2)) {
                    return 0;
                }
                return Integer.parseInt(b2);
            }
        } catch (Exception e2) {
            aa.d("SDKAuthorityController", e2.getMessage());
        }
        return 0;
    }

    private int c(String str) {
        e b2 = f.a().b(b.d().h());
        if (b2 == null) {
            b2 = f.a().b();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            return b2.H();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            return b2.I();
        }
        if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            return b2.G();
        }
        return -1;
    }

    public final boolean a(String str) {
        boolean z;
        boolean z2;
        e b2 = f.a().b(b.d().h());
        boolean z3 = true;
        if (b2 == null) {
            b2 = f.a().b();
            z = true;
        } else {
            z = false;
        }
        int J = b2.J();
        if (J != 0 ? !(J == 1 && c(str) == 1) : !(b(str) == 1 && c(str) == 1)) {
            z2 = false;
        } else {
            z2 = true;
        }
        if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            z2 = b(str) == 1;
        }
        if (!str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID) || a().d != 2) {
            return z2;
        }
        if (b2.aB() || z || b(str) != 1) {
            z3 = false;
        }
        return z3;
    }

    public final String c() {
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.a.size(); i++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("keyname", String.valueOf(this.a.get(i)));
                jSONObject.put("client_status", b(this.a.get(i)));
                jSONObject.put("server_status", c(this.a.get(i)));
                jSONArray.put(jSONObject);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public final void a(int i) {
        if (this.c != null) {
            c(i);
        }
    }

    public final void a(final Context context, final OnCompletionListener onCompletionListener) {
        if (onCompletionListener != null) {
            com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() {
                public final void run() {
                    a.this.a(context);
                    onCompletionListener.onCompletion();
                }
            });
        } else {
            a(context);
        }
    }

    public final boolean d() {
        int i = this.d;
        return i == 1 || i == 3;
    }

    public final void b(int i) {
        com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_DNT, i);
    }

    public final int e() {
        return com.mbridge.msdk.foundation.a.a.a.a().b(MBridgeConstans.AUTHORITY_COPPA, 0);
    }

    public final int f() {
        return this.d;
    }

    private void c(int i) {
        int i2 = 1;
        if (i != 1) {
            i2 = 2;
        }
        this.d = i2;
    }

    public static boolean g() {
        return e;
    }

    public static void a(boolean z) {
        e = z;
    }

    public static boolean h() {
        return f;
    }

    public static void b(boolean z) {
        f = z;
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        try {
            if (this.h == null) {
                d dVar = new d(context);
                this.h = dVar;
                dVar.a((d.a) new d.a() {
                    public final void a() {
                        a.this.j();
                    }
                });
            }
            j();
        } catch (Throwable th) {
            aa.d("SDKAuthorityController", th.getMessage());
        }
    }

    /* access modifiers changed from: private */
    public void j() {
        boolean b2 = this.h.b();
        d(this.h.a());
        c(b2 ? 1 : 2);
        this.c.c(b2 ? 1 : 0);
    }

    private void d(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.g = str;
        }
    }

    public final String i() {
        return this.g;
    }
}
