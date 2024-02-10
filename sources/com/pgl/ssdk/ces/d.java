package com.pgl.ssdk.ces;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.LocaleList;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.applovin.impl.sdk.utils.JsonUtils;
import com.facebook.internal.security.CertificateUtil;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.pgl.ssdk.C0237a;
import com.pgl.ssdk.C0239c;
import com.pgl.ssdk.C0240d;
import com.pgl.ssdk.C0241e;
import com.pgl.ssdk.f;
import com.pgl.ssdk.g;
import com.pgl.ssdk.h;
import com.pgl.ssdk.j;
import com.pgl.ssdk.m;
import com.pgl.ssdk.p;
import com.pgl.ssdk.r;
import com.pgl.ssdk.u;
import com.pgl.ssdk.y;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import okhttp3.HttpUrl;
import org.json.JSONObject;

public class d extends Thread {
    private static volatile d f = null;
    private static boolean g = false;
    public static boolean h = false;
    private static Map i;
    public boolean a = false;
    public Context b = null;
    private String c = "";
    private String d = null;
    private boolean e = false;

    private d(Context context, String str) {
        setName("CZL-00");
        this.b = context;
        this.c = str;
    }

    static /* synthetic */ boolean a(boolean z) {
        return z;
    }

    public static String b() {
        if (f != null) {
            return f.d;
        }
        return null;
    }

    public static d c() {
        return f;
    }

