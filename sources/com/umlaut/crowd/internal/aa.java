package com.umlaut.crowd.internal;

import android.util.Log;
import com.facebook.internal.security.CertificateUtil;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class aa {
    private static final String a = "aa";

    class a implements Comparator<T> {
        a() {
        }

        /* renamed from: a */
        public int compare(T t, T t2) {
            return t.name().compareTo(t2.name());
        }
    }

    static /* synthetic */ class b {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
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
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.Full     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.None     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.aa.b.<clinit>():void");
        }
    }

    public static String a(InetAddress inetAddress) {
        String hostAddress = inetAddress.getHostAddress();
        if (inetAddress instanceof Inet4Address) {
            return hostAddress.substring(0, hostAddress.lastIndexOf(46)) + ".xxx";
        }
        String str = "";
        if (!(inetAddress instanceof Inet6Address)) {
            return str;
        }
        String[] split = hostAddress.split(CertificateUtil.DELIMITER);
        int length = split.length - 4;
        if (length < 0) {
            length = 0;
        }
        for (int i = 0; i < length; i++) {
            str = str + split[i] + CertificateUtil.DELIMITER;
        }
        return str + "x:x:x:x";
    }

    public static String b(String str) {
        if (str.length() != 32) {
            return str;
        }
        return str.substring(0, 7) + "-" + str.substring(7, 11) + "-" + str.substring(11, 15) + "-" + str.substring(15, 19) + "-" + str.substring(19, 31);
    }

    public static boolean c(String str) {
        return str == null || str.length() == 0;
    }

    public static String d(String str) {
        return (str.length() <= 1 || !str.startsWith("\"") || !str.endsWith("\"")) ? str : str.substring(1, str.length() - 1);
    }

    public static String a(String str, d dVar) {
        if (str == null) {
            str = "";
        }
        int i = b.a[dVar.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return "";
            }
            return str;
        } else if (str.length() <= 3) {
            return "***";
        } else {
            return str.substring(0, str.length() - 3) + "***";
        }
    }

    public static String a(String str) {
        return str == null ? "" : str.replaceAll("[\u0000-\u001f]", "").trim();
    }

    public static String a(List<String> list) {
        if (list == null || list.size() == 0) {
            return "";
        }
        int i = 0;
        for (String length : list) {
            i += length.length();
        }
        StringBuffer stringBuffer = new StringBuffer(i);
        for (String append : list) {
            stringBuffer.append(append);
        }
        return stringBuffer.toString();
    }

    public static String[] a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            if (str != null && str.length() > 0) {
                arrayList.add(str);
            }
        }
        return (String[]) arrayList.toArray(new String[arrayList.size()]);
    }

    public static String a(InputStream inputStream, String str) {
        StringWriter stringWriter = new StringWriter();
        char[] cArr = new char[1024];
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, str));
            while (true) {
                int read = bufferedReader.read(cArr);
                if (read != -1) {
                    stringWriter.write(cArr, 0, read);
                } else {
                    bufferedReader.close();
                    return stringWriter.toString();
                }
            }
        } catch (Exception e) {
            String str2 = a;
            Log.e(str2, "fromStream: " + e.getMessage());
            return null;
        }
    }

    public static <T extends Enum<T>> String a(ArrayList<T> arrayList, char c, boolean z) {
        if (arrayList == null || arrayList.isEmpty()) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        ArrayList arrayList2 = new ArrayList(arrayList);
        if (z) {
            Collections.sort(arrayList2, new a());
        }
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            sb.append(((Enum) it.next()).name());
            sb.append(c);
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }
}
