package com.mbridge.msdk.dycreator.e;

import android.text.TextUtils;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.mbridge.msdk.dycreator.baseview.inter.InterBase;
import com.mbridge.msdk.dycreator.f.a.a;
import com.mbridge.msdk.foundation.entity.CampaignEx;

/* compiled from: DYLogicUtil */
public final class d {
    public static boolean a(View view, a aVar) {
        String[] split;
        if (view == null) {
            return true;
        }
        try {
            if (!(view instanceof InterBase) || aVar == null) {
                return true;
            }
            String actionDes = ((InterBase) view).getActionDes();
            if (TextUtils.isEmpty(actionDes) || (split = actionDes.split("\\|")) == null || split.length < 2 || TextUtils.isEmpty(split[0]) || !split[0].startsWith(CampaignEx.JSON_NATIVE_VIDEO_CLICK) || TextUtils.isEmpty(split[1]) || !split[1].equals("alecfc") || aVar.getEffectData() == null) {
                return true;
            }
            return aVar.getEffectData().isClickScreen();
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static void a(String str, View view, boolean z) {
        if (view != null && (view instanceof InterBase) && !TextUtils.isEmpty(str)) {
            try {
                String[] split = str.split("\\|");
                if (split != null && split.length >= 2 && !TextUtils.isEmpty(split[0]) && split[0].startsWith("visible") && !TextUtils.isEmpty(split[1]) && split[1].equals("parent") && z) {
                    view.setVisibility(8);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:10|11|(1:13)|(2:15|16)) */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        if ((r4 instanceof com.mbridge.msdk.dycreator.f.a.a) != false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        r2 = ((com.mbridge.msdk.dycreator.f.a.a) r4).getBindData().getClass().getMethod(r5, new java.lang.Class[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        if (r2 != null) goto L_0x002f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        return r2.invoke(((com.mbridge.msdk.dycreator.f.a.a) r4).getBindData(), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        r4.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0015, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0018 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object a(java.lang.Object r4, java.lang.String r5) {
        /*
            r0 = 0
            r1 = 0
            java.lang.Class r2 = r4.getClass()     // Catch:{ NoSuchMethodException -> 0x0017 }
            java.lang.Class[] r3 = new java.lang.Class[r0]     // Catch:{ NoSuchMethodException -> 0x0017 }
            java.lang.reflect.Method r2 = r2.getMethod(r5, r3)     // Catch:{ NoSuchMethodException -> 0x0017 }
            if (r2 == 0) goto L_0x003f
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ NoSuchMethodException -> 0x0018 }
            java.lang.Object r4 = r2.invoke(r4, r3)     // Catch:{ NoSuchMethodException -> 0x0018 }
            return r4
        L_0x0015:
            r4 = move-exception
            goto L_0x003c
        L_0x0017:
            r2 = r1
        L_0x0018:
            boolean r3 = r4 instanceof com.mbridge.msdk.dycreator.f.a.a     // Catch:{ Exception -> 0x0015 }
            if (r3 == 0) goto L_0x002d
            r2 = r4
            com.mbridge.msdk.dycreator.f.a.a r2 = (com.mbridge.msdk.dycreator.f.a.a) r2     // Catch:{ Exception -> 0x0015 }
            com.mbridge.msdk.foundation.entity.CampaignEx r2 = r2.getBindData()     // Catch:{ Exception -> 0x0015 }
            java.lang.Class r2 = r2.getClass()     // Catch:{ Exception -> 0x0015 }
            java.lang.Class[] r3 = new java.lang.Class[r0]     // Catch:{ Exception -> 0x0015 }
            java.lang.reflect.Method r2 = r2.getMethod(r5, r3)     // Catch:{ Exception -> 0x0015 }
        L_0x002d:
            if (r2 == 0) goto L_0x003f
            com.mbridge.msdk.dycreator.f.a.a r4 = (com.mbridge.msdk.dycreator.f.a.a) r4     // Catch:{ Exception -> 0x0015 }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = r4.getBindData()     // Catch:{ Exception -> 0x0015 }
            java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x0015 }
            java.lang.Object r4 = r2.invoke(r4, r5)     // Catch:{ Exception -> 0x0015 }
            return r4
        L_0x003c:
            r4.printStackTrace()
        L_0x003f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.e.d.a(java.lang.Object, java.lang.String):java.lang.Object");
    }

    public static String a(boolean z, int i, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        if (TextUtils.isEmpty(str2) || !str2.contains("zh")) {
            return str + " " + i + CmcdHeadersFactory.STREAMING_FORMAT_SS;
        } else if (z) {
            return str + i + CmcdHeadersFactory.STREAMING_FORMAT_SS;
        } else {
            return i + "s " + str;
        }
    }
}
