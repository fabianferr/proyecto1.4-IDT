package io.monedata;

import android.app.AlertDialog;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Build;
import android.text.Html;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import io.monedata.consent.ConsentManager;
import io.monedata.consent.models.ConsentData;
import io.monedata.consent.models.ConsentSettings;
import io.monedata.consent.models.ConsentSource;
import io.monedata.extensions.CoroutinesKt;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010 \u001a\u00020\u001f\u0012\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\b\u001a\u00020\u0002R#\u0010\u000f\u001a\n \n*\u0004\u0018\u00010\t0\t8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0012\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R8\u0010\u0016\u001a\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0014\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0013j\u0004\u0018\u0001`\u00158\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u0005\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\r\u0010\u001e¨\u0006%"}, d2 = {"Lio/monedata/w;", "Landroid/content/ContextWrapper;", "", "granted", "", "a", "Lio/monedata/c1;", "binding", "d", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "inflater$delegate", "Lkotlin/Lazy;", "b", "()Landroid/view/LayoutInflater;", "inflater", "c", "()Z", "isShowing", "Lkotlin/Function1;", "Lio/monedata/consent/models/ConsentData;", "Lio/monedata/consent/ConsentRequestListener;", "listener", "Lkotlin/jvm/functions/Function1;", "getListener", "()Lkotlin/jvm/functions/Function1;", "(Lkotlin/jvm/functions/Function1;)V", "withOptOut", "Z", "getWithOptOut", "(Z)V", "Landroid/content/Context;", "context", "Lio/monedata/consent/models/ConsentSettings;", "settings", "<init>", "(Landroid/content/Context;Lio/monedata/consent/models/ConsentSettings;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class w extends ContextWrapper {
    private final ConsentSettings a;
    private AlertDialog b;
    private final Lazy c = LazyKt.lazy(new b(this));
    private Function1<? super ConsentData, Unit> d;
    private boolean e = true;

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "io.monedata.consent.dialog.ConsentDialog$deliver$1", f = "ConsentDialog.kt", i = {}, l = {55}, m = "invokeSuspend", n = {}, s = {})
    static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int a;
        final /* synthetic */ w b;
        final /* synthetic */ ConsentData c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(w wVar, ConsentData consentData, Continuation<? super a> continuation) {
            super(2, continuation);
            this.b = wVar;
            this.c = consentData;
        }

        /* renamed from: a */
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.b, this.c, continuation);
        }

        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                ConsentManager consentManager = ConsentManager.INSTANCE;
                Context baseContext = this.b.getBaseContext();
                Intrinsics.checkNotNullExpressionValue(baseContext, "baseContext");
                ConsentData consentData = this.c;
                this.a = 1;
                if (consentManager.set$core_productionRelease(baseContext, consentData, true, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if (i == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "a", "()Landroid/view/LayoutInflater;"}, k = 3, mv = {1, 7, 1})
    static final class b extends Lambda implements Function0<LayoutInflater> {
        final /* synthetic */ w a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(w wVar) {
            super(0);
            this.a = wVar;
        }

        /* renamed from: a */
        public final LayoutInflater invoke() {
            return LayoutInflater.from(this.a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(Context context, ConsentSettings consentSettings) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(consentSettings, "settings");
        this.a = consentSettings;
    }

    private final c1 a(c1 c1Var) {
        String str;
        Spanned spanned;
        Button button = c1Var.b;
        button.setOnClickListener(new w$$ExternalSyntheticLambda0(this));
        button.setText(this.a.getAllowText());
        Button button2 = c1Var.c;
        button2.setOnClickListener(new w$$ExternalSyntheticLambda1(this));
        Intrinsics.checkNotNullExpressionValue(button2, "it");
        button2.setVisibility(this.a.getRequired() || this.e ? 0 : 8);
        button2.setText(this.a.getDenyText());
        TextView textView = c1Var.d;
        textView.setMovementMethod(new LinkMovementMethod());
        String message = this.a.getMessage();
        if (Build.VERSION.SDK_INT >= 24) {
            spanned = Html.fromHtml(message, 0);
            str = "fromHtml(this, FROM_HTML_MODE_LEGACY)";
        } else {
            spanned = Html.fromHtml(message);
            str = "fromHtml(this)";
        }
        Intrinsics.checkNotNullExpressionValue(spanned, str);
        textView.setText(spanned);
        return c1Var;
    }

    /* access modifiers changed from: private */
    public static final void a(w wVar, View view) {
        Intrinsics.checkNotNullParameter(wVar, "this$0");
        wVar.a(true);
    }

    private final void a(boolean z) {
        ConsentData consentData = new ConsentData((Date) null, z, (String) null, ConsentSource.CMP, 5, (DefaultConstructorMarker) null);
        Job unused = BuildersKt__Builders_commonKt.launch$default(CoroutinesKt.getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new a(this, consentData, (Continuation<? super a>) null), 3, (Object) null);
        a();
        Function1<? super ConsentData, Unit> function1 = this.d;
        if (function1 != null) {
            function1.invoke(consentData);
        }
    }

    private final LayoutInflater b() {
        return (LayoutInflater) this.c.getValue();
    }

    /* access modifiers changed from: private */
    public static final void b(w wVar, View view) {
        Intrinsics.checkNotNullParameter(wVar, "this$0");
        wVar.a(false);
    }

    public final void a(Function1<? super ConsentData, Unit> function1) {
        this.d = function1;
    }

    public final boolean a() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            AlertDialog alertDialog = this.b;
            if (alertDialog != null) {
                d.a(alertDialog);
            }
            this.b = null;
            obj = Result.m2344constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        return Result.m2351isSuccessimpl(obj);
    }

    public final void b(boolean z) {
        this.e = z;
    }

    public final boolean c() {
        AlertDialog alertDialog = this.b;
        if (alertDialog != null) {
            return alertDialog.isShowing();
        }
        return false;
    }

    public final boolean d() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            if (!c()) {
                c1 a2 = c1.a(b());
                Intrinsics.checkNotNullExpressionValue(a2, "it");
                a(a2);
                Intrinsics.checkNotNullExpressionValue(a2, "inflate(inflater).also {…  setupView(it)\n        }");
                AlertDialog.Builder view = new AlertDialog.Builder(this).setCancelable(false).setView(a2.getRoot());
                Intrinsics.checkNotNullExpressionValue(view, "Builder(this)\n          …tView      (binding.root)");
                this.b = d.a(view, (Function0) null, 1, (Object) null);
                obj = Result.m2344constructorimpl(Unit.INSTANCE);
                return Result.m2351isSuccessimpl(obj);
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
    }
}
