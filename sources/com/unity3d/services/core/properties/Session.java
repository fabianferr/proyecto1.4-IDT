package com.unity3d.services.core.properties;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bf\u0018\u0000 \u00062\u00020\u0001:\u0001\u0006R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\u0007"}, d2 = {"Lcom/unity3d/services/core/properties/Session;", "", "id", "", "getId", "()Ljava/lang/String;", "Default", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: Session.kt */
public interface Session {
    public static final Default Default = Default.$$INSTANCE;

    String getId();

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/unity3d/services/core/properties/Session$Default;", "Lcom/unity3d/services/core/properties/Session;", "()V", "id", "", "getId", "()Ljava/lang/String;", "unity-ads_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: Session.kt */
    public static final class Default implements Session {
        static final /* synthetic */ Default $$INSTANCE = new Default();
        private static final String id = SessionIdReader.INSTANCE.getSessionId();

        private Default() {
        }

        public String getId() {
            return id;
        }
    }
}
