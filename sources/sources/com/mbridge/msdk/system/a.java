package com.mbridge.msdk.system;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.MBridgeSDK;
import com.mbridge.msdk.foundation.controller.authoritycontroller.AuthorityInfoBean;
import com.mbridge.msdk.foundation.controller.authoritycontroller.CallBackForDeveloper;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.download.MBDownloadConfig;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.database.IDatabaseOpenHelper;
import com.mbridge.msdk.foundation.download.resource.ResourceConfig;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.l;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.q;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.DeveloperTransferIdInfo;
import com.mbridge.msdk.out.OnCompletionListener;
import com.mbridge.msdk.out.SDKInitStatusListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: MBridgeSDKImpl */
public final class a implements MBridgeSDK {
    public static Map<String, String> a;
    private volatile MBridgeSDK.PLUGIN_LOAD_STATUS b = MBridgeSDK.PLUGIN_LOAD_STATUS.INITIAL;
    private Context c;
    private SDKInitStatusListener d;
    private boolean e = false;
    private boolean f = false;
    private volatile AtomicBoolean g;
    private final Application.ActivityLifecycleCallbacks h = new Application.ActivityLifecycleCallbacks() {
        public final void onActivityPaused(Activity activity) {
        }

        public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        public final void onActivityCreated(Activity activity, Bundle bundle) {
            q.a().c();
        }

        public final void onActivityStarted(Activity activity) {
            int e = b.d().e();
            if (e == 0) {
                com.mbridge.msdk.foundation.same.report.q.a("1");
            }
            b.d().b(e + 1);
        }

        public final void onActivityResumed(Activity activity) {
            b.d().a((Context) activity);
        }

        public final void onActivityStopped(Activity activity) {
            int e = b.d().e();
            if (e == 1 || e == 0) {
                com.mbridge.msdk.foundation.same.report.q.a("2");
            }
            b.d().b(e - 1);
        }

        public final void onActivityDestroyed(Activity activity) {
            q.a().d();
            b.d().a(activity);
        }
    };

    public final void setThirdPartyFeatures(Map<String, Object> map) {
    }

    public final void showUserPrivateInfoTips(Context context, CallBackForDeveloper callBackForDeveloper) {
    }

