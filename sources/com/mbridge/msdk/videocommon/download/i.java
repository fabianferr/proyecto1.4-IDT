package com.mbridge.msdk.videocommon.download;

import android.text.TextUtils;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.c.b;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: ResDownloadCheckManager */
public final class i {
    private static ConcurrentHashMap<String, Boolean> b = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, Boolean> a;
    private ConcurrentHashMap<String, Boolean> c;
    private ConcurrentHashMap<String, Boolean> d;
    private ConcurrentHashMap<String, Boolean> e;

    /* compiled from: ResDownloadCheckManager */
    private static final class a {
        public static i a = new i();
    }

    private i() {
        this.a = new ConcurrentHashMap<>();
        this.c = new ConcurrentHashMap<>();
        this.d = new ConcurrentHashMap<>();
        this.e = new ConcurrentHashMap<>();
    }

    public static i a() {
        return a.a;
    }

    public final boolean a(String str) {
        if (this.a == null || TextUtils.isEmpty(str) || !this.a.containsKey(str)) {
            return false;
        }
        return this.a.get(str).booleanValue();
    }

    public final boolean b(String str) {
        if (this.c == null || TextUtils.isEmpty(str) || !this.c.containsKey(str)) {
            return false;
        }
        return this.c.get(str).booleanValue();
    }

    public final void a(CopyOnWriteArrayList<CampaignEx> copyOnWriteArrayList) {
        List<CampaignEx.c.a> f;
        List<String> list;
        ConcurrentHashMap<String, Boolean> concurrentHashMap;
        ConcurrentHashMap<String, Boolean> concurrentHashMap2;
        ConcurrentHashMap<String, Boolean> concurrentHashMap3;
        if (copyOnWriteArrayList != null && copyOnWriteArrayList.size() != 0) {
            Iterator<CampaignEx> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                CampaignEx next = it.next();
                if (next != null) {
                    if (next != null) {
                        String videoUrlEncode = next.getVideoUrlEncode();
                        if (!TextUtils.isEmpty(videoUrlEncode) && (concurrentHashMap3 = this.a) != null && !concurrentHashMap3.containsKey(videoUrlEncode)) {
                            this.a.put(videoUrlEncode, false);
                        }
                        String str = next.getendcard_url();
                        if (!TextUtils.isEmpty(str) && (concurrentHashMap2 = this.c) != null && !concurrentHashMap2.containsKey(str)) {
                            this.c.put(str, false);
                        }
                        CampaignEx.c rewardTemplateMode = next.getRewardTemplateMode();
                        if (!(rewardTemplateMode == null || (f = rewardTemplateMode.f()) == null)) {
                            for (CampaignEx.c.a next2 : f) {
                                if (!(next2 == null || (list = next2.b) == null || list.size() == 0)) {
                                    for (String next3 : list) {
                                        if (!TextUtils.isEmpty(next3) && (concurrentHashMap = b) != null && !concurrentHashMap.containsKey(next3)) {
                                            b.put(next3, Boolean.valueOf(b.a(com.mbridge.msdk.foundation.controller.b.d().g()).b(next3)));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    String id = next.getId();
                    if (this.d == null) {
                        this.d = new ConcurrentHashMap<>();
                    }
                    if (!TextUtils.isEmpty(id)) {
                        this.d.put(id, false);
                    }
                }
            }
        }
    }

    public final void a(String str, boolean z) {
        if (this.a == null) {
            this.a = new ConcurrentHashMap<>();
        }
        if (!TextUtils.isEmpty(str)) {
            this.a.put(str, Boolean.valueOf(z));
        }
    }

    public final void b(String str, boolean z) {
        if (this.c == null) {
            this.c = new ConcurrentHashMap<>();
        }
        if (!TextUtils.isEmpty(str)) {
            this.c.put(str, Boolean.valueOf(z));
        }
    }

    public final void c(String str, boolean z) {
        if (b == null) {
            b = new ConcurrentHashMap<>();
        }
        if (!TextUtils.isEmpty(str)) {
            b.put(str, Boolean.valueOf(z));
        }
    }

    public final void d(String str, boolean z) {
        if (this.e == null) {
            this.e = new ConcurrentHashMap<>();
        }
        if (!TextUtils.isEmpty(str)) {
            this.e.put(str, Boolean.valueOf(z));
        }
    }

    public final boolean c(String str) {
        if (!TextUtils.isEmpty(str) && this.e.containsKey(str)) {
            return this.e.get(str).booleanValue();
        }
        return false;
    }
}
