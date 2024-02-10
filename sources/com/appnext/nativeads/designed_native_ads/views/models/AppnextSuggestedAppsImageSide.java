package com.appnext.nativeads.designed_native_ads.views.models;

public enum AppnextSuggestedAppsImageSide {
    Right,
    Left;

    /* renamed from: com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] fY = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide[] r0 = com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                fY = r0
                com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide r1 = com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide.Left     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = fY     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide r1 = com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide.Right     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appnext.nativeads.designed_native_ads.views.models.AppnextSuggestedAppsImageSide.AnonymousClass1.<clinit>():void");
        }
    }

    public final AppnextSuggestedAppsImageSide getOppositeSide() {
        int i = AnonymousClass1.fY[ordinal()];
        if (i == 1) {
            return Right;
        }
        if (i != 2) {
            return Right;
        }
        return Left;
    }
}
