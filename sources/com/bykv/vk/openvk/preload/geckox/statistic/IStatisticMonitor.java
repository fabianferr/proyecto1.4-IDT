package com.bykv.vk.openvk.preload.geckox.statistic;

import org.json.JSONObject;

public interface IStatisticMonitor {
    void upload(String str, JSONObject jSONObject);
}
