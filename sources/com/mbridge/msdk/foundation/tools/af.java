package com.mbridge.msdk.foundation.tools;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.ImageView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.c.a;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.db.g;
import com.mbridge.msdk.foundation.db.h;
import com.mbridge.msdk.foundation.db.j;
import com.mbridge.msdk.foundation.db.k;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.net.g.d;
import com.mbridge.msdk.foundation.tools.q;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: SameTool */
public final class af extends j {
    private static char[] a = {'A', 'p', 'p', 'l', 'i', 'c', 'a', 't', 'i', 'o', 'n', 'I', 'n', 'f', 'o'};
    private static char[] b = {'.', 'X'};
    private static int c = 0;
    private static int d = 1;
    private static int e = 2;
    private static int f = 3;
    private static int g = 0;
    private static int h = 7;
    private static int i = 14;
    private static int j = 19;
    private static int k = 16;
    private static int l = 26;
    private static String m = "[一-龥]";
    private static Pattern n = Pattern.compile("[一-龥]");
    private static int o = 1;
    private static boolean p = true;
    private static Map<String, String> q;
    private static Map<String, String> r;
    private static volatile Boolean s = null;

    public static int b(int i2) {
        if ((i2 > 100 && i2 < 199) || i2 == 2) {
            return 1;
        }
        if ((i2 <= 200 || i2 >= 299) && i2 != 4) {
            return (i2 <= 500 || i2 >= 599) ? -1 : 5;
        }
        return 2;
    }

    public static <T extends String> boolean a(T t) {
        return t == null || t.length() == 0;
    }

    public static <T extends String> boolean b(T t) {
        return t != null && t.length() > 0;
    }

