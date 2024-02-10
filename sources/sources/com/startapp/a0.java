package com.startapp;

import android.app.Activity;
import android.content.Context;
import android.content.ServiceConnection;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.graphics.Paint;
import android.os.Build;
import android.provider.Settings;
import android.webkit.WebView;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

/* compiled from: Sta */
public class a0 {
    public static final /* synthetic */ int a = 0;

    /* compiled from: Sta */
    public class a implements Comparator<Signature> {
        public int compare(Object obj, Object obj2) {
            return ((Signature) obj).toCharsString().compareTo(((Signature) obj2).toCharsString());
        }
    }

    /* compiled from: Sta */
    public interface b {
    }

    static {
        a((Class<?>) a0.class);
    }

    public static int a(int i) {
        return i;
    }

    public static String a(Class<?> cls) {
        StringBuilder a2 = p0.a("startapp.");
        a2.append(cls.getSimpleName());
        return a2.toString();
    }

    public static boolean a() {
        return true;
    }

    public static boolean b(Context context) {
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                if (Settings.Secure.getInt(context.getContentResolver(), "install_non_market_apps") != 1) {
                    return false;
                }
            } else if (Settings.Global.getInt(context.getContentResolver(), "install_non_market_apps") == 1) {
                return true;
            } else {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean c(Context context) {
        try {
            if (c2.k == null) {
                if (c2.j == null) {
                    Context a2 = h0.a(context);
                    if (a2 != null) {
                        context = a2;
                    }
                    c2.j = new c2(context);
                }
                c2.k = Boolean.valueOf(c2.j.c());
            }
            return c2.k.booleanValue();
        } catch (Throwable unused) {
            return false;
        }
    }

    public static int a(Activity activity, int i, boolean z) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        int i2 = 1;
        if (i != 1) {
            if (i == 2) {
                i2 = (z || rotation == 0 || rotation == 1) ? 0 : 8;
            }
        } else if (!z && (rotation == 1 || rotation == 2)) {
            i2 = 9;
        }
        try {
            activity.setRequestedOrientation(i2);
        } catch (Throwable unused) {
        }
        return i2;
    }

    public static void b(WebView webView) {
        webView.onResume();
    }

    public static void a(WebView webView) {
        webView.onPause();
    }

    public static void a(WebView webView, Paint paint) {
        webView.setLayerType(1, (Paint) null);
    }

    public static boolean a(Context context, String str) {
        try {
            if (Build.VERSION.SDK_INT >= 23) {
                if (context.checkSelfPermission(str) == 0) {
                    return true;
                }
                return false;
            } else if (context.checkCallingOrSelfPermission(str) == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String a(String str, Context context) throws FileNotFoundException {
        String str2;
        int i;
        try {
            str2 = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128).sourceDir;
        } catch (Throwable unused) {
            str2 = null;
        }
        if (str2 == null) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(str2);
        StringBuilder sb = new StringBuilder();
        try {
            byte[] bArr = new byte[8192];
            MessageDigest instance = MessageDigest.getInstance(str);
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read == -1) {
                    break;
                } else if (read > 0) {
                    instance.update(bArr, 0, read);
                }
            }
            for (byte b2 : instance.digest()) {
                sb.append(Integer.toString((b2 & 255) + 256, 16).substring(1));
            }
        } catch (Throwable unused2) {
        }
        a((Closeable) fileInputStream);
        return sb.toString().toUpperCase(Locale.ENGLISH);
    }

    public static boolean a(PackageInfo packageInfo) {
        int i = packageInfo.applicationInfo.flags;
        return ((i & 1) == 0 && (i & 128) == 0) ? false : true;
    }

    public static boolean a(Context context, String str, int i) {
        try {
            if (context.getPackageManager().getPackageInfo(str, 128).versionCode >= i) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static List<PackageInfo> a(PackageManager packageManager) throws Exception {
        return (List) packageManager.getClass().getMethod("getInstalledPackages", new Class[]{Integer.TYPE}).invoke(packageManager, new Object[]{8192});
    }

    public static String a(Context context) {
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            if (signatureArr == null || signatureArr.length <= 0) {
                return null;
            }
            if (signatureArr.length == 1) {
                return signatureArr[0].toCharsString();
            }
            Arrays.sort(signatureArr, new a());
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < signatureArr.length; i++) {
                sb.append(signatureArr[i].toCharsString());
                if (i < signatureArr.length - 1) {
                    sb.append(';');
                }
            }
            return sb.toString();
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (Exception unused) {
            }
        }
    }

    public static void a(Context context, ServiceConnection serviceConnection) {
        if (serviceConnection != null) {
            try {
                context.unbindService(serviceConnection);
            } catch (Throwable unused) {
            }
        }
    }
}
