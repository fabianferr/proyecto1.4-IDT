package com.facebook.appevents;

import com.facebook.appevents.AccessTokenAppIdPair;
import com.facebook.appevents.AppEvent;
import com.facebook.appevents.internal.AppEventUtility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0007J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\rH\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u0017\u0010\u0010\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\u000fH\u0001¢\u0006\u0002\b\u0011R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/facebook/appevents/AppEventStore;", "", "()V", "PERSISTED_EVENTS_FILENAME", "", "TAG", "persistEvents", "", "accessTokenAppIdPair", "Lcom/facebook/appevents/AccessTokenAppIdPair;", "appEvents", "Lcom/facebook/appevents/SessionEventsState;", "eventsToPersist", "Lcom/facebook/appevents/AppEventCollection;", "readAndClearStore", "Lcom/facebook/appevents/PersistedEvents;", "saveEventsToDisk", "saveEventsToDisk$facebook_core_release", "MovedClassObjectInputStream", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AppEventStore.kt */
public final class AppEventStore {
    public static final AppEventStore INSTANCE = new AppEventStore();
    private static final String PERSISTED_EVENTS_FILENAME = "AppEventsLogger.persistedevents";
    private static final String TAG;

    private AppEventStore() {
    }

    static {
        String name = AppEventStore.class.getName();
        Intrinsics.checkNotNullExpressionValue(name, "AppEventStore::class.java.name");
        TAG = name;
    }

