package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzkt {
    private static final String zzd = "zzkt";
    protected final Context zza;
    protected boolean zzb;
    protected boolean zzc;
    private ExecutorService zze;
    private DexClassLoader zzf;
    private zzjy zzg;
    private byte[] zzh;
    private volatile AdvertisingIdClient zzi = null;
    private volatile boolean zzj;
    private Future zzk;
    private final boolean zzl;
    /* access modifiers changed from: private */
    public volatile zzbc zzm;
    private Future zzn;
    private zzjk zzo;
    private final Map zzp;
    private boolean zzq;
    private zzkm zzr;

    private zzkt(Context context) {
        boolean z = false;
        this.zzj = false;
        this.zzk = null;
        this.zzm = null;
        this.zzn = null;
        this.zzb = false;
        this.zzc = false;
        this.zzq = false;
        Context applicationContext = context.getApplicationContext();
        this.zzl = applicationContext != null ? true : z;
        context = applicationContext != null ? applicationContext : context;
        this.zza = context;
        this.zzp = new HashMap();
        if (this.zzr == null) {
            this.zzr = new zzkm(context);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(17:1|2|(1:4)|5|6|7|8|(1:10)(1:11)|12|(1:14)(1:15)|16|17|18|(2:20|(1:22)(2:23|24))|25|26|(3:27|28|(17:30|(2:32|33)|34|35|36|37|(2:39|(1:41)(2:42|43))|44|(3:46|(1:48)|49)|50|51|52|53|54|55|56|85)(3:74|75|76))) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x004f */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0058 A[Catch:{ zzkj -> 0x016e }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0086 A[Catch:{ IllegalArgumentException -> 0x0160, zzjx -> 0x0167 }] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x015a A[SYNTHETIC, Splitter:B:74:0x015a] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.ads.interactivemedia.v3.internal.zzkt zzg(android.content.Context r9, java.lang.String r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r11 = "1678981529375"
            com.google.ads.interactivemedia.v3.internal.zzkt r0 = new com.google.ads.interactivemedia.v3.internal.zzkt
            r0.<init>(r9)
            com.google.ads.interactivemedia.v3.internal.zzkp r9 = new com.google.ads.interactivemedia.v3.internal.zzkp     // Catch:{ zzkj -> 0x016e }
            r9.<init>()     // Catch:{ zzkj -> 0x016e }
            java.util.concurrent.ExecutorService r9 = java.util.concurrent.Executors.newCachedThreadPool(r9)     // Catch:{ zzkj -> 0x016e }
            r0.zze = r9     // Catch:{ zzkj -> 0x016e }
            r0.zzj = r12     // Catch:{ zzkj -> 0x016e }
            if (r12 == 0) goto L_0x0025
            java.util.concurrent.ExecutorService r9 = r0.zze     // Catch:{ zzkj -> 0x016e }
            com.google.ads.interactivemedia.v3.internal.zzkq r12 = new com.google.ads.interactivemedia.v3.internal.zzkq     // Catch:{ zzkj -> 0x016e }
            r12.<init>(r0)     // Catch:{ zzkj -> 0x016e }
            java.util.concurrent.Future r9 = r9.submit(r12)     // Catch:{ zzkj -> 0x016e }
            r0.zzk = r9     // Catch:{ zzkj -> 0x016e }
        L_0x0025:
            java.util.concurrent.ExecutorService r9 = r0.zze     // Catch:{ zzkj -> 0x016e }
            com.google.ads.interactivemedia.v3.internal.zzks r12 = new com.google.ads.interactivemedia.v3.internal.zzks     // Catch:{ zzkj -> 0x016e }
            r12.<init>(r0)     // Catch:{ zzkj -> 0x016e }
            r9.execute(r12)     // Catch:{ zzkj -> 0x016e }
            r9 = 1
            r12 = 0
            com.google.android.gms.common.GoogleApiAvailabilityLight r1 = com.google.android.gms.common.GoogleApiAvailabilityLight.getInstance()     // Catch:{ all -> 0x004f }
            android.content.Context r2 = r0.zza     // Catch:{ all -> 0x004f }
            int r2 = r1.getApkVersion(r2)     // Catch:{ all -> 0x004f }
            if (r2 <= 0) goto L_0x003f
            r2 = 1
            goto L_0x0040
        L_0x003f:
            r2 = 0
        L_0x0040:
            r0.zzb = r2     // Catch:{ all -> 0x004f }
            android.content.Context r2 = r0.zza     // Catch:{ all -> 0x004f }
            int r1 = r1.isGooglePlayServicesAvailable(r2)     // Catch:{ all -> 0x004f }
            if (r1 != 0) goto L_0x004c
            r1 = 1
            goto L_0x004d
        L_0x004c:
            r1 = 0
        L_0x004d:
            r0.zzc = r1     // Catch:{ all -> 0x004f }
        L_0x004f:
            r0.zzo(r12, r9)     // Catch:{ zzkj -> 0x016e }
            boolean r1 = com.google.ads.interactivemedia.v3.internal.zzkw.zzc()     // Catch:{ zzkj -> 0x016e }
            if (r1 == 0) goto L_0x0073
            com.google.ads.interactivemedia.v3.internal.zznj r1 = com.google.ads.interactivemedia.v3.internal.zznr.zzcS     // Catch:{ zzkj -> 0x016e }
            com.google.ads.interactivemedia.v3.internal.zznp r2 = com.google.ads.interactivemedia.v3.internal.zznc.zzc()     // Catch:{ zzkj -> 0x016e }
            java.lang.Object r1 = r2.zzb(r1)     // Catch:{ zzkj -> 0x016e }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ zzkj -> 0x016e }
            boolean r1 = r1.booleanValue()     // Catch:{ zzkj -> 0x016e }
            if (r1 != 0) goto L_0x006b
            goto L_0x0073
        L_0x006b:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException     // Catch:{ zzkj -> 0x016e }
            java.lang.String r10 = "Task Context initialization must not be called from the UI thread."
            r9.<init>(r10)     // Catch:{ zzkj -> 0x016e }
            throw r9     // Catch:{ zzkj -> 0x016e }
        L_0x0073:
            com.google.ads.interactivemedia.v3.internal.zzjy r1 = new com.google.ads.interactivemedia.v3.internal.zzjy     // Catch:{ zzkj -> 0x016e }
            r2 = 0
            r1.<init>(r2)     // Catch:{ zzkj -> 0x016e }
            r0.zzg = r1     // Catch:{ zzkj -> 0x016e }
            java.lang.String r3 = "lDvao6SwgKNthUqzuuToCGalSafTc2rxCMGIUZkEwkc="
            byte[] r3 = com.google.ads.interactivemedia.v3.internal.zzia.zzb(r3, r12)     // Catch:{ IllegalArgumentException -> 0x0160 }
            int r4 = r3.length     // Catch:{ IllegalArgumentException -> 0x0160 }
            r5 = 32
            if (r4 != r5) goto L_0x015a
            r4 = 4
            r5 = 16
            java.nio.ByteBuffer r3 = java.nio.ByteBuffer.wrap(r3, r4, r5)     // Catch:{ IllegalArgumentException -> 0x0160 }
            byte[] r4 = new byte[r5]     // Catch:{ IllegalArgumentException -> 0x0160 }
            r3.get(r4)     // Catch:{ IllegalArgumentException -> 0x0160 }
            r3 = 0
        L_0x0093:
            if (r3 >= r5) goto L_0x009f
            byte r6 = r4[r3]     // Catch:{ IllegalArgumentException -> 0x0160 }
            r6 = r6 ^ 68
            byte r6 = (byte) r6     // Catch:{ IllegalArgumentException -> 0x0160 }
            r4[r3] = r6     // Catch:{ IllegalArgumentException -> 0x0160 }
            int r3 = r3 + 1
            goto L_0x0093
        L_0x009f:
            r0.zzh = r4     // Catch:{ zzjx -> 0x0167 }
            android.content.Context r1 = r0.zza     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            java.io.File r1 = r1.getCacheDir()     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            if (r1 != 0) goto L_0x00ba
            android.content.Context r1 = r0.zza     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.String r3 = "dex"
            java.io.File r1 = r1.getDir(r3, r12)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            if (r1 == 0) goto L_0x00b4
            goto L_0x00ba
        L_0x00b4:
            com.google.ads.interactivemedia.v3.internal.zzkj r9 = new com.google.ads.interactivemedia.v3.internal.zzkj     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r9.<init>()     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            throw r9     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
        L_0x00ba:
            java.lang.String r3 = "6ME7rF9jfeG6+GUVE5RX/UlUnlZWH23Nl9zWeUAnkWEzlVjxtpsPyAT5+o+lqopQAzYc0ci5zY00tOA0Gg6LwKDzR2s1S5j93Gc2QOoU1PBAObc1k97ntcIIjZ4iw3dIAvA8tZS7OHa6uUi/OZXINAFazXTTFRn7hmM8sAIxMTBJy5vVBHgr5aiSedxsutiXFQK9ZB4ocALFBCjPhpKh2n/5QpE4K9eKW/0fZnr3YW7TACRGyaw3BpVIW1y+m4mHyLzZ8PxoUwuxYYnQPsoIbSPd3a7Tyvo8hh4NvrRRH0HWgbjrWa/N+3O4Odd5MUcizOdXga8ruKjzD8W5RTlvAGeMV27bZumYf9fvo74q1/ml5RXmRNojJqI7j0EOK11j3KV+t9pHqjoaKLXb9/ecDuuJze3zyJhM6zx0H7Fn3uWm682tfh6Q0zJ9/jcuUpqrEP6EST1Rhir+UH+MgMnu2FLadVObiG8CIn5Sf+u9+nrc7CLoDpHuAaiJ6/eU/Y5xgp2C8wlAn50MDBt9n27GMiS+6ENadyHtX97yW2ocwxGkRRtIajTv30glfuOQjYtKA7mOeYfPN4QAicup9uQZWAaq44+MF3sWd5XwpDXy02BtE4nMLvq8QwdmgiAtsJ8OEl+OsZdKYxqQO2roNEFHgSNm2stZQyQSwAOpeQP4msgAPXnwCGdaKpYkr5GsReN7FFo6Hz78eK5pUAFEBLox1yDckR0LWVXapKMVeCCv6vxIuDWq9GlCA9ZEGBRK8Bsf8rNiphtbZYUmILya73L6FgY5yfML8/VsR4vGVlfW2p1G7y1JAx3wXOxnuGq2i+tyvAnho1MLQi/pJtN22jKOZt/KHQjnBFE9pCnOBuhNKNzVkMZ4vOluSos1wBtYArql2VRD2A0cca/NxpUOU7SZMcc2ug6gCLhyyWl0HUWJ9ob0h12V8fAJn6BcyibzIXSOQIRRBU7abgwORMMRGSUFAn7weZjCD2b0GzWv3G191ehXN/zbaU0YN75kHvOoEFy15L+GP17l1evkfM5VDBVCcU+4fv3/hcmqaSQ+7TUSXRhUztKPCrPaVyhW6wFwZMGAqrV/8mYRPCV7ltr7gZBPfGoQT+gdY7vP6Py3R+E21kNrkPmJLLCJcwXHU/6zE0oboRCa5OxdINaStefZPvaE8D+uE4w5xKYh3Dei2EiELew4taUTQ65QR4OqwAH+8xjWaqqdsMn17ANSCdJacA3CiZPlM9e+kD72PmQ0hd6mJ++URio8zVRRUIqVJtr6kVpKlUjlCUFtZz7Ekr2xfsvh652oQI05F5QtqVrw6UhA4pZsNYwp0EWTn1mLg22QzmMmNKH4afNn79bVg1bZ+kxjVKQ9d4kGTn6doIzevQr4RAollOelSusJb13BT8k1n65u6XNmCzphQim2WGIWmuLhAokwj7utmvJrPVdq9Uy4kx9RHvH0Z+zW3wd8jAJO1EFGu3tk6W0OTurVKQTWJgSpag7oOSo1uILADvOKBurrRVxCIy+V7MjtixPQTnMYa6QRByVFPyJiyoBx1CTes/kadm6ERA0s+Txcx/ckx2FeYX7LKncGh3EMMha3evZduLF32l8YzEsb5Y5P73e/1gNvnrgqnLJmS+IYgQCMefe4JAp3fyYikXzYbAHuS3F6YVDh4W9eoe3jud51mPIv1ti95VyT+lIW7R///oILt3Zbgp1dPs6Hr2RDpSm69BD4J5oxw/l6/fsLJ077O4MJrupSvyH4KwmtSgMt9XVNxqYhnv+JyJJ+jXNwf6AWiNhn0HULORzpgDWcxmotLVl9Z9dhguVOnUwgy/RVUtKbOmn9fsat2wX9wyB4TLUkk+4NgX5H4Hrzs9bqcL1XehyUFA7X/zNcfyaa5pRrbwETd5t2fMELcF8m2QeeOCCPMQIu06m/cdLJz9NWEAE3yZuiQMmk3QP5N3oF0SFDZXK7w+1tG9CgdxLzE/HQWntgMzx8jsOI5hetWnLeWEWz8Cw8X7hUGGvM6tffeVSmupAGef03mNvtCChn405+rAvmkBiHt1h1Vw9IWI94eCqd72rT010XIe0+pcF2qiYm46gJxEw9QEOre7zBKIek64QFv2mJVKZCiKH/teYbEu6CnrGipcDSP70GDxonsNK8nrlhEhFr6rMlCslvjmOkYoveZburJw9m6BP8gf7ibolLlRG2sK6IiVQuSFvLHlO1xVAwOP+KFmg1gJ3o9awZoHEt6pzIVz+Zel6yibETS8XnzkiRqajvI7tsnnV4C3mZUxoyli9xFLbkOshjpw3QdtwmMS3Y8BsnysTUkQ2eubvmHBQrg5aRPJeVdfiU9gLdRTGZekwwCNDz9ju6OkU2mtaLsR75tDJViti8TW3lh+eJiWFsdF9xXJ9FXFZplIwkz43gp7ndZYU+AYd9LU/TjyJLG4vcXPVbAZ6AylEAqZ2C5dztmVTVdzLUGQFHXHeMoBEfD39MsL7t5V/a6minRHrBnrL6RZnS7rGJTCd+/GRX9WwCjdJfzEpxuHXKnt0TyHI7OC6X/HUm2A6u7wrztiykK9rHmO/8KIFPKZMLyzSrjyvl5avpYu9/Z0oF2DykSdxTVQ463N/7HXm2KoFR4hLsknIh2oS09JTO641YBilA+S5Nc2I80Sysw0sFJAaoXetB4VWWKLXIRBOz1Bze2DM7ndFoAM0m+f9pWFtJlz1tAoQBroc2KOSVx9KPropSknHOeiil3Yc8ZZprd2e88KC5XIrUq9p38FP0OtY38PG1v7dYbI9AOdIaNa6dGr4O5Y+lDlxSw9EvgYUo+pjfWeqPXS35f+mMAcvVilZ6Fe8hdd2VpnnwfGgAgWs3aVprrxkA0oD98urVMMnU49yVF96iUv4/BLhAC1+/HgY34qlyyWSFJe3tBlntKe4jE931ap8laUANw9mOBHHo0GMc9vybBwxOIXDv89dxuxxpV4zNRO1OZhVIKa9Ly5d8XRNQImYMXXND7YJ9SMpIzkpWp0/oK/b/UnQMRzUcSFN76kJvsHwDmxDKhXw1BKnEaxbbQDkPERcdePq7HjEA4IuZJv+bD4QvH0Ohj4QvFo//jSF6fs8iXjVb0i7p8406KPooEuL4q+eSh8PNskO98mEPgpSSQswUdgdTFPS6xzP+J4jJyMvX5MngeKcqQRaXnhQHukrb+6RsGBOF8QOCN7rbjfTMzsV40wY0JD92JpIsq/HluXi+dgn2VwR11+qs9XQeZ3MFgfyBZNNawdKAq+yP6L4CofQ23+ejxETZnA/j7avMLF8uc3po6AuA/mN9Ii6LNSnbunXf9LZbdtbQrwKtcOdnPWYhvaKvvz4WaU/H+a6GPjcHAFbeZfwh09ZTxuj7d0KDFVL8VZwOMsvLInIz5hoHtriJ2mNJrFrrNBSCmN++MGzmG/yM5kxdykUrlEz7X/uVsu3cHQ314hhADu9dcwVKgtVn4WF3UQ57fR4iqEvXA8LiaGmBZDzLK4C4kbcIJyuDgDV20QkAT4AoTgrtKaieoxXK+Zb5vNlzjA0j2TcMZSqYFW56TrYCDff9KSgXZ8BQwHRdxK4YrbIbhnwEzwjK79Msfa6j1ggv3mOKNQtiHi99GN+MazYF+mMZcyx7Motf3s0gwf451Zc8F8xpY9nzUMzQHHTK7Iy0Po9INAzk0znpt7AwI1SewiF6OiWmBf3q/C1Es/lUSnxcrL00+CinjxB24WYUECsI1BD98443P8/Xoi1CIgQo8u2loYxgfApozCx547UClmjKioSmAqx3i6QqQK1/xtOBcypVOu5rV0V45u7/Rrwk+4LK9a9EcERI3XPiQbYIHWXZI7OVRPQCPbLbeC2NHxRxcCZJLL6lAoSAdbIuoU5otCqa3OfklRVUKpHBLTPgPfYtvrIf50WeZr7lZPdTSWdKgsTM5nMSTeW/hmiztoS9HtQErwEo95GqgW233BUdkNIF0hQRgSnRDXwN4AWs1cYwmQNCJvK4Zu55eVkXPE1dZNF2HZhNHlhm/3/ZEUy0PiSHKOmvdSZv+/4AZsY/huuSYa5OIw2vD34vc6aQy/TI2x4n2wCXMB3nsbzxWEbGbKgT2bg6chNAq+yvgkaxsjXVYc0NX/l5mozAzvAIt0PnyaddHrJ5ZDmZKbxjWtX3fCtesjf+QNSlFTU+M0SDCHZ+qtpkZ641FresURwcq2/AOCrhP/Yi5pd7f+z4AUpiXz8579SETwJ6fqYyZLpaHvK0GC5uio5uRxf1W5OsysKgXT/WvZyILUHbR0ppJsQAIpzVvH0/D3a6pdEw/lAz7Zhwa+YfFvp4GaWzAf9upsthDpwm4eBD+PXOkPGuQISvdSwP7sk3q343zIOtbu2jXQAgwiJAcQcDGYz9Dq6qEonRYn+Ot+ACNBdpLnteL80RXdA4YAZyFLNmf5cwSkAhzqzR4W3LqUeF8IzBhMJFBvTGvui5J/y+dnRCyJyAbqRlrOq8sMyFZLfAlvmf0plI7uJDbXodnjMEQKFfKDhnMkoX34XVS1omZZDKIo9bqY7IDzyLXcrlW+ScMZPC459s8EDN/HxzyFYhpwgIG054mp9W8PeG3Dkm1Zm0KtWqHOkpB43LNtlDfDcwj81eSucYDmY6jLXskO/jF0s6pqYwDkSCAFhYNYxNetJTuu/4tawnhDnEoon3L3mMNfwWExMFnc1oWecOFqJH/x3YC6t642aZiZggPelo35/lNJnkUexH8LA+1zTDoGwuD4S8HUjMDZIFXiY1DhA1gkrTfTUMod/HJXOCRvWHA0vFDF7eez4iavNh+DiSaRBcy6pwnGETd4CXhrkqF+H+uboS59SIEsHLMd6PVp9++DEPVJIHRhXxu1lvVDw21s3tINuDwPI3LL0p1zJgNXNPtSXo2W2z6iGyC7YXwT0pd3LzPIfxhpjfJ8muLw9aE3yOi7tscSNP4l9ixKIWss5nuMDKV6uS93PPxF8l+USNWQQ/soqFnBCF9ZAov7uJWd4LUduqopP1i5bpvqUo9tT6NAvudUqIbMVf3I7tVeMwh2oBF4C2Pk/QKskHbkEzZ48xzykoqxP6y2gkz42p3cusmd6XydkDIO0yuEbteVU/uBYLYzptbuQa08w/YN497p8QtdSpkyfwyIt7npJSSOkFhSTYoRUENpSRO4gGcxTB6Tg4pW8gRHNK1/F3hYkxmp/uaHD4bX7VXYsmvdbUAe6mRN7n4pqvrjaOdxdHDrvmkXD1RnTSVowNa0Q7gpVvGssi/gLtRElfdlu++2JI/RwJ+sULyNiIGDOVsKhuOJaeQHtk3Rx8+qkt3aul8foQ+SGDv6TNXDyZ469mQgRC6P8e0TQew+K9ci1ujgYMi00EPuQSq5K1RE/554YMYZ8+LVYKFSzPLehi1MC11O0xW0CdDAbNJiRhmGquajtEMrKm8hLaEm4tO2RwVGVf28i/UFL29cjwIVBVWFboxCSsInxCzAFingyXFYxI2kxl+SjrByXXn8xfhmk0ZpM/smy9/z/Hwir1exAX1iHdCP4z+GZsD44duNL4vIqDGOLInb1HqmMfz7th2gK1SQxtnEsd6PZRh11roDYKFQ5amQmIz05IBBPEXHoU+2WFvt9PgMzhEIFY3URypFHVDuU7Tc0w90irFauQNnLPBFox/5UOMh3JnRqsDp2DXoOUEfHmNT0gQPod6SMdDQ0VSxMoWw28TNJ12P3qE+cOYdLFiPKZFRw6d3KxcsRETkGsZhDcpbk063Y+OSbwa2ANaHhGS8MqZCM0Uff7HCfrBwpaYaC+uRcuLHLngyd9uCGVtnKhi7IKe/VmqCSVUYaTnCWmeID5cfyYVIotUFfnTnt2ub5te24HbNO9sM0SmPjYAMOl7YGAeptsZZDs9vYs93WriHCFI0aOFRFhZpOeYnhz2opX7HKpKf+B/pwNE3DhfBy0lqjfPFRK4Y3nQ07uV/JFWpwZUpNYyYKPM/IsS78AWp8sjU30DshS7YBR8+nw6R7514DIcddsPZEtsamt4BQoJNlAdak8lCtwhimFMuRyo4QgM8j2R4SaWbGAjgOqNFHF5yO9HNIB3Y69boltBGOSl/+TlkjyPsBm7osnz9i+2zUqEutdrjd4bUdjlCMwbbYHDeT14U95NpFrMqw36zFnOebT6t3T698g2NDny7fWtt6ab8IjaL21rkoasyRc2C1kdF+qt0Rmwg1i/vLlotwO90cx/Iy9k63Eh0g7tKPerTLTsj+WU07adLQ9E6o0KZjJZwZVX3qsqsSbuEVD8dhniPhcrlbDvRGZRLNLBKEGONhX5rolxIGpvF28I0gw7s/Czel/X5P559T51pjOhOCpw1Q/VTdT8ItIcfUE3iUbe7TowLwp9Fd5VwyUCb61bGVMU/szYZeN9h4U1cfYv1KbBodu7Co6Hd5f/vqMFb7Ut20R8CSA9c7bnJ+neYn0CaWFvnGHFAL3+5aVyd+pjPAFF307aFnab1KS+ljFtVxyFXgradHZAJ+wXQ9aIgf3rvSnxxVpCTQjokwk6dEIxEkzf0JSNMkhfQf6zJLO1bh14myneOnaoHs9M+OQjjj8CtOQ1fvw4C+UHvf/y7ekLHiCsYiVqMK4HGoF4j+AMLZDVKQNRHtn0wvboMhZb4dCfOoWbYtJsOE7qBXx7f2Ggxi7K+QNIO29eywZlFhQ0LaRLsJH4A9FLHRISdL6OQIXx3rKScfUaMbsvI4PkXUgvTNdY9uGBvNacp8QwbTeYnDeIWCs7zPCynVnwXld1HyeeA07Qf/UoTm6ZrMlTTqqXVeZVqdYX3Rn6Qu+kcJzeDZxfvxxqIksCNzK9v1JfzZajMHVUdq00b0SoiwVjJw1M0E5FK+OuQd6B6BHtrTEtcPRLrc70KkW/EAY3kbXPxoWhXZAMOZ//qbYPYJizntJkgbjoUBAFxe8SgkWXZtzcWEi+O0SALpzxaKhcCqTNS76hxhu3fyHxFNfPe5WrGQQ/diRQKo6gaDpT68oesNj5ZVG+YgDntrgzVlBbTfSD2VWdMZRoR5SyZEDVkhfCWCl3D6OqGUbP6QOCFBgdajMngoc9+ENqKFvSzfBeFk3rGj4j1INe2FxSZiQGBE/nWB7nGaDDCBADV/W3r2tm7QeLdvw1XoX52nydn6cbiPM6ReriMLP4nd2jdxZCQb3teytm4nJwlog0Teja8W+j05w0FxJLpaMnYgjcntrRNySExFZ1BFwStn1xClVwUKBE6emGnqe6+VoKlRS2GqudnzID4MZcdpRsADvxOuRAZ9109ezcBR3f1K3vEfj3D7IC1TB+N2NSiOrAKDZbR8o74l8pvIacDkPKzrbGwBxjasZyZ7/R9Yg94zy6mtUUNOMifuEUHvj92RbJLdVHMngAYk5za6MDqSaSI3Wsx0hM75YXGTnMDC/B5YypJje0Ed6Ts/7KbaiaeSoEcsmHe96YOKWT9kMiqWmgXNuoMNwEZWsTxLfETZPDZmR/MQ6AyfgpJxqar24YVsdiwj0Z23eZrou7W8rFahvXdOT0ETlQps7plOkV8znL0hDQRD6KGaP4FfjUKJVQNzBdJbEnyNYxIPLfkl52ntgl2imbF+gqtbbM4OpEYYschJ6mRCkyPbB4L9D/kvklO7SrobzLQjdI4qJs9rAXRBI/J7V0SzDyreGHAxhYsCA9+tBKNdDXS20i0MMZxZ0o4FyIY0x5oR1O5MTh+FJd4NFTSYr7dj3WBEwdC+w187FrPIaQAM9IjNgATVu6ugSBUPDdDJSNLGPYVP7InisGBdLaETlrXfGzCF8LOZ+JGh3ZqHGv0g35ShAj0w+KOympvwUhyIfCAl246FfhsKAnBN0scTu8fv7JXxLp/cKwI/VqT0jY2S6n4lwraGA/r0ozEEFDoPEtTxyTRrdPLYMI3U0EoPHPuGc7CCmgK9OGBbtdgQT+2vTwhkhSiQVMrD5bLcqydjstVg4pAoXqJrQraVV8IxlHLf7BC9q20uaRQd1j0DzngbKyvDv4vYdFpR6cH+FToXxLaGpQx+cT66UIUj3DVIUf/g3co003sEx43BERQv9ZUs8pIENG5AkV+J30j26fyB3lidYVFyMSPNu8HRWg0cA9tPnNPV4dt7Q9Ap0p54iwwWDjH1ijSYeNUEfzDmEeTpNcSy6U0Xw+9bizPjLzpvM4i8LuCm8sH2SfDrE8d7xD7+3V/oY7ZUqq1G+rD2tHUoEHPRdBR3MATHI6fRA1CjFEpzjapm1XVU8Heo3jueq+7MczxcZhI8DIlaEgK4B+XEu6QfXQ1uKO0A6rO33dUZDpY6HHZzgaX22Gb33za3rGe3rOjZNDLpAJ7hWhLbFJnsPPyqOqc88yIJyWB1tFDwwP6u5QmyWItsDtC22ZmIQ2bw37OCJesQgbgoPEwSfeJLIMaHm64yzvq8ERbq/woxhNKrinAmCrgmILkXui6VNq350Z3dPZ6VquHfGczRyNsCw1k9NvVryAIuk5UWGW5KsnWwb5QayZ7TgY8WUxZhGNai/2ujJ68g4GqyI420eJ4uMRaK1V5DUbwx4izpXeK4uocnD5bMa7r60+5b63KMr+Q7ZcEOAuQ/64I0qiwYwoZCfhcFr5KU7YrHxgrDcD+ragSYkc7m6jRdIzj2h0e+UPHyXaTap35+ZJw6ITJs6Fps2h2fPPQtz21UhnqQB0KQ73yCkIHnclRUhbX8O20UvCGnMouW7klswNgtq71pjZC59vumAfw4OL/T2E3nTAeWRnXVHkXd/7t4duzBPmGAia6kWZtfL5aJrTfv7QZQ2woozbautNyG3pVQH3d0ivAi87NbEOR5s0nejsGFVTd7Rqk2dX0/OwZ+ihtHsin3EmlSwd5h3q3QXiF7bp2bkxdNO/BydjbAXwf9/UPniJ/zL6bp1qjwyV7dTly2obT681p9NoiwPtcGkF31Ayil8cfR1sXoh3LhC6SLgHrZV0mvsubZQceTme8IhKy6HKgYnxthe/o0hjU1DiHWg9kEMHOBHsFqg6SJF2YPxm2oiZA/37IrUQwJrvrd19zK6Fh21KUDHOiCanp1Sgk44ZMnsGGTc2m4VW83RLl41+lYoNDA2O39C1tpcDM6EuxZFHdP4UAArCB0xaQKYU0cRpg4le/jri8EIpR0QjtR+VKYMRaBLh2Z6kOqGDjtjP2yBA3zuyJZBEBOPGqvu0zDJ40YYTMHxVQCNU4QseYV23aNCRuh9Ef+doJqxJAGrcHMd1bzoLlUI7Lo23lNsbNOK3sGu3+zFAkSw3VYggqXHsw3Q4gFFIt7jat/Bb0z5LgtXfcv298tPp/das761htElwAush3fdOWZCfmeWoL+Q28SdisddggtXgnzayuXouWYYhfJx0zMq6w6bcnj6gMBQzNGNN9vTLRYzI3tnrHWEbX+uqKdNTg2OnUReQ9LLesKSWMmX67as7vCak5/i5zlGht3M1uVCLoGSHHgnEdan5V1txaG3uaH7Usmeo1SZ6JauAIsiefylKfBMzOkHLl6m/SC+nhkjS1jsoT9nfZPFRZlPrQztMqpCt296jGfHI4GHZ5VbvVGAY+7aMDV+4mvt8MbqJxce5Dqb+saxkcby1xyVXKM4rDHuqH+BndUfcrIZCX/Md7lLLrwI3bqk1umpeTs0oGfmGqMlz0qu1Kv8UjMiW9Rx+9UDcKYxMnnxhdKuGvVLcIZa98bTliqugoRRbiEY1kj4kXhurUtyaDteJHrVt1ghGE2pfYkEPvyCSgJT3g3nwBHRXjw+YaGzIw09wsv+iSyRFO1G9C1llz8dulFsjdKQenXFSPFJEapNW135t2pqpIebxSMPUE9fpJT9dDy3dfh1F1Gzd6m1gvZwMM6BNu6YiA6qrY52neYmiGBERrpLZeOuRZGKZPnUpjQQD7GJ2gWQXeljZV4hC2lhRdoyjPpsCh+/8HbAejAwMqp7KyRmd8i/Ivi5RrbQchg5odYUsViOYAXG1KiD3/DGuuQD8dH/4Nh0jxporyEwGf/vQSlhHRBIrmRao+aGYztgJJTL/RmzyWoIDuWSkOyBCWN/BSct9qgsoYbP8YeIaOwU6UR/4DR/QCCh8mxa7txq4LsE3Q5CaNH6Dr/j/+LFgZ5Xd8gmkyn8UpsmDBBhDTmOTFnWq3yDHHoAHbSRK2bnHAVIf+VyEZAtZFN9eksZWnCbzEMX/fPCVyRIzG8lTGSXYiS2LPIu+SvhfxBTO5x7YpSEQuUSp2w+NfMkV9cd7pg3d7mh0VzT/7i0Bm0+YKHdOmN7qUyLFnp1ykz8jvc9SkAFpFvv5HVjiNiLermHW2dcDMC5XGQ0NEXUnKLV3eYRelch4fZzaPCIqLJZUIcKNRHCTNvtSnQG8bEifaegMzZe3KgxgScLoLvwiYxayEw5weeZY03otUTNy7/g/RNZKyOiLFNwejS2ZWec5Mjw5DdUoMoVkstzG2bCAGwapA59M39+AqpnJT2KEzjVme2CAGmzHBIRgQZW4r8cjhI5B7lwZ+n9mq22J9Da+q8GWgquiwdljSCVNoCIt8Q1T7ZpH0STXtH9hXpsDrCjZKqUnDVBHsGNkzMn/TtIX+Sng7Zv1JIj1jWZnlfSC1XakXo0N5ThjdDObOIjjZxqseWaQxNGKtZzYLXml4LRFCwRItB3nnQT/s3MXxMLcvmJ3B3+5d37ByKdPjUJ7pmYWK7UwYZulpgylZ0LI6a30YaF+Vkhc24VQJxnWqwGj1lc5NL1Z6N5tT/G2v3Atef7rsPgONwtzURXMnFhHNQVXoiR995LPJJMRiYb7CJU5Su5513E+rZa5h0HyOCIJA53e9bje0Tlk5qego6HxtEV7/mekQeFMbU2dKhqa7DQWioZKmC9zVLH/IhpI4ZNblkXWr4ZIs1x2Coc8nDp9uA13fNPSVfZ5ZIdjQS8lZQX/+hwqThdPp24iuaRt3jHsVPkumGrIoCCAcja5KyD4bozuAy5WIzEa4b2ubU2Prsm3yZP5Y225Mvgi2avQerEfZ7vLwtzgUDjSGxVL4Wu9NVZwhtFqA0RHpFZWA3G23kHXVnj/xnikq4L82mBBHQTxyKN2z0OS29qdeU4xBsVYE8HpIT5I5TlTfemIS5Yz7fBOAF0kPXmjZWZEGVRQP2rP/seJYCyGXqU7j2ey2Iq7kQrSNfLmD7PLG0nat/tJk6ljjlyybVkqnNS6HsjAOwfkzL9H3U172+nUTcJoZxAfeJicsjkNVebOHP/5a8/28JOMe0wD8JeUAmOZNMI1cnoAU8AgjGvipftIXQqjLkCrHXipu46id8/Uenr2vqmjQ2iJcvzmDTMU3ey5R8/iq/FEi28BeLb0t+8Hn6Iep/OHAwdkCNz6ze29vbl2MVOMuxdYf0ZpBqOPW1SLCM/+QDjkIE5hxlhoO86OmVsEiSADtaSpNglS9eqJS7esIaqb0FYgeCXmhXrC9KLZgYvoOhZhEqDrdVGzBh7268x0+MefuFP232bbPJK5ou9Y8/Qnc+wNSurRruVQPAL4d7DKoRR2siqT+Y+2rc/gmCY4z7ZoAzV2B0gZpv/mnjJO9pFl0eM1RFWbx7dXD3/r2sL7TImCksdH1DdAQ66/eo107hodnXweGkRGJG8vOjp7Cpf1td+nT8H44ap27bpe3qVXrbAtVsFLVy0AO2jgl4r0jr8lF7gZwErMt1ZAF1AZObU1nJJI362QUppE0R9yLK64MrFlBEq5mz70/2JuNccbShOpWJQNIVvQ8dVdMJQn7Tpj72Z95MqRQJjWrt0ern9PXd+Z7eLN6x8+vk06tSpiKsIA7epiQSFsIYaq+MUeHLABrO18hD3A6OsZHec+BUlBkb3V8Xfyp+lGlXil/zKLECRr0sHQrZw2Bf1qKqOek1QJ4jwHHySJcIZaHFU4Cd7TI0nmIemYutwB3SLNsTjH6+mrGKKPNY9iV2xPFeu/Hw7Bfojnh+BFU4ZuMNWFC013BTa+zIpw6irkCBvJiaPHrYKSx6ViQDJSj5IeL4mJ0lVJO8RrJwydduqDvjZ48i4zXjSmWQNdK9U2Law8k4KG+Ay/ZVeP8tDrm0UtAABI4KgVJrE6kndIAINXWRMEq01gcvdKeq2amig5GdDFJ9LmI4jV8vc5KBzNCNfjaSlk9ZG62zEvDPqPKJe9ONXcMf6i8V7bqz+ViRWZ7ry2+bi1lhuEdLETZcV+6VWBqZKHGn/GrteRSN+AgC7rqCgzBs3N8Q/F8VAT8pNOahFRnzC7XU6Y9Lm4fdd6TYmHx5Ke6iiDa/PKgV1wTwo+wrodNVuXJJ6tHVUXk8tzlfZnc5xD/lJerB5c7uspwTp1dfp2g4FHmUgDUuaYehecjNV4uvDExsy6yW5f6YCVVITUw9hqlVKwmWosL75pBNWra2rIH+8xpZitt+EHYfr6otlo5bTJ7lqn0x5bThk8mu5vTsc3VbMxm5BXsx5Te1MKtY5rVzh2JUHLeWHfxLon0QwXHQ5FxBnkWrLkorltINOWHMIJC5KU8aov4eXKfpxwy3k2aD+dWIdAOytTggYuswGOFsATErdjgCDUEgG7Y+t5EybHrU08k3U9WBZ1K1ZRoQar2vcIAybwRMwnUhH1VViUw3eNN10RNwTiRJKNUPTGLIoB6zPDa0NtG9lhkTBPJr+uKTifPdaZRzq7A/vOKKzCwVa7sT/3vRROnbdvUf3FK2nfBvXA4CBjPfmXNr3fjZUAzGTvMh9ZyVv4bgsoeq7oi2hmD8u9jL013D0Xk2oLBYyjMs0PndD+P6HqqHzzbv0n9WEv0NIQ91nwoFESPgb9qg2ohJStFCKgekyS/Br+Xl7Kh6AsrKFTVsZ0E/1V11ufbZCGYDz1I3Qbny5TsYotDqWCZHXMPKT5nkondtGGs4FOQpNJiOhXNbuspF1KWgfSizG3hfIPc4DDbrArfKl2qR4hQWPYQPDUSbwMMp3UxQMnqNhXcok7zwxc0CmaYxAxnEWH+IafWTdI7xdn8MTLydJyAt8P7l2gxpYF1O9jqf3hWg6TjmHQ69pbF8NUoIXwPukX2WDXy1pZPvySOH8RHywSV1+TdOgK1uPXtyF20AoFBcQVsWqgpX60rCeRCeIAw+jsi4fi0Rf2HwuWfZ8wLCeLOFbVjx8uEFgaW7Qc10LUFoqe4qCsLJYQYhM7jhIR/RhPZ2heHVZRahaTsoy5HG0vfYTKtJ6qc0+AHpjvaMQQthEHlxUEbEIXaFQ+ltoVkx7bJ66SAXHfL3hNTqen6MQKmiWyNGmPVTLc+0AGHUw+GNuNR4wyPBQrYRKjyMTTpW+6T7MRJ7ICba6745SgvbGRbnOsujmMxL9qmsdxa7YHlglET+xeR/yjgst2JQ9Uj2pFC3jztaTlvMcK1qXX3qReuF05eA1pTbBfDu2pG/Ff5g/uBWfldUeU1b3v+FRjZdcuSyS96W+zvDjNv/QBI+CiZtH5k7TVPkxf10tm9/+Rm/3j6mCW4ylGnS8TxoX48rkECD7+5Pn5K+GSEHob+Hk4ZfyVErYqtzSy4kxVtBxGszOqcfbpMDgc7aFrHGsdWryisdAI4SoMgmyPFREqM0B4D0DYMc+40ts/7duaW9jg+rKzo9h3viCbzqDUpTxW7Y1OPo7Smo7iEobMf2GNw0+TnLPp26Dke3hezO1Hdch5BYCISFqAoPGdiHwPnUMpN4O93B1/s8/Zjm/SFXlbrm6YTxYGX09Spo1Mjv0FvlhMUsbOXIkeImJ4k3XeBSQr0KBOauDi7Q7fGfFYPNITl39DI/9POO92C/8JMCoa4NM6lgpVhhti3NFA6XYpdI4MMWZjiyNRuvIqMZrWy3aHqTsHGYfEEUK53VCp+/mp6wju/nWgKEHCcV/0LwCkYFF8sd4jQr5Nke9aphp+si+Z6mcbNZmqeKy1E/nh6dnq4QGr+95fKxYDc5e90llGR17BOM4yol+FGYd+wtsBlbrzrxGSWCbs04YL5VUYBzwoNo9+3v/eCqn+mLdz8c5RbbKi1TEIQUqZ0M4+mD0dgvBjsm8ASbbGHvE6jEzvzA78GeSWSgTtsU/Sa688QGCK35536DRE+IX+7oJfN9Bxk6+D4CfTrJpCbCCPfLNp1urTRXNAUeKKDgGeacHdtBVAVrAddiWJG9h4LUoYr/glKrLaWR/nkReouEzD/ngiKbGbNtNyJ0js1u5qjRJLyd60DWpufzVHM2NLKrRuOdk9lt4JZTBNUOVe1A9MVvQ49tgwXXBQlGAJ1Y9GSY1u735RQugnz9v20qHSiapiT1MWvghGoiwDXedTt5qYb8vT4rPtDvSxIH4MuovWi895coMvXGbKulG2t4XKdumdX+SGhW1Jj446exj4rsFGJfgB2Q/Iuwt0Bv+J7AXARZEYZcRRJWCGDFeYm9m0Me/KIxeN/rIfRYtqn6Om8NUnLJd7w43qTk8D1wF0Z+8OG757PVHpcmF3DWE06L04HOfvkgHyphUrtPXqOVmF15I0yuojUlX+n7KX/ThzO+HFwR65DY4u1U+Dj2cvCa6YQNjylCK6gv0lCtzJJGzSVA5O797H+lHPfuP/boHyRFxQKLRuZOXNCC8PYcb853fLO/Lj4g7vDzgb7+eDSt4h49aoS+JgQFKFuDjVUmHdrkAWJkQDxO5CIVAfA4XK9fHU8QBUvWOek6pIvD0ko2bxAPZUQ8m3HIEYDAV/toXh3HiKRndBR8Fw9OgW1C1O+KlwOYUwDukZmbzMndpl/SVOONMlXXubWcYMeALn/r/I7uUfBJN8RwplDYWQ/c1DNah4FW5l2vq4HKVzN5twfppjwLzHXQaEmpd5j47uPxDRFdvxjiGhW+v4WZCS8iQ2MNVcHWCMBkwpYCmMjoD6jiBWbkA1aCm3+/In5wq6LF030NMFDnDFoPOZwL8O3f0WHpHzGELBybIukWOCzNyGytJHkTi+X4A/acS1vFZCnVrRY+AnImQ8xfNldHabCZ8S1xESfuV4S0oE0HDAiRdEw93h41+3sXVyKOMJsI0AdOatg3jEQCa7jwAeCnViRpnuLMyA0AWzhWzFpubkXhpyq6EFkKXcwEzi24R0mgVlEdltDaGWYdNZGdAKxrmkN7Ok6wfQBb/cogWzJ8wxhs/Sd5oO2t/pRms0OMFATgf4Px4nJxEYE2uGKun+/uoWOeGKKT5GWok00Z9n6XT6zd14zeDOObseN6UhKZdiPoNg8p8bg6UHV4q0xiXUNOaeAmvfv3xcvjJ"
            java.io.File r4 = new java.io.File     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.String r5 = "%s/%s.jar"
            r6 = 2
            java.lang.Object[] r7 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r7[r12] = r1     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r7[r9] = r11     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.String r5 = java.lang.String.format(r5, r7)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            boolean r5 = r4.exists()     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            if (r5 != 0) goto L_0x00f4
            com.google.ads.interactivemedia.v3.internal.zzjy r5 = r0.zzg     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            byte[] r7 = r0.zzh     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            byte[] r3 = r5.zzb(r7, r3)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r4.createNewFile()     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r5.<init>(r4)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r8 = 33
            if (r7 < r8) goto L_0x00ed
            r4.setReadOnly()     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
        L_0x00ed:
            int r7 = r3.length     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r5.write(r3, r12, r7)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r5.close()     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
        L_0x00f4:
            r0.zzx(r1, r11)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            dalvik.system.DexClassLoader r3 = new dalvik.system.DexClassLoader     // Catch:{ all -> 0x0129 }
            java.lang.String r5 = r4.getAbsolutePath()     // Catch:{ all -> 0x0129 }
            java.lang.String r7 = r1.getAbsolutePath()     // Catch:{ all -> 0x0129 }
            android.content.Context r8 = r0.zza     // Catch:{ all -> 0x0129 }
            java.lang.ClassLoader r8 = r8.getClassLoader()     // Catch:{ all -> 0x0129 }
            r3.<init>(r5, r7, r2, r8)     // Catch:{ all -> 0x0129 }
            r0.zzf = r3     // Catch:{ all -> 0x0129 }
            zzy(r4)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r0.zzw(r1, r11)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.Object[] r2 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r2[r12] = r1     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r2[r9] = r11     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.String r10 = java.lang.String.format(r10, r2)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            zzz(r10)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            com.google.ads.interactivemedia.v3.internal.zzjk r10 = new com.google.ads.interactivemedia.v3.internal.zzjk     // Catch:{ zzkj -> 0x016e }
            r10.<init>(r0)     // Catch:{ zzkj -> 0x016e }
            r0.zzo = r10     // Catch:{ zzkj -> 0x016e }
            r0.zzq = r9     // Catch:{ zzkj -> 0x016e }
            goto L_0x016e
        L_0x0129:
            r2 = move-exception
            zzy(r4)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r0.zzw(r1, r11)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.Object[] r3 = new java.lang.Object[r6]     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r3[r12] = r1     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            r3[r9] = r11     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            java.lang.String r9 = java.lang.String.format(r10, r3)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            zzz(r9)     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
            throw r2     // Catch:{ FileNotFoundException -> 0x0153, IOException -> 0x014c, zzjx -> 0x0145, NullPointerException -> 0x013e }
        L_0x013e:
            r9 = move-exception
            com.google.ads.interactivemedia.v3.internal.zzkj r10 = new com.google.ads.interactivemedia.v3.internal.zzkj     // Catch:{ zzkj -> 0x016e }
            r10.<init>(r9)     // Catch:{ zzkj -> 0x016e }
            throw r10     // Catch:{ zzkj -> 0x016e }
        L_0x0145:
            r9 = move-exception
            com.google.ads.interactivemedia.v3.internal.zzkj r10 = new com.google.ads.interactivemedia.v3.internal.zzkj     // Catch:{ zzkj -> 0x016e }
            r10.<init>(r9)     // Catch:{ zzkj -> 0x016e }
            throw r10     // Catch:{ zzkj -> 0x016e }
        L_0x014c:
            r9 = move-exception
            com.google.ads.interactivemedia.v3.internal.zzkj r10 = new com.google.ads.interactivemedia.v3.internal.zzkj     // Catch:{ zzkj -> 0x016e }
            r10.<init>(r9)     // Catch:{ zzkj -> 0x016e }
            throw r10     // Catch:{ zzkj -> 0x016e }
        L_0x0153:
            r9 = move-exception
            com.google.ads.interactivemedia.v3.internal.zzkj r10 = new com.google.ads.interactivemedia.v3.internal.zzkj     // Catch:{ zzkj -> 0x016e }
            r10.<init>(r9)     // Catch:{ zzkj -> 0x016e }
            throw r10     // Catch:{ zzkj -> 0x016e }
        L_0x015a:
            com.google.ads.interactivemedia.v3.internal.zzjx r9 = new com.google.ads.interactivemedia.v3.internal.zzjx     // Catch:{ IllegalArgumentException -> 0x0160 }
            r9.<init>(r1)     // Catch:{ IllegalArgumentException -> 0x0160 }
            throw r9     // Catch:{ IllegalArgumentException -> 0x0160 }
        L_0x0160:
            r9 = move-exception
            com.google.ads.interactivemedia.v3.internal.zzjx r10 = new com.google.ads.interactivemedia.v3.internal.zzjx     // Catch:{ zzjx -> 0x0167 }
            r10.<init>(r1, r9)     // Catch:{ zzjx -> 0x0167 }
            throw r10     // Catch:{ zzjx -> 0x0167 }
        L_0x0167:
            r9 = move-exception
            com.google.ads.interactivemedia.v3.internal.zzkj r10 = new com.google.ads.interactivemedia.v3.internal.zzkj     // Catch:{ zzkj -> 0x016e }
            r10.<init>(r9)     // Catch:{ zzkj -> 0x016e }
            throw r10     // Catch:{ zzkj -> 0x016e }
        L_0x016e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzkt.zzg(android.content.Context, java.lang.String, java.lang.String, boolean):com.google.ads.interactivemedia.v3.internal.zzkt");
    }

    /* access modifiers changed from: private */
    public final void zzv() {
        try {
            if (this.zzi == null && this.zzl) {
                AdvertisingIdClient advertisingIdClient = new AdvertisingIdClient(this.zza);
                advertisingIdClient.start();
                this.zzi = advertisingIdClient;
            }
        } catch (GooglePlayServicesNotAvailableException | GooglePlayServicesRepairableException | IOException unused) {
            this.zzi = null;
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(10:20|21|22|23|24|25|26|27|28|30) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x00c3 */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00dc A[SYNTHETIC, Splitter:B:42:0x00dc] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e3 A[SYNTHETIC, Splitter:B:46:0x00e3] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00ee A[SYNTHETIC, Splitter:B:54:0x00ee] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00f5 A[SYNTHETIC, Splitter:B:58:0x00f5] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzw(java.io.File r11, java.lang.String r12) {
        /*
            r10 = this;
            java.lang.String r12 = "test"
            java.io.File r0 = new java.io.File
            r1 = 2
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r3 = 0
            r2[r3] = r11
            r4 = 1
            java.lang.String r5 = "1678981529375"
            r2[r4] = r5
            java.lang.String r6 = "%s/%s.tmp"
            java.lang.String r2 = java.lang.String.format(r6, r2)
            r0.<init>(r2)
            boolean r2 = r0.exists()
            if (r2 == 0) goto L_0x001f
            return
        L_0x001f:
            java.io.File r2 = new java.io.File
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r3] = r11
            r1[r4] = r5
            java.lang.String r11 = "%s/%s.dex"
            java.lang.String r11 = java.lang.String.format(r11, r1)
            r2.<init>(r11)
            boolean r11 = r2.exists()
            if (r11 != 0) goto L_0x0037
            return
        L_0x0037:
            long r6 = r2.length()
            r8 = 0
            int r11 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r11 > 0) goto L_0x0042
            return
        L_0x0042:
            int r11 = (int) r6
            byte[] r11 = new byte[r11]
            r1 = 0
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00ea, all -> 0x00d7 }
            r4.<init>(r2)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00ea, all -> 0x00d7 }
            int r6 = r4.read(r11)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            if (r6 > 0) goto L_0x0058
            r4.close()     // Catch:{ IOException -> 0x0054 }
        L_0x0054:
            zzy(r2)
            return
        L_0x0058:
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r6.print(r12)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r6.print(r12)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            java.io.PrintStream r6 = java.lang.System.out     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r6.print(r12)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.ads.interactivemedia.v3.internal.zzbf r12 = com.google.ads.interactivemedia.v3.internal.zzbg.zza()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            byte[] r6 = r6.getBytes()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.ads.interactivemedia.v3.internal.zzadr r7 = com.google.ads.interactivemedia.v3.internal.zzadr.zzb     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            int r7 = r6.length     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.ads.interactivemedia.v3.internal.zzadr r6 = com.google.ads.interactivemedia.v3.internal.zzadr.zzs(r6, r3, r7)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r12.zzc(r6)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            byte[] r5 = r5.getBytes()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            int r6 = r5.length     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.ads.interactivemedia.v3.internal.zzadr r5 = com.google.ads.interactivemedia.v3.internal.zzadr.zzs(r5, r3, r6)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r12.zzd(r5)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.ads.interactivemedia.v3.internal.zzjy r5 = r10.zzg     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            byte[] r6 = r10.zzh     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            java.lang.String r11 = r5.zza(r6, r11)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            byte[] r11 = r11.getBytes()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            int r5 = r11.length     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.ads.interactivemedia.v3.internal.zzadr r5 = com.google.ads.interactivemedia.v3.internal.zzadr.zzs(r11, r3, r5)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r12.zza(r5)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            byte[] r11 = com.google.ads.interactivemedia.v3.internal.zzie.zze(r11)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            int r5 = r11.length     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.ads.interactivemedia.v3.internal.zzadr r11 = com.google.ads.interactivemedia.v3.internal.zzadr.zzs(r11, r3, r5)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r12.zzb(r11)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r0.createNewFile()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            r11.<init>(r0)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d3, all -> 0x00ce }
            com.google.ads.interactivemedia.v3.internal.zzaet r12 = r12.zzak()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00ca }
            com.google.ads.interactivemedia.v3.internal.zzbg r12 = (com.google.ads.interactivemedia.v3.internal.zzbg) r12     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00ca }
            byte[] r12 = r12.zzav()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00ca }
            int r0 = r12.length     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00ca }
            r11.write(r12, r3, r0)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00ca }
            r11.close()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00cc, all -> 0x00ca }
            r4.close()     // Catch:{ IOException -> 0x00c3 }
        L_0x00c3:
            r11.close()     // Catch:{ IOException -> 0x00c6 }
        L_0x00c6:
            zzy(r2)
            return
        L_0x00ca:
            r12 = move-exception
            goto L_0x00d1
        L_0x00cc:
            goto L_0x00d5
        L_0x00ce:
            r11 = move-exception
            r12 = r11
            r11 = r1
        L_0x00d1:
            r1 = r4
            goto L_0x00da
        L_0x00d3:
            r11 = r1
        L_0x00d5:
            r1 = r4
            goto L_0x00ec
        L_0x00d7:
            r11 = move-exception
            r12 = r11
            r11 = r1
        L_0x00da:
            if (r1 == 0) goto L_0x00e1
            r1.close()     // Catch:{ IOException -> 0x00e0 }
            goto L_0x00e1
        L_0x00e0:
        L_0x00e1:
            if (r11 == 0) goto L_0x00e6
            r11.close()     // Catch:{ IOException -> 0x00e6 }
        L_0x00e6:
            zzy(r2)
            throw r12
        L_0x00ea:
            r11 = r1
        L_0x00ec:
            if (r1 == 0) goto L_0x00f3
            r1.close()     // Catch:{ IOException -> 0x00f2 }
            goto L_0x00f3
        L_0x00f2:
        L_0x00f3:
            if (r11 == 0) goto L_0x00f8
            r11.close()     // Catch:{ IOException -> 0x00f8 }
        L_0x00f8:
            zzy(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzkt.zzw(java.io.File, java.lang.String):void");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:31|32|33|34|35|36|37) */
    /* JADX WARNING: Code restructure failed: missing block: B:49:?, code lost:
        r5.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e0, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:55:0x00e5, code lost:
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:73:?, code lost:
        r10.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cd */
    /* JADX WARNING: Missing exception handler attribute for start block: B:48:0x00dd */
    /* JADX WARNING: Removed duplicated region for block: B:56:? A[ExcHandler: zzjx | IOException | NoSuchAlgorithmException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:12:0x004b] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00ed A[SYNTHETIC, Splitter:B:61:0x00ed] */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00f4 A[SYNTHETIC, Splitter:B:65:0x00f4] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00fc A[SYNTHETIC, Splitter:B:72:0x00fc] */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0103 A[SYNTHETIC, Splitter:B:76:0x0103] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzx(java.io.File r10, java.lang.String r11) {
        /*
            r9 = this;
            java.io.File r11 = new java.io.File
            r0 = 2
            java.lang.Object[] r1 = new java.lang.Object[r0]
            r2 = 0
            r1[r2] = r10
            r3 = 1
            java.lang.String r4 = "1678981529375"
            r1[r3] = r4
            java.lang.String r5 = "%s/%s.tmp"
            java.lang.String r1 = java.lang.String.format(r5, r1)
            r11.<init>(r1)
            boolean r1 = r11.exists()
            if (r1 != 0) goto L_0x001d
            return r2
        L_0x001d:
            java.io.File r1 = new java.io.File
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r2] = r10
            r0[r3] = r4
            java.lang.String r10 = "%s/%s.dex"
            java.lang.String r10 = java.lang.String.format(r10, r0)
            r1.<init>(r10)
            boolean r10 = r1.exists()
            if (r10 != 0) goto L_0x0106
            r10 = 0
            long r5 = r11.length()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00f8, all -> 0x00e9 }
            r7 = 0
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 > 0) goto L_0x0043
            zzy(r11)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00f8, all -> 0x00e9 }
            return r2
        L_0x0043:
            int r0 = (int) r5     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00f8, all -> 0x00e9 }
            byte[] r0 = new byte[r0]     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00f8, all -> 0x00e9 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00f8, all -> 0x00e9 }
            r5.<init>(r11)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00f8, all -> 0x00e9 }
            int r6 = r5.read(r0)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            if (r6 > 0) goto L_0x005f
            java.lang.String r0 = zzd     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            java.lang.String r1 = "Cannot read the cache data."
            android.util.Log.d(r0, r1)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            zzy(r11)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            r5.close()     // Catch:{ IOException -> 0x005e }
        L_0x005e:
            return r2
        L_0x005f:
            com.google.ads.interactivemedia.v3.internal.zzaef r6 = com.google.ads.interactivemedia.v3.internal.zzaef.zza()     // Catch:{ NullPointerException -> 0x00dd, zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, zzjx | IOException | NoSuchAlgorithmException -> 0x00e5 }
            com.google.ads.interactivemedia.v3.internal.zzbg r0 = com.google.ads.interactivemedia.v3.internal.zzbg.zzc(r0, r6)     // Catch:{ NullPointerException -> 0x00dd, zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, zzjx | IOException | NoSuchAlgorithmException -> 0x00e5 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            com.google.ads.interactivemedia.v3.internal.zzadr r7 = r0.zzg()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r7 = r7.zzx()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            r6.<init>(r7)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            boolean r4 = r4.equals(r6)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            if (r4 == 0) goto L_0x00d6
            com.google.ads.interactivemedia.v3.internal.zzadr r4 = r0.zze()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r4 = r4.zzx()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            com.google.ads.interactivemedia.v3.internal.zzadr r6 = r0.zzd()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r6 = r6.zzx()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r6 = com.google.ads.interactivemedia.v3.internal.zzie.zze(r6)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            boolean r4 = java.util.Arrays.equals(r4, r6)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            if (r4 == 0) goto L_0x00d6
            com.google.ads.interactivemedia.v3.internal.zzadr r4 = r0.zzf()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r4 = r4.zzx()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            java.lang.String r6 = android.os.Build.VERSION.SDK     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r6 = r6.getBytes()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            boolean r4 = java.util.Arrays.equals(r4, r6)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            if (r4 != 0) goto L_0x00a9
            goto L_0x00d6
        L_0x00a9:
            com.google.ads.interactivemedia.v3.internal.zzjy r11 = r9.zzg     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r4 = r9.zzh     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            java.lang.String r6 = new java.lang.String     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            com.google.ads.interactivemedia.v3.internal.zzadr r0 = r0.zzd()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r0 = r0.zzx()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            r6.<init>(r0)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            byte[] r11 = r11.zzb(r4, r6)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            r1.createNewFile()     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            java.io.FileOutputStream r0 = new java.io.FileOutputStream     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            r0.<init>(r1)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            int r10 = r11.length     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d4, all -> 0x00d1 }
            r0.write(r11, r2, r10)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00d4, all -> 0x00d1 }
            r5.close()     // Catch:{ IOException -> 0x00cd }
        L_0x00cd:
            r0.close()     // Catch:{ IOException -> 0x00d0 }
        L_0x00d0:
            return r3
        L_0x00d1:
            r10 = move-exception
            r11 = r10
            goto L_0x00e3
        L_0x00d4:
            goto L_0x00e7
        L_0x00d6:
            zzy(r11)     // Catch:{ zzjx | IOException | NoSuchAlgorithmException -> 0x00e5, all -> 0x00e1 }
            r5.close()     // Catch:{ IOException -> 0x00dc }
        L_0x00dc:
            return r2
        L_0x00dd:
            r5.close()     // Catch:{ IOException -> 0x00e0 }
        L_0x00e0:
            return r2
        L_0x00e1:
            r11 = move-exception
            r0 = r10
        L_0x00e3:
            r10 = r5
            goto L_0x00eb
        L_0x00e5:
            r0 = r10
        L_0x00e7:
            r10 = r5
            goto L_0x00fa
        L_0x00e9:
            r11 = move-exception
            r0 = r10
        L_0x00eb:
            if (r10 == 0) goto L_0x00f2
            r10.close()     // Catch:{ IOException -> 0x00f1 }
            goto L_0x00f2
        L_0x00f1:
        L_0x00f2:
            if (r0 == 0) goto L_0x00f7
            r0.close()     // Catch:{ IOException -> 0x00f7 }
        L_0x00f7:
            throw r11
        L_0x00f8:
            r0 = r10
        L_0x00fa:
            if (r10 == 0) goto L_0x0101
            r10.close()     // Catch:{ IOException -> 0x0100 }
            goto L_0x0101
        L_0x0100:
        L_0x0101:
            if (r0 == 0) goto L_0x0106
            r0.close()     // Catch:{ IOException -> 0x0106 }
        L_0x0106:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.zzkt.zzx(java.io.File, java.lang.String):boolean");
    }

    private static final void zzy(File file) {
        if (!file.exists()) {
            Log.d(zzd, String.format("File %s not found. No need for deletion", new Object[]{file.getAbsolutePath()}));
            return;
        }
        file.delete();
    }

    private static final void zzz(String str) {
        zzy(new File(str));
    }

    public final int zza() {
        if (this.zzo != null) {
            return zzjk.zzd();
        }
        return Integer.MIN_VALUE;
    }

    public final Context zzb() {
        return this.zza;
    }

    public final zzbc zzc() {
        return this.zzm;
    }

    public final zzjk zzd() {
        return this.zzo;
    }

    public final zzjy zze() {
        return this.zzg;
    }

    /* access modifiers changed from: package-private */
    public final zzkm zzf() {
        return this.zzr;
    }

    public final AdvertisingIdClient zzh() {
        if (!this.zzj) {
            return null;
        }
        if (this.zzi != null) {
            return this.zzi;
        }
        Future future = this.zzk;
        if (future != null) {
            try {
                future.get(2000, TimeUnit.MILLISECONDS);
                this.zzk = null;
            } catch (InterruptedException | ExecutionException unused) {
            } catch (TimeoutException unused2) {
                this.zzk.cancel(true);
            }
        }
        return this.zzi;
    }

    public final DexClassLoader zzi() {
        return this.zzf;
    }

    public final Method zzj(String str, String str2) {
        zzmg zzmg = (zzmg) this.zzp.get(new Pair(str, str2));
        if (zzmg == null) {
            return null;
        }
        return zzmg.zza();
    }

    public final ExecutorService zzk() {
        return this.zze;
    }

    public final Future zzl() {
        return this.zzn;
    }

    /* access modifiers changed from: package-private */
    public final void zzo(int i, boolean z) {
        if (this.zzc) {
            Future<?> submit = this.zze.submit(new zzkr(this, i, true));
            if (i == 0) {
                this.zzn = submit;
            }
        }
    }

    public final boolean zzp() {
        return this.zzc;
    }

    public final boolean zzq() {
        return this.zzb;
    }

    public final boolean zzr() {
        return this.zzq;
    }

    public final boolean zzs() {
        return this.zzr.zza();
    }

    public final boolean zzt(String str, String str2, Class... clsArr) {
        Pair pair = new Pair(str, str2);
        if (this.zzp.containsKey(pair)) {
            return false;
        }
        this.zzp.put(pair, new zzmg(this, str, str2, clsArr));
        return true;
    }

    public final byte[] zzu() {
        return this.zzh;
    }
}
