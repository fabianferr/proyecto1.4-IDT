package com.google.android.gms.common.data;

/* compiled from: com.google.android.gms:play-services-base@@18.2.0 */
public interface Freezable<T> {
    T freeze();

    boolean isDataValid();
}