package com.mbridge.msdk.foundation.same.report.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import com.facebook.share.internal.ShareInternalUtility;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.e;
import com.mbridge.msdk.c.f;
import com.mbridge.msdk.foundation.a.a.a;
import com.mbridge.msdk.foundation.controller.b;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.report.m;
import com.mbridge.msdk.foundation.same.report.p;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: CrashHandlerUtil */
public class d implements Thread.UncaughtExceptionHandler {
    private static volatile d c;
    Handler a = new Handler() {
        public final void handleMessage(Message message) {
            Context context;
            HashMap hashMap;
            super.handleMessage(message);
            if (message.what == 101 && (context = (Context) d.this.b.get()) != null && (message.obj instanceof HashMap) && (hashMap = (HashMap) message.obj) != null) {
                new p(context).a((String) hashMap.get("crashinfo"), (File) hashMap.get(ShareInternalUtility.STAGING_PARAM));
            }
        }
    };
    /* access modifiers changed from: private */
    public final WeakReference<Context> b;
    private Thread.UncaughtExceptionHandler d;
    private Throwable e;

    private d(Context context) {
        this.b = new WeakReference<>(context);
    }

    public static d a(Context context) {
        if (c == null) {
            synchronized (d.class) {
                if (c == null) {
                    c = new d(context);
                }
            }
        }
        return c;
    }

    public final void a() {
        this.d = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private String a(Throwable th, String str) {
        try {
            JSONObject a2 = a(str);
            if (a2 == null) {
                return "";
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            a2.put("crashinfo", stringWriter.toString());
            String jSONObject = a2.toString();
            StringBuffer stringBuffer = new StringBuffer("key=2000052");
            if (th != null) {
                stringBuffer.append("&crash_first_index_from_mtg=").append(c.a(th.getStackTrace()));
            } else {
                stringBuffer.append("&crash_first_index_from_mtg=0");
            }
            stringBuffer.append("&exception=" + jSONObject);
            return stringBuffer.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public final JSONObject a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Context context = (Context) this.b.get();
        if (context == null) {
            return null;
        }
        double maxMemory = (double) Runtime.getRuntime().maxMemory();
        Double.isNaN(maxMemory);
        double d2 = (double) Runtime.getRuntime().totalMemory();
        Double.isNaN(d2);
        float f = (float) ((d2 * 1.0d) / 1048576.0d);
        double freeMemory = (double) Runtime.getRuntime().freeMemory();
        Double.isNaN(freeMemory);
        float f2 = (float) ((freeMemory * 1.0d) / 1048576.0d);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        long usableSpace = externalStorageDirectory.getUsableSpace();
        long totalSpace = externalStorageDirectory.getTotalSpace();
        String formatFileSize = Formatter.formatFileSize(context, usableSpace);
        String formatFileSize2 = Formatter.formatFileSize(context, totalSpace);
        jSONObject.put("max_memory", String.valueOf((float) ((maxMemory * 1.0d) / 1048576.0d)));
        jSONObject.put("memoryby_app", String.valueOf(f));
        jSONObject.put("remaining_memory", (double) f2);
        jSONObject.put("sdcard_remainder", formatFileSize);
        jSONObject.put("totalspacestr", formatFileSize2);
        jSONObject.put("crashtime", str);
        String b2 = a.a().b(MBridgeConstans.SDK_APP_ID);
        if (!TextUtils.isEmpty(b2)) {
            jSONObject.put("appid", b2);
        }
        try {
            jSONObject.put("osversion", Build.VERSION.SDK_INT);
            jSONObject.put("appversioncode", b(context));
            jSONObject.put("appversionname", c(context));
            jSONObject.put("appname", d(context));
        } catch (Exception unused) {
            jSONObject.put("osversion", 0);
            jSONObject.put("appversioncode", "-1");
            jSONObject.put("appversionname", "-1");
            jSONObject.put("appname", "");
        }
        return jSONObject;
    }

    private int b(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    private static String c(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e("", e2.getMessage());
            return "";
        }
    }

    private String d(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        m.a().b();
        try {
            this.e = th;
            String b2 = b();
            List<String> b3 = b(b2);
            if (b3.size() > 0) {
                for (int i = 0; i < b3.size(); i++) {
                    a(a(th), b3.get(i), th, thread);
                }
                return;
            }
            a(a(th), b2, th, thread);
        } catch (Exception e2) {
            a(thread, th);
            e2.printStackTrace();
        }
    }

    public static List<String> b(String str) {
        try {
            List<String> a2 = a(str, "<mvpackage>(.*?)</mvpackage>");
            return a2 == null ? new ArrayList() : a2;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    public static String b() {
        try {
            e b2 = f.a().b(b.d().h());
            if (b2 == null) {
                b2 = f.a().b();
            }
            String N = b2.N();
            if (TextUtils.isEmpty(N)) {
                return "<mvpackage>mbridge</mvpackage>";
            }
            return N;
        } catch (Exception unused) {
            return "<mvpackage>mbridge</mvpackage>";
        }
    }

    private String a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < stackTrace.length; i++) {
            sb.append(stackTrace[i].toString() + "\n");
        }
        return sb.toString();
    }

    private void a(String str, String str2, Throwable th, Thread thread) {
        if (str.contains(str2)) {
            HashMap<String, Object> c2 = c();
            if (c2 != null && c2.get(ShareInternalUtility.STAGING_PARAM) != null) {
                Message obtain = Message.obtain();
                HashMap hashMap = new HashMap();
                hashMap.put("crashinfo", a(th, (String) c2.get("time")));
                hashMap.put(ShareInternalUtility.STAGING_PARAM, c2.get(ShareInternalUtility.STAGING_PARAM));
                obtain.obj = hashMap;
                obtain.what = 101;
                this.a.sendMessage(obtain);
                a(thread, th);
                return;
            }
            return;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.d;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private static List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            while (matcher.find()) {
                arrayList.add(matcher.group(1));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    private void a(Thread thread, Throwable th) {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        Process.killProcess(Process.myPid());
    }

    private HashMap<String, Object> c() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (this.e == null) {
            return null;
        }
        String b2 = com.mbridge.msdk.foundation.same.b.e.b(c.MBRIDGE_CRASH_INFO);
        File file = new File(b2 + "/");
        if (!file.exists()) {
            file.mkdirs();
        }
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        File file2 = new File(b2 + "/sdkcrash" + format + ".txt");
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2)));
            printWriter.println(a(this.e, format));
            printWriter.println("====");
            this.e.printStackTrace(printWriter);
            printWriter.close();
            hashMap.put(ShareInternalUtility.STAGING_PARAM, file2);
            hashMap.put("time", format);
            return hashMap;
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
