package com.m2catalyst.m2sdk;

import org.koin.core.definition.BeanDefinition;
import org.koin.core.instance.SingleInstanceFactory;
import org.koin.core.module.Module;

/* compiled from: R8$$SyntheticClass */
public final /* synthetic */ class x {
    public static SingleInstanceFactory a(BeanDefinition beanDefinition, Module module) {
        SingleInstanceFactory singleInstanceFactory = new SingleInstanceFactory(beanDefinition);
        module.indexPrimaryType(singleInstanceFactory);
        return singleInstanceFactory;
    }
}
