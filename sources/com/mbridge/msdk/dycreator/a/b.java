package com.mbridge.msdk.dycreator.a;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.TypedValue;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.view.ViewCompat;
import androidx.media3.exoplayer.upstream.CmcdHeadersFactory;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.dycreator.e.e;
import com.mbridge.msdk.dycreator.e.g;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.t;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.lang.reflect.Field;
import java.util.HashMap;
import org.xmlpull.v1.XmlPullParser;

/* compiled from: MBResource */
public class b {
    private static volatile b g;
    private SoftReference<HashMap<String, c>> a;
    private SoftReference<HashMap<String, String>> b;
    private SoftReference<HashMap<String, c>> c;
    private String d;
    private String e;
    private Context f;

    private b() {
    }

    public static b a() {
        if (g == null) {
            synchronized (b.class) {
                if (g == null) {
                    g = new b();
                }
            }
        }
        return g;
    }

    public final void a(Context context, String str) {
        try {
            if (g.a) {
                this.d = context.getFilesDir().toString();
            } else {
                this.d = str;
            }
            if (e.a(context).heightPixels > 320) {
                if (!g.a) {
                    this.e = "/drawable-hdpi/";
                    this.f = context;
                    com.mbridge.msdk.dycreator.e.b.a = a().d();
                }
            }
            this.e = "/drawable-mdpi/";
            this.f = context;
            com.mbridge.msdk.dycreator.e.b.a = a().d();
        } catch (Exception e2) {
            aa.d("MBResource", e2.getMessage());
        }
    }

    public final void a(Context context) {
        try {
            if (e.a(context).heightPixels > 320) {
                if (!g.a) {
                    this.e = "/drawable-hdpi/";
                    this.f = context;
                    com.mbridge.msdk.dycreator.e.b.a = a().d();
                }
            }
            this.e = "/drawable-mdpi/";
            this.f = context;
            com.mbridge.msdk.dycreator.e.b.a = a().d();
        } catch (Exception e2) {
            aa.d("MBResource", e2.getMessage());
        }
    }

    public final HashMap b() {
        SoftReference<HashMap<String, c>> softReference = this.a;
        if (softReference == null || softReference.get() == null) {
            HashMap hashMap = new HashMap(45);
            hashMap.put("layout_width", c.layout_width);
            hashMap.put("layout_height", c.layout_height);
            hashMap.put(AdUnitActivity.EXTRA_ORIENTATION, c.orientation);
            hashMap.put("layout_centerHorizontal", c.layout_centerHorizontal);
            hashMap.put("layout_centerVertical", c.layout_centerVertical);
            hashMap.put("layout_marginLeft", c.layout_marginLeft);
            hashMap.put("layout_marginRight", c.layout_marginRight);
            hashMap.put("layout_margin", c.layout_margin);
            hashMap.put("layout_gravity", c.layout_gravity);
            hashMap.put("layout_alignParentRight", c.layout_alignParentRight);
            hashMap.put("layout_weight", c.layout_weight);
            hashMap.put("contentDescription", c.contentDescription);
            hashMap.put("gravity", c.gravity);
            hashMap.put("id", c.id);
            hashMap.put("layout_below", c.layout_below);
            hashMap.put("layout_above", c.layout_above);
            hashMap.put("layout_toLeftOf", c.layout_toLeftOf);
            hashMap.put("layout_toRightOf", c.layout_toRightOf);
            hashMap.put("layout_toEndOf", c.layout_toEndOf);
            hashMap.put("background", c.background);
            hashMap.put("layout_marginTop", c.layout_marginTop);
            hashMap.put("layout_marginBottom", c.layout_marginBottom);
            hashMap.put("layout_marginLeft", c.layout_marginLeft);
            hashMap.put("layout_marginRight", c.layout_marginRight);
            hashMap.put("layout_alignParentBottom", c.layout_alignParentBottom);
            hashMap.put("layout_alignParentTop", c.layout_alignParentTop);
            hashMap.put("layout_alignParentLeft", c.layout_alignParentLeft);
            hashMap.put("layout_alignWithParentIfMissing", c.layout_alignWithParentIfMissing);
            hashMap.put("layout_alignTop", c.layout_alignTop);
            hashMap.put("layout_alignBottom", c.layout_alignBottom);
            hashMap.put("layout_alignLeft", c.layout_alignLeft);
            hashMap.put("layout_alignRight", c.layout_alignRight);
            hashMap.put("layout_centerInParent", c.layout_centerInParent);
            hashMap.put("layout_alignParentEnd", c.layout_alignParentEnd);
            this.a = new SoftReference<>(hashMap);
        }
        return this.a.get();
    }

