package com.umlaut.crowd.internal;

import android.net.LinkProperties;
import android.net.NetworkCapabilities;
import android.text.TextUtils;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

public class h {

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.umlaut.crowd.internal.d[] r0 = com.umlaut.crowd.internal.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.Anonymized     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.Hashed     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.AnonymizedAndHashed     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.Full     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.None     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.h.a.<clinit>():void");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000b, code lost:
        r2 = r4.getNetworkSpecifier();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int b(android.net.NetworkCapabilities r4) {
        /*
            java.lang.String r0 = ""
            r1 = -1
            if (r4 == 0) goto L_0x003b
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 30
            if (r2 < r3) goto L_0x001c
            android.net.NetworkSpecifier r2 = r4.getNetworkSpecifier()
            if (r2 == 0) goto L_0x001c
            boolean r3 = r2 instanceof android.net.TelephonyNetworkSpecifier
            if (r3 == 0) goto L_0x001c
            android.net.TelephonyNetworkSpecifier r2 = (android.net.TelephonyNetworkSpecifier) r2
            int r2 = r2.getSubscriptionId()
            goto L_0x001d
        L_0x001c:
            r2 = -1
        L_0x001d:
            if (r2 != r1) goto L_0x003a
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x003a }
            java.lang.String r1 = "Specifier:"
            java.lang.String r4 = a((java.lang.String) r4, (java.lang.String) r1)     // Catch:{ Exception -> 0x003a }
            java.lang.String r1 = "<"
            java.lang.String r4 = r4.replaceAll(r1, r0)     // Catch:{ Exception -> 0x003a }
            java.lang.String r1 = ">"
            java.lang.String r4 = r4.replaceAll(r1, r0)     // Catch:{ Exception -> 0x003a }
            int r1 = java.lang.Integer.parseInt(r4)     // Catch:{ Exception -> 0x003a }
            goto L_0x003b
        L_0x003a:
            r1 = r2
        L_0x003b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.h.b(android.net.NetworkCapabilities):int");
    }

    public static String a(NetworkCapabilities networkCapabilities) {
        if (networkCapabilities != null) {
            try {
                return a(networkCapabilities.toString(), "Capabilities:").replaceAll("&", ",").toLowerCase();
            } catch (Exception unused) {
            }
        }
        return "";
    }

    public static String a(LinkProperties linkProperties) {
        if (linkProperties == null) {
            return "";
        }
        try {
            String a2 = a(linkProperties.toString().replaceAll("\\[ ", "\\[").replaceAll(" \\]", "\\]").replaceAll("/", ""), "PcscfAddresses:");
            if (a2.isEmpty()) {
                return "";
            }
            String replace = a2.replace("[", "").replace("]", "");
            if (replace.lastIndexOf(",") == replace.length() - 1) {
                replace = replace.substring(0, replace.length() - 1);
            }
            return replace;
        } catch (Exception unused) {
            return "";
        }
    }

    public static String a(String str, d dVar) {
        if (str != null && !str.isEmpty()) {
            ArrayList arrayList = new ArrayList();
            for (String str2 : str.split(",")) {
                int i = a.a[dVar.ordinal()];
                if (i == 1) {
                    arrayList.add(aa.a(InetAddress.getByName(str2)));
                } else if (i == 2) {
                    arrayList.add("HASH:" + k3.a(str2));
                } else if (i == 3) {
                    try {
                        arrayList.add("IP:" + aa.a(InetAddress.getByName(str2)) + "-" + ("HASH:" + k3.a(str2)));
                    } catch (UnknownHostException unused) {
                    }
                } else if (i == 4) {
                    arrayList.add(str2);
                }
            }
            if (arrayList.size() > 0) {
                return TextUtils.join(",", arrayList);
            }
        }
        return "";
    }

    private static String a(String str, String str2) throws Exception {
        String substring = str.substring(str.indexOf(str2));
        String replaceAll = substring.replaceAll(str2 + " ", "");
        return replaceAll.substring(0, replaceAll.contains(" ") ? replaceAll.indexOf(" ") : replaceAll.length() - 1);
    }
}
