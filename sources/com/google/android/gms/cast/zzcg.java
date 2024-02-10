package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.util.ArrayList;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public final class zzcg implements Parcelable.Creator {
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        double d = 0.0d;
        String str = null;
        ArrayList<MediaMetadata> arrayList = null;
        ArrayList<WebImage> arrayList2 = null;
        int i = 0;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            int fieldId = SafeParcelReader.getFieldId(readHeader);
            if (fieldId == 2) {
                i = SafeParcelReader.readInt(parcel, readHeader);
            } else if (fieldId == 3) {
                str = SafeParcelReader.createString(parcel, readHeader);
            } else if (fieldId == 4) {
                arrayList = SafeParcelReader.createTypedList(parcel, readHeader, MediaMetadata.CREATOR);
            } else if (fieldId == 5) {
                arrayList2 = SafeParcelReader.createTypedList(parcel, readHeader, WebImage.CREATOR);
            } else if (fieldId != 6) {
                SafeParcelReader.skipUnknownField(parcel, readHeader);
            } else {
                d = SafeParcelReader.readDouble(parcel, readHeader);
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new MediaQueueContainerMetadata(i, str, arrayList, arrayList2, d);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new MediaQueueContainerMetadata[i];
    }
}
