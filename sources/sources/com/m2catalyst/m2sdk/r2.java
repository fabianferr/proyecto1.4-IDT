package com.m2catalyst.m2sdk;

import android.content.Context;
import com.google.gson.Gson;
import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.external.DataAvailability;
import com.m2catalyst.m2sdk.external.LoggingLevel;
import com.m2catalyst.m2sdk.external.M2SDKConfiguration;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.json.JSONObject;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.component.KoinScopeComponent;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

/* compiled from: M2InternalConfiguration.kt */
public final class r2 implements DataAvailability.ConfigurationAvailability, KoinComponent {
    public static r2 j;
    public boolean a;
    public boolean b;
    public boolean c;
    public boolean d;
    public boolean e;
    public boolean f;
    public M2Configuration g;
    public final d6 h = new d6();
    public final Lazy i = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new f(this));

    /* compiled from: M2InternalConfiguration.kt */
    public static final class a {
        public static r2 a() {
            if (r2.j == null) {
                r2.j = new r2();
            }
            r2 r2Var = r2.j;
            Intrinsics.checkNotNull(r2Var);
            return r2Var;
        }
    }

    /* compiled from: M2InternalConfiguration.kt */
    public /* synthetic */ class b extends FunctionReferenceImpl implements Function0<String> {
        public b(Object obj) {
            super(0, obj, r2.class, "getM2Uuid", "getM2Uuid()Ljava/lang/String;", 0);
        }

        public final Object invoke() {
            return ((r2) this.receiver).getM2Uuid();
        }
    }

    /* compiled from: M2InternalConfiguration.kt */
    public /* synthetic */ class c extends FunctionReferenceImpl implements Function0<String> {
        public c(Object obj) {
            super(0, obj, r2.class, "getSDKVersion", "getSDKVersion()Ljava/lang/String;", 0);
        }

        public final Object invoke() {
            return ((r2) this.receiver).getSDKVersion();
        }
    }

    /* compiled from: M2InternalConfiguration.kt */
    public /* synthetic */ class d extends FunctionReferenceImpl implements Function0<Boolean> {
        public d(Object obj) {
            super(0, obj, r2.class, "isCollectionRunning", "isCollectionRunning()Ljava/lang/Boolean;", 0);
        }

        public final Object invoke() {
            return ((r2) this.receiver).isCollectionRunning();
        }
    }

    /* compiled from: M2InternalConfiguration.kt */
    public /* synthetic */ class e extends FunctionReferenceImpl implements Function0<Boolean> {
        public e(Object obj) {
            super(0, obj, r2.class, "isTransmitting", "isTransmitting()Ljava/lang/Boolean;", 0);
        }

        public final Object invoke() {
            return ((r2) this.receiver).isTransmitting();
        }
    }

    /* compiled from: KoinComponent.kt */
    public static final class f extends Lambda implements Function0<z5> {
        public final /* synthetic */ KoinComponent a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(KoinComponent koinComponent) {
            super(0);
            this.a = koinComponent;
        }

        /* JADX WARNING: type inference failed for: r0v2, types: [java.lang.Object, com.m2catalyst.m2sdk.z5] */
        /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object, com.m2catalyst.m2sdk.z5] */
        public final z5 invoke() {
            KoinComponent koinComponent = this.a;
            if (koinComponent instanceof KoinScopeComponent) {
                return ((KoinScopeComponent) koinComponent).getScope().get(Reflection.getOrCreateKotlinClass(z5.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
            }
            return y1.a(koinComponent).get(Reflection.getOrCreateKotlinClass(z5.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
        }
    }

    public final z5 a() {
        return (z5) this.i.getValue();
    }

    public final d6 b() {
        return this.h;
    }

    public final M2Configuration c() {
        return this.g;
    }

    public final boolean d() {
        return a(false).isComplete();
    }

    public final boolean e() {
        return this.a && this.b && this.c && this.d && this.e && d();
    }

    public final Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r2 = r2.getDataAccess();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getM2Uuid() {
        /*
            r4 = this;
            com.m2catalyst.m2sdk.external.M2SDK r0 = com.m2catalyst.m2sdk.external.M2SDK.INSTANCE
            com.m2catalyst.m2sdk.r2$b r1 = new com.m2catalyst.m2sdk.r2$b
            r1.<init>(r4)
            com.m2catalyst.m2sdk.configuration.M2Configuration r2 = r4.g
            r3 = 0
            if (r2 == 0) goto L_0x0015
            com.m2catalyst.m2sdk.n2 r2 = r2.getDataAccess()
            if (r2 == 0) goto L_0x0015
            com.m2catalyst.m2sdk.l2 r2 = r2.a
            goto L_0x0016
        L_0x0015:
            r2 = r3
        L_0x0016:
            boolean r0 = r0.isAccessible(r1, r2)
            if (r0 == 0) goto L_0x0020
            com.m2catalyst.m2sdk.d6 r0 = r4.h
            java.lang.String r3 = r0.b
        L_0x0020:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.r2.getM2Uuid():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r2 = r2.getDataAccess();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getSDKVersion() {
        /*
            r4 = this;
            com.m2catalyst.m2sdk.external.M2SDK r0 = com.m2catalyst.m2sdk.external.M2SDK.INSTANCE
            com.m2catalyst.m2sdk.r2$c r1 = new com.m2catalyst.m2sdk.r2$c
            r1.<init>(r4)
            com.m2catalyst.m2sdk.configuration.M2Configuration r2 = r4.g
            r3 = 0
            if (r2 == 0) goto L_0x0015
            com.m2catalyst.m2sdk.n2 r2 = r2.getDataAccess()
            if (r2 == 0) goto L_0x0015
            com.m2catalyst.m2sdk.l2 r2 = r2.a
            goto L_0x0016
        L_0x0015:
            r2 = r3
        L_0x0016:
            boolean r0 = r0.isAccessible(r1, r2)
            if (r0 == 0) goto L_0x001e
            java.lang.String r3 = "10.0.0.49"
        L_0x001e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.r2.getSDKVersion():java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r2 = r2.getDataAccess();
     */
    @com.m2catalyst.m2sdk.w2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean isCollectionRunning() {
        /*
            r4 = this;
            com.m2catalyst.m2sdk.external.M2SDK r0 = com.m2catalyst.m2sdk.external.M2SDK.INSTANCE
            com.m2catalyst.m2sdk.r2$d r1 = new com.m2catalyst.m2sdk.r2$d
            r1.<init>(r4)
            com.m2catalyst.m2sdk.configuration.M2Configuration r2 = r4.g
            r3 = 0
            if (r2 == 0) goto L_0x0015
            com.m2catalyst.m2sdk.n2 r2 = r2.getDataAccess()
            if (r2 == 0) goto L_0x0015
            com.m2catalyst.m2sdk.l2 r2 = r2.a
            goto L_0x0016
        L_0x0015:
            r2 = r3
        L_0x0016:
            boolean r0 = r0.isAccessible(r1, r2)
            if (r0 == 0) goto L_0x0022
            boolean r0 = r4.f
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
        L_0x0022:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.r2.isCollectionRunning():java.lang.Boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000c, code lost:
        r2 = r2.getDataAccess();
     */
    @com.m2catalyst.m2sdk.w2
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean isTransmitting() {
        /*
            r4 = this;
            com.m2catalyst.m2sdk.external.M2SDK r0 = com.m2catalyst.m2sdk.external.M2SDK.INSTANCE
            com.m2catalyst.m2sdk.r2$e r1 = new com.m2catalyst.m2sdk.r2$e
            r1.<init>(r4)
            com.m2catalyst.m2sdk.configuration.M2Configuration r2 = r4.g
            r3 = 0
            if (r2 == 0) goto L_0x0015
            com.m2catalyst.m2sdk.n2 r2 = r2.getDataAccess()
            if (r2 == 0) goto L_0x0015
            com.m2catalyst.m2sdk.l2 r2 = r2.a
            goto L_0x0016
        L_0x0015:
            r2 = r3
        L_0x0016:
            boolean r0 = r0.isAccessible(r1, r2)
            if (r0 == 0) goto L_0x0022
            boolean r0 = r4.c
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r0)
        L_0x0022:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.r2.isTransmitting():java.lang.Boolean");
    }

    public final boolean a(r5 r5Var) {
        Intrinsics.checkNotNullParameter(r5Var, "config");
        int ordinal = r5Var.ordinal();
        if (ordinal == 0) {
            return this.a;
        }
        if (ordinal == 1) {
            if (this.b) {
                z5 a2 = a();
                a6 a6Var = a6.API_KEY;
                Object obj = Boolean.FALSE;
                if (a2.a.getAll().containsKey("dbMigrationV8V9")) {
                    obj = a2.a.getAll().get("dbMigrationV8V9");
                }
                Boolean bool = (Boolean) obj;
                if (bool != null ? bool.booleanValue() : false) {
                    return true;
                }
            }
            return false;
        } else if (ordinal == 2) {
            return this.e;
        } else {
            if (ordinal == 3) {
                return this.c;
            }
            if (ordinal == 4) {
                return this.d;
            }
            if (ordinal == 5) {
                return this.f;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    public final M2SDKConfiguration a(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        z5 a2 = a();
        a6 a6Var = a6.API_KEY;
        if (!a2.a.getAll().containsKey("m2configJSON")) {
            obj = "";
        } else {
            obj = a2.a.getAll().get("m2configJSON");
        }
        String str = (String) obj;
        if (str == null || str.length() == 0) {
            return null;
        }
        JSONObject jSONObject = new JSONObject(str);
        M2SDKConfiguration.Builder builder = new M2SDKConfiguration.Builder(context);
        String string = jSONObject.getString("apiKey");
        Intrinsics.checkNotNullExpressionValue(string, "json.getString(\"apiKey\")");
        M2SDKConfiguration.Builder withApiKey = builder.withApiKey(string);
        String string2 = jSONObject.getString("packageName");
        Intrinsics.checkNotNullExpressionValue(string2, "json.getString(\"packageName\")");
        M2SDKConfiguration.Builder withPackageName$m2sdk_release = withApiKey.withPackageName$m2sdk_release(string2);
        String string3 = jSONObject.getString("appName");
        Intrinsics.checkNotNullExpressionValue(string3, "json.getString(\"appName\")");
        M2SDKConfiguration.Builder withCrashExceptionHandling = withPackageName$m2sdk_release.withAppName(string3).withCrashExceptionHandling(jSONObject.getBoolean("crashExceptionHandling"));
        LoggingLevel byId$m2sdk_release = LoggingLevel.Companion.getById$m2sdk_release(jSONObject.getInt("loggingLevel"));
        if (byId$m2sdk_release == null) {
            byId$m2sdk_release = LoggingLevel.ERROR;
        }
        return withCrashExceptionHandling.withLoggingLevel(byId$m2sdk_release).build();
    }

    public final void a(M2SDKConfiguration m2SDKConfiguration) {
        Intrinsics.checkNotNullParameter(m2SDKConfiguration, "m2config");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("apiKey", m2SDKConfiguration.getApiKey());
        jSONObject.put("packageName", m2SDKConfiguration.getPackageName());
        jSONObject.put("appName", m2SDKConfiguration.getAppName());
        jSONObject.put("crashExceptionHandling", m2SDKConfiguration.getCrashExceptionHandling$m2sdk_release());
        LoggingLevel loggingLevel$m2sdk_release = m2SDKConfiguration.getLoggingLevel$m2sdk_release();
        jSONObject.put("loggingLevel", loggingLevel$m2sdk_release != null ? Integer.valueOf(loggingLevel$m2sdk_release.getId()) : null);
        z5 a2 = a();
        a6 a6Var = a6.M2CONFIG_JSON;
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "jsonBuilder.toString()");
        a2.a(a6Var, jSONObject2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0011, code lost:
        if ((r10.isComplete()) == false) goto L_0x0013;
     */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x01e3  */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0201  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0207 A[SYNTHETIC, Splitter:B:116:0x0207] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0219  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0237  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0239  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x023d A[SYNTHETIC, Splitter:B:133:0x023d] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x026c  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0270 A[SYNTHETIC, Splitter:B:148:0x0270] */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x0281  */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0177  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0195  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0197  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x019b A[SYNTHETIC, Splitter:B:82:0x019b] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01cb  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01d1 A[SYNTHETIC, Splitter:B:99:0x01d1] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.m2catalyst.m2sdk.configuration.M2Configuration a(boolean r10) {
        /*
            r9 = this;
            r0 = 0
            r1 = 1
            if (r10 != 0) goto L_0x0013
            com.m2catalyst.m2sdk.configuration.M2Configuration r10 = r9.g
            if (r10 == 0) goto L_0x0013
            boolean r10 = r10.isComplete()
            if (r10 != r1) goto L_0x0010
            r10 = 1
            goto L_0x0011
        L_0x0010:
            r10 = 0
        L_0x0011:
            if (r10 != 0) goto L_0x0288
        L_0x0013:
            com.m2catalyst.m2sdk.configuration.M2Configuration r10 = new com.m2catalyst.m2sdk.configuration.M2Configuration
            r10.<init>()
            com.m2catalyst.m2sdk.z5 r2 = r9.a()
            com.m2catalyst.m2sdk.a6 r3 = com.m2catalyst.m2sdk.a6.LOCAL_SDK_PACKAGE_NAME
            java.lang.String r3 = r3.a
            android.content.SharedPreferences r4 = r2.a
            java.util.Map r4 = r4.getAll()
            boolean r4 = r4.containsKey(r3)
            java.lang.String r5 = ""
            if (r4 != 0) goto L_0x0030
            r2 = r5
            goto L_0x003a
        L_0x0030:
            android.content.SharedPreferences r2 = r2.a
            java.util.Map r2 = r2.getAll()
            java.lang.Object r2 = r2.get(r3)
        L_0x003a:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x003f
            r2 = r5
        L_0x003f:
            r10.setPackageName$m2sdk_release(r2)
            com.m2catalyst.m2sdk.z5 r2 = r9.a()
            android.content.SharedPreferences r3 = r2.a
            java.util.Map r3 = r3.getAll()
            java.lang.String r4 = "apikey"
            boolean r3 = r3.containsKey(r4)
            if (r3 != 0) goto L_0x0056
            r2 = r5
            goto L_0x0060
        L_0x0056:
            android.content.SharedPreferences r2 = r2.a
            java.util.Map r2 = r2.getAll()
            java.lang.Object r2 = r2.get(r4)
        L_0x0060:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x0065
            r2 = r5
        L_0x0065:
            r10.setApiKey$m2sdk_release(r2)
            com.m2catalyst.m2sdk.z5 r2 = r9.a()
            com.m2catalyst.m2sdk.a6 r3 = com.m2catalyst.m2sdk.a6.LOCAL_SDK_APP_NAME
            java.lang.String r3 = r3.a
            android.content.SharedPreferences r4 = r2.a
            java.util.Map r4 = r4.getAll()
            boolean r4 = r4.containsKey(r3)
            if (r4 != 0) goto L_0x007e
            r2 = r5
            goto L_0x0088
        L_0x007e:
            android.content.SharedPreferences r2 = r2.a
            java.util.Map r2 = r2.getAll()
            java.lang.Object r2 = r2.get(r3)
        L_0x0088:
            java.lang.String r2 = (java.lang.String) r2
            if (r2 != 0) goto L_0x008d
            r2 = r5
        L_0x008d:
            r10.setAppName$m2sdk_release(r2)
            com.m2catalyst.m2sdk.z5 r2 = r9.a()
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            android.content.SharedPreferences r4 = r2.a
            java.util.Map r4 = r4.getAll()
            java.lang.String r6 = "sdkCrashRecording"
            boolean r4 = r4.containsKey(r6)
            if (r4 != 0) goto L_0x00a6
            r2 = r3
            goto L_0x00b0
        L_0x00a6:
            android.content.SharedPreferences r2 = r2.a
            java.util.Map r2 = r2.getAll()
            java.lang.Object r2 = r2.get(r6)
        L_0x00b0:
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            java.util.Set<java.lang.String> r4 = com.m2catalyst.m2sdk.s1.a
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r2, (java.lang.Object) r3)
            r10.setCrashExceptionHandling$m2sdk_release(r2)
            com.m2catalyst.m2sdk.external.LoggingLevel$Companion r2 = com.m2catalyst.m2sdk.external.LoggingLevel.Companion
            com.m2catalyst.m2sdk.z5 r3 = r9.a()
            com.m2catalyst.m2sdk.a6 r4 = com.m2catalyst.m2sdk.a6.SDK_LOGGING_LEVEL
            com.m2catalyst.m2sdk.external.LoggingLevel r6 = com.m2catalyst.m2sdk.external.LoggingLevel.INFO
            int r7 = r6.getId()
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            java.lang.String r4 = r4.a
            android.content.SharedPreferences r8 = r3.a
            java.util.Map r8 = r8.getAll()
            boolean r8 = r8.containsKey(r4)
            if (r8 != 0) goto L_0x00dc
            goto L_0x00e6
        L_0x00dc:
            android.content.SharedPreferences r3 = r3.a
            java.util.Map r3 = r3.getAll()
            java.lang.Object r7 = r3.get(r4)
        L_0x00e6:
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto L_0x00ef
            int r3 = r7.intValue()
            goto L_0x00f3
        L_0x00ef:
            int r3 = r6.getId()
        L_0x00f3:
            com.m2catalyst.m2sdk.external.LoggingLevel r3 = r2.getById$m2sdk_release(r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)
            r10.setLoggingLevel$m2sdk_release(r3)
            com.m2catalyst.m2sdk.z5 r3 = r9.a()
            com.m2catalyst.m2sdk.a6 r4 = com.m2catalyst.m2sdk.a6.SDK_SUPER_LOGGING_LEVEL
            r6 = -1
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            java.lang.String r4 = r4.a
            android.content.SharedPreferences r8 = r3.a
            java.util.Map r8 = r8.getAll()
            boolean r8 = r8.containsKey(r4)
            if (r8 != 0) goto L_0x0117
            goto L_0x0121
        L_0x0117:
            android.content.SharedPreferences r3 = r3.a
            java.util.Map r3 = r3.getAll()
            java.lang.Object r7 = r3.get(r4)
        L_0x0121:
            java.lang.Integer r7 = (java.lang.Integer) r7
            if (r7 == 0) goto L_0x0129
            int r6 = r7.intValue()
        L_0x0129:
            com.m2catalyst.m2sdk.external.LoggingLevel r2 = r2.getById$m2sdk_release(r6)
            r10.setSuperloggingLevel$m2sdk_release(r2)
            com.m2catalyst.m2sdk.configuration.M2Configuration r2 = r9.g
            if (r2 == 0) goto L_0x013c
            boolean r2 = r2.isComplete()
            if (r2 != r1) goto L_0x013c
            r2 = 1
            goto L_0x013d
        L_0x013c:
            r2 = 0
        L_0x013d:
            if (r2 != 0) goto L_0x0286
            com.m2catalyst.m2sdk.x2 r2 = com.m2catalyst.m2sdk.y2.a.a(r9)
            com.m2catalyst.m2sdk.a6 r3 = com.m2catalyst.m2sdk.a6.REMOTE_SDK_INGESTION_CONFIGURATION
            com.m2catalyst.m2sdk.s2 r4 = new com.m2catalyst.m2sdk.s2
            r4.<init>(r9, r3)
            java.lang.String r3 = "block"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r3)
            java.lang.Object r4 = r4.invoke()     // Catch:{ Exception -> 0x0154 }
            goto L_0x0156
        L_0x0154:
            r4 = r5
        L_0x0156:
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r4.length()
            if (r6 != 0) goto L_0x0160
            r6 = 1
            goto L_0x0161
        L_0x0160:
            r6 = 0
        L_0x0161:
            r7 = 0
            if (r6 == 0) goto L_0x0165
            goto L_0x0172
        L_0x0165:
            com.google.gson.Gson r6 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0171 }
            r6.<init>()     // Catch:{ Exception -> 0x0171 }
            java.lang.Class<com.m2catalyst.m2sdk.q2> r8 = com.m2catalyst.m2sdk.q2.class
            java.lang.Object r4 = r6.fromJson((java.lang.String) r4, r8)     // Catch:{ Exception -> 0x0171 }
            goto L_0x0173
        L_0x0171:
        L_0x0172:
            r4 = r7
        L_0x0173:
            com.m2catalyst.m2sdk.q2 r4 = (com.m2catalyst.m2sdk.q2) r4
            if (r4 != 0) goto L_0x0179
            com.m2catalyst.m2sdk.q2 r4 = r2.a
        L_0x0179:
            r10.setIngestionConfig$m2sdk_release(r4)
            com.m2catalyst.m2sdk.a6 r4 = com.m2catalyst.m2sdk.a6.REMOTE_SDK_GENERAL_CONFIGURATION
            com.m2catalyst.m2sdk.s2 r6 = new com.m2catalyst.m2sdk.s2
            r6.<init>(r9, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            java.lang.Object r4 = r6.invoke()     // Catch:{ Exception -> 0x018b }
            goto L_0x018d
        L_0x018b:
            r4 = r5
        L_0x018d:
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r4.length()
            if (r6 != 0) goto L_0x0197
            r6 = 1
            goto L_0x0198
        L_0x0197:
            r6 = 0
        L_0x0198:
            if (r6 == 0) goto L_0x019b
            goto L_0x01a8
        L_0x019b:
            com.google.gson.Gson r6 = new com.google.gson.Gson     // Catch:{ Exception -> 0x01a7 }
            r6.<init>()     // Catch:{ Exception -> 0x01a7 }
            java.lang.Class<com.m2catalyst.m2sdk.p2> r8 = com.m2catalyst.m2sdk.p2.class
            java.lang.Object r4 = r6.fromJson((java.lang.String) r4, r8)     // Catch:{ Exception -> 0x01a7 }
            goto L_0x01a9
        L_0x01a7:
        L_0x01a8:
            r4 = r7
        L_0x01a9:
            com.m2catalyst.m2sdk.p2 r4 = (com.m2catalyst.m2sdk.p2) r4
            if (r4 != 0) goto L_0x01af
            com.m2catalyst.m2sdk.p2 r4 = r2.f
        L_0x01af:
            r10.setGeneralConfig$m2sdk_release(r4)
            com.m2catalyst.m2sdk.a6 r4 = com.m2catalyst.m2sdk.a6.REMOTE_SDK_LOCATION_CONFIGURATION
            com.m2catalyst.m2sdk.s2 r6 = new com.m2catalyst.m2sdk.s2
            r6.<init>(r9, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            java.lang.Object r4 = r6.invoke()     // Catch:{ Exception -> 0x01c1 }
            goto L_0x01c3
        L_0x01c1:
            r4 = r5
        L_0x01c3:
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r4.length()
            if (r6 != 0) goto L_0x01cd
            r6 = 1
            goto L_0x01ce
        L_0x01cd:
            r6 = 0
        L_0x01ce:
            if (r6 == 0) goto L_0x01d1
            goto L_0x01de
        L_0x01d1:
            com.google.gson.Gson r6 = new com.google.gson.Gson     // Catch:{ Exception -> 0x01dd }
            r6.<init>()     // Catch:{ Exception -> 0x01dd }
            java.lang.Class<com.m2catalyst.m2sdk.h2> r8 = com.m2catalyst.m2sdk.h2.class
            java.lang.Object r4 = r6.fromJson((java.lang.String) r4, r8)     // Catch:{ Exception -> 0x01dd }
            goto L_0x01df
        L_0x01dd:
        L_0x01de:
            r4 = r7
        L_0x01df:
            com.m2catalyst.m2sdk.h2 r4 = (com.m2catalyst.m2sdk.h2) r4
            if (r4 != 0) goto L_0x01e5
            com.m2catalyst.m2sdk.h2 r4 = r2.d
        L_0x01e5:
            r10.setLocationConfiguration$m2sdk_release(r4)
            com.m2catalyst.m2sdk.a6 r4 = com.m2catalyst.m2sdk.a6.REMOTE_SDK_MNSI_CONFIGURATION
            com.m2catalyst.m2sdk.s2 r6 = new com.m2catalyst.m2sdk.s2
            r6.<init>(r9, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            java.lang.Object r4 = r6.invoke()     // Catch:{ Exception -> 0x01f7 }
            goto L_0x01f9
        L_0x01f7:
            r4 = r5
        L_0x01f9:
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r4.length()
            if (r6 != 0) goto L_0x0203
            r6 = 1
            goto L_0x0204
        L_0x0203:
            r6 = 0
        L_0x0204:
            if (r6 == 0) goto L_0x0207
            goto L_0x0214
        L_0x0207:
            com.google.gson.Gson r6 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0213 }
            r6.<init>()     // Catch:{ Exception -> 0x0213 }
            java.lang.Class<com.m2catalyst.m2sdk.f3> r8 = com.m2catalyst.m2sdk.f3.class
            java.lang.Object r4 = r6.fromJson((java.lang.String) r4, r8)     // Catch:{ Exception -> 0x0213 }
            goto L_0x0215
        L_0x0213:
        L_0x0214:
            r4 = r7
        L_0x0215:
            com.m2catalyst.m2sdk.f3 r4 = (com.m2catalyst.m2sdk.f3) r4
            if (r4 != 0) goto L_0x021b
            com.m2catalyst.m2sdk.f3 r4 = r2.e
        L_0x021b:
            r10.setMnsiConfiguration$m2sdk_release(r4)
            com.m2catalyst.m2sdk.a6 r4 = com.m2catalyst.m2sdk.a6.REMOTE_SDK_SPEED_TEST_CONFIGURATION
            com.m2catalyst.m2sdk.s2 r6 = new com.m2catalyst.m2sdk.s2
            r6.<init>(r9, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            java.lang.Object r4 = r6.invoke()     // Catch:{ Exception -> 0x022d }
            goto L_0x022f
        L_0x022d:
            r4 = r5
        L_0x022f:
            java.lang.String r4 = (java.lang.String) r4
            int r6 = r4.length()
            if (r6 != 0) goto L_0x0239
            r6 = 1
            goto L_0x023a
        L_0x0239:
            r6 = 0
        L_0x023a:
            if (r6 == 0) goto L_0x023d
            goto L_0x024a
        L_0x023d:
            com.google.gson.Gson r6 = new com.google.gson.Gson     // Catch:{ Exception -> 0x0249 }
            r6.<init>()     // Catch:{ Exception -> 0x0249 }
            java.lang.Class<com.m2catalyst.m2sdk.f6> r8 = com.m2catalyst.m2sdk.f6.class
            java.lang.Object r4 = r6.fromJson((java.lang.String) r4, r8)     // Catch:{ Exception -> 0x0249 }
            goto L_0x024b
        L_0x0249:
        L_0x024a:
            r4 = r7
        L_0x024b:
            com.m2catalyst.m2sdk.f6 r4 = (com.m2catalyst.m2sdk.f6) r4
            if (r4 != 0) goto L_0x0251
            com.m2catalyst.m2sdk.f6 r4 = r2.c
        L_0x0251:
            r10.setSpeedTestConfiguration$m2sdk_release(r4)
            com.m2catalyst.m2sdk.a6 r4 = com.m2catalyst.m2sdk.a6.REMOTE_SDK_DATA_ACCESS_CONFIGURATION
            com.m2catalyst.m2sdk.s2 r6 = new com.m2catalyst.m2sdk.s2
            r6.<init>(r9, r4)
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r3)
            java.lang.Object r5 = r6.invoke()     // Catch:{ Exception -> 0x0263 }
            goto L_0x0264
        L_0x0263:
        L_0x0264:
            java.lang.String r5 = (java.lang.String) r5
            int r3 = r5.length()
            if (r3 != 0) goto L_0x026d
            r0 = 1
        L_0x026d:
            if (r0 == 0) goto L_0x0270
            goto L_0x027d
        L_0x0270:
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ Exception -> 0x027c }
            r0.<init>()     // Catch:{ Exception -> 0x027c }
            java.lang.Class<com.m2catalyst.m2sdk.n2> r1 = com.m2catalyst.m2sdk.n2.class
            java.lang.Object r7 = r0.fromJson((java.lang.String) r5, r1)     // Catch:{ Exception -> 0x027c }
            goto L_0x027d
        L_0x027c:
        L_0x027d:
            com.m2catalyst.m2sdk.n2 r7 = (com.m2catalyst.m2sdk.n2) r7
            if (r7 != 0) goto L_0x0283
            com.m2catalyst.m2sdk.n2 r7 = r2.b
        L_0x0283:
            r10.setDataAccess$m2sdk_release(r7)
        L_0x0286:
            r9.g = r10
        L_0x0288:
            com.m2catalyst.m2sdk.configuration.M2Configuration r10 = r9.g
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.r2.a(boolean):com.m2catalyst.m2sdk.configuration.M2Configuration");
    }

    public final void a(Object obj) {
        Object obj2;
        Object obj3;
        Gson gson = new Gson();
        if (obj instanceof x2) {
            x2 x2Var = (x2) obj;
            if (this.g == null) {
                this.g = new M2Configuration();
            }
            M2Configuration m2Configuration = this.g;
            if (m2Configuration != null) {
                m2Configuration.setRemoteConfig(x2Var);
            }
            f6 f6Var = x2Var.c;
            if (f6Var != null) {
                a().a(a6.REMOTE_SDK_SPEED_TEST_CONFIGURATION, gson.toJson((Object) f6Var).toString());
            }
            n2 n2Var = x2Var.b;
            if (n2Var != null) {
                a().a(a6.REMOTE_SDK_DATA_ACCESS_CONFIGURATION, gson.toJson((Object) n2Var).toString());
            }
            p2 p2Var = x2Var.f;
            if (p2Var != null) {
                a().a(a6.REMOTE_SDK_GENERAL_CONFIGURATION, gson.toJson((Object) p2Var).toString());
            }
            h2 h2Var = x2Var.d;
            if (h2Var != null) {
                a().a(a6.REMOTE_SDK_LOCATION_CONFIGURATION, gson.toJson((Object) h2Var).toString());
            }
            q2 q2Var = x2Var.a;
            if (q2Var != null) {
                a().a(a6.REMOTE_SDK_INGESTION_CONFIGURATION, gson.toJson((Object) q2Var).toString());
            }
            f3 f3Var = x2Var.e;
            if (f3Var != null) {
                a().a(a6.REMOTE_SDK_MNSI_CONFIGURATION, gson.toJson((Object) f3Var).toString());
            }
        } else if (obj instanceof M2SDKConfiguration) {
            try {
                a().a(a6.M2_SDK_CONFIG, gson.toJson(obj).toString());
            } catch (Exception unused) {
            }
            if (this.g == null) {
                this.g = new M2Configuration();
            }
            M2Configuration m2Configuration2 = this.g;
            if (m2Configuration2 != null) {
                m2Configuration2.setLocalConfig((M2SDKConfiguration) obj);
            }
            M2SDKConfiguration m2SDKConfiguration = (M2SDKConfiguration) obj;
            a().a(a6.LOCAL_SDK_PACKAGE_NAME, m2SDKConfiguration.getPackageName());
            a().a(a6.LOCAL_SDK_APP_NAME, m2SDKConfiguration.getAppName());
            a().a(a6.API_KEY, m2SDKConfiguration.getApiKey());
            a().a(a6.SDK_CRASH_RECORDING, Boolean.valueOf(m2SDKConfiguration.getCrashExceptionHandling$m2sdk_release()));
            z5 a2 = a();
            a6 a6Var = a6.SDK_LOGGING_LEVEL;
            LoggingLevel loggingLevel$m2sdk_release = m2SDKConfiguration.getLoggingLevel$m2sdk_release();
            if (loggingLevel$m2sdk_release == null) {
                loggingLevel$m2sdk_release = LoggingLevel.INFO;
            }
            a2.a(a6Var, Integer.valueOf(loggingLevel$m2sdk_release.getId()));
            d6 d6Var = this.h;
            z5 a3 = a();
            String str = "";
            if (!a3.a.getAll().containsKey("apikey")) {
                obj2 = str;
            } else {
                obj2 = a3.a.getAll().get("apikey");
            }
            String str2 = (String) obj2;
            if (str2 == null) {
                str2 = str;
            }
            d6Var.getClass();
            Intrinsics.checkNotNullParameter(str2, "<set-?>");
            d6Var.d = str2;
            z5 a4 = a();
            int i2 = -3;
            int i3 = -3;
            if (a4.a.getAll().containsKey("deviceId")) {
                i3 = a4.a.getAll().get("deviceId");
            }
            Integer num = (Integer) i3;
            if (num != null) {
                i2 = num.intValue();
            }
            d6Var.a = i2;
            z5 a5 = a();
            int i4 = 1;
            int i5 = 1;
            if (a5.a.getAll().containsKey("companyId")) {
                i5 = a5.a.getAll().get("companyId");
            }
            Integer num2 = (Integer) i5;
            if (num2 != null) {
                i4 = num2.intValue();
            }
            d6Var.c = i4;
            z5 a6 = a();
            if (!a6.a.getAll().containsKey("m2Uuid")) {
                obj3 = str;
            } else {
                obj3 = a6.a.getAll().get("m2Uuid");
            }
            String str3 = (String) obj3;
            if (str3 != null) {
                str = str3;
            }
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            d6Var.b = str;
        }
    }

    public final void a(r5 r5Var, boolean z) {
        Intrinsics.checkNotNullParameter(r5Var, "config");
        int ordinal = r5Var.ordinal();
        if (ordinal == 0) {
            this.a = z;
        } else if (ordinal == 1) {
            if (z) {
                z5 a2 = a();
                a6 a6Var = a6.API_KEY;
                Object obj = Boolean.FALSE;
                if (a2.a.getAll().containsKey("dbMigrationV8V9")) {
                    obj = a2.a.getAll().get("dbMigrationV8V9");
                }
                if (Intrinsics.areEqual((Object) obj, (Object) Boolean.TRUE)) {
                    this.b = true;
                }
            }
            if (!z) {
                this.b = false;
            }
        } else if (ordinal == 2) {
            this.e = z;
        } else if (ordinal == 3) {
            this.c = z;
        } else if (ordinal == 4) {
            this.d = z;
        } else if (ordinal == 5) {
            this.f = z;
        }
    }
}
