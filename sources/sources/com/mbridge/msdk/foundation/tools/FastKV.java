package com.mbridge.msdk.foundation.tools;

import com.google.common.primitives.SignedBytes;
import com.mbridge.msdk.foundation.tools.c;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import kotlin.UShort;
import okio.Utf8;

public class FastKV {
    static final int ASYNC_BLOCKING = 1;
    private static final String A_SUFFIX = ".kva";
    private static final int BASE_GC_BYTES_THRESHOLD = 4096;
    private static final int BASE_GC_KEYS_THRESHOLD = 80;
    private static final String BOTH_FILES_ERROR = "both files error";
    private static final String B_SUFFIX = ".kvb";
    private static final String C_SUFFIX = ".kvc";
    private static final int DATA_SIZE_LIMIT = 536870912;
    private static final int DATA_START = 12;
    private static final int DOUBLE_LIMIT;
    private static final byte[] EMPTY_ARRAY = new byte[0];
    static final String GC_FINISH = "gc finish";
    private static final int INTERNAL_LIMIT = 2048;
    private static final String MAP_FAILED = "map failed";
    static final int NON_BLOCKING = 0;
    private static final String OPEN_FILE_FAILED = "open file failed";
    private static final int PAGE_SIZE;
    private static final String PARSE_DATA_FAILED = "parse dara failed";
    static final int SYNC_BLOCKING = 2;
    private static final String TEMP_SUFFIX = ".tmp";
    static final String TRUNCATE_FINISH = "truncate finish";
    private static final int TRUNCATE_THRESHOLD;
    private static final int[] TYPE_SIZE = {0, 1, 4, 4, 8, 8};
    private MappedByteBuffer aBuffer;
    private FileChannel aChannel;
    private boolean autoCommit = true;
    private MappedByteBuffer bBuffer;
    private FileChannel bChannel;
    private long checksum;
    private final Map<String, c.b> data = new HashMap();
    private int dataEnd;
    private final Map<String, a> encoderMap;
    private final Executor executor = new p();
    private m fastBuffer;
    private int invalidBytes;
    private final ArrayList<c> invalids = new ArrayList<>();
    private final b logger = n.a;
    private final String name;
    private final String path;
    private int removeStart;
    private boolean sizeChanged;
    private String tempExternalName;
    private int updateSize;
    private int updateStart;
    private int writingMode;

    public interface a<T> {
        T a(byte[] bArr, int i, int i2);

        String a();

        byte[] a(T t);
    }

    public interface b {
        void a(String str, Exception exc);

        void a(String str, String str2);

        void b(String str, Exception exc);
    }

    private long shiftCheckSum(long j, int i) {
        int i2 = (i & 7) << 3;
        return (j >>> (64 - i2)) | (j << i2);
    }

    static {
        int b2 = am.b();
        PAGE_SIZE = b2;
        int max = Math.max(b2 << 1, 16384);
        DOUBLE_LIMIT = max;
        TRUNCATE_THRESHOLD = max << 1;
    }

    FastKV(String str, String str2, a[] aVarArr, int i) {
        this.path = str;
        this.name = str2;
        this.writingMode = i;
        HashMap hashMap = new HashMap();
        hashMap.put("StringSet", aj.a);
        if (aVarArr != null && aVarArr.length > 0) {
            for (a aVar : aVarArr) {
                String a2 = aVar.a();
                if (hashMap.containsKey(a2)) {
                    error("duplicate encoder tag:" + a2);
                } else {
                    hashMap.put(a2, aVar);
                }
            }
        }
        this.encoderMap = hashMap;
        loadData();
    }

