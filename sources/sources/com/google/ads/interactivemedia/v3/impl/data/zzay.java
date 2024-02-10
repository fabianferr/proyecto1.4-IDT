package com.google.ads.interactivemedia.v3.impl.data;

import android.view.View;
import com.google.ads.interactivemedia.v3.api.FriendlyObstruction;
import com.google.ads.interactivemedia.v3.api.FriendlyObstructionPurpose;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzay implements FriendlyObstruction {
    public static zzax builder() {
        return new zzr();
    }

    public abstract String detailedReason();

    public String getDetailedReason() {
        return detailedReason();
    }

    public FriendlyObstructionPurpose getPurpose() {
        return purpose();
    }

    public View getView() {
        return view();
    }

    public abstract FriendlyObstructionPurpose purpose();

    public abstract View view();
}
