package com.startapp.sdk.adsbase.remoteconfig;

import android.app.Activity;
import com.startapp.d9;
import com.startapp.k9;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* compiled from: Sta */
public class MetaDataStyle implements Serializable {
    public static final Integer a = 18;
    public static final Integer b = -1;
    public static final Set<String> c = new HashSet(Arrays.asList(new String[]{"BOLD"}));
    public static final Integer d = 14;
    public static final Integer e = -1;
    public static final Set<String> f = new HashSet();
    private static final long serialVersionUID = -8172457405775076403L;
    private Integer itemDescriptionTextColor = e;
    @d9(type = HashSet.class)
    private Set<String> itemDescriptionTextDecoration = f;
    private Integer itemDescriptionTextSize = d;
    private Integer itemGradientBottom = -8750199;
    private Integer itemGradientTop = -14014151;
    private Integer itemTitleTextColor = b;
    @d9(type = HashSet.class)
    private Set<String> itemTitleTextDecoration = c;
    private Integer itemTitleTextSize = a;
    private String name = "";

    public Integer a() {
        return this.itemDescriptionTextColor;
    }

    public Set<String> b() {
        return this.itemDescriptionTextDecoration;
    }

    public Integer c() {
        return this.itemDescriptionTextSize;
    }

    public Integer d() {
        return this.itemGradientBottom;
    }

    public Integer e() {
        return this.itemGradientTop;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MetaDataStyle metaDataStyle = (MetaDataStyle) obj;
        if (!k9.a(this.name, metaDataStyle.name) || !k9.a(this.itemGradientTop, metaDataStyle.itemGradientTop) || !k9.a(this.itemGradientBottom, metaDataStyle.itemGradientBottom) || !k9.a(this.itemTitleTextSize, metaDataStyle.itemTitleTextSize) || !k9.a(this.itemTitleTextColor, metaDataStyle.itemTitleTextColor) || !k9.a(this.itemTitleTextDecoration, metaDataStyle.itemTitleTextDecoration) || !k9.a(this.itemDescriptionTextSize, metaDataStyle.itemDescriptionTextSize) || !k9.a(this.itemDescriptionTextColor, metaDataStyle.itemDescriptionTextColor) || !k9.a(this.itemDescriptionTextDecoration, metaDataStyle.itemDescriptionTextDecoration)) {
            return false;
        }
        return true;
    }

    public Integer f() {
        return this.itemTitleTextColor;
    }

    public Set<String> g() {
        return this.itemTitleTextDecoration;
    }

    public Integer h() {
        return this.itemTitleTextSize;
    }

    public int hashCode() {
        Object[] objArr = {this.name, this.itemGradientTop, this.itemGradientBottom, this.itemTitleTextSize, this.itemTitleTextColor, this.itemTitleTextDecoration, this.itemDescriptionTextSize, this.itemDescriptionTextColor, this.itemDescriptionTextDecoration};
        Map<Activity, Integer> map = k9.a;
        return Arrays.deepHashCode(objArr);
    }
}
