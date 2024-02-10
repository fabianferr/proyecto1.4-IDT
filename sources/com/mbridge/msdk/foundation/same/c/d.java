package com.mbridge.msdk.foundation.same.c;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.core.DownloadRequest;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.tools.aa;
import com.mbridge.msdk.foundation.tools.y;
import java.io.File;
import java.util.concurrent.ThreadPoolExecutor;

/* compiled from: CommonImageLoaderRefactor */
public final class d {
    private final String a;
    private final ThreadPoolExecutor b;
    /* access modifiers changed from: private */
    public final Handler c;

    /* compiled from: CommonImageLoaderRefactor */
    private static final class a {
        /* access modifiers changed from: private */
        public static final d a = new d();
    }

    private d() {
        this.c = new Handler(Looper.getMainLooper());
        this.a = e.b(c.MBRIDGE_700_IMG) + File.separator;
        this.b = g.c();
    }

    public final void a(final String str, final h hVar, final c cVar) {
        try {
            this.b.execute(new Runnable() {
                public final void run() {
                    DownloadRequest a2 = d.this.a(y.d(str), str, hVar, cVar);
                    if (a2 == null) {
                        if (MBridgeConstans.DEBUG) {
                            aa.d("CommonImageLoaderRefactor", "createDownloadRequest error");
                        }
                        if (cVar != null) {
                            d.this.c.post(new Runnable() {
                                public final void run() {
                                    cVar.onFailedLoad("create download request error", str);
                                }
                            });
                            return;
                        }
                        return;
                    }
                    a2.start();
                }
            });
        } catch (Exception e) {
            if (MBridgeConstans.DEBUG) {
                aa.b("CommonImageLoaderRefactor", "loadImage error", e);
            }
        }
    }

    public final Bitmap a(String str) {
        if (MBridgeConstans.DEBUG) {
            aa.a("CommonImageLoaderRefactor", "getImageBitmapByUrl imageUrl = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String str2 = this.a + y.d(str);
        File file = new File(str2);
        if (file.isFile() && file.exists()) {
            try {
                return d(str2);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.b("CommonImageLoaderRefactor", "getImageBitmapByUrl error", e);
                }
            }
        }
        return null;
    }

    public final boolean b(String str) {
        File file;
        if (MBridgeConstans.DEBUG) {
            aa.a("CommonImageLoaderRefactor", "isImageFileExists imageUrl = " + str);
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String d = y.d(str);
            try {
                file = new File(this.a + d);
            } catch (Exception e) {
                if (MBridgeConstans.DEBUG) {
                    aa.b("CommonImageLoaderRefactor", "isImageFileExists error", e);
                }
                file = null;
            }
            if (file == null || !file.isFile() || !file.exists()) {
                return false;
            }
            return true;
        } catch (Exception e2) {
            if (MBridgeConstans.DEBUG) {
                aa.b("CommonImageLoaderRefactor", "isImageFileExists error", e2);
            }
            return false;
        }
    }

    /* access modifiers changed from: private */
    public DownloadRequest<?> a(String str, String str2, h hVar, c cVar) {
        try {
            return MBDownloadManager.getInstance().download(new DownloadMessage(new Object(), str2, str, 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_IMAGE)).withReadTimeout(30000).withConnectTimeout(30000).withWriteTimeout(30000).withDownloadPriority(DownloadPriority.LOW).withHttpRetryCounter(1).withDirectoryPathInternal(this.a).withDownloadStateListener(new b(this.c, this.b, str2, this.a, str, hVar, cVar)).withProgressStateListener((OnProgressStateListener) null).with("do_us_fi_re", Boolean.FALSE.toString()).build();
        } catch (Exception e) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            aa.b("CommonImageLoaderRefactor", "createDownloadRequest error", e);
            return null;
        }
    }

