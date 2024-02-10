package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* compiled from: com.google.ads.interactivemedia.v3:interactivemedia@@3.30.3 */
final class zzagb {
    private static final char[] zza;

    static {
        char[] cArr = new char[80];
        zza = cArr;
        Arrays.fill(cArr, ' ');
    }

    static String zza(zzafz zzafz, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzafz, sb, 0);
        return sb.toString();
    }

    static void zzb(StringBuilder sb, int i, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i, str, zzb2);
            }
        } else {
            sb.append(10);
            zzc(i, sb);
            if (!str.isEmpty()) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(Character.toLowerCase(str.charAt(0)));
                for (int i2 = 1; i2 < str.length(); i2++) {
                    char charAt = str.charAt(i2);
                    if (Character.isUpperCase(charAt)) {
                        sb2.append("_");
                    }
                    sb2.append(Character.toLowerCase(charAt));
                }
                str = sb2.toString();
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzahh.zza(new zzado(((String) obj).getBytes(zzafa.zzb))));
                sb.append('\"');
            } else if (obj instanceof zzadr) {
                sb.append(": \"");
                sb.append(zzahh.zza((zzadr) obj));
                sb.append('\"');
            } else if (obj instanceof zzaet) {
                sb.append(" {");
                zzd((zzaet) obj, sb, i + 2);
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i3 = i + 2;
                zzb(sb, i3, "key", entry.getKey());
                zzb(sb, i3, "value", entry.getValue());
                sb.append("\n");
                zzc(i, sb);
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj);
            }
        }
    }

    private static void zzc(int i, StringBuilder sb) {
        while (i > 0) {
            int i2 = 80;
            if (i <= 80) {
                i2 = i;
            }
            sb.append(zza, 0, i2);
            i -= i2;
        }
    }

    private static void zzd(zzafz zzafz, StringBuilder sb, int i) {
        int i2;
        boolean z;
        Method method;
        Method method2;
        zzafz zzafz2 = zzafz;
        StringBuilder sb2 = sb;
        int i3 = i;
        HashSet hashSet = new HashSet();
        HashMap hashMap = new HashMap();
        TreeMap treeMap = new TreeMap();
        Method[] declaredMethods = zzafz.getClass().getDeclaredMethods();
        int length = declaredMethods.length;
        int i4 = 0;
        while (true) {
            i2 = 3;
            if (i4 >= length) {
                break;
            }
            Method method3 = declaredMethods[i4];
            if (!Modifier.isStatic(method3.getModifiers()) && method3.getName().length() >= 3) {
                if (method3.getName().startsWith("set")) {
                    hashSet.add(method3.getName());
                } else if (Modifier.isPublic(method3.getModifiers()) && method3.getParameterTypes().length == 0) {
                    if (method3.getName().startsWith("has")) {
                        hashMap.put(method3.getName(), method3);
                    } else if (method3.getName().startsWith("get")) {
                        treeMap.put(method3.getName(), method3);
                    }
                }
            }
            i4++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String substring = ((String) entry.getKey()).substring(i2);
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List") && (method2 = (Method) entry.getValue()) != null && method2.getReturnType().equals(List.class)) {
                zzb(sb2, i3, substring.substring(0, substring.length() - 4), zzaet.zzaI(method2, zzafz2, new Object[0]));
            } else if (substring.endsWith("Map") && !substring.equals("Map") && (method = (Method) entry.getValue()) != null && method.getReturnType().equals(Map.class) && !method.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method.getModifiers())) {
                zzb(sb2, i3, substring.substring(0, substring.length() - 3), zzaet.zzaI(method, zzafz2, new Object[0]));
            } else if (hashSet.contains("set".concat(String.valueOf(substring))) && (!substring.endsWith("Bytes") || !treeMap.containsKey("get".concat(String.valueOf(substring.substring(0, substring.length() - 5)))))) {
                Method method4 = (Method) entry.getValue();
                Method method5 = (Method) hashMap.get("has".concat(String.valueOf(substring)));
                if (method4 != null) {
                    Object zzaI = zzaet.zzaI(method4, zzafz2, new Object[0]);
                    if (method5 == null) {
                        if (zzaI instanceof Boolean) {
                            if (!((Boolean) zzaI).booleanValue()) {
                            }
                        } else if (zzaI instanceof Integer) {
                            if (((Integer) zzaI).intValue() == 0) {
                            }
                        } else if (zzaI instanceof Float) {
                            if (Float.floatToRawIntBits(((Float) zzaI).floatValue()) == 0) {
                            }
                        } else if (!(zzaI instanceof Double)) {
                            if (zzaI instanceof String) {
                                z = zzaI.equals("");
                            } else if (zzaI instanceof zzadr) {
                                z = zzaI.equals(zzadr.zzb);
                            } else if (zzaI instanceof zzafz) {
                                if (zzaI == ((zzafz) zzaI).zzaR()) {
                                }
                            } else if ((zzaI instanceof Enum) && ((Enum) zzaI).ordinal() == 0) {
                            }
                            if (z) {
                            }
                        } else if (Double.doubleToRawLongBits(((Double) zzaI).doubleValue()) == 0) {
                        }
                    } else if (!((Boolean) zzaet.zzaI(method5, zzafz2, new Object[0])).booleanValue()) {
                    }
                    zzb(sb2, i3, substring, zzaI);
                }
            }
            i2 = 3;
        }
        if (!(zzafz2 instanceof zzaeq)) {
            zzahk zzahk = ((zzaet) zzafz2).zzc;
            if (zzahk != null) {
                zzahk.zzi(sb2, i3);
                return;
            }
            return;
        }
        zzaek zzaek = ((zzaeq) zzafz2).zzb;
        throw null;
    }
}
