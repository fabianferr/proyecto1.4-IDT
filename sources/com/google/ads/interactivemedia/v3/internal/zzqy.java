package com.google.ads.interactivemedia.v3.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
public @interface zzqy {
    Class zza();

    String[] zzb() default {""};
}