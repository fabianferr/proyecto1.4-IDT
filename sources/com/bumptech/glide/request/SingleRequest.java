package com.bumptech.glide.request;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.Log;
import com.bumptech.glide.GlideBuilder;
import com.bumptech.glide.GlideContext;
import com.bumptech.glide.Priority;
import com.bumptech.glide.load.engine.Engine;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.load.resource.drawable.DrawableDecoderCompat;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.TransitionFactory;
import com.bumptech.glide.util.LogTime;
import com.bumptech.glide.util.Util;
import com.bumptech.glide.util.pool.StateVerifier;
import java.util.List;
import java.util.concurrent.Executor;

public final class SingleRequest<R> implements Request, SizeReadyCallback, ResourceCallback {
    private static final String GLIDE_TAG = "Glide";
    private static final boolean IS_VERBOSE_LOGGABLE = Log.isLoggable(TAG, 2);
    private static final String TAG = "Request";
    private final TransitionFactory<? super R> animationFactory;
    private final Executor callbackExecutor;
    private final Context context;
    private volatile Engine engine;
    private Drawable errorDrawable;
    private Drawable fallbackDrawable;
    private final GlideContext glideContext;
    private int height;
    private boolean isCallingCallbacks;
    private Engine.LoadStatus loadStatus;
    private final Object model;
    private final int overrideHeight;
    private final int overrideWidth;
    private Drawable placeholderDrawable;
    private final Priority priority;
    private final RequestCoordinator requestCoordinator;
    private final List<RequestListener<R>> requestListeners;
    private final Object requestLock;
    private final BaseRequestOptions<?> requestOptions;
    private RuntimeException requestOrigin;
    private Resource<R> resource;
    private long startTime;
    private final StateVerifier stateVerifier;
    private Status status;
    private final String tag;
    private final Target<R> target;
    private final RequestListener<R> targetListener;
    private final Class<R> transcodeClass;
    private int width;

    private enum Status {
        PENDING,
        RUNNING,
        WAITING_FOR_SIZE,
        COMPLETE,
        FAILED,
        CLEARED
    }

    public static <R> SingleRequest<R> obtain(Context context2, GlideContext glideContext2, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority2, Target<R> target2, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> transitionFactory, Executor executor) {
        return new SingleRequest(context2, glideContext2, obj, obj2, cls, baseRequestOptions, i, i2, priority2, target2, requestListener, list, requestCoordinator2, engine2, transitionFactory, executor);
    }

