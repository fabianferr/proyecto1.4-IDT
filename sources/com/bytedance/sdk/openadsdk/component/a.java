package com.bytedance.sdk.openadsdk.component;

import android.view.View;
import com.bykv.vk.openvk.component.video.api.d.c;
import com.bytedance.sdk.component.utils.l;

/* compiled from: AppOpenAdCallbackCollection */
public class a implements c.a, com.bytedance.sdk.openadsdk.component.f.a {
    public void c() {
    }

    public void d() {
    }

    public void e() {
    }

    public void f() {
    }

    public void a(long j, int i) {
        l.a("AppOpenAdCallbackCollection", "open_ad", "onComplete");
    }

    public void b(long j, int i) {
        l.a("AppOpenAdCallbackCollection", "open_ad", "onError");
    }

    public void a() {
        l.a("AppOpenAdCallbackCollection", "open_ad", "onTimeOut");
    }

    public void a(long j, long j2) {
        l.a("AppOpenAdCallbackCollection", "open_ad", "onProgressUpdate");
    }

    public void a(View view) {
        l.a("AppOpenAdCallbackCollection", "open_ad", "onClickSkip");
    }

    public void b(View view) {
        l.a("AppOpenAdCallbackCollection", "open_ad", "onClickDislike");
    }

    public void b() {
        l.a("AppOpenAdCallbackCollection", "open_ad", "onCountDownFinish");
    }

    public void a(int i, int i2, boolean z) {
        l.a("AppOpenAdCallbackCollection", "open_ad", "onTimeChanged");
    }
}
