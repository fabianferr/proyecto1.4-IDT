package com.google.android.gms.vision;

import android.content.Context;
import android.graphics.ImageFormat;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.SystemClock;
import android.util.Log;
import android.view.SurfaceHolder;
import com.google.android.gms.common.images.Size;
import com.google.android.gms.common.internal.Preconditions;
import java.nio.ByteBuffer;
import java.util.IdentityHashMap;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
public class CameraSource {
    public static final int CAMERA_FACING_BACK = 0;
    public static final int CAMERA_FACING_FRONT = 1;
    /* access modifiers changed from: private */
    public Context zza;
    /* access modifiers changed from: private */
    public final Object zzb;
    /* access modifiers changed from: private */
    @Nullable
    public Camera zzc;
    /* access modifiers changed from: private */
    public int zzd;
    /* access modifiers changed from: private */
    public int zze;
    /* access modifiers changed from: private */
    public Size zzf;
    /* access modifiers changed from: private */
    public float zzg;
    /* access modifiers changed from: private */
    public int zzh;
    /* access modifiers changed from: private */
    public int zzi;
    /* access modifiers changed from: private */
    public boolean zzj;
    /* access modifiers changed from: private */
    @Nullable
    public String zzk;
    @Nullable
    private SurfaceTexture zzl;
    @Nullable
    private Thread zzm;
    /* access modifiers changed from: private */
    public zza zzn;
    /* access modifiers changed from: private */
    public final IdentityHashMap<byte[], ByteBuffer> zzo;

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public interface PictureCallback {
        void onPictureTaken(byte[] bArr);
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public interface ShutterCallback {
        void onShutter();
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    private class zzb implements Camera.PreviewCallback {
        private zzb() {
        }

        public final void onPreviewFrame(byte[] bArr, Camera camera) {
            CameraSource.this.zzn.zza(bArr, camera);
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    private class zzc implements Camera.PictureCallback {
        /* access modifiers changed from: private */
        @Nullable
        public PictureCallback zza;

        private zzc() {
        }

        public final void onPictureTaken(byte[] bArr, Camera camera) {
            PictureCallback pictureCallback = this.zza;
            if (pictureCallback != null) {
                pictureCallback.onPictureTaken(bArr);
            }
            synchronized (CameraSource.this.zzb) {
                if (CameraSource.this.zzc != null) {
                    CameraSource.this.zzc.startPreview();
                }
            }
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    private static class zzd implements Camera.ShutterCallback {
        /* access modifiers changed from: private */
        @Nullable
        public ShutterCallback zza;

        private zzd() {
        }

        public final void onShutter() {
            ShutterCallback shutterCallback = this.zza;
            if (shutterCallback != null) {
                shutterCallback.onShutter();
            }
        }
    }

    public void release() {
        synchronized (this.zzb) {
            stop();
            this.zzn.zza();
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    static class zze {
        private Size zza;
        private Size zzb;

        public zze(Camera.Size size, @Nullable Camera.Size size2) {
            this.zza = new Size(size.width, size.height);
            if (size2 != null) {
                this.zzb = new Size(size2.width, size2.height);
            }
        }

        public final Size zza() {
            return this.zza;
        }

        @Nullable
        public final Size zzb() {
            return this.zzb;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x003e, code lost:
        return r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.vision.CameraSource start() throws java.io.IOException {
        /*
            r3 = this;
            java.lang.Object r0 = r3.zzb
            monitor-enter(r0)
            android.hardware.Camera r1 = r3.zzc     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return r3
        L_0x0009:
            android.hardware.Camera r1 = r3.zza()     // Catch:{ all -> 0x003f }
            r3.zzc = r1     // Catch:{ all -> 0x003f }
            android.graphics.SurfaceTexture r1 = new android.graphics.SurfaceTexture     // Catch:{ all -> 0x003f }
            r2 = 100
            r1.<init>(r2)     // Catch:{ all -> 0x003f }
            r3.zzl = r1     // Catch:{ all -> 0x003f }
            android.hardware.Camera r2 = r3.zzc     // Catch:{ all -> 0x003f }
            r2.setPreviewTexture(r1)     // Catch:{ all -> 0x003f }
            android.hardware.Camera r1 = r3.zzc     // Catch:{ all -> 0x003f }
            r1.startPreview()     // Catch:{ all -> 0x003f }
            java.lang.Thread r1 = new java.lang.Thread     // Catch:{ all -> 0x003f }
            com.google.android.gms.vision.CameraSource$zza r2 = r3.zzn     // Catch:{ all -> 0x003f }
            r1.<init>(r2)     // Catch:{ all -> 0x003f }
            r3.zzm = r1     // Catch:{ all -> 0x003f }
            java.lang.String r2 = "gms.vision.CameraSource"
            r1.setName(r2)     // Catch:{ all -> 0x003f }
            com.google.android.gms.vision.CameraSource$zza r1 = r3.zzn     // Catch:{ all -> 0x003f }
            r2 = 1
            r1.zza(r2)     // Catch:{ all -> 0x003f }
            java.lang.Thread r1 = r3.zzm     // Catch:{ all -> 0x003f }
            if (r1 == 0) goto L_0x003d
            r1.start()     // Catch:{ all -> 0x003f }
        L_0x003d:
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            return r3
        L_0x003f:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003f }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.start():com.google.android.gms.vision.CameraSource");
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    private class zza implements Runnable {
        @Nullable
        private Detector<?> zza;
        private long zzb = SystemClock.elapsedRealtime();
        private final Object zzc = new Object();
        private boolean zzd = true;
        private long zze;
        private int zzf = 0;
        @Nullable
        private ByteBuffer zzg;

        zza(Detector<?> detector) {
            this.zza = detector;
        }

        /* access modifiers changed from: package-private */
        public final void zza() {
            Detector<?> detector = this.zza;
            if (detector != null) {
                detector.release();
                this.zza = null;
            }
        }

        /* access modifiers changed from: package-private */
        public final void zza(boolean z) {
            synchronized (this.zzc) {
                this.zzd = z;
                this.zzc.notifyAll();
            }
        }

        /* access modifiers changed from: package-private */
        public final void zza(byte[] bArr, Camera camera) {
            synchronized (this.zzc) {
                ByteBuffer byteBuffer = this.zzg;
                if (byteBuffer != null) {
                    camera.addCallbackBuffer(byteBuffer.array());
                    this.zzg = null;
                }
                if (!CameraSource.this.zzo.containsKey(bArr)) {
                    Log.d("CameraSource", "Skipping frame. Could not find ByteBuffer associated with the image data from the camera.");
                    return;
                }
                this.zze = SystemClock.elapsedRealtime() - this.zzb;
                this.zzf++;
                this.zzg = (ByteBuffer) CameraSource.this.zzo.get(bArr);
                this.zzc.notifyAll();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            ((com.google.android.gms.vision.Detector) com.google.android.gms.common.internal.Preconditions.checkNotNull(r6.zza)).receiveFrame(r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x008c, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x008e, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            android.util.Log.e("CameraSource", "Exception thrown from receiver.", r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00b1, code lost:
            ((android.hardware.Camera) com.google.android.gms.common.internal.Preconditions.checkNotNull(com.google.android.gms.vision.CameraSource.zzb(r6.zzh))).addCallbackBuffer(((java.nio.ByteBuffer) com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)).array());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ca, code lost:
            throw r0;
         */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x001f A[Catch:{ InterruptedException -> 0x0011 }] */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x001d A[SYNTHETIC] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r6 = this;
            L_0x0000:
                java.lang.Object r0 = r6.zzc
                monitor-enter(r0)
            L_0x0003:
                boolean r1 = r6.zzd     // Catch:{ all -> 0x00cb }
                if (r1 == 0) goto L_0x001b
                java.nio.ByteBuffer r2 = r6.zzg     // Catch:{ all -> 0x00cb }
                if (r2 != 0) goto L_0x001b
                java.lang.Object r1 = r6.zzc     // Catch:{ InterruptedException -> 0x0011 }
                r1.wait()     // Catch:{ InterruptedException -> 0x0011 }
                goto L_0x0003
            L_0x0011:
                r1 = move-exception
                java.lang.String r2 = "CameraSource"
                java.lang.String r3 = "Frame processing loop terminated."
                android.util.Log.d(r2, r3, r1)     // Catch:{ all -> 0x00cb }
                monitor-exit(r0)     // Catch:{ all -> 0x00cb }
                return
            L_0x001b:
                if (r1 != 0) goto L_0x001f
                monitor-exit(r0)     // Catch:{ all -> 0x00cb }
                return
            L_0x001f:
                com.google.android.gms.vision.Frame$Builder r1 = new com.google.android.gms.vision.Frame$Builder     // Catch:{ all -> 0x00cb }
                r1.<init>()     // Catch:{ all -> 0x00cb }
                java.nio.ByteBuffer r2 = r6.zzg     // Catch:{ all -> 0x00cb }
                java.lang.Object r2 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)     // Catch:{ all -> 0x00cb }
                java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2     // Catch:{ all -> 0x00cb }
                com.google.android.gms.vision.CameraSource r3 = com.google.android.gms.vision.CameraSource.this     // Catch:{ all -> 0x00cb }
                com.google.android.gms.common.images.Size r3 = r3.zzf     // Catch:{ all -> 0x00cb }
                int r3 = r3.getWidth()     // Catch:{ all -> 0x00cb }
                com.google.android.gms.vision.CameraSource r4 = com.google.android.gms.vision.CameraSource.this     // Catch:{ all -> 0x00cb }
                com.google.android.gms.common.images.Size r4 = r4.zzf     // Catch:{ all -> 0x00cb }
                int r4 = r4.getHeight()     // Catch:{ all -> 0x00cb }
                r5 = 17
                com.google.android.gms.vision.Frame$Builder r1 = r1.setImageData(r2, r3, r4, r5)     // Catch:{ all -> 0x00cb }
                int r2 = r6.zzf     // Catch:{ all -> 0x00cb }
                com.google.android.gms.vision.Frame$Builder r1 = r1.setId(r2)     // Catch:{ all -> 0x00cb }
                long r2 = r6.zze     // Catch:{ all -> 0x00cb }
                com.google.android.gms.vision.Frame$Builder r1 = r1.setTimestampMillis(r2)     // Catch:{ all -> 0x00cb }
                com.google.android.gms.vision.CameraSource r2 = com.google.android.gms.vision.CameraSource.this     // Catch:{ all -> 0x00cb }
                int r2 = r2.zze     // Catch:{ all -> 0x00cb }
                com.google.android.gms.vision.Frame$Builder r1 = r1.setRotation(r2)     // Catch:{ all -> 0x00cb }
                com.google.android.gms.vision.Frame r1 = r1.build()     // Catch:{ all -> 0x00cb }
                java.nio.ByteBuffer r2 = r6.zzg     // Catch:{ all -> 0x00cb }
                r3 = 0
                r6.zzg = r3     // Catch:{ all -> 0x00cb }
                monitor-exit(r0)     // Catch:{ all -> 0x00cb }
                com.google.android.gms.vision.Detector<?> r0 = r6.zza     // Catch:{ Exception -> 0x008e }
                java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)     // Catch:{ Exception -> 0x008e }
                com.google.android.gms.vision.Detector r0 = (com.google.android.gms.vision.Detector) r0     // Catch:{ Exception -> 0x008e }
                r0.receiveFrame(r1)     // Catch:{ Exception -> 0x008e }
                com.google.android.gms.vision.CameraSource r0 = com.google.android.gms.vision.CameraSource.this
                android.hardware.Camera r0 = r0.zzc
                java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
                android.hardware.Camera r0 = (android.hardware.Camera) r0
                java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
                java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
                byte[] r1 = r1.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x008c:
                r0 = move-exception
                goto L_0x00b1
            L_0x008e:
                r0 = move-exception
                java.lang.String r1 = "CameraSource"
                java.lang.String r3 = "Exception thrown from receiver."
                android.util.Log.e(r1, r3, r0)     // Catch:{ all -> 0x008c }
                com.google.android.gms.vision.CameraSource r0 = com.google.android.gms.vision.CameraSource.this
                android.hardware.Camera r0 = r0.zzc
                java.lang.Object r0 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r0)
                android.hardware.Camera r0 = (android.hardware.Camera) r0
                java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
                java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
                byte[] r1 = r1.array()
                r0.addCallbackBuffer(r1)
                goto L_0x0000
            L_0x00b1:
                com.google.android.gms.vision.CameraSource r1 = com.google.android.gms.vision.CameraSource.this
                android.hardware.Camera r1 = r1.zzc
                java.lang.Object r1 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r1)
                android.hardware.Camera r1 = (android.hardware.Camera) r1
                java.lang.Object r2 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
                java.nio.ByteBuffer r2 = (java.nio.ByteBuffer) r2
                byte[] r2 = r2.array()
                r1.addCallbackBuffer(r2)
                throw r0
            L_0x00cb:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x00cb }
                goto L_0x00cf
            L_0x00ce:
                throw r1
            L_0x00cf:
                goto L_0x00ce
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.zza.run():void");
        }
    }

    /* compiled from: com.google.android.gms:play-services-vision-common@@19.1.3 */
    public static class Builder {
        private final Detector<?> zza;
        private CameraSource zzb;

        public Builder(Context context, Detector<?> detector) {
            CameraSource cameraSource = new CameraSource();
            this.zzb = cameraSource;
            if (context == null) {
                throw new IllegalArgumentException("No context supplied.");
            } else if (detector != null) {
                this.zza = detector;
                Context unused = cameraSource.zza = context;
            } else {
                throw new IllegalArgumentException("No detector supplied.");
            }
        }

        public Builder setRequestedFps(float f) {
            if (f > 0.0f) {
                float unused = this.zzb.zzg = f;
                return this;
            }
            StringBuilder sb = new StringBuilder(28);
            sb.append("Invalid fps: ");
            sb.append(f);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setRequestedPreviewSize(int i, int i2) {
            if (i <= 0 || i > 1000000 || i2 <= 0 || i2 > 1000000) {
                StringBuilder sb = new StringBuilder(45);
                sb.append("Invalid preview size: ");
                sb.append(i);
                sb.append("x");
                sb.append(i2);
                throw new IllegalArgumentException(sb.toString());
            }
            int unused = this.zzb.zzh = i;
            int unused2 = this.zzb.zzi = i2;
            return this;
        }

        public Builder setFacing(int i) {
            if (i == 0 || i == 1) {
                int unused = this.zzb.zzd = i;
                return this;
            }
            StringBuilder sb = new StringBuilder(27);
            sb.append("Invalid camera: ");
            sb.append(i);
            throw new IllegalArgumentException(sb.toString());
        }

        public Builder setAutoFocusEnabled(boolean z) {
            boolean unused = this.zzb.zzj = z;
            return this;
        }

        public Builder setFocusMode(String str) {
            if (str.equals("continuous-video") || str.equals("continuous-picture")) {
                String unused = this.zzb.zzk = str;
            } else {
                Log.w("CameraSource", String.format("FocusMode %s is not supported for now.", new Object[]{str}));
                String unused2 = this.zzb.zzk = null;
            }
            return this;
        }

        public CameraSource build() {
            CameraSource cameraSource = this.zzb;
            cameraSource.getClass();
            zza unused = cameraSource.zzn = new zza(this.zza);
            return this.zzb;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002e, code lost:
        return r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.vision.CameraSource start(android.view.SurfaceHolder r3) throws java.io.IOException {
        /*
            r2 = this;
            java.lang.Object r0 = r2.zzb
            monitor-enter(r0)
            android.hardware.Camera r1 = r2.zzc     // Catch:{ all -> 0x002f }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r2
        L_0x0009:
            android.hardware.Camera r1 = r2.zza()     // Catch:{ all -> 0x002f }
            r2.zzc = r1     // Catch:{ all -> 0x002f }
            r1.setPreviewDisplay(r3)     // Catch:{ all -> 0x002f }
            android.hardware.Camera r3 = r2.zzc     // Catch:{ all -> 0x002f }
            r3.startPreview()     // Catch:{ all -> 0x002f }
            java.lang.Thread r3 = new java.lang.Thread     // Catch:{ all -> 0x002f }
            com.google.android.gms.vision.CameraSource$zza r1 = r2.zzn     // Catch:{ all -> 0x002f }
            r3.<init>(r1)     // Catch:{ all -> 0x002f }
            r2.zzm = r3     // Catch:{ all -> 0x002f }
            com.google.android.gms.vision.CameraSource$zza r3 = r2.zzn     // Catch:{ all -> 0x002f }
            r1 = 1
            r3.zza(r1)     // Catch:{ all -> 0x002f }
            java.lang.Thread r3 = r2.zzm     // Catch:{ all -> 0x002f }
            if (r3 == 0) goto L_0x002d
            r3.start()     // Catch:{ all -> 0x002f }
        L_0x002d:
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            return r2
        L_0x002f:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002f }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.start(android.view.SurfaceHolder):com.google.android.gms.vision.CameraSource");
    }

    public void stop() {
        synchronized (this.zzb) {
            this.zzn.zza(false);
            Thread thread = this.zzm;
            if (thread != null) {
                try {
                    thread.join();
                } catch (InterruptedException unused) {
                    Log.d("CameraSource", "Frame processing thread interrupted on release.");
                }
                this.zzm = null;
            }
            Camera camera = this.zzc;
            if (camera != null) {
                camera.stopPreview();
                this.zzc.setPreviewCallbackWithBuffer((Camera.PreviewCallback) null);
                try {
                    this.zzc.setPreviewTexture((SurfaceTexture) null);
                    this.zzl = null;
                    this.zzc.setPreviewDisplay((SurfaceHolder) null);
                } catch (Exception e) {
                    String valueOf = String.valueOf(e);
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32);
                    sb.append("Failed to clear camera preview: ");
                    sb.append(valueOf);
                    Log.e("CameraSource", sb.toString());
                }
                ((Camera) Preconditions.checkNotNull(this.zzc)).release();
                this.zzc = null;
            }
            this.zzo.clear();
        }
    }

    public Size getPreviewSize() {
        return this.zzf;
    }

    public int getCameraFacing() {
        return this.zzd;
    }

    public void takePicture(@Nullable ShutterCallback shutterCallback, @Nullable PictureCallback pictureCallback) {
        synchronized (this.zzb) {
            if (this.zzc != null) {
                zzd zzd2 = new zzd();
                ShutterCallback unused = zzd2.zza = shutterCallback;
                zzc zzc2 = new zzc();
                PictureCallback unused2 = zzc2.zza = pictureCallback;
                this.zzc.takePicture(zzd2, (Camera.PictureCallback) null, (Camera.PictureCallback) null, zzc2);
            }
        }
    }

    private CameraSource() {
        this.zzb = new Object();
        this.zzd = 0;
        this.zzg = 30.0f;
        this.zzh = 1024;
        this.zzi = 768;
        this.zzj = false;
        this.zzo = new IdentityHashMap<>();
    }

    /* JADX WARNING: Removed duplicated region for block: B:55:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x01b1  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x01c7  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0204  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x020a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.hardware.Camera zza() throws java.io.IOException {
        /*
            r17 = this;
            r0 = r17
            int r1 = r0.zzd
            android.hardware.Camera$CameraInfo r2 = new android.hardware.Camera$CameraInfo
            r2.<init>()
            r3 = 0
            r4 = 0
        L_0x000b:
            int r5 = android.hardware.Camera.getNumberOfCameras()
            r6 = -1
            if (r4 >= r5) goto L_0x001d
            android.hardware.Camera.getCameraInfo(r4, r2)
            int r5 = r2.facing
            if (r5 != r1) goto L_0x001a
            goto L_0x001e
        L_0x001a:
            int r4 = r4 + 1
            goto L_0x000b
        L_0x001d:
            r4 = -1
        L_0x001e:
            if (r4 == r6) goto L_0x024f
            android.hardware.Camera r1 = android.hardware.Camera.open(r4)
            int r2 = r0.zzh
            int r5 = r0.zzi
            android.hardware.Camera$Parameters r6 = r1.getParameters()
            java.util.List r7 = r6.getSupportedPreviewSizes()
            java.util.List r6 = r6.getSupportedPictureSizes()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r9 = r7.iterator()
        L_0x003d:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x007d
            java.lang.Object r10 = r9.next()
            android.hardware.Camera$Size r10 = (android.hardware.Camera.Size) r10
            int r11 = r10.width
            float r11 = (float) r11
            int r12 = r10.height
            float r12 = (float) r12
            float r11 = r11 / r12
            java.util.Iterator r12 = r6.iterator()
        L_0x0054:
            boolean r13 = r12.hasNext()
            if (r13 == 0) goto L_0x003d
            java.lang.Object r13 = r12.next()
            android.hardware.Camera$Size r13 = (android.hardware.Camera.Size) r13
            int r14 = r13.width
            float r14 = (float) r14
            int r15 = r13.height
            float r15 = (float) r15
            float r14 = r14 / r15
            float r14 = r11 - r14
            float r14 = java.lang.Math.abs(r14)
            r15 = 1008981770(0x3c23d70a, float:0.01)
            int r14 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
            if (r14 >= 0) goto L_0x0054
            com.google.android.gms.vision.CameraSource$zze r11 = new com.google.android.gms.vision.CameraSource$zze
            r11.<init>(r10, r13)
            r8.add(r11)
            goto L_0x003d
        L_0x007d:
            int r6 = r8.size()
            java.lang.String r9 = "CameraSource"
            r10 = 0
            if (r6 != 0) goto L_0x00a4
            java.lang.String r6 = "No preview sizes have a corresponding same-aspect-ratio picture size"
            android.util.Log.w(r9, r6)
            java.util.Iterator r6 = r7.iterator()
        L_0x008f:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x00a4
            java.lang.Object r7 = r6.next()
            android.hardware.Camera$Size r7 = (android.hardware.Camera.Size) r7
            com.google.android.gms.vision.CameraSource$zze r11 = new com.google.android.gms.vision.CameraSource$zze
            r11.<init>(r7, r10)
            r8.add(r11)
            goto L_0x008f
        L_0x00a4:
            r6 = r8
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            int r6 = r8.size()
            r7 = 2147483647(0x7fffffff, float:NaN)
            r12 = r10
            r11 = 0
            r13 = 2147483647(0x7fffffff, float:NaN)
        L_0x00b3:
            if (r11 >= r6) goto L_0x00db
            java.lang.Object r14 = r8.get(r11)
            int r11 = r11 + 1
            com.google.android.gms.vision.CameraSource$zze r14 = (com.google.android.gms.vision.CameraSource.zze) r14
            com.google.android.gms.common.images.Size r15 = r14.zza()
            int r16 = r15.getWidth()
            int r16 = r16 - r2
            int r16 = java.lang.Math.abs(r16)
            int r15 = r15.getHeight()
            int r15 = r15 - r5
            int r15 = java.lang.Math.abs(r15)
            int r15 = r16 + r15
            if (r15 >= r13) goto L_0x00b3
            r12 = r14
            r13 = r15
            goto L_0x00b3
        L_0x00db:
            java.lang.Object r2 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r12)
            com.google.android.gms.vision.CameraSource$zze r2 = (com.google.android.gms.vision.CameraSource.zze) r2
            if (r2 == 0) goto L_0x0247
            com.google.android.gms.common.images.Size r5 = r2.zzb()
            com.google.android.gms.common.images.Size r2 = r2.zza()
            r0.zzf = r2
            float r2 = r0.zzg
            r6 = 1148846080(0x447a0000, float:1000.0)
            float r2 = r2 * r6
            int r2 = (int) r2
            android.hardware.Camera$Parameters r6 = r1.getParameters()
            java.util.List r6 = r6.getSupportedPreviewFpsRange()
            java.util.Iterator r6 = r6.iterator()
            r8 = r10
        L_0x0101:
            boolean r11 = r6.hasNext()
            r12 = 1
            if (r11 == 0) goto L_0x0124
            java.lang.Object r11 = r6.next()
            int[] r11 = (int[]) r11
            r13 = r11[r3]
            int r13 = r2 - r13
            r12 = r11[r12]
            int r12 = r2 - r12
            int r13 = java.lang.Math.abs(r13)
            int r12 = java.lang.Math.abs(r12)
            int r13 = r13 + r12
            if (r13 >= r7) goto L_0x0101
            r8 = r11
            r7 = r13
            goto L_0x0101
        L_0x0124:
            java.lang.Object r2 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r8)
            int[] r2 = (int[]) r2
            if (r2 == 0) goto L_0x023f
            android.hardware.Camera$Parameters r6 = r1.getParameters()
            if (r5 == 0) goto L_0x013d
            int r7 = r5.getWidth()
            int r5 = r5.getHeight()
            r6.setPictureSize(r7, r5)
        L_0x013d:
            com.google.android.gms.common.images.Size r5 = r0.zzf
            int r5 = r5.getWidth()
            com.google.android.gms.common.images.Size r7 = r0.zzf
            int r7 = r7.getHeight()
            r6.setPreviewSize(r5, r7)
            r5 = r2[r3]
            r2 = r2[r12]
            r6.setPreviewFpsRange(r5, r2)
            r2 = 17
            r6.setPreviewFormat(r2)
            android.content.Context r2 = r0.zza
            java.lang.String r5 = "window"
            java.lang.Object r2 = r2.getSystemService(r5)
            android.view.WindowManager r2 = (android.view.WindowManager) r2
            java.lang.Object r2 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
            android.view.WindowManager r2 = (android.view.WindowManager) r2
            android.view.Display r2 = r2.getDefaultDisplay()
            int r2 = r2.getRotation()
            if (r2 == 0) goto L_0x019a
            if (r2 == r12) goto L_0x0197
            r5 = 2
            if (r2 == r5) goto L_0x0194
            r5 = 3
            if (r2 == r5) goto L_0x0191
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r7 = 31
            r5.<init>(r7)
            java.lang.String r7 = "Bad rotation value: "
            r5.append(r7)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            android.util.Log.e(r9, r2)
            goto L_0x019a
        L_0x0191:
            r2 = 270(0x10e, float:3.78E-43)
            goto L_0x019b
        L_0x0194:
            r2 = 180(0xb4, float:2.52E-43)
            goto L_0x019b
        L_0x0197:
            r2 = 90
            goto L_0x019b
        L_0x019a:
            r2 = 0
        L_0x019b:
            android.hardware.Camera$CameraInfo r5 = new android.hardware.Camera$CameraInfo
            r5.<init>()
            android.hardware.Camera.getCameraInfo(r4, r5)
            int r4 = r5.facing
            if (r4 != r12) goto L_0x01b1
            int r4 = r5.orientation
            int r4 = r4 + r2
            int r4 = r4 % 360
            int r2 = 360 - r4
            int r2 = r2 % 360
            goto L_0x01b9
        L_0x01b1:
            int r4 = r5.orientation
            int r4 = r4 - r2
            int r4 = r4 + 360
            int r4 = r4 % 360
            r2 = r4
        L_0x01b9:
            int r5 = r4 / 90
            r0.zze = r5
            r1.setDisplayOrientation(r2)
            r6.setRotation(r4)
            java.lang.String r2 = r0.zzk
            if (r2 == 0) goto L_0x01f0
            java.util.List r2 = r6.getSupportedFocusModes()
            java.lang.String r4 = r0.zzk
            boolean r2 = r2.contains(r4)
            if (r2 == 0) goto L_0x01df
            java.lang.String r2 = r0.zzk
            java.lang.Object r2 = com.google.android.gms.common.internal.Preconditions.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            r6.setFocusMode(r2)
            goto L_0x01f0
        L_0x01df:
            java.lang.Object[] r2 = new java.lang.Object[r12]
            java.lang.String r4 = r0.zzk
            r2[r3] = r4
            java.lang.String r3 = "FocusMode %s is not supported on this device."
            java.lang.String r2 = java.lang.String.format(r3, r2)
            android.util.Log.w(r9, r2)
            r0.zzk = r10
        L_0x01f0:
            java.lang.String r2 = r0.zzk
            if (r2 != 0) goto L_0x020f
            boolean r2 = r0.zzj
            if (r2 == 0) goto L_0x020f
            java.util.List r2 = r6.getSupportedFocusModes()
            java.lang.String r3 = "continuous-video"
            boolean r2 = r2.contains(r3)
            if (r2 == 0) goto L_0x020a
            r6.setFocusMode(r3)
            r0.zzk = r3
            goto L_0x020f
        L_0x020a:
            java.lang.String r2 = "Camera auto focus is not supported on this device."
            android.util.Log.i(r9, r2)
        L_0x020f:
            r1.setParameters(r6)
            com.google.android.gms.vision.CameraSource$zzb r2 = new com.google.android.gms.vision.CameraSource$zzb
            r2.<init>()
            r1.setPreviewCallbackWithBuffer(r2)
            com.google.android.gms.common.images.Size r2 = r0.zzf
            byte[] r2 = r0.zza((com.google.android.gms.common.images.Size) r2)
            r1.addCallbackBuffer(r2)
            com.google.android.gms.common.images.Size r2 = r0.zzf
            byte[] r2 = r0.zza((com.google.android.gms.common.images.Size) r2)
            r1.addCallbackBuffer(r2)
            com.google.android.gms.common.images.Size r2 = r0.zzf
            byte[] r2 = r0.zza((com.google.android.gms.common.images.Size) r2)
            r1.addCallbackBuffer(r2)
            com.google.android.gms.common.images.Size r2 = r0.zzf
            byte[] r2 = r0.zza((com.google.android.gms.common.images.Size) r2)
            r1.addCallbackBuffer(r2)
            return r1
        L_0x023f:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Could not find suitable preview frames per second range."
            r1.<init>(r2)
            throw r1
        L_0x0247:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Could not find suitable preview size."
            r1.<init>(r2)
            throw r1
        L_0x024f:
            java.io.IOException r1 = new java.io.IOException
            java.lang.String r2 = "Could not find requested camera."
            r1.<init>(r2)
            goto L_0x0258
        L_0x0257:
            throw r1
        L_0x0258:
            goto L_0x0257
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.vision.CameraSource.zza():android.hardware.Camera");
    }

    private final byte[] zza(Size size) {
        double height = (double) (((long) size.getHeight()) * ((long) size.getWidth()) * ((long) ImageFormat.getBitsPerPixel(17)));
        Double.isNaN(height);
        byte[] bArr = new byte[(((int) Math.ceil(height / 8.0d)) + 1)];
        ByteBuffer wrap = ByteBuffer.wrap(bArr);
        if (!wrap.hasArray() || wrap.array() != bArr) {
            throw new IllegalStateException("Failed to create valid buffer for camera source.");
        }
        this.zzo.put(bArr, wrap);
        return bArr;
    }
}
