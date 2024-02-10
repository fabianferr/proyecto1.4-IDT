package com.bytedance.sdk.openadsdk.utils;

import android.text.TextUtils;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.o;
import java.util.Map;

/* compiled from: TTClientBiddingUtil */
public class w {
    public static void a(q qVar, Double d) {
        if (qVar != null && qVar.ai() != null) {
            Map<String, Object> ai = qVar.ai();
            try {
                Object obj = qVar.ai().get("sdk_bidding_type");
                if (obj == null) {
                    return;
                }
                if (Integer.parseInt(obj.toString()) == 2) {
                    String str = (String) ai.get("nurl");
                    if (!TextUtils.isEmpty(str)) {
                        if (d != null) {
                            str = str.replace("${AUCTION_BID_TO_WIN}", String.valueOf(d));
                        }
                        o.c().a(str);
                    }
                }
            } catch (Throwable unused) {
                l.d("report Win error");
            }
        }
    }

    public static void a(q qVar, Double d, String str, String str2) {
        if (qVar != null && qVar.ai() != null) {
            Map<String, Object> ai = qVar.ai();
            try {
                Object obj = qVar.ai().get("sdk_bidding_type");
                if (obj == null) {
                    return;
                }
                if (Integer.parseInt(obj.toString()) == 2) {
                    String str3 = (String) ai.get("lurl");
                    if (!TextUtils.isEmpty(str3)) {
                        if (d != null) {
                            str3 = str3.replace("${AUCTION_PRICE}", String.valueOf(d));
                        }
                        if (str != null) {
                            str3 = str3.replace("${AUCTION_LOSS}", str);
                        }
                        if (str2 != null) {
                            str3 = str3.replace("${AUCTION_WINNER}", str2);
                        }
                        o.c().a(str3);
                    }
                }
            } catch (Throwable unused) {
                l.d("report Loss error");
            }
        }
    }
}
