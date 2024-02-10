package com.appnext.core.a;

import android.content.Context;
import android.text.TextUtils;
import com.appnext.core.n;
import com.appnext.core.o;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    private static a dZ;
    /* access modifiers changed from: private */
    public String dY;

    private a(final Context context) {
        n.aa().a(new Runnable() {
            public final void run() {
                try {
                    a aVar = a.this;
                    o.ab();
                    aVar.dY = o.i(context);
                } catch (Throwable th) {
                    com.appnext.base.a.a("Language$Language", th);
                }
            }
        });
    }

    public static synchronized a n(Context context) {
        a aVar;
        synchronized (a.class) {
            if (dZ == null) {
                dZ = new a(context.getApplicationContext());
            }
            aVar = dZ;
        }
        return aVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        com.appnext.base.a.a("Translate$translate", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0033, code lost:
        com.appnext.base.a.a("Translate$translate", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003b, code lost:
        com.appnext.base.a.a("Translate$translate", r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        return a("{\"EN\":{\"settings\":{\"active\":true,\"len\":12,\"font_size_px\":12,\"font_size_sp\":10},\"new\":{\"Install\":\"Install\",\"Download\":\"Download\",\"Shop\":\"Shop\",\"Sign up\":\"Sign up\",\"Watch\":\"Watch\",\"Join\":\"Join\",\"Start\":\"Start\",\"Subscribe\":\"Subscribe\",\"Add\":\"Add\",\"Search\":\"Search\",\"Share\":\"Share\",\"Get\":\"Get\",\"Book\":\"Book\",\"Play\":\"Play\"},\"existing\":{\"Install\":\"Install\",\"Use\":\"Use\",\"Play\":\"Play\",\"Reserve\":\"Reserve\",\"Buy\":\"Buy\",\"View\":\"View\",\"Log in\":\"Log in\",\"Listen\":\"Listen\",\"Read\":\"Read\",\"Watch\":\"Watch\",\"See more\":\"See more\",\"Find\":\"Find\",\"Book\":\"Book\",\"Chat\":\"Chat\",\"Park\":\"Park\",\"Open\":\"Open\",\"Exercise\":\"Exercise\",\"Optimize\":\"Optimize\"}},\"KO\":{\"settings\":{\"active\":true,\"len\":10,\"font_size_px\":12,\"font_size_sp\":10},\"new\":{\"Install\":\"설치\",\"Download\":\"다운로드\",\"Shop\":\"가게에서 물건을 사다\",\"Sign up\":\"회원가입\",\"Watch\":\"보다\",\"Join\":\"입회하다\",\"Start\":\"시작\",\"Subscribe\":\"구독\",\"Add\":\"추가\",\"Search\":\"검색\",\"Share\":\"공유\",\"Get\":\"얻다\",\"Book\":\"예약\",\"Play\":\"재생\"},\"existing\":{\"Install\":\"설치\",\"Use\":\"설치\",\"Play\":\"재생\",\"Reserve\":\"예약하기\",\"Buy\":\"구매하기\",\"View\":\"바라보다\",\"Log in\":\"로그인\",\"Listen\":\"듣기\",\"Read\":\"읽기\",\"Watch\":\"보기\",\"See more\":\"더 보기\",\"Find\":\"찾기\",\"Book\":\"예약\",\"Chat\":\"채팅\",\"Park\":\"읽기\",\"Open\":\"개장\",\"Exercise\":\"연습하다\",\"Optimize\":\"최적화하기\"}}}", r5, r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return a(r4.dY, "EN", r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return a("{\"EN\":{\"settings\":{\"active\":true,\"len\":12,\"font_size_px\":12,\"font_size_sp\":10},\"new\":{\"Install\":\"Install\",\"Download\":\"Download\",\"Shop\":\"Shop\",\"Sign up\":\"Sign up\",\"Watch\":\"Watch\",\"Join\":\"Join\",\"Start\":\"Start\",\"Subscribe\":\"Subscribe\",\"Add\":\"Add\",\"Search\":\"Search\",\"Share\":\"Share\",\"Get\":\"Get\",\"Book\":\"Book\",\"Play\":\"Play\"},\"existing\":{\"Install\":\"Install\",\"Use\":\"Use\",\"Play\":\"Play\",\"Reserve\":\"Reserve\",\"Buy\":\"Buy\",\"View\":\"View\",\"Log in\":\"Log in\",\"Listen\":\"Listen\",\"Read\":\"Read\",\"Watch\":\"Watch\",\"See more\":\"See more\",\"Find\":\"Find\",\"Book\":\"Book\",\"Chat\":\"Chat\",\"Park\":\"Park\",\"Open\":\"Open\",\"Exercise\":\"Exercise\",\"Optimize\":\"Optimize\"}},\"KO\":{\"settings\":{\"active\":true,\"len\":10,\"font_size_px\":12,\"font_size_sp\":10},\"new\":{\"Install\":\"설치\",\"Download\":\"다운로드\",\"Shop\":\"가게에서 물건을 사다\",\"Sign up\":\"회원가입\",\"Watch\":\"보다\",\"Join\":\"입회하다\",\"Start\":\"시작\",\"Subscribe\":\"구독\",\"Add\":\"추가\",\"Search\":\"검색\",\"Share\":\"공유\",\"Get\":\"얻다\",\"Book\":\"예약\",\"Play\":\"재생\"},\"existing\":{\"Install\":\"설치\",\"Use\":\"설치\",\"Play\":\"재생\",\"Reserve\":\"예약하기\",\"Buy\":\"구매하기\",\"View\":\"바라보다\",\"Log in\":\"로그인\",\"Listen\":\"듣기\",\"Read\":\"읽기\",\"Watch\":\"보기\",\"See more\":\"더 보기\",\"Find\":\"찾기\",\"Book\":\"예약\",\"Chat\":\"채팅\",\"Park\":\"읽기\",\"Open\":\"개장\",\"Exercise\":\"연습하다\",\"Optimize\":\"최적화하기\"}}}", "EN", r6, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0026, code lost:
        r5 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(java.lang.String r5, java.lang.String r6, java.lang.String r7) {
        /*
            r4 = this;
            java.lang.String r0 = "EN"
            java.lang.String r1 = "{\"EN\":{\"settings\":{\"active\":true,\"len\":12,\"font_size_px\":12,\"font_size_sp\":10},\"new\":{\"Install\":\"Install\",\"Download\":\"Download\",\"Shop\":\"Shop\",\"Sign up\":\"Sign up\",\"Watch\":\"Watch\",\"Join\":\"Join\",\"Start\":\"Start\",\"Subscribe\":\"Subscribe\",\"Add\":\"Add\",\"Search\":\"Search\",\"Share\":\"Share\",\"Get\":\"Get\",\"Book\":\"Book\",\"Play\":\"Play\"},\"existing\":{\"Install\":\"Install\",\"Use\":\"Use\",\"Play\":\"Play\",\"Reserve\":\"Reserve\",\"Buy\":\"Buy\",\"View\":\"View\",\"Log in\":\"Log in\",\"Listen\":\"Listen\",\"Read\":\"Read\",\"Watch\":\"Watch\",\"See more\":\"See more\",\"Find\":\"Find\",\"Book\":\"Book\",\"Chat\":\"Chat\",\"Park\":\"Park\",\"Open\":\"Open\",\"Exercise\":\"Exercise\",\"Optimize\":\"Optimize\"}},\"KO\":{\"settings\":{\"active\":true,\"len\":10,\"font_size_px\":12,\"font_size_sp\":10},\"new\":{\"Install\":\"설치\",\"Download\":\"다운로드\",\"Shop\":\"가게에서 물건을 사다\",\"Sign up\":\"회원가입\",\"Watch\":\"보다\",\"Join\":\"입회하다\",\"Start\":\"시작\",\"Subscribe\":\"구독\",\"Add\":\"추가\",\"Search\":\"검색\",\"Share\":\"공유\",\"Get\":\"얻다\",\"Book\":\"예약\",\"Play\":\"재생\"},\"existing\":{\"Install\":\"설치\",\"Use\":\"설치\",\"Play\":\"재생\",\"Reserve\":\"예약하기\",\"Buy\":\"구매하기\",\"View\":\"바라보다\",\"Log in\":\"로그인\",\"Listen\":\"듣기\",\"Read\":\"읽기\",\"Watch\":\"보기\",\"See more\":\"더 보기\",\"Find\":\"찾기\",\"Book\":\"예약\",\"Chat\":\"채팅\",\"Park\":\"읽기\",\"Open\":\"개장\",\"Exercise\":\"연습하다\",\"Optimize\":\"최적화하기\"}}}"
            if (r5 == 0) goto L_0x000e
            java.lang.String r2 = ""
            boolean r2 = r5.equals(r2)
            if (r2 == 0) goto L_0x001a
        L_0x000e:
            java.util.Locale r5 = java.util.Locale.getDefault()
            java.lang.String r5 = r5.getLanguage()
            java.lang.String r5 = r5.toUpperCase()
        L_0x001a:
            java.lang.String r2 = r4.dY     // Catch:{ all -> 0x0021 }
            java.lang.String r7 = a(r2, r5, r6, r7)     // Catch:{ all -> 0x0021 }
            goto L_0x003e
        L_0x0021:
            java.lang.String r7 = a(r1, r5, r6, r7)     // Catch:{ all -> 0x0026 }
            goto L_0x003e
        L_0x0026:
            r5 = move-exception
            java.lang.String r2 = "Translate$translate"
            com.appnext.base.a.a(r2, r5)
            java.lang.String r3 = r4.dY     // Catch:{ all -> 0x0033 }
            java.lang.String r7 = a(r3, r0, r6, r7)     // Catch:{ all -> 0x0033 }
            goto L_0x003e
        L_0x0033:
            com.appnext.base.a.a(r2, r5)
            java.lang.String r7 = a(r1, r0, r6, r7)     // Catch:{ all -> 0x003b }
            goto L_0x003e
        L_0x003b:
            com.appnext.base.a.a(r2, r5)
        L_0x003e:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appnext.core.a.a.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    private static String a(String str, String str2, String str3, String str4) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        if (!jSONObject.has(str2)) {
            str2 = "EN";
            if (!jSONObject.has(str2)) {
                str2 = null;
            }
        }
        return (TextUtils.isEmpty(str2) || !jSONObject.getJSONObject(str2).getJSONObject("settings").getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE)) ? str4 : jSONObject.getJSONObject(str2).getJSONObject(str3).getString(str4);
    }

    public final String ag() {
        String str = this.dY;
        return str != null ? str : "{\"EN\":{\"settings\":{\"active\":true,\"len\":12,\"font_size_px\":12,\"font_size_sp\":10},\"new\":{\"Install\":\"Install\",\"Download\":\"Download\",\"Shop\":\"Shop\",\"Sign up\":\"Sign up\",\"Watch\":\"Watch\",\"Join\":\"Join\",\"Start\":\"Start\",\"Subscribe\":\"Subscribe\",\"Add\":\"Add\",\"Search\":\"Search\",\"Share\":\"Share\",\"Get\":\"Get\",\"Book\":\"Book\",\"Play\":\"Play\"},\"existing\":{\"Install\":\"Install\",\"Use\":\"Use\",\"Play\":\"Play\",\"Reserve\":\"Reserve\",\"Buy\":\"Buy\",\"View\":\"View\",\"Log in\":\"Log in\",\"Listen\":\"Listen\",\"Read\":\"Read\",\"Watch\":\"Watch\",\"See more\":\"See more\",\"Find\":\"Find\",\"Book\":\"Book\",\"Chat\":\"Chat\",\"Park\":\"Park\",\"Open\":\"Open\",\"Exercise\":\"Exercise\",\"Optimize\":\"Optimize\"}},\"KO\":{\"settings\":{\"active\":true,\"len\":10,\"font_size_px\":12,\"font_size_sp\":10},\"new\":{\"Install\":\"설치\",\"Download\":\"다운로드\",\"Shop\":\"가게에서 물건을 사다\",\"Sign up\":\"회원가입\",\"Watch\":\"보다\",\"Join\":\"입회하다\",\"Start\":\"시작\",\"Subscribe\":\"구독\",\"Add\":\"추가\",\"Search\":\"검색\",\"Share\":\"공유\",\"Get\":\"얻다\",\"Book\":\"예약\",\"Play\":\"재생\"},\"existing\":{\"Install\":\"설치\",\"Use\":\"설치\",\"Play\":\"재생\",\"Reserve\":\"예약하기\",\"Buy\":\"구매하기\",\"View\":\"바라보다\",\"Log in\":\"로그인\",\"Listen\":\"듣기\",\"Read\":\"읽기\",\"Watch\":\"보기\",\"See more\":\"더 보기\",\"Find\":\"찾기\",\"Book\":\"예약\",\"Chat\":\"채팅\",\"Park\":\"읽기\",\"Open\":\"개장\",\"Exercise\":\"연습하다\",\"Optimize\":\"최적화하기\"}}}";
    }
}
