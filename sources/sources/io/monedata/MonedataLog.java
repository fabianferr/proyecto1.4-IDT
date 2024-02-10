package io.monedata;

import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J \u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012J\u001a\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J \u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012J\u001a\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J \u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J(\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0002J\u001a\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J \u0010\u001a\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012J\u001a\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010J \u0010\u001b\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lio/monedata/MonedataLog;", "", "()V", "TAG", "", "level", "Lio/monedata/MonedataLog$Level;", "getLevel$annotations", "getLevel", "()Lio/monedata/MonedataLog$Level;", "setLevel", "(Lio/monedata/MonedataLog$Level;)V", "d", "", "message", "t", "", "lazyMessage", "Lkotlin/Function0;", "e", "i", "isLoggable", "", "priority", "", "println", "v", "w", "Level", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MonedataLog {
    public static final MonedataLog INSTANCE = new MonedataLog();
    private static final String TAG = "Monedata";
    private static Level level = Level.INFO;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lio/monedata/MonedataLog$Level;", "", "priority", "", "(Ljava/lang/String;II)V", "getPriority", "()I", "DEBUG", "ERROR", "INFO", "WARN", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum Level {
        DEBUG(3),
        ERROR(6),
        INFO(4),
        WARN(5);
        
        private final int priority;

        private Level(int i) {
            this.priority = i;
        }

        public final int getPriority() {
            return this.priority;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<String> {
        final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(0);
            this.a = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 7, 1})
    static final class b extends Lambda implements Function0<String> {
        final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str) {
            super(0);
            this.a = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 7, 1})
    static final class c extends Lambda implements Function0<String> {
        final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(String str) {
            super(0);
            this.a = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 7, 1})
    static final class d extends Lambda implements Function0<String> {
        final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(String str) {
            super(0);
            this.a = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.a;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/String;"}, k = 3, mv = {1, 7, 1})
    static final class e extends Lambda implements Function0<String> {
        final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(String str) {
            super(0);
            this.a = str;
        }

        /* renamed from: a */
        public final String invoke() {
            return this.a;
        }
    }

    private MonedataLog() {
    }

    public static /* synthetic */ void d$default(MonedataLog monedataLog, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        monedataLog.d(str, th);
    }

    public static /* synthetic */ void d$default(MonedataLog monedataLog, Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        monedataLog.d(th, (Function0<String>) function0);
    }

    public static /* synthetic */ void e$default(MonedataLog monedataLog, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        monedataLog.e(str, th);
    }

    public static /* synthetic */ void e$default(MonedataLog monedataLog, Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        monedataLog.e(th, (Function0<String>) function0);
    }

    public static final Level getLevel() {
        return level;
    }

    @JvmStatic
    public static /* synthetic */ void getLevel$annotations() {
    }

    public static /* synthetic */ void i$default(MonedataLog monedataLog, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        monedataLog.i(str, th);
    }

    public static /* synthetic */ void i$default(MonedataLog monedataLog, Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        monedataLog.i(th, (Function0<String>) function0);
    }

    private final boolean isLoggable(int i) {
        return Log.isLoggable(TAG, i);
    }

    private final void println(int i, Throwable th, Function0<String> function0) {
        Object obj;
        if (level.getPriority() <= i || isLoggable(i)) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m2344constructorimpl(function0.invoke());
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m2344constructorimpl(ResultKt.createFailure(th2));
            }
            if (Result.m2350isFailureimpl(obj)) {
                obj = null;
            }
            String str = (String) obj;
            if (str != null) {
                if (th != null) {
                    str = (str + 10) + Log.getStackTraceString(th);
                }
                Log.println(i, TAG, str);
            }
        }
    }

    public static final void setLevel(Level level2) {
        Intrinsics.checkNotNullParameter(level2, "<set-?>");
        level = level2;
    }

    public static /* synthetic */ void v$default(MonedataLog monedataLog, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        monedataLog.v(str, th);
    }

    public static /* synthetic */ void v$default(MonedataLog monedataLog, Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        monedataLog.v(th, (Function0<String>) function0);
    }

    public static /* synthetic */ void w$default(MonedataLog monedataLog, String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        monedataLog.w(str, th);
    }

    public static /* synthetic */ void w$default(MonedataLog monedataLog, Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        monedataLog.w(th, (Function0<String>) function0);
    }

    public final void d(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        d(th, (Function0<String>) new a(str));
    }

    public final void d(Throwable th, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        println(3, th, function0);
    }

    public final void e(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        e(th, (Function0<String>) new b(str));
    }

    public final void e(Throwable th, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        println(6, th, function0);
    }

    public final void i(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        i(th, (Function0<String>) new c(str));
    }

    public final void i(Throwable th, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        println(4, th, function0);
    }

    public final void v(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        v(th, (Function0<String>) new d(str));
    }

    public final void v(Throwable th, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        println(2, th, function0);
    }

    public final void w(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        w(th, (Function0<String>) new e(str));
    }

    public final void w(Throwable th, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        println(5, th, function0);
    }
}
