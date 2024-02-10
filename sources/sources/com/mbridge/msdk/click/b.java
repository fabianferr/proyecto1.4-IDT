package com.mbridge.msdk.click;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.same.report.p;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.u;
import com.mbridge.msdk.foundation.tools.w;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

/* compiled from: CommonClickUtil */
public final class b {
    static Handler a = new Handler(Looper.getMainLooper()) {
        public final void handleMessage(Message message) {
            String str;
            String str2;
            String str3;
            super.handleMessage(message);
            try {
                if (message.what == 1000) {
                    int i = message.arg1;
                    int i2 = message.arg2;
                    Bundle data = message.getData();
                    if (data != null) {
                        String string = data.getString("rid");
                        String string2 = data.getString("cid_n");
                        str = data.getString(CmcdConfiguration.KEY_CONTENT_ID);
                        str3 = string;
                        str2 = string2;
                    } else {
                        str3 = "";
                        str2 = str3;
                        str = str2;
                    }
                    new p(com.mbridge.msdk.foundation.controller.b.d().g()).a(i, i2, str3, str2, str);
                }
            } catch (Throwable th) {
                if (MBridgeConstans.DEBUG) {
                    th.printStackTrace();
                }
            }
        }
    };

    public static void a(Context context, String str) {
        if (str != null && context != null) {
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                intent.addFlags(268435456);
                ResolveInfo resolveActivity = context.getPackageManager().resolveActivity(intent, 65536);
                if (resolveActivity != null) {
                    intent.setClassName(resolveActivity.activityInfo.packageName, resolveActivity.activityInfo.name);
                }
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    intent2.addFlags(268435456);
                    context.startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public static void b(Context context, String str) {
        if (context != null && str != null) {
            try {
                Class.forName("com.mbridge.msdk.activity.MBCommonActivity");
                Intent intent = new Intent(context, Class.forName("com.mbridge.msdk.activity.MBCommonActivity"));
                intent.putExtra("url", str);
                if (!(context instanceof ContextThemeWrapper)) {
                    intent.setFlags(268435456);
                }
                context.startActivity(intent);
            } catch (ClassNotFoundException e) {
                aa.d("CommonClickUtil", e.getMessage());
            } catch (Throwable th) {
                aa.d("CommonClickUtil", th.getMessage());
            }
        }
    }

    public static boolean c(Context context, String str) {
        if (str != null && !"".equals(str)) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 8192);
                if (packageInfo != null) {
                    return str.equals(packageInfo.packageName);
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean d(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            Uri parse = Uri.parse(str);
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            intent.setData(parse);
            if (parse.getScheme().startsWith(u.b("L7QthdSsLkP8")) && a(context, intent)) {
                return true;
            }
            intent.setFlags(268435456);
            context.startActivity(intent);
            return true;
        } catch (Throwable th) {
            aa.b("CommonClickUtil", th.getMessage(), th);
            return false;
        }
    }

    private static boolean a(Context context, Intent intent) {
        try {
            if (context instanceof Activity) {
                context.startActivity(intent);
                return true;
            }
            if (com.mbridge.msdk.foundation.controller.b.d().c() != null) {
                Context c = com.mbridge.msdk.foundation.controller.b.d().c();
                if (!(c instanceof Activity)) {
                    return false;
                }
                c.startActivity(intent);
                return true;
            }
            return false;
        } catch (Throwable th) {
            aa.b("CommonClickUtil", th.getMessage(), th);
        }
    }

    public static void e(Context context, String str) {
        Intent launchIntentForPackage;
        ResolveInfo next;
        try {
            if (!TextUtils.isEmpty(str) && c(context, str) && (launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage(str)) != null) {
                List<ResolveInfo> queryIntentActivities = context.getPackageManager().queryIntentActivities(launchIntentForPackage, 0);
                if (queryIntentActivities.size() > 0 && (next = queryIntentActivities.iterator().next()) != null) {
                    ComponentName componentName = new ComponentName(next.activityInfo.packageName, next.activityInfo.name);
                    Intent intent = new Intent();
                    intent.setComponent(componentName);
                    intent.addFlags(268435456);
                    context.startActivity(intent);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String a(String str, List<String> list, String str2) {
        if (list != null) {
            for (String next : list) {
                if (!TextUtils.isEmpty(next)) {
                    str = str.replaceAll(next, str2);
                }
            }
        }
        return str;
    }

    public static String a(String str, String str2, String str3) {
        Map<String, e.a> am;
        try {
            if (TextUtils.isEmpty(str)) {
                return str;
            }
            String host = Uri.parse(str).getHost();
            e b = f.a().b(com.mbridge.msdk.foundation.controller.b.d().h());
            if (b == null || (am = b.am()) == null || TextUtils.isEmpty(host)) {
                return str;
            }
            for (Map.Entry<String, e.a> key : am.entrySet()) {
                String str4 = (String) key.getKey();
                if (!TextUtils.isEmpty(str4) && host.contains(str4)) {
                    e.a aVar = am.get(str4);
                    if (aVar != null) {
                        return a(a(a(a(str, aVar.d(), String.valueOf((float) w.m(com.mbridge.msdk.foundation.controller.b.d().g()))), aVar.c(), String.valueOf((float) w.l(com.mbridge.msdk.foundation.controller.b.d().g()))), aVar.a(), str2), aVar.b(), str3);
                    }
                    return str;
                }
            }
            return str;
        } catch (Exception e) {
            e.printStackTrace();
            return str;
        }
    }

    public static void a(final Context context, int i, final String str) {
        if (i != 0) {
            try {
                com.mbridge.msdk.foundation.same.f.b.a().execute(new Runnable() {
                    public final void run() {
                        try {
                            Method method = Class.forName("com.mbridge.msdk.foundation.tools.r").getMethod("mia", new Class[]{Context.class, String.class});
                            Context context = context;
                            if (context != null) {
                                method.invoke((Object) null, new Object[]{context, str});
                                return;
                            }
                            aa.d("CommonClickUtil", "Context is null");
                        } catch (Throwable th) {
                            aa.d("CommonClickUtil", th.getMessage());
                        }
                    }
                });
            } catch (Throwable th) {
                aa.d("CommonClickUtil", th.getMessage());
            }
        }
    }
}
