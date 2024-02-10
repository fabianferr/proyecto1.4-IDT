package com.startapp.sdk.adsbase;

import android.content.SharedPreferences;
import com.startapp.k9;
import com.startapp.sdk.adsbase.remoteconfig.MetaDataRequest;
import com.startapp.sdk.components.s;
import com.startapp.t7;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

/* compiled from: Sta */
public class e implements SharedPreferences {
    public final SharedPreferences a;
    public final b b;

    /* compiled from: Sta */
    public interface b {
    }

    public e(SharedPreferences sharedPreferences) {
        this(sharedPreferences, (b) null);
    }

    /* renamed from: a */
    public a edit() {
        return new a(this.a.edit(), this.a.getAll(), this.b);
    }

    public boolean contains(String str) {
        try {
            return this.a.contains(str);
        } catch (Throwable unused) {
            return false;
        }
    }

    public Map<String, ?> getAll() {
        try {
            return this.a.getAll();
        } catch (Throwable unused) {
            return Collections.emptyMap();
        }
    }

    public boolean getBoolean(String str, boolean z) {
        try {
            return this.a.getBoolean(str, z);
        } catch (Throwable unused) {
            return z;
        }
    }

    public float getFloat(String str, float f) {
        try {
            return this.a.getFloat(str, f);
        } catch (Throwable unused) {
            return f;
        }
    }

    public int getInt(String str, int i) {
        try {
            return this.a.getInt(str, i);
        } catch (Throwable unused) {
            return i;
        }
    }

    public long getLong(String str, long j) {
        try {
            return this.a.getLong(str, j);
        } catch (Throwable unused) {
            return j;
        }
    }

    public String getString(String str, String str2) {
        try {
            return this.a.getString(str, str2);
        } catch (Throwable unused) {
            return str2;
        }
    }

    public Set<String> getStringSet(String str, Set<String> set) {
        try {
            return this.a.getStringSet(str, set);
        } catch (Throwable unused) {
            return set;
        }
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.a.registerOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.a.unregisterOnSharedPreferenceChangeListener(onSharedPreferenceChangeListener);
    }

    public e(SharedPreferences sharedPreferences, b bVar) {
        this.a = sharedPreferences;
        this.b = bVar;
    }

    /* compiled from: Sta */
    public static class a implements SharedPreferences.Editor {
        public final SharedPreferences.Editor a;
        public final Map<String, ?> b;
        public final b c;
        public boolean d;

        public a(SharedPreferences.Editor editor, Map<String, ?> map, b bVar) {
            this.a = editor;
            this.b = map;
            this.c = bVar;
        }

        public final <T> void a(String str, T t) {
            if (this.c != null && !k9.a(this.b.get(str), t)) {
                this.d = true;
            }
        }

        public SharedPreferences.Editor clear() {
            if (!this.b.isEmpty()) {
                this.d = true;
            }
            this.a.clear();
            return this;
        }

        public boolean commit() {
            return this.a.commit();
        }

        public SharedPreferences.Editor putBoolean(String str, boolean z) {
            a(str, Boolean.valueOf(z));
            this.a.putBoolean(str, z);
            return this;
        }

        public SharedPreferences.Editor putFloat(String str, float f) {
            a(str, Float.valueOf(f));
            this.a.putFloat(str, f);
            return this;
        }

        public SharedPreferences.Editor putInt(String str, int i) {
            a(str, Integer.valueOf(i));
            this.a.putInt(str, i);
            return this;
        }

        public SharedPreferences.Editor putLong(String str, long j) {
            a(str, Long.valueOf(j));
            this.a.putLong(str, j);
            return this;
        }

        public SharedPreferences.Editor putString(String str, String str2) {
            a(str, str2);
            this.a.putString(str, str2);
            return this;
        }

        public SharedPreferences.Editor putStringSet(String str, Set set) {
            a(str, set);
            this.a.putStringSet(str, set);
            return this;
        }

        public void apply() {
            this.a.apply();
            b bVar = this.c;
            if (bVar != null && this.d) {
                this.d = false;
                s sVar = (s) bVar;
                sVar.getClass();
                t7 t7Var = t7.d;
                t7.d.a(sVar.a.a, MetaDataRequest.RequestReason.EXTRAS);
            }
        }

        public a a(String str, String str2) {
            a(str, str2);
            this.a.putString(str, str2);
            return this;
        }

        public a a(String str, int i) {
            a(str, Integer.valueOf(i));
            this.a.putInt(str, i);
            return this;
        }

        public a a(String str, long j) {
            a(str, Long.valueOf(j));
            this.a.putLong(str, j);
            return this;
        }

        /* renamed from: a */
        public a remove(String str) {
            if (this.b.containsKey(str)) {
                this.d = true;
            }
            this.a.remove(str);
            return this;
        }
    }
}