    private void a() {
        String str;
        boolean z;
        if (this.g == null) {
            this.g = new AtomicBoolean(false);
        }
        this.e = false;
        try {
            if (this.g.get()) {
                SDKInitStatusListener sDKInitStatusListener = this.d;
                if (sDKInitStatusListener != null && !this.e) {
                    try {
                        this.e = true;
                        sDKInitStatusListener.onInitSuccess();
                        return;
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("com.mbridge.msdk", e2.getMessage());
                            return;
                        }
                        return;
                    }
                } else {
                    return;
                }
            }
        } catch (Exception e3) {
            if (MBridgeConstans.DEBUG) {
                aa.d("com.mbridge.msdk", e3.getMessage());
            }
        }
        this.g.set(true);
        try {
            c.a().a((Map) a, this.c);
            this.b = MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED;
            d.a().c();
            m.a().c();
            HandlerThread handlerThread = new HandlerThread("mb_db_thread");
            handlerThread.start();
            Handler handler = new Handler(handlerThread.getLooper());
            MBDownloadConfig.Builder builder = new MBDownloadConfig.Builder();
            builder.setDatabaseHandler(handler);
            builder.setDatabaseOpenHelper(new IDatabaseOpenHelper() {
                public final SQLiteDatabase getReadableDatabase() {
                    return h.a(b.d().g()).a();
                }

                public final SQLiteDatabase getWritableDatabase() {
                    return h.a(b.d().g()).b();
                }
            });
            builder.setLogger(new ILogger() {
                public final void log(String str, String str2) {
                    aa.a(str, str2);
                }

                public final void log(String str, Exception exc) {
                    aa.a(str, exc.getMessage());
                }
            });
            MBDownloadManager.getInstance().initialize(b.d().g(), builder.build(), new ResourceConfig.Builder().setMaxStorageSpace(100).setMaxStorageTime(259200000).build());
            k.a().b();
            l.a().b();
            SDKInitStatusListener sDKInitStatusListener2 = this.d;
            if (sDKInitStatusListener2 != null && !this.e) {
                this.e = true;
                sDKInitStatusListener2.onInitSuccess();
            }
            try {
                q.a().a(this.c.getApplicationContext());
            } catch (Exception e4) {
                aa.b("com.mbridge.msdk", "INIT", e4);
            }
            Context context = this.c;
            if (context instanceof Application) {
                Application application = (Application) context;
                try {
                    if (ac.a().a("c_r_a_l_c", 0) != 0) {
                        z = false;
                        if (application != null && z) {
                            application.registerActivityLifecycleCallbacks(this.h);
                            this.f = true;
                        }
                    }
                } catch (Exception e5) {
                    aa.d("com.mbridge.msdk", e5.getMessage());
                }
                z = true;
                application.registerActivityLifecycleCallbacks(this.h);
                this.f = true;
            }
            this.g.set(true);
        } catch (Exception e6) {
            if (MBridgeConstans.DEBUG) {
                aa.b("com.mbridge.msdk", "INIT FAIL", e6);
                e6.printStackTrace();
            }
            if (this.g != null) {
                this.g.set(false);
            }
            SDKInitStatusListener sDKInitStatusListener3 = this.d;
            if (sDKInitStatusListener3 != null && !this.e) {
                this.e = true;
                sDKInitStatusListener3.onInitFail(e6.getMessage());
            }
        }
        try {
            com.mbridge.msdk.foundation.same.f.b.b().execute(new Runnable() {
                public final void run() {
                    try {
                        com.mbridge.msdk.f.b.a();
                    } catch (Exception e) {
                        aa.d("com.mbridge.msdk", e.getMessage());
                    }
                }
            });
            HashMap hashMap = new HashMap();
            if (this.g != null) {
                String str2 = "1";
                hashMap.put("status", this.g.get() ? str2 : "2");
                if (b.d().f().a()) {
                    str = str2;
                } else {
                    str = "2";
                }
                hashMap.put("is_allow_crash", str);
                if (!b.d().f().b()) {
                    str2 = "2";
                }
                hashMap.put("is_allow_anr", str2);
            }
            m.a().b("m_init_sdk", "InitSDK", "", "", hashMap);
        } catch (Throwable th) {
            aa.d("com.mbridge.msdk", th.getMessage());
        }
    }

    public final MBridgeSDK.PLUGIN_LOAD_STATUS getStatus() {
        return this.b;
    }

    public final void preload(Map<String, Object> map) {
        if (this.b == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            c.a().a(map, 0);
        }
    }

    public final void setUserPrivateInfoType(Context context, String str, int i) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(str, i);
    }

    public final void setDoNotTrackStatus(boolean z) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().b(z ? 1 : 0);
    }

    public final void setCoppaStatus(Context context, boolean z) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a();
        com.mbridge.msdk.foundation.a.a.a.a().a(MBridgeConstans.AUTHORITY_COPPA, z ? 1 : 2);
    }

    public final void setDoNotTrackStatus(Context context, boolean z) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().b(z ? 1 : 0);
    }

    public final AuthorityInfoBean userPrivateInfo(Context context) {
        a(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().b();
    }

    public final void setConsentStatus(Context context, int i) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(i);
    }

    public final void setConsentStatus(Context context) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(context, (OnCompletionListener) null);
    }

    public final void setConsentStatus(Context context, OnCompletionListener onCompletionListener) {
        a(context);
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().a(context, onCompletionListener);
    }

    public final boolean getConsentStatus(Context context) {
        a(context);
        return com.mbridge.msdk.foundation.controller.authoritycontroller.a.a().d();
    }

    public final void preloadFrame(Map<String, Object> map) {
        c.a().a(map, 1);
    }

    public final Map<String, String> getMBConfigurationMap(String str, String str2) {
        return getMBConfigurationMap(str, str2, "");
    }

    public final Map<String, String> getMBConfigurationMap(String str, String str2, boolean z) {
        return getMBConfigurationMap(str, str2, "");
    }

    public final Map<String, String> getMBConfigurationMap(String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put(MBridgeConstans.ID_MBRIDGE_APPID, str);
        hashMap.put(MBridgeConstans.ID_MBRIDGE_APPKEY, str2);
        hashMap.put(MBridgeConstans.ID_MBRIDGE_WX_APPID, str3);
        hashMap.put(MBridgeConstans.ID_MBRIDGE_STARTUPCRASH, String.valueOf(1));
        return hashMap;
    }

    public final Map<String, String> getMBConfigurationMap(String str, String str2, String str3, boolean z) {
        return getMBConfigurationMap(str, str2, "");
    }

    public final void release() {
        if (this.b == MBridgeSDK.PLUGIN_LOAD_STATUS.COMPLETED) {
            c.a().b();
        }
        Context context = this.c;
        if (context instanceof Application) {
            Application application = (Application) context;
            if (this.f) {
                application.unregisterActivityLifecycleCallbacks(this.h);
            }
        }
    }

    public final void init(Map<String, String> map, Application application) {
        this.c = application.getApplicationContext();
        a = map;
        a();
    }

    public final void initAsync(Map<String, String> map, Application application) {
        this.c = application.getApplicationContext();
        a = map;
        a();
    }

    public final void init(Map<String, String> map, Context context) {
        this.c = context.getApplicationContext();
        a = map;
        a();
    }

    public final void initAsync(Map<String, String> map, Context context) {
        this.c = context.getApplicationContext();
        a = map;
        a();
    }

    public final void init(Map<String, String> map, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.c = application;
        this.d = sDKInitStatusListener;
        a = map;
        a();
    }

    public final void initAsync(Map<String, String> map, Application application, SDKInitStatusListener sDKInitStatusListener) {
        this.c = application;
        this.d = sDKInitStatusListener;
        a = map;
        a();
    }

    public final void init(Map<String, String> map, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.c = context.getApplicationContext();
        this.d = sDKInitStatusListener;
        a = map;
        a();
    }

    public final void initAsync(Map<String, String> map, Context context, SDKInitStatusListener sDKInitStatusListener) {
        this.c = context.getApplicationContext();
        this.d = sDKInitStatusListener;
        a = map;
        a();
    }

    private void a(Context context) {
        if (b.d().g() == null && context != null) {
            b.d().b(context);
        }
    }

    public final void updateDialogWeakActivity(WeakReference<Activity> weakReference) {
        b.d().a(weakReference);
    }

    public final void setAllowAcquireIds(boolean z) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.a(z);
    }

    public final void setDeveloperIds(DeveloperTransferIdInfo developerTransferIdInfo) {
        if (!com.mbridge.msdk.foundation.controller.authoritycontroller.a.g() && developerTransferIdInfo != null && !TextUtils.isEmpty(developerTransferIdInfo.getGaid())) {
            w.a(developerTransferIdInfo.getGaid());
        }
    }

    public final void setAllowTransferIdsIfLimit(boolean z) {
        com.mbridge.msdk.foundation.controller.authoritycontroller.a.b(z);
    }
}
