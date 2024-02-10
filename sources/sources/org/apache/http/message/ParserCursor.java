package org.apache.http.message;

import kotlin.text.Typography;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.apache.http.util.CharArrayBuffer;

public class ParserCursor {
    private final int lowerBound;
    private int pos;
    private final int upperBound;

    public ParserCursor(int i, int i2) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Lower bound cannot be negative");
        } else if (i <= i2) {
            this.lowerBound = i;
            this.upperBound = i2;
            this.pos = i;
        } else {
            throw new IndexOutOfBoundsException("Lower bound cannot be greater then upper bound");
        }
    }

    public int getLowerBound() {
        return this.lowerBound;
    }

    public int getUpperBound() {
        return this.upperBound;
    }

    public int getPos() {
        return this.pos;
    }

    public void updatePos(int i) {
        if (i < this.lowerBound) {
            throw new IndexOutOfBoundsException(new StringBuffer("pos: ").append(i).append(" < lowerBound: ").append(this.lowerBound).toString());
        } else if (i <= this.upperBound) {
            this.pos = i;
        } else {
            throw new IndexOutOfBoundsException(new StringBuffer("pos: ").append(i).append(" > upperBound: ").append(this.upperBound).toString());
        }
    }

    public boolean atEnd() {
        return this.pos >= this.upperBound;
    }

    public String toString() {
        CharArrayBuffer charArrayBuffer = new CharArrayBuffer(16);
        charArrayBuffer.append((char) AbstractJsonLexerKt.BEGIN_LIST);
        charArrayBuffer.append(Integer.toString(this.lowerBound));
        charArrayBuffer.append((char) Typography.greater);
        charArrayBuffer.append(Integer.toString(this.pos));
        charArrayBuffer.append((char) Typography.greater);
        charArrayBuffer.append(Integer.toString(this.upperBound));
        charArrayBuffer.append((char) AbstractJsonLexerKt.END_LIST);
        return charArrayBuffer.toString();
    }
}
