package com.startapp.sdk.ads.video.vast;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import com.startapp.a3;
import com.startapp.g2;
import com.startapp.i3;
import com.startapp.k9;
import com.startapp.sdk.ads.video.vast.c;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.w0;
import java.io.ByteArrayOutputStream;
import java.util.Map;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Sta */
public class b implements c.b {
    public final Context a;
    public final String b;
    public final JSONArray c = new JSONArray();
    public final String d;
    public final String e;
    public boolean f;

    public b(Context context, String str, String str2, String str3, boolean z) {
        this.a = context;
        this.b = str;
        this.d = str2;
        this.e = str3;
        this.f = z;
    }

    public void a(VASTErrorCodes vASTErrorCodes) {
        a3 m;
        if (this.c.length() != 0) {
            if (!this.f || vASTErrorCodes == VASTErrorCodes.ErrorNone) {
                try {
                    String b2 = b(vASTErrorCodes);
                    if (!TextUtils.isEmpty(b2)) {
                        m = ComponentLocator.a(this.a).m();
                        String str = this.b;
                        byte[] bytes = b2.getBytes();
                        Map<Activity, Integer> map = k9.a;
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
                        gZIPOutputStream.write(bytes);
                        gZIPOutputStream.flush();
                        gZIPOutputStream.close();
                        m.a(str, (w0) null, byteArrayOutputStream.toByteArray(), true, (g2<Throwable, Void>) null);
                    }
                } catch (Throwable th) {
                    i3.a(th);
                }
            }
        }
    }

    public final String b(VASTErrorCodes vASTErrorCodes) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("vastDocs", this.c);
        String str = this.d;
        String str2 = "";
        if (str == null) {
            str = str2;
        }
        jSONObject.put("partnerResponse", str);
        String str3 = this.e;
        if (str3 != null) {
            str2 = str3;
        }
        jSONObject.put("partnerName", str2);
        jSONObject.put("error", vASTErrorCodes.a());
        return jSONObject.toString();
    }
}
