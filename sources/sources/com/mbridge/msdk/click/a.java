package com.mbridge.msdk.click;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.click.entity.JumpLoaderResult;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.d;
import com.mbridge.msdk.foundation.same.report.k;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.same.report.q;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.ae;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.foundation.tools.w;
import com.mbridge.msdk.out.BaseTrackingListener;
import com.mbridge.msdk.out.Campaign;
import com.mbridge.msdk.out.Frame;
import com.mbridge.msdk.out.LoadingActivity;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.scheme.applet.AppletSchemeCallBack;
import com.mbridge.msdk.scheme.applet.AppletsModel;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* compiled from: CommonClickControl */
public final class a {
    public static boolean a = false;
    public static Map<String, Long> b = new HashMap();
    public static Set<String> c = new HashSet();
    /* access modifiers changed from: private */
    public String d;
    private long e;
    /* access modifiers changed from: private */
    public h f = null;
    private Context g = null;
    private c h;
    /* access modifiers changed from: private */
    public NativeListener.NativeTrackingListener i = null;
    private p j;
    private e k;
    private boolean l;
    /* access modifiers changed from: private */
    public boolean m = false;
    private boolean n = true;
    /* access modifiers changed from: private */
    public boolean o;
    private h p;

    static /* synthetic */ String a(int i2) {
        return i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 4 ? "" : "2000138" : "2000139" : "2000137" : "2000136";
    }

    public a(Context context, String str) {
        e b2 = f.a().b(str);
        this.k = b2;
        if (b2 == null) {
            this.k = f.a().b();
        }
        this.l = this.k.T();
        Context applicationContext = context.getApplicationContext();
        this.g = applicationContext;
        this.d = str;
        if (this.f == null) {
            this.f = h.a(applicationContext);
        }
        this.j = new p(this.g);
    }

    public final void a(String str) {
        this.d = str;
    }

    public final void a(NativeListener.NativeTrackingListener nativeTrackingListener) {
        this.i = nativeTrackingListener;
    }

    public final void a(h hVar) {
        this.p = hVar;
    }

    public final void a(boolean z) {
        this.n = z;
    }

