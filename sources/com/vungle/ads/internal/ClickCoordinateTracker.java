package com.vungle.ads.internal;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.BannerAdSize;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.model.AdPayload;
import com.vungle.ads.internal.network.TpatSender;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.util.PathProvider;
import com.vungle.ads.internal.util.ViewUtility;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.regex.Pattern;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\u0018\u0000 *2\u00020\u0001:\u0004)*+,B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010$\u001a\u00020%H\u0002J\u000e\u0010&\u001a\u00020%2\u0006\u0010'\u001a\u00020(R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u00020\n8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168BX\u0002¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u001b\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0012R\u0014\u0010\u001d\u001a\u00020\u00108BX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0012R\u001b\u0010\u001f\u001a\u00020 8BX\u0002¢\u0006\f\n\u0004\b#\u0010\u001a\u001a\u0004\b!\u0010\"¨\u0006-²\u0006\n\u0010.\u001a\u00020/X\u0002"}, d2 = {"Lcom/vungle/ads/internal/ClickCoordinateTracker;", "", "context", "Landroid/content/Context;", "advertisement", "Lcom/vungle/ads/internal/model/AdPayload;", "executor", "Ljava/util/concurrent/Executor;", "(Landroid/content/Context;Lcom/vungle/ads/internal/model/AdPayload;Ljava/util/concurrent/Executor;)V", "currentClick", "Lcom/vungle/ads/internal/ClickCoordinateTracker$ClickCoordinate;", "getCurrentClick$vungle_ads_release$annotations", "()V", "getCurrentClick$vungle_ads_release", "()Lcom/vungle/ads/internal/ClickCoordinateTracker$ClickCoordinate;", "deviceHeight", "", "getDeviceHeight", "()I", "deviceWidth", "getDeviceWidth", "executors", "Lcom/vungle/ads/internal/executor/Executors;", "getExecutors", "()Lcom/vungle/ads/internal/executor/Executors;", "executors$delegate", "Lkotlin/Lazy;", "requestedHeight", "getRequestedHeight", "requestedWidth", "getRequestedWidth", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;", "getVungleApiClient", "()Lcom/vungle/ads/internal/network/VungleApiClient;", "vungleApiClient$delegate", "sendClickCoordinates", "", "trackCoordinate", "event", "Landroid/view/MotionEvent;", "ClickCoordinate", "Companion", "Coordinate", "DeviceScreenInfo", "vungle-ads_release", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ClickCoordinateTracker.kt */
public final class ClickCoordinateTracker {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String MACRO_DOWN_X = Pattern.quote("{{{down_x}}}");
    private static final String MACRO_DOWN_Y = Pattern.quote("{{{down_y}}}");
    private static final String MACRO_HEIGHT = Pattern.quote("{{{height}}}");
    private static final String MACRO_REQ_HEIGHT = Pattern.quote("{{{req_height}}}");
    private static final String MACRO_REQ_WIDTH = Pattern.quote("{{{req_width}}}");
    private static final String MACRO_UP_X = Pattern.quote("{{{up_x}}}");
    private static final String MACRO_UP_Y = Pattern.quote("{{{up_y}}}");
    private static final String MACRO_WIDTH = Pattern.quote("{{{width}}}");
    private static final String TAG = "ClickCoordinateTracker";
    private final AdPayload advertisement;
    private final Context context;
    private final ClickCoordinate currentClick = new ClickCoordinate(new Coordinate(Integer.MIN_VALUE, Integer.MIN_VALUE), new Coordinate(Integer.MIN_VALUE, Integer.MIN_VALUE));
    private final Executor executor;
    private final Lazy executors$delegate;
    private final Lazy vungleApiClient$delegate;

    public static /* synthetic */ void getCurrentClick$vungle_ads_release$annotations() {
    }

