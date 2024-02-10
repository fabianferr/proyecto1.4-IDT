package com.startapp;

import com.startapp.simple.bloomfilter.version.BloomVersion;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Sta */
public class y9 {
    public final Map<BloomVersion, x9> a;

    public y9() {
        HashMap hashMap = new HashMap();
        this.a = hashMap;
        hashMap.put(BloomVersion.ZERO, new ca());
        hashMap.put(BloomVersion.THREE, new ba());
        hashMap.put(BloomVersion.FOUR, new aa());
        hashMap.put(BloomVersion.FIVE, new z9());
    }
}