    @JvmStatic
    public static final synchronized void persistEvents(AccessTokenAppIdPair accessTokenAppIdPair, SessionEventsState sessionEventsState) {
        synchronized (AppEventStore.class) {
            if (!CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
                try {
                    Intrinsics.checkNotNullParameter(accessTokenAppIdPair, "accessTokenAppIdPair");
                    Intrinsics.checkNotNullParameter(sessionEventsState, "appEvents");
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    AppEventUtility.assertIsNotMainThread();
                    PersistedEvents readAndClearStore = readAndClearStore();
                    readAndClearStore.addEvents(accessTokenAppIdPair, sessionEventsState.getEventsToPersist());
                    saveEventsToDisk$facebook_core_release(readAndClearStore);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, AppEventStore.class);
                }
            }
        }
    }

    @JvmStatic
    public static final synchronized void persistEvents(AppEventCollection appEventCollection) {
        synchronized (AppEventStore.class) {
            if (!CrashShieldHandler.isObjectCrashing(AppEventStore.class)) {
                try {
                    Intrinsics.checkNotNullParameter(appEventCollection, "eventsToPersist");
                    AppEventUtility appEventUtility = AppEventUtility.INSTANCE;
                    AppEventUtility.assertIsNotMainThread();
                    PersistedEvents readAndClearStore = readAndClearStore();
                    for (AccessTokenAppIdPair next : appEventCollection.keySet()) {
                        SessionEventsState sessionEventsState = appEventCollection.get(next);
                        if (sessionEventsState != null) {
                            readAndClearStore.addEvents(next, sessionEventsState.getEventsToPersist());
                        } else {
                            throw new IllegalStateException("Required value was null.".toString());
                        }
                    }
                    saveEventsToDisk$facebook_core_release(readAndClearStore);
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, AppEventStore.class);
                }
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c6 A[Catch:{ Exception -> 0x004c, all -> 0x00cd }] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final synchronized com.facebook.appevents.PersistedEvents readAndClearStore() {
        /*
            java.lang.Class<com.facebook.appevents.AppEventStore> r0 = com.facebook.appevents.AppEventStore.class
            monitor-enter(r0)
            java.lang.Class<com.facebook.appevents.AppEventStore> r1 = com.facebook.appevents.AppEventStore.class
            boolean r1 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)     // Catch:{ all -> 0x00d5 }
            r2 = 0
            if (r1 == 0) goto L_0x000e
            monitor-exit(r0)
            return r2
        L_0x000e:
            com.facebook.appevents.internal.AppEventUtility r1 = com.facebook.appevents.internal.AppEventUtility.INSTANCE     // Catch:{ all -> 0x00cd }
            com.facebook.appevents.internal.AppEventUtility.assertIsNotMainThread()     // Catch:{ all -> 0x00cd }
            com.facebook.FacebookSdk r1 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x00cd }
            android.content.Context r1 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x00cd }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.FileInputStream r3 = r1.openFileInput(r3)     // Catch:{ FileNotFoundException -> 0x00a9, Exception -> 0x0065, all -> 0x0062 }
            java.lang.String r4 = "context.openFileInput(PERSISTED_EVENTS_FILENAME)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r4)     // Catch:{ FileNotFoundException -> 0x00a9, Exception -> 0x0065, all -> 0x0062 }
            java.io.InputStream r3 = (java.io.InputStream) r3     // Catch:{ FileNotFoundException -> 0x00a9, Exception -> 0x0065, all -> 0x0062 }
            com.facebook.appevents.AppEventStore$MovedClassObjectInputStream r4 = new com.facebook.appevents.AppEventStore$MovedClassObjectInputStream     // Catch:{ FileNotFoundException -> 0x00a9, Exception -> 0x0065, all -> 0x0062 }
            java.io.BufferedInputStream r5 = new java.io.BufferedInputStream     // Catch:{ FileNotFoundException -> 0x00a9, Exception -> 0x0065, all -> 0x0062 }
            r5.<init>(r3)     // Catch:{ FileNotFoundException -> 0x00a9, Exception -> 0x0065, all -> 0x0062 }
            java.io.InputStream r5 = (java.io.InputStream) r5     // Catch:{ FileNotFoundException -> 0x00a9, Exception -> 0x0065, all -> 0x0062 }
            r4.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00a9, Exception -> 0x0065, all -> 0x0062 }
            java.lang.Object r3 = r4.readObject()     // Catch:{ FileNotFoundException -> 0x00aa, Exception -> 0x0060 }
            if (r3 == 0) goto L_0x0058
            com.facebook.appevents.PersistedEvents r3 = (com.facebook.appevents.PersistedEvents) r3     // Catch:{ FileNotFoundException -> 0x00aa, Exception -> 0x0060 }
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x00cd }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x00cd }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00cd }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch:{ Exception -> 0x004c }
            r1.delete()     // Catch:{ Exception -> 0x004c }
            goto L_0x00c4
        L_0x004c:
            r1 = move-exception
            java.lang.String r4 = TAG     // Catch:{ all -> 0x00cd }
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00cd }
            android.util.Log.w(r4, r5, r1)     // Catch:{ all -> 0x00cd }
            goto L_0x00c4
        L_0x0058:
            java.lang.NullPointerException r3 = new java.lang.NullPointerException     // Catch:{ FileNotFoundException -> 0x00aa, Exception -> 0x0060 }
            java.lang.String r5 = "null cannot be cast to non-null type com.facebook.appevents.PersistedEvents"
            r3.<init>(r5)     // Catch:{ FileNotFoundException -> 0x00aa, Exception -> 0x0060 }
            throw r3     // Catch:{ FileNotFoundException -> 0x00aa, Exception -> 0x0060 }
        L_0x0060:
            r3 = move-exception
            goto L_0x0067
        L_0x0062:
            r3 = move-exception
            r4 = r2
            goto L_0x008d
        L_0x0065:
            r3 = move-exception
            r4 = r2
        L_0x0067:
            java.lang.String r5 = TAG     // Catch:{ all -> 0x008c }
            java.lang.String r6 = "Got unexpected exception while reading events: "
            java.lang.Throwable r3 = (java.lang.Throwable) r3     // Catch:{ all -> 0x008c }
            android.util.Log.w(r5, r6, r3)     // Catch:{ all -> 0x008c }
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x00cd }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x00cd }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00cd }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x0081 }
            r1.delete()     // Catch:{ Exception -> 0x0081 }
            goto L_0x00c3
        L_0x0081:
            r1 = move-exception
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00cd }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00cd }
        L_0x0088:
            android.util.Log.w(r3, r4, r1)     // Catch:{ all -> 0x00cd }
            goto L_0x00c3
        L_0x008c:
            r3 = move-exception
        L_0x008d:
            com.facebook.internal.Utility r5 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x00cd }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x00cd }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00cd }
            java.lang.String r4 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r4)     // Catch:{ Exception -> 0x009e }
            r1.delete()     // Catch:{ Exception -> 0x009e }
            goto L_0x00a8
        L_0x009e:
            r1 = move-exception
            java.lang.String r4 = TAG     // Catch:{ all -> 0x00cd }
            java.lang.String r5 = "Got unexpected exception when removing events file: "
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00cd }
            android.util.Log.w(r4, r5, r1)     // Catch:{ all -> 0x00cd }
        L_0x00a8:
            throw r3     // Catch:{ all -> 0x00cd }
        L_0x00a9:
            r4 = r2
        L_0x00aa:
            com.facebook.internal.Utility r3 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x00cd }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x00cd }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x00cd }
            java.lang.String r3 = "AppEventsLogger.persistedevents"
            java.io.File r1 = r1.getFileStreamPath(r3)     // Catch:{ Exception -> 0x00bb }
            r1.delete()     // Catch:{ Exception -> 0x00bb }
            goto L_0x00c3
        L_0x00bb:
            r1 = move-exception
            java.lang.String r3 = TAG     // Catch:{ all -> 0x00cd }
            java.lang.String r4 = "Got unexpected exception when removing events file: "
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ all -> 0x00cd }
            goto L_0x0088
        L_0x00c3:
            r3 = r2
        L_0x00c4:
            if (r3 != 0) goto L_0x00cb
            com.facebook.appevents.PersistedEvents r3 = new com.facebook.appevents.PersistedEvents     // Catch:{ all -> 0x00cd }
            r3.<init>()     // Catch:{ all -> 0x00cd }
        L_0x00cb:
            monitor-exit(r0)
            return r3
        L_0x00cd:
            r1 = move-exception
            java.lang.Class<com.facebook.appevents.AppEventStore> r3 = com.facebook.appevents.AppEventStore.class
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r1, r3)     // Catch:{ all -> 0x00d5 }
            monitor-exit(r0)
            return r2
        L_0x00d5:
            r1 = move-exception
            monitor-exit(r0)
            goto L_0x00d9
        L_0x00d8:
            throw r1
        L_0x00d9:
            goto L_0x00d8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.readAndClearStore():com.facebook.appevents.PersistedEvents");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0042 */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void saveEventsToDisk$facebook_core_release(com.facebook.appevents.PersistedEvents r7) {
        /*
            java.lang.String r0 = "AppEventsLogger.persistedevents"
            java.lang.Class<com.facebook.appevents.AppEventStore> r1 = com.facebook.appevents.AppEventStore.class
            boolean r2 = com.facebook.internal.instrument.crashshield.CrashShieldHandler.isObjectCrashing(r1)
            if (r2 == 0) goto L_0x000b
            return
        L_0x000b:
            com.facebook.FacebookSdk r2 = com.facebook.FacebookSdk.INSTANCE     // Catch:{ all -> 0x0053 }
            android.content.Context r2 = com.facebook.FacebookSdk.getApplicationContext()     // Catch:{ all -> 0x0053 }
            r3 = 0
            java.io.ObjectOutputStream r4 = new java.io.ObjectOutputStream     // Catch:{ all -> 0x0033 }
            java.io.BufferedOutputStream r5 = new java.io.BufferedOutputStream     // Catch:{ all -> 0x0033 }
            r6 = 0
            java.io.FileOutputStream r6 = r2.openFileOutput(r0, r6)     // Catch:{ all -> 0x0033 }
            java.io.OutputStream r6 = (java.io.OutputStream) r6     // Catch:{ all -> 0x0033 }
            r5.<init>(r6)     // Catch:{ all -> 0x0033 }
            java.io.OutputStream r5 = (java.io.OutputStream) r5     // Catch:{ all -> 0x0033 }
            r4.<init>(r5)     // Catch:{ all -> 0x0033 }
            r4.writeObject(r7)     // Catch:{ all -> 0x0030 }
            com.facebook.internal.Utility r7 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x0053 }
            java.io.Closeable r4 = (java.io.Closeable) r4     // Catch:{ all -> 0x0053 }
            com.facebook.internal.Utility.closeQuietly(r4)     // Catch:{ all -> 0x0053 }
            goto L_0x0049
        L_0x0030:
            r7 = move-exception
            r3 = r4
            goto L_0x0034
        L_0x0033:
            r7 = move-exception
        L_0x0034:
            java.lang.String r4 = TAG     // Catch:{ all -> 0x004a }
            java.lang.String r5 = "Got unexpected exception while persisting events: "
            android.util.Log.w(r4, r5, r7)     // Catch:{ all -> 0x004a }
            java.io.File r7 = r2.getFileStreamPath(r0)     // Catch:{ Exception -> 0x0042 }
            r7.delete()     // Catch:{ Exception -> 0x0042 }
        L_0x0042:
            com.facebook.internal.Utility r7 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x0053 }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x0053 }
            com.facebook.internal.Utility.closeQuietly(r3)     // Catch:{ all -> 0x0053 }
        L_0x0049:
            return
        L_0x004a:
            r7 = move-exception
            com.facebook.internal.Utility r0 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x0053 }
            java.io.Closeable r3 = (java.io.Closeable) r3     // Catch:{ all -> 0x0053 }
            com.facebook.internal.Utility.closeQuietly(r3)     // Catch:{ all -> 0x0053 }
            throw r7     // Catch:{ all -> 0x0053 }
        L_0x0053:
            r7 = move-exception
            com.facebook.internal.instrument.crashshield.CrashShieldHandler.handleThrowable(r7, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.AppEventStore.saveEventsToDisk$facebook_core_release(com.facebook.appevents.PersistedEvents):void");
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0014¨\u0006\b"}, d2 = {"Lcom/facebook/appevents/AppEventStore$MovedClassObjectInputStream;", "Ljava/io/ObjectInputStream;", "inputStream", "Ljava/io/InputStream;", "(Ljava/io/InputStream;)V", "readClassDescriptor", "Ljava/io/ObjectStreamClass;", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AppEventStore.kt */
    private static final class MovedClassObjectInputStream extends ObjectInputStream {
        private static final String ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AccessTokenAppIdPair$SerializationProxyV1";
        private static final String APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME = "com.facebook.appevents.AppEventsLogger$AppEvent$SerializationProxyV2";
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

        public MovedClassObjectInputStream(InputStream inputStream) {
            super(inputStream);
        }

        /* access modifiers changed from: protected */
        public ObjectStreamClass readClassDescriptor() throws IOException, ClassNotFoundException {
            ObjectStreamClass readClassDescriptor = super.readClassDescriptor();
            if (Intrinsics.areEqual((Object) readClassDescriptor.getName(), (Object) ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AccessTokenAppIdPair.SerializationProxyV1.class);
            } else if (Intrinsics.areEqual((Object) readClassDescriptor.getName(), (Object) APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME)) {
                readClassDescriptor = ObjectStreamClass.lookup(AppEvent.SerializationProxyV2.class);
            }
            Intrinsics.checkNotNullExpressionValue(readClassDescriptor, "resultClassDescriptor");
            return readClassDescriptor;
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/appevents/AppEventStore$MovedClassObjectInputStream$Companion;", "", "()V", "ACCESS_TOKEN_APP_ID_PAIR_SERIALIZATION_PROXY_V1_CLASS_NAME", "", "APP_EVENT_SERIALIZATION_PROXY_V1_CLASS_NAME", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: AppEventStore.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
