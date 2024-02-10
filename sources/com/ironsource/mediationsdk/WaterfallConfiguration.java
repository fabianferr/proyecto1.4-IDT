package com.ironsource.mediationsdk;

import com.ironsource.mediationsdk.logger.IronLog;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000f\u0010B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\rH\u0016R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/ironsource/mediationsdk/WaterfallConfiguration;", "", "builder", "Lcom/ironsource/mediationsdk/WaterfallConfiguration$WaterfallConfigurationBuilder;", "(Lcom/ironsource/mediationsdk/WaterfallConfiguration$WaterfallConfigurationBuilder;)V", "ceiling", "", "getCeiling", "()Ljava/lang/Double;", "Ljava/lang/Double;", "floor", "getFloor", "toJsonString", "", "toString", "Companion", "WaterfallConfigurationBuilder", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class WaterfallConfiguration {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Double a;
    private final Double b;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007J\b\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/ironsource/mediationsdk/WaterfallConfiguration$Companion;", "", "()V", "builder", "Lcom/ironsource/mediationsdk/WaterfallConfiguration$WaterfallConfigurationBuilder;", "empty", "Lcom/ironsource/mediationsdk/WaterfallConfiguration;", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final WaterfallConfigurationBuilder builder() {
            return new WaterfallConfigurationBuilder();
        }

        @JvmStatic
        public final WaterfallConfiguration empty() {
            return builder().build();
        }
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0004R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u000b\u0010\u0006\"\u0004\b\f\u0010\b¨\u0006\u0011"}, d2 = {"Lcom/ironsource/mediationsdk/WaterfallConfiguration$WaterfallConfigurationBuilder;", "", "()V", "ceiling", "", "getCeiling$mediationsdk_release", "()Ljava/lang/Double;", "setCeiling$mediationsdk_release", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "floor", "getFloor$mediationsdk_release", "setFloor$mediationsdk_release", "build", "Lcom/ironsource/mediationsdk/WaterfallConfiguration;", "setCeiling", "setFloor", "mediationsdk_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class WaterfallConfigurationBuilder {
        private Double a;
        private Double b;

        public final WaterfallConfiguration build() {
            return new WaterfallConfiguration(this, (DefaultConstructorMarker) null);
        }

        public final Double getCeiling$mediationsdk_release() {
            return this.b;
        }

        public final Double getFloor$mediationsdk_release() {
            return this.a;
        }

        public final WaterfallConfigurationBuilder setCeiling(double d) {
            this.b = Double.valueOf(d);
            return this;
        }

        public final void setCeiling$mediationsdk_release(Double d) {
            this.b = d;
        }

        public final WaterfallConfigurationBuilder setFloor(double d) {
            this.a = Double.valueOf(d);
            return this;
        }

        public final void setFloor$mediationsdk_release(Double d) {
            this.a = d;
        }
    }

    private WaterfallConfiguration(WaterfallConfigurationBuilder waterfallConfigurationBuilder) {
        this.a = waterfallConfigurationBuilder.getFloor$mediationsdk_release();
        this.b = waterfallConfigurationBuilder.getCeiling$mediationsdk_release();
    }

    public /* synthetic */ WaterfallConfiguration(WaterfallConfigurationBuilder waterfallConfigurationBuilder, DefaultConstructorMarker defaultConstructorMarker) {
        this(waterfallConfigurationBuilder);
    }

    @JvmStatic
    public static final WaterfallConfigurationBuilder builder() {
        return Companion.builder();
    }

    @JvmStatic
    public static final WaterfallConfiguration empty() {
        return Companion.empty();
    }

    public final Double getCeiling() {
        return this.b;
    }

    public final Double getFloor() {
        return this.a;
    }

    public final String toJsonString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ceiling", this.b);
            jSONObject.put("floor", this.a);
        } catch (JSONException e) {
            IronLog.INTERNAL.error(e.getMessage());
        }
        String jSONObject2 = jSONObject.toString();
        Intrinsics.checkNotNullExpressionValue(jSONObject2, "json.toString()");
        return jSONObject2;
    }

    public final String toString() {
        return "WaterfallConfiguration" + toJsonString();
    }
}
