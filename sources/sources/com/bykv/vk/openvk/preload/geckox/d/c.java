package com.bykv.vk.openvk.preload.geckox.d;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.text.TextUtils;
import android.util.Pair;
import com.bykv.vk.openvk.preload.a.f;
import com.bykv.vk.openvk.preload.b.d;
import com.bykv.vk.openvk.preload.geckox.model.CheckRequestBodyModel;
import com.bykv.vk.openvk.preload.geckox.model.Common;
import com.bykv.vk.openvk.preload.geckox.model.ComponentModel;
import com.bykv.vk.openvk.preload.geckox.model.UpdatePackage;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bykv.vk.openvk.preload.geckox.utils.e;
import com.bykv.vk.openvk.preload.geckox.utils.h;
import java.io.File;
import java.io.FileFilter;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: GetServerChannelVersionInterceptorMulti */
public class c extends d<Map<String, List<Pair<String, Long>>>, List<UpdatePackage>> {
    private com.bykv.vk.openvk.preload.geckox.b g;
    private Map<String, Map<String, Object>> h;
    private Map<String, List<CheckRequestBodyModel.TargetChannel>> i;
    private com.bykv.vk.openvk.preload.geckox.e.a j;
    private String k;
    private com.bykv.vk.openvk.preload.geckox.statistic.model.b l = new com.bykv.vk.openvk.preload.geckox.statistic.model.b();

    public final void a(Object... objArr) {
        super.a(objArr);
        this.g = objArr[0];
        this.h = objArr[1];
        this.i = objArr[2];
        this.j = objArr[3];
        this.k = objArr[4];
    }

