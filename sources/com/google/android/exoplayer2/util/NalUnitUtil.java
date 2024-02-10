package com.google.android.exoplayer2.util;

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
        public final int constraintsFlagsAndReservedZero2Bits;
        public final boolean deltaPicOrderAlwaysZeroFlag;
        public final boolean frameMbsOnlyFlag;
        public final int frameNumLength;
        public final int height;
        public final int levelIdc;
        public final int picOrderCntLsbLength;
        public final int picOrderCountType;
        public final float pixelWidthAspectRatio;
        public final int profileIdc;
        public final boolean separateColorPlaneFlag;
        public final int seqParameterSetId;
        public final int width;

        public SpsData(int i, int i2, int i3, int i4, int i5, int i6, float f, boolean z, boolean z2, int i7, int i8, int i9, boolean z3) {
            this.profileIdc = i;
            this.constraintsFlagsAndReservedZero2Bits = i2;
            this.levelIdc = i3;
            this.seqParameterSetId = i4;
            this.width = i5;
            this.height = i6;
            this.pixelWidthAspectRatio = f;
            this.separateColorPlaneFlag = z;
            this.frameMbsOnlyFlag = z2;
            this.frameNumLength = i7;
            this.picOrderCountType = i8;
            this.picOrderCntLsbLength = i9;
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

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0154  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.exoplayer2.util.NalUnitUtil.SpsData parseSpsNalUnit(byte[] r21, int r22, int r23) {
        /*
            com.google.android.exoplayer2.util.ParsableNalUnitBitArray r0 = new com.google.android.exoplayer2.util.ParsableNalUnitBitArray
            r1 = r21
            r2 = r22
            r3 = r23
            r0.<init>(r1, r2, r3)
            r1 = 8
            r0.skipBits(r1)
            int r3 = r0.readBits(r1)
            int r4 = r0.readBits(r1)
            int r5 = r0.readBits(r1)
            int r6 = r0.readUnsignedExpGolombCodedInt()
            r2 = 100
            r7 = 3
            r8 = 16
            r9 = 1
            if (r3 == r2) goto L_0x0050
            r2 = 110(0x6e, float:1.54E-43)
            if (r3 == r2) goto L_0x0050
            r2 = 122(0x7a, float:1.71E-43)
            if (r3 == r2) goto L_0x0050
            r2 = 244(0xf4, float:3.42E-43)
            if (r3 == r2) goto L_0x0050
            r2 = 44
            if (r3 == r2) goto L_0x0050
            r2 = 83
            if (r3 == r2) goto L_0x0050
            r2 = 86
            if (r3 == r2) goto L_0x0050
            r2 = 118(0x76, float:1.65E-43)
            if (r3 == r2) goto L_0x0050
            r2 = 128(0x80, float:1.794E-43)
            if (r3 == r2) goto L_0x0050
            r2 = 138(0x8a, float:1.93E-43)
            if (r3 != r2) goto L_0x004d
            goto L_0x0050
        L_0x004d:
            r2 = 1
            r11 = 0
            goto L_0x0089
        L_0x0050:
            int r2 = r0.readUnsignedExpGolombCodedInt()
            if (r2 != r7) goto L_0x005b
            boolean r11 = r0.readBit()
            goto L_0x005c
        L_0x005b:
            r11 = 0
        L_0x005c:
            r0.readUnsignedExpGolombCodedInt()
            r0.readUnsignedExpGolombCodedInt()
            r0.skipBit()
            boolean r12 = r0.readBit()
            if (r12 == 0) goto L_0x0089
            if (r2 == r7) goto L_0x0070
            r12 = 8
            goto L_0x0072
        L_0x0070:
            r12 = 12
        L_0x0072:
            r13 = 0
        L_0x0073:
            if (r13 >= r12) goto L_0x0089
            boolean r14 = r0.readBit()
            if (r14 == 0) goto L_0x0086
            r14 = 6
            if (r13 >= r14) goto L_0x0081
            r14 = 16
            goto L_0x0083
        L_0x0081:
            r14 = 64
        L_0x0083:
            skipScalingList(r0, r14)
        L_0x0086:
            int r13 = r13 + 1
            goto L_0x0073
        L_0x0089:
            int r12 = r0.readUnsignedExpGolombCodedInt()
            int r12 = r12 + 4
            int r13 = r0.readUnsignedExpGolombCodedInt()
            if (r13 != 0) goto L_0x00a0
            int r14 = r0.readUnsignedExpGolombCodedInt()
            int r14 = r14 + 4
            r16 = r2
            r22 = r11
            goto L_0x00c9
        L_0x00a0:
            if (r13 != r9) goto L_0x00c4
            boolean r14 = r0.readBit()
            r0.readSignedExpGolombCodedInt()
            r0.readSignedExpGolombCodedInt()
            int r15 = r0.readUnsignedExpGolombCodedInt()
            r22 = r11
            long r10 = (long) r15
            r16 = r2
            r15 = 0
        L_0x00b6:
            long r1 = (long) r15
            int r17 = (r1 > r10 ? 1 : (r1 == r10 ? 0 : -1))
            if (r17 >= 0) goto L_0x00c1
            r0.readUnsignedExpGolombCodedInt()
            int r15 = r15 + 1
            goto L_0x00b6
        L_0x00c1:
            r15 = r14
            r14 = 0
            goto L_0x00ca
        L_0x00c4:
            r16 = r2
            r22 = r11
            r14 = 0
        L_0x00c9:
            r15 = 0
        L_0x00ca:
            r0.readUnsignedExpGolombCodedInt()
            r0.skipBit()
            int r1 = r0.readUnsignedExpGolombCodedInt()
            int r1 = r1 + r9
            int r2 = r0.readUnsignedExpGolombCodedInt()
            int r2 = r2 + r9
            boolean r11 = r0.readBit()
            int r10 = 2 - r11
            int r10 = r10 * r2
            if (r11 != 0) goto L_0x00e7
            r0.skipBit()
        L_0x00e7:
            r0.skipBit()
            int r1 = r1 * 16
            int r10 = r10 * 16
            boolean r2 = r0.readBit()
            if (r2 == 0) goto L_0x0126
            int r2 = r0.readUnsignedExpGolombCodedInt()
            int r17 = r0.readUnsignedExpGolombCodedInt()
            int r18 = r0.readUnsignedExpGolombCodedInt()
            int r19 = r0.readUnsignedExpGolombCodedInt()
            if (r16 != 0) goto L_0x0109
            int r7 = 2 - r11
            goto L_0x011b
        L_0x0109:
            r20 = 2
            r8 = r16
            if (r8 != r7) goto L_0x0111
            r7 = 1
            goto L_0x0112
        L_0x0111:
            r7 = 2
        L_0x0112:
            if (r8 != r9) goto L_0x0115
            r9 = 2
        L_0x0115:
            int r8 = 2 - r11
            int r8 = r8 * r9
            r9 = r7
            r7 = r8
        L_0x011b:
            int r2 = r2 + r17
            int r2 = r2 * r9
            int r1 = r1 - r2
            int r18 = r18 + r19
            int r18 = r18 * r7
            int r10 = r10 - r18
        L_0x0126:
            r7 = r1
            r8 = r10
            boolean r1 = r0.readBit()
            r2 = 1065353216(0x3f800000, float:1.0)
            if (r1 == 0) goto L_0x0175
            boolean r1 = r0.readBit()
            if (r1 == 0) goto L_0x0175
            r1 = 8
            int r1 = r0.readBits(r1)
            r9 = 255(0xff, float:3.57E-43)
            if (r1 != r9) goto L_0x0154
            r9 = 16
            int r1 = r0.readBits(r9)
            int r0 = r0.readBits(r9)
            if (r1 == 0) goto L_0x0152
            if (r0 == 0) goto L_0x0152
            float r1 = (float) r1
            float r0 = (float) r0
            float r2 = r1 / r0
        L_0x0152:
            r9 = r2
            goto L_0x0177
        L_0x0154:
            float[] r0 = ASPECT_RATIO_IDC_VALUES
            int r9 = r0.length
            if (r1 >= r9) goto L_0x015d
            r0 = r0[r1]
            r9 = r0
            goto L_0x0177
        L_0x015d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r9 = 46
            r0.<init>(r9)
            java.lang.String r9 = "Unexpected aspect_ratio_idc value: "
            r0.append(r9)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "NalUnitUtil"
            com.google.android.exoplayer2.util.Log.w(r1, r0)
        L_0x0175:
            r9 = 1065353216(0x3f800000, float:1.0)
        L_0x0177:
            com.google.android.exoplayer2.util.NalUnitUtil$SpsData r0 = new com.google.android.exoplayer2.util.NalUnitUtil$SpsData
            r2 = r0
            r10 = r22
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.NalUnitUtil.parseSpsNalUnit(byte[], int, int):com.google.android.exoplayer2.util.NalUnitUtil$SpsData");
    }

    public static PpsData parsePpsNalUnit(byte[] bArr, int i, int i2) {
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(bArr, i, i2);
        parsableNalUnitBitArray.skipBits(8);
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.skipBit();
        return new PpsData(readUnsignedExpGolombCodedInt, readUnsignedExpGolombCodedInt2, parsableNalUnitBitArray.readBit());
    }

    public static int findNalUnit(byte[] bArr, int i, int i2, boolean[] zArr) {
        boolean z;
        int i3 = i2 - i;
        boolean z2 = false;
        Assertions.checkState(i3 >= 0);
        if (i3 == 0) {
            return i2;
        }
        if (zArr[0]) {
            clearPrefixFlags(zArr);
            return i - 3;
        } else if (i3 > 1 && zArr[1] && bArr[i] == 1) {
            clearPrefixFlags(zArr);
            return i - 2;
        } else if (i3 <= 2 || !zArr[2] || bArr[i] != 0 || bArr[i + 1] != 1) {
            int i4 = i2 - 1;
            int i5 = i + 2;
            while (i5 < i4) {
                byte b = bArr[i5];
                if ((b & 254) == 0) {
                    int i6 = i5 - 2;
                    if (bArr[i6] == 0 && bArr[i5 - 1] == 0 && b == 1) {
                        clearPrefixFlags(zArr);
                        return i6;
                    }
                    i5 -= 2;
                }
                i5 += 3;
            }
            if (i3 <= 2 ? i3 != 2 ? !zArr[1] || bArr[i4] != 1 : !(zArr[2] && bArr[i2 - 2] == 0 && bArr[i4] == 1) : !(bArr[i2 - 3] == 0 && bArr[i2 - 2] == 0 && bArr[i4] == 1)) {
                z = false;
            } else {
                z = true;
            }
            zArr[0] = z;
            zArr[1] = i3 <= 1 ? !(!zArr[2] || bArr[i4] != 0) : bArr[i2 + -2] == 0 && bArr[i4] == 0;
            if (bArr[i4] == 0) {
                z2 = true;
            }
            zArr[2] = z2;
            return i2;
        } else {
            clearPrefixFlags(zArr);
            return i - 1;
        }
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
