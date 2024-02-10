package com.vungle.ads.internal.privacy;

import android.content.Context;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.model.Cookie;
import com.vungle.ads.internal.persistence.FilePreferences;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0013\u001a\u00020\fJ\u0006\u0010\u0014\u001a\u00020\fJ\u0006\u0010\u0015\u001a\u00020\fJ\u0006\u0010\u0016\u001a\u00020\fJ\u0006\u0010\u0017\u001a\u00020\u0010J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0007J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eJ\u0010\u0010\u001f\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0004H\u0002J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0007H\u0002J\u0010\u0010#\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0007H\u0002J(\u0010$\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\u0006\u0010&\u001a\u00020\f2\u0006\u0010'\u001a\u00020\u0010H\u0002J\u0010\u0010(\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u0007H\u0002J\u000e\u0010*\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020\u0007J\u0006\u0010+\u001a\u00020\u0007J\u000e\u0010,\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u0004J\u000e\u0010-\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0007J\u000e\u0010/\u001a\u00020\u001c2\u0006\u0010.\u001a\u00020\u0007J \u00100\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\f2\u0006\u0010%\u001a\u00020\f2\b\u0010&\u001a\u0004\u0018\u00010\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0004\n\u0002\u0010\u0011R\u0016\u0010\u0012\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Lcom/vungle/ads/internal/privacy/PrivacyManager;", "", "()V", "ccpaConsent", "Lcom/vungle/ads/internal/privacy/PrivacyConsent;", "coppaStatus", "Ljava/util/concurrent/atomic/AtomicReference;", "", "disableAdId", "filePreferences", "Lcom/vungle/ads/internal/persistence/FilePreferences;", "gdprConsent", "", "gdprConsentMessageVersion", "gdprConsentSource", "gdprConsentTimestamp", "", "Ljava/lang/Long;", "publishAndroidId", "getCcpaStatus", "getConsentMessageVersion", "getConsentSource", "getConsentStatus", "getConsentTimestamp", "getCoppaStatus", "Lcom/vungle/ads/internal/privacy/COPPA;", "getPublishAndroidId", "init", "", "context", "Landroid/content/Context;", "saveCcpaConsent", "consent", "saveCoppaConsent", "value", "saveDisableAdId", "saveGdprConsent", "source", "consentMessageVersion", "consentTimestamp", "savePublishAndroidId", "publish", "setPublishAndroidId", "shouldSendAdIds", "updateCcpaConsent", "updateCoppaConsent", "newValue", "updateDisableAdId", "updateGdprConsent", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PrivacyManager.kt */
public final class PrivacyManager {
    public static final PrivacyManager INSTANCE = new PrivacyManager();
    private static PrivacyConsent ccpaConsent;
    private static final AtomicReference<Boolean> coppaStatus = new AtomicReference<>();
    private static final AtomicReference<Boolean> disableAdId = new AtomicReference<>();
    private static FilePreferences filePreferences;
    private static String gdprConsent;
    private static String gdprConsentMessageVersion;
    private static String gdprConsentSource;
    private static Long gdprConsentTimestamp;
    private static AtomicReference<Boolean> publishAndroidId = new AtomicReference<>();

    private PrivacyManager() {
    }

