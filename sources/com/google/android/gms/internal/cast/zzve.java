package com.google.android.gms.internal.cast;

/* compiled from: com.google.android.gms:play-services-cast@@21.3.0 */
final class zzve extends IllegalArgumentException {
    zzve(int i, int i2) {
        super("Unpaired surrogate at index " + i + " of " + i2);
    }
}
