package com.startapp;

import android.text.TextUtils;
import com.startapp.sdk.common.SDKException;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Sta */
public class l4 extends r6 {
    public final JSONObject a = new JSONObject();

    public void a(String str, Object obj, boolean z, boolean z2) throws SDKException {
        if (z && obj == null) {
            throw new SDKException(str, (Throwable) null);
        } else if (obj != null && !TextUtils.isEmpty(obj.toString())) {
            try {
                this.a.put(str, obj);
            } catch (JSONException e) {
                if (z) {
                    throw new SDKException(str, e);
                }
            }
        }
    }

    public String toString() {
        return this.a.toString();
    }

    public void a(String str, Set<String> set, boolean z, boolean z2) throws SDKException {
        if (z && (set == null || set.size() == 0)) {
            throw new SDKException(str, (Throwable) null);
        } else if (set != null && set.size() > 0) {
            try {
                this.a.put(str, new JSONArray(set));
            } catch (JSONException e) {
                if (z) {
                    throw new SDKException(str, e);
                }
            }
        }
    }
}
