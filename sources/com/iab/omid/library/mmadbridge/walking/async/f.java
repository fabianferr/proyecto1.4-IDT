package com.iab.omid.library.mmadbridge.walking.async;

import android.text.TextUtils;
import com.iab.omid.library.mmadbridge.adsession.a;
import com.iab.omid.library.mmadbridge.internal.c;
import com.iab.omid.library.mmadbridge.walking.async.b;
import java.util.HashSet;
import org.json.JSONObject;

public class f extends a {
    public f(b.C0090b bVar, HashSet<String> hashSet, JSONObject jSONObject, long j) {
        super(bVar, hashSet, jSONObject, j);
    }

    private void b(String str) {
        c c = c.c();
        if (c != null) {
            for (a next : c.b()) {
                if (this.c.contains(next.getAdSessionId())) {
                    next.getAdSessionStatePublisher().b(str, this.e);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public String doInBackground(Object... objArr) {
        if (com.iab.omid.library.mmadbridge.utils.c.h(this.d, this.b.a())) {
            return null;
        }
        this.b.a(this.d);
        return this.d.toString();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        if (!TextUtils.isEmpty(str)) {
            b(str);
        }
        super.onPostExecute(str);
    }
}
