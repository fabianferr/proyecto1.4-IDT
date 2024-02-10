package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.UiElement;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public abstract class zzc {
    public abstract zzd build();

    /* access modifiers changed from: package-private */
    public abstract zzc setDisableUi(boolean z);

    /* access modifiers changed from: package-private */
    public abstract zzc setEnableFocusSkipButton(boolean z);

    /* access modifiers changed from: package-private */
    public abstract zzc setEnablePreloading(boolean z);

    /* access modifiers changed from: package-private */
    public abstract zzc setLoadVideoTimeout(int i);

    /* access modifiers changed from: package-private */
    public abstract zzc setMimeTypes(@Nullable List<String> list);

    /* access modifiers changed from: package-private */
    public abstract zzc setPlayAdsAfterTime(double d);

    /* access modifiers changed from: package-private */
    public abstract zzc setUiElements(@Nullable Set<UiElement> set);
}
