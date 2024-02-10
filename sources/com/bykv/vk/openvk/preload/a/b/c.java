package com.bykv.vk.openvk.preload.a.b;

import com.bykv.vk.openvk.preload.a.b.b.b;
import com.bykv.vk.openvk.preload.a.c.a;
import com.bykv.vk.openvk.preload.a.h;
import com.bykv.vk.openvk.preload.a.l;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ConcurrentNavigableMap;
import java.util.concurrent.ConcurrentSkipListMap;

/* compiled from: ConstructorConstructor */
public final class c {
    private final Map<Type, h<?>> a;
    private final b b = b.a();

    public c(Map<Type, h<?>> map) {
        this.a = map;
    }

    private <T> i<T> a(Class<? super T> cls) {
        try {
            final Constructor<? super T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            if (!declaredConstructor.isAccessible()) {
                this.b.a(declaredConstructor);
            }
            return new i<T>() {
                public final T a() {
                    try {
                        return declaredConstructor.newInstance((Object[]) null);
                    } catch (InstantiationException e) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e);
                    } catch (InvocationTargetException e2) {
                        throw new RuntimeException("Failed to invoke " + declaredConstructor + " with no args", e2.getTargetException());
                    } catch (IllegalAccessException e3) {
                        throw new AssertionError(e3);
                    }
                }
            };
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public final String toString() {
        return this.a.toString();
    }

    public final <T> i<T> a(a<T> aVar) {
        i<T> iVar;
        final Type type = aVar.c;
        final Class<? super T> cls = aVar.b;
        final h hVar = this.a.get(type);
        if (hVar != null) {
            return new i<T>() {
                public final T a() {
                    return hVar.a();
                }
            };
        }
        final h hVar2 = this.a.get(cls);
        if (hVar2 != null) {
            return new i<T>() {
                public final T a() {
                    return hVar2.a();
                }
            };
        }
        i<T> a2 = a(cls);
        if (a2 != null) {
            return a2;
        }
        if (Collection.class.isAssignableFrom(cls)) {
            iVar = SortedSet.class.isAssignableFrom(cls) ? new i<T>() {
                public final T a() {
                    return new TreeSet();
                }
            } : EnumSet.class.isAssignableFrom(cls) ? new i<T>() {
                public final T a() {
                    Type type = type;
                    if (type instanceof ParameterizedType) {
                        Type type2 = ((ParameterizedType) type).getActualTypeArguments()[0];
                        if (type2 instanceof Class) {
                            return EnumSet.noneOf((Class) type2);
                        }
                        throw new l("Invalid EnumSet type: " + type.toString());
                    }
                    throw new l("Invalid EnumSet type: " + type.toString());
                }
            } : Set.class.isAssignableFrom(cls) ? new i<T>() {
                public final T a() {
                    return new LinkedHashSet();
                }
            } : Queue.class.isAssignableFrom(cls) ? new i<T>() {
                public final T a() {
                    return new ArrayDeque();
                }
            } : new i<T>() {
                public final T a() {
                    return new ArrayList();
                }
            };
        } else if (!Map.class.isAssignableFrom(cls)) {
            iVar = null;
        } else if (ConcurrentNavigableMap.class.isAssignableFrom(cls)) {
            iVar = new i<T>() {
                public final T a() {
                    return new ConcurrentSkipListMap();
                }
            };
        } else if (ConcurrentMap.class.isAssignableFrom(cls)) {
            iVar = new i<T>() {
                public final T a() {
                    return new ConcurrentHashMap();
                }
            };
        } else {
            iVar = SortedMap.class.isAssignableFrom(cls) ? new i<T>() {
                public final T a() {
                    return new TreeMap();
                }
            } : (!(type instanceof ParameterizedType) || String.class.isAssignableFrom(a.a(((ParameterizedType) type).getActualTypeArguments()[0]).b)) ? new i<T>() {
                public final T a() {
                    return new h();
                }
            } : new i<T>() {
                public final T a() {
                    return new LinkedHashMap();
                }
            };
        }
        return iVar != null ? iVar : new i<T>() {
            private final l d = l.a();

            public final T a() {
                try {
                    return this.d.a(cls);
                } catch (Exception e) {
                    throw new RuntimeException("Unable to invoke no-args constructor for " + type + ". Registering an InstanceCreator with Gson for this type may fix this problem.", e);
                }
            }
        };
    }
}
