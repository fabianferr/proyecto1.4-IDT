package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import com.startapp.d9;
import com.startapp.e9;
import com.startapp.k9;
import com.startapp.sdk.common.utils.Pair;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.json.JSONObject;

/* compiled from: Sta */
public class RcdTargets implements Serializable {
    private static final long serialVersionUID = 6963217195144137950L;
    @d9
    private final SortedMap<String, Pair<Integer, String>> nameToScopesIds;
    @d9
    private final SortedMap<Integer, SortedMap<String, String>> scopeToNamesIds;

    /* compiled from: Sta */
    public static class Parser implements e9<RcdTargets> {
        private static void add(String str, String str2, int i, SortedMap<String, Pair<Integer, String>> sortedMap, SortedMap<Integer, SortedMap<String, String>> sortedMap2) {
            if (str2.length() >= 1) {
                String replaceAll = str2.replaceAll("~", ".");
                sortedMap.put(replaceAll, new Pair(Integer.valueOf(i), str));
                for (int i2 = 0; i2 < 16; i2++) {
                    int i3 = 1 << i2;
                    if ((i & i3) == i3) {
                        SortedMap sortedMap3 = (SortedMap) sortedMap2.get(Integer.valueOf(i3));
                        if (sortedMap3 == null) {
                            sortedMap3 = new TreeMap();
                            sortedMap2.put(Integer.valueOf(i3), sortedMap3);
                        }
                        sortedMap3.put(replaceAll, str);
                    }
                }
            }
        }

        public static void parseRec(String str, String str2, JSONObject jSONObject, SortedMap<String, Pair<Integer, String>> sortedMap, SortedMap<Integer, SortedMap<String, String>> sortedMap2) {
            if (jSONObject != null) {
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    if (next.equals("~")) {
                        add(str, str2, jSONObject.optInt(next), sortedMap, sortedMap2);
                    } else if (next.endsWith("~") && (jSONObject.opt(next) instanceof JSONObject)) {
                        parseRec(str, str2 + next, jSONObject.optJSONObject(next), sortedMap, sortedMap2);
                    } else if (next.length() > 0) {
                        add(str, str2 + next, jSONObject.optInt(next), sortedMap, sortedMap2);
                    }
                }
            }
        }

        public RcdTargets parse(Class<RcdTargets> cls, Object obj) {
            if (!(obj instanceof JSONObject)) {
                return null;
            }
            JSONObject jSONObject = (JSONObject) obj;
            TreeMap treeMap = new TreeMap();
            TreeMap treeMap2 = new TreeMap();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                parseRec(next, "", jSONObject.optJSONObject(next), treeMap, treeMap2);
            }
            return new RcdTargets(treeMap, treeMap2);
        }
    }

    public RcdTargets(SortedMap<String, Pair<Integer, String>> sortedMap, SortedMap<Integer, SortedMap<String, String>> sortedMap2) {
        this.nameToScopesIds = sortedMap;
        this.scopeToNamesIds = sortedMap2;
    }

    public Collection<String> a(int i) {
        SortedMap sortedMap = (SortedMap) this.scopeToNamesIds.get(Integer.valueOf(i));
        return sortedMap != null ? Collections.unmodifiableCollection(sortedMap.keySet()) : Collections.emptyList();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        RcdTargets rcdTargets = (RcdTargets) obj;
        if (!k9.a(this.nameToScopesIds, rcdTargets.nameToScopesIds) || !k9.a(this.scopeToNamesIds, rcdTargets.scopeToNamesIds)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        Object[] objArr = {this.nameToScopesIds, this.scopeToNamesIds};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }

    public String a(Map<String, Integer> map) {
        Pair pair;
        TreeMap treeMap = new TreeMap();
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Integer num = (Integer) next.getValue();
            if (!(str == null || num == null || (pair = (Pair) this.nameToScopesIds.get(str)) == null)) {
                String str2 = (String) pair.second;
                Integer num2 = (Integer) treeMap.get(str2);
                if (num2 == null) {
                    num2 = 0;
                }
                treeMap.put(str2, Integer.valueOf(num.intValue() | num2.intValue()));
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry entry : treeMap.entrySet()) {
            sb.append(AbstractJsonLexerKt.COLON);
            sb.append((String) entry.getKey());
            sb.append(AbstractJsonLexerKt.COLON);
            int intValue = ((Integer) entry.getValue()).intValue();
            int i = 1;
            boolean z = (57344 & intValue) != 0;
            boolean z2 = (intValue & 7680) != 0;
            if (z && z2) {
                i = 6;
            } else if (z) {
                i = 5;
            } else if (z2) {
                i = 4;
            } else if ((intValue & 256) != 0) {
                i = 3;
            } else if ((intValue & 172) != 0) {
                i = 2;
            } else if ((intValue & 83) == 0) {
                i = 0;
            }
            sb.append(i);
        }
        if (sb.length() > 0) {
            sb.append(AbstractJsonLexerKt.COLON);
        }
        return sb.toString();
    }
}
