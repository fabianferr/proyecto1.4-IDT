package com.applovin.impl.communicator;

import android.content.Context;
import android.content.Intent;
import com.applovin.communicator.AppLovinCommunicatorMessage;
import com.applovin.communicator.AppLovinCommunicatorSubscriber;
import com.applovin.impl.sdk.AppLovinBroadcastManager;
import com.applovin.impl.sdk.u;
import java.lang.ref.WeakReference;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class b implements AppLovinBroadcastManager.Receiver {
    private boolean a = true;
    private final String b;
    private final WeakReference<AppLovinCommunicatorSubscriber> c;
    private final Set<CommunicatorMessageImpl> d = new LinkedHashSet();
    private final Object e = new Object();

    b(String str, AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber) {
        this.b = str;
        this.c = new WeakReference<>(appLovinCommunicatorSubscriber);
    }

    public String a() {
        return this.b;
    }

    public void a(boolean z) {
        this.a = z;
    }

    public AppLovinCommunicatorSubscriber b() {
        return (AppLovinCommunicatorSubscriber) this.c.get();
    }

    public boolean c() {
        return this.a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b)) {
            return false;
        }
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber = (AppLovinCommunicatorSubscriber) this.c.get();
        b bVar = (b) obj;
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber2 = (AppLovinCommunicatorSubscriber) bVar.c.get();
        if (a().equals(bVar.a())) {
            if (appLovinCommunicatorSubscriber != null) {
                if (appLovinCommunicatorSubscriber.equals(appLovinCommunicatorSubscriber2)) {
                    return true;
                }
            } else if (appLovinCommunicatorSubscriber == appLovinCommunicatorSubscriber2) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.b.hashCode();
        AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber = (AppLovinCommunicatorSubscriber) this.c.get();
        return (hashCode * 31) + (appLovinCommunicatorSubscriber != null ? appLovinCommunicatorSubscriber.hashCode() : 0);
    }

    public void onReceive(Context context, Intent intent, Map<String, Object> map) {
        boolean z;
        if (b() != null) {
            CommunicatorMessageImpl communicatorMessageImpl = (CommunicatorMessageImpl) intent;
            synchronized (this.e) {
                if (!this.d.contains(communicatorMessageImpl)) {
                    this.d.add(communicatorMessageImpl);
                    z = true;
                } else {
                    z = false;
                }
            }
            if (z) {
                b().onMessageReceived((AppLovinCommunicatorMessage) communicatorMessageImpl);
            }
        } else if (u.a()) {
            u.i("AppLovinCommunicator", "Message received for GC'd subscriber");
        }
    }
}
