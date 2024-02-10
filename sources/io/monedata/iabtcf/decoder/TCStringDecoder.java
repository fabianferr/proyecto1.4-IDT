package io.monedata.iabtcf.decoder;

import android.util.Base64;
import io.monedata.iabtcf.exceptions.ByteParseException;
import io.monedata.iabtcf.exceptions.UnsupportedVersionException;
import io.monedata.iabtcf.utils.BitReader;
import io.monedata.iabtcf.utils.FieldDefs;
import java.util.EnumSet;

class TCStringDecoder {
    TCStringDecoder() {
    }

    static BitReader vectorFromString(String str) {
        return new BitReader(Base64.decode(str, 8));
    }

    public static TCString decode(String str, DecoderOption... decoderOptionArr) throws IllegalArgumentException, ByteParseException, UnsupportedVersionException {
        TCStringV2 tCStringV2;
        EnumSet<E> noneOf = EnumSet.noneOf(DecoderOption.class);
        for (DecoderOption add : decoderOptionArr) {
            noneOf.add(add);
        }
        String[] split = str.split("\\.");
        BitReader vectorFromString = vectorFromString(split[0]);
        byte readBits6 = vectorFromString.readBits6(FieldDefs.CORE_VERSION);
        if (readBits6 == 1) {
            return TCStringV1.fromBitVector(vectorFromString);
        }
        if (readBits6 == 2) {
            if (split.length > 1) {
                BitReader[] bitReaderArr = new BitReader[(split.length - 1)];
                for (int i = 1; i < split.length; i++) {
                    bitReaderArr[i - 1] = vectorFromString(split[i]);
                }
                tCStringV2 = TCStringV2.fromBitVector(vectorFromString, bitReaderArr);
            } else {
                tCStringV2 = TCStringV2.fromBitVector(vectorFromString, new BitReader[0]);
            }
            if (!noneOf.contains(DecoderOption.LAZY)) {
                tCStringV2.hashCode();
            }
            return tCStringV2;
        }
        throw new UnsupportedVersionException("Version " + readBits6 + "is unsupported yet");
    }
}
