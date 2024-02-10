package com.startapp;

import android.text.TextUtils;
import com.startapp.sdk.common.SDKException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Set;
import kotlin.text.Typography;
import org.slf4j.Marker;

/* compiled from: Sta */
public class r5 extends r6 {
    public final Set<s5> a = new HashSet();

    public void a(String str, Object obj, boolean z, boolean z2) throws SDKException {
        if (z && obj == null) {
            throw new SDKException(str, (Throwable) null);
        } else if (obj != null && !TextUtils.isEmpty(obj.toString())) {
            try {
                s5 s5Var = new s5();
                s5Var.a = str;
                String obj2 = obj.toString();
                if (z2) {
                    obj2 = URLEncoder.encode(obj2, "UTF-8");
                }
                s5Var.b = obj2;
                if (!this.a.add(s5Var)) {
                    this.a.remove(s5Var);
                    this.a.add(s5Var);
                }
            } catch (UnsupportedEncodingException e) {
                if (z) {
                    throw new SDKException(str, e);
                }
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('?');
        for (s5 next : this.a) {
            if (next.b != null) {
                sb.append(next.a);
                sb.append('=');
                sb.append(next.b);
                sb.append(Typography.amp);
            } else {
                Set<String> set = next.c;
                if (set != null) {
                    for (String append : set) {
                        sb.append(next.a);
                        sb.append('=');
                        sb.append(append);
                        sb.append(Typography.amp);
                    }
                }
            }
        }
        if (sb.length() != 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString().replace(Marker.ANY_NON_NULL_MARKER, "%20");
    }

    public void a(String str, Set<String> set, boolean z, boolean z2) throws SDKException {
        if (z && set == null) {
            throw new SDKException(str, (Throwable) null);
        } else if (set != null) {
            s5 s5Var = new s5();
            s5Var.a = str;
            HashSet hashSet = new HashSet();
            for (String next : set) {
                if (z2) {
                    try {
                        next = URLEncoder.encode(next, "UTF-8");
                    } catch (UnsupportedEncodingException unused) {
                    }
                }
                hashSet.add(next);
            }
            if (!z || hashSet.size() != 0) {
                s5Var.c = hashSet;
                if (!this.a.add(s5Var)) {
                    this.a.remove(s5Var);
                    this.a.add(s5Var);
                    return;
                }
                return;
            }
            throw new SDKException(str, (Throwable) null);
        }
    }
}
