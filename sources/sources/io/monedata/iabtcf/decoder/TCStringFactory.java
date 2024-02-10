package io.monedata.iabtcf.decoder;

import io.monedata.iabtcf.exceptions.ByteParseException;
import io.monedata.iabtcf.exceptions.UnsupportedVersionException;

public class TCStringFactory {
    public static TCString decode(String str, DecoderOption... decoderOptionArr) throws IllegalArgumentException, ByteParseException, UnsupportedVersionException {
        return TCStringDecoder.decode(str, decoderOptionArr);
    }
}
