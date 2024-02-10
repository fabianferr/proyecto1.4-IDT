package com.cellrebel.sdk.trafficprofile.utils;

import android.content.Context;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileManager {
    private final Context a;
    private BufferedReader b;

    public FileManager(Context context) {
        this.a = context;
    }

    public String a() {
        return this.a.getCacheDir().getAbsolutePath();
    }

    public void a(String str) {
        BufferedReader bufferedReader = this.b;
        if (bufferedReader != null) {
            bufferedReader.close();
            this.b = null;
        }
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
    }

    public String b(String str) {
        if (this.b == null) {
            this.b = new BufferedReader(new FileReader(str));
        }
        return this.b.readLine();
    }
}
