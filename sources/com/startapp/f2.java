package com.startapp;

import android.content.Context;
import com.startapp.sdk.adsbase.remoteconfig.AnalyticsConfig;
import com.startapp.sdk.adsbase.remoteconfig.MetaData;
import com.startapp.sdk.components.ComponentLocator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Sta */
public class f2 {

    /* compiled from: Sta */
    public class a implements Runnable {
        public final /* synthetic */ Context a;
        public final /* synthetic */ String b;
        public final /* synthetic */ Serializable c;

        public a(Context context, String str, Serializable serializable) {
            this.a = context;
            this.b = str;
            this.c = serializable;
        }

        public void run() {
            Context context = this.a;
            String str = this.b;
            Serializable serializable = this.c;
            if (str != null) {
                try {
                    f2.a(f2.c(context, (String) null), str, serializable);
                } catch (Throwable th) {
                    if (f2.a(4)) {
                        i3.a(th);
                    }
                }
            }
        }
    }

    public static void a(Context context, String str, Serializable serializable) {
        try {
            a(c(context, (String) null), str, serializable);
        } catch (Throwable th) {
            if (a(4)) {
                i3.a(th);
            }
        }
    }

    public static void b(Context context, String str, Serializable serializable) {
        try {
            ComponentLocator.a(context).j().execute(new a(context, str, serializable));
        } catch (Throwable th) {
            if (a(1)) {
                i3.a(th);
            }
        }
    }

    public static String c(Context context, String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(context.getFilesDir().toString());
        if (str != null) {
            str2 = File.separator + str;
        } else {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    public static <T> List d(Context context, String str) {
        ArrayList arrayList = new ArrayList();
        try {
            File file = new File(b(context, str));
            if (file.exists()) {
                if (file.isDirectory()) {
                    String[] list = file.list();
                    if (list == null) {
                        return null;
                    }
                    for (String file2 : list) {
                        FileInputStream fileInputStream = new FileInputStream(new File(file, file2));
                        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
                        Object readObject = objectInputStream.readObject();
                        objectInputStream.close();
                        fileInputStream.close();
                        arrayList.add(readObject);
                    }
                    return arrayList;
                }
            }
            return null;
        } catch (Throwable th) {
            if (a(2)) {
                i3.a(th);
            }
        }
    }

    public static <T> T a(Context context, String str, Class<T> cls) {
        try {
            return a(c(context, (String) null), str);
        } catch (Throwable th) {
            if (!a(2)) {
                return null;
            }
            i3.a(th);
            return null;
        }
    }

    public static String b(Context context, String str) {
        String str2;
        StringBuilder sb = new StringBuilder();
        sb.append(context.getCacheDir().toString());
        if (str != null) {
            str2 = File.separator + str;
        } else {
            str2 = "";
        }
        sb.append(str2);
        return sb.toString();
    }

    public static void a(Context context, String str) {
        if (str != null) {
            a(new File(c(context, str)));
            a(new File(b(context, str)));
        }
    }

    public static void a(String str, String str2, Serializable serializable) throws IOException {
        File file = new File(str);
        if (file.exists() || file.mkdirs()) {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(file, str2));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            fileOutputStream.close();
        }
    }

    public static <T> T a(String str, String str2) throws IOException, ClassNotFoundException {
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        File file2 = new File(file, str2);
        if (!file2.exists()) {
            return null;
        }
        FileInputStream fileInputStream = new FileInputStream(file2);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        T readObject = objectInputStream.readObject();
        objectInputStream.close();
        fileInputStream.close();
        return readObject;
    }

    public static void a(File file) {
        File[] listFiles;
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (File a2 : listFiles) {
                a(a2);
            }
        }
        file.delete();
    }

    public static boolean a(int i) {
        try {
            AnalyticsConfig analyticsConfig = MetaData.k.analytics;
            if (analyticsConfig == null || (analyticsConfig.e() & i) != i) {
                return false;
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }
}