    public ClickCoordinateTracker(Context context2, AdPayload adPayload, Executor executor2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(adPayload, "advertisement");
        Intrinsics.checkNotNullParameter(executor2, "executor");
        this.context = context2;
        this.advertisement = adPayload;
        this.executor = executor2;
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        this.vungleApiClient$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new ClickCoordinateTracker$special$$inlined$inject$1(context2));
        ServiceLocator.Companion companion2 = ServiceLocator.Companion;
        this.executors$delegate = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new ClickCoordinateTracker$special$$inlined$inject$2(context2));
    }

    private final VungleApiClient getVungleApiClient() {
        return (VungleApiClient) this.vungleApiClient$delegate.getValue();
    }

    private final Executors getExecutors() {
        return (Executors) this.executors$delegate.getValue();
    }

    public final ClickCoordinate getCurrentClick$vungle_ads_release() {
        return this.currentClick;
    }

    public final void trackCoordinate(MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (this.advertisement.isClickCoordinatesTrackingEnabled()) {
            int action = motionEvent.getAction();
            if (action == 0) {
                this.currentClick.setDownCoordinate(new Coordinate((int) motionEvent.getX(), (int) motionEvent.getY()));
            } else if (action == 1) {
                this.currentClick.setUpCoordinate(new Coordinate((int) motionEvent.getX(), (int) motionEvent.getY()));
                if (this.currentClick.ready()) {
                    sendClickCoordinates();
                }
            }
        }
    }

    private final void sendClickCoordinates() {
        List<String> tpatUrls$default = AdPayload.getTpatUrls$default(this.advertisement, AdPayload.TPAT_CLICK_COORDINATES_URLS, (String) null, 2, (Object) null);
        Collection collection = tpatUrls$default;
        if (collection == null || collection.isEmpty()) {
            AnalyticsClient.INSTANCE.logError$vungle_ads_release(129, "Empty tpat key: click_coordinate", this.advertisement.placementId(), this.advertisement.getCreativeId(), this.advertisement.eventId());
            return;
        }
        int requestedWidth = getRequestedWidth();
        int requestedHeight = getRequestedHeight();
        int requestedWidth2 = getRequestedWidth();
        int requestedHeight2 = getRequestedHeight();
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        TpatSender tpatSender = new TpatSender(getVungleApiClient(), this.advertisement.placementId(), this.advertisement.getCreativeId(), this.advertisement.eventId(), getExecutors().getIoExecutor(), m2272sendClickCoordinates$lambda0(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new ClickCoordinateTracker$sendClickCoordinates$$inlined$inject$1(this.context))));
        for (String replace : tpatUrls$default) {
            String str = MACRO_REQ_WIDTH;
            Intrinsics.checkNotNullExpressionValue(str, "MACRO_REQ_WIDTH");
            Regex regex = new Regex(str);
            String str2 = MACRO_REQ_HEIGHT;
            Intrinsics.checkNotNullExpressionValue(str2, "MACRO_REQ_HEIGHT");
            Regex regex2 = new Regex(str2);
            String str3 = MACRO_WIDTH;
            Intrinsics.checkNotNullExpressionValue(str3, "MACRO_WIDTH");
            Regex regex3 = new Regex(str3);
            String str4 = MACRO_HEIGHT;
            Intrinsics.checkNotNullExpressionValue(str4, "MACRO_HEIGHT");
            Regex regex4 = new Regex(str4);
            String str5 = MACRO_DOWN_X;
            Intrinsics.checkNotNullExpressionValue(str5, "MACRO_DOWN_X");
            Regex regex5 = new Regex(str5);
            String str6 = MACRO_DOWN_Y;
            Intrinsics.checkNotNullExpressionValue(str6, "MACRO_DOWN_Y");
            Regex regex6 = new Regex(str6);
            String str7 = MACRO_UP_X;
            Intrinsics.checkNotNullExpressionValue(str7, "MACRO_UP_X");
            Regex regex7 = new Regex(str7);
            String str8 = MACRO_UP_Y;
            Intrinsics.checkNotNullExpressionValue(str8, "MACRO_UP_Y");
            tpatSender.sendTpat(new Regex(str8).replace((CharSequence) regex7.replace((CharSequence) regex6.replace((CharSequence) regex5.replace((CharSequence) regex4.replace((CharSequence) regex3.replace((CharSequence) regex2.replace((CharSequence) regex.replace((CharSequence) replace, String.valueOf(requestedWidth)), String.valueOf(requestedHeight)), String.valueOf(requestedWidth2)), String.valueOf(requestedHeight2)), String.valueOf(this.currentClick.getDownCoordinate().getX())), String.valueOf(this.currentClick.getDownCoordinate().getY())), String.valueOf(this.currentClick.getUpCoordinate().getX())), String.valueOf(this.currentClick.getUpCoordinate().getY())), this.executor);
        }
    }

    /* renamed from: sendClickCoordinates$lambda-0  reason: not valid java name */
    private static final PathProvider m2272sendClickCoordinates$lambda0(Lazy<PathProvider> lazy) {
        return lazy.getValue();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/vungle/ads/internal/ClickCoordinateTracker$Coordinate;", "", "x", "", "y", "(II)V", "getX", "()I", "getY", "component1", "component2", "copy", "equals", "", "other", "hashCode", "toString", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ClickCoordinateTracker.kt */
    public static final class Coordinate {
        private final int x;
        private final int y;

        public static /* synthetic */ Coordinate copy$default(Coordinate coordinate, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i = coordinate.x;
            }
            if ((i3 & 2) != 0) {
                i2 = coordinate.y;
            }
            return coordinate.copy(i, i2);
        }

        public final int component1() {
            return this.x;
        }

        public final int component2() {
            return this.y;
        }

        public final Coordinate copy(int i, int i2) {
            return new Coordinate(i, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Coordinate)) {
                return false;
            }
            Coordinate coordinate = (Coordinate) obj;
            return this.x == coordinate.x && this.y == coordinate.y;
        }

        public int hashCode() {
            return (this.x * 31) + this.y;
        }

        public String toString() {
            return "Coordinate(x=" + this.x + ", y=" + this.y + ')';
        }

        public Coordinate(int i, int i2) {
            this.x = i;
            this.y = i2;
        }

        public final int getX() {
            return this.x;
        }

        public final int getY() {
            return this.y;
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\u0006\u0010\u0014\u001a\u00020\u0010J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0007\"\u0004\b\u000b\u0010\t¨\u0006\u0017"}, d2 = {"Lcom/vungle/ads/internal/ClickCoordinateTracker$ClickCoordinate;", "", "downCoordinate", "Lcom/vungle/ads/internal/ClickCoordinateTracker$Coordinate;", "upCoordinate", "(Lcom/vungle/ads/internal/ClickCoordinateTracker$Coordinate;Lcom/vungle/ads/internal/ClickCoordinateTracker$Coordinate;)V", "getDownCoordinate", "()Lcom/vungle/ads/internal/ClickCoordinateTracker$Coordinate;", "setDownCoordinate", "(Lcom/vungle/ads/internal/ClickCoordinateTracker$Coordinate;)V", "getUpCoordinate", "setUpCoordinate", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "ready", "toString", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ClickCoordinateTracker.kt */
    public static final class ClickCoordinate {
        private Coordinate downCoordinate;
        private Coordinate upCoordinate;

        public static /* synthetic */ ClickCoordinate copy$default(ClickCoordinate clickCoordinate, Coordinate coordinate, Coordinate coordinate2, int i, Object obj) {
            if ((i & 1) != 0) {
                coordinate = clickCoordinate.downCoordinate;
            }
            if ((i & 2) != 0) {
                coordinate2 = clickCoordinate.upCoordinate;
            }
            return clickCoordinate.copy(coordinate, coordinate2);
        }

        public final Coordinate component1() {
            return this.downCoordinate;
        }

        public final Coordinate component2() {
            return this.upCoordinate;
        }

        public final ClickCoordinate copy(Coordinate coordinate, Coordinate coordinate2) {
            Intrinsics.checkNotNullParameter(coordinate, "downCoordinate");
            Intrinsics.checkNotNullParameter(coordinate2, "upCoordinate");
            return new ClickCoordinate(coordinate, coordinate2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ClickCoordinate)) {
                return false;
            }
            ClickCoordinate clickCoordinate = (ClickCoordinate) obj;
            return Intrinsics.areEqual((Object) this.downCoordinate, (Object) clickCoordinate.downCoordinate) && Intrinsics.areEqual((Object) this.upCoordinate, (Object) clickCoordinate.upCoordinate);
        }

        public int hashCode() {
            return (this.downCoordinate.hashCode() * 31) + this.upCoordinate.hashCode();
        }

        public String toString() {
            return "ClickCoordinate(downCoordinate=" + this.downCoordinate + ", upCoordinate=" + this.upCoordinate + ')';
        }

        public ClickCoordinate(Coordinate coordinate, Coordinate coordinate2) {
            Intrinsics.checkNotNullParameter(coordinate, "downCoordinate");
            Intrinsics.checkNotNullParameter(coordinate2, "upCoordinate");
            this.downCoordinate = coordinate;
            this.upCoordinate = coordinate2;
        }

        public final Coordinate getDownCoordinate() {
            return this.downCoordinate;
        }

        public final void setDownCoordinate(Coordinate coordinate) {
            Intrinsics.checkNotNullParameter(coordinate, "<set-?>");
            this.downCoordinate = coordinate;
        }

        public final Coordinate getUpCoordinate() {
            return this.upCoordinate;
        }

        public final void setUpCoordinate(Coordinate coordinate) {
            Intrinsics.checkNotNullParameter(coordinate, "<set-?>");
            this.upCoordinate = coordinate;
        }

        public final boolean ready() {
            return (this.downCoordinate.getX() == Integer.MIN_VALUE || this.downCoordinate.getY() == Integer.MIN_VALUE || this.upCoordinate.getX() == Integer.MIN_VALUE || this.upCoordinate.getY() == Integer.MIN_VALUE) ? false : true;
        }
    }

    private final int getRequestedWidth() {
        BannerAdSize adSize = this.advertisement.getAdSize();
        if (adSize == null) {
            return getDeviceWidth();
        }
        return ViewUtility.INSTANCE.dpToPixels(this.context, adSize.getWidth());
    }

    private final int getRequestedHeight() {
        BannerAdSize adSize = this.advertisement.getAdSize();
        if (adSize == null) {
            return getDeviceHeight();
        }
        return ViewUtility.INSTANCE.dpToPixels(this.context, adSize.getHeight());
    }

    private final int getDeviceWidth() {
        return new DeviceScreenInfo(this.context).getDeviceWidth();
    }

    private final int getDeviceHeight() {
        return new DeviceScreenInfo(this.context).getDeviceHeight();
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001a\u00020\bHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/vungle/ads/internal/ClickCoordinateTracker$DeviceScreenInfo;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "deviceHeight", "", "getDeviceHeight", "()I", "deviceWidth", "getDeviceWidth", "dm", "Landroid/util/DisplayMetrics;", "component1", "copy", "equals", "", "other", "hashCode", "toString", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ClickCoordinateTracker.kt */
    public static final class DeviceScreenInfo {
        private final Context context;
        private final DisplayMetrics dm;

        public static /* synthetic */ DeviceScreenInfo copy$default(DeviceScreenInfo deviceScreenInfo, Context context2, int i, Object obj) {
            if ((i & 1) != 0) {
                context2 = deviceScreenInfo.context;
            }
            return deviceScreenInfo.copy(context2);
        }

        public final Context component1() {
            return this.context;
        }

        public final DeviceScreenInfo copy(Context context2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            return new DeviceScreenInfo(context2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DeviceScreenInfo) && Intrinsics.areEqual((Object) this.context, (Object) ((DeviceScreenInfo) obj).context);
        }

        public int hashCode() {
            return this.context.hashCode();
        }

        public String toString() {
            return "DeviceScreenInfo(context=" + this.context + ')';
        }

        public DeviceScreenInfo(Context context2) {
            Intrinsics.checkNotNullParameter(context2, "context");
            this.context = context2;
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.dm = displayMetrics;
            Object systemService = context2.getSystemService("window");
            Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.WindowManager");
            ((WindowManager) systemService).getDefaultDisplay().getMetrics(displayMetrics);
        }

        public final Context getContext() {
            return this.context;
        }

        public final int getDeviceWidth() {
            return this.dm.widthPixels;
        }

        public final int getDeviceHeight() {
            return this.dm.heightPixels;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0016\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/vungle/ads/internal/ClickCoordinateTracker$Companion;", "", "()V", "MACRO_DOWN_X", "", "kotlin.jvm.PlatformType", "MACRO_DOWN_Y", "MACRO_HEIGHT", "MACRO_REQ_HEIGHT", "MACRO_REQ_WIDTH", "MACRO_UP_X", "MACRO_UP_Y", "MACRO_WIDTH", "TAG", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ClickCoordinateTracker.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
