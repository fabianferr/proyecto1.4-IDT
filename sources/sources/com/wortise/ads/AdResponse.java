package com.wortise.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.wortise.ads.device.ScreenOrientation;
import com.wortise.ads.geofencing.models.GeofencePoint;
import com.wortise.ads.google.models.GoogleParams;
import com.wortise.ads.push.models.Notification;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\f\b\b\u0018\u00002\u00020\u00012\u00020\u0002Bç\u0001\u0012\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u0015\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001a\u0012\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\r\u0012\b\b\u0002\u0010#\u001a\u00020\u001a¢\u0006\u0004\b\\\u0010]J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003J\u000e\u0010\u0006\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0005J\u0006\u0010\n\u001a\u00020\u0005J\u0006\u0010\u000b\u001a\u00020\u0005Jð\u0001\u0010\u0006\u001a\u00020\u00002\u0010\b\u0002\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00152\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010#\u001a\u00020\u001aHÆ\u0001¢\u0006\u0004\b\u0006\u0010$J\t\u0010%\u001a\u00020\rHÖ\u0001J\t\u0010&\u001a\u00020\u001aHÖ\u0001J\u0013\u0010)\u001a\u00020\u00052\b\u0010(\u001a\u0004\u0018\u00010'HÖ\u0003J\t\u0010*\u001a\u00020\u001aHÖ\u0001J\u0019\u0010/\u001a\u00020.2\u0006\u0010,\u001a\u00020+2\u0006\u0010-\u001a\u00020\u001aHÖ\u0001R\"\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0004¢\u0006\f\n\u0004\b\u0006\u00100\u001a\u0004\b\u0006\u00101R\u001c\u0010\u000f\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\f\n\u0004\b2\u00103\u001a\u0004\b2\u00104R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00108\u0006X\u0004¢\u0006\f\n\u0004\b5\u00106\u001a\u0004\b5\u00107R\"\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0004¢\u0006\f\n\u0004\b8\u00100\u001a\u0004\b8\u00101R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\f\n\u0004\b9\u00103\u001a\u0004\b9\u00104R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\f\n\u0004\b:\u00103\u001a\u0004\b:\u00104R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\f\n\u0004\b;\u0010<\u001a\u0004\b;\u0010=R\"\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u00158\u0006X\u0004¢\u0006\f\n\u0004\b>\u00100\u001a\u0004\b>\u00101R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u00188\u0006X\u0004¢\u0006\f\n\u0004\b?\u0010@\u001a\u0004\b?\u0010AR\u001a\u0010\u001b\u001a\u00020\u001a8\u0006X\u0004¢\u0006\f\n\u0004\bB\u0010C\u001a\u0004\bB\u0010DR\"\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006X\u0004¢\u0006\f\n\u0004\bE\u00100\u001a\u0004\bE\u00101R\u001c\u0010\u001d\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\f\n\u0004\bF\u00103\u001a\u0004\bF\u00104R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0006X\u0004¢\u0006\f\n\u0004\bG\u0010H\u001a\u0004\bG\u0010IR\u001c\u0010!\u001a\u0004\u0018\u00010 8\u0006X\u0004¢\u0006\f\n\u0004\bJ\u0010K\u001a\u0004\bJ\u0010LR\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0004¢\u0006\f\n\u0004\bM\u0010N\u001a\u0004\bO\u0010PR\u001c\u0010\"\u001a\u0004\u0018\u00010\r8\u0006X\u0004¢\u0006\f\n\u0004\bQ\u00103\u001a\u0004\bM\u00104R\u001a\u0010#\u001a\u00020\u001a8\u0006X\u0004¢\u0006\f\n\u0004\b\t\u0010C\u001a\u0004\bQ\u0010DR\u001a\u0010V\u001a\u00020R8\u0002X\u0004¢\u0006\f\n\u0004\b\n\u0010S\u0012\u0004\bT\u0010UR\u001a\u0010X\u001a\u00020R8\u0002X\u0004¢\u0006\f\n\u0004\b\u000b\u0010S\u0012\u0004\bW\u0010UR\u001a\u0010[\u001a\u00020R8\u0002X\u0004¢\u0006\f\n\u0004\bY\u0010S\u0012\u0004\bZ\u0010U¨\u0006^"}, d2 = {"Lcom/wortise/ads/AdResponse;", "", "Landroid/os/Parcelable;", "Lcom/wortise/ads/AdFormat;", "format", "", "a", "Lcom/wortise/ads/AdType;", "type", "q", "r", "s", "", "", "clickTrackers", "clickUrl", "", "closeDelay", "completionTrackers", "completionUrl", "content", "", "Lcom/wortise/ads/geofencing/models/GeofencePoint;", "geofences", "Lcom/wortise/ads/google/models/GoogleParams;", "google", "", "height", "impressionTrackers", "impressionUrl", "Lcom/wortise/ads/push/models/Notification;", "notification", "Lcom/wortise/ads/device/ScreenOrientation;", "orientation", "url", "width", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/wortise/ads/AdFormat;Ljava/util/List;Lcom/wortise/ads/google/models/GoogleParams;ILjava/util/List;Ljava/lang/String;Lcom/wortise/ads/push/models/Notification;Lcom/wortise/ads/device/ScreenOrientation;Lcom/wortise/ads/AdType;Ljava/lang/String;I)Lcom/wortise/ads/AdResponse;", "toString", "hashCode", "", "other", "equals", "describeContents", "Landroid/os/Parcel;", "parcel", "flags", "", "writeToParcel", "Ljava/util/List;", "()Ljava/util/List;", "b", "Ljava/lang/String;", "()Ljava/lang/String;", "c", "Ljava/lang/Long;", "()Ljava/lang/Long;", "d", "e", "f", "g", "Lcom/wortise/ads/AdFormat;", "()Lcom/wortise/ads/AdFormat;", "h", "i", "Lcom/wortise/ads/google/models/GoogleParams;", "()Lcom/wortise/ads/google/models/GoogleParams;", "j", "I", "()I", "k", "l", "m", "Lcom/wortise/ads/push/models/Notification;", "()Lcom/wortise/ads/push/models/Notification;", "n", "Lcom/wortise/ads/device/ScreenOrientation;", "()Lcom/wortise/ads/device/ScreenOrientation;", "o", "Lcom/wortise/ads/AdType;", "getType", "()Lcom/wortise/ads/AdType;", "p", "Ljava/util/concurrent/atomic/AtomicBoolean;", "Ljava/util/concurrent/atomic/AtomicBoolean;", "getClickSent$annotations", "()V", "clickSent", "getCompletionSent$annotations", "completionSent", "t", "getImpressionSent$annotations", "impressionSent", "<init>", "(Ljava/util/List;Ljava/lang/String;Ljava/lang/Long;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/wortise/ads/AdFormat;Ljava/util/List;Lcom/wortise/ads/google/models/GoogleParams;ILjava/util/List;Ljava/lang/String;Lcom/wortise/ads/push/models/Notification;Lcom/wortise/ads/device/ScreenOrientation;Lcom/wortise/ads/AdType;Ljava/lang/String;I)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: AdResponse.kt */
public final class AdResponse implements Cloneable, Parcelable {
    public static final Parcelable.Creator<AdResponse> CREATOR = new a();
    @SerializedName("clickTrackers")
    private final List<String> a;
    @SerializedName("clickUrl")
    private final String b;
    @SerializedName("closeDelay")
    private final Long c;
    @SerializedName("completionTrackers")
    private final List<String> d;
    @SerializedName("completionUrl")
    private final String e;
    @SerializedName("content")
    private final String f;
    @SerializedName("format")
    private final AdFormat g;
    @SerializedName("geofences")
    private final List<GeofencePoint> h;
    @SerializedName("google")
    private final GoogleParams i;
    @SerializedName("height")
    private final int j;
    @SerializedName("impressionTrackers")
    private final List<String> k;
    @SerializedName("impressionUrl")
    private final String l;
    @SerializedName("notification")
    private final Notification m;
    @SerializedName("orientation")
    private final ScreenOrientation n;
    @SerializedName("type")
    private final AdType o;
    @SerializedName("url")
    private final String p;
    @SerializedName("width")
    private final int q;
    private final transient AtomicBoolean r;
    private final transient AtomicBoolean s;
    private final transient AtomicBoolean t;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AdResponse.kt */
    public static final class a implements Parcelable.Creator<AdResponse> {
        /* renamed from: a */
        public final AdResponse createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
            String readString = parcel.readString();
            Long valueOf = parcel.readInt() == 0 ? null : Long.valueOf(parcel.readLong());
            ArrayList<String> createStringArrayList2 = parcel.createStringArrayList();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            AdFormat valueOf2 = parcel.readInt() == 0 ? null : AdFormat.valueOf(parcel.readString());
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i = 0; i != readInt; i++) {
                    arrayList.add(GeofencePoint.CREATOR.createFromParcel(parcel2));
                }
            }
            return new AdResponse(createStringArrayList, readString, valueOf, createStringArrayList2, readString2, readString3, valueOf2, arrayList, parcel.readInt() == 0 ? null : GoogleParams.CREATOR.createFromParcel(parcel2), parcel.readInt(), parcel.createStringArrayList(), parcel.readString(), parcel.readInt() == 0 ? null : Notification.CREATOR.createFromParcel(parcel2), parcel.readInt() == 0 ? null : ScreenOrientation.valueOf(parcel.readString()), parcel.readInt() == 0 ? null : AdType.valueOf(parcel.readString()), parcel.readString(), parcel.readInt());
        }

        /* renamed from: a */
        public final AdResponse[] newArray(int i) {
            return new AdResponse[i];
        }
    }

    public AdResponse() {
        this((List) null, (String) null, (Long) null, (List) null, (String) null, (String) null, (AdFormat) null, (List) null, (GoogleParams) null, 0, (List) null, (String) null, (Notification) null, (ScreenOrientation) null, (AdType) null, (String) null, 0, 131071, (DefaultConstructorMarker) null);
    }

    public AdResponse(List<String> list, String str, Long l2, List<String> list2, String str2, String str3, AdFormat adFormat, List<GeofencePoint> list3, GoogleParams googleParams, int i2, List<String> list4, String str4, Notification notification, ScreenOrientation screenOrientation, AdType adType, String str5, int i3) {
        this.a = list;
        this.b = str;
        this.c = l2;
        this.d = list2;
        this.e = str2;
        this.f = str3;
        this.g = adFormat;
        this.h = list3;
        this.i = googleParams;
        this.j = i2;
        this.k = list4;
        this.l = str4;
        this.m = notification;
        this.n = screenOrientation;
        this.o = adType;
        this.p = str5;
        this.q = i3;
        this.r = new AtomicBoolean(false);
        this.s = new AtomicBoolean(false);
        this.t = new AtomicBoolean(false);
    }

    public static /* synthetic */ AdResponse a(AdResponse adResponse, List list, String str, Long l2, List list2, String str2, String str3, AdFormat adFormat, List list3, GoogleParams googleParams, int i2, List list4, String str4, Notification notification, ScreenOrientation screenOrientation, AdType adType, String str5, int i3, int i4, Object obj) {
        AdResponse adResponse2 = adResponse;
        int i5 = i4;
        return adResponse.a((i5 & 1) != 0 ? adResponse2.a : list, (i5 & 2) != 0 ? adResponse2.b : str, (i5 & 4) != 0 ? adResponse2.c : l2, (i5 & 8) != 0 ? adResponse2.d : list2, (i5 & 16) != 0 ? adResponse2.e : str2, (i5 & 32) != 0 ? adResponse2.f : str3, (i5 & 64) != 0 ? adResponse2.g : adFormat, (i5 & 128) != 0 ? adResponse2.h : list3, (i5 & 256) != 0 ? adResponse2.i : googleParams, (i5 & 512) != 0 ? adResponse2.j : i2, (i5 & 1024) != 0 ? adResponse2.k : list4, (i5 & 2048) != 0 ? adResponse2.l : str4, (i5 & 4096) != 0 ? adResponse2.m : notification, (i5 & 8192) != 0 ? adResponse2.n : screenOrientation, (i5 & 16384) != 0 ? adResponse2.o : adType, (i5 & 32768) != 0 ? adResponse2.p : str5, (i5 & 65536) != 0 ? adResponse2.q : i3);
    }

    public final AdResponse a(List<String> list, String str, Long l2, List<String> list2, String str2, String str3, AdFormat adFormat, List<GeofencePoint> list3, GoogleParams googleParams, int i2, List<String> list4, String str4, Notification notification, ScreenOrientation screenOrientation, AdType adType, String str5, int i3) {
        return new AdResponse(list, str, l2, list2, str2, str3, adFormat, list3, googleParams, i2, list4, str4, notification, screenOrientation, adType, str5, i3);
    }

    public final List<String> a() {
        return this.a;
    }

    public final String b() {
        return this.b;
    }

    public final Long c() {
        return this.c;
    }

    public Object clone() {
        return super.clone();
    }

    public final List<String> d() {
        return this.d;
    }

    public int describeContents() {
        return 0;
    }

    public final String e() {
        return this.e;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdResponse)) {
            return false;
        }
        AdResponse adResponse = (AdResponse) obj;
        return Intrinsics.areEqual((Object) this.a, (Object) adResponse.a) && Intrinsics.areEqual((Object) this.b, (Object) adResponse.b) && Intrinsics.areEqual((Object) this.c, (Object) adResponse.c) && Intrinsics.areEqual((Object) this.d, (Object) adResponse.d) && Intrinsics.areEqual((Object) this.e, (Object) adResponse.e) && Intrinsics.areEqual((Object) this.f, (Object) adResponse.f) && this.g == adResponse.g && Intrinsics.areEqual((Object) this.h, (Object) adResponse.h) && Intrinsics.areEqual((Object) this.i, (Object) adResponse.i) && this.j == adResponse.j && Intrinsics.areEqual((Object) this.k, (Object) adResponse.k) && Intrinsics.areEqual((Object) this.l, (Object) adResponse.l) && Intrinsics.areEqual((Object) this.m, (Object) adResponse.m) && this.n == adResponse.n && this.o == adResponse.o && Intrinsics.areEqual((Object) this.p, (Object) adResponse.p) && this.q == adResponse.q;
    }

    public final String f() {
        return this.f;
    }

    public final AdFormat g() {
        return this.g;
    }

    public final List<GeofencePoint> h() {
        return this.h;
    }

    public int hashCode() {
        List<String> list = this.a;
        int i2 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        String str = this.b;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Long l2 = this.c;
        int hashCode3 = (hashCode2 + (l2 == null ? 0 : l2.hashCode())) * 31;
        List<String> list2 = this.d;
        int hashCode4 = (hashCode3 + (list2 == null ? 0 : list2.hashCode())) * 31;
        String str2 = this.e;
        int hashCode5 = (hashCode4 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f;
        int hashCode6 = (hashCode5 + (str3 == null ? 0 : str3.hashCode())) * 31;
        AdFormat adFormat = this.g;
        int hashCode7 = (hashCode6 + (adFormat == null ? 0 : adFormat.hashCode())) * 31;
        List<GeofencePoint> list3 = this.h;
        int hashCode8 = (hashCode7 + (list3 == null ? 0 : list3.hashCode())) * 31;
        GoogleParams googleParams = this.i;
        int hashCode9 = (((hashCode8 + (googleParams == null ? 0 : googleParams.hashCode())) * 31) + this.j) * 31;
        List<String> list4 = this.k;
        int hashCode10 = (hashCode9 + (list4 == null ? 0 : list4.hashCode())) * 31;
        String str4 = this.l;
        int hashCode11 = (hashCode10 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Notification notification = this.m;
        int hashCode12 = (hashCode11 + (notification == null ? 0 : notification.hashCode())) * 31;
        ScreenOrientation screenOrientation = this.n;
        int hashCode13 = (hashCode12 + (screenOrientation == null ? 0 : screenOrientation.hashCode())) * 31;
        AdType adType = this.o;
        int hashCode14 = (hashCode13 + (adType == null ? 0 : adType.hashCode())) * 31;
        String str5 = this.p;
        if (str5 != null) {
            i2 = str5.hashCode();
        }
        return ((hashCode14 + i2) * 31) + this.q;
    }

    public final GoogleParams i() {
        return this.i;
    }

    public final int j() {
        return this.j;
    }

    public final List<String> k() {
        return this.k;
    }

    public final String l() {
        return this.l;
    }

    public final Notification m() {
        return this.m;
    }

    public final ScreenOrientation n() {
        return this.n;
    }

    public final String o() {
        return this.p;
    }

    public final int p() {
        return this.q;
    }

    public final boolean q() {
        return this.r.compareAndSet(false, true);
    }

    public final boolean r() {
        return this.s.compareAndSet(false, true);
    }

    public final boolean s() {
        return this.t.compareAndSet(false, true);
    }

    public String toString() {
        return "AdResponse(clickTrackers=" + this.a + ", clickUrl=" + this.b + ", closeDelay=" + this.c + ", completionTrackers=" + this.d + ", completionUrl=" + this.e + ", content=" + this.f + ", format=" + this.g + ", geofences=" + this.h + ", google=" + this.i + ", height=" + this.j + ", impressionTrackers=" + this.k + ", impressionUrl=" + this.l + ", notification=" + this.m + ", orientation=" + this.n + ", type=" + this.o + ", url=" + this.p + ", width=" + this.q + ')';
    }

    public void writeToParcel(Parcel parcel, int i2) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        parcel.writeStringList(this.a);
        parcel.writeString(this.b);
        Long l2 = this.c;
        if (l2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeLong(l2.longValue());
        }
        parcel.writeStringList(this.d);
        parcel.writeString(this.e);
        parcel.writeString(this.f);
        AdFormat adFormat = this.g;
        if (adFormat == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(adFormat.name());
        }
        List<GeofencePoint> list = this.h;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (GeofencePoint writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i2);
            }
        }
        GoogleParams googleParams = this.i;
        if (googleParams == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            googleParams.writeToParcel(parcel, i2);
        }
        parcel.writeInt(this.j);
        parcel.writeStringList(this.k);
        parcel.writeString(this.l);
        Notification notification = this.m;
        if (notification == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            notification.writeToParcel(parcel, i2);
        }
        ScreenOrientation screenOrientation = this.n;
        if (screenOrientation == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(screenOrientation.name());
        }
        AdType adType = this.o;
        if (adType == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeString(adType.name());
        }
        parcel.writeString(this.p);
        parcel.writeInt(this.q);
    }

    public final boolean a(AdFormat adFormat) {
        Intrinsics.checkNotNullParameter(adFormat, "format");
        return this.g == adFormat;
    }

    public final boolean a(AdType adType) {
        Intrinsics.checkNotNullParameter(adType, "type");
        return this.o == adType;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AdResponse(java.util.List r19, java.lang.String r20, java.lang.Long r21, java.util.List r22, java.lang.String r23, java.lang.String r24, com.wortise.ads.AdFormat r25, java.util.List r26, com.wortise.ads.google.models.GoogleParams r27, int r28, java.util.List r29, java.lang.String r30, com.wortise.ads.push.models.Notification r31, com.wortise.ads.device.ScreenOrientation r32, com.wortise.ads.AdType r33, java.lang.String r34, int r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            if (r1 == 0) goto L_0x0008
            r1 = 0
            goto L_0x000a
        L_0x0008:
            r1 = r19
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = 0
            goto L_0x0012
        L_0x0010:
            r3 = r20
        L_0x0012:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0018
            r4 = 0
            goto L_0x001a
        L_0x0018:
            r4 = r21
        L_0x001a:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r22
        L_0x0022:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0028
            r6 = 0
            goto L_0x002a
        L_0x0028:
            r6 = r23
        L_0x002a:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x0030
            r7 = 0
            goto L_0x0032
        L_0x0030:
            r7 = r24
        L_0x0032:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0038
            r8 = 0
            goto L_0x003a
        L_0x0038:
            r8 = r25
        L_0x003a:
            r9 = r0 & 128(0x80, float:1.794E-43)
            if (r9 == 0) goto L_0x0040
            r9 = 0
            goto L_0x0042
        L_0x0040:
            r9 = r26
        L_0x0042:
            r10 = r0 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0048
            r10 = 0
            goto L_0x004a
        L_0x0048:
            r10 = r27
        L_0x004a:
            r11 = r0 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0050
            r11 = -1
            goto L_0x0052
        L_0x0050:
            r11 = r28
        L_0x0052:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0058
            r13 = 0
            goto L_0x005a
        L_0x0058:
            r13 = r29
        L_0x005a:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0060
            r14 = 0
            goto L_0x0062
        L_0x0060:
            r14 = r30
        L_0x0062:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0068
            r15 = 0
            goto L_0x006a
        L_0x0068:
            r15 = r31
        L_0x006a:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0070
            r2 = 0
            goto L_0x0072
        L_0x0070:
            r2 = r32
        L_0x0072:
            r12 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r12 == 0) goto L_0x0078
            r12 = 0
            goto L_0x007a
        L_0x0078:
            r12 = r33
        L_0x007a:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x0084
            r16 = 0
            goto L_0x0086
        L_0x0084:
            r16 = r34
        L_0x0086:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x008e
            r0 = -1
            goto L_0x0090
        L_0x008e:
            r0 = r35
        L_0x0090:
            r19 = r18
            r20 = r1
            r21 = r3
            r22 = r4
            r23 = r5
            r24 = r6
            r25 = r7
            r26 = r8
            r27 = r9
            r28 = r10
            r29 = r11
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r2
            r34 = r12
            r35 = r16
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wortise.ads.AdResponse.<init>(java.util.List, java.lang.String, java.lang.Long, java.util.List, java.lang.String, java.lang.String, com.wortise.ads.AdFormat, java.util.List, com.wortise.ads.google.models.GoogleParams, int, java.util.List, java.lang.String, com.wortise.ads.push.models.Notification, com.wortise.ads.device.ScreenOrientation, com.wortise.ads.AdType, java.lang.String, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
