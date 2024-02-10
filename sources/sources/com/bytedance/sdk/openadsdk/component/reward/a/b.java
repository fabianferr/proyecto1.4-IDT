package com.bytedance.sdk.openadsdk.component.reward.a;

import android.content.Intent;
import android.os.Bundle;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.openadsdk.TTAdConstant;
import com.bytedance.sdk.openadsdk.core.model.a;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.r;
import com.bytedance.sdk.openadsdk.core.s;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* compiled from: RewardFullDataManager */
public class b {
    private static final SparseArray<WeakReference<q>> a = new SparseArray<>();

    public static void a(a aVar, Intent intent, Bundle bundle) {
        a(intent, aVar);
        a(bundle, aVar);
    }

    public static q a(Intent intent, Bundle bundle, com.bytedance.sdk.openadsdk.core.video.c.b bVar) {
        r rVar;
        if (com.bytedance.sdk.openadsdk.multipro.b.c()) {
            rVar = null;
            if (intent != null) {
                try {
                    String stringExtra = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_AD_INFO);
                    if (stringExtra != null) {
                        rVar = new r(a.b(new JSONObject(stringExtra)));
                    }
                } catch (Exception e) {
                    l.c("TTAD.RFDM", "", e);
                }
            }
        } else {
            q b = s.a().b();
            a g = s.a().g();
            if (b == null && g != null) {
                b = new r(g);
            }
            if (bVar != null) {
                bVar.a(bundle);
            }
            s.a().f();
            rVar = b;
        }
        if (bundle != null) {
            try {
                WeakReference weakReference = a.get(bundle.getInt("meta_tmp"));
                if (weakReference != null) {
                    rVar = (q) weakReference.get();
                }
            } catch (Throwable th) {
                l.c("TTAD.RFDM", "", th);
            }
        }
        if (rVar != null) {
            rVar.a(rVar.p(), 7);
        }
        return rVar;
    }

    private static void a(Intent intent, a aVar) {
        if (intent != null) {
            boolean z = false;
            aVar.G.c(intent.getBooleanExtra("video_is_cached", false));
            aVar.c = intent.getStringExtra(TTAdConstant.MULTI_PROCESS_META_MD5);
            if (intent.getIntExtra("orientation_angle", 0) == 3) {
                z = true;
            }
            aVar.n = z;
        }
    }

    public static void a(Bundle bundle, a aVar) {
        if (bundle != null) {
            aVar.c = bundle.getString(TTAdConstant.MULTI_PROCESS_META_MD5);
            aVar.G.c(bundle.getBoolean("video_is_cached", false));
            aVar.d = bundle.getBoolean("is_mute");
            if (bundle.getLong("video_current") > 0) {
                aVar.G.b(bundle.getLong("video_current", 0));
            }
            aVar.a(bundle.getBoolean("has_show_skip_btn"));
        }
    }

    public static void a(a aVar, Bundle bundle) {
        if (bundle != null) {
            try {
                q qVar = aVar.a;
                a.append(qVar.hashCode(), new WeakReference(qVar));
                bundle.putInt("meta_tmp", qVar.hashCode());
                bundle.putString(TTAdConstant.MULTI_PROCESS_META_MD5, aVar.c);
                bundle.putBoolean("video_is_cached", aVar.G.x());
                bundle.putLong("video_current", aVar.G.g());
                bundle.putBoolean("is_mute", aVar.d);
                bundle.putBoolean("has_show_skip_btn", aVar.p);
            } catch (Throwable th) {
                l.c("TTAD.RFDM", "onSaveInstanceState: ", th);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(android.content.Intent r2, android.app.Activity r3, boolean r4, com.bytedance.sdk.openadsdk.core.model.a r5, java.lang.String r6) {
        /*
            if (r3 != 0) goto L_0x0008
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            r2.addFlags(r3)
            goto L_0x001d
        L_0x0008:
            android.view.WindowManager r3 = r3.getWindowManager()     // Catch:{ Exception -> 0x0015 }
            android.view.Display r3 = r3.getDefaultDisplay()     // Catch:{ Exception -> 0x0015 }
            int r3 = r3.getRotation()     // Catch:{ Exception -> 0x0015 }
            goto L_0x001e
        L_0x0015:
            r3 = move-exception
            java.lang.String r0 = "TTAD.RFDM"
            java.lang.String r1 = ""
            com.bytedance.sdk.component.utils.l.c(r0, r1, r3)
        L_0x001d:
            r3 = 0
        L_0x001e:
            java.lang.String r0 = "orientation_angle"
            r2.putExtra(r0, r3)
            java.lang.String r3 = "video_is_cached"
            r2.putExtra(r3, r4)
            boolean r3 = com.bytedance.sdk.openadsdk.multipro.b.c()
            if (r3 == 0) goto L_0x0049
            org.json.JSONObject r3 = r5.k()
            if (r3 != 0) goto L_0x003a
            java.lang.String r2 = "toJsonObj return null"
            com.bytedance.sdk.component.utils.l.d(r2)
            return
        L_0x003a:
            java.lang.String r4 = "multi_process_ad_info"
            java.lang.String r3 = r3.toString()
            r2.putExtra(r4, r3)
            java.lang.String r3 = "multi_process_meta_md5"
            r2.putExtra(r3, r6)
            goto L_0x0057
        L_0x0049:
            com.bytedance.sdk.openadsdk.core.s r2 = com.bytedance.sdk.openadsdk.core.s.a()
            r2.f()
            com.bytedance.sdk.openadsdk.core.s r2 = com.bytedance.sdk.openadsdk.core.s.a()
            r2.a((com.bytedance.sdk.openadsdk.core.model.a) r5)
        L_0x0057:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.component.reward.a.b.a(android.content.Intent, android.app.Activity, boolean, com.bytedance.sdk.openadsdk.core.model.a, java.lang.String):void");
    }
}
