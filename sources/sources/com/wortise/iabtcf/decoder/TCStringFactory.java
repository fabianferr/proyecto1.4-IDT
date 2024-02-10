package com.wortise.iabtcf.decoder;

import com.wortise.iabtcf.exceptions.ByteParseException;
import com.wortise.iabtcf.exceptions.UnsupportedVersionException;

public class TCStringFactory {
    public static TCString decode(String str, DecoderOption... decoderOptionArr) throws IllegalArgumentException, ByteParseException, UnsupportedVersionException {
        return TCStringDecoder.decode(str, decoderOptionArr);
    }
}