    public Object a(int i2, Object obj) {
        if (i2 == 123) {
            return f.a(this.b);
        }
        if (i2 == 121) {
            return (Build.VERSION.SDK_INT >= 24 ? LocaleList.getDefault().get(0) : Locale.getDefault()).getLanguage();
        }
        String str = null;
        if (i2 == 122) {
            try {
                str = TimeZone.getDefault().getDisplayName(false, 0);
            } catch (Throwable unused) {
            }
            if (str != null) {
                return str.trim();
            }
        } else if (i2 == 126) {
            return C0240d.a(this.b);
        } else {
            if (!(i2 == 127 || i2 == 128)) {
                if (i2 == 120) {
                    return C0239c.b();
                }
                if (i2 == 124) {
                    return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
                }
                if (i2 != 130) {
                    if (i2 == 145) {
                        Context context = this.b;
                        WifiManager wifiManager = (WifiManager) context.getApplicationContext().getSystemService("wifi");
                        String str2 = "1";
                        String str3 = (wifiManager == null || !wifiManager.isWifiEnabled()) ? "0" : str2;
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager != null) {
                            StringBuilder sb = new StringBuilder();
                            sb.append(str3);
                            if (telephonyManager.getSimState() != 5) {
                                str2 = "0";
                            }
                            sb.append(str2);
                            return sb.toString();
                        }
                        return str3 + "0";
                    } else if (i2 != 125) {
                        if (i2 == 129) {
                            return C0241e.b(this.b);
                        }
                        if (i2 == 141) {
                            Context context2 = this.b;
                            int i3 = -1;
                            if (context2 != null) {
                                try {
                                    i3 = Settings.System.getInt(context2.getContentResolver(), "screen_brightness", -1);
                                } catch (Throwable unused2) {
                                }
                            }
                            return String.valueOf(i3);
                        } else if (i2 == 131) {
                            return y.a();
                        } else {
                            if (i2 == 132) {
                                a((String) obj);
                            } else if (i2 == 134) {
                                return h.a(this.b).b();
                            } else {
                                if (i2 == 140) {
                                    return g.a(this.b).c();
                                }
                                if (i2 == 144) {
                                    return g.a(this.b).b();
                                }
                                if (i2 == 133) {
                                    try {
                                        JSONObject jSONObject = new JSONObject();
                                        for (Map.Entry entry : i.entrySet()) {
                                            if (entry.getValue() == null) {
                                                jSONObject.put((String) entry.getKey(), "");
                                            } else {
                                                jSONObject.put((String) entry.getKey(), entry.getValue());
                                            }
                                        }
                                        str = jSONObject.toString();
                                    } catch (Throwable unused3) {
                                    }
                                    return str == null ? JsonUtils.EMPTY_JSON : str.trim();
                                } else if (i2 == 135) {
                                    try {
                                        byte[] byteArray = this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64).signatures[0].toByteArray();
                                        MessageDigest instance = MessageDigest.getInstance("SHA1");
                                        if (instance != null) {
                                            byte[] digest = instance.digest(byteArray);
                                            StringBuilder sb2 = new StringBuilder();
                                            for (byte b2 : digest) {
                                                sb2.append(Integer.toHexString((b2 & 255) | 256).substring(1, 3).toUpperCase());
                                                sb2.append(CertificateUtil.DELIMITER);
                                            }
                                            return sb2.substring(0, sb2.length() - 1);
                                        }
                                    } catch (Throwable th) {
                                        th.printStackTrace();
                                    }
                                } else if (i2 == 136) {
                                    return this.b.getPackageManager().getPackageInfo(this.b.getPackageName(), 64).signatures[0].toByteArray();
                                } else {
                                    if (i2 == 201) {
                                        try {
                                            str = Settings.Secure.getString(this.b.getContentResolver(), "android_id");
                                        } catch (Throwable unused4) {
                                        }
                                        if (str != null) {
                                            return str.trim();
                                        }
                                    } else if (i2 != 202) {
                                        if (i2 == 236) {
                                            try {
                                                return Class.forName("android.os.SystemProperties").getDeclaredMethod("get", new Class[]{String.class}).invoke((Object) null, new Object[]{obj});
                                            } catch (Throwable unused5) {
                                            }
                                        } else if (i2 == 142) {
                                            try {
                                                str = this.b.getPackageResourcePath();
                                            } catch (Throwable unused6) {
                                            }
                                            if (str != null) {
                                                return str.trim();
                                            }
                                        } else if (i2 == 143) {
                                            return f.b(this.b);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return null;
            }
        }
        return "";
    }

    public void a(HashMap hashMap) {
        if (hashMap != null) {
            i = hashMap;
        }
    }

    public void run() {
        this.e = true;
        m.b();
        C0237a.a(10000);
        y.a(this.b, this.c, new b(this));
        C0237a.a(10000);
        a("CZL-L1st");
        while (true) {
            int i2 = 0;
            do {
                h.a(this.b).a();
                g.a(this.b).a();
                i2++;
                a.meta(IronSourceConstants.RV_INSTANCE_LOAD_NO_FILL, (Context) null, Thread.currentThread().getName() + "-" + i2);
                C0237a.a(180000);
            } while (((long) i2) <= 10);
        }
    }

    public void b(String str) {
        if (!TextUtils.isEmpty(str) && !str.equals(this.d)) {
            a.meta(103, (Context) null, str);
            if (this.d != null) {
                y.c();
            }
            this.d = str;
        }
        if (!isAlive() || !this.e) {
            try {
                start();
            } catch (Throwable unused) {
            }
        }
    }

    public static String a() {
        if (f != null) {
            return f.c;
        }
        return null;
    }

    public static d a(Context context, String str, int i2) {
        Application application;
        if (f == null) {
            synchronized (d.class) {
                if (f == null) {
                    if (context == null) {
                        try {
                            application = (Application) Class.forName("android.app.ActivityThread").getMethod("currentApplication", new Class[0]).invoke((Object) null, (Object[]) null);
                        } catch (Throwable unused) {
                            application = null;
                        }
                        context = application.getApplicationContext();
                    }
                    if (context == null) {
                        return null;
                    }
                    j.a = i2;
                    if (!p.a(context, "nms")) {
                        return null;
                    }
                    f = new d(context, str);
                    f.a(context);
                    d dVar = f;
                    String str2 = "";
                    SharedPreferences sharedPreferences = context.getSharedPreferences("ss_config", 0);
                    if (sharedPreferences != null) {
                        str2 = sharedPreferences.getString("iid", str2);
                    }
                    if (TextUtils.isEmpty(str2)) {
                        str2 = UUID.randomUUID().toString();
                        SharedPreferences sharedPreferences2 = context.getSharedPreferences("ss_config", 0);
                        if (sharedPreferences2 != null) {
                            sharedPreferences2.edit().putString("iid", str2).commit();
                        }
                    }
                    dVar.getClass();
                    if (!TextUtils.isEmpty(str2)) {
                        a.meta(104, (Context) null, str2);
                    }
                }
            }
        }
        return f;
    }

    private void a(Context context) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6 = "";
        if (context != null && !g) {
            try {
                a.meta(101, (Context) null, "1");
                a.meta(102, (Context) null, this.c);
                a.meta(105, (Context) null, str6 + C0237a.a(context));
                StringBuilder sb = new StringBuilder(str6);
                try {
                    str = context.getPackageName();
                } catch (Throwable unused) {
                    str = null;
                }
                sb.append(str == null ? str6 : str.trim());
                a.meta(106, (Context) null, sb.toString());
                StringBuilder sb2 = new StringBuilder(str6);
                try {
                    str2 = context.getFilesDir().getAbsolutePath();
                } catch (Throwable unused2) {
                    str2 = null;
                }
                sb2.append(str2 == null ? str6 : str2.trim());
                a.meta(107, (Context) null, sb2.toString());
                StringBuilder sb3 = new StringBuilder(str6);
                try {
                    str3 = context.getApplicationInfo().sourceDir;
                } catch (Throwable unused3) {
                    str3 = null;
                }
                sb3.append(str3 == null ? str6 : str3.trim());
                a.meta(108, (Context) null, sb3.toString());
                StringBuilder sb4 = new StringBuilder(str6);
                try {
                    str4 = Environment.getExternalStorageDirectory().getAbsolutePath();
                } catch (Throwable unused4) {
                    str4 = null;
                }
                sb4.append(str4 == null ? str6 : str4.trim());
                a.meta(109, (Context) null, sb4.toString());
                StringBuilder sb5 = new StringBuilder(str6);
                try {
                    str5 = Environment.getDataDirectory().getPath();
                } catch (Throwable unused5) {
                    str5 = null;
                }
                if (str5 != null) {
                    str6 = str5.trim();
                }
                sb5.append(str6);
                a.meta(110, (Context) null, sb5.toString());
                g = true;
            } catch (Throwable unused6) {
            }
        }
    }

    public void a(String str) {
        try {
            r b2 = u.a().b();
            if (b2 != null) {
                b2.post(new c(this, str));
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
