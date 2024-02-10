package com.bykv.vk.openvk.preload.a.b;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Map;
import java.util.Properties;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import okhttp3.HttpUrl;

/* compiled from: $Gson$Types */
public final class b {
    static final Type[] a = new Type[0];

    private static GenericArrayType f(Type type) {
        return new a(type);
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [com.bykv.vk.openvk.preload.a.b.b$a] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.reflect.Type a(java.lang.reflect.Type r3) {
        /*
            boolean r0 = r3 instanceof java.lang.Class
            if (r0 == 0) goto L_0x001d
            java.lang.Class r3 = (java.lang.Class) r3
            boolean r0 = r3.isArray()
            if (r0 == 0) goto L_0x001a
            com.bykv.vk.openvk.preload.a.b.b$a r0 = new com.bykv.vk.openvk.preload.a.b.b$a
            java.lang.Class r3 = r3.getComponentType()
            java.lang.reflect.Type r3 = a((java.lang.reflect.Type) r3)
            r0.<init>(r3)
            r3 = r0
        L_0x001a:
            java.lang.reflect.Type r3 = (java.lang.reflect.Type) r3
            return r3
        L_0x001d:
            boolean r0 = r3 instanceof java.lang.reflect.ParameterizedType
            if (r0 == 0) goto L_0x0035
            java.lang.reflect.ParameterizedType r3 = (java.lang.reflect.ParameterizedType) r3
            com.bykv.vk.openvk.preload.a.b.b$b r0 = new com.bykv.vk.openvk.preload.a.b.b$b
            java.lang.reflect.Type r1 = r3.getOwnerType()
            java.lang.reflect.Type r2 = r3.getRawType()
            java.lang.reflect.Type[] r3 = r3.getActualTypeArguments()
            r0.<init>(r1, r2, r3)
            return r0
        L_0x0035:
            boolean r0 = r3 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x0045
            java.lang.reflect.GenericArrayType r3 = (java.lang.reflect.GenericArrayType) r3
            com.bykv.vk.openvk.preload.a.b.b$a r0 = new com.bykv.vk.openvk.preload.a.b.b$a
            java.lang.reflect.Type r3 = r3.getGenericComponentType()
            r0.<init>(r3)
            return r0
        L_0x0045:
            boolean r0 = r3 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x0059
            java.lang.reflect.WildcardType r3 = (java.lang.reflect.WildcardType) r3
            com.bykv.vk.openvk.preload.a.b.b$c r0 = new com.bykv.vk.openvk.preload.a.b.b$c
            java.lang.reflect.Type[] r1 = r3.getUpperBounds()
            java.lang.reflect.Type[] r3 = r3.getLowerBounds()
            r0.<init>(r1, r3)
            return r0
        L_0x0059:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.b.b.a(java.lang.reflect.Type):java.lang.reflect.Type");
    }

    public static Class<?> b(Type type) {
        String str;
        while (!(type instanceof Class)) {
            if (type instanceof ParameterizedType) {
                Type rawType = ((ParameterizedType) type).getRawType();
                a.a(rawType instanceof Class);
                return (Class) rawType;
            } else if (type instanceof GenericArrayType) {
                return Array.newInstance(b(((GenericArrayType) type).getGenericComponentType()), 0).getClass();
            } else {
                if (type instanceof TypeVariable) {
                    return Object.class;
                }
                if (type instanceof WildcardType) {
                    type = ((WildcardType) type).getUpperBounds()[0];
                } else {
                    if (type == null) {
                        str = AbstractJsonLexerKt.NULL;
                    } else {
                        str = type.getClass().getName();
                    }
                    throw new IllegalArgumentException("Expected a Class, ParameterizedType, or GenericArrayType, but <" + type + "> is of type " + str);
                }
            }
        }
        return (Class) type;
    }

    public static boolean a(Type type, Type type2) {
        while (type != type2) {
            if (type instanceof Class) {
                return type.equals(type2);
            }
            if (type instanceof ParameterizedType) {
                if (!(type2 instanceof ParameterizedType)) {
                    return false;
                }
                ParameterizedType parameterizedType = (ParameterizedType) type;
                ParameterizedType parameterizedType2 = (ParameterizedType) type2;
                Type ownerType = parameterizedType.getOwnerType();
                Type ownerType2 = parameterizedType2.getOwnerType();
                if (!(ownerType == ownerType2 || (ownerType != null && ownerType.equals(ownerType2))) || !parameterizedType.getRawType().equals(parameterizedType2.getRawType()) || !Arrays.equals(parameterizedType.getActualTypeArguments(), parameterizedType2.getActualTypeArguments())) {
                    return false;
                }
                return true;
            } else if (type instanceof GenericArrayType) {
                if (!(type2 instanceof GenericArrayType)) {
                    return false;
                }
                type = ((GenericArrayType) type).getGenericComponentType();
                type2 = ((GenericArrayType) type2).getGenericComponentType();
            } else if (type instanceof WildcardType) {
                if (!(type2 instanceof WildcardType)) {
                    return false;
                }
                WildcardType wildcardType = (WildcardType) type;
                WildcardType wildcardType2 = (WildcardType) type2;
                if (!Arrays.equals(wildcardType.getUpperBounds(), wildcardType2.getUpperBounds()) || !Arrays.equals(wildcardType.getLowerBounds(), wildcardType2.getLowerBounds())) {
                    return false;
                }
                return true;
            } else if (!(type instanceof TypeVariable) || !(type2 instanceof TypeVariable)) {
                return false;
            } else {
                TypeVariable typeVariable = (TypeVariable) type;
                TypeVariable typeVariable2 = (TypeVariable) type2;
                if (typeVariable.getGenericDeclaration() != typeVariable2.getGenericDeclaration() || !typeVariable.getName().equals(typeVariable2.getName())) {
                    return false;
                }
                return true;
            }
        }
        return true;
    }

    static int a(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }

    public static String c(Type type) {
        return type instanceof Class ? ((Class) type).getName() : type.toString();
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Class<?>, code=java.lang.Class<? super ?>, for r5v0, types: [java.lang.Class<?>] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Type a(java.lang.reflect.Type r4, java.lang.Class<? super java.lang.Object> r5, java.lang.Class<?> r6) {
        /*
        L_0x0000:
            if (r6 != r5) goto L_0x0003
            return r4
        L_0x0003:
            boolean r4 = r6.isInterface()
            if (r4 == 0) goto L_0x002e
            java.lang.Class[] r4 = r5.getInterfaces()
            int r0 = r4.length
            r1 = 0
        L_0x000f:
            if (r1 >= r0) goto L_0x002e
            r2 = r4[r1]
            if (r2 != r6) goto L_0x001c
            java.lang.reflect.Type[] r4 = r5.getGenericInterfaces()
            r4 = r4[r1]
            return r4
        L_0x001c:
            boolean r2 = r6.isAssignableFrom(r2)
            if (r2 == 0) goto L_0x002b
            java.lang.reflect.Type[] r5 = r5.getGenericInterfaces()
            r5 = r5[r1]
            r4 = r4[r1]
            goto L_0x004d
        L_0x002b:
            int r1 = r1 + 1
            goto L_0x000f
        L_0x002e:
            boolean r4 = r5.isInterface()
            if (r4 != 0) goto L_0x0053
        L_0x0034:
            java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
            if (r5 == r4) goto L_0x0053
            java.lang.Class r4 = r5.getSuperclass()
            if (r4 != r6) goto L_0x0043
            java.lang.reflect.Type r4 = r5.getGenericSuperclass()
            return r4
        L_0x0043:
            boolean r0 = r6.isAssignableFrom(r4)
            if (r0 == 0) goto L_0x0051
            java.lang.reflect.Type r5 = r5.getGenericSuperclass()
        L_0x004d:
            r3 = r5
            r5 = r4
            r4 = r3
            goto L_0x0000
        L_0x0051:
            r5 = r4
            goto L_0x0034
        L_0x0053:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.b.b.a(java.lang.reflect.Type, java.lang.Class, java.lang.Class):java.lang.reflect.Type");
    }

    private static Type b(Type type, Class<?> cls, Class<?> cls2) {
        if (type instanceof WildcardType) {
            type = ((WildcardType) type).getUpperBounds()[0];
        }
        a.a(cls2.isAssignableFrom(cls));
        return a(type, cls, a(type, cls, cls2));
    }

    public static Type d(Type type) {
        if (type instanceof GenericArrayType) {
            return ((GenericArrayType) type).getGenericComponentType();
        }
        return ((Class) type).getComponentType();
    }

    public static Type a(Type type, Class<?> cls) {
        Type b = b(type, cls, Collection.class);
        if (b instanceof WildcardType) {
            b = ((WildcardType) b).getUpperBounds()[0];
        }
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments()[0];
        }
        return Object.class;
    }

    public static Type[] b(Type type, Class<?> cls) {
        if (type == Properties.class) {
            return new Type[]{String.class, String.class};
        }
        Type b = b(type, cls, Map.class);
        if (b instanceof ParameterizedType) {
            return ((ParameterizedType) b).getActualTypeArguments();
        }
        return new Type[]{Object.class, Object.class};
    }

    public static Type a(Type type, Class<?> cls, Type type2) {
        return a(type, cls, type2, new HashSet());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v1, resolved type: java.lang.Class} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v2, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.reflect.Type[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v20, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v21, resolved type: java.lang.reflect.TypeVariable} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v11, resolved type: java.lang.Class} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v12, resolved type: java.lang.Class} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: java.lang.reflect.GenericArrayType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v20, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v21, resolved type: java.lang.reflect.WildcardType} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v22, resolved type: java.lang.reflect.WildcardType} */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.reflect.Type a(java.lang.reflect.Type r8, java.lang.Class<?> r9, java.lang.reflect.Type r10, java.util.Collection<java.lang.reflect.TypeVariable> r11) {
        /*
        L_0x0000:
            boolean r0 = r10 instanceof java.lang.reflect.TypeVariable
            r1 = 0
            if (r0 == 0) goto L_0x004d
            r0 = r10
            java.lang.reflect.TypeVariable r0 = (java.lang.reflect.TypeVariable) r0
            boolean r2 = r11.contains(r0)
            if (r2 == 0) goto L_0x000f
            return r10
        L_0x000f:
            r11.add(r0)
            java.lang.reflect.GenericDeclaration r10 = r0.getGenericDeclaration()
            boolean r2 = r10 instanceof java.lang.Class
            if (r2 == 0) goto L_0x001d
            java.lang.Class r10 = (java.lang.Class) r10
            goto L_0x001e
        L_0x001d:
            r10 = 0
        L_0x001e:
            if (r10 == 0) goto L_0x0049
            java.lang.reflect.Type r2 = a((java.lang.reflect.Type) r8, (java.lang.Class<?>) r9, (java.lang.Class<?>) r10)
            boolean r3 = r2 instanceof java.lang.reflect.ParameterizedType
            if (r3 == 0) goto L_0x0049
            java.lang.reflect.TypeVariable[] r10 = r10.getTypeParameters()
            int r3 = r10.length
        L_0x002d:
            if (r1 >= r3) goto L_0x0043
            r4 = r10[r1]
            boolean r4 = r0.equals(r4)
            if (r4 == 0) goto L_0x0040
            java.lang.reflect.ParameterizedType r2 = (java.lang.reflect.ParameterizedType) r2
            java.lang.reflect.Type[] r10 = r2.getActualTypeArguments()
            r10 = r10[r1]
            goto L_0x004a
        L_0x0040:
            int r1 = r1 + 1
            goto L_0x002d
        L_0x0043:
            java.util.NoSuchElementException r8 = new java.util.NoSuchElementException
            r8.<init>()
            throw r8
        L_0x0049:
            r10 = r0
        L_0x004a:
            if (r10 != r0) goto L_0x0000
            return r10
        L_0x004d:
            boolean r0 = r10 instanceof java.lang.Class
            if (r0 == 0) goto L_0x006a
            r0 = r10
            java.lang.Class r0 = (java.lang.Class) r0
            boolean r2 = r0.isArray()
            if (r2 == 0) goto L_0x006a
            java.lang.Class r10 = r0.getComponentType()
            java.lang.reflect.Type r8 = a(r8, r9, r10, r11)
            if (r10 != r8) goto L_0x0065
            return r0
        L_0x0065:
            java.lang.reflect.GenericArrayType r8 = f(r8)
            return r8
        L_0x006a:
            boolean r0 = r10 instanceof java.lang.reflect.GenericArrayType
            if (r0 == 0) goto L_0x0080
            java.lang.reflect.GenericArrayType r10 = (java.lang.reflect.GenericArrayType) r10
            java.lang.reflect.Type r0 = r10.getGenericComponentType()
            java.lang.reflect.Type r8 = a(r8, r9, r0, r11)
            if (r0 != r8) goto L_0x007b
            return r10
        L_0x007b:
            java.lang.reflect.GenericArrayType r8 = f(r8)
            return r8
        L_0x0080:
            boolean r0 = r10 instanceof java.lang.reflect.ParameterizedType
            r2 = 1
            if (r0 == 0) goto L_0x00c1
            java.lang.reflect.ParameterizedType r10 = (java.lang.reflect.ParameterizedType) r10
            java.lang.reflect.Type r0 = r10.getOwnerType()
            java.lang.reflect.Type r3 = a(r8, r9, r0, r11)
            if (r3 == r0) goto L_0x0093
            r0 = 1
            goto L_0x0094
        L_0x0093:
            r0 = 0
        L_0x0094:
            java.lang.reflect.Type[] r4 = r10.getActualTypeArguments()
            int r5 = r4.length
        L_0x0099:
            if (r1 >= r5) goto L_0x00b4
            r6 = r4[r1]
            java.lang.reflect.Type r6 = a(r8, r9, r6, r11)
            r7 = r4[r1]
            if (r6 == r7) goto L_0x00b1
            if (r0 != 0) goto L_0x00af
            java.lang.Object r0 = r4.clone()
            r4 = r0
            java.lang.reflect.Type[] r4 = (java.lang.reflect.Type[]) r4
            r0 = 1
        L_0x00af:
            r4[r1] = r6
        L_0x00b1:
            int r1 = r1 + 1
            goto L_0x0099
        L_0x00b4:
            if (r0 == 0) goto L_0x00c0
            java.lang.reflect.Type r8 = r10.getRawType()
            com.bykv.vk.openvk.preload.a.b.b$b r9 = new com.bykv.vk.openvk.preload.a.b.b$b
            r9.<init>(r3, r8, r4)
            return r9
        L_0x00c0:
            return r10
        L_0x00c1:
            boolean r0 = r10 instanceof java.lang.reflect.WildcardType
            if (r0 == 0) goto L_0x011d
            java.lang.reflect.WildcardType r10 = (java.lang.reflect.WildcardType) r10
            java.lang.reflect.Type[] r0 = r10.getLowerBounds()
            java.lang.reflect.Type[] r3 = r10.getUpperBounds()
            int r4 = r0.length
            if (r4 != r2) goto L_0x00f8
            r3 = r0[r1]
            java.lang.reflect.Type r8 = a(r8, r9, r3, r11)
            r9 = r0[r1]
            if (r8 == r9) goto L_0x011d
            boolean r9 = r8 instanceof java.lang.reflect.WildcardType
            if (r9 == 0) goto L_0x00e7
            java.lang.reflect.WildcardType r8 = (java.lang.reflect.WildcardType) r8
            java.lang.reflect.Type[] r8 = r8.getLowerBounds()
            goto L_0x00ec
        L_0x00e7:
            java.lang.reflect.Type[] r9 = new java.lang.reflect.Type[r2]
            r9[r1] = r8
            r8 = r9
        L_0x00ec:
            com.bykv.vk.openvk.preload.a.b.b$c r9 = new com.bykv.vk.openvk.preload.a.b.b$c
            java.lang.reflect.Type[] r10 = new java.lang.reflect.Type[r2]
            java.lang.Class<java.lang.Object> r11 = java.lang.Object.class
            r10[r1] = r11
            r9.<init>(r10, r8)
            return r9
        L_0x00f8:
            int r0 = r3.length
            if (r0 != r2) goto L_0x011d
            r0 = r3[r1]
            java.lang.reflect.Type r8 = a(r8, r9, r0, r11)     // Catch:{ all -> 0x011e }
            r9 = r3[r1]
            if (r8 == r9) goto L_0x011d
            boolean r9 = r8 instanceof java.lang.reflect.WildcardType
            if (r9 == 0) goto L_0x0110
            java.lang.reflect.WildcardType r8 = (java.lang.reflect.WildcardType) r8
            java.lang.reflect.Type[] r8 = r8.getUpperBounds()
            goto L_0x0115
        L_0x0110:
            java.lang.reflect.Type[] r9 = new java.lang.reflect.Type[r2]
            r9[r1] = r8
            r8 = r9
        L_0x0115:
            com.bykv.vk.openvk.preload.a.b.b$c r9 = new com.bykv.vk.openvk.preload.a.b.b$c
            java.lang.reflect.Type[] r10 = a
            r9.<init>(r8, r10)
            return r9
        L_0x011d:
            return r10
        L_0x011e:
            r8 = move-exception
            goto L_0x0121
        L_0x0120:
            throw r8
        L_0x0121:
            goto L_0x0120
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bykv.vk.openvk.preload.a.b.b.a(java.lang.reflect.Type, java.lang.Class, java.lang.reflect.Type, java.util.Collection):java.lang.reflect.Type");
    }

    static void e(Type type) {
        a.a(!(type instanceof Class) || !((Class) type).isPrimitive());
    }

    /* renamed from: com.bykv.vk.openvk.preload.a.b.b$b  reason: collision with other inner class name */
    /* compiled from: $Gson$Types */
    static final class C0037b implements Serializable, ParameterizedType {
        private final Type a;
        private final Type b;
        private final Type[] c;

        public C0037b(Type type, Type type2, Type... typeArr) {
            Type type3;
            if (type2 instanceof Class) {
                Class cls = (Class) type2;
                boolean z = true;
                boolean z2 = Modifier.isStatic(cls.getModifiers()) || cls.getEnclosingClass() == null;
                if (type == null && !z2) {
                    z = false;
                }
                a.a(z);
            }
            if (type == null) {
                type3 = null;
            } else {
                type3 = b.a(type);
            }
            this.a = type3;
            this.b = b.a(type2);
            Type[] typeArr2 = (Type[]) typeArr.clone();
            this.c = typeArr2;
            int length = typeArr2.length;
            for (int i = 0; i < length; i++) {
                a.a(this.c[i]);
                b.e(this.c[i]);
                Type[] typeArr3 = this.c;
                typeArr3[i] = b.a(typeArr3[i]);
            }
        }

        public final Type[] getActualTypeArguments() {
            return (Type[]) this.c.clone();
        }

        public final Type getRawType() {
            return this.b;
        }

        public final Type getOwnerType() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof ParameterizedType) && b.a((Type) this, (Type) (ParameterizedType) obj);
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.c) ^ this.b.hashCode()) ^ b.a((Object) this.a);
        }

