package com.startapp;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.InstallSourceInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Base64;
import android.util.Log;
import android.webkit.WebView;
import com.facebook.share.internal.ShareConstants;
import com.startapp.sdk.ads.banner.banner3d.Banner3DAd;
import com.startapp.sdk.ads.banner.bannerstandard.BannerStandardAd;
import com.startapp.sdk.ads.interstitials.OverlayActivity;
import com.startapp.sdk.ads.interstitials.ReturnAd;
import com.startapp.sdk.ads.nativead.NativeAd;
import com.startapp.sdk.ads.offerWall.offerWallHtml.OfferWallAd;
import com.startapp.sdk.ads.offerWall.offerWallJson.OfferWall3DAd;
import com.startapp.sdk.ads.splash.SplashAd;
import com.startapp.sdk.ads.video.VideoEnabledAd;
import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.model.AdPreferences;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import com.umlaut.crowd.CCS;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: Sta */
public class k9 {
    public static Map<Activity, Integer> a = new WeakHashMap();
    public static volatile Intent b;
    public static volatile Boolean c;
    public static Random d;
    public static final a4 e = new a();

    /* compiled from: Sta */
    public class a implements a4 {
        public int a(int i) {
            Random random = k9.d;
            if (random == null) {
                random = new Random();
                k9.d = random;
            }
            return random.nextInt(i);
        }
    }

    /* compiled from: Sta */
    public interface b {
        void a(int i, String str);

        void a(boolean z, long j, long j2, boolean z2);
    }

    /* compiled from: Sta */
    public static class c {
        public static StackTraceElement[] a() {
            return Thread.currentThread().getStackTrace();
        }
    }

