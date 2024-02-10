package com.google.android.exoplayer2;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;

public abstract class Rating implements Bundleable {
    public static final Bundleable.Creator<Rating> CREATOR = new Rating$$ExternalSyntheticLambda0();
    static final int FIELD_RATING_TYPE = 0;
    static final int RATING_TYPE_DEFAULT = -1;
    static final int RATING_TYPE_HEART = 0;
    static final int RATING_TYPE_PERCENTAGE = 1;
    static final int RATING_TYPE_STAR = 2;
    static final int RATING_TYPE_THUMB = 3;
    public static final float RATING_UNSET = -1.0f;

    public abstract boolean isRated();

    Rating() {
    }

    /* access modifiers changed from: private */
    public static Rating fromBundle(Bundle bundle) {
        int i = bundle.getInt(keyForField(0), -1);
        if (i == 0) {
            return HeartRating.CREATOR.fromBundle(bundle);
        }
        if (i == 1) {
            return PercentageRating.CREATOR.fromBundle(bundle);
        }
        if (i == 2) {
            return StarRating.CREATOR.fromBundle(bundle);
        }
        if (i == 3) {
            return ThumbRating.CREATOR.fromBundle(bundle);
        }
        StringBuilder sb = new StringBuilder(44);
        sb.append("Encountered unknown rating type: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    private static String keyForField(int i) {
        return Integer.toString(i, 36);
    }
}
