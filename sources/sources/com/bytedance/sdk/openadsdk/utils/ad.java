package com.bytedance.sdk.openadsdk.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Outline;
import android.graphics.Paint;
import android.graphics.Picture;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import com.bytedance.sdk.component.g.h;
import com.bytedance.sdk.component.utils.d;
import com.bytedance.sdk.component.utils.g;
import com.bytedance.sdk.component.utils.l;
import com.bytedance.sdk.component.utils.s;
import com.bytedance.sdk.component.widget.SSWebView;
import com.bytedance.sdk.openadsdk.b.c;
import com.bytedance.sdk.openadsdk.core.model.q;
import com.bytedance.sdk.openadsdk.core.model.t;
import com.bytedance.sdk.openadsdk.core.o;
import com.bytedance.sdk.openadsdk.core.video.b.a;
import com.bytedance.sdk.openadsdk.core.widget.TTRatingBar2;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: UIUtils */
public class ad {
    private static float a = -1.0f;
    private static int b = -1;
    private static float c = -1.0f;
    private static int d = -1;
    private static int e = -1;
    private static WindowManager f = null;
    private static float g = -1.0f;
    private static Boolean h;
    private static final Object i = new Object();

    private static boolean a(int i2) {
        return i2 == 0 || i2 == 8 || i2 == 4;
    }

    private static boolean b() {
        return a < 0.0f || b < 0 || c < 0.0f || d < 0 || e < 0;
    }

    public static void a(Context context) {
        a(context, false);
    }

    public static void a(Context context, boolean z) {
        Context a2 = context == null ? o.a() : context;
        if (a2 != null) {
            f = (WindowManager) a2.getSystemService("window");
            if (b() || z) {
                DisplayMetrics displayMetrics = a2.getResources().getDisplayMetrics();
                a = displayMetrics.density;
                b = displayMetrics.densityDpi;
                c = displayMetrics.scaledDensity;
                d = displayMetrics.widthPixels;
                e = displayMetrics.heightPixels;
            }
            if (context != null && context.getResources() != null && context.getResources().getConfiguration() != null) {
                if (context.getResources().getConfiguration().orientation == 1) {
                    int i2 = d;
                    int i3 = e;
                    if (i2 > i3) {
                        d = i3;
                        e = i2;
                        return;
                    }
                    return;
                }
                int i4 = d;
                int i5 = e;
                if (i4 < i5) {
                    d = i5;
                    e = i4;
                }
            }
        }
    }

    public static int a(Context context, float f2) {
        a(context);
        float f3 = f(context);
        if (f3 <= 0.0f) {
            f3 = 1.0f;
        }
        return (int) ((f2 / f3) + 0.5f);
    }

    public static int b(Context context, float f2) {
        return Float.valueOf(a(context, f2, true)).intValue();
    }

    public static float a(Context context, float f2, boolean z) {
        a(context);
        return (f2 * e(context)) + (z ? 0.5f : 0.0f);
    }

    public static int c(Context context, float f2) {
        a(context, true);
        float e2 = e(context);
        if (e2 <= 0.0f) {
            e2 = 1.0f;
        }
        return (int) ((f2 / e2) + 0.5f);
    }

