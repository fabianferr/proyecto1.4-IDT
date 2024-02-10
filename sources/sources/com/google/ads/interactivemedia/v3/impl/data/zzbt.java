package com.google.ads.interactivemedia.v3.impl.data;

import com.google.ads.interactivemedia.v3.api.UiElement;
import com.google.ads.interactivemedia.v3.internal.zzxi;
import java.util.Arrays;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public final class zzbt implements UiElement {
    public static final zzxi<zzbt> GSON_TYPE_ADAPTER = new zzbs();
    private final String name;

    public zzbt(String str) {
        this.name = str;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof zzbt)) {
            return this.name.equals(((zzbt) obj).name);
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.name});
    }

    public String toString() {
        String str = this.name;
        return "UiElementImpl[name=" + str + "]";
    }
}
