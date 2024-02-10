package com.umlaut.crowd.internal;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import com.m2catalyst.m2sdk.speed_test.legacy.ThroughputConfigUtil;
import com.umlaut.crowd.CCS;
import com.umlaut.crowd.IC;
import com.umlaut.crowd.IS;
import com.umlaut.crowd.InsightCore;
import com.umlaut.crowd.enums.ConnectionTypes;
import com.umlaut.crowd.timeserver.TimeServer;
import com.umlaut.crowd.utils.DateUtils;
import java.io.File;
import java.security.PublicKey;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;

public class nd {
    /* access modifiers changed from: private */
    public static boolean j = false;
    private static boolean k = false;
    private static boolean l = false;
    /* access modifiers changed from: private */
    public static boolean m = false;
    /* access modifiers changed from: private */
    public static final String n = "nd";
    /* access modifiers changed from: private */
    public File a;
    /* access modifiers changed from: private */
    public boolean b = false;
    /* access modifiers changed from: private */
    public Context c;
    /* access modifiers changed from: private */
    public long d;
    /* access modifiers changed from: private */
    public PublicKey e;
    private Calendar f;
    /* access modifiers changed from: private */
    public boolean g = true;
    /* access modifiers changed from: private */
    public UML h;
    /* access modifiers changed from: private */
    public long i;

