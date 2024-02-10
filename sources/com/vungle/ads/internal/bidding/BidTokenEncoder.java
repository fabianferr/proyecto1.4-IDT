package com.vungle.ads.internal.bidding;

import android.content.Context;
import android.util.Base64;
import com.vungle.ads.AnalyticsClient;
import com.vungle.ads.ServiceLocator;
import com.vungle.ads.internal.ConfigManager;
import com.vungle.ads.internal.model.CommonRequestBody;
import com.vungle.ads.internal.model.RtbRequest;
import com.vungle.ads.internal.model.RtbToken;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.util.ActivityManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.StringFormat;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\n\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\u0006\u0010\r\u001a\u00020\fJ\b\u0010\u000e\u001a\u0004\u0018\u00010\fR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u0002"}, d2 = {"Lcom/vungle/ads/internal/bidding/BidTokenEncoder;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "enterBackgroundTime", "", "json", "Lkotlinx/serialization/json/Json;", "ordinalView", "", "bidTokenV4", "", "constructV4Token", "encode", "Companion", "vungle-ads_release", "vungleApiClient", "Lcom/vungle/ads/internal/network/VungleApiClient;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BidTokenEncoder.kt */
public final class BidTokenEncoder {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TOKEN_VERSION = 4;
    private final Context context;
    /* access modifiers changed from: private */
    public long enterBackgroundTime;
    private final Json json = JsonKt.Json$default((Json) null, BidTokenEncoder$json$1.INSTANCE, 1, (Object) null);
    /* access modifiers changed from: private */
    public int ordinalView;

    public BidTokenEncoder(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        ActivityManager.Companion.addLifecycleListener(new ActivityManager.LifeCycleCallback(this) {
            final /* synthetic */ BidTokenEncoder this$0;

            {
                this.this$0 = r1;
            }

            public void onResume() {
                super.onResume();
                if (System.currentTimeMillis() > this.this$0.enterBackgroundTime + (((long) ConfigManager.INSTANCE.getSessionTimeoutInSecond()) * 1000)) {
                    this.this$0.ordinalView = 0;
                    this.this$0.enterBackgroundTime = 0;
                }
            }

            public void onPause() {
                super.onPause();
                this.this$0.enterBackgroundTime = System.currentTimeMillis();
            }
        });
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/vungle/ads/internal/bidding/BidTokenEncoder$Companion;", "", "()V", "TOKEN_VERSION", "", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: BidTokenEncoder.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final String encode() {
        this.ordinalView++;
        return bidTokenV4();
    }

    private final String bidTokenV4() {
        try {
            String constructV4Token = constructV4Token();
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(constructV4Token.length());
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            byte[] bytes = constructV4Token.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            gZIPOutputStream.write(bytes);
            gZIPOutputStream.close();
            String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
            byteArrayOutputStream.close();
            return "4:" + encodeToString;
        } catch (IOException e) {
            AnalyticsClient analyticsClient = AnalyticsClient.INSTANCE;
            AnalyticsClient.logError$vungle_ads_release$default(analyticsClient, 116, "Fail to gzip bidtoken " + e.getLocalizedMessage(), (String) null, (String) null, (String) null, 28, (Object) null);
            String str = null;
            return null;
        }
    }

    /* renamed from: constructV4Token$lambda-0  reason: not valid java name */
    private static final VungleApiClient m2293constructV4Token$lambda0(Lazy<VungleApiClient> lazy) {
        return lazy.getValue();
    }

    public final String constructV4Token() {
        ServiceLocator.Companion companion = ServiceLocator.Companion;
        CommonRequestBody requestBody = m2293constructV4Token$lambda0(LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, new BidTokenEncoder$constructV4Token$$inlined$inject$1(this.context))).requestBody();
        RtbToken rtbToken = new RtbToken(requestBody.getDevice(), requestBody.getUser(), requestBody.getExt(), new RtbRequest(VungleApiClient.Companion.getHeaderUa()), this.ordinalView);
        StringFormat stringFormat = this.json;
        KSerializer<Object> serializer = SerializersKt.serializer(stringFormat.getSerializersModule(), Reflection.typeOf(RtbToken.class));
        Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return stringFormat.encodeToString(serializer, rtbToken);
    }
}
