package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.videocommon.d.c;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: UnitCacheControllerRefactor */
public final class m {
    private com.mbridge.msdk.videocommon.listener.a a;
    private ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> b;
    private final Context c = b.d().g();
    private final String d;
    private c e;
    private final int f;
    private final CopyOnWriteArrayList<CampaignEx> g;
    private final ConcurrentHashMap<String, a> h = new ConcurrentHashMap<>();

    public m(List<CampaignEx> list, String str, int i) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.g = copyOnWriteArrayList;
        this.d = str;
        this.f = i;
        if (list != null) {
            copyOnWriteArrayList.addAll(list);
        }
    }

    public m(CampaignEx campaignEx, String str, int i) {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.g = copyOnWriteArrayList;
        this.d = str;
        this.f = i;
        if (campaignEx != null) {
            copyOnWriteArrayList.add(campaignEx);
        }
    }

    public final void a(com.mbridge.msdk.videocommon.listener.a aVar) {
        this.a = aVar;
    }

    public final void a(String str, com.mbridge.msdk.videocommon.listener.a aVar) {
        if (this.b == null) {
            this.b = new ConcurrentHashMap<>();
        }
        if (aVar != null && !TextUtils.isEmpty(str)) {
            this.b.put(str, aVar);
        }
    }

    public final void a(List<CampaignEx> list) {
        if (list != null) {
            try {
                this.g.addAll(list);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    aa.b("RewardVideoRefactorManager", this.d + " update error", e2);
                }
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                this.g.add(campaignEx);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    aa.b("RewardVideoRefactorManager", this.d + " update error", e2);
                }
            }
        }
    }

    public final void a() {
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = this.g;
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            aa.a("RewardVideoRefactorManager", this.d + " load campaignExes is null");
            return;
        }
        Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            CampaignEx next = it.next();
            if (!(next == null || next == null)) {
                try {
                    String str = next.getRequestId() + next.getId() + next.getVideoUrlEncode();
                    if (!this.h.containsKey(str)) {
                        a(next, str, (a) null);
                    }
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        aa.b("RewardVideoRefactorManager", this.d + " handlerCampaignLoadEvent error", e2);
                    }
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b3, code lost:
        if (r7.getRsIgnoreCheckRule().contains(0) != false) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00c1, code lost:
        if (r7.getVideoCheckType() == 1) goto L_0x0130;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x012c, code lost:
        if (com.mbridge.msdk.foundation.download.utils.Utils.getDownloadRate(r8.i(), r8.l()) >= r17) goto L_0x00f6;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01ae  */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x01c8 A[Catch:{ Exception -> 0x036e }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x01e4 A[Catch:{ Exception -> 0x036e }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x01f3 A[Catch:{ Exception -> 0x036e }] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01fa A[Catch:{ Exception -> 0x036e }] */
    /* JADX WARNING: Removed duplicated region for block: B:188:0x001d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00f8 A[Catch:{ Exception -> 0x01c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0133  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x013f A[Catch:{ Exception -> 0x01be }] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0160 A[Catch:{ Exception -> 0x01bc }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.mbridge.msdk.videocommon.download.a> a(java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r19, boolean r20) {
        /*
            r18 = this;
            r1 = r18
            java.lang.String r2 = "\n\t\t\tisIgnore = "
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            java.lang.String r4 = "RewardVideoRefactorManager"
            if (r19 == 0) goto L_0x038c
            int r0 = r19.size()
            if (r0 != 0) goto L_0x0015
            goto L_0x038c
        L_0x0015:
            int r5 = r19.size()
            java.util.Iterator r6 = r19.iterator()
        L_0x001d:
            boolean r0 = r6.hasNext()
            if (r0 == 0) goto L_0x038b
            java.lang.Object r0 = r6.next()
            r7 = r0
            com.mbridge.msdk.foundation.entity.CampaignEx r7 = (com.mbridge.msdk.foundation.entity.CampaignEx) r7
            if (r7 != 0) goto L_0x002d
            goto L_0x001d
        L_0x002d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x036e }
            r0.<init>()     // Catch:{ Exception -> 0x036e }
            java.lang.String r8 = r7.getRequestId()     // Catch:{ Exception -> 0x036e }
            r0.append(r8)     // Catch:{ Exception -> 0x036e }
            java.lang.String r8 = r7.getId()     // Catch:{ Exception -> 0x036e }
            r0.append(r8)     // Catch:{ Exception -> 0x036e }
            java.lang.String r8 = r7.getVideoUrlEncode()     // Catch:{ Exception -> 0x036e }
            r0.append(r8)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x036e }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, com.mbridge.msdk.videocommon.download.a> r8 = r1.h     // Catch:{ Exception -> 0x036e }
            java.lang.Object r8 = r8.get(r0)     // Catch:{ Exception -> 0x036e }
            com.mbridge.msdk.videocommon.download.a r8 = (com.mbridge.msdk.videocommon.download.a) r8     // Catch:{ Exception -> 0x036e }
            com.mbridge.msdk.videocommon.download.a r8 = r1.a((com.mbridge.msdk.foundation.entity.CampaignEx) r7, (java.lang.String) r0, (com.mbridge.msdk.videocommon.download.a) r8)     // Catch:{ Exception -> 0x036e }
            if (r7 == 0) goto L_0x001d
            if (r8 != 0) goto L_0x005c
            goto L_0x001d
        L_0x005c:
            r9 = 0
            r10 = 1
            int r0 = r7.getLoadTimeoutState()     // Catch:{ Exception -> 0x01c0 }
            boolean r11 = r8.d()     // Catch:{ Exception -> 0x01c0 }
            if (r11 != 0) goto L_0x0135
            int r11 = r1.f(r7)     // Catch:{ Exception -> 0x01c0 }
            int r12 = r18.f()     // Catch:{ Exception -> 0x01c0 }
            if (r8 == 0) goto L_0x012f
            if (r7 != 0) goto L_0x0076
            goto L_0x012f
        L_0x0076:
            boolean r13 = r8.d()     // Catch:{ Exception -> 0x01c0 }
            if (r13 == 0) goto L_0x007e
            goto L_0x0130
        L_0x007e:
            boolean r13 = r1.e(r7)     // Catch:{ Exception -> 0x01c0 }
            if (r13 == 0) goto L_0x0086
            goto L_0x0130
        L_0x0086:
            java.lang.String r13 = r8.e()     // Catch:{ Exception -> 0x01c0 }
            boolean r13 = android.text.TextUtils.isEmpty(r13)     // Catch:{ Exception -> 0x01c0 }
            if (r13 == 0) goto L_0x0092
            goto L_0x0130
        L_0x0092:
            r13 = 3
            if (r12 != r13) goto L_0x0097
            goto L_0x0130
        L_0x0097:
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x01c0 }
            if (r12 == 0) goto L_0x00b7
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x01be }
            int r12 = r12.size()     // Catch:{ Exception -> 0x01be }
            if (r12 <= 0) goto L_0x00b7
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x01be }
            java.lang.Integer r13 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x01be }
            boolean r12 = r12.contains(r13)     // Catch:{ Exception -> 0x01be }
            if (r12 == 0) goto L_0x00b7
            goto L_0x0130
        L_0x00b7:
            int r12 = r7.getIsTimeoutCheckVideoStatus()     // Catch:{ Exception -> 0x01c0 }
            if (r12 != r10) goto L_0x00c5
            int r12 = r7.getVideoCheckType()     // Catch:{ Exception -> 0x01be }
            if (r12 != r10) goto L_0x00c5
            goto L_0x0130
        L_0x00c5:
            long r12 = r8.l()     // Catch:{ Exception -> 0x01c0 }
            long r14 = r8.i()     // Catch:{ Exception -> 0x01c0 }
            if (r20 == 0) goto L_0x00f2
            int r9 = r7.getVideoCheckType()     // Catch:{ Exception -> 0x01c0 }
            if (r9 != r10) goto L_0x00f2
            if (r11 != 0) goto L_0x00d8
            goto L_0x0130
        L_0x00d8:
            r16 = 0
            int r9 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r9 != 0) goto L_0x00e2
            int r9 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r9 == 0) goto L_0x00f2
        L_0x00e2:
            int r9 = r11 / 100
            r17 = r11
            long r10 = (long) r9     // Catch:{ Exception -> 0x01c0 }
            long r10 = r10 * r14
            int r9 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r9 < 0) goto L_0x00f4
            r9 = 1
            r7.setIsTimeoutCheckVideoStatus(r9)     // Catch:{ Exception -> 0x01c0 }
            goto L_0x00f6
        L_0x00f2:
            r17 = r11
        L_0x00f4:
            if (r8 != 0) goto L_0x00f8
        L_0x00f6:
            r10 = 1
            goto L_0x0130
        L_0x00f8:
            java.lang.String r9 = r8.e()     // Catch:{ Exception -> 0x01c0 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x01c0 }
            if (r9 == 0) goto L_0x0103
            goto L_0x00f6
        L_0x0103:
            if (r17 != 0) goto L_0x011e
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r8.k()     // Catch:{ Exception -> 0x01c0 }
            if (r9 == 0) goto L_0x011b
            com.mbridge.msdk.foundation.entity.CampaignEx r9 = r8.k()     // Catch:{ Exception -> 0x01c0 }
            java.lang.String r9 = r9.getVideoUrlEncode()     // Catch:{ Exception -> 0x01c0 }
            boolean r9 = android.text.TextUtils.isEmpty(r9)     // Catch:{ Exception -> 0x01c0 }
            if (r9 != 0) goto L_0x011b
            r9 = 1
            goto L_0x011c
        L_0x011b:
            r9 = 0
        L_0x011c:
            r10 = r9
            goto L_0x0130
        L_0x011e:
            long r9 = r8.i()     // Catch:{ Exception -> 0x01c0 }
            long r11 = r8.l()     // Catch:{ Exception -> 0x01c0 }
            int r9 = com.mbridge.msdk.foundation.download.utils.Utils.getDownloadRate(r9, r11)     // Catch:{ Exception -> 0x01c0 }
            r10 = r17
            if (r9 < r10) goto L_0x012f
            goto L_0x00f6
        L_0x012f:
            r10 = 0
        L_0x0130:
            if (r10 == 0) goto L_0x0133
            goto L_0x0135
        L_0x0133:
            r9 = 0
            goto L_0x0136
        L_0x0135:
            r9 = 1
        L_0x0136:
            r8.d((boolean) r9)     // Catch:{ Exception -> 0x01be }
            boolean r10 = r8.b()     // Catch:{ Exception -> 0x01be }
            if (r10 != 0) goto L_0x0151
            if (r7 != 0) goto L_0x0144
            java.lang.String r10 = ""
            goto L_0x0148
        L_0x0144:
            java.lang.String r10 = r7.getendcard_url()     // Catch:{ Exception -> 0x01be }
        L_0x0148:
            boolean r10 = r1.a((java.lang.String) r10, (com.mbridge.msdk.foundation.entity.CampaignEx) r7, (com.mbridge.msdk.videocommon.download.a) r8)     // Catch:{ Exception -> 0x01be }
            if (r10 == 0) goto L_0x014f
            goto L_0x0151
        L_0x014f:
            r10 = 0
            goto L_0x0152
        L_0x0151:
            r10 = 1
        L_0x0152:
            if (r0 != 0) goto L_0x015a
            if (r10 == 0) goto L_0x015a
            r11 = 1
            r8.b((boolean) r11)     // Catch:{ Exception -> 0x01bc }
        L_0x015a:
            boolean r11 = r8.c()     // Catch:{ Exception -> 0x01bc }
            if (r11 != 0) goto L_0x01b0
            java.lang.String r11 = r1.b((com.mbridge.msdk.foundation.entity.CampaignEx) r7)     // Catch:{ Exception -> 0x01bc }
            boolean r12 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x01bc }
            if (r12 == 0) goto L_0x016b
            goto L_0x01aa
        L_0x016b:
            if (r8 == 0) goto L_0x0174
            boolean r12 = r8.c()     // Catch:{ Exception -> 0x01bc }
            if (r12 == 0) goto L_0x0174
            goto L_0x01aa
        L_0x0174:
            boolean r12 = r7.isDynamicView()     // Catch:{ Exception -> 0x01bc }
            if (r12 == 0) goto L_0x017b
            goto L_0x01aa
        L_0x017b:
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x01bc }
            if (r12 == 0) goto L_0x019b
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x01bc }
            int r12 = r12.size()     // Catch:{ Exception -> 0x01bc }
            if (r12 <= 0) goto L_0x019b
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x01bc }
            r13 = 1
            java.lang.Integer r14 = java.lang.Integer.valueOf(r13)     // Catch:{ Exception -> 0x01bc }
            boolean r12 = r12.contains(r14)     // Catch:{ Exception -> 0x01bc }
            if (r12 == 0) goto L_0x019b
            goto L_0x01aa
        L_0x019b:
            int r12 = r7.getLoadTimeoutState()     // Catch:{ Exception -> 0x01bc }
            if (r12 != 0) goto L_0x01aa
            java.lang.String r11 = com.mbridge.msdk.videocommon.download.j.a(r11)     // Catch:{ Exception -> 0x01bc }
            if (r11 == 0) goto L_0x01a8
            goto L_0x01aa
        L_0x01a8:
            r11 = 0
            goto L_0x01ab
        L_0x01aa:
            r11 = 1
        L_0x01ab:
            if (r11 == 0) goto L_0x01ae
            goto L_0x01b0
        L_0x01ae:
            r11 = 0
            goto L_0x01b1
        L_0x01b0:
            r11 = 1
        L_0x01b1:
            if (r0 != 0) goto L_0x01de
            if (r11 == 0) goto L_0x01de
            r12 = 1
            r8.c((boolean) r12)     // Catch:{ Exception -> 0x01ba }
            goto L_0x01de
        L_0x01ba:
            r0 = move-exception
            goto L_0x01c4
        L_0x01bc:
            r0 = move-exception
            goto L_0x01c3
        L_0x01be:
            r0 = move-exception
            goto L_0x01c2
        L_0x01c0:
            r0 = move-exception
            r9 = 0
        L_0x01c2:
            r10 = 0
        L_0x01c3:
            r11 = 0
        L_0x01c4:
            boolean r12 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x036e }
            if (r12 == 0) goto L_0x01de
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x036e }
            r12.<init>()     // Catch:{ Exception -> 0x036e }
            java.lang.String r13 = r1.d     // Catch:{ Exception -> 0x036e }
            r12.append(r13)     // Catch:{ Exception -> 0x036e }
            java.lang.String r13 = " checkResourceReadyState error"
            r12.append(r13)     // Catch:{ Exception -> 0x036e }
            java.lang.String r12 = r12.toString()     // Catch:{ Exception -> 0x036e }
            com.mbridge.msdk.foundation.tools.aa.b(r4, r12, r0)     // Catch:{ Exception -> 0x036e }
        L_0x01de:
            boolean r0 = r8.a()     // Catch:{ Exception -> 0x036e }
            if (r0 != 0) goto L_0x01ed
            if (r9 == 0) goto L_0x01eb
            if (r10 == 0) goto L_0x01eb
            if (r11 == 0) goto L_0x01eb
            goto L_0x01ed
        L_0x01eb:
            r0 = 0
            goto L_0x01ee
        L_0x01ed:
            r0 = 1
        L_0x01ee:
            r8.a((boolean) r0)     // Catch:{ Exception -> 0x036e }
            if (r0 == 0) goto L_0x01f6
            r3.add(r8)     // Catch:{ Exception -> 0x036e }
        L_0x01f6:
            boolean r12 = com.mbridge.msdk.MBridgeConstans.DEBUG     // Catch:{ Exception -> 0x036e }
            if (r12 == 0) goto L_0x001d
            java.util.ArrayList r12 = r7.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x036e }
            if (r12 != 0) goto L_0x0205
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ Exception -> 0x036e }
            r12.<init>()     // Catch:{ Exception -> 0x036e }
        L_0x0205:
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x036e }
            r13.<init>()     // Catch:{ Exception -> 0x036e }
            java.lang.String r14 = r1.d     // Catch:{ Exception -> 0x036e }
            r13.append(r14)     // Catch:{ Exception -> 0x036e }
            java.lang.String r14 = "  campaign name = "
            r13.append(r14)     // Catch:{ Exception -> 0x036e }
            java.lang.String r14 = r7.getAppName()     // Catch:{ Exception -> 0x036e }
            r13.append(r14)     // Catch:{ Exception -> 0x036e }
            java.lang.String r14 = "\n\t\tcampaign id = "
            r13.append(r14)     // Catch:{ Exception -> 0x036e }
            java.lang.String r14 = r7.getId()     // Catch:{ Exception -> 0x036e }
            r13.append(r14)     // Catch:{ Exception -> 0x036e }
            java.lang.String r14 = "\n\t\trequest id = "
            r13.append(r14)     // Catch:{ Exception -> 0x036e }
            java.lang.String r14 = r7.getRequestId()     // Catch:{ Exception -> 0x036e }
            r13.append(r14)     // Catch:{ Exception -> 0x036e }
            java.lang.String r14 = "\n\t\tadType = "
            r13.append(r14)     // Catch:{ Exception -> 0x036e }
            int r14 = r1.f     // Catch:{ Exception -> 0x036e }
            r13.append(r14)     // Catch:{ Exception -> 0x036e }
            java.lang.String r14 = "\n\t\tunitID = "
            r13.append(r14)     // Catch:{ Exception -> 0x036e }
            java.lang.String r14 = r1.d     // Catch:{ Exception -> 0x036e }
            r13.append(r14)     // Catch:{ Exception -> 0x036e }
            java.lang.String r14 = "\n\t\tisReady = "
            r13.append(r14)     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\tisDynamicView = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            boolean r0 = r7.isDynamicView()     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\tisTPL = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = r7.getCMPTEntryUrl()     // Catch:{ Exception -> 0x036e }
            boolean r0 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x036e }
            if (r0 != 0) goto L_0x026c
            r0 = 1
            goto L_0x026d
        L_0x026c:
            r0 = 0
        L_0x026d:
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\tcurrentSuccessSize = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            int r0 = r3.size()     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\tisReadyCheckSize = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            r13.append(r5)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\ttotalCampaignSize = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx> r0 = r1.g     // Catch:{ Exception -> 0x036e }
            int r0 = r0.size()     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\tlinkType = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            int r0 = r7.getLinkType()     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\tloadTimeoutState = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            int r0 = r7.getLoadTimeoutState()     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\tisVideoReady = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            r13.append(r9)     // Catch:{ Exception -> 0x036e }
            r13.append(r2)     // Catch:{ Exception -> 0x036e }
            r9 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x036e }
            boolean r0 = r12.contains(r0)     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\t\treadyRate == "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            int r0 = r1.f(r7)     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\t\tCDRate = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            int r0 = r18.e()     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\t\tdlnet = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            int r0 = r18.f()     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\t\tctn = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            int r0 = r1.d(r7)     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\t\tdownloadState = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            int r0 = r8.j()     // Catch:{ Exception -> 0x036e }
            r8 = 2
            if (r0 == 0) goto L_0x0317
            r9 = 1
            if (r0 == r9) goto L_0x0314
            if (r0 == r8) goto L_0x0311
            r9 = 4
            if (r0 == r9) goto L_0x030e
            r9 = 5
            if (r0 == r9) goto L_0x030b
            java.lang.String r0 = "Unknown"
            goto L_0x0319
        L_0x030b:
            java.lang.String r0 = "DOWNLOAD_DONE"
            goto L_0x0319
        L_0x030e:
            java.lang.String r0 = "DOWNLOAD_STOP"
            goto L_0x0319
        L_0x0311:
            java.lang.String r0 = "DOWNLOAD_PAUSE"
            goto L_0x0319
        L_0x0314:
            java.lang.String r0 = "DOWNLOAD_RUN"
            goto L_0x0319
        L_0x0317:
            java.lang.String r0 = "DOWNLOAD_READY"
        L_0x0319:
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\tisTemplateReady = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            r13.append(r11)     // Catch:{ Exception -> 0x036e }
            r13.append(r2)     // Catch:{ Exception -> 0x036e }
            r9 = 1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x036e }
            boolean r0 = r12.contains(r0)     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\tisEndCardReady = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            r13.append(r10)     // Catch:{ Exception -> 0x036e }
            r13.append(r2)     // Catch:{ Exception -> 0x036e }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x036e }
            boolean r0 = r12.contains(r0)     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\t\tisOnlyPlayable = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            boolean r0 = r1.e(r7)     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = "\n\t\t\tisPlayableEndCard(dynamicView) = "
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = r7.getendcard_url()     // Catch:{ Exception -> 0x036e }
            boolean r0 = com.mbridge.msdk.foundation.tools.af.j((java.lang.String) r0)     // Catch:{ Exception -> 0x036e }
            r13.append(r0)     // Catch:{ Exception -> 0x036e }
            java.lang.String r0 = r13.toString()     // Catch:{ Exception -> 0x036e }
            com.mbridge.msdk.foundation.tools.aa.d(r4, r0)     // Catch:{ Exception -> 0x036e }
            goto L_0x001d
        L_0x036e:
            r0 = move-exception
            boolean r7 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r7 == 0) goto L_0x001d
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = r1.d
            r7.append(r8)
            java.lang.String r8 = " isReady error"
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            com.mbridge.msdk.foundation.tools.aa.b(r4, r7, r0)
            goto L_0x001d
        L_0x038b:
            return r3
        L_0x038c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = r1.d
            r0.append(r2)
            java.lang.String r2 = " isReady campaignExes is null"
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.mbridge.msdk.foundation.tools.aa.a((java.lang.String) r4, (java.lang.String) r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.m.a(java.util.List, boolean):java.util.List");
    }

    private a a(CampaignEx campaignEx, String str, a aVar) {
        if (aVar != null) {
            return aVar;
        }
        a c2 = c(campaignEx);
        c2.m();
        this.h.put(str, c2);
        return c2;
    }

    private String b(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return "";
        }
        try {
            CampaignEx.c rewardTemplateMode = campaignEx.getRewardTemplateMode();
            if (rewardTemplateMode != null) {
                return rewardTemplateMode.e();
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                aa.b("RewardVideoRefactorManager", this.d + " getVideoTemplateUrl error", e2);
            }
        }
        return "";
    }

    public final a b() {
        List<a> list;
        if (this.g.size() == 0) {
            aa.a("RewardVideoRefactorManager", this.d + " isReady campaignExes is null");
            return null;
        }
        try {
            list = a((List<CampaignEx>) this.g, false);
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                aa.b("RewardVideoRefactorManager", this.d + " isReady error", e2);
            }
            list = null;
        }
        if (list == null || list.size() <= 0) {
            return null;
        }
        return list.get(0);
    }

    private a c(CampaignEx campaignEx) {
        a aVar = null;
        try {
            a aVar2 = new a(this.c, campaignEx, this.d, f());
            try {
                aVar2.a(campaignEx);
                aVar2.d(this.f);
                aVar2.c(f(campaignEx));
                aVar2.b(e());
                aVar2.e(d(campaignEx));
                aVar2.a((d) null);
                aVar2.a((com.mbridge.msdk.videocommon.listener.a) new a(this.d, this.b, this.a));
                return aVar2;
            } catch (Exception e2) {
                e = e2;
                aVar = aVar2;
            }
        } catch (Exception e3) {
            e = e3;
            if (MBridgeConstans.DEBUG) {
                aa.a("RewardVideoRefactorManager", this.d + " createAndStartCampaignDownloadTask error " + e.getMessage());
            }
            return aVar;
        }
    }

    private c c(String str) {
        try {
            if (this.e == null) {
                this.e = com.mbridge.msdk.videocommon.d.b.a().a(b.d().h(), str, this.f == 287);
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                aa.a("RewardVideoRefactorManager", this.d + " getRewardUnitSetting error " + e2.getMessage());
            }
        }
        return this.e;
    }

    private int d(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return 1;
        }
        try {
            return campaignEx.getVideoCtnType();
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return 1;
            }
            aa.a("RewardVideoRefactorManager", this.d + " getVideoCtnType error " + e2.getMessage());
            return 1;
        }
    }

    private boolean a(String str, CampaignEx campaignEx, a aVar) {
        boolean z;
        if (!(campaignEx == null || aVar == null)) {
            try {
                if (aVar.b()) {
                    aa.a("RewardVideoRefactorManager", this.d + " checkEndCardZipOrSourceDownLoad endCard download success");
                    return true;
                } else if (campaignEx.getRsIgnoreCheckRule() != null && campaignEx.getRsIgnoreCheckRule().size() > 0 && campaignEx.getRsIgnoreCheckRule().contains(2)) {
                    return true;
                } else {
                    if ((campaignEx.isDynamicView() && !af.j(str)) || ak.a(str)) {
                        return true;
                    }
                    if (campaignEx == null) {
                        z = false;
                    } else {
                        if (!campaignEx.isMraid()) {
                            if (!TextUtils.isEmpty(str)) {
                                if (campaignEx.getLoadTimeoutState() != 1 || e(campaignEx)) {
                                    if (campaignEx.getRsIgnoreCheckRule() == null || campaignEx.getRsIgnoreCheckRule().size() <= 0 || !campaignEx.getRsIgnoreCheckRule().contains(2)) {
                                        if (!ak.b(j.a(str))) {
                                            z = ak.b(j.b(str));
                                        }
                                    }
                                }
                            }
                        }
                        z = true;
                    }
                    if (z) {
                        return true;
                    }
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    aa.a("RewardVideoRefactorManager", this.d + " checkEndCardDownload error " + th.getMessage());
                }
            }
        }
        return false;
    }

    public final a c() {
        try {
            return b();
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            aa.d("RewardVideoRefactorManager", this.d + " getCampaignDownLoadTask error:" + th.getMessage());
            return null;
        }
    }

    public final a a(String str) {
        if (!TextUtils.isEmpty(str) && this.h.containsKey(str)) {
            return this.h.get(str);
        }
        return null;
    }

    public final CopyOnWriteArrayList<Map<String, a>> d() {
        try {
            CopyOnWriteArrayList<Map<String, a>> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            copyOnWriteArrayList.add(this.h);
            return copyOnWriteArrayList;
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            aa.d("RewardVideoRefactorManager", this.d + " getCampaignDownLoadTaskList error:" + e2.getMessage());
            return null;
        }
    }

    private boolean e(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return false;
        }
        try {
            if (campaignEx.getPlayable_ads_without_video() == 2) {
                return true;
            }
            return false;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            aa.a("RewardVideoRefactorManager", this.d + " isPlayerAbleAds error:" + th.getMessage());
            return false;
        }
    }

    public final void b(String str) {
        a remove;
        CampaignEx k;
        if (!TextUtils.isEmpty(str)) {
            try {
                if (this.h.containsKey(str) && (remove = this.h.remove(str)) != null && (k = remove.k()) != null) {
                    this.g.remove(k);
                    if (MBridgeConstans.DEBUG) {
                        aa.a("RewardVideoRefactorManager", this.d + " removeCampaignDownloadTask campaign name: " + k.getAppName());
                    }
                }
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    aa.d("RewardVideoRefactorManager", this.d + " removeCampaignDownloadTask error:" + e2.getMessage());
                }
            }
        }
    }

    private int f(CampaignEx campaignEx) {
        if (campaignEx == null) {
            return -1;
        }
        if (campaignEx.getReady_rate() != -1) {
            return campaignEx.getReady_rate();
        }
        return g();
    }

    private int g() {
        try {
            return c(this.d).r();
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return 100;
            }
            aa.a("RewardVideoRefactorManager", this.d + " getRewardReadyRate error:" + th.getMessage());
            return 100;
        }
    }

    /* compiled from: UnitCacheControllerRefactor */
    private static final class a implements com.mbridge.msdk.videocommon.listener.a {
        private final String a;
        private final ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> b;
        private final com.mbridge.msdk.videocommon.listener.a c;

        public a(String str, ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap, com.mbridge.msdk.videocommon.listener.a aVar) {
            this.a = str;
            this.b = concurrentHashMap;
            this.c = aVar;
        }

        public final void a(String str) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.c;
            if (aVar != null) {
                try {
                    aVar.a(str);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("RewardVideoRefactorManager", this.a + " videoDownloadListener onDownLoadDone error: " + e.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.b;
            if (concurrentHashMap != null) {
                for (com.mbridge.msdk.videocommon.listener.a a2 : concurrentHashMap.values()) {
                    try {
                        a2.a(str);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("RewardVideoRefactorManager", this.a + " videoDownloadListener onDownLoadDone error: " + e2.getMessage());
                        }
                    }
                }
            }
        }

        public final void a(String str, String str2) {
            com.mbridge.msdk.videocommon.listener.a aVar = this.c;
            if (aVar != null) {
                try {
                    aVar.a(str, str2);
                } catch (Exception e) {
                    if (MBridgeConstans.DEBUG) {
                        aa.d("RewardVideoRefactorManager", this.a + " videoDownloadListener onDownLoadFailed error: " + e.getMessage());
                    }
                }
            }
            ConcurrentHashMap<String, com.mbridge.msdk.videocommon.listener.a> concurrentHashMap = this.b;
            if (concurrentHashMap != null) {
                for (com.mbridge.msdk.videocommon.listener.a a2 : concurrentHashMap.values()) {
                    try {
                        a2.a(str, str2);
                    } catch (Exception e2) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("RewardVideoRefactorManager", this.a + " videoDownloadListener onDownLoadFailed error: " + e2.getMessage());
                        }
                    }
                }
            }
        }
    }

    private int e() {
        c c2 = c(this.d);
        if (c2 == null) {
            return 0;
        }
        try {
            return c2.s();
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return 0;
            }
            aa.a("RewardVideoRefactorManager", this.d + " getCDRate error " + e2.getMessage());
            return 0;
        }
    }

    private int f() {
        if (TextUtils.isEmpty(this.d)) {
            return 1;
        }
        try {
            c c2 = c(this.d);
            if (c2 != null) {
                return c2.w();
            }
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                aa.a("RewardVideoRefactorManager", this.d + " getDlnet error " + e2.getMessage());
            }
        }
        return 1;
    }
}