    static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.umlaut.crowd.internal.nd$d[] r0 = com.umlaut.crowd.internal.nd.d.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.umlaut.crowd.internal.nd$d r1 = com.umlaut.crowd.internal.nd.d.ExportStart     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.umlaut.crowd.internal.nd$d r1 = com.umlaut.crowd.internal.nd.d.ExportProgress     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.umlaut.crowd.internal.nd$d r1 = com.umlaut.crowd.internal.nd.d.UploadStart     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.umlaut.crowd.internal.nd$d r1 = com.umlaut.crowd.internal.nd.d.UploadProgress     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.umlaut.crowd.internal.nd$d r1 = com.umlaut.crowd.internal.nd.d.UploadFinished     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.umlaut.crowd.internal.nd.a.<clinit>():void");
        }
    }

    private enum b {
        Success,
        ServerNotReachable,
        Error,
        d,
        FileNotHashable,
        FileNameInvalid
    }

    private enum d {
        ExportStart,
        ExportProgress,
        UploadStart,
        UploadProgress,
        UploadFinished
    }

    private class e {
        public d a;
        public int b;
        public int c;

        private e() {
        }

        /* synthetic */ e(nd ndVar, a aVar) {
            this();
        }
    }

    public nd(Context context) {
        File file = new File(context.getFilesDir() + CCS.b);
        this.a = file;
        if (!file.exists()) {
            this.a.mkdirs();
        }
        this.f = Calendar.getInstance();
        this.c = context;
        this.i = InsightCore.getInsightConfig().t0();
    }

    public void setUploadManagerListener(UML uml) {
        this.h = uml;
    }

    public void uploadFiles(boolean z) {
        long j2;
        long j3;
        boolean z2 = z;
        v4 v4Var = v4.UploadResults;
        w4.a(v4Var, u4.UploadStart, (Map<String, String>) null);
        if (!l && !this.b) {
            this.d = TimeServer.getTimeInMillis();
            IS is = new IS(this.c);
            long z3 = is.z();
            long x = is.x();
            long j4 = this.d;
            long j5 = z3 > j4 ? 0 : z3;
            long j6 = x > j4 ? 0 : x;
            IC insightConfig = InsightCore.getInsightConfig();
            long j7 = this.d;
            long j8 = j7 - j5;
            long j9 = j7 - j6;
            ConnectionTypes e2 = InsightCore.getRadioController().e();
            if (j || z2) {
                j3 = j6;
                j2 = j5;
                this.g = true;
            } else {
                j3 = j6;
                j2 = j5;
                if (insightConfig.A1() == b0.Charging) {
                    a0 a0Var = new x(this.c).a().BatteryStatus;
                    w4.a(v4Var, u4.UploadBatteryStatus, Collections.singletonMap("Status", a0Var.name()));
                    if (a0Var != a0.Charging) {
                        if (k) {
                            String str = n;
                            Log.i(str, "Battery Status State: " + a0Var + " -> exit");
                            return;
                        }
                        return;
                    }
                } else if (insightConfig.A1() == b0.FullOrCharging) {
                    a0 a0Var2 = new x(this.c).a().BatteryStatus;
                    w4.a(v4Var, u4.UploadBatteryStatus, Collections.singletonMap("Status", a0Var2.name()));
                    if (!(a0Var2 == a0.Charging || a0Var2 == a0.Full)) {
                        if (k) {
                            String str2 = n;
                            Log.i(str2, "Battery Status State: " + a0Var2 + " -> exit");
                            return;
                        }
                        return;
                    }
                }
                if (e2 == ConnectionTypes.WiFi || e2 == ConnectionTypes.Ethernet) {
                    w4.a(v4Var, u4.UploadWiFiCheck, Collections.singletonMap("TimePassed", String.valueOf(j8 >= insightConfig.K1())));
                    if (j8 < insightConfig.K1()) {
                        if (k) {
                            String str3 = n;
                            Log.i(str3, "Millis since last upload: " + j8 + ". Minimum timespan in WiFi: " + insightConfig.K1() + " -> exit");
                            return;
                        }
                        return;
                    }
                } else {
                    w4.a(v4Var, u4.UploadMobileCheck, Collections.singletonMap("TimePassed", String.valueOf(j8 >= insightConfig.J1())));
                    if (j8 < insightConfig.J1()) {
                        if (k) {
                            String str4 = n;
                            Log.i(str4, "Millis since last upload: " + j8 + ". Minimum timespan: " + insightConfig.J1() + " -> exit");
                            return;
                        }
                        return;
                    }
                }
                if (j9 < insightConfig.I1()) {
                    if (k) {
                        String str5 = n;
                        Log.i(str5, "Millis since last export: " + j9 + " -> no export");
                    }
                    this.g = false;
                } else {
                    this.g = true;
                }
            }
            w4.a(v4Var, u4.UploadTimePassed, Collections.singletonMap("ExportDB", String.valueOf(this.g)));
            if ((z2 || insightConfig.C1() || e2 != ConnectionTypes.Mobile || !InsightCore.getRadioController().q()) && this.a.exists() && this.a.canRead() && this.a.canWrite()) {
                if (insightConfig.E1()) {
                    a(insightConfig.f1(), is.q(), j2, j3);
                }
                new c(z2).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Void[0]);
            }
        }
    }

    private void a(String str, String str2, long j2, long j3) {
        md mdVar = new md(str, str2);
        mdVar.TimestampLastUpload = DateUtils.formatTableau(j2);
        mdVar.TimestampLastExport = DateUtils.formatTableau(j3);
        mdVar.TimeInfoOnUploadAttempt = TimeServer.getTimeInfo();
        mdVar.UploadExtraInfo = InsightCore.getUploadExtraInfo();
        InsightCore.getDatabaseHelper().b(w2.UIR, (RBR) mdVar, mdVar.TimeInfoOnUploadAttempt.TimestampMillis);
    }

    /* access modifiers changed from: private */
    public b a(File file, String str, Date date, String str2, String str3, String str4) {
        byte[] a2 = a5.a(file);
        if (a2 == null) {
            return b.FileNotHashable;
        }
        String a3 = i1.a(a2);
        String[] split = file.getName().split("-");
        if (split == null || split.length < 3) {
            return b.FileNameInvalid;
        }
        String upperCase = split[1].toUpperCase(Locale.ENGLISH);
        this.f.setTime(date);
        StringBuilder sb = new StringBuilder();
        sb.append(str2);
        sb.append("?md5=" + a3);
        sb.append("&project=" + str3);
        sb.append("&campaign=" + str4);
        sb.append("&type=InSight");
        sb.append("&isdate=" + DateUtils.formatLumenDate(this.f.get(1), this.f.get(2) + 1, this.f.get(5)));
        sb.append("&istime=" + DateUtils.formatLumenTime(this.f.get(11), this.f.get(12), this.f.get(13)));
        sb.append("&schema=" + upperCase);
        sb.append("&guid=" + str);
        sb.append("&version=20230301124918&os=Android");
        try {
            a6 a6Var = new a6(sb.toString());
            a6Var.a("uploadedfile", file);
            if (a6Var.a()) {
                return b.Success;
            }
            w4.a(v4.UploadResults, u4.UploadTransferFailed, Collections.singletonMap("Reason", "MultipartUploadFailed"));
            return b.Error;
        } catch (Exception e2) {
            w4.a(v4.UploadResults, u4.UploadTransferFailed, Collections.singletonMap("Exception", e2.toString()));
            String str5 = n;
            Log.i(str5, "transferFile: " + e2.toString());
            return b.Error;
        }
    }

    private class c extends AsyncTask<Void, e, Boolean> implements pd {
        private boolean a;
        private a2 b;
        private q4 c;

        public c(boolean z) {
            this.a = z;
        }

        private void b() {
            if (this.b == null) {
                this.b = CDC.getDeviceInfo(nd.this.c);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public Boolean doInBackground(Void... voidArr) {
            if (!this.a) {
                InsightCore.getDatabaseHelper().a(nd.this.i);
            }
            if (InsightCore.getDatabaseHelper().k() || this.a) {
                Date date = new Date(nd.this.d);
                if (nd.this.e == null) {
                    PublicKey unused = nd.this.e = InsightCore.getPublicKey();
                }
                if (nd.this.e == null) {
                    w4.a(v4.UploadResults, u4.UploadTransferFailed, Collections.singletonMap("Reason", "No Public Key"));
                    return Boolean.FALSE;
                }
                IC insightConfig = InsightCore.getInsightConfig();
                IS is = new IS(nd.this.c);
                String q = is.q();
                boolean z = false;
                if (!this.a) {
                    od odVar = new od(nd.this.c, is, this);
                    if (!odVar.d()) {
                        w4.a(v4.UploadResults, u4.UploadRequest, Collections.singletonMap("Granted", String.valueOf(false)));
                        if (!odVar.b()) {
                            InsightCore.getDatabaseHelper().l();
                        }
                        return Boolean.FALSE;
                    }
                }
                w4.a(v4.UploadResults, u4.UploadRequest, Collections.singletonMap("Granted", String.valueOf(true)));
                p1 p1Var = new p1(q, nd.this.a, nd.this.e, insightConfig.f1());
                a(d.ExportStart, 0, 0);
                if (nd.this.g) {
                    u1 databaseHelper = InsightCore.getDatabaseHelper();
                    int length = w2.values().length;
                    w2[] values = w2.values();
                    int length2 = values.length;
                    int i = 0;
                    int i2 = 0;
                    while (i < length2) {
                        w2 w2Var = values[i];
                        a(d.ExportProgress, length, i2);
                        databaseHelper.a(w2Var, p1Var);
                        i++;
                        i2++;
                    }
                    new IS(nd.this.c).g(nd.this.d);
                    w4.a(v4.UploadResults, u4.UploadExport, (Map<String, String>) null);
                    if (nd.j) {
                        String c2 = nd.n;
                        Log.i(c2, "Last export: " + nd.this.d);
                    }
                }
                File[] listFiles = nd.this.a.listFiles();
                if (listFiles.length == 0) {
                    w4.a(v4.UploadResults, u4.UploadNoFileAvailable, (Map<String, String>) null);
                    return Boolean.FALSE;
                }
                a(d.UploadStart, listFiles.length, 0);
                int i3 = 0;
                while (true) {
                    if (i3 >= listFiles.length) {
                        break;
                    }
                    a(d.UploadProgress, listFiles.length, i3);
                    b a2 = nd.this.a(listFiles[i3], q, date, insightConfig.B1(), insightConfig.f1(), insightConfig.x());
                    if (a2 == b.Error) {
                        z = true;
                        break;
                    }
                    if (a2 == b.Success && !nd.m) {
                        listFiles[i3].delete();
                    }
                    i3++;
                }
                return Boolean.valueOf(z);
            }
            w4.a(v4.UploadResults, u4.UploadNoFileAvailable, (Map<String, String>) null);
            return Boolean.FALSE;
        }

        /* access modifiers changed from: protected */
        public void onPreExecute() {
            super.onPreExecute();
            boolean unused = nd.this.b = true;
        }

        private void a(d dVar, int i, int i2) {
            if (nd.this.h != null) {
                e eVar = new e(nd.this, (a) null);
                eVar.a = dVar;
                eVar.b = i;
                eVar.c = i2;
                publishProgress(new e[]{eVar});
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onProgressUpdate(e... eVarArr) {
            if (nd.this.h != null && eVarArr != null && eVarArr.length != 0) {
                e eVar = eVarArr[0];
                int i = a.a[eVar.a.ordinal()];
                if (i == 1) {
                    nd.this.h.onExportStart();
                } else if (i == 2) {
                    nd.this.h.onExportProgress(eVar.b, eVar.c);
                } else if (i == 3) {
                    nd.this.h.onUploadStart();
                } else if (i == 4) {
                    nd.this.h.onUploadProgress(eVar.b, eVar.c);
                } else if (i == 5) {
                    nd.this.h.onUploadFinished();
                }
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public void onPostExecute(Boolean bool) {
            if (!bool.booleanValue()) {
                new IS(nd.this.c).i(nd.this.d);
                if (nd.j) {
                    String c2 = nd.n;
                    Log.i(c2, "Last upload: " + nd.this.d);
                }
            }
            boolean unused = nd.this.b = false;
            w4.a(v4.UploadResults, u4.UploadEnd, Collections.singletonMap("Successful", String.valueOf(!bool.booleanValue())));
            if (nd.this.h == null) {
                return;
            }
            if (bool.booleanValue()) {
                nd.this.h.onUploadError();
            } else {
                nd.this.h.onUploadFinished();
            }
        }

        public void a(List<UTP> list) {
            ListIterator<UTP> listIterator = list.listIterator();
            while (listIterator.hasNext()) {
                UTP next = listIterator.next();
                if (next.name.equals(ThroughputConfigUtil.SHARED_PREFS_KEY_MCC)) {
                    b();
                    String str = this.b.SimOperator;
                    if (str != null && str.length() > 3) {
                        next.val = this.b.SimOperator.substring(0, 3);
                    }
                } else if (next.name.equals(ThroughputConfigUtil.SHARED_PREFS_KEY_MNC)) {
                    b();
                    String str2 = this.b.SimOperator;
                    if (str2 != null && str2.length() > 3) {
                        next.val = this.b.SimOperator.substring(3);
                    }
                } else if (next.name.equals("version")) {
                    next.val = "20230301124918";
                } else if (next.name.equals("lat")) {
                    double a2 = CLC.a();
                    if (a2 == 0.0d) {
                        a2 = a().LocationLatitude;
                        if (a2 == 0.0d) {
                            listIterator.remove();
                        }
                    }
                    next.val = Double.toString(a2);
                } else if (next.name.equals("lon")) {
                    double b2 = CLC.b();
                    if (b2 == 0.0d) {
                        b2 = a().LocationLongitude;
                        if (b2 == 0.0d) {
                            listIterator.remove();
                        }
                    }
                    next.val = Double.toString(b2);
                }
                listIterator.remove();
            }
        }

        private q4 a() {
            if (this.c == null) {
                this.c = new CLC(nd.this.c).getLastLocationInfo();
            }
            return this.c;
        }
    }
}
