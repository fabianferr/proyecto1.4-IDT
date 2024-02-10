package com.google.android.exoplayer2.util;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;

public final class BundleableUtils {
    public static Bundle toNullableBundle(Bundleable bundleable) {
        if (bundleable == null) {
            return null;
        }
        return bundleable.toBundle();
    }

    public static <T extends Bundleable> T fromNullableBundle(Bundleable.Creator<T> creator, Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        return creator.fromBundle(bundle);
    }

    public static <T extends Bundleable> T fromNullableBundle(Bundleable.Creator<T> creator, Bundle bundle, T t) {
        return bundle == null ? t : creator.fromBundle(bundle);
    }

    public static <T extends Bundleable> ImmutableList<Bundle> toBundleList(List<T> list) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            builder.add((Object) ((Bundleable) list.get(i)).toBundle());
        }
        return builder.build();
    }

    public static <T extends Bundleable> ImmutableList<T> fromBundleList(Bundleable.Creator<T> creator, List<Bundle> list) {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            builder.add((Object) creator.fromBundle(list.get(i)));
        }
        return builder.build();
    }

    public static <T extends Bundleable> ArrayList<Bundle> toBundleArrayList(List<T> list) {
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            arrayList.add(((Bundleable) list.get(i)).toBundle());
        }
        return arrayList;
    }

    private BundleableUtils() {
    }
}
