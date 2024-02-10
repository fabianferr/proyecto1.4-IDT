package com.bykv.vk.openvk.preload.geckox;

import android.content.Context;
import android.webkit.WebResourceResponse;
import com.bykv.vk.openvk.preload.falconx.loader.ILoader;
import com.bykv.vk.openvk.preload.geckox.model.WebResourceResponseModel;
import com.bykv.vk.openvk.preload.geckox.net.INetWork;
import com.bykv.vk.openvk.preload.geckox.statistic.IStatisticMonitor;
import java.util.Set;
import java.util.concurrent.ThreadPoolExecutor;

public class GeckoHubImp {

    static class a {
        /* access modifiers changed from: private */
        public static GeckoHubImp a = new GeckoHubImp();
    }

    public static GeckoHubImp inst(Context context) {
        c.a(context);
        return a.a;
    }

    private GeckoHubImp() {
    }

    public static void setRandomHost(String str) {
        c.a(str);
    }

    public void preload(String str, IStatisticMonitor iStatisticMonitor, Set<String> set, INetWork iNetWork) {
        c.a();
        c.a(str, iStatisticMonitor, set, iNetWork);
    }

    public com.bykv.vk.openvk.preload.falconx.loader.a getGeckoResLoader() {
        c.a();
        return c.b();
    }

    public void releaseGeckoResLoader(ILoader iLoader) {
        c.a();
        c.a(iLoader);
    }

    public WebResourceResponseModel findResAndMsg(ILoader iLoader, String str, String str2) {
        return c.a().a(iLoader, str, str2);
    }

    public WebResourceResponse findRes(ILoader iLoader, String str, String str2) {
        return c.a().a(iLoader, str, str2).getWebResourceResponse();
    }

    public int getResCount(ILoader iLoader, String str) {
        c.a();
        return c.a(iLoader, str);
    }

    public static void setThreadPoolExecutor(ThreadPoolExecutor threadPoolExecutor) {
        b.a(threadPoolExecutor);
    }
}
