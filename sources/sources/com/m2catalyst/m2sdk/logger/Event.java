package com.m2catalyst.m2sdk.logger;

import com.facebook.internal.NativeProtocol;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\rB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000e"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/Event;", "", "builder", "Lcom/m2catalyst/m2sdk/logger/Event$Builder;", "(Lcom/m2catalyst/m2sdk/logger/Event$Builder;)V", "eventName", "", "getEventName", "()Ljava/lang/String;", "params", "", "getParams", "()Ljava/util/Map;", "Builder", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Event.kt */
public final class Event {
    private final String eventName;
    private final Map<String, Object> params;

    private Event(Builder builder) {
        this.eventName = builder.getEventName();
        this.params = builder.getParams();
    }

    public /* synthetic */ Event(Builder builder, DefaultConstructorMarker defaultConstructorMarker) {
        this(builder);
    }

    public final String getEventName() {
        return this.eventName;
    }

    public final Map<String, Object> getParams() {
        return this.params;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B%\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\r\u001a\u00020\u000eJ\u0006\u0010\u000f\u001a\u00020\u0000J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0002\u001a\u00020\u0003J\u0016\u0010\u0011\u001a\u00020\u00002\u0006\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0014"}, d2 = {"Lcom/m2catalyst/m2sdk/logger/Event$Builder;", "", "eventName", "", "params", "", "(Ljava/lang/String;Ljava/util/Map;)V", "getEventName", "()Ljava/lang/String;", "setEventName", "(Ljava/lang/String;)V", "getParams", "()Ljava/util/Map;", "build", "Lcom/m2catalyst/m2sdk/logger/Event;", "clearParams", "withName", "withParam", "key", "value", "m2sdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Event.kt */
    public static final class Builder {
        private String eventName;
        private final Map<String, Object> params;

        public Builder() {
            this((String) null, (Map) null, 3, (DefaultConstructorMarker) null);
        }

        public Builder(String str, Map<String, Object> map) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
            this.eventName = str;
            this.params = map;
        }

        public final Event build() {
            return new Event(this, (DefaultConstructorMarker) null);
        }

        public final Builder clearParams() {
            this.params.clear();
            return this;
        }

        public final String getEventName() {
            return this.eventName;
        }

        public final Map<String, Object> getParams() {
            return this.params;
        }

        public final void setEventName(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.eventName = str;
        }

        public final Builder withName(String str) {
            Intrinsics.checkNotNullParameter(str, "eventName");
            this.eventName = str;
            return this;
        }

        public final Builder withParam(String str, Object obj) {
            Intrinsics.checkNotNullParameter(str, "key");
            Intrinsics.checkNotNullParameter(obj, "value");
            this.params.put(str, obj);
            return this;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(String str, Map map, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? new LinkedHashMap() : map);
        }
    }
}
