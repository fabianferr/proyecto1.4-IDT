package com.mbridge.msdk.e.a.a;

import com.mbridge.msdk.e.a.a;
import com.mbridge.msdk.e.a.g;
import com.mbridge.msdk.e.a.k;
import com.mbridge.msdk.e.a.v;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.TreeSet;
import org.apache.http.client.cache.HeaderConstants;

/* compiled from: HttpHeaderParser */
public final class e {
    public static a.C0133a a(k kVar) {
        long j;
        long j2;
        boolean z;
        long j3;
        long j4;
        long j5;
        k kVar2 = kVar;
        long currentTimeMillis = System.currentTimeMillis();
        Map<String, String> map = kVar2.c;
        if (map == null) {
            return null;
        }
        String str = map.get("Date");
        long a = str != null ? a(str) : 0;
        String str2 = map.get("Cache-Control");
        int i = 0;
        if (str2 != null) {
            String[] split = str2.split(",", 0);
            z = false;
            j2 = 0;
            j = 0;
            while (i < split.length) {
                String trim = split[i].trim();
                if (trim.equals(HeaderConstants.CACHE_CONTROL_NO_CACHE) || trim.equals(HeaderConstants.CACHE_CONTROL_NO_STORE)) {
                    return null;
                }
                if (trim.startsWith("max-age=")) {
                    try {
                        j2 = Long.parseLong(trim.substring(8));
                    } catch (Exception unused) {
                    }
                } else if (trim.startsWith("stale-while-revalidate=")) {
                    j = Long.parseLong(trim.substring(23));
                } else if (trim.equals(HeaderConstants.CACHE_CONTROL_MUST_REVALIDATE) || trim.equals(HeaderConstants.CACHE_CONTROL_PROXY_REVALIDATE)) {
                    z = true;
                }
                i++;
            }
            i = 1;
        } else {
            z = false;
            j2 = 0;
            j = 0;
        }
        String str3 = map.get("Expires");
        long a2 = str3 != null ? a(str3) : 0;
        String str4 = map.get("Last-Modified");
        long a3 = str4 != null ? a(str4) : 0;
        String str5 = map.get("ETag");
        if (i != 0) {
            j4 = currentTimeMillis + (j2 * 1000);
            if (z) {
                j5 = j4;
            } else {
                Long.signum(j);
                j5 = (j * 1000) + j4;
            }
            j3 = j5;
        } else {
            j3 = 0;
            if (a <= 0 || a2 < a) {
                j4 = 0;
            } else {
                j4 = currentTimeMillis + (a2 - a);
                j3 = j4;
            }
        }
        a.C0133a aVar = new a.C0133a();
        aVar.a = kVar2.b;
        aVar.b = str5;
        aVar.f = j4;
        aVar.e = j3;
        aVar.c = a;
        aVar.d = a3;
        aVar.g = map;
        aVar.h = kVar2.d;
        return aVar;
    }

    private static long a(String str) {
        try {
            Date parse = b("EEE, dd MMM yyyy HH:mm:ss zzz").parse(str);
            if (parse != null) {
                return parse.getTime();
            }
            return 0;
        } catch (ParseException e) {
            if ("0".equals(str) || "-1".equals(str)) {
                v.a("Unable to parse dateStr: %s, falling back to 0", str);
            } else {
                v.a(e, "Unable to parse dateStr: %s, falling back to 0", str);
            }
            return 0;
        }
    }

    static String a(long j) {
        return b("EEE, dd MMM yyyy HH:mm:ss 'GMT'").format(new Date(j));
    }

    private static SimpleDateFormat b(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.US);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        return simpleDateFormat;
    }

    public static String a(Map<String, String> map, String str) {
        String str2;
        if (!(map == null || (str2 = map.get("Content-Type")) == null)) {
            String[] split = str2.split(";", 0);
            for (int i = 1; i < split.length; i++) {
                String[] split2 = split[i].trim().split("=", 0);
                if (split2.length == 2 && split2[0].equals("charset")) {
                    return split2[1];
                }
            }
        }
        return str;
    }

    static List<g> a(List<g> list, a.C0133a aVar) {
        TreeSet treeSet = new TreeSet(String.CASE_INSENSITIVE_ORDER);
        if (!list.isEmpty()) {
            for (g a : list) {
                treeSet.add(a.a());
            }
        }
        ArrayList arrayList = new ArrayList(list);
        if (aVar.h != null) {
            if (!aVar.h.isEmpty()) {
                for (g next : aVar.h) {
                    if (!treeSet.contains(next.a())) {
                        arrayList.add(next);
                    }
                }
            }
        } else if (!aVar.g.isEmpty()) {
            for (Map.Entry next2 : aVar.g.entrySet()) {
                if (!treeSet.contains(next2.getKey())) {
                    arrayList.add(new g((String) next2.getKey(), (String) next2.getValue()));
                }
            }
        }
        return arrayList;
    }
}