    public final void a() {
        try {
            this.i = null;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final void a(CampaignEx campaignEx, NativeListener.NativeAdListener nativeAdListener) {
        if (!(nativeAdListener == null || campaignEx == null)) {
            nativeAdListener.onAdClick(campaignEx);
        }
        a(campaignEx);
    }

    private boolean b(CampaignEx campaignEx) {
        Long l2;
        if (campaignEx == null) {
            return true;
        }
        try {
            if (2 != campaignEx.getLinkType() && 3 != campaignEx.getLinkType()) {
                return true;
            }
            String id = campaignEx.getId();
            Map<String, Long> map = b;
            if (map == null) {
                return true;
            }
            if (map.containsKey(id) && (l2 = b.get(id)) != null) {
                if (l2.longValue() > System.currentTimeMillis() || c.contains(campaignEx.getId())) {
                    return false;
                }
            }
            b.put(campaignEx.getId(), Long.valueOf(System.currentTimeMillis() + ((long) (campaignEx.getClickTimeOutInterval() * 1000))));
            return true;
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return true;
            }
            e2.printStackTrace();
            return true;
        }
    }

    private void a(CampaignEx campaignEx, String str) {
        if (!TextUtils.isEmpty(str)) {
            a(this.g, campaignEx, this.d, str, true, false, com.mbridge.msdk.click.a.a.i);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v14, resolved type: com.mbridge.msdk.out.NativeListener$NativeTrackingListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v15, resolved type: com.mbridge.msdk.click.h} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v46, resolved type: com.mbridge.msdk.out.NativeListener$NativeTrackingListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v47, resolved type: com.mbridge.msdk.out.NativeListener$NativeTrackingListener} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v48, resolved type: com.mbridge.msdk.out.NativeListener$NativeTrackingListener} */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:118:0x029c */
    /* JADX WARNING: Missing exception handler attribute for start block: B:170:0x0377 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:28:0x00cd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0148 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x0239 A[Catch:{ all -> 0x03ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x02c1 A[Catch:{ all -> 0x03ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x02c9 A[Catch:{ all -> 0x03ad }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:? A[Catch:{ all -> 0x03ad }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:199:? A[Catch:{ all -> 0x03ad }, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x015e A[Catch:{ all -> 0x03ad }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.mbridge.msdk.foundation.entity.CampaignEx r21) {
        /*
            r20 = this;
            r1 = r20
            r0 = r21
            java.lang.String r2 = "MBridge SDK M"
            java.lang.String r3 = "1"
            java.lang.String r4 = "最终地址是gp, 但是打开失败了："
            java.lang.String r5 = "不用做302跳转 最终地址已经是gp了："
            boolean r6 = r20.b((com.mbridge.msdk.foundation.entity.CampaignEx) r21)     // Catch:{ all -> 0x03ad }
            if (r6 != 0) goto L_0x0015
            return
        L_0x0015:
            java.util.HashMap r6 = new java.util.HashMap     // Catch:{ all -> 0x03ad }
            r6.<init>()     // Catch:{ all -> 0x03ad }
            java.lang.String r7 = "update"
            r6.put(r7, r3)     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.foundation.same.report.m r7 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ all -> 0x03ad }
            java.lang.String r8 = "2000149"
            r7.a((java.lang.String) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.util.Map<java.lang.String, java.lang.String>) r6)     // Catch:{ all -> 0x03ad }
            java.lang.String r6 = r21.getNoticeUrl()     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.foundation.db.h r7 = r1.f     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.foundation.db.d r7 = com.mbridge.msdk.foundation.db.d.a(r7)     // Catch:{ all -> 0x03ad }
            r7.a()     // Catch:{ all -> 0x03ad }
            java.lang.String r8 = r21.getId()     // Catch:{ all -> 0x03ad }
            java.lang.String r9 = r1.d     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.click.entity.JumpLoaderResult r8 = r7.b(r8, r9)     // Catch:{ all -> 0x03ad }
            if (r8 == 0) goto L_0x0054
            java.lang.String r9 = r8.getNoticeurl()     // Catch:{ all -> 0x03ad }
            if (r9 == 0) goto L_0x004c
            r9 = 0
            r8.setNoticeurl(r9)     // Catch:{ all -> 0x03ad }
        L_0x004c:
            r0.setJumpResult(r8)     // Catch:{ all -> 0x03ad }
            java.lang.String r9 = r1.d     // Catch:{ all -> 0x03ad }
            r7.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.lang.String) r9)     // Catch:{ all -> 0x03ad }
        L_0x0054:
            com.mbridge.msdk.scheme.applet.AppletModelManager r7 = com.mbridge.msdk.scheme.applet.AppletModelManager.getInstance()     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.scheme.applet.AppletsModel r7 = r7.get(r0)     // Catch:{ all -> 0x03ad }
            boolean r9 = com.mbridge.msdk.foundation.tools.af.a((com.mbridge.msdk.foundation.entity.CampaignEx) r21)     // Catch:{ all -> 0x03ad }
            java.lang.String r10 = "&opdptype=1"
            java.lang.String r11 = "&opdptype=0"
            java.lang.String r12 = "2"
            java.lang.String r13 = "type"
            java.lang.String r14 = "2000150"
            java.lang.String r15 = "result"
            if (r9 == 0) goto L_0x00e4
            com.mbridge.msdk.foundation.tools.q r9 = com.mbridge.msdk.foundation.tools.q.a()     // Catch:{ all -> 0x03ad }
            r9.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ all -> 0x03ad }
            java.util.HashMap r9 = new java.util.HashMap     // Catch:{ all -> 0x03ad }
            r9.<init>()     // Catch:{ all -> 0x03ad }
            r16 = r4
            java.lang.String r4 = "3"
            r9.put(r13, r4)     // Catch:{ all -> 0x03ad }
            android.content.Context r4 = r1.g     // Catch:{ all -> 0x03ad }
            r17 = r13
            java.lang.String r13 = r21.getDeepLinkURL()     // Catch:{ all -> 0x03ad }
            boolean r4 = com.mbridge.msdk.click.b.d(r4, r13)     // Catch:{ all -> 0x03ad }
            if (r4 == 0) goto L_0x00c3
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r1.i     // Catch:{ all -> 0x03ad }
            if (r4 == 0) goto L_0x009b
            java.lang.String r5 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r4.onStartRedirection(r0, r5)     // Catch:{ all -> 0x03ad }
        L_0x009b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ad }
            r4.<init>()     // Catch:{ all -> 0x03ad }
            r4.append(r6)     // Catch:{ all -> 0x03ad }
            r4.append(r10)     // Catch:{ all -> 0x03ad }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x03ad }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.lang.String) r4)     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r1.i     // Catch:{ all -> 0x03ad }
            if (r4 == 0) goto L_0x00b8
            java.lang.String r5 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r4.onFinishRedirection(r0, r5)     // Catch:{ all -> 0x03ad }
        L_0x00b8:
            r9.put(r15, r3)     // Catch:{ Exception -> 0x00c2 }
            com.mbridge.msdk.foundation.same.report.m r3 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x00c2 }
            r3.a((java.lang.String) r14, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.util.Map<java.lang.String, java.lang.String>) r9)     // Catch:{ Exception -> 0x00c2 }
        L_0x00c2:
            return
        L_0x00c3:
            r9.put(r15, r12)     // Catch:{ Exception -> 0x00cd }
            com.mbridge.msdk.foundation.same.report.m r4 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x00cd }
            r4.a((java.lang.String) r14, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.util.Map<java.lang.String, java.lang.String>) r9)     // Catch:{ Exception -> 0x00cd }
        L_0x00cd:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ad }
            r4.<init>()     // Catch:{ all -> 0x03ad }
            r4.append(r6)     // Catch:{ all -> 0x03ad }
            r4.append(r11)     // Catch:{ all -> 0x03ad }
            java.lang.String r6 = r4.toString()     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.foundation.tools.q r4 = com.mbridge.msdk.foundation.tools.q.a()     // Catch:{ all -> 0x03ad }
            r4.b((com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ all -> 0x03ad }
            goto L_0x00e8
        L_0x00e4:
            r16 = r4
            r17 = r13
        L_0x00e8:
            int r4 = r21.getLinkType()     // Catch:{ all -> 0x03ad }
            r9 = 12
            if (r4 != r9) goto L_0x010f
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.i     // Catch:{ all -> 0x03ad }
            if (r3 == 0) goto L_0x00fb
            java.lang.String r4 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r3.onStartRedirection(r0, r4)     // Catch:{ all -> 0x03ad }
        L_0x00fb:
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.lang.String) r6)     // Catch:{ all -> 0x03ad }
            android.content.Context r3 = r1.g     // Catch:{ all -> 0x03ad }
            r1.a((android.content.Context) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r0)     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.i     // Catch:{ all -> 0x03ad }
            if (r3 == 0) goto L_0x010e
            java.lang.String r4 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r3.onFinishRedirection(r0, r4)     // Catch:{ all -> 0x03ad }
        L_0x010e:
            return
        L_0x010f:
            r4 = 1
            if (r7 == 0) goto L_0x01c8
            boolean r9 = r7.isSupportWxScheme()     // Catch:{ all -> 0x03ad }
            if (r9 == 0) goto L_0x01c8
            boolean r9 = r7.isRequestSuccess()     // Catch:{ all -> 0x03ad }
            if (r9 == 0) goto L_0x0176
            android.content.Context r9 = r1.g     // Catch:{ all -> 0x03ad }
            java.lang.String r7 = r7.getDeepLink()     // Catch:{ all -> 0x03ad }
            boolean r7 = com.mbridge.msdk.click.b.d(r9, r7)     // Catch:{ all -> 0x03ad }
            if (r7 == 0) goto L_0x0166
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.i     // Catch:{ all -> 0x03ad }
            if (r3 == 0) goto L_0x0135
            java.lang.String r4 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r3.onStartRedirection(r0, r4)     // Catch:{ all -> 0x03ad }
        L_0x0135:
            android.content.Context r3 = r1.g     // Catch:{ all -> 0x03ad }
            if (r3 == 0) goto L_0x0148
            android.content.Intent r3 = new android.content.Intent     // Catch:{ all -> 0x03ad }
            r3.<init>()     // Catch:{ all -> 0x03ad }
            java.lang.String r4 = "mb_dp_close_broadcast_receiver"
            r3.setAction(r4)     // Catch:{ all -> 0x03ad }
            android.content.Context r4 = r1.g     // Catch:{ Exception -> 0x0148 }
            r4.sendBroadcast(r3)     // Catch:{ Exception -> 0x0148 }
        L_0x0148:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ad }
            r3.<init>()     // Catch:{ all -> 0x03ad }
            r3.append(r6)     // Catch:{ all -> 0x03ad }
            r3.append(r10)     // Catch:{ all -> 0x03ad }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03ad }
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.lang.String) r3)     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.i     // Catch:{ all -> 0x03ad }
            if (r3 == 0) goto L_0x0165
            java.lang.String r4 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r3.onFinishRedirection(r0, r4)     // Catch:{ all -> 0x03ad }
        L_0x0165:
            return
        L_0x0166:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ad }
            r7.<init>()     // Catch:{ all -> 0x03ad }
            r7.append(r6)     // Catch:{ all -> 0x03ad }
            r7.append(r11)     // Catch:{ all -> 0x03ad }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x03ad }
            goto L_0x01c8
        L_0x0176:
            boolean r9 = r7.isRequesting()     // Catch:{ all -> 0x03ad }
            if (r9 == 0) goto L_0x0191
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.i     // Catch:{ all -> 0x03ad }
            if (r3 == 0) goto L_0x0187
            java.lang.String r4 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r3.onStartRedirection(r0, r4)     // Catch:{ all -> 0x03ad }
        L_0x0187:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.i     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.scheme.applet.AppletSchemeCallBack r0 = r1.a((com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (com.mbridge.msdk.scheme.applet.AppletsModel) r7, (com.mbridge.msdk.click.a) r1)     // Catch:{ all -> 0x03ad }
            r7.setAppletSchemeCallBack(r0)     // Catch:{ all -> 0x03ad }
            return
        L_0x0191:
            boolean r9 = r7.can(r4)     // Catch:{ all -> 0x03ad }
            if (r9 == 0) goto L_0x01c8
            boolean r9 = r7.isRequestTimesMaxPerDay()     // Catch:{ all -> 0x03ad }
            if (r9 == 0) goto L_0x01b3
            if (r0 == 0) goto L_0x01c8
            if (r7 == 0) goto L_0x01c8
            java.lang.String r9 = r7.getReBuildClickUrl()     // Catch:{ all -> 0x03ad }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x03ad }
            if (r9 != 0) goto L_0x01c8
            java.lang.String r7 = r7.getReBuildClickUrl()     // Catch:{ all -> 0x03ad }
            r0.setClickURL(r7)     // Catch:{ all -> 0x03ad }
            goto L_0x01c8
        L_0x01b3:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.i     // Catch:{ all -> 0x03ad }
            if (r3 == 0) goto L_0x01be
            java.lang.String r5 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r3.onStartRedirection(r0, r5)     // Catch:{ all -> 0x03ad }
        L_0x01be:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.i     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.scheme.applet.AppletSchemeCallBack r0 = r1.a((com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (com.mbridge.msdk.scheme.applet.AppletsModel) r7, (com.mbridge.msdk.click.a) r1)     // Catch:{ all -> 0x03ad }
            r7.requestWxAppletsScheme(r4, r0)     // Catch:{ all -> 0x03ad }
            return
        L_0x01c8:
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.lang.String) r6)     // Catch:{ all -> 0x03ad }
            boolean r6 = r21.getUserActivation()     // Catch:{ all -> 0x03ad }
            if (r6 != 0) goto L_0x0205
            android.content.Context r6 = r1.g     // Catch:{ all -> 0x03ad }
            java.lang.String r7 = r21.getPackageName()     // Catch:{ all -> 0x03ad }
            boolean r6 = com.mbridge.msdk.click.b.c(r6, r7)     // Catch:{ all -> 0x03ad }
            if (r6 == 0) goto L_0x0205
            android.content.Context r3 = r1.g     // Catch:{ all -> 0x03ad }
            java.lang.String r5 = r21.getPackageName()     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.click.b.e(r3, r5)     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.i     // Catch:{ all -> 0x03ad }
            if (r3 == 0) goto L_0x01f1
            java.lang.String r5 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r3.onStartRedirection(r0, r5)     // Catch:{ all -> 0x03ad }
        L_0x01f1:
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (boolean) r4)     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.i     // Catch:{ all -> 0x03ad }
            if (r3 == 0) goto L_0x0204
            java.lang.String r4 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r3.onFinishRedirection(r0, r4)     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r1.i     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.foundation.tools.ae.a((com.mbridge.msdk.out.BaseTrackingListener) r0)     // Catch:{ all -> 0x03ad }
        L_0x0204:
            return
        L_0x0205:
            int r6 = r21.getLinkType()     // Catch:{ all -> 0x03ad }
            int r7 = r20.b()     // Catch:{ all -> 0x03ad }
            r9 = 4
            r10 = 9
            r11 = 8
            r13 = 0
            if (r6 == r11) goto L_0x021d
            if (r6 == r10) goto L_0x021d
            if (r6 != r9) goto L_0x021a
            goto L_0x021d
        L_0x021a:
            r18 = 0
            goto L_0x021f
        L_0x021d:
            r18 = 1
        L_0x021f:
            java.lang.String r9 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            boolean r19 = android.text.TextUtils.isEmpty(r9)     // Catch:{ all -> 0x03ad }
            if (r19 != 0) goto L_0x02c9
            java.lang.String r10 = "market://"
            boolean r10 = r9.startsWith(r10)     // Catch:{ all -> 0x03ad }
            if (r10 != 0) goto L_0x0239
            java.lang.String r10 = "https://play.google.com/"
            boolean r9 = r9.startsWith(r10)     // Catch:{ all -> 0x03ad }
            if (r9 == 0) goto L_0x02c9
        L_0x0239:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r1.i     // Catch:{ all -> 0x03ad }
            if (r4 == 0) goto L_0x0244
            java.lang.String r6 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r4.onStartRedirection(r0, r6)     // Catch:{ all -> 0x03ad }
        L_0x0244:
            android.content.Context r4 = r1.g     // Catch:{ all -> 0x03ad }
            java.lang.String r6 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r9 = r1.i     // Catch:{ all -> 0x03ad }
            boolean r4 = com.mbridge.msdk.foundation.tools.ae.a.a(r4, r6, r9)     // Catch:{ all -> 0x03ad }
            if (r4 == 0) goto L_0x0288
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (boolean) r13)     // Catch:{ all -> 0x03ad }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ad }
            r4.<init>(r5)     // Catch:{ all -> 0x03ad }
            java.lang.String r5 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r4.append(r5)     // Catch:{ all -> 0x03ad }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.foundation.tools.aa.b(r2, r4)     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r1.i     // Catch:{ all -> 0x03ad }
            if (r4 == 0) goto L_0x0273
            java.lang.String r5 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r4.onFinishRedirection(r0, r5)     // Catch:{ all -> 0x03ad }
        L_0x0273:
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x0287 }
            r4.<init>()     // Catch:{ Exception -> 0x0287 }
            r5 = r17
            r4.put(r5, r3)     // Catch:{ Exception -> 0x0287 }
            r4.put(r15, r3)     // Catch:{ Exception -> 0x0287 }
            com.mbridge.msdk.foundation.same.report.m r3 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x0287 }
            r3.a((java.lang.String) r14, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.util.Map<java.lang.String, java.lang.String>) r4)     // Catch:{ Exception -> 0x0287 }
        L_0x0287:
            return
        L_0x0288:
            r5 = r17
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x029c }
            r4.<init>()     // Catch:{ Exception -> 0x029c }
            r4.put(r5, r3)     // Catch:{ Exception -> 0x029c }
            r4.put(r15, r12)     // Catch:{ Exception -> 0x029c }
            com.mbridge.msdk.foundation.same.report.m r3 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x029c }
            r3.a((java.lang.String) r14, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.util.Map<java.lang.String, java.lang.String>) r4)     // Catch:{ Exception -> 0x029c }
        L_0x029c:
            java.lang.String r3 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r1.i     // Catch:{ all -> 0x03ad }
            r1.a((int) r7, (java.lang.String) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r4)     // Catch:{ all -> 0x03ad }
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (boolean) r13)     // Catch:{ all -> 0x03ad }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x03ad }
            r4 = r16
            r3.<init>(r4)     // Catch:{ all -> 0x03ad }
            java.lang.String r4 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r3.append(r4)     // Catch:{ all -> 0x03ad }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.foundation.tools.aa.b(r2, r3)     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r1.i     // Catch:{ all -> 0x03ad }
            if (r3 == 0) goto L_0x02c8
            java.lang.String r4 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            r3.onFinishRedirection(r0, r4)     // Catch:{ all -> 0x03ad }
        L_0x02c8:
            return
        L_0x02c9:
            r5 = r17
            r9 = 2
            if (r18 == 0) goto L_0x035c
            java.lang.String r3 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r1.i     // Catch:{ all -> 0x03ad }
            if (r5 == 0) goto L_0x02d9
            r5.onStartRedirection(r0, r3)     // Catch:{ all -> 0x03ad }
        L_0x02d9:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x03ad }
            if (r5 == 0) goto L_0x02ea
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r1.i     // Catch:{ all -> 0x03ad }
            if (r5 == 0) goto L_0x02e6
            r5.onRedirectionFailed(r0, r3)     // Catch:{ all -> 0x03ad }
        L_0x02e6:
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (boolean) r4)     // Catch:{ all -> 0x03ad }
            return
        L_0x02ea:
            if (r6 != r11) goto L_0x031f
            com.mbridge.msdk.foundation.entity.AabEntity r5 = r21.getAabEntity()     // Catch:{ all -> 0x03ad }
            if (r5 == 0) goto L_0x030d
            com.mbridge.msdk.foundation.entity.AabEntity r5 = r21.getAabEntity()     // Catch:{ all -> 0x03ad }
            int r5 = r5.getHlp()     // Catch:{ all -> 0x03ad }
            if (r5 != r4) goto L_0x030d
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r1.i     // Catch:{ all -> 0x03ad }
            if (r4 != 0) goto L_0x0307
            com.mbridge.msdk.click.h r4 = r1.p     // Catch:{ all -> 0x03ad }
            if (r4 == 0) goto L_0x0307
            r4.onStartRedirection(r0, r3)     // Catch:{ all -> 0x03ad }
        L_0x0307:
            android.content.Context r5 = r1.g     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.foundation.tools.ae.a(r5, r3, r0, r1, r4)     // Catch:{ all -> 0x03ad }
            goto L_0x031b
        L_0x030d:
            android.content.Context r4 = r1.g     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r1.i     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.foundation.tools.ae.a((android.content.Context) r4, (java.lang.String) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r5)     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r1.i     // Catch:{ all -> 0x03ad }
            if (r4 == 0) goto L_0x031b
            r4.onFinishRedirection(r0, r3)     // Catch:{ all -> 0x03ad }
        L_0x031b:
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (boolean) r13)     // Catch:{ all -> 0x03ad }
            return
        L_0x031f:
            r4 = 9
            if (r6 != r4) goto L_0x0339
            android.content.Context r4 = r1.g     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r1.i     // Catch:{ all -> 0x03ad }
            java.lang.String r6 = r21.getCurrentLRid()     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.foundation.tools.ae.a((android.content.Context) r4, (java.lang.String) r3, (com.mbridge.msdk.out.BaseTrackingListener) r5, (java.lang.String) r6)     // Catch:{ all -> 0x03ad }
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (boolean) r13)     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r1.i     // Catch:{ all -> 0x03ad }
            if (r4 == 0) goto L_0x0338
            r4.onFinishRedirection(r0, r3)     // Catch:{ all -> 0x03ad }
        L_0x0338:
            return
        L_0x0339:
            r4 = 4
            if (r6 != r4) goto L_0x0351
            if (r7 != r9) goto L_0x0346
            android.content.Context r4 = r1.g     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r1.i     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.foundation.tools.ae.a((android.content.Context) r4, (java.lang.String) r3, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r5)     // Catch:{ all -> 0x03ad }
            goto L_0x0351
        L_0x0346:
            android.content.Context r4 = r1.g     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r1.i     // Catch:{ all -> 0x03ad }
            java.lang.String r6 = r21.getCurrentLRid()     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.foundation.tools.ae.a((android.content.Context) r4, (java.lang.String) r3, (com.mbridge.msdk.out.BaseTrackingListener) r5, (java.lang.String) r6)     // Catch:{ all -> 0x03ad }
        L_0x0351:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r1.i     // Catch:{ all -> 0x03ad }
            if (r4 == 0) goto L_0x0358
            r4.onFinishRedirection(r0, r3)     // Catch:{ all -> 0x03ad }
        L_0x0358:
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (boolean) r13)     // Catch:{ all -> 0x03ad }
            goto L_0x03b5
        L_0x035c:
            if (r6 != r9) goto L_0x0362
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (boolean) r13)     // Catch:{ all -> 0x03ad }
            goto L_0x03b5
        L_0x0362:
            r7 = 3
            if (r6 != r7) goto L_0x037b
            java.util.HashMap r4 = new java.util.HashMap     // Catch:{ Exception -> 0x0377 }
            r4.<init>()     // Catch:{ Exception -> 0x0377 }
            r4.put(r5, r12)     // Catch:{ Exception -> 0x0377 }
            r4.put(r15, r3)     // Catch:{ Exception -> 0x0377 }
            com.mbridge.msdk.foundation.same.report.m r3 = com.mbridge.msdk.foundation.same.report.m.a()     // Catch:{ Exception -> 0x0377 }
            r3.a((java.lang.String) r14, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (java.util.Map<java.lang.String, java.lang.String>) r4)     // Catch:{ Exception -> 0x0377 }
        L_0x0377:
            r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r0, (boolean) r13)     // Catch:{ all -> 0x03ad }
            goto L_0x03b5
        L_0x037b:
            java.lang.String r3 = r21.getClickURL()     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r1.i     // Catch:{ all -> 0x03ad }
            if (r5 == 0) goto L_0x0386
            r5.onStartRedirection(r0, r3)     // Catch:{ all -> 0x03ad }
        L_0x0386:
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x03ad }
            if (r5 == 0) goto L_0x0397
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r1.i     // Catch:{ all -> 0x03ad }
            if (r5 == 0) goto L_0x0393
            r5.onRedirectionFailed(r0, r3)     // Catch:{ all -> 0x03ad }
        L_0x0393:
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (boolean) r4)     // Catch:{ all -> 0x03ad }
            return
        L_0x0397:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r5 = r1.i     // Catch:{ all -> 0x03ad }
            if (r5 == 0) goto L_0x039e
            r5.onFinishRedirection(r0, r3)     // Catch:{ all -> 0x03ad }
        L_0x039e:
            android.content.Context r5 = r1.g     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r6 = r1.i     // Catch:{ all -> 0x03ad }
            java.lang.String r7 = r21.getCurrentLRid()     // Catch:{ all -> 0x03ad }
            com.mbridge.msdk.foundation.tools.ae.a((android.content.Context) r5, (java.lang.String) r3, (com.mbridge.msdk.out.BaseTrackingListener) r6, (java.lang.String) r7)     // Catch:{ all -> 0x03ad }
            r1.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r8, (com.mbridge.msdk.foundation.entity.CampaignEx) r0, (boolean) r4)     // Catch:{ all -> 0x03ad }
            goto L_0x03b5
        L_0x03ad:
            r0 = move-exception
            java.lang.String r3 = r0.getMessage()
            com.mbridge.msdk.foundation.tools.aa.b(r2, r3, r0)
        L_0x03b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx):void");
    }

    private AppletSchemeCallBack a(NativeListener.NativeTrackingListener nativeTrackingListener, CampaignEx campaignEx, AppletsModel appletsModel, a aVar) {
        return new f(nativeTrackingListener, campaignEx, appletsModel, aVar);
    }

    private void a(Context context, CampaignEx campaignEx) {
        if (context == null) {
            q.a(b.d().g(), campaignEx, 2, "context is null", this.d);
            return;
        }
        boolean z = w.g() == 1;
        boolean z2 = w.f(context) == 1;
        if (!z || !z2) {
            q.a(context, campaignEx, 2, "integrated:" + z + "-hasWx:" + z2, this.d);
            c(campaignEx);
            return;
        }
        String ghId = campaignEx.getGhId();
        String ghPath = campaignEx.getGhPath();
        String bindId = campaignEx.getBindId();
        String i2 = b.d().i();
        if (!TextUtils.isEmpty(ghId)) {
            try {
                if (!TextUtils.isEmpty(i2)) {
                    bindId = i2;
                }
                Object b2 = w.b(bindId);
                Class<?> cls = Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram$Req");
                Object newInstance = cls.newInstance();
                cls.getField("userName").set(newInstance, ghId);
                cls.getField("path").set(newInstance, ghPath);
                cls.getField("miniprogramType").set(newInstance, cls.getField("MINIPTOGRAM_TYPE_RELEASE").get((Object) null));
                Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("sendReq", new Class[]{Class.forName("com.tencent.mm.opensdk.modelbase.BaseReq")}).invoke(b2, new Object[]{newInstance});
                q.a(context, campaignEx, 1, "", this.d);
            } catch (Throwable th) {
                q.a(context, campaignEx, 2, th.getMessage(), this.d);
                c(campaignEx);
            }
        } else {
            c(campaignEx);
            q.a(context, campaignEx, 2, "ghid is empty", this.d);
        }
    }

    private void c(CampaignEx campaignEx) {
        if (b() == 2) {
            ae.a(this.g, campaignEx.getClickURL(), campaignEx, this.i);
        } else {
            ae.a(this.g, campaignEx.getClickURL(), (BaseTrackingListener) this.i, campaignEx.getCurrentLRid());
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String str2, boolean z, boolean z2) {
        if (context != null) {
            new c(context.getApplicationContext()).a(str, campaignEx, (e) null, str2, z, z2, com.mbridge.msdk.click.a.a.f);
        }
    }

    public static void a(Context context, final CampaignEx campaignEx, String str, String str2, boolean z, boolean z2, final int i2) {
        if (context != null) {
            final int i3 = TextUtils.isEmpty(str2) ? -1 : str2.startsWith("tcp") ? 1 : 0;
            new c(context.getApplicationContext()).a(str, campaignEx, new e() {
                public final void a(Object obj) {
                }

                public final void b(Object obj) {
                    try {
                        HashMap hashMap = new HashMap();
                        hashMap.put(IronSourceConstants.EVENTS_RESULT, "2");
                        hashMap.put("net_ty", String.valueOf(i3));
                        if (obj instanceof JumpLoaderResult) {
                            String str = ((JumpLoaderResult) obj).getStatusCode() + "";
                            hashMap.put("status_code", str);
                            if (str.startsWith("2")) {
                                hashMap.put(IronSourceConstants.EVENTS_RESULT, "1");
                            }
                        }
                        String a2 = a.a(i2);
                        hashMap.put("update", "1");
                        m.a().a(a2, campaignEx, (Map<String, String>) hashMap);
                    } catch (Exception e) {
                        aa.d("MBridge SDK M", e.getMessage());
                    }
                }

                public final void a(Object obj, String str) {
                    try {
                        String a2 = a.a(i2);
                        HashMap hashMap = new HashMap();
                        hashMap.put(IronSourceConstants.EVENTS_RESULT, "2");
                        hashMap.put("code", "");
                        if (obj instanceof JumpLoaderResult) {
                            String exceptionMsg = ((JumpLoaderResult) obj).getExceptionMsg();
                            if (!TextUtils.isEmpty(exceptionMsg)) {
                                str = exceptionMsg;
                            }
                            hashMap.put(IronSourceConstants.EVENTS_ERROR_REASON, str);
                        }
                        hashMap.put("failing", "");
                        hashMap.put("update", "1");
                        hashMap.put("net_ty", String.valueOf(i3));
                        m.a().a(a2, campaignEx, (Map<String, String>) hashMap);
                    } catch (Exception e) {
                        aa.d("MBridge SDK M", e.getMessage());
                    }
                }
            }, str2, z, z2, i2);
        }
    }

    public static void a(Context context, CampaignEx campaignEx, String str, String[] strArr, boolean z, boolean z2) {
        if (context != null && campaignEx != null && !TextUtils.isEmpty(str) && strArr != null) {
            c cVar = new c(context.getApplicationContext());
            for (String a2 : strArr) {
                cVar.a(str, campaignEx, new e() {
                    public final void a(Object obj) {
                    }

                    public final void a(Object obj, String str) {
                    }

                    public final void b(Object obj) {
                    }
                }, a2, z, z2, com.mbridge.msdk.click.a.a.f);
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x00dd A[Catch:{ Exception -> 0x011e }] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ee A[Catch:{ Exception -> 0x011e }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00ff A[Catch:{ Exception -> 0x011e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(final com.mbridge.msdk.foundation.entity.CampaignEx r9, final boolean r10) {
        /*
            r8 = this;
            java.lang.String r0 = "market://details?id="
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x011e }
            r8.e = r1     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r8.i     // Catch:{ Exception -> 0x011e }
            r2 = 1
            if (r1 == 0) goto L_0x001e
            if (r10 != 0) goto L_0x001e
            java.lang.String r3 = r9.getClickURL()     // Catch:{ Exception -> 0x011e }
            r1.onStartRedirection(r9, r3)     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r1 = r8.i     // Catch:{ Exception -> 0x011e }
            boolean r1 = r1.onInterceptDefaultLoadingDialog()     // Catch:{ Exception -> 0x011e }
            r1 = r1 ^ r2
            goto L_0x001f
        L_0x001e:
            r1 = 1
        L_0x001f:
            r3 = 0
            r8.o = r3     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.click.entity.JumpLoaderResult r4 = r9.getJumpResult()     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0039
            if (r10 != 0) goto L_0x0033
            com.mbridge.msdk.click.entity.JumpLoaderResult r4 = r9.getJumpResult()     // Catch:{ Exception -> 0x011e }
            boolean r5 = r8.m     // Catch:{ Exception -> 0x011e }
            r8.a((com.mbridge.msdk.foundation.entity.CampaignEx) r9, (com.mbridge.msdk.click.entity.JumpLoaderResult) r4, (boolean) r2, (boolean) r5)     // Catch:{ Exception -> 0x011e }
        L_0x0033:
            r8.o = r2     // Catch:{ Exception -> 0x011e }
            r8.m = r3     // Catch:{ Exception -> 0x011e }
            r4 = 0
            goto L_0x003a
        L_0x0039:
            r4 = 1
        L_0x003a:
            com.mbridge.msdk.foundation.db.h r5 = r8.f     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.foundation.db.d r5 = com.mbridge.msdk.foundation.db.d.a(r5)     // Catch:{ Exception -> 0x011e }
            java.lang.String r6 = r9.getId()     // Catch:{ Exception -> 0x011e }
            java.lang.String r7 = r8.d     // Catch:{ Exception -> 0x011e }
            boolean r5 = r5.a((java.lang.String) r6, (java.lang.String) r7)     // Catch:{ Exception -> 0x011e }
            if (r5 == 0) goto L_0x0052
            com.mbridge.msdk.click.entity.JumpLoaderResult r5 = r9.getJumpResult()     // Catch:{ Exception -> 0x011e }
            if (r5 != 0) goto L_0x0122
        L_0x0052:
            com.mbridge.msdk.foundation.db.h r5 = r8.f     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.foundation.db.d r5 = com.mbridge.msdk.foundation.db.d.a(r5)     // Catch:{ Exception -> 0x011e }
            r5.a()     // Catch:{ Exception -> 0x011e }
            java.lang.String r6 = r9.getId()     // Catch:{ Exception -> 0x011e }
            java.lang.String r7 = r8.d     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.click.entity.JumpLoaderResult r5 = r5.b(r6, r7)     // Catch:{ Exception -> 0x011e }
            if (r5 == 0) goto L_0x007a
            if (r10 != 0) goto L_0x007a
            r9.setJumpResult(r5)     // Catch:{ Exception -> 0x011e }
            if (r4 == 0) goto L_0x0078
            boolean r0 = r8.m     // Catch:{ Exception -> 0x011e }
            r8.a((com.mbridge.msdk.foundation.entity.CampaignEx) r9, (com.mbridge.msdk.click.entity.JumpLoaderResult) r5, (boolean) r4, (boolean) r0)     // Catch:{ Exception -> 0x011e }
            r8.o = r2     // Catch:{ Exception -> 0x011e }
            r8.m = r3     // Catch:{ Exception -> 0x011e }
            goto L_0x00c8
        L_0x0078:
            r3 = r4
            goto L_0x00c8
        L_0x007a:
            java.lang.String r5 = r9.getClick_mode()     // Catch:{ Exception -> 0x011e }
            java.lang.String r6 = "6"
            boolean r5 = r5.equals(r6)     // Catch:{ Exception -> 0x011e }
            if (r5 == 0) goto L_0x00c2
            java.lang.String r5 = r9.getPackageName()     // Catch:{ Exception -> 0x011e }
            boolean r5 = r5.isEmpty()     // Catch:{ Exception -> 0x011e }
            if (r5 != 0) goto L_0x00c2
            int r5 = r9.getLinkType()     // Catch:{ Exception -> 0x011e }
            r6 = 2
            if (r5 != r6) goto L_0x00c2
            if (r10 != 0) goto L_0x00c2
            android.content.Context r5 = r8.g     // Catch:{ Exception -> 0x011e }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x011e }
            r6.<init>(r0)     // Catch:{ Exception -> 0x011e }
            java.lang.String r0 = r9.getPackageName()     // Catch:{ Exception -> 0x011e }
            r6.append(r0)     // Catch:{ Exception -> 0x011e }
            java.lang.String r0 = r6.toString()     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r6 = r8.i     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.foundation.tools.ae.a.a(r5, r0, r6)     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r8.i     // Catch:{ Exception -> 0x011e }
            if (r0 == 0) goto L_0x00bf
            if (r4 == 0) goto L_0x00bf
            r0.onDismissLoading(r9)     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r8.i     // Catch:{ Exception -> 0x011e }
            r4 = 0
            r0.onFinishRedirection(r9, r4)     // Catch:{ Exception -> 0x011e }
        L_0x00bf:
            r8.o = r2     // Catch:{ Exception -> 0x011e }
            r4 = 0
        L_0x00c2:
            if (r10 == 0) goto L_0x0078
            r8.o = r2     // Catch:{ Exception -> 0x011e }
            r8.m = r3     // Catch:{ Exception -> 0x011e }
        L_0x00c8:
            android.os.Handler r0 = new android.os.Handler     // Catch:{ Exception -> 0x011e }
            android.os.Looper r2 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x011e }
            r0.<init>(r2)     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.click.a$3 r2 = new com.mbridge.msdk.click.a$3     // Catch:{ Exception -> 0x011e }
            r2.<init>(r1, r10, r9)     // Catch:{ Exception -> 0x011e }
            r0.post(r2)     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.click.c r10 = r8.h     // Catch:{ Exception -> 0x011e }
            if (r10 == 0) goto L_0x00e0
            r10.a()     // Catch:{ Exception -> 0x011e }
        L_0x00e0:
            java.util.Set<java.lang.String> r10 = c     // Catch:{ Exception -> 0x011e }
            if (r10 == 0) goto L_0x00ff
            java.lang.String r0 = r9.getId()     // Catch:{ Exception -> 0x011e }
            boolean r10 = r10.contains(r0)     // Catch:{ Exception -> 0x011e }
            if (r10 == 0) goto L_0x00ff
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r10 = r8.i     // Catch:{ Exception -> 0x011e }
            if (r10 == 0) goto L_0x00fe
            r10.onDismissLoading(r9)     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r10 = r8.i     // Catch:{ Exception -> 0x011e }
            java.lang.String r0 = r9.getClickURL()     // Catch:{ Exception -> 0x011e }
            r10.onFinishRedirection(r9, r0)     // Catch:{ Exception -> 0x011e }
        L_0x00fe:
            return
        L_0x00ff:
            java.util.Set<java.lang.String> r10 = c     // Catch:{ Exception -> 0x011e }
            if (r10 == 0) goto L_0x010a
            java.lang.String r0 = r9.getId()     // Catch:{ Exception -> 0x011e }
            r10.add(r0)     // Catch:{ Exception -> 0x011e }
        L_0x010a:
            com.mbridge.msdk.click.c r10 = new com.mbridge.msdk.click.c     // Catch:{ Exception -> 0x011e }
            android.content.Context r0 = r8.g     // Catch:{ Exception -> 0x011e }
            r10.<init>(r0)     // Catch:{ Exception -> 0x011e }
            r8.h = r10     // Catch:{ Exception -> 0x011e }
            java.lang.String r0 = r8.d     // Catch:{ Exception -> 0x011e }
            com.mbridge.msdk.click.a$4 r2 = new com.mbridge.msdk.click.a$4     // Catch:{ Exception -> 0x011e }
            r2.<init>(r9, r3, r1)     // Catch:{ Exception -> 0x011e }
            r10.a(r0, r9, r2)     // Catch:{ Exception -> 0x011e }
            goto L_0x0122
        L_0x011e:
            r9 = move-exception
            r9.printStackTrace()
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx, boolean):void");
    }

    public final void a(JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, int i2, boolean z) {
        if (campaignEx != null && jumpLoaderResult != null) {
            try {
                long currentTimeMillis = System.currentTimeMillis() - this.e;
                d dVar = new d();
                int r = w.r(this.g);
                dVar.a(r);
                dVar.a(w.a(this.g, r));
                dVar.j(campaignEx.getRequestId());
                dVar.k(campaignEx.getRequestIdNotice());
                dVar.d(i2);
                dVar.i(currentTimeMillis + "");
                dVar.h(campaignEx.getId());
                dVar.f(jumpLoaderResult.getType());
                if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                    dVar.g(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
                }
                dVar.c((this.e / 1000) + "");
                dVar.b(Integer.parseInt(campaignEx.getLandingType()));
                dVar.c(campaignEx.getLinkType());
                dVar.b(this.d);
                dVar.f(jumpLoaderResult.getType());
                if (!TextUtils.isEmpty(jumpLoaderResult.getUrl())) {
                    dVar.g(URLEncoder.encode(jumpLoaderResult.getUrl(), "utf-8"));
                }
                if (this.l) {
                    dVar.e(jumpLoaderResult.getStatusCode());
                    if (!TextUtils.isEmpty(jumpLoaderResult.getHeader())) {
                        dVar.e(URLEncoder.encode(jumpLoaderResult.getHeader(), "utf-8"));
                    }
                    if (!TextUtils.isEmpty(jumpLoaderResult.getContent())) {
                        dVar.f(URLEncoder.encode(jumpLoaderResult.getContent(), "UTF-8"));
                    }
                    if (!TextUtils.isEmpty(jumpLoaderResult.getExceptionMsg())) {
                        dVar.d(URLEncoder.encode(jumpLoaderResult.getExceptionMsg(), "utf-8"));
                    }
                }
                if (z) {
                    this.j.a("click_jump_error", dVar, this.d);
                    return;
                }
                ArrayList arrayList = new ArrayList();
                arrayList.add(dVar);
                String a2 = d.a((List<d>) arrayList);
                if (!ak.b(a2)) {
                    return;
                }
                if (k.a().c()) {
                    k.a().a(a2);
                } else {
                    new p(this.g, 0).a("click_jump_success", a2, (String) null, (Frame) null);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public final void a(Campaign campaign, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (campaign != null) {
                CampaignEx campaignEx = campaign instanceof CampaignEx ? (CampaignEx) campaign : null;
                if ((!str.startsWith("market://") && !str.startsWith("https://play.google.com/")) || ae.a.a(this.g, str, this.i) || campaignEx == null) {
                    return;
                }
                if (!TextUtils.isEmpty(campaignEx.getPackageName())) {
                    Context context = this.g;
                    ae.a.a(context, "market://details?id=" + campaignEx.getPackageName(), this.i);
                } else if (b() == 2) {
                    ae.a(this.g, campaignEx.getClickURL(), campaignEx, this.i);
                } else {
                    ae.a(this.g, campaignEx.getClickURL(), (BaseTrackingListener) this.i, campaignEx.getCurrentLRid());
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void a(JumpLoaderResult jumpLoaderResult, CampaignEx campaignEx, boolean z) {
        a(jumpLoaderResult, campaignEx, 1, z);
    }

    private void a(int i2, String str, CampaignEx campaignEx, NativeListener.NativeTrackingListener nativeTrackingListener) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            if (i2 == 2) {
                ae.a(this.g, str, campaignEx, nativeTrackingListener);
            } else {
                ae.a(this.g, str, (BaseTrackingListener) nativeTrackingListener, campaignEx.getCurrentLRid());
            }
        } catch (Throwable th) {
            aa.b("MBridge SDK M", th.getMessage(), th);
        }
    }

    private boolean a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, boolean z, int i2) {
        boolean z2 = false;
        if (z) {
            try {
                int parseInt = Integer.parseInt(campaignEx.getLandingType());
                if (parseInt == 1) {
                    ae.a(this.g, jumpLoaderResult.getUrl(), (BaseTrackingListener) this.i, campaignEx.getCurrentLRid());
                } else if (parseInt == 2) {
                    ae.a(this.g, jumpLoaderResult.getUrl(), campaignEx, this.i);
                } else if (campaignEx.getPackageName() != null) {
                    Context context = this.g;
                    if (!ae.a.a(context, "market://details?id=" + campaignEx.getPackageName(), this.i)) {
                        a(i2, jumpLoaderResult.getUrl(), campaignEx, this.i);
                    }
                } else {
                    a(i2, jumpLoaderResult.getUrl(), campaignEx, this.i);
                }
                z2 = true;
            } catch (Throwable th) {
                aa.b("MBridge SDK M", th.getMessage(), th);
            }
        }
        if (z2) {
            a(jumpLoaderResult, campaignEx, true);
            NativeListener.NativeTrackingListener nativeTrackingListener = this.i;
            if (nativeTrackingListener != null) {
                nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
            }
        } else {
            a(jumpLoaderResult, campaignEx, true);
            NativeListener.NativeTrackingListener nativeTrackingListener2 = this.i;
            if (nativeTrackingListener2 != null && z) {
                nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z2;
    }

    private boolean a(CampaignEx campaignEx, JumpLoaderResult jumpLoaderResult, boolean z) {
        boolean z2 = false;
        if (z) {
            try {
                ae.a(this.g, campaignEx.getClickURL(), (BaseTrackingListener) this.i, campaignEx.getCurrentLRid());
                z2 = true;
            } catch (Throwable th) {
                aa.b("MBridge SDK M", th.getMessage(), th);
            }
        }
        a(jumpLoaderResult, campaignEx, true);
        if (z2) {
            NativeListener.NativeTrackingListener nativeTrackingListener = this.i;
            if (nativeTrackingListener != null) {
                nativeTrackingListener.onFinishRedirection(campaignEx, jumpLoaderResult.getUrl());
            }
        } else {
            NativeListener.NativeTrackingListener nativeTrackingListener2 = this.i;
            if (nativeTrackingListener2 != null) {
                nativeTrackingListener2.onRedirectionFailed(campaignEx, jumpLoaderResult.getUrl());
            }
        }
        return z2;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00af, code lost:
        if (com.mbridge.msdk.foundation.tools.ae.a.a(r3, "market://details?id=" + r8.getPackageName(), r7.i) == false) goto L_0x00b1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(com.mbridge.msdk.foundation.entity.CampaignEx r8, com.mbridge.msdk.click.entity.JumpLoaderResult r9, boolean r10, boolean r11) {
        /*
            r7 = this;
            java.lang.String r0 = "market://details?id="
            boolean r1 = r7.n     // Catch:{ Exception -> 0x0151 }
            if (r1 != 0) goto L_0x0007
            return
        L_0x0007:
            r1 = 1
            if (r8 == 0) goto L_0x0143
            if (r9 != 0) goto L_0x000e
            goto L_0x0143
        L_0x000e:
            int r2 = r7.b()     // Catch:{ Exception -> 0x0151 }
            int r3 = r9.getCode()     // Catch:{ Exception -> 0x0151 }
            java.lang.String r4 = r9.getUrl()     // Catch:{ Exception -> 0x0151 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0151 }
            r5 = 2
            r6 = 3
            if (r4 == 0) goto L_0x0056
            if (r10 == 0) goto L_0x0056
            int r11 = r8.getLinkType()     // Catch:{ Exception -> 0x0151 }
            if (r11 != r5) goto L_0x0032
            int r11 = r7.b()     // Catch:{ Exception -> 0x0151 }
            r7.a((com.mbridge.msdk.foundation.entity.CampaignEx) r8, (com.mbridge.msdk.click.entity.JumpLoaderResult) r9, (boolean) r10, (int) r11)     // Catch:{ Exception -> 0x0151 }
            return
        L_0x0032:
            if (r11 != r6) goto L_0x0038
            r7.a((com.mbridge.msdk.foundation.entity.CampaignEx) r8, (com.mbridge.msdk.click.entity.JumpLoaderResult) r9, (boolean) r10)     // Catch:{ Exception -> 0x0151 }
            return
        L_0x0038:
            android.content.Context r10 = r7.g     // Catch:{ Exception -> 0x0151 }
            java.lang.String r11 = r8.getClickURL()     // Catch:{ Exception -> 0x0151 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r7.i     // Catch:{ Exception -> 0x0151 }
            java.lang.String r2 = r8.getCurrentLRid()     // Catch:{ Exception -> 0x0151 }
            com.mbridge.msdk.foundation.tools.ae.a((android.content.Context) r10, (java.lang.String) r11, (com.mbridge.msdk.out.BaseTrackingListener) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x0151 }
            r7.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r9, (com.mbridge.msdk.foundation.entity.CampaignEx) r8, (boolean) r1)     // Catch:{ Exception -> 0x0151 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r10 = r7.i     // Catch:{ Exception -> 0x0151 }
            if (r10 == 0) goto L_0x0055
            java.lang.String r9 = r9.getUrl()     // Catch:{ Exception -> 0x0151 }
            r10.onFinishRedirection(r8, r9)     // Catch:{ Exception -> 0x0151 }
        L_0x0055:
            return
        L_0x0056:
            if (r3 != r1) goto L_0x00c8
            java.lang.String r3 = r8.getPackageName()     // Catch:{ Exception -> 0x0151 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0151 }
            if (r3 != 0) goto L_0x008b
            java.lang.String r3 = r9.getUrl()     // Catch:{ Exception -> 0x0151 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0151 }
            if (r3 != 0) goto L_0x008b
            java.lang.String r3 = r9.getUrl()     // Catch:{ Exception -> 0x0151 }
            java.lang.String r4 = r8.getPackageName()     // Catch:{ Exception -> 0x0151 }
            boolean r3 = r3.contains(r4)     // Catch:{ Exception -> 0x0151 }
            if (r3 == 0) goto L_0x008b
            if (r10 == 0) goto L_0x008b
            android.content.Context r0 = r7.g     // Catch:{ Exception -> 0x0151 }
            java.lang.String r3 = r9.getUrl()     // Catch:{ Exception -> 0x0151 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r7.i     // Catch:{ Exception -> 0x0151 }
            boolean r0 = com.mbridge.msdk.foundation.tools.ae.a.a(r0, r3, r4)     // Catch:{ Exception -> 0x0151 }
            if (r0 != 0) goto L_0x00ba
            goto L_0x00b1
        L_0x008b:
            if (r10 == 0) goto L_0x00ba
            java.lang.String r3 = r8.getPackageName()     // Catch:{ Exception -> 0x0151 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ Exception -> 0x0151 }
            if (r3 != 0) goto L_0x00b1
            android.content.Context r3 = r7.g     // Catch:{ Exception -> 0x0151 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0151 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r0 = r8.getPackageName()     // Catch:{ Exception -> 0x0151 }
            r4.append(r0)     // Catch:{ Exception -> 0x0151 }
            java.lang.String r0 = r4.toString()     // Catch:{ Exception -> 0x0151 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r4 = r7.i     // Catch:{ Exception -> 0x0151 }
            boolean r0 = com.mbridge.msdk.foundation.tools.ae.a.a(r3, r0, r4)     // Catch:{ Exception -> 0x0151 }
            if (r0 != 0) goto L_0x00ba
        L_0x00b1:
            java.lang.String r0 = r9.getUrl()     // Catch:{ Exception -> 0x0151 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r7.i     // Catch:{ Exception -> 0x0151 }
            r7.a((int) r2, (java.lang.String) r0, (com.mbridge.msdk.foundation.entity.CampaignEx) r8, (com.mbridge.msdk.out.NativeListener.NativeTrackingListener) r3)     // Catch:{ Exception -> 0x0151 }
        L_0x00ba:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r7.i     // Catch:{ Exception -> 0x0151 }
            if (r0 == 0) goto L_0x011d
            if (r10 == 0) goto L_0x011d
            java.lang.String r2 = r9.getUrl()     // Catch:{ Exception -> 0x0151 }
            r0.onFinishRedirection(r8, r2)     // Catch:{ Exception -> 0x0151 }
            goto L_0x011d
        L_0x00c8:
            if (r3 != r6) goto L_0x00e9
            if (r10 == 0) goto L_0x00db
            android.content.Context r0 = r7.g     // Catch:{ Exception -> 0x0151 }
            java.lang.String r2 = r9.getUrl()     // Catch:{ Exception -> 0x0151 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r7.i     // Catch:{ Exception -> 0x0151 }
            java.lang.String r4 = r8.getCurrentLRid()     // Catch:{ Exception -> 0x0151 }
            com.mbridge.msdk.foundation.tools.ae.a((android.content.Context) r0, (java.lang.String) r2, (com.mbridge.msdk.out.BaseTrackingListener) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x0151 }
        L_0x00db:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r7.i     // Catch:{ Exception -> 0x0151 }
            if (r0 == 0) goto L_0x011d
            if (r10 == 0) goto L_0x011d
            java.lang.String r2 = r9.getUrl()     // Catch:{ Exception -> 0x0151 }
            r0.onFinishRedirection(r8, r2)     // Catch:{ Exception -> 0x0151 }
            goto L_0x011d
        L_0x00e9:
            if (r10 == 0) goto L_0x011d
            int r0 = r8.getLinkType()     // Catch:{ Exception -> 0x0151 }
            if (r6 != r0) goto L_0x00f5
            r7.a((com.mbridge.msdk.foundation.entity.CampaignEx) r8, (com.mbridge.msdk.click.entity.JumpLoaderResult) r9, (boolean) r10)     // Catch:{ Exception -> 0x0151 }
            return
        L_0x00f5:
            int r0 = r8.getLinkType()     // Catch:{ Exception -> 0x0151 }
            if (r5 != r0) goto L_0x0103
            int r11 = r7.b()     // Catch:{ Exception -> 0x0151 }
            r7.a((com.mbridge.msdk.foundation.entity.CampaignEx) r8, (com.mbridge.msdk.click.entity.JumpLoaderResult) r9, (boolean) r10, (int) r11)     // Catch:{ Exception -> 0x0151 }
            return
        L_0x0103:
            android.content.Context r0 = r7.g     // Catch:{ Exception -> 0x0151 }
            java.lang.String r2 = r9.getUrl()     // Catch:{ Exception -> 0x0151 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r3 = r7.i     // Catch:{ Exception -> 0x0151 }
            java.lang.String r4 = r8.getCurrentLRid()     // Catch:{ Exception -> 0x0151 }
            com.mbridge.msdk.foundation.tools.ae.a((android.content.Context) r0, (java.lang.String) r2, (com.mbridge.msdk.out.BaseTrackingListener) r3, (java.lang.String) r4)     // Catch:{ Exception -> 0x0151 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r7.i     // Catch:{ Exception -> 0x0151 }
            if (r0 == 0) goto L_0x011d
            java.lang.String r2 = r9.getUrl()     // Catch:{ Exception -> 0x0151 }
            r0.onFinishRedirection(r8, r2)     // Catch:{ Exception -> 0x0151 }
        L_0x011d:
            int r0 = r8.getLinkType()     // Catch:{ Exception -> 0x0151 }
            java.lang.String r2 = r9.getUrl()     // Catch:{ Exception -> 0x0151 }
            boolean r0 = r7.a((int) r0, (java.lang.String) r2)     // Catch:{ Exception -> 0x0151 }
            if (r0 == 0) goto L_0x0130
            r0 = 0
            r7.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r9, (com.mbridge.msdk.foundation.entity.CampaignEx) r8, (boolean) r0)     // Catch:{ Exception -> 0x0151 }
            goto L_0x0133
        L_0x0130:
            r7.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r9, (com.mbridge.msdk.foundation.entity.CampaignEx) r8, (boolean) r1)     // Catch:{ Exception -> 0x0151 }
        L_0x0133:
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r0 = r7.i     // Catch:{ Exception -> 0x0151 }
            if (r0 == 0) goto L_0x0155
            if (r10 != 0) goto L_0x0155
            if (r11 == 0) goto L_0x0155
            java.lang.String r9 = r9.getUrl()     // Catch:{ Exception -> 0x0151 }
            r0.onFinishRedirection(r8, r9)     // Catch:{ Exception -> 0x0151 }
            goto L_0x0155
        L_0x0143:
            if (r10 == 0) goto L_0x0150
            r7.a((com.mbridge.msdk.click.entity.JumpLoaderResult) r9, (com.mbridge.msdk.foundation.entity.CampaignEx) r8, (boolean) r1)     // Catch:{ Exception -> 0x0151 }
            com.mbridge.msdk.out.NativeListener$NativeTrackingListener r8 = r7.i     // Catch:{ Exception -> 0x0151 }
            if (r8 == 0) goto L_0x0150
            r9 = 0
            r8.onRedirectionFailed(r9, r9)     // Catch:{ Exception -> 0x0151 }
        L_0x0150:
            return
        L_0x0151:
            r8 = move-exception
            r8.printStackTrace()
        L_0x0155:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(com.mbridge.msdk.foundation.entity.CampaignEx, com.mbridge.msdk.click.entity.JumpLoaderResult, boolean, boolean):void");
    }

    private int b() {
        try {
            e eVar = this.k;
            if (eVar != null) {
                return eVar.O();
            }
            return 1;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0010, code lost:
        if (android.text.TextUtils.isEmpty(r5) == false) goto L_0x0014;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(int r4, java.lang.String r5) {
        /*
            r3 = this;
            r0 = 2
            r1 = 1
            r2 = 0
            if (r4 != r0) goto L_0x000c
            boolean r4 = com.mbridge.msdk.foundation.tools.ae.a.a((java.lang.String) r5)     // Catch:{ Exception -> 0x0016 }
            if (r4 == 0) goto L_0x0013
            goto L_0x0014
        L_0x000c:
            boolean r4 = android.text.TextUtils.isEmpty(r5)     // Catch:{ Exception -> 0x0016 }
            if (r4 != 0) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r1 = 0
        L_0x0014:
            r2 = r1
            goto L_0x001a
        L_0x0016:
            r4 = move-exception
            r4.printStackTrace()
        L_0x001a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.click.a.a(int, java.lang.String):boolean");
    }

    static /* synthetic */ void a(a aVar, CampaignEx campaignEx) {
        try {
            Intent intent = new Intent(aVar.g, LoadingActivity.class);
            intent.setFlags(268435456);
            intent.putExtra(CampaignEx.JSON_KEY_ICON_URL, campaignEx.getIconUrl());
            aVar.g.startActivity(intent);
        } catch (Exception e2) {
            aa.b("MBridge SDK M", "Exception", e2);
        }
    }

    static /* synthetic */ void f(a aVar) {
        try {
            Intent intent = new Intent();
            intent.setAction("ExitApp");
            aVar.g.sendBroadcast(intent);
        } catch (Exception e2) {
            aa.b("MBridge SDK M", "Exception", e2);
        }
    }
}
