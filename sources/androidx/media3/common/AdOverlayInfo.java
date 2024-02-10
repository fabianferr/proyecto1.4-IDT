package androidx.media3.common;

import android.view.View;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public final class AdOverlayInfo {
    public static final int PURPOSE_CLOSE_AD = 2;
    public static final int PURPOSE_CONTROLS = 1;
    public static final int PURPOSE_NOT_VISIBLE = 4;
    public static final int PURPOSE_OTHER = 3;
    public final int purpose;
    public final String reasonDetail;
    public final View view;

    @Documented
    @Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.LOCAL_VARIABLE, ElementType.TYPE_USE})
    @Retention(RetentionPolicy.SOURCE)
    public @interface Purpose {
    }

    public static final class Builder {
        private String detailedReason;
        private final int purpose;
        private final View view;

        public Builder(View view2, int i) {
            this.view = view2;
            this.purpose = i;
        }

        public Builder setDetailedReason(String str) {
            this.detailedReason = str;
            return this;
        }

        public AdOverlayInfo build() {
            return new AdOverlayInfo(this.view, this.purpose, this.detailedReason);
        }
    }

    @Deprecated
    public AdOverlayInfo(View view2, int i) {
        this(view2, i, (String) null);
    }

    @Deprecated
    public AdOverlayInfo(View view2, int i, String str) {
        this.view = view2;
        this.purpose = i;
        this.reasonDetail = str;
    }
}
