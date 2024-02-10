package com.mbridge.msdk.videocommon.download;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.videocommon.d.b;
import com.mbridge.msdk.videocommon.listener.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: DownLoadManager */
public class c {
    private static volatile c a;
    private ThreadPoolExecutor b;
    private boolean c = false;
    private ConcurrentHashMap<String, n> d = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, CopyOnWriteArrayList<Map<String, a>>> e;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> f;
    private ConcurrentHashMap<String, CopyOnWriteArrayList<a>> g;

    private c() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 15, 15, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadPoolExecutor.DiscardPolicy());
        this.b = threadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    public static c getInstance() {
        if (a == null) {
            synchronized (c.class) {
                if (a == null) {
                    a = new c();
                }
            }
        }
        return a;
    }

    public final a a(String str, String str2) {
        n c2 = c(str);
        if (c2 != null) {
            return c2.a(str2);
        }
        return null;
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<CampaignEx>> concurrentHashMap = this.f;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.f.get(str);
    }

    public final CopyOnWriteArrayList<a> b(String str) {
        ConcurrentHashMap<String, CopyOnWriteArrayList<a>> concurrentHashMap = this.g;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.g.get(str);
    }

    public final n c(String str) {
        ConcurrentHashMap<String, n> concurrentHashMap = this.d;
        if (concurrentHashMap == null || !concurrentHashMap.containsKey(str)) {
            return null;
        }
        return this.d.get(str);
    }

    public final boolean a(int i, String str, boolean z) {
        try {
            n c2 = c(str);
            if (c2 == null || c2.a(i, z) == null) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public final boolean a(int i, String str, boolean z, int i2, boolean z2, int i3, List<CampaignEx> list) {
        return a(i, str, z, i2, z2, i3, list, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0127, code lost:
        if (r5.size() >= r18) goto L_0x018b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x0189, code lost:
        if (r4.size() > 0) goto L_0x018b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0243  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean a(int r15, java.lang.String r16, boolean r17, int r18, boolean r19, int r20, java.util.List<com.mbridge.msdk.foundation.entity.CampaignEx> r21, boolean r22) {
        /*
            r14 = this;
            r1 = r14
            r0 = r16
            r8 = r21
            r9 = 0
            if (r8 == 0) goto L_0x0246
            int r2 = r21.size()     // Catch:{ Exception -> 0x023e }
            if (r2 != 0) goto L_0x0010
            goto L_0x0246
        L_0x0010:
            com.mbridge.msdk.videocommon.download.n r2 = r14.c(r0)     // Catch:{ Exception -> 0x023e }
            if (r2 == 0) goto L_0x0246
            r3 = r16
            r4 = r15
            r5 = r17
            r6 = r21
            r7 = r22
            java.util.List r2 = r2.a(r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x023e }
            if (r2 == 0) goto L_0x018c
            int r3 = r2.size()     // Catch:{ Exception -> 0x023e }
            if (r3 != 0) goto L_0x002d
            goto L_0x018c
        L_0x002d:
            r3 = 1
            if (r19 == 0) goto L_0x012e
            int r4 = r21.size()     // Catch:{ Exception -> 0x023e }
            if (r4 <= 0) goto L_0x0065
            java.lang.Object r4 = r8.get(r9)     // Catch:{ Exception -> 0x023e }
            com.mbridge.msdk.foundation.entity.CampaignEx r4 = (com.mbridge.msdk.foundation.entity.CampaignEx) r4     // Catch:{ Exception -> 0x023e }
            if (r4 == 0) goto L_0x0065
            java.util.ArrayList r5 = r4.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x023e }
            if (r5 == 0) goto L_0x0065
            java.util.ArrayList r5 = r4.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x023e }
            int r5 = r5.size()     // Catch:{ Exception -> 0x023e }
            if (r5 <= 0) goto L_0x0065
            java.util.ArrayList r4 = r4.getRsIgnoreCheckRule()     // Catch:{ Exception -> 0x023e }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r9)     // Catch:{ Exception -> 0x023e }
            boolean r4 = r4.contains(r5)     // Catch:{ Exception -> 0x023e }
            if (r4 == 0) goto L_0x0065
            java.lang.String r4 = "DownLoadManager"
            java.lang.String r5 = "Is not check video download status with TPL"
            com.mbridge.msdk.foundation.tools.aa.b(r4, r5)     // Catch:{ Exception -> 0x023e }
            r4 = 1
            goto L_0x0066
        L_0x0065:
            r4 = 0
        L_0x0066:
            if (r20 != 0) goto L_0x00ca
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x012a }
            r5.<init>()     // Catch:{ Exception -> 0x012a }
            java.util.Iterator r6 = r2.iterator()     // Catch:{ Exception -> 0x012a }
        L_0x0071:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x012a }
            if (r7 == 0) goto L_0x00bf
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x012a }
            com.mbridge.msdk.videocommon.download.a r7 = (com.mbridge.msdk.videocommon.download.a) r7     // Catch:{ Exception -> 0x012a }
            java.util.Iterator r9 = r21.iterator()     // Catch:{ Exception -> 0x012a }
        L_0x0081:
            boolean r10 = r9.hasNext()     // Catch:{ Exception -> 0x012a }
            if (r10 == 0) goto L_0x0071
            java.lang.Object r10 = r9.next()     // Catch:{ Exception -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10     // Catch:{ Exception -> 0x012a }
            if (r7 == 0) goto L_0x0081
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r7.k()     // Catch:{ Exception -> 0x012a }
            if (r11 == 0) goto L_0x0081
            if (r10 == 0) goto L_0x0081
            java.lang.String r11 = r10.getId()     // Catch:{ Exception -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r7.k()     // Catch:{ Exception -> 0x012a }
            java.lang.String r12 = r12.getId()     // Catch:{ Exception -> 0x012a }
            boolean r11 = r11.equals(r12)     // Catch:{ Exception -> 0x012a }
            if (r11 == 0) goto L_0x0081
            java.lang.String r10 = r10.getRequestId()     // Catch:{ Exception -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r7.k()     // Catch:{ Exception -> 0x012a }
            java.lang.String r11 = r11.getRequestId()     // Catch:{ Exception -> 0x012a }
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x012a }
            if (r10 == 0) goto L_0x0081
            r5.add(r7)     // Catch:{ Exception -> 0x012a }
            goto L_0x0081
        L_0x00bf:
            int r5 = r5.size()     // Catch:{ Exception -> 0x012a }
            if (r5 <= 0) goto L_0x00c7
            goto L_0x018b
        L_0x00c7:
            r9 = r4
            goto L_0x018c
        L_0x00ca:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ Exception -> 0x012a }
            r5.<init>()     // Catch:{ Exception -> 0x012a }
            java.util.Iterator r6 = r2.iterator()     // Catch:{ Exception -> 0x012a }
        L_0x00d3:
            boolean r7 = r6.hasNext()     // Catch:{ Exception -> 0x012a }
            if (r7 == 0) goto L_0x0121
            java.lang.Object r7 = r6.next()     // Catch:{ Exception -> 0x012a }
            com.mbridge.msdk.videocommon.download.a r7 = (com.mbridge.msdk.videocommon.download.a) r7     // Catch:{ Exception -> 0x012a }
            java.util.Iterator r10 = r21.iterator()     // Catch:{ Exception -> 0x012a }
        L_0x00e3:
            boolean r11 = r10.hasNext()     // Catch:{ Exception -> 0x012a }
            if (r11 == 0) goto L_0x00d3
            java.lang.Object r11 = r10.next()     // Catch:{ Exception -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = (com.mbridge.msdk.foundation.entity.CampaignEx) r11     // Catch:{ Exception -> 0x012a }
            if (r7 == 0) goto L_0x00e3
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r7.k()     // Catch:{ Exception -> 0x012a }
            if (r12 == 0) goto L_0x00e3
            if (r11 == 0) goto L_0x00e3
            java.lang.String r12 = r11.getId()     // Catch:{ Exception -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r13 = r7.k()     // Catch:{ Exception -> 0x012a }
            java.lang.String r13 = r13.getId()     // Catch:{ Exception -> 0x012a }
            boolean r12 = r12.equals(r13)     // Catch:{ Exception -> 0x012a }
            if (r12 == 0) goto L_0x00e3
            java.lang.String r11 = r11.getRequestId()     // Catch:{ Exception -> 0x012a }
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r7.k()     // Catch:{ Exception -> 0x012a }
            java.lang.String r12 = r12.getRequestId()     // Catch:{ Exception -> 0x012a }
            boolean r11 = r11.equals(r12)     // Catch:{ Exception -> 0x012a }
            if (r11 == 0) goto L_0x00e3
            r5.add(r7)     // Catch:{ Exception -> 0x012a }
            goto L_0x00e3
        L_0x0121:
            int r4 = r5.size()     // Catch:{ Exception -> 0x012a }
            r5 = r18
            if (r4 < r5) goto L_0x018c
            goto L_0x018b
        L_0x012a:
            r0 = move-exception
            r9 = r4
            goto L_0x023f
        L_0x012e:
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ Exception -> 0x023e }
            r4.<init>()     // Catch:{ Exception -> 0x023e }
            java.util.Iterator r5 = r2.iterator()     // Catch:{ Exception -> 0x023e }
        L_0x0137:
            boolean r6 = r5.hasNext()     // Catch:{ Exception -> 0x023e }
            if (r6 == 0) goto L_0x0185
            java.lang.Object r6 = r5.next()     // Catch:{ Exception -> 0x023e }
            com.mbridge.msdk.videocommon.download.a r6 = (com.mbridge.msdk.videocommon.download.a) r6     // Catch:{ Exception -> 0x023e }
            java.util.Iterator r7 = r21.iterator()     // Catch:{ Exception -> 0x023e }
        L_0x0147:
            boolean r10 = r7.hasNext()     // Catch:{ Exception -> 0x023e }
            if (r10 == 0) goto L_0x0137
            java.lang.Object r10 = r7.next()     // Catch:{ Exception -> 0x023e }
            com.mbridge.msdk.foundation.entity.CampaignEx r10 = (com.mbridge.msdk.foundation.entity.CampaignEx) r10     // Catch:{ Exception -> 0x023e }
            if (r6 == 0) goto L_0x0147
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r6.k()     // Catch:{ Exception -> 0x023e }
            if (r11 == 0) goto L_0x0147
            if (r10 == 0) goto L_0x0147
            java.lang.String r11 = r10.getId()     // Catch:{ Exception -> 0x023e }
            com.mbridge.msdk.foundation.entity.CampaignEx r12 = r6.k()     // Catch:{ Exception -> 0x023e }
            java.lang.String r12 = r12.getId()     // Catch:{ Exception -> 0x023e }
            boolean r11 = r11.equals(r12)     // Catch:{ Exception -> 0x023e }
            if (r11 == 0) goto L_0x0147
            java.lang.String r10 = r10.getRequestId()     // Catch:{ Exception -> 0x023e }
            com.mbridge.msdk.foundation.entity.CampaignEx r11 = r6.k()     // Catch:{ Exception -> 0x023e }
            java.lang.String r11 = r11.getRequestId()     // Catch:{ Exception -> 0x023e }
            boolean r10 = r10.equals(r11)     // Catch:{ Exception -> 0x023e }
            if (r10 == 0) goto L_0x0147
            r4.add(r6)     // Catch:{ Exception -> 0x023e }
            goto L_0x0147
        L_0x0185:
            int r4 = r4.size()     // Catch:{ Exception -> 0x023e }
            if (r4 <= 0) goto L_0x018c
        L_0x018b:
            r9 = 1
        L_0x018c:
            if (r9 == 0) goto L_0x0246
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>>> r3 = r1.e     // Catch:{ Exception -> 0x023e }
            if (r3 != 0) goto L_0x019a
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x023e }
            r3.<init>()     // Catch:{ Exception -> 0x023e }
            r1.e = r3     // Catch:{ Exception -> 0x023e }
            goto L_0x01a5
        L_0x019a:
            boolean r3 = r3.containsKey(r0)     // Catch:{ Exception -> 0x023e }
            if (r3 == 0) goto L_0x01a5
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>>> r3 = r1.e     // Catch:{ Exception -> 0x023e }
            r3.remove(r0)     // Catch:{ Exception -> 0x023e }
        L_0x01a5:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.a>> r3 = r1.g     // Catch:{ Exception -> 0x023e }
            if (r3 != 0) goto L_0x01b1
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x023e }
            r3.<init>()     // Catch:{ Exception -> 0x023e }
            r1.g = r3     // Catch:{ Exception -> 0x023e }
            goto L_0x01bc
        L_0x01b1:
            boolean r3 = r3.containsKey(r0)     // Catch:{ Exception -> 0x023e }
            if (r3 == 0) goto L_0x01bc
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.a>> r3 = r1.g     // Catch:{ Exception -> 0x023e }
            r3.remove(r0)     // Catch:{ Exception -> 0x023e }
        L_0x01bc:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>> r3 = r1.f     // Catch:{ Exception -> 0x023e }
            if (r3 != 0) goto L_0x01c8
            java.util.concurrent.ConcurrentHashMap r3 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x023e }
            r3.<init>()     // Catch:{ Exception -> 0x023e }
            r1.f = r3     // Catch:{ Exception -> 0x023e }
            goto L_0x01d3
        L_0x01c8:
            boolean r3 = r3.containsKey(r0)     // Catch:{ Exception -> 0x023e }
            if (r3 == 0) goto L_0x01d3
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>> r3 = r1.f     // Catch:{ Exception -> 0x023e }
            r3.remove(r0)     // Catch:{ Exception -> 0x023e }
        L_0x01d3:
            if (r2 == 0) goto L_0x0246
            int r3 = r2.size()     // Catch:{ Exception -> 0x023e }
            if (r3 <= 0) goto L_0x0246
            java.util.concurrent.CopyOnWriteArrayList r3 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x023e }
            r3.<init>()     // Catch:{ Exception -> 0x023e }
            java.util.concurrent.CopyOnWriteArrayList r4 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x023e }
            r4.<init>()     // Catch:{ Exception -> 0x023e }
            java.util.concurrent.CopyOnWriteArrayList r5 = new java.util.concurrent.CopyOnWriteArrayList     // Catch:{ Exception -> 0x023e }
            r5.<init>()     // Catch:{ Exception -> 0x023e }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ Exception -> 0x023e }
        L_0x01ee:
            boolean r6 = r2.hasNext()     // Catch:{ Exception -> 0x023e }
            if (r6 == 0) goto L_0x022e
            java.lang.Object r6 = r2.next()     // Catch:{ Exception -> 0x023e }
            com.mbridge.msdk.videocommon.download.a r6 = (com.mbridge.msdk.videocommon.download.a) r6     // Catch:{ Exception -> 0x023e }
            java.util.concurrent.ConcurrentHashMap r7 = new java.util.concurrent.ConcurrentHashMap     // Catch:{ Exception -> 0x023e }
            r7.<init>()     // Catch:{ Exception -> 0x023e }
            com.mbridge.msdk.foundation.entity.CampaignEx r8 = r6.k()     // Catch:{ Exception -> 0x023e }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x023e }
            r10.<init>()     // Catch:{ Exception -> 0x023e }
            java.lang.String r11 = r8.getId()     // Catch:{ Exception -> 0x023e }
            r10.append(r11)     // Catch:{ Exception -> 0x023e }
            java.lang.String r11 = r8.getVideoUrlEncode()     // Catch:{ Exception -> 0x023e }
            r10.append(r11)     // Catch:{ Exception -> 0x023e }
            java.lang.String r11 = r8.getBidToken()     // Catch:{ Exception -> 0x023e }
            r10.append(r11)     // Catch:{ Exception -> 0x023e }
            java.lang.String r10 = r10.toString()     // Catch:{ Exception -> 0x023e }
            r7.put(r10, r6)     // Catch:{ Exception -> 0x023e }
            r3.add(r7)     // Catch:{ Exception -> 0x023e }
            r4.add(r8)     // Catch:{ Exception -> 0x023e }
            r5.add(r6)     // Catch:{ Exception -> 0x023e }
            goto L_0x01ee
        L_0x022e:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<java.util.Map<java.lang.String, com.mbridge.msdk.videocommon.download.a>>> r2 = r1.e     // Catch:{ Exception -> 0x023e }
            r2.put(r0, r3)     // Catch:{ Exception -> 0x023e }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.entity.CampaignEx>> r2 = r1.f     // Catch:{ Exception -> 0x023e }
            r2.put(r0, r4)     // Catch:{ Exception -> 0x023e }
            java.util.concurrent.ConcurrentHashMap<java.lang.String, java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.videocommon.download.a>> r2 = r1.g     // Catch:{ Exception -> 0x023e }
            r2.put(r0, r5)     // Catch:{ Exception -> 0x023e }
            goto L_0x0246
        L_0x023e:
            r0 = move-exception
        L_0x023f:
            boolean r2 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r2 == 0) goto L_0x0246
            r0.printStackTrace()
        L_0x0246:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.videocommon.download.c.a(int, java.lang.String, boolean, int, boolean, int, java.util.List, boolean):boolean");
    }

    public void load(String str) {
        n c2 = c(str);
        if (c2 != null) {
            c2.a();
        }
    }

    public n createUnitCache(Context context, String str, CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList, int i, a aVar) {
        if (TextUtils.isEmpty(str) || copyOnWriteArrayList == null || copyOnWriteArrayList.size() == 0) {
            return null;
        }
        if (this.d.containsKey(str)) {
            n nVar = this.d.get(str);
            if (i == 94 || i == 287) {
                nVar.a(copyOnWriteArrayList.get(0).getRequestId(), aVar);
            } else {
                nVar.a(aVar);
            }
            nVar.a((List<CampaignEx>) copyOnWriteArrayList);
            return nVar;
        }
        n nVar2 = new n(context, (List<CampaignEx>) copyOnWriteArrayList, (ExecutorService) this.b, str, i);
        if (aVar != null) {
            nVar2.a(aVar);
        }
        this.d.put(str, nVar2);
        return nVar2;
    }

    public n createUnitCache(Context context, String str, CampaignEx campaignEx, int i, a aVar) {
        if (TextUtils.isEmpty(str) || campaignEx == null) {
            return null;
        }
        if (this.d.containsKey(str)) {
            n nVar = this.d.get(str);
            if (i == 94 || i == 287) {
                nVar.a(campaignEx.getRequestId(), aVar);
            } else {
                nVar.a(aVar);
            }
            nVar.a(campaignEx);
            return nVar;
        }
        n nVar2 = new n(context, campaignEx, (ExecutorService) this.b, str, i);
        if (aVar != null) {
            nVar2.a(aVar);
        }
        this.d.put(str, nVar2);
        return nVar2;
    }

    public final void a(boolean z) {
        this.c = z;
        ConcurrentHashMap<String, n> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, n> value : concurrentHashMap.entrySet()) {
                n nVar = (n) value.getValue();
                if (nVar != null) {
                    nVar.b();
                }
            }
        }
    }

    public final int b(String str, String str2) {
        CopyOnWriteArrayList<Map<String, a>> c2;
        a aVar;
        CampaignEx k;
        ConcurrentHashMap<String, n> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, n> value : concurrentHashMap.entrySet()) {
                n nVar = (n) value.getValue();
                if (!(nVar == null || (c2 = nVar.c()) == null)) {
                    int size = c2.size();
                    for (int i = 0; i < size; i++) {
                        Map map = c2.get(i);
                        if (map != null) {
                            Iterator it = map.entrySet().iterator();
                            if (!(!it.hasNext() || (aVar = (a) ((Map.Entry) it.next()).getValue()) == null || (k = aVar.k()) == null)) {
                                String videoUrlEncode = k.getVideoUrlEncode();
                                if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(videoUrlEncode) && str2.equals(videoUrlEncode)) {
                                    return aVar.j();
                                }
                            }
                        }
                    }
                    continue;
                }
            }
        }
        return 0;
    }

    public final void b(boolean z) {
        if (!z) {
            this.c = false;
        } else if (this.c) {
            return;
        }
        ConcurrentHashMap<String, n> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            for (Map.Entry<String, n> value : concurrentHashMap.entrySet()) {
                ((n) value.getValue()).a();
            }
        }
    }

    public final void a() {
        ConcurrentHashMap<String, n> concurrentHashMap = this.d;
        if (concurrentHashMap != null) {
            for (Map.Entry next : concurrentHashMap.entrySet()) {
                n nVar = (n) next.getValue();
                String str = (String) next.getKey();
                try {
                    Class.forName("com.mbridge.msdk.videocommon.d.a");
                    com.mbridge.msdk.videocommon.d.c a2 = b.a().a(com.mbridge.msdk.foundation.controller.b.d().h(), str);
                    if (a2 != null) {
                        if (a2.w() == 2) {
                            nVar.b();
                        } else {
                            nVar.a();
                        }
                    }
                } catch (Exception e2) {
                    aa.d("DownLoadManager", e2.getMessage());
                    try {
                        if (!TextUtils.isEmpty(str)) {
                            h e3 = f.a().e(com.mbridge.msdk.foundation.controller.b.d().h(), str);
                            if (e3 == null) {
                                e3 = h.e(str);
                            }
                            if (e3.k() == 2) {
                                nVar.b();
                            } else {
                                nVar.a();
                            }
                        }
                    } catch (Exception e4) {
                        aa.d("DownLoadManager", e4.getMessage());
                    }
                }
            }
        }
    }
}
