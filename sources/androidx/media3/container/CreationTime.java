package androidx.media3.container;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.media3.common.Format;
import androidx.media3.common.MediaMetadata;
import androidx.media3.common.Metadata;
import com.google.common.primitives.Longs;

public final class CreationTime implements Metadata.Entry {
    public static final Parcelable.Creator<CreationTime> CREATOR = new Parcelable.Creator<CreationTime>() {
        public CreationTime createFromParcel(Parcel parcel) {
            return new CreationTime(parcel);
        }

        public CreationTime[] newArray(int i) {
            return new CreationTime[i];
        }
    };
    public final long timestampMs;

    public int describeContents() {
        return 0;
    }

    public /* synthetic */ byte[] getWrappedMetadataBytes() {
        return Metadata.Entry.CC.$default$getWrappedMetadataBytes(this);
    }

    public /* synthetic */ Format getWrappedMetadataFormat() {
        return Metadata.Entry.CC.$default$getWrappedMetadataFormat(this);
    }

    public /* synthetic */ void populateMediaMetadata(MediaMetadata.Builder builder) {
        Metadata.Entry.CC.$default$populateMediaMetadata(this, builder);
    }

    public CreationTime(long j) {
        this.timestampMs = j;
    }

    private CreationTime(Parcel parcel) {
        this.timestampMs = parcel.readLong();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof CreationTime) && this.timestampMs == ((CreationTime) obj).timestampMs) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Longs.hashCode(this.timestampMs);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Creation time: ");
        long j = this.timestampMs;
        sb.append(j == -2082844800000L ? "unset" : Long.valueOf(j));
        return sb.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.timestampMs);
    }
}
