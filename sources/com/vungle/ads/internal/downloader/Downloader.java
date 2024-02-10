package com.vungle.ads.internal.downloader;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0002\u000b\fJ\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0003H&J\u001c\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\u00052\b\u0010\t\u001a\u0004\u0018\u00010\nH&¨\u0006\r"}, d2 = {"Lcom/vungle/ads/internal/downloader/Downloader;", "", "cancel", "", "request", "Lcom/vungle/ads/internal/downloader/DownloadRequest;", "cancelAll", "download", "downloadRequest", "downloadListener", "Lcom/vungle/ads/internal/downloader/AssetDownloadListener;", "NetworkType", "RequestException", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Downloader.kt */
public interface Downloader {
    void cancel(DownloadRequest downloadRequest);

    void cancelAll();

    void download(DownloadRequest downloadRequest, AssetDownloadListener assetDownloadListener);

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/vungle/ads/internal/downloader/Downloader$NetworkType;", "", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @Retention(RetentionPolicy.RUNTIME)
    /* compiled from: Downloader.kt */
    public @interface NetworkType {
        public static final Companion Companion = Companion.$$INSTANCE;

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\b¨\u0006\u000f"}, d2 = {"Lcom/vungle/ads/internal/downloader/Downloader$NetworkType$Companion;", "", "()V", "ANY", "", "getANY", "()I", "setANY", "(I)V", "CELLULAR", "getCELLULAR", "setCELLULAR", "WIFI", "getWIFI", "setWIFI", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: Downloader.kt */
        public static final class Companion {
            static final /* synthetic */ Companion $$INSTANCE = new Companion();
            private static int ANY = (1 | 2);
            private static int CELLULAR = 1;
            private static int WIFI = 2;

            private Companion() {
            }

            public final int getCELLULAR() {
                return CELLULAR;
            }

            public final void setCELLULAR(int i) {
                CELLULAR = i;
            }

            public final int getWIFI() {
                return WIFI;
            }

            public final void setWIFI(int i) {
                WIFI = i;
            }

            public final int getANY() {
                return ANY;
            }

            public final void setANY(int i) {
                ANY = i;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\b\u0000\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/vungle/ads/internal/downloader/Downloader$RequestException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: Downloader.kt */
    public static final class RequestException extends Exception {
        public RequestException(String str) {
            super(str);
        }
    }
}
