package com.ironsource.mediationsdk.testSuite;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;
import com.ironsource.mediationsdk.sdk.LevelPlayBannerListener;
import com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener;
import com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener;
import com.ironsource.mediationsdk.testSuite.c.a;
import com.ironsource.mediationsdk.testSuite.e.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\n\u001a\u00020\u0005J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0012H\u0016J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0014J\b\u0010\u0017\u001a\u00020\u0012H\u0014J\b\u0010\u0018\u001a\u00020\u0012H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/ironsource/mediationsdk/testSuite/TestSuiteActivity;", "Landroid/app/Activity;", "Lcom/ironsource/mediationsdk/testSuite/listeners/ITestSuiteUILifeCycleListener;", "()V", "mContainer", "Landroid/widget/RelativeLayout;", "mNativeBridge", "Lcom/ironsource/mediationsdk/testSuite/adBridge/TestSuiteNativeBridge;", "mWebViewWrapper", "Lcom/ironsource/mediationsdk/testSuite/webView/TestSuiteWebViewWrapper;", "getContainer", "getControllerUrl", "", "getJsonData", "Lorg/json/JSONObject;", "getLayoutParams", "Landroid/widget/RelativeLayout$LayoutParams;", "onBackPressed", "", "onClosed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onUIReady", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TestSuiteActivity extends Activity implements a {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private RelativeLayout a;
    private b b;
    private com.ironsource.mediationsdk.testSuite.a.a c;

    private static RelativeLayout.LayoutParams a() {
        return new RelativeLayout.LayoutParams(-1, -1);
    }

    /* access modifiers changed from: private */
    public static final void a(TestSuiteActivity testSuiteActivity) {
        Intrinsics.checkNotNullParameter(testSuiteActivity, "this$0");
        b bVar = testSuiteActivity.b;
        b bVar2 = null;
        if (bVar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
            bVar = null;
        }
        if (bVar.c.getParent() == null) {
            RelativeLayout relativeLayout = testSuiteActivity.a;
            if (relativeLayout == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                relativeLayout = null;
            }
            b bVar3 = testSuiteActivity.b;
            if (bVar3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
                bVar3 = null;
            }
            relativeLayout.removeView(bVar3.b);
            RelativeLayout relativeLayout2 = testSuiteActivity.a;
            if (relativeLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mContainer");
                relativeLayout2 = null;
            }
            b bVar4 = testSuiteActivity.b;
            if (bVar4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
                bVar4 = null;
            }
            relativeLayout2.addView(bVar4.c, a());
            b bVar5 = testSuiteActivity.b;
            if (bVar5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
            } else {
                bVar2 = bVar5;
            }
            bVar2.a();
        }
    }

    /* access modifiers changed from: private */
    public static final void b(TestSuiteActivity testSuiteActivity) {
        Intrinsics.checkNotNullParameter(testSuiteActivity, "this$0");
        testSuiteActivity.finish();
    }

    public final void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public final View _$_findCachedViewById(int i) {
        Map<Integer, View> map = this._$_findViewCache;
        View view = map.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public final RelativeLayout getContainer() {
        RelativeLayout relativeLayout = this.a;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mContainer");
        return null;
    }

    public final void onBackPressed() {
    }

    public final void onClosed() {
        runOnUiThread(new TestSuiteActivity$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0076  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x007d  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00b4  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00be  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00c4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onCreate(android.os.Bundle r6) {
        /*
            r5 = this;
            super.onCreate(r6)
            android.widget.RelativeLayout r6 = new android.widget.RelativeLayout
            r0 = r5
            android.content.Context r0 = (android.content.Context) r0
            r6.<init>(r0)
            r5.a = r6
            android.view.View r6 = (android.view.View) r6
            android.widget.RelativeLayout$LayoutParams r0 = a()
            android.view.ViewGroup$LayoutParams r0 = (android.view.ViewGroup.LayoutParams) r0
            r5.setContentView(r6, r0)
            com.ironsource.mediationsdk.testSuite.e.b r6 = new com.ironsource.mediationsdk.testSuite.e.b
            r0 = r5
            com.ironsource.mediationsdk.testSuite.c.a r0 = (com.ironsource.mediationsdk.testSuite.c.a) r0
            android.content.Intent r1 = r5.getIntent()
            r2 = 0
            if (r1 == 0) goto L_0x0057
            android.content.Intent r1 = r5.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            if (r1 == 0) goto L_0x0057
            android.content.Intent r1 = r5.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            if (r1 == 0) goto L_0x003f
            java.lang.String r3 = "dataString"
            java.lang.String r1 = r1.getString(r3)
            goto L_0x0040
        L_0x003f:
            r1 = r2
        L_0x0040:
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x004e
            int r3 = r3.length()
            if (r3 != 0) goto L_0x004c
            goto L_0x004e
        L_0x004c:
            r3 = 0
            goto L_0x004f
        L_0x004e:
            r3 = 1
        L_0x004f:
            if (r3 != 0) goto L_0x0057
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>(r1)
            goto L_0x005c
        L_0x0057:
            org.json.JSONObject r3 = new org.json.JSONObject
            r3.<init>()
        L_0x005c:
            android.content.Intent r1 = r5.getIntent()
            if (r1 == 0) goto L_0x007d
            android.content.Intent r1 = r5.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            if (r1 == 0) goto L_0x007d
            android.content.Intent r1 = r5.getIntent()
            android.os.Bundle r1 = r1.getExtras()
            if (r1 == 0) goto L_0x007d
            java.lang.String r4 = "controllerUrl"
            java.lang.String r1 = r1.getString(r4)
            goto L_0x007e
        L_0x007d:
            r1 = r2
        L_0x007e:
            r6.<init>(r5, r0, r3, r1)
            r5.b = r6
            com.ironsource.mediationsdk.testSuite.a.a r0 = new com.ironsource.mediationsdk.testSuite.a.a
            com.ironsource.mediationsdk.testSuite.c.b r6 = (com.ironsource.mediationsdk.testSuite.c.b) r6
            r0.<init>(r6)
            r5.c = r0
            com.ironsource.mediationsdk.testSuite.d r6 = com.ironsource.mediationsdk.testSuite.d.a
            com.ironsource.mediationsdk.testSuite.a.a$a r6 = new com.ironsource.mediationsdk.testSuite.a.a$a
            r6.<init>(r0)
            com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener r6 = (com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener) r6
            com.ironsource.mediationsdk.testSuite.d.a((com.ironsource.mediationsdk.sdk.LevelPlayInterstitialListener) r6)
            com.ironsource.mediationsdk.testSuite.d r6 = com.ironsource.mediationsdk.testSuite.d.a
            com.ironsource.mediationsdk.testSuite.a.a$b r6 = new com.ironsource.mediationsdk.testSuite.a.a$b
            r6.<init>(r0)
            com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener r6 = (com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener) r6
            com.ironsource.mediationsdk.testSuite.d.a((com.ironsource.mediationsdk.sdk.LevelPlayRewardedVideoBaseListener) r6)
            com.ironsource.mediationsdk.testSuite.d r6 = com.ironsource.mediationsdk.testSuite.d.a
            com.ironsource.mediationsdk.testSuite.a.a$c r6 = new com.ironsource.mediationsdk.testSuite.a.a$c
            r6.<init>(r0)
            com.ironsource.mediationsdk.sdk.LevelPlayBannerListener r6 = (com.ironsource.mediationsdk.sdk.LevelPlayBannerListener) r6
            com.ironsource.mediationsdk.testSuite.d.a((com.ironsource.mediationsdk.sdk.LevelPlayBannerListener) r6)
            android.widget.RelativeLayout r6 = r5.a
            if (r6 != 0) goto L_0x00ba
            java.lang.String r6 = "mContainer"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r6 = r2
        L_0x00ba:
            com.ironsource.mediationsdk.testSuite.e.b r0 = r5.b
            if (r0 != 0) goto L_0x00c4
            java.lang.String r0 = "mWebViewWrapper"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r0)
            goto L_0x00c5
        L_0x00c4:
            r2 = r0
        L_0x00c5:
            android.webkit.WebView r0 = r2.b
            android.view.View r0 = (android.view.View) r0
            android.widget.RelativeLayout$LayoutParams r1 = a()
            android.view.ViewGroup$LayoutParams r1 = (android.view.ViewGroup.LayoutParams) r1
            r6.addView(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.testSuite.TestSuiteActivity.onCreate(android.os.Bundle):void");
    }

    /* access modifiers changed from: protected */
    public final void onDestroy() {
        if (this.c == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mNativeBridge");
        }
        d dVar = d.a;
        b bVar = null;
        d.a((LevelPlayInterstitialListener) null);
        d dVar2 = d.a;
        d.a((LevelPlayRewardedVideoBaseListener) null);
        d dVar3 = d.a;
        d.a((LevelPlayBannerListener) null);
        d dVar4 = d.a;
        d.e();
        RelativeLayout relativeLayout = this.a;
        if (relativeLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContainer");
            relativeLayout = null;
        }
        relativeLayout.removeAllViews();
        b bVar2 = this.b;
        if (bVar2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mWebViewWrapper");
        } else {
            bVar = bVar2;
        }
        bVar.a();
        bVar.c.destroy();
        super.onDestroy();
    }

    public final void onUIReady() {
        runOnUiThread(new TestSuiteActivity$$ExternalSyntheticLambda0(this));
    }
}
