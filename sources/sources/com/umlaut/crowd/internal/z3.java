package com.umlaut.crowd.internal;

import android.content.Context;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import javax.net.ssl.X509TrustManager;

public class z3 implements X509TrustManager {
    private static final boolean e = false;
    private static final String f = "z3";
    private static String g = "";
    private static boolean h = false;
    private static X509TrustManager i = null;
    private static X509TrustManager j = null;
    private static final String k = "R_hqKukfFZxKn52";
    private static final X509TrustManager l = new a();
    private X509TrustManager[] a;
    private s1[] b;
    private String c = "";
    private s1 d = s1.Unknown;

    class a implements X509TrustManager {
        a() {
        }

        public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) {
        }

        public X509Certificate[] getAcceptedIssuers() {
            return new X509Certificate[0];
        }
    }

    public z3(Context context, boolean z) {
        a(context, z);
        X509TrustManager[] x509TrustManagerArr = new X509TrustManager[3];
        this.a = x509TrustManagerArr;
        s1[] s1VarArr = new s1[3];
        this.b = s1VarArr;
        x509TrustManagerArr[0] = i;
        s1VarArr[0] = s1.SSLOwnTs;
        x509TrustManagerArr[1] = j;
        s1VarArr[1] = s1.SSLDeviceTs;
        x509TrustManagerArr[2] = l;
        s1VarArr[2] = s1.SSLTrustAll;
        this.c = g;
    }

    public String a() {
        return this.c;
    }

    public s1 b() {
        return this.d;
    }

    public void checkClientTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
    }

    public void checkServerTrusted(X509Certificate[] x509CertificateArr, String str) throws CertificateException {
        int i2 = 0;
        while (true) {
            X509TrustManager[] x509TrustManagerArr = this.a;
            if (i2 < x509TrustManagerArr.length) {
                X509TrustManager x509TrustManager = x509TrustManagerArr[i2];
                if (x509TrustManager != null) {
                    try {
                        this.d = this.b[i2];
                        x509TrustManager.checkServerTrusted(x509CertificateArr, str);
                        return;
                    } catch (CertificateException e2) {
                        if (i2 == 0) {
                            this.c += e2.getMessage();
                        }
                        if (i2 + 1 == this.a.length) {
                            throw e2;
                        }
                    }
                } else {
                    i2++;
                }
            } else {
                return;
            }
        }
    }

    public X509Certificate[] getAcceptedIssuers() {
        return j.getAcceptedIssuers();
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:34:0x0082 */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0094 A[Catch:{ Exception -> 0x00b2 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00ca A[EDGE_INSN: B:55:0x00ca->B:48:0x00ca ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(android.content.Context r7, boolean r8) {
        /*
            r6 = this;
            boolean r0 = h
            if (r0 == 0) goto L_0x0007
            if (r8 != 0) goto L_0x0007
            return
        L_0x0007:
            java.lang.Class<com.umlaut.crowd.internal.z3> r0 = com.umlaut.crowd.internal.z3.class
            monitor-enter(r0)
            boolean r1 = h     // Catch:{ all -> 0x00cf }
            if (r1 == 0) goto L_0x0012
            if (r8 != 0) goto L_0x0012
            monitor-exit(r0)     // Catch:{ all -> 0x00cf }
            return
        L_0x0012:
            java.lang.String r8 = ""
            g = r8     // Catch:{ all -> 0x00cf }
            r8 = 0
            java.lang.String r1 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()     // Catch:{ Exception -> 0x0039 }
            javax.net.ssl.TrustManagerFactory r1 = javax.net.ssl.TrustManagerFactory.getInstance(r1)     // Catch:{ Exception -> 0x0039 }
            r2 = 0
            r1.init(r2)     // Catch:{ Exception -> 0x0039 }
            javax.net.ssl.TrustManager[] r1 = r1.getTrustManagers()     // Catch:{ Exception -> 0x0039 }
            int r2 = r1.length     // Catch:{ Exception -> 0x0039 }
            r3 = 0
        L_0x0029:
            if (r3 >= r2) goto L_0x0051
            r4 = r1[r3]     // Catch:{ Exception -> 0x0039 }
            boolean r5 = r4 instanceof javax.net.ssl.X509TrustManager     // Catch:{ Exception -> 0x0039 }
            if (r5 == 0) goto L_0x0036
            javax.net.ssl.X509TrustManager r4 = (javax.net.ssl.X509TrustManager) r4     // Catch:{ Exception -> 0x0039 }
            j = r4     // Catch:{ Exception -> 0x0039 }
            goto L_0x0051
        L_0x0036:
            int r3 = r3 + 1
            goto L_0x0029
        L_0x0039:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r2.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r3 = g     // Catch:{ all -> 0x00cf }
            r2.append(r3)     // Catch:{ all -> 0x00cf }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x00cf }
            r2.append(r1)     // Catch:{ all -> 0x00cf }
            java.lang.String r1 = r2.toString()     // Catch:{ all -> 0x00cf }
            g = r1     // Catch:{ all -> 0x00cf }
        L_0x0051:
            java.io.File r1 = com.umlaut.crowd.internal.sc.c(r7)     // Catch:{ Exception -> 0x00b2 }
            java.io.File r7 = com.umlaut.crowd.internal.sc.d(r7)     // Catch:{ Exception -> 0x00b2 }
            boolean r2 = r1.exists()     // Catch:{ Exception -> 0x00b2 }
            if (r2 == 0) goto L_0x00aa
            boolean r2 = r7.exists()     // Catch:{ Exception -> 0x00b2 }
            if (r2 == 0) goto L_0x00aa
            boolean r7 = com.umlaut.crowd.internal.sc.a((java.io.File) r1, (java.io.File) r7)     // Catch:{ Exception -> 0x00b2 }
            if (r7 == 0) goto L_0x00a2
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ Exception -> 0x00b2 }
            r7.<init>(r1)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r1 = "BKS"
            java.security.KeyStore r1 = java.security.KeyStore.getInstance(r1)     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r2 = "R_hqKukfFZxKn52"
            char[] r2 = r2.toCharArray()     // Catch:{ Exception -> 0x00b2 }
            r1.load(r7, r2)     // Catch:{ Exception -> 0x00b2 }
            r7.close()     // Catch:{ IOException -> 0x0082 }
        L_0x0082:
            java.lang.String r7 = javax.net.ssl.TrustManagerFactory.getDefaultAlgorithm()     // Catch:{ Exception -> 0x00b2 }
            javax.net.ssl.TrustManagerFactory r7 = javax.net.ssl.TrustManagerFactory.getInstance(r7)     // Catch:{ Exception -> 0x00b2 }
            r7.init(r1)     // Catch:{ Exception -> 0x00b2 }
            javax.net.ssl.TrustManager[] r7 = r7.getTrustManagers()     // Catch:{ Exception -> 0x00b2 }
            int r1 = r7.length     // Catch:{ Exception -> 0x00b2 }
        L_0x0092:
            if (r8 >= r1) goto L_0x00ca
            r2 = r7[r8]     // Catch:{ Exception -> 0x00b2 }
            boolean r3 = r2 instanceof javax.net.ssl.X509TrustManager     // Catch:{ Exception -> 0x00b2 }
            if (r3 == 0) goto L_0x009f
            javax.net.ssl.X509TrustManager r2 = (javax.net.ssl.X509TrustManager) r2     // Catch:{ Exception -> 0x00b2 }
            i = r2     // Catch:{ Exception -> 0x00b2 }
            goto L_0x00ca
        L_0x009f:
            int r8 = r8 + 1
            goto L_0x0092
        L_0x00a2:
            java.security.KeyStoreException r7 = new java.security.KeyStoreException     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r8 = "Verification of downloaded truststore failed"
            r7.<init>(r8)     // Catch:{ Exception -> 0x00b2 }
            throw r7     // Catch:{ Exception -> 0x00b2 }
        L_0x00aa:
            java.security.KeyStoreException r7 = new java.security.KeyStoreException     // Catch:{ Exception -> 0x00b2 }
            java.lang.String r8 = "Downloaded truststore not available"
            r7.<init>(r8)     // Catch:{ Exception -> 0x00b2 }
            throw r7     // Catch:{ Exception -> 0x00b2 }
        L_0x00b2:
            r7 = move-exception
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cf }
            r8.<init>()     // Catch:{ all -> 0x00cf }
            java.lang.String r1 = g     // Catch:{ all -> 0x00cf }
            r8.append(r1)     // Catch:{ all -> 0x00cf }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x00cf }
            r8.append(r7)     // Catch:{ all -> 0x00cf }
            java.lang.String r7 = r8.toString()     // Catch:{ all -> 0x00cf }
            g = r7     // Catch:{ all -> 0x00cf }
        L_0x00ca:
            r7 = 1
            h = r7     // Catch:{ all -> 0x00cf }
            monitor-exit(r0)     // Catch:{ all -> 0x00cf }
            return
        L_0x00cf:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00cf }
            goto L_0x00d3
        L_0x00d2:
            throw r7
        L_0x00d3:
            goto L_0x00d2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.z3.a(android.content.Context, boolean):void");
    }
}
