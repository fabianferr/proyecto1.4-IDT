package com.google.common.io;

import java.io.DataInput;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
public interface ByteArrayDataInput extends DataInput {
    boolean readBoolean();

    byte readByte();

    char readChar();

    double readDouble();

    float readFloat();

    void readFully(byte[] bArr);

    void readFully(byte[] bArr, int i, int i2);

    int readInt();

    @CheckForNull
    String readLine();

    long readLong();

    short readShort();

    String readUTF();

    int readUnsignedByte();

    int readUnsignedShort();

    int skipBytes(int i);
}
