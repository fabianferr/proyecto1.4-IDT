package com.umlaut.crowd;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.internal.z9;
import com.umlaut.crowd.threads.ThreadManager;

public class InsightStarter extends ContentProvider {
    /* access modifiers changed from: private */
    public static final String a = "InsightStarter";

    class a implements Runnable {
        a() {
        }

        public void run() {
            try {
                InsightCore.init(InsightStarter.this.getContext(), z9.a(InsightStarter.this.getContext().getAssets().open("insightconfig.bin")), (InsightCore.OnInsightCoreInitializedListener) null);
            } catch (Exception unused) {
                Log.i(InsightStarter.a, "insightconfig.bin is either corrupted or not found in assets folder. If you refrain from automatic initialization on purpose, please use the manual initialization in the application class.");
            }
        }
    }

    public void attachInfo(Context context, ProviderInfo providerInfo) {
        if (providerInfo == null) {
            throw new NullPointerException("InsightStarter ProviderInfo cannot be null.");
        } else if (!providerInfo.authority.equals("com.p3group.insight.insightstarter")) {
            super.attachInfo(context, providerInfo);
        } else {
            throw new IllegalStateException("Incorrect provider authority in manifest. Most likely due to a missing applicationId variable your application's build.gradle.");
        }
    }

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    public boolean onCreate() {
        ThreadManager.getInstance().getSingleThreadScheduledExecutor().execute(new a());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
