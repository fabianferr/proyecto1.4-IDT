package com.ironsource.mediationsdk.demandOnly;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\rJ\u0015\u0010\u0003\u001a\u00028\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\nJ\u001d\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00028\u0000H&¢\u0006\u0002\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyListenerHolder;", "T", "", "getListener", "instanceId", "", "(Ljava/lang/String;)Ljava/lang/Object;", "setDefaultListener", "", "listener", "(Ljava/lang/Object;)V", "setListener", "(Ljava/lang/String;Ljava/lang/Object;)V", "Interstitial", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface n<T> {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0016J\u0018\u0010\u000e\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00050\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyListenerHolder$Interstitial;", "Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyListenerHolder;", "Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyInterstitialListener;", "()V", "defaultListener", "Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyInterstitialListenerWrapper;", "listenerWrappers", "", "", "getListener", "instanceId", "setDefaultListener", "", "listener", "setListener", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements n<ISDemandOnlyInterstitialListener> {
        private m a = new m();
        private final Map<String, m> b = new HashMap();

        public final /* synthetic */ Object a(String str) {
            Intrinsics.checkNotNullParameter(str, ImpressionData.IMPRESSION_DATA_KEY_INSTANCE_ID);
            m mVar = this.b.get(str);
            return mVar != null ? mVar : this.a;
        }

        public final /* synthetic */ void a(Object obj) {
            T t = (ISDemandOnlyInterstitialListener) obj;
            Intrinsics.checkNotNullParameter(t, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
            this.a = new m(t);
            for (m mVar : this.b.values()) {
                mVar.a = t;
            }
        }
    }

    T a(String str);

    void a(T t);
}