    public static String a(Drawable drawable, int i, int i2, Bitmap.Config config) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i2, config);
        Drawable mutate = drawable.mutate();
        mutate.setBounds(0, 0, i, i2);
        mutate.draw(new Canvas(createBitmap));
        e2 e2Var = new e2(i * i2);
        createBitmap.compress(Bitmap.CompressFormat.PNG, 100, e2Var);
        return new String(Base64.encode(e2Var.a(), 0, e2Var.b(), 2));
    }

    public static <T> boolean b(T t, T t2) {
        Object obj;
        boolean z = false;
        try {
            Class<?> cls = t2.getClass();
            LinkedList<Field> linkedList = new LinkedList<>();
            linkedList.addAll(Arrays.asList(cls.getDeclaredFields()));
            if (cls.getSuperclass() != null) {
                a((List<Field>) linkedList, (Class<?>) cls.getSuperclass());
            }
            for (Field field : linkedList) {
                int modifiers = field.getModifiers();
                if (!Modifier.isTransient(modifiers)) {
                    if (!Modifier.isStatic(modifiers)) {
                        field.setAccessible(true);
                        if (field.get(t) == null && (obj = field.get(t2)) != null) {
                            field.set(t, obj);
                            z = true;
                        }
                    }
                }
            }
        } catch (Exception unused) {
        }
        return z;
    }

    public static String c(Context context) {
        ComponentName component;
        Intent a2 = a(context, (String) null);
        if (a2 == null || (component = a2.getComponent()) == null) {
            return null;
        }
        return component.getClassName();
    }

    public static boolean d(Context context) {
        boolean z = false;
        try {
            ActivityInfo[] activityInfoArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
            boolean z2 = false;
            int i = 0;
            while (!z2) {
                try {
                    if (i >= activityInfoArr.length) {
                        return z2;
                    }
                    int i2 = i + 1;
                    ActivityInfo activityInfo = activityInfoArr[i];
                    if (activityInfo.name.equals(OverlayActivity.class.getName())) {
                        int i3 = activityInfo.flags & 512;
                        i = i2;
                        z2 = i3 == 0;
                    } else {
                        i = i2;
                    }
                } catch (PackageManager.NameNotFoundException | Exception unused) {
                    z = z2;
                    return z;
                }
            }
            return z2;
        } catch (PackageManager.NameNotFoundException | Exception unused2) {
            return z;
        }
    }

    public static boolean e(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        try {
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null) {
                return false;
            }
            String packageName = context.getPackageName();
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (next != null && next.importance == 100 && packageName.equals(next.processName)) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            if (!a(th, (Class<? extends Throwable>) SecurityException.class) && !a(th, (Class<? extends Throwable>) RemoteException.class)) {
                i3.a(th);
            }
        }
    }

    public static boolean f(Context context) {
        Boolean bool = c;
        if (bool != null) {
            return bool.booleanValue();
        }
        try {
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                bool = Boolean.valueOf((applicationInfo.flags & 2) != 0);
            }
        } catch (Throwable unused) {
        }
        if (bool == null) {
            bool = Boolean.FALSE;
        }
        c = bool;
        return bool.booleanValue();
    }

    public static boolean g(Context context) {
        return ComponentLocator.a(context).f().a();
    }

    public static boolean c(String str) {
        if (str == null) {
            return false;
        }
        try {
            String[] split = new URL(MetaData.k.d()).getHost().split("\\.");
            if (split.length > 1) {
                Locale locale = Locale.ENGLISH;
                return str.toLowerCase(locale).contains(split[1].toLowerCase(locale));
            }
        } catch (MalformedURLException unused) {
        }
        return false;
    }

    public static String d(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str;
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x004b */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x005f A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.Intent a(android.content.Context r8, java.lang.String r9) {
        /*
            r0 = 0
            if (r8 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.lang.String r1 = r8.getPackageName()     // Catch:{ all -> 0x0009 }
            goto L_0x000b
        L_0x0009:
            r1 = r0
        L_0x000b:
            if (r9 != 0) goto L_0x000e
            r9 = r1
        L_0x000e:
            if (r9 != 0) goto L_0x0011
            return r0
        L_0x0011:
            boolean r2 = r9.equals(r1)
            if (r2 == 0) goto L_0x0021
            android.content.Intent r2 = b
            if (r2 == 0) goto L_0x0021
            android.content.Intent r8 = new android.content.Intent
            r8.<init>(r2)
            return r8
        L_0x0021:
            java.lang.Thread r2 = java.lang.Thread.currentThread()
            android.os.Looper r3 = android.os.Looper.getMainLooper()
            java.lang.Thread r3 = r3.getThread()
            if (r2 != r3) goto L_0x0032
            r2 = 100
            goto L_0x0034
        L_0x0032:
            r2 = 5000(0x1388, double:2.4703E-320)
        L_0x0034:
            r4 = 1
            android.content.Intent[] r4 = new android.content.Intent[r4]
            r5 = 0
            r4[r5] = r0
            monitor-enter(r4)
            java.lang.Thread r6 = new java.lang.Thread     // Catch:{ all -> 0x004b }
            com.startapp.i9 r7 = new com.startapp.i9     // Catch:{ all -> 0x004b }
            r7.<init>(r4, r8, r9)     // Catch:{ all -> 0x004b }
            r6.<init>(r7)     // Catch:{ all -> 0x004b }
            r6.start()     // Catch:{ all -> 0x004b }
            r4.wait(r2)     // Catch:{ all -> 0x004b }
        L_0x004b:
            monitor-exit(r4)     // Catch:{ all -> 0x0060 }
            r8 = r4[r5]
            if (r8 == 0) goto L_0x005f
            boolean r9 = r9.equals(r1)
            if (r9 == 0) goto L_0x005e
            b = r8
            android.content.Intent r9 = new android.content.Intent
            r9.<init>(r8)
            return r9
        L_0x005e:
            return r8
        L_0x005f:
            return r0
        L_0x0060:
            r8 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0060 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.k9.a(android.content.Context, java.lang.String):android.content.Intent");
    }

    public static int b(int[] iArr) {
        int length = iArr.length;
        a4 a4Var = e;
        int[] iArr2 = new int[length];
        int[] iArr3 = new int[length];
        int i = 0;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            int i4 = iArr[i3];
            if (i4 > 0) {
                i += i4;
                i2++;
                iArr2[i2] = i - 1;
                iArr3[i2] = i3;
            }
        }
        for (int i5 = i2 + 1; i5 < length; i5++) {
            iArr2[i5] = ((i + i5) - i2) - 1;
            iArr3[i5] = -1;
        }
        int binarySearch = Arrays.binarySearch(iArr2, ((a) a4Var).a(i));
        if (binarySearch < 0) {
            binarySearch ^= -1;
        }
        return iArr3[binarySearch];
    }

    public static long e(String str) {
        long j;
        if (str == null || str.length() < 1) {
            return 0;
        }
        int length = str.length() - 1;
        long j2 = 0;
        long j3 = 0;
        char c2 = 0;
        boolean z = true;
        while (length >= 0) {
            char charAt = str.charAt(length);
            if (charAt < '0' || charAt > '9') {
                if (charAt == 'm' && c2 == 's') {
                    j3 = 1;
                    length--;
                    c2 = charAt;
                } else if (z) {
                    if (charAt == 's') {
                        j = 1000;
                    } else if (charAt == 'm') {
                        j = 60000;
                    } else if (charAt == 'h') {
                        j = CCS.a;
                    } else if (charAt == 'd') {
                        j = 86400000;
                    }
                    j3 = j;
                    z = false;
                    length--;
                    c2 = charAt;
                }
            } else if (j3 != 0) {
                j2 += ((long) (charAt - '0')) * j3;
                j3 *= 10;
                z = true;
                length--;
                c2 = charAt;
            }
            return (long) (length ^ -1);
        }
        return j2;
    }

    public static int[][] f(String str) {
        int i;
        int i2;
        ArrayList arrayList = null;
        for (String str2 : str.split(",")) {
            int indexOf = str2.indexOf("..");
            if (indexOf < 0) {
                i2 = Integer.parseInt(str2);
                i = i2;
            } else {
                String substring = str2.substring(0, indexOf);
                int parseInt = substring.length() > 0 ? Integer.parseInt(substring) : Integer.MIN_VALUE;
                String substring2 = str2.substring(indexOf + 2);
                if (substring2.length() > 0) {
                    i = Integer.parseInt(substring2);
                    i2 = parseInt;
                } else {
                    i2 = parseInt;
                    i = Integer.MAX_VALUE;
                }
            }
            if (arrayList == null) {
                arrayList = new ArrayList(2);
            }
            arrayList.add(new int[]{Math.min(i2, i), Math.max(i2, i)});
        }
        if (arrayList != null) {
            return (int[][]) arrayList.toArray(new int[0][]);
        }
        return null;
    }

    public static String b(String str) throws IOException {
        byte[] bytes = str.getBytes();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DeflaterOutputStream deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, new Deflater(9, true));
        deflaterOutputStream.write(bytes);
        deflaterOutputStream.close();
        return Base64.encodeToString(a.a(byteArrayOutputStream.toByteArray()), 10);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x002d, code lost:
        return r7.toString();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0032, code lost:
        return r7.getMessage();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0029 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String b(java.lang.Throwable r7) {
        /*
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0029 }
            r0.<init>()     // Catch:{ all -> 0x0029 }
            java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ all -> 0x0029 }
            java.util.zip.DeflaterOutputStream r2 = new java.util.zip.DeflaterOutputStream     // Catch:{ all -> 0x0029 }
            android.util.Base64OutputStream r3 = new android.util.Base64OutputStream     // Catch:{ all -> 0x0029 }
            r4 = 10
            r3.<init>(r0, r4)     // Catch:{ all -> 0x0029 }
            java.util.zip.Deflater r4 = new java.util.zip.Deflater     // Catch:{ all -> 0x0029 }
            r5 = 9
            r6 = 1
            r4.<init>(r5, r6)     // Catch:{ all -> 0x0029 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0029 }
            r1.<init>(r2)     // Catch:{ all -> 0x0029 }
            a((java.lang.Throwable) r7, (java.io.PrintWriter) r1)     // Catch:{ all -> 0x0029 }
            r1.close()     // Catch:{ all -> 0x0029 }
            java.lang.String r7 = r0.toString()     // Catch:{ all -> 0x0029 }
            return r7
        L_0x0029:
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x002e }
            return r7
        L_0x002e:
            java.lang.String r7 = r7.getMessage()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.startapp.k9.b(java.lang.Throwable):java.lang.String");
    }

    public static String a(String str, String str2, String str3) {
        int indexOf;
        int indexOf2;
        if (str == null || str2 == null || str3 == null || (indexOf = str.indexOf(str2)) == -1 || (indexOf2 = str.indexOf(str3, str2.length() + indexOf)) == -1) {
            return null;
        }
        return str.substring(str2.length() + indexOf, indexOf2);
    }

    public static int a(Activity activity, int i, boolean z) {
        if (z) {
            if (!((WeakHashMap) a).containsKey(activity)) {
                ((WeakHashMap) a).put(activity, Integer.valueOf(activity.getRequestedOrientation()));
            }
            if (i == activity.getResources().getConfiguration().orientation) {
                return a0.a(activity, i, false);
            }
            return a0.a(activity, i, true);
        } else if (!((WeakHashMap) a).containsKey(activity)) {
            return -1;
        } else {
            int intValue = ((Integer) ((WeakHashMap) a).get(activity)).intValue();
            int i2 = a0.a;
            try {
                activity.setRequestedOrientation(intValue);
            } catch (Throwable unused) {
            }
            ((WeakHashMap) a).remove(activity);
            return intValue;
        }
    }

    public static boolean b(Context context, String str) {
        if (!str.startsWith("sms:") && !str.startsWith("smsto:")) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(str));
        intent.addFlags(268435456);
        try {
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            i3.a(th);
            return false;
        }
    }

    public static <T> List<T> b(List<T> list) {
        return list != null ? Collections.unmodifiableList(list) : Collections.emptyList();
    }

    public static String b(Context context) {
        PackageManager packageManager;
        String str = null;
        try {
            packageManager = context.getPackageManager();
        } catch (Throwable unused) {
            packageManager = null;
        }
        if (packageManager == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT > 29) {
            try {
                InstallSourceInfo installSourceInfo = packageManager.getInstallSourceInfo(context.getPackageName());
                if (installSourceInfo != null) {
                    str = installSourceInfo.getInstallingPackageName();
                }
            } catch (Throwable unused2) {
            }
        }
        if (str != null) {
            return str;
        }
        try {
            return packageManager.getInstallerPackageName(context.getPackageName());
        } catch (Throwable unused3) {
            return str;
        }
    }

    public static void a(Activity activity, boolean z) {
        a(activity, activity.getResources().getConfiguration().orientation, z);
    }

    public static List<Field> a(List<Field> list, Class<?> cls) {
        list.addAll(Arrays.asList(cls.getDeclaredFields()));
        if (cls.getSuperclass() != null) {
            a(list, (Class<?>) cls.getSuperclass());
        }
        return list;
    }

    public static String a(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static boolean a(double d2) {
        if (Double.compare(d2, 0.0d) <= 0) {
            return false;
        }
        if (Double.compare(d2, 1.0d) < 0 && Math.random() >= d2) {
            return false;
        }
        return true;
    }

    public static String a(Context context) {
        ActivityInfo activityInfo;
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.MAIN");
            intent.addCategory("android.intent.category.HOME");
            ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 0);
            if (resolveActivity == null || (activityInfo = resolveActivity.activityInfo) == null) {
                return "";
            }
            String str = activityInfo.packageName;
            return str != null ? str.toLowerCase() : str;
        } catch (Exception unused) {
            return "";
        }
    }

    public static void a(WebView webView, boolean z, String str, Object... objArr) {
        if (webView != null) {
            try {
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("(");
                if (objArr != null) {
                    for (int i = 0; i < objArr.length; i++) {
                        if (!z || !(objArr[i] instanceof String)) {
                            sb.append(objArr[i]);
                        } else {
                            sb.append("\"");
                            sb.append(objArr[i]);
                            sb.append("\"");
                        }
                        if (i < objArr.length - 1) {
                            sb.append(",");
                        }
                    }
                }
                sb.append(")");
                webView.loadUrl("javascript:" + sb.toString());
            } catch (Exception unused) {
            }
        }
    }

    public static boolean a(Context context, Class<? extends Activity> cls) {
        try {
            for (ActivityInfo activityInfo : context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities) {
                if (activityInfo.name.equals(cls.getName())) {
                    return true;
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean a(WebView webView, String str) {
        try {
            webView.loadDataWithBaseURL(MetaData.k.q(), str, "text/html", "utf-8", (String) null);
            return true;
        } catch (Throwable th) {
            i3.a(th);
            return false;
        }
    }

    public static <T> boolean a(T t, T t2) {
        if (t == null) {
            return t2 == null;
        }
        return t.equals(t2);
    }

    public static String a(int... iArr) {
        int length = iArr.length;
        char[] cArr = new char[length];
        char c2 = (char) length;
        for (int i = 0; i < length; i++) {
            c2 = (char) (c2 + iArr[i]);
            cArr[i] = c2;
        }
        return new String(cArr);
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static <T> String a(Iterable<T> iterable, String str) {
        StringBuilder sb = new StringBuilder();
        boolean z = false;
        for (T next : iterable) {
            if (z) {
                sb.append(str);
            }
            sb.append(next);
            z = true;
        }
        return sb.toString();
    }

    public static StackTraceElement a(int i) {
        if (i < 0) {
            i = 0;
        }
        StackTraceElement[] a2 = c.a();
        if (a2 == null) {
            return null;
        }
        String name = c.class.getName();
        int length = a2.length;
        for (int i2 = 0; i2 < length; i2++) {
            StackTraceElement stackTraceElement = a2[i2];
            if (stackTraceElement != null && name.equals(stackTraceElement.getClassName())) {
                int i3 = i2 + 3 + i;
                if (i3 < length) {
                    return a2[i3];
                }
                return null;
            }
        }
        return null;
    }

    public static String a(StackTraceElement stackTraceElement) {
        if (stackTraceElement == null) {
            return AbstractJsonLexerKt.NULL;
        }
        return stackTraceElement.getClassName() + '.' + stackTraceElement.getMethodName() + "()";
    }

    public static List<String> a(List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (c(next)) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public static void a(Context context, int i, String str, boolean z) {
        Log.println(i, "StartAppSDK", str);
        if (z) {
            if (f(context) || a0.c(context)) {
                i3 i3Var = new i3(j3.d);
                i3Var.d = "Log for a publisher";
                i3Var.e = str;
                i3Var.a();
            }
        }
    }

    public static String a(Ad ad) {
        if (ad instanceof VideoEnabledAd) {
            VideoEnabledAd videoEnabledAd = (VideoEnabledAd) ad;
            if (videoEnabledAd.getType() == Ad.AdType.VIDEO) {
                return ShareConstants.VIDEO_URL;
            }
            return videoEnabledAd.getType() == Ad.AdType.REWARDED_VIDEO ? "REWARDED_VIDEO" : "INTERSTITIAL";
        } else if (ad instanceof ReturnAd) {
            return "RETURN";
        } else {
            if (ad instanceof OfferWallAd) {
                return "OFFER_WALL";
            }
            if (ad instanceof OfferWall3DAd) {
                return "OFFER_WALL_3D";
            }
            if (ad instanceof BannerStandardAd) {
                BannerStandardAd bannerStandardAd = (BannerStandardAd) ad;
                if (bannerStandardAd.v() == 0) {
                    return AdPreferences.TYPE_BANNER;
                }
                if (bannerStandardAd.v() == 1) {
                    return "MREC";
                }
                return bannerStandardAd.v() == 2 ? "COVER" : "BANNER_UNDEFINED";
            } else if (ad instanceof Banner3DAd) {
                return "BANNER_3D";
            } else {
                if (ad instanceof NativeAd) {
                    return "NATIVE";
                }
                return ad instanceof SplashAd ? "SPLASH" : "UNDEFINED";
            }
        }
    }

    public static boolean a(int i, int[][] iArr) {
        if (iArr != null) {
            for (int[] iArr2 : iArr) {
                if (iArr2 != null && iArr2.length > 1 && iArr2[0] <= i && i <= iArr2[1]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void a(Object obj, Throwable th) {
        if (obj.getClass().getName().startsWith("com.startapp.")) {
            i3.a(th);
        }
    }

    public static void a(Throwable th, PrintWriter printWriter) {
        String className;
        l8 l8Var = new l8(th);
        while (l8Var.hasNext()) {
            Throwable a2 = l8Var.next();
            if (l8Var.d) {
                printWriter.println('-');
            }
            printWriter.println(a2.toString().trim());
            StackTraceElement[] stackTrace = a2.getStackTrace();
            if (stackTrace != null) {
                int length = stackTrace.length;
                StackTraceElement stackTraceElement = null;
                int i = 0;
                int i2 = 0;
                boolean z = false;
                while (i < length) {
                    StackTraceElement stackTraceElement2 = stackTrace[i];
                    if (!(stackTraceElement2 == null || (className = stackTraceElement2.getClassName()) == null)) {
                        boolean z2 = i < 3;
                        boolean startsWith = className.startsWith("com.startapp.");
                        if (z2 || startsWith || z) {
                            if (i2 > 0) {
                                printWriter.print(' ');
                                printWriter.println(i2);
                                i2 = 0;
                            }
                            if (stackTraceElement != null) {
                                printWriter.print(' ');
                                printWriter.print(stackTraceElement.getClassName());
                                printWriter.print('.');
                                printWriter.print(stackTraceElement.getMethodName());
                                printWriter.println("()");
                                stackTraceElement = null;
                            }
                            printWriter.print(' ');
                            printWriter.print(stackTraceElement2.getClassName());
                            printWriter.print('.');
                            printWriter.print(stackTraceElement2.getMethodName());
                            printWriter.println("()");
                        } else {
                            if (stackTraceElement != null) {
                                i2++;
                            }
                            stackTraceElement = stackTraceElement2;
                        }
                        z = startsWith;
                    }
                    i++;
                }
                if (stackTraceElement != null) {
                    i2++;
                }
                if (i2 > 0) {
                    printWriter.print(' ');
                    printWriter.println(i2);
                }
            }
        }
    }

    public static StackTraceElement a(Throwable th) {
        String className;
        Throwable th2 = th;
        while (true) {
            StackTraceElement stackTraceElement = null;
            if (th2 == null) {
                return null;
            }
            StackTraceElement[] stackTrace = th.getStackTrace();
            if (stackTrace != null) {
                int length = stackTrace.length;
                int i = 0;
                while (true) {
                    if (i < length) {
                        StackTraceElement stackTraceElement2 = stackTrace[i];
                        if (stackTraceElement2 != null && (className = stackTraceElement2.getClassName()) != null && className.startsWith("com.startapp.")) {
                            stackTraceElement = stackTraceElement2;
                            break;
                        }
                        i++;
                    } else {
                        break;
                    }
                }
            }
            if (stackTraceElement != null) {
                return stackTraceElement;
            }
            th2 = th2.getCause();
        }
    }

    public static boolean a(Throwable th, Class<? extends Throwable> cls) {
        while (th != null) {
            if (cls.isInstance(th)) {
                return true;
            }
            th = th.getCause();
        }
        return false;
    }

    public static long a() {
        return SystemClock.elapsedRealtimeNanos();
    }
}
