package com.google.common.hash;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;

@ElementTypesAreNonnullByDefault
public interface Hasher extends PrimitiveSink {

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: com.google.common.hash.Hasher$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
    }

    HashCode hash();

    @Deprecated
    int hashCode();

    Hasher putBoolean(boolean z);

    Hasher putByte(byte b);

    Hasher putBytes(ByteBuffer byteBuffer);

    Hasher putBytes(byte[] bArr);

    Hasher putBytes(byte[] bArr, int i, int i2);

    Hasher putChar(char c);

    Hasher putDouble(double d);

    Hasher putFloat(float f);

    Hasher putInt(int i);

    Hasher putLong(long j);

    <T> Hasher putObject(@ParametricNullness T t, Funnel<? super T> funnel);

    Hasher putShort(short s);

    Hasher putString(CharSequence charSequence, Charset charset);

    Hasher putUnencodedChars(CharSequence charSequence);
}
