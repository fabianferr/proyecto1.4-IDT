package com.google.ads.mediation.applovin;

import android.content.Context;
import com.applovin.mediation.ApplovinAdapter;
import com.applovin.mediation.BuildConfig;
import com.applovin.sdk.AppLovinMediationProvider;
import com.applovin.sdk.AppLovinSdk;
import com.applovin.sdk.AppLovinSdkConfiguration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class AppLovinInitializer {
    public static final int INITIALIZED = 2;
    public static final int INITIALIZING = 1;
    public static final int UNINITIALIZED = 0;
    private static AppLovinInitializer instance;
    /* access modifiers changed from: private */
    public final HashMap<String, Integer> initializationStatus = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashMap<String, ArrayList<OnInitializeSuccessListener>> initializerListeners = new HashMap<>();

    @Retention(RetentionPolicy.SOURCE)
    public @interface InitializationStatus {
    }

    public interface OnInitializeSuccessListener {
        void onInitializeSuccess(String str);
    }

    private AppLovinInitializer() {
    }

    public static AppLovinInitializer getInstance() {
        if (instance == null) {
            instance = new AppLovinInitializer();
        }
        return instance;
    }

    public void initialize(Context context, final String str, OnInitializeSuccessListener onInitializeSuccessListener) {
        if (!this.initializationStatus.containsKey(str)) {
            this.initializationStatus.put(str, 0);
            this.initializerListeners.put(str, new ArrayList());
        }
        Integer num = 2;
        if (num.equals(this.initializationStatus.get(str))) {
            onInitializeSuccessListener.onInitializeSuccess(str);
            return;
        }
        this.initializerListeners.get(str).add(onInitializeSuccessListener);
        Integer num2 = 1;
        if (!num2.equals(this.initializationStatus.get(str))) {
            this.initializationStatus.put(str, 1);
            ApplovinAdapter.log(3, String.format("Attempting to initialize SDK with SDK Key: %s", new Object[]{str}));
            AppLovinSdk instance2 = AppLovinSdk.getInstance(str, AppLovinMediationAdapter.getSdkSettings(context), context);
            instance2.setPluginVersion(BuildConfig.ADAPTER_VERSION);
            instance2.setMediationProvider(AppLovinMediationProvider.ADMOB);
            instance2.initializeSdk((AppLovinSdk.SdkInitializationListener) new AppLovinSdk.SdkInitializationListener() {
                public void onSdkInitialized(AppLovinSdkConfiguration appLovinSdkConfiguration) {
                    AppLovinInitializer.this.initializationStatus.put(str, 2);
                    ArrayList arrayList = (ArrayList) AppLovinInitializer.this.initializerListeners.get(str);
                    if (arrayList != null) {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            ((OnInitializeSuccessListener) it.next()).onInitializeSuccess(str);
                        }
                        arrayList.clear();
                    }
                }
            });
        }
    }
}
