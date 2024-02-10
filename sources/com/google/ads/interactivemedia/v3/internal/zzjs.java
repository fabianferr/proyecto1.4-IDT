package com.google.ads.interactivemedia.v3.internal;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.view.MotionEvent;
import android.view.View;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzjs {
    private static final String[] zza = {"/aclk", "/pcs/click", "/dbm/clk"};
    private String zzb = "googleads.g.doubleclick.net";
    private String zzc = "/pagead/ads";
    private final String zzd = "ad.doubleclick.net";
    private String[] zze = {".doubleclick.net", ".googleadservices.com", ".googlesyndication.com"};
    private final zzjl zzf;

    @Deprecated
    public zzjs(zzjl zzjl) {
        this.zzf = zzjl;
    }

    private final Uri zzh(Uri uri, String str) throws zzjt {
        uri.getClass();
        try {
            if (uri.getHost().equals(this.zzd)) {
                try {
                    if (!uri.toString().contains("dc_ms=")) {
                        String uri2 = uri.toString();
                        int indexOf = uri2.indexOf(";adurl");
                        if (indexOf != -1) {
                            int i = indexOf + 1;
                            return Uri.parse(uri2.substring(0, i) + "dc_ms=" + str + ";" + uri2.substring(i));
                        }
                        String encodedPath = uri.getEncodedPath();
                        int indexOf2 = uri2.indexOf(encodedPath);
                        return Uri.parse(uri2.substring(0, encodedPath.length() + indexOf2) + ";dc_ms=" + str + ";" + uri2.substring(indexOf2 + encodedPath.length()));
                    }
                    throw new zzjt("Parameter already exists: dc_ms");
                } catch (UnsupportedOperationException unused) {
                    throw new zzjt("Provided Uri is not in a valid state");
                }
            }
        } catch (NullPointerException unused2) {
        }
        if (uri.getQueryParameter("ms") == null) {
            String uri3 = uri.toString();
            int indexOf3 = uri3.indexOf("&adurl");
            if (indexOf3 == -1) {
                indexOf3 = uri3.indexOf("?adurl");
            }
            if (indexOf3 == -1) {
                return uri.buildUpon().appendQueryParameter("ms", str).build();
            }
            int i2 = indexOf3 + 1;
            return Uri.parse(uri3.substring(0, i2) + "ms=" + str + "&" + uri3.substring(i2));
        }
        throw new zzjt("Query parameter already exists: ms");
    }

    @Deprecated
    public final Uri zza(Uri uri, Context context, View view, Activity activity) throws zzjt {
        try {
            return zzh(uri, this.zzf.zze(context, uri.getQueryParameter("ai"), (View) null, (Activity) null));
        } catch (UnsupportedOperationException unused) {
            throw new zzjt("Provided Uri is not in a valid state");
        }
    }

    @Deprecated
    public final Uri zzb(Uri uri, Context context) throws zzjt {
        return zzh(uri, ((zzjp) this.zzf).zzg(context, (byte[]) null));
    }

    @Deprecated
    public final void zzc(MotionEvent motionEvent) {
        this.zzf.zzk(motionEvent);
    }

    public final void zzd(String str, String str2) {
        this.zzb = str;
        this.zzc = str2;
    }

    public final void zze(String str) {
        this.zze = str.split(",");
    }

    public final boolean zzf(Uri uri) {
        uri.getClass();
        try {
            String host = uri.getHost();
            for (String endsWith : this.zze) {
                if (host.endsWith(endsWith)) {
                    return true;
                }
            }
        } catch (NullPointerException unused) {
        }
        return false;
    }

    public final boolean zzg(Uri uri) {
        uri.getClass();
        try {
            if (!uri.getHost().equals(this.zzb) || !uri.getPath().equals(this.zzc)) {
                return false;
            }
            return true;
        } catch (NullPointerException unused) {
        }
    }
}
