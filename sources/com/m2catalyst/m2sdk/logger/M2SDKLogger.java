package com.m2catalyst.m2sdk.logger;

import android.content.Context;
import android.os.Process;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.cast.MediaError;
import com.google.android.gms.cast.MediaTrack;
import com.m2catalyst.m2sdk.configuration.M2Configuration;
import com.m2catalyst.m2sdk.external.LoggingLevel;
import com.m2catalyst.m2sdk.j3;
import com.m2catalyst.m2sdk.r2;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import kotlin.ExceptionsKt;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;
import org.koin.core.instance.InstanceFactory;
import org.koin.core.qualifier.Qualifier;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u0000 -2\u00020\u0001:\u0001-B\u0011\u0012\b\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b+\u0010,J0\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0002J1\u0010\u0011\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000f\"\u00020\u0004¢\u0006\u0004\b\u0011\u0010\u0012J1\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000f\"\u00020\u0004¢\u0006\u0004\b\u0013\u0010\u0012J1\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000f\"\u00020\u0004¢\u0006\u0004\b\u0014\u0010\u0012J1\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000f\"\u00020\u0004¢\u0006\u0004\b\u0015\u0010\u0012J1\u0010\u0016\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000f\"\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0012J9\u0010\u0017\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0010\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000f\"\u00020\u0004¢\u0006\u0004\b\u0017\u0010\u0018R\u0016\u0010\u0019\u001a\u0004\u0018\u00010\u00048\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001c\u001a\u00020\u001b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001dR\u001b\u0010#\u001a\u00020\u001e8BX\u0002¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"R\u0016\u0010$\u001a\u00020\u00048\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b$\u0010\u001aR\u0014\u0010&\u001a\u00020%8\u0002X\u0004¢\u0006\u0006\n\u0004\b&\u0010'R\u0014\u0010*\u001a\u00020\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b(\u0010)¨\u0006."}, d2 = {"Lcom/m2catalyst/m2sdk/logger/M2SDKLogger;", "Lorg/koin/core/component/KoinComponent;", "Lcom/m2catalyst/m2sdk/external/LoggingLevel;", "level", "", "tag", "message", "", "currentThread", "mainThread", "", "writeToFile", "Ljava/io/File;", "getLogDirectory", "getLogFilePath", "", "data", "v", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "i", "d", "w", "e", "log", "(Lcom/m2catalyst/m2sdk/external/LoggingLevel;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "logName", "Ljava/lang/String;", "Lcom/m2catalyst/m2sdk/r2;", "config", "Lcom/m2catalyst/m2sdk/r2;", "Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "getContext", "()Landroid/content/Context;", "context", "logFileName", "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/text/SimpleDateFormat;", "getMAX_LOG_FILE_SIZE", "()I", "MAX_LOG_FILE_SIZE", "<init>", "(Ljava/lang/String;)V", "Companion", "m2sdk_release"}, k = 1, mv = {1, 7, 1})
/* compiled from: M2SDKLogger.kt */
public final class M2SDKLogger implements KoinComponent {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LOGS = "logs";
    /* access modifiers changed from: private */
    public static final HashMap<String, M2SDKLogger> loggers = new HashMap<>();
    private final r2 config = r2.a.a();
    private final Lazy context$delegate = LazyKt.lazy(KoinPlatformTools.INSTANCE.defaultLazyMode(), new M2SDKLogger$special$$inlined$inject$default$1(this, (Qualifier) null, (Function0) null));
    private final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS z", Locale.US);
    private String logFileName;
    private final String logName;

