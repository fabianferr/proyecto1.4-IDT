package com.wortise.ads.api.submodels;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0011\b\u0001\u0018\u0000 \t2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012¨\u0006\u0013"}, d2 = {"Lcom/wortise/ads/api/submodels/UserAppCategory;", "", "", "value", "I", "getValue", "()I", "<init>", "(Ljava/lang/String;II)V", "Companion", "a", "AUDIO", "GAME", "IMAGE", "MAPS", "NEWS", "PRODUCTIVITY", "SOCIAL", "VIDEO", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
/* compiled from: UserAppCategory.kt */
public enum UserAppCategory {
    AUDIO(1),
    GAME(0),
    IMAGE(3),
    MAPS(6),
    NEWS(5),
    PRODUCTIVITY(7),
    SOCIAL(4),
    VIDEO(2);
    
    public static final a Companion = null;
    private final int value;

    @Metadata(bv = {}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0003\u001a\u00020\u0002¨\u0006\b"}, d2 = {"Lcom/wortise/ads/api/submodels/UserAppCategory$a;", "", "", "value", "Lcom/wortise/ads/api/submodels/UserAppCategory;", "a", "<init>", "()V", "sdk_productionRelease"}, k = 1, mv = {1, 5, 1})
    /* compiled from: UserAppCategory.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final UserAppCategory a(int i) {
            for (UserAppCategory userAppCategory : UserAppCategory.values()) {
                if (userAppCategory.getValue() == i) {
                    return userAppCategory;
                }
            }
            return null;
        }
    }

    static {
        Companion = new a((DefaultConstructorMarker) null);
    }

    private UserAppCategory(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
