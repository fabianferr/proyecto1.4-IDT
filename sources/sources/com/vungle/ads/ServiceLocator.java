package com.vungle.ads;

import android.content.Context;
import com.vungle.ads.internal.bidding.BidTokenEncoder;
import com.vungle.ads.internal.downloader.Downloader;
import com.vungle.ads.internal.executor.Executors;
import com.vungle.ads.internal.locale.LocaleInfo;
import com.vungle.ads.internal.network.VungleApiClient;
import com.vungle.ads.internal.omsdk.OMInjector;
import com.vungle.ads.internal.omsdk.OMTracker;
import com.vungle.ads.internal.persistence.FilePreferences;
import com.vungle.ads.internal.platform.Platform;
import com.vungle.ads.internal.task.JobCreator;
import com.vungle.ads.internal.task.JobRunner;
import com.vungle.ads.internal.util.ConcurrencyTimeoutProvider;
import com.vungle.ads.internal.util.PathProvider;
import java.util.HashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u000b\u001a\u00020\f\"\u0004\b\u0000\u0010\r2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00072\u0006\u0010\u000f\u001a\u0002H\rH\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\b\u0010\u0012\u001a\u00020\fH\u0002J#\u0010\u0013\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u0007H\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001f\u0010\u0016\u001a\u0002H\r\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u0007¢\u0006\u0002\u0010\u0015J\u0018\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00072\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0007H\u0002J\u001a\u0010\u0018\u001a\u00020\u0019\"\u0004\b\u0000\u0010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\r0\u0007R \u0010\u0005\u001a\u0014\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0006X\u0004¢\u0006\u0002\n\u0000R&\u0010\b\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0007\u0012\f\u0012\n\u0012\u0002\b\u00030\tR\u00020\u00000\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/vungle/ads/ServiceLocator;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cache", "", "Ljava/lang/Class;", "creators", "Lcom/vungle/ads/ServiceLocator$Creator;", "ctx", "bindService", "", "T", "serviceClass", "service", "bindService$vungle_ads_release", "(Ljava/lang/Class;Ljava/lang/Object;)V", "buildCreators", "getOrBuild", "getOrBuild$vungle_ads_release", "(Ljava/lang/Class;)Ljava/lang/Object;", "getService", "getServiceClass", "isCreated", "", "Companion", "Creator", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ServiceLocator.kt */
public final class ServiceLocator {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static volatile ServiceLocator INSTANCE;
    private final Map<Class<?>, Object> cache;
    private final Map<Class<?>, Creator<?>> creators;
    /* access modifiers changed from: private */
    public final Context ctx;

    public /* synthetic */ ServiceLocator(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    private ServiceLocator(Context context) {
        Context applicationContext = context.getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "context.applicationContext");
        this.ctx = applicationContext;
        this.creators = new HashMap();
        this.cache = new HashMap();
        buildCreators();
    }

