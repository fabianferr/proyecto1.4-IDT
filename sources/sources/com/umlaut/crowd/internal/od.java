package com.umlaut.crowd.internal;

import android.content.Context;
import com.umlaut.crowd.IC;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.net.WebApiClient;
import com.umlaut.crowd.net.WebApiResponse;
import com.umlaut.crowd.timeserver.TimeServer;
import com.umlaut.crowd.utils.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class od {
    private static final long d = 2592000000L;
    private static final long e = 5;
    private Context a;
    private IS b;
    private pd c;

    public od(Context context, IS is, pd pdVar) {
        this.a = context;
        this.b = is;
        this.c = pdVar;
        if (is.M() >= TimeServer.getTimeInMillis() + d) {
            is.m(1);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return a(false);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.b.M() == 0;
    }

    /* access modifiers changed from: package-private */
    public boolean c() {
        String str;
        WebApiResponse webApiResponse;
        UTR utr;
        if (a()) {
            return true;
        }
        IC insightConfig = InsightCore.getInsightConfig();
        String str2 = null;
        int i = 0;
        while (((long) i) <= 5) {
            i++;
            UT ut = new UT();
            ut.guid = this.b.q();
            ut.projectid = Integer.parseInt(insightConfig.f1());
            ut.paramsetid = this.b.K();
            String L = this.b.L();
            if (L == null) {
                this.b.h("");
                L = "";
            }
            String[] split = L.split("\\|");
            ArrayList arrayList = new ArrayList(split.length);
            for (String str3 : split) {
                if (!str3.trim().equals("")) {
                    UTP utp = new UTP();
                    utp.name = str3;
                    utp.val = null;
                    arrayList.add(utp);
                }
            }
            ut.params = null;
            if (arrayList.size() > 0) {
                this.c.a(arrayList);
                UTP[] utpArr = new UTP[arrayList.size()];
                ut.params = utpArr;
                arrayList.toArray(utpArr);
            }
            ut.paramsetid = this.b.K();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            if (str2 != null) {
                linkedHashSet.add(str2);
            } else {
                linkedHashSet.add(insightConfig.H1());
                linkedHashSet.addAll(Arrays.asList(insightConfig.G1()));
            }
            Iterator it = linkedHashSet.iterator();
            while (true) {
                if (!it.hasNext()) {
                    str = str2;
                    webApiResponse = null;
                    break;
                }
                str = (String) it.next();
                try {
                    webApiResponse = WebApiClient.sendJsonRequest(WebApiClient.RequestMethod.POST, str, ut);
                    break;
                } catch (IOException unused) {
                }
            }
            if (webApiResponse == null || (utr = (UTR) JsonUtils.fromJson(webApiResponse.content, UTR.class, true)) == null) {
                return false;
            }
            String str4 = utr.paramsetid;
            if (str4 != null && !str4.equals("")) {
                if (utr.params == null) {
                    utr.params = new String[0];
                }
                StringBuilder sb = new StringBuilder();
                for (String append : utr.params) {
                    sb.append(append);
                    sb.append('|');
                }
                this.b.h(sb.toString());
                this.b.g(utr.paramsetid);
            }
            if (utr.status == 3) {
                str2 = str;
            } else {
                this.b.m(TimeServer.getTimeInMillis() + (utr.timeout * 1000));
                long j = utr.status;
                if (j == 2) {
                    this.b.o(false);
                } else if (j == 1) {
                    this.b.o(true);
                } else {
                    this.b.o(false);
                }
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        if (!a()) {
            if (!c()) {
                if (!a(true)) {
                    return false;
                }
            } else if (!a()) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(boolean z) {
        long timeInMillis = TimeServer.getTimeInMillis() - this.b.M();
        if ((z || timeInMillis <= 0) && Math.abs(timeInMillis) <= d) {
            return this.b.S();
        }
        return false;
    }
}
