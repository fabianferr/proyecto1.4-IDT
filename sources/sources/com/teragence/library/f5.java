package com.teragence.library;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.UUID;

public class f5 {
    public static byte[] a(UUID uuid) {
        ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
        ByteBuffer wrap2 = ByteBuffer.wrap(new byte[8]);
        wrap2.putLong(uuid.getMostSignificantBits()).rewind();
        wrap.order(ByteOrder.LITTLE_ENDIAN).putInt(wrap2.getInt()).putShort(wrap2.getShort()).putShort(wrap2.getShort()).order(ByteOrder.BIG_ENDIAN).putLong(uuid.getLeastSignificantBits());
        return wrap.array();
    }
}
