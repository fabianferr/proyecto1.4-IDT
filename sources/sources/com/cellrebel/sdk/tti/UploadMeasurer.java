package com.cellrebel.sdk.tti;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class UploadMeasurer {
    private final OkHttpClient a;
    private Call b;

    public interface CompletionHandler {
        void a();

        void a(String str);
    }

    class a implements Callback {
        final /* synthetic */ CompletionHandler a;
        final /* synthetic */ File b;

        a(CompletionHandler completionHandler, File file) {
            this.a = completionHandler;
            this.b = file;
        }

        public void onFailure(Call call, IOException iOException) {
            this.a.a(iOException.toString());
        }

        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                this.a.a();
            } else {
                response.code();
                CompletionHandler completionHandler = this.a;
                completionHandler.a("Request failed with code " + response.code());
            }
            this.b.delete();
        }
    }

    public UploadMeasurer(OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }

    private File a(int i) {
        byte[] bArr = new byte[i];
        Random random = new Random();
        File createTempFile = File.createTempFile("upload", ".bin");
        FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
        try {
            random.nextBytes(bArr);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return createTempFile;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public void a() {
        Call call = this.b;
        if (call != null) {
            call.cancel();
        }
    }

    public void a(String str, int i, String str2, String str3, CompletionHandler completionHandler) {
        try {
            File a2 = a(i * 1024);
            Request.Builder builder = new Request.Builder();
            Request.Builder url = builder.url(str + "?guid=" + str2);
            StringBuilder sb = new StringBuilder("Bearer ");
            sb.append(str3);
            Request build = url.header("Authorization", sb.toString()).post(RequestBody.create(MediaType.parse("application/octet-stream"), a2)).build();
            this.b = this.a.newCall(build);
            build.url().port();
            this.b.enqueue(new a(completionHandler, a2));
        } catch (IOException e) {
            completionHandler.a(e.toString());
        }
    }
}
