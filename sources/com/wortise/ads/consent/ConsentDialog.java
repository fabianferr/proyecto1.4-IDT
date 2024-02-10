package com.wortise.ads.consent;

import android.content.Context;
import android.content.ContextWrapper;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.text.HtmlCompat;
import com.wortise.ads.consent.models.ConsentData;
import com.wortise.ads.consent.models.ConsentSource;
import com.wortise.ads.g7;
import com.wortise.ads.w1;
import java.util.Date;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {}, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0001(B\u0017\u0012\u0006\u0010#\u001a\u00020\"\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u0006\u0010\u0005\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\u0002R\u0018\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000b\u0010\fR#\u0010\u0013\u001a\n \u000e*\u0004\u0018\u00010\r0\r8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R$\u0010\u0015\u001a\u0004\u0018\u00010\u00148\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\"\u0010\u001b\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00028F¢\u0006\u0006\u001a\u0004\b!\u0010\u001e¨\u0006)"}, d2 = {"Lcom/wortise/ads/consent/ConsentDialog;", "Landroid/content/ContextWrapper;", "", "granted", "", "dismiss", "Lcom/wortise/ads/g7;", "binding", "setupView", "show", "Landroidx/appcompat/app/AlertDialog;", "dialog", "Landroidx/appcompat/app/AlertDialog;", "Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "layoutInflater$delegate", "Lkotlin/Lazy;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater", "Lcom/wortise/ads/consent/ConsentDialog$Listener;", "listener", "Lcom/wortise/ads/consent/ConsentDialog$Listener;", "getListener", "()Lcom/wortise/ads/consent/ConsentDialog$Listener;", "setListener", "(Lcom/wortise/ads/consent/ConsentDialog$Listener;)V", "withOptOut", "Z", "getWithOptOut", "()Z", "setWithOptOut", "(Z)V", "isShowing", "Landroid/content/Context;", "context", "Lcom/wortise/ads/w1;", "settings", "<init>", "(Landroid/content/Context;Lcom/wortise/ads/w1;)V", "Listener", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ConsentDialog.kt */
public final class ConsentDialog extends ContextWrapper {
    private AlertDialog dialog;
    private final Lazy layoutInflater$delegate;
    private Listener listener;
    private final w1 settings;
    private boolean withOptOut = true;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/wortise/ads/consent/ConsentDialog$Listener;", "", "onConsentRequestFinished", "", "granted", "", "(Ljava/lang/Boolean;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: ConsentDialog.kt */
    public interface Listener {
        void onConsentRequestFinished(Boolean bool);
    }

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\n \u0001*\u0004\u0018\u00010\u00000\u0000H\n"}, d2 = {"Landroid/view/LayoutInflater;", "kotlin.jvm.PlatformType", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    /* compiled from: ConsentDialog.kt */
    static final class a extends Lambda implements Function0<LayoutInflater> {
        final /* synthetic */ Context a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(Context context) {
            super(0);
            this.a = context;
        }

        /* renamed from: a */
        public final LayoutInflater invoke() {
            return LayoutInflater.from(this.a);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConsentDialog(Context context, w1 w1Var) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(w1Var, "settings");
        this.settings = w1Var;
        this.layoutInflater$delegate = LazyKt.lazy(new a(context));
    }

    private final LayoutInflater getLayoutInflater() {
        return (LayoutInflater) this.layoutInflater$delegate.getValue();
    }

    private final void setupView(g7 g7Var) {
        AppCompatButton appCompatButton = g7Var.c;
        appCompatButton.setOnClickListener(new ConsentDialog$$ExternalSyntheticLambda0(this));
        appCompatButton.setText(this.settings.b());
        AppCompatButton appCompatButton2 = g7Var.b;
        appCompatButton2.setOnClickListener(new ConsentDialog$$ExternalSyntheticLambda1(this));
        Intrinsics.checkNotNullExpressionValue(appCompatButton2, "it");
        appCompatButton2.setVisibility(this.settings.d() || getWithOptOut() ? 0 : 8);
        appCompatButton2.setText(this.settings.a());
        TextView textView = g7Var.d;
        textView.setMovementMethod(new LinkMovementMethod());
        Spanned fromHtml = HtmlCompat.fromHtml(this.settings.c(), 0);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(this, FROM_HTML_MODE_LEGACY)");
        textView.setText(fromHtml);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupView$lambda-4$lambda-3  reason: not valid java name */
    public static final void m2335setupView$lambda4$lambda3(ConsentDialog consentDialog, View view) {
        Intrinsics.checkNotNullParameter(consentDialog, "this$0");
        consentDialog.dismiss(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: setupView$lambda-6$lambda-5  reason: not valid java name */
    public static final void m2336setupView$lambda6$lambda5(ConsentDialog consentDialog, View view) {
        Intrinsics.checkNotNullParameter(consentDialog, "this$0");
        consentDialog.dismiss(false);
    }

    public final boolean dismiss() {
        try {
            AlertDialog alertDialog = this.dialog;
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            this.dialog = null;
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public final Listener getListener() {
        return this.listener;
    }

    public final boolean getWithOptOut() {
        return this.withOptOut;
    }

    public final boolean isShowing() {
        AlertDialog alertDialog = this.dialog;
        if (alertDialog == null) {
            return false;
        }
        return alertDialog.isShowing();
    }

    public final void setListener(Listener listener2) {
        this.listener = listener2;
    }

    public final void setWithOptOut(boolean z) {
        this.withOptOut = z;
    }

    public final boolean show() {
        try {
            if (!isShowing()) {
                g7 a2 = g7.a(getLayoutInflater());
                Intrinsics.checkNotNullExpressionValue(a2, "it");
                setupView(a2);
                Intrinsics.checkNotNullExpressionValue(a2, "inflate(layoutInflater)\n…  .also { setupView(it) }");
                this.dialog = new AlertDialog.Builder(this).setCancelable(false).setTitle((CharSequence) this.settings.e()).setView((View) a2.getRoot()).show();
                return true;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        } catch (Throwable unused) {
            return false;
        }
    }

    private final void dismiss(boolean z) {
        ConsentManager.INSTANCE.set$sdk_productionRelease(this, new ConsentData(new Date(), z, (String) null, ConsentSource.CMP, 4, (DefaultConstructorMarker) null), true);
        dismiss();
        Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onConsentRequestFinished(Boolean.valueOf(z));
        }
    }
}
