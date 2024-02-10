package com.wortise.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001:\u0001\fB\u000f\u0012\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\"\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\b2\b\u0010\u000b\u001a\u0004\u0018\u00010\nH$J\u000e\u0010\f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u0002J\u000e\u0010\u000e\u001a\u00020\r2\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0011\u001a\u00020\u000f8$X¤\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lcom/wortise/ads/a;", "Landroid/content/BroadcastReceiver;", "Landroid/content/Context;", "context", "Landroid/content/Intent;", "intent", "", "onReceive", "", "action", "Landroid/os/Bundle;", "extras", "a", "", "b", "Landroid/content/IntentFilter;", "()Landroid/content/IntentFilter;", "filter", "", "identifier", "<init>", "(J)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: ActionBroadcastReceiver.kt */
public abstract class a extends BroadcastReceiver {
    public static final C0177a Companion = new C0177a((DefaultConstructorMarker) null);
    private final long a;

    @Metadata(bv = {}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J*\u0010\u0005\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\nR\u0014\u0010\r\u001a\u00020\b8\u0002XT¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/wortise/ads/a$a;", "", "Landroid/content/Context;", "context", "Landroidx/localbroadcastmanager/content/LocalBroadcastManager;", "a", "", "identifier", "", "action", "Landroid/os/Bundle;", "extras", "", "EXTRA_IDENTIFIER", "Ljava/lang/String;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* renamed from: com.wortise.ads.a$a  reason: collision with other inner class name */
    /* compiled from: ActionBroadcastReceiver.kt */
    public static final class C0177a {
        private C0177a() {
        }

        public /* synthetic */ C0177a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        public final LocalBroadcastManager a(Context context) {
            LocalBroadcastManager instance = LocalBroadcastManager.getInstance(context.getApplicationContext());
            Intrinsics.checkNotNullExpressionValue(instance, "getInstance(context.applicationContext)");
            return instance;
        }

        public final void a(Context context, long j, String str, Bundle bundle) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
            Intent intent = new Intent(str);
            if (bundle != null) {
                intent.putExtras(bundle);
            }
            intent.putExtra("identifier", j);
            a(context).sendBroadcast(intent);
        }
    }

    public a(long j) {
        this.a = j;
    }

    /* access modifiers changed from: protected */
    public abstract IntentFilter a();

    public final void a(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Companion.a(context).registerReceiver(this, a());
    }

    /* access modifiers changed from: protected */
    public abstract void a(Context context, String str, Bundle bundle);

    public final boolean b(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            Companion.a(context).unregisterReceiver(this);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        Bundle extras = intent.getExtras();
        long longExtra = intent.getLongExtra("identifier", -1);
        if (action != null && longExtra == this.a) {
            a(context, action, extras);
        }
    }
}