    public final HashMap<String, c> c() {
        SoftReference<HashMap<String, c>> softReference = this.c;
        if (softReference == null || softReference.get() == null) {
            HashMap hashMap = new HashMap(55);
            hashMap.put("id", c.id);
            hashMap.put("text", c.text);
            hashMap.put("ellipsize", c.ellipsize);
            hashMap.put("singleLine", c.singleLine);
            hashMap.put("lines", c.lines);
            hashMap.put("maxLength", c.maxLength);
            hashMap.put("drawableLeft", c.drawableLeft);
            hashMap.put("drawablePadding", c.drawablePadding);
            hashMap.put("fadingEdge", c.fadingEdge);
            hashMap.put("scrollHorizontally", c.scrollHorizontally);
            hashMap.put("textColor", c.textColor);
            hashMap.put("textSize", c.textSize);
            hashMap.put("visibility", c.visibility);
            hashMap.put("background", c.background);
            hashMap.put("textStyle", c.textStyle);
            hashMap.put("style", c.style);
            hashMap.put("layout_width", c.layout_width);
            hashMap.put("layout_height", c.layout_height);
            hashMap.put("layout_below", c.layout_below);
            hashMap.put("layout_centerInParent", c.layout_centerInParent);
            hashMap.put("contentDescription", c.contentDescription);
            hashMap.put("src", c.src);
            hashMap.put("gravity", c.gravity);
            hashMap.put(AdUnitActivity.EXTRA_ORIENTATION, c.orientation);
            hashMap.put("numColumns", c.numColumns);
            hashMap.put("verticalSpacing", c.verticalSpacing);
            hashMap.put("horizontalSpacing", c.horizontalSpacing);
            hashMap.put("background", c.background);
            hashMap.put("layout_marginBottom", c.layout_marginBottom);
            hashMap.put("scaleType", c.scaleType);
            hashMap.put(ViewHierarchyConstants.TAG_KEY, c.Y);
            hashMap.put("layout_gravity", c.layout_gravity);
            hashMap.put("parent_view", c.parent_view);
            hashMap.put("padding", c.padding);
            hashMap.put("paddingTop", c.paddingTop);
            hashMap.put("paddingBottom", c.paddingBottom);
            hashMap.put("paddingLeft", c.paddingLeft);
            hashMap.put("paddingRight", c.paddingRight);
            hashMap.put("divider", c.divider);
            hashMap.put("scrollbars", c.scrollbars);
            hashMap.put("listSelector", c.listSelector);
            this.c = new SoftReference<>(hashMap);
        }
        return this.c.get();
    }

