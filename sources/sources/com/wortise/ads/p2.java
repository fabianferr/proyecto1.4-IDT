package com.wortise.ads;

import android.content.Context;
import android.webkit.WebSettings;
import android.webkit.WebView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KFunction;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

@Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002R$\u0010\t\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\b\u0010\u000b\"\u0004\b\b\u0010\f¨\u0006\u000f"}, d2 = {"Lcom/wortise/ads/p2;", "", "Landroid/content/Context;", "context", "", "b", "c", "d", "a", "value", "Ljava/lang/String;", "()Ljava/lang/String;", "(Ljava/lang/String;)V", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: DeviceUserAgent.kt */
public final class p2 {
    public static final p2 a;
    private static final List<KFunction<String>> b;
    private static String c;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: DeviceUserAgent.kt */
    /* synthetic */ class a extends FunctionReferenceImpl implements Function1<Context, String> {
        a(Object obj) {
            super(1, obj, p2.class, "getFromWebSettings", "getFromWebSettings(Landroid/content/Context;)Ljava/lang/String;", 0);
        }

        /* renamed from: a */
        public final String invoke(Context context) {
            Intrinsics.checkNotNullParameter(context, "p0");
            return ((p2) this.receiver).b(context);
        }
    }

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: DeviceUserAgent.kt */
    /* synthetic */ class b extends FunctionReferenceImpl implements Function1<Context, String> {
        b(Object obj) {
            super(1, obj, p2.class, "getFromWebView", "getFromWebView(Landroid/content/Context;)Ljava/lang/String;", 0);
        }

        /* renamed from: a */
        public final String invoke(Context context) {
            Intrinsics.checkNotNullParameter(context, "p0");
            return ((p2) this.receiver).c(context);
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u0010\u0004\u001a\u0004\u0018\u00018\u0001\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u00012\u0006\u0010\u0003\u001a\u00028\u0000H\n"}, d2 = {"T", "", "R", "it", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: TryMapper.kt */
    public static final class c extends Lambda implements Function1<KFunction<? extends String>, String> {
        final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(Context context) {
            super(1);
            this.a = context;
        }

        public final String invoke(KFunction<? extends String> kFunction) {
            try {
                return (String) ((Function1) kFunction).invoke(this.a);
            } catch (Throwable unused) {
                return null;
            }
        }
    }

    static {
        p2 p2Var = new p2();
        a = p2Var;
        b = CollectionsKt.listOf(new a(p2Var), new b(p2Var));
    }

    private p2() {
    }

    /* access modifiers changed from: private */
    public final String c(Context context) {
        WebView webView = new WebView(context);
        String userAgentString = webView.getSettings().getUserAgentString();
        webView.destroy();
        Intrinsics.checkNotNullExpressionValue(userAgentString, "view.settings.userAgentS… view.destroy()\n        }");
        return userAgentString;
    }

    private final String d(Context context) {
        String str = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(b), new c(context)));
        if (str == null) {
            return null;
        }
        return StringsKt.replace$default(str, "; wv", "", false, 4, (Object) null);
    }

    /* access modifiers changed from: private */
    public final String b(Context context) {
        String defaultUserAgent = WebSettings.getDefaultUserAgent(context);
        Intrinsics.checkNotNullExpressionValue(defaultUserAgent, "getDefaultUserAgent(context)");
        return defaultUserAgent;
    }

    public final String a() {
        return c;
    }

    public final void a(String str) {
        c = str;
    }

    public final String a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String str = c;
        if (str != null) {
            return str;
        }
        String d = d(context);
        if (d == null) {
            return null;
        }
        a.a(d);
        return d;
    }
}
