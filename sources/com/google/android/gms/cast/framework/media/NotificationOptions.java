package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.internal.cast.zzfh;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

/* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
public class NotificationOptions extends AbstractSafeParcelable {
    public static final Parcelable.Creator<NotificationOptions> CREATOR = new zzaa();
    public static final long SKIP_STEP_TEN_SECONDS_IN_MS = 10000;
    public static final long SKIP_STEP_THIRTY_SECONDS_IN_MS = 30000;
    /* access modifiers changed from: private */
    public static final zzfh zza = zzfh.zzk(MediaIntentReceiver.ACTION_TOGGLE_PLAYBACK, MediaIntentReceiver.ACTION_STOP_CASTING);
    /* access modifiers changed from: private */
    public static final int[] zzb = {0, 1};
    private final int zzA;
    private final int zzB;
    private final int zzC;
    private final int zzD;
    private final int zzE;
    private final int zzF;
    private final int zzG;
    private final zzg zzH;
    private final boolean zzI;
    private final boolean zzJ;
    private final List zzc;
    private final int[] zzd;
    private final long zze;
    private final String zzf;
    private final int zzg;
    private final int zzh;
    private final int zzi;
    private final int zzj;
    private final int zzk;
    private final int zzl;
    private final int zzm;
    private final int zzn;
    private final int zzo;
    private final int zzp;
    private final int zzq;
    private final int zzr;
    private final int zzs;
    private final int zzt;
    private final int zzu;
    private final int zzv;
    private final int zzw;
    private final int zzx;
    private final int zzy;
    private final int zzz;

    public NotificationOptions(List list, int[] iArr, long j, String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18, int i19, int i20, int i21, int i22, int i23, int i24, int i25, int i26, int i27, IBinder iBinder, boolean z, boolean z2) {
        IBinder iBinder2 = iBinder;
        List list2 = list;
        this.zzc = new ArrayList(list);
        this.zzd = Arrays.copyOf(iArr, iArr.length);
        this.zze = j;
        this.zzf = str;
        this.zzg = i;
        this.zzh = i2;
        this.zzi = i3;
        this.zzj = i4;
        this.zzk = i5;
        this.zzl = i6;
        this.zzm = i7;
        this.zzn = i8;
        this.zzo = i9;
        this.zzp = i10;
        this.zzq = i11;
        this.zzr = i12;
        this.zzs = i13;
        this.zzt = i14;
        this.zzu = i15;
        this.zzv = i16;
        this.zzw = i17;
        this.zzx = i18;
        this.zzy = i19;
        this.zzz = i20;
        this.zzA = i21;
        this.zzB = i22;
        this.zzC = i23;
        this.zzD = i24;
        this.zzE = i25;
        this.zzF = i26;
        this.zzG = i27;
        this.zzI = z;
        this.zzJ = z2;
        if (iBinder2 == null) {
            this.zzH = null;
            return;
        }
        IInterface queryLocalInterface = iBinder2.queryLocalInterface("com.google.android.gms.cast.framework.media.INotificationActionsProvider");
        this.zzH = queryLocalInterface instanceof zzg ? (zzg) queryLocalInterface : new zze(iBinder2);
    }

    public List<String> getActions() {
        return this.zzc;
    }

    public int getCastingToDeviceStringResId() {
        return this.zzu;
    }

    public int[] getCompatActionIndices() {
        int[] iArr = this.zzd;
        return Arrays.copyOf(iArr, iArr.length);
    }

    public int getDisconnectDrawableResId() {
        return this.zzs;
    }

    public int getForward10DrawableResId() {
        return this.zzn;
    }

    public int getForward30DrawableResId() {
        return this.zzo;
    }

    public int getForwardDrawableResId() {
        return this.zzm;
    }

    public int getPauseDrawableResId() {
        return this.zzi;
    }

    public int getPlayDrawableResId() {
        return this.zzj;
    }

    public int getRewind10DrawableResId() {
        return this.zzq;
    }

    public int getRewind30DrawableResId() {
        return this.zzr;
    }

    public int getRewindDrawableResId() {
        return this.zzp;
    }

    public int getSkipNextDrawableResId() {
        return this.zzk;
    }

    public int getSkipPrevDrawableResId() {
        return this.zzl;
    }

    public long getSkipStepMs() {
        return this.zze;
    }

    public int getSmallIconDrawableResId() {
        return this.zzg;
    }

    public int getStopLiveStreamDrawableResId() {
        return this.zzh;
    }

    public int getStopLiveStreamTitleResId() {
        return this.zzv;
    }

    public String getTargetActivityClassName() {
        return this.zzf;
    }

    public void writeToParcel(Parcel parcel, int i) {
        IBinder iBinder;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringList(parcel, 2, getActions(), false);
        SafeParcelWriter.writeIntArray(parcel, 3, getCompatActionIndices(), false);
        SafeParcelWriter.writeLong(parcel, 4, getSkipStepMs());
        SafeParcelWriter.writeString(parcel, 5, getTargetActivityClassName(), false);
        SafeParcelWriter.writeInt(parcel, 6, getSmallIconDrawableResId());
        SafeParcelWriter.writeInt(parcel, 7, getStopLiveStreamDrawableResId());
        SafeParcelWriter.writeInt(parcel, 8, getPauseDrawableResId());
        SafeParcelWriter.writeInt(parcel, 9, getPlayDrawableResId());
        SafeParcelWriter.writeInt(parcel, 10, getSkipNextDrawableResId());
        SafeParcelWriter.writeInt(parcel, 11, getSkipPrevDrawableResId());
        SafeParcelWriter.writeInt(parcel, 12, getForwardDrawableResId());
        SafeParcelWriter.writeInt(parcel, 13, getForward10DrawableResId());
        SafeParcelWriter.writeInt(parcel, 14, getForward30DrawableResId());
        SafeParcelWriter.writeInt(parcel, 15, getRewindDrawableResId());
        SafeParcelWriter.writeInt(parcel, 16, getRewind10DrawableResId());
        SafeParcelWriter.writeInt(parcel, 17, getRewind30DrawableResId());
        SafeParcelWriter.writeInt(parcel, 18, getDisconnectDrawableResId());
        SafeParcelWriter.writeInt(parcel, 19, this.zzt);
        SafeParcelWriter.writeInt(parcel, 20, getCastingToDeviceStringResId());
        SafeParcelWriter.writeInt(parcel, 21, getStopLiveStreamTitleResId());
        SafeParcelWriter.writeInt(parcel, 22, this.zzw);
        SafeParcelWriter.writeInt(parcel, 23, this.zzx);
        SafeParcelWriter.writeInt(parcel, 24, this.zzy);
        SafeParcelWriter.writeInt(parcel, 25, this.zzz);
        SafeParcelWriter.writeInt(parcel, 26, this.zzA);
        SafeParcelWriter.writeInt(parcel, 27, this.zzB);
        SafeParcelWriter.writeInt(parcel, 28, this.zzC);
        SafeParcelWriter.writeInt(parcel, 29, this.zzD);
        SafeParcelWriter.writeInt(parcel, 30, this.zzE);
        SafeParcelWriter.writeInt(parcel, 31, this.zzF);
        SafeParcelWriter.writeInt(parcel, 32, this.zzG);
        zzg zzg2 = this.zzH;
        if (zzg2 == null) {
            iBinder = null;
        } else {
            iBinder = zzg2.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel, 33, iBinder, false);
        SafeParcelWriter.writeBoolean(parcel, 34, this.zzI);
        SafeParcelWriter.writeBoolean(parcel, 35, this.zzJ);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zza() {
        return this.zzG;
    }

    public final int zzb() {
        return this.zzB;
    }

    public final int zzc() {
        return this.zzC;
    }

    public final int zzd() {
        return this.zzA;
    }

    public final int zze() {
        return this.zzt;
    }

    public final int zzf() {
        return this.zzw;
    }

    public final int zzg() {
        return this.zzx;
    }

    public final int zzh() {
        return this.zzE;
    }

    public final int zzi() {
        return this.zzF;
    }

    public final int zzj() {
        return this.zzD;
    }

    public final int zzk() {
        return this.zzy;
    }

    public final int zzl() {
        return this.zzz;
    }

    public final zzg zzm() {
        return this.zzH;
    }

    public final boolean zzo() {
        return this.zzJ;
    }

    public final boolean zzp() {
        return this.zzI;
    }

    /* compiled from: com.google.android.gms:play-services-cast-framework@@21.3.0 */
    public static final class Builder {
        private String zza;
        private List zzb = NotificationOptions.zza;
        private NotificationActionsProvider zzc;
        private int[] zzd = NotificationOptions.zzb;
        private int zze = zza("smallIconDrawableResId");
        private int zzf = zza("stopLiveStreamDrawableResId");
        private int zzg = zza("pauseDrawableResId");
        private int zzh = zza("playDrawableResId");
        private int zzi = zza("skipNextDrawableResId");
        private int zzj = zza("skipPrevDrawableResId");
        private int zzk = zza("forwardDrawableResId");
        private int zzl = zza("forward10DrawableResId");
        private int zzm = zza("forward30DrawableResId");
        private int zzn = zza("rewindDrawableResId");
        private int zzo = zza("rewind10DrawableResId");
        private int zzp = zza("rewind30DrawableResId");
        private int zzq = zza("disconnectDrawableResId");
        private long zzr = 10000;
        private boolean zzs;
        private boolean zzt;

        private static int zza(String str) {
            try {
                Integer num = (Integer) Class.forName("com.google.android.gms.cast.framework.media.internal.ResourceProvider").getMethod("findResourceByName", new Class[]{String.class}).invoke((Object) null, new Object[]{str});
                if (num == null) {
                    return 0;
                }
                return num.intValue();
            } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
                return 0;
            }
        }

        /* JADX WARNING: type inference failed for: r1v24, types: [com.google.android.gms.cast.framework.media.zzg] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.google.android.gms.cast.framework.media.NotificationOptions build() {
            /*
                r39 = this;
                r0 = r39
                com.google.android.gms.cast.framework.media.NotificationActionsProvider r1 = r0.zzc
                if (r1 != 0) goto L_0x0008
                r1 = 0
                goto L_0x000c
            L_0x0008:
                com.google.android.gms.cast.framework.media.zzg r1 = r1.zza()
            L_0x000c:
                r35 = r1
                com.google.android.gms.cast.framework.media.NotificationOptions r1 = new com.google.android.gms.cast.framework.media.NotificationOptions
                r2 = r1
                java.util.List r3 = r0.zzb
                int[] r4 = r0.zzd
                long r5 = r0.zzr
                java.lang.String r7 = r0.zza
                int r8 = r0.zze
                int r9 = r0.zzf
                int r10 = r0.zzg
                int r11 = r0.zzh
                int r12 = r0.zzi
                int r13 = r0.zzj
                int r14 = r0.zzk
                int r15 = r0.zzl
                r38 = r1
                int r1 = r0.zzm
                r16 = r1
                int r1 = r0.zzn
                r17 = r1
                int r1 = r0.zzo
                r18 = r1
                int r1 = r0.zzp
                r19 = r1
                int r1 = r0.zzq
                r20 = r1
                java.lang.String r1 = "notificationImageSizeDimenResId"
                int r21 = zza(r1)
                java.lang.String r1 = "castingToDeviceStringResId"
                int r22 = zza(r1)
                java.lang.String r1 = "stopLiveStreamStringResId"
                int r23 = zza(r1)
                java.lang.String r1 = "pauseStringResId"
                int r24 = zza(r1)
                java.lang.String r1 = "playStringResId"
                int r25 = zza(r1)
                java.lang.String r1 = "skipNextStringResId"
                int r26 = zza(r1)
                java.lang.String r1 = "skipPrevStringResId"
                int r27 = zza(r1)
                java.lang.String r1 = "forwardStringResId"
                int r28 = zza(r1)
                java.lang.String r1 = "forward10StringResId"
                int r29 = zza(r1)
                java.lang.String r1 = "forward30StringResId"
                int r30 = zza(r1)
                java.lang.String r1 = "rewindStringResId"
                int r31 = zza(r1)
                java.lang.String r1 = "rewind10StringResId"
                int r32 = zza(r1)
                java.lang.String r1 = "rewind30StringResId"
                int r33 = zza(r1)
                java.lang.String r1 = "disconnectStringResId"
                int r34 = zza(r1)
                boolean r1 = r0.zzs
                r36 = r1
                boolean r1 = r0.zzt
                r37 = r1
                r2.<init>(r3, r4, r5, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
                return r38
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.framework.media.NotificationOptions.Builder.build():com.google.android.gms.cast.framework.media.NotificationOptions");
        }

        public Builder setDisconnectDrawableResId(int i) {
            this.zzq = i;
            return this;
        }

        public Builder setForward10DrawableResId(int i) {
            this.zzl = i;
            return this;
        }

        public Builder setForward30DrawableResId(int i) {
            this.zzm = i;
            return this;
        }

        public Builder setForwardDrawableResId(int i) {
            this.zzk = i;
            return this;
        }

        public Builder setNotificationActionsProvider(NotificationActionsProvider notificationActionsProvider) {
            if (notificationActionsProvider != null) {
                this.zzc = notificationActionsProvider;
                return this;
            }
            throw new IllegalArgumentException("notificationActionsProvider cannot be null.");
        }

        public Builder setPauseDrawableResId(int i) {
            this.zzg = i;
            return this;
        }

        public Builder setPlayDrawableResId(int i) {
            this.zzh = i;
            return this;
        }

        public Builder setRewind10DrawableResId(int i) {
            this.zzo = i;
            return this;
        }

        public Builder setRewind30DrawableResId(int i) {
            this.zzp = i;
            return this;
        }

        public Builder setRewindDrawableResId(int i) {
            this.zzn = i;
            return this;
        }

        public Builder setSkipNextDrawableResId(int i) {
            this.zzi = i;
            return this;
        }

        public Builder setSkipPrevDrawableResId(int i) {
            this.zzj = i;
            return this;
        }

        public Builder setSkipStepMs(long j) {
            Preconditions.checkArgument(j > 0, "skipStepMs must be positive.");
            this.zzr = j;
            return this;
        }

        public Builder setSkipToNextSlotReserved(boolean z) {
            this.zzt = z;
            return this;
        }

        public Builder setSkipToPrevSlotReserved(boolean z) {
            this.zzs = z;
            return this;
        }

        public Builder setSmallIconDrawableResId(int i) {
            this.zze = i;
            return this;
        }

        public Builder setStopLiveStreamDrawableResId(int i) {
            this.zzf = i;
            return this;
        }

        public Builder setTargetActivityClassName(String str) {
            this.zza = str;
            return this;
        }

        public Builder setActions(List<String> list, int[] iArr) {
            if (list == null && iArr != null) {
                throw new IllegalArgumentException("When setting actions to null, you must also set compatActionIndices to null.");
            } else if (list == null || iArr != null) {
                if (list == null || iArr == null) {
                    this.zzb = NotificationOptions.zza;
                    this.zzd = NotificationOptions.zzb;
                } else {
                    int size = list.size();
                    if (r0 <= size) {
                        for (int i : iArr) {
                            if (i < 0 || i >= size) {
                                throw new IllegalArgumentException(String.format(Locale.ROOT, "Index %d in compatActionIndices out of range: [0, %d]", new Object[]{Integer.valueOf(i), Integer.valueOf(size - 1)}));
                            }
                        }
                        this.zzb = new ArrayList(list);
                        this.zzd = Arrays.copyOf(iArr, iArr.length);
                    } else {
                        throw new IllegalArgumentException(String.format(Locale.ROOT, "Invalid number of compat actions: %d > %d.", new Object[]{Integer.valueOf(r0), Integer.valueOf(size)}));
                    }
                }
                return this;
            } else {
                throw new IllegalArgumentException("When setting compatActionIndices to null, you must also set actions to null.");
            }
        }
    }
}
