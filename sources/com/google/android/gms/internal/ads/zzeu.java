package com.google.android.gms.internal.ads;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* compiled from: com.google.android.gms:play-services-ads@@21.3.0 */
public final class zzeu extends zzer {
    private final ContentResolver zza;
    private Uri zzb;
    private AssetFileDescriptor zzc;
    private FileInputStream zzd;
    private long zze;
    private boolean zzf;

    public zzeu(Context context) {
        super(false);
        this.zza = context.getContentResolver();
    }

    public final int zza(byte[] bArr, int i, int i2) throws zzet {
        if (i2 == 0) {
            return 0;
        }
        long j = this.zze;
        if (j == 0) {
            return -1;
        }
        if (j != -1) {
            try {
                i2 = (int) Math.min(j, (long) i2);
            } catch (IOException e) {
                throw new zzet(e, 2000);
            }
        }
        FileInputStream fileInputStream = this.zzd;
        int i3 = zzen.zza;
        int read = fileInputStream.read(bArr, i, i2);
        if (read == -1) {
            return -1;
        }
        long j2 = this.zze;
        if (j2 != -1) {
            this.zze = j2 - ((long) read);
        }
        zzg(read);
        return read;
    }

    public final long zzb(zzfc zzfc) throws zzet {
        AssetFileDescriptor assetFileDescriptor;
        long j;
        int i = 2000;
        try {
            Uri uri = zzfc.zza;
            this.zzb = uri;
            zzi(zzfc);
            if ("content".equals(zzfc.zza.getScheme())) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptor = this.zza.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                assetFileDescriptor = this.zza.openAssetFileDescriptor(uri, CampaignEx.JSON_KEY_AD_R);
            }
            this.zzc = assetFileDescriptor;
            if (assetFileDescriptor != null) {
                long length = assetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
                this.zzd = fileInputStream;
                if (length != -1) {
                    if (zzfc.zzf > length) {
                        throw new zzet((IOException) null, 2008);
                    }
                }
                long startOffset = assetFileDescriptor.getStartOffset();
                long skip = fileInputStream.skip(zzfc.zzf + startOffset) - startOffset;
                if (skip == zzfc.zzf) {
                    if (length == -1) {
                        FileChannel channel = fileInputStream.getChannel();
                        long size = channel.size();
                        if (size == 0) {
                            this.zze = -1;
                            j = -1;
                        } else {
                            j = size - channel.position();
                            this.zze = j;
                            if (j < 0) {
                                throw new zzet((IOException) null, 2008);
                            }
                        }
                    } else {
                        long j2 = length - skip;
                        this.zze = j2;
                        if (j2 >= 0) {
                            j = j2;
                        } else {
                            throw new zzet((IOException) null, 2008);
                        }
                    }
                    long j3 = zzfc.zzg;
                    if (j3 != -1) {
                        if (j != -1) {
                            j3 = Math.min(j, j3);
                        }
                        this.zze = j3;
                    }
                    this.zzf = true;
                    zzj(zzfc);
                    long j4 = zzfc.zzg;
                    return j4 != -1 ? j4 : this.zze;
                }
                throw new zzet((IOException) null, 2008);
            }
            throw new zzet(new IOException("Could not open file descriptor for: " + String.valueOf(uri)), 2000);
        } catch (zzet e) {
            throw e;
        } catch (IOException e2) {
            if (true == (e2 instanceof FileNotFoundException)) {
                i = 2005;
            }
            throw new zzet(e2, i);
        }
    }

    public final Uri zzc() {
        return this.zzb;
    }

    public final void zzd() throws zzet {
        this.zzb = null;
        try {
            FileInputStream fileInputStream = this.zzd;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.zzd = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.zzc;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzh();
                }
            } catch (IOException e) {
                throw new zzet(e, 2000);
            } catch (Throwable th) {
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzh();
                }
                throw th;
            }
        } catch (IOException e2) {
            throw new zzet(e2, 2000);
        } catch (Throwable th2) {
            this.zzd = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.zzc;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzh();
                }
                throw th2;
            } catch (IOException e3) {
                throw new zzet(e3, 2000);
            } catch (Throwable th3) {
                this.zzc = null;
                if (this.zzf) {
                    this.zzf = false;
                    zzh();
                }
                throw th3;
            }
        }
    }
}
