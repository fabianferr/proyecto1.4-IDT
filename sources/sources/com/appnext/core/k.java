package com.appnext.core;

import android.text.TextUtils;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.appnext.base.a;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class k {
    private static int dn = 2;

    public static Object a(Class<?> cls, JSONObject jSONObject) {
        Field[] fieldArr;
        try {
            Object newInstance = cls.newInstance();
            if (dn == 0) {
                fieldArr = cls.getFields();
            } else {
                fieldArr = cls.getDeclaredFields();
            }
            for (Field field : fieldArr) {
                if (dn == 2 && Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(true);
                }
                try {
                    if (jSONObject.has(field.getName())) {
                        String simpleName = field.getType().getSimpleName();
                        if (TextUtils.isEmpty(simpleName)) {
                        } else if (simpleName.equalsIgnoreCase(TypedValues.Custom.S_BOOLEAN)) {
                            field.setBoolean(newInstance, jSONObject.getBoolean(field.getName()));
                        } else if (simpleName.equalsIgnoreCase("int")) {
                            field.setInt(newInstance, jSONObject.getInt(field.getName()));
                        } else if (simpleName.equalsIgnoreCase("double")) {
                            field.setDouble(newInstance, jSONObject.getDouble(field.getName()));
                        } else if (simpleName.equalsIgnoreCase(TypedValues.Custom.S_FLOAT)) {
                            field.setFloat(newInstance, (float) jSONObject.getDouble(field.getName()));
                        } else if (simpleName.equalsIgnoreCase(TypedValues.Custom.S_STRING)) {
                            field.set(newInstance, jSONObject.getString(field.getName()));
                        } else if (field.getType().isArray()) {
                            field.set(newInstance, Array.newInstance(field.getType().getComponentType(), jSONObject.getJSONArray(field.getName()).length()));
                            a(field.get(newInstance), jSONObject.getJSONArray(field.getName()));
                        } else {
                            field.set(newInstance, a(field.getType(), jSONObject.getJSONObject(field.getName())));
                        }
                    }
                } catch (IllegalArgumentException e) {
                    a.a("JSONParser$populateObjectFromJSON", e);
                } catch (IllegalAccessException e2) {
                    a.a("JSONParser$populateObjectFromJSON", e2);
                } catch (Throwable th) {
                    a.a("JSONParser$populateObjectFromJSON", th);
                }
                if (dn == 2 && Modifier.isPrivate(field.getModifiers())) {
                    field.setAccessible(false);
                }
            }
            return newInstance;
        } catch (InstantiationException e3) {
            a.a("JSONParser$populateObjectFromJSON", e3);
            return null;
        } catch (IllegalAccessException e4) {
            a.a("JSONParser$populateObjectFromJSON", e4);
            return null;
        }
    }

    public static void a(Object obj, JSONArray jSONArray) throws IllegalArgumentException, NegativeArraySizeException, IllegalAccessException, JSONException {
        Class<?> cls = obj.getClass();
        String simpleName = cls.getComponentType().getSimpleName();
        for (int i = 0; i < jSONArray.length(); i++) {
            if (cls.getComponentType().isArray()) {
                Array.set(obj, i, Array.newInstance(cls.getComponentType().getComponentType(), jSONArray.getJSONArray(i).length()));
                a(Array.get(obj, i), jSONArray.getJSONArray(i));
            } else if (cls.getComponentType().isPrimitive() || simpleName.equalsIgnoreCase(TypedValues.Custom.S_STRING)) {
                Array.set(obj, i, jSONArray.get(i));
            } else {
                Array.set(obj, i, a(cls.getComponentType(), jSONArray.getJSONObject(i)));
            }
        }
    }
}
