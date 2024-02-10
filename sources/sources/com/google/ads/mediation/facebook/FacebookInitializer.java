package com.google.ads.mediation.facebook;

import android.content.Context;
import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.AdError;
import java.util.ArrayList;
import java.util.Iterator;

class FacebookInitializer implements AudienceNetworkAds.InitListener {
    private static FacebookInitializer instance;
    private boolean mIsInitialized = false;
    private boolean mIsInitializing = false;
    private ArrayList<Listener> mListeners = new ArrayList<>();

    interface Listener {
        void onInitializeError(AdError adError);

        void onInitializeSuccess();
    }

    static FacebookInitializer getInstance() {
        if (instance == null) {
            instance = new FacebookInitializer();
        }
        return instance;
    }

    private FacebookInitializer() {
    }

    /* access modifiers changed from: package-private */
    public void initialize(Context context, String str, Listener listener) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(str);
        getInstance().initialize(context, (ArrayList<String>) arrayList, listener);
    }

    /* access modifiers changed from: package-private */
    public void initialize(Context context, ArrayList<String> arrayList, Listener listener) {
        if (this.mIsInitializing) {
            this.mListeners.add(listener);
        } else if (this.mIsInitialized) {
            listener.onInitializeSuccess();
        } else {
            this.mIsInitializing = true;
            getInstance().mListeners.add(listener);
            AudienceNetworkAds.buildInitSettings(context).withMediationService("GOOGLE:6.11.0.0").withPlacementIds(arrayList).withInitListener(this).initialize();
        }
    }

    public void onInitialized(AudienceNetworkAds.InitResult initResult) {
        this.mIsInitializing = false;
        this.mIsInitialized = initResult.isSuccess();
        Iterator<Listener> it = this.mListeners.iterator();
        while (it.hasNext()) {
            Listener next = it.next();
            if (initResult.isSuccess()) {
                next.onInitializeSuccess();
            } else {
                next.onInitializeError(new AdError(104, initResult.getMessage(), "com.google.ads.mediation.facebook"));
            }
        }
        this.mListeners.clear();
    }
}