    public final int a(String str) {
        if (TextUtils.isEmpty(str)) {
            return ViewCompat.MEASURED_STATE_MASK;
        }
        if (str.startsWith("#")) {
            int length = str.length();
            if (length == 7) {
                return (int) Long.decode(str.replace("#", "#FF")).longValue();
            }
            if (length == 9) {
                return (int) Long.decode(str).longValue();
            }
            g.a("返回白色背景");
            return -1;
        } else if (!str.startsWith("@color/")) {
            return ViewCompat.MEASURED_STATE_MASK;
        } else {
            return Build.VERSION.SDK_INT >= 23 ? com.mbridge.msdk.foundation.controller.b.d().g().getColor(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), str.substring(7), "color")) : ViewCompat.MEASURED_STATE_MASK;
        }
    }

    public final GradientDrawable a(String[] strArr) {
        try {
            GradientDrawable gradientDrawable = new GradientDrawable(GradientOrientationUtils.getOrientation(strArr[2]), new int[]{Color.parseColor(strArr[0]), Color.parseColor(strArr[1])});
            gradientDrawable.setGradientType(0);
            return gradientDrawable;
        } catch (Exception e2) {
            aa.d("MBResource", e2.getMessage());
            return null;
        }
    }

    public final int b(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception unused) {
            int indexOf = str.indexOf("d");
            int indexOf2 = str.indexOf(CmcdHeadersFactory.STREAMING_FORMAT_SS);
            if (indexOf == -1) {
                indexOf = indexOf2;
            }
            int parseInt = Integer.parseInt(str.substring(0, indexOf));
            if (str.contains("d")) {
                return (int) TypedValue.applyDimension(1, (float) parseInt, this.f.getResources().getDisplayMetrics());
            }
            str.contains(CmcdHeadersFactory.STREAMING_FORMAT_SS);
            return parseInt;
        }
    }

    public final int c(String str) {
        String[] split = str.toUpperCase().split("\\|");
        int i = 48;
        try {
            Class<?> cls = Class.forName("android.view.Gravity");
            for (String field : split) {
                i = cls.getField(field).getInt((Object) null);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return i;
    }

    public final int d(String str) {
        Context context = this.f;
        if (context != null) {
            String packageName = context.getPackageName();
            StringBuilder sb = new StringBuilder();
            sb.append(packageName);
            sb.append(".R$");
            String[] split = str.split("\\.");
            sb.append(split[1]);
            try {
                Class<?> cls = Class.forName(sb.toString());
                Object newInstance = cls.newInstance();
                Field declaredField = cls.getDeclaredField(split[2]);
                declaredField.setAccessible(true);
                return ((Integer) declaredField.get(newInstance)).intValue();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return 0;
    }

    public final String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("@")) {
            return str;
        }
        SoftReference<HashMap<String, String>> softReference = this.b;
        if (softReference == null || softReference.get() == null) {
            this.b = new SoftReference<>(d());
        }
        String substring = str.substring(8);
        if (this.b.get() == null || this.b.get().size() <= 0) {
            return null;
        }
        String str2 = (String) this.b.get().get(substring);
        if (!TextUtils.isEmpty(str2)) {
            return str2;
        }
        try {
            return com.mbridge.msdk.foundation.controller.b.d().g().getString(t.a(com.mbridge.msdk.foundation.controller.b.d().g(), substring, TypedValues.Custom.S_STRING));
        } catch (Exception e2) {
            aa.d("MBResource", e2.getMessage());
            return null;
        }
    }

    private HashMap<String, String> d() {
        InputStream inputStream;
        try {
            inputStream = this.f.getAssets().open("rv_binddatas.xml");
        } catch (IOException e2) {
            e2.printStackTrace();
            inputStream = null;
        }
        XmlPullParser newPullParser = Xml.newPullParser();
        try {
            newPullParser.setInput(inputStream, "utf-8");
            HashMap<String, String> hashMap = new HashMap<>();
            for (int eventType = newPullParser.getEventType(); eventType != 1; eventType = newPullParser.next()) {
                if (eventType == 2 && TypedValues.Custom.S_STRING.equals(newPullParser.getName())) {
                    hashMap.put(newPullParser.getAttributeValue(0), newPullParser.nextText());
                }
            }
            return hashMap;
        } catch (Exception e3) {
            e3.printStackTrace();
            return null;
        }
    }

    public final void a(String str, ImageView imageView) {
        Context context;
        if (str != null && str.startsWith("@drawable/") && (context = this.f) != null) {
            try {
                imageView.setImageResource(context.getResources().getIdentifier(str, "drawable", this.f.getPackageName()));
            } catch (Exception e2) {
                aa.d("MBResource", e2.getMessage());
            }
        }
    }

    public final View f(String str) {
        if (this.f != null) {
            try {
                a aVar = new a(this.f);
                new String();
                g.a(str.toString());
                return aVar.a(str.toString(), (ViewGroup) null);
            } catch (Exception e2) {
                aa.d("MBResource", e2.getMessage());
            }
        }
        return null;
    }
}
