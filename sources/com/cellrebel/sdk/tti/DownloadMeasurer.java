package com.cellrebel.sdk.tti;

import com.vungle.ads.internal.presenter.NativeAdPresenter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class DownloadMeasurer {
    private final OkHttpClient a;
    private Call b;

    public interface CompletionHandler {
        void a(long j, long j2, long j3);

        void a(String str);
    }

    class a implements Callback {
        final /* synthetic */ long a;
        final /* synthetic */ CompletionHandler b;

        a(long j, CompletionHandler completionHandler) {
            this.a = j;
            this.b = completionHandler;
        }

        public void onFailure(Call call, IOException iOException) {
            this.b.a(iOException.toString());
        }

        public void onResponse(Call call, Response response) {
            ResponseBody body = response.body();
            if (!response.isSuccessful() || body == null) {
                response.code();
                CompletionHandler completionHandler = this.b;
                completionHandler.a("Request failed with the code " + response.code());
                return;
            }
            File createTempFile = File.createTempFile(NativeAdPresenter.DOWNLOAD, ".bin");
            DownloadMeasurer.this.a(body.byteStream(), createTempFile);
            long length = createTempFile.length();
            createTempFile.length();
            body.contentLength();
            createTempFile.delete();
            this.b.a(System.currentTimeMillis() - this.a, length, response.receivedResponseAtMillis() - response.sentRequestAtMillis());
        }
    }

    public DownloadMeasurer(OkHttpClient okHttpClient) {
        this.a = okHttpClient;
    }

    /* access modifiers changed from: private */
    public void a(InputStream inputStream, File file) {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[4096];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.flush();
                    fileOutputStream.close();
                    return;
                }
            }
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
        Request.Builder builder = new Request.Builder();
        Request.Builder url = builder.url(str + "?size=" + (i * 1024) + "&guid=" + str2);
        StringBuilder sb = new StringBuilder("Bearer ");
        sb.append(str3);
        Request build = url.header("Authorization", sb.toString()).build();
        try {
            this.b = this.a.newCall(build);
            build.url().port();
            this.b.enqueue(new a(System.currentTimeMillis(), completionHandler));
        } catch (Exception e) {
            completionHandler.a(e.toString());
        }
    }
}
