package com.mbridge.msdk.playercommon.exoplayer2.util;

import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class NalUnitUtil {
    public static final float[] ASPECT_RATIO_IDC_VALUES = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};
    public static final int EXTENDED_SAR = 255;
    private static final int H264_NAL_UNIT_TYPE_SEI = 6;
    private static final int H264_NAL_UNIT_TYPE_SPS = 7;
    private static final int H265_NAL_UNIT_TYPE_PREFIX_SEI = 39;
    public static final byte[] NAL_START_CODE = {0, 0, 0, 1};
    private static final String TAG = "NalUnitUtil";
    private static int[] scratchEscapePositions = new int[10];
    private static final Object scratchEscapePositionsLock = new Object();

    public static final class SpsData {
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthAspectRatio;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i, int i2, int i3, float f, boolean z, boolean z2, int i4, int i5, int i6, boolean z3) {
            this.seqParameterSetId = i;
            this.width = i2;
            this.height = i3;
            this.pixelWidthAspectRatio = f;
            this.separateColorPlaneFlag = z;
            this.frameMbsOnlyFlag = z2;
            this.frameNumLength = i4;
            this.picOrderCountType = i5;
            this.picOrderCntLsbLength = i6;
            this.deltaPicOrderAlwaysZeroFlag = z3;
        }
    }

    public static final class PpsData {
        public final boolean bottomFieldPicOrderInFramePresentFlag;
        public final int picParameterSetId;
        public final int seqParameterSetId;

        public PpsData(int i, int i2, boolean z) {
            this.picParameterSetId = i;
            this.seqParameterSetId = i2;
            this.bottomFieldPicOrderInFramePresentFlag = z;
        }
    }

    public static int unescapeStream(byte[] bArr, int i) {
        int i2;
        synchronized (scratchEscapePositionsLock) {
            int i3 = 0;
            int i4 = 0;
            while (i3 < i) {
                try {
                    i3 = findNextUnescapeIndex(bArr, i3, i);
                    if (i3 < i) {
                        int[] iArr = scratchEscapePositions;
                        if (iArr.length <= i4) {
                            scratchEscapePositions = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        scratchEscapePositions[i4] = i3;
                        i3 += 3;
                        i4++;
                    }
                } finally {
                }
            }
            i2 = i - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = scratchEscapePositions[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i10 + 1;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i2 - i5);
        }
        return i2;
    }

    public static void discardToSps(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i + 1;
            if (i3 < position) {
                byte b = byteBuffer.get(i) & 255;
                if (i2 == 3) {
                    if (b == 1 && (byteBuffer.get(i3) & Ascii.US) == 7) {
                        ByteBuffer duplicate = byteBuffer.duplicate();
                        duplicate.position(i - 3);
                        duplicate.limit(position);
                        byteBuffer.position(0);
                        byteBuffer.put(duplicate);
                        return;
                    }
                } else if (b == 0) {
                    i2++;
                }
                if (b != 0) {
                    i2 = 0;
                }
                i = i3;
            } else {
                byteBuffer.clear();
                return;
            }
        }
    }

    public static boolean isNalUnitSei(String str, byte b) {
        if ("video/avc".equals(str) && (b & Ascii.US) == 6) {
            return true;
        }
        if (!"video/hevc".equals(str) || ((b & 126) >> 1) != 39) {
            return false;
        }
        return true;
    }

    public static int getNalUnitType(byte[] bArr, int i) {
        return bArr[i + 3] & Ascii.US;
    }

    public static int getH265NalUnitType(byte[] bArr, int i) {
        return (bArr[i + 3] & 126) >> 1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00db  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x0131  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0143  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil.SpsData parseSpsNalUnit(byte[] r19, int r20, int r21) {
        /*
            com.mbridge.msdk.playercommon.exoplayer2.util.ParsableNalUnitBitArray r0 = new com.mbridge.msdk.playercommon.exoplayer2.util.ParsableNalUnitBitArray
            r1 = r19
            r2 = r20
            r3 = r21
            r0.<init>(r1, r2, r3)
            r1 = 8
            r0.skipBits(r1)
            int r2 = r0.readBits(r1)
            r3 = 16
            r0.skipBits(r3)
            int r5 = r0.readUnsignedExpGolombCodedInt()
            r4 = 100
            r6 = 3
            r7 = 1
            if (r2 == r4) goto L_0x004b
            r4 = 110(0x6e, float:1.54E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 122(0x7a, float:1.71E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 244(0xf4, float:3.42E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 44
            if (r2 == r4) goto L_0x004b
            r4 = 83
            if (r2 == r4) goto L_0x004b
            r4 = 86
            if (r2 == r4) goto L_0x004b
            r4 = 118(0x76, float:1.65E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 128(0x80, float:1.794E-43)
            if (r2 == r4) goto L_0x004b
            r4 = 138(0x8a, float:1.93E-43)
            if (r2 != r4) goto L_0x0048
            goto L_0x004b
        L_0x0048:
            r2 = 1
            r9 = 0
            goto L_0x0085
        L_0x004b:
            int r2 = r0.readUnsignedExpGolombCodedInt()
            if (r2 != r6) goto L_0x0056
            boolean r4 = r0.readBit()
            goto L_0x0057
        L_0x0056:
            r4 = 0
        L_0x0057:
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.skipBit()
            boolean r9 = r0.readBit()
            if (r9 == 0) goto L_0x0084
            if (r2 == r6) goto L_0x006b
            r9 = 8
            goto L_0x006d
        L_0x006b:
            r9 = 12
        L_0x006d:
            r10 = 0
        L_0x006e:
            if (r10 >= r9) goto L_0x0084
            boolean r11 = r0.readBit()
            if (r11 == 0) goto L_0x0081
            r11 = 6
            if (r10 >= r11) goto L_0x007c
            r11 = 16
            goto L_0x007e
        L_0x007c:
            r11 = 64
        L_0x007e:
            skipScalingList(r0, r11)
        L_0x0081:
            int r10 = r10 + 1
            goto L_0x006e
        L_0x0084:
            r9 = r4
        L_0x0085:
            int r4 = r0.readUnsignedExpGolombCodedInt()
            int r11 = r4 + 4
            int r12 = r0.readUnsignedExpGolombCodedInt()
            if (r12 != 0) goto L_0x009b
            int r4 = r0.readUnsignedExpGolombCodedInt()
            int r4 = r4 + 4
            r13 = r4
            r20 = r9
            goto L_0x00c0
        L_0x009b:
            if (r12 != r7) goto L_0x00bd
            boolean r4 = r0.readBit()
            r0.readSignedExpGolombCodedInt()
            r0.readSignedExpGolombCodedInt()
            int r10 = r0.readUnsignedExpGolombCodedInt()
            long r13 = (long) r10
            r20 = r9
            r10 = 0
        L_0x00af:
            long r8 = (long) r10
            int r15 = (r8 > r13 ? 1 : (r8 == r13 ? 0 : -1))
            if (r15 >= 0) goto L_0x00ba
            r0.readUnsignedExpGolombCodedInt()
            int r10 = r10 + 1
            goto L_0x00af
        L_0x00ba:
            r14 = r4
            r13 = 0
            goto L_0x00c1
        L_0x00bd:
            r20 = r9
            r13 = 0
        L_0x00c0:
            r14 = 0
        L_0x00c1:
            r0.readUnsignedExpGolombCodedInt()
            r0.skipBit()
            int r4 = r0.readUnsignedExpGolombCodedInt()
            int r4 = r4 + r7
            int r8 = r0.readUnsignedExpGolombCodedInt()
            int r8 = r8 + r7
            boolean r10 = r0.readBit()
            int r9 = 2 - r10
            int r9 = r9 * r8
            if (r10 != 0) goto L_0x00de
            r0.skipBit()
        L_0x00de:
            r0.skipBit()
            int r4 = r4 * 16
            int r9 = r9 * 16
            boolean r8 = r0.readBit()
            if (r8 == 0) goto L_0x0119
            int r8 = r0.readUnsignedExpGolombCodedInt()
            int r15 = r0.readUnsignedExpGolombCodedInt()
            int r16 = r0.readUnsignedExpGolombCodedInt()
            int r17 = r0.readUnsignedExpGolombCodedInt()
            if (r2 != 0) goto L_0x0100
            int r2 = 2 - r10
            goto L_0x010f
        L_0x0100:
            r18 = 2
            if (r2 != r6) goto L_0x0106
            r6 = 1
            goto L_0x0107
        L_0x0106:
            r6 = 2
        L_0x0107:
            if (r2 != r7) goto L_0x010a
            r7 = 2
        L_0x010a:
            int r2 = 2 - r10
            int r2 = r2 * r7
            r7 = r6
        L_0x010f:
            int r8 = r8 + r15
            int r8 = r8 * r7
            int r4 = r4 - r8
            int r16 = r16 + r17
            int r16 = r16 * r2
            int r9 = r9 - r16
        L_0x0119:
            r6 = r4
            r7 = r9
            boolean r2 = r0.readBit()
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r2 == 0) goto L_0x015f
            boolean r2 = r0.readBit()
            if (r2 == 0) goto L_0x015f
            int r1 = r0.readBits(r1)
            r2 = 255(0xff, float:3.57E-43)
            if (r1 != r2) goto L_0x0143
            int r1 = r0.readBits(r3)
            int r0 = r0.readBits(r3)
            if (r1 == 0) goto L_0x0141
            if (r0 == 0) goto L_0x0141
            float r1 = (float) r1
            float r0 = (float) r0
            float r4 = r1 / r0
        L_0x0141:
            r8 = r4
            goto L_0x0161
        L_0x0143:
            float[] r0 = ASPECT_RATIO_IDC_VALUES
            int r2 = r0.length
            if (r1 >= r2) goto L_0x014c
            r0 = r0[r1]
            r8 = r0
            goto L_0x0161
        L_0x014c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "Unexpected aspect_ratio_idc value: "
            r0.<init>(r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "NalUnitUtil"
            android.util.Log.w(r1, r0)
        L_0x015f:
            r8 = 1065353216(0x3f800000, float:1.0)
        L_0x0161:
            com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil$SpsData r0 = new com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil$SpsData
            r4 = r0
            r9 = r20
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil.parseSpsNalUnit(byte[], int, int):com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil$SpsData");
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i, int i2) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.skipBits(8);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0095, code lost:
        r9 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int findNalUnit(byte[] r8, int r9, int r10, boolean[] r11) {
        /*
            int r0 = r10 - r9
            r1 = 0
            r2 = 1
            if (r0 < 0) goto L_0x0008
            r3 = 1
            goto L_0x0009
        L_0x0008:
            r3 = 0
        L_0x0009:
            com.mbridge.msdk.playercommon.exoplayer2.util.Assertions.checkState(r3)
            if (r0 != 0) goto L_0x000f
            return r10
        L_0x000f:
            r3 = 2
            if (r11 == 0) goto L_0x0040
            boolean r4 = r11[r1]
            if (r4 == 0) goto L_0x001c
            clearPrefixFlags(r11)
            int r9 = r9 + -3
            return r9
        L_0x001c:
            if (r0 <= r2) goto L_0x002b
            boolean r4 = r11[r2]
            if (r4 == 0) goto L_0x002b
            byte r4 = r8[r9]
            if (r4 != r2) goto L_0x002b
            clearPrefixFlags(r11)
            int r9 = r9 - r3
            return r9
        L_0x002b:
            if (r0 <= r3) goto L_0x0040
            boolean r4 = r11[r3]
            if (r4 == 0) goto L_0x0040
            byte r4 = r8[r9]
            if (r4 != 0) goto L_0x0040
            int r4 = r9 + 1
            byte r4 = r8[r4]
            if (r4 != r2) goto L_0x0040
            clearPrefixFlags(r11)
            int r9 = r9 - r2
            return r9
        L_0x0040:
            int r4 = r10 + -1
            int r9 = r9 + r3
        L_0x0043:
            if (r9 >= r4) goto L_0x0065
            byte r5 = r8[r9]
            r6 = r5 & 254(0xfe, float:3.56E-43)
            if (r6 == 0) goto L_0x004c
            goto L_0x0062
        L_0x004c:
            int r6 = r9 + -2
            byte r7 = r8[r6]
            if (r7 != 0) goto L_0x0060
            int r7 = r9 + -1
            byte r7 = r8[r7]
            if (r7 != 0) goto L_0x0060
            if (r5 != r2) goto L_0x0060
            if (r11 == 0) goto L_0x005f
            clearPrefixFlags(r11)
        L_0x005f:
            return r6
        L_0x0060:
            int r9 = r9 + -2
        L_0x0062:
            int r9 = r9 + 3
            goto L_0x0043
        L_0x0065:
            if (r11 == 0) goto L_0x00b9
            if (r0 <= r3) goto L_0x007c
            int r9 = r10 + -3
            byte r9 = r8[r9]
            if (r9 != 0) goto L_0x007a
            int r9 = r10 + -2
            byte r9 = r8[r9]
            if (r9 != 0) goto L_0x007a
            byte r9 = r8[r4]
            if (r9 != r2) goto L_0x007a
            goto L_0x0095
        L_0x007a:
            r9 = 0
            goto L_0x0096
        L_0x007c:
            if (r0 != r3) goto L_0x008d
            boolean r9 = r11[r3]
            if (r9 == 0) goto L_0x007a
            int r9 = r10 + -2
            byte r9 = r8[r9]
            if (r9 != 0) goto L_0x007a
            byte r9 = r8[r4]
            if (r9 != r2) goto L_0x007a
            goto L_0x0095
        L_0x008d:
            boolean r9 = r11[r2]
            if (r9 == 0) goto L_0x007a
            byte r9 = r8[r4]
            if (r9 != r2) goto L_0x007a
        L_0x0095:
            r9 = 1
        L_0x0096:
            r11[r1] = r9
            if (r0 <= r2) goto L_0x00a5
            int r9 = r10 + -2
            byte r9 = r8[r9]
            if (r9 != 0) goto L_0x00af
            byte r9 = r8[r4]
            if (r9 != 0) goto L_0x00af
            goto L_0x00ad
        L_0x00a5:
            boolean r9 = r11[r3]
            if (r9 == 0) goto L_0x00af
            byte r9 = r8[r4]
            if (r9 != 0) goto L_0x00af
        L_0x00ad:
            r9 = 1
            goto L_0x00b0
        L_0x00af:
            r9 = 0
        L_0x00b0:
            r11[r2] = r9
            byte r8 = r8[r4]
            if (r8 != 0) goto L_0x00b7
            r1 = 1
        L_0x00b7:
            r11[r3] = r1
        L_0x00b9:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.util.NalUnitUtil.findNalUnit(byte[], int, int, boolean[]):int");
    }

    public static void clearPrefixFlags(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    private static int findNextUnescapeIndex(byte[] bArr, int i, int i2) {
        while (i < i2 - 2) {
            if (bArr[i] == 0 && bArr[i + 1] == 0 && bArr[i + 2] == 3) {
                return i;
            }
            i++;
        }
        return i2;
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray, int i) {
        int i2 = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i; i4++) {
            if (i2 != 0) {
                i2 = ((parsableNalUnitBitArray.readSignedExpGolombCodedInt() + i3) + 256) % 256;
            }
            if (i2 != 0) {
                i3 = i2;
            }
        }
    }

    private NalUnitUtil() {
    }
}
