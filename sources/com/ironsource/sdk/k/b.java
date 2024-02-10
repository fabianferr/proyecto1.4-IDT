package com.ironsource.sdk.k;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.ironsource.sdk.g.g;
import com.ironsource.sdk.utils.Logger;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0014\u001a\u00020\u0015H\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/ironsource/sdk/nativeAd/ISNNativeAdContainer;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "listener", "Lcom/ironsource/sdk/nativeAd/ISNNativeAdContainer$Listener;", "getListener$sdk5_release", "()Lcom/ironsource/sdk/nativeAd/ISNNativeAdContainer$Listener;", "setListener$sdk5_release", "(Lcom/ironsource/sdk/nativeAd/ISNNativeAdContainer$Listener;)V", "logTag", "", "onVisibilityChanged", "", "changedView", "Landroid/view/View;", "visibility", "", "onWindowVisibilityChanged", "prepareVisibilityParams", "Lcom/ironsource/sdk/data/ViewVisibilityParams;", "Listener", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class b extends FrameLayout {
    a a;
    private final String b;
    private Map<Integer, View> c = new LinkedHashMap();

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/ironsource/sdk/nativeAd/ISNNativeAdContainer$Listener;", "", "onVisibilityChanged", "", "viewVisibilityParams", "Lcom/ironsource/sdk/data/ViewVisibilityParams;", "sdk5_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface a {
        void a(g gVar);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.b = "ISNNativeAdContainer";
    }

    private final g a() {
        boolean z = true;
        boolean z2 = getVisibility() == 0;
        if (getWindowVisibility() != 0) {
            z = false;
        }
        return new g(z2, z, isShown());
    }

    public final void onVisibilityChanged(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "changedView");
        String str = this.b;
        Logger.i(str, "onVisibilityChanged: " + i);
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(a());
        }
    }

    public final void onWindowVisibilityChanged(int i) {
        String str = this.b;
        Logger.i(str, "onWindowVisibilityChanged: " + i);
        a aVar = this.a;
        if (aVar != null) {
            aVar.a(a());
        }
    }
}
