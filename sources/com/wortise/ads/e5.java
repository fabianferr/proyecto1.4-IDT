package com.wortise.ads;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0005B\u000f\u0012\u0006\u0010\u0016\u001a\u00020\u0015¢\u0006\u0004\b\u0017\u0010\u0018J\b\u0010\u0003\u001a\u00020\u0002H\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\u0005\u0010\bJ\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\nR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0012\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0014\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0011¨\u0006\u0019"}, d2 = {"Lcom/wortise/ads/e5;", "Landroid/content/ContextWrapper;", "", "e", "Landroidx/core/app/NotificationCompat$Builder;", "a", "Landroid/app/Notification;", "notification", "(Landroid/app/Notification;)Lkotlin/Unit;", "builder", "(Landroidx/core/app/NotificationCompat$Builder;)Lkotlin/Unit;", "Landroid/app/NotificationManager;", "c", "()Landroid/app/NotificationManager;", "notificationManager", "", "b", "()Z", "areEnabled", "d", "isAvailable", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: NotificationHelper.kt */
public final class e5 extends ContextWrapper {
    public static final a Companion = new a((DefaultConstructorMarker) null);

    @Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nJ\u000e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002R\u0014\u0010\u0007\u001a\u00020\u00068\u0002XT¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/e5$a;", "", "Landroid/content/Context;", "context", "", "a", "", "CHANNEL_ID", "Ljava/lang/String;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: NotificationHelper.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean a(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            return g5.a.a(context, "com.wortise.ads");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e5(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        e();
    }

    private final NotificationManager c() {
        Object systemService = getSystemService("notification");
        if (systemService instanceof NotificationManager) {
            return (NotificationManager) systemService;
        }
        return null;
    }

    private final void e() {
        NotificationManager c = c();
        if (c != null) {
            f5.a(c, "com.wortise.ads", "Wortise", 0, 4, (Object) null);
        }
    }

    public final NotificationCompat.Builder a() {
        return new NotificationCompat.Builder((Context) this, "com.wortise.ads");
    }

    public final boolean b() {
        return Companion.a(this);
    }

    public final boolean d() {
        return c() != null && b();
    }

    public final Unit a(Notification notification) {
        Intrinsics.checkNotNullParameter(notification, "notification");
        NotificationManager c = c();
        if (c == null) {
            return null;
        }
        c.notify(0, notification);
        return Unit.INSTANCE;
    }

    public final Unit a(NotificationCompat.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        Notification build = builder.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return a(build);
    }
}
