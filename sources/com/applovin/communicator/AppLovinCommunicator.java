package com.applovin.communicator;

import android.content.Context;
import com.applovin.impl.communicator.MessagingServiceImpl;
import com.applovin.impl.communicator.a;
import com.applovin.impl.sdk.m;
import com.applovin.impl.sdk.u;
import java.util.Collections;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class AppLovinCommunicator {
    private static AppLovinCommunicator a;
    private static final Object b = new Object();
    private m c;
    private u d;
    private final a e;
    private final MessagingServiceImpl f;

    private AppLovinCommunicator(Context context) {
        this.e = new a(context);
        this.f = new MessagingServiceImpl(context);
    }

    private void a(String str) {
        u uVar = this.d;
        if (uVar != null) {
            uVar.b("AppLovinCommunicator", str);
        }
    }

    public static AppLovinCommunicator getInstance(Context context) {
        synchronized (b) {
            if (a == null) {
                a = new AppLovinCommunicator(context.getApplicationContext());
            }
        }
        return a;
    }

    public void a(m mVar) {
        this.c = mVar;
        this.d = mVar.A();
        if (u.a()) {
            a("Attached SDK instance: " + mVar + "...");
        }
    }

    public AppLovinCommunicatorMessagingService getMessagingService() {
        return this.f;
    }

    public boolean hasSubscriber(String str) {
        return this.e.a(str);
    }

    public boolean respondsToTopic(String str) {
        return this.c.ag().c(str);
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        subscribe(appLovinCommunicatorSubscriber, (List<String>) Collections.singletonList(str));
    }

    public void subscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String next : list) {
            if (!this.e.a(appLovinCommunicatorSubscriber, next) && u.a()) {
                a("Unable to subscribe " + appLovinCommunicatorSubscriber + " to topic: " + next);
            }
        }
    }

    public String toString() {
        return "AppLovinCommunicator{sdk=" + this.c + AbstractJsonLexerKt.END_OBJ;
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, String str) {
        unsubscribe(appLovinCommunicatorSubscriber, (List<String>) Collections.singletonList(str));
    }

    public void unsubscribe(AppLovinCommunicatorSubscriber appLovinCommunicatorSubscriber, List<String> list) {
        for (String next : list) {
            if (u.a()) {
                a("Unsubscribing " + appLovinCommunicatorSubscriber + " from topic: " + next);
            }
            this.e.b(appLovinCommunicatorSubscriber, next);
        }
    }
}
