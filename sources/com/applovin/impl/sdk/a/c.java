package com.applovin.impl.sdk.a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.IBinder;
import android.os.RemoteException;
import com.applovin.array.apphub.aidl.IAppHubDirectDownloadServiceCallback;
import com.applovin.array.apphub.aidl.IAppHubService;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class c extends IAppHubDirectDownloadServiceCallback.Stub {
    private int a;
    private final m b;
    /* access modifiers changed from: private */
    public final u c;
    private final a d;
    private final Intent e;
    /* access modifiers changed from: private */
    public IAppHubService f;
    private long g = -1;
    private boolean h;
    private String i;
    /* access modifiers changed from: private */
    public b j;

    public interface a {
        void a();

        void b();

        void c();
    }

    private static class b {
        /* access modifiers changed from: private */
        public final AtomicBoolean a = new AtomicBoolean();
        /* access modifiers changed from: private */
        public final String b;
        /* access modifiers changed from: private */
        public final a c;

        public b(String str, a aVar) {
            this.b = str;
            this.c = aVar;
        }

        public AtomicBoolean a() {
            return this.a;
        }

        /* access modifiers changed from: protected */
        public boolean a(Object obj) {
            return obj instanceof b;
        }

        public String b() {
            return this.b;
        }

        public a c() {
            return this.c;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof b)) {
                return false;
            }
            b bVar = (b) obj;
            if (!bVar.a((Object) this)) {
                return false;
            }
            AtomicBoolean a2 = a();
            AtomicBoolean a3 = bVar.a();
            if (a2 != null ? !a2.equals(a3) : a3 != null) {
                return false;
            }
            String b2 = b();
            String b3 = bVar.b();
            if (b2 != null ? !b2.equals(b3) : b3 != null) {
                return false;
            }
            a c2 = c();
            a c3 = bVar.c();
            return c2 != null ? c2.equals(c3) : c3 == null;
        }

        public int hashCode() {
            AtomicBoolean a2 = a();
            int i = 43;
            int hashCode = a2 == null ? 43 : a2.hashCode();
            String b2 = b();
            int hashCode2 = ((hashCode + 59) * 59) + (b2 == null ? 43 : b2.hashCode());
            a c2 = c();
            int i2 = hashCode2 * 59;
            if (c2 != null) {
                i = c2.hashCode();
            }
            return i2 + i;
        }

        public String toString() {
            return "ArrayService.DirectDownloadState(errorCallbackInvoked=" + a() + ", adToken=" + b() + ", listener=" + c() + ")";
        }
    }

    public c(m mVar) {
        this.b = mVar;
        this.c = mVar.A();
        this.d = new a(mVar);
        Intent f2 = f();
        this.e = f2;
        if (f2 != null) {
            g();
        }
        mVar.af().a(new com.applovin.impl.sdk.utils.a() {
            public void onActivityStopped(Activity activity) {
                if (c.this.b() && c.this.j != null) {
                    try {
                        c.this.c.b("ArrayService", "Dismissing Direct Download Activity");
                        c.this.f.dismissDirectDownloadAppDetails(c.this.j.b);
                        c.this.j.c.b();
                        b unused = c.this.j = null;
                    } catch (RemoteException e) {
                        c.this.c.b("ArrayService", "Failed dismiss Direct Download Activity", e);
                    }
                }
            }
        });
    }

    private Intent f() {
        Intent intent = new Intent("com.applovin.am.intent.action.APPHUB_SERVICE");
        List<ResolveInfo> queryIntentServices = this.b.L().getPackageManager().queryIntentServices(intent, 0);
        if (queryIntentServices == null || queryIntentServices.isEmpty()) {
            this.c.e("ArrayService", "App Hub not available");
            return null;
        }
        intent.setClassName(queryIntentServices.get(0).serviceInfo.packageName, "com.applovin.oem.am.android.external.AppHubService");
        return intent;
    }

    /* access modifiers changed from: private */
    public void g() {
        if (this.a > 3) {
            this.c.d("ArrayService", "Exceeded maximum retry count");
            return;
        }
        this.c.b("ArrayService", "Attempting connection to App Hub service...");
        this.a++;
        try {
            if (!this.b.L().bindService(this.e, new ServiceConnection() {
                public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    u b = c.this.c;
                    b.b("ArrayService", "Connection successful: " + componentName);
                    IAppHubService unused = c.this.f = IAppHubService.Stub.asInterface(iBinder);
                }

                public void onServiceDisconnected(ComponentName componentName) {
                    u b = c.this.c;
                    b.e("ArrayService", "Service disconnected: " + componentName);
                    IAppHubService unused = c.this.f = null;
                    c.this.c.e("ArrayService", "Retrying...");
                    c.this.g();
                }
            }, 1)) {
                this.c.e("ArrayService", "App Hub not available");
            }
        } catch (Throwable th) {
            this.c.b("ArrayService", "Failed to bind to service", th);
        }
    }

    public void a() {
        if (b()) {
            this.c.b("ArrayService", "Collecting data...");
            this.g = this.d.a(this.f);
            this.h = this.d.b(this.f);
            this.i = this.d.c(this.f);
        }
    }

    public void a(b bVar, a aVar) {
        u uVar;
        String str;
        if (!b()) {
            uVar = this.c;
            str = "Cannot begin Direct Download process - service disconnected";
        } else if (!bVar.isDirectDownloadEnabled()) {
            uVar = this.c;
            str = "Cannot begin Direct Download process - missing token";
        } else {
            try {
                this.j = new b(bVar.getDirectDownloadToken(), aVar);
                this.c.b("ArrayService", "Starting Direct Download Activity");
                this.f.showDirectDownloadAppDetails(this.j.b, this);
                this.c.b("ArrayService", "Activity started");
                return;
            } catch (Throwable th) {
                this.c.b("ArrayService", "Failed start Direct Download Activity", th);
                this.j = null;
                aVar.c();
                return;
            }
        }
        uVar.e("ArrayService", str);
        aVar.c();
    }

    public boolean b() {
        return this.f != null;
    }

    public long c() {
        return this.g;
    }

    public boolean d() {
        return this.h;
    }

    public String e() {
        return this.i;
    }

    public void onAppDetailsDismissed(String str) {
        this.c.b("ArrayService", "App details dismissed");
        b bVar = this.j;
        if (bVar != null) {
            bVar.c.b();
            this.j = null;
        }
    }

    public void onAppDetailsShown(String str) {
        this.c.b("ArrayService", "App details shown");
        b bVar = this.j;
        if (bVar != null) {
            bVar.c.a();
        }
    }

    public void onDownloadStarted(String str) {
        this.c.b("ArrayService", "Download started");
    }

    public void onError(String str, String str2) {
        u uVar = this.c;
        uVar.e("ArrayService", "Encountered error with code: " + str2);
        b bVar = this.j;
        if (bVar != null && bVar.a.compareAndSet(false, true)) {
            this.j.c.c();
            this.j = null;
        }
    }
}