    public final void init(Context context) {
        PrivacyConsent privacyConsent;
        String str;
        Intrinsics.checkNotNullParameter(context, "context");
        FilePreferences filePreferences2 = (FilePreferences) ServiceLocator.Companion.getInstance(context).getService(FilePreferences.class);
        filePreferences = filePreferences2;
        AtomicReference<Boolean> atomicReference = disableAdId;
        Boolean bool = atomicReference.get();
        if (bool != null) {
            saveDisableAdId(bool.booleanValue());
        } else {
            Boolean bool2 = filePreferences2.getBoolean(Cookie.COPPA_DISABLE_AD_ID);
            if (bool2 != null) {
                atomicReference.set(Boolean.valueOf(bool2.booleanValue()));
            }
        }
        String str2 = gdprConsent;
        long j = 0;
        if (str2 != null) {
            String str3 = gdprConsentSource;
            String str4 = str3 == null ? "" : str3;
            String str5 = gdprConsentMessageVersion;
            if (str5 == null) {
                str = "";
            } else {
                str = str5;
            }
            Long l = gdprConsentTimestamp;
            if (l != null) {
                j = l.longValue();
            }
            saveGdprConsent(str2, str4, str, j);
        } else {
            String string = filePreferences2.getString(Cookie.GDPR_CONSENT_STATUS);
            if (Intrinsics.areEqual((Object) string, (Object) PrivacyConsent.OPT_IN.getValue())) {
                string = PrivacyConsent.OPT_IN.getValue();
            } else if (Intrinsics.areEqual((Object) string, (Object) PrivacyConsent.OPT_OUT.getValue())) {
                string = PrivacyConsent.OPT_OUT.getValue();
            }
            gdprConsent = string;
            gdprConsentSource = filePreferences2.getString(Cookie.GDPR_CONSENT_SOURCE);
            gdprConsentMessageVersion = filePreferences2.getString(Cookie.GDPR_CONSENT_MESSAGE_VERSION);
            gdprConsentTimestamp = Long.valueOf(filePreferences2.getLong(Cookie.GDPR_CONSENT_TIMESTAMP, 0));
        }
        PrivacyConsent privacyConsent2 = ccpaConsent;
        if (privacyConsent2 != null) {
            saveCcpaConsent(privacyConsent2);
        } else {
            if (Intrinsics.areEqual((Object) PrivacyConsent.OPT_OUT.getValue(), (Object) filePreferences2.getString(Cookie.CCPA_CONSENT_STATUS))) {
                privacyConsent = PrivacyConsent.OPT_OUT;
            } else {
                privacyConsent = PrivacyConsent.OPT_IN;
            }
            ccpaConsent = privacyConsent;
        }
        AtomicReference<Boolean> atomicReference2 = coppaStatus;
        Boolean bool3 = atomicReference2.get();
        if (bool3 != null) {
            saveCoppaConsent(bool3.booleanValue());
        } else {
            Boolean bool4 = filePreferences2.getBoolean(Cookie.COPPA_STATUS_KEY);
            if (bool4 != null) {
                atomicReference2.set(Boolean.valueOf(bool4.booleanValue()));
            }
        }
        Boolean bool5 = publishAndroidId.get();
        if (bool5 != null) {
            savePublishAndroidId(bool5.booleanValue());
            return;
        }
        Boolean bool6 = filePreferences2.getBoolean(Cookie.PUBLISH_ANDROID_ID);
        if (bool6 != null) {
            publishAndroidId.set(Boolean.valueOf(bool6.booleanValue()));
        }
    }

