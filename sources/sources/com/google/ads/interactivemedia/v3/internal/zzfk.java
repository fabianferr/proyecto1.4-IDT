package com.google.ads.interactivemedia.v3.internal;

import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.AdError;
import com.google.ads.interactivemedia.v3.api.CompanionAdSlot;
import com.google.ads.interactivemedia.v3.impl.data.CompanionData;
import com.google.ads.interactivemedia.v3.impl.data.ResizeAndPositionVideoMsgData;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public interface zzfk {
    void zzb(zzfj zzfj);

    void zzd(AdError.AdErrorType adErrorType, int i, String str);

    void zze(AdError.AdErrorType adErrorType, AdError.AdErrorCode adErrorCode, String str);

    void zzh(String str);

    void zzi(ViewGroup viewGroup, CompanionData companionData, String str, CompanionAdSlot companionAdSlot, zzfm zzfm, zzha zzha);

    void zzj(ResizeAndPositionVideoMsgData resizeAndPositionVideoMsgData);

    void zzk();
}
