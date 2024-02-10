package com.google.android.gms.internal.ads;

import android.media.AudioTrack;
import android.os.SystemClock;
import androidx.media3.exoplayer.dash.DashMediaSource;
import java.lang.reflect.Method;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
final class zzoc {
    private long zzA;
    private long zzB;
    private long zzC;
    private boolean zzD;
    private long zzE;
    private long zzF;
    private final zzob zza;
    private final long[] zzb;
    private AudioTrack zzc;
    private int zzd;
    private int zze;
    private zzoa zzf;
    private int zzg;
    private boolean zzh;
    private long zzi;
    private float zzj;
    private boolean zzk;
    private long zzl;
    private long zzm;
    private Method zzn;
    private long zzo;
    private boolean zzp;
    private boolean zzq;
    private long zzr;
    private long zzs;
    private long zzt;
    private long zzu;
    private int zzv;
    private int zzw;
    private long zzx;
    private long zzy;
    private long zzz;

    public zzoc(zzob zzob) {
        this.zza = zzob;
        int i = zzen.zza;
        try {
            Class[] clsArr = null;
            this.zzn = AudioTrack.class.getMethod("getLatency", (Class[]) null);
        } catch (NoSuchMethodException unused) {
        }
        this.zzb = new long[10];
    }

    private final long zzl(long j) {
        return (j * 1000000) / ((long) this.zzg);
    }

