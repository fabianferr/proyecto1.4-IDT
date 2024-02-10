package com.mbridge.msdk.foundation.a.a;

import android.content.Context;
import android.content.SharedPreferences;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.FastKV;
import com.mbridge.msdk.foundation.tools.aa;

/* compiled from: SharedPerferenceManager */
public class a {
    public static final String a = "a";
    private static a e;
    SharedPreferences b;
    FastKV c;
    private final boolean d = true;

    private a() {
        c.a();
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (e == null) {
                e = new a();
            }
            aVar = e;
        }
        return aVar;
    }

    public final void a(String str, String str2) {
        try {
            Context g = b.d().g();
            if (g != null) {
                if (this.d) {
                    if (this.c == null) {
                        try {
                            this.c = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                        } catch (Exception unused) {
                            this.c = null;
                        }
                    }
                }
                FastKV fastKV = this.c;
                if (fastKV != null) {
                    try {
                        fastKV.putString(str, str2);
                    } catch (Exception unused2) {
                    }
                } else {
                    if (this.b == null && g != null) {
                        this.b = g.getSharedPreferences("mbridge", 0);
                    }
                    SharedPreferences.Editor edit = this.b.edit();
                    edit.putString(str, str2);
                    edit.apply();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str, int i) {
        try {
            Context g = b.d().g();
            if (g != null) {
                if (this.d) {
                    if (this.c == null) {
                        try {
                            this.c = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                        } catch (Exception unused) {
                            this.c = null;
                        }
                    }
                }
                FastKV fastKV = this.c;
                if (fastKV != null) {
                    try {
                        fastKV.putInt(str, i);
                    } catch (Exception unused2) {
                    }
                } else {
                    if (this.b == null && g != null) {
                        this.b = g.getSharedPreferences("mbridge", 0);
                    }
                    SharedPreferences.Editor edit = this.b.edit();
                    edit.putInt(str, i);
                    edit.apply();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(String str, long j) {
        try {
            Context g = b.d().g();
            if (g == null) {
                aa.d(a, "context is null in put");
                return;
            }
            if (this.d) {
                if (this.c == null) {
                    try {
                        this.c = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                    } catch (Exception unused) {
                        this.c = null;
                    }
                }
            }
            FastKV fastKV = this.c;
            if (fastKV != null) {
                try {
                    fastKV.putLong(str, j);
                } catch (Exception unused2) {
                }
            } else {
                if (this.b == null && g != null) {
                    this.b = g.getSharedPreferences("mbridge", 0);
                }
                SharedPreferences.Editor edit = this.b.edit();
                edit.putLong(str, j);
                edit.apply();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:23|24|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0048, code lost:
        return 0L;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0044 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Long a(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0061 }
            android.content.Context r2 = r2.g()     // Catch:{ Exception -> 0x0061 }
            if (r2 != 0) goto L_0x0018
            java.lang.String r7 = a     // Catch:{ Exception -> 0x0061 }
            java.lang.String r2 = "context is null in get"
            com.mbridge.msdk.foundation.tools.aa.d(r7, r2)     // Catch:{ Exception -> 0x0061 }
            java.lang.Long r7 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x0061 }
            return r7
        L_0x0018:
            boolean r3 = r6.d     // Catch:{ Exception -> 0x0061 }
            java.lang.String r4 = "mbridge"
            if (r3 == 0) goto L_0x0037
            com.mbridge.msdk.foundation.tools.FastKV r3 = r6.c     // Catch:{ Exception -> 0x0061 }
            if (r3 != 0) goto L_0x0037
            com.mbridge.msdk.foundation.tools.FastKV$Builder r3 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.foundation.same.b.c r5 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x0034 }
            java.lang.String r5 = com.mbridge.msdk.foundation.same.b.e.b(r5)     // Catch:{ Exception -> 0x0034 }
            r3.<init>(r5, r4)     // Catch:{ Exception -> 0x0034 }
            com.mbridge.msdk.foundation.tools.FastKV r3 = r3.build()     // Catch:{ Exception -> 0x0034 }
            r6.c = r3     // Catch:{ Exception -> 0x0034 }
            goto L_0x0037
        L_0x0034:
            r3 = 0
            r6.c = r3     // Catch:{ Exception -> 0x0061 }
        L_0x0037:
            com.mbridge.msdk.foundation.tools.FastKV r3 = r6.c     // Catch:{ Exception -> 0x0061 }
            if (r3 == 0) goto L_0x0049
            long r2 = r3.getLong(r7, r0)     // Catch:{ Exception -> 0x0044 }
            java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x0044 }
            return r7
        L_0x0044:
            java.lang.Long r7 = java.lang.Long.valueOf(r0)     // Catch:{ Exception -> 0x0061 }
            return r7
        L_0x0049:
            android.content.SharedPreferences r3 = r6.b     // Catch:{ Exception -> 0x0061 }
            if (r3 != 0) goto L_0x0056
            if (r2 == 0) goto L_0x0056
            r3 = 0
            android.content.SharedPreferences r2 = r2.getSharedPreferences(r4, r3)     // Catch:{ Exception -> 0x0061 }
            r6.b = r2     // Catch:{ Exception -> 0x0061 }
        L_0x0056:
            android.content.SharedPreferences r2 = r6.b     // Catch:{ Exception -> 0x0061 }
            long r2 = r2.getLong(r7, r0)     // Catch:{ Exception -> 0x0061 }
            java.lang.Long r7 = java.lang.Long.valueOf(r2)     // Catch:{ Exception -> 0x0061 }
            return r7
        L_0x0061:
            r7 = move-exception
            r7.printStackTrace()
            java.lang.Long r7 = java.lang.Long.valueOf(r0)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.a.a.a.a(java.lang.String):java.lang.Long");
    }

    public final int b(String str, int i) {
        try {
            Context g = b.d().g();
            if (g == null) {
                return i;
            }
            if (this.d) {
                if (this.c == null) {
                    try {
                        this.c = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                    } catch (Exception unused) {
                        this.c = null;
                    }
                }
            }
            FastKV fastKV = this.c;
            if (fastKV != null) {
                try {
                    return fastKV.getInt(str, i);
                } catch (Exception unused2) {
                    return i;
                }
            } else {
                if (this.b == null) {
                    this.b = g.getSharedPreferences("mbridge", 0);
                }
                return this.b.getInt(str, i);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            return i;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:11|12|13|14) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(java.lang.String r6) {
        /*
            r5 = this;
            r0 = 0
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x004a }
            android.content.Context r1 = r1.g()     // Catch:{ Exception -> 0x004a }
            if (r1 != 0) goto L_0x000c
            return r0
        L_0x000c:
            boolean r2 = r5.d     // Catch:{ Exception -> 0x004a }
            java.lang.String r3 = "mbridge"
            if (r2 == 0) goto L_0x002a
            com.mbridge.msdk.foundation.tools.FastKV r2 = r5.c     // Catch:{ Exception -> 0x004a }
            if (r2 != 0) goto L_0x002a
            com.mbridge.msdk.foundation.tools.FastKV$Builder r2 = new com.mbridge.msdk.foundation.tools.FastKV$Builder     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.foundation.same.b.c r4 = com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG     // Catch:{ Exception -> 0x0028 }
            java.lang.String r4 = com.mbridge.msdk.foundation.same.b.e.b(r4)     // Catch:{ Exception -> 0x0028 }
            r2.<init>(r4, r3)     // Catch:{ Exception -> 0x0028 }
            com.mbridge.msdk.foundation.tools.FastKV r2 = r2.build()     // Catch:{ Exception -> 0x0028 }
            r5.c = r2     // Catch:{ Exception -> 0x0028 }
            goto L_0x002a
        L_0x0028:
            r5.c = r0     // Catch:{ Exception -> 0x004a }
        L_0x002a:
            com.mbridge.msdk.foundation.tools.FastKV r2 = r5.c     // Catch:{ Exception -> 0x004a }
            java.lang.String r4 = ""
            if (r2 == 0) goto L_0x0036
            java.lang.String r6 = r2.getString(r6, r4)     // Catch:{ Exception -> 0x0035 }
            return r6
        L_0x0035:
            return r4
        L_0x0036:
            android.content.SharedPreferences r2 = r5.b     // Catch:{ Exception -> 0x004a }
            if (r2 != 0) goto L_0x0043
            if (r1 == 0) goto L_0x0043
            r2 = 0
            android.content.SharedPreferences r1 = r1.getSharedPreferences(r3, r2)     // Catch:{ Exception -> 0x004a }
            r5.b = r1     // Catch:{ Exception -> 0x004a }
        L_0x0043:
            android.content.SharedPreferences r1 = r5.b     // Catch:{ Exception -> 0x004a }
            java.lang.String r6 = r1.getString(r6, r4)     // Catch:{ Exception -> 0x004a }
            return r6
        L_0x004a:
            r6 = move-exception
            r6.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.a.a.a.b(java.lang.String):java.lang.String");
    }

    public final void c(String str) {
        Context g = b.d().g();
        if (g != null) {
            if (this.d && this.c == null) {
                try {
                    this.c = new FastKV.Builder(e.b(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_CONFIG), "mbridge").build();
                } catch (Exception unused) {
                    this.c = null;
                }
            }
            FastKV fastKV = this.c;
            if (fastKV != null) {
                try {
                    fastKV.remove(str);
                } catch (Exception unused2) {
                }
            } else {
                if (this.b == null && g != null) {
                    this.b = g.getSharedPreferences("mbridge", 0);
                }
                this.b.edit().remove(str).apply();
            }
        }
    }
}
