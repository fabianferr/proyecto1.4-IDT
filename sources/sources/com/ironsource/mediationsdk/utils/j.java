package com.ironsource.mediationsdk.utils;

import android.content.Context;
import android.text.TextUtils;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.InterstitialPlacement;
import com.ironsource.mediationsdk.model.Placement;
import com.ironsource.mediationsdk.model.e;
import com.ironsource.mediationsdk.model.m;
import com.ironsource.mediationsdk.model.n;
import java.util.Calendar;
import java.util.Map;
import java.util.TimeZone;

public class j {
    private final int a;
    private final String b;
    private final Map<String, Object> c;
    private final long d;
    private final String e;

    /* renamed from: com.ironsource.mediationsdk.utils.j$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.ironsource.mediationsdk.model.n[] r0 = com.ironsource.mediationsdk.model.n.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.ironsource.mediationsdk.model.n r1 = com.ironsource.mediationsdk.model.n.PER_DAY     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.ironsource.mediationsdk.model.n r1 = com.ironsource.mediationsdk.model.n.PER_HOUR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.ironsource.mediationsdk.utils.j.AnonymousClass1.<clinit>():void");
        }
    }

    public enum a {
        ;
        
        public static final int a = 1;
        public static final int b = 2;
        public static final int c = 3;
        public static final int d = 4;

        static {
            e = new int[]{1, 2, 3, 4};
        }

        public static int[] a() {
            return (int[]) e.clone();
        }
    }

    public j(int i, String str, Map<String, Object> map, long j, String str2) {
        this.a = i;
        this.b = str;
        this.c = map;
        this.d = j;
        this.e = str2;
    }

    private static int a(Context context, String str, String str2) {
        long currentTimeMillis = System.currentTimeMillis();
        if (!IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, "CappingManager.IS_DELIVERY_ENABLED", str2), true)) {
            return a.a;
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, "CappingManager.IS_PACING_ENABLED", str2), false)) {
            if (currentTimeMillis - IronSourceUtils.getLongFromSharedPrefs(context, a(str, "CappingManager.TIME_OF_THE_PREVIOUS_SHOW", str2), 0) < ((long) (IronSourceUtils.getIntFromSharedPrefs(context, a(str, "CappingManager.SECONDS_BETWEEN_SHOWS", str2), 0) * 1000))) {
                return a.c;
            }
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, "CappingManager.IS_CAPPING_ENABLED", str2), false)) {
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, a(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), 0);
            String a2 = a(str, "CappingManager.CURRENT_NUMBER_OF_SHOWS", str2);
            int intFromSharedPrefs2 = IronSourceUtils.getIntFromSharedPrefs(context, a2, 0);
            String a3 = a(str, "CappingManager.CAPPING_TIME_THRESHOLD", str2);
            if (currentTimeMillis >= IronSourceUtils.getLongFromSharedPrefs(context, a3, 0)) {
                IronSourceUtils.saveIntToSharedPrefs(context, a2, 0);
                IronSourceUtils.saveLongToSharedPrefs(context, a3, 0);
            } else if (intFromSharedPrefs2 >= intFromSharedPrefs) {
                return a.b;
            }
        }
        return a.d;
    }

    private static long a(n nVar) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        int i = AnonymousClass1.a[nVar.ordinal()];
        if (i == 1) {
            instance.set(14, 0);
            instance.set(13, 0);
            instance.set(12, 0);
            instance.set(11, 0);
            instance.add(6, 1);
        } else if (i == 2) {
            instance.set(14, 0);
            instance.set(13, 0);
            instance.set(12, 0);
            instance.add(11, 1);
        }
        return instance.getTimeInMillis();
    }

    private static String a(IronSource.AD_UNIT ad_unit) {
        return ad_unit == IronSource.AD_UNIT.REWARDED_VIDEO ? IronSourceConstants.REWARDED_VIDEO_AD_UNIT : ad_unit == IronSource.AD_UNIT.INTERSTITIAL ? IronSourceConstants.INTERSTITIAL_AD_UNIT : ad_unit == IronSource.AD_UNIT.BANNER ? IronSourceConstants.BANNER_AD_UNIT : ad_unit == IronSource.AD_UNIT.NATIVE_AD ? IronSourceConstants.NATIVE_AD_UNIT : ad_unit.toString();
    }

    private static String a(String str, String str2, String str3) {
        return str + "_" + str2 + "_" + str3;
    }

    public static synchronized void a(Context context, InterstitialPlacement interstitialPlacement) {
        synchronized (j.class) {
            if (context != null) {
                m placementAvailabilitySettings = interstitialPlacement.getPlacementAvailabilitySettings();
                if (placementAvailabilitySettings != null) {
                    a(context, IronSourceConstants.INTERSTITIAL_AD_UNIT, interstitialPlacement.getPlacementName(), placementAvailabilitySettings);
                }
            }
        }
    }

    public static synchronized void a(Context context, Placement placement) {
        synchronized (j.class) {
            if (context != null) {
                m placementAvailabilitySettings = placement.getPlacementAvailabilitySettings();
                if (placementAvailabilitySettings != null) {
                    a(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, placement.getPlacementName(), placementAvailabilitySettings);
                }
            }
        }
    }

    public static synchronized void a(Context context, e eVar) {
        synchronized (j.class) {
            if (context != null) {
                m placementAvailabilitySettings = eVar.getPlacementAvailabilitySettings();
                if (placementAvailabilitySettings != null) {
                    a(context, IronSourceConstants.BANNER_AD_UNIT, eVar.getPlacementName(), placementAvailabilitySettings);
                }
            }
        }
    }

    public static synchronized void a(Context context, com.ironsource.mediationsdk.model.j jVar) {
        synchronized (j.class) {
            if (context != null) {
                m placementAvailabilitySettings = jVar.getPlacementAvailabilitySettings();
                if (placementAvailabilitySettings != null) {
                    a(context, IronSourceConstants.NATIVE_AD_UNIT, jVar.getPlacementName(), placementAvailabilitySettings);
                }
            }
        }
    }

    private static void a(Context context, String str, String str2, m mVar) {
        boolean z = mVar.a;
        IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, "CappingManager.IS_DELIVERY_ENABLED", str2), z);
        if (z) {
            boolean z2 = mVar.b;
            IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, "CappingManager.IS_CAPPING_ENABLED", str2), z2);
            if (z2) {
                IronSourceUtils.saveIntToSharedPrefs(context, a(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), mVar.e);
                IronSourceUtils.saveStringToSharedPrefs(context, a(str, "CappingManager.CAPPING_TYPE", str2), mVar.d.toString());
            }
            boolean z3 = mVar.c;
            IronSourceUtils.saveBooleanToSharedPrefs(context, a(str, "CappingManager.IS_PACING_ENABLED", str2), z3);
            if (z3) {
                IronSourceUtils.saveIntToSharedPrefs(context, a(str, "CappingManager.SECONDS_BETWEEN_SHOWS", str2), mVar.f);
            }
        }
    }

    public static synchronized boolean a(Context context, String str) {
        int a2;
        int i;
        synchronized (j.class) {
            a2 = a(context, IronSourceConstants.INTERSTITIAL_AD_UNIT, str);
            i = a.d;
        }
        return a2 != i;
    }

    public static synchronized boolean a(Context context, String str, IronSource.AD_UNIT ad_unit) {
        int a2;
        int i;
        synchronized (j.class) {
            a2 = a(context, a(ad_unit), str);
            i = a.d;
        }
        return a2 != i;
    }

    public static synchronized int b(Context context, InterstitialPlacement interstitialPlacement) {
        synchronized (j.class) {
            if (!(context == null || interstitialPlacement == null)) {
                if (interstitialPlacement.getPlacementAvailabilitySettings() != null) {
                    int a2 = a(context, IronSourceConstants.INTERSTITIAL_AD_UNIT, interstitialPlacement.getPlacementName());
                    return a2;
                }
            }
            int i = a.d;
            return i;
        }
    }

    public static synchronized int b(Context context, Placement placement) {
        synchronized (j.class) {
            if (!(context == null || placement == null)) {
                if (placement.getPlacementAvailabilitySettings() != null) {
                    int a2 = a(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, placement.getPlacementName());
                    return a2;
                }
            }
            int i = a.d;
            return i;
        }
    }

    public static synchronized void b(Context context, String str, IronSource.AD_UNIT ad_unit) {
        synchronized (j.class) {
            b(context, a(ad_unit), str);
        }
    }

    private static void b(Context context, String str, String str2) {
        n nVar;
        int i = 0;
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, "CappingManager.IS_PACING_ENABLED", str2), false)) {
            IronSourceUtils.saveLongToSharedPrefs(context, a(str, "CappingManager.TIME_OF_THE_PREVIOUS_SHOW", str2), System.currentTimeMillis());
        }
        if (IronSourceUtils.getBooleanFromSharedPrefs(context, a(str, "CappingManager.IS_CAPPING_ENABLED", str2), false)) {
            IronSourceUtils.getIntFromSharedPrefs(context, a(str, "CappingManager.MAX_NUMBER_OF_SHOWS", str2), 0);
            String a2 = a(str, "CappingManager.CURRENT_NUMBER_OF_SHOWS", str2);
            int intFromSharedPrefs = IronSourceUtils.getIntFromSharedPrefs(context, a2, 0);
            if (intFromSharedPrefs == 0) {
                String stringFromSharedPrefs = IronSourceUtils.getStringFromSharedPrefs(context, a(str, "CappingManager.CAPPING_TYPE", str2), n.PER_DAY.toString());
                n[] values = n.values();
                int length = values.length;
                while (true) {
                    if (i >= length) {
                        nVar = null;
                        break;
                    }
                    nVar = values[i];
                    if (nVar.c.equals(stringFromSharedPrefs)) {
                        break;
                    }
                    i++;
                }
                IronSourceUtils.saveLongToSharedPrefs(context, a(str, "CappingManager.CAPPING_TIME_THRESHOLD", str2), a(nVar));
            }
            IronSourceUtils.saveIntToSharedPrefs(context, a2, intFromSharedPrefs + 1);
        }
    }

    public static synchronized boolean b(Context context, String str) {
        int a2;
        int i;
        synchronized (j.class) {
            a2 = a(context, IronSourceConstants.BANNER_AD_UNIT, str);
            i = a.d;
        }
        return a2 != i;
    }

    public static synchronized boolean c(Context context, String str) {
        int a2;
        int i;
        synchronized (j.class) {
            a2 = a(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, str);
            i = a.d;
        }
        return a2 != i;
    }

    public static synchronized void d(Context context, String str) {
        synchronized (j.class) {
            b(context, IronSourceConstants.INTERSTITIAL_AD_UNIT, str);
        }
    }

    public static synchronized void e(Context context, String str) {
        synchronized (j.class) {
            b(context, IronSourceConstants.REWARDED_VIDEO_AD_UNIT, str);
        }
    }

    public static synchronized void f(Context context, String str) {
        synchronized (j.class) {
            if (!TextUtils.isEmpty(str)) {
                b(context, IronSourceConstants.BANNER_AD_UNIT, str);
            }
        }
    }

    public int a() {
        return this.a;
    }

    public String b() {
        return this.b;
    }

    public Map<String, Object> c() {
        return this.c;
    }

    public long d() {
        return this.d;
    }

    public String e() {
        return this.e;
    }
}
