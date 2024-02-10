package org.koin.core.instance;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.koin.core.Koin;
import org.koin.core.definition.BeanDefinition;
import org.koin.core.error.InstanceCreationException;
import org.koin.core.logger.Level;
import org.koin.core.logger.Logger;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.scope.Scope;
import org.koin.mp.KoinPlatformTools;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b&\u0018\u0000 \u0015*\u0004\b\u0000\u0010\u00012\u00060\u0002j\u0002`\u0003:\u0001\u0015B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH\u0016¢\u0006\u0002\u0010\fJ\u0014\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H&J\b\u0010\u0011\u001a\u00020\u000eH&J\u0015\u0010\u0012\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH&¢\u0006\u0002\u0010\fJ\u0014\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lorg/koin/core/instance/InstanceFactory;", "T", "", "Lorg/koin/mp/Lockable;", "beanDefinition", "Lorg/koin/core/definition/BeanDefinition;", "(Lorg/koin/core/definition/BeanDefinition;)V", "getBeanDefinition", "()Lorg/koin/core/definition/BeanDefinition;", "create", "context", "Lorg/koin/core/instance/InstanceContext;", "(Lorg/koin/core/instance/InstanceContext;)Ljava/lang/Object;", "drop", "", "scope", "Lorg/koin/core/scope/Scope;", "dropAll", "get", "isCreated", "", "Companion", "koin-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: InstanceFactory.kt */
public abstract class InstanceFactory<T> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String ERROR_SEPARATOR = "\n\t";
    private final BeanDefinition<T> beanDefinition;

    public abstract void drop(Scope scope);

    public abstract void dropAll();

    public abstract T get(InstanceContext instanceContext);

    public abstract boolean isCreated(InstanceContext instanceContext);

    public InstanceFactory(BeanDefinition<T> beanDefinition2) {
        Intrinsics.checkNotNullParameter(beanDefinition2, "beanDefinition");
        this.beanDefinition = beanDefinition2;
    }

    public final BeanDefinition<T> getBeanDefinition() {
        return this.beanDefinition;
    }

    public T create(InstanceContext instanceContext) {
        Intrinsics.checkNotNullParameter(instanceContext, "context");
        Koin koin = instanceContext.getKoin();
        if (koin.getLogger().isAt(Level.DEBUG)) {
            Logger logger = koin.getLogger();
            logger.debug("| create instance for " + this.beanDefinition);
        }
        try {
            ParametersHolder parameters = instanceContext.getParameters();
            if (parameters == null) {
                parameters = ParametersHolderKt.emptyParametersHolder();
            }
            return this.beanDefinition.getDefinition().invoke(instanceContext.getScope(), parameters);
        } catch (Exception e) {
            String stackTrace = KoinPlatformTools.INSTANCE.getStackTrace(e);
            Logger logger2 = koin.getLogger();
            logger2.error("Instance creation error : could not create instance for " + this.beanDefinition + ": " + stackTrace);
            throw new InstanceCreationException("Could not create instance for " + this.beanDefinition, e);
        }
    }

    public static /* synthetic */ boolean isCreated$default(InstanceFactory instanceFactory, InstanceContext instanceContext, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                instanceContext = null;
            }
            return instanceFactory.isCreated(instanceContext);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: isCreated");
    }

    public static /* synthetic */ void drop$default(InstanceFactory instanceFactory, Scope scope, int i, Object obj) {
        if (obj == null) {
            if ((i & 1) != 0) {
                scope = null;
            }
            instanceFactory.drop(scope);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: drop");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lorg/koin/core/instance/InstanceFactory$Companion;", "", "()V", "ERROR_SEPARATOR", "", "koin-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: InstanceFactory.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
