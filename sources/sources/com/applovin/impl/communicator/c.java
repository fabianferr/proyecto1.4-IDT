package com.applovin.impl.communicator;

import java.util.ArrayList;
import java.util.List;

public class c {
    public static final List<String> a;

    static {
        ArrayList arrayList = new ArrayList();
        a = arrayList;
        arrayList.add("send_http_request");
        arrayList.add("send_http_request_v2");
        arrayList.add("set_ad_request_query_params");
        arrayList.add("set_ad_request_post_body");
        arrayList.add("set_mediate_request_post_body_data");
    }
}
