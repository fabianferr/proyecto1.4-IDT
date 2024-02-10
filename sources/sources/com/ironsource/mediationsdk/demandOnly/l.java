package com.ironsource.mediationsdk.demandOnly;

import com.facebook.share.internal.ShareConstants;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.impressionData.ImpressionData;
import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003J\u0015\u0010\u0004\u001a\u00028\u00012\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/ironsource/mediationsdk/Mapper;", "I", "O", "", "map", "input", "(Ljava/lang/Object;)Ljava/lang/Object;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface l<I, O> {

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0012R\u001e\u0010\u0004\u001a\u0004\u0018\u00018\u0000X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, d2 = {"Lcom/ironsource/mediationsdk/demandOnly/ISDemandOnlyBaseListenerWrapper$Base;", "T", "", "()V", "listener", "getListener", "()Ljava/lang/Object;", "setListener", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "executeOnUIThreadIfConditionMet", "", "runnable", "Ljava/lang/Runnable;", "predicate", "", "log", "instanceId", "", "message", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static class a<T> {
        T a;

        public static void a(Runnable runnable, boolean z) {
            Intrinsics.checkNotNullParameter(runnable, "runnable");
            if (z) {
                IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, runnable, 0, 2, (Object) null);
            }
        }

        public static void a(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, ImpressionData.IMPRESSION_DATA_KEY_INSTANCE_ID);
            Intrinsics.checkNotNullParameter(str2, ShareConstants.WEB_DIALOG_PARAM_MESSAGE);
            IronLog ironLog = IronLog.CALLBACK;
            ironLog.info(str2 + " instanceId=" + str + ' ');
        }

        public final T a() {
            return this.a;
        }

        public final void a(T t) {
            this.a = t;
        }
    }

    O a(I i);
}
