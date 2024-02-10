package com.umlaut.crowd.qoe;

import android.content.Context;
import android.os.SystemClock;
import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.internal.RMR;
import com.umlaut.crowd.internal.RVR;
import com.umlaut.crowd.internal.l;
import com.umlaut.crowd.internal.p;
import com.umlaut.crowd.internal.s0;
import com.umlaut.crowd.timeserver.TimeServer;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class QoeManager {
    private static final boolean d = false;
    private static final String e = "QoeManager";
    private QoeListener a;
    private a b;
    private Map<String, Integer> c = new HashMap();

    public QoeManager(Context context) {
        this.b = new a(context);
    }

    private boolean n() {
        return SystemClock.elapsedRealtime() - this.b.l() < g();
    }

    public void a(RVR rvr) {
        if (this.a == null || !rvr.CallSuccessful) {
            return;
        }
        if (rvr.CallEndType.equals(s0.Dropped)) {
            int e2 = this.b.e() + 1;
            if (e2 < l()) {
                this.b.d(e2);
            } else if (!a() && !n()) {
                try {
                    this.a.onVoiceCallDropped((RVR) rvr.clone());
                } catch (CloneNotSupportedException e3) {
                    e3.printStackTrace();
                }
            }
        } else {
            int d2 = this.b.d() + 1;
            if (d2 < k()) {
                this.b.c(d2);
            } else if (!a() && !n()) {
                try {
                    this.a.onVoiceCall((RVR) rvr.clone());
                } catch (CloneNotSupportedException e4) {
                    e4.printStackTrace();
                }
            }
        }
    }

    public void addPackageNameToWhiteList(String str, int i) {
        this.c.put(str, Integer.valueOf(i));
    }

    public void b(p pVar) {
        if (this.a != null) {
            boolean z = false;
            for (String equals : this.c.keySet()) {
                if (equals.equals(pVar.PackageName)) {
                    z = true;
                }
            }
            if (z && pVar.TimeInfoOnEnd.TimestampMillis - pVar.TimeInfoOnStart.TimestampMillis >= ((long) this.b.c())) {
                int b2 = this.b.b(pVar.PackageName) + 1;
                if (b2 < this.c.get(pVar.PackageName).intValue()) {
                    this.b.a(pVar.PackageName, b2);
                } else if (!a() && !n() && a(pVar)) {
                    this.a.onAppEnd(pVar);
                }
            }
        }
    }

    public l c() {
        return this.b.a();
    }

    public int d() {
        return this.b.c();
    }

    public int e() {
        return this.b.g();
    }

    public int f() {
        return this.b.h();
    }

    public long g() {
        return this.b.m();
    }

    public boolean h() {
        return this.b.j();
    }

    public boolean i() {
        return this.b.n();
    }

    public void incrementMessages() {
        long timeInMillis = TimeServer.getTimeInMillis();
        Set<String> i = this.b.i();
        i.add(String.valueOf(timeInMillis));
        this.b.a(i);
        this.b.a(timeInMillis);
    }

    public int j() {
        return this.b.p();
    }

    public int k() {
        return this.b.p();
    }

    public int l() {
        return this.b.q();
    }

    public boolean m() {
        return this.b.r();
    }

    public void mute() {
        this.b.b(SystemClock.elapsedRealtime());
    }

    public void resetAppsClosedCounter(String str) {
        this.b.a(str, 0);
    }

    public void resetCallsCounter() {
        this.b.c(0);
    }

    public void resetDroppedCallsCounter() {
        this.b.d(0);
    }

    public void resetSmsCounter() {
        this.b.k(0);
    }

    public void setAppEnabled(boolean z) {
        this.b.b(z);
    }

    public void setAppTriggerConnectionType(l lVar) {
        this.b.a(lVar);
    }

    public void setAppsMinForegroundTime(int i) {
        this.b.b(i);
    }

    public void setDefaultMessageLimit(int i) {
        this.b.e(i);
    }

    public void setMessageLimit(int i) {
        this.b.f(i);
    }

    public void setMessageLimitTimespan(int i) {
        this.b.g(i);
    }

    public void setMuteLength(long j) {
        this.b.c(j);
    }

    public void setPeriodicMessageLimitEnabled(boolean z) {
        this.b.a(z);
    }

    public void setQoeListener(QoeListener qoeListener) {
        this.a = qoeListener;
    }

    public void setSmsEnabled(boolean z) {
        this.b.c(z);
    }

    public void setSmsThreshold(int i) {
        this.b.i(i);
    }

    public void setVoiceCallThreshold(int i) {
        this.b.i(i);
    }

    public void setVoiceDroppedThreshold(int i) {
        this.b.j(i);
    }

    public void setVoiceEnabled(boolean z) {
        this.b.d(z);
    }

    public void mute(int i) {
        setMuteLength((long) i);
        mute();
    }

    public boolean b() {
        return this.b.k();
    }

    public void a(RMR rmr) {
        if (this.a != null) {
            int s = this.b.s() + 1;
            if (s < j()) {
                this.b.k(s);
            } else if (!a() && !n()) {
                try {
                    this.a.onSms((RMR) rmr.clone());
                } catch (CloneNotSupportedException e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    private boolean a(p pVar) {
        return c() == l.All || a(pVar.RadioInfoOnEnd.ConnectionType) == c();
    }

    private l a(ConnectionTypes connectionTypes) {
        if (connectionTypes == ConnectionTypes.Bluetooth) {
            return l.Bluetooth;
        }
        if (connectionTypes == ConnectionTypes.Ethernet) {
            return l.Ethernet;
        }
        if (connectionTypes == ConnectionTypes.Mobile) {
            return l.Mobile;
        }
        if (connectionTypes == ConnectionTypes.WiFi) {
            return l.WiFi;
        }
        if (connectionTypes == ConnectionTypes.WiMAX) {
            return l.WiMAX;
        }
        return l.All;
    }

    private boolean a() {
        long timeInMillis = TimeServer.getTimeInMillis();
        if (h()) {
            if (timeInMillis - this.b.f() < ((long) (f() / e()))) {
                return true;
            }
            return false;
        }
        Set<String> i = this.b.i();
        HashSet hashSet = new HashSet();
        for (String next : i) {
            if (timeInMillis - Long.parseLong(next) < ((long) f())) {
                hashSet.add(next);
            }
        }
        if (hashSet.size() >= this.b.g()) {
            return true;
        }
        this.b.a((Set<String>) hashSet);
        return false;
    }
}
