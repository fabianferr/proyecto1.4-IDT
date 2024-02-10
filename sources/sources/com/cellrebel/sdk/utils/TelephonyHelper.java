package com.cellrebel.sdk.utils;

import android.content.Context;
import android.location.Location;
import android.os.Build;
import android.os.Looper;
import android.os.Parcelable;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoNr;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.CellSignalStrengthCdma;
import android.telephony.CellSignalStrengthGsm;
import android.telephony.CellSignalStrengthLte;
import android.telephony.CellSignalStrengthNr;
import android.telephony.CellSignalStrengthWcdma;
import android.telephony.NetworkRegistrationInfo;
import android.telephony.PhoneStateListener;
import android.telephony.ServiceState;
import android.telephony.SignalStrength;
import android.telephony.TelephonyCallback;
import android.telephony.TelephonyDisplayInfo;
import android.telephony.TelephonyManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.networking.beans.request.BaseMetric;
import com.cellrebel.sdk.networking.beans.request.CellInfoMetric;
import com.cellrebel.sdk.networking.beans.request.CoverageMetric;
import com.cellrebel.sdk.networking.beans.response.Settings;
import com.cellrebel.sdk.workers.BaseMetricsWorker;
import com.google.gson.Gson;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TelephonyHelper {
    private static volatile TelephonyHelper m;
    private List<CellInfo> a;
    private TelephonyManager b;
    public ServiceState c;
    public TelephonyDisplayInfo d;
    public WrappedRegInfo e;
    public List<CellSignalStrength> f;
    private int g = 0;
    private PhoneStateListener h;
    private c i;
    private d j;
    private e k;
    private f l;

    public interface CellInfoCallback {
        void a(List<CellInfo> list);
    }

    class a extends TelephonyManager.CellInfoCallback {
        final /* synthetic */ Context a;
        final /* synthetic */ CellInfoCallback b;

        a(Context context, CellInfoCallback cellInfoCallback) {
            this.a = context;
            this.b = cellInfoCallback;
        }

        public void onCellInfo(List<CellInfo> list) {
            if (list != null && !list.isEmpty()) {
                list.toString();
                TelephonyHelper.this.a(list, this.a);
                CellInfoCallback cellInfoCallback = this.b;
                if (cellInfoCallback != null) {
                    cellInfoCallback.a(list);
                }
            }
        }

        public void onError(int i, Throwable th) {
        }
    }

    class b extends PhoneStateListener {
        final /* synthetic */ Context a;

        b(Context context) {
            this.a = context;
        }

        public void onCellInfoChanged(List<CellInfo> list) {
            super.onCellInfoChanged(list);
            if (list != null && !list.isEmpty()) {
                TelephonyHelper.this.a(list, this.a);
            }
        }

        public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
            super.onDisplayInfoChanged(telephonyDisplayInfo);
            String.valueOf(telephonyDisplayInfo);
            TelephonyHelper.this.d = telephonyDisplayInfo;
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            super.onServiceStateChanged(serviceState);
            if (serviceState != null) {
                Objects.toString(serviceState);
                TelephonyHelper.this.a(serviceState);
            }
        }

        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            super.onSignalStrengthsChanged(signalStrength);
            if (signalStrength != null) {
                TelephonyHelper.this.a(signalStrength);
                if (Build.VERSION.SDK_INT >= 29) {
                    TelephonyHelper.this.a(signalStrength.getCellSignalStrengths());
                }
            }
        }
    }

    class c extends TelephonyCallback implements TelephonyCallback.CellInfoListener {
        private Context a;

        public c(Context context) {
            this.a = context;
        }

        public void onCellInfoChanged(List<CellInfo> list) {
            if (list != null && !list.isEmpty()) {
                TelephonyHelper.this.a(list, this.a);
            }
        }
    }

    class d extends TelephonyCallback implements TelephonyCallback.DisplayInfoListener {
        private Context a;

        public d(Context context) {
            this.a = context;
        }

        public void onDisplayInfoChanged(TelephonyDisplayInfo telephonyDisplayInfo) {
            String.valueOf(telephonyDisplayInfo);
            TelephonyHelper.this.d = telephonyDisplayInfo;
        }
    }

    class e extends TelephonyCallback implements TelephonyCallback.ServiceStateListener {
        private Context a;

        public e(Context context) {
            this.a = context;
        }

        public void onServiceStateChanged(ServiceState serviceState) {
            if (serviceState != null) {
                Objects.toString(serviceState);
                TelephonyHelper.this.a(serviceState);
            }
        }
    }

    class f extends TelephonyCallback implements TelephonyCallback.SignalStrengthsListener {
        private Context a;

        public f(Context context) {
            this.a = context;
        }

        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            if (signalStrength != null) {
                TelephonyHelper.this.a(signalStrength);
                if (Build.VERSION.SDK_INT >= 29) {
                    TelephonyHelper.this.a(signalStrength.getCellSignalStrengths());
                }
            }
        }
    }

    private TelephonyHelper() {
        if (m != null) {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    private ServiceState a(TelephonyManager telephonyManager) {
        try {
            return (ServiceState) Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod("getServiceState", new Class[0]).invoke(telephonyManager, new Object[0]);
        } catch (ClassCastException | ClassNotFoundException | Exception | IllegalAccessException | NoSuchMethodException | OutOfMemoryError | InvocationTargetException unused) {
            return null;
        }
    }

    private WrappedRegInfo a(String str) {
        ArrayList<String> arrayList = new ArrayList<>();
        Pattern compile = Pattern.compile("NetworkRegistrationInfo\\{ domain=PS transportType=WWAN(.*?)\\}\\]");
        Pattern compile2 = Pattern.compile("NetworkRegistrationInfo\\{ domain=PS transportType=WWAN(.*?)\\},");
        Pattern compile3 = Pattern.compile("NetworkRegistrationState\\{transportType=1 domain=PS(.*?)\\}\\]");
        Pattern compile4 = Pattern.compile("NetworkRegistrationState\\{transportType=1 domain=PS(.*?)\\},");
        Matcher matcher = compile.matcher(str);
        Matcher matcher2 = compile2.matcher(str);
        Matcher matcher3 = compile3.matcher(str);
        Matcher matcher4 = compile4.matcher(str);
        if (matcher.find()) {
            for (int i2 = 1; i2 <= matcher.groupCount(); i2++) {
                matcher.group(i2);
                arrayList.add(matcher.group(i2));
            }
        }
        if (matcher2.find()) {
            for (int i3 = 1; i3 <= matcher2.groupCount(); i3++) {
                matcher2.group(i3);
                arrayList.add(matcher2.group(i3));
            }
        }
        if (matcher3.find()) {
            for (int i4 = 1; i4 <= matcher3.groupCount(); i4++) {
                matcher3.group(i4);
                arrayList.add(matcher3.group(i4));
            }
        }
        if (matcher4.find()) {
            for (int i5 = 1; i5 <= matcher4.groupCount(); i5++) {
                matcher4.group(i5);
                arrayList.add(matcher4.group(i5));
            }
        }
        if (arrayList.size() > 1) {
            for (String str2 : arrayList) {
                if (str2.contains("registrationState=HOME") && str2.contains("transportType=WWAN")) {
                    return new WrappedRegInfo(str2);
                }
                if (str2.contains("registrationState = HOME") && str2.contains("transportType = WWAN")) {
                    return new WrappedRegInfo(str2);
                }
                if (str2.contains("regState=HOME") && str2.contains("transportType=1")) {
                    return new WrappedRegInfo(str2);
                }
                if (str2.contains("regState = HOME") && str2.contains("transportType = 1")) {
                    return new WrappedRegInfo(str2);
                }
            }
            for (String str3 : arrayList) {
                if (str3.contains("registrationState=ROAMING") && str3.contains("transportType=WWAN")) {
                    return new WrappedRegInfo(str3);
                }
                if (str3.contains("registrationState = ROAMING") && str3.contains("transportType = WWAN")) {
                    return new WrappedRegInfo(str3);
                }
                if (str3.contains("regState=ROAMING") && str3.contains("transportType=1")) {
                    return new WrappedRegInfo(str3);
                }
                if (str3.contains("regState = ROAMING") && str3.contains("transportType = 1")) {
                    return new WrappedRegInfo(str3);
                }
            }
        } else if (arrayList.size() == 0) {
            return null;
        }
        String str4 = (String) arrayList.get(arrayList.size() - 1);
        if (str4 == null) {
            return null;
        }
        return new WrappedRegInfo(str4);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ String a(Context context, List list) {
        try {
            CoverageMetric coverageMetric = new CoverageMetric();
            BaseMetricsWorker.a(context, (BaseMetric) coverageMetric);
            ArrayList arrayList = new ArrayList();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                CellInfo cellInfo = (CellInfo) it.next();
                if (Utils.a(cellInfo)) {
                    CellInfoMetric cellInfoMetric = new CellInfoMetric();
                    cellInfoMetric.fill((BaseMetric) coverageMetric);
                    cellInfoMetric.fill(cellInfo);
                    Location b2 = TrackingHelper.a().b();
                    if (b2 != null) {
                        cellInfoMetric.latitude = b2.getLatitude();
                        cellInfoMetric.longitude = b2.getLongitude();
                        cellInfoMetric.gpsAccuracy = (double) b2.getAccuracy();
                    }
                    cellInfoMetric.dateTimeOfMeasurement = String.valueOf(System.currentTimeMillis() / 1000);
                    arrayList.add(cellInfoMetric);
                }
            }
            coverageMetric.cellInfoMetricsJSON = new Gson().toJson((Object) arrayList);
            if (DatabaseClient.a() == null) {
                return null;
            }
            DatabaseClient.a().e().a(coverageMetric);
            return null;
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    private void a(NetworkRegistrationInfo networkRegistrationInfo) {
        int i2 = Build.VERSION.SDK_INT;
        this.e = i2 >= 31 ? new WrappedRegInfo((Parcelable) networkRegistrationInfo) : new WrappedRegInfo(networkRegistrationInfo.toString());
        if (i2 >= 30) {
            this.e.h = networkRegistrationInfo.getAccessNetworkTechnology();
        }
    }

    /* access modifiers changed from: private */
    public void a(ServiceState serviceState) {
        this.c = serviceState;
        if (Build.VERSION.SDK_INT >= 30) {
            List<NetworkRegistrationInfo> networkRegistrationInfoList = serviceState.getNetworkRegistrationInfoList();
            ArrayList arrayList = new ArrayList();
            for (NetworkRegistrationInfo networkRegistrationInfo : networkRegistrationInfoList) {
                if (networkRegistrationInfo.getAvailableServices().contains(2)) {
                    arrayList.add(networkRegistrationInfo);
                }
            }
            if (arrayList.size() != 1) {
                Iterator it = arrayList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    NetworkRegistrationInfo networkRegistrationInfo2 = (NetworkRegistrationInfo) it.next();
                    try {
                        if (networkRegistrationInfo2.isRegistered()) {
                            a(networkRegistrationInfo2);
                            break;
                        }
                    } catch (Exception unused) {
                    }
                }
                if (this.e != null || arrayList.isEmpty()) {
                    return;
                }
            }
            a((NetworkRegistrationInfo) arrayList.get(0));
            return;
        }
        this.e = a(serviceState.toString());
    }

    /* access modifiers changed from: private */
    public void a(SignalStrength signalStrength) {
        int i2;
        if (signalStrength.isGsm()) {
            i2 = (signalStrength.getGsmSignalStrength() * 2) - 113;
        } else {
            i2 = Math.min(signalStrength.getCdmaDbm(), signalStrength.getEvdoDbm());
        }
        String.valueOf(i2);
        this.g = i2;
    }

    /* access modifiers changed from: private */
    public void a(List<CellSignalStrength> list) {
        this.f = list;
    }

    public static TelephonyHelper b() {
        if (m == null) {
            synchronized (TelephonyHelper.class) {
                if (m == null) {
                    m = new TelephonyHelper();
                }
            }
        }
        return m;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String b(Context context) {
        int i2;
        TelephonyManager telephonyManager;
        PhoneStateListener phoneStateListener;
        Looper.prepare();
        this.h = new b(context);
        try {
            int i3 = Build.VERSION.SDK_INT;
            if (i3 >= 23 && ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                CellLocation.requestLocationUpdate();
            }
            if (ContextCompat.checkSelfPermission(context, "android.permission.READ_PHONE_STATE") == 0) {
                if (ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 && i3 >= 30) {
                    i2 = 1049857;
                    telephonyManager = this.b;
                    if (!(telephonyManager == null || (phoneStateListener = this.h) == null)) {
                        telephonyManager.listen(phoneStateListener, i2);
                    }
                    Looper.loop();
                    return null;
                }
            }
            i2 = ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0 ? 1281 : 257;
            telephonyManager = this.b;
            telephonyManager.listen(phoneStateListener, i2);
        } catch (Exception | OutOfMemoryError unused) {
        }
        Looper.loop();
        return null;
    }

    public CellSignalStrength a(CellInfo cellInfo) {
        List<CellSignalStrength> list = this.f;
        if (list != null && !list.isEmpty()) {
            for (CellSignalStrength next : this.f) {
                int i2 = Build.VERSION.SDK_INT;
                if ((cellInfo instanceof CellInfoGsm) && (next instanceof CellSignalStrengthGsm)) {
                    return next;
                }
                if ((cellInfo instanceof CellInfoCdma) && (next instanceof CellSignalStrengthCdma)) {
                    return next;
                }
                if ((cellInfo instanceof CellInfoWcdma) && (next instanceof CellSignalStrengthWcdma)) {
                    return next;
                }
                if ((cellInfo instanceof CellInfoLte) && (next instanceof CellSignalStrengthLte)) {
                    return next;
                }
                if (i2 >= 29 && (cellInfo instanceof CellInfoNr) && (next instanceof CellSignalStrengthNr)) {
                    return next;
                }
            }
        }
        return null;
    }

    public List<CellInfo> a(Context context) {
        ServiceState a2;
        if (this.b == null) {
            this.b = TrackingHelper.a().h(context);
        }
        if (this.c == null && (a2 = a(this.b)) != null) {
            a(a2);
        }
        List<CellInfo> list = this.a;
        if (list != null) {
            return list;
        }
        c(context);
        a(context, (CellInfoCallback) null);
        if (ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != 0) {
            return this.a;
        }
        List<CellInfo> allCellInfo = this.b.getAllCellInfo();
        this.a = allCellInfo;
        return allCellInfo;
    }

    public void a() {
        this.a = null;
    }

    public void a(Context context, CellInfoCallback cellInfoCallback) {
        try {
            if (ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != -1) {
                Settings c2 = SettingsManager.b().c();
                if (Build.VERSION.SDK_INT > 29 && c2 != null && c2.cellInfoUpdateEnabled().booleanValue() && Utils.c()) {
                    TrackingHelper.a().h(context).requestCellInfoUpdate(Executors.newSingleThreadExecutor(), new a(context, cellInfoCallback));
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void a(List<CellInfo> list, Context context) {
        if (list != null) {
            try {
                if (!list.isEmpty()) {
                    this.a = list;
                    Settings c2 = SettingsManager.b().c();
                    if (c2 != null && c2.coverageMeasurement().booleanValue()) {
                        ThreadPoolProvider.a().a(new TelephonyHelper$$ExternalSyntheticLambda0(context, list));
                    }
                }
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
    }

    public int c() {
        return this.g;
    }

    public void c(Context context) {
        int i2 = Build.VERSION.SDK_INT;
        if (this.b != null && context != null) {
            if (ActivityCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
                List<CellInfo> allCellInfo = this.b.getAllCellInfo();
                if (allCellInfo != null && !allCellInfo.isEmpty()) {
                    a(allCellInfo, context);
                }
                a(context, (CellInfoCallback) null);
            }
            if (i2 < 31) {
                ThreadPoolProvider.a().b(new TelephonyHelper$$ExternalSyntheticLambda1(this, context));
            } else if (this.b != null) {
                if (this.i == null) {
                    try {
                        this.i = new c(context);
                        this.b.registerTelephonyCallback(context.getMainExecutor(), this.i);
                    } catch (Exception unused) {
                    }
                }
                if (this.j == null) {
                    try {
                        this.j = new d(context);
                        this.b.registerTelephonyCallback(context.getMainExecutor(), this.j);
                    } catch (Exception unused2) {
                    }
                }
                if (this.k == null) {
                    try {
                        this.k = new e(context);
                        this.b.registerTelephonyCallback(context.getMainExecutor(), this.k);
                    } catch (Exception unused3) {
                    }
                }
                if (this.l == null) {
                    try {
                        this.l = new f(context);
                        this.b.registerTelephonyCallback(context.getMainExecutor(), this.l);
                    } catch (Exception unused4) {
                    }
                }
            }
        }
    }

    public void d() {
        TelephonyManager telephonyManager = this.b;
        if (telephonyManager != null) {
            if (Build.VERSION.SDK_INT >= 31) {
                c cVar = this.i;
                if (cVar != null) {
                    telephonyManager.unregisterTelephonyCallback(cVar);
                    this.i = null;
                }
                d dVar = this.j;
                if (dVar != null) {
                    this.b.unregisterTelephonyCallback(dVar);
                    this.j = null;
                }
                e eVar = this.k;
                if (eVar != null) {
                    this.b.unregisterTelephonyCallback(eVar);
                    this.k = null;
                }
                f fVar = this.l;
                if (fVar != null) {
                    this.b.unregisterTelephonyCallback(fVar);
                    this.l = null;
                    return;
                }
                return;
            }
            PhoneStateListener phoneStateListener = this.h;
            if (phoneStateListener != null) {
                telephonyManager.listen(phoneStateListener, 0);
                this.h = null;
            }
        }
    }
}