    private synchronized void loadData() {
        long nanoTime = System.nanoTime();
        if (!loadFromCFile() && this.writingMode == 0) {
            loadFromABFile();
        }
        if (this.fastBuffer == null) {
            this.fastBuffer = new m(PAGE_SIZE);
        }
        if (this.logger != null) {
            info("loading finish, data len:" + this.dataEnd + ", get keys:" + this.data.size() + ", use time:" + ((System.nanoTime() - nanoTime) / 1000000) + " ms");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x010d A[Catch:{ Exception -> 0x01ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x012c A[ADDED_TO_REGION, Catch:{ Exception -> 0x01ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0198 A[Catch:{ Exception -> 0x01ba }] */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void loadFromABFile() {
        /*
            r20 = this;
            r1 = r20
            java.lang.String r0 = "rw"
            java.io.File r2 = new java.io.File
            java.lang.String r3 = r1.path
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r1.name
            r4.append(r5)
            java.lang.String r5 = ".kva"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r2.<init>(r3, r4)
            java.io.File r3 = new java.io.File
            java.lang.String r4 = r1.path
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = r1.name
            r5.append(r6)
            java.lang.String r6 = ".kvb"
            r5.append(r6)
            java.lang.String r5 = r5.toString()
            r3.<init>(r4, r5)
            boolean r4 = com.mbridge.msdk.foundation.tools.am.a((java.io.File) r2)     // Catch:{ Exception -> 0x01ba }
            if (r4 == 0) goto L_0x01ac
            boolean r4 = com.mbridge.msdk.foundation.tools.am.a((java.io.File) r3)     // Catch:{ Exception -> 0x01ba }
            if (r4 != 0) goto L_0x0046
            goto L_0x01ac
        L_0x0046:
            java.io.RandomAccessFile r4 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x01ba }
            r4.<init>(r2, r0)     // Catch:{ Exception -> 0x01ba }
            java.io.RandomAccessFile r5 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x01ba }
            r5.<init>(r3, r0)     // Catch:{ Exception -> 0x01ba }
            long r6 = r4.length()     // Catch:{ Exception -> 0x01ba }
            long r8 = r5.length()     // Catch:{ Exception -> 0x01ba }
            java.nio.channels.FileChannel r0 = r4.getChannel()     // Catch:{ Exception -> 0x01ba }
            r1.aChannel = r0     // Catch:{ Exception -> 0x01ba }
            java.nio.channels.FileChannel r0 = r5.getChannel()     // Catch:{ Exception -> 0x01ba }
            r1.bChannel = r0     // Catch:{ Exception -> 0x01ba }
            java.nio.channels.FileChannel r10 = r1.aChannel     // Catch:{ IOException -> 0x01a1 }
            java.nio.channels.FileChannel$MapMode r11 = java.nio.channels.FileChannel.MapMode.READ_WRITE     // Catch:{ IOException -> 0x01a1 }
            r12 = 0
            r4 = 0
            int r0 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0072
            r14 = r6
            goto L_0x0075
        L_0x0072:
            int r0 = PAGE_SIZE     // Catch:{ IOException -> 0x01a1 }
            long r14 = (long) r0     // Catch:{ IOException -> 0x01a1 }
        L_0x0075:
            java.nio.MappedByteBuffer r0 = r10.map(r11, r12, r14)     // Catch:{ IOException -> 0x01a1 }
            r1.aBuffer = r0     // Catch:{ IOException -> 0x01a1 }
            java.nio.ByteOrder r10 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ IOException -> 0x01a1 }
            r0.order(r10)     // Catch:{ IOException -> 0x01a1 }
            java.nio.channels.FileChannel r11 = r1.bChannel     // Catch:{ IOException -> 0x01a1 }
            java.nio.channels.FileChannel$MapMode r12 = java.nio.channels.FileChannel.MapMode.READ_WRITE     // Catch:{ IOException -> 0x01a1 }
            r13 = 0
            int r0 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x008c
            r15 = r8
            goto L_0x0090
        L_0x008c:
            int r0 = PAGE_SIZE     // Catch:{ IOException -> 0x01a1 }
            long r4 = (long) r0     // Catch:{ IOException -> 0x01a1 }
            r15 = r4
        L_0x0090:
            java.nio.MappedByteBuffer r0 = r11.map(r12, r13, r15)     // Catch:{ IOException -> 0x01a1 }
            r1.bBuffer = r0     // Catch:{ IOException -> 0x01a1 }
            java.nio.ByteOrder r4 = java.nio.ByteOrder.LITTLE_ENDIAN     // Catch:{ IOException -> 0x01a1 }
            r0.order(r4)     // Catch:{ IOException -> 0x01a1 }
            com.mbridge.msdk.foundation.tools.m r0 = new com.mbridge.msdk.foundation.tools.m     // Catch:{ Exception -> 0x01ba }
            java.nio.MappedByteBuffer r2 = r1.aBuffer     // Catch:{ Exception -> 0x01ba }
            int r2 = r2.capacity()     // Catch:{ Exception -> 0x01ba }
            r0.<init>((int) r2)     // Catch:{ Exception -> 0x01ba }
            r1.fastBuffer = r0     // Catch:{ Exception -> 0x01ba }
            r0 = 12
            r2 = 0
            int r4 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00b8
            int r4 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x00b8
            r1.dataEnd = r0     // Catch:{ Exception -> 0x01ba }
            goto L_0x01c4
        L_0x00b8:
            java.nio.MappedByteBuffer r2 = r1.aBuffer     // Catch:{ Exception -> 0x01ba }
            int r2 = r2.getInt()     // Catch:{ Exception -> 0x01ba }
            java.nio.MappedByteBuffer r3 = r1.aBuffer     // Catch:{ Exception -> 0x01ba }
            long r3 = r3.getLong()     // Catch:{ Exception -> 0x01ba }
            java.nio.MappedByteBuffer r5 = r1.bBuffer     // Catch:{ Exception -> 0x01ba }
            int r5 = r5.getInt()     // Catch:{ Exception -> 0x01ba }
            java.nio.MappedByteBuffer r10 = r1.bBuffer     // Catch:{ Exception -> 0x01ba }
            long r10 = r10.getLong()     // Catch:{ Exception -> 0x01ba }
            r13 = 12
            r15 = 0
            if (r2 < 0) goto L_0x010a
            long r0 = (long) r2     // Catch:{ Exception -> 0x01ba }
            long r17 = r6 - r13
            int r19 = (r0 > r17 ? 1 : (r0 == r17 ? 0 : -1))
            if (r19 > 0) goto L_0x0108
            int r0 = r2 + 12
            r1 = r20
            r1.dataEnd = r0     // Catch:{ Exception -> 0x01ba }
            java.nio.MappedByteBuffer r0 = r1.aBuffer     // Catch:{ Exception -> 0x01ba }
            r0.rewind()     // Catch:{ Exception -> 0x01ba }
            java.nio.MappedByteBuffer r0 = r1.aBuffer     // Catch:{ Exception -> 0x01ba }
            com.mbridge.msdk.foundation.tools.m r12 = r1.fastBuffer     // Catch:{ Exception -> 0x01ba }
            byte[] r12 = r12.a     // Catch:{ Exception -> 0x01ba }
            int r13 = r1.dataEnd     // Catch:{ Exception -> 0x01ba }
            r0.get(r12, r15, r13)     // Catch:{ Exception -> 0x01ba }
            com.mbridge.msdk.foundation.tools.m r0 = r1.fastBuffer     // Catch:{ Exception -> 0x01ba }
            r12 = 12
            long r13 = r0.b(r12, r2)     // Catch:{ Exception -> 0x01ba }
            int r0 = (r3 > r13 ? 1 : (r3 == r13 ? 0 : -1))
            if (r0 != 0) goto L_0x010a
            int r0 = r20.parseData()     // Catch:{ Exception -> 0x01ba }
            if (r0 != 0) goto L_0x010a
            r1.checksum = r3     // Catch:{ Exception -> 0x01ba }
            r0 = 1
            goto L_0x010b
        L_0x0108:
            r1 = r20
        L_0x010a:
            r0 = 0
        L_0x010b:
            if (r0 == 0) goto L_0x012c
            int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r0 != 0) goto L_0x0117
            boolean r0 = r20.isABFileEqual()     // Catch:{ Exception -> 0x01ba }
            if (r0 != 0) goto L_0x01c4
        L_0x0117:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x01ba }
            java.lang.String r2 = "B file error"
            r0.<init>(r2)     // Catch:{ Exception -> 0x01ba }
            r1.warning(r0)     // Catch:{ Exception -> 0x01ba }
            java.nio.MappedByteBuffer r0 = r1.aBuffer     // Catch:{ Exception -> 0x01ba }
            java.nio.MappedByteBuffer r2 = r1.bBuffer     // Catch:{ Exception -> 0x01ba }
            int r3 = r1.dataEnd     // Catch:{ Exception -> 0x01ba }
            r1.copyBuffer(r0, r2, r3)     // Catch:{ Exception -> 0x01ba }
            goto L_0x01c4
        L_0x012c:
            if (r5 < 0) goto L_0x0195
            long r2 = (long) r5     // Catch:{ Exception -> 0x01ba }
            r6 = 12
            long r8 = r8 - r6
            int r0 = (r2 > r8 ? 1 : (r2 == r8 ? 0 : -1))
            if (r0 > 0) goto L_0x0195
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.c$b> r0 = r1.data     // Catch:{ Exception -> 0x01ba }
            r0.clear()     // Catch:{ Exception -> 0x01ba }
            r20.clearInvalid()     // Catch:{ Exception -> 0x01ba }
            int r0 = r5 + 12
            r1.dataEnd = r0     // Catch:{ Exception -> 0x01ba }
            com.mbridge.msdk.foundation.tools.m r0 = r1.fastBuffer     // Catch:{ Exception -> 0x01ba }
            byte[] r0 = r0.a     // Catch:{ Exception -> 0x01ba }
            int r0 = r0.length     // Catch:{ Exception -> 0x01ba }
            java.nio.MappedByteBuffer r2 = r1.bBuffer     // Catch:{ Exception -> 0x01ba }
            int r2 = r2.capacity()     // Catch:{ Exception -> 0x01ba }
            if (r0 == r2) goto L_0x015c
            com.mbridge.msdk.foundation.tools.m r0 = new com.mbridge.msdk.foundation.tools.m     // Catch:{ Exception -> 0x01ba }
            java.nio.MappedByteBuffer r2 = r1.bBuffer     // Catch:{ Exception -> 0x01ba }
            int r2 = r2.capacity()     // Catch:{ Exception -> 0x01ba }
            r0.<init>((int) r2)     // Catch:{ Exception -> 0x01ba }
            r1.fastBuffer = r0     // Catch:{ Exception -> 0x01ba }
        L_0x015c:
            java.nio.MappedByteBuffer r0 = r1.bBuffer     // Catch:{ Exception -> 0x01ba }
            r0.rewind()     // Catch:{ Exception -> 0x01ba }
            java.nio.MappedByteBuffer r0 = r1.bBuffer     // Catch:{ Exception -> 0x01ba }
            com.mbridge.msdk.foundation.tools.m r2 = r1.fastBuffer     // Catch:{ Exception -> 0x01ba }
            byte[] r2 = r2.a     // Catch:{ Exception -> 0x01ba }
            int r3 = r1.dataEnd     // Catch:{ Exception -> 0x01ba }
            r0.get(r2, r15, r3)     // Catch:{ Exception -> 0x01ba }
            com.mbridge.msdk.foundation.tools.m r0 = r1.fastBuffer     // Catch:{ Exception -> 0x01ba }
            r2 = 12
            long r2 = r0.b(r2, r5)     // Catch:{ Exception -> 0x01ba }
            int r0 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0195
            int r0 = r20.parseData()     // Catch:{ Exception -> 0x01ba }
            if (r0 != 0) goto L_0x0195
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x01ba }
            java.lang.String r2 = "A file error"
            r0.<init>(r2)     // Catch:{ Exception -> 0x01ba }
            r1.warning(r0)     // Catch:{ Exception -> 0x01ba }
            java.nio.MappedByteBuffer r0 = r1.bBuffer     // Catch:{ Exception -> 0x01ba }
            java.nio.MappedByteBuffer r2 = r1.aBuffer     // Catch:{ Exception -> 0x01ba }
            int r3 = r1.dataEnd     // Catch:{ Exception -> 0x01ba }
            r1.copyBuffer(r0, r2, r3)     // Catch:{ Exception -> 0x01ba }
            r1.checksum = r10     // Catch:{ Exception -> 0x01ba }
            r12 = 1
            goto L_0x0196
        L_0x0195:
            r12 = 0
        L_0x0196:
            if (r12 != 0) goto L_0x01c4
            java.lang.String r0 = "both files error"
            r1.error((java.lang.String) r0)     // Catch:{ Exception -> 0x01ba }
            r20.resetData()     // Catch:{ Exception -> 0x01ba }
            goto L_0x01c4
        L_0x01a1:
            r0 = move-exception
            r1.error((java.lang.Exception) r0)     // Catch:{ Exception -> 0x01ba }
            r20.toBlockingMode()     // Catch:{ Exception -> 0x01ba }
            r1.tryBlockingIO(r2, r3)     // Catch:{ Exception -> 0x01ba }
            return
        L_0x01ac:
            java.lang.Exception r0 = new java.lang.Exception     // Catch:{ Exception -> 0x01ba }
            java.lang.String r2 = "open file failed"
            r0.<init>(r2)     // Catch:{ Exception -> 0x01ba }
            r1.error((java.lang.Exception) r0)     // Catch:{ Exception -> 0x01ba }
            r20.toBlockingMode()     // Catch:{ Exception -> 0x01ba }
            return
        L_0x01ba:
            r0 = move-exception
            r1.error((java.lang.Exception) r0)
            r20.clearData()
            r20.toBlockingMode()
        L_0x01c4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.loadFromABFile():void");
    }

    private void tryBlockingIO(File file, File file2) {
        try {
            if (loadWithBlockingIO(file)) {
                return;
            }
        } catch (IOException e) {
            warning(e);
        }
        clearData();
        try {
            if (loadWithBlockingIO(file2)) {
                return;
            }
        } catch (IOException e2) {
            warning(e2);
        }
        clearData();
    }

    private boolean isABFileEqual() {
        m mVar = new m(this.dataEnd);
        this.bBuffer.rewind();
        this.bBuffer.get(mVar.a, 0, this.dataEnd);
        byte[] bArr = this.fastBuffer.a;
        byte[] bArr2 = mVar.a;
        for (int i = 0; i < this.dataEnd; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean loadFromCFile() {
        String str = this.path;
        File file = new File(str, this.name + C_SUFFIX);
        String str2 = this.path;
        File file2 = new File(str2, this.name + TEMP_SUFFIX);
        boolean z = false;
        try {
            if (!file.exists()) {
                file = file2.exists() ? file2 : null;
            }
            if (file != null) {
                if (!loadWithBlockingIO(file)) {
                    clearData();
                    deleteCFiles();
                    return false;
                } else if (this.writingMode != 0) {
                    return false;
                } else {
                    if (writeToABFile(this.fastBuffer)) {
                        info("recover from c file");
                        try {
                            deleteCFiles();
                            return true;
                        } catch (Exception e) {
                            e = e;
                            z = true;
                            error(e);
                            return z;
                        }
                    } else {
                        this.writingMode = 1;
                        return false;
                    }
                }
            } else if (this.writingMode == 0) {
                return false;
            } else {
                String str3 = this.path;
                File file3 = new File(str3, this.name + A_SUFFIX);
                String str4 = this.path;
                File file4 = new File(str4, this.name + B_SUFFIX);
                if (!file3.exists() || !file4.exists()) {
                    return false;
                }
                tryBlockingIO(file3, file4);
                return false;
            }
        } catch (Exception e2) {
            e = e2;
            error(e);
            return z;
        }
    }

    private boolean loadWithBlockingIO(File file) throws IOException {
        m mVar;
        long length = file.length();
        if (length != 0 && length <= 536870912) {
            int i = (int) length;
            int newCapacity = getNewCapacity(PAGE_SIZE, i);
            m mVar2 = this.fastBuffer;
            if (mVar2 == null || mVar2.a.length != newCapacity) {
                m mVar3 = new m(new byte[newCapacity]);
                this.fastBuffer = mVar3;
                mVar = mVar3;
            } else {
                mVar = this.fastBuffer;
                mVar.b = 0;
            }
            am.a(file, mVar.a, i);
            int c2 = mVar.c();
            long d = mVar.d();
            this.dataEnd = c2 + 12;
            if (c2 >= 0 && c2 <= i - 12 && d == mVar.b(12, c2) && parseData() == 0) {
                this.checksum = d;
                return true;
            }
        }
        return false;
    }

    private boolean writeToABFile(m mVar) {
        int length = mVar.a.length;
        String str = this.path;
        File file = new File(str, this.name + A_SUFFIX);
        String str2 = this.path;
        File file2 = new File(str2, this.name + B_SUFFIX);
        try {
            if (!am.a(file) || !am.a(file2)) {
                throw new Exception(OPEN_FILE_FAILED);
            }
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(file2, "rw");
            long j = (long) length;
            randomAccessFile.setLength(j);
            randomAccessFile2.setLength(j);
            this.aChannel = randomAccessFile.getChannel();
            this.bChannel = randomAccessFile2.getChannel();
            MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0, j);
            this.aBuffer = map;
            map.order(ByteOrder.LITTLE_ENDIAN);
            MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0, j);
            this.bBuffer = map2;
            map2.order(ByteOrder.LITTLE_ENDIAN);
            this.aBuffer.put(mVar.a, 0, this.dataEnd);
            this.bBuffer.put(mVar.a, 0, this.dataEnd);
            return true;
        } catch (Exception e) {
            error(e);
            return false;
        }
    }

    private void checkValueSize(int i, boolean z) {
        if (z) {
            if (i != 32) {
                throw new IllegalStateException("name size not match");
            }
        } else if (i < 0 || i >= 2048) {
            throw new IllegalStateException("value size out of bound");
        }
    }

    private void copyBuffer(MappedByteBuffer mappedByteBuffer, MappedByteBuffer mappedByteBuffer2, int i) {
        if (mappedByteBuffer.capacity() != mappedByteBuffer2.capacity()) {
            try {
                MappedByteBuffer map = (mappedByteBuffer2 == this.bBuffer ? this.bChannel : this.aChannel).map(FileChannel.MapMode.READ_WRITE, 0, (long) mappedByteBuffer.capacity());
                map.order(ByteOrder.LITTLE_ENDIAN);
                if (mappedByteBuffer2 == this.bBuffer) {
                    this.bBuffer = map;
                } else {
                    this.aBuffer = map;
                }
                mappedByteBuffer2 = map;
            } catch (IOException e) {
                error((Exception) e);
                toBlockingMode();
                return;
            }
        }
        mappedByteBuffer.rewind();
        mappedByteBuffer2.rewind();
        mappedByteBuffer.limit(i);
        mappedByteBuffer2.put(mappedByteBuffer);
        mappedByteBuffer.limit(mappedByteBuffer.capacity());
    }

    private int parseData() {
        Object obj;
        m mVar = this.fastBuffer;
        mVar.b = 12;
        while (true) {
            try {
                boolean z = false;
                if (mVar.b < this.dataEnd) {
                    int i = mVar.b;
                    byte a2 = mVar.a();
                    byte b2 = (byte) (a2 & Utf8.REPLACEMENT_BYTE);
                    if (b2 >= 1 && b2 <= 8) {
                        byte a3 = mVar.a() & 255;
                        if (a2 < 0) {
                            mVar.b += a3;
                            int b3 = b2 <= 5 ? TYPE_SIZE[b2] : mVar.b() & UShort.MAX_VALUE;
                            this.fastBuffer.b += b3;
                            countInvalid(i, this.fastBuffer.b);
                        } else {
                            String b4 = mVar.b((int) a3);
                            int i2 = mVar.b;
                            if (b2 > 5) {
                                int b5 = mVar.b() & UShort.MAX_VALUE;
                                boolean z2 = (a2 & SignedBytes.MAX_POWER_OF_TWO) != 0;
                                checkValueSize(b5, z2);
                                if (b2 == 6) {
                                    this.data.put(b4, new c.i(i, i2 + 2, mVar.b(b5), b5, z2));
                                } else if (b2 == 7) {
                                    if (z2) {
                                        obj = mVar.b(b5);
                                    } else {
                                        obj = new byte[b5];
                                        System.arraycopy(mVar.a, mVar.b, obj, 0, b5);
                                        mVar.b += b5;
                                    }
                                    this.data.put(b4, new c.a(i, i2 + 2, obj, b5, z2));
                                } else if (z2) {
                                    this.data.put(b4, new c.h(i, i2 + 2, mVar.b(b5), b5, true));
                                } else {
                                    byte a4 = mVar.a() & 255;
                                    String b6 = mVar.b((int) a4);
                                    a aVar = this.encoderMap.get(b6);
                                    int i3 = b5 - (a4 + 1);
                                    if (i3 >= 0) {
                                        if (aVar != null) {
                                            try {
                                                Object a5 = aVar.a(mVar.a, mVar.b, i3);
                                                if (a5 != null) {
                                                    this.data.put(b4, new c.h(i, i2 + 2, a5, b5, false));
                                                }
                                            } catch (Exception e) {
                                                error(e);
                                            }
                                        } else {
                                            error("object with tag: " + b6 + " without encoder");
                                        }
                                        mVar.b += i3;
                                    } else {
                                        throw new Exception(PARSE_DATA_FAILED);
                                    }
                                }
                            } else if (b2 == 1) {
                                Map<String, c.b> map = this.data;
                                if (mVar.a() == 1) {
                                    z = true;
                                }
                                map.put(b4, new c.C0145c(i2, z));
                            } else if (b2 == 2) {
                                this.data.put(b4, new c.f(i2, mVar.c()));
                            } else if (b2 == 3) {
                                this.data.put(b4, new c.e(i2, Float.intBitsToFloat(mVar.c())));
                            } else if (b2 != 4) {
                                this.data.put(b4, new c.d(i2, Double.longBitsToDouble(mVar.d())));
                            } else {
                                this.data.put(b4, new c.g(i2, mVar.d()));
                            }
                        }
                    }
                } else if (mVar.b == this.dataEnd) {
                    return 0;
                } else {
                    warning(new Exception(PARSE_DATA_FAILED));
                    return -1;
                }
            } catch (Exception e2) {
                warning(e2);
                return -1;
            }
        }
        throw new Exception(PARSE_DATA_FAILED);
    }

    public synchronized boolean contains(String str) {
        return this.data.containsKey(str);
    }

    public synchronized boolean getBoolean(String str) {
        return getBoolean(str, false);
    }

    public synchronized boolean getBoolean(String str, boolean z) {
        c.C0145c cVar = (c.C0145c) this.data.get(str);
        if (cVar != null) {
            z = cVar.b;
        }
        return z;
    }

    public int getInt(String str) {
        return getInt(str, 0);
    }

    public synchronized int getInt(String str, int i) {
        c.f fVar = (c.f) this.data.get(str);
        if (fVar != null) {
            i = fVar.b;
        }
        return i;
    }

    public float getFloat(String str) {
        return getFloat(str, 0.0f);
    }

    public synchronized float getFloat(String str, float f) {
        c.e eVar = (c.e) this.data.get(str);
        if (eVar != null) {
            f = eVar.b;
        }
        return f;
    }

    public synchronized long getLong(String str) {
        long j;
        c.g gVar = (c.g) this.data.get(str);
        if (gVar == null) {
            j = 0;
        } else {
            j = gVar.b;
        }
        return j;
    }

    public synchronized long getLong(String str, long j) {
        c.g gVar = (c.g) this.data.get(str);
        if (gVar != null) {
            j = gVar.b;
        }
        return j;
    }

    public double getDouble(String str) {
        return getDouble(str, 0.0d);
    }

    public synchronized double getDouble(String str, double d) {
        c.d dVar = (c.d) this.data.get(str);
        if (dVar != null) {
            d = dVar.b;
        }
        return d;
    }

    public String getString(String str) {
        return getString(str, "");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0019, code lost:
        return r2.e ? getStringFromFile(r2) : (java.lang.String) r2.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized java.lang.String getString(java.lang.String r2, java.lang.String r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.c$b> r0 = r1.data     // Catch:{ all -> 0x001c }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001c }
            com.mbridge.msdk.foundation.tools.c$i r2 = (com.mbridge.msdk.foundation.tools.c.i) r2     // Catch:{ all -> 0x001c }
            if (r2 == 0) goto L_0x001a
            boolean r3 = r2.e     // Catch:{ all -> 0x001c }
            if (r3 == 0) goto L_0x0014
            java.lang.String r2 = r1.getStringFromFile(r2)     // Catch:{ all -> 0x001c }
            goto L_0x0018
        L_0x0014:
            java.lang.Object r2 = r2.b     // Catch:{ all -> 0x001c }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x001c }
        L_0x0018:
            monitor-exit(r1)
            return r2
        L_0x001a:
            monitor-exit(r1)
            return r3
        L_0x001c:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.getString(java.lang.String, java.lang.String):java.lang.String");
    }

    private String getStringFromFile(c.i iVar) {
        try {
            byte[] b2 = am.b(new File(this.path + this.name, (String) iVar.b));
            if (b2 != null) {
                if (b2.length == 0) {
                    return "";
                }
                return new String(b2, StandardCharsets.UTF_8);
            }
        } catch (Exception e) {
            error(e);
        }
        return "";
    }

    public byte[] getArray(String str) {
        return getArray(str, EMPTY_ARRAY);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001b, code lost:
        return r2.e ? getArrayFromFile(r2) : (byte[]) r2.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] getArray(java.lang.String r2, byte[] r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.c$b> r0 = r1.data     // Catch:{ all -> 0x001e }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001e }
            com.mbridge.msdk.foundation.tools.c$a r2 = (com.mbridge.msdk.foundation.tools.c.a) r2     // Catch:{ all -> 0x001e }
            if (r2 == 0) goto L_0x001c
            boolean r3 = r2.e     // Catch:{ all -> 0x001e }
            if (r3 == 0) goto L_0x0014
            byte[] r2 = r1.getArrayFromFile(r2)     // Catch:{ all -> 0x001e }
            goto L_0x001a
        L_0x0014:
            java.lang.Object r2 = r2.b     // Catch:{ all -> 0x001e }
            byte[] r2 = (byte[]) r2     // Catch:{ all -> 0x001e }
            byte[] r2 = (byte[]) r2     // Catch:{ all -> 0x001e }
        L_0x001a:
            monitor-exit(r1)
            return r2
        L_0x001c:
            monitor-exit(r1)
            return r3
        L_0x001e:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.getArray(java.lang.String, byte[]):byte[]");
    }

    private byte[] getArrayFromFile(c.a aVar) {
        try {
            byte[] b2 = am.b(new File(this.path + this.name, (String) aVar.b));
            return b2 != null ? b2 : EMPTY_ARRAY;
        } catch (Exception e) {
            error(e);
            return EMPTY_ARRAY;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0017, code lost:
        return r2.e ? getObjectFromFile(r2) : r2.b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T> T getObject(java.lang.String r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.c$b> r0 = r1.data     // Catch:{ all -> 0x001b }
            java.lang.Object r2 = r0.get(r2)     // Catch:{ all -> 0x001b }
            com.mbridge.msdk.foundation.tools.c$h r2 = (com.mbridge.msdk.foundation.tools.c.h) r2     // Catch:{ all -> 0x001b }
            if (r2 == 0) goto L_0x0018
            boolean r0 = r2.e     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0014
            java.lang.Object r2 = r1.getObjectFromFile(r2)     // Catch:{ all -> 0x001b }
            goto L_0x0016
        L_0x0014:
            java.lang.Object r2 = r2.b     // Catch:{ all -> 0x001b }
        L_0x0016:
            monitor-exit(r1)
            return r2
        L_0x0018:
            monitor-exit(r1)
            r2 = 0
            return r2
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.getObject(java.lang.String):java.lang.Object");
    }

    private Object getObjectFromFile(c.h hVar) {
        try {
            byte[] b2 = am.b(new File(this.path + this.name, (String) hVar.b));
            if (b2 != null) {
                byte b3 = b2[0] & 255;
                String str = new String(b2, 1, b3, StandardCharsets.UTF_8);
                a aVar = this.encoderMap.get(str);
                if (aVar != null) {
                    int i = b3 + 1;
                    return aVar.a(b2, i, b2.length - i);
                }
                warning(new Exception("No encoder for tag:".concat(str)));
                return null;
            }
            warning(new Exception("Read object data failed"));
            return null;
        } catch (Exception e) {
            error(e);
            return null;
        }
    }

    public synchronized Set<String> getStringSet(String str) {
        return (Set) getObject(str);
    }

    public synchronized void putBoolean(String str, boolean z) {
        checkKey(str);
        c.C0145c cVar = (c.C0145c) this.data.get(str);
        int i = 0;
        if (cVar == null) {
            wrapHeader(str, (byte) 1);
            int i2 = this.fastBuffer.b;
            m mVar = this.fastBuffer;
            if (z) {
                i = 1;
            }
            mVar.a((byte) i);
            updateChange();
            this.data.put(str, new c.C0145c(i2, z));
            checkIfCommit();
        } else if (cVar.b != z) {
            cVar.b = z;
            if (z) {
                i = 1;
            }
            updateBoolean((byte) i, cVar.a);
            checkIfCommit();
        }
    }

    public synchronized void putInt(String str, int i) {
        checkKey(str);
        c.f fVar = (c.f) this.data.get(str);
        if (fVar == null) {
            wrapHeader(str, (byte) 2);
            int i2 = this.fastBuffer.b;
            this.fastBuffer.a(i);
            updateChange();
            this.data.put(str, new c.f(i2, i));
            checkIfCommit();
        } else if (fVar.b != i) {
            fVar.b = i;
            updateInt32(i, ((long) (fVar.b ^ i)) & 4294967295L, fVar.a);
            checkIfCommit();
        }
    }

    public synchronized void putFloat(String str, float f) {
        checkKey(str);
        c.e eVar = (c.e) this.data.get(str);
        if (eVar == null) {
            wrapHeader(str, (byte) 3);
            int i = this.fastBuffer.b;
            this.fastBuffer.a(Float.floatToRawIntBits(f));
            updateChange();
            this.data.put(str, new c.e(i, f));
            checkIfCommit();
        } else if (eVar.b != f) {
            int floatToRawIntBits = Float.floatToRawIntBits(f);
            eVar.b = f;
            updateInt32(floatToRawIntBits, ((long) (Float.floatToRawIntBits(eVar.b) ^ floatToRawIntBits)) & 4294967295L, eVar.a);
            checkIfCommit();
        }
    }

    public synchronized void putLong(String str, long j) {
        checkKey(str);
        c.g gVar = (c.g) this.data.get(str);
        if (gVar == null) {
            wrapHeader(str, (byte) 4);
            int i = this.fastBuffer.b;
            this.fastBuffer.a(j);
            updateChange();
            this.data.put(str, new c.g(i, j));
            checkIfCommit();
        } else if (gVar.b != j) {
            gVar.b = j;
            updateInt64(j, j ^ gVar.b, gVar.a);
            checkIfCommit();
        }
    }

    public synchronized void putDouble(String str, double d) {
        checkKey(str);
        c.d dVar = (c.d) this.data.get(str);
        if (dVar == null) {
            wrapHeader(str, (byte) 5);
            int i = this.fastBuffer.b;
            this.fastBuffer.a(Double.doubleToRawLongBits(d));
            updateChange();
            this.data.put(str, new c.d(i, d));
            checkIfCommit();
        } else if (dVar.b != d) {
            long doubleToRawLongBits = Double.doubleToRawLongBits(d);
            dVar.b = d;
            updateInt64(doubleToRawLongBits, Double.doubleToRawLongBits(dVar.b) ^ doubleToRawLongBits, dVar.a);
            checkIfCommit();
        }
    }

    public synchronized void putString(String str, String str2) {
        checkKey(str);
        if (str2 == null) {
            remove(str);
        } else {
            c.i iVar = (c.i) this.data.get(str);
            if (str2.length() * 3 < 2048) {
                fastPutString(str, str2, iVar);
            } else {
                addOrUpdate(str, str2, str2.isEmpty() ? EMPTY_ARRAY : str2.getBytes(StandardCharsets.UTF_8), iVar, (byte) 6);
            }
        }
    }

    public synchronized void putArray(String str, byte[] bArr) {
        checkKey(str);
        if (bArr == null) {
            remove(str);
        } else {
            addOrUpdate(str, bArr, bArr, (c.a) this.data.get(str), (byte) 7);
        }
    }

    public synchronized <T> void putObject(String str, T t, a<T> aVar) {
        byte[] bArr;
        checkKey(str);
        if (aVar != null) {
            String a2 = aVar.a();
            if (a2 == null || a2.isEmpty() || a2.length() > 50) {
                throw new IllegalArgumentException("Invalid encoder tag:" + a2);
            } else if (!this.encoderMap.containsKey(a2)) {
                throw new IllegalArgumentException("Encoder hasn't been registered");
            } else if (t == null) {
                remove(str);
            } else {
                try {
                    bArr = aVar.a(t);
                } catch (Exception e) {
                    error(e);
                    bArr = null;
                }
                if (bArr == null) {
                    remove(str);
                    return;
                }
                int b2 = m.b(a2);
                m mVar = new m(b2 + 1 + bArr.length);
                mVar.a((byte) b2);
                mVar.a(a2);
                mVar.a(bArr);
                addOrUpdate(str, t, mVar.a, (c.h) this.data.get(str), (byte) 8);
            }
        } else {
            throw new IllegalArgumentException("Encoder is null");
        }
    }

    public synchronized void putStringSet(String str, Set<String> set) {
        if (set == null) {
            remove(str);
        } else {
            putObject(str, set, aj.a);
        }
    }

    public synchronized void remove(String str) {
        c.b bVar = this.data.get(str);
        if (bVar != null) {
            this.data.remove(str);
            byte a2 = bVar.a();
            String str2 = null;
            if (a2 <= 5) {
                remove(a2, bVar.a - (m.b(str) + 2), bVar.a + TYPE_SIZE[a2]);
            } else {
                c.j jVar = (c.j) bVar;
                remove(a2, jVar.c, jVar.a + jVar.d);
                if (jVar.e) {
                    str2 = (String) jVar.b;
                }
            }
            byte b2 = (byte) (a2 | Byte.MIN_VALUE);
            if (this.writingMode == 0) {
                this.aBuffer.putLong(4, this.checksum);
                this.aBuffer.put(this.removeStart, b2);
                this.bBuffer.putLong(4, this.checksum);
                this.bBuffer.put(this.removeStart, b2);
            } else {
                this.fastBuffer.a(4, this.checksum);
            }
            this.removeStart = 0;
            if (str2 != null) {
                am.c(new File(this.path + this.name, str2));
            }
            checkGC();
            checkIfCommit();
        }
    }

    public synchronized void clear() {
        resetData();
        if (this.writingMode != 0) {
            deleteCFiles();
        }
    }

    public synchronized Map<String, Object> getAll() {
        Object obj;
        int size = this.data.size();
        if (size == 0) {
            return new HashMap();
        }
        HashMap hashMap = new HashMap(((size * 4) / 3) + 1);
        for (Map.Entry next : this.data.entrySet()) {
            String str = (String) next.getKey();
            c.b bVar = (c.b) next.getValue();
            switch (bVar.a()) {
                case 1:
                    obj = Boolean.valueOf(((c.C0145c) bVar).b);
                    break;
                case 2:
                    obj = Integer.valueOf(((c.f) bVar).b);
                    break;
                case 3:
                    obj = Float.valueOf(((c.e) bVar).b);
                    break;
                case 4:
                    obj = Long.valueOf(((c.g) bVar).b);
                    break;
                case 5:
                    obj = Double.valueOf(((c.d) bVar).b);
                    break;
                case 6:
                    c.i iVar = (c.i) bVar;
                    if (!iVar.e) {
                        obj = iVar.b;
                        break;
                    } else {
                        obj = getStringFromFile(iVar);
                        break;
                    }
                case 7:
                    c.a aVar = (c.a) bVar;
                    if (!aVar.e) {
                        obj = aVar.b;
                        break;
                    } else {
                        obj = getArrayFromFile(aVar);
                        break;
                    }
                case 8:
                    c.h hVar = (c.h) bVar;
                    if (!hVar.e) {
                        obj = ((c.h) bVar).b;
                        break;
                    } else {
                        obj = getObjectFromFile(hVar);
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            hashMap.put(str, obj);
        }
        return hashMap;
    }

    public void putAll(Map<String, Object> map) {
        putAll(map, (Map<Class, a>) null);
    }

    public synchronized void putAll(Map<String, Object> map, Map<Class, a> map2) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            Object value = next.getValue();
            if (str != null && !str.isEmpty()) {
                if (value instanceof String) {
                    putString(str, (String) value);
                } else if (value instanceof Boolean) {
                    putBoolean(str, ((Boolean) value).booleanValue());
                } else if (value instanceof Integer) {
                    putInt(str, ((Integer) value).intValue());
                } else if (value instanceof Long) {
                    putLong(str, ((Long) value).longValue());
                } else if (value instanceof Float) {
                    putFloat(str, ((Float) value).floatValue());
                } else if (value instanceof Double) {
                    putDouble(str, ((Double) value).doubleValue());
                } else if (value instanceof Set) {
                    Set set = (Set) value;
                    if (!set.isEmpty() && (set.iterator().next() instanceof String)) {
                        putStringSet(str, (Set) value);
                    }
                } else if (value instanceof byte[]) {
                    putArray(str, (byte[]) value);
                } else if (map2 != null) {
                    a aVar = map2.get(value.getClass());
                    if (aVar != null) {
                        putObject(str, value, aVar);
                    } else {
                        warning(new Exception("missing encoder for type:" + value.getClass()));
                    }
                } else {
                    warning(new Exception("missing encoders"));
                }
            }
        }
    }

    public synchronized void force() {
        if (this.writingMode == 0) {
            this.aBuffer.force();
            this.bBuffer.force();
        }
    }

    public synchronized void disableAutoCommit() {
        this.autoCommit = false;
    }

    public synchronized boolean commit() {
        this.autoCommit = true;
        return commitToCFile();
    }

    private void checkIfCommit() {
        if (this.writingMode != 0 && this.autoCommit) {
            commitToCFile();
        }
    }

    private boolean commitToCFile() {
        int i = this.writingMode;
        if (i == 1) {
            this.executor.execute(new Runnable() {
                public final void run() {
                    boolean unused = FastKV.this.writeToCFile();
                }
            });
        } else if (i == 2) {
            return writeToCFile();
        }
        return true;
    }

    /* access modifiers changed from: private */
    public synchronized boolean writeToCFile() {
        try {
            String str = this.path;
            File file = new File(str, this.name + TEMP_SUFFIX);
            if (am.a(file)) {
                RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                randomAccessFile.setLength((long) this.dataEnd);
                randomAccessFile.write(this.fastBuffer.a, 0, this.dataEnd);
                randomAccessFile.close();
                String str2 = this.path;
                File file2 = new File(str2, this.name + C_SUFFIX);
                if (!file2.exists() || file2.delete()) {
                    if (file.renameTo(file2)) {
                        return true;
                    }
                    warning(new Exception("rename failed"));
                }
            }
        } catch (Exception e) {
            error(e);
        }
        return false;
    }

    private void deleteCFiles() {
        try {
            String str = this.path;
            am.c(new File(str, this.name + C_SUFFIX));
            String str2 = this.path;
            am.c(new File(str2, this.name + TEMP_SUFFIX));
        } catch (Exception e) {
            error(e);
        }
    }

    private void toBlockingMode() {
        this.writingMode = 1;
        am.a((Closeable) this.aChannel);
        am.a((Closeable) this.bChannel);
        this.aChannel = null;
        this.bChannel = null;
        this.aBuffer = null;
        this.bBuffer = null;
    }

    private void resetData() {
        if (this.writingMode == 0) {
            try {
                resetBuffer(this.aBuffer);
                resetBuffer(this.bBuffer);
            } catch (IOException unused) {
                toBlockingMode();
            }
        }
        clearData();
        am.c(new File(this.path + this.name));
    }

    private void resetBuffer(MappedByteBuffer mappedByteBuffer) throws IOException {
        int capacity = mappedByteBuffer.capacity();
        int i = PAGE_SIZE;
        if (capacity != i) {
            FileChannel fileChannel = mappedByteBuffer == this.aBuffer ? this.aChannel : this.bChannel;
            fileChannel.truncate((long) i);
            MappedByteBuffer map = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, (long) i);
            map.order(ByteOrder.LITTLE_ENDIAN);
            if (mappedByteBuffer == this.aBuffer) {
                this.aBuffer = map;
            } else {
                this.bBuffer = map;
            }
            mappedByteBuffer = map;
        }
        mappedByteBuffer.putInt(0, 0);
        mappedByteBuffer.putLong(4, 0);
    }

    private void clearData() {
        this.dataEnd = 12;
        this.checksum = 0;
        clearInvalid();
        this.data.clear();
        m mVar = this.fastBuffer;
        if (mVar == null || mVar.a.length != PAGE_SIZE) {
            this.fastBuffer = new m(PAGE_SIZE);
            return;
        }
        this.fastBuffer.a(0, 0);
        this.fastBuffer.a(4, 0);
    }

    private void checkKey(String str) {
        if (str == null || str.isEmpty()) {
            throw new IllegalArgumentException("key is empty");
        }
    }

    private void checkKeySize(int i) {
        if (i > 255) {
            throw new IllegalArgumentException("key's length must less than 256");
        }
    }

    private void wrapHeader(String str, byte b2) {
        wrapHeader(str, b2, TYPE_SIZE[b2]);
    }

    private void wrapHeader(String str, byte b2, int i) {
        int b3 = m.b(str);
        checkKeySize(b3);
        this.updateSize = b3 + 2 + i;
        preparePutBytes();
        this.fastBuffer.a(b2);
        putKey(str, b3);
    }

    private void updateChange() {
        this.checksum ^= this.fastBuffer.b(this.updateStart, this.updateSize);
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            syncABBuffer(this.aBuffer);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            syncABBuffer(this.bBuffer);
        } else {
            if (this.sizeChanged) {
                this.fastBuffer.a(0, this.dataEnd - 12);
            }
            this.fastBuffer.a(4, this.checksum);
        }
        this.sizeChanged = false;
        this.removeStart = 0;
        this.updateSize = 0;
    }

    private void syncABBuffer(MappedByteBuffer mappedByteBuffer) {
        if (this.sizeChanged && mappedByteBuffer != this.aBuffer) {
            mappedByteBuffer.putInt(0, this.dataEnd - 12);
        }
        mappedByteBuffer.putLong(4, this.checksum);
        int i = this.removeStart;
        if (i != 0) {
            mappedByteBuffer.put(i, this.fastBuffer.a[this.removeStart]);
        }
        if (this.updateSize != 0) {
            mappedByteBuffer.position(this.updateStart);
            mappedByteBuffer.put(this.fastBuffer.a, this.updateStart, this.updateSize);
        }
    }

    private int bytesThreshold() {
        int i = this.dataEnd;
        if (i <= 16384) {
            return 4096;
        }
        return i <= 65536 ? 8192 : 16384;
    }

    private void ensureSize(int i) {
        int length = this.fastBuffer.a.length;
        int i2 = this.dataEnd + i;
        if (i2 >= length) {
            int i3 = this.invalidBytes;
            if (i3 <= i || i3 <= bytesThreshold()) {
                int newCapacity = getNewCapacity(length, i2);
                byte[] bArr = new byte[newCapacity];
                System.arraycopy(this.fastBuffer.a, 0, bArr, 0, this.dataEnd);
                this.fastBuffer.a = bArr;
                if (this.writingMode == 0) {
                    try {
                        long j = (long) newCapacity;
                        MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0, j);
                        this.aBuffer = map;
                        map.order(ByteOrder.LITTLE_ENDIAN);
                        MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0, j);
                        this.bBuffer = map2;
                        map2.order(ByteOrder.LITTLE_ENDIAN);
                    } catch (IOException e) {
                        error(new Exception(MAP_FAILED, e));
                        this.fastBuffer.a(0, this.dataEnd - 12);
                        this.fastBuffer.a(4, this.checksum);
                        toBlockingMode();
                    }
                }
            } else {
                gc(i);
            }
        }
    }

    private void updateBoolean(byte b2, int i) {
        long shiftCheckSum = this.checksum ^ shiftCheckSum(1, i);
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.put(i, b2);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.put(i, b2);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.a[i] = b2;
    }

    private void updateInt32(int i, long j, int i2) {
        long shiftCheckSum = shiftCheckSum(j, i2) ^ this.checksum;
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.putInt(i2, i);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putInt(i2, i);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.a(i2, i);
    }

    private void updateInt64(long j, long j2, int i) {
        long shiftCheckSum = shiftCheckSum(j2, i) ^ this.checksum;
        this.checksum = shiftCheckSum;
        if (this.writingMode == 0) {
            this.aBuffer.putLong(4, shiftCheckSum);
            this.aBuffer.putLong(i, j);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.putLong(i, j);
        } else {
            this.fastBuffer.a(4, shiftCheckSum);
        }
        this.fastBuffer.a(i, j);
    }

    private void updateBytes(int i, byte[] bArr) {
        int length = bArr.length;
        this.checksum ^= this.fastBuffer.b(i, length);
        this.fastBuffer.b = i;
        this.fastBuffer.a(bArr);
        long b2 = this.checksum ^ this.fastBuffer.b(i, length);
        this.checksum = b2;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i);
            this.aBuffer.put(bArr);
            this.aBuffer.putInt(0, this.dataEnd - 12);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i);
            this.bBuffer.put(bArr);
            return;
        }
        this.fastBuffer.a(4, b2);
    }

