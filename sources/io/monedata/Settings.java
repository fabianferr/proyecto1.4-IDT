package io.monedata;

import android.content.Context;
import android.content.SharedPreferences;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\tJ\u0017\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\fJ\u0010\u0010\r\u001a\u00020\u000b2\u0006\u0010\u0007\u001a\u00020\bH\u0007J\u0015\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\bH\u0000¢\u0006\u0002\b\u000fJ\u001d\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\u0013J\u001f\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010\u0016R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lio/monedata/Settings;", "", "()V", "KEY_ASSET", "", "KEY_BACKGROUND_LOCATION", "getAssetKey", "context", "Landroid/content/Context;", "getAssetKey$core_productionRelease", "getBackgroundLocationEnabled", "", "(Landroid/content/Context;)Ljava/lang/Boolean;", "isBackgroundLocationEnabled", "requireAssetKey", "requireAssetKey$core_productionRelease", "setAssetKey", "", "value", "setAssetKey$core_productionRelease", "setBackgroundLocationEnabled", "enable", "(Landroid/content/Context;Ljava/lang/Boolean;)V", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Settings {
    public static final Settings INSTANCE = new Settings();
    private static final String KEY_ASSET = "assetKey";
    private static final String KEY_BACKGROUND_LOCATION = "backgroundLocation";

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/content/SharedPreferences$Editor;", "", "a", "(Landroid/content/SharedPreferences$Editor;)V"}, k = 3, mv = {1, 7, 1})
    static final class a extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
        final /* synthetic */ String a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(String str) {
            super(1);
            this.a = str;
        }

        public final void a(SharedPreferences.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "$this$edit");
            editor.putString(Settings.KEY_ASSET, this.a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SharedPreferences.Editor) obj);
            return Unit.INSTANCE;
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Landroid/content/SharedPreferences$Editor;", "", "a", "(Landroid/content/SharedPreferences$Editor;)V"}, k = 3, mv = {1, 7, 1})
    static final class b extends Lambda implements Function1<SharedPreferences.Editor, Unit> {
        final /* synthetic */ Boolean a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(Boolean bool) {
            super(1);
            this.a = bool;
        }

        public final void a(SharedPreferences.Editor editor) {
            Intrinsics.checkNotNullParameter(editor, "$this$edit");
            u1.a(editor, Settings.KEY_BACKGROUND_LOCATION, this.a);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((SharedPreferences.Editor) obj);
            return Unit.INSTANCE;
        }
    }

    private Settings() {
    }

    @JvmStatic
    public static final Boolean getBackgroundLocationEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(\"io.monedata\", MODE_PRIVATE)");
        return u1.a(sharedPreferences, KEY_BACKGROUND_LOCATION, false);
    }

    @JvmStatic
    public static final boolean isBackgroundLocationEnabled(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        boolean a2 = new q0(context).a();
        SharedPreferences sharedPreferences = context.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(\"io.monedata\", MODE_PRIVATE)");
        return sharedPreferences.getBoolean(KEY_BACKGROUND_LOCATION, a2);
    }

    @JvmStatic
    public static final void setBackgroundLocationEnabled(Context context, Boolean bool) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(\"io.monedata\", MODE_PRIVATE)");
        u1.a(sharedPreferences, new b(bool));
    }

    public final String getAssetKey$core_productionRelease(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        SharedPreferences sharedPreferences = context.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(\"io.monedata\", MODE_PRIVATE)");
        return sharedPreferences.getString(KEY_ASSET, (String) null);
    }

    public final String requireAssetKey$core_productionRelease(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        String assetKey$core_productionRelease = getAssetKey$core_productionRelease(context);
        if (assetKey$core_productionRelease != null) {
            return assetKey$core_productionRelease;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final void setAssetKey$core_productionRelease(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "value");
        SharedPreferences sharedPreferences = context.getSharedPreferences(BuildConfig.LIBRARY_PACKAGE_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "getSharedPreferences(\"io.monedata\", MODE_PRIVATE)");
        u1.a(sharedPreferences, new a(str));
    }
}
