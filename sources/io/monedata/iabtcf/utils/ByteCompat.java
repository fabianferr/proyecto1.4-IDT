package io.monedata.iabtcf.utils;

public class ByteCompat {
    public static int toUnsignedInt(byte b) {
        return b & 255;
    }
}