    private void preparePutBytes() {
        ensureSize(this.updateSize);
        int i = this.dataEnd;
        this.updateStart = i;
        this.dataEnd = this.updateSize + i;
        this.fastBuffer.b = i;
        this.sizeChanged = true;
    }

    private void putKey(String str, int i) {
        this.fastBuffer.a((byte) i);
        if (i == str.length()) {
            str.getBytes(0, i, this.fastBuffer.a, this.fastBuffer.b);
            this.fastBuffer.b += i;
            return;
        }
        this.fastBuffer.a(str);
    }

    private void putStringValue(String str, int i) {
        this.fastBuffer.a((short) i);
        if (i == str.length()) {
            str.getBytes(0, i, this.fastBuffer.a, this.fastBuffer.b);
        } else {
            this.fastBuffer.a(str);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void fastPutString(java.lang.String r11, java.lang.String r12, com.mbridge.msdk.foundation.tools.c.i r13) {
        /*
            r10 = this;
            int r4 = com.mbridge.msdk.foundation.tools.m.b((java.lang.String) r12)
            r0 = 6
            if (r13 != 0) goto L_0x003a
            int r13 = com.mbridge.msdk.foundation.tools.m.b((java.lang.String) r11)
            r10.checkKeySize(r13)
            int r1 = r13 + 4
            int r2 = r1 + r4
            r10.updateSize = r2
            r10.preparePutBytes()
            com.mbridge.msdk.foundation.tools.m r2 = r10.fastBuffer
            r2.a((byte) r0)
            r10.putKey(r11, r13)
            r10.putStringValue(r12, r4)
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.c$b> r13 = r10.data
            com.mbridge.msdk.foundation.tools.c$i r6 = new com.mbridge.msdk.foundation.tools.c$i
            int r2 = r10.updateStart
            int r3 = r2 + r1
            r5 = 0
            r0 = r6
            r1 = r2
            r2 = r3
            r3 = r12
            r0.<init>(r1, r2, r3, r4, r5)
            r13.put(r11, r6)
            r10.updateChange()
            goto L_0x00e9
        L_0x003a:
            int r11 = r13.a
            int r1 = r13.c
            int r11 = r11 - r1
            int r1 = r13.d
            r2 = 0
            r3 = 0
            if (r1 != r4) goto L_0x0076
            long r0 = r10.checksum
            com.mbridge.msdk.foundation.tools.m r11 = r10.fastBuffer
            int r5 = r13.a
            int r6 = r13.d
            long r5 = r11.b(r5, r6)
            long r0 = r0 ^ r5
            r10.checksum = r0
            int r11 = r12.length()
            if (r4 != r11) goto L_0x0064
            com.mbridge.msdk.foundation.tools.m r11 = r10.fastBuffer
            byte[] r11 = r11.a
            int r0 = r13.a
            r12.getBytes(r2, r4, r11, r0)
            goto L_0x006f
        L_0x0064:
            com.mbridge.msdk.foundation.tools.m r11 = r10.fastBuffer
            int r0 = r13.a
            r11.b = r0
            com.mbridge.msdk.foundation.tools.m r11 = r10.fastBuffer
            r11.a((java.lang.String) r12)
        L_0x006f:
            int r11 = r13.a
            r10.updateStart = r11
            r10.updateSize = r4
            goto L_0x00c2
        L_0x0076:
            int r1 = r11 + r4
            r10.updateSize = r1
            r10.preparePutBytes()
            com.mbridge.msdk.foundation.tools.m r1 = r10.fastBuffer
            r1.a((byte) r0)
            int r1 = r11 + -3
            com.mbridge.msdk.foundation.tools.m r5 = r10.fastBuffer
            byte[] r5 = r5.a
            int r6 = r13.c
            r7 = 1
            int r6 = r6 + r7
            com.mbridge.msdk.foundation.tools.m r8 = r10.fastBuffer
            byte[] r8 = r8.a
            com.mbridge.msdk.foundation.tools.m r9 = r10.fastBuffer
            int r9 = r9.b
            java.lang.System.arraycopy(r5, r6, r8, r9, r1)
            com.mbridge.msdk.foundation.tools.m r5 = r10.fastBuffer
            int r6 = r5.b
            int r6 = r6 + r1
            r5.b = r6
            r10.putStringValue(r12, r4)
            int r1 = r13.c
            int r5 = r13.a
            int r6 = r13.d
            int r5 = r5 + r6
            r10.remove(r0, r1, r5)
            boolean r0 = r13.e
            if (r0 == 0) goto L_0x00b4
            java.lang.Object r0 = r13.b
            r3 = r0
            java.lang.String r3 = (java.lang.String) r3
        L_0x00b4:
            r13.e = r2
            int r0 = r10.updateStart
            r13.c = r0
            int r0 = r10.updateStart
            int r0 = r0 + r11
            r13.a = r0
            r13.d = r4
            r2 = 1
        L_0x00c2:
            r13.b = r12
            r10.updateChange()
            if (r2 == 0) goto L_0x00cc
            r10.checkGC()
        L_0x00cc:
            if (r3 == 0) goto L_0x00e9
            java.io.File r11 = new java.io.File
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r13 = r10.path
            r12.append(r13)
            java.lang.String r13 = r10.name
            r12.append(r13)
            java.lang.String r12 = r12.toString()
            r11.<init>(r12, r3)
            com.mbridge.msdk.foundation.tools.am.c(r11)
        L_0x00e9:
            r10.checkIfCommit()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.fastPutString(java.lang.String, java.lang.String, com.mbridge.msdk.foundation.tools.c$i):void");
    }

    private void addOrUpdate(String str, Object obj, byte[] bArr, c.j jVar, byte b2) {
        if (jVar == null) {
            addObject(str, obj, bArr, b2);
        } else if (jVar.e || jVar.d != bArr.length) {
            updateObject(str, obj, bArr, jVar);
        } else {
            updateBytes(jVar.a, bArr);
            jVar.b = obj;
        }
        checkIfCommit();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r0v4, types: [com.mbridge.msdk.foundation.tools.c$h] */
    /* JADX WARNING: type inference failed for: r0v5, types: [com.mbridge.msdk.foundation.tools.c$a] */
    /* JADX WARNING: type inference failed for: r0v6, types: [com.mbridge.msdk.foundation.tools.c$i] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void addObject(java.lang.String r7, java.lang.Object r8, byte[] r9, byte r10) {
        /*
            r6 = this;
            int r2 = r6.saveArray(r7, r9, r10)
            if (r2 == 0) goto L_0x0047
            java.lang.String r0 = r6.tempExternalName
            if (r0 == 0) goto L_0x000d
            r1 = 1
            r5 = 1
            goto L_0x000f
        L_0x000d:
            r1 = 0
            r5 = 0
        L_0x000f:
            if (r5 == 0) goto L_0x001a
            r8 = 0
            r6.tempExternalName = r8
            r8 = 32
            r3 = r0
            r4 = 32
            goto L_0x001d
        L_0x001a:
            int r9 = r9.length
            r3 = r8
            r4 = r9
        L_0x001d:
            r8 = 6
            if (r10 != r8) goto L_0x002b
            com.mbridge.msdk.foundation.tools.c$i r8 = new com.mbridge.msdk.foundation.tools.c$i
            int r1 = r6.updateStart
            java.lang.String r3 = (java.lang.String) r3
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x003f
        L_0x002b:
            r8 = 7
            if (r10 != r8) goto L_0x0037
            com.mbridge.msdk.foundation.tools.c$a r8 = new com.mbridge.msdk.foundation.tools.c$a
            int r1 = r6.updateStart
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
            goto L_0x003f
        L_0x0037:
            com.mbridge.msdk.foundation.tools.c$h r8 = new com.mbridge.msdk.foundation.tools.c$h
            int r1 = r6.updateStart
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5)
        L_0x003f:
            java.util.Map<java.lang.String, com.mbridge.msdk.foundation.tools.c$b> r9 = r6.data
            r9.put(r7, r8)
            r6.updateChange()
        L_0x0047:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.tools.FastKV.addObject(java.lang.String, java.lang.Object, byte[], byte):void");
    }

    private void updateObject(String str, Object obj, byte[] bArr, c.j jVar) {
        int saveArray = saveArray(str, bArr, jVar.a());
        if (saveArray != 0) {
            String str2 = jVar.e ? (String) jVar.b : null;
            remove(jVar.a(), jVar.c, jVar.a + jVar.d);
            boolean z = this.tempExternalName != null;
            jVar.c = this.updateStart;
            jVar.a = saveArray;
            jVar.e = z;
            if (z) {
                jVar.b = this.tempExternalName;
                jVar.d = 32;
                this.tempExternalName = null;
            } else {
                jVar.b = obj;
                jVar.d = bArr.length;
            }
            updateChange();
            checkGC();
            if (str2 != null) {
                am.c(new File(this.path + this.name, str2));
            }
        }
    }

    private int saveArray(String str, byte[] bArr, byte b2) {
        this.tempExternalName = null;
        if (bArr.length < 2048) {
            return wrapArray(str, bArr, b2);
        }
        info("large value, key: " + str + ", size: " + bArr.length);
        String a2 = am.a();
        if (am.a(new File(this.path + this.name, a2), bArr)) {
            this.tempExternalName = a2;
            byte[] bArr2 = new byte[32];
            a2.getBytes(0, 32, bArr2, 0);
            return wrapArray(str, bArr2, (byte) (b2 | SignedBytes.MAX_POWER_OF_TWO));
        }
        error("save large value failed");
        return 0;
    }

    private int wrapArray(String str, byte[] bArr, byte b2) {
        wrapHeader(str, b2, bArr.length + 2);
        this.fastBuffer.a((short) bArr.length);
        int i = this.fastBuffer.b;
        this.fastBuffer.a(bArr);
        return i;
    }

    private void remove(byte b2, int i, int i2) {
        countInvalid(i, i2);
        byte b3 = (byte) (b2 | Byte.MIN_VALUE);
        this.checksum ^= (((long) (this.fastBuffer.a[i] ^ b3)) & 255) << ((i & 7) << 3);
        this.fastBuffer.a[i] = b3;
        this.removeStart = i;
    }

    private void checkGC() {
        if (this.invalidBytes < (bytesThreshold() << 1)) {
            if (this.invalids.size() < (this.dataEnd < 16384 ? 80 : 160)) {
                return;
            }
        }
        gc(0);
    }

    private void mergeInvalids() {
        int size = this.invalids.size() - 1;
        c cVar = this.invalids.get(size);
        while (size > 0) {
            size--;
            c cVar2 = this.invalids.get(size);
            if (cVar.a == cVar2.b) {
                cVar2.b = cVar.b;
                this.invalids.remove(size + 1);
            }
            cVar = cVar2;
        }
    }

    /* access modifiers changed from: package-private */
    public void gc(int i) {
        Collections.sort(this.invalids);
        mergeInvalids();
        c cVar = this.invalids.get(0);
        int i2 = cVar.a;
        int i3 = this.dataEnd;
        int i4 = i3 - this.invalidBytes;
        int i5 = i4 - 12;
        int i6 = i4 - i2;
        int i7 = i3 - i2;
        boolean z = i5 < i7 + i6;
        if (!z) {
            this.checksum ^= this.fastBuffer.b(i2, i7);
        }
        int size = this.invalids.size();
        int i8 = size - 1;
        int i9 = this.dataEnd - this.invalids.get(i8).b;
        int[] iArr = new int[((i9 > 0 ? size : i8) << 1)];
        int i10 = cVar.a;
        int i11 = cVar.b;
        int i12 = 1;
        while (i12 < size) {
            c cVar2 = this.invalids.get(i12);
            int i13 = cVar2.a - i11;
            int i14 = size;
            System.arraycopy(this.fastBuffer.a, i11, this.fastBuffer.a, i10, i13);
            int i15 = (i12 - 1) << 1;
            iArr[i15] = i11;
            iArr[i15 + 1] = i11 - i10;
            i10 += i13;
            i11 = cVar2.b;
            i12++;
            size = i14;
        }
        if (i9 > 0) {
            System.arraycopy(this.fastBuffer.a, i11, this.fastBuffer.a, i10, i9);
            int i16 = i8 << 1;
            iArr[i16] = i11;
            iArr[i16 + 1] = i11 - i10;
        }
        clearInvalid();
        if (z) {
            this.checksum = this.fastBuffer.b(12, i5);
        } else {
            this.checksum ^= this.fastBuffer.b(i2, i6);
        }
        this.dataEnd = i4;
        if (this.writingMode == 0) {
            this.aBuffer.putInt(0, -1);
            this.aBuffer.putLong(4, this.checksum);
            this.aBuffer.position(i2);
            this.aBuffer.put(this.fastBuffer.a, i2, i6);
            this.aBuffer.putInt(0, i5);
            this.bBuffer.putInt(0, i5);
            this.bBuffer.putLong(4, this.checksum);
            this.bBuffer.position(i2);
            this.bBuffer.put(this.fastBuffer.a, i2, i6);
        } else {
            this.fastBuffer.a(0, i5);
            this.fastBuffer.a(4, this.checksum);
        }
        updateOffset(i2, iArr);
        int i17 = i4 + i;
        if (this.fastBuffer.a.length - i17 > TRUNCATE_THRESHOLD) {
            truncate(i17);
        }
        info(GC_FINISH);
    }

    private void updateOffset(int i, int[] iArr) {
        for (c.b next : this.data.values()) {
            if (next.a > i) {
                int i2 = next.a;
                int length = (iArr.length >> 1) - 1;
                int i3 = 0;
                while (true) {
                    if (i3 > length) {
                        break;
                    }
                    int i4 = (i3 + length) >>> 1;
                    int i5 = iArr[i4 << 1];
                    if (i5 >= i2) {
                        if (i5 <= i2) {
                            length = i4;
                            break;
                        }
                        length = i4 - 1;
                    } else {
                        i3 = i4 + 1;
                    }
                }
                int i6 = iArr[(length << 1) + 1];
                next.a -= i6;
                if (next.a() >= 6) {
                    ((c.j) next).c -= i6;
                }
            }
        }
    }

    private void truncate(int i) {
        int i2 = PAGE_SIZE;
        int newCapacity = getNewCapacity(i2, i + i2);
        if (newCapacity < this.fastBuffer.a.length) {
            byte[] bArr = new byte[newCapacity];
            System.arraycopy(this.fastBuffer.a, 0, bArr, 0, this.dataEnd);
            this.fastBuffer.a = bArr;
            if (this.writingMode == 0) {
                try {
                    long j = (long) newCapacity;
                    this.aChannel.truncate(j);
                    MappedByteBuffer map = this.aChannel.map(FileChannel.MapMode.READ_WRITE, 0, j);
                    this.aBuffer = map;
                    map.order(ByteOrder.LITTLE_ENDIAN);
                    this.bChannel.truncate(j);
                    MappedByteBuffer map2 = this.bChannel.map(FileChannel.MapMode.READ_WRITE, 0, j);
                    this.bBuffer = map2;
                    map2.order(ByteOrder.LITTLE_ENDIAN);
                } catch (IOException e) {
                    error(new Exception(MAP_FAILED, e));
                    toBlockingMode();
                }
            }
            info(TRUNCATE_FINISH);
        }
    }

    private int getNewCapacity(int i, int i2) {
        if (i2 <= 536870912) {
            int i3 = PAGE_SIZE;
            if (i2 <= i3) {
                return i3;
            }
            while (i < i2) {
                int i4 = DOUBLE_LIMIT;
                i = i <= i4 ? i << 1 : i + i4;
            }
            return i;
        }
        throw new IllegalStateException("data size out of limit");
    }

    private void countInvalid(int i, int i2) {
        this.invalidBytes += i2 - i;
        this.invalids.add(new c(i, i2));
    }

    private void clearInvalid() {
        this.invalidBytes = 0;
        this.invalids.clear();
    }

    private static class c implements Comparable<c> {
        int a;
        int b;

        public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
            return this.a - ((c) obj).a;
        }

        c(int i, int i2) {
            this.a = i;
            this.b = i2;
        }
    }

    private void error(String str) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.b(this.name, new Exception(str));
        }
    }