        public final String toString() {
            int length = this.c.length;
            if (length == 0) {
                return b.c(this.b);
            }
            StringBuilder sb = new StringBuilder((length + 1) * 30);
            sb.append(b.c(this.b));
            sb.append("<");
            sb.append(b.c(this.c[0]));
            for (int i = 1; i < length; i++) {
                sb.append(", ");
                sb.append(b.c(this.c[i]));
            }
            sb.append(">");
            return sb.toString();
        }
    }

    /* compiled from: $Gson$Types */
    static final class a implements Serializable, GenericArrayType {
        private final Type a;

        public a(Type type) {
            this.a = b.a(type);
        }

        public final Type getGenericComponentType() {
            return this.a;
        }

        public final boolean equals(Object obj) {
            return (obj instanceof GenericArrayType) && b.a((Type) this, (Type) (GenericArrayType) obj);
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return b.c(this.a) + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* compiled from: $Gson$Types */
    static final class c implements Serializable, WildcardType {
        private final Type a;
        private final Type b;

        public c(Type[] typeArr, Type[] typeArr2) {
            boolean z = true;
            a.a(typeArr2.length <= 1);
            a.a(typeArr.length == 1);
            if (typeArr2.length == 1) {
                a.a(typeArr2[0]);
                b.e(typeArr2[0]);
                a.a(typeArr[0] != Object.class ? false : z);
                this.b = b.a(typeArr2[0]);
                this.a = Object.class;
                return;
            }
            a.a(typeArr[0]);
            b.e(typeArr[0]);
            this.b = null;
            this.a = b.a(typeArr[0]);
        }

        public final Type[] getUpperBounds() {
            return new Type[]{this.a};
        }

        public final Type[] getLowerBounds() {
            Type type = this.b;
            if (type == null) {
                return b.a;
            }
            return new Type[]{type};
        }

        public final boolean equals(Object obj) {
            return (obj instanceof WildcardType) && b.a((Type) this, (Type) (WildcardType) obj);
        }

        public final int hashCode() {
            Type type = this.b;
            return (type != null ? type.hashCode() + 31 : 1) ^ (this.a.hashCode() + 31);
        }

        public final String toString() {
            if (this.b != null) {
                return "? super " + b.c(this.b);
            } else if (this.a == Object.class) {
                return "?";
            } else {
                return "? extends " + b.c(this.a);
            }
        }
    }
}
