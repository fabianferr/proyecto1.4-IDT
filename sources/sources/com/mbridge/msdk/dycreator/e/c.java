package com.mbridge.msdk.dycreator.e;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.mbridge.msdk.dycreator.binding.b;
import com.mbridge.msdk.foundation.tools.aa;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/* compiled from: CommUtil */
public final class c {
    public static double a(double d, double d2, int i) {
        if (i < 0) {
            return 1.0d;
        }
        try {
            return new BigDecimal(Double.toString(d)).divide(new BigDecimal(Double.toString(d2)), i, 4).doubleValue();
        } catch (Exception e) {
            aa.d("CommUtil", e.getMessage());
            return 1.0d;
        }
    }

    public static int a(Context context, float f) {
        if (context == null) {
            return 0;
        }
        try {
            Resources resources = context.getResources();
            if (resources == null) {
                return 0;
            }
            return (int) ((f * resources.getDisplayMetrics().density) + 0.5f);
        } catch (Exception e) {
            aa.d("CommUtil", e.getMessage());
            return 0;
        }
    }

    public static Map<String, String> a(Context context, AttributeSet attributeSet) {
        HashMap hashMap = new HashMap();
        if (!(context == null || attributeSet == null)) {
            int attributeCount = attributeSet.getAttributeCount();
            for (int i = 0; i < attributeCount; i++) {
                String attributeName = attributeSet.getAttributeName(i);
                if (!TextUtils.isEmpty(attributeName)) {
                    if (attributeName.equals("mbridge_data")) {
                        try {
                            hashMap.put("mbridgeData", b.a.get(attributeSet.getAttributeValue(i).substring(8)));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    if (attributeName.equals("mbridge_click")) {
                        try {
                            hashMap.put("mbridgeAction", b.a.get(attributeSet.getAttributeValue(i).substring(8)));
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                    if (attributeName.equals("mbridge_strategy")) {
                        try {
                            hashMap.put("mbridgeStrategy", b.a.get(attributeSet.getAttributeValue(i).substring(8)));
                        } catch (Exception e3) {
                            e3.printStackTrace();
                        }
                    }
                    if (attributeName.equals("mbridge_effect")) {
                        try {
                            hashMap.put("mbridgeEffect", b.a.get(attributeSet.getAttributeValue(i).substring(8)));
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    if (attributeName.equals("mbridge_report")) {
                        try {
                            hashMap.put("mbridgeReport", attributeSet.getAttributeValue(i));
                        } catch (Exception e5) {
                            e5.printStackTrace();
                        }
                    }
                }
            }
        }
        return hashMap;
    }

    public static void a(Map<String, String> map, View view) {
        if (map != null && view != null) {
            if (map.containsKey("mbridgeData")) {
                b.a().c(view);
            }
            if (map.containsKey("mbridgeAction")) {
                b.a().d(view);
            }
            if (map.containsKey("mbridgeEffect")) {
                b.a().b(view);
            }
            if (map.containsKey("mbridgeReport")) {
                b.a().a(view);
            }
        }
    }

    public static Map<String, Boolean> a(String str) {
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(str)) {
            String[] split = str.split("\\|");
            if (split == null || split.length <= 0) {
                if (str.equals("mbridgeAttached")) {
                    hashMap.put("mbridgeAttached", true);
                }
                if (str.equals("mbridgeDetached")) {
                    hashMap.put("mbridgeDetached", true);
                }
            } else {
                for (String str2 : split) {
                    if (str2.equals("mbridgeAttached")) {
                        hashMap.put("mbridgeAttached", true);
                    }
                    if (str2.equals("mbridgeDetached")) {
                        hashMap.put("mbridgeDetached", true);
                    }
                }
            }
        }
        return hashMap;
    }
}