    public static boolean b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !"wifi".equals(activeNetworkInfo.getTypeName().toLowerCase(Locale.US))) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean c(Context context) {
        try {
            if (((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo() != null) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean d(Context context) {
        if (context == null) {
            return false;
        }
        try {
            NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                aa.b("SameTools", "isNetworkAvailable", e2);
            }
            return false;
        }
    }

    public static boolean a(CampaignEx campaignEx) {
        if (campaignEx != null) {
            return !TextUtils.isEmpty(campaignEx.getDeepLinkURL());
        }
        return false;
    }

    public static float e(Context context) {
        if (context == null) {
            return 2.5f;
        }
        try {
            float f2 = context.getResources().getDisplayMetrics().density;
            if (f2 == 0.0f) {
                return 2.5f;
            }
            return f2;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 2.5f;
        }
    }

    public static int a(Context context, float f2) {
        float f3 = 2.5f;
        if (context != null) {
            try {
                float f4 = context.getResources().getDisplayMetrics().density;
                if (f4 != 0.0f) {
                    f3 = f4;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    public static int b(Context context, float f2) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return 0;
        }
        return (int) ((f2 * resources.getDisplayMetrics().density) + 0.5f);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001d, code lost:
        if (r2 != null) goto L_0x001f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002a, code lost:
        if (r2 != null) goto L_0x001f;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0026 A[SYNTHETIC, Splitter:B:19:0x0026] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long a(java.io.File r4) throws java.lang.Exception {
        /*
            r0 = 0
            r2 = 0
            boolean r3 = r4.exists()     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            if (r3 == 0) goto L_0x001a
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            r3.<init>(r4)     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
            int r4 = r3.available()     // Catch:{ Exception -> 0x0018, all -> 0x0015 }
            long r0 = (long) r4
            r2 = r3
            goto L_0x001d
        L_0x0015:
            r4 = move-exception
            r2 = r3
            goto L_0x0024
        L_0x0018:
            r2 = r3
            goto L_0x002a
        L_0x001a:
            r4.createNewFile()     // Catch:{ Exception -> 0x002a, all -> 0x0023 }
        L_0x001d:
            if (r2 == 0) goto L_0x002d
        L_0x001f:
            r2.close()     // Catch:{ Exception -> 0x002d }
            goto L_0x002d
        L_0x0023:
            r4 = move-exception
        L_0x0024:
            if (r2 == 0) goto L_0x0029
            r2.close()     // Catch:{ Exception -> 0x0029 }
        L_0x0029:
            throw r4
        L_0x002a:
            if (r2 == 0) goto L_0x002d
            goto L_0x001f
        L_0x002d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.af.a(java.io.File):long");
    }

    public static int f(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField("status_bar_height").get(cls.newInstance()).toString()));
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static float g(Context context) {
        return (float) context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int a() {
        int i2 = o;
        o = i2 + 1;
        return i2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c A[Catch:{ Exception -> 0x005f }, LOOP:0: B:17:0x004a->B:18:0x004c, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(int r6) {
        /*
            java.lang.String r0 = ""
            com.mbridge.msdk.c.f r1 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x005f }
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x005f }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x005f }
            com.mbridge.msdk.c.e r1 = r1.b(r2)     // Catch:{ Exception -> 0x005f }
            if (r1 != 0) goto L_0x001c
            com.mbridge.msdk.c.f r1 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x005f }
            com.mbridge.msdk.c.e r1 = r1.b()     // Catch:{ Exception -> 0x005f }
        L_0x001c:
            org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ Exception -> 0x005f }
            r2.<init>()     // Catch:{ Exception -> 0x005f }
            if (r1 == 0) goto L_0x0054
            int r1 = r1.X()     // Catch:{ Exception -> 0x005f }
            r3 = 1
            if (r1 != r3) goto L_0x0054
            com.mbridge.msdk.foundation.controller.b r1 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x005f }
            android.content.Context r1 = r1.g()     // Catch:{ Exception -> 0x005f }
            com.mbridge.msdk.foundation.db.h r1 = com.mbridge.msdk.foundation.db.h.a((android.content.Context) r1)     // Catch:{ Exception -> 0x005f }
            com.mbridge.msdk.foundation.db.k r1 = com.mbridge.msdk.foundation.db.k.a((com.mbridge.msdk.foundation.db.g) r1)     // Catch:{ Exception -> 0x005f }
            long[] r1 = r1.a()     // Catch:{ Exception -> 0x005f }
            if (r1 == 0) goto L_0x0054
            int r3 = r1.length     // Catch:{ Exception -> 0x005f }
            if (r3 <= r6) goto L_0x0049
            if (r6 != 0) goto L_0x0046
            goto L_0x0049
        L_0x0046:
            int r6 = r3 - r6
            goto L_0x004a
        L_0x0049:
            r6 = 0
        L_0x004a:
            if (r6 >= r3) goto L_0x0054
            r4 = r1[r6]     // Catch:{ Exception -> 0x005f }
            r2.put(r4)     // Catch:{ Exception -> 0x005f }
            int r6 = r6 + 1
            goto L_0x004a
        L_0x0054:
            int r6 = r2.length()     // Catch:{ Exception -> 0x005f }
            if (r6 <= 0) goto L_0x0063
            java.lang.String r0 = a((org.json.JSONArray) r2)     // Catch:{ Exception -> 0x005f }
            goto L_0x0063
        L_0x005f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0063:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.af.a(int):java.lang.String");
    }

    public static String a(JSONArray jSONArray) {
        if (jSONArray == null) {
            return "";
        }
        e b2 = f.a().b(b.d().h());
        if (b2 == null) {
            b2 = f.a().b();
        }
        int P = b2.P();
        if (jSONArray.length() <= P) {
            return jSONArray.toString();
        }
        JSONArray jSONArray2 = new JSONArray();
        for (int i2 = 0; i2 < P; i2++) {
            try {
                jSONArray2.put(jSONArray.get(i2));
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray2.toString();
    }

    public static boolean a(String str, Context context) {
        try {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean b(CampaignEx campaignEx) {
        if (campaignEx != null) {
            try {
                return campaignEx.getRetarget_offer() == 1;
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static double c(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                return Double.parseDouble(str);
            }
            return 0.0d;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    public static int a(Object obj) {
        if (obj == null) {
            return 0;
        }
        try {
            if (obj instanceof String) {
                return Integer.parseInt((String) obj);
            }
            return 0;
        } catch (Throwable th) {
            aa.b("SameTools", th.getMessage(), th);
            return 0;
        }
    }

    public static double a(Double d2) {
        try {
            String format = new DecimalFormat("0.00", DecimalFormatSymbols.getInstance(Locale.US)).format(d2);
            if (ak.b(format)) {
                return Double.parseDouble(format);
            }
            return 0.0d;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0.0d;
        }
    }

    private static DisplayMetrics n(Context context) {
        if (context == null) {
            return null;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getRealMetrics(displayMetrics);
            return displayMetrics;
        } catch (Throwable th) {
            th.printStackTrace();
            return context.getResources().getDisplayMetrics();
        }
    }

    public static int h(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return n(context).heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int i(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return n(context).widthPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int j(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().widthPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static int k(Context context) {
        if (context == null) {
            return 0;
        }
        try {
            return context.getResources().getDisplayMetrics().heightPixels;
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static void a(View view) {
        if (view != null) {
            try {
                view.setSystemUiVisibility(4102);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static int l(Context context) {
        if (context != null) {
            return 0;
        }
        try {
            if (context.getResources().getIdentifier("config_showNavigationBar", "bool", "android") != 0) {
                return context.getResources().getDimensionPixelSize(context.getResources().getIdentifier("navigation_bar_height", "dimen", "android"));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return 0;
    }

    public static void a(ImageView imageView) {
        if (imageView != null) {
            try {
                imageView.setImageResource(0);
                imageView.setImageDrawable((Drawable) null);
                imageView.setImageURI((Uri) null);
                imageView.setImageBitmap((Bitmap) null);
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    }

    public static List<String> b(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        try {
            if (jSONArray.length() <= 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String optString = jSONArray.optString(i2);
                if (ak.b(optString)) {
                    arrayList.add(optString);
                }
            }
            return arrayList;
        } catch (Throwable th) {
            aa.b("SameTools", th.getMessage(), th);
            return null;
        }
    }

    public static String d(String str) {
        try {
            if (ak.b(str)) {
                return URLEncoder.encode(str, "utf-8");
            }
            return "";
        } catch (Throwable th) {
            aa.b("SameTools", th.getMessage(), th);
            return "";
        }
    }

    public static boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static String c() {
        String str;
        try {
            str = UUID.randomUUID().toString() + System.currentTimeMillis();
        } catch (Throwable th) {
            th.printStackTrace();
            str = "";
        }
        if (!ak.a(str)) {
            return str;
        }
        return System.currentTimeMillis() + "";
    }

    public static int m(Context context) {
        PackageInfo packageInfo;
        if (context == null) {
            return 0;
        }
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                packageInfo = WebView.getCurrentWebViewPackage();
            } else {
                packageInfo = context.getPackageManager().getPackageInfo("com.google.android.webview", 1);
            }
            e b2 = f.a().b(b.d().h());
            if (b2 == null) {
                b2 = f.a().b();
            }
            if (packageInfo == null || TextUtils.isEmpty(packageInfo.versionName) || !packageInfo.versionName.equals("77.0.3865.92")) {
                return b2.aF();
            }
            return 5;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static JSONArray a(Context context, String str) {
        JSONArray jSONArray = new JSONArray();
        try {
            e b2 = f.a().b(b.d().h());
            if (b2 == null) {
                b2 = f.a().b();
            }
            if (b2 != null && b2.X() == 1) {
                aa.b("SameTools", "fqci cfc:" + b2.X());
                long[] a2 = k.a((g) h.a(context)).a();
                if (a2 != null) {
                    for (long put : a2) {
                        aa.b("SameTools", "cfc campaignIds:" + a2);
                        jSONArray.put(put);
                    }
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONArray;
    }

    public static String b(Context context, String str) {
        String str2 = "";
        try {
            JSONArray a2 = a(context, str);
            if (a2.length() > 0) {
                str2 = a(a2);
            }
            aa.b("SameTools", "get excludes:" + str2);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return str2;
    }

    public static void a(String str, CampaignEx campaignEx, int i2) {
        if (!TextUtils.isEmpty(str) && campaignEx != null && b.d().g() != null) {
            j a2 = j.a((g) h.a(b.d().g()));
            com.mbridge.msdk.foundation.entity.f fVar = new com.mbridge.msdk.foundation.entity.f();
            fVar.a(System.currentTimeMillis());
            fVar.b(str);
            fVar.a(campaignEx.getId());
            fVar.a(i2);
            a2.a(fVar);
        }
    }

    public static synchronized boolean c(Context context, String str) {
        boolean z;
        synchronized (af.class) {
            z = false;
            if (context != null) {
                if (!TextUtils.isEmpty(str)) {
                    try {
                        if (b(str, context) != null) {
                            z = true;
                        }
                    } catch (Exception unused) {
                    }
                }
            }
        }
        return z;
    }

    public static boolean d() {
        if (TextUtils.isEmpty(b.d().i())) {
            return false;
        }
        try {
            Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory");
            Class.forName("com.tencent.mm.opensdk.modelbiz.WXLaunchMiniProgram");
            return true;
        } catch (ClassNotFoundException e2) {
            aa.d("SameTools", e2.getMessage());
            return false;
        }
    }

    public static Object e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return Class.forName("com.tencent.mm.opensdk.openapi.WXAPIFactory").getMethod("createWXAPI", new Class[]{Context.class, String.class}).invoke((Object) null, new Object[]{b.d().g(), str});
        } catch (ClassNotFoundException e2) {
            aa.d("SameTools", e2.getMessage());
            return null;
        } catch (NoSuchMethodException e3) {
            aa.d("SameTools", e3.getMessage());
            return null;
        } catch (IllegalAccessException e4) {
            aa.d("SameTools", e4.getMessage());
            return null;
        } catch (InvocationTargetException e5) {
            aa.d("SameTools", e5.getMessage());
            return null;
        }
    }

    public static int e() {
        try {
            return ((Integer) Class.forName("com.tencent.mm.opensdk.constants.Build").getField("SDK_INT").get((Object) null)).intValue();
        } catch (Throwable th) {
            aa.d("SameTools", th.getMessage());
            return 0;
        }
    }

    public static int f(String str) {
        try {
            return ((Integer) Class.forName("com.tencent.mm.opensdk.openapi.IWXAPI").getMethod("getWXAppSupportAPI", new Class[0]).invoke(w.b(str), new Object[0])).intValue();
        } catch (Throwable th) {
            aa.d("SameTools", th.getMessage());
            return 0;
        }
    }

    private static Object b(String str, Context context) {
        try {
            return Class.forName(String.valueOf(c(c))).getMethod(String.valueOf(c(e)), new Class[]{String.class, Integer.TYPE}).invoke(Class.forName(String.valueOf(c(d))).getMethod(String.valueOf(c(f)), new Class[0]).invoke(context, new Object[0]), new Object[]{str, 8192});
        } catch (Exception unused) {
            return null;
        }
    }

    private static final char[] c(int i2) {
        StringBuilder sb;
        if (i2 == 0) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(ae.b, h)));
            sb.append(b[g]);
            sb.append(String.valueOf(Arrays.copyOfRange(ae.b, h, i)));
            sb.append(b[g]);
            sb.append(String.valueOf(Arrays.copyOfRange(ae.b, i, k)));
            sb.append(b[g]);
            sb.append(String.valueOf(ad.c));
        } else if (i2 == 1) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOf(ae.b, h)));
            sb.append(b[g]);
            sb.append(String.valueOf(Arrays.copyOfRange(ae.b, h, i)));
            sb.append(b[g]);
            sb.append(String.valueOf(Arrays.copyOfRange(ae.b, j, l)));
        } else if (i2 == 2) {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(ae.b, k, j)));
            sb.append(String.valueOf(a));
        } else if (i2 != 3) {
            sb = null;
        } else {
            sb = new StringBuilder();
            sb.append(String.valueOf(Arrays.copyOfRange(ae.b, k, j)));
            sb.append(String.valueOf(ad.c));
        }
        return sb.toString().toCharArray();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r2 = new java.lang.StringBuilder("&rtins_type=");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        r2.append(0);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0025 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0042 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.lang.String a(java.lang.String r2, android.content.Context r3, java.lang.String r4) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.af> r0 = com.mbridge.msdk.foundation.tools.af.class
            monitor-enter(r0)
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x0025 }
            java.util.Set r2 = r2.getQueryParameterNames()     // Catch:{ Exception -> 0x0025 }
            if (r2 == 0) goto L_0x001b
            int r2 = r2.size()     // Catch:{ Exception -> 0x0025 }
            if (r2 <= 0) goto L_0x001b
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch:{ Exception -> 0x0025 }
            goto L_0x002c
        L_0x001b:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = "?rtins_type="
            r2.<init>(r1)     // Catch:{ Exception -> 0x0025 }
            goto L_0x002c
        L_0x0023:
            r2 = move-exception
            goto L_0x004b
        L_0x0025:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0023 }
            java.lang.String r1 = "&rtins_type="
            r2.<init>(r1)     // Catch:{ all -> 0x0023 }
        L_0x002c:
            r1 = 0
            java.lang.Object r3 = b((java.lang.String) r4, (android.content.Context) r3)     // Catch:{ Exception -> 0x0042 }
            r4 = 1
            if (r3 == 0) goto L_0x0036
            r3 = 1
            goto L_0x0037
        L_0x0036:
            r3 = 0
        L_0x0037:
            if (r3 == 0) goto L_0x003d
            r2.append(r4)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0045
        L_0x003d:
            r3 = 2
            r2.append(r3)     // Catch:{ Exception -> 0x0042 }
            goto L_0x0045
        L_0x0042:
            r2.append(r1)     // Catch:{ all -> 0x0023 }
        L_0x0045:
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0023 }
            monitor-exit(r0)
            return r2
        L_0x004b:
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.af.a(java.lang.String, android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:2|3|4|5|6|7|8) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String a(android.content.Context r2, java.lang.String r3, java.lang.String r4) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.af> r0 = com.mbridge.msdk.foundation.tools.af.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0015 }
            r1.<init>(r4)     // Catch:{ all -> 0x0015 }
            java.lang.String r2 = a((java.lang.String) r4, (android.content.Context) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x000f }
            r1.append(r2)     // Catch:{ Exception -> 0x000f }
        L_0x000f:
            java.lang.String r2 = r1.toString()     // Catch:{ all -> 0x0015 }
            monitor-exit(r0)
            return r2
        L_0x0015:
            r2 = move-exception
            monitor-exit(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.af.a(android.content.Context, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:62:0x012a, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized java.lang.String g(java.lang.String r9) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.af> r0 = com.mbridge.msdk.foundation.tools.af.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0135 }
            r1.<init>()     // Catch:{ Exception -> 0x0135 }
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0135 }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x0135 }
            r1.append(r2)     // Catch:{ Exception -> 0x0135 }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ Exception -> 0x0135 }
            r1.append(r9)     // Catch:{ Exception -> 0x0135 }
            java.lang.String r9 = r1.toString()     // Catch:{ Exception -> 0x0135 }
            com.mbridge.msdk.c.f r1 = com.mbridge.msdk.c.f.a()     // Catch:{ Exception -> 0x0135 }
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ Exception -> 0x0135 }
            java.lang.String r2 = r2.h()     // Catch:{ Exception -> 0x0135 }
            com.mbridge.msdk.c.e r1 = r1.b(r2)     // Catch:{ Exception -> 0x0135 }
            r2 = 0
            if (r1 == 0) goto L_0x0043
            boolean r3 = r1.at()     // Catch:{ Exception -> 0x0135 }
            boolean r4 = r1.ar()     // Catch:{ Exception -> 0x0135 }
            int r1 = r1.as()     // Catch:{ Exception -> 0x0135 }
            int r1 = java.lang.Math.max(r2, r1)     // Catch:{ Exception -> 0x0135 }
            goto L_0x0046
        L_0x0043:
            r3 = 1
            r1 = 3
            r4 = 0
        L_0x0046:
            if (r4 == 0) goto L_0x012f
            if (r1 != 0) goto L_0x004c
            goto L_0x012f
        L_0x004c:
            if (r3 == 0) goto L_0x0062
            java.util.Map<java.lang.String, java.lang.String> r4 = q     // Catch:{ Exception -> 0x0135 }
            if (r4 == 0) goto L_0x0062
            boolean r4 = r4.containsKey(r9)     // Catch:{ Exception -> 0x0135 }
            if (r4 == 0) goto L_0x0062
            java.util.Map<java.lang.String, java.lang.String> r1 = q     // Catch:{ Exception -> 0x0135 }
            java.lang.Object r9 = r1.get(r9)     // Catch:{ Exception -> 0x0135 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ Exception -> 0x0135 }
            monitor-exit(r0)
            return r9
        L_0x0062:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0135 }
            java.lang.String r5 = ""
            r4.<init>(r5)     // Catch:{ Exception -> 0x0135 }
            java.lang.Exception r5 = new java.lang.Exception     // Catch:{ Exception -> 0x0135 }
            r5.<init>()     // Catch:{ Exception -> 0x0135 }
            java.lang.StackTraceElement[] r5 = r5.getStackTrace()     // Catch:{ Exception -> 0x0135 }
            if (r5 == 0) goto L_0x013f
            int r6 = r5.length     // Catch:{ Exception -> 0x0135 }
            if (r6 <= 0) goto L_0x013f
            java.util.List r5 = a((java.lang.StackTraceElement[]) r5)     // Catch:{ Exception -> 0x0135 }
            java.util.Collections.reverse(r5)     // Catch:{ Exception -> 0x0135 }
            java.util.Iterator r5 = r5.iterator()     // Catch:{ Exception -> 0x0135 }
            java.util.ArrayList r6 = new java.util.ArrayList     // Catch:{ Exception -> 0x0135 }
            r6.<init>()     // Catch:{ Exception -> 0x0135 }
        L_0x0087:
            boolean r7 = r5.hasNext()     // Catch:{ Exception -> 0x0135 }
            if (r7 == 0) goto L_0x00c5
            java.lang.Object r7 = r5.next()     // Catch:{ Exception -> 0x0135 }
            java.lang.String r7 = (java.lang.String) r7     // Catch:{ Exception -> 0x0135 }
            java.lang.String r8 = "com.android"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0135 }
            if (r8 != 0) goto L_0x0087
            java.lang.String r8 = "android.os"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0135 }
            if (r8 != 0) goto L_0x0087
            java.lang.String r8 = "android.app"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0135 }
            if (r8 != 0) goto L_0x0087
            java.lang.String r8 = "java.lang.reflect.Method"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0135 }
            if (r8 != 0) goto L_0x0087
            java.lang.String r8 = "android.view"
            boolean r8 = r7.startsWith(r8)     // Catch:{ Exception -> 0x0135 }
            if (r8 != 0) goto L_0x0087
            boolean r8 = r6.contains(r7)     // Catch:{ Exception -> 0x0135 }
            if (r8 != 0) goto L_0x0087
            r6.add(r7)     // Catch:{ Exception -> 0x0135 }
            goto L_0x0087
        L_0x00c5:
            int r5 = r6.size()     // Catch:{ Exception -> 0x0135 }
            int r1 = java.lang.Math.min(r5, r1)     // Catch:{ Exception -> 0x0135 }
            if (r1 <= 0) goto L_0x00e7
        L_0x00cf:
            if (r2 >= r1) goto L_0x00e7
            java.lang.Object r5 = r6.get(r2)     // Catch:{ Exception -> 0x0135 }
            java.lang.String r5 = (java.lang.String) r5     // Catch:{ Exception -> 0x0135 }
            r4.append(r5)     // Catch:{ Exception -> 0x0135 }
            int r5 = r1 + -1
            if (r2 >= r5) goto L_0x00e4
            java.lang.String r5 = "|"
            r4.append(r5)     // Catch:{ Exception -> 0x0135 }
        L_0x00e4:
            int r2 = r2 + 1
            goto L_0x00cf
        L_0x00e7:
            java.lang.String r1 = r4.toString()     // Catch:{ Exception -> 0x0135 }
            boolean r1 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0135 }
            if (r1 != 0) goto L_0x0100
            org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ Exception -> 0x0135 }
            r1.<init>()     // Catch:{ Exception -> 0x0135 }
            java.lang.String r2 = "1"
            java.lang.String r4 = r4.toString()     // Catch:{ Exception -> 0x0135 }
            r1.put(r2, r4)     // Catch:{ Exception -> 0x0135 }
            goto L_0x0101
        L_0x0100:
            r1 = 0
        L_0x0101:
            if (r1 == 0) goto L_0x012b
            int r2 = r1.length()     // Catch:{ Exception -> 0x0135 }
            if (r2 <= 0) goto L_0x012b
            java.lang.String r1 = r1.toString()     // Catch:{ Exception -> 0x0135 }
            java.lang.String r1 = com.mbridge.msdk.foundation.tools.a.a(r1)     // Catch:{ Exception -> 0x0135 }
            if (r3 == 0) goto L_0x0129
            boolean r2 = android.text.TextUtils.isEmpty(r1)     // Catch:{ Exception -> 0x0135 }
            if (r2 != 0) goto L_0x0129
            java.util.Map<java.lang.String, java.lang.String> r2 = q     // Catch:{ Exception -> 0x0135 }
            if (r2 != 0) goto L_0x0124
            java.util.HashMap r2 = new java.util.HashMap     // Catch:{ Exception -> 0x0135 }
            r2.<init>()     // Catch:{ Exception -> 0x0135 }
            q = r2     // Catch:{ Exception -> 0x0135 }
        L_0x0124:
            java.util.Map<java.lang.String, java.lang.String> r2 = q     // Catch:{ Exception -> 0x0135 }
            r2.put(r9, r1)     // Catch:{ Exception -> 0x0135 }
        L_0x0129:
            monitor-exit(r0)
            return r1
        L_0x012b:
            java.lang.String r9 = ""
            monitor-exit(r0)
            return r9
        L_0x012f:
            java.lang.String r9 = ""
            monitor-exit(r0)
            return r9
        L_0x0133:
            r9 = move-exception
            goto L_0x0143
        L_0x0135:
            r9 = move-exception
            java.lang.String r1 = "SameTools"
            java.lang.String r9 = r9.getMessage()     // Catch:{ all -> 0x0133 }
            com.mbridge.msdk.foundation.tools.aa.d(r1, r9)     // Catch:{ all -> 0x0133 }
        L_0x013f:
            java.lang.String r9 = ""
            monitor-exit(r0)
            return r9
        L_0x0143:
            monitor-exit(r0)
            goto L_0x0146
        L_0x0145:
            throw r9
        L_0x0146:
            goto L_0x0145
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.af.g(java.lang.String):java.lang.String");
    }

    public static synchronized void a(String str, String str2) {
        synchronized (af.class) {
            if (r == null) {
                r = new HashMap();
            }
            r.put(b.d().h() + "_" + str, str2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized java.lang.String h(java.lang.String r3) {
        /*
            java.lang.Class<com.mbridge.msdk.foundation.tools.af> r0 = com.mbridge.msdk.foundation.tools.af.class
            monitor-enter(r0)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0036 }
            r1.<init>()     // Catch:{ all -> 0x0036 }
            com.mbridge.msdk.foundation.controller.b r2 = com.mbridge.msdk.foundation.controller.b.d()     // Catch:{ all -> 0x0036 }
            java.lang.String r2 = r2.h()     // Catch:{ all -> 0x0036 }
            r1.append(r2)     // Catch:{ all -> 0x0036 }
            java.lang.String r2 = "_"
            r1.append(r2)     // Catch:{ all -> 0x0036 }
            r1.append(r3)     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = r1.toString()     // Catch:{ all -> 0x0036 }
            java.util.Map<java.lang.String, java.lang.String> r1 = r     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0033
            boolean r1 = r1.containsKey(r3)     // Catch:{ all -> 0x0036 }
            if (r1 == 0) goto L_0x0033
            java.util.Map<java.lang.String, java.lang.String> r1 = r     // Catch:{ all -> 0x0036 }
            java.lang.Object r3 = r1.get(r3)     // Catch:{ all -> 0x0036 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0036 }
            monitor-exit(r0)
            return r3
        L_0x0033:
            monitor-exit(r0)
            r3 = 0
            return r3
        L_0x0036:
            r3 = move-exception
            monitor-exit(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.af.h(java.lang.String):java.lang.String");
    }

    private static List<String> a(StackTraceElement[] stackTraceElementArr) {
        ArrayList arrayList = new ArrayList();
        if (stackTraceElementArr != null && stackTraceElementArr.length > 0) {
            for (StackTraceElement className : stackTraceElementArr) {
                arrayList.add(className.getClassName());
            }
        }
        return arrayList;
    }

    public static final int f() {
        if (s == null) {
            try {
                s = q.a.a.e();
            } catch (Exception e2) {
                aa.d("SameTools", e2.getMessage());
            }
        }
        if (s != null) {
            return s.booleanValue() ? 1 : 0;
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        r0 = -1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return false;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041 A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:36:? A[ExcHandler: all (unused java.lang.Throwable), SYNTHETIC, Splitter:B:3:0x0008] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean i(java.lang.String r4) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            r1 = 0
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            android.net.Uri r4 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x0048, all -> 0x0055 }
            if (r4 == 0) goto L_0x0047
            java.lang.String r0 = "dyview"
            java.lang.String r0 = r4.getQueryParameter(r0)     // Catch:{ Exception -> 0x0048, all -> 0x0055 }
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0048, all -> 0x0055 }
            if (r2 == 0) goto L_0x0021
            java.lang.String r0 = "view"
            java.lang.String r0 = r4.getQueryParameter(r0)     // Catch:{ Exception -> 0x0048, all -> 0x0055 }
        L_0x0021:
            boolean r2 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x0048, all -> 0x0055 }
            r3 = 1
            if (r2 != 0) goto L_0x0034
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ Exception -> 0x002d, all -> 0x0055 }
            goto L_0x002e
        L_0x002d:
            r0 = -1
        L_0x002e:
            int r0 = r0 % 2
            if (r0 != 0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0034:
            r0 = 0
        L_0x0035:
            java.lang.String r2 = "natmp"
            java.lang.String r4 = r4.getQueryParameter(r2)     // Catch:{ Exception -> 0x0045 }
            boolean r4 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0045 }
            if (r4 != 0) goto L_0x0043
            r1 = 1
            goto L_0x0047
        L_0x0043:
            r1 = r0
            goto L_0x0047
        L_0x0045:
            r4 = move-exception
            goto L_0x004a
        L_0x0047:
            return r1
        L_0x0048:
            r4 = move-exception
            r0 = 0
        L_0x004a:
            java.lang.String r2 = "SameTools"
            java.lang.String r4 = r4.getMessage()     // Catch:{ all -> 0x0054 }
            com.mbridge.msdk.foundation.tools.aa.d(r2, r4)     // Catch:{ all -> 0x0054 }
            return r1
        L_0x0054:
            r1 = r0
        L_0x0055:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.af.i(java.lang.String):boolean");
    }

    public static boolean b(String str, String str2) {
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str)) {
            try {
                Uri parse = Uri.parse(str2);
                if (parse == null || TextUtils.isEmpty(parse.getQueryParameter(str))) {
                    return false;
                }
                return true;
            } catch (Exception e2) {
                aa.d("SameTools", e2.getMessage());
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static boolean j(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return false;
            }
            String queryParameter = parse.getQueryParameter(MBridgeConstans.ENDCARD_URL_IS_PLAYABLE);
            if (!TextUtils.isEmpty(queryParameter)) {
                return queryParameter.equals("0");
            }
            return false;
        } catch (Exception e2) {
            aa.d("SameTools", e2.getMessage());
            return false;
        }
    }

    public static boolean k(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return false;
            }
            String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_CAN_ANIM);
            if (!TextUtils.isEmpty(queryParameter)) {
                return queryParameter.equals("1");
            }
            return false;
        } catch (Exception e2) {
            aa.d("SameTools", e2.getMessage());
            return false;
        }
    }

    public static int l(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse == null) {
                return -1;
            }
            String queryParameter = parse.getQueryParameter(MBridgeConstans.DYNAMIC_VIEW_KEY_DY_VIEW);
            if (TextUtils.isEmpty(queryParameter)) {
                queryParameter = parse.getQueryParameter("view");
            }
            if (TextUtils.isEmpty(queryParameter)) {
                return -1;
            }
            try {
                return Integer.parseInt(queryParameter);
            } catch (Exception unused) {
                return -1;
            }
        } catch (Exception e2) {
            aa.d("SameTools", e2.getMessage());
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004b, code lost:
        if ((r6 + (r4 * 1000)) >= r8) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0071, code lost:
        if ((r6 + (r4.Q() * 1000)) >= r8) goto L_0x0075;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m(java.lang.String r17) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r17)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.util.concurrent.ConcurrentHashMap r0 = com.mbridge.msdk.foundation.same.a.d.a(r17)
            if (r0 == 0) goto L_0x009c
            int r2 = r0.size()
            if (r2 <= 0) goto L_0x009c
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Collection r0 = r0.values()
            java.util.Iterator r0 = r0.iterator()
        L_0x0022:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x0087
            java.lang.Object r3 = r0.next()
            com.mbridge.msdk.foundation.entity.b r3 = (com.mbridge.msdk.foundation.entity.b) r3
            if (r3 == 0) goto L_0x0022
            long r4 = r3.d()
            long r6 = r3.e()
            long r8 = java.lang.System.currentTimeMillis()
            r10 = 0
            r12 = 1
            r13 = 0
            r14 = 1000(0x3e8, double:4.94E-321)
            int r16 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1))
            if (r16 <= 0) goto L_0x004e
            long r4 = r4 * r14
            long r6 = r6 + r4
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x0074
            goto L_0x0075
        L_0x004e:
            com.mbridge.msdk.c.f r4 = com.mbridge.msdk.c.f.a()
            com.mbridge.msdk.foundation.controller.b r5 = com.mbridge.msdk.foundation.controller.b.d()
            java.lang.String r5 = r5.h()
            com.mbridge.msdk.c.e r4 = r4.b(r5)
            if (r4 != 0) goto L_0x0068
            com.mbridge.msdk.c.f r4 = com.mbridge.msdk.c.f.a()
            com.mbridge.msdk.c.e r4 = r4.b()
        L_0x0068:
            long r4 = r4.Q()
            long r4 = r4 * r14
            long r6 = r6 + r4
            int r4 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r4 < 0) goto L_0x0074
            goto L_0x0075
        L_0x0074:
            r12 = 0
        L_0x0075:
            if (r12 == 0) goto L_0x0022
            java.util.List r3 = r3.c()
            if (r3 == 0) goto L_0x0022
            int r4 = r3.size()
            if (r4 <= 0) goto L_0x0022
            r2.addAll(r3)
            goto L_0x0022
        L_0x0087:
            int r0 = r2.size()
            if (r0 <= 0) goto L_0x009c
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>(r2)
            r2.clear()
            r2.addAll(r0)
            java.lang.String r1 = r2.toString()
        L_0x009c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.af.m(java.lang.String):java.lang.String");
    }

    public static boolean a(JSONObject jSONObject) {
        if (jSONObject == null || jSONObject.length() == 0 || jSONObject.optInt("v", -1) != -1) {
            return false;
        }
        return true;
    }

    public static int c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String queryParameter = parse.getQueryParameter(str2);
                if (TextUtils.isEmpty(queryParameter)) {
                    return 0;
                }
                return (int) Math.round(Double.valueOf(String.valueOf(queryParameter)).doubleValue());
            }
        } catch (Exception e2) {
            aa.d("SameTools", e2.getMessage());
        }
        return 0;
    }

    public static boolean h() {
        try {
            ConnectivityManager a2 = s.a();
            if (a2 == null) {
                return false;
            }
            NetworkInfo networkInfo = a2.getNetworkInfo(17);
            if (networkInfo == null) {
                return false;
            }
            return networkInfo.isConnected();
        } catch (Exception e2) {
            aa.d("SameTools", e2.getMessage());
            return false;
        }
    }

    public static boolean i() {
        try {
            if (b.d().g() == null) {
                return false;
            }
            String property = System.getProperty("http.proxyHost");
            String property2 = System.getProperty("http.proxyPort");
            if (property2 == null) {
                property2 = "-1";
            }
            int parseInt = Integer.parseInt(property2);
            aa.a("address = ", property + "~");
            aa.a("port = ", parseInt + "~");
            if (TextUtils.isEmpty(property) || parseInt == -1) {
                return false;
            }
            return true;
        } catch (Throwable th) {
            aa.d("SameTools", th.getMessage());
            return false;
        }
    }

    public static String a(String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
                return str;
            }
            if (TextUtils.isEmpty(str3)) {
                return str;
            }
            HashMap hashMap = new HashMap();
            hashMap.put(str2, str3);
            return a(str, (Map<String, String>) hashMap);
        } catch (Exception e2) {
            aa.d("SameTools", e2.getMessage());
            return str;
        }
    }

    private static String a(String str, Map<String, String> map) {
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            if (map == null) {
                return str;
            }
            StringBuilder sb = new StringBuilder(str);
            for (Map.Entry next : map.entrySet()) {
                if (next != null && !TextUtils.isEmpty((CharSequence) next.getKey())) {
                    if (!TextUtils.isEmpty((CharSequence) next.getValue())) {
                        String str2 = (String) next.getValue();
                        if (str.contains((CharSequence) next.getKey())) {
                            if (str2.equals("0")) {
                                sb = new StringBuilder(str.replaceAll("(" + ((String) next.getKey()) + "[^&]*)", ""));
                            } else {
                                sb = new StringBuilder(str.replaceAll("(" + ((String) next.getKey()) + "[^&]*)", ((String) next.getKey()) + ((String) next.getValue())));
                            }
                        } else if (!str2.equals("0")) {
                            sb.append(((String) next.getKey()) + ((String) next.getValue()));
                        }
                    }
                }
            }
            return sb.toString();
        } catch (Exception e2) {
            aa.d("SameTools", e2.getMessage());
            return str;
        }
    }

    public static String b(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                JSONObject jSONObject2 = jSONObject.getJSONObject("device");
                if (jSONObject2 == null) {
                    return str;
                }
                if (jSONObject2.has(str2)) {
                    if (str3.equals("0")) {
                        jSONObject2.remove(str2);
                    } else {
                        jSONObject2.put(str2, str3);
                    }
                } else if (str3.equals("0")) {
                    return str;
                } else {
                    jSONObject2.put(str2, str3);
                }
                return jSONObject.toString();
            } catch (Exception e2) {
                aa.d("SameTools", e2.getMessage());
            }
        }
        return str;
    }

    public static final void a(final int i2, final ImageView imageView, final CampaignEx campaignEx, Context context, boolean z, final a aVar) {
        if (imageView != null && campaignEx != null) {
            aa.a("configPrivacyButton", "configPrivacyButton");
            boolean z2 = campaignEx.getPrivacyButtonTemplateVisibility() == 0;
            aa.a("configPrivacyButton", "privacyButtonVisibilityGone: " + z2 + " isIgnoreCampaignPrivacyConfig: " + z);
            if (!z && z2) {
                try {
                    imageView.setVisibility(8);
                } catch (Exception e2) {
                    aa.d("SameTools", e2.getMessage());
                }
            } else if (TextUtils.isEmpty(c(campaignEx))) {
                try {
                    imageView.setVisibility(8);
                } catch (Exception e3) {
                    aa.d("SameTools", e3.getMessage());
                }
            } else {
                try {
                    imageView.setVisibility(0);
                } catch (Exception e4) {
                    aa.d("SameTools", e4.getMessage());
                }
                imageView.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        try {
                            af.a(campaignEx, aVar, i2, (String) imageView.getTag());
                        } catch (Exception e) {
                            aa.d("SameTools", e.getMessage());
                        }
                    }
                });
            }
        }
    }

    public static void a(CampaignEx campaignEx, a aVar, int i2, String str) {
        if (campaignEx != null) {
            try {
                String str2 = campaignEx.getCampaignUnitId() + "_" + i2;
                com.mbridge.msdk.foundation.c.b.a().c(str2);
                com.mbridge.msdk.foundation.c.b.a().a(str2, campaignEx);
                com.mbridge.msdk.foundation.c.b.a().a(str2, aVar);
                com.mbridge.msdk.foundation.c.b.a().b(str2, i2);
                com.mbridge.msdk.foundation.c.b.a().a(str2, str);
                com.mbridge.msdk.foundation.c.b.a().a(str2).a();
            } catch (Throwable th) {
                aa.b("SameTools", "feedback error", th);
            }
        }
    }

    public static String c(CampaignEx campaignEx) {
        e b2;
        CampaignEx.a adchoice;
        String str = "";
        if (campaignEx != null) {
            try {
                str = campaignEx.getPrivacyUrl();
            } catch (Exception e2) {
                aa.d("SameTools", e2.getMessage());
                return str;
            }
        }
        if (!(!TextUtils.isEmpty(str) || campaignEx == null || (adchoice = campaignEx.getAdchoice()) == null)) {
            str = adchoice.d();
        }
        if (TextUtils.isEmpty(str) && (b2 = f.a().b(b.d().h())) != null) {
            str = b2.al();
        }
        if (TextUtils.isEmpty(str)) {
            return d.a().j;
        }
        return str;
    }

    public static BitmapDrawable n(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            byte[] decode = Base64.decode(str, 0);
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(decode, 0, decode.length);
            if (decodeByteArray != null) {
                BitmapDrawable bitmapDrawable = new BitmapDrawable(decodeByteArray);
                bitmapDrawable.setTileModeXY(Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
                return bitmapDrawable;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return null;
    }

    public static ImageView a(ImageView imageView, BitmapDrawable bitmapDrawable, DisplayMetrics displayMetrics) {
        try {
            bitmapDrawable.setTargetDensity(displayMetrics);
            imageView.setBackground(bitmapDrawable);
            imageView.setClickable(false);
            imageView.setFocusable(false);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return imageView;
    }

    public static final String g() {
        return q.a.a.f();
    }
}