    public static int[] b(Context context) {
        if (context == null) {
            return null;
        }
        if (f == null) {
            f = (WindowManager) o.a().getSystemService("window");
        }
        int[] iArr = new int[2];
        WindowManager windowManager = f;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getMetrics(displayMetrics);
            int i2 = displayMetrics.widthPixels;
            int i3 = displayMetrics.heightPixels;
            try {
                Point point = new Point();
                Display.class.getMethod("getRealSize", new Class[]{Point.class}).invoke(defaultDisplay, new Object[]{point});
                i2 = point.x;
                i3 = point.y;
            } catch (Exception unused) {
            }
            iArr[0] = i2;
            iArr[1] = i3;
        }
        if (iArr[0] <= 0 || iArr[1] <= 0) {
            DisplayMetrics displayMetrics2 = context.getResources().getDisplayMetrics();
            iArr[0] = displayMetrics2.widthPixels;
            iArr[1] = displayMetrics2.heightPixels;
        }
        return iArr;
    }

    public static int c(Context context) {
        a(context);
        return d;
    }

    public static int d(Context context) {
        a(context);
        return e;
    }

    public static float e(Context context) {
        a(context, true);
        return a;
    }

    public static float f(Context context) {
        a(context);
        return c;
    }

    public static int g(Context context) {
        a(context);
        return b;
    }

    public static void a(View view, int i2, int i3, int i4, int i5) {
        Rect rect = new Rect();
        view.getHitRect(rect);
        rect.top -= i2;
        rect.bottom += i3;
        rect.left -= i4;
        rect.right += i5;
        ((View) view.getParent()).setTouchDelegate(new g(rect, view));
    }

    public static int[] a(View view) {
        if (view == null || view.getVisibility() != 0) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] b(View view) {
        if (view == null) {
            return null;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return iArr;
    }

    public static int[] c(View view) {
        if (view == null) {
            return null;
        }
        return new int[]{view.getWidth(), view.getHeight()};
    }

    public static void a(View view, int i2) {
        if (view != null && view.getVisibility() != i2 && a(i2)) {
            view.setVisibility(i2);
        }
    }

    public static boolean d(View view) {
        return view != null && view.getVisibility() == 0;
    }

    public static void a(TextView textView, CharSequence charSequence) {
        if (textView != null && !TextUtils.isEmpty(charSequence)) {
            textView.setText(charSequence);
        }
    }

    public static void b(View view, int i2, int i3, int i4, int i5) {
        ViewGroup.LayoutParams layoutParams;
        if (view != null && (layoutParams = view.getLayoutParams()) != null && (layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            a(view, (ViewGroup.MarginLayoutParams) layoutParams, i2, i3, i4, i5);
        }
    }

    private static void a(View view, ViewGroup.MarginLayoutParams marginLayoutParams, int i2, int i3, int i4, int i5) {
        if (view != null && marginLayoutParams != null) {
            if (marginLayoutParams.leftMargin != i2 || marginLayoutParams.topMargin != i3 || marginLayoutParams.rightMargin != i4 || marginLayoutParams.bottomMargin != i5) {
                if (i2 != -3) {
                    marginLayoutParams.leftMargin = i2;
                }
                if (i3 != -3) {
                    marginLayoutParams.topMargin = i3;
                }
                if (i4 != -3) {
                    marginLayoutParams.rightMargin = i4;
                }
                if (i5 != -3) {
                    marginLayoutParams.bottomMargin = i5;
                }
                view.setLayoutParams(marginLayoutParams);
            }
        }
    }

    private static Bitmap a(WebView webView) {
        Bitmap bitmap = null;
        try {
            Picture capturePicture = webView.capturePicture();
            bitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Bitmap.Config.ARGB_8888);
            capturePicture.draw(new Canvas(bitmap));
            return bitmap;
        } catch (Throwable th) {
            l.e("UIUtils", th.getMessage());
            return bitmap;
        }
    }

    public static void e(View view) {
        if (view != null) {
            final WeakReference weakReference = new WeakReference(view);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{1.0f, 0.0f});
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    View view = (View) weakReference.get();
                    if (view != null) {
                        ad.a(view, 8);
                        view.setAlpha(1.0f);
                    }
                }
            });
            ofFloat.setDuration(800);
            ofFloat.start();
        }
    }

    public static void f(View view) {
        if (view != null) {
            a(view, 0);
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(view, "alpha", new float[]{0.0f, 1.0f});
            ofFloat.addListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animator) {
                    super.onAnimationEnd(animator);
                }
            });
            ofFloat.setDuration(300);
            ofFloat.start();
        }
    }

    public static Pair<Integer, Integer> h(Context context) {
        if (context == null) {
            context = o.a();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        return new Pair<>(Integer.valueOf(point.x), Integer.valueOf(point.y));
    }

    public static int i(Context context) {
        return ((Integer) h(context).second).intValue();
    }

    public static int j(Context context) {
        return ((Integer) h(context).first).intValue();
    }

    public static float a() {
        float f2 = g;
        if (f2 > 0.0f) {
            return f2;
        }
        Resources resources = o.a().getResources();
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier <= 0) {
            return 0.0f;
        }
        float dimensionPixelSize = (float) resources.getDimensionPixelSize(identifier);
        g = dimensionPixelSize;
        return dimensionPixelSize;
    }

    public static void a(Activity activity) {
        if (activity != null && !activity.isFinishing()) {
            try {
                activity.getWindow().getDecorView().setSystemUiVisibility(3846);
                activity.getWindow().addFlags(1792);
            } catch (Exception e2) {
                l.e("UIUtils", e2.getMessage());
            }
        }
    }

    public static void b(Activity activity) {
        if (activity != null) {
            try {
                activity.getWindow().getDecorView().setSystemUiVisibility(1792);
                activity.getWindow().clearFlags(1792);
            } catch (Exception unused) {
            }
        }
    }

    public static boolean c(Activity activity) {
        if (h == null) {
            synchronized (i) {
                if (h == null) {
                    boolean z = true;
                    if (!d(activity) && a("ro.miui.notch", activity) != 1 && !k(activity) && !o(activity) && !l(activity) && !m(activity)) {
                        if (!n(activity)) {
                            z = false;
                        }
                    }
                    h = Boolean.valueOf(z);
                }
            }
        }
        return h.booleanValue();
    }

    public static boolean d(Activity activity) {
        if (Build.VERSION.SDK_INT < 28) {
            return false;
        }
        try {
            WindowInsets rootWindowInsets = activity.getWindow().getDecorView().getRootWindowInsets();
            if ((rootWindowInsets != null ? rootWindowInsets.getDisplayCutout() : null) != null) {
                return true;
            }
            return false;
        } catch (Exception e2) {
            l.e("UIUtils", e2.getMessage());
            return false;
        }
    }

    public static int a(String str, Activity activity) {
        if (!t.e()) {
            return 0;
        }
        try {
            Class<?> loadClass = activity.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) loadClass.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(loadClass, new Object[]{new String(str), new Integer(0)})).intValue();
        } catch (ClassNotFoundException e2) {
            l.e("UIUtils", e2.getMessage());
            return 0;
        } catch (NoSuchMethodException e3) {
            l.e("UIUtils", e3.getMessage());
            return 0;
        } catch (IllegalAccessException e4) {
            l.e("UIUtils", e4.getMessage());
            return 0;
        } catch (IllegalArgumentException e5) {
            l.e("UIUtils", e5.getMessage());
            return 0;
        } catch (InvocationTargetException e6) {
            l.e("UIUtils", e6.getMessage());
            return 0;
        }
    }

    public static boolean k(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    public static boolean l(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.util.FtFeature");
            return ((Boolean) loadClass.getMethod("isFeatureSupport", new Class[]{Integer.TYPE}).invoke(loadClass, new Object[]{32})).booleanValue();
        } catch (ClassNotFoundException | Exception | NoSuchMethodException unused) {
            return false;
        }
    }

    public static boolean m(Context context) {
        return Build.MODEL.equals("IN2010") || Build.MODEL.equals("IN2020") || Build.MODEL.equals("KB2000") || Build.MODEL.startsWith("ONEPLUS");
    }

    public static boolean n(Context context) {
        try {
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("config_mainBuiltInDisplayCutout", TypedValues.Custom.S_STRING, "android");
            String string = identifier > 0 ? resources.getString(identifier) : null;
            if (string == null || TextUtils.isEmpty(string)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean o(Context context) {
        return context.getPackageManager().hasSystemFeature("com.oppo.feature.screen.heteromorphism");
    }

    public static void a(View view, View.OnClickListener onClickListener, String str) {
        if (view == null) {
            l.e("OnclickListener ", str + " is null , can not set OnClickListener !!!");
            return;
        }
        view.setOnClickListener(onClickListener);
    }

    public static void a(View view, View.OnTouchListener onTouchListener, String str) {
        if (view == null) {
            l.e("OnTouchListener ", str + " is null , can not set OnTouchListener !!!");
            return;
        }
        view.setOnTouchListener(onTouchListener);
    }

    public static void a(View view, float f2) {
        if (view != null) {
            view.setAlpha(f2);
        }
    }

    public static void a(TextView textView, TTRatingBar2 tTRatingBar2, q qVar) {
        a(textView, tTRatingBar2, (qVar == null || qVar.aa() == null) ? -1.0d : qVar.aa().d());
    }

    public static void a(TextView textView, TTRatingBar2 tTRatingBar2, double d2) {
        if (d2 == -1.0d) {
            if (textView != null) {
                textView.setVisibility(8);
            }
            tTRatingBar2.setVisibility(8);
            return;
        }
        if (textView != null) {
            textView.setText(String.format(Locale.getDefault(), "%.1f", new Object[]{Double.valueOf(d2)}));
        }
        a(tTRatingBar2, d2, 0, 14);
    }

    public static void a(TTRatingBar2 tTRatingBar2, double d2, int i2, int i3) {
        if (d2 < 0.0d) {
            tTRatingBar2.setVisibility(8);
            return;
        }
        tTRatingBar2.setVisibility(0);
        tTRatingBar2.a(d2, i2, i3);
    }

    public static void a(TextView textView, q qVar, Context context, String str) {
        a(textView, qVar.aa() != null ? qVar.aa().e() : -1, context, str);
    }

    public static void a(TextView textView, int i2, Context context, String str) {
        String str2;
        String a2 = s.a(context, str);
        if (i2 > 10000) {
            str2 = (i2 / 1000) + CampaignEx.JSON_KEY_AD_K;
        } else {
            str2 = String.valueOf(i2);
        }
        textView.setText(String.format(a2, new Object[]{str2}));
        if (i2 == -1) {
            textView.setVisibility(8);
        }
    }

    public static Bitmap a(SSWebView sSWebView) {
        if (Build.VERSION.SDK_INT < 24) {
            return null;
        }
        WebView webView = sSWebView.getWebView();
        int layerType = webView.getLayerType();
        webView.setLayerType(1, (Paint) null);
        Bitmap b2 = b(sSWebView);
        if (b2 == null) {
            b2 = a(webView);
        }
        webView.setLayerType(layerType, (Paint) null);
        if (b2 == null) {
            return null;
        }
        return d.a(b2, b2.getWidth() / 6, b2.getHeight() / 6);
    }

    public static void a(q qVar, String str, String str2, Bitmap bitmap, String str3, long j) {
        final q qVar2 = qVar;
        final String str4 = str;
        final String str5 = str2;
        final Bitmap bitmap2 = bitmap;
        final String str6 = str3;
        final long j2 = j;
        aa.b(new h("startCheckPlayableStatusPercentage") {
            public void run() {
                ad.c(qVar2, str4, str5, bitmap2, str6, j2);
            }
        }, 10);
    }

    /* access modifiers changed from: private */
    public static void c(q qVar, String str, String str2, Bitmap bitmap, String str3, long j) {
        JSONObject jSONObject;
        if (bitmap != null) {
            try {
                if (bitmap.getWidth() > 0 && bitmap.getHeight() > 0) {
                    if (!bitmap.isRecycled()) {
                        int a2 = a(bitmap);
                        JSONObject jSONObject2 = null;
                        try {
                            JSONObject jSONObject3 = new JSONObject();
                            jSONObject3.put("url", str3);
                            if (j != -1) {
                                jSONObject3.put("page_id", j);
                            }
                            jSONObject3.put("render_type", "h5");
                            int i2 = 0;
                            jSONObject3.put("render_type_2", 0);
                            jSONObject3.put("is_blank", a2 == 100 ? 1 : 0);
                            jSONObject3.put("is_playable", t.b(qVar) ? 1 : 0);
                            if (a.a().a(qVar)) {
                                i2 = 1;
                            }
                            jSONObject3.put("usecache", i2);
                            jSONObject = new JSONObject();
                            try {
                                jSONObject.put("ad_extra_data", jSONObject3.toString());
                            } catch (JSONException unused) {
                                jSONObject2 = jSONObject;
                            }
                        } catch (JSONException unused2) {
                            jSONObject = jSONObject2;
                            c.c(qVar, str, str2, jSONObject);
                        }
                        c.c(qVar, str, str2, jSONObject);
                    }
                }
            } catch (Throwable th) {
                l.e("UIUtils", "(Developers can ignore this detection exception)checkWebViewIsTransparent->throwable ex>>>" + th);
            }
        }
    }

    private static Bitmap b(SSWebView sSWebView) {
        if (sSWebView == null) {
            return null;
        }
        try {
            Bitmap createBitmap = Bitmap.createBitmap(sSWebView.getWidth(), sSWebView.getHeight(), Bitmap.Config.RGB_565);
            sSWebView.draw(new Canvas(createBitmap));
            return createBitmap;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int a(Bitmap bitmap) {
        try {
            ArrayList<Integer> b2 = b(bitmap);
            if (b2 == null) {
                return -1;
            }
            HashMap hashMap = new HashMap();
            Iterator<Integer> it = b2.iterator();
            while (it.hasNext()) {
                Integer next = it.next();
                if (hashMap.containsKey(next)) {
                    Integer valueOf = Integer.valueOf(((Integer) hashMap.get(next)).intValue() + 1);
                    hashMap.remove(next);
                    hashMap.put(next, valueOf);
                } else {
                    hashMap.put(next, 1);
                }
            }
            int i2 = 0;
            int i3 = 0;
            for (Map.Entry entry : hashMap.entrySet()) {
                int intValue = ((Integer) entry.getValue()).intValue();
                if (i3 < intValue) {
                    i2 = ((Integer) entry.getKey()).intValue();
                    i3 = intValue;
                }
            }
            if (i2 == 0) {
                return -1;
            }
            return (int) ((((float) i3) / (((float) (bitmap.getWidth() * bitmap.getHeight())) * 1.0f)) * 100.0f);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private static ArrayList<Integer> b(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        try {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int i2 = width * height;
            int[] iArr = new int[i2];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int i3 = 0; i3 < i2; i3++) {
                int i4 = iArr[i3];
                arrayList.add(Integer.valueOf(Color.rgb((16711680 & i4) >> 16, (65280 & i4) >> 8, i4 & 255)));
            }
            return arrayList;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void b(View view, final float f2) {
        if (view == null || f2 <= 0.0f) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            view.setOutlineProvider(new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    if (outline != null) {
                        outline.setRoundRect(0, 0, view.getWidth(), view.getHeight(), f2);
                    }
                }
            });
            view.setClipToOutline(true);
            return;
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(ViewCompat.MEASURED_STATE_MASK);
        gradientDrawable.setCornerRadius(f2);
        view.setBackground(gradientDrawable);
    }
}