    private SingleRequest(Context context2, GlideContext glideContext2, Object obj, Object obj2, Class<R> cls, BaseRequestOptions<?> baseRequestOptions, int i, int i2, Priority priority2, Target<R> target2, RequestListener<R> requestListener, List<RequestListener<R>> list, RequestCoordinator requestCoordinator2, Engine engine2, TransitionFactory<? super R> transitionFactory, Executor executor) {
        this.tag = IS_VERBOSE_LOGGABLE ? String.valueOf(super.hashCode()) : null;
        this.stateVerifier = StateVerifier.newInstance();
        this.requestLock = obj;
        this.context = context2;
        this.glideContext = glideContext2;
        this.model = obj2;
        this.transcodeClass = cls;
        this.requestOptions = baseRequestOptions;
        this.overrideWidth = i;
        this.overrideHeight = i2;
        this.priority = priority2;
        this.target = target2;
        this.targetListener = requestListener;
        this.requestListeners = list;
        this.requestCoordinator = requestCoordinator2;
        this.engine = engine2;
        this.animationFactory = transitionFactory;
        this.callbackExecutor = executor;
        this.status = Status.PENDING;
        if (this.requestOrigin == null && glideContext2.getExperiments().isEnabled(GlideBuilder.LogRequestOrigins.class)) {
            this.requestOrigin = new RuntimeException("Glide request origin trace");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00a4, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void begin() {
        /*
            r5 = this;
            java.lang.String r0 = "finished run method in "
            java.lang.Object r1 = r5.requestLock
            monitor-enter(r1)
            r5.assertNotCallingCallbacks()     // Catch:{ all -> 0x00ad }
            com.bumptech.glide.util.pool.StateVerifier r2 = r5.stateVerifier     // Catch:{ all -> 0x00ad }
            r2.throwIfRecycled()     // Catch:{ all -> 0x00ad }
            long r2 = com.bumptech.glide.util.LogTime.getLogTime()     // Catch:{ all -> 0x00ad }
            r5.startTime = r2     // Catch:{ all -> 0x00ad }
            java.lang.Object r2 = r5.model     // Catch:{ all -> 0x00ad }
            if (r2 != 0) goto L_0x003e
            int r0 = r5.overrideWidth     // Catch:{ all -> 0x00ad }
            int r2 = r5.overrideHeight     // Catch:{ all -> 0x00ad }
            boolean r0 = com.bumptech.glide.util.Util.isValidDimensions(r0, r2)     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x0029
            int r0 = r5.overrideWidth     // Catch:{ all -> 0x00ad }
            r5.width = r0     // Catch:{ all -> 0x00ad }
            int r0 = r5.overrideHeight     // Catch:{ all -> 0x00ad }
            r5.height = r0     // Catch:{ all -> 0x00ad }
        L_0x0029:
            android.graphics.drawable.Drawable r0 = r5.getFallbackDrawable()     // Catch:{ all -> 0x00ad }
            if (r0 != 0) goto L_0x0031
            r0 = 5
            goto L_0x0032
        L_0x0031:
            r0 = 3
        L_0x0032:
            com.bumptech.glide.load.engine.GlideException r2 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00ad }
            java.lang.String r3 = "Received null model"
            r2.<init>(r3)     // Catch:{ all -> 0x00ad }
            r5.onLoadFailed(r2, r0)     // Catch:{ all -> 0x00ad }
            monitor-exit(r1)     // Catch:{ all -> 0x00ad }
            return
        L_0x003e:
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.status     // Catch:{ all -> 0x00ad }
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00ad }
            if (r2 == r3) goto L_0x00a5
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.status     // Catch:{ all -> 0x00ad }
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00ad }
            if (r2 != r3) goto L_0x0054
            com.bumptech.glide.load.engine.Resource<R> r0 = r5.resource     // Catch:{ all -> 0x00ad }
            com.bumptech.glide.load.DataSource r2 = com.bumptech.glide.load.DataSource.MEMORY_CACHE     // Catch:{ all -> 0x00ad }
            r3 = 0
            r5.onResourceReady(r0, r2, r3)     // Catch:{ all -> 0x00ad }
            monitor-exit(r1)     // Catch:{ all -> 0x00ad }
            return
        L_0x0054:
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00ad }
            r5.status = r2     // Catch:{ all -> 0x00ad }
            int r2 = r5.overrideWidth     // Catch:{ all -> 0x00ad }
            int r3 = r5.overrideHeight     // Catch:{ all -> 0x00ad }
            boolean r2 = com.bumptech.glide.util.Util.isValidDimensions(r2, r3)     // Catch:{ all -> 0x00ad }
            if (r2 == 0) goto L_0x006a
            int r2 = r5.overrideWidth     // Catch:{ all -> 0x00ad }
            int r3 = r5.overrideHeight     // Catch:{ all -> 0x00ad }
            r5.onSizeReady(r2, r3)     // Catch:{ all -> 0x00ad }
            goto L_0x006f
        L_0x006a:
            com.bumptech.glide.request.target.Target<R> r2 = r5.target     // Catch:{ all -> 0x00ad }
            r2.getSize(r5)     // Catch:{ all -> 0x00ad }
        L_0x006f:
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.status     // Catch:{ all -> 0x00ad }
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.RUNNING     // Catch:{ all -> 0x00ad }
            if (r2 == r3) goto L_0x007b
            com.bumptech.glide.request.SingleRequest$Status r2 = r5.status     // Catch:{ all -> 0x00ad }
            com.bumptech.glide.request.SingleRequest$Status r3 = com.bumptech.glide.request.SingleRequest.Status.WAITING_FOR_SIZE     // Catch:{ all -> 0x00ad }
            if (r2 != r3) goto L_0x008a
        L_0x007b:
            boolean r2 = r5.canNotifyStatusChanged()     // Catch:{ all -> 0x00ad }
            if (r2 == 0) goto L_0x008a
            com.bumptech.glide.request.target.Target<R> r2 = r5.target     // Catch:{ all -> 0x00ad }
            android.graphics.drawable.Drawable r3 = r5.getPlaceholderDrawable()     // Catch:{ all -> 0x00ad }
            r2.onLoadStarted(r3)     // Catch:{ all -> 0x00ad }
        L_0x008a:
            boolean r2 = IS_VERBOSE_LOGGABLE     // Catch:{ all -> 0x00ad }
            if (r2 == 0) goto L_0x00a3
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ad }
            r2.<init>(r0)     // Catch:{ all -> 0x00ad }
            long r3 = r5.startTime     // Catch:{ all -> 0x00ad }
            double r3 = com.bumptech.glide.util.LogTime.getElapsedMillis(r3)     // Catch:{ all -> 0x00ad }
            r2.append(r3)     // Catch:{ all -> 0x00ad }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x00ad }
            r5.logV(r0)     // Catch:{ all -> 0x00ad }
        L_0x00a3:
            monitor-exit(r1)     // Catch:{ all -> 0x00ad }
            return
        L_0x00a5:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00ad }
            java.lang.String r2 = "Cannot restart a running request"
            r0.<init>(r2)     // Catch:{ all -> 0x00ad }
            throw r0     // Catch:{ all -> 0x00ad }
        L_0x00ad:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00ad }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.begin():void");
    }

    private void cancel() {
        assertNotCallingCallbacks();
        this.stateVerifier.throwIfRecycled();
        this.target.removeCallback(this);
        Engine.LoadStatus loadStatus2 = this.loadStatus;
        if (loadStatus2 != null) {
            loadStatus2.cancel();
            this.loadStatus = null;
        }
    }

    private void assertNotCallingCallbacks() {
        if (this.isCallingCallbacks) {
            throw new IllegalStateException("You can't start or clear loads in RequestListener or Target callbacks. If you're trying to start a fallback request when a load fails, use RequestBuilder#error(RequestBuilder). Otherwise consider posting your into() or clear() calls to the main thread using a Handler instead.");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0033, code lost:
        if (r1 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0035, code lost:
        r4.engine.release(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.requestLock
            monitor-enter(r0)
            r4.assertNotCallingCallbacks()     // Catch:{ all -> 0x003b }
            com.bumptech.glide.util.pool.StateVerifier r1 = r4.stateVerifier     // Catch:{ all -> 0x003b }
            r1.throwIfRecycled()     // Catch:{ all -> 0x003b }
            com.bumptech.glide.request.SingleRequest$Status r1 = r4.status     // Catch:{ all -> 0x003b }
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x003b }
            if (r1 != r2) goto L_0x0013
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            return
        L_0x0013:
            r4.cancel()     // Catch:{ all -> 0x003b }
            com.bumptech.glide.load.engine.Resource<R> r1 = r4.resource     // Catch:{ all -> 0x003b }
            r2 = 0
            if (r1 == 0) goto L_0x001e
            r4.resource = r2     // Catch:{ all -> 0x003b }
            goto L_0x001f
        L_0x001e:
            r1 = r2
        L_0x001f:
            boolean r2 = r4.canNotifyCleared()     // Catch:{ all -> 0x003b }
            if (r2 == 0) goto L_0x002e
            com.bumptech.glide.request.target.Target<R> r2 = r4.target     // Catch:{ all -> 0x003b }
            android.graphics.drawable.Drawable r3 = r4.getPlaceholderDrawable()     // Catch:{ all -> 0x003b }
            r2.onLoadCleared(r3)     // Catch:{ all -> 0x003b }
        L_0x002e:
            com.bumptech.glide.request.SingleRequest$Status r2 = com.bumptech.glide.request.SingleRequest.Status.CLEARED     // Catch:{ all -> 0x003b }
            r4.status = r2     // Catch:{ all -> 0x003b }
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            if (r1 == 0) goto L_0x003a
            com.bumptech.glide.load.engine.Engine r0 = r4.engine
            r0.release(r1)
        L_0x003a:
            return
        L_0x003b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.clear():void");
    }

    public void pause() {
        synchronized (this.requestLock) {
            if (isRunning()) {
                clear();
            }
        }
    }

    public boolean isRunning() {
        boolean z;
        synchronized (this.requestLock) {
            if (this.status != Status.RUNNING) {
                if (this.status != Status.WAITING_FOR_SIZE) {
                    z = false;
                }
            }
            z = true;
        }
        return z;
    }

    public boolean isComplete() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.COMPLETE;
        }
        return z;
    }

    public boolean isCleared() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.CLEARED;
        }
        return z;
    }

    public boolean isAnyResourceSet() {
        boolean z;
        synchronized (this.requestLock) {
            z = this.status == Status.COMPLETE;
        }
        return z;
    }

    private Drawable getErrorDrawable() {
        if (this.errorDrawable == null) {
            Drawable errorPlaceholder = this.requestOptions.getErrorPlaceholder();
            this.errorDrawable = errorPlaceholder;
            if (errorPlaceholder == null && this.requestOptions.getErrorId() > 0) {
                this.errorDrawable = loadDrawable(this.requestOptions.getErrorId());
            }
        }
        return this.errorDrawable;
    }

    private Drawable getPlaceholderDrawable() {
        if (this.placeholderDrawable == null) {
            Drawable placeholderDrawable2 = this.requestOptions.getPlaceholderDrawable();
            this.placeholderDrawable = placeholderDrawable2;
            if (placeholderDrawable2 == null && this.requestOptions.getPlaceholderId() > 0) {
                this.placeholderDrawable = loadDrawable(this.requestOptions.getPlaceholderId());
            }
        }
        return this.placeholderDrawable;
    }

    private Drawable getFallbackDrawable() {
        if (this.fallbackDrawable == null) {
            Drawable fallbackDrawable2 = this.requestOptions.getFallbackDrawable();
            this.fallbackDrawable = fallbackDrawable2;
            if (fallbackDrawable2 == null && this.requestOptions.getFallbackId() > 0) {
                this.fallbackDrawable = loadDrawable(this.requestOptions.getFallbackId());
            }
        }
        return this.fallbackDrawable;
    }

    private Drawable loadDrawable(int i) {
        return DrawableDecoderCompat.getDrawable((Context) this.glideContext, i, this.requestOptions.getTheme() != null ? this.requestOptions.getTheme() : this.context.getTheme());
    }

    private void setErrorPlaceholder() {
        if (canNotifyStatusChanged()) {
            Drawable fallbackDrawable2 = this.model == null ? getFallbackDrawable() : null;
            if (fallbackDrawable2 == null) {
                fallbackDrawable2 = getErrorDrawable();
            }
            if (fallbackDrawable2 == null) {
                fallbackDrawable2 = getPlaceholderDrawable();
            }
            this.target.onLoadFailed(fallbackDrawable2);
        }
    }

    public void onSizeReady(int i, int i2) {
        Object obj;
        this.stateVerifier.throwIfRecycled();
        Object obj2 = this.requestLock;
        synchronized (obj2) {
            try {
                boolean z = IS_VERBOSE_LOGGABLE;
                if (z) {
                    logV("Got onSizeReady in " + LogTime.getElapsedMillis(this.startTime));
                }
                if (this.status == Status.WAITING_FOR_SIZE) {
                    this.status = Status.RUNNING;
                    float sizeMultiplier = this.requestOptions.getSizeMultiplier();
                    this.width = maybeApplySizeMultiplier(i, sizeMultiplier);
                    this.height = maybeApplySizeMultiplier(i2, sizeMultiplier);
                    if (z) {
                        logV("finished setup for calling load in " + LogTime.getElapsedMillis(this.startTime));
                    }
                    String str = "finished onSizeReady in ";
                    obj = obj2;
                    try {
                        this.loadStatus = this.engine.load(this.glideContext, this.model, this.requestOptions.getSignature(), this.width, this.height, this.requestOptions.getResourceClass(), this.transcodeClass, this.priority, this.requestOptions.getDiskCacheStrategy(), this.requestOptions.getTransformations(), this.requestOptions.isTransformationRequired(), this.requestOptions.isScaleOnlyOrNoTransform(), this.requestOptions.getOptions(), this.requestOptions.isMemoryCacheable(), this.requestOptions.getUseUnlimitedSourceGeneratorsPool(), this.requestOptions.getUseAnimationPool(), this.requestOptions.getOnlyRetrieveFromCache(), this, this.callbackExecutor);
                        if (this.status != Status.RUNNING) {
                            this.loadStatus = null;
                        }
                        if (z) {
                            logV(str + LogTime.getElapsedMillis(this.startTime));
                        }
                    } catch (Throwable th) {
                        th = th;
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                obj = obj2;
                throw th;
            }
        }
    }

    private static int maybeApplySizeMultiplier(int i, float f) {
        return i == Integer.MIN_VALUE ? i : Math.round(f * ((float) i));
    }

    private boolean canSetResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canSetImage(this);
    }

    private boolean canNotifyCleared() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canNotifyCleared(this);
    }

    private boolean canNotifyStatusChanged() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || requestCoordinator2.canNotifyStatusChanged(this);
    }

    private boolean isFirstReadyResource() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        return requestCoordinator2 == null || !requestCoordinator2.getRoot().isAnyResourceSet();
    }

    private void notifyLoadSuccess() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestSuccess(this);
        }
    }

    private void notifyLoadFailed() {
        RequestCoordinator requestCoordinator2 = this.requestCoordinator;
        if (requestCoordinator2 != null) {
            requestCoordinator2.onRequestFailed(this);
        }
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [com.bumptech.glide.load.engine.Engine$LoadStatus, com.bumptech.glide.load.engine.Resource<R>] */
    /* JADX WARNING: type inference failed for: r2v2, types: [com.bumptech.glide.load.engine.Resource] */
    /* JADX WARNING: type inference failed for: r2v4 */
    /* JADX WARNING: type inference failed for: r2v6 */
    /* JADX WARNING: type inference failed for: r2v7 */
    /* JADX WARNING: type inference failed for: r2v8 */
    /* JADX WARNING: type inference failed for: r2v9 */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        if (r7 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0050, code lost:
        r6.engine.release(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:?, code lost:
        return;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResourceReady(com.bumptech.glide.load.engine.Resource<?> r7, com.bumptech.glide.load.DataSource r8, boolean r9) {
        /*
            r6 = this;
            java.lang.String r0 = "Expected to receive an object of "
            java.lang.String r1 = "Expected to receive a Resource<R> with an object of "
            com.bumptech.glide.util.pool.StateVerifier r2 = r6.stateVerifier
            r2.throwIfRecycled()
            r2 = 0
            java.lang.Object r3 = r6.requestLock     // Catch:{ all -> 0x00b3 }
            monitor-enter(r3)     // Catch:{ all -> 0x00b3 }
            r6.loadStatus = r2     // Catch:{ all -> 0x00b0 }
            if (r7 != 0) goto L_0x002e
            com.bumptech.glide.load.engine.GlideException r7 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00b0 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00b0 }
            r8.<init>(r1)     // Catch:{ all -> 0x00b0 }
            java.lang.Class<R> r9 = r6.transcodeClass     // Catch:{ all -> 0x00b0 }
            r8.append(r9)     // Catch:{ all -> 0x00b0 }
            java.lang.String r9 = " inside, but instead got null."
            r8.append(r9)     // Catch:{ all -> 0x00b0 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x00b0 }
            r7.<init>(r8)     // Catch:{ all -> 0x00b0 }
            r6.onLoadFailed(r7)     // Catch:{ all -> 0x00b0 }
            monitor-exit(r3)     // Catch:{ all -> 0x00b0 }
            return
        L_0x002e:
            java.lang.Object r1 = r7.get()     // Catch:{ all -> 0x00b0 }
            if (r1 == 0) goto L_0x005b
            java.lang.Class<R> r4 = r6.transcodeClass     // Catch:{ all -> 0x00b0 }
            java.lang.Class r5 = r1.getClass()     // Catch:{ all -> 0x00b0 }
            boolean r4 = r4.isAssignableFrom(r5)     // Catch:{ all -> 0x00b0 }
            if (r4 != 0) goto L_0x0041
            goto L_0x005b
        L_0x0041:
            boolean r0 = r6.canSetResource()     // Catch:{ all -> 0x00b0 }
            if (r0 != 0) goto L_0x0056
            r6.resource = r2     // Catch:{ all -> 0x00ac }
            com.bumptech.glide.request.SingleRequest$Status r8 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE     // Catch:{ all -> 0x00ac }
            r6.status = r8     // Catch:{ all -> 0x00ac }
            monitor-exit(r3)     // Catch:{ all -> 0x00ac }
            if (r7 == 0) goto L_0x0055
            com.bumptech.glide.load.engine.Engine r8 = r6.engine
            r8.release(r7)
        L_0x0055:
            return
        L_0x0056:
            r6.onResourceReady(r7, r1, r8, r9)     // Catch:{ all -> 0x00b0 }
            monitor-exit(r3)     // Catch:{ all -> 0x00b0 }
            return
        L_0x005b:
            r6.resource = r2     // Catch:{ all -> 0x00ac }
            com.bumptech.glide.load.engine.GlideException r8 = new com.bumptech.glide.load.engine.GlideException     // Catch:{ all -> 0x00ac }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ all -> 0x00ac }
            r9.<init>(r0)     // Catch:{ all -> 0x00ac }
            java.lang.Class<R> r0 = r6.transcodeClass     // Catch:{ all -> 0x00ac }
            r9.append(r0)     // Catch:{ all -> 0x00ac }
            java.lang.String r0 = " but instead got "
            r9.append(r0)     // Catch:{ all -> 0x00ac }
            if (r1 == 0) goto L_0x0075
            java.lang.Class r0 = r1.getClass()     // Catch:{ all -> 0x00ac }
            goto L_0x0077
        L_0x0075:
            java.lang.String r0 = ""
        L_0x0077:
            r9.append(r0)     // Catch:{ all -> 0x00ac }
            java.lang.String r0 = "{"
            r9.append(r0)     // Catch:{ all -> 0x00ac }
            r9.append(r1)     // Catch:{ all -> 0x00ac }
            java.lang.String r0 = "} inside Resource{"
            r9.append(r0)     // Catch:{ all -> 0x00ac }
            r9.append(r7)     // Catch:{ all -> 0x00ac }
            java.lang.String r0 = "}."
            r9.append(r0)     // Catch:{ all -> 0x00ac }
            if (r1 == 0) goto L_0x0094
            java.lang.String r0 = ""
            goto L_0x0096
        L_0x0094:
            java.lang.String r0 = " To indicate failure return a null Resource object, rather than a Resource object containing null data."
        L_0x0096:
            r9.append(r0)     // Catch:{ all -> 0x00ac }
            java.lang.String r9 = r9.toString()     // Catch:{ all -> 0x00ac }
            r8.<init>(r9)     // Catch:{ all -> 0x00ac }
            r6.onLoadFailed(r8)     // Catch:{ all -> 0x00ac }
            monitor-exit(r3)     // Catch:{ all -> 0x00ac }
            if (r7 == 0) goto L_0x00ab
            com.bumptech.glide.load.engine.Engine r8 = r6.engine
            r8.release(r7)
        L_0x00ab:
            return
        L_0x00ac:
            r8 = move-exception
            r2 = r7
            r7 = r8
            goto L_0x00b1
        L_0x00b0:
            r7 = move-exception
        L_0x00b1:
            monitor-exit(r3)     // Catch:{ all -> 0x00b0 }
            throw r7     // Catch:{ all -> 0x00b3 }
        L_0x00b3:
            r7 = move-exception
            if (r2 == 0) goto L_0x00bb
            com.bumptech.glide.load.engine.Engine r8 = r6.engine
            r8.release(r2)
        L_0x00bb:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, com.bumptech.glide.load.DataSource, boolean):void");
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a4 A[Catch:{ all -> 0x00b5 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onResourceReady(com.bumptech.glide.load.engine.Resource<R> r10, R r11, com.bumptech.glide.load.DataSource r12, boolean r13) {
        /*
            r9 = this;
            boolean r13 = r9.isFirstReadyResource()
            com.bumptech.glide.request.SingleRequest$Status r0 = com.bumptech.glide.request.SingleRequest.Status.COMPLETE
            r9.status = r0
            r9.resource = r10
            com.bumptech.glide.GlideContext r10 = r9.glideContext
            int r10 = r10.getLogLevel()
            r0 = 3
            if (r10 > r0) goto L_0x0067
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            java.lang.String r0 = "Finished loading "
            r10.<init>(r0)
            java.lang.Class r0 = r11.getClass()
            java.lang.String r0 = r0.getSimpleName()
            r10.append(r0)
            java.lang.String r0 = " from "
            r10.append(r0)
            r10.append(r12)
            java.lang.String r0 = " for "
            r10.append(r0)
            java.lang.Object r0 = r9.model
            r10.append(r0)
            java.lang.String r0 = " with size ["
            r10.append(r0)
            int r0 = r9.width
            r10.append(r0)
            java.lang.String r0 = "x"
            r10.append(r0)
            int r0 = r9.height
            r10.append(r0)
            java.lang.String r0 = "] in "
            r10.append(r0)
            long r0 = r9.startTime
            double r0 = com.bumptech.glide.util.LogTime.getElapsedMillis(r0)
            r10.append(r0)
            java.lang.String r0 = " ms"
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.String r0 = "Glide"
            android.util.Log.d(r0, r10)
        L_0x0067:
            r10 = 1
            r9.isCallingCallbacks = r10
            r6 = 0
            java.util.List<com.bumptech.glide.request.RequestListener<R>> r0 = r9.requestListeners     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x008d
            java.util.Iterator r7 = r0.iterator()     // Catch:{ all -> 0x00b5 }
            r8 = 0
        L_0x0074:
            boolean r0 = r7.hasNext()     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x008e
            java.lang.Object r0 = r7.next()     // Catch:{ all -> 0x00b5 }
            com.bumptech.glide.request.RequestListener r0 = (com.bumptech.glide.request.RequestListener) r0     // Catch:{ all -> 0x00b5 }
            java.lang.Object r2 = r9.model     // Catch:{ all -> 0x00b5 }
            com.bumptech.glide.request.target.Target<R> r3 = r9.target     // Catch:{ all -> 0x00b5 }
            r1 = r11
            r4 = r12
            r5 = r13
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b5 }
            r8 = r8 | r0
            goto L_0x0074
        L_0x008d:
            r8 = 0
        L_0x008e:
            com.bumptech.glide.request.RequestListener<R> r0 = r9.targetListener     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x00a0
            java.lang.Object r2 = r9.model     // Catch:{ all -> 0x00b5 }
            com.bumptech.glide.request.target.Target<R> r3 = r9.target     // Catch:{ all -> 0x00b5 }
            r1 = r11
            r4 = r12
            r5 = r13
            boolean r0 = r0.onResourceReady(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x00b5 }
            if (r0 == 0) goto L_0x00a0
            goto L_0x00a1
        L_0x00a0:
            r10 = 0
        L_0x00a1:
            r10 = r10 | r8
            if (r10 != 0) goto L_0x00af
            com.bumptech.glide.request.transition.TransitionFactory<? super R> r10 = r9.animationFactory     // Catch:{ all -> 0x00b5 }
            com.bumptech.glide.request.transition.Transition r10 = r10.build(r12, r13)     // Catch:{ all -> 0x00b5 }
            com.bumptech.glide.request.target.Target<R> r12 = r9.target     // Catch:{ all -> 0x00b5 }
            r12.onResourceReady(r11, r10)     // Catch:{ all -> 0x00b5 }
        L_0x00af:
            r9.isCallingCallbacks = r6
            r9.notifyLoadSuccess()
            return
        L_0x00b5:
            r10 = move-exception
            r9.isCallingCallbacks = r6
            goto L_0x00ba
        L_0x00b9:
            throw r10
        L_0x00ba:
            goto L_0x00b9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.request.SingleRequest.onResourceReady(com.bumptech.glide.load.engine.Resource, java.lang.Object, com.bumptech.glide.load.DataSource, boolean):void");
    }

    public void onLoadFailed(GlideException glideException) {
        onLoadFailed(glideException, 5);
    }

    public Object getLock() {
        this.stateVerifier.throwIfRecycled();
        return this.requestLock;
    }

    /* JADX INFO: finally extract failed */
    private void onLoadFailed(GlideException glideException, int i) {
        boolean z;
        this.stateVerifier.throwIfRecycled();
        synchronized (this.requestLock) {
            glideException.setOrigin(this.requestOrigin);
            int logLevel = this.glideContext.getLogLevel();
            if (logLevel <= i) {
                Log.w(GLIDE_TAG, "Load failed for " + this.model + " with size [" + this.width + "x" + this.height + "]", glideException);
                if (logLevel <= 4) {
                    glideException.logRootCauses(GLIDE_TAG);
                }
            }
            this.loadStatus = null;
            this.status = Status.FAILED;
            boolean z2 = true;
            this.isCallingCallbacks = true;
            try {
                List<RequestListener<R>> list = this.requestListeners;
                if (list != null) {
                    z = false;
                    for (RequestListener<R> onLoadFailed : list) {
                        z |= onLoadFailed.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource());
                    }
                } else {
                    z = false;
                }
                RequestListener<R> requestListener = this.targetListener;
                if (requestListener == null || !requestListener.onLoadFailed(glideException, this.model, this.target, isFirstReadyResource())) {
                    z2 = false;
                }
                if (!z && !z2) {
                    setErrorPlaceholder();
                }
                this.isCallingCallbacks = false;
                notifyLoadFailed();
            } catch (Throwable th) {
                this.isCallingCallbacks = false;
                throw th;
            }
        }
    }

    public boolean isEquivalentTo(Request request) {
        int i;
        int i2;
        Object obj;
        Class<R> cls;
        BaseRequestOptions<?> baseRequestOptions;
        Priority priority2;
        int size;
        int i3;
        int i4;
        Object obj2;
        Class<R> cls2;
        BaseRequestOptions<?> baseRequestOptions2;
        Priority priority3;
        int size2;
        Request request2 = request;
        if (!(request2 instanceof SingleRequest)) {
            return false;
        }
        synchronized (this.requestLock) {
            i = this.overrideWidth;
            i2 = this.overrideHeight;
            obj = this.model;
            cls = this.transcodeClass;
            baseRequestOptions = this.requestOptions;
            priority2 = this.priority;
            List<RequestListener<R>> list = this.requestListeners;
            size = list != null ? list.size() : 0;
        }
        SingleRequest singleRequest = (SingleRequest) request2;
        synchronized (singleRequest.requestLock) {
            i3 = singleRequest.overrideWidth;
            i4 = singleRequest.overrideHeight;
            obj2 = singleRequest.model;
            cls2 = singleRequest.transcodeClass;
            baseRequestOptions2 = singleRequest.requestOptions;
            priority3 = singleRequest.priority;
            List<RequestListener<R>> list2 = singleRequest.requestListeners;
            size2 = list2 != null ? list2.size() : 0;
        }
        return i == i3 && i2 == i4 && Util.bothModelsNullEquivalentOrEquals(obj, obj2) && cls.equals(cls2) && baseRequestOptions.equals(baseRequestOptions2) && priority2 == priority3 && size == size2;
    }

    private void logV(String str) {
        Log.v(TAG, str + " this: " + this.tag);
    }
}