    private void error(Exception exc) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.b(this.name, exc);
        }
    }

    private void warning(Exception exc) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, exc);
        }
    }

    private void info(String str) {
        b bVar = this.logger;
        if (bVar != null) {
            bVar.a(this.name, str);
        }
    }

    public static class Builder {
        private static final Map<String, FastKV> INSTANCE_MAP = new ConcurrentHashMap();
        private a[] encoders;
        private final String name;
        private final String path;
        private int writingMode = 0;

        public Builder(String str, String str2) {
            if (str == null || str.isEmpty()) {
                throw new IllegalArgumentException("path is empty");
            } else if (str2 == null || str2.isEmpty()) {
                throw new IllegalArgumentException("name is empty");
            } else {
                if (!str.endsWith("/")) {
                    str = str + '/';
                }
                this.path = str;
                this.name = str2;
            }
        }

        public Builder encoder(a[] aVarArr) {
            this.encoders = aVarArr;
            return this;
        }

        public Builder blocking() {
            this.writingMode = 2;
            return this;
        }

        public Builder asyncBlocking() {
            this.writingMode = 1;
            return this;
        }

        public FastKV build() {
            String str = this.path + this.name;
            Map<String, FastKV> map = INSTANCE_MAP;
            FastKV fastKV = map.get(str);
            if (fastKV == null) {
                synchronized (Builder.class) {
                    fastKV = map.get(str);
                    if (fastKV == null) {
                        fastKV = new FastKV(this.path, this.name, this.encoders, this.writingMode);
                        map.put(str, fastKV);
                    }
                }
            }
            return fastKV;
        }
    }

    public synchronized String toString() {
        return "FastKV: path:" + this.path + " name:" + this.name;
    }
}
