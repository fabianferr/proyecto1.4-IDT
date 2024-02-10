package com.startapp;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.startapp.sdk.adsbase.StartAppSDKInternal;
import com.startapp.sdk.adsbase.adinformation.AdInformationMetaData;
import com.startapp.sdk.adsbase.consent.ConsentActivity;
import com.startapp.sdk.adsbase.consent.ConsentConfig;
import com.startapp.sdk.adsbase.consent.ConsentTypeInfoConfig;
import com.startapp.sdk.adsbase.e;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.adsbase.remoteconfig.c;
import com.startapp.sdk.components.ComponentLocator;

/* compiled from: Sta */
public final class u1 implements c {
    public final Context a;
    public final e b;
    public Intent c;
    public boolean d = false;
    public boolean e = true;

    public u1(Context context, e eVar) {
        this.a = context;
        this.b = eVar;
    }

    public void a(Integer num, Long l, Boolean bool, boolean z, boolean z2) {
        if (d()) {
            long j = this.b.getLong("consentTimestamp", 0);
            int i = this.b.getInt("consentType", -1);
            boolean contains = this.b.contains("consentApc");
            boolean z3 = true;
            boolean z4 = (num == null || i == num.intValue()) ? false : true;
            boolean z5 = bool != null && (!contains || this.b.getBoolean("consentApc", false) != bool.booleanValue());
            if (l == null || l.longValue() <= j) {
                z3 = false;
            }
            if (!z && !z3) {
                return;
            }
            if (z4 || z5) {
                e.a a2 = this.b.edit();
                if (z4) {
                    int intValue = num.intValue();
                    a2.a("consentType", Integer.valueOf(intValue));
                    a2.a.putInt("consentType", intValue);
                }
                if (z5) {
                    boolean booleanValue = bool.booleanValue();
                    a2.a("consentApc", Boolean.valueOf(booleanValue));
                    a2.a.putBoolean("consentApc", booleanValue);
                }
                if (z3) {
                    long longValue = l.longValue();
                    a2.a("consentTimestamp", Long.valueOf(longValue));
                    a2.a.putLong("consentTimestamp", longValue);
                }
                a2.apply();
                if (z2) {
                    MetaData.k.a(this.a, new AdPreferences(), MetaDataRequest.RequestReason.CONSENT, false, (c) null, true);
                }
            }
        }
    }

    public Integer b() {
        if (d()) {
            int hashCode = ComponentLocator.a(this.a).a().a().a.hashCode();
            if (!this.b.contains("advIdHash") || this.b.getInt("advIdHash", 0) != hashCode) {
                e.a a2 = this.b.edit().remove("consentType").remove("consentTimestamp");
                a2.a("advIdHash", Integer.valueOf(hashCode));
                a2.a.putInt("advIdHash", hashCode);
                a2.apply();
            }
        }
        if (!d() || !this.b.contains("consentType")) {
            return null;
        }
        return Integer.valueOf(this.b.getInt("consentType", -1));
    }

    public boolean c() {
        Boolean a2 = a();
        return a2 != null && a2.booleanValue();
    }

    public final boolean d() {
        ConsentConfig o = MetaData.k.o();
        return this.e && o != null && o.k();
    }

    public Boolean a() {
        if (!d() || !this.b.contains("consentApc")) {
            return null;
        }
        return Boolean.valueOf(this.b.getBoolean("consentApc", false));
    }

    public final void a(boolean z, String str, String str2, String str3) {
        ConsentConfig o;
        String str4;
        int i;
        int i2;
        Integer b2;
        if ((!z && !StartAppSDKInternal.c()) || (o = MetaData.k.o()) == null) {
            return;
        }
        if ((!d() && !z) || this.d || !k9.g(this.a) || !k9.e(this.a)) {
            return;
        }
        if (z || !(o.h() == null || o.g() == null || this.b.contains("consentApc"))) {
            if (z) {
                str4 = AdInformationMetaData.a.a().c();
            } else {
                str4 = o.f();
            }
            if (str4 != null) {
                Intent intent = new Intent(this.a, ConsentActivity.class);
                intent.setFlags(805306368);
                intent.setData(Uri.parse(str4));
                intent.putExtra("allowCT", o.k());
                intent.putExtra(CampaignEx.JSON_KEY_TIMESTAMP, o.i());
                if (z) {
                    i = 4;
                } else {
                    i = o.h().intValue();
                }
                Integer valueOf = Integer.valueOf(i);
                if (valueOf != null) {
                    intent.putExtra("templateName", valueOf);
                }
                if (z) {
                    i2 = 7;
                } else {
                    i2 = o.g().intValue();
                }
                Integer valueOf2 = Integer.valueOf(i2);
                if (valueOf2 != null) {
                    intent.putExtra("templateId", valueOf2);
                }
                if (!z) {
                    str = o.d();
                }
                if (str != null) {
                    intent.putExtra("dParam", str);
                }
                if (!z) {
                    str2 = o.e();
                }
                if (str2 != null) {
                    intent.putExtra("impressionUrl", str2);
                }
                if (!z) {
                    str3 = o.a();
                }
                if (str3 != null) {
                    intent.putExtra("clickUrl", str3);
                }
                if (z) {
                    intent.putExtra("advertisingId", ComponentLocator.a(this.a).a().a().a);
                    if (this.b.contains("consentType")) {
                        intent.putExtra("consentType", this.b.getInt("consentType", -1));
                    }
                }
                ConsentTypeInfoConfig c2 = o.c();
                if (c2 != null) {
                    if (c2.b() != null) {
                        intent.putExtra("impression", c2.b());
                    }
                    if (c2.a() != null) {
                        intent.putExtra("falseClick", c2.a());
                    }
                    if (c2.c() != null) {
                        intent.putExtra("trueClick", c2.c());
                    }
                }
                if (z && (b2 = AdInformationMetaData.a.a().b()) != null) {
                    intent.putExtra("trueClick", b2);
                }
                try {
                    this.a.startActivity(intent);
                    this.d = true;
                } catch (ActivityNotFoundException unused) {
                } catch (Throwable th) {
                    i3.a(th);
                }
            }
        }
    }

    public void a(MetaDataRequest.RequestReason requestReason) {
        MetaData.k.a((c) this);
    }

    public void a(MetaDataRequest.RequestReason requestReason, boolean z) {
        MetaData.k.a((c) this);
        ConsentConfig o = MetaData.k.o();
        if (o != null && d()) {
            Integer b2 = o.b();
            if (b2 != null) {
                a(b2, Long.valueOf(o.i()), (Boolean) null, false, false);
            }
            if (requestReason == MetaDataRequest.RequestReason.CONSENT) {
                e.a a2 = this.b.edit();
                long i = o.i();
                a2.a("consentTimestamp", Long.valueOf(i));
                a2.a.putLong("consentTimestamp", i);
                a2.apply();
            } else if (requestReason == MetaDataRequest.RequestReason.LAUNCH) {
                a(false, (String) null, (String) null, (String) null);
            }
        }
    }
}
