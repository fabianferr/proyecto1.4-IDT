package com.squareup.wire;

import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 /2\u00020\u0001:\u0001/B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J \u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000b2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\b\u0010\u0017\u001a\u00020\tH\u0002J\u0006\u0010\u0018\u001a\u00020\tJ\u0010\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\tH\u0007J\u000e\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001a\u001a\u00020\tJ%\u0010\u001d\u001a\u00020\u001c2\u0012\u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00010\u001fH\bø\u0001\u0000¢\u0006\u0002\b J\b\u0010!\u001a\u00020\u000fH\u0002J\u0006\u0010\"\u001a\u00020\u000fJ\b\u0010#\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010$\u001a\u00020\u001cJ\u0006\u0010%\u001a\u00020\u000fJ\u0006\u0010&\u001a\u00020\tJ\u0006\u0010'\u001a\u00020(J\u000e\u0010)\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010*\u001a\u00020\u000fJ\u0006\u0010+\u001a\u00020\tJ\u0006\u0010,\u001a\u00020\u0013J\u0010\u0010-\u001a\u00020\u00132\u0006\u0010.\u001a\u00020\u000fH\u0002R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000\u0002\u0007\n\u0005\b20\u0001¨\u00060"}, d2 = {"Lcom/squareup/wire/ProtoReader;", "", "source", "Lokio/BufferedSource;", "(Lokio/BufferedSource;)V", "bufferStack", "", "Lokio/Buffer;", "limit", "", "nextFieldEncoding", "Lcom/squareup/wire/FieldEncoding;", "pos", "pushedLimit", "recursionDepth", "", "state", "tag", "addUnknownField", "", "fieldEncoding", "value", "afterPackableScalar", "beforeLengthDelimitedScalar", "beginMessage", "endMessage", "token", "endMessageAndGetUnknownFields", "Lokio/ByteString;", "forEachTag", "tagHandler", "Lkotlin/Function1;", "-forEachTag", "internalReadVarint32", "nextTag", "peekFieldEncoding", "readBytes", "readFixed32", "readFixed64", "readString", "", "readUnknownField", "readVarint32", "readVarint64", "skip", "skipGroup", "expectedEndTag", "Companion", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProtoReader.kt */
public final class ProtoReader {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int FIELD_ENCODING_MASK = 7;
    private static final int RECURSION_LIMIT = 65;
    private static final int STATE_END_GROUP = 4;
    private static final int STATE_FIXED32 = 5;
    private static final int STATE_FIXED64 = 1;
    private static final int STATE_LENGTH_DELIMITED = 2;
    private static final int STATE_PACKED_TAG = 7;
    private static final int STATE_START_GROUP = 3;
    private static final int STATE_TAG = 6;
    private static final int STATE_VARINT = 0;
    public static final int TAG_FIELD_ENCODING_BITS = 3;
    private final List<Buffer> bufferStack = new ArrayList();
    private long limit = Long.MAX_VALUE;
    private FieldEncoding nextFieldEncoding;
    private long pos;
    private long pushedLimit = -1;
    private int recursionDepth;
    private final BufferedSource source;
    private int state = 2;
    private int tag = -1;

    public ProtoReader(BufferedSource bufferedSource) {
        Intrinsics.checkNotNullParameter(bufferedSource, "source");
        this.source = bufferedSource;
    }

    public final long beginMessage() throws IOException {
        if (this.state == 2) {
            int i = this.recursionDepth + 1;
            this.recursionDepth = i;
            if (i <= 65) {
                if (i > this.bufferStack.size()) {
                    this.bufferStack.add(new Buffer());
                }
                long j = this.pushedLimit;
                this.pushedLimit = -1;
                this.state = 6;
                return j;
            }
            throw new IOException("Wire recursion limit exceeded");
        }
        throw new IllegalStateException("Unexpected call to beginMessage()".toString());
    }

    public final ByteString endMessageAndGetUnknownFields(long j) throws IOException {
        boolean z = true;
        if (this.state == 6) {
            int i = this.recursionDepth - 1;
            this.recursionDepth = i;
            if (i < 0 || this.pushedLimit != -1) {
                z = false;
            }
            if (!z) {
                throw new IllegalStateException("No corresponding call to beginMessage()".toString());
            } else if (this.pos == this.limit || i == 0) {
                this.limit = j;
                Buffer buffer = this.bufferStack.get(i);
                if (buffer.size() > 0) {
                    return buffer.readByteString();
                }
                return ByteString.EMPTY;
            } else {
                throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
            }
        } else {
            throw new IllegalStateException("Unexpected call to endMessage()".toString());
        }
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "prefer endMessageAndGetUnknownFields()", replaceWith = @ReplaceWith(expression = "endMessageAndGetUnknownFields(token)", imports = {}))
    public final void endMessage(long j) throws IOException {
        endMessageAndGetUnknownFields(j);
    }

    public final int nextTag() throws IOException {
        int i = this.state;
        if (i == 7) {
            this.state = 2;
            return this.tag;
        } else if (i == 6) {
            while (this.pos < this.limit && !this.source.exhausted()) {
                int internalReadVarint32 = internalReadVarint32();
                if (internalReadVarint32 != 0) {
                    int i2 = internalReadVarint32 >> 3;
                    this.tag = i2;
                    int i3 = internalReadVarint32 & 7;
                    if (i3 == 0) {
                        this.nextFieldEncoding = FieldEncoding.VARINT;
                        this.state = 0;
                        return this.tag;
                    } else if (i3 == 1) {
                        this.nextFieldEncoding = FieldEncoding.FIXED64;
                        this.state = 1;
                        return this.tag;
                    } else if (i3 == 2) {
                        this.nextFieldEncoding = FieldEncoding.LENGTH_DELIMITED;
                        this.state = 2;
                        int internalReadVarint322 = internalReadVarint32();
                        if (internalReadVarint322 < 0) {
                            throw new ProtocolException(Intrinsics.stringPlus("Negative length: ", Integer.valueOf(internalReadVarint322)));
                        } else if (this.pushedLimit == -1) {
                            long j = this.limit;
                            this.pushedLimit = j;
                            long j2 = this.pos + ((long) internalReadVarint322);
                            this.limit = j2;
                            if (j2 <= j) {
                                return this.tag;
                            }
                            throw new EOFException();
                        } else {
                            throw new IllegalStateException();
                        }
                    } else if (i3 == 3) {
                        skipGroup(i2);
                    } else if (i3 == 4) {
                        throw new ProtocolException("Unexpected end group");
                    } else if (i3 == 5) {
                        this.nextFieldEncoding = FieldEncoding.FIXED32;
                        this.state = 5;
                        return this.tag;
                    } else {
                        throw new ProtocolException(Intrinsics.stringPlus("Unexpected field encoding: ", Integer.valueOf(i3)));
                    }
                } else {
                    throw new ProtocolException("Unexpected tag 0");
                }
            }
            return -1;
        } else {
            throw new IllegalStateException("Unexpected call to nextTag()");
        }
    }

    public final FieldEncoding peekFieldEncoding() {
        return this.nextFieldEncoding;
    }

    public final void skip() throws IOException {
        int i = this.state;
        if (i == 0) {
            readVarint64();
        } else if (i == 1) {
            readFixed64();
        } else if (i == 2) {
            this.source.skip(beforeLengthDelimitedScalar());
        } else if (i == 5) {
            readFixed32();
        } else {
            throw new IllegalStateException("Unexpected call to skip()");
        }
    }

    private final void skipGroup(int i) {
        while (this.pos < this.limit && !this.source.exhausted()) {
            int internalReadVarint32 = internalReadVarint32();
            if (internalReadVarint32 != 0) {
                int i2 = internalReadVarint32 >> 3;
                int i3 = internalReadVarint32 & 7;
                if (i3 == 0) {
                    this.state = 0;
                    readVarint64();
                } else if (i3 == 1) {
                    this.state = 1;
                    readFixed64();
                } else if (i3 == 2) {
                    long internalReadVarint322 = (long) internalReadVarint32();
                    this.pos += internalReadVarint322;
                    this.source.skip(internalReadVarint322);
                } else if (i3 == 3) {
                    skipGroup(i2);
                } else if (i3 != 4) {
                    if (i3 == 5) {
                        this.state = 5;
                        readFixed32();
                    } else {
                        throw new ProtocolException(Intrinsics.stringPlus("Unexpected field encoding: ", Integer.valueOf(i3)));
                    }
                } else if (i2 != i) {
                    throw new ProtocolException("Unexpected end group");
                } else {
                    return;
                }
            } else {
                throw new ProtocolException("Unexpected tag 0");
            }
        }
        throw new EOFException();
    }

    public final ByteString readBytes() throws IOException {
        long beforeLengthDelimitedScalar = beforeLengthDelimitedScalar();
        this.source.require(beforeLengthDelimitedScalar);
        return this.source.readByteString(beforeLengthDelimitedScalar);
    }

    public final String readString() throws IOException {
        long beforeLengthDelimitedScalar = beforeLengthDelimitedScalar();
        this.source.require(beforeLengthDelimitedScalar);
        return this.source.readUtf8(beforeLengthDelimitedScalar);
    }

    public final int readVarint32() throws IOException {
        int i = this.state;
        if (i == 0 || i == 2) {
            int internalReadVarint32 = internalReadVarint32();
            afterPackableScalar(0);
            return internalReadVarint32;
        }
        throw new ProtocolException(Intrinsics.stringPlus("Expected VARINT or LENGTH_DELIMITED but was ", Integer.valueOf(this.state)));
    }

    private final int internalReadVarint32() {
        int i;
        this.source.require(1);
        this.pos++;
        byte readByte = this.source.readByte();
        if (readByte >= 0) {
            return readByte;
        }
        byte b = readByte & Byte.MAX_VALUE;
        this.source.require(1);
        this.pos++;
        byte readByte2 = this.source.readByte();
        if (readByte2 >= 0) {
            i = readByte2 << 7;
        } else {
            b |= (readByte2 & Byte.MAX_VALUE) << 7;
            this.source.require(1);
            this.pos++;
            byte readByte3 = this.source.readByte();
            if (readByte3 >= 0) {
                i = readByte3 << Ascii.SO;
            } else {
                b |= (readByte3 & Byte.MAX_VALUE) << Ascii.SO;
                this.source.require(1);
                this.pos++;
                byte readByte4 = this.source.readByte();
                if (readByte4 >= 0) {
                    i = readByte4 << Ascii.NAK;
                } else {
                    byte b2 = b | ((readByte4 & Byte.MAX_VALUE) << Ascii.NAK);
                    this.source.require(1);
                    this.pos++;
                    byte readByte5 = this.source.readByte();
                    byte b3 = b2 | (readByte5 << Ascii.FS);
                    if (readByte5 >= 0) {
                        return b3;
                    }
                    int i2 = 0;
                    while (i2 < 5) {
                        i2++;
                        this.source.require(1);
                        this.pos++;
                        if (this.source.readByte() >= 0) {
                            return b3;
                        }
                    }
                    throw new ProtocolException("Malformed VARINT");
                }
            }
        }
        return b | i;
    }

    public final long readVarint64() throws IOException {
        int i = this.state;
        if (i == 0 || i == 2) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2 += 7) {
                this.source.require(1);
                this.pos++;
                byte readByte = this.source.readByte();
                j |= ((long) (readByte & Byte.MAX_VALUE)) << i2;
                if ((readByte & 128) == 0) {
                    afterPackableScalar(0);
                    return j;
                }
            }
            throw new ProtocolException("WireInput encountered a malformed varint");
        }
        throw new ProtocolException(Intrinsics.stringPlus("Expected VARINT or LENGTH_DELIMITED but was ", Integer.valueOf(this.state)));
    }

    public final int readFixed32() throws IOException {
        int i = this.state;
        if (i == 5 || i == 2) {
            this.source.require(4);
            this.pos += (long) 4;
            int readIntLe = this.source.readIntLe();
            afterPackableScalar(5);
            return readIntLe;
        }
        throw new ProtocolException(Intrinsics.stringPlus("Expected FIXED32 or LENGTH_DELIMITED but was ", Integer.valueOf(this.state)));
    }

    public final long readFixed64() throws IOException {
        int i = this.state;
        if (i == 1 || i == 2) {
            this.source.require(8);
            this.pos += (long) 8;
            long readLongLe = this.source.readLongLe();
            afterPackableScalar(1);
            return readLongLe;
        }
        throw new ProtocolException(Intrinsics.stringPlus("Expected FIXED64 or LENGTH_DELIMITED but was ", Integer.valueOf(this.state)));
    }

    private final void afterPackableScalar(int i) throws IOException {
        if (this.state == i) {
            this.state = 6;
            return;
        }
        long j = this.pos;
        long j2 = this.limit;
        if (j > j2) {
            throw new IOException("Expected to end at " + this.limit + " but was " + this.pos);
        } else if (j == j2) {
            this.limit = this.pushedLimit;
            this.pushedLimit = -1;
            this.state = 6;
        } else {
            this.state = 7;
        }
    }

    private final long beforeLengthDelimitedScalar() throws IOException {
        if (this.state == 2) {
            long j = this.limit - this.pos;
            this.source.require(j);
            this.state = 6;
            this.pos = this.limit;
            this.limit = this.pushedLimit;
            this.pushedLimit = -1;
            return j;
        }
        throw new ProtocolException(Intrinsics.stringPlus("Expected LENGTH_DELIMITED but was ", Integer.valueOf(this.state)));
    }

    /* renamed from: -forEachTag  reason: not valid java name */
    public final ByteString m243forEachTag(Function1<? super Integer, ? extends Object> function1) {
        Intrinsics.checkNotNullParameter(function1, "tagHandler");
        long beginMessage = beginMessage();
        while (true) {
            int nextTag = nextTag();
            if (nextTag == -1) {
                return endMessageAndGetUnknownFields(beginMessage);
            }
            function1.invoke(Integer.valueOf(nextTag));
        }
    }

    public final void readUnknownField(int i) {
        FieldEncoding peekFieldEncoding = peekFieldEncoding();
        Intrinsics.checkNotNull(peekFieldEncoding);
        addUnknownField(i, peekFieldEncoding, peekFieldEncoding.rawProtoAdapter().decode(this));
    }

    public final void addUnknownField(int i, FieldEncoding fieldEncoding, Object obj) {
        Intrinsics.checkNotNullParameter(fieldEncoding, "fieldEncoding");
        fieldEncoding.rawProtoAdapter().encodeWithTag(new ProtoWriter(this.bufferStack.get(this.recursionDepth - 1)), i, obj);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/squareup/wire/ProtoReader$Companion;", "", "()V", "FIELD_ENCODING_MASK", "", "RECURSION_LIMIT", "STATE_END_GROUP", "STATE_FIXED32", "STATE_FIXED64", "STATE_LENGTH_DELIMITED", "STATE_PACKED_TAG", "STATE_START_GROUP", "STATE_TAG", "STATE_VARINT", "TAG_FIELD_ENCODING_BITS", "wire-runtime"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ProtoReader.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
