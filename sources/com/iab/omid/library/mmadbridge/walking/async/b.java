package com.iab.omid.library.mmadbridge.walking.async;

import android.os.AsyncTask;
import java.util.concurrent.ThreadPoolExecutor;
import org.json.JSONObject;

public abstract class b extends AsyncTask<Object, Void, String> {
    private a a;
    protected final C0090b b;

    public interface a {
        void a(b bVar);
    }

    /* renamed from: com.iab.omid.library.mmadbridge.walking.async.b$b  reason: collision with other inner class name */
    public interface C0090b {
        JSONObject a();

        void a(JSONObject jSONObject);
    }

    public b(C0090b bVar) {
        this.b = bVar;
    }

    public void a(a aVar) {
        this.a = aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void onPostExecute(String str) {
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(this);
        }
    }

    public void a(ThreadPoolExecutor threadPoolExecutor) {
        executeOnExecutor(threadPoolExecutor, new Object[0]);
    }
}