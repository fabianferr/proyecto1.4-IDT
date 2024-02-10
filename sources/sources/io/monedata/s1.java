package io.monedata;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.preference.PreferenceManager;
import io.monedata.extensions.ClassKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

@Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0002\b\b\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0016\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0016\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\n2\u0006\u0010\u0003\u001a\u00020\u0002J\u0006\u0010\t\u001a\u00020\fJ\u001f\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u000b\u0010\rR\u001b\u0010\u0011\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u000b\u0010\u0010¨\u0006\u0014"}, d2 = {"Lio/monedata/s1;", "", "Landroid/content/Context;", "context", "Lio/monedata/u0;", "c", "", "id", "", "a", "", "b", "", "(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/Boolean;", "isAvailable$delegate", "Lkotlin/Lazy;", "()Z", "isAvailable", "<init>", "()V", "core_productionRelease"}, k = 1, mv = {1, 7, 1})
public final class s1 {
    public static final s1 a = new s1();
    private static u0 b;
    private static final Lazy c = LazyKt.lazy(a.a);

    @Metadata(bv = {}, d1 = {"\u0000\b\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0001\u0010\u0002"}, d2 = {"", "a", "()Ljava/lang/Boolean;"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function0<Boolean> {
        public static final a a = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final Boolean invoke() {
            return Boolean.valueOf(ClassKt.classExists("com.sfbx.appconsentv3.ui.AppConsentSDK"));
        }
    }

    private s1() {
    }

    private final u0 c(Context context) {
        u0 u0Var = b;
        if (u0Var != null) {
            return u0Var;
        }
        u0 a2 = v0.a.a(context);
        if (a2 == null) {
            return null;
        }
        b = a2;
        return a2;
    }

    public final List<String> a(Context context) {
        Object obj;
        List list;
        Intrinsics.checkNotNullParameter(context, "context");
        List<String> list2 = null;
        try {
            Result.Companion companion = Result.Companion;
            SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
            Intrinsics.checkNotNullExpressionValue(defaultSharedPreferences, "getDefaultSharedPreferences(this)");
            String string = defaultSharedPreferences.getString("SFBXTCF_ExtraVendorConsents", (String) null);
            if (string != null) {
                list = StringsKt.split$default((CharSequence) string, new char[]{AbstractJsonLexerKt.COMMA}, false, 0, 6, (Object) null);
            } else {
                list = null;
            }
            obj = Result.m2344constructorimpl(list);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m2350isFailureimpl(obj)) {
            list2 = obj;
        }
        return list2;
    }

    public final void a() {
        b = null;
    }

    public final boolean a(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "id");
        List<String> b2 = b(context);
        return b2 != null && b2.contains(str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001d, code lost:
        if (r2 == true) goto L_0x0021;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean b(android.content.Context r2, java.lang.String r3) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            boolean r0 = r1.a(r2, r3)
            if (r0 != 0) goto L_0x0012
            r2 = 0
            return r2
        L_0x0012:
            java.util.List r2 = r1.a(r2)
            if (r2 == 0) goto L_0x0020
            boolean r2 = r2.contains(r3)
            r3 = 1
            if (r2 != r3) goto L_0x0020
            goto L_0x0021
        L_0x0020:
            r3 = 0
        L_0x0021:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r3)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.monedata.s1.b(android.content.Context, java.lang.String):java.lang.Boolean");
    }

    public final List<String> b(Context context) {
        Object obj;
        ArrayList arrayList;
        b2 a2;
        List<a2> a3;
        Intrinsics.checkNotNullParameter(context, "context");
        List<String> list = null;
        try {
            Result.Companion companion = Result.Companion;
            u0 c2 = a.c(context);
            if (c2 == null || (a2 = c2.a()) == null || (a3 = a2.a()) == null) {
                arrayList = null;
            } else {
                arrayList = new ArrayList();
                for (a2 a4 : a3) {
                    String a5 = a4.a();
                    if (a5 != null) {
                        arrayList.add(a5);
                    }
                }
            }
            obj = Result.m2344constructorimpl(arrayList);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m2344constructorimpl(ResultKt.createFailure(th));
        }
        if (!Result.m2350isFailureimpl(obj)) {
            list = obj;
        }
        return list;
    }

    public final boolean b() {
        return ((Boolean) c.getValue()).booleanValue();
    }
}
