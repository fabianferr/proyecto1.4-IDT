package com.mbridge.msdk.playercommon.exoplayer2.metadata.id3;

import android.util.Log;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.Metadata;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataDecoder;
import com.mbridge.msdk.playercommon.exoplayer2.metadata.MetadataInputBuffer;
import com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import org.apache.commons.codec.CharEncoding;

public final class Id3Decoder implements MetadataDecoder {
    private static final int FRAME_FLAG_V3_HAS_GROUP_IDENTIFIER = 32;
    private static final int FRAME_FLAG_V3_IS_COMPRESSED = 128;
    private static final int FRAME_FLAG_V3_IS_ENCRYPTED = 64;
    private static final int FRAME_FLAG_V4_HAS_DATA_LENGTH = 1;
    private static final int FRAME_FLAG_V4_HAS_GROUP_IDENTIFIER = 64;
    private static final int FRAME_FLAG_V4_IS_COMPRESSED = 8;
    private static final int FRAME_FLAG_V4_IS_ENCRYPTED = 4;
    private static final int FRAME_FLAG_V4_IS_UNSYNCHRONIZED = 2;
    public static final int ID3_HEADER_LENGTH = 10;
    public static final int ID3_TAG = Util.getIntegerCodeForString("ID3");
    private static final int ID3_TEXT_ENCODING_ISO_8859_1 = 0;
    private static final int ID3_TEXT_ENCODING_UTF_16 = 1;
    private static final int ID3_TEXT_ENCODING_UTF_16BE = 2;
    private static final int ID3_TEXT_ENCODING_UTF_8 = 3;
    public static final FramePredicate NO_FRAMES_PREDICATE = new FramePredicate() {
        public final boolean evaluate(int i, int i2, int i3, int i4, int i5) {
            return false;
        }
    };
    private static final String TAG = "Id3Decoder";
    private final FramePredicate framePredicate;

    public interface FramePredicate {
        boolean evaluate(int i, int i2, int i3, int i4, int i5);
    }

    private static int delimiterLength(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    private static String getCharsetName(int i) {
        return i != 1 ? i != 2 ? i != 3 ? "ISO-8859-1" : "UTF-8" : CharEncoding.UTF_16BE : "UTF-16";
    }

    public Id3Decoder() {
        this((FramePredicate) null);
    }

    public Id3Decoder(FramePredicate framePredicate2) {
        this.framePredicate = framePredicate2;
    }

    public final Metadata decode(MetadataInputBuffer metadataInputBuffer) {
        ByteBuffer byteBuffer = metadataInputBuffer.data;
        return decode(byteBuffer.array(), byteBuffer.limit());
    }

    public final Metadata decode(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        ParsableByteArray parsableByteArray = new ParsableByteArray(bArr, i);
        Id3Header decodeHeader = decodeHeader(parsableByteArray);
        if (decodeHeader == null) {
            return null;
        }
        int position = parsableByteArray.getPosition();
        int i2 = decodeHeader.majorVersion == 2 ? 6 : 10;
        int access$100 = decodeHeader.framesSize;
        if (decodeHeader.isUnsynchronized) {
            access$100 = removeUnsynchronization(parsableByteArray, decodeHeader.framesSize);
        }
        parsableByteArray.setLimit(position + access$100);
        boolean z = false;
        if (!validateFrames(parsableByteArray, decodeHeader.majorVersion, i2, false)) {
            if (decodeHeader.majorVersion != 4 || !validateFrames(parsableByteArray, 4, i2, true)) {
                Log.w(TAG, "Failed to validate ID3 tag with majorVersion=" + decodeHeader.majorVersion);
                return null;
            }
            z = true;
        }
        while (parsableByteArray.bytesLeft() >= i2) {
            Id3Frame decodeFrame = decodeFrame(decodeHeader.majorVersion, parsableByteArray, z, i2, this.framePredicate);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static Id3Header decodeHeader(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() < 10) {
            Log.w(TAG, "Data too short to be an ID3 tag");
            return null;
        }
        int readUnsignedInt24 = parsableByteArray.readUnsignedInt24();
        if (readUnsignedInt24 != ID3_TAG) {
            Log.w(TAG, "Unexpected first three bytes of ID3 tag header: " + readUnsignedInt24);
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        boolean z = true;
        parsableByteArray.skipBytes(1);
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        int readSynchSafeInt = parsableByteArray.readSynchSafeInt();
        if (readUnsignedByte == 2) {
            if ((readUnsignedByte2 & 64) != 0) {
                Log.w(TAG, "Skipped ID3 tag with majorVersion=2 and undefined compression scheme");
                return null;
            }
        } else if (readUnsignedByte == 3) {
            if ((readUnsignedByte2 & 64) != 0) {
                int readInt = parsableByteArray.readInt();
                parsableByteArray.skipBytes(readInt);
                readSynchSafeInt -= readInt + 4;
            }
        } else if (readUnsignedByte == 4) {
            if ((readUnsignedByte2 & 64) != 0) {
                int readSynchSafeInt2 = parsableByteArray.readSynchSafeInt();
                parsableByteArray.skipBytes(readSynchSafeInt2 - 4);
                readSynchSafeInt -= readSynchSafeInt2;
            }
            if ((readUnsignedByte2 & 16) != 0) {
                readSynchSafeInt -= 10;
            }
        } else {
            Log.w(TAG, "Skipped ID3 tag with unsupported majorVersion=" + readUnsignedByte);
            return null;
        }
        if (readUnsignedByte >= 4 || (readUnsignedByte2 & 128) == 0) {
            z = false;
        }
        return new Id3Header(readUnsignedByte, z, readSynchSafeInt);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0076, code lost:
        if ((r10 & 1) != 0) goto L_0x008b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0086, code lost:
        if ((r10 & 128) != 0) goto L_0x008b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean validateFrames(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r18, int r19, int r20, boolean r21) {
        /*
            r1 = r18
            r0 = r19
            int r2 = r18.getPosition()
        L_0x0008:
            int r3 = r18.bytesLeft()     // Catch:{ all -> 0x00af }
            r4 = 1
            r5 = r20
            if (r3 < r5) goto L_0x00ab
            r3 = 3
            r6 = 0
            if (r0 < r3) goto L_0x0022
            int r7 = r18.readInt()     // Catch:{ all -> 0x00af }
            long r8 = r18.readUnsignedInt()     // Catch:{ all -> 0x00af }
            int r10 = r18.readUnsignedShort()     // Catch:{ all -> 0x00af }
            goto L_0x002c
        L_0x0022:
            int r7 = r18.readUnsignedInt24()     // Catch:{ all -> 0x00af }
            int r8 = r18.readUnsignedInt24()     // Catch:{ all -> 0x00af }
            long r8 = (long) r8
            r10 = 0
        L_0x002c:
            r11 = 0
            if (r7 != 0) goto L_0x003a
            int r7 = (r8 > r11 ? 1 : (r8 == r11 ? 0 : -1))
            if (r7 != 0) goto L_0x003a
            if (r10 != 0) goto L_0x003a
            r1.setPosition(r2)
            return r4
        L_0x003a:
            r7 = 4
            if (r0 != r7) goto L_0x006b
            if (r21 != 0) goto L_0x006b
            r13 = 8421504(0x808080, double:4.160776E-317)
            long r13 = r13 & r8
            int r15 = (r13 > r11 ? 1 : (r13 == r11 ? 0 : -1))
            if (r15 == 0) goto L_0x004b
            r1.setPosition(r2)
            return r6
        L_0x004b:
            r11 = 255(0xff, double:1.26E-321)
            long r13 = r8 & r11
            r15 = 8
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 7
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 16
            long r15 = r8 >> r15
            long r15 = r15 & r11
            r17 = 14
            long r15 = r15 << r17
            long r13 = r13 | r15
            r15 = 24
            long r8 = r8 >> r15
            long r8 = r8 & r11
            r11 = 21
            long r8 = r8 << r11
            long r8 = r8 | r13
        L_0x006b:
            if (r0 != r7) goto L_0x007b
            r3 = r10 & 64
            if (r3 == 0) goto L_0x0073
            r3 = 1
            goto L_0x0074
        L_0x0073:
            r3 = 0
        L_0x0074:
            r7 = r10 & 1
            if (r7 == 0) goto L_0x0079
            goto L_0x008b
        L_0x0079:
            r4 = 0
            goto L_0x008b
        L_0x007b:
            if (r0 != r3) goto L_0x0089
            r3 = r10 & 32
            if (r3 == 0) goto L_0x0083
            r3 = 1
            goto L_0x0084
        L_0x0083:
            r3 = 0
        L_0x0084:
            r7 = r10 & 128(0x80, float:1.794E-43)
            if (r7 == 0) goto L_0x0079
            goto L_0x008b
        L_0x0089:
            r3 = 0
            goto L_0x0079
        L_0x008b:
            if (r4 == 0) goto L_0x008f
            int r3 = r3 + 4
        L_0x008f:
            long r3 = (long) r3
            int r7 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
            if (r7 >= 0) goto L_0x0098
            r1.setPosition(r2)
            return r6
        L_0x0098:
            int r3 = r18.bytesLeft()     // Catch:{ all -> 0x00af }
            long r3 = (long) r3
            int r7 = (r3 > r8 ? 1 : (r3 == r8 ? 0 : -1))
            if (r7 >= 0) goto L_0x00a5
            r1.setPosition(r2)
            return r6
        L_0x00a5:
            int r3 = (int) r8
            r1.skipBytes(r3)     // Catch:{ all -> 0x00af }
            goto L_0x0008
        L_0x00ab:
            r1.setPosition(r2)
            return r4
        L_0x00af:
            r0 = move-exception
            r1.setPosition(r2)
            goto L_0x00b5
        L_0x00b4:
            throw r0
        L_0x00b5:
            goto L_0x00b4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder.validateFrames(com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray, int, int, boolean):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0198, code lost:
        if (r14 == 67) goto L_0x019a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Frame decodeFrame(int r20, com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray r21, boolean r22, int r23, com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder.FramePredicate r24) {
        /*
            r0 = r20
            r7 = r21
            java.lang.String r8 = "Failed to decode frame: id="
            int r9 = r21.readUnsignedByte()
            int r10 = r21.readUnsignedByte()
            int r11 = r21.readUnsignedByte()
            r13 = 3
            if (r0 < r13) goto L_0x001b
            int r1 = r21.readUnsignedByte()
            r14 = r1
            goto L_0x001c
        L_0x001b:
            r14 = 0
        L_0x001c:
            r15 = 4
            if (r0 != r15) goto L_0x003f
            int r1 = r21.readUnsignedIntToInt()
            if (r22 != 0) goto L_0x003c
            r2 = r1 & 255(0xff, float:3.57E-43)
            int r3 = r1 >> 8
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 7
            r2 = r2 | r3
            int r3 = r1 >> 16
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 14
            r2 = r2 | r3
            int r1 = r1 >> 24
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 21
            r1 = r1 | r2
        L_0x003c:
            r16 = r1
            goto L_0x004b
        L_0x003f:
            if (r0 != r13) goto L_0x0046
            int r1 = r21.readUnsignedIntToInt()
            goto L_0x003c
        L_0x0046:
            int r1 = r21.readUnsignedInt24()
            goto L_0x003c
        L_0x004b:
            if (r0 < r13) goto L_0x0053
            int r1 = r21.readUnsignedShort()
            r6 = r1
            goto L_0x0054
        L_0x0053:
            r6 = 0
        L_0x0054:
            r17 = 0
            if (r9 != 0) goto L_0x006a
            if (r10 != 0) goto L_0x006a
            if (r11 != 0) goto L_0x006a
            if (r14 != 0) goto L_0x006a
            if (r16 != 0) goto L_0x006a
            if (r6 != 0) goto L_0x006a
            int r0 = r21.limit()
            r7.setPosition(r0)
            return r17
        L_0x006a:
            int r1 = r21.getPosition()
            int r5 = r1 + r16
            int r1 = r21.limit()
            java.lang.String r4 = "Id3Decoder"
            if (r5 <= r1) goto L_0x0085
            java.lang.String r0 = "Frame size exceeds remaining tag data"
            android.util.Log.w(r4, r0)
            int r0 = r21.limit()
            r7.setPosition(r0)
            return r17
        L_0x0085:
            if (r24 == 0) goto L_0x009d
            r1 = r24
            r2 = r20
            r3 = r9
            r12 = r4
            r4 = r10
            r15 = r5
            r5 = r11
            r19 = r6
            r6 = r14
            boolean r1 = r1.evaluate(r2, r3, r4, r5, r6)
            if (r1 != 0) goto L_0x00a1
            r7.setPosition(r15)
            return r17
        L_0x009d:
            r12 = r4
            r15 = r5
            r19 = r6
        L_0x00a1:
            r1 = 1
            if (r0 != r13) goto L_0x00c3
            r2 = r19
            r3 = r2 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x00ac
            r3 = 1
            goto L_0x00ad
        L_0x00ac:
            r3 = 0
        L_0x00ad:
            r4 = r2 & 64
            if (r4 == 0) goto L_0x00b3
            r4 = 1
            goto L_0x00b4
        L_0x00b3:
            r4 = 0
        L_0x00b4:
            r2 = r2 & 32
            if (r2 == 0) goto L_0x00ba
            r2 = 1
            goto L_0x00bb
        L_0x00ba:
            r2 = 0
        L_0x00bb:
            r18 = r3
            r5 = r4
            r6 = 0
            r3 = r2
            r4 = r18
            goto L_0x00ec
        L_0x00c3:
            r2 = r19
            r3 = 4
            if (r0 != r3) goto L_0x00f1
            r3 = r2 & 64
            if (r3 == 0) goto L_0x00ce
            r3 = 1
            goto L_0x00cf
        L_0x00ce:
            r3 = 0
        L_0x00cf:
            r4 = r2 & 8
            if (r4 == 0) goto L_0x00d5
            r4 = 1
            goto L_0x00d6
        L_0x00d5:
            r4 = 0
        L_0x00d6:
            r5 = r2 & 4
            if (r5 == 0) goto L_0x00dc
            r5 = 1
            goto L_0x00dd
        L_0x00dc:
            r5 = 0
        L_0x00dd:
            r6 = r2 & 2
            if (r6 == 0) goto L_0x00e3
            r6 = 1
            goto L_0x00e4
        L_0x00e3:
            r6 = 0
        L_0x00e4:
            r2 = r2 & r1
            if (r2 == 0) goto L_0x00ea
            r18 = 1
            goto L_0x00ec
        L_0x00ea:
            r18 = 0
        L_0x00ec:
            r2 = r18
            r18 = r4
            goto L_0x00f7
        L_0x00f1:
            r2 = 0
            r3 = 0
            r5 = 0
            r6 = 0
            r18 = 0
        L_0x00f7:
            if (r18 != 0) goto L_0x021a
            if (r5 == 0) goto L_0x00fd
            goto L_0x021a
        L_0x00fd:
            if (r3 == 0) goto L_0x0104
            int r16 = r16 + -1
            r7.skipBytes(r1)
        L_0x0104:
            if (r2 == 0) goto L_0x010c
            int r16 = r16 + -4
            r1 = 4
            r7.skipBytes(r1)
        L_0x010c:
            r1 = r16
            if (r6 == 0) goto L_0x0114
            int r1 = removeUnsynchronization(r7, r1)
        L_0x0114:
            r13 = r1
            r1 = 84
            r2 = 2
            r3 = 88
            if (r9 != r1) goto L_0x012a
            if (r10 != r3) goto L_0x012a
            if (r11 != r3) goto L_0x012a
            if (r0 == r2) goto L_0x0124
            if (r14 != r3) goto L_0x012a
        L_0x0124:
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.TextInformationFrame r1 = decodeTxxxFrame(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            goto L_0x01ec
        L_0x012a:
            if (r9 != r1) goto L_0x0139
            java.lang.String r1 = getFrameId(r0, r9, r10, r11, r14)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.TextInformationFrame r1 = decodeTextInformationFrame(r7, r13, r1)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            goto L_0x01ec
        L_0x0136:
            r0 = move-exception
            goto L_0x0216
        L_0x0139:
            r4 = 87
            if (r9 != r4) goto L_0x014b
            if (r10 != r3) goto L_0x014b
            if (r11 != r3) goto L_0x014b
            if (r0 == r2) goto L_0x0145
            if (r14 != r3) goto L_0x014b
        L_0x0145:
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.UrlLinkFrame r1 = decodeWxxxFrame(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            goto L_0x01ec
        L_0x014b:
            if (r9 != r4) goto L_0x0157
            java.lang.String r1 = getFrameId(r0, r9, r10, r11, r14)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.UrlLinkFrame r1 = decodeUrlLinkFrame(r7, r13, r1)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            goto L_0x01ec
        L_0x0157:
            r3 = 73
            r4 = 80
            if (r9 != r4) goto L_0x016d
            r5 = 82
            if (r10 != r5) goto L_0x016d
            if (r11 != r3) goto L_0x016d
            r5 = 86
            if (r14 != r5) goto L_0x016d
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.PrivFrame r1 = decodePrivFrame(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            goto L_0x01ec
        L_0x016d:
            r5 = 71
            r6 = 79
            if (r9 != r5) goto L_0x0185
            r5 = 69
            if (r10 != r5) goto L_0x0185
            if (r11 != r6) goto L_0x0185
            r5 = 66
            if (r14 == r5) goto L_0x017f
            if (r0 != r2) goto L_0x0185
        L_0x017f:
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.GeobFrame r1 = decodeGeobFrame(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            goto L_0x01ec
        L_0x0185:
            r5 = 65
            r1 = 67
            if (r0 != r2) goto L_0x0192
            if (r9 != r4) goto L_0x019f
            if (r10 != r3) goto L_0x019f
            if (r11 != r1) goto L_0x019f
            goto L_0x019a
        L_0x0192:
            if (r9 != r5) goto L_0x019f
            if (r10 != r4) goto L_0x019f
            if (r11 != r3) goto L_0x019f
            if (r14 != r1) goto L_0x019f
        L_0x019a:
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.ApicFrame r1 = decodeApicFrame(r7, r13, r0)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            goto L_0x01ec
        L_0x019f:
            if (r9 != r1) goto L_0x01b0
            if (r10 != r6) goto L_0x01b0
            r3 = 77
            if (r11 != r3) goto L_0x01b0
            if (r14 == r3) goto L_0x01ab
            if (r0 != r2) goto L_0x01b0
        L_0x01ab:
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.CommentFrame r1 = decodeCommentFrame(r7, r13)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            goto L_0x01ec
        L_0x01b0:
            if (r9 != r1) goto L_0x01ca
            r2 = 72
            if (r10 != r2) goto L_0x01ca
            if (r11 != r5) goto L_0x01ca
            if (r14 != r4) goto L_0x01ca
            r1 = r21
            r2 = r13
            r3 = r20
            r4 = r22
            r5 = r23
            r6 = r24
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.ChapterFrame r1 = decodeChapterFrame(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            goto L_0x01ec
        L_0x01ca:
            if (r9 != r1) goto L_0x01e4
            r2 = 84
            if (r10 != r2) goto L_0x01e4
            if (r11 != r6) goto L_0x01e4
            if (r14 != r1) goto L_0x01e4
            r1 = r21
            r2 = r13
            r3 = r20
            r4 = r22
            r5 = r23
            r6 = r24
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.ChapterTocFrame r1 = decodeChapterTOCFrame(r1, r2, r3, r4, r5, r6)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            goto L_0x01ec
        L_0x01e4:
            java.lang.String r1 = getFrameId(r0, r9, r10, r11, r14)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.BinaryFrame r1 = decodeBinaryFrame(r7, r13, r1)     // Catch:{ UnsupportedEncodingException -> 0x020d }
        L_0x01ec:
            if (r1 != 0) goto L_0x0209
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ UnsupportedEncodingException -> 0x020d }
            r2.<init>(r8)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            java.lang.String r0 = getFrameId(r0, r9, r10, r11, r14)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            r2.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            java.lang.String r0 = ", frameSize="
            r2.append(r0)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            r2.append(r13)     // Catch:{ UnsupportedEncodingException -> 0x020d }
            java.lang.String r0 = r2.toString()     // Catch:{ UnsupportedEncodingException -> 0x020d }
            android.util.Log.w(r12, r0)     // Catch:{ UnsupportedEncodingException -> 0x020d }
        L_0x0209:
            r7.setPosition(r15)
            return r1
        L_0x020d:
            java.lang.String r0 = "Unsupported character encoding"
            android.util.Log.w(r12, r0)     // Catch:{ all -> 0x0136 }
            r7.setPosition(r15)
            return r17
        L_0x0216:
            r7.setPosition(r15)
            throw r0
        L_0x021a:
            java.lang.String r0 = "Skipping unsupported compressed or encrypted frame"
            android.util.Log.w(r12, r0)
            r7.setPosition(r15)
            return r17
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder.decodeFrame(int, com.mbridge.msdk.playercommon.exoplayer2.util.ParsableByteArray, boolean, int, com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Decoder$FramePredicate):com.mbridge.msdk.playercommon.exoplayer2.metadata.id3.Id3Frame");
    }

    private static TextInformationFrame decodeTxxxFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new TextInformationFrame("TXXX", str, decodeStringIfValid(bArr, delimiterLength, indexOfEos(bArr, delimiterLength, readUnsignedByte), charsetName));
    }

    private static TextInformationFrame decodeTextInformationFrame(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        return new TextInformationFrame(str, (String) null, new String(bArr, 0, indexOfEos(bArr, 0, readUnsignedByte), charsetName));
    }

    private static UrlLinkFrame decodeWxxxFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 1) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int indexOfEos = indexOfEos(bArr, 0, readUnsignedByte);
        String str = new String(bArr, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new UrlLinkFrame("WXXX", str, decodeStringIfValid(bArr, delimiterLength, indexOfZeroByte(bArr, delimiterLength), "ISO-8859-1"));
    }

    private static UrlLinkFrame decodeUrlLinkFrame(ParsableByteArray parsableByteArray, int i, String str) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new UrlLinkFrame(str, (String) null, new String(bArr, 0, indexOfZeroByte(bArr, 0), "ISO-8859-1"));
    }

    private static PrivFrame decodePrivFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        return new PrivFrame(new String(bArr, 0, indexOfZeroByte, "ISO-8859-1"), copyOfRangeIfValid(bArr, indexOfZeroByte + 1, i));
    }

    private static GeobFrame decodeGeobFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        parsableByteArray.readBytes(bArr, 0, i2);
        int indexOfZeroByte = indexOfZeroByte(bArr, 0);
        String str = new String(bArr, 0, indexOfZeroByte, "ISO-8859-1");
        int i3 = indexOfZeroByte + 1;
        int indexOfEos = indexOfEos(bArr, i3, readUnsignedByte);
        String decodeStringIfValid = decodeStringIfValid(bArr, i3, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        int indexOfEos2 = indexOfEos(bArr, delimiterLength, readUnsignedByte);
        return new GeobFrame(str, decodeStringIfValid, decodeStringIfValid(bArr, delimiterLength, indexOfEos2, charsetName), copyOfRangeIfValid(bArr, indexOfEos2 + delimiterLength(readUnsignedByte), i2));
    }

    private static ApicFrame decodeApicFrame(ParsableByteArray parsableByteArray, int i, int i2) throws UnsupportedEncodingException {
        int i3;
        String str;
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        int i4 = i - 1;
        byte[] bArr = new byte[i4];
        parsableByteArray.readBytes(bArr, 0, i4);
        if (i2 == 2) {
            str = "image/" + Util.toLowerInvariant(new String(bArr, 0, 3, "ISO-8859-1"));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            i3 = 2;
        } else {
            i3 = indexOfZeroByte(bArr, 0);
            String lowerInvariant = Util.toLowerInvariant(new String(bArr, 0, i3, "ISO-8859-1"));
            if (lowerInvariant.indexOf(47) == -1) {
                str = "image/" + lowerInvariant;
            } else {
                str = lowerInvariant;
            }
        }
        int i5 = i3 + 2;
        int indexOfEos = indexOfEos(bArr, i5, readUnsignedByte);
        return new ApicFrame(str, new String(bArr, i5, indexOfEos - i5, charsetName), bArr[i3 + 1] & 255, copyOfRangeIfValid(bArr, indexOfEos + delimiterLength(readUnsignedByte), i4));
    }

    private static CommentFrame decodeCommentFrame(ParsableByteArray parsableByteArray, int i) throws UnsupportedEncodingException {
        if (i < 4) {
            return null;
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        String charsetName = getCharsetName(readUnsignedByte);
        byte[] bArr = new byte[3];
        parsableByteArray.readBytes(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        parsableByteArray.readBytes(bArr2, 0, i2);
        int indexOfEos = indexOfEos(bArr2, 0, readUnsignedByte);
        String str2 = new String(bArr2, 0, indexOfEos, charsetName);
        int delimiterLength = indexOfEos + delimiterLength(readUnsignedByte);
        return new CommentFrame(str, str2, decodeStringIfValid(bArr2, delimiterLength, indexOfEos(bArr2, delimiterLength, readUnsignedByte), charsetName));
    }

    private static ChapterFrame decodeChapterFrame(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate2) throws UnsupportedEncodingException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray2.data, position);
        String str = new String(parsableByteArray2.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readInt = parsableByteArray.readInt();
        int readInt2 = parsableByteArray.readInt();
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        long j = readUnsignedInt == 4294967295L ? -1 : readUnsignedInt;
        long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
        long j2 = readUnsignedInt2 == 4294967295L ? -1 : readUnsignedInt2;
        ArrayList arrayList = new ArrayList();
        int i4 = position + i;
        while (parsableByteArray.getPosition() < i4) {
            Id3Frame decodeFrame = decodeFrame(i2, parsableByteArray, z, i3, framePredicate2);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterFrame(str, readInt, readInt2, j, j2, id3FrameArr);
    }

    private static ChapterTocFrame decodeChapterTOCFrame(ParsableByteArray parsableByteArray, int i, int i2, boolean z, int i3, FramePredicate framePredicate2) throws UnsupportedEncodingException {
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int position = parsableByteArray.getPosition();
        int indexOfZeroByte = indexOfZeroByte(parsableByteArray2.data, position);
        String str = new String(parsableByteArray2.data, position, indexOfZeroByte - position, "ISO-8859-1");
        parsableByteArray.setPosition(indexOfZeroByte + 1);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        boolean z2 = (readUnsignedByte & 2) != 0;
        boolean z3 = (readUnsignedByte & 1) != 0;
        int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
        String[] strArr = new String[readUnsignedByte2];
        for (int i4 = 0; i4 < readUnsignedByte2; i4++) {
            int position2 = parsableByteArray.getPosition();
            int indexOfZeroByte2 = indexOfZeroByte(parsableByteArray2.data, position2);
            strArr[i4] = new String(parsableByteArray2.data, position2, indexOfZeroByte2 - position2, "ISO-8859-1");
            parsableByteArray.setPosition(indexOfZeroByte2 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = position + i;
        while (parsableByteArray.getPosition() < i5) {
            Id3Frame decodeFrame = decodeFrame(i2, parsableByteArray, z, i3, framePredicate2);
            if (decodeFrame != null) {
                arrayList.add(decodeFrame);
            }
        }
        Id3Frame[] id3FrameArr = new Id3Frame[arrayList.size()];
        arrayList.toArray(id3FrameArr);
        return new ChapterTocFrame(str, z2, z3, strArr, id3FrameArr);
    }

    private static BinaryFrame decodeBinaryFrame(ParsableByteArray parsableByteArray, int i, String str) {
        byte[] bArr = new byte[i];
        parsableByteArray.readBytes(bArr, 0, i);
        return new BinaryFrame(str, bArr);
    }

    private static int removeUnsynchronization(ParsableByteArray parsableByteArray, int i) {
        byte[] bArr = parsableByteArray.data;
        int position = parsableByteArray.getPosition();
        while (true) {
            int i2 = position + 1;
            if (i2 >= i) {
                return i;
            }
            if ((bArr[position] & 255) == 255 && bArr[i2] == 0) {
                System.arraycopy(bArr, position + 2, bArr, i2, (i - position) - 2);
                i--;
            }
            position = i2;
        }
    }

    private static String getFrameId(int i, int i2, int i3, int i4, int i5) {
        if (i == 2) {
            return String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)});
        }
        return String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    private static int indexOfEos(byte[] bArr, int i, int i2) {
        int indexOfZeroByte = indexOfZeroByte(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return indexOfZeroByte;
        }
        while (indexOfZeroByte < bArr.length - 1) {
            if (indexOfZeroByte % 2 == 0 && bArr[indexOfZeroByte + 1] == 0) {
                return indexOfZeroByte;
            }
            indexOfZeroByte = indexOfZeroByte(bArr, indexOfZeroByte + 1);
        }
        return bArr.length;
    }

    private static int indexOfZeroByte(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    private static byte[] copyOfRangeIfValid(byte[] bArr, int i, int i2) {
        return i2 <= i ? new byte[0] : Arrays.copyOfRange(bArr, i, i2);
    }

    private static String decodeStringIfValid(byte[] bArr, int i, int i2, String str) throws UnsupportedEncodingException {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, str);
    }

    private static final class Id3Header {
        /* access modifiers changed from: private */
        public final int framesSize;
        /* access modifiers changed from: private */
        public final boolean isUnsynchronized;
        /* access modifiers changed from: private */
        public final int majorVersion;

        public Id3Header(int i, boolean z, int i2) {
            this.majorVersion = i;
            this.isUnsynchronized = z;
            this.framesSize = i2;
        }
    }
}
