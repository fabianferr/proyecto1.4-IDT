package com.google.ads.interactivemedia.v3.api;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import com.google.ads.interactivemedia.v3.api.player.VideoAdPlayer;
import com.google.ads.interactivemedia.v3.api.player.VideoStreamPlayer;
import com.google.ads.interactivemedia.v3.impl.data.zzax;
import com.google.ads.interactivemedia.v3.impl.data.zzay;
import com.google.ads.interactivemedia.v3.impl.data.zze;
import com.google.ads.interactivemedia.v3.internal.zzdk;
import com.google.ads.interactivemedia.v3.internal.zzec;
import com.google.ads.interactivemedia.v3.internal.zzei;
import com.google.ads.interactivemedia.v3.internal.zzek;
import com.google.ads.interactivemedia.v3.internal.zzeq;
import com.google.ads.interactivemedia.v3.internal.zzey;
import com.google.ads.interactivemedia.v3.internal.zzez;
import com.google.ads.interactivemedia.v3.internal.zzgi;
import com.google.ads.interactivemedia.v3.internal.zzgk;
import java.util.concurrent.Executors;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public class ImaSdkFactory {
    private static ImaSdkFactory zza;

    private ImaSdkFactory() {
    }

    private AdsLoader createAdsLoader(Context context, Uri uri, BaseDisplayContainer baseDisplayContainer, ImaSdkSettings imaSdkSettings) {
        if (uri == null) {
            uri = zza(imaSdkSettings);
        }
        zzec zzec = new zzec(context, uri, imaSdkSettings, baseDisplayContainer, Executors.newCachedThreadPool());
        zzec.zzq();
        return zzec;
    }

    public static ImaSdkFactory getInstance() {
        if (zza == null) {
            zza = new ImaSdkFactory();
        }
        return zza;
    }

    private static final Uri zza(ImaSdkSettings imaSdkSettings) {
        if (imaSdkSettings == null || !imaSdkSettings.isDebugMode()) {
            return zzey.zza;
        }
        return zzey.zzb;
    }

    @Deprecated
    public AdDisplayContainer createAdDisplayContainer() {
        return new zzdk((ViewGroup) null, (VideoAdPlayer) null);
    }

    public AdsRenderingSettings createAdsRenderingSettings() {
        return new zze();
    }

    public AdsRequest createAdsRequest() {
        return new zzei();
    }

    public CompanionAdSlot createCompanionAdSlot() {
        return new zzeq();
    }

    public FriendlyObstruction createFriendlyObstruction(View view, FriendlyObstructionPurpose friendlyObstructionPurpose, String str) {
        zzax builder = zzay.builder();
        builder.view(view);
        builder.purpose(friendlyObstructionPurpose);
        builder.detailedReason(str);
        return builder.build();
    }

    public ImaSdkSettings createImaSdkSettings() {
        return new zzez();
    }

    public StreamRequest createLiveStreamRequest(String str, String str2) {
        zzgk zzgk = new zzgk();
        zzgk.zzd(str);
        zzgk.zzc(str2);
        return zzgk;
    }

    public StreamRequest createPodStreamRequest(String str, String str2, String str3) {
        zzgk zzgk = new zzgk();
        zzgk.zzi(str);
        zzgk.zzg(str2);
        zzgk.zzc(str3);
        return zzgk;
    }

    @Deprecated
    public StreamDisplayContainer createStreamDisplayContainer() {
        return new zzgi((ViewGroup) null, (VideoStreamPlayer) null);
    }

    public StreamRequest createVideoStitcherLiveStreamRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        zzgk zzgk = new zzgk();
        zzgk.zzi(str);
        zzgk.zzg(str2);
        zzgk.zzh(str3);
        zzgk.zzl(str4);
        zzgk.zzk(str5);
        zzgk.zzj(str6);
        return zzgk;
    }

    public StreamRequest createVideoStitcherVodStreamRequest(String str, String str2, String str3, String str4, String str5, String str6) {
        zzgk zzgk = new zzgk();
        zzgk.zzf(str);
        zzgk.zzi(str2);
        zzgk.zzl(str3);
        zzgk.zzk(str4);
        zzgk.zzj(str5);
        zzgk.zzb(str6);
        return zzgk;
    }

    public StreamRequest createVodStreamRequest(String str, String str2, String str3) {
        zzgk zzgk = new zzgk();
        zzgk.zze(str);
        zzgk.zzm(str2);
        zzgk.zzc(str3);
        return zzgk;
    }

    @Deprecated
    public AdDisplayContainer createAudioAdDisplayContainer(Context context) {
        context.getClass();
        return new zzek(context, (VideoAdPlayer) null);
    }

    public static AdDisplayContainer createAdDisplayContainer(ViewGroup viewGroup, VideoAdPlayer videoAdPlayer) {
        viewGroup.getClass();
        videoAdPlayer.getClass();
        return new zzdk(viewGroup, videoAdPlayer);
    }

    public static StreamDisplayContainer createStreamDisplayContainer(ViewGroup viewGroup, VideoStreamPlayer videoStreamPlayer) {
        viewGroup.getClass();
        videoStreamPlayer.getClass();
        return new zzgi(viewGroup, videoStreamPlayer);
    }

    public AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, AdDisplayContainer adDisplayContainer) {
        Context context2 = context;
        zzec zzec = new zzec(context2, zza(imaSdkSettings), imaSdkSettings, adDisplayContainer, Executors.newCachedThreadPool());
        zzec.zzq();
        return zzec;
    }

    public static AdDisplayContainer createAudioAdDisplayContainer(Context context, VideoAdPlayer videoAdPlayer) {
        context.getClass();
        videoAdPlayer.getClass();
        return new zzek(context, videoAdPlayer);
    }

    public AdsLoader createAdsLoader(Context context, ImaSdkSettings imaSdkSettings, StreamDisplayContainer streamDisplayContainer) {
        Context context2 = context;
        zzec zzec = new zzec(context2, zza(imaSdkSettings), imaSdkSettings, streamDisplayContainer, Executors.newCachedThreadPool());
        zzec.zzq();
        return zzec;
    }
}
