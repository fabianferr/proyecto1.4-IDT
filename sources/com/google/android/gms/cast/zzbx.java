package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzbx implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        long j = 0;
        String str2 = null;
        Integer num = null;
        String str3 = null;
        while (true) {
            long j2 = j;
            while (parcel.dataPosition() < validateObjectHeader) {
                int readHeader = SafeParcelReader.readHeader(parcel);
                int fieldId = SafeParcelReader.getFieldId(readHeader);
                if (fieldId == 2) {
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                } else if (fieldId == 3) {
                    j = SafeParcelReader.readLong(parcel, readHeader);
                } else if (fieldId == 4) {
                    num = SafeParcelReader.readIntegerObject(parcel, readHeader);
                } else if (fieldId == 5) {
                    str3 = SafeParcelReader.createString(parcel, readHeader);
                } else if (fieldId != 6) {
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                } else {
                    str = SafeParcelReader.createString(parcel, readHeader);
                }
            }
            SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
            return new MediaError(str2, j2, num, str3, CastUtils.jsonStringToJsonObject(str));
        }
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MediaError[i];
    }
}
