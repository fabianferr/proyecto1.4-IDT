package com.mbridge.msdk.scheme.report;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.same.a;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.d.b;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.w;

public class AppletsReport {
    public static final String APPLETS_API_VALUE = "2000118";
    /* access modifiers changed from: private */
    public static final String TAG = "com.mbridge.msdk.scheme.report.AppletsReport";

    public static void reportAppletsLoadState(Context context, String str, String str2, String str3) {
        if (context != null) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    StringBuffer stringBuffer = new StringBuffer("key=2000118&");
                    stringBuffer.append("network_type=" + w.r(context) + "&");
                    stringBuffer.append("unit_id=" + str2 + "&");
                    if (!TextUtils.isEmpty(a.l)) {
                        stringBuffer.append("b=" + a.l + "&");
                    }
                    if (!TextUtils.isEmpty(a.m)) {
                        stringBuffer.append("c=" + a.m + "&");
                    }
                    stringBuffer.append("hb=0&");
                    if (!TextUtils.isEmpty(str3)) {
                        stringBuffer.append("rid_n=").append(str3).append("&");
                    }
                    stringBuffer.append("reason=" + str);
                    if (k.a().c()) {
                        k.a().a(stringBuffer.toString());
                    } else {
                        reportLoadData(context, stringBuffer.toString());
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    private static void reportLoadData(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                new com.mbridge.msdk.foundation.same.report.d.a(context).post(0, d.a().a, q.a(str, context), new b() {
                    public final void onSuccess(String str) {
                        aa.d(AppletsReport.TAG, str);
                    }

                    public final void onFailed(String str) {
                        aa.d(AppletsReport.TAG, str);
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
                aa.d(TAG, e.getMessage());
            }
        }
    }
}
