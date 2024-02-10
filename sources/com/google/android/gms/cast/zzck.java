package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzck implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        Parcel parcel2 = parcel;
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        MediaInfo mediaInfo = null;
        long[] jArr = null;
        String str = null;
        double d = 0.0d;
        double d2 = 0.0d;
        double d3 = 0.0d;
        int i = 0;
        boolean z = false;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 2:
                    mediaInfo = (MediaInfo) SafeParcelReader.createParcelable(parcel2, readHeader, MediaInfo.CREATOR);
                    break;
                case 3:
                    i = SafeParcelReader.readInt(parcel2, readHeader);
                    break;
                case 4:
                    z = SafeParcelReader.readBoolean(parcel2, readHeader);
                    break;
                case 5:
                    d = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 6:
                    d2 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 7:
                    d3 = SafeParcelReader.readDouble(parcel2, readHeader);
                    break;
                case 8:
                    jArr = SafeParcelReader.createLongArray(parcel2, readHeader);
                    break;
                case 9:
                    str = SafeParcelReader.createString(parcel2, readHeader);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel2, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel2, validateObjectHeader);
        return new MediaQueueItem(mediaInfo, i, z, d, d2, d3, jArr, str);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MediaQueueItem[i];
    }
}
