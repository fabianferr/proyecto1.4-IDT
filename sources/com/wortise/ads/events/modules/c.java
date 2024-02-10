package com.wortise.ads.events.modules;

import android.content.Context;
import android.os.Bundle;
import com.google.gson.annotations.SerializedName;
import com.wortise.ads.AdResponse;
import com.wortise.ads.AdType;
import com.wortise.ads.rewarded.models.Reward;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv = {}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 \u00142\u00020\u0001:\u0002\u0015\u0016B!\u0012\u0006\u0010\r\u001a\u00020\f\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\b\u0010\u0003\u001a\u00020\u0002H\u0016R\u0016\u0010\u0007\u001a\u0004\u0018\u00010\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u000b\u001a\u00020\b8TX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\n¨\u0006\u0017"}, d2 = {"Lcom/wortise/ads/events/modules/c;", "Lcom/wortise/ads/events/modules/a;", "", "canHandle", "Lcom/wortise/ads/rewarded/models/Reward;", "getReward", "()Lcom/wortise/ads/rewarded/models/Reward;", "reward", "", "getLogExtras", "()Ljava/lang/Object;", "logExtras", "Landroid/content/Context;", "context", "Lcom/wortise/ads/AdResponse;", "adResponse", "Landroid/os/Bundle;", "adExtras", "<init>", "(Landroid/content/Context;Lcom/wortise/ads/AdResponse;Landroid/os/Bundle;)V", "Companion", "a", "b", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: RewardedHandler.kt */
public final class c extends a {
    public static final a Companion = new a((DefaultConstructorMarker) null);
    public static final String EXTRA_REWARD = "reward";

    @Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0003\u001a\u00020\u00028\u0006XT¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, d2 = {"Lcom/wortise/ads/events/modules/c$a;", "", "", "EXTRA_REWARD", "Ljava/lang/String;", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: RewardedHandler.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(bv = {}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\u000f\u0010\u0010J\t\u0010\u0003\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0005\u001a\u00020\u0004HÖ\u0001J\u0013\u0010\b\u001a\u00020\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\t8\u0006X\u0004¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/wortise/ads/events/modules/c$b;", "", "", "toString", "", "hashCode", "other", "", "equals", "Lcom/wortise/ads/rewarded/models/Reward;", "a", "Lcom/wortise/ads/rewarded/models/Reward;", "getReward", "()Lcom/wortise/ads/rewarded/models/Reward;", "reward", "<init>", "(Lcom/wortise/ads/rewarded/models/Reward;)V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: RewardedHandler.kt */
    private static final class b {
        @SerializedName("reward")
        private final Reward a;

        public b(Reward reward) {
            this.a = reward;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && Intrinsics.areEqual((Object) this.a, (Object) ((b) obj).a);
        }

        public int hashCode() {
            Reward reward = this.a;
            if (reward == null) {
                return 0;
            }
            return reward.hashCode();
        }

        public String toString() {
            return "LogExtras(reward=" + this.a + ')';
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Context context, AdResponse adResponse, Bundle bundle) {
        super(context, adResponse, bundle);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(adResponse, "adResponse");
    }

    private final Reward getReward() {
        Bundle adExtras = getAdExtras();
        if (adExtras == null) {
            return null;
        }
        return (Reward) adExtras.getParcelable(EXTRA_REWARD);
    }

    public boolean canHandle() {
        return getAdResponse().a(AdType.REWARDED);
    }

    /* access modifiers changed from: protected */
    public Object getLogExtras() {
        return new b(getReward());
    }
}
