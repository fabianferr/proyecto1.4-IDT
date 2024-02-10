package com.cellrebel.sdk.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import com.cellrebel.sdk.database.DatabaseClient;
import com.cellrebel.sdk.database.Preferences;
import com.cellrebel.sdk.database.dao.PreferencesDAO;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.util.List;
import java.util.Map;

public class PreferencesManager {
    private static volatile PreferencesManager j;
    private PreferencesDAO a;
    private Preferences b;
    private Boolean c;
    private Boolean d;
    private Boolean e;
    private int f = 0;
    private String g;
    private String h;
    private Boolean i;

    private PreferencesManager() {
        if (j == null) {
            try {
                if (DatabaseClient.a() != null) {
                    PreferencesDAO o = DatabaseClient.a().o();
                    this.a = o;
                    List<Preferences> b2 = o.b();
                    if (b2.size() == 1) {
                        this.b = b2.get(0);
                        return;
                    }
                    Preferences preferences = new Preferences();
                    this.b = preferences;
                    preferences.z = true;
                    this.a.a();
                    this.a.a(this.b);
                }
            } catch (Exception | OutOfMemoryError unused) {
            }
        } else {
            throw new RuntimeException("Use getInstance() method to get the single instance of this class.");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String A() {
        this.a.a(this.b);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String B() {
        this.a.a(this.b);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String C() {
        this.a.a(this.b);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String D() {
        this.a.a(this.b);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String E() {
        this.a.a(this.b);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String F() {
        this.a.a(this.b);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String G() {
        this.a.a(this.b);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ String H() {
        this.a.a(this.b);
        return null;
    }

    public static PreferencesManager m() {
        if (j == null) {
            synchronized (PreferencesManager.class) {
                if (j == null) {
                    j = new PreferencesManager();
                }
            }
        }
        return j;
    }

    public String a(Context context) {
        String string;
        try {
            String str = this.h;
            if (str != null) {
                return str;
            }
            Preferences preferences = this.b;
            if (preferences == null || preferences.f == null) {
                SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
                if (defaultSharedPreferences.contains("mobileClientId") && (string = defaultSharedPreferences.getString("mobileClientId", (String) null)) != null) {
                    if (this.b != null) {
                        a(string, context);
                    }
                    return string;
                }
            }
            return this.b.f;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public void a() {
        Preferences preferences = new Preferences();
        this.b = preferences;
        preferences.z = true;
    }

    public void a(long j2) {
        try {
            this.b.a(j2);
            if (this.a != null) {
                ThreadPoolProvider.a().a(new PreferencesManager$$ExternalSyntheticLambda5(this));
            }
        } catch (Exception unused) {
        }
    }

    public void a(long j2, long j3, long j4, long j5, long j6) {
        try {
            Preferences preferences = this.b;
            if (preferences != null) {
                preferences.i(j2);
                this.b.h(j3);
                this.b.c(j4);
                this.b.b(j5);
                this.b.e(j6);
                PreferencesDAO preferencesDAO = this.a;
                if (preferencesDAO != null) {
                    preferencesDAO.a(this.b);
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void a(Preferences preferences) {
        if (preferences != null) {
            try {
                this.b = preferences;
                if (DatabaseClient.a() != null) {
                    PreferencesDAO o = DatabaseClient.a().o();
                    this.a = o;
                    o.a(preferences);
                }
            } catch (Exception | OutOfMemoryError unused) {
            }
        }
    }

    public void a(String str) {
        try {
            Preferences preferences = this.b;
            if (preferences != null) {
                preferences.e(str);
                PreferencesDAO preferencesDAO = this.a;
                if (preferencesDAO != null) {
                    preferencesDAO.a(this.b);
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0032 A[Catch:{ Exception | OutOfMemoryError -> 0x0038 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033 A[Catch:{ Exception | OutOfMemoryError -> 0x0038 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r3, android.content.Context r4) {
        /*
            r2 = this;
            java.lang.String r0 = "mobileClientId"
            r2.h = r3     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
            android.content.SharedPreferences r4 = android.preference.PreferenceManager.getDefaultSharedPreferences(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
            com.cellrebel.sdk.database.Preferences r1 = r2.b     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
            if (r1 != 0) goto L_0x000d
            return
        L_0x000d:
            boolean r1 = r4.contains(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
            if (r1 == 0) goto L_0x001f
            r3 = 0
            java.lang.String r3 = r4.getString(r0, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
            if (r3 == 0) goto L_0x002e
            r2.h = r3     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
        L_0x001c:
            com.cellrebel.sdk.database.Preferences r4 = r2.b     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
            goto L_0x002b
        L_0x001f:
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
            android.content.SharedPreferences$Editor r4 = r4.putString(r0, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
            r4.apply()     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
            goto L_0x001c
        L_0x002b:
            r4.d((java.lang.String) r3)     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
        L_0x002e:
            com.cellrebel.sdk.database.dao.PreferencesDAO r3 = r2.a     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
            if (r3 != 0) goto L_0x0033
            return
        L_0x0033:
            com.cellrebel.sdk.database.Preferences r4 = r2.b     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
            r3.a(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x0038 }
        L_0x0038:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.PreferencesManager.a(java.lang.String, android.content.Context):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0039 A[Catch:{ Exception | OutOfMemoryError -> 0x003d }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003a A[Catch:{ Exception | OutOfMemoryError -> 0x003d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(java.lang.String r3, java.lang.String r4, android.content.Context r5) {
        /*
            r2 = this;
            java.lang.String r0 = "mobileClientId"
            r2.g = r4     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
            r2.h = r3     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
            com.cellrebel.sdk.database.Preferences r1 = r2.b     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
            r1.b((java.lang.String) r4)     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
            android.content.SharedPreferences r4 = android.preference.PreferenceManager.getDefaultSharedPreferences(r5)     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
            boolean r5 = r4.contains(r0)     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
            if (r5 == 0) goto L_0x0021
            r3 = 0
            java.lang.String r3 = r4.getString(r0, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
            if (r3 == 0) goto L_0x0030
            r2.h = r3     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
        L_0x001e:
            com.cellrebel.sdk.database.Preferences r4 = r2.b     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
            goto L_0x002d
        L_0x0021:
            android.content.SharedPreferences$Editor r4 = r4.edit()     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
            android.content.SharedPreferences$Editor r4 = r4.putString(r0, r3)     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
            r4.apply()     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
            goto L_0x001e
        L_0x002d:
            r4.d((java.lang.String) r3)     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
        L_0x0030:
            com.cellrebel.sdk.database.dao.PreferencesDAO r3 = r2.a     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
            if (r3 != 0) goto L_0x0035
            return
        L_0x0035:
            com.cellrebel.sdk.database.Preferences r4 = r2.b     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
            if (r4 != 0) goto L_0x003a
            return
        L_0x003a:
            r3.a(r4)     // Catch:{ Exception | OutOfMemoryError -> 0x003d }
        L_0x003d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cellrebel.sdk.utils.PreferencesManager.a(java.lang.String, java.lang.String, android.content.Context):void");
    }

    public void a(String str, String str2, String str3) {
        try {
            Preferences preferences = this.b;
            if (preferences != null) {
                preferences.c = str2;
                preferences.e = str3;
                preferences.d = str;
                PreferencesDAO preferencesDAO = this.a;
                if (preferencesDAO != null) {
                    preferencesDAO.a(preferences);
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void a(Map<String, Integer> map) {
        try {
            this.b.a(new Gson().toJson((Object) map, new TypeToken<Map<String, Integer>>() {
            }.getType()));
            if (this.a != null) {
                ThreadPoolProvider.a().a(new PreferencesManager$$ExternalSyntheticLambda3(this));
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void a(boolean z) {
        try {
            Preferences preferences = this.b;
            if (preferences != null) {
                preferences.a(z);
                if (this.a != null) {
                    ThreadPoolProvider.a().a(new PreferencesManager$$ExternalSyntheticLambda0(this));
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void a(boolean z, boolean z2, boolean z3) {
        try {
            this.e = Boolean.valueOf(z);
            this.d = Boolean.valueOf(z2);
            this.c = Boolean.valueOf(z3);
            Preferences preferences = this.b;
            if (preferences != null) {
                preferences.C = z;
                preferences.B = z2;
                preferences.A = z3;
                if (this.a != null) {
                    ThreadPoolProvider.a().a(new PreferencesManager$$ExternalSyntheticLambda2(this));
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long b() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return 0;
        }
        return preferences.r;
    }

    public void b(long j2) {
        try {
            Preferences preferences = this.b;
            if (preferences != null) {
                preferences.d(j2);
                if (this.a != null) {
                    ThreadPoolProvider.a().a(new PreferencesManager$$ExternalSyntheticLambda1(this));
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void b(Map<String, Integer> map) {
        try {
            this.b.c(new Gson().toJson((Object) map, new TypeToken<Map<String, Integer>>() {
            }.getType()));
            if (this.a != null) {
                ThreadPoolProvider.a().a(new PreferencesManager$$ExternalSyntheticLambda4(this));
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public void b(boolean z) {
        try {
            this.i = Boolean.valueOf(z);
            Preferences preferences = this.b;
            if (preferences != null) {
                preferences.b(z);
                if (this.a != null) {
                    ThreadPoolProvider.a().a(new PreferencesManager$$ExternalSyntheticLambda7(this));
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public Map<String, Integer> c() {
        String str;
        Preferences preferences = this.b;
        if (preferences == null || (str = preferences.E) == null) {
            return null;
        }
        return (Map) new Gson().fromJson(str, new TypeToken<Map<String, Integer>>() {
        }.getType());
    }

    public void c(long j2) {
        try {
            Preferences preferences = this.b;
            if (preferences != null) {
                preferences.f(j2);
                PreferencesDAO preferencesDAO = this.a;
                if (preferencesDAO != null) {
                    preferencesDAO.a(this.b);
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long d() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return 0;
        }
        return preferences.q;
    }

    public void d(long j2) {
        try {
            Preferences preferences = this.b;
            if (preferences != null) {
                preferences.g(j2);
                if (this.a != null) {
                    ThreadPoolProvider.a().a(new PreferencesManager$$ExternalSyntheticLambda6(this));
                }
            }
        } catch (Exception | OutOfMemoryError unused) {
        }
    }

    public long e() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return 0;
        }
        return preferences.p;
    }

    public String f() {
        String str = this.g;
        if (str != null) {
            return str;
        }
        Preferences preferences = this.b;
        if (preferences == null) {
            return null;
        }
        return preferences.g;
    }

    public String g() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return null;
        }
        return preferences.e;
    }

    public long h() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return 0;
        }
        return preferences.i;
    }

    public long i() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return 0;
        }
        return preferences.s;
    }

    public Map<String, Integer> j() {
        String str;
        Preferences preferences = this.b;
        if (preferences == null || (str = preferences.D) == null) {
            return null;
        }
        return (Map) new Gson().fromJson(str, new TypeToken<Map<String, Integer>>() {
        }.getType());
    }

    public long k() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return 0;
        }
        return preferences.h;
    }

    public int l() {
        return this.f;
    }

    public boolean n() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return false;
        }
        return preferences.z;
    }

    public boolean o() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return false;
        }
        Boolean bool = this.c;
        return bool != null ? bool.booleanValue() : preferences.A;
    }

    public boolean p() {
        Boolean bool = this.i;
        if (bool != null) {
            return bool.booleanValue();
        }
        Preferences preferences = this.b;
        if (preferences == null) {
            return false;
        }
        return preferences.y;
    }

    public boolean q() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return false;
        }
        Boolean bool = this.d;
        return bool != null ? bool.booleanValue() : preferences.B;
    }

    public boolean r() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return false;
        }
        Boolean bool = this.e;
        return bool != null ? bool.booleanValue() : preferences.C;
    }

    public String s() {
        Preferences preferences = this.b;
        return preferences == null ? "" : preferences.c;
    }

    public String t() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return null;
        }
        return preferences.d;
    }

    public long u() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return 0;
        }
        return preferences.j;
    }

    public Preferences v() {
        try {
            Preferences preferences = this.b;
            if (preferences != null) {
                return preferences;
            }
            if (this.a == null && DatabaseClient.a() != null) {
                this.a = DatabaseClient.a().o();
            }
            PreferencesDAO preferencesDAO = this.a;
            if (preferencesDAO != null) {
                List<Preferences> b2 = preferencesDAO.b();
                if (b2.size() == 1) {
                    Preferences preferences2 = b2.get(0);
                    this.b = preferences2;
                    return preferences2;
                }
            }
            Preferences preferences3 = new Preferences();
            this.b = preferences3;
            preferences3.z = true;
            a(preferences3);
            return this.b;
        } catch (Exception | OutOfMemoryError unused) {
            return null;
        }
    }

    public String w() {
        Preferences preferences = this.b;
        return preferences == null ? "" : preferences.b;
    }

    public long x() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return 0;
        }
        return preferences.o;
    }

    public long y() {
        Preferences preferences = this.b;
        if (preferences == null) {
            return 0;
        }
        return preferences.n;
    }

    public void z() {
        this.f++;
    }
}