    private final long zzm() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        if (this.zzx != -9223372036854775807L) {
            return Math.min(this.zzA, this.zzz + ((((SystemClock.elapsedRealtime() * 1000) - this.zzx) * ((long) this.zzg)) / 1000000));
        }
        int playState = audioTrack.getPlayState();
        long j = 0;
        if (playState == 1) {
            return 0;
        }
        long playbackHeadPosition = ((long) audioTrack.getPlaybackHeadPosition()) & 4294967295L;
        if (this.zzh) {
            if (playState == 2) {
                if (playbackHeadPosition == 0) {
                    this.zzu = this.zzs;
                }
                playState = 2;
            }
            playbackHeadPosition += this.zzu;
        }
        if (zzen.zza <= 29) {
            if (playbackHeadPosition != 0) {
                j = playbackHeadPosition;
            } else if (this.zzs > 0 && playState == 3) {
                if (this.zzy == -9223372036854775807L) {
                    this.zzy = SystemClock.elapsedRealtime();
                }
                return this.zzs;
            }
            this.zzy = -9223372036854775807L;
            playbackHeadPosition = j;
        }
        if (this.zzs > playbackHeadPosition) {
            this.zzt++;
        }
        this.zzs = playbackHeadPosition;
        return playbackHeadPosition + (this.zzt << 32);
    }

    private final void zzn() {
        this.zzl = 0;
        this.zzw = 0;
        this.zzv = 0;
        this.zzm = 0;
        this.zzC = 0;
        this.zzF = 0;
        this.zzk = false;
    }

    public final int zza(long j) {
        return this.zze - ((int) (j - (zzm() * ((long) this.zzd))));
    }

    public final long zzb(boolean z) {
        long j;
        Method method;
        zzoc zzoc = this;
        AudioTrack audioTrack = zzoc.zzc;
        audioTrack.getClass();
        if (audioTrack.getPlayState() == 3) {
            long zzl2 = zzoc.zzl(zzm());
            if (zzl2 != 0) {
                long nanoTime = System.nanoTime() / 1000;
                if (nanoTime - zzoc.zzm >= 30000) {
                    long[] jArr = zzoc.zzb;
                    int i = zzoc.zzv;
                    jArr[i] = zzl2 - nanoTime;
                    zzoc.zzv = (i + 1) % 10;
                    int i2 = zzoc.zzw;
                    if (i2 < 10) {
                        zzoc.zzw = i2 + 1;
                    }
                    zzoc.zzm = nanoTime;
                    zzoc.zzl = 0;
                    int i3 = 0;
                    while (true) {
                        int i4 = zzoc.zzw;
                        if (i3 >= i4) {
                            break;
                        }
                        zzoc.zzl += zzoc.zzb[i3] / ((long) i4);
                        i3++;
                    }
                }
                if (!zzoc.zzh) {
                    zzoa zzoa = zzoc.zzf;
                    zzoa.getClass();
                    if (zzoa.zzg(nanoTime)) {
                        long zzb2 = zzoa.zzb();
                        long zza2 = zzoa.zza();
                        if (Math.abs(zzb2 - nanoTime) > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                            zzop zzop = (zzop) zzoc.zza;
                            zzdw.zze("DefaultAudioSink", "Spurious audio timestamp (system clock mismatch): " + zza2 + ", " + zzb2 + ", " + nanoTime + ", " + zzl2 + ", " + zzop.zza.zzE() + ", " + zzop.zza.zzF());
                            zzoa.zzd();
                        } else {
                            zzoa zzoa2 = zzoa;
                            if (Math.abs(zzoc.zzl(zza2) - zzl2) > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                                zzop zzop2 = (zzop) zzoc.zza;
                                zzdw.zze("DefaultAudioSink", "Spurious audio timestamp (frame position mismatch): " + zza2 + ", " + zzb2 + ", " + nanoTime + ", " + zzl2 + ", " + zzop2.zza.zzE() + ", " + zzop2.zza.zzF());
                                zzoa2.zzd();
                            } else {
                                zzoa2.zzc();
                            }
                        }
                        zzoc = this;
                    }
                    if (zzoc.zzq && (method = zzoc.zzn) != null && nanoTime - zzoc.zzr >= 500000) {
                        try {
                            AudioTrack audioTrack2 = zzoc.zzc;
                            audioTrack2.getClass();
                            int i5 = zzen.zza;
                            long intValue = (((long) ((Integer) method.invoke(audioTrack2, new Object[0])).intValue()) * 1000) - zzoc.zzi;
                            zzoc.zzo = intValue;
                            long max = Math.max(intValue, 0);
                            zzoc.zzo = max;
                            if (max > DashMediaSource.MIN_LIVE_DEFAULT_START_POSITION_US) {
                                zzdw.zze("DefaultAudioSink", "Ignoring impossibly large audio latency: " + max);
                                zzoc.zzo = 0;
                            }
                        } catch (Exception unused) {
                            zzoc.zzn = null;
                        }
                        zzoc.zzr = nanoTime;
                    }
                }
            }
        }
        long nanoTime2 = System.nanoTime() / 1000;
        zzoa zzoa3 = zzoc.zzf;
        zzoa3.getClass();
        boolean zzf2 = zzoa3.zzf();
        if (zzf2) {
            j = zzoc.zzl(zzoa3.zza()) + zzen.zzs(nanoTime2 - zzoa3.zzb(), zzoc.zzj);
        } else {
            if (zzoc.zzw == 0) {
                j = zzoc.zzl(zzm());
            } else {
                j = zzoc.zzl + nanoTime2;
            }
            if (!z) {
                j = Math.max(0, j - zzoc.zzo);
            }
        }
        if (zzoc.zzD != zzf2) {
            zzoc.zzF = zzoc.zzC;
            zzoc.zzE = zzoc.zzB;
        }
        long j2 = nanoTime2 - zzoc.zzF;
        if (j2 < 1000000) {
            long j3 = (j2 * 1000) / 1000000;
            j = ((j * j3) + ((1000 - j3) * (zzoc.zzE + zzen.zzs(j2, zzoc.zzj)))) / 1000;
        }
        if (!zzoc.zzk) {
            long j4 = zzoc.zzB;
            if (j > j4) {
                zzoc.zzk = true;
                long currentTimeMillis = System.currentTimeMillis() - zzen.zzz(zzen.zzu(zzen.zzz(j - j4), zzoc.zzj));
                zzou zzou = ((zzop) zzoc.zza).zza;
                if (zzou.zzq != null) {
                    ((zzoz) zzou.zzq).zza.zzc.zzr(currentTimeMillis);
                }
            }
        }
        zzoc.zzC = nanoTime2;
        zzoc.zzB = j;
        zzoc.zzD = zzf2;
        return j;
    }

    public final void zzc(long j) {
        this.zzz = zzm();
        this.zzx = SystemClock.elapsedRealtime() * 1000;
        this.zzA = j;
    }

    public final void zzd() {
        zzn();
        this.zzc = null;
        this.zzf = null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zze(android.media.AudioTrack r3, boolean r4, int r5, int r6, int r7) {
        /*
            r2 = this;
            r2.zzc = r3
            r2.zzd = r6
            r2.zze = r7
            com.google.android.gms.internal.ads.zzoa r0 = new com.google.android.gms.internal.ads.zzoa
            r0.<init>(r3)
            r2.zzf = r0
            int r3 = r3.getSampleRate()
            r2.zzg = r3
            r3 = 0
            if (r4 == 0) goto L_0x0025
            int r4 = com.google.android.gms.internal.ads.zzen.zza
            r0 = 23
            if (r4 >= r0) goto L_0x0025
            r4 = 5
            r0 = 1
            if (r5 == r4) goto L_0x0026
            r4 = 6
            if (r5 != r4) goto L_0x0025
            r5 = 6
            goto L_0x0026
        L_0x0025:
            r0 = 0
        L_0x0026:
            r2.zzh = r0
            boolean r4 = com.google.android.gms.internal.ads.zzen.zzV(r5)
            r2.zzq = r4
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 == 0) goto L_0x003c
            int r7 = r7 / r6
            long r4 = (long) r7
            long r4 = r2.zzl(r4)
            goto L_0x003d
        L_0x003c:
            r4 = r0
        L_0x003d:
            r2.zzi = r4
            r4 = 0
            r2.zzs = r4
            r2.zzt = r4
            r2.zzu = r4
            r2.zzp = r3
            r2.zzx = r0
            r2.zzy = r0
            r2.zzr = r4
            r2.zzo = r4
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.zzj = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoc.zze(android.media.AudioTrack, boolean, int, int, int):void");
    }

    public final boolean zzg(long j) {
        if (j > zzm()) {
            return true;
        }
        if (!this.zzh) {
            return false;
        }
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        return audioTrack.getPlayState() == 2 && zzm() == 0;
    }

    public final boolean zzh() {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        return audioTrack.getPlayState() == 3;
    }

    public final boolean zzi(long j) {
        return this.zzy != -9223372036854775807L && j > 0 && SystemClock.elapsedRealtime() - this.zzy >= 200;
    }

    public final boolean zzj(long j) {
        AudioTrack audioTrack = this.zzc;
        audioTrack.getClass();
        int playState = audioTrack.getPlayState();
        if (this.zzh) {
            if (playState == 2) {
                this.zzp = false;
                return false;
            } else if (playState == 1) {
                if (zzm() == 0) {
                    return false;
                }
                playState = 1;
            }
        }
        boolean z = this.zzp;
        boolean zzg2 = zzg(j);
        this.zzp = zzg2;
        if (z && !zzg2 && playState != 1) {
            zzob zzob = this.zza;
            int i = this.zze;
            long zzz2 = zzen.zzz(this.zzi);
            zzop zzop = (zzop) zzob;
            if (zzop.zza.zzq != null) {
                long elapsedRealtime = SystemClock.elapsedRealtime();
                zzou zzou = zzop.zza;
                ((zzoz) zzou.zzq).zza.zzc.zzt(i, zzz2, elapsedRealtime - zzou.zzV);
            }
        }
        return true;
    }

    public final boolean zzk() {
        zzn();
        if (this.zzx != -9223372036854775807L) {
            return false;
        }
        zzoa zzoa = this.zzf;
        zzoa.getClass();
        zzoa.zze();
        return true;
    }

    public final void zzf() {
        zzoa zzoa = this.zzf;
        zzoa.getClass();
        zzoa.zze();
    }
}