    public final void updateGdprConsent(String str, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "consent");
        Intrinsics.checkNotNullParameter(str2, "source");
        gdprConsent = str;
        gdprConsentSource = str2;
        gdprConsentMessageVersion = str3;
        long currentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        gdprConsentTimestamp = Long.valueOf(currentTimeMillis);
        String str4 = gdprConsentMessageVersion;
        if (str4 == null) {
            str4 = "";
        }
        saveGdprConsent(str, str2, str4, currentTimeMillis);
    }

    private final void saveGdprConsent(String str, String str2, String str3, long j) {
        FilePreferences put;
        FilePreferences put2;
        FilePreferences put3;
        FilePreferences put4;
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 != null && (put = filePreferences2.put((String) Cookie.GDPR_CONSENT_STATUS, str)) != null && (put2 = put.put((String) Cookie.GDPR_CONSENT_SOURCE, str2)) != null && (put3 = put2.put((String) Cookie.GDPR_CONSENT_MESSAGE_VERSION, str3)) != null && (put4 = put3.put((String) Cookie.GDPR_CONSENT_TIMESTAMP, j)) != null) {
            put4.apply();
        }
    }

    public final void updateCcpaConsent(PrivacyConsent privacyConsent) {
        Intrinsics.checkNotNullParameter(privacyConsent, "consent");
        ccpaConsent = privacyConsent;
        saveCcpaConsent(privacyConsent);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.getValue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getCcpaStatus() {
        /*
            r1 = this;
            com.vungle.ads.internal.privacy.PrivacyConsent r0 = ccpaConsent
            if (r0 == 0) goto L_0x000a
            java.lang.String r0 = r0.getValue()
            if (r0 != 0) goto L_0x0010
        L_0x000a:
            com.vungle.ads.internal.privacy.PrivacyConsent r0 = com.vungle.ads.internal.privacy.PrivacyConsent.OPT_IN
            java.lang.String r0 = r0.getValue()
        L_0x0010:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vungle.ads.internal.privacy.PrivacyManager.getCcpaStatus():java.lang.String");
    }

    private final void saveCcpaConsent(PrivacyConsent privacyConsent) {
        FilePreferences put;
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 != null && (put = filePreferences2.put((String) Cookie.CCPA_CONSENT_STATUS, privacyConsent.getValue())) != null) {
            put.apply();
        }
    }

    public final void updateCoppaConsent(boolean z) {
        coppaStatus.set(Boolean.valueOf(z));
        saveCoppaConsent(z);
    }

    private final void saveCoppaConsent(boolean z) {
        FilePreferences put;
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 != null && (put = filePreferences2.put((String) Cookie.COPPA_STATUS_KEY, z)) != null) {
            put.apply();
        }
    }

    public final void updateDisableAdId(boolean z) {
        disableAdId.set(Boolean.valueOf(z));
        saveDisableAdId(z);
    }

    private final void saveDisableAdId(boolean z) {
        FilePreferences put;
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 != null && (put = filePreferences2.put((String) Cookie.COPPA_DISABLE_AD_ID, z)) != null) {
            put.apply();
        }
    }

    public final String getConsentStatus() {
        String str = gdprConsent;
        return str == null ? "unknown" : str;
    }

    public final String getConsentSource() {
        String str = gdprConsentSource;
        return str == null ? "no_interaction" : str;
    }

    public final String getConsentMessageVersion() {
        String str = gdprConsentMessageVersion;
        return str == null ? "" : str;
    }

    public final long getConsentTimestamp() {
        Long l = gdprConsentTimestamp;
        if (l != null) {
            return l.longValue();
        }
        return 0;
    }

    public final COPPA getCoppaStatus() {
        AtomicReference<Boolean> atomicReference = coppaStatus;
        if (atomicReference.get() == null) {
            return COPPA.COPPA_NOTSET;
        }
        if (Intrinsics.areEqual((Object) atomicReference.get(), (Object) true)) {
            return COPPA.COPPA_ENABLED;
        }
        if (Intrinsics.areEqual((Object) atomicReference.get(), (Object) false)) {
            return COPPA.COPPA_DISABLED;
        }
        return COPPA.COPPA_NOTSET;
    }

    public final boolean shouldSendAdIds() {
        Boolean bool = disableAdId.get();
        if (bool != null && !bool.booleanValue()) {
            return true;
        }
        return false;
    }

    public final void setPublishAndroidId(boolean z) {
        publishAndroidId.set(Boolean.valueOf(z));
        savePublishAndroidId(z);
    }

    private final void savePublishAndroidId(boolean z) {
        FilePreferences put;
        FilePreferences filePreferences2 = filePreferences;
        if (filePreferences2 != null && (put = filePreferences2.put((String) Cookie.PUBLISH_ANDROID_ID, z)) != null) {
            put.apply();
        }
    }

    public final boolean getPublishAndroidId() {
        Boolean bool = publishAndroidId.get();
        if (bool != null) {
            return bool.booleanValue();
        }
        return true;
    }
}
