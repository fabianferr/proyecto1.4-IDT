package androidx.media3.common;

import android.os.Bundle;
import androidx.media3.common.Bundleable;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import com.ironsource.mediationsdk.logger.IronSourceError;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class DeviceInfo implements Bundleable {
    public static final Bundleable.Creator<DeviceInfo> CREATOR = new DeviceInfo$$ExternalSyntheticLambda0();
    private static final String FIELD_MAX_VOLUME = Util.intToStringMaxRadix(2);
    private static final String FIELD_MIN_VOLUME = Util.intToStringMaxRadix(1);
    private static final String FIELD_PLAYBACK_TYPE = Util.intToStringMaxRadix(0);
    private static final String FIELD_ROUTING_CONTROLLER_ID = Util.intToStringMaxRadix(3);
    public static final int PLAYBACK_TYPE_LOCAL = 0;
    public static final int PLAYBACK_TYPE_REMOTE = 1;
    public static final DeviceInfo UNKNOWN = new Builder(0).build();
    public final int maxVolume;
    public final int minVolume;
    public final int playbackType;
    public final String routingControllerId;

    @Documented
    @Target({ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface PlaybackType {
    }

    public static final class Builder {
        /* access modifiers changed from: private */
        public int maxVolume;
        /* access modifiers changed from: private */
        public int minVolume;
        /* access modifiers changed from: private */
        public final int playbackType;
        /* access modifiers changed from: private */
        public String routingControllerId;

        public Builder(int i) {
            this.playbackType = i;
        }

        public Builder setMinVolume(int i) {
            this.minVolume = i;
            return this;
        }

        public Builder setMaxVolume(int i) {
            this.maxVolume = i;
            return this;
        }

        public Builder setRoutingControllerId(String str) {
            Assertions.checkArgument(this.playbackType != 0 || str == null);
            this.routingControllerId = str;
            return this;
        }

        public DeviceInfo build() {
            Assertions.checkArgument(this.minVolume <= this.maxVolume);
            return new DeviceInfo(this);
        }
    }

    @Deprecated
    public DeviceInfo(int i, int i2, int i3) {
        this(new Builder(i).setMinVolume(i2).setMaxVolume(i3));
    }

    private DeviceInfo(Builder builder) {
        this.playbackType = builder.playbackType;
        this.minVolume = builder.minVolume;
        this.maxVolume = builder.maxVolume;
        this.routingControllerId = builder.routingControllerId;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeviceInfo)) {
            return false;
        }
        DeviceInfo deviceInfo = (DeviceInfo) obj;
        if (this.playbackType == deviceInfo.playbackType && this.minVolume == deviceInfo.minVolume && this.maxVolume == deviceInfo.maxVolume && Util.areEqual(this.routingControllerId, deviceInfo.routingControllerId)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i = (((((IronSourceError.ERROR_NON_EXISTENT_INSTANCE + this.playbackType) * 31) + this.minVolume) * 31) + this.maxVolume) * 31;
        String str = this.routingControllerId;
        return i + (str == null ? 0 : str.hashCode());
    }

    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        int i = this.playbackType;
        if (i != 0) {
            bundle.putInt(FIELD_PLAYBACK_TYPE, i);
        }
        int i2 = this.minVolume;
        if (i2 != 0) {
            bundle.putInt(FIELD_MIN_VOLUME, i2);
        }
        int i3 = this.maxVolume;
        if (i3 != 0) {
            bundle.putInt(FIELD_MAX_VOLUME, i3);
        }
        String str = this.routingControllerId;
        if (str != null) {
            bundle.putString(FIELD_ROUTING_CONTROLLER_ID, str);
        }
        return bundle;
    }

    static /* synthetic */ DeviceInfo lambda$static$0(Bundle bundle) {
        int i = bundle.getInt(FIELD_PLAYBACK_TYPE, 0);
        int i2 = bundle.getInt(FIELD_MIN_VOLUME, 0);
        int i3 = bundle.getInt(FIELD_MAX_VOLUME, 0);
        return new Builder(i).setMinVolume(i2).setMaxVolume(i3).setRoutingControllerId(bundle.getString(FIELD_ROUTING_CONTROLLER_ID)).build();
    }
}