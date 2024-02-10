package androidx.media3.exoplayer.source;

import androidx.media3.common.util.Assertions;
import androidx.media3.extractor.Extractor;
import androidx.media3.extractor.ExtractorInput;
import androidx.media3.extractor.ExtractorsFactory;
import androidx.media3.extractor.PositionHolder;
import androidx.media3.extractor.mp3.Mp3Extractor;
import java.io.IOException;

public final class BundledExtractorsAdapter implements ProgressiveMediaExtractor {
    private Extractor extractor;
    private ExtractorInput extractorInput;
    private final ExtractorsFactory extractorsFactory;

    public BundledExtractorsAdapter(ExtractorsFactory extractorsFactory2) {
        this.extractorsFactory = extractorsFactory2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004a, code lost:
        if (r0.getPosition() != r11) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x006d, code lost:
        if (r0.getPosition() != r11) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0070, code lost:
        r1 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void init(androidx.media3.common.DataReader r8, android.net.Uri r9, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r10, long r11, long r13, androidx.media3.extractor.ExtractorOutput r15) throws java.io.IOException {
        /*
            r7 = this;
            androidx.media3.extractor.DefaultExtractorInput r6 = new androidx.media3.extractor.DefaultExtractorInput
            r0 = r6
            r1 = r8
            r2 = r11
            r4 = r13
            r0.<init>(r1, r2, r4)
            r7.extractorInput = r6
            androidx.media3.extractor.Extractor r8 = r7.extractor
            if (r8 == 0) goto L_0x0010
            return
        L_0x0010:
            androidx.media3.extractor.ExtractorsFactory r8 = r7.extractorsFactory
            androidx.media3.extractor.Extractor[] r8 = r8.createExtractors(r9, r10)
            int r10 = r8.length
            r13 = 0
            r14 = 1
            if (r10 != r14) goto L_0x0020
            r8 = r8[r13]
            r7.extractor = r8
            goto L_0x0080
        L_0x0020:
            int r10 = r8.length
            r0 = 0
        L_0x0022:
            if (r0 >= r10) goto L_0x007c
            r1 = r8[r0]
            boolean r2 = r1.sniff(r6)     // Catch:{ EOFException -> 0x0062, all -> 0x004d }
            if (r2 == 0) goto L_0x0040
            r7.extractor = r1     // Catch:{ EOFException -> 0x0062, all -> 0x004d }
            if (r1 != 0) goto L_0x0038
            long r0 = r6.getPosition()
            int r10 = (r0 > r11 ? 1 : (r0 == r11 ? 0 : -1))
            if (r10 != 0) goto L_0x0039
        L_0x0038:
            r13 = 1
        L_0x0039:
            androidx.media3.common.util.Assertions.checkState(r13)
            r6.resetPeekPosition()
            goto L_0x007c
        L_0x0040:
            androidx.media3.extractor.Extractor r1 = r7.extractor
            if (r1 != 0) goto L_0x0072
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0070
            goto L_0x0072
        L_0x004d:
            r8 = move-exception
            androidx.media3.extractor.Extractor r9 = r7.extractor
            if (r9 != 0) goto L_0x005a
            long r9 = r6.getPosition()
            int r15 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r15 != 0) goto L_0x005b
        L_0x005a:
            r13 = 1
        L_0x005b:
            androidx.media3.common.util.Assertions.checkState(r13)
            r6.resetPeekPosition()
            throw r8
        L_0x0062:
            androidx.media3.extractor.Extractor r1 = r7.extractor
            if (r1 != 0) goto L_0x0072
            long r1 = r6.getPosition()
            int r3 = (r1 > r11 ? 1 : (r1 == r11 ? 0 : -1))
            if (r3 != 0) goto L_0x0070
            goto L_0x0072
        L_0x0070:
            r1 = 0
            goto L_0x0073
        L_0x0072:
            r1 = 1
        L_0x0073:
            androidx.media3.common.util.Assertions.checkState(r1)
            r6.resetPeekPosition()
            int r0 = r0 + 1
            goto L_0x0022
        L_0x007c:
            androidx.media3.extractor.Extractor r10 = r7.extractor
            if (r10 == 0) goto L_0x0086
        L_0x0080:
            androidx.media3.extractor.Extractor r8 = r7.extractor
            r8.init(r15)
            return
        L_0x0086:
            androidx.media3.exoplayer.source.UnrecognizedInputFormatException r10 = new androidx.media3.exoplayer.source.UnrecognizedInputFormatException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            java.lang.String r12 = "None of the available extractors ("
            r11.<init>(r12)
            java.lang.String r8 = androidx.media3.common.util.Util.getCommaDelimitedSimpleClassNames(r8)
            r11.append(r8)
            java.lang.String r8 = ") could read the stream."
            r11.append(r8)
            java.lang.String r8 = r11.toString()
            java.lang.Object r9 = androidx.media3.common.util.Assertions.checkNotNull(r9)
            android.net.Uri r9 = (android.net.Uri) r9
            r10.<init>(r8, r9)
            goto L_0x00aa
        L_0x00a9:
            throw r10
        L_0x00aa:
            goto L_0x00a9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.media3.exoplayer.source.BundledExtractorsAdapter.init(androidx.media3.common.DataReader, android.net.Uri, java.util.Map, long, long, androidx.media3.extractor.ExtractorOutput):void");
    }

    public void release() {
        Extractor extractor2 = this.extractor;
        if (extractor2 != null) {
            extractor2.release();
            this.extractor = null;
        }
        this.extractorInput = null;
    }

    public void disableSeekingOnMp3Streams() {
        Extractor extractor2 = this.extractor;
        if (extractor2 instanceof Mp3Extractor) {
            ((Mp3Extractor) extractor2).disableSeeking();
        }
    }

    public long getCurrentInputPosition() {
        ExtractorInput extractorInput2 = this.extractorInput;
        if (extractorInput2 != null) {
            return extractorInput2.getPosition();
        }
        return -1;
    }

    public void seek(long j, long j2) {
        ((Extractor) Assertions.checkNotNull(this.extractor)).seek(j, j2);
    }

    public int read(PositionHolder positionHolder) throws IOException {
        return ((Extractor) Assertions.checkNotNull(this.extractor)).read((ExtractorInput) Assertions.checkNotNull(this.extractorInput), positionHolder);
    }
}
