package io.monedata;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\b\u0010\u0003\u001a\u00020\u0002H\u0014J\b\u0010\u0004\u001a\u00020\u0002H\u0014J\u000e\u0010\u0003\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005J\u000e\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0005R\"\u0010\u0006\u001a\u00020\u00058\u0004@\u0004X.¢\u0006\u0012\n\u0004\b\u0006\u0010\b\u001a\u0004\b\t\u0010\n\"\u0004\b\t\u0010\u000b¨\u0006\u000e"}, d2 = {"Lio/monedata/m1;", "Landroid/content/SharedPreferences$OnSharedPreferenceChangeListener;", "", "b", "c", "Landroid/content/Context;", "context", "", "Landroid/content/Context;", "a", "()Landroid/content/Context;", "(Landroid/content/Context;)V", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public abstract class m1 implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final AtomicBoolean a = new AtomicBoolean(false);
    protected Context b;

    /* access modifiers changed from: protected */
    public final Context a() {
        Context context = this.b;
        if (context != null) {
            return context;
        }
        Intrinsics.throwUninitializedPropertyAccessException("context");
        return null;
    }

    /* access modifiers changed from: protected */
    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "<set-?>");
        this.b = context;
    }

    /* access modifiers changed from: protected */
    public void b() {
    }

    public final boolean b(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Result.Companion companion = Result.Companion;
            if (this.a.compareAndSet(false, true)) {
                Context applicationContext = context.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
                a(applicationContext);
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(this)");
                defaultSharedPreferences.registerOnSharedPreferenceChangeListener(this);
                b();
                obj = Result.m2344constructorimpl(Unit.INSTANCE);
                return Result.m2351isSuccessimpl(obj);
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
    }

    public final void c(Context context) {
        Object obj;
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(this)");
        try {
            Result.Companion companion = Result.Companion;
            defaultSharedPreferences.unregisterOnSharedPreferenceChangeListener(this);
            obj = Result.m2344constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        Result.m2351isSuccessimpl(obj);
        this.a.set(false);
        c();
    }
}
