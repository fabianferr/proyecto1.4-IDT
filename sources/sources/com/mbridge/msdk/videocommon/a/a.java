package com.mbridge.msdk.videocommon.a;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.f;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.a.d;
import com.mbridge.msdk.foundation.tools.aa;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: VideoCampaignCache */
public class a {
    private static final String a = "com.mbridge.msdk.videocommon.a.a";
    private static a b;
    private f c;

    private a() {
        try {
            Context g = b.d().g();
            if (g != null) {
                this.c = f.a((g) h.a(g));
            } else {
                aa.d(a, "RewardCampaignCache get Context is null");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static synchronized a a() {
        a aVar;
        synchronized (a.class) {
            if (b == null) {
                b = new a();
            }
            aVar = b;
        }
        return aVar;
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str, int i) {
        List<CampaignEx> a2;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            if (TextUtils.isEmpty(str) || (a2 = this.c.a(str, 0, 0, i)) == null) {
                return null;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            try {
                for (CampaignEx next : a2) {
                    if (next != null) {
                        copyOnWriteArrayList2.add(next);
                    }
                }
                return copyOnWriteArrayList2;
            } catch (Exception e) {
                e = e;
                copyOnWriteArrayList = copyOnWriteArrayList2;
                e.printStackTrace();
                return copyOnWriteArrayList;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return copyOnWriteArrayList;
        }
    }

    public final void a(String str, List<CampaignEx> list, String str2, int i) {
        f fVar;
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && !TextUtils.isEmpty(str2) && (fVar = this.c) != null) {
            fVar.a(str, list, str2, i);
        }
    }

    public final void a(String str, List<CampaignEx> list) {
        f fVar;
        if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && (fVar = this.c) != null) {
            fVar.b(str, list);
        }
    }

    public final void a(String str, List<CampaignEx> list, String str2) {
        f fVar;
        try {
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0 && (fVar = this.c) != null) {
                fVar.a(str, list, str2);
            }
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
    }

    public final void a(String str, String str2) {
        if (this.c != null && !TextUtils.isEmpty(str)) {
            this.c.f(str, str2);
        }
    }

    public final List<CampaignEx> a(String str, int i, boolean z) {
        return a(str, i, z, "");
    }

    public final CopyOnWriteArrayList<CampaignEx> a(String str, int i, boolean z, String str2) {
        List<CampaignEx> list;
        CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList = null;
        try {
            com.mbridge.msdk.videocommon.d.a b2 = com.mbridge.msdk.videocommon.d.b.a().b();
            long f = b2 != null ? b2.f() : 0;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (z) {
                list = this.c.a(str, 0, 0, i, str2);
            } else {
                list = this.c.a(str, 0, 0, i, false);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (list == null) {
                return null;
            }
            CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList2 = new CopyOnWriteArrayList<>();
            try {
                for (CampaignEx next : list) {
                    if (next != null && (next.getReadyState() == 0 || next.getLoadTimeoutState() == 1)) {
                        long plct = next.getPlct() * 1000;
                        long timestamp = currentTimeMillis - next.getTimestamp();
                        if ((plct > 0 && plct >= timestamp) || (plct <= 0 && f >= timestamp)) {
                            copyOnWriteArrayList2.add(next);
                        }
                    }
                }
                return copyOnWriteArrayList2;
            } catch (Exception e) {
                e = e;
                copyOnWriteArrayList = copyOnWriteArrayList2;
                e.printStackTrace();
                return copyOnWriteArrayList;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return copyOnWriteArrayList;
        }
    }

    public final List<CampaignEx> a(List<CampaignEx> list) {
        ArrayList arrayList = null;
        if (list == null) {
            return null;
        }
        try {
            com.mbridge.msdk.videocommon.d.a b2 = com.mbridge.msdk.videocommon.d.b.a().b();
            long f = b2 != null ? b2.f() : 0;
            long currentTimeMillis = System.currentTimeMillis();
            if (list == null || list.size() <= 0) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (CampaignEx next : list) {
                    if (next != null) {
                        long plct = next.getPlct() * 1000;
                        long timestamp = currentTimeMillis - next.getTimestamp();
                        if ((plct > 0 && plct >= timestamp) || (plct <= 0 && f >= timestamp)) {
                            arrayList2.add(next);
                        }
                    }
                }
                return arrayList2;
            } catch (Exception e) {
                e = e;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return arrayList;
        }
    }

    public final List<com.mbridge.msdk.foundation.entity.b> a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return this.c.d(str);
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final int b(String str, int i, boolean z, String str2) {
        List<CampaignEx> list;
        try {
            if (TextUtils.isEmpty(str)) {
                return 0;
            }
            ArrayList arrayList = new ArrayList();
            if (z) {
                list = this.c.a(str, 0, 0, i, str2);
            } else {
                list = this.c.a(str, 0, 0, i, false);
            }
            if (list == null) {
                return 0;
            }
            for (CampaignEx next : list) {
                if (next != null && next.getReadyState() == 0) {
                    arrayList.add(next);
                }
            }
            return arrayList.size();
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public final List<CampaignEx> b(String str, int i, boolean z) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return this.c.a(str, 0, 0, i, z);
            }
            return null;
        } catch (Exception e) {
            aa.d(a, e.getLocalizedMessage());
            return null;
        }
    }

    public final List<CampaignEx> c(String str, int i, boolean z, String str2) {
        long Q;
        List<CampaignEx> list;
        ArrayList arrayList = null;
        try {
            e b2 = com.mbridge.msdk.c.f.a().b(b.d().h());
            if (b2 != null) {
                Q = b2.Q();
            } else {
                Q = com.mbridge.msdk.c.f.a().b().Q();
            }
            long j = Q * 1000;
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            if (z) {
                list = this.c.a(str, 0, 0, i, str2);
            } else {
                list = this.c.a(str, 0, 0, i, false);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (list == null) {
                return null;
            }
            ArrayList arrayList2 = new ArrayList();
            try {
                for (CampaignEx next : list) {
                    if (next != null && next.getReadyState() == 0) {
                        long plctb = next.getPlctb() * 1000;
                        long timestamp = currentTimeMillis - next.getTimestamp();
                        if ((plctb <= 0 && j >= timestamp) || (plctb > 0 && plctb >= timestamp)) {
                            arrayList2.add(next);
                        }
                    }
                }
                return arrayList2;
            } catch (Exception e) {
                e = e;
                arrayList = arrayList2;
                e.printStackTrace();
                return arrayList;
            }
        } catch (Exception e2) {
            e = e2;
            e.printStackTrace();
            return arrayList;
        }
    }

    public final void a(CampaignEx campaignEx, String str) {
        if (campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(str)) {
                    if (campaignEx.isBidCampaign()) {
                        d.b(str, campaignEx.getRequestId());
                    }
                    this.c.a(campaignEx.getId(), str, campaignEx.isBidCampaign(), campaignEx.getRequestId());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                if (!TextUtils.isEmpty(campaignEx.getId())) {
                    this.c.b(campaignEx.getId(), campaignEx.getRequestId());
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public final void b(String str) {
        ConcurrentHashMap<String, com.mbridge.msdk.foundation.entity.b> f;
        try {
            if (!TextUtils.isEmpty(str) && (f = this.c.f(str)) != null && f.size() > 0) {
                e b2 = com.mbridge.msdk.c.f.a().b(b.d().h());
                if (b2 == null) {
                    b2 = com.mbridge.msdk.c.f.a().b();
                }
                long Q = b2 != null ? b2.Q() : 0;
                long currentTimeMillis = System.currentTimeMillis();
                for (com.mbridge.msdk.foundation.entity.b next : f.values()) {
                    if (next != null) {
                        long d = next.d();
                        if (d <= 0) {
                            d = Q;
                        }
                        if (next.e() + (d * 1000) < currentTimeMillis) {
                            if (!TextUtils.isEmpty(next.b())) {
                                c(str, next.b());
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void b(String str, String str2) {
        f fVar = this.c;
        if (fVar != null) {
            fVar.e(str, str2);
        }
    }

    public final void b(String str, int i) {
        int size;
        try {
            List<com.mbridge.msdk.foundation.entity.b> d = this.c.d(str);
            if (d != null && d.size() > 0 && (size = d.size() - i) > 0) {
                for (int i2 = 0; i2 < size; i2++) {
                    c(str, d.get(i2).b());
                    d.b(str, d.get(i2).b());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final List<String> c(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            return this.c.e(str);
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return arrayList;
            }
            e.printStackTrace();
            return arrayList;
        }
    }

    public final synchronized void c(String str, String str2) {
        try {
            this.c.c(str2, str);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return;
    }

    public final void a(String str, String str2, List<CampaignEx> list) {
        try {
            if (!TextUtils.isEmpty(str2) && list != null && list.size() > 0) {
                this.c.a(list, str, str2, 0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final synchronized void a(long j, String str) {
        try {
            this.c.a(j, str);
        } catch (Exception e) {
            e.printStackTrace();
            aa.d(a, e.getMessage());
        }
        return;
    }

    public final synchronized void c(String str, int i) {
        try {
            e b2 = com.mbridge.msdk.c.f.a().b(b.d().h());
            if (b2 == null) {
                b2 = com.mbridge.msdk.c.f.a().b();
            }
            int aA = b2.aA();
            if (aA != 0) {
                boolean z = true;
                List<CampaignEx> b3 = this.c.b(str, i, aA == 2);
                if (b3 != null && b3.size() > 0) {
                    for (CampaignEx next : b3) {
                        String requestIdNotice = next.getRequestIdNotice();
                        String id = next.getId();
                        String campaignUnitId = next.getCampaignUnitId();
                        String cMPTEntryUrl = next.getCMPTEntryUrl();
                        com.mbridge.msdk.videocommon.a.b(campaignUnitId + "_" + id + "_" + requestIdNotice + "_" + cMPTEntryUrl);
                    }
                }
                f fVar = this.c;
                if (aA != 2) {
                    z = false;
                }
                fVar.a(str, i, z);
            } else {
                return;
            }
        } catch (Exception e) {
            aa.d(a, e.getMessage());
        }
        return;
    }
}
