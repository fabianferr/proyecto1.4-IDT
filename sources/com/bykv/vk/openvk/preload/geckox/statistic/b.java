package com.bykv.vk.openvk.preload.geckox.statistic;

import android.content.Context;
import android.net.Uri;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.openvk.preload.b.b.a;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.d.e;
import com.bykv.vk.openvk.preload.geckox.d.g;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.statistic.model.StatisticModel;
import com.bykv.vk.openvk.preload.geckox.utils.h;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: UpdateListeners */
public final class b {
    public static a a(final com.bykv.vk.openvk.preload.geckox.b bVar) {
        return new a() {
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
                super.a(bVar, dVar);
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onStart", "");
                } catch (Throwable unused) {
                }
            }

            public final <T> void c(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
                super.c(bVar, dVar);
                try {
                    c.a(bVar, a.a(dVar.f));
                } catch (Throwable unused) {
                }
            }

            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
                super.b(bVar, dVar);
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onEnd", "");
                    if ((dVar instanceof e) && (dVar.c instanceof Map)) {
                        JSONObject jSONObject2 = bVar.r;
                        String simpleName = dVar.getClass().getSimpleName();
                        Map map = (Map) dVar.c;
                        Map map2 = map;
                        jSONObject2.put(simpleName, map.get("cca47107bfcbdb211d88f3385aeede40"));
                    }
                } catch (Throwable unused) {
                }
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onException", th.toString());
                    c.a(bVar, a.a(dVar.f));
                } catch (Throwable unused) {
                }
            }

            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar, Throwable th) {
                super.b(bVar, dVar, th);
                try {
                    JSONObject jSONObject = bVar.r;
                    jSONObject.put(dVar.getClass().getSimpleName() + "onChainException", th.toString());
                    c.a(bVar, a.a(dVar.f));
                } catch (Throwable unused) {
                }
            }
        };
    }

    public static a a(final Context context) {
        return new a() {
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
                super.a(bVar, dVar);
                Pair pair = (Pair) bVar.b(g.class);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.f).a(((UpdatePackage) pair.second).getChannel());
                a2.v = ((Uri) pair.first).toString();
                a2.p = h.a(context);
                a2.x = SystemClock.uptimeMillis();
                a2.r = Long.valueOf(((UpdatePackage) pair.second).getFullPackage().getId());
                a2.c = ((UpdatePackage) pair.second).getChannel();
                if (!TextUtils.isEmpty(((UpdatePackage) pair.second).getAccessKey())) {
                    a2.a = ((UpdatePackage) pair.second).getAccessKey();
                }
                if (!TextUtils.isEmpty(((UpdatePackage) pair.second).getGroupName())) {
                    a2.b = ((UpdatePackage) pair.second).getGroupName();
                }
            }

            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
                super.b(bVar, dVar);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(g.class)).second).getChannel());
                a2.B = true;
                a2.y = SystemClock.uptimeMillis();
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                Pair pair = (Pair) bVar.b(g.class);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.f).a(((UpdatePackage) pair.second).getChannel());
                String uri = ((Uri) pair.first).toString();
                a2.B = false;
                a2.y = SystemClock.uptimeMillis();
                a2.w.add(new StatisticModel.PackageStatisticModel.DownloadFailRecords(uri, th.getMessage()));
            }
        };
    }

    public static a b(final Context context) {
        return new a() {
            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
                super.a(bVar, dVar);
                Pair pair = (Pair) bVar.b(com.bykv.vk.openvk.preload.geckox.d.h.class);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.f).a(((UpdatePackage) pair.second).getChannel());
                a2.d = ((Uri) pair.first).toString();
                a2.p = h.a(context);
                a2.f = SystemClock.uptimeMillis();
                a2.q = Long.valueOf(((UpdatePackage) pair.second).getPatch().getId());
                a2.r = Long.valueOf(((UpdatePackage) pair.second).getFullPackage().getId());
                a2.c = ((UpdatePackage) pair.second).getChannel();
            }

            public final <T> void b(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar) {
                super.b(bVar, dVar);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.f).a(((UpdatePackage) ((Pair) bVar.b(com.bykv.vk.openvk.preload.geckox.d.h.class)).second).getChannel());
                a2.h = true;
                a2.g = SystemClock.uptimeMillis();
            }

            public final <T> void a(com.bykv.vk.openvk.preload.b.b<T> bVar, d dVar, Throwable th) {
                super.a(bVar, dVar, th);
                Pair pair = (Pair) bVar.b(com.bykv.vk.openvk.preload.geckox.d.h.class);
                com.bykv.vk.openvk.preload.geckox.statistic.model.a a2 = a.a(dVar.f).a(((UpdatePackage) pair.second).getChannel());
                String uri = ((Uri) pair.first).toString();
                a2.h = false;
                a2.g = SystemClock.uptimeMillis();
                a2.e.add(new StatisticModel.PackageStatisticModel.DownloadFailRecords(uri, th.getMessage()));
            }
        };
    }
}
