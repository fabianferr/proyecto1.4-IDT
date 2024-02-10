package com.m2catalyst.m2sdk.business.repositories;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.google.gson.Gson;
import com.m2catalyst.m2sdk.a6;
import com.m2catalyst.m2sdk.business.models.DeviceInfo;
import com.m2catalyst.m2sdk.d6;
import com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiRequestMessage;
import com.m2catalyst.m2sdk.external.DataAvailability;
import com.m2catalyst.m2sdk.logger.M2SDKLogger;
import com.m2catalyst.m2sdk.n3;
import com.m2catalyst.m2sdk.r2;
import com.m2catalyst.m2sdk.z1;
import com.m2catalyst.m2sdk.z5;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 *2\u00020\u00012\u00020\u0002:\u0001*B\u0017\u0012\u0006\u0010\u001a\u001a\u00020\u0019\u0012\u0006\u0010\u001d\u001a\u00020\u001c¢\u0006\u0004\b(\u0010)J\b\u0010\u0004\u001a\u00020\u0003H\u0002J\b\u0010\u0006\u001a\u00020\u0005H\u0002J\u000e\u0010\t\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0007J\b\u0010\u000b\u001a\u0004\u0018\u00010\nJ\b\u0010\f\u001a\u0004\u0018\u00010\u0007J\u000f\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0006\u0010\u0011\u001a\u00020\u0010J\u001b\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\nH@ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0005R\u0014\u0010\u001a\u001a\u00020\u00198\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0014\u0010\u001d\u001a\u00020\u001c8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001eR\u0014\u0010 \u001a\u00020\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b \u0010!R\u0016\u0010#\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b#\u0010$R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\b\u0010%R\u0016\u0010&\u001a\u00020\u00058\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b&\u0010'\u0002\u0004\n\u0002\b\u0019¨\u0006+"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/DeviceRepository;", "Lcom/m2catalyst/m2sdk/business/repositories/BaseRepository;", "Lcom/m2catalyst/m2sdk/external/DataAvailability$DeviceInfoAvailability;", "", "buildDeviceInfo", "", "wasDeviceSynced", "Lcom/m2catalyst/m2sdk/business/models/DeviceInfo;", "deviceInfo", "saveDeviceInfo", "", "getSyncBody", "getDeviceInfo", "", "getDeviceId", "()Ljava/lang/Integer;", "", "getM2UUId", "body", "Lcom/m2catalyst/m2sdk/data_transmission/ingestion/dtos/ApiResponseMessage;", "syncDevice", "([BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "syncNeeded", "successful", "deviceSynced", "Lcom/m2catalyst/m2sdk/z1;", "apiClient", "Lcom/m2catalyst/m2sdk/z1;", "Landroid/content/Context;", "context", "Landroid/content/Context;", "Lcom/m2catalyst/m2sdk/r2;", "configuration", "Lcom/m2catalyst/m2sdk/r2;", "Landroid/content/SharedPreferences;", "pref", "Landroid/content/SharedPreferences;", "Lcom/m2catalyst/m2sdk/business/models/DeviceInfo;", "syncInProcess", "Z", "<init>", "(Lcom/m2catalyst/m2sdk/z1;Landroid/content/Context;)V", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: DeviceRepository.kt */
public final class DeviceRepository extends BaseRepository implements DataAvailability.DeviceInfoAvailability {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String DEVICE_INFO = "device_info";
    private static final String DEVICE_REPOSITORY_LOGS = "DEVICE_REPOSITORY_LOGS";
    private static final String DEVICE_SYNC_SUCCESSFUL = "device_sync_successfull";
    private static final String SYNC_DEVICE_EVENT = "sync_device";
    private static final String SYNC_DEVICE_EVENT_ERROR = "Device sync error";
    public static final String SYNC_DEVICE_PREFS = "com.m2catalyst.m2appinsight.sdk.vo.deviceinfo";
    private static final String TAG = "DeviceInfo";
    private final z1 apiClient;
    private final r2 configuration = r2.a.a();
    private final Context context;
    private DeviceInfo deviceInfo;
    private SharedPreferences pref;
    private boolean syncInProcess;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/m2catalyst/m2sdk/business/repositories/DeviceRepository$Companion;", "", "()V", "DEVICE_INFO", "", "DEVICE_REPOSITORY_LOGS", "DEVICE_SYNC_SUCCESSFUL", "SYNC_DEVICE_EVENT", "SYNC_DEVICE_EVENT_ERROR", "SYNC_DEVICE_PREFS", "TAG", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: DeviceRepository.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public DeviceRepository(z1 z1Var, Context context2) {
        Intrinsics.checkNotNullParameter(z1Var, "apiClient");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.apiClient = z1Var;
        this.context = context2;
        SharedPreferences sharedPreferences = context2.getSharedPreferences(SYNC_DEVICE_PREFS, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…FS, Context.MODE_PRIVATE)");
        this.pref = sharedPreferences;
        buildDeviceInfo();
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x022e  */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x023a  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x023e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void buildDeviceInfo() {
        /*
            r30 = this;
            r1 = r30
            com.m2catalyst.m2sdk.business.models.DeviceInfo r0 = new com.m2catalyst.m2sdk.business.models.DeviceInfo
            r0.<init>()
            android.content.SharedPreferences r2 = r1.pref
            java.lang.String r3 = "device_info"
            r4 = 0
            java.lang.String r2 = r2.getString(r3, r4)
            if (r2 == 0) goto L_0x0022
            com.google.gson.Gson r0 = new com.google.gson.Gson
            r0.<init>()
            java.lang.Class<com.m2catalyst.m2sdk.business.models.DeviceInfo> r3 = com.m2catalyst.m2sdk.business.models.DeviceInfo.class
            java.lang.Object r0 = r0.fromJson((java.lang.String) r2, r3)
            java.lang.String r2 = "Gson().fromJson(it, DeviceInfo::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
        L_0x0022:
            java.lang.String r2 = r30.getM2UUId()
            r3 = r0
            com.m2catalyst.m2sdk.business.models.DeviceInfo r3 = (com.m2catalyst.m2sdk.business.models.DeviceInfo) r3
            com.m2catalyst.m2sdk.r2 r0 = com.m2catalyst.m2sdk.r2.a.a()
            com.m2catalyst.m2sdk.z5 r0 = r0.a()
            com.m2catalyst.m2sdk.a6 r4 = com.m2catalyst.m2sdk.a6.DEVICE_ID
            java.lang.Integer r5 = r3.getDeviceId()
            if (r5 == 0) goto L_0x003a
            goto L_0x0045
        L_0x003a:
            java.lang.Object r5 = r4.b()
            java.lang.String r6 = "null cannot be cast to non-null type kotlin.Int"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5, r6)
            java.lang.Integer r5 = (java.lang.Integer) r5
        L_0x0045:
            int r5 = r5.intValue()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r0.a(r4, r5)
            r3.setM2uuid(r2)
            java.lang.String r0 = android.os.Build.MANUFACTURER
            java.lang.String r2 = android.os.Build.MODEL
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = " "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r0 = r4.toString()
            r3.setDeviceType(r0)
            int r0 = android.os.Build.VERSION.SDK_INT
            r3.setOsVersion(r0)
            java.lang.String r2 = android.os.Build.BOOTLOADER
            r3.setBootloaderId(r2)
            java.lang.String r2 = android.os.Build.VERSION.RELEASE
            r3.setOsBuildVersion(r2)
            java.lang.String r2 = android.os.Build.DISPLAY
            r3.setOsBuildId(r2)
            java.lang.String r2 = "os.arch"
            java.lang.String r2 = java.lang.System.getProperty(r2)
            r3.setDeviceArchitecture(r2)
            r2 = 21
            r4 = 0
            if (r0 >= r2) goto L_0x0096
            java.lang.String r0 = android.os.Build.CPU_ABI
            r3.setOSArchitecture(r0)
            goto L_0x00a0
        L_0x0096:
            java.lang.String[] r0 = android.os.Build.SUPPORTED_ABIS
            int r2 = r0.length
            if (r2 <= 0) goto L_0x00a0
            r0 = r0[r4]
            r3.setOSArchitecture(r0)
        L_0x00a0:
            java.util.Locale r0 = java.util.Locale.getDefault()
            java.lang.String r0 = r0.getDisplayLanguage()
            r3.setLocaleLanguage(r0)
            android.content.Context r0 = r1.context
            java.lang.String r2 = "phone"
            java.lang.Object r0 = r0.getSystemService(r2)
            java.lang.String r2 = "null cannot be cast to non-null type android.telephony.TelephonyManager"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r2)
            r2 = r0
            android.telephony.TelephonyManager r2 = (android.telephony.TelephonyManager) r2
            if (r2 == 0) goto L_0x0201
            java.lang.String r0 = r2.getNetworkOperatorName()
            r3.setNetworkOperator(r0)
            java.lang.String r5 = r2.getNetworkOperator()
            java.lang.String r11 = "this as java.lang.String).substring(startIndex)"
            java.lang.String r12 = "this as java.lang.String…ing(startIndex, endIndex)"
            java.lang.String r13 = "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
            java.lang.String r14 = ","
            java.lang.String r15 = "operator"
            r10 = 3
            if (r5 == 0) goto L_0x016d
            int r0 = r5.length()
            if (r0 < r10) goto L_0x016d
            java.lang.String[] r6 = new java.lang.String[]{r14}
            r7 = 0
            r8 = 0
            r9 = 6
            r0 = 0
            r10 = r0
            java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r5, (java.lang.String[]) r6, (boolean) r7, (int) r8, (int) r9, (java.lang.Object) r10)
            java.lang.String[] r5 = new java.lang.String[r4]
            java.lang.Object[] r0 = r0.toArray(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r13)
            java.lang.String[] r0 = (java.lang.String[]) r0
            r5 = r0[r4]
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r15)     // Catch:{ NumberFormatException -> 0x0122, IndexOutOfBoundsException -> 0x010e }
            r6 = 3
            java.lang.String r0 = r5.substring(r4, r6)     // Catch:{ NumberFormatException -> 0x010c, IndexOutOfBoundsException -> 0x010a }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r12)     // Catch:{ NumberFormatException -> 0x010c, IndexOutOfBoundsException -> 0x010a }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x010c, IndexOutOfBoundsException -> 0x010a }
            r3.setNetworkMcc(r0)     // Catch:{ NumberFormatException -> 0x010c, IndexOutOfBoundsException -> 0x010a }
            goto L_0x0135
        L_0x010a:
            r0 = move-exception
            goto L_0x0110
        L_0x010c:
            r0 = move-exception
            goto L_0x0124
        L_0x010e:
            r0 = move-exception
            r6 = 3
        L_0x0110:
            r19 = r0
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r16 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r17 = "DeviceInfo"
            java.lang.String r18 = "Error getting network mcc"
            r20 = 0
            r21 = 8
            r22 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(r16, r17, r18, r19, r20, r21, r22)
            goto L_0x0135
        L_0x0122:
            r0 = move-exception
            r6 = 3
        L_0x0124:
            r26 = r0
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r23 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r24 = "DeviceInfo"
            java.lang.String r25 = "Error getting network mcc"
            r27 = 0
            r28 = 8
            r29 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(r23, r24, r25, r26, r27, r28, r29)
        L_0x0135:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r15)     // Catch:{ NumberFormatException -> 0x015a, IndexOutOfBoundsException -> 0x0147 }
            java.lang.String r0 = r5.substring(r6)     // Catch:{ NumberFormatException -> 0x015a, IndexOutOfBoundsException -> 0x0147 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r11)     // Catch:{ NumberFormatException -> 0x015a, IndexOutOfBoundsException -> 0x0147 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x015a, IndexOutOfBoundsException -> 0x0147 }
            r3.setNetworkMnc(r0)     // Catch:{ NumberFormatException -> 0x015a, IndexOutOfBoundsException -> 0x0147 }
            goto L_0x016e
        L_0x0147:
            r0 = move-exception
            r19 = r0
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r16 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r17 = "DeviceInfo"
            java.lang.String r18 = "Error getting network mnc"
            r20 = 0
            r21 = 8
            r22 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(r16, r17, r18, r19, r20, r21, r22)
            goto L_0x016e
        L_0x015a:
            r0 = move-exception
            r26 = r0
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r23 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r24 = "DeviceInfo"
            java.lang.String r25 = "Error getting network mnc"
            r27 = 0
            r28 = 8
            r29 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(r23, r24, r25, r26, r27, r28, r29)
            goto L_0x016e
        L_0x016d:
            r6 = 3
        L_0x016e:
            java.lang.String r16 = r2.getSimOperator()
            if (r16 == 0) goto L_0x0201
            int r0 = r16.length()
            if (r0 < r6) goto L_0x0201
            java.lang.String[] r17 = new java.lang.String[]{r14}
            r18 = 0
            r19 = 0
            r20 = 6
            r21 = 0
            java.util.List r0 = kotlin.text.StringsKt.split$default((java.lang.CharSequence) r16, (java.lang.String[]) r17, (boolean) r18, (int) r19, (int) r20, (java.lang.Object) r21)
            java.lang.String[] r2 = new java.lang.String[r4]
            java.lang.Object[] r0 = r0.toArray(r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r13)
            java.lang.String[] r0 = (java.lang.String[]) r0
            r2 = r0[r4]
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)     // Catch:{ NumberFormatException -> 0x01bc, IndexOutOfBoundsException -> 0x01a9 }
            java.lang.String r0 = r2.substring(r4, r6)     // Catch:{ NumberFormatException -> 0x01bc, IndexOutOfBoundsException -> 0x01a9 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r12)     // Catch:{ NumberFormatException -> 0x01bc, IndexOutOfBoundsException -> 0x01a9 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x01bc, IndexOutOfBoundsException -> 0x01a9 }
            r3.setSimMcc(r0)     // Catch:{ NumberFormatException -> 0x01bc, IndexOutOfBoundsException -> 0x01a9 }
            goto L_0x01ce
        L_0x01a9:
            r0 = move-exception
            r19 = r0
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r16 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r17 = "DeviceInfo"
            java.lang.String r18 = "Error getting sim mcc"
            r20 = 0
            r21 = 8
            r22 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(r16, r17, r18, r19, r20, r21, r22)
            goto L_0x01ce
        L_0x01bc:
            r0 = move-exception
            r26 = r0
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r23 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r24 = "DeviceInfo"
            java.lang.String r25 = "Error getting sim mcc"
            r27 = 0
            r28 = 8
            r29 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(r23, r24, r25, r26, r27, r28, r29)
        L_0x01ce:
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r15)     // Catch:{ NumberFormatException -> 0x01f0, IndexOutOfBoundsException -> 0x01e0 }
            java.lang.String r0 = r2.substring(r6)     // Catch:{ NumberFormatException -> 0x01f0, IndexOutOfBoundsException -> 0x01e0 }
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r11)     // Catch:{ NumberFormatException -> 0x01f0, IndexOutOfBoundsException -> 0x01e0 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x01f0, IndexOutOfBoundsException -> 0x01e0 }
            r3.setSimMnc(r0)     // Catch:{ NumberFormatException -> 0x01f0, IndexOutOfBoundsException -> 0x01e0 }
            goto L_0x0201
        L_0x01e0:
            r0 = move-exception
            r8 = r0
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r5 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r6 = "DeviceInfo"
            java.lang.String r7 = "Error getting sim mnc"
            r9 = 0
            r10 = 8
            r11 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(r5, r6, r7, r8, r9, r10, r11)
            goto L_0x0201
        L_0x01f0:
            r0 = move-exception
            r15 = r0
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r12 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r13 = "DeviceInfo"
            java.lang.String r14 = "Error getting sim mnc"
            r16 = 0
            r17 = 8
            r18 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.logError$default(r12, r13, r14, r15, r16, r17, r18)
        L_0x0201:
            android.content.Context r0 = r1.context
            android.content.Context r0 = r0.getApplicationContext()
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.mcc
            r3.setResourcesMcc(r0)
            android.content.Context r0 = r1.context
            android.content.Context r0 = r0.getApplicationContext()
            android.content.res.Resources r0 = r0.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.mnc
            r3.setResourcesMnc(r0)
            int r0 = r3.getResourcesMcc()
            r2 = -1
            if (r0 != 0) goto L_0x0231
            r3.setResourcesMcc(r2)
        L_0x0231:
            int r0 = r3.getResourcesMnc()
            r5 = 65535(0xffff, float:9.1834E-41)
            if (r0 != r5) goto L_0x023e
            r3.setResourcesMnc(r4)
            goto L_0x0247
        L_0x023e:
            int r0 = r3.getResourcesMnc()
            if (r0 != 0) goto L_0x0247
            r3.setResourcesMnc(r2)
        L_0x0247:
            int r0 = r3.getNetworkMcc()
            r3.setMcc(r0)
            int r0 = r3.getNetworkMnc()
            r3.setMnc(r0)
            int r0 = r3.getMcc()
            if (r0 != r2) goto L_0x0289
            int r0 = r3.getMnc()
            if (r0 != r2) goto L_0x0289
            int r0 = r3.getSimMcc()
            r3.setMcc(r0)
            int r0 = r3.getSimMnc()
            r3.setMnc(r0)
            int r0 = r3.getMcc()
            if (r0 != r2) goto L_0x0289
            int r0 = r3.getMnc()
            if (r0 != r2) goto L_0x0289
            int r0 = r3.getResourcesMcc()
            r3.setMcc(r0)
            int r0 = r3.getResourcesMnc()
            r3.setMnc(r0)
        L_0x0289:
            r1.deviceInfo = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.DeviceRepository.buildDeviceInfo():void");
    }

    private final boolean wasDeviceSynced() {
        boolean z = this.pref.getBoolean(DEVICE_SYNC_SUCCESSFUL, false);
        z5 a = this.configuration.a();
        long j = 0L;
        String str = a6.LAST_TIME_SYNCED.a;
        if (a.a.getAll().containsKey(str)) {
            j = a.a.getAll().get(str);
        }
        Long l = (Long) j;
        if (l != null) {
            l.longValue();
        }
        return z;
    }

    public final void deviceSynced(boolean z) {
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putBoolean(DEVICE_SYNC_SUCCESSFUL, z);
        edit.apply();
        this.configuration.a().a(a6.LAST_TIME_SYNCED, Long.valueOf(System.currentTimeMillis()));
        M2SDKLogger.Companion companion = M2SDKLogger.Companion;
        long currentTimeMillis = System.currentTimeMillis();
        M2SDKLogger.Companion.log$default(companion, DEVICE_REPOSITORY_LOGS, "Device SUCCESSFULLY SYNCED at " + currentTimeMillis, (Map) null, false, 12, (Object) null);
    }

    public Integer getDeviceId() {
        z5 a = this.configuration.a();
        Object obj = a6.DEVICE_ID.b;
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        Object obj2 = (Integer) obj;
        if (a.a.getAll().containsKey("deviceId")) {
            obj2 = a.a.getAll().get("deviceId");
        }
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Int");
        return (Integer) obj2;
    }

    public final DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    public final String getM2UUId() {
        Object obj;
        z5 a = this.configuration.a();
        a6 a6Var = a6.M2_UUID;
        if (!a.a.getAll().containsKey("m2Uuid")) {
            obj = "";
        } else {
            obj = a.a.getAll().get("m2Uuid");
        }
        String str = (String) obj;
        boolean z = false;
        if (!(str == null || str.length() == 0)) {
            String str2 = this.configuration.h.b;
            if (!(str2 == null || str2.length() == 0)) {
                return str;
            }
        }
        if (str == null || str.length() == 0) {
            String uuid = UUID.randomUUID().toString();
            this.configuration.a().a(a6Var, uuid);
            d6 d6Var = this.configuration.h;
            d6Var.getClass();
            Intrinsics.checkNotNullParameter(uuid, "<set-?>");
            d6Var.b = uuid;
            return uuid;
        }
        String str3 = this.configuration.h.b;
        if (str3 == null || str3.length() == 0) {
            z = true;
        }
        if (!z) {
            return str;
        }
        d6 d6Var2 = this.configuration.h;
        d6Var2.getClass();
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        d6Var2.b = str;
        return str;
    }

    public final byte[] getSyncBody() {
        if (!syncNeeded() || this.syncInProcess) {
            return null;
        }
        ApiRequestMessage.Builder a = n3.a(this.configuration);
        DeviceInfo deviceInfo2 = this.deviceInfo;
        Intrinsics.checkNotNull(deviceInfo2);
        return ApiRequestMessage.ADAPTER.encode(a.device_info(deviceInfo2.toMessage()).build());
    }

    public final void saveDeviceInfo(DeviceInfo deviceInfo2) {
        Intrinsics.checkNotNullParameter(deviceInfo2, "deviceInfo");
        SharedPreferences.Editor edit = this.pref.edit();
        edit.putString("device_info", new Gson().toJson((Object) deviceInfo2));
        edit.apply();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x007f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x010e  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object syncDevice(byte[] r14, kotlin.coroutines.Continuation<? super com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.m2catalyst.m2sdk.business.repositories.DeviceRepository$syncDevice$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.m2catalyst.m2sdk.business.repositories.DeviceRepository$syncDevice$1 r0 = (com.m2catalyst.m2sdk.business.repositories.DeviceRepository$syncDevice$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            com.m2catalyst.m2sdk.business.repositories.DeviceRepository$syncDevice$1 r0 = new com.m2catalyst.m2sdk.business.repositories.DeviceRepository$syncDevice$1
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r14 = r0.L$0
            com.m2catalyst.m2sdk.business.repositories.DeviceRepository r14 = (com.m2catalyst.m2sdk.business.repositories.DeviceRepository) r14
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0048
        L_0x002d:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r15)
            r13.syncInProcess = r3
            com.m2catalyst.m2sdk.z1 r15 = r13.apiClient
            r0.L$0 = r13
            r0.label = r3
            java.lang.Object r15 = r15.a(r14, r0)
            if (r15 != r1) goto L_0x0047
            return r1
        L_0x0047:
            r14 = r13
        L_0x0048:
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage r15 = (com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.ApiResponseMessage) r15
            java.util.LinkedHashMap r0 = new java.util.LinkedHashMap
            r0.<init>()
            com.m2catalyst.m2sdk.business.models.DeviceInfo r1 = r14.deviceInfo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.Integer r1 = r1.getDeviceId()
            if (r1 != 0) goto L_0x006f
            com.m2catalyst.m2sdk.a6 r1 = com.m2catalyst.m2sdk.a6.DEVICE_ID
            java.lang.Object r1 = r1.b()
            java.lang.String r2 = "null cannot be cast to non-null type kotlin.Int"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.lang.String r1 = java.lang.String.valueOf(r1)
        L_0x006f:
            java.lang.String r2 = "deviceId"
            r0.put(r2, r1)
            com.m2catalyst.m2sdk.business.models.DeviceInfo r1 = r14.deviceInfo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            java.lang.String r1 = r1.getM2uuid()
            if (r1 != 0) goto L_0x0081
            java.lang.String r1 = ""
        L_0x0081:
            java.lang.String r2 = "m2uuid"
            r0.put(r2, r1)
            com.m2catalyst.m2sdk.logger.M2SDKLogger$Companion r1 = com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion
            java.lang.String r5 = "DEVICE_REPOSITORY_LOGS"
            java.lang.String r6 = "Device Sync started"
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            r4 = r1
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r4, r5, r6, r7, r8, r9, r10)
            java.lang.Boolean r2 = r15.success
            java.lang.String r4 = "response.success"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            boolean r2 = r2.booleanValue()
            r11 = 0
            r12 = -3
            if (r2 == 0) goto L_0x010e
            com.m2catalyst.m2sdk.logger.Event$Builder r2 = new com.m2catalyst.m2sdk.logger.Event$Builder
            java.lang.String r4 = "sync_device"
            r2.<init>(r4, r0)
            com.m2catalyst.m2sdk.logger.Event r5 = r2.build()
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            r4 = r1
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r4, r5, r6, r7, r8, r9)
            java.lang.String r0 = r15.details
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r4 = "Sync device successful with details "
            r2.<init>(r4)
            r2.append(r0)
            java.lang.String r6 = r2.toString()
            java.lang.String r5 = "DEVICE_REPOSITORY_LOGS"
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            r4 = r1
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r4, r5, r6, r7, r8, r9, r10)
            r14.deviceSynced(r3)
            com.m2catalyst.m2sdk.business.models.DeviceInfo r0 = r14.deviceInfo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.SyncDeviceResponseMessage r1 = r15.sync_device_response
            java.lang.Integer r1 = r1.device_id
            r0.setDeviceId(r1)
            com.m2catalyst.m2sdk.business.models.DeviceInfo r0 = r14.deviceInfo
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            r14.saveDeviceInfo(r0)
            com.m2catalyst.m2sdk.data_transmission.ingestion.dtos.SyncDeviceResponseMessage r0 = r15.sync_device_response
            java.lang.Integer r0 = r0.device_id
            if (r0 != 0) goto L_0x00f1
            goto L_0x00f5
        L_0x00f1:
            int r12 = r0.intValue()
        L_0x00f5:
            com.m2catalyst.m2sdk.r2 r0 = r14.configuration
            com.m2catalyst.m2sdk.d6 r0 = r0.b()
            r0.b(r12)
            com.m2catalyst.m2sdk.r2 r0 = r14.configuration
            com.m2catalyst.m2sdk.z5 r0 = r0.a()
            com.m2catalyst.m2sdk.a6 r1 = com.m2catalyst.m2sdk.a6.DEVICE_ID
            java.lang.Integer r2 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r12)
            r0.a(r1, r2)
            goto L_0x014f
        L_0x010e:
            com.m2catalyst.m2sdk.logger.Event$Builder r2 = new com.m2catalyst.m2sdk.logger.Event$Builder
            java.lang.String r3 = "Device sync error"
            r2.<init>(r3, r0)
            com.m2catalyst.m2sdk.logger.Event r5 = r2.build()
            r6 = 0
            r7 = 0
            r8 = 6
            r9 = 0
            r4 = r1
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r4, r5, r6, r7, r8, r9)
            java.lang.String r0 = r15.details
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            java.lang.String r3 = "Could not sync device at this time - "
            r2.<init>(r3)
            r2.append(r0)
            java.lang.String r0 = "."
            r2.append(r0)
            java.lang.String r6 = r2.toString()
            java.lang.String r5 = "DEVICE_REPOSITORY_LOGS"
            r7 = 0
            r8 = 0
            r9 = 12
            r10 = 0
            com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.log$default(r4, r5, r6, r7, r8, r9, r10)
            com.m2catalyst.m2sdk.r2 r0 = r14.configuration
            com.m2catalyst.m2sdk.d6 r0 = r0.b()
            int r0 = r0.a()
            if (r0 != r12) goto L_0x014f
            r14.deviceSynced(r11)
        L_0x014f:
            r14.syncInProcess = r11
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.business.repositories.DeviceRepository.syncDevice(byte[], kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final boolean syncNeeded() {
        DeviceInfo deviceInfo2 = this.deviceInfo;
        Intrinsics.checkNotNull(deviceInfo2);
        if (deviceInfo2.getOsVersion() >= Build.VERSION.SDK_INT) {
            z5 a = this.configuration.a();
            a6 a6Var = a6.API_KEY;
            int i = -3;
            if (a.a.getAll().containsKey("deviceId")) {
                i = a.a.getAll().get("deviceId");
            }
            Integer num = (Integer) i;
            return (num != null && num.intValue() == -3) || !wasDeviceSynced();
        }
    }
}
