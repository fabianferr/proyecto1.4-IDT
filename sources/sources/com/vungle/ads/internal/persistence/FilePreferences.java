package com.vungle.ads.internal.persistence;

import com.vungle.ads.internal.util.CollectionsConcurrencyUtil;
import com.vungle.ads.internal.util.FileUtility;
import com.vungle.ads.internal.util.PathProvider;
import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\r\u001a\u00020\u000eJ\u0015\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0007¢\u0006\u0002\u0010\u0012J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0010J\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0015J\u0016\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0017J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u00072\u0006\u0010\u0011\u001a\u00020\u0007J\u0016\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u0007J6\u0010\u0019\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001aj\b\u0012\u0004\u0012\u00020\u0007`\u001b2\u0006\u0010\u0011\u001a\u00020\u00072\u0016\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u001aj\b\u0012\u0004\u0012\u00020\u0007`\u001bJ\u0016\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0010J\u0016\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0015J\u0016\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0017J\u0016\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007J*\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u00072\u001a\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001aj\n\u0012\u0004\u0012\u00020\u0007\u0018\u0001`\u001bJ\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\fX\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lcom/vungle/ads/internal/persistence/FilePreferences;", "", "ioExecutor", "Ljava/util/concurrent/Executor;", "pathProvider", "Lcom/vungle/ads/internal/util/PathProvider;", "filename", "", "(Ljava/util/concurrent/Executor;Lcom/vungle/ads/internal/util/PathProvider;Ljava/lang/String;)V", "file", "Ljava/io/File;", "values", "Ljava/util/concurrent/ConcurrentHashMap;", "apply", "", "getBoolean", "", "key", "(Ljava/lang/String;)Ljava/lang/Boolean;", "defaultValue", "getInt", "", "getLong", "", "getString", "getStringSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "put", "value", "remove", "Companion", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FilePreferences.kt */
public final class FilePreferences {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final String FILENAME = "settings_vungle";
    private final File file;
    private final Executor ioExecutor;
    private final ConcurrentHashMap<String, Object> values;

    public FilePreferences(Executor executor, PathProvider pathProvider, String str) {
        Intrinsics.checkNotNullParameter(executor, "ioExecutor");
        Intrinsics.checkNotNullParameter(pathProvider, "pathProvider");
        Intrinsics.checkNotNullParameter(str, "filename");
        this.ioExecutor = executor;
        File file2 = new File(pathProvider.getSharedPrefsDir(), str);
        this.file = file2;
        ConcurrentHashMap<String, Object> concurrentHashMap = new ConcurrentHashMap<>();
        this.values = concurrentHashMap;
        Object readSerializable = FileUtility.readSerializable(file2);
        if (readSerializable instanceof HashMap) {
            concurrentHashMap.putAll((HashMap) readSerializable);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FilePreferences(Executor executor, PathProvider pathProvider, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(executor, pathProvider, (i & 4) != 0 ? FILENAME : str);
    }

    public final void apply() {
        this.ioExecutor.execute(new FilePreferences$$ExternalSyntheticLambda0(this, new HashMap(this.values)));
    }

    /* access modifiers changed from: private */
    /* renamed from: apply$lambda-0  reason: not valid java name */
    public static final void m2310apply$lambda0(FilePreferences filePreferences, Serializable serializable) {
        Intrinsics.checkNotNullParameter(filePreferences, "this$0");
        Intrinsics.checkNotNullParameter(serializable, "$serializable");
        FileUtility.writeSerializable(filePreferences.file, serializable);
    }

    public final FilePreferences put(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.values.put(str, Boolean.valueOf(z));
        return this;
    }

    public final boolean getBoolean(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = this.values.get(str);
        return obj instanceof Boolean ? ((Boolean) obj).booleanValue() : z;
    }

    public final Boolean getBoolean(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        return null;
    }

    public final FilePreferences put(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        this.values.put(str, str2);
        return this;
    }

    public final FilePreferences remove(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (this.values.containsKey(str)) {
            this.values.remove(str);
        }
        return this;
    }

    public final String getString(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "defaultValue");
        Object obj = this.values.get(str);
        return obj instanceof String ? (String) obj : str2;
    }

    public final String getString(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = this.values.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    public final FilePreferences put(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.values.put(str, Integer.valueOf(i));
        return this;
    }

    public final int getInt(String str, int i) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = this.values.get(str);
        return obj instanceof Integer ? ((Number) obj).intValue() : i;
    }

    public final FilePreferences put(String str, HashSet<String> hashSet) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.values.put(str, CollectionsConcurrencyUtil.getNewHashSet(hashSet));
        return this;
    }

    public final HashSet<String> getStringSet(String str, HashSet<String> hashSet) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(hashSet, "defaultValue");
        Object obj = this.values.get(str);
        return obj instanceof HashSet ? CollectionsConcurrencyUtil.getNewHashSet((HashSet) obj) : hashSet;
    }

    public final FilePreferences put(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.values.put(str, Long.valueOf(j));
        return this;
    }

    public final long getLong(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        Object obj = this.values.get(str);
        return obj instanceof Long ? ((Number) obj).longValue() : j;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/vungle/ads/internal/persistence/FilePreferences$Companion;", "", "()V", "FILENAME", "", "getFILENAME$annotations", "getFILENAME", "()Ljava/lang/String;", "vungle-ads_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FilePreferences.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getFILENAME$annotations() {
        }

        private Companion() {
        }

        public final String getFILENAME() {
            return FilePreferences.FILENAME;
        }
    }
}
