package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.metrics.LogSessionId;
import android.media.metrics.MediaMetricsManager;
import android.media.metrics.PlaybackMetrics;
import android.media.metrics.PlaybackSession;
import android.media.metrics.TrackChangeEvent;
import android.os.SystemClock;
import android.util.Pair;
import androidx.media3.common.MediaLibraryInfo;
import java.io.IOException;
import java.util.HashMap;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzmx implements zzkr, zzmy {
    private final Context zza;
    private final zzmz zzb;
    private final PlaybackSession zzc;
    private final long zzd = SystemClock.elapsedRealtime();
    private final zzcm zze = new zzcm();
    private final zzck zzf = new zzck();
    private final HashMap zzg = new HashMap();
    private final HashMap zzh = new HashMap();
    private String zzi;
    private PlaybackMetrics.Builder zzj;
    private int zzk;
    private int zzl = 0;
    private int zzm = 0;
    private zzbw zzn;
    private zzmw zzo;
    private zzmw zzp;
    private zzmw zzq;
    private zzaf zzr;
    private zzaf zzs;
    private zzaf zzt;
    private boolean zzu;
    private boolean zzv;
    private int zzw;
    private int zzx;
    private int zzy;
    private boolean zzz;

    private zzmx(Context context, PlaybackSession playbackSession) {
        this.zza = context.getApplicationContext();
        this.zzc = playbackSession;
        zzmv zzmv = new zzmv(zzmv.zza);
        this.zzb = zzmv;
        zzmv.zzg(this);
    }

    public static zzmx zzb(Context context) {
        MediaMetricsManager mediaMetricsManager = (MediaMetricsManager) context.getSystemService("media_metrics");
        if (mediaMetricsManager == null) {
            return null;
        }
        return new zzmx(context, mediaMetricsManager.createPlaybackSession());
    }

    private static int zzr(int i) {
        switch (zzen.zzl(i)) {
            case 6002:
                return 24;
            case 6003:
                return 28;
            case 6004:
                return 25;
            case 6005:
                return 26;
            default:
                return 27;
        }
    }

    private final void zzs() {
        long j;
        long j2;
        PlaybackMetrics.Builder builder = this.zzj;
        if (builder != null && this.zzz) {
            builder.setAudioUnderrunCount(this.zzy);
            this.zzj.setVideoFramesDropped(this.zzw);
            this.zzj.setVideoFramesPlayed(this.zzx);
            Long l = (Long) this.zzg.get(this.zzi);
            PlaybackMetrics.Builder builder2 = this.zzj;
            if (l == null) {
                j = 0;
            } else {
                j = l.longValue();
            }
            builder2.setNetworkTransferDurationMillis(j);
            Long l2 = (Long) this.zzh.get(this.zzi);
            PlaybackMetrics.Builder builder3 = this.zzj;
            if (l2 == null) {
                j2 = 0;
            } else {
                j2 = l2.longValue();
            }
            builder3.setNetworkBytesRead(j2);
            this.zzj.setStreamSource((l2 == null || l2.longValue() <= 0) ? 0 : 1);
            this.zzc.reportPlaybackMetrics(this.zzj.build());
        }
        this.zzj = null;
        this.zzi = null;
        this.zzy = 0;
        this.zzw = 0;
        this.zzx = 0;
        this.zzr = null;
        this.zzs = null;
        this.zzt = null;
        this.zzz = false;
    }

    private final void zzt(long j, zzaf zzaf, int i) {
        if (!zzen.zzT(this.zzs, zzaf)) {
            int i2 = this.zzs == null ? 1 : 0;
            this.zzs = zzaf;
            zzx(0, j, zzaf, i2);
        }
    }

    private final void zzu(long j, zzaf zzaf, int i) {
        if (!zzen.zzT(this.zzt, zzaf)) {
            int i2 = this.zzt == null ? 1 : 0;
            this.zzt = zzaf;
            zzx(2, j, zzaf, i2);
        }
    }

    @RequiresNonNull({"metricsBuilder"})
    private final void zzv(zzcn zzcn, zzsi zzsi) {
        int zza2;
        PlaybackMetrics.Builder builder = this.zzj;
        if (zzsi != null && (zza2 = zzcn.zza(zzsi.zza)) != -1) {
            int i = 0;
            zzcn.zzd(zza2, this.zzf, false);
            zzcn.zze(this.zzf.zzd, this.zze, 0);
            zzay zzay = this.zze.zzd.zzd;
            int i2 = 2;
            if (zzay != null) {
                int zzp2 = zzen.zzp(zzay.zza);
                i = zzp2 != 0 ? zzp2 != 1 ? zzp2 != 2 ? 1 : 4 : 5 : 3;
            }
            builder.setStreamType(i);
            zzcm zzcm = this.zze;
            if (zzcm.zzn != -9223372036854775807L && !zzcm.zzl && !zzcm.zzi && !zzcm.zzb()) {
                builder.setMediaDurationMillis(zzen.zzz(this.zze.zzn));
            }
            if (true != this.zze.zzb()) {
                i2 = 1;
            }
            builder.setPlaybackType(i2);
            this.zzz = true;
        }
    }

    private final void zzw(long j, zzaf zzaf, int i) {
        if (!zzen.zzT(this.zzr, zzaf)) {
            int i2 = this.zzr == null ? 1 : 0;
            this.zzr = zzaf;
            zzx(1, j, zzaf, i2);
        }
    }

    private final void zzx(int i, long j, zzaf zzaf, int i2) {
        TrackChangeEvent.Builder timeSinceCreatedMillis = new TrackChangeEvent.Builder(i).setTimeSinceCreatedMillis(j - this.zzd);
        if (zzaf != null) {
            timeSinceCreatedMillis.setTrackState(1);
            timeSinceCreatedMillis.setTrackChangeReason(i2 != 1 ? 1 : 2);
            String str = zzaf.zzl;
            if (str != null) {
                timeSinceCreatedMillis.setContainerMimeType(str);
            }
            String str2 = zzaf.zzm;
            if (str2 != null) {
                timeSinceCreatedMillis.setSampleMimeType(str2);
            }
            String str3 = zzaf.zzj;
            if (str3 != null) {
                timeSinceCreatedMillis.setCodecName(str3);
            }
            int i3 = zzaf.zzi;
            if (i3 != -1) {
                timeSinceCreatedMillis.setBitrate(i3);
            }
            int i4 = zzaf.zzr;
            if (i4 != -1) {
                timeSinceCreatedMillis.setWidth(i4);
            }
            int i5 = zzaf.zzs;
            if (i5 != -1) {
                timeSinceCreatedMillis.setHeight(i5);
            }
            int i6 = zzaf.zzz;
            if (i6 != -1) {
                timeSinceCreatedMillis.setChannelCount(i6);
            }
            int i7 = zzaf.zzA;
            if (i7 != -1) {
                timeSinceCreatedMillis.setAudioSampleRate(i7);
            }
            String str4 = zzaf.zzd;
            if (str4 != null) {
                String[] zzag = zzen.zzag(str4, "-");
                Pair create = Pair.create(zzag[0], zzag.length >= 2 ? zzag[1] : null);
                timeSinceCreatedMillis.setLanguage((String) create.first);
                if (create.second != null) {
                    timeSinceCreatedMillis.setLanguageRegion((String) create.second);
                }
            }
            float f = zzaf.zzt;
            if (f != -1.0f) {
                timeSinceCreatedMillis.setVideoFrameRate(f);
            }
        } else {
            timeSinceCreatedMillis.setTrackState(0);
        }
        this.zzz = true;
        this.zzc.reportTrackChangeEvent(timeSinceCreatedMillis.build());
    }

    @EnsuresNonNullIf(expression = {"#1"}, result = true)
    private final boolean zzy(zzmw zzmw) {
        return zzmw != null && zzmw.zzc.equals(this.zzb.zzd());
    }

    public final LogSessionId zza() {
        return this.zzc.getSessionId();
    }

    public final void zzc(zzkp zzkp, String str) {
        zzsi zzsi = zzkp.zzd;
        if (zzsi == null || !zzsi.zzb()) {
            zzs();
            this.zzi = str;
            this.zzj = new PlaybackMetrics.Builder().setPlayerName(MediaLibraryInfo.TAG).setPlayerVersion("1.0.0-beta02");
            zzv(zzkp.zzb, zzkp.zzd);
        }
    }

    public final void zzd(zzkp zzkp, String str, boolean z) {
        zzsi zzsi = zzkp.zzd;
        if ((zzsi == null || !zzsi.zzb()) && str.equals(this.zzi)) {
            zzs();
        }
        this.zzg.remove(str);
        this.zzh.remove(str);
    }

    public final /* synthetic */ void zze(zzkp zzkp, zzaf zzaf, zzgt zzgt) {
    }

    public final void zzf(zzkp zzkp, int i, long j, long j2) {
        long j3;
        zzsi zzsi = zzkp.zzd;
        if (zzsi != null) {
            String zze2 = this.zzb.zze(zzkp.zzb, zzsi);
            Long l = (Long) this.zzh.get(zze2);
            Long l2 = (Long) this.zzg.get(zze2);
            HashMap hashMap = this.zzh;
            long j4 = 0;
            if (l == null) {
                j3 = 0;
            } else {
                j3 = l.longValue();
            }
            hashMap.put(zze2, Long.valueOf(j3 + j));
            HashMap hashMap2 = this.zzg;
            if (l2 != null) {
                j4 = l2.longValue();
            }
            hashMap2.put(zze2, Long.valueOf(j4 + ((long) i)));
        }
    }

    public final void zzg(zzkp zzkp, zzse zzse) {
        zzsi zzsi = zzkp.zzd;
        if (zzsi != null) {
            zzaf zzaf = zzse.zzb;
            zzaf.getClass();
            zzmw zzmw = new zzmw(zzaf, 0, this.zzb.zze(zzkp.zzb, zzsi));
            int i = zzse.zza;
            if (i != 0) {
                if (i == 1) {
                    this.zzp = zzmw;
                    return;
                } else if (i != 2) {
                    if (i == 3) {
                        this.zzq = zzmw;
                        return;
                    }
                    return;
                }
            }
            this.zzo = zzmw;
        }
    }

    public final /* synthetic */ void zzh(zzkp zzkp, int i, long j) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:129:0x01e2, code lost:
        if (r8 != 1) goto L_0x01e6;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(com.google.android.gms.internal.ads.zzcg r19, com.google.android.gms.internal.ads.zzkq r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r20
            int r2 = r20.zzb()
            if (r2 == 0) goto L_0x03cf
            r2 = 0
            r3 = 0
        L_0x000c:
            int r4 = r20.zzb()
            r5 = 11
            if (r3 >= r4) goto L_0x0036
            int r4 = r1.zza(r3)
            com.google.android.gms.internal.ads.zzkp r6 = r1.zzc(r4)
            if (r4 != 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzmz r4 = r0.zzb
            r4.zzj(r6)
            goto L_0x0033
        L_0x0024:
            if (r4 != r5) goto L_0x002e
            com.google.android.gms.internal.ads.zzmz r4 = r0.zzb
            int r5 = r0.zzk
            r4.zzi(r6, r5)
            goto L_0x0033
        L_0x002e:
            com.google.android.gms.internal.ads.zzmz r4 = r0.zzb
            r4.zzh(r6)
        L_0x0033:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x0036:
            long r3 = android.os.SystemClock.elapsedRealtime()
            boolean r6 = r1.zzd(r2)
            if (r6 == 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzkp r6 = r1.zzc(r2)
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x004f
            com.google.android.gms.internal.ads.zzcn r7 = r6.zzb
            com.google.android.gms.internal.ads.zzsi r6 = r6.zzd
            r0.zzv(r7, r6)
        L_0x004f:
            r6 = 2
            boolean r7 = r1.zzd(r6)
            r9 = 3
            r10 = 0
            r11 = 1
            if (r7 == 0) goto L_0x00c6
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            if (r7 == 0) goto L_0x00c6
            com.google.android.gms.internal.ads.zzcy r7 = r19.zzo()
            com.google.android.gms.internal.ads.zzfvn r7 = r7.zza()
            int r12 = r7.size()
            r13 = 0
        L_0x006a:
            if (r13 >= r12) goto L_0x008f
            java.lang.Object r14 = r7.get(r13)
            com.google.android.gms.internal.ads.zzcx r14 = (com.google.android.gms.internal.ads.zzcx) r14
            r15 = 0
        L_0x0073:
            int r5 = r14.zzb
            int r5 = r13 + 1
            if (r15 > 0) goto L_0x008b
            boolean r5 = r14.zzd(r15)
            if (r5 == 0) goto L_0x0088
            com.google.android.gms.internal.ads.zzaf r5 = r14.zzb(r15)
            com.google.android.gms.internal.ads.zzx r5 = r5.zzp
            if (r5 == 0) goto L_0x0088
            goto L_0x0090
        L_0x0088:
            int r15 = r15 + 1
            goto L_0x0073
        L_0x008b:
            r13 = r5
            r5 = 11
            goto L_0x006a
        L_0x008f:
            r5 = r10
        L_0x0090:
            if (r5 == 0) goto L_0x00c6
            android.media.metrics.PlaybackMetrics$Builder r7 = r0.zzj
            int r12 = com.google.android.gms.internal.ads.zzen.zza
            r12 = 0
        L_0x0097:
            int r13 = r5.zzb
            if (r12 >= r13) goto L_0x00c2
            com.google.android.gms.internal.ads.zzw r13 = r5.zza(r12)
            java.util.UUID r13 = r13.zza
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zzd
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00ab
            r5 = 3
            goto L_0x00c3
        L_0x00ab:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zze
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x00b5
            r5 = 2
            goto L_0x00c3
        L_0x00b5:
            java.util.UUID r14 = com.google.android.gms.internal.ads.zzo.zzc
            boolean r13 = r13.equals(r14)
            if (r13 == 0) goto L_0x00bf
            r5 = 6
            goto L_0x00c3
        L_0x00bf:
            int r12 = r12 + 1
            goto L_0x0097
        L_0x00c2:
            r5 = 1
        L_0x00c3:
            r7.setDrmType(r5)
        L_0x00c6:
            r5 = 1011(0x3f3, float:1.417E-42)
            boolean r5 = r1.zzd(r5)
            if (r5 == 0) goto L_0x00d3
            int r5 = r0.zzy
            int r5 = r5 + r11
            r0.zzy = r5
        L_0x00d3:
            com.google.android.gms.internal.ads.zzbw r5 = r0.zzn
            r16 = 9
            if (r5 != 0) goto L_0x00db
            goto L_0x027c
        L_0x00db:
            android.content.Context r7 = r0.zza
            int r8 = r5.zzb
            r12 = 1001(0x3e9, float:1.403E-42)
            if (r8 != r12) goto L_0x00e8
            r7 = 20
        L_0x00e5:
            r8 = 0
            goto L_0x0256
        L_0x00e8:
            r8 = r5
            com.google.android.gms.internal.ads.zzha r8 = (com.google.android.gms.internal.ads.zzha) r8
            int r12 = r8.zze
            int r8 = r8.zzi
            java.lang.Throwable r13 = r5.getCause()
            r13.getClass()
            boolean r14 = r13 instanceof java.io.IOException
            r15 = 23
            if (r14 == 0) goto L_0x01dc
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzfs
            if (r8 == 0) goto L_0x0108
            com.google.android.gms.internal.ads.zzfs r13 = (com.google.android.gms.internal.ads.zzfs) r13
            int r7 = r13.zzd
            r8 = r7
            r7 = 5
            goto L_0x0256
        L_0x0108:
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzfr
            if (r8 != 0) goto L_0x01d8
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzbu
            if (r8 == 0) goto L_0x0112
            goto L_0x01d8
        L_0x0112:
            boolean r8 = r13 instanceof com.google.android.gms.internal.ads.zzfq
            if (r8 != 0) goto L_0x01aa
            boolean r12 = r13 instanceof com.google.android.gms.internal.ads.zzga
            if (r12 == 0) goto L_0x011c
            goto L_0x01aa
        L_0x011c:
            int r7 = r5.zzb
            r8 = 1002(0x3ea, float:1.404E-42)
            r12 = 21
            if (r7 != r8) goto L_0x0127
            r7 = 21
            goto L_0x00e5
        L_0x0127:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzpi
            if (r7 == 0) goto L_0x0175
            java.lang.Throwable r7 = r13.getCause()
            r7.getClass()
            int r8 = com.google.android.gms.internal.ads.zzen.zza
            if (r8 < r12) goto L_0x014a
            boolean r8 = r7 instanceof android.media.MediaDrm.MediaDrmStateException
            if (r8 == 0) goto L_0x014a
            android.media.MediaDrm$MediaDrmStateException r7 = (android.media.MediaDrm.MediaDrmStateException) r7
            java.lang.String r7 = r7.getDiagnosticInfo()
            int r7 = com.google.android.gms.internal.ads.zzen.zzm(r7)
            int r8 = zzr(r7)
            goto L_0x024c
        L_0x014a:
            int r8 = com.google.android.gms.internal.ads.zzen.zza
            if (r8 < r15) goto L_0x0155
            boolean r8 = r7 instanceof android.media.MediaDrmResetException
            if (r8 == 0) goto L_0x0155
            r7 = 27
            goto L_0x00e5
        L_0x0155:
            boolean r8 = r7 instanceof android.media.NotProvisionedException
            if (r8 == 0) goto L_0x015c
            r7 = 24
            goto L_0x00e5
        L_0x015c:
            boolean r8 = r7 instanceof android.media.DeniedByServerException
            if (r8 == 0) goto L_0x0163
            r7 = 29
            goto L_0x00e5
        L_0x0163:
            boolean r8 = r7 instanceof com.google.android.gms.internal.ads.zzpt
            if (r8 == 0) goto L_0x0169
            goto L_0x01f2
        L_0x0169:
            boolean r7 = r7 instanceof com.google.android.gms.internal.ads.zzpg
            if (r7 == 0) goto L_0x0171
            r7 = 28
            goto L_0x00e5
        L_0x0171:
            r7 = 30
            goto L_0x00e5
        L_0x0175:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzfm
            if (r7 == 0) goto L_0x01a6
            java.lang.Throwable r7 = r13.getCause()
            boolean r7 = r7 instanceof java.io.FileNotFoundException
            if (r7 == 0) goto L_0x01a6
            java.lang.Throwable r7 = r13.getCause()
            r7.getClass()
            java.lang.Throwable r7 = r7.getCause()
            int r8 = com.google.android.gms.internal.ads.zzen.zza
            r13 = 31
            if (r8 < r12) goto L_0x01a2
            boolean r8 = r7 instanceof android.system.ErrnoException
            if (r8 == 0) goto L_0x01a2
            android.system.ErrnoException r7 = (android.system.ErrnoException) r7
            int r7 = r7.errno
            int r8 = android.system.OsConstants.EACCES
            if (r7 != r8) goto L_0x01a2
            r7 = 32
            goto L_0x00e5
        L_0x01a2:
            r7 = 31
            goto L_0x00e5
        L_0x01a6:
            r7 = 9
            goto L_0x00e5
        L_0x01aa:
            com.google.android.gms.internal.ads.zzed r7 = com.google.android.gms.internal.ads.zzed.zzb(r7)
            int r7 = r7.zza()
            if (r7 != r11) goto L_0x01b7
            r7 = 3
            goto L_0x00e5
        L_0x01b7:
            java.lang.Throwable r7 = r13.getCause()
            boolean r12 = r7 instanceof java.net.UnknownHostException
            if (r12 == 0) goto L_0x01c2
            r7 = 6
            goto L_0x00e5
        L_0x01c2:
            boolean r7 = r7 instanceof java.net.SocketTimeoutException
            if (r7 == 0) goto L_0x01c9
            r7 = 7
            goto L_0x00e5
        L_0x01c9:
            if (r8 == 0) goto L_0x01d4
            com.google.android.gms.internal.ads.zzfq r13 = (com.google.android.gms.internal.ads.zzfq) r13
            int r7 = r13.zzc
            if (r7 != r11) goto L_0x01d4
            r7 = 4
            goto L_0x00e5
        L_0x01d4:
            r7 = 8
            goto L_0x00e5
        L_0x01d8:
            r7 = 11
            goto L_0x00e5
        L_0x01dc:
            if (r12 != r11) goto L_0x01e6
            r7 = 35
            if (r8 == 0) goto L_0x00e5
            if (r8 != r11) goto L_0x01e6
            goto L_0x00e5
        L_0x01e6:
            if (r12 != r11) goto L_0x01ee
            if (r8 != r9) goto L_0x01ee
            r7 = 15
            goto L_0x00e5
        L_0x01ee:
            if (r12 != r11) goto L_0x01f6
            if (r8 != r6) goto L_0x01f6
        L_0x01f2:
            r7 = 23
            goto L_0x00e5
        L_0x01f6:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzqp
            if (r7 == 0) goto L_0x0206
            com.google.android.gms.internal.ads.zzqp r13 = (com.google.android.gms.internal.ads.zzqp) r13
            java.lang.String r7 = r13.zzd
            int r7 = com.google.android.gms.internal.ads.zzen.zzm(r7)
            r8 = r7
            r7 = 13
            goto L_0x0256
        L_0x0206:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zzqm
            r8 = 14
            if (r7 == 0) goto L_0x0218
            com.google.android.gms.internal.ads.zzqm r13 = (com.google.android.gms.internal.ads.zzqm) r13
            java.lang.String r7 = r13.zzb
            int r7 = com.google.android.gms.internal.ads.zzen.zzm(r7)
            r8 = r7
            r7 = 14
            goto L_0x0256
        L_0x0218:
            boolean r7 = r13 instanceof java.lang.OutOfMemoryError
            if (r7 == 0) goto L_0x0220
            r7 = 14
            goto L_0x00e5
        L_0x0220:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zznu
            if (r7 == 0) goto L_0x022e
            com.google.android.gms.internal.ads.zznu r13 = (com.google.android.gms.internal.ads.zznu) r13
            int r7 = r13.zza
            r8 = 17
            r8 = r7
            r7 = 17
            goto L_0x0256
        L_0x022e:
            boolean r7 = r13 instanceof com.google.android.gms.internal.ads.zznx
            if (r7 == 0) goto L_0x023c
            com.google.android.gms.internal.ads.zznx r13 = (com.google.android.gms.internal.ads.zznx) r13
            int r7 = r13.zza
            r8 = 18
            r8 = r7
            r7 = 18
            goto L_0x0256
        L_0x023c:
            int r7 = com.google.android.gms.internal.ads.zzen.zza
            boolean r7 = r13 instanceof android.media.MediaCodec.CryptoException
            if (r7 == 0) goto L_0x0252
            android.media.MediaCodec$CryptoException r13 = (android.media.MediaCodec.CryptoException) r13
            int r7 = r13.getErrorCode()
            int r8 = zzr(r7)
        L_0x024c:
            r17 = r8
            r8 = r7
            r7 = r17
            goto L_0x0256
        L_0x0252:
            r7 = 22
            goto L_0x00e5
        L_0x0256:
            android.media.metrics.PlaybackSession r12 = r0.zzc
            android.media.metrics.PlaybackErrorEvent$Builder r13 = new android.media.metrics.PlaybackErrorEvent$Builder
            r13.<init>()
            long r14 = r0.zzd
            long r14 = r3 - r14
            android.media.metrics.PlaybackErrorEvent$Builder r13 = r13.setTimeSinceCreatedMillis(r14)
            android.media.metrics.PlaybackErrorEvent$Builder r7 = r13.setErrorCode(r7)
            android.media.metrics.PlaybackErrorEvent$Builder r7 = r7.setSubErrorCode(r8)
            android.media.metrics.PlaybackErrorEvent$Builder r5 = r7.setException(r5)
            android.media.metrics.PlaybackErrorEvent r5 = r5.build()
            r12.reportPlaybackErrorEvent(r5)
            r0.zzz = r11
            r0.zzn = r10
        L_0x027c:
            boolean r5 = r1.zzd(r6)
            if (r5 == 0) goto L_0x02a8
            com.google.android.gms.internal.ads.zzcy r5 = r19.zzo()
            boolean r7 = r5.zzb(r6)
            boolean r8 = r5.zzb(r11)
            boolean r5 = r5.zzb(r9)
            if (r7 != 0) goto L_0x0299
            if (r8 != 0) goto L_0x0299
            if (r5 == 0) goto L_0x02a8
            r5 = 1
        L_0x0299:
            if (r7 != 0) goto L_0x029e
            r0.zzw(r3, r10, r2)
        L_0x029e:
            if (r8 != 0) goto L_0x02a3
            r0.zzt(r3, r10, r2)
        L_0x02a3:
            if (r5 != 0) goto L_0x02a8
            r0.zzu(r3, r10, r2)
        L_0x02a8:
            com.google.android.gms.internal.ads.zzmw r5 = r0.zzo
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02c0
            com.google.android.gms.internal.ads.zzmw r5 = r0.zzo
            com.google.android.gms.internal.ads.zzaf r7 = r5.zza
            int r8 = r7.zzs
            r12 = -1
            if (r8 == r12) goto L_0x02c0
            int r5 = r5.zzb
            r0.zzw(r3, r7, r2)
            r0.zzo = r10
        L_0x02c0:
            com.google.android.gms.internal.ads.zzmw r5 = r0.zzp
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02d3
            com.google.android.gms.internal.ads.zzmw r5 = r0.zzp
            com.google.android.gms.internal.ads.zzaf r7 = r5.zza
            int r5 = r5.zzb
            r0.zzt(r3, r7, r2)
            r0.zzp = r10
        L_0x02d3:
            com.google.android.gms.internal.ads.zzmw r5 = r0.zzq
            boolean r5 = r0.zzy(r5)
            if (r5 == 0) goto L_0x02e6
            com.google.android.gms.internal.ads.zzmw r5 = r0.zzq
            com.google.android.gms.internal.ads.zzaf r7 = r5.zza
            int r5 = r5.zzb
            r0.zzu(r3, r7, r2)
            r0.zzq = r10
        L_0x02e6:
            android.content.Context r5 = r0.zza
            com.google.android.gms.internal.ads.zzed r5 = com.google.android.gms.internal.ads.zzed.zzb(r5)
            int r5 = r5.zza()
            switch(r5) {
                case 0: goto L_0x0307;
                case 1: goto L_0x0304;
                case 2: goto L_0x0302;
                case 3: goto L_0x0300;
                case 4: goto L_0x02fe;
                case 5: goto L_0x02fc;
                case 6: goto L_0x02f3;
                case 7: goto L_0x02fa;
                case 8: goto L_0x02f3;
                case 9: goto L_0x02f7;
                case 10: goto L_0x02f5;
                default: goto L_0x02f3;
            }
        L_0x02f3:
            r13 = 1
            goto L_0x0308
        L_0x02f5:
            r13 = 7
            goto L_0x0308
        L_0x02f7:
            r13 = 8
            goto L_0x0308
        L_0x02fa:
            r13 = 3
            goto L_0x0308
        L_0x02fc:
            r13 = 6
            goto L_0x0308
        L_0x02fe:
            r13 = 5
            goto L_0x0308
        L_0x0300:
            r13 = 4
            goto L_0x0308
        L_0x0302:
            r13 = 2
            goto L_0x0308
        L_0x0304:
            r13 = 9
            goto L_0x0308
        L_0x0307:
            r13 = 0
        L_0x0308:
            int r5 = r0.zzm
            if (r13 == r5) goto L_0x0328
            r0.zzm = r13
            android.media.metrics.PlaybackSession r5 = r0.zzc
            android.media.metrics.NetworkEvent$Builder r7 = new android.media.metrics.NetworkEvent$Builder
            r7.<init>()
            android.media.metrics.NetworkEvent$Builder r7 = r7.setNetworkType(r13)
            long r12 = r0.zzd
            long r12 = r3 - r12
            android.media.metrics.NetworkEvent$Builder r7 = r7.setTimeSinceCreatedMillis(r12)
            android.media.metrics.NetworkEvent r7 = r7.build()
            r5.reportNetworkEvent(r7)
        L_0x0328:
            int r5 = r19.zzh()
            if (r5 == r6) goto L_0x0330
            r0.zzu = r2
        L_0x0330:
            r5 = r19
            com.google.android.gms.internal.ads.zzkf r5 = (com.google.android.gms.internal.ads.zzkf) r5
            com.google.android.gms.internal.ads.zzha r5 = r5.zzw()
            r7 = 10
            if (r5 != 0) goto L_0x033f
            r0.zzv = r2
            goto L_0x0347
        L_0x033f:
            boolean r2 = r1.zzd(r7)
            if (r2 == 0) goto L_0x0347
            r0.zzv = r11
        L_0x0347:
            int r2 = r19.zzh()
            boolean r5 = r0.zzu
            if (r5 == 0) goto L_0x0351
            r5 = 5
            goto L_0x039b
        L_0x0351:
            boolean r5 = r0.zzv
            if (r5 == 0) goto L_0x0358
            r5 = 13
            goto L_0x039b
        L_0x0358:
            r5 = 4
            if (r2 != r5) goto L_0x035e
            r5 = 11
            goto L_0x039b
        L_0x035e:
            if (r2 != r6) goto L_0x037c
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x037a
            if (r2 != r6) goto L_0x0367
            goto L_0x037a
        L_0x0367:
            boolean r2 = r19.zzq()
            if (r2 != 0) goto L_0x036f
            r5 = 7
            goto L_0x039b
        L_0x036f:
            int r2 = r19.zzi()
            if (r2 == 0) goto L_0x0378
            r5 = 10
            goto L_0x039b
        L_0x0378:
            r5 = 6
            goto L_0x039b
        L_0x037a:
            r5 = 2
            goto L_0x039b
        L_0x037c:
            if (r2 != r9) goto L_0x0390
            boolean r2 = r19.zzq()
            if (r2 != 0) goto L_0x0385
            goto L_0x039b
        L_0x0385:
            int r2 = r19.zzi()
            if (r2 == 0) goto L_0x038e
            r5 = 9
            goto L_0x039b
        L_0x038e:
            r5 = 3
            goto L_0x039b
        L_0x0390:
            if (r2 != r11) goto L_0x0399
            int r2 = r0.zzl
            if (r2 == 0) goto L_0x0399
            r5 = 12
            goto L_0x039b
        L_0x0399:
            int r5 = r0.zzl
        L_0x039b:
            int r2 = r0.zzl
            if (r2 == r5) goto L_0x03be
            r0.zzl = r5
            r0.zzz = r11
            android.media.metrics.PlaybackSession r2 = r0.zzc
            android.media.metrics.PlaybackStateEvent$Builder r5 = new android.media.metrics.PlaybackStateEvent$Builder
            r5.<init>()
            int r6 = r0.zzl
            android.media.metrics.PlaybackStateEvent$Builder r5 = r5.setState(r6)
            long r6 = r0.zzd
            long r3 = r3 - r6
            android.media.metrics.PlaybackStateEvent$Builder r3 = r5.setTimeSinceCreatedMillis(r3)
            android.media.metrics.PlaybackStateEvent r3 = r3.build()
            r2.reportPlaybackStateEvent(r3)
        L_0x03be:
            r2 = 1028(0x404, float:1.44E-42)
            boolean r3 = r1.zzd(r2)
            if (r3 == 0) goto L_0x03cf
            com.google.android.gms.internal.ads.zzmz r3 = r0.zzb
            com.google.android.gms.internal.ads.zzkp r1 = r1.zzc(r2)
            r3.zzf(r1)
        L_0x03cf:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmx.zzi(com.google.android.gms.internal.ads.zzcg, com.google.android.gms.internal.ads.zzkq):void");
    }

    public final void zzj(zzkp zzkp, zzrz zzrz, zzse zzse, IOException iOException, boolean z) {
    }

    public final /* synthetic */ void zzk(zzkp zzkp, int i) {
    }

    public final void zzl(zzkp zzkp, zzbw zzbw) {
        this.zzn = zzbw;
    }

    public final void zzm(zzkp zzkp, zzcf zzcf, zzcf zzcf2, int i) {
        if (i == 1) {
            this.zzu = true;
            i = 1;
        }
        this.zzk = i;
    }

    public final /* synthetic */ void zzn(zzkp zzkp, Object obj, long j) {
    }

    public final void zzo(zzkp zzkp, zzgs zzgs) {
        this.zzw += zzgs.zzg;
        this.zzx += zzgs.zze;
    }

    public final /* synthetic */ void zzp(zzkp zzkp, zzaf zzaf, zzgt zzgt) {
    }

    public final void zzq(zzkp zzkp, zzda zzda) {
        zzmw zzmw = this.zzo;
        if (zzmw != null) {
            zzaf zzaf = zzmw.zza;
            if (zzaf.zzs == -1) {
                zzad zzb2 = zzaf.zzb();
                zzb2.zzX(zzda.zzc);
                zzb2.zzF(zzda.zzd);
                this.zzo = new zzmw(zzb2.zzY(), 0, zzmw.zzc);
            }
        }
    }
}
