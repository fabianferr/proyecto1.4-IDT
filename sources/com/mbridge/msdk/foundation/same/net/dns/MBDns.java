package com.mbridge.msdk.foundation.same.net.dns;

import android.text.TextUtils;
import com.mbridge.msdk.c.c;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.thrid.okhttp.Dns;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MBDns implements Dns {
    private static String TAG = "MBDns";

    public List<InetAddress> lookup(String str) throws UnknownHostException {
        String str2 = TAG;
        aa.a(str2, "host:" + str);
        String str3 = TAG;
        aa.a(str3, "host str:" + Arrays.toString(InetAddress.getAllByName(str)));
        try {
            String b = c.a().b(str);
            if (!TextUtils.isEmpty(b)) {
                ArrayList arrayList = new ArrayList(Arrays.asList(InetAddress.getAllByName(b)));
                String str4 = TAG;
                aa.a(str4, "ip:" + b);
                return arrayList;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Dns.SYSTEM.lookup(str);
    }
}