    /* compiled from: CommonImageLoaderRefactor */
    private static final class b implements OnDownloadStateListener<Object> {
        private final Handler a;
        private final ThreadPoolExecutor b;
        /* access modifiers changed from: private */
        public final String c;
        private final String d;
        private final String e;
        private final h f;
        /* access modifiers changed from: private */
        public final c g;

        public final void onCancelDownload(DownloadMessage<Object> downloadMessage) {
        }

        public final void onDownloadStart(DownloadMessage<Object> downloadMessage) {
        }

        public b(Handler handler, ThreadPoolExecutor threadPoolExecutor, String str, String str2, String str3, h hVar, c cVar) {
            this.a = handler;
            this.b = threadPoolExecutor;
            this.c = str;
            this.d = str2;
            this.e = str3;
            this.f = hVar;
            this.g = cVar;
        }

        private Bitmap a(Bitmap bitmap, h hVar) {
            if (hVar == null) {
                return bitmap;
            }
            try {
                return hVar.a(bitmap);
            } catch (Exception e2) {
                if (MBridgeConstans.DEBUG) {
                    aa.b("CommonImageLoaderRefactor", "handlerImageTransformation error", e2);
                }
                return bitmap;
            }
        }

        private void a(final String str) {
            if (this.g != null) {
                this.a.post(new Runnable() {
                    public final void run() {
                        try {
                            b.this.g.onFailedLoad(b.this.c, str);
                        } catch (Exception e) {
                            if (MBridgeConstans.DEBUG) {
                                aa.b("CommonImageLoaderRefactor", "callbackForFailed error", e);
                            }
                        }
                    }
                });
            }
        }

        public final void onDownloadError(DownloadMessage<Object> downloadMessage, DownloadError downloadError) {
            if (MBridgeConstans.DEBUG) {
                aa.a("CommonImageLoaderRefactor", "onDownloadError imageUrl = " + downloadError.getException().getLocalizedMessage());
            }
            a(downloadError.getException().getLocalizedMessage());
        }

        public final void onDownloadComplete(DownloadMessage<Object> downloadMessage) {
            File file;
            if (MBridgeConstans.DEBUG) {
                aa.a("CommonImageLoaderRefactor", "onDownloadComplete imageUrl = " + this.c + " imagePath = " + this.d + this.e);
                try {
                    file = new File(this.d + this.e);
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        aa.b("CommonImageLoaderRefactor", "onDownloadComplete error", e2);
                    }
                    file = null;
                }
                if (file == null || !file.isFile() || !file.exists()) {
                    aa.d("CommonImageLoaderRefactor", "onDownloadComplete file not exist");
                } else {
                    aa.a("CommonImageLoaderRefactor", "onDownloadComplete file size = " + file.length());
                }
            }
            this.b.execute(new Runnable() {
                public final void run() {
                    b.a(b.this);
                }
            });
        }

        static /* synthetic */ void a(b bVar) {
            if (bVar.g != null) {
                try {
                    Bitmap c2 = d.d(bVar.d + bVar.e);
                    if (c2 == null) {
                        bVar.a("bitmap decode failed");
                        return;
                    }
                    final Bitmap a2 = bVar.a(c2, bVar.f);
                    if (a2 == null) {
                        bVar.a("bitmap transformation failed");
                    } else if (bVar.g != null) {
                        bVar.a.post(new Runnable() {
                            public final void run() {
                                try {
                                    b.this.g.onSuccessLoad(a2, b.this.c);
                                } catch (Exception e) {
                                    if (MBridgeConstans.DEBUG) {
                                        aa.b("CommonImageLoaderRefactor", "callbackForSuccess error", e);
                                    }
                                }
                            }
                        });
                    }
                } catch (Exception e2) {
                    if (MBridgeConstans.DEBUG) {
                        aa.a("CommonImageLoaderRefactor", "onDownloadComplete decodeBitmap error = " + e2.getLocalizedMessage());
                    }
                    bVar.a("bitmap decode failed");
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static Bitmap d(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inDither = true;
        return BitmapFactory.decodeFile(str, options);
    }
}
