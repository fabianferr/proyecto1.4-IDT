package com.unity3d.services.ads.gmascar.bridges.mobileads;

import android.content.Context;
import com.unity3d.services.ads.gmascar.finder.ScarAdapterVersion;
import com.unity3d.services.core.log.DeviceLog;
import java.util.HashMap;

public class MobileAdsBridgeLegacy extends MobileAdsBridgeBase {
    public static final int CODE_19_2 = 201604000;
    public static final int CODE_19_5 = 203404000;
    public static final int CODE_19_8 = 204890000;
    public static final int CODE_20_0 = 210402000;
    public static final int CODE_21_0 = 221310000;
    public static final String versionStringMethodName = "getVersionString";

    public int getVersionCodeIndex() {
        return 1;
    }

    public String getVersionMethodName() {
        return versionStringMethodName;
    }

    public boolean hasSCARBiddingSupport() {
        return false;
    }

    public boolean shouldInitialize() {
        return true;
    }

    public MobileAdsBridgeLegacy() {
        super(new HashMap<String, Class<?>[]>() {
            {
                try {
                    put(MobileAdsBridgeBase.initializeMethodName, new Class[]{Context.class, Class.forName("com.google.android.gms.ads.initialization.OnInitializationCompleteListener")});
                } catch (ClassNotFoundException e) {
                    DeviceLog.debug("Could not find class \"com.google.android.gms.ads.initialization.OnInitializationCompleteListener\" %s", e.getLocalizedMessage());
                }
                put(MobileAdsBridgeBase.initializationStatusMethodName, new Class[0]);
                put(MobileAdsBridgeLegacy.versionStringMethodName, new Class[0]);
            }
        });
    }

    public ScarAdapterVersion getAdapterVersion(int i) {
        if (i >= 201604000 && i < 203404000) {
            return ScarAdapterVersion.V192;
        }
        if (i >= 203404000 && i <= 204890000) {
            return ScarAdapterVersion.V195;
        }
        if (i < 210402000 || i >= 221310000) {
            return ScarAdapterVersion.NA;
        }
        return ScarAdapterVersion.V20;
    }
}
