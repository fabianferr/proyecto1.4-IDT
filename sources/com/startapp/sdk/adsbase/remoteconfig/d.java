package com.startapp.sdk.adsbase.remoteconfig;

import android.content.Context;
import android.os.Bundle;
import com.startapp.g4;
import com.startapp.i3;
import com.startapp.o2;
import com.startapp.sdk.adsbase.SimpleTokenUtils;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.components.ComponentLocator;
import com.startapp.sdk.jobs.b;
import com.startapp.z5;

/* compiled from: Sta */
public class d extends b {
    public static final String LOG_TAG = "d";

    public d(Context context, b.a aVar, Bundle bundle) {
        super(context, aVar, bundle);
    }

    private void sendMetaDataRequest(Context context) {
        AdPreferences adPreferences = new AdPreferences();
        a aVar = new a(context, adPreferences, MetaDataRequest.RequestReason.PERIODIC, context, adPreferences);
        ComponentLocator a2 = ComponentLocator.a(context);
        a2.r().execute(new o2(aVar, a2));
    }

    public void run() {
        try {
            ComponentLocator.a(this.context).w().b();
            MetaData.c(this.context);
            if (MetaData.k.Y()) {
                sendMetaDataRequest(this.context);
            } else {
                this.callback.a(this, false);
            }
        } catch (Throwable th) {
            i3.a(th);
        }
    }

    /* compiled from: Sta */
    public class a extends a {
        public MetaData l;
        public final /* synthetic */ Context m;
        public final /* synthetic */ AdPreferences n;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(Context context, AdPreferences adPreferences, MetaDataRequest.RequestReason requestReason, Context context2, AdPreferences adPreferences2) {
            super(context, adPreferences, requestReason);
            this.m = context2;
            this.n = adPreferences2;
        }

        public Boolean a() {
            try {
                SimpleTokenUtils.e(this.m);
                MetaDataRequest metaDataRequest = new MetaDataRequest(this.m, ComponentLocator.a(this.m).e(), MetaDataRequest.RequestReason.PERIODIC);
                metaDataRequest.a(this.m, this.n);
                z5.a a = a.a(this.m, metaDataRequest);
                if (a != null) {
                    MetaData metaData = (MetaData) g4.a(a.b, MetaData.class);
                    this.l = metaData;
                    return Boolean.valueOf(metaData != null);
                }
            } catch (Throwable th) {
                i3.a(th);
            }
            return Boolean.FALSE;
        }

        public void a(Boolean bool) {
            MetaData metaData;
            Context context;
            try {
                if (!(!bool.booleanValue() || (metaData = this.l) == null || (context = this.m) == null)) {
                    MetaData.a(context, metaData, MetaDataRequest.RequestReason.PERIODIC, this.k);
                }
                d.this.callback.a(d.this, false);
            } catch (Throwable th) {
                i3.a(th);
            }
        }
    }
}
