package com.wortise.ads;

import android.util.Log;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\"\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0007J\u001c\u0010\u0013\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\"\u0010\u0013\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0007J\u001c\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\"\u0010\u0014\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0007J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J(\u0010\u0019\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0002J\u001c\u0010\u001a\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\"\u0010\u001a\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0007J\u001c\u0010\u001b\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007J\"\u0010\u001b\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R$\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/wortise/ads/WortiseLog;", "", "()V", "TAG", "", "level", "Lcom/wortise/ads/WortiseLog$Level;", "getLevel$annotations", "getLevel", "()Lcom/wortise/ads/WortiseLog$Level;", "setLevel", "(Lcom/wortise/ads/WortiseLog$Level;)V", "d", "", "message", "t", "", "lazyMessage", "Lkotlin/Function0;", "e", "i", "isLoggable", "", "priority", "", "println", "v", "w", "Level", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: WortiseLog.kt */
public final class WortiseLog {
    public static final WortiseLog INSTANCE = new WortiseLog();
    private static final String TAG = "Wortise";
    private static Level level = Level.INFO;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/WortiseLog$Level;", "", "priority", "", "(Ljava/lang/String;II)V", "getPriority", "()I", "DEBUG", "ERROR", "INFO", "WARN", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: WortiseLog.kt */
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

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: WortiseLog.kt */
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

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: WortiseLog.kt */
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

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: WortiseLog.kt */
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

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: WortiseLog.kt */
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

    @Metadata(bv = {}, d1 = {"\u0000\u0006\n\u0002\u0010\u000e\n\u0000\u0010\u0001\u001a\u00020\u0000H\n"}, d2 = {"", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: WortiseLog.kt */
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

    private WortiseLog() {
    }

    @JvmStatic
    public static final void d(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        d$default(str, (Throwable) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void d(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        d(th, (Function0<String>) new a(str));
    }

    @JvmStatic
    public static final void d(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        d$default((Throwable) null, (Function0) function0, 1, (Object) null);
    }

    public static /* synthetic */ void d$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        d(str, th);
    }

    @JvmStatic
    public static final void e(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        e$default(str, (Throwable) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void e(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        e(th, (Function0<String>) new b(str));
    }

    @JvmStatic
    public static final void e(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        e$default((Throwable) null, (Function0) function0, 1, (Object) null);
    }

    public static /* synthetic */ void e$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        e(str, th);
    }

    public static final Level getLevel() {
        return level;
    }

    @JvmStatic
    public static /* synthetic */ void getLevel$annotations() {
    }

    @JvmStatic
    public static final void i(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        i$default(str, (Throwable) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void i(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        i(th, (Function0<String>) new c(str));
    }

    @JvmStatic
    public static final void i(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        i$default((Throwable) null, (Function0) function0, 1, (Object) null);
    }

    public static /* synthetic */ void i$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        i(str, th);
    }

    private final boolean isLoggable(int i) {
        return Log.isLoggable(TAG, i);
    }

    private final void println(int i, Throwable th, Function0<String> function0) {
        String str;
        if (level.getPriority() <= i || isLoggable(i)) {
            try {
                str = function0.invoke();
            } catch (Throwable unused) {
                str = null;
            }
            if (str != null) {
                if (th != null) {
                    str = Intrinsics.stringPlus(Intrinsics.stringPlus(str, "\n"), Log.getStackTraceString(th));
                }
                Log.println(i, TAG, str);
            }
        }
    }

    public static final void setLevel(Level level2) {
        Intrinsics.checkNotNullParameter(level2, "<set-?>");
        level = level2;
    }

    @JvmStatic
    public static final void v(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        v$default(str, (Throwable) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void v(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        v(th, (Function0<String>) new d(str));
    }

    @JvmStatic
    public static final void v(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        v$default((Throwable) null, (Function0) function0, 1, (Object) null);
    }

    public static /* synthetic */ void v$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        v(str, th);
    }

    @JvmStatic
    public static final void w(String str) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        w$default(str, (Throwable) null, 2, (Object) null);
    }

    @JvmStatic
    public static final void w(String str, Throwable th) {
        Intrinsics.checkNotNullParameter(str, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
        w(th, (Function0<String>) new e(str));
    }

    @JvmStatic
    public static final void w(Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        w$default((Throwable) null, (Function0) function0, 1, (Object) null);
    }

    public static /* synthetic */ void w$default(String str, Throwable th, int i, Object obj) {
        if ((i & 2) != 0) {
            th = null;
        }
        w(str, th);
    }

    @JvmStatic
    public static final void d(Throwable th, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        INSTANCE.println(3, th, function0);
    }

    public static /* synthetic */ void d$default(Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        d(th, (Function0<String>) function0);
    }

    @JvmStatic
    public static final void e(Throwable th, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        INSTANCE.println(6, th, function0);
    }

    public static /* synthetic */ void e$default(Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        e(th, (Function0<String>) function0);
    }

    @JvmStatic
    public static final void i(Throwable th, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        INSTANCE.println(4, th, function0);
    }

    public static /* synthetic */ void i$default(Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        i(th, (Function0<String>) function0);
    }

    @JvmStatic
    public static final void v(Throwable th, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        INSTANCE.println(2, th, function0);
    }

    public static /* synthetic */ void v$default(Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        v(th, (Function0<String>) function0);
    }

    @JvmStatic
    public static final void w(Throwable th, Function0<String> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        INSTANCE.println(5, th, function0);
    }

    public static /* synthetic */ void w$default(Throwable th, Function0 function0, int i, Object obj) {
        if ((i & 1) != 0) {
            th = null;
        }
        w(th, (Function0<String>) function0);
    }
}
