package com.mbridge.msdk.foundation.entity;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.system.NoProGuard;
import java.io.Serializable;
import org.json.JSONException;
import org.json.JSONObject;

public class AabEntity implements NoProGuard, Serializable {
    private static final String TAG = "AabEntity";
    public int h3c;
    public int hlp;

    public int getHlp() {
        return this.hlp;
    }

    public void setHlp(int i) {
        this.hlp = i;
    }

    public int getH3c() {
        return this.h3c;
    }

    public void setH3c(int i) {
        this.h3c = i;
    }

    public static AabEntity parser(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str);
            AabEntity aabEntity = new AabEntity();
            if (jSONObject.has("hlp")) {
                aabEntity.setHlp(jSONObject.optInt("hlp"));
            }
            if (jSONObject.has("h3c")) {
                aabEntity.setH3c(jSONObject.optInt("h3c"));
            }
            return aabEntity;
        } catch (Throwable th) {
            aa.d(TAG, th.getMessage());
            return null;
        }
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("hlp", this.hlp);
            jSONObject.put("h3c", this.h3c);
        } catch (JSONException e) {
            aa.d(TAG, e.getMessage());
        }
        return jSONObject;
    }
}
