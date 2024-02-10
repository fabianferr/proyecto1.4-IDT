package com.bykv.vk.openvk.preload.geckox.a;

import android.accounts.NetworkErrorException;
import android.content.Context;
import android.os.SystemClock;
import com.bykv.vk.openvk.preload.geckox.h.b;
import com.bykv.vk.openvk.preload.geckox.model.Common;
import com.bykv.vk.openvk.preload.geckox.model.ComponentModel;
import com.bykv.vk.openvk.preload.geckox.net.Response;
import com.bykv.vk.openvk.preload.geckox.statistic.model.StatisticModel;
import com.bykv.vk.openvk.preload.geckox.utils.c;
import com.bykv.vk.openvk.preload.geckox.utils.e;
import com.bykv.vk.openvk.preload.geckox.utils.h;
import com.bykv.vk.openvk.preload.geckox.utils.j;
import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: AbandonChannelClenUtils */
public final class a {
    public static void a(Context context, Map<String, ComponentModel.b> map, File file, com.bykv.vk.openvk.preload.geckox.e.a aVar) {
        final ArrayList arrayList;
        ComponentModel.b bVar;
        Iterator<Map.Entry<String, ComponentModel.b>> it;
        Iterator<ComponentModel.a> it2;
        File file2;
        List<Long> b;
        Iterator<Long> it3;
        File file3;
        List<Long> b2;
        Iterator<Map.Entry<String, ComponentModel.b>> it4;
        Iterator<ComponentModel.a> it5;
        File file4;
        File file5;
        List<Long> list;
        String str;
        if (map != null && !map.isEmpty()) {
            try {
                arrayList = new ArrayList();
                Iterator<Map.Entry<String, ComponentModel.b>> it6 = map.entrySet().iterator();
                while (it6.hasNext()) {
                    Map.Entry next = it6.next();
                    String str2 = (String) next.getKey();
                    File file6 = new File(file, str2);
                    if (file6.isDirectory() && (bVar = (ComponentModel.b) next.getValue()) != null && bVar.a != null && !bVar.a.isEmpty()) {
                        List<ComponentModel.a> list2 = bVar.a;
                        HashSet hashSet = new HashSet();
                        Iterator<ComponentModel.a> it7 = list2.iterator();
                        while (it7.hasNext()) {
                            ComponentModel.a next2 = it7.next();
                            String str3 = next2.a;
                            if (!hashSet.contains(str3)) {
                                hashSet.add(str3);
                                int i = next2.b;
                                List<Long> list3 = next2.c;
                                File file7 = new File(file6, str3);
                                String str4 = "--pending-delete";
                                if (i != 1) {
                                    if (i != 2) {
                                        if (i == 3) {
                                            File file8 = new File(file6, str3);
                                            File file9 = new File(file6, str3 + str4);
                                            file8.renameTo(file9);
                                            C0039a aVar2 = r4;
                                            C0039a aVar3 = new C0039a(str2, str3, i, 0, file9);
                                            arrayList.add(aVar2);
                                        }
                                    } else if (!(list3 == null || (b2 = j.b(file7)) == null || b2.isEmpty())) {
                                        for (Long next3 : b2) {
                                            if (list3.get(0).longValue() > next3.longValue()) {
                                                File file10 = new File(file7, next3 + str4);
                                                new File(file7, String.valueOf(next3)).renameTo(file10);
                                                it4 = it6;
                                                C0039a aVar4 = r4;
                                                it5 = it7;
                                                file4 = file7;
                                                str = str4;
                                                long longValue = next3.longValue();
                                                file5 = file6;
                                                list = list3;
                                                C0039a aVar5 = new C0039a(str2, str3, i, longValue, file10);
                                                arrayList.add(aVar4);
                                            } else {
                                                it4 = it6;
                                                it5 = it7;
                                                file4 = file7;
                                                str = str4;
                                                file5 = file6;
                                                list = list3;
                                            }
                                            it6 = it4;
                                            str4 = str;
                                            list3 = list;
                                            file6 = file5;
                                            file7 = file4;
                                            it7 = it5;
                                        }
                                    }
                                    it = it6;
                                    it2 = it7;
                                    file2 = file6;
                                } else {
                                    it = it6;
                                    it2 = it7;
                                    File file11 = file7;
                                    String str5 = str4;
                                    file2 = file6;
                                    List<Long> list4 = list3;
                                    if (!(list4 == null || (b = j.b(file11)) == null || b.isEmpty())) {
                                        Iterator<Long> it8 = b.iterator();
                                        while (it8.hasNext()) {
                                            Long next4 = it8.next();
                                            if (list4.contains(next4)) {
                                                File file12 = file11;
                                                File file13 = new File(file12, next4 + str5);
                                                new File(file12, String.valueOf(next4)).renameTo(file13);
                                                it3 = it8;
                                                file3 = file12;
                                                C0039a aVar6 = r4;
                                                C0039a aVar7 = new C0039a(str2, str3, i, next4.longValue(), file13);
                                                arrayList.add(aVar6);
                                            } else {
                                                file3 = file11;
                                                it3 = it8;
                                            }
                                            it8 = it3;
                                            file11 = file3;
                                        }
                                    }
                                }
                                it6 = it;
                                file6 = file2;
                                it7 = it2;
                            }
                        }
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                arrayList = null;
            }
            if (arrayList != null) {
                final Context context2 = context;
                final com.bykv.vk.openvk.preload.geckox.e.a aVar8 = aVar;
                e.a().execute(new Runnable() {
                    public final void run() {
                        try {
                            Context context = context2;
                            List<C0039a> list = arrayList;
                            if (list == null) {
                                return;
                            }
                            if (!list.isEmpty()) {
                                for (C0039a aVar : list) {
                                    File file = aVar.e;
                                    long uptimeMillis = SystemClock.uptimeMillis();
                                    boolean a2 = c.a(file);
                                    long uptimeMillis2 = SystemClock.uptimeMillis();
                                    if (a2) {
                                        b.a(context).a(aVar.a, aVar.b, aVar.c, 200, aVar.d, 0, (String) null, uptimeMillis2 - uptimeMillis);
                                    } else {
                                        b a3 = b.a(context);
                                        String str = aVar.a;
                                        String str2 = aVar.b;
                                        a3.a(str, str2, aVar.c, 201, aVar.d, 601, "delete failed", uptimeMillis2 - uptimeMillis);
                                    }
                                }
                            }
                        } catch (Exception e) {
                            b.a("clean-channel", "", e);
                        }
                    }
                });
            }
        }
    }

    /* renamed from: com.bykv.vk.openvk.preload.geckox.a.a$a  reason: collision with other inner class name */
    /* compiled from: AbandonChannelClenUtils */
    static class C0039a {
        String a;
        String b;
        int c;
        long d;
        File e;

        C0039a(String str, String str2, int i, long j, File file) {
            this.a = str;
            this.b = str2;
            this.c = i;
            this.d = j;
            this.e = file;
        }
    }

    public static void a(com.bykv.vk.openvk.preload.geckox.b bVar) {
        if (bVar.q) {
            Common common = new Common(bVar.j.longValue(), bVar.k, bVar.l, com.bykv.vk.openvk.preload.geckox.utils.a.b(bVar.a), h.a(bVar.a), bVar.o, bVar.n);
            StatisticModel statisticModel = new StatisticModel();
            statisticModel.common = common;
            statisticModel.packages.addAll(b.a(bVar.a).a());
            if (!statisticModel.packages.isEmpty()) {
                String str = "https://" + bVar.m + "/gecko/server/packages/stats";
                try {
                    Response doPost = bVar.f.doPost(str, com.bykv.vk.openvk.preload.geckox.c.b.a().a.a((Object) statisticModel));
                    if (doPost.code != 200) {
                        throw new NetworkErrorException("net work get failed, code: " + doPost.code + ", url:" + str);
                    } else if (new JSONObject(doPost.body).getInt("status") != 0) {
                        throw new RuntimeException("upload failed");
                    }
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
        }
    }
}
