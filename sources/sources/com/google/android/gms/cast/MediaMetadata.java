package com.google.android.gms.cast;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.cast.internal.media.zza;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
public class MediaMetadata extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MediaMetadata> CREATOR = new zzce();
    public static final String KEY_ALBUM_ARTIST = "com.google.android.gms.cast.metadata.ALBUM_ARTIST";
    public static final String KEY_ALBUM_TITLE = "com.google.android.gms.cast.metadata.ALBUM_TITLE";
    public static final String KEY_ARTIST = "com.google.android.gms.cast.metadata.ARTIST";
    public static final String KEY_BOOK_TITLE = "com.google.android.gms.cast.metadata.BOOK_TITLE";
    public static final String KEY_BROADCAST_DATE = "com.google.android.gms.cast.metadata.BROADCAST_DATE";
    public static final String KEY_CHAPTER_NUMBER = "com.google.android.gms.cast.metadata.CHAPTER_NUMBER";
    public static final String KEY_CHAPTER_TITLE = "com.google.android.gms.cast.metadata.CHAPTER_TITLE";
    public static final String KEY_COMPOSER = "com.google.android.gms.cast.metadata.COMPOSER";
    public static final String KEY_CREATION_DATE = "com.google.android.gms.cast.metadata.CREATION_DATE";
    public static final String KEY_DISC_NUMBER = "com.google.android.gms.cast.metadata.DISC_NUMBER";
    public static final String KEY_EPISODE_NUMBER = "com.google.android.gms.cast.metadata.EPISODE_NUMBER";
    public static final String KEY_HEIGHT = "com.google.android.gms.cast.metadata.HEIGHT";
    public static final String KEY_LOCATION_LATITUDE = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE";
    public static final String KEY_LOCATION_LONGITUDE = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE";
    public static final String KEY_LOCATION_NAME = "com.google.android.gms.cast.metadata.LOCATION_NAME";
    public static final String KEY_QUEUE_ITEM_ID = "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID";
    public static final String KEY_RELEASE_DATE = "com.google.android.gms.cast.metadata.RELEASE_DATE";
    public static final String KEY_SEASON_NUMBER = "com.google.android.gms.cast.metadata.SEASON_NUMBER";
    public static final String KEY_SECTION_DURATION = "com.google.android.gms.cast.metadata.SECTION_DURATION";
    public static final String KEY_SECTION_START_ABSOLUTE_TIME = "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME";
    public static final String KEY_SECTION_START_TIME_IN_CONTAINER = "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER";
    public static final String KEY_SECTION_START_TIME_IN_MEDIA = "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA";
    public static final String KEY_SERIES_TITLE = "com.google.android.gms.cast.metadata.SERIES_TITLE";
    public static final String KEY_STUDIO = "com.google.android.gms.cast.metadata.STUDIO";
    public static final String KEY_SUBTITLE = "com.google.android.gms.cast.metadata.SUBTITLE";
    public static final String KEY_TITLE = "com.google.android.gms.cast.metadata.TITLE";
    public static final String KEY_TRACK_NUMBER = "com.google.android.gms.cast.metadata.TRACK_NUMBER";
    public static final String KEY_WIDTH = "com.google.android.gms.cast.metadata.WIDTH";
    public static final int MEDIA_TYPE_AUDIOBOOK_CHAPTER = 5;
    public static final int MEDIA_TYPE_GENERIC = 0;
    public static final int MEDIA_TYPE_MOVIE = 1;
    public static final int MEDIA_TYPE_MUSIC_TRACK = 3;
    public static final int MEDIA_TYPE_PHOTO = 4;
    public static final int MEDIA_TYPE_TV_SHOW = 2;
    public static final int MEDIA_TYPE_USER = 100;
    private static final String[] zzb = {"none", "String", "int", "double", "ISO-8601 date String", "Time in milliseconds as long"};
    private static final zzcd zzc;
    final Bundle zza;
    private final List zzd;
    /* access modifiers changed from: private */
    public int zze;
    private final Writer zzf;

    /* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
    public class Writer {
        public Writer() {
        }

        public Object getRawValue(String str) {
            return MediaMetadata.this.zza.get(str);
        }

        public void remove(String str) {
            MediaMetadata.this.zza.remove(str);
        }

        public void setMediaType(int i) {
            MediaMetadata.this.zze = i;
        }
    }

    static {
        zzcd zzcd = new zzcd();
        zzcd.zzb(KEY_CREATION_DATE, "creationDateTime", 4);
        zzcd.zzb(KEY_RELEASE_DATE, "releaseDate", 4);
        zzcd.zzb(KEY_BROADCAST_DATE, "originalAirdate", 4);
        zzcd.zzb(KEY_TITLE, "title", 1);
        zzcd.zzb(KEY_SUBTITLE, MediaTrack.ROLE_SUBTITLE, 1);
        zzcd.zzb(KEY_ARTIST, "artist", 1);
        zzcd.zzb(KEY_ALBUM_ARTIST, "albumArtist", 1);
        zzcd.zzb(KEY_ALBUM_TITLE, "albumName", 1);
        zzcd.zzb(KEY_COMPOSER, "composer", 1);
        zzcd.zzb(KEY_DISC_NUMBER, "discNumber", 2);
        zzcd.zzb(KEY_TRACK_NUMBER, "trackNumber", 2);
        zzcd.zzb(KEY_SEASON_NUMBER, "season", 2);
        zzcd.zzb(KEY_EPISODE_NUMBER, "episode", 2);
        zzcd.zzb(KEY_SERIES_TITLE, "seriesTitle", 1);
        zzcd.zzb(KEY_STUDIO, "studio", 1);
        zzcd.zzb(KEY_WIDTH, ViewHierarchyConstants.DIMENSION_WIDTH_KEY, 2);
        zzcd.zzb(KEY_HEIGHT, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY, 2);
        zzcd.zzb(KEY_LOCATION_NAME, FirebaseAnalytics.Param.LOCATION, 1);
        zzcd.zzb(KEY_LOCATION_LATITUDE, "latitude", 3);
        zzcd.zzb(KEY_LOCATION_LONGITUDE, "longitude", 3);
        zzcd.zzb(KEY_SECTION_DURATION, "sectionDuration", 5);
        zzcd.zzb(KEY_SECTION_START_TIME_IN_MEDIA, "sectionStartTimeInMedia", 5);
        zzcd.zzb(KEY_SECTION_START_ABSOLUTE_TIME, "sectionStartAbsoluteTime", 5);
        zzcd.zzb(KEY_SECTION_START_TIME_IN_CONTAINER, "sectionStartTimeInContainer", 5);
        zzcd.zzb(KEY_QUEUE_ITEM_ID, "queueItemId", 2);
        zzcd.zzb(KEY_BOOK_TITLE, "bookTitle", 1);
        zzcd.zzb(KEY_CHAPTER_NUMBER, "chapterNumber", 2);
        zzcd.zzb(KEY_CHAPTER_TITLE, "chapterTitle", 1);
        zzc = zzcd;
    }

    public MediaMetadata() {
        this(0);
    }

    public static int getTypeForKey(String str) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(str)) {
            return zzc.zza(str);
        }
        throw new IllegalArgumentException("null and empty keys are not allowed");
    }

    public static void throwIfWrongType(String str, int i) throws IllegalArgumentException {
        if (!TextUtils.isEmpty(str)) {
            int zza2 = zzc.zza(str);
            if (zza2 != i && zza2 != 0) {
                String str2 = zzb[i];
                throw new IllegalArgumentException("Value for " + str + " must be a " + str2);
            }
            return;
        }
        throw new IllegalArgumentException("null and empty keys are not allowed");
    }

    private final boolean zzd(Bundle bundle, Bundle bundle2) {
        if (bundle.size() != bundle2.size()) {
            return false;
        }
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            Object obj2 = bundle2.get(str);
            if ((obj instanceof Bundle) && (obj2 instanceof Bundle) && !zzd((Bundle) obj, (Bundle) obj2)) {
                return false;
            }
            if (obj == null) {
                if (obj2 != null || !bundle2.containsKey(str)) {
                    return false;
                }
            } else if (!obj.equals(obj2)) {
                return false;
            }
        }
        return true;
    }

    public void addImage(WebImage webImage) {
        this.zzd.add(webImage);
    }

    public void clear() {
        this.zza.clear();
        this.zzd.clear();
    }

    public void clearImages() {
        this.zzd.clear();
    }

    public boolean containsKey(String str) {
        return this.zza.containsKey(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MediaMetadata)) {
            return false;
        }
        MediaMetadata mediaMetadata = (MediaMetadata) obj;
        return zzd(this.zza, mediaMetadata.zza) && this.zzd.equals(mediaMetadata.zzd);
    }

    public Calendar getDate(String str) {
        throwIfWrongType(str, 4);
        String string = this.zza.getString(str);
        if (string != null) {
            return zza.zzb(string);
        }
        return null;
    }

    public String getDateAsString(String str) {
        throwIfWrongType(str, 4);
        return this.zza.getString(str);
    }

    public double getDouble(String str) {
        throwIfWrongType(str, 3);
        return this.zza.getDouble(str);
    }

    public List<WebImage> getImages() {
        return this.zzd;
    }

    public int getInt(String str) {
        throwIfWrongType(str, 2);
        return this.zza.getInt(str);
    }

    public int getMediaType() {
        return this.zze;
    }

    public String getString(String str) {
        throwIfWrongType(str, 1);
        return this.zza.getString(str);
    }

    public long getTimeMillis(String str) {
        throwIfWrongType(str, 5);
        return this.zza.getLong(str);
    }

    public Writer getWriter() {
        return this.zzf;
    }

    public boolean hasImages() {
        List list = this.zzd;
        return list != null && !list.isEmpty();
    }

    public int hashCode() {
        Bundle bundle = this.zza;
        int i = 17;
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object obj = this.zza.get(str);
                i = (i * 31) + (obj != null ? obj.hashCode() : 0);
            }
        }
        return (i * 31) + this.zzd.hashCode();
    }

    public Set<String> keySet() {
        return this.zza.keySet();
    }

    public void putDate(String str, Calendar calendar) {
        throwIfWrongType(str, 4);
        this.zza.putString(str, zza.zza(calendar));
    }

    public void putDouble(String str, double d) {
        throwIfWrongType(str, 3);
        this.zza.putDouble(str, d);
    }

    public void putInt(String str, int i) {
        throwIfWrongType(str, 2);
        this.zza.putInt(str, i);
    }

    public void putString(String str, String str2) {
        throwIfWrongType(str, 1);
        this.zza.putString(str, str2);
    }

    public void putTimeMillis(String str, long j) {
        throwIfWrongType(str, 5);
        this.zza.putLong(str, j);
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, getImages(), false);
        SafeParcelWriter.writeBundle(parcel, 3, this.zza, false);
        SafeParcelWriter.writeInt(parcel, 4, getMediaType());
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00cc, code lost:
        r4 = zzc;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final org.json.JSONObject zza() {
        /*
            r18 = this;
            r0 = r18
            org.json.JSONObject r1 = new org.json.JSONObject
            r1.<init>()
            java.lang.String r2 = "metadataType"
            int r3 = r0.zze     // Catch:{ JSONException -> 0x000f }
            r1.put(r2, r3)     // Catch:{ JSONException -> 0x000f }
            goto L_0x0010
        L_0x000f:
        L_0x0010:
            java.util.List r2 = r0.zzd
            org.json.JSONArray r2 = com.google.android.gms.cast.internal.media.zza.zzc(r2)
            int r3 = r2.length()
            if (r3 == 0) goto L_0x0021
            java.lang.String r3 = "images"
            r1.put(r3, r2)     // Catch:{ JSONException -> 0x0021 }
        L_0x0021:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            int r3 = r0.zze
            java.lang.String r4 = "com.google.android.gms.cast.metadata.RELEASE_DATE"
            r5 = 5
            r6 = 4
            r7 = 3
            r8 = 2
            r9 = 1
            java.lang.String r10 = "com.google.android.gms.cast.metadata.SUBTITLE"
            java.lang.String r11 = "com.google.android.gms.cast.metadata.TITLE"
            if (r3 == 0) goto L_0x0098
            if (r3 == r9) goto L_0x008e
            if (r3 == r8) goto L_0x007e
            if (r3 == r7) goto L_0x0066
            if (r3 == r6) goto L_0x004e
            if (r3 == r5) goto L_0x0040
            goto L_0x00a1
        L_0x0040:
            java.lang.String r3 = "com.google.android.gms.cast.metadata.CHAPTER_NUMBER"
            java.lang.String r4 = "com.google.android.gms.cast.metadata.BOOK_TITLE"
            java.lang.String r12 = "com.google.android.gms.cast.metadata.CHAPTER_TITLE"
            java.lang.String[] r3 = new java.lang.String[]{r12, r3, r11, r4, r10}
            java.util.Collections.addAll(r2, r3)
            goto L_0x00a1
        L_0x004e:
            java.lang.String r10 = "com.google.android.gms.cast.metadata.TITLE"
            java.lang.String r11 = "com.google.android.gms.cast.metadata.ARTIST"
            java.lang.String r12 = "com.google.android.gms.cast.metadata.LOCATION_NAME"
            java.lang.String r13 = "com.google.android.gms.cast.metadata.LOCATION_LATITUDE"
            java.lang.String r14 = "com.google.android.gms.cast.metadata.LOCATION_LONGITUDE"
            java.lang.String r15 = "com.google.android.gms.cast.metadata.WIDTH"
            java.lang.String r16 = "com.google.android.gms.cast.metadata.HEIGHT"
            java.lang.String r17 = "com.google.android.gms.cast.metadata.CREATION_DATE"
            java.lang.String[] r3 = new java.lang.String[]{r10, r11, r12, r13, r14, r15, r16, r17}
            java.util.Collections.addAll(r2, r3)
            goto L_0x00a1
        L_0x0066:
            java.lang.String r10 = "com.google.android.gms.cast.metadata.TITLE"
            java.lang.String r11 = "com.google.android.gms.cast.metadata.ARTIST"
            java.lang.String r12 = "com.google.android.gms.cast.metadata.ALBUM_TITLE"
            java.lang.String r13 = "com.google.android.gms.cast.metadata.ALBUM_ARTIST"
            java.lang.String r14 = "com.google.android.gms.cast.metadata.COMPOSER"
            java.lang.String r15 = "com.google.android.gms.cast.metadata.TRACK_NUMBER"
            java.lang.String r16 = "com.google.android.gms.cast.metadata.DISC_NUMBER"
            java.lang.String r17 = "com.google.android.gms.cast.metadata.RELEASE_DATE"
            java.lang.String[] r3 = new java.lang.String[]{r10, r11, r12, r13, r14, r15, r16, r17}
            java.util.Collections.addAll(r2, r3)
            goto L_0x00a1
        L_0x007e:
            java.lang.String r3 = "com.google.android.gms.cast.metadata.EPISODE_NUMBER"
            java.lang.String r4 = "com.google.android.gms.cast.metadata.BROADCAST_DATE"
            java.lang.String r10 = "com.google.android.gms.cast.metadata.SERIES_TITLE"
            java.lang.String r12 = "com.google.android.gms.cast.metadata.SEASON_NUMBER"
            java.lang.String[] r3 = new java.lang.String[]{r11, r10, r12, r3, r4}
            java.util.Collections.addAll(r2, r3)
            goto L_0x00a1
        L_0x008e:
            java.lang.String r3 = "com.google.android.gms.cast.metadata.STUDIO"
            java.lang.String[] r3 = new java.lang.String[]{r11, r3, r10, r4}
            java.util.Collections.addAll(r2, r3)
            goto L_0x00a1
        L_0x0098:
            java.lang.String r3 = "com.google.android.gms.cast.metadata.ARTIST"
            java.lang.String[] r3 = new java.lang.String[]{r11, r3, r10, r4}
            java.util.Collections.addAll(r2, r3)
        L_0x00a1:
            java.lang.String r3 = "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_CONTAINER"
            java.lang.String r4 = "com.google.android.gms.cast.metadata.QUEUE_ITEM_ID"
            java.lang.String r10 = "com.google.android.gms.cast.metadata.SECTION_DURATION"
            java.lang.String r11 = "com.google.android.gms.cast.metadata.SECTION_START_TIME_IN_MEDIA"
            java.lang.String r12 = "com.google.android.gms.cast.metadata.SECTION_START_ABSOLUTE_TIME"
            java.lang.String[] r3 = new java.lang.String[]{r10, r11, r12, r3, r4}
            java.util.Collections.addAll(r2, r3)
            java.util.Iterator r2 = r2.iterator()     // Catch:{ JSONException -> 0x014b }
        L_0x00b6:
            boolean r3 = r2.hasNext()     // Catch:{ JSONException -> 0x014b }
            if (r3 == 0) goto L_0x010f
            java.lang.Object r3 = r2.next()     // Catch:{ JSONException -> 0x014b }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x014b }
            if (r3 == 0) goto L_0x00b6
            android.os.Bundle r4 = r0.zza     // Catch:{ JSONException -> 0x014b }
            boolean r4 = r4.containsKey(r3)     // Catch:{ JSONException -> 0x014b }
            if (r4 == 0) goto L_0x00b6
            com.google.android.gms.cast.zzcd r4 = zzc     // Catch:{ JSONException -> 0x014b }
            java.lang.String r10 = r4.zzc(r3)     // Catch:{ JSONException -> 0x014b }
            if (r10 == 0) goto L_0x00b6
            int r4 = r4.zza(r3)     // Catch:{ JSONException -> 0x014b }
            if (r4 == r9) goto L_0x0105
            if (r4 == r8) goto L_0x00fb
            if (r4 == r7) goto L_0x00f1
            if (r4 == r6) goto L_0x0105
            if (r4 == r5) goto L_0x00e3
            goto L_0x00b6
        L_0x00e3:
            android.os.Bundle r4 = r0.zza     // Catch:{ JSONException -> 0x014b }
            long r3 = r4.getLong(r3)     // Catch:{ JSONException -> 0x014b }
            double r3 = com.google.android.gms.cast.internal.CastUtils.millisecToSec(r3)     // Catch:{ JSONException -> 0x014b }
            r1.put(r10, r3)     // Catch:{ JSONException -> 0x014b }
            goto L_0x00b6
        L_0x00f1:
            android.os.Bundle r4 = r0.zza     // Catch:{ JSONException -> 0x014b }
            double r3 = r4.getDouble(r3)     // Catch:{ JSONException -> 0x014b }
            r1.put(r10, r3)     // Catch:{ JSONException -> 0x014b }
            goto L_0x00b6
        L_0x00fb:
            android.os.Bundle r4 = r0.zza     // Catch:{ JSONException -> 0x014b }
            int r3 = r4.getInt(r3)     // Catch:{ JSONException -> 0x014b }
            r1.put(r10, r3)     // Catch:{ JSONException -> 0x014b }
            goto L_0x00b6
        L_0x0105:
            android.os.Bundle r4 = r0.zza     // Catch:{ JSONException -> 0x014b }
            java.lang.String r3 = r4.getString(r3)     // Catch:{ JSONException -> 0x014b }
            r1.put(r10, r3)     // Catch:{ JSONException -> 0x014b }
            goto L_0x00b6
        L_0x010f:
            android.os.Bundle r2 = r0.zza     // Catch:{ JSONException -> 0x014b }
            java.util.Set r2 = r2.keySet()     // Catch:{ JSONException -> 0x014b }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ JSONException -> 0x014b }
        L_0x0119:
            boolean r3 = r2.hasNext()     // Catch:{ JSONException -> 0x014b }
            if (r3 == 0) goto L_0x014b
            java.lang.Object r3 = r2.next()     // Catch:{ JSONException -> 0x014b }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ JSONException -> 0x014b }
            java.lang.String r4 = "com.google."
            boolean r4 = r3.startsWith(r4)     // Catch:{ JSONException -> 0x014b }
            if (r4 != 0) goto L_0x0119
            android.os.Bundle r4 = r0.zza     // Catch:{ JSONException -> 0x014b }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ JSONException -> 0x014b }
            boolean r5 = r4 instanceof java.lang.String     // Catch:{ JSONException -> 0x014b }
            if (r5 == 0) goto L_0x013b
            r1.put(r3, r4)     // Catch:{ JSONException -> 0x014b }
            goto L_0x0119
        L_0x013b:
            boolean r5 = r4 instanceof java.lang.Integer     // Catch:{ JSONException -> 0x014b }
            if (r5 == 0) goto L_0x0143
            r1.put(r3, r4)     // Catch:{ JSONException -> 0x014b }
            goto L_0x0119
        L_0x0143:
            boolean r5 = r4 instanceof java.lang.Double     // Catch:{ JSONException -> 0x014b }
            if (r5 == 0) goto L_0x0119
            r1.put(r3, r4)     // Catch:{ JSONException -> 0x014b }
            goto L_0x0119
        L_0x014b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.cast.MediaMetadata.zza():org.json.JSONObject");
    }

    public final void zzc(JSONObject jSONObject) {
        JSONObject jSONObject2 = jSONObject;
        clear();
        this.zze = 0;
        try {
            this.zze = jSONObject2.getInt("metadataType");
        } catch (JSONException unused) {
        }
        JSONArray optJSONArray = jSONObject2.optJSONArray("images");
        if (optJSONArray != null) {
            zza.zzd(this.zzd, optJSONArray);
        }
        ArrayList arrayList = new ArrayList();
        int i = this.zze;
        if (i == 0) {
            Collections.addAll(arrayList, new String[]{KEY_TITLE, KEY_ARTIST, KEY_SUBTITLE, KEY_RELEASE_DATE});
        } else if (i == 1) {
            Collections.addAll(arrayList, new String[]{KEY_TITLE, KEY_STUDIO, KEY_SUBTITLE, KEY_RELEASE_DATE});
        } else if (i == 2) {
            Collections.addAll(arrayList, new String[]{KEY_TITLE, KEY_SERIES_TITLE, KEY_SEASON_NUMBER, KEY_EPISODE_NUMBER, KEY_BROADCAST_DATE});
        } else if (i == 3) {
            Collections.addAll(arrayList, new String[]{KEY_TITLE, KEY_ALBUM_TITLE, KEY_ARTIST, KEY_ALBUM_ARTIST, KEY_COMPOSER, KEY_TRACK_NUMBER, KEY_DISC_NUMBER, KEY_RELEASE_DATE});
        } else if (i == 4) {
            Collections.addAll(arrayList, new String[]{KEY_TITLE, KEY_ARTIST, KEY_LOCATION_NAME, KEY_LOCATION_LATITUDE, KEY_LOCATION_LONGITUDE, KEY_WIDTH, KEY_HEIGHT, KEY_CREATION_DATE});
        } else if (i == 5) {
            Collections.addAll(arrayList, new String[]{KEY_CHAPTER_TITLE, KEY_CHAPTER_NUMBER, KEY_TITLE, KEY_BOOK_TITLE, KEY_SUBTITLE});
        }
        Collections.addAll(arrayList, new String[]{KEY_SECTION_DURATION, KEY_SECTION_START_TIME_IN_MEDIA, KEY_SECTION_START_ABSOLUTE_TIME, KEY_SECTION_START_TIME_IN_CONTAINER, KEY_QUEUE_ITEM_ID});
        HashSet hashSet = new HashSet(arrayList);
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next != null && !"metadataType".equals(next)) {
                    zzcd zzcd = zzc;
                    String zzd2 = zzcd.zzd(next);
                    if (zzd2 == null) {
                        Object obj = jSONObject2.get(next);
                        if (obj instanceof String) {
                            this.zza.putString(next, (String) obj);
                        } else if (obj instanceof Integer) {
                            this.zza.putInt(next, ((Integer) obj).intValue());
                        } else if (obj instanceof Double) {
                            this.zza.putDouble(next, ((Double) obj).doubleValue());
                        }
                    } else if (hashSet.contains(zzd2)) {
                        try {
                            Object obj2 = jSONObject2.get(next);
                            if (obj2 != null) {
                                int zza2 = zzcd.zza(zzd2);
                                if (zza2 != 1) {
                                    if (zza2 != 2) {
                                        if (zza2 == 3) {
                                            double optDouble = jSONObject2.optDouble(next);
                                            if (!Double.isNaN(optDouble)) {
                                                this.zza.putDouble(zzd2, optDouble);
                                            }
                                        } else if (zza2 != 4) {
                                            if (zza2 == 5) {
                                                this.zza.putLong(zzd2, CastUtils.secToMillisec(jSONObject2.optLong(next)));
                                            }
                                        } else if (obj2 instanceof String) {
                                            String str = (String) obj2;
                                            if (zza.zzb(str) != null) {
                                                this.zza.putString(zzd2, str);
                                            }
                                        }
                                    } else if (obj2 instanceof Integer) {
                                        this.zza.putInt(zzd2, ((Integer) obj2).intValue());
                                    }
                                } else if (obj2 instanceof String) {
                                    this.zza.putString(zzd2, (String) obj2);
                                }
                            }
                        } catch (JSONException unused2) {
                        }
                    }
                }
            }
        } catch (JSONException unused3) {
        }
    }

    public MediaMetadata(int i) {
        this(new ArrayList(), new Bundle(), i);
    }

    MediaMetadata(List list, Bundle bundle, int i) {
        this.zzf = new Writer();
        this.zzd = list;
        this.zza = bundle;
        this.zze = i;
    }
}
