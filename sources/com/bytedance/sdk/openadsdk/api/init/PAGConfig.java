package com.bytedance.sdk.openadsdk.api.init;

import android.text.TextUtils;
import com.bykv.vk.openvk.component.video.api.c;
import com.bytedance.sdk.component.f.d.b;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.InitConfig;
import com.bytedance.sdk.openadsdk.core.v;
import com.bytedance.sdk.openadsdk.utils.ac;

public final class PAGConfig implements InitConfig {
    private static String l;
    private String a;
    private boolean b;
    private int c;
    private int d = -1;
    private int e = -1;
    private int f = -1;
    private int g = 0;
    private boolean h;
    private boolean i;
    private String j;
    private String k;

    public String getData() {
        return this.k;
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        this.k = str;
    }

    public String getAppId() {
        return this.a;
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        this.a = str;
    }

    public boolean getDebugLog() {
        return this.b;
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        this.b = z;
    }

    public int getAppIconId() {
        return this.c;
    }

    /* access modifiers changed from: private */
    public void a(int i2) {
        this.c = i2;
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        if (i2 < -1 || i2 > 1) {
            i2 = -1;
        }
        this.d = i2;
    }

    public int getCoppa() {
        return this.d;
    }

    /* access modifiers changed from: private */
    public void c(int i2) {
        if (i2 < -1 || i2 > 1) {
            i2 = -1;
        }
        this.e = i2;
    }

    public int getGdpr() {
        return this.e;
    }

    /* access modifiers changed from: private */
    public void d(int i2) {
        if (i2 < -1 || i2 > 1) {
            i2 = -1;
        }
        this.f = i2;
    }

    public int getCcpa() {
        return this.f;
    }

    public int getTitleBarTheme() {
        return this.g;
    }

    /* access modifiers changed from: private */
    public void e(int i2) {
        this.g = i2;
    }

    public boolean isUseTextureView() {
        return this.h;
    }

    /* access modifiers changed from: private */
    public void b(boolean z) {
        this.h = z;
    }

    public boolean isSupportMultiProcess() {
        return this.i;
    }

    /* access modifiers changed from: private */
    public void c(boolean z) {
        this.i = z;
        c.a(z);
    }

    /* access modifiers changed from: private */
    public void c(String str) {
        this.j = str;
    }

    public String getPackageName() {
        if (TextUtils.isEmpty(this.j)) {
            return l;
        }
        return this.j;
    }

    public static void setChildDirected(int i2) {
        if (ac.i("setCoppa")) {
            if (i2 < -1 || i2 > 1) {
                i2 = -1;
            }
            v.a().b(i2);
        }
    }

    public static int getChildDirected() {
        if (!ac.i("getCoppa")) {
            return -1;
        }
        return v.a().b();
    }

    public static void setGDPRConsent(int i2) {
        ac.i("setGdpr");
        if (i2 < -1 || i2 > 1) {
            i2 = -1;
        }
        v.a().c(i2);
    }

    public static int getGDPRConsent() {
        if (!ac.i("getGdpr")) {
            return -1;
        }
        int c2 = v.a().c();
        if (c2 == 1) {
            return 0;
        }
        if (c2 == 0) {
            return 1;
        }
        return c2;
    }

    public static void setDoNotSell(int i2) {
        if (ac.i("setCCPA")) {
            if (i2 < -1 || i2 > 1) {
                i2 = -1;
            }
            v.a().d(i2);
        }
    }

    public static int getDoNotSell() {
        if (!ac.i("getCCPA")) {
            return -1;
        }
        return v.a().f();
    }

    public static void debugLog(boolean z) {
        if (v.a() == null) {
            return;
        }
        if (z) {
            v.a().e(1);
            v.a().a();
            com.bykv.vk.openvk.component.video.api.f.c.a();
            return;
        }
        v.a().e(0);
        b.a(b.a.OFF);
        l.c();
        com.bykv.vk.openvk.component.video.api.f.c.b();
    }

    public static void setAppIconId(int i2) {
        if (v.a() != null) {
            v.a().f(i2);
        }
    }

    public static void setUserData(String str) {
        if (v.a() != null) {
            v.a().b(str);
        }
    }

    public static void setPackageName(String str) {
        l = str;
    }

    public static class Builder {
        private String a;
        private boolean b;
        private int c;
        private int d = -1;
        private int e = -1;
        private int f = -1;
        private int g = 0;
        private boolean h = true;
        private boolean i = false;
        private String[] j;
        private String k;
        private String l;

        public Builder setUserData(String str) {
            this.l = str;
            return this;
        }

        public Builder appId(String str) {
            this.a = str;
            return this;
        }

        public Builder debugLog(boolean z) {
            this.b = z;
            return this;
        }

        public Builder appIcon(int i2) {
            this.c = i2;
            return this;
        }

        public Builder setChildDirected(int i2) {
            this.d = i2;
            return this;
        }

        public Builder setGDPRConsent(int i2) {
            this.e = i2;
            return this;
        }

        public Builder setDoNotSell(int i2) {
            this.f = i2;
            return this;
        }

        public Builder titleBarTheme(int i2) {
            this.g = i2;
            return this;
        }

        public Builder useTextureView(boolean z) {
            this.h = z;
            return this;
        }

        public Builder supportMultiProcess(boolean z) {
            this.i = z;
            return this;
        }

        public Builder needClearTaskReset(String... strArr) {
            this.j = strArr;
            return this;
        }

        public Builder setPackageName(String str) {
            this.k = str;
            return this;
        }

        public PAGConfig build() {
            PAGConfig pAGConfig = new PAGConfig();
            pAGConfig.b(this.a);
            pAGConfig.b(this.d);
            pAGConfig.a(this.c);
            pAGConfig.e(this.g);
            pAGConfig.b(this.h);
            pAGConfig.c(this.i);
            pAGConfig.c(this.e);
            pAGConfig.d(this.f);
            pAGConfig.a(this.b);
            pAGConfig.c(this.k);
            pAGConfig.a(this.l);
            return pAGConfig;
        }
    }
}
