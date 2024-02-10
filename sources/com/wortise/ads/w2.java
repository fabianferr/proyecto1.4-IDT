package com.wortise.ads;

import android.content.Context;
import android.content.IntentFilter;
import android.os.Bundle;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\tB+\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\u001a\u0010\u0011\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0004\u0012\u00020\b0\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0014R\u001a\u0010\u000b\u001a\u00020\n8\u0014X\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\r¨\u0006\u0014"}, d2 = {"Lcom/wortise/ads/w2;", "Lcom/wortise/ads/a;", "Landroid/content/Context;", "context", "", "action", "Landroid/os/Bundle;", "extras", "", "a", "Landroid/content/IntentFilter;", "filter", "Landroid/content/IntentFilter;", "()Landroid/content/IntentFilter;", "", "identifier", "Lkotlin/Function2;", "listener", "<init>", "(JLkotlin/jvm/functions/Function2;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: FullscreenBroadcastReceiver.kt */
public final class w2 extends a {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    private final Function2<String, Bundle, Unit> b;
    private final IntentFilter c;

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\t\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0005\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0005\u0010\u0004R\u0014\u0010\u0006\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0014\u0010\u0007\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0007\u0010\u0004R\u0014\u0010\b\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\b\u0010\u0004¨\u0006\u000b"}, d2 = {"Lcom/wortise/ads/w2$a;", "", "", "EVENT_CLICK", "Ljava/lang/String;", "EVENT_COMPLETE", "EVENT_DISMISS", "EVENT_ERROR", "EXTRA_ERROR", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: FullscreenBroadcastReceiver.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w2(long j, Function2<? super String, ? super Bundle, Unit> function2) {
        super(j);
        Intrinsics.checkNotNullParameter(function2, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.b = function2;
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(CampaignEx.JSON_NATIVE_VIDEO_CLICK);
        intentFilter.addAction(CampaignEx.JSON_NATIVE_VIDEO_COMPLETE);
        intentFilter.addAction("dismiss");
        intentFilter.addAction("error");
        Unit unit = Unit.INSTANCE;
        this.c = intentFilter;
    }

    /* access modifiers changed from: protected */
    public IntentFilter a() {
        return this.c;
    }

    /* access modifiers changed from: protected */
    public void a(Context context, String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, NativeProtocol.WEB_DIALOG_ACTION);
        this.b.invoke(str, bundle);
    }
}
