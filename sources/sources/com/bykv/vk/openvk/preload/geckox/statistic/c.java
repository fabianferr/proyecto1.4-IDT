package com.bykv.vk.openvk.preload.geckox.statistic;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bykv.vk.openvk.preload.geckox.b;
import com.bykv.vk.openvk.preload.geckox.model.Common;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bykv.vk.openvk.preload.geckox.statistic.model.StatisticModel;
import com.bykv.vk.openvk.preload.geckox.statistic.model.a;
import com.bykv.vk.openvk.preload.geckox.utils.h;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.umlaut.crowd.internal.v3;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.json.JSONObject;

/* compiled from: UploadStatistic */
public final class c {
    public static void a(b bVar, a aVar) {
        StatisticModel b = b(bVar, aVar);
        if (b != null && b.packages != null) {
            IStatisticMonitor iStatisticMonitor = bVar.e;
            if (iStatisticMonitor != null) {
                try {
                    for (StatisticModel.PackageStatisticModel a : b.packages) {
                        iStatisticMonitor.upload("geckosdk_update_stats", a(a, b.common));
                    }
                } catch (Throwable th) {
                    com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "UploadStatistic.upload:", th);
                }
            }
            if (bVar.q) {
                try {
                    String a2 = com.bykv.vk.openvk.preload.geckox.c.b.a().a.a((Object) b);
                    if (!TextUtils.isEmpty(a2)) {
                        a(bVar, a2);
                    }
                } catch (Throwable unused) {
                }
            }
        }
    }

    private static void a(final b bVar, final String str) {
        final String str2 = "https://" + bVar.m + "/gecko/server/packages/stats";
        bVar.b.execute(new Runnable() {
            public final void run() {
                int i = 0;
                while (i < 3) {
                    try {
                        Response doPost = bVar.f.doPost(str2, str);
                        if (doPost.code != 200) {
                            throw new NetworkErrorException("net work get failed, code: " + doPost.code + ", url:" + str2);
                        } else if (new JSONObject(doPost.body).getInt("status") != 0) {
                            i++;
                        } else {
                            return;
                        }
                    } catch (Exception e) {
                        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "upload statistic:", e);
                    }
                }
            }
        });
    }

    private static JSONObject a(StatisticModel.PackageStatisticModel packageStatisticModel, Common common) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("params_for_special", "gecko");
        jSONObject.put("region", common.region);
        jSONObject.put("err_code", packageStatisticModel.errCode);
        jSONObject.put("err_msg", packageStatisticModel.errMsg);
        jSONObject.put("sdk_version", common.sdkVersion);
        jSONObject.put("access_key", packageStatisticModel.accessKey);
        jSONObject.put("stats_type", packageStatisticModel.statsType);
        jSONObject.put("device_id", common.deviceId);
        long j = 0;
        jSONObject.put("patch_id", packageStatisticModel.patchId == null ? 0 : packageStatisticModel.patchId.longValue());
        jSONObject.put("group_name", packageStatisticModel.groupName);
        jSONObject.put("os", common.os);
        jSONObject.put("app_version", common.appVersion);
        jSONObject.put("device_model", common.deviceModel);
        jSONObject.put("channel", packageStatisticModel.channel);
        jSONObject.put("id", packageStatisticModel.id == null ? 0 : packageStatisticModel.id.longValue());
        jSONObject.put("ac", common.ac);
        jSONObject.put("download_retry_times", packageStatisticModel.downloadRetryTimes == null ? 0 : packageStatisticModel.downloadRetryTimes.intValue());
        Object obj = "";
        jSONObject.put(DownloadModel.DOWNLOAD_URL, packageStatisticModel.downloadUrl == null ? obj : packageStatisticModel.downloadUrl);
        jSONObject.put("download_duration", packageStatisticModel.downloadDuration);
        if (packageStatisticModel.downloadFailRecords != null) {
            obj = packageStatisticModel.downloadFailRecords;
        }
        jSONObject.put("download_fail_records", obj);
        jSONObject.put("log_id", packageStatisticModel.logId);
        jSONObject.put("active_check_duration", packageStatisticModel.activeCheckDuration == null ? 0 : packageStatisticModel.activeCheckDuration.longValue());
        if (packageStatisticModel.applyDuration != null) {
            j = packageStatisticModel.applyDuration.longValue();
        }
        jSONObject.put("apply_duration", j);
        return jSONObject;
    }

    private static JSONObject b(b bVar, com.bykv.vk.openvk.preload.geckox.statistic.model.b bVar2) throws Exception {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("params_for_special", "gecko");
        jSONObject.put("device_id", bVar.l);
        jSONObject.put("os", 0);
        jSONObject.put("app_version", bVar.k);
        jSONObject.put("api_version", v3.i);
        jSONObject.put("aid", bVar.j.longValue());
        jSONObject.put("x_tt_logid", bVar2.e);
        jSONObject.put("http_status", bVar2.g);
        jSONObject.put("err_msg", bVar2.d);
        if (TextUtils.isEmpty(bVar2.e)) {
            jSONObject.put("deployments_info", bVar2.b);
            jSONObject.put("local_info", bVar2.a);
            jSONObject.put("custom_info", bVar2.c);
        } else {
            jSONObject.put("deployments_info", "");
            jSONObject.put("local_info", "");
            jSONObject.put("custom_info", "");
        }
        StringBuilder sb = new StringBuilder();
        sb.append(Build.VERSION.SDK_INT);
        jSONObject.put("os_version", sb.toString());
        jSONObject.put("device_platform", "android");
        jSONObject.put("device_model", Build.MODEL);
        jSONObject.put("ac", bVar2.f);
        return jSONObject;
    }

    private static StatisticModel b(b bVar, a aVar) {
        ArrayList<StatisticModel.PackageStatisticModel> arrayList = new ArrayList<>();
        for (a next : aVar.a()) {
            if (!(next.d == null && next.f == 0)) {
                if (!next.h || !next.i) {
                    StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
                    arrayList.add(packageStatisticModel);
                    packageStatisticModel.statsType = 101;
                    packageStatisticModel.accessKey = next.a;
                    packageStatisticModel.groupName = next.b;
                    packageStatisticModel.channel = next.c;
                    packageStatisticModel.ac = next.p;
                    packageStatisticModel.patchId = next.q;
                    packageStatisticModel.id = next.r;
                    packageStatisticModel.downloadRetryTimes = a(next.e);
                    packageStatisticModel.downloadUrl = next.d;
                    packageStatisticModel.downloadFailRecords = b(next.e);
                    if (!next.h) {
                        packageStatisticModel.errCode = "301";
                        if (next.e != null && !next.e.isEmpty()) {
                            packageStatisticModel.errMsg = next.e.get(0).reason;
                        }
                    } else if (!next.i) {
                        packageStatisticModel.errCode = "402";
                        packageStatisticModel.errMsg = next.s;
                    }
                    a(next, (List<StatisticModel.PackageStatisticModel>) arrayList);
                } else {
                    StatisticModel.PackageStatisticModel packageStatisticModel2 = new StatisticModel.PackageStatisticModel();
                    arrayList.add(packageStatisticModel2);
                    packageStatisticModel2.statsType = 100;
                    packageStatisticModel2.groupName = next.b;
                    packageStatisticModel2.accessKey = next.a;
                    packageStatisticModel2.channel = next.c;
                    packageStatisticModel2.ac = next.p;
                    packageStatisticModel2.id = next.r;
                    packageStatisticModel2.patchId = next.q;
                    packageStatisticModel2.downloadRetryTimes = a(next.e);
                    packageStatisticModel2.downloadUrl = next.d;
                    packageStatisticModel2.downloadFailRecords = b(next.e);
                    packageStatisticModel2.downloadDuration = Long.valueOf(next.g - next.f);
                    if (!next.j) {
                        StatisticModel.PackageStatisticModel packageStatisticModel3 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel3);
                        packageStatisticModel3.statsType = 100;
                        packageStatisticModel3.channel = next.c;
                        packageStatisticModel3.errCode = "403";
                        packageStatisticModel3.errMsg = next.t;
                        packageStatisticModel3.ac = next.p;
                        packageStatisticModel3.patchId = next.q;
                        packageStatisticModel3.id = next.r;
                        packageStatisticModel3.downloadRetryTimes = a(next.e);
                        packageStatisticModel3.downloadUrl = next.d;
                        packageStatisticModel3.downloadFailRecords = b(next.e);
                    } else if (next.k) {
                        StatisticModel.PackageStatisticModel packageStatisticModel4 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel4);
                        packageStatisticModel4.accessKey = next.a;
                        packageStatisticModel4.groupName = next.b;
                        packageStatisticModel4.statsType = 102;
                        packageStatisticModel4.patchId = next.q;
                        packageStatisticModel4.id = next.r;
                        packageStatisticModel4.channel = next.c;
                        packageStatisticModel4.activeCheckDuration = Long.valueOf(next.n - next.g);
                        packageStatisticModel4.applyDuration = Long.valueOf(next.o - next.n);
                    } else {
                        StatisticModel.PackageStatisticModel packageStatisticModel5 = new StatisticModel.PackageStatisticModel();
                        arrayList.add(packageStatisticModel5);
                        packageStatisticModel5.accessKey = next.a;
                        packageStatisticModel5.groupName = next.b;
                        packageStatisticModel5.statsType = 103;
                        packageStatisticModel5.errCode = "501";
                        packageStatisticModel5.channel = next.c;
                        packageStatisticModel5.patchId = next.q;
                        packageStatisticModel5.id = next.r;
                        packageStatisticModel5.errMsg = next.u;
                        a(next, (List<StatisticModel.PackageStatisticModel>) arrayList);
                    }
                }
            }
            a(next, (List<StatisticModel.PackageStatisticModel>) arrayList);
        }
        Context context = bVar.a;
        arrayList.addAll(com.bykv.vk.openvk.preload.geckox.a.b.a(context).a());
        if (arrayList.isEmpty()) {
            return null;
        }
        Common common = new Common(bVar.j.longValue(), bVar.k, bVar.l, com.bykv.vk.openvk.preload.geckox.utils.a.b(context), h.a(context), bVar.o, bVar.n);
        StatisticModel statisticModel = new StatisticModel();
        statisticModel.common = common;
        statisticModel.packages = arrayList;
        String uuid = UUID.randomUUID().toString();
        for (StatisticModel.PackageStatisticModel packageStatisticModel6 : arrayList) {
            packageStatisticModel6.logId = uuid;
        }
        return statisticModel;
    }

    private static Integer a(List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return Integer.valueOf(list.size());
    }

    private static void a(a aVar, List<StatisticModel.PackageStatisticModel> list) {
        if (!aVar.B || !aVar.C) {
            StatisticModel.PackageStatisticModel packageStatisticModel = new StatisticModel.PackageStatisticModel();
            list.add(packageStatisticModel);
            packageStatisticModel.statsType = 1;
            packageStatisticModel.accessKey = aVar.a;
            packageStatisticModel.groupName = aVar.b;
            packageStatisticModel.channel = aVar.c;
            packageStatisticModel.ac = aVar.p;
            packageStatisticModel.id = aVar.r;
            packageStatisticModel.downloadRetryTimes = a(aVar.w);
            packageStatisticModel.downloadUrl = aVar.v;
            packageStatisticModel.downloadFailRecords = b(aVar.w);
            if (!aVar.B) {
                packageStatisticModel.errCode = "300";
                if (aVar.w != null && !aVar.w.isEmpty()) {
                    packageStatisticModel.errMsg = aVar.w.get(0).reason;
                }
            } else if (!aVar.C) {
                packageStatisticModel.errCode = "450";
                packageStatisticModel.errMsg = aVar.E;
            }
        } else {
            StatisticModel.PackageStatisticModel packageStatisticModel2 = new StatisticModel.PackageStatisticModel();
            list.add(packageStatisticModel2);
            packageStatisticModel2.statsType = 0;
            packageStatisticModel2.accessKey = aVar.a;
            packageStatisticModel2.groupName = aVar.b;
            packageStatisticModel2.channel = aVar.c;
            packageStatisticModel2.ac = aVar.p;
            packageStatisticModel2.id = aVar.r;
            packageStatisticModel2.downloadRetryTimes = a(aVar.w);
            packageStatisticModel2.downloadUrl = aVar.v;
            packageStatisticModel2.downloadFailRecords = b(aVar.w);
            packageStatisticModel2.downloadDuration = Long.valueOf(aVar.y - aVar.x);
            if (aVar.D) {
                StatisticModel.PackageStatisticModel packageStatisticModel3 = new StatisticModel.PackageStatisticModel();
                list.add(packageStatisticModel3);
                packageStatisticModel3.accessKey = aVar.a;
                packageStatisticModel3.groupName = aVar.b;
                packageStatisticModel3.statsType = 2;
                packageStatisticModel3.id = aVar.r;
                packageStatisticModel3.channel = aVar.c;
                packageStatisticModel3.activeCheckDuration = Long.valueOf(aVar.z - aVar.y);
                packageStatisticModel3.applyDuration = Long.valueOf(aVar.A - aVar.z);
                return;
            }
            StatisticModel.PackageStatisticModel packageStatisticModel4 = new StatisticModel.PackageStatisticModel();
            list.add(packageStatisticModel4);
            packageStatisticModel4.statsType = 3;
            packageStatisticModel4.accessKey = aVar.a;
            packageStatisticModel4.groupName = aVar.b;
            packageStatisticModel4.errCode = "500";
            packageStatisticModel4.id = aVar.r;
            packageStatisticModel4.channel = aVar.c;
            packageStatisticModel4.errMsg = aVar.F;
        }
    }

    private static List<StatisticModel.PackageStatisticModel.DownloadFailRecords> b(List<StatisticModel.PackageStatisticModel.DownloadFailRecords> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        return list;
    }

    public static void a(b bVar, com.bykv.vk.openvk.preload.geckox.statistic.model.b bVar2) {
        IStatisticMonitor iStatisticMonitor = bVar.e;
        if (iStatisticMonitor != null) {
            try {
                iStatisticMonitor.upload("geckosdk_query_pkgs", b(bVar, bVar2));
            } catch (Throwable th) {
                com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "UploadStatistic.upload:", th);
            }
        }
    }
}