    @Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J/\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004¢\u0006\u0002\u0010\u000fJ/\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004¢\u0006\u0002\u0010\u000fJ/\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004¢\u0006\u0002\u0010\u000fJ\u001e\u0010\u0011\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0004J/\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004¢\u0006\u0002\u0010\u000fJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019J7\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004¢\u0006\u0002\u0010\u001bJ$\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ<\u0010\u001a\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\u0016\b\u0002\u0010!\u001a\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0001\u0018\u00010\"2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ*\u0010#\u001a\u00020\n2\u0006\u0010\u001c\u001a\u00020\u001d2\u0010\b\u0002\u0010$\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ6\u0010#\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u00042\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010$\u001a\n\u0018\u00010%j\u0004\u0018\u0001`&2\b\b\u0002\u0010\u001e\u001a\u00020\u001fJ/\u0010'\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004¢\u0006\u0002\u0010\u000fJ/\u0010(\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u000e\"\u00020\u0004¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00070\u0006j\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0007`\bX\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/M2SDKLogger$Companion;", "", "()V", "LOGS", "", "loggers", "Ljava/util/HashMap;", "Lcom/m2catalyst/m2sdk/logger/M2SDKLogger;", "Lkotlin/collections/HashMap;", "a", "", "tag", "message", "data", "", "(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "d", "e", "ex", "", "getLogger", "logName", "i", "levelToString", "level", "Lcom/m2catalyst/m2sdk/external/LoggingLevel;", "log", "(Lcom/m2catalyst/m2sdk/external/LoggingLevel;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "event", "Lcom/m2catalyst/m2sdk/logger/Event;", "forward", "", "name", "params", "", "logError", "exception", "Ljava/lang/Exception;", "Lkotlin/Exception;", "v", "w", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: M2SDKLogger.kt */
    public static final class Companion {

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        /* compiled from: M2SDKLogger.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
            /* JADX WARNING: Failed to process nested try/catch */
            /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
            /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
            static {
                /*
                    com.m2catalyst.m2sdk.external.LoggingLevel[] r0 = com.m2catalyst.m2sdk.external.LoggingLevel.values()
                    int r0 = r0.length
                    int[] r0 = new int[r0]
                    com.m2catalyst.m2sdk.external.LoggingLevel r1 = com.m2catalyst.m2sdk.external.LoggingLevel.VERBOSE     // Catch:{ NoSuchFieldError -> 0x0010 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                    r2 = 1
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
                L_0x0010:
                    com.m2catalyst.m2sdk.external.LoggingLevel r1 = com.m2catalyst.m2sdk.external.LoggingLevel.INFO     // Catch:{ NoSuchFieldError -> 0x0019 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                    r2 = 2
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
                L_0x0019:
                    com.m2catalyst.m2sdk.external.LoggingLevel r1 = com.m2catalyst.m2sdk.external.LoggingLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x0022 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                    r2 = 3
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
                L_0x0022:
                    com.m2catalyst.m2sdk.external.LoggingLevel r1 = com.m2catalyst.m2sdk.external.LoggingLevel.WARN     // Catch:{ NoSuchFieldError -> 0x002b }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                    r2 = 4
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
                L_0x002b:
                    com.m2catalyst.m2sdk.external.LoggingLevel r1 = com.m2catalyst.m2sdk.external.LoggingLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0034 }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                    r2 = 5
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
                L_0x0034:
                    com.m2catalyst.m2sdk.external.LoggingLevel r1 = com.m2catalyst.m2sdk.external.LoggingLevel.ASSERT     // Catch:{ NoSuchFieldError -> 0x003d }
                    int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                    r2 = 6
                    r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
                L_0x003d:
                    $EnumSwitchMapping$0 = r0
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.M2SDKLogger.Companion.WhenMappings.<clinit>():void");
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void log$default(Companion companion, Event event, String str, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                str = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            companion.log(event, str, z);
        }

        public static /* synthetic */ void logError$default(Companion companion, Event event, Exception exc, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                exc = null;
            }
            if ((i & 4) != 0) {
                z = false;
            }
            companion.logError(event, exc, z);
        }

        public final void a(String str, String str2, String... strArr) {
            Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
            Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            Intrinsics.checkNotNullParameter(strArr, "data");
            log(LoggingLevel.ASSERT, str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final void d(String str, String str2, String... strArr) {
            Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
            Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            Intrinsics.checkNotNullParameter(strArr, "data");
            log(LoggingLevel.DEBUG, str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final void e(String str, String str2, String... strArr) {
            Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
            Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            Intrinsics.checkNotNullParameter(strArr, "data");
            log(LoggingLevel.ERROR, str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final M2SDKLogger getLogger() {
            return getLogger(MediaTrack.ROLE_MAIN);
        }

        public final void i(String str, String str2, String... strArr) {
            Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
            Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            Intrinsics.checkNotNullParameter(strArr, "data");
            log(LoggingLevel.INFO, str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final String levelToString(LoggingLevel loggingLevel) {
            Intrinsics.checkNotNullParameter(loggingLevel, "level");
            switch (WhenMappings.$EnumSwitchMapping$0[loggingLevel.ordinal()]) {
                case 1:
                    return "VERBOSE";
                case 2:
                    return "INFO";
                case 3:
                    return "DEBUG";
                case 4:
                    return "WARN";
                case 5:
                    return MediaError.ERROR_TYPE_ERROR;
                case 6:
                    return "ASSERT";
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }

        public final void log(Event event, String str, boolean z) {
            Intrinsics.checkNotNullParameter(event, "event");
            String.valueOf(event);
        }

        public final void logError(Event event, Exception exc, boolean z) {
            Intrinsics.checkNotNullParameter(event, "event");
            event.getEventName();
            event.getParams().toString();
        }

        public final void logError(String str, String str2, Exception exc, boolean z) {
            Intrinsics.checkNotNullParameter(str, "name");
        }

        public final void v(String str, String str2, String... strArr) {
            Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
            Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            Intrinsics.checkNotNullParameter(strArr, "data");
            log(LoggingLevel.VERBOSE, str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public final void w(String str, String str2, String... strArr) {
            Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
            Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            Intrinsics.checkNotNullParameter(strArr, "data");
            log(LoggingLevel.WARN, str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
        }

        public static /* synthetic */ void log$default(Companion companion, String str, String str2, Map map, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                map = null;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            companion.log(str, str2, (Map<String, Object>) map, z);
        }

        public static /* synthetic */ void logError$default(Companion companion, String str, String str2, Exception exc, boolean z, int i, Object obj) {
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                exc = null;
            }
            if ((i & 8) != 0) {
                z = false;
            }
            companion.logError(str, str2, exc, z);
        }

        public final void e(String str, String str2, Throwable th) {
            Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
            Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            Intrinsics.checkNotNullParameter(th, "ex");
            log(LoggingLevel.ERROR, str, str2, ExceptionsKt.stackTraceToString(th));
        }

        public final M2SDKLogger getLogger(String str) {
            Intrinsics.checkNotNullParameter(str, "logName");
            HashMap access$getLoggers$cp = M2SDKLogger.loggers;
            Object obj = access$getLoggers$cp.get(str);
            if (obj == null) {
                obj = new M2SDKLogger(str);
                access$getLoggers$cp.put(str, obj);
            }
            return (M2SDKLogger) obj;
        }

        public final void log(String str, String str2, Map<String, Object> map, boolean z) {
            Intrinsics.checkNotNullParameter(str, "name");
            Objects.toString(map);
        }

        public final void log(LoggingLevel loggingLevel, String str, String str2, String... strArr) {
            Intrinsics.checkNotNullParameter(loggingLevel, "level");
            Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
            Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            Intrinsics.checkNotNullParameter(strArr, "data");
            M2SDKLogger.Companion.getLogger(MediaTrack.ROLE_MAIN).log(loggingLevel, str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: M2SDKLogger.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.m2catalyst.m2sdk.external.LoggingLevel[] r0 = com.m2catalyst.m2sdk.external.LoggingLevel.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.m2catalyst.m2sdk.external.LoggingLevel r1 = com.m2catalyst.m2sdk.external.LoggingLevel.VERBOSE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.m2catalyst.m2sdk.external.LoggingLevel r1 = com.m2catalyst.m2sdk.external.LoggingLevel.INFO     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.m2catalyst.m2sdk.external.LoggingLevel r1 = com.m2catalyst.m2sdk.external.LoggingLevel.DEBUG     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.m2catalyst.m2sdk.external.LoggingLevel r1 = com.m2catalyst.m2sdk.external.LoggingLevel.WARN     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.m2catalyst.m2sdk.external.LoggingLevel r1 = com.m2catalyst.m2sdk.external.LoggingLevel.ERROR     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.m2catalyst.m2sdk.external.LoggingLevel r1 = com.m2catalyst.m2sdk.external.LoggingLevel.ASSERT     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.M2SDKLogger.WhenMappings.<clinit>():void");
        }
    }

    public M2SDKLogger(String str) {
        this.logName = str;
        this.logFileName = str == null ? MediaTrack.ROLE_MAIN : str;
    }

    private final Context getContext() {
        return (Context) this.context$delegate.getValue();
    }

    private final File getLogDirectory() {
        String absolutePath = getContext().getFilesDir().getAbsolutePath();
        return new File(absolutePath + "/logs");
    }

    private final String getLogFilePath() {
        File logDirectory = getLogDirectory();
        if (!logDirectory.exists()) {
            logDirectory.mkdirs();
        }
        String absolutePath = logDirectory.getAbsolutePath();
        String str = this.logFileName;
        return absolutePath + "/" + str + ".txt";
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
        if (r0.isDebug() == true) goto L_0x000f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int getMAX_LOG_FILE_SIZE() {
        /*
            r2 = this;
            com.m2catalyst.m2sdk.r2 r0 = r2.config
            com.m2catalyst.m2sdk.configuration.M2Configuration r0 = r0.g
            if (r0 == 0) goto L_0x000e
            boolean r0 = r0.isDebug()
            r1 = 1
            if (r0 != r1) goto L_0x000e
            goto L_0x000f
        L_0x000e:
            r1 = 0
        L_0x000f:
            if (r1 == 0) goto L_0x0014
            r0 = 10485760(0xa00000, float:1.469368E-38)
            goto L_0x0016
        L_0x0014:
            r0 = 3145728(0x300000, float:4.408104E-39)
        L_0x0016:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.m2catalyst.m2sdk.logger.M2SDKLogger.getMAX_LOG_FILE_SIZE():int");
    }

    /* access modifiers changed from: private */
    public final void writeToFile(LoggingLevel loggingLevel, String str, String str2, int i, int i2) {
        try {
            File file = new File(getLogFilePath());
            if (file.length() > ((long) getMAX_LOG_FILE_SIZE())) {
                new ZipUtils(getLogDirectory(), this.logFileName + ".zip").compress(new File(getLogFilePath()));
                try {
                    FileWriter fileWriter = new FileWriter(file, false);
                    fileWriter.write("");
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            FileWriter fileWriter2 = new FileWriter(file, true);
            fileWriter2.write((this.dateFormat.format(new Date()) + " " + i2 + " : " + i + " [" + Companion.levelToString(loggingLevel) + "] [" + str + "] " + str2) + "\n");
            fileWriter2.close();
        } catch (IOException e2) {
            Companion.e(str, "Error writing to log file: " + e2.getMessage(), new String[0]);
        }
    }

    public final void d(String str, String str2, String... strArr) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(strArr, "data");
        log(LoggingLevel.DEBUG, str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void e(String str, String str2, String... strArr) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(strArr, "data");
        log(LoggingLevel.ERROR, str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public Koin getKoin() {
        return KoinComponent.DefaultImpls.getKoin(this);
    }

    public final void i(String str, String str2, String... strArr) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(strArr, "data");
        log(LoggingLevel.INFO, str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void log(LoggingLevel loggingLevel, String str, String str2, String... strArr) {
        Intrinsics.checkNotNullParameter(loggingLevel, "level");
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(strArr, "data");
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = str2;
        for (String str3 : strArr) {
            T t = objectRef.element;
            objectRef.element = t + InstanceFactory.ERROR_SEPARATOR + str3;
        }
        M2Configuration c = this.config.c();
        LoggingLevel loggingLevel2 = null;
        LoggingLevel loggingLevel3 = c != null ? c.getLoggingLevel() : null;
        M2Configuration c2 = this.config.c();
        if (c2 != null) {
            loggingLevel2 = c2.getSuperloggingLevel();
        }
        if (loggingLevel2 == null) {
            if (loggingLevel3 != null && loggingLevel3.getId() < loggingLevel.getId()) {
                return;
            }
        } else if (loggingLevel2.getId() < loggingLevel.getId()) {
            return;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[loggingLevel.ordinal()]) {
            case 1:
                String str4 = (String) objectRef.element;
                break;
            case 2:
                String str5 = (String) objectRef.element;
                break;
            case 3:
                String str6 = (String) objectRef.element;
                break;
            case 4:
                String str7 = (String) objectRef.element;
                break;
            case 5:
                String str8 = (String) objectRef.element;
                break;
            case 6:
                String str9 = (String) objectRef.element;
                break;
        }
        j3.c(new M2SDKLogger$log$1(this, loggingLevel, str, objectRef, Process.myTid(), Process.myPid(), (Continuation<? super M2SDKLogger$log$1>) null));
    }

    public final void v(String str, String str2, String... strArr) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(strArr, "data");
        log(LoggingLevel.VERBOSE, str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
    }

    public final void w(String str, String str2, String... strArr) {
        Intrinsics.checkNotNullParameter(str, ViewHierarchyConstants.TAG_KEY);
        Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        Intrinsics.checkNotNullParameter(strArr, "data");
        log(LoggingLevel.WARN, str, str2, (String[]) Arrays.copyOf(strArr, strArr.length));
    }
}
