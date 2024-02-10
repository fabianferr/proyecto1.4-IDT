package androidx.mediarouter.media;

import android.os.Build;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class MediaRouterParams {
    public static final int DIALOG_TYPE_DEFAULT = 1;
    public static final int DIALOG_TYPE_DYNAMIC_GROUP = 2;
    public static final String ENABLE_GROUP_VOLUME_UX = "androidx.mediarouter.media.MediaRouterParams.ENABLE_GROUP_VOLUME_UX";
    public static final String EXTRAS_KEY_FIXED_CAST_ICON = "androidx.mediarouter.media.MediaRouterParams.FIXED_CAST_ICON";
    final int mDialogType;
    final Bundle mExtras;
    final boolean mMediaTransferReceiverEnabled;
    final boolean mOutputSwitcherEnabled;
    final boolean mTransferToLocalEnabled;

    @Retention(RetentionPolicy.SOURCE)
    public @interface DialogType {
    }

    MediaRouterParams(Builder builder) {
        this.mDialogType = builder.mDialogType;
        this.mMediaTransferReceiverEnabled = builder.mMediaTransferEnabled;
        this.mOutputSwitcherEnabled = builder.mOutputSwitcherEnabled;
        this.mTransferToLocalEnabled = builder.mTransferToLocalEnabled;
        Bundle bundle = builder.mExtras;
        this.mExtras = bundle == null ? Bundle.EMPTY : new Bundle(bundle);
    }

    public int getDialogType() {
        return this.mDialogType;
    }

    public boolean isMediaTransferReceiverEnabled() {
        return this.mMediaTransferReceiverEnabled;
    }

    public boolean isOutputSwitcherEnabled() {
        return this.mOutputSwitcherEnabled;
    }

    public boolean isTransferToLocalEnabled() {
        return this.mTransferToLocalEnabled;
    }

    public Bundle getExtras() {
        return this.mExtras;
    }

    public static final class Builder {
        int mDialogType = 1;
        Bundle mExtras;
        boolean mMediaTransferEnabled;
        boolean mOutputSwitcherEnabled;
        boolean mTransferToLocalEnabled;

        public Builder() {
            boolean z = true;
            this.mMediaTransferEnabled = Build.VERSION.SDK_INT < 30 ? false : z;
        }

        public Builder(MediaRouterParams mediaRouterParams) {
            boolean z = true;
            this.mMediaTransferEnabled = Build.VERSION.SDK_INT < 30 ? false : z;
            if (mediaRouterParams != null) {
                this.mDialogType = mediaRouterParams.mDialogType;
                this.mOutputSwitcherEnabled = mediaRouterParams.mOutputSwitcherEnabled;
                this.mTransferToLocalEnabled = mediaRouterParams.mTransferToLocalEnabled;
                this.mMediaTransferEnabled = mediaRouterParams.mMediaTransferReceiverEnabled;
                this.mExtras = mediaRouterParams.mExtras == null ? null : new Bundle(mediaRouterParams.mExtras);
                return;
            }
            throw new NullPointerException("params should not be null!");
        }

        public Builder setDialogType(int i) {
            this.mDialogType = i;
            return this;
        }

        public Builder setMediaTransferReceiverEnabled(boolean z) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.mMediaTransferEnabled = z;
            }
            return this;
        }

        public Builder setOutputSwitcherEnabled(boolean z) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.mOutputSwitcherEnabled = z;
            }
            return this;
        }

        public Builder setTransferToLocalEnabled(boolean z) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.mTransferToLocalEnabled = z;
            }
            return this;
        }

        public Builder setExtras(Bundle bundle) {
            this.mExtras = bundle == null ? null : new Bundle(bundle);
            return this;
        }

        public MediaRouterParams build() {
            return new MediaRouterParams(this);
        }
    }
}
