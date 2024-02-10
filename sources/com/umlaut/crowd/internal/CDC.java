package com.umlaut.crowd.internal;

import android.app.ActivityManager;
import android.app.usage.UsageStatsManager;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Point;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.net.ConnectivityManager;
import android.net.TrafficStats;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.provider.Settings;
import android.telephony.SubscriptionInfo;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.KeyCharacterMap;
import android.view.WindowManager;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.enums.ThreeState;
import com.umlaut.crowd.utils.AppUsageUtils;
import com.umlaut.crowd.utils.PermissionUtils;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CDC {
    private static final String a = "CDC";
    private static final boolean b = false;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.umlaut.crowd.internal.d[] r0 = com.umlaut.crowd.internal.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.Full     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.Anonymized     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.d r1 = com.umlaut.crowd.internal.d.None     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.CDC.a.<clinit>():void");
        }
    }

    public static c2 a(Context context) {
        c2 c2Var = new c2();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (defaultDisplay != null) {
            defaultDisplay.getMetrics(displayMetrics);
            c2Var.DisplayPixelDensity = displayMetrics.densityDpi;
            c2Var.DisplayScaledDensity = displayMetrics.scaledDensity;
            int rotation = defaultDisplay.getRotation();
            if (rotation == 0) {
                c2Var.DisplayOrientation = 0;
            } else if (rotation == 1) {
                c2Var.DisplayOrientation = 90;
            } else if (rotation == 2) {
                c2Var.DisplayOrientation = 180;
            } else if (rotation == 3) {
                c2Var.DisplayOrientation = 270;
            }
            c2Var.DisplayRealPixelDensityX = displayMetrics.xdpi;
            c2Var.DisplayRealPixelDensityY = displayMetrics.ydpi;
            Resources resources = context.getResources();
            int identifier = resources.getIdentifier("navigation_bar_height", "dimen", "android");
            if (identifier > 0) {
                resources.getDimensionPixelSize(identifier);
            }
            KeyCharacterMap.deviceHasKey(3);
            Point point = new Point();
            int i = Build.VERSION.SDK_INT;
            defaultDisplay.getRealSize(point);
            c2Var.DisplayPixelWidth = point.x;
            c2Var.DisplayPixelHeight = point.y;
            int i2 = c2Var.DisplayOrientation;
            if (i2 == 90 || i2 == 270) {
                int i3 = c2Var.DisplayPixelHeight;
                c2Var.DisplayPixelHeight = c2Var.DisplayPixelWidth;
                c2Var.DisplayPixelWidth = i3;
            }
            double d = (double) c2Var.DisplayRealPixelDensityX;
            if (d != 0.0d) {
                double d2 = (double) c2Var.DisplayRealPixelDensityY;
                if (d2 != 0.0d) {
                    double d3 = (double) c2Var.DisplayPixelWidth;
                    Double.isNaN(d3);
                    Double.isNaN(d);
                    double d4 = d3 / d;
                    double d5 = (double) c2Var.DisplayPixelHeight;
                    Double.isNaN(d5);
                    Double.isNaN(d2);
                    c2Var.DisplayDimension = Math.sqrt(Math.pow(d4, 2.0d) + Math.pow(d5 / d2, 2.0d));
                }
            }
            int i4 = c2Var.DisplayPixelDensity;
            if (i4 == 120) {
                c2Var.DisplayPixelDensityAndroid = b2.Ldpi;
            } else if (i4 == 160) {
                c2Var.DisplayPixelDensityAndroid = b2.Mdpi;
            } else if (i4 == 240) {
                c2Var.DisplayPixelDensityAndroid = b2.Hdpi;
            } else if (i4 == 320) {
                c2Var.DisplayPixelDensityAndroid = b2.Xhdpi;
            } else if (i4 == 480) {
                c2Var.DisplayPixelDensityAndroid = b2.Xxhdpi;
            } else if (i4 == 640) {
                c2Var.DisplayPixelDensityAndroid = b2.Xxxhdpi;
            } else if (i4 == 280) {
                c2Var.DisplayPixelDensityAndroid = b2.D280;
            } else if (i4 == 400) {
                c2Var.DisplayPixelDensityAndroid = b2.D400;
            } else if (i4 == 560) {
                c2Var.DisplayPixelDensityAndroid = b2.D560;
            } else if (i4 == 213) {
                c2Var.DisplayPixelDensityAndroid = b2.Tv;
            } else {
                c2Var.DisplayPixelDensityAndroid = b2.Unknown;
            }
            c2Var.DisplayRefreshRate = defaultDisplay.getRefreshRate();
            if (i >= 20) {
                int state = defaultDisplay.getState();
                if (state == 0) {
                    c2Var.DisplayState = d2.Unknown;
                } else if (state == 1) {
                    c2Var.DisplayState = d2.Off;
                } else if (state == 2) {
                    c2Var.DisplayState = d2.On;
                } else if (state == 3) {
                    c2Var.DisplayState = d2.Doze;
                } else if (state == 4) {
                    c2Var.DisplayState = d2.DozeSuspend;
                }
            }
        }
        return c2Var;
    }

    public static n3 b(Context context) {
        ConnectivityManager connectivityManager;
        n3 n3Var = new n3();
        n3Var.AppPackageName = context.getPackageName();
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        if (applicationInfo == null) {
            try {
                applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        if (applicationInfo != null) {
            n3Var.AppTargetVersion = applicationInfo.targetSdkVersion;
            n3Var.AppName = (String) applicationInfo.loadLabel(context.getPackageManager());
            if (Build.VERSION.SDK_INT >= 26) {
                n3Var.AppCategory = AppUsageUtils.getAppCategory(applicationInfo.category);
            }
        }
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            if (Build.VERSION.SDK_INT >= 28) {
                n3Var.AppBuildVersion = packageInfo.getLongVersionCode();
            } else {
                n3Var.AppBuildVersion = (long) packageInfo.versionCode;
            }
        } catch (Exception unused2) {
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 24 && (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) != null) {
            int restrictBackgroundStatus = connectivityManager.getRestrictBackgroundStatus();
            if (restrictBackgroundStatus == 1) {
                n3Var.BackgroundDataRestrictionState = r.Disabled;
            } else if (restrictBackgroundStatus == 2) {
                n3Var.BackgroundDataRestrictionState = r.Whitelsted;
            } else if (restrictBackgroundStatus != 3) {
                n3Var.BackgroundDataRestrictionState = r.Unknown;
            } else {
                n3Var.BackgroundDataRestrictionState = r.Enabled;
            }
        }
        if (i >= 28) {
            int appStandbyBucket = ((UsageStatsManager) context.getSystemService("usagestats")).getAppStandbyBucket();
            if (appStandbyBucket == 5) {
                n3Var.AppStandbyBucket = k.Exempted;
            } else if (appStandbyBucket == 10) {
                n3Var.AppStandbyBucket = k.Active;
            } else if (appStandbyBucket == 20) {
                n3Var.AppStandbyBucket = k.WorkingSet;
            } else if (appStandbyBucket == 30) {
                n3Var.AppStandbyBucket = k.Frequent;
            } else if (appStandbyBucket == 40) {
                n3Var.AppStandbyBucket = k.Rare;
            } else if (appStandbyBucket == 45) {
                n3Var.AppStandbyBucket = k.Restricted;
            } else if (appStandbyBucket != 50) {
                n3Var.AppStandbyBucket = k.Unknown;
            } else {
                n3Var.AppStandbyBucket = k.Never;
            }
        }
        ArrayList arrayList = new ArrayList();
        try {
            for (String str : context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions) {
                j jVar = new j();
                jVar.Permission = str.toLowerCase();
                if (str.equalsIgnoreCase("android.permission.PACKAGE_USAGE_STATS")) {
                    jVar.IsGranted = AppUsageUtils.isAppUsageStatsPermissionGranted(context) ? 1 : 0;
                } else {
                    jVar.IsGranted = context.checkPermission(str, Process.myPid(), Process.myUid()) == 0 ? 1 : 0;
                }
                arrayList.add(jVar);
            }
        } catch (Exception unused3) {
        } finally {
            n3Var.AppPermissions = (j[]) arrayList.toArray(new j[0]);
        }
        return n3Var;
    }

    public static w3 c(Context context) {
        PowerManager powerManager;
        w3 w3Var = w3.Unknown;
        int i = Build.VERSION.SDK_INT;
        if (i < 23 || (powerManager = (PowerManager) context.getSystemService("power")) == null) {
            return w3Var;
        }
        if (i >= 24) {
            try {
                if (((Boolean) powerManager.getClass().getDeclaredMethod("isLightDeviceIdleMode", new Class[0]).invoke(powerManager, new Object[0])).booleanValue()) {
                    w3Var = w3.LightIdle;
                }
            } catch (Exception e) {
                String str = a;
                Log.e(str, "getIdleState: " + e.getMessage());
            }
        }
        if (w3Var != w3.LightIdle) {
            return powerManager.isDeviceIdleMode() ? w3.DeepIdle : w3.NonIdle;
        }
        return w3Var;
    }

    public static n5 d(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        n5 n5Var = new n5();
        long j = memoryInfo.availMem;
        n5Var.MemoryFree = j;
        long j2 = memoryInfo.totalMem;
        n5Var.MemoryTotal = j2;
        n5Var.MemoryUsed = j2 - j;
        if (memoryInfo.lowMemory) {
            n5Var.MemoryState = o5.Low;
        } else {
            n5Var.MemoryState = o5.Normal;
        }
        return n5Var;
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:116:0x021e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:123:0x024d */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0233 A[SYNTHETIC, Splitter:B:121:0x0233] */
    /* JADX WARNING: Removed duplicated region for block: B:128:0x0262 A[SYNTHETIC, Splitter:B:128:0x0262] */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0278 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.umlaut.crowd.internal.y5 e(android.content.Context r14) {
        /*
            java.lang.String r0 = "getMultiSimInfo: "
            com.umlaut.crowd.internal.y5 r1 = new com.umlaut.crowd.internal.y5
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 22
            if (r2 < r3) goto L_0x027c
            java.lang.String r2 = "android.permission.READ_PHONE_STATE"
            int r2 = r14.checkCallingOrSelfPermission(r2)
            if (r2 != 0) goto L_0x027c
            java.lang.String r2 = "telephony_subscription_service"
            java.lang.Object r2 = r14.getSystemService(r2)
            android.telephony.SubscriptionManager r2 = (android.telephony.SubscriptionManager) r2
            r3 = -1
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0156
            int r6 = r2.getActiveSubscriptionInfoCount()
            r1.ActiveSimCount = r6
            int r6 = r2.getActiveSubscriptionInfoCountMax()
            r1.ActiveSimCountMax = r6
            java.util.List r6 = r2.getActiveSubscriptionInfoList()
            if (r6 == 0) goto L_0x0116
            int r7 = r6.size()
            if (r7 <= 0) goto L_0x0116
            int r7 = r6.size()
            com.umlaut.crowd.internal.o9[] r7 = new com.umlaut.crowd.internal.o9[r7]
            java.util.Iterator r6 = r6.iterator()
            r8 = 0
        L_0x0046:
            boolean r9 = r6.hasNext()
            if (r9 == 0) goto L_0x0114
            java.lang.Object r9 = r6.next()
            android.telephony.SubscriptionInfo r9 = (android.telephony.SubscriptionInfo) r9
            com.umlaut.crowd.internal.o9 r10 = new com.umlaut.crowd.internal.o9
            r10.<init>()
            java.lang.CharSequence r11 = r9.getCarrierName()     // Catch:{ Exception -> 0x006c }
            if (r11 == 0) goto L_0x0082
            java.lang.CharSequence r11 = r9.getCarrierName()     // Catch:{ Exception -> 0x006c }
            java.lang.String r11 = r11.toString()     // Catch:{ Exception -> 0x006c }
            java.lang.String r11 = com.umlaut.crowd.internal.aa.a((java.lang.String) r11)     // Catch:{ Exception -> 0x006c }
            r10.CarrierName = r11     // Catch:{ Exception -> 0x006c }
            goto L_0x0082
        L_0x006c:
            r11 = move-exception
            java.lang.String r12 = a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r0)
            java.lang.String r11 = r11.getMessage()
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            android.util.Log.e(r12, r11)
        L_0x0082:
            java.lang.String r11 = r9.getCountryIso()     // Catch:{ Exception -> 0x0093 }
            if (r11 == 0) goto L_0x00a9
            java.lang.String r11 = r9.getCountryIso()     // Catch:{ Exception -> 0x0093 }
            java.lang.String r11 = com.umlaut.crowd.internal.aa.a((java.lang.String) r11)     // Catch:{ Exception -> 0x0093 }
            r10.CountryIso = r11     // Catch:{ Exception -> 0x0093 }
            goto L_0x00a9
        L_0x0093:
            r11 = move-exception
            java.lang.String r12 = a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r0)
            java.lang.String r11 = r11.getMessage()
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            android.util.Log.e(r12, r11)
        L_0x00a9:
            java.lang.String r11 = r9.getIccId()     // Catch:{ Exception -> 0x00be }
            if (r11 == 0) goto L_0x00d4
            java.lang.String r11 = r9.getIccId()     // Catch:{ Exception -> 0x00be }
            java.lang.String r11 = com.umlaut.crowd.internal.aa.a((java.lang.String) r11)     // Catch:{ Exception -> 0x00be }
            java.lang.String r11 = a((java.lang.String) r11)     // Catch:{ Exception -> 0x00be }
            r10.IccId = r11     // Catch:{ Exception -> 0x00be }
            goto L_0x00d4
        L_0x00be:
            r11 = move-exception
            java.lang.String r12 = a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r0)
            java.lang.String r11 = r11.getMessage()
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            android.util.Log.e(r12, r11)
        L_0x00d4:
            int r11 = r9.getMcc()
            r12 = 2147483647(0x7fffffff, float:NaN)
            if (r11 != r12) goto L_0x00df
            r11 = -1
            goto L_0x00e3
        L_0x00df:
            int r11 = r9.getMcc()
        L_0x00e3:
            r10.Mcc = r11
            int r11 = r9.getMnc()
            if (r11 != r12) goto L_0x00ed
            r11 = -1
            goto L_0x00f1
        L_0x00ed:
            int r11 = r9.getMnc()
        L_0x00f1:
            r10.Mnc = r11
            int r11 = r9.getSimSlotIndex()
            r10.SimSlotIndex = r11
            int r11 = r9.getSubscriptionId()
            r10.SubscriptionId = r11
            int r9 = r9.getDataRoaming()
            if (r9 != r4) goto L_0x0107
            r9 = 1
            goto L_0x0108
        L_0x0107:
            r9 = 0
        L_0x0108:
            r10.DataRoaming = r9
            int r9 = r10.SubscriptionId
            a(r14, r9, r10)
            r7[r8] = r10
            int r8 = r8 + r4
            goto L_0x0046
        L_0x0114:
            r1.SimInfos = r7
        L_0x0116:
            int r0 = android.os.Build.VERSION.SDK_INT
            r6 = 24
            if (r0 < r6) goto L_0x0123
            int r7 = b()
            r1.DefaultDataSimId = r7
            goto L_0x0129
        L_0x0123:
            int r7 = a((android.telephony.SubscriptionManager) r2)
            r1.DefaultDataSimId = r7
        L_0x0129:
            if (r0 < r6) goto L_0x0132
            int r7 = c()
            r1.DefaultSmsSimId = r7
            goto L_0x0138
        L_0x0132:
            int r7 = b((android.telephony.SubscriptionManager) r2)
            r1.DefaultSmsSimId = r7
        L_0x0138:
            if (r0 < r6) goto L_0x0141
            int r7 = d()
            r1.DefaultSimId = r7
            goto L_0x0147
        L_0x0141:
            int r7 = c((android.telephony.SubscriptionManager) r2)
            r1.DefaultSimId = r7
        L_0x0147:
            if (r0 < r6) goto L_0x0150
            int r0 = e()
            r1.DefaultVoiceSimId = r0
            goto L_0x0156
        L_0x0150:
            int r0 = d((android.telephony.SubscriptionManager) r2)
            r1.DefaultVoiceSimId = r0
        L_0x0156:
            java.lang.String r0 = "phone"
            java.lang.Object r14 = r14.getSystemService(r0)
            android.telephony.TelephonyManager r14 = (android.telephony.TelephonyManager) r14
            if (r14 == 0) goto L_0x027c
            r0 = 0
            java.lang.Class r2 = r14.getClass()     // Catch:{ NoSuchMethodException -> 0x016e }
            java.lang.String r6 = "getMultiSimConfiguration"
            java.lang.Class[] r7 = new java.lang.Class[r5]     // Catch:{ NoSuchMethodException -> 0x016e }
            java.lang.reflect.Method r2 = r2.getDeclaredMethod(r6, r7)     // Catch:{ NoSuchMethodException -> 0x016e }
            goto L_0x0170
        L_0x016e:
            r2 = r0
        L_0x0170:
            if (r2 == 0) goto L_0x01cb
            java.lang.Object[] r6 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x01cb }
            java.lang.Object r2 = r2.invoke(r14, r6)     // Catch:{ Exception -> 0x01cb }
            boolean r6 = r2 instanceof java.lang.Enum     // Catch:{ Exception -> 0x01cb }
            if (r6 == 0) goto L_0x01cb
            java.lang.String r2 = r2.toString()     // Catch:{ Exception -> 0x01cb }
            int r6 = r2.hashCode()     // Catch:{ Exception -> 0x01cb }
            r7 = 2107724(0x20294c, float:2.95355E-39)
            r8 = 2
            if (r6 == r7) goto L_0x01a9
            r7 = 2107742(0x20295e, float:2.953576E-39)
            if (r6 == r7) goto L_0x019f
            r7 = 2584894(0x27713e, float:3.622208E-39)
            if (r6 == r7) goto L_0x0195
            goto L_0x01b2
        L_0x0195:
            java.lang.String r6 = "TSTS"
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x01cb }
            if (r2 == 0) goto L_0x01b2
            r3 = 2
            goto L_0x01b2
        L_0x019f:
            java.lang.String r6 = "DSDS"
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x01cb }
            if (r2 == 0) goto L_0x01b2
            r3 = 1
            goto L_0x01b2
        L_0x01a9:
            java.lang.String r6 = "DSDA"
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x01cb }
            if (r2 == 0) goto L_0x01b2
            r3 = 0
        L_0x01b2:
            if (r3 == 0) goto L_0x01c7
            if (r3 == r4) goto L_0x01c2
            if (r3 == r8) goto L_0x01bd
            com.umlaut.crowd.internal.z5 r2 = com.umlaut.crowd.internal.z5.Unknown     // Catch:{ Exception -> 0x01cb }
            r1.MultiSimVariant = r2     // Catch:{ Exception -> 0x01cb }
            goto L_0x01cb
        L_0x01bd:
            com.umlaut.crowd.internal.z5 r2 = com.umlaut.crowd.internal.z5.TSTS     // Catch:{ Exception -> 0x01cb }
            r1.MultiSimVariant = r2     // Catch:{ Exception -> 0x01cb }
            goto L_0x01cb
        L_0x01c2:
            com.umlaut.crowd.internal.z5 r2 = com.umlaut.crowd.internal.z5.DSDS     // Catch:{ Exception -> 0x01cb }
            r1.MultiSimVariant = r2     // Catch:{ Exception -> 0x01cb }
            goto L_0x01cb
        L_0x01c7:
            com.umlaut.crowd.internal.z5 r2 = com.umlaut.crowd.internal.z5.DSDA     // Catch:{ Exception -> 0x01cb }
            r1.MultiSimVariant = r2     // Catch:{ Exception -> 0x01cb }
        L_0x01cb:
            com.umlaut.crowd.internal.o9[] r2 = r1.SimInfos
            int r3 = r2.length
            r6 = 0
        L_0x01cf:
            if (r6 >= r3) goto L_0x027c
            r7 = r2[r6]
            java.lang.Class r8 = r14.getClass()     // Catch:{ NoSuchMethodException -> 0x01e4 }
            java.lang.String r9 = "getSimState"
            java.lang.Class[] r10 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x01e4 }
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x01e4 }
            r10[r5] = r11     // Catch:{ NoSuchMethodException -> 0x01e4 }
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r9, r10)     // Catch:{ NoSuchMethodException -> 0x01e4 }
            goto L_0x01e6
        L_0x01e4:
            r8 = r0
        L_0x01e6:
            if (r8 == 0) goto L_0x021e
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x021e }
            int r10 = r7.SimSlotIndex     // Catch:{ Exception -> 0x021e }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x021e }
            r9[r5] = r10     // Catch:{ Exception -> 0x021e }
            java.lang.Object r8 = r8.invoke(r14, r9)     // Catch:{ Exception -> 0x021e }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ Exception -> 0x021e }
            int r8 = r8.intValue()     // Catch:{ Exception -> 0x021e }
            switch(r8) {
                case 1: goto L_0x021a;
                case 2: goto L_0x0217;
                case 3: goto L_0x0214;
                case 4: goto L_0x0211;
                case 5: goto L_0x020e;
                case 6: goto L_0x020b;
                case 7: goto L_0x0208;
                case 8: goto L_0x0205;
                case 9: goto L_0x0202;
                default: goto L_0x01ff;
            }     // Catch:{ Exception -> 0x021e }
        L_0x01ff:
            com.umlaut.crowd.internal.p9 r8 = com.umlaut.crowd.internal.p9.Unknown     // Catch:{ Exception -> 0x021e }
            goto L_0x021c
        L_0x0202:
            com.umlaut.crowd.internal.p9 r8 = com.umlaut.crowd.internal.p9.CardRestricted     // Catch:{ Exception -> 0x021e }
            goto L_0x021c
        L_0x0205:
            com.umlaut.crowd.internal.p9 r8 = com.umlaut.crowd.internal.p9.CardIoError     // Catch:{ Exception -> 0x021e }
            goto L_0x021c
        L_0x0208:
            com.umlaut.crowd.internal.p9 r8 = com.umlaut.crowd.internal.p9.PermanentlyDisabled     // Catch:{ Exception -> 0x021e }
            goto L_0x021c
        L_0x020b:
            com.umlaut.crowd.internal.p9 r8 = com.umlaut.crowd.internal.p9.NotReady     // Catch:{ Exception -> 0x021e }
            goto L_0x021c
        L_0x020e:
            com.umlaut.crowd.internal.p9 r8 = com.umlaut.crowd.internal.p9.Ready     // Catch:{ Exception -> 0x021e }
            goto L_0x021c
        L_0x0211:
            com.umlaut.crowd.internal.p9 r8 = com.umlaut.crowd.internal.p9.NetworkLocked     // Catch:{ Exception -> 0x021e }
            goto L_0x021c
        L_0x0214:
            com.umlaut.crowd.internal.p9 r8 = com.umlaut.crowd.internal.p9.PukRequired     // Catch:{ Exception -> 0x021e }
            goto L_0x021c
        L_0x0217:
            com.umlaut.crowd.internal.p9 r8 = com.umlaut.crowd.internal.p9.PinRequired     // Catch:{ Exception -> 0x021e }
            goto L_0x021c
        L_0x021a:
            com.umlaut.crowd.internal.p9 r8 = com.umlaut.crowd.internal.p9.Absent     // Catch:{ Exception -> 0x021e }
        L_0x021c:
            r7.SimState = r8     // Catch:{ Exception -> 0x021e }
        L_0x021e:
            java.lang.Class r8 = r14.getClass()     // Catch:{ NoSuchMethodException -> 0x022f }
            java.lang.String r9 = "getSubscriberId"
            java.lang.Class[] r10 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x022f }
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x022f }
            r10[r5] = r11     // Catch:{ NoSuchMethodException -> 0x022f }
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r9, r10)     // Catch:{ NoSuchMethodException -> 0x022f }
            goto L_0x0231
        L_0x022f:
            r8 = r0
        L_0x0231:
            if (r8 == 0) goto L_0x024d
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x024d }
            int r10 = r7.SubscriptionId     // Catch:{ Exception -> 0x024d }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x024d }
            r9[r5] = r10     // Catch:{ Exception -> 0x024d }
            java.lang.Object r8 = r8.invoke(r14, r9)     // Catch:{ Exception -> 0x024d }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x024d }
            java.lang.String r8 = com.umlaut.crowd.internal.aa.a((java.lang.String) r8)     // Catch:{ Exception -> 0x024d }
            java.lang.String r8 = b((java.lang.String) r8)     // Catch:{ Exception -> 0x024d }
            r7.IMSI = r8     // Catch:{ Exception -> 0x024d }
        L_0x024d:
            java.lang.Class r8 = r14.getClass()     // Catch:{ NoSuchMethodException -> 0x025e }
            java.lang.String r9 = "getGroupIdLevel1"
            java.lang.Class[] r10 = new java.lang.Class[r4]     // Catch:{ NoSuchMethodException -> 0x025e }
            java.lang.Class r11 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x025e }
            r10[r5] = r11     // Catch:{ NoSuchMethodException -> 0x025e }
            java.lang.reflect.Method r8 = r8.getDeclaredMethod(r9, r10)     // Catch:{ NoSuchMethodException -> 0x025e }
            goto L_0x0260
        L_0x025e:
            r8 = r0
        L_0x0260:
            if (r8 == 0) goto L_0x0278
            java.lang.Object[] r9 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0278 }
            int r10 = r7.SubscriptionId     // Catch:{ Exception -> 0x0278 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)     // Catch:{ Exception -> 0x0278 }
            r9[r5] = r10     // Catch:{ Exception -> 0x0278 }
            java.lang.Object r8 = r8.invoke(r14, r9)     // Catch:{ Exception -> 0x0278 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ Exception -> 0x0278 }
            java.lang.String r8 = com.umlaut.crowd.internal.aa.a((java.lang.String) r8)     // Catch:{ Exception -> 0x0278 }
            r7.GroupIdentifierLevel1 = r8     // Catch:{ Exception -> 0x0278 }
        L_0x0278:
            int r6 = r6 + 1
            goto L_0x01cf
        L_0x027c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.CDC.e(android.content.Context):com.umlaut.crowd.internal.y5");
    }

    public static nc f() {
        nc ncVar = new nc();
        ncVar.MobileRxBytes = pc.e();
        ncVar.MobileTxBytes = pc.f();
        ncVar.TotalRxBytes = TrafficStats.getTotalRxBytes();
        ncVar.TotalTxBytes = TrafficStats.getTotalTxBytes();
        ncVar.WifiRxBytes = InsightCore.getWifiController().f();
        ncVar.WifiTxBytes = InsightCore.getWifiController().h();
        return ncVar;
    }

    private static c9[] g(Context context) {
        ArrayList arrayList = new ArrayList();
        SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
        if (sensorManager != null) {
            for (Sensor next : sensorManager.getSensorList(-1)) {
                c9 c9Var = new c9();
                c9Var.SensorName = aa.a(next.getName());
                c9Var.SensorVendor = aa.a(next.getVendor());
                c9Var.SensorVersion = next.getVersion();
                c9Var.SensorPower = p6.a(next.getPower(), -1.0f);
                c9Var.SensorResolution = next.getResolution();
                c9Var.SensorMinDelay = next.getMinDelay();
                c9Var.SensorMaximumRange = next.getMaximumRange();
                if (Build.VERSION.SDK_INT >= 21) {
                    c9Var.SensorMaxDelay = next.getMaxDelay();
                    c9Var.SensorIsWakeUp = next.isWakeUpSensor();
                    int reportingMode = next.getReportingMode();
                    if (reportingMode == 0) {
                        c9Var.SensorReportingMode = d9.Continuos;
                    } else if (reportingMode == 1) {
                        c9Var.SensorReportingMode = d9.OnChange;
                    } else if (reportingMode == 2) {
                        c9Var.SensorReportingMode = d9.OneShot;
                    } else if (reportingMode != 3) {
                        c9Var.SensorReportingMode = d9.Unknown;
                    } else {
                        c9Var.SensorReportingMode = d9.SpecialTrigger;
                    }
                }
                switch (next.getType()) {
                    case 1:
                        c9Var.SensorType = e9.Accelerometer;
                        break;
                    case 2:
                        c9Var.SensorType = e9.MagneticField;
                        break;
                    case 3:
                        c9Var.SensorType = e9.Orientation;
                        break;
                    case 4:
                        c9Var.SensorType = e9.Gyroscope;
                        break;
                    case 5:
                        c9Var.SensorType = e9.Light;
                        break;
                    case 6:
                        c9Var.SensorType = e9.Pressure;
                        break;
                    case 7:
                        c9Var.SensorType = e9.Temperature;
                        break;
                    case 8:
                        c9Var.SensorType = e9.Proximity;
                        break;
                    case 9:
                        c9Var.SensorType = e9.Gravity;
                        break;
                    case 10:
                        c9Var.SensorType = e9.LinearAcceleration;
                        break;
                    case 11:
                        c9Var.SensorType = e9.RotationVector;
                        break;
                    case 12:
                        c9Var.SensorType = e9.RelativeHumidity;
                        break;
                    case 13:
                        c9Var.SensorType = e9.AmbientTemperature;
                        break;
                    case 14:
                        c9Var.SensorType = e9.MagneticFieldUncalibrated;
                        break;
                    case 15:
                        c9Var.SensorType = e9.GameRotationVector;
                        break;
                    case 16:
                        c9Var.SensorType = e9.GyroscopeUncalibrated;
                        break;
                    case 17:
                        c9Var.SensorType = e9.SignificantMotion;
                        break;
                    case 18:
                        c9Var.SensorType = e9.StepDetector;
                        break;
                    case 19:
                        c9Var.SensorType = e9.StepCounter;
                        break;
                    case 20:
                        c9Var.SensorType = e9.GeomagneticRotationVector;
                        break;
                    case 21:
                        c9Var.SensorType = e9.HeartRate;
                        break;
                    default:
                        c9Var.SensorType = e9.Unknown;
                        break;
                }
                arrayList.add(c9Var);
            }
        }
        return (c9[]) arrayList.toArray(new c9[arrayList.size()]);
    }

    public static a2 getDeviceInfo(Context context) {
        String[] strArr;
        p9 p9Var;
        a2 a2Var = new a2();
        a2Var.DeviceManufacturer = Build.MANUFACTURER;
        a2Var.DeviceName = Build.MODEL;
        a2Var.OS = r6.Android;
        a2Var.OSVersion = Build.VERSION.RELEASE;
        a2Var.BuildFingerprint = Build.FINGERPRINT;
        a2Var.DeviceUpTime = SystemClock.elapsedRealtime();
        a2Var.UserLocal = Locale.getDefault().toString();
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            a2Var.SimOperator = aa.a(telephonyManager.getSimOperator());
            a2Var.SimOperatorName = aa.a(telephonyManager.getSimOperatorName());
            if (context.checkCallingOrSelfPermission("android.permission.READ_PHONE_STATE") == 0 && Build.VERSION.SDK_INT < 29) {
                String deviceId = telephonyManager.getDeviceId();
                if (deviceId != null && deviceId.length() >= 8) {
                    a2Var.TAC = deviceId.substring(0, 8);
                }
            } else if (Build.VERSION.SDK_INT >= 29) {
                String typeAllocationCode = telephonyManager.getTypeAllocationCode();
                if (typeAllocationCode == null || typeAllocationCode.isEmpty()) {
                    String manufacturerCode = telephonyManager.getManufacturerCode();
                    if (manufacturerCode != null && !manufacturerCode.isEmpty()) {
                        a2Var.TAC = manufacturerCode;
                    }
                } else {
                    a2Var.TAC = typeAllocationCode;
                }
            }
            int simState = telephonyManager.getSimState();
            if (simState == 1) {
                p9Var = p9.Absent;
            } else if (simState == 2) {
                p9Var = p9.PinRequired;
            } else if (simState == 3) {
                p9Var = p9.PukRequired;
            } else if (simState == 4) {
                p9Var = p9.NetworkLocked;
            } else if (simState != 5) {
                p9Var = p9.Unknown;
            } else {
                p9Var = p9.Ready;
            }
            a2Var.SimState = p9Var;
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    a2Var.PhoneCount = ((Integer) telephonyManager.getClass().getDeclaredMethod("getPhoneCount", new Class[0]).invoke(telephonyManager, new Object[0])).intValue();
                } catch (Exception e) {
                    String str = a;
                    Log.e(str, "getPhoneCount: " + e.getMessage());
                }
            }
            v6 v6Var = v6.Unknown;
            int phoneType = telephonyManager.getPhoneType();
            if (phoneType == 0) {
                v6Var = v6.None;
            } else if (phoneType == 1) {
                v6Var = v6.GSM;
            } else if (phoneType == 2) {
                v6Var = v6.CDMA;
            } else if (phoneType == 3) {
                v6Var = v6.SIP;
            }
            a2Var.PhoneType = v6Var;
        }
        a2Var.IsRooted = a();
        if (Build.VERSION.SDK_INT <= 24) {
            strArr = i9.a("/proc/version");
        } else {
            strArr = i9.b("uname -a");
        }
        if (strArr.length > 0) {
            a2Var.OsSystemVersion = aa.a(strArr[0]);
        }
        a2Var.CpuInfo = j1.a();
        a2Var.DisplayInfo = a(context);
        a2Var.Sensors = g(context);
        try {
            a2Var.BluetoothInfo = InsightCore.getBluetoothController().a();
        } catch (Exception unused) {
        }
        a2Var.PowerSaveMode = getPowerSaveMode(context);
        a2Var.MultiSimInfo = e(context);
        a2Var.HostAppInfo = b(context);
        return a2Var;
    }

    public static ThreeState getPowerSaveMode(Context context) {
        try {
            String string = Settings.System.getString(context.getContentResolver(), "user_powersaver_enable");
            if (string != null) {
                return string.equals("1") ? ThreeState.Enabled : ThreeState.Disabled;
            }
            int i = Build.VERSION.SDK_INT;
            if (i >= 21) {
                if (Build.MANUFACTURER.toLowerCase().startsWith("sony") && i < 23) {
                    return ThreeState.Unknown;
                }
                PowerManager powerManager = (PowerManager) context.getSystemService("power");
                if (powerManager != null) {
                    return powerManager.isPowerSaveMode() ? ThreeState.Enabled : ThreeState.Disabled;
                }
            }
            return ThreeState.Unknown;
        } catch (Exception e) {
            String str = a;
            Log.e(str, "getPowerSaveMode: " + e.getMessage());
        }
    }

    public static o9 h(Context context) {
        return e(context).getDefaultDataSimInfo();
    }

    public static o9 i(Context context) {
        return e(context).getDefaultVoiceSimInfo();
    }

    public static y9 j(Context context) {
        y9 y9Var = new y9();
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = (long) statFs.getBlockSize();
        y9Var.StorageInternalSize = ((long) statFs.getBlockCount()) * blockSize;
        y9Var.StorageInternalAvailable = blockSize * ((long) statFs.getAvailableBlocks());
        y9Var.StorageInternalAudio = a(context, MediaStore.Audio.Media.INTERNAL_CONTENT_URI);
        y9Var.StorageInternalImages = a(context, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        y9Var.StorageInternalVideo = a(context, MediaStore.Video.Media.INTERNAL_CONTENT_URI);
        if (g()) {
            try {
                StatFs statFs2 = new StatFs(Environment.getExternalStorageDirectory().getPath());
                long blockSize2 = (long) statFs2.getBlockSize();
                y9Var.StorageExternalSize = ((long) statFs2.getBlockCount()) * blockSize2;
                y9Var.StorageExternalAvailable = blockSize2 * ((long) statFs2.getAvailableBlocks());
            } catch (IllegalArgumentException unused) {
                y9Var.StorageExternalSize = -1;
                y9Var.StorageExternalAvailable = -1;
            }
            if (context.checkCallingOrSelfPermission("android.permission.READ_EXTERNAL_STORAGE") == 0) {
                y9Var.StorageExternalAudio = a(context, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
                y9Var.StorageExternalImages = a(context, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                y9Var.StorageExternalVideo = a(context, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
            }
        }
        return y9Var;
    }

    public static int[] k(Context context) {
        SubscriptionManager subscriptionManager;
        List<SubscriptionInfo> activeSubscriptionInfoList;
        int i = 0;
        if (Build.VERSION.SDK_INT < 22 || !PermissionUtils.hasReadPhoneStatePermission(context) || (subscriptionManager = (SubscriptionManager) context.getSystemService("telephony_subscription_service")) == null || (activeSubscriptionInfoList = subscriptionManager.getActiveSubscriptionInfoList()) == null || activeSubscriptionInfoList.size() <= 0) {
            return new int[0];
        }
        int[] iArr = new int[activeSubscriptionInfoList.size()];
        for (SubscriptionInfo subscriptionId : activeSubscriptionInfoList) {
            iArr[i] = subscriptionId.getSubscriptionId();
            i++;
        }
        return iArr;
    }

    public static boolean l(Context context) {
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        ((ActivityManager) context.getSystemService("activity")).getMemoryInfo(memoryInfo);
        return !memoryInfo.lowMemory;
    }

    public static z8 f(Context context) {
        z8 z8Var = z8.Unknown;
        PowerManager powerManager = (PowerManager) context.getSystemService("power");
        if (powerManager != null) {
            return powerManager.isScreenOn() ? z8.On : z8.Off;
        }
        return z8Var;
    }

    public static int d() {
        return SubscriptionManager.getDefaultSubscriptionId();
    }

    private static int d(SubscriptionManager subscriptionManager) {
        Method method;
        try {
            method = subscriptionManager.getClass().getDeclaredMethod("getDefaultVoiceSubscriptionId", new Class[0]);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method == null) {
            try {
                method = subscriptionManager.getClass().getDeclaredMethod("getDefaultVoiceSubId", new Class[0]);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (method == null) {
            return -1;
        }
        try {
            return ((Integer) method.invoke(subscriptionManager, new Object[0])).intValue();
        } catch (Exception unused3) {
            return -1;
        }
    }

    public static int c() {
        return SubscriptionManager.getDefaultSmsSubscriptionId();
    }

    private static int c(SubscriptionManager subscriptionManager) {
        Method method;
        try {
            method = subscriptionManager.getClass().getDeclaredMethod("getDefaultSubscriptionId", new Class[0]);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method == null) {
            try {
                method = subscriptionManager.getClass().getDeclaredMethod("getDefaultSubId", new Class[0]);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (method == null) {
            return -1;
        }
        try {
            return ((Integer) method.invoke(subscriptionManager, new Object[0])).intValue();
        } catch (Exception unused3) {
            return -1;
        }
    }

    private static boolean a() {
        String[] strArr = {"/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su", "/system/bin/failsafe/su", "/data/local/su", "/su/bin/su"};
        for (int i = 0; i < 10; i++) {
            if (new File(strArr[i]).exists()) {
                return true;
            }
        }
        return false;
    }

    private static long a(Context context, Uri uri) {
        Cursor cursor = null;
        try {
            cursor = context.getContentResolver().query(uri, new String[]{"_size"}, (String) null, (String[]) null, (String) null);
            long j = 0;
            if (cursor != null) {
                if (cursor.getCount() == 0) {
                    cursor.close();
                    return 0;
                }
                while (cursor.moveToNext()) {
                    j += cursor.getLong(cursor.getColumnIndexOrThrow("_size"));
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (Exception e) {
            e.printStackTrace();
            if (cursor == null) {
                return -1;
            }
            cursor.close();
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public static o9 a(int i, Context context) {
        return e(context).getSimInfoSubId(i);
    }

    private static int a(SubscriptionManager subscriptionManager) {
        Method method;
        try {
            method = subscriptionManager.getClass().getDeclaredMethod("getDefaultDataSubscriptionId", new Class[0]);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method == null) {
            try {
                method = subscriptionManager.getClass().getDeclaredMethod("getDefaultDataSubId", new Class[0]);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (method == null) {
            return -1;
        }
        try {
            return ((Integer) method.invoke(subscriptionManager, new Object[0])).intValue();
        } catch (Exception unused3) {
            return -1;
        }
    }

    public static int b() {
        return SubscriptionManager.getDefaultDataSubscriptionId();
    }

    private static int b(SubscriptionManager subscriptionManager) {
        Method method;
        try {
            method = subscriptionManager.getClass().getDeclaredMethod("getDefaultSmsSubscriptionId", new Class[0]);
        } catch (NoSuchMethodException unused) {
            method = null;
        }
        if (method == null) {
            try {
                method = subscriptionManager.getClass().getDeclaredMethod("getDefaultSmsSubId", new Class[0]);
            } catch (NoSuchMethodException unused2) {
            }
        }
        if (method == null) {
            return -1;
        }
        try {
            return ((Integer) method.invoke(subscriptionManager, new Object[0])).intValue();
        } catch (Exception unused3) {
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004e, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004f, code lost:
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        r10 = null;
        r0 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0059, code lost:
        if (r2 == null) goto L_0x006d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0066, code lost:
        if (r2 != null) goto L_0x0068;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004e A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x002f] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x005f A[SYNTHETIC, Splitter:B:28:0x005f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void a(android.content.Context r9, int r10, com.umlaut.crowd.internal.o9 r11) {
        /*
            java.lang.String r0 = "type"
            java.lang.String r1 = "apn"
            r2 = -1
            if (r10 == r2) goto L_0x0017
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "content://telephony/carriers/preferapn/subId/"
            r2.<init>(r3)
            r2.append(r10)
            java.lang.String r10 = r2.toString()
            goto L_0x0019
        L_0x0017:
            java.lang.String r10 = "content://telephony/carriers/preferapn"
        L_0x0019:
            r2 = 0
            android.net.Uri r4 = android.net.Uri.parse(r10)     // Catch:{ Exception -> 0x0063, all -> 0x005c }
            android.content.ContentResolver r3 = r9.getContentResolver()     // Catch:{ Exception -> 0x0063, all -> 0x005c }
            java.lang.String[] r5 = new java.lang.String[]{r1, r0}     // Catch:{ Exception -> 0x0063, all -> 0x005c }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r9 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0063, all -> 0x005c }
            if (r9 == 0) goto L_0x0056
            boolean r10 = r9.moveToFirst()     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            if (r10 == 0) goto L_0x0056
            int r10 = r9.getColumnIndexOrThrow(r1)     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            java.lang.String r10 = r9.getString(r10)     // Catch:{ Exception -> 0x0051, all -> 0x004e }
            int r0 = r9.getColumnIndexOrThrow(r0)     // Catch:{ Exception -> 0x004b, all -> 0x004e }
            java.lang.String r0 = r9.getString(r0)     // Catch:{ Exception -> 0x004b, all -> 0x004e }
            r9.close()     // Catch:{ Exception -> 0x0049, all -> 0x004e }
            goto L_0x0059
        L_0x0049:
            goto L_0x0054
        L_0x004b:
            r0 = r2
            goto L_0x0054
        L_0x004e:
            r10 = move-exception
            r2 = r9
            goto L_0x005d
        L_0x0051:
            r10 = r2
            r0 = r10
        L_0x0054:
            r2 = r9
            goto L_0x0066
        L_0x0056:
            r10 = r2
            r0 = r10
            r2 = r9
        L_0x0059:
            if (r2 == 0) goto L_0x006d
            goto L_0x0068
        L_0x005c:
            r10 = move-exception
        L_0x005d:
            if (r2 == 0) goto L_0x0062
            r2.close()     // Catch:{ Exception -> 0x0062 }
        L_0x0062:
            throw r10
        L_0x0063:
            r10 = r2
            r0 = r10
        L_0x0066:
            if (r2 == 0) goto L_0x006d
        L_0x0068:
            r2.close()     // Catch:{ Exception -> 0x006c }
            goto L_0x006d
        L_0x006c:
        L_0x006d:
            if (r10 != 0) goto L_0x007e
            java.lang.String r9 = "getprop ril.attach.apn"
            java.lang.String[] r9 = com.umlaut.crowd.internal.i9.b(r9)
            int r1 = r9.length
            if (r1 <= 0) goto L_0x007e
            r1 = 0
            r9 = r9[r1]
            if (r9 == 0) goto L_0x007e
            r10 = r9
        L_0x007e:
            if (r10 == 0) goto L_0x0082
            r11.Apn = r10
        L_0x0082:
            if (r0 == 0) goto L_0x0086
            r11.ApnTypes = r0
        L_0x0086:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.CDC.a(android.content.Context, int, com.umlaut.crowd.internal.o9):void");
    }

    private static String b(String str) {
        int i;
        if (str.length() == 0 || (i = a.a[InsightCore.getInsightConfig().k1().ordinal()]) == 1) {
            return str;
        }
        if (i != 2) {
            return "";
        }
        if (str.length() < 14) {
            return str.replaceAll("[\\d\\w]", "*");
        }
        String substring = str.substring(0, 10);
        String replaceAll = str.substring(10, str.length()).replaceAll("[\\d\\w]", "*");
        return substring + replaceAll;
    }

    private static String a(String str) {
        int i;
        if (str.length() == 0 || (i = a.a[InsightCore.getInsightConfig().j1().ordinal()]) == 1) {
            return str;
        }
        if (i != 2) {
            return "";
        }
        if (str.length() < 11) {
            return str.replaceAll("[\\d\\w]", "*");
        }
        String substring = str.substring(0, 7);
        String replaceAll = str.substring(7, str.length()).replaceAll("[\\d\\w]", "*");
        return substring + replaceAll;
    }

    public static int e() {
        return SubscriptionManager.getDefaultVoiceSubscriptionId();
    }

    private static boolean g() {
        try {
            return Environment.getExternalStorageState().equals("mounted");
        } catch (Exception e) {
            String str = a;
            Log.d(str, "isExternalMemoryAvailable: " + e.getMessage());
            return false;
        }
    }
}
