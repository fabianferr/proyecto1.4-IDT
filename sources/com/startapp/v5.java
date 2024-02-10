package com.startapp;

import android.content.Context;
import android.content.SharedPreferences;
import com.startapp.sdk.adsbase.remoteconfig.NetworkDiagnosticConfig;
import java.util.concurrent.Executor;

/* compiled from: Sta */
public class v5 {
    public final SharedPreferences a;
    public final x5 b;
    public final Executor c;
    public final i2<NetworkDiagnosticConfig> d;
    public final Runnable e = new a();
    public final n3 f = new b();

    /* compiled from: Sta */
    public class a implements Runnable {
        public a() {
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.startapp.v5$a} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.startapp.v5$a} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: com.startapp.v5} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: com.startapp.v5} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: com.startapp.v5$a} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x012c A[Catch:{ all -> 0x0135 }] */
        /* JADX WARNING: Removed duplicated region for block: B:44:? A[RETURN, SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r24 = this;
                java.lang.String r0 = ";"
                r1 = r24
                com.startapp.v5 r2 = com.startapp.v5.this
                com.startapp.sdk.adsbase.remoteconfig.NetworkDiagnosticConfig r3 = r2.a()
                if (r3 != 0) goto L_0x000e
                goto L_0x013c
            L_0x000e:
                android.content.SharedPreferences r4 = r2.a
                r5 = 0
                java.lang.String r7 = "181bb7005f9db75a"
                long r4 = r4.getLong(r7, r5)
                int r6 = r3.c()
                r8 = 60000(0xea60, float:8.4078E-41)
                int r6 = r6 * r8
                long r8 = (long) r6
                long r4 = r4 + r8
                long r8 = java.lang.System.currentTimeMillis()
                int r6 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
                if (r6 > 0) goto L_0x013c
                r4 = 2
                r5 = 0
                com.startapp.x5 r6 = r2.b     // Catch:{ all -> 0x0123 }
                android.database.sqlite.SQLiteDatabase r6 = r6.a()     // Catch:{ all -> 0x0123 }
                r10 = 1
                java.lang.String[] r11 = new java.lang.String[r10]     // Catch:{ all -> 0x0123 }
                java.lang.String r12 = java.lang.String.valueOf(r8)     // Catch:{ all -> 0x0123 }
                r13 = 0
                r11[r13] = r12     // Catch:{ all -> 0x0123 }
                java.lang.String r12 = "SELECT requestId, statusId, requests.value AS request, statuses.value AS status, COUNT(*), MIN(durationNanos), MAX(durationNanos), AVG(durationNanos), MIN(timeMillis) FROM traces JOIN requests ON requests.id = traces.requestId JOIN statuses ON statuses.id = traces.statusId WHERE timeMillis < ? GROUP BY requestId, statusId"
                android.database.Cursor r5 = r6.rawQuery(r12, r11)     // Catch:{ all -> 0x0123 }
                if (r5 == 0) goto L_0x0120
            L_0x0045:
                boolean r6 = r5.moveToNext()     // Catch:{ all -> 0x0123 }
                if (r6 == 0) goto L_0x010b
                long r11 = r5.getLong(r13)     // Catch:{ all -> 0x0123 }
                long r14 = r5.getLong(r10)     // Catch:{ all -> 0x0123 }
                java.lang.String r6 = r5.getString(r4)     // Catch:{ all -> 0x0123 }
                r10 = 3
                java.lang.String r10 = r5.getString(r10)     // Catch:{ all -> 0x0123 }
                r13 = 4
                r16 = r2
                long r1 = r5.getLong(r13)     // Catch:{ all -> 0x0107 }
                int r13 = r3.b()     // Catch:{ all -> 0x0107 }
                r17 = r5
                long r4 = (long) r13     // Catch:{ all -> 0x0107 }
                int r13 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
                if (r13 >= 0) goto L_0x0078
                r1 = r24
                r2 = r16
                r5 = r17
                r4 = 2
                r10 = 1
                r13 = 0
                goto L_0x0045
            L_0x0078:
                r4 = 5
                r13 = r3
                r5 = r17
                long r3 = r5.getLong(r4)     // Catch:{ all -> 0x0107 }
                r17 = r13
                r13 = 6
                r19 = r6
                r18 = r7
                long r6 = r5.getLong(r13)     // Catch:{ all -> 0x0107 }
                r13 = 7
                r20 = r14
                long r13 = r5.getLong(r13)     // Catch:{ all -> 0x0107 }
                r15 = 8
                r22 = r11
                r12 = r10
                long r10 = r5.getLong(r15)     // Catch:{ all -> 0x0107 }
                java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0107 }
                r15.<init>()     // Catch:{ all -> 0x0107 }
                r15.append(r1)     // Catch:{ all -> 0x0107 }
                r15.append(r0)     // Catch:{ all -> 0x0107 }
                r15.append(r3)     // Catch:{ all -> 0x0107 }
                r15.append(r0)     // Catch:{ all -> 0x0107 }
                r15.append(r6)     // Catch:{ all -> 0x0107 }
                r15.append(r0)     // Catch:{ all -> 0x0107 }
                r15.append(r13)     // Catch:{ all -> 0x0107 }
                r15.append(r0)     // Catch:{ all -> 0x0107 }
                r15.append(r10)     // Catch:{ all -> 0x0107 }
                r15.append(r0)     // Catch:{ all -> 0x0107 }
                r15.append(r8)     // Catch:{ all -> 0x0107 }
                java.lang.String r1 = r15.toString()     // Catch:{ all -> 0x0107 }
                com.startapp.i3 r2 = new com.startapp.i3     // Catch:{ all -> 0x0107 }
                com.startapp.j3 r3 = com.startapp.j3.i     // Catch:{ all -> 0x0107 }
                r2.<init>((com.startapp.j3) r3)     // Catch:{ all -> 0x0107 }
                java.lang.Long r3 = java.lang.Long.valueOf(r8)     // Catch:{ all -> 0x0107 }
                r2.h = r3     // Catch:{ all -> 0x0107 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0107 }
                r3.<init>()     // Catch:{ all -> 0x0107 }
                r6 = r22
                r3.append(r6)     // Catch:{ all -> 0x0107 }
                java.lang.String r4 = ","
                r3.append(r4)     // Catch:{ all -> 0x0107 }
                r6 = r20
                r3.append(r6)     // Catch:{ all -> 0x0107 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0107 }
                r2.k = r3     // Catch:{ all -> 0x0107 }
                r3 = r19
                r2.i = r3     // Catch:{ all -> 0x0107 }
                r2.d = r12     // Catch:{ all -> 0x0107 }
                r2.e = r1     // Catch:{ all -> 0x0107 }
                r1 = r16
                com.startapp.n3 r3 = r1.f     // Catch:{ all -> 0x011e }
                r2.a((com.startapp.n3) r3)     // Catch:{ all -> 0x011e }
                r2 = r1
                r3 = r17
                r7 = r18
                r4 = 2
                r10 = 1
                r13 = 0
                r1 = r24
                goto L_0x0045
            L_0x0107:
                r0 = move-exception
                r1 = r16
                goto L_0x0125
            L_0x010b:
                r1 = r2
                r18 = r7
                android.content.SharedPreferences r0 = r1.a     // Catch:{ all -> 0x011e }
                android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ all -> 0x011e }
                r2 = r18
                android.content.SharedPreferences$Editor r0 = r0.putLong(r2, r8)     // Catch:{ all -> 0x011e }
                r0.commit()     // Catch:{ all -> 0x011e }
                goto L_0x0120
            L_0x011e:
                r0 = move-exception
                goto L_0x0125
            L_0x0120:
                if (r5 == 0) goto L_0x013c
                goto L_0x0131
            L_0x0123:
                r0 = move-exception
                r1 = r2
            L_0x0125:
                r2 = 2
                boolean r1 = r1.a(r2)     // Catch:{ all -> 0x0135 }
                if (r1 == 0) goto L_0x012f
                com.startapp.i3.a((java.lang.Throwable) r0)     // Catch:{ all -> 0x0135 }
            L_0x012f:
                if (r5 == 0) goto L_0x013c
            L_0x0131:
                r5.close()
                goto L_0x013c
            L_0x0135:
                r0 = move-exception
                if (r5 == 0) goto L_0x013b
                r5.close()
            L_0x013b:
                throw r0
            L_0x013c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.startapp.v5.a.run():void");
        }
    }

    /* compiled from: Sta */
    public class b implements n3 {

        /* compiled from: Sta */
        public class a implements Runnable {
            public final /* synthetic */ i3 a;

            public a(i3 i3Var) {
                this.a = i3Var;
            }

            public void run() {
                c cVar;
                String str;
                v5 v5Var = v5.this;
                i3 i3Var = this.a;
                v5Var.getClass();
                Long l = i3Var.h;
                String str2 = i3Var.k;
                if (str2 != null) {
                    String[] split = str2.split(",");
                    if (!(split.length != 2 || (str = split[0]) == null || split[1] == null)) {
                        try {
                            cVar = new c(Long.parseLong(str), Long.parseLong(split[1]));
                        } catch (NumberFormatException unused) {
                        }
                        if (l != null && cVar != null) {
                            try {
                                x5 x5Var = v5Var.b;
                                long j = cVar.a;
                                long j2 = cVar.b;
                                long longValue = l.longValue();
                                x5Var.a().delete("traces", "requestId = ? AND statusId = ? AND timeMillis < ?", new String[]{String.valueOf(j), String.valueOf(j2), String.valueOf(longValue)});
                                return;
                            } catch (Throwable th) {
                                if (v5Var.a(4)) {
                                    i3.a(th);
                                    return;
                                }
                                return;
                            }
                        }
                    }
                }
                cVar = null;
                if (l != null) {
                }
            }
        }

        public b() {
        }

        public void a(i3 i3Var, int i) {
            if (i == 1) {
                v5.this.c.execute(new a(i3Var));
            }
        }
    }

    /* compiled from: Sta */
    public static class c {
        public final long a;
        public final long b;

        public c(long j, long j2) {
            this.a = j;
            this.b = j2;
        }
    }

    public v5(Context context, SharedPreferences sharedPreferences, x5 x5Var, Executor executor, i2<NetworkDiagnosticConfig> i2Var) {
        this.a = sharedPreferences;
        this.b = x5Var;
        this.c = executor;
        this.d = i2Var;
    }

    public final NetworkDiagnosticConfig a() {
        NetworkDiagnosticConfig a2 = this.d.a();
        if (a2 == null || !a2.e()) {
            return null;
        }
        return a2;
    }

    public boolean a(int i) {
        NetworkDiagnosticConfig a2 = a();
        return a2 != null && (a2.a() & i) == i;
    }
}
