package kotlin.reflect.jvm.internal.impl.types.model;

import com.unity3d.services.ads.gmascar.utils.ScarConstants;

/* compiled from: TypeSystemContext.kt */
public enum TypeVariance {
    IN(ScarConstants.IN_SIGNAL_KEY),
    OUT("out"),
    INV("");
    
    private final String presentation;

    private TypeVariance(String str) {
        this.presentation = str;
    }

    public String toString() {
        return this.presentation;
    }
}