    /* access modifiers changed from: private */
    public Object a(com.bykv.vk.openvk.preload.b.b<List<UpdatePackage>> bVar, Map<String, List<Pair<String, Long>>> map) throws Throwable {
        List<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> list;
        Map<String, List<Pair<String, Long>>> map2 = map;
        char c = 2;
        char c2 = 0;
        char c3 = 1;
        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "start get server channel version[v3]... local channel version:", map2);
        Map<String, List<UpdatePackage>> a2 = a(map2);
        com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.g, this.l);
        for (Map.Entry<String, List<UpdatePackage>> value : a2.entrySet()) {
            Iterator it = ((List) value.getValue()).iterator();
            while (it.hasNext()) {
                UpdatePackage updatePackage = (UpdatePackage) it.next();
                long localVersion = updatePackage.getLocalVersion();
                long version = updatePackage.getVersion();
                if (version < localVersion) {
                    Object[] objArr = new Object[5];
                    objArr[c2] = updatePackage.getChannel();
                    objArr[c3] = "rollback：";
                    objArr[c] = Long.valueOf(localVersion);
                    objArr[3] = "->";
                    objArr[4] = Long.valueOf(version);
                    com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", objArr);
                    File[] listFiles = new File(this.g.p, updatePackage.getAccessKey() + File.separator + updatePackage.getChannel()).listFiles(new FileFilter() {
                        public final boolean accept(File file) {
                            return file.isDirectory();
                        }
                    });
                    if (listFiles == null || listFiles.length == 0) {
                        c = 2;
                        c3 = 1;
                        c2 = 0;
                    } else {
                        int length = listFiles.length;
                        int i2 = 0;
                        while (i2 < length) {
                            File file = listFiles[i2];
                            try {
                                long parseLong = Long.parseLong(file.getName());
                                if (parseLong > version) {
                                    final File file2 = new File(file.getParent(), file.getName() + "--pending-delete");
                                    file.renameTo(file2);
                                    e.a().execute(new Runnable() {
                                        public final void run() {
                                            com.bykv.vk.openvk.preload.geckox.utils.c.a(file2);
                                        }
                                    });
                                } else if (parseLong == version) {
                                    it.remove();
                                }
                            } catch (Exception unused) {
                            }
                            i2++;
                            c = 2;
                            c3 = 1;
                            c2 = 0;
                        }
                    }
                }
            }
        }
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<UpdatePackage>> value2 : a2.entrySet()) {
            arrayList.addAll((Collection) value2.getValue());
        }
        Object obj = null;
        try {
            list = c(arrayList);
            try {
                obj = bVar.a(arrayList);
                b(list);
                com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
            } catch (Throwable th) {
                th = th;
                try {
                    com.bykv.vk.openvk.preload.geckox.h.b.b("gecko-debug-tag", "filterChannel:", th);
                    b(list);
                    com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                    a((List<UpdatePackage>) arrayList);
                    return obj;
                } catch (Throwable th2) {
                    b(list);
                    com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            list = null;
            com.bykv.vk.openvk.preload.geckox.h.b.b("gecko-debug-tag", "filterChannel:", th);
            b(list);
            com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "all channel update finished");
            a((List<UpdatePackage>) arrayList);
            return obj;
        }
        a((List<UpdatePackage>) arrayList);
        return obj;
    }

    private void a(List<UpdatePackage> list) {
        if (!list.isEmpty()) {
            for (UpdatePackage next : list) {
                com.bykv.vk.openvk.preload.geckox.a.c.a(new File(new File(this.g.p, next.getAccessKey()), next.getChannel()).getAbsolutePath());
            }
        }
    }

    private static void b(List<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> list) {
        if (list != null) {
            for (Pair pair : list) {
                try {
                    ((com.bykv.vk.openvk.preload.geckox.g.a) pair.second).a();
                } catch (Exception e) {
                    com.bykv.vk.openvk.preload.geckox.h.b.b("gecko-debug-tag", "releaseLock:", e);
                }
            }
        }
    }

    private List<Pair<String, com.bykv.vk.openvk.preload.geckox.g.a>> c(List<UpdatePackage> list) {
        if (list.isEmpty()) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (UpdatePackage next : list) {
            try {
                File file = new File(new File(this.g.p, next.getAccessKey()), next.getChannel());
                if (file.isFile()) {
                    com.bykv.vk.openvk.preload.geckox.utils.c.a(file);
                }
                if (!file.mkdirs()) {
                    if (!file.isDirectory()) {
                        com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "can not create channel dir：", file.getAbsolutePath());
                        throw new RuntimeException("can not create channel dir:" + file.getAbsolutePath());
                    }
                }
                com.bykv.vk.openvk.preload.geckox.g.a a2 = com.bykv.vk.openvk.preload.geckox.g.a.a(file.getAbsolutePath() + File.separator + "update.lock");
                if (a2 != null) {
                    arrayList.add(new Pair(next.getChannel(), a2));
                    arrayList2.add(next);
                } else {
                    com.bykv.vk.openvk.preload.geckox.e.a aVar = this.j;
                    next.getChannel();
                }
            } catch (Exception e) {
                com.bykv.vk.openvk.preload.geckox.h.b.b("gecko-debug-tag", "filterChannel:", e);
                next.getChannel();
                com.bykv.vk.openvk.preload.geckox.e.a aVar2 = this.j;
            }
        }
        list.clear();
        list.addAll(arrayList2);
        return arrayList;
    }

    private Map<String, List<UpdatePackage>> a(Map<String, List<Pair<String, Long>>> map) throws Exception {
        Object obj;
        String b2 = b(map);
        String str = "https://" + this.g.m + "/gecko/server/v3/package";
        try {
            this.l.f = h.a(this.g.a);
            Response doPost = this.g.f.doPost(str, b2);
            this.l.g = doPost.code;
            this.l.d = doPost.msg;
            com.bykv.vk.openvk.preload.geckox.statistic.model.b bVar = this.l;
            Map<String, String> map2 = doPost.headers;
            String str2 = "";
            if (map2 != null) {
                if (!map2.isEmpty()) {
                    String str3 = map2.get("x-tt-logid");
                    if (TextUtils.isEmpty(str3)) {
                        str3 = map2.get("X-Tt-Logid");
                        if (TextUtils.isEmpty(str3)) {
                            String str4 = map2.get("X-TT-LOGID");
                            if (!TextUtils.isEmpty(str4)) {
                                str2 = str4;
                            }
                        }
                    }
                    str2 = str3;
                }
            }
            bVar.e = str2;
            if (doPost.code == 200) {
                String str5 = doPost.body;
                com.bykv.vk.openvk.preload.geckox.h.b.a("gecko-debug-tag", "response:", str5);
                try {
                    Type type = new com.bykv.vk.openvk.preload.a.c.a<com.bykv.vk.openvk.preload.geckox.model.Response<ComponentModel>>() {
                    }.c;
                    f fVar = com.bykv.vk.openvk.preload.geckox.c.b.a().a;
                    if (str5 == null) {
                        obj = null;
                    } else {
                        com.bykv.vk.openvk.preload.a.d.a aVar = new com.bykv.vk.openvk.preload.a.d.a(new StringReader(str5));
                        aVar.a = fVar.j;
                        obj = fVar.a(aVar, type);
                        f.a(obj, aVar);
                    }
                    com.bykv.vk.openvk.preload.geckox.model.Response response = (com.bykv.vk.openvk.preload.geckox.model.Response) obj;
                    if (response.status == 0) {
                        if (response.data != null) {
                            com.bykv.vk.openvk.preload.geckox.a.a.a(this.g.a, ((ComponentModel) response.data).getUniversalStrategies(), this.g.p, this.j);
                            Map<String, List<UpdatePackage>> packages = ((ComponentModel) response.data).getPackages();
                            if (packages == null || packages.isEmpty()) {
                                com.bykv.vk.openvk.preload.geckox.a.a.a(this.g);
                                return new HashMap();
                            }
                            for (String next : this.g.g) {
                                List<UpdatePackage> list = packages.get(next);
                                if (list != null && !list.isEmpty()) {
                                    for (UpdatePackage updatePackage : list) {
                                        updatePackage.setAccessKey(next);
                                        updatePackage.setLocalVersion(a(map.get(next), updatePackage.getChannel()));
                                    }
                                }
                            }
                            return packages;
                        }
                        this.l.d = "check update error：response.data==null";
                        com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.g, this.l);
                        throw new a("check update error：response.data==null");
                    } else if (response.status == 2000) {
                        com.bykv.vk.openvk.preload.geckox.a.a.a(this.g);
                        return new HashMap();
                    } else {
                        String str6 = "check update error，unknow status code，response.status：" + response.status;
                        this.l.d = str6;
                        com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.g, this.l);
                        throw new a(str6);
                    }
                } catch (Throwable th) {
                    this.l.d = "json parse failed：" + th.getMessage();
                    com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.g, this.l);
                    throw new b("json parse failed：" + str5 + " caused by:" + th.getMessage(), th);
                }
            } else {
                throw new NetworkErrorException("net work get failed, code: " + doPost.code + ", url:" + str);
            }
        } catch (Exception e) {
            com.bykv.vk.openvk.preload.geckox.statistic.c.a(this.g, this.l);
            throw new C0041c("request failed：url:" + str + ", caused by:" + e.getMessage(), e);
        }
    }

    private static long a(List<Pair<String, Long>> list, String str) {
        for (Pair next : list) {
            if (((String) next.first).equals(str)) {
                return ((Long) next.second).longValue();
            }
        }
        return 0;
    }

    private String b(Map<String, List<Pair<String, Long>>> map) {
        List list;
        CheckRequestBodyModel checkRequestBodyModel = new CheckRequestBodyModel();
        Context context = this.g.a;
        checkRequestBodyModel.setCommon(new Common(this.g.j.longValue(), this.g.k, this.g.l, com.bykv.vk.openvk.preload.geckox.utils.a.b(context), h.a(context), this.g.o, this.g.n));
        HashMap hashMap = new HashMap();
        for (Map.Entry next : map.entrySet()) {
            HashMap hashMap2 = new HashMap();
            for (Pair pair : (List) next.getValue()) {
                CheckRequestBodyModel.LocalChannel localChannel = new CheckRequestBodyModel.LocalChannel();
                localChannel.localVersion = (Long) pair.second;
                hashMap2.put(pair.first, localChannel);
            }
            hashMap.put(next.getKey(), hashMap2);
        }
        try {
            f fVar = com.bykv.vk.openvk.preload.geckox.c.b.a().a;
            this.l.a = fVar.a((Object) hashMap);
            checkRequestBodyModel.setLocal(hashMap);
            HashMap hashMap3 = new HashMap();
            for (String next2 : this.g.g) {
                CheckRequestBodyModel.Group group = new CheckRequestBodyModel.Group();
                group.groupName = this.k;
                Map<String, List<CheckRequestBodyModel.TargetChannel>> map2 = this.i;
                if (map2 != null && !map2.isEmpty() && (list = this.i.get(next2)) != null && !list.isEmpty()) {
                    group.targetChannels = new ArrayList();
                    group.targetChannels.addAll(list);
                }
                hashMap3.put(next2, group);
            }
            this.l.b = fVar.a((Object) hashMap3);
            checkRequestBodyModel.setDeployments(hashMap3);
            Map<String, Map<String, Object>> map3 = this.h;
            if (map3 != null) {
                this.l.c = fVar.a((Object) map3);
                checkRequestBodyModel.setCustom(this.h);
            }
            return fVar.a((Object) checkRequestBodyModel);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: com.bykv.vk.openvk.preload.geckox.d.c$c  reason: collision with other inner class name */
    /* compiled from: GetServerChannelVersionInterceptorMulti */
    public static class C0041c extends RuntimeException {
        C0041c(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: GetServerChannelVersionInterceptorMulti */
    public static class b extends RuntimeException {
        b(String str, Throwable th) {
            super(str, th);
        }
    }

    /* compiled from: GetServerChannelVersionInterceptorMulti */
    public static class a extends RuntimeException {
        a(String str) {
            super(str);
        }
    }
}
