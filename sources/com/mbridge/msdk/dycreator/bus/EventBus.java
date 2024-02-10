package com.mbridge.msdk.dycreator.bus;

import android.os.Looper;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class EventBus {
    public static String TAG = "Event";
    static ExecutorService a = Executors.newCachedThreadPool();
    private static volatile EventBus b;
    private static final Map<Class<?>, List<Class<?>>> c = new HashMap();
    private final Map<Class<?>, CopyOnWriteArrayList<Subscription>> d = new HashMap();
    private final Map<Object, List<Class<?>>> e = new HashMap();
    private final Map<Class<?>, Object> f = new ConcurrentHashMap();
    private final ThreadLocal<List<Object>> g = new ThreadLocal<List<Object>>() {
        /* access modifiers changed from: protected */
        public /* synthetic */ Object initialValue() {
            return new ArrayList();
        }
    };
    private final ThreadLocal<BooleanWrapper> h = new ThreadLocal<BooleanWrapper>() {
        /* access modifiers changed from: protected */
        public /* synthetic */ Object initialValue() {
            return new BooleanWrapper();
        }
    };
    private String i = "onEvent";
    private final HandlerPoster j = new HandlerPoster(this, Looper.getMainLooper(), 10);
    private final BackgroundPoster k = new BackgroundPoster(this);
    private final AsyncPoster l = new AsyncPoster(this);
    private final SubscriberMethodFinder m = new SubscriberMethodFinder();
    private boolean n;
    private boolean o = true;
    private Map<String, Object> p = new ConcurrentHashMap();

    interface PostCallback {
        void onPostCompleted(List<SubscriberExceptionEvent> list);
    }

    public static EventBus getDefault() {
        if (b == null) {
            synchronized (EventBus.class) {
                if (b == null) {
                    b = new EventBus();
                }
            }
        }
        return b;
    }

    public static void clearCaches() {
        SubscriberMethodFinder.a();
        c.clear();
    }

    public static void skipMethodNameVerificationFor(Class<?> cls) {
        SubscriberMethodFinder.a(cls);
    }

    public static void clearSkipMethodNameVerifications() {
        SubscriberMethodFinder.clearSkipMethodNameVerifications();
    }

    public final void configureLogSubscriberExceptions(boolean z) {
        if (!this.n) {
            this.o = z;
            return;
        }
        throw new EventBusException("This method must be called before any registration");
    }

    public final void register(Object obj) {
        a(obj, this.i, false);
    }

    public final void register(String str, Object obj) {
        Map<String, Object> map = this.p;
        if (map != null && map.containsKey(str)) {
            unregister(this.p.get(str));
        }
        this.p.put(str, obj);
        a(obj, this.i, false);
    }

    public final void register(Object obj, String str) {
        a(obj, str, false);
    }

    public final void registerSticky(Object obj) {
        a(obj, this.i, true);
    }

    public final void registerSticky(Object obj, String str) {
        a(obj, str, true);
    }

    private void a(Object obj, String str, boolean z) {
        for (SubscriberMethod a2 : this.m.a(obj.getClass(), str)) {
            a(obj, a2, z);
        }
    }

    public final void register(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.i, false, cls, clsArr);
    }

    public final synchronized void register(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        a(obj, str, false, cls, clsArr);
    }

    public final void registerSticky(Object obj, Class<?> cls, Class<?>... clsArr) {
        a(obj, this.i, true, cls, clsArr);
    }

    public final synchronized void registerSticky(Object obj, String str, Class<?> cls, Class<?>... clsArr) {
        a(obj, str, true, cls, clsArr);
    }

    private synchronized void a(Object obj, String str, boolean z, Class<?> cls, Class<?>... clsArr) {
        for (SubscriberMethod next : this.m.a(obj.getClass(), str)) {
            if (cls == next.c) {
                a(obj, next, z);
            } else if (clsArr != null) {
                int length = clsArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (clsArr[i2] == next.c) {
                        a(obj, next, z);
                        break;
                    } else {
                        i2++;
                    }
                }
            }
        }
    }

    private void a(Object obj, SubscriberMethod subscriberMethod, boolean z) {
        Object obj2;
        boolean z2 = true;
        this.n = true;
        Class<?> cls = subscriberMethod.c;
        CopyOnWriteArrayList copyOnWriteArrayList = this.d.get(cls);
        Subscription subscription = new Subscription(obj, subscriberMethod);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.d.put(cls, copyOnWriteArrayList);
        } else {
            Iterator it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                if (((Subscription) it.next()).equals(subscription)) {
                    throw new EventBusException("Subscriber " + obj.getClass() + " already registered to event " + cls);
                }
            }
        }
        subscriberMethod.a.setAccessible(true);
        copyOnWriteArrayList.add(subscription);
        List list = this.e.get(obj);
        if (list == null) {
            list = new ArrayList();
            this.e.put(obj, list);
        }
        list.add(cls);
        if (z) {
            synchronized (this.f) {
                obj2 = this.f.get(cls);
            }
            if (obj2 != null) {
                if (Looper.getMainLooper() != Looper.myLooper()) {
                    z2 = false;
                }
                a(subscription, obj2, z2);
            }
        }
    }

    public final synchronized void unregister(Object obj, Class<?>... clsArr) {
        if (clsArr.length != 0) {
            List list = this.e.get(obj);
            if (list != null) {
                for (Class<?> cls : clsArr) {
                    a(obj, cls);
                    list.remove(cls);
                }
                if (list.isEmpty()) {
                    this.e.remove(obj);
                }
            } else {
                Log.w(TAG, "Subscriber to unregister was not registered before: " + obj.getClass());
            }
        } else {
            throw new IllegalArgumentException("Provide at least one event class");
        }
    }

    private void a(Object obj, Class<?> cls) {
        List list = this.d.get(cls);
        if (list != null) {
            int size = list.size();
            int i2 = 0;
            while (i2 < size) {
                if (((Subscription) list.get(i2)).a == obj) {
                    list.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    public final synchronized void unregister(Object obj) {
        List<Class> list = this.e.get(obj);
        if (list != null) {
            for (Class a2 : list) {
                a(obj, (Class<?>) a2);
            }
            this.e.remove(obj);
        } else {
            String str = TAG;
            Log.w(str, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public final synchronized void unregister(String str) {
        Map<String, Object> map = this.p;
        if (map != null && map.containsKey(str)) {
            Object remove = this.p.remove(str);
            List<Class> list = this.e.get(remove);
            if (list != null) {
                for (Class a2 : list) {
                    a(remove, (Class<?>) a2);
                }
                this.e.remove(remove);
            } else {
                String str2 = TAG;
                Log.w(str2, "Subscriber to unregister was not registered before: " + remove.getClass());
            }
        }
    }

    public final void post(Object obj) {
        CopyOnWriteArrayList copyOnWriteArrayList;
        List list = this.g.get();
        list.add(obj);
        BooleanWrapper booleanWrapper = this.h.get();
        if (!booleanWrapper.a) {
            boolean z = Looper.getMainLooper() == Looper.myLooper();
            booleanWrapper.a = true;
            while (!list.isEmpty()) {
                try {
                    Object remove = list.remove(0);
                    if (remove != null) {
                        try {
                            Class<?> cls = remove.getClass();
                            List<Class<?>> a2 = a(cls);
                            int size = a2.size();
                            boolean z2 = false;
                            for (int i2 = 0; i2 < size; i2++) {
                                Class cls2 = a2.get(i2);
                                synchronized (this) {
                                    copyOnWriteArrayList = this.d.get(cls2);
                                }
                                if (copyOnWriteArrayList != null) {
                                    Iterator it = copyOnWriteArrayList.iterator();
                                    while (it.hasNext()) {
                                        a((Subscription) it.next(), remove, z);
                                    }
                                    z2 = true;
                                }
                            }
                            if (!z2) {
                                String str = TAG;
                                Log.d(str, "No subscripers registered for event " + cls);
                                if (!(cls == NoSubscriberEvent.class || cls == SubscriberExceptionEvent.class)) {
                                    post(new NoSubscriberEvent(this, remove));
                                }
                            }
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    }
                } finally {
                    booleanWrapper.a = false;
                }
            }
        }
    }

    public final void postSticky(Object obj) {
        post(obj);
        synchronized (this.f) {
            this.f.put(obj.getClass(), obj);
        }
    }

    public final Object getStickyEvent(Class<?> cls) {
        Object obj;
        synchronized (this.f) {
            obj = this.f.get(cls);
        }
        return obj;
    }

    public final Object removeStickyEvent(Class<?> cls) {
        Object remove;
        synchronized (this.f) {
            remove = this.f.remove(cls);
        }
        return remove;
    }

    public final boolean removeStickyEvent(Object obj) {
        synchronized (this.f) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.f.get(cls))) {
                return false;
            }
            this.f.remove(cls);
            return true;
        }
    }

    public final void release() {
        if (b != null) {
            b = null;
            a = null;
            Map<Class<?>, List<Class<?>>> map = c;
            if (map != null && map.size() > 0) {
                map.clear();
            }
            Map<Class<?>, CopyOnWriteArrayList<Subscription>> map2 = this.d;
            if (map2 != null && map2.size() > 0) {
                this.d.clear();
            }
            Map<Object, List<Class<?>>> map3 = this.e;
            if (map3 != null && map3.size() > 0) {
                this.e.clear();
            }
            Map<Class<?>, Object> map4 = this.f;
            if (map4 != null && map4.size() > 0) {
                this.f.clear();
            }
            Map<String, Object> map5 = this.p;
            if (map5 != null && map5.size() > 0) {
                this.p.clear();
            }
        }
    }

    /* renamed from: com.mbridge.msdk.dycreator.bus.EventBus$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                com.mbridge.msdk.dycreator.bus.ThreadMode[] r0 = com.mbridge.msdk.dycreator.bus.ThreadMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                a = r0
                com.mbridge.msdk.dycreator.bus.ThreadMode r1 = com.mbridge.msdk.dycreator.bus.ThreadMode.PostThread     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.bus.ThreadMode r1 = com.mbridge.msdk.dycreator.bus.ThreadMode.MainThread     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.bus.ThreadMode r1 = com.mbridge.msdk.dycreator.bus.ThreadMode.BackgroundThread     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.bus.ThreadMode r1 = com.mbridge.msdk.dycreator.bus.ThreadMode.Async     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.bus.EventBus.AnonymousClass3.<clinit>():void");
        }
    }

    private void a(Subscription subscription, Object obj, boolean z) {
        int i2 = AnonymousClass3.a[subscription.b.b.ordinal()];
        if (i2 == 1) {
            a(subscription, obj);
        } else if (i2 != 2) {
            if (i2 != 3) {
                if (i2 == 4) {
                    this.l.enqueue(subscription, obj);
                    return;
                }
                throw new IllegalStateException("Unknown thread mode: " + subscription.b.b);
            } else if (z) {
                this.k.enqueue(subscription, obj);
            } else {
                a(subscription, obj);
            }
        } else if (z) {
            a(subscription, obj);
        } else {
            this.j.a(subscription, obj);
        }
    }

    private List<Class<?>> a(Class<?> cls) {
        List<Class<?>> list;
        Map<Class<?>, List<Class<?>>> map = c;
        synchronized (map) {
            list = map.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    a(list, (Class<?>[]) cls2.getInterfaces());
                }
                c.put(cls, list);
            }
        }
        return list;
    }

    private static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, (Class<?>[]) cls.getInterfaces());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void a(PendingPost pendingPost) {
        Object obj = pendingPost.a;
        Subscription subscription = pendingPost.b;
        PendingPost.a(pendingPost);
        a(subscription, obj);
    }

    private void a(Subscription subscription, Object obj) throws Error {
        try {
            subscription.b.a.invoke(subscription.a, new Object[]{obj});
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (obj instanceof SubscriberExceptionEvent) {
                String str = TAG;
                Log.e(str, "SubscriberExceptionEvent subscriber " + subscription.a.getClass() + " threw an exception", cause);
                SubscriberExceptionEvent subscriberExceptionEvent = (SubscriberExceptionEvent) obj;
                String str2 = TAG;
                Log.e(str2, "Initial event " + subscriberExceptionEvent.causingEvent + " caused exception in " + subscriberExceptionEvent.causingSubscriber, subscriberExceptionEvent.throwable);
                return;
            }
            if (this.o) {
                String str3 = TAG;
                Log.e(str3, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + subscription.a.getClass(), cause);
            }
            post(new SubscriberExceptionEvent(this, cause, obj, subscription.a));
        } catch (IllegalAccessException e3) {
            throw new IllegalStateException("Unexpected exception", e3);
        }
    }

    static final class BooleanWrapper {
        boolean a;

        BooleanWrapper() {
        }
    }
}
