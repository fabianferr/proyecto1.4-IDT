package com.mbridge.msdk.thrid.okhttp.internal.cache2;

import com.mbridge.msdk.thrid.okhttp.internal.Util;
import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.ByteString;
import com.mbridge.msdk.thrid.okio.Source;
import com.mbridge.msdk.thrid.okio.Timeout;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

final class Relay {
    private static final long FILE_HEADER_SIZE = 32;
    static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
    static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    final Buffer buffer = new Buffer();
    final long bufferMaxSize;
    boolean complete;
    RandomAccessFile file;
    private final ByteString metadata;
    int sourceCount;
    Source upstream;
    final Buffer upstreamBuffer = new Buffer();
    long upstreamPos;
    Thread upstreamReader;

    private Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2) {
        this.file = randomAccessFile;
        this.upstream = source;
        this.complete = source == null;
        this.upstreamPos = j;
        this.metadata = byteString;
        this.bufferMaxSize = j2;
    }

    public static Relay edit(File file2, Source source, ByteString byteString, long j) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        Relay relay = new Relay(randomAccessFile, source, 0, byteString, j);
        randomAccessFile.setLength(0);
        relay.writeHeader(PREFIX_DIRTY, -1, -1);
        return relay;
    }

    public static Relay read(File file2) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile(file2, "rw");
        FileOperator fileOperator = new FileOperator(randomAccessFile.getChannel());
        Buffer buffer2 = new Buffer();
        fileOperator.read(0, buffer2, 32);
        ByteString byteString = PREFIX_CLEAN;
        if (buffer2.readByteString((long) byteString.size()).equals(byteString)) {
            long readLong = buffer2.readLong();
            long readLong2 = buffer2.readLong();
            Buffer buffer3 = new Buffer();
            fileOperator.read(readLong + 32, buffer3, readLong2);
            return new Relay(randomAccessFile, (Source) null, readLong, buffer3.readByteString(), 0);
        }
        throw new IOException("unreadable cache file");
    }

    private void writeHeader(ByteString byteString, long j, long j2) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(byteString);
        buffer2.writeLong(j);
        buffer2.writeLong(j2);
        if (buffer2.size() == 32) {
            new FileOperator(this.file.getChannel()).write(0, buffer2, 32);
            return;
        }
        throw new IllegalArgumentException();
    }

    private void writeMetadata(long j) throws IOException {
        Buffer buffer2 = new Buffer();
        buffer2.write(this.metadata);
        new FileOperator(this.file.getChannel()).write(32 + j, buffer2, (long) this.metadata.size());
    }

    /* access modifiers changed from: package-private */
    public void commit(long j) throws IOException {
        writeMetadata(j);
        this.file.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, j, (long) this.metadata.size());
        this.file.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
        }
        Util.closeQuietly((Closeable) this.upstream);
        this.upstream = null;
    }

    /* access modifiers changed from: package-private */
    public boolean isClosed() {
        return this.file == null;
    }

    public ByteString metadata() {
        return this.metadata;
    }

    public Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        RelaySource() {
            this.fileOperator = new FileOperator(Relay.this.file.getChannel());
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0037, code lost:
            r4 = 1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
            r5 = r7 - r1.this$0.buffer.size();
            r11 = r1.sourcePos;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0047, code lost:
            if (r11 >= r5) goto L_0x011a;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x004a, code lost:
            r4 = 2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            r2 = java.lang.Math.min(r2, r7 - r11);
            r1.this$0.buffer.copyTo(r21, r1.sourcePos - r5, r2);
            r1.sourcePos += r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:0x0133, code lost:
            return r2;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public long read(com.mbridge.msdk.thrid.okio.Buffer r21, long r22) throws java.io.IOException {
            /*
                r20 = this;
                r1 = r20
                r2 = r22
                com.mbridge.msdk.thrid.okhttp.internal.cache2.FileOperator r0 = r1.fileOperator
                if (r0 == 0) goto L_0x0137
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r4 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this
                monitor-enter(r4)
            L_0x000b:
                long r5 = r1.sourcePos     // Catch:{ all -> 0x0134 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0134 }
                long r7 = r0.upstreamPos     // Catch:{ all -> 0x0134 }
                r0 = 2
                r9 = -1
                int r11 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
                if (r11 != 0) goto L_0x0039
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r5 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0134 }
                boolean r5 = r5.complete     // Catch:{ all -> 0x0134 }
                if (r5 == 0) goto L_0x0020
                monitor-exit(r4)     // Catch:{ all -> 0x0134 }
                return r9
            L_0x0020:
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r5 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0134 }
                java.lang.Thread r5 = r5.upstreamReader     // Catch:{ all -> 0x0134 }
                if (r5 == 0) goto L_0x002e
                com.mbridge.msdk.thrid.okio.Timeout r0 = r1.timeout     // Catch:{ all -> 0x0134 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r5 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0134 }
                r0.waitUntilNotified(r5)     // Catch:{ all -> 0x0134 }
                goto L_0x000b
            L_0x002e:
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r5 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0134 }
                java.lang.Thread r6 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0134 }
                r5.upstreamReader = r6     // Catch:{ all -> 0x0134 }
                monitor-exit(r4)     // Catch:{ all -> 0x0134 }
                r4 = 1
                goto L_0x004b
            L_0x0039:
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r5 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0134 }
                com.mbridge.msdk.thrid.okio.Buffer r5 = r5.buffer     // Catch:{ all -> 0x0134 }
                long r5 = r5.size()     // Catch:{ all -> 0x0134 }
                long r5 = r7 - r5
                long r11 = r1.sourcePos     // Catch:{ all -> 0x0134 }
                int r13 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
                if (r13 >= 0) goto L_0x011a
                monitor-exit(r4)     // Catch:{ all -> 0x0134 }
                r4 = 2
            L_0x004b:
                r5 = 32
                if (r4 != r0) goto L_0x0068
                long r9 = r1.sourcePos
                long r7 = r7 - r9
                long r2 = java.lang.Math.min(r2, r7)
                com.mbridge.msdk.thrid.okhttp.internal.cache2.FileOperator r9 = r1.fileOperator
                long r7 = r1.sourcePos
                long r10 = r7 + r5
                r12 = r21
                r13 = r2
                r9.read(r10, r12, r13)
                long r4 = r1.sourcePos
                long r4 = r4 + r2
                r1.sourcePos = r4
                return r2
            L_0x0068:
                r4 = 0
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0108 }
                com.mbridge.msdk.thrid.okio.Source r0 = r0.upstream     // Catch:{ all -> 0x0108 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r11 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0108 }
                com.mbridge.msdk.thrid.okio.Buffer r11 = r11.upstreamBuffer     // Catch:{ all -> 0x0108 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r12 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0108 }
                long r12 = r12.bufferMaxSize     // Catch:{ all -> 0x0108 }
                long r11 = r0.read(r11, r12)     // Catch:{ all -> 0x0108 }
                int r0 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
                if (r0 != 0) goto L_0x0093
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0108 }
                r0.commit(r7)     // Catch:{ all -> 0x0108 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r2 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this
                monitor-enter(r2)
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0090 }
                r0.upstreamReader = r4     // Catch:{ all -> 0x0090 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0090 }
                r0.notifyAll()     // Catch:{ all -> 0x0090 }
                monitor-exit(r2)     // Catch:{ all -> 0x0090 }
                return r9
            L_0x0090:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0090 }
                throw r0
            L_0x0093:
                long r2 = java.lang.Math.min(r11, r2)     // Catch:{ all -> 0x0108 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0108 }
                com.mbridge.msdk.thrid.okio.Buffer r13 = r0.upstreamBuffer     // Catch:{ all -> 0x0108 }
                r15 = 0
                r14 = r21
                r17 = r2
                r13.copyTo((com.mbridge.msdk.thrid.okio.Buffer) r14, (long) r15, (long) r17)     // Catch:{ all -> 0x0108 }
                long r9 = r1.sourcePos     // Catch:{ all -> 0x0108 }
                long r9 = r9 + r2
                r1.sourcePos = r9     // Catch:{ all -> 0x0108 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.FileOperator r14 = r1.fileOperator     // Catch:{ all -> 0x0108 }
                long r15 = r7 + r5
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0108 }
                com.mbridge.msdk.thrid.okio.Buffer r0 = r0.upstreamBuffer     // Catch:{ all -> 0x0108 }
                com.mbridge.msdk.thrid.okio.Buffer r17 = r0.clone()     // Catch:{ all -> 0x0108 }
                r18 = r11
                r14.write(r15, r17, r18)     // Catch:{ all -> 0x0108 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r5 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0108 }
                monitor-enter(r5)     // Catch:{ all -> 0x0108 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0105 }
                com.mbridge.msdk.thrid.okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x0105 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r6 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0105 }
                com.mbridge.msdk.thrid.okio.Buffer r6 = r6.upstreamBuffer     // Catch:{ all -> 0x0105 }
                r0.write((com.mbridge.msdk.thrid.okio.Buffer) r6, (long) r11)     // Catch:{ all -> 0x0105 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0105 }
                com.mbridge.msdk.thrid.okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x0105 }
                long r6 = r0.size()     // Catch:{ all -> 0x0105 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0105 }
                long r8 = r0.bufferMaxSize     // Catch:{ all -> 0x0105 }
                int r0 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r0 <= 0) goto L_0x00ec
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0105 }
                com.mbridge.msdk.thrid.okio.Buffer r0 = r0.buffer     // Catch:{ all -> 0x0105 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r6 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0105 }
                com.mbridge.msdk.thrid.okio.Buffer r6 = r6.buffer     // Catch:{ all -> 0x0105 }
                long r6 = r6.size()     // Catch:{ all -> 0x0105 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r8 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0105 }
                long r8 = r8.bufferMaxSize     // Catch:{ all -> 0x0105 }
                long r6 = r6 - r8
                r0.skip(r6)     // Catch:{ all -> 0x0105 }
            L_0x00ec:
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0105 }
                long r6 = r0.upstreamPos     // Catch:{ all -> 0x0105 }
                long r6 = r6 + r11
                r0.upstreamPos = r6     // Catch:{ all -> 0x0105 }
                monitor-exit(r5)     // Catch:{ all -> 0x0105 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r6 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this
                monitor-enter(r6)
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0102 }
                r0.upstreamReader = r4     // Catch:{ all -> 0x0102 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0102 }
                r0.notifyAll()     // Catch:{ all -> 0x0102 }
                monitor-exit(r6)     // Catch:{ all -> 0x0102 }
                return r2
            L_0x0102:
                r0 = move-exception
                monitor-exit(r6)     // Catch:{ all -> 0x0102 }
                throw r0
            L_0x0105:
                r0 = move-exception
                monitor-exit(r5)     // Catch:{ all -> 0x0105 }
                throw r0     // Catch:{ all -> 0x0108 }
            L_0x0108:
                r0 = move-exception
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r2 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this
                monitor-enter(r2)
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r3 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0117 }
                r3.upstreamReader = r4     // Catch:{ all -> 0x0117 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r3 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0117 }
                r3.notifyAll()     // Catch:{ all -> 0x0117 }
                monitor-exit(r2)     // Catch:{ all -> 0x0117 }
                throw r0
            L_0x0117:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0117 }
                throw r0
            L_0x011a:
                long r7 = r7 - r11
                long r2 = java.lang.Math.min(r2, r7)     // Catch:{ all -> 0x0134 }
                com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay r0 = com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.this     // Catch:{ all -> 0x0134 }
                com.mbridge.msdk.thrid.okio.Buffer r9 = r0.buffer     // Catch:{ all -> 0x0134 }
                long r7 = r1.sourcePos     // Catch:{ all -> 0x0134 }
                long r11 = r7 - r5
                r10 = r21
                r13 = r2
                r9.copyTo((com.mbridge.msdk.thrid.okio.Buffer) r10, (long) r11, (long) r13)     // Catch:{ all -> 0x0134 }
                long r5 = r1.sourcePos     // Catch:{ all -> 0x0134 }
                long r5 = r5 + r2
                r1.sourcePos = r5     // Catch:{ all -> 0x0134 }
                monitor-exit(r4)     // Catch:{ all -> 0x0134 }
                return r2
            L_0x0134:
                r0 = move-exception
                monitor-exit(r4)     // Catch:{ all -> 0x0134 }
                throw r0
            L_0x0137:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r2 = "closed"
                r0.<init>(r2)
                goto L_0x0140
            L_0x013f:
                throw r0
            L_0x0140:
                goto L_0x013f
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.thrid.okhttp.internal.cache2.Relay.RelaySource.read(com.mbridge.msdk.thrid.okio.Buffer, long):long");
        }

        public Timeout timeout() {
            return this.timeout;
        }

        public void close() throws IOException {
            if (this.fileOperator != null) {
                RandomAccessFile randomAccessFile = null;
                this.fileOperator = null;
                synchronized (Relay.this) {
                    Relay relay = Relay.this;
                    relay.sourceCount--;
                    if (Relay.this.sourceCount == 0) {
                        RandomAccessFile randomAccessFile2 = Relay.this.file;
                        Relay.this.file = null;
                        randomAccessFile = randomAccessFile2;
                    }
                }
                if (randomAccessFile != null) {
                    Util.closeQuietly((Closeable) randomAccessFile);
                }
            }
        }
    }
}
