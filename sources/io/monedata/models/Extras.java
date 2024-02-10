package io.monedata.models;

import io.monedata.r1;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000¬\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\u0005\b\u0007\u0018\u00002\"\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001j\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003`\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005B\u001d\b\u0016\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0007¢\u0006\u0002\u0010\bJ\u0019\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0002¢\u0006\u0002\u0010\fJ!\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u0010J!\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0012¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u000b\u001a\u00020\u0002J!\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0017¢\u0006\u0002\u0010\u0018J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0006\u0010\u000b\u001a\u00020\u0002J\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001cJ!\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u001e¢\u0006\u0002\u0010\u001fJ\u0010\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u000b\u001a\u00020\u0002J\u0010\u0010\"\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u000b\u001a\u00020\u0002J!\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010$¢\u0006\u0002\u0010%J\u0010\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010\u000b\u001a\u00020\u0002J!\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010)¢\u0006\u0002\u0010*J\u0010\u0010+\u001a\u0004\u0018\u00010,2\u0006\u0010\u000b\u001a\u00020\u0002J\u0014\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010.2\u0006\u0010\u000b\u001a\u00020\u0002J!\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u000100¢\u0006\u0002\u00101J\u0010\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u000b\u001a\u00020\u0002J\u001a\u00104\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0002\b\u0003\u0018\u00010\u00072\u0006\u0010\u000b\u001a\u00020\u0002J$\u00105\u001a\u0004\u0018\u0001H6\"\n\b\u0000\u00106\u0018\u0001*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u0002H\b¢\u0006\u0002\u00107J/\u00105\u001a\u0004\u0018\u0001H6\"\b\b\u0000\u00106*\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00022\u000e\u00108\u001a\n\u0012\u0006\b\u0001\u0012\u0002H609¢\u0006\u0002\u0010:J!\u0010;\u001a\u0004\u0018\u00010<2\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010<¢\u0006\u0002\u0010=J\u0010\u0010>\u001a\u0004\u0018\u00010?2\u0006\u0010\u000b\u001a\u00020\u0002J\u001c\u0010@\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u000b\u001a\u00020\u00022\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0002J\u0016\u0010A\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010.2\u0006\u0010\u000b\u001a\u00020\u0002J\u0016\u0010B\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010.2\u0006\u0010\u000b\u001a\u00020\u0002J \u0010C\u001a\u0004\u0018\u0001H6\"\u0006\b\u0000\u00106\u0018\u00012\u0006\u0010\u000b\u001a\u00020\u0002H\b¢\u0006\u0002\u00107¨\u0006D"}, d2 = {"Lio/monedata/models/Extras;", "Ljava/util/LinkedHashMap;", "", "", "Lkotlin/collections/LinkedHashMap;", "()V", "map", "", "(Ljava/util/Map;)V", "getArray", "", "key", "(Ljava/lang/String;)[Ljava/lang/Object;", "getBoolean", "", "defaultValue", "(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "getByte", "", "(Ljava/lang/String;Ljava/lang/Byte;)Ljava/lang/Byte;", "getByteArray", "", "getChar", "", "(Ljava/lang/String;Ljava/lang/Character;)Ljava/lang/Character;", "getCharArray", "", "getCharSequence", "", "getDouble", "", "(Ljava/lang/String;Ljava/lang/Double;)Ljava/lang/Double;", "getDoubleArray", "", "getExtras", "getFloat", "", "(Ljava/lang/String;Ljava/lang/Float;)Ljava/lang/Float;", "getFloatArray", "", "getInt", "", "(Ljava/lang/String;Ljava/lang/Integer;)Ljava/lang/Integer;", "getIntArray", "", "getList", "", "getLong", "", "(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "getLongArray", "", "getMap", "getObject", "T", "(Ljava/lang/String;)Ljava/lang/Object;", "clazz", "Lkotlin/reflect/KClass;", "(Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "getShort", "", "(Ljava/lang/String;Ljava/lang/Short;)Ljava/lang/Short;", "getShortArray", "", "getString", "getStringArray", "getStringList", "getValue", "core_productionRelease"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Extras extends LinkedHashMap<String, Object> {
    public Extras() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Extras(Map<String, ? extends Object> map) {
        super(map);
        Intrinsics.checkNotNullParameter(map, "map");
    }

    public static /* synthetic */ Boolean getBoolean$default(Extras extras, String str, Boolean bool, int i, Object obj) {
        if ((i & 2) != 0) {
            bool = null;
        }
        return extras.getBoolean(str, bool);
    }

    public static /* synthetic */ Byte getByte$default(Extras extras, String str, Byte b, int i, Object obj) {
        if ((i & 2) != 0) {
            b = null;
        }
        return extras.getByte(str, b);
    }

    public static /* synthetic */ Character getChar$default(Extras extras, String str, Character ch, int i, Object obj) {
        if ((i & 2) != 0) {
            ch = null;
        }
        return extras.getChar(str, ch);
    }

    public static /* synthetic */ CharSequence getCharSequence$default(Extras extras, String str, CharSequence charSequence, int i, Object obj) {
        if ((i & 2) != 0) {
            charSequence = null;
        }
        return extras.getCharSequence(str, charSequence);
    }

    public static /* synthetic */ Double getDouble$default(Extras extras, String str, Double d, int i, Object obj) {
        if ((i & 2) != 0) {
            d = null;
        }
        return extras.getDouble(str, d);
    }

    public static /* synthetic */ Float getFloat$default(Extras extras, String str, Float f, int i, Object obj) {
        if ((i & 2) != 0) {
            f = null;
        }
        return extras.getFloat(str, f);
    }

    public static /* synthetic */ Integer getInt$default(Extras extras, String str, Integer num, int i, Object obj) {
        if ((i & 2) != 0) {
            num = null;
        }
        return extras.getInt(str, num);
    }

    public static /* synthetic */ Long getLong$default(Extras extras, String str, Long l, int i, Object obj) {
        if ((i & 2) != 0) {
            l = null;
        }
        return extras.getLong(str, l);
    }

    public static /* synthetic */ Short getShort$default(Extras extras, String str, Short sh, int i, Object obj) {
        if ((i & 2) != 0) {
            sh = null;
        }
        return extras.getShort(str, sh);
    }

    public static /* synthetic */ String getString$default(Extras extras, String str, String str2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        return extras.getString(str, str2);
    }

    public final /* bridge */ boolean containsKey(Object obj) {
        if (!(obj instanceof String)) {
            return false;
        }
        return containsKey((String) obj);
    }

    public /* bridge */ boolean containsKey(String str) {
        return super.containsKey(str);
    }

    public final /* bridge */ Set<Map.Entry<String, Object>> entrySet() {
        return getEntries();
    }

    public final /* bridge */ Object get(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return get((String) obj);
    }

    public /* bridge */ Object get(String str) {
        return super.get(str);
    }

    public final Object[] getArray(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof Object[])) {
            obj = null;
        }
        return (Object[]) obj;
    }

    public final Boolean getBoolean(String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof Boolean)) {
            obj = null;
        }
        Boolean bool2 = (Boolean) obj;
        return bool2 == null ? bool : bool2;
    }

    public final Byte getByte(String str, Byte b) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof Byte)) {
            obj = null;
        }
        Byte b2 = (Byte) obj;
        return b2 == null ? b : b2;
    }

    public final byte[] getByteArray(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof byte[])) {
            obj = null;
        }
        return (byte[]) obj;
    }

    public final Character getChar(String str, Character ch) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof Character)) {
            obj = null;
        }
        Character ch2 = (Character) obj;
        return ch2 == null ? ch : ch2;
    }

    public final char[] getCharArray(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof char[])) {
            obj = null;
        }
        return (char[]) obj;
    }

    public final CharSequence getCharSequence(String str, CharSequence charSequence) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof CharSequence)) {
            obj = null;
        }
        CharSequence charSequence2 = (CharSequence) obj;
        return charSequence2 == null ? charSequence : charSequence2;
    }

    public final Double getDouble(String str, Double d) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof Double)) {
            obj = null;
        }
        Double d2 = (Double) obj;
        return d2 == null ? d : d2;
    }

    public final double[] getDoubleArray(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof double[])) {
            obj = null;
        }
        return (double[]) obj;
    }

    public /* bridge */ Set<Map.Entry<String, Object>> getEntries() {
        return super.entrySet();
    }

    public final Extras getExtras(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Map<String, ?> map = getMap(str);
        if (map != null) {
            return new Extras(map);
        }
        return null;
    }

    public final Float getFloat(String str, Float f) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof Float)) {
            obj = null;
        }
        Float f2 = (Float) obj;
        return f2 == null ? f : f2;
    }

    public final float[] getFloatArray(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (obj instanceof float[]) {
            return (float[]) obj;
        }
        return null;
    }

    public final Integer getInt(String str, Integer num) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof Integer)) {
            obj = null;
        }
        Integer num2 = (Integer) obj;
        return num2 == null ? num : num2;
    }

    public final int[] getIntArray(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof int[])) {
            obj = null;
        }
        return (int[]) obj;
    }

    public /* bridge */ Set<String> getKeys() {
        return super.keySet();
    }

    public final List<?> getList(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof List)) {
            obj = null;
        }
        return (List) obj;
    }

    public final Long getLong(String str, Long l) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof Long)) {
            obj = null;
        }
        Long l2 = (Long) obj;
        return l2 == null ? l : l2;
    }

    public final long[] getLongArray(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof long[])) {
            obj = null;
        }
        return (long[]) obj;
    }

    public final Map<String, ?> getMap(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof Map)) {
            obj = null;
        }
        return (Map) obj;
    }

    public final /* synthetic */ <T> T getObject(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.reifiedOperationMarker(4, "T");
        return getObject(str, Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> T getObject(String str, KClass<? extends T> kClass) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Map<String, ?> map = getMap(str);
        if (map != null) {
            return r1.a.a((Map<?, ?>) map, kClass);
        }
        return null;
    }

    public final /* bridge */ Object getOrDefault(Object obj, Object obj2) {
        return !(obj instanceof String) ? obj2 : getOrDefault((String) obj, obj2);
    }

    public /* bridge */ Object getOrDefault(String str, Object obj) {
        return super.getOrDefault(str, obj);
    }

    public final Short getShort(String str, Short sh) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof Short)) {
            obj = null;
        }
        Short sh2 = (Short) obj;
        return sh2 == null ? sh : sh2;
    }

    public final short[] getShortArray(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof short[])) {
            obj = null;
        }
        return (short[]) obj;
    }

    public /* bridge */ int getSize() {
        return super.size();
    }

    public final String getString(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = get((Object) str);
        if (!(obj instanceof String)) {
            obj = null;
        }
        String str3 = (String) obj;
        return str3 == null ? str2 : str3;
    }

    public final List<String> getStringArray(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object[] array = getArray(str);
        if (array == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : array) {
            String str2 = obj instanceof String ? (String) obj : null;
            if (str2 != null) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public final List<String> getStringList(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        List<?> list = getList(str);
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (T next : list) {
            String str2 = next instanceof String ? (String) next : null;
            if (str2 != null) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public final /* synthetic */ <T> T getValue(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        T t = get((Object) str);
        Intrinsics.reifiedOperationMarker(2, "T");
        Object obj = (Object) t;
        return t;
    }

    public /* bridge */ Collection<Object> getValues() {
        return super.values();
    }

    public final /* bridge */ Set<String> keySet() {
        return getKeys();
    }

    public final /* bridge */ Object remove(Object obj) {
        if (!(obj instanceof String)) {
            return null;
        }
        return remove((String) obj);
    }

    public /* bridge */ Object remove(String str) {
        return super.remove(str);
    }

    public final /* bridge */ boolean remove(Object obj, Object obj2) {
        if (!(obj instanceof String)) {
            return false;
        }
        return remove((String) obj, obj2);
    }

    public /* bridge */ boolean remove(String str, Object obj) {
        return super.remove(str, obj);
    }

    public final /* bridge */ int size() {
        return getSize();
    }

    public final /* bridge */ Collection<Object> values() {
        return getValues();
    }
}