    public final synchronized <T> T getService(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "serviceClass");
        return getOrBuild$vungle_ads_release(cls);
    }

    public final synchronized <T> boolean isCreated(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "serviceClass");
        return this.cache.containsKey(getServiceClass(cls));
    }

    public final <T> T getOrBuild$vungle_ads_release(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "serviceClass");
        Class<?> serviceClass = getServiceClass(cls);
        T t = this.cache.get(serviceClass);
        if (t != null) {
            return t;
        }
        Creator creator = this.creators.get(serviceClass);
        if (creator != null) {
            T create = creator.create();
            if (creator.isSingleton()) {
                this.cache.put(serviceClass, create);
            }
            return create;
        }
        throw new IllegalArgumentException("Unknown class");
    }

    public final <T> void bindService$vungle_ads_release(Class<?> cls, T t) {
        Intrinsics.checkNotNullParameter(cls, "serviceClass");
        this.cache.put(cls, t);
    }

    private final Class<?> getServiceClass(Class<?> cls) {
        for (Class<?> next : this.creators.keySet()) {
            if (next.isAssignableFrom(cls)) {
                return next;
            }
        }
        throw new IllegalArgumentException("Unknown dependency for " + cls);
    }

    private final void buildCreators() {
        this.creators.put(JobCreator.class, new ServiceLocator$buildCreators$1(this));
        this.creators.put(JobRunner.class, new ServiceLocator$buildCreators$2(this));
        this.creators.put(VungleApiClient.class, new ServiceLocator$buildCreators$3(this));
        this.creators.put(Platform.class, new ServiceLocator$buildCreators$4(this));
        this.creators.put(Executors.class, new ServiceLocator$buildCreators$5(this));
        this.creators.put(OMInjector.class, new ServiceLocator$buildCreators$6(this));
        this.creators.put(OMTracker.Factory.class, new ServiceLocator$buildCreators$7(this));
        this.creators.put(FilePreferences.class, new ServiceLocator$buildCreators$8(this));
        this.creators.put(LocaleInfo.class, new ServiceLocator$buildCreators$9(this));
        this.creators.put(BidTokenEncoder.class, new ServiceLocator$buildCreators$10(this));
        this.creators.put(PathProvider.class, new ServiceLocator$buildCreators$11(this));
        this.creators.put(Downloader.class, new ServiceLocator$buildCreators$12(this));
        this.creators.put(ConcurrencyTimeoutProvider.class, new ServiceLocator$buildCreators$13(this));
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b¢\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\r\u0010\u0007\u001a\u00028\u0000H&¢\u0006\u0002\u0010\bR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0006¨\u0006\t"}, d2 = {"Lcom/vungle/ads/ServiceLocator$Creator;", "T", "", "isSingleton", "", "(Lcom/vungle/ads/ServiceLocator;Z)V", "()Z", "create", "()Ljava/lang/Object;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ServiceLocator.kt */
    private abstract class Creator<T> {
        private final boolean isSingleton;

        public abstract T create();

        public Creator(boolean z) {
            this.isSingleton = z;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Creator(ServiceLocator serviceLocator, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? true : z);
        }

        public final boolean isSingleton() {
            return this.isSingleton;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eJ#\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00110\u0010\"\n\b\u0000\u0010\u0011\u0018\u0001*\u00020\u00012\u0006\u0010\r\u001a\u00020\u000eH\bR&\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0012"}, d2 = {"Lcom/vungle/ads/ServiceLocator$Companion;", "", "()V", "INSTANCE", "Lcom/vungle/ads/ServiceLocator;", "getINSTANCE$vungle_ads_release$annotations", "getINSTANCE$vungle_ads_release", "()Lcom/vungle/ads/ServiceLocator;", "setINSTANCE$vungle_ads_release", "(Lcom/vungle/ads/ServiceLocator;)V", "deInit", "", "getInstance", "context", "Landroid/content/Context;", "inject", "Lkotlin/Lazy;", "T", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ServiceLocator.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getINSTANCE$vungle_ads_release$annotations() {
        }

        private Companion() {
        }

        public final ServiceLocator getINSTANCE$vungle_ads_release() {
            return ServiceLocator.INSTANCE;
        }

        public final void setINSTANCE$vungle_ads_release(ServiceLocator serviceLocator) {
            ServiceLocator.INSTANCE = serviceLocator;
        }

        public final ServiceLocator getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            ServiceLocator iNSTANCE$vungle_ads_release = getINSTANCE$vungle_ads_release();
            if (iNSTANCE$vungle_ads_release == null) {
                synchronized (this) {
                    iNSTANCE$vungle_ads_release = ServiceLocator.Companion.getINSTANCE$vungle_ads_release();
                    if (iNSTANCE$vungle_ads_release == null) {
                        iNSTANCE$vungle_ads_release = new ServiceLocator(context, (DefaultConstructorMarker) null);
                        ServiceLocator.Companion.setINSTANCE$vungle_ads_release(iNSTANCE$vungle_ads_release);
                    }
                }
            }
            return iNSTANCE$vungle_ads_release;
        }

        public final /* synthetic */ <T> Lazy<T> inject(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.SYNCHRONIZED;
            Intrinsics.needClassReification();
            return LazyKt.lazy(lazyThreadSafetyMode, new ServiceLocator$Companion$inject$1(context));
        }

        public final synchronized void deInit() {
            setINSTANCE$vungle_ads_release((ServiceLocator) null);
        }
    }
}
