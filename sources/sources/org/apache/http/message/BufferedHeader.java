package org.apache.http.message;

import java.io.Serializable;
import org.apache.http.FormattedHeader;
import org.apache.http.HeaderElement;
import org.apache.http.ParseException;
import org.apache.http.util.CharArrayBuffer;

public class BufferedHeader implements FormattedHeader, Cloneable, Serializable {
    private static final long serialVersionUID = -2768352615787625448L;
    private final CharArrayBuffer buffer;
    private final String name;
    private final int valuePos;

    public BufferedHeader(CharArrayBuffer charArrayBuffer) throws ParseException {
        if (charArrayBuffer != null) {
            int indexOf = charArrayBuffer.indexOf(58);
            if (indexOf != -1) {
                String substringTrimmed = charArrayBuffer.substringTrimmed(0, indexOf);
                if (substringTrimmed.length() != 0) {
                    this.buffer = charArrayBuffer;
                    this.name = substringTrimmed;
                    this.valuePos = indexOf + 1;
                    return;
                }
                throw new ParseException(new StringBuffer("Invalid header: ").append(charArrayBuffer.toString()).toString());
            }
            throw new ParseException(new StringBuffer("Invalid header: ").append(charArrayBuffer.toString()).toString());
        }
        throw new IllegalArgumentException("Char array buffer may not be null");
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        CharArrayBuffer charArrayBuffer = this.buffer;
        return charArrayBuffer.substringTrimmed(this.valuePos, charArrayBuffer.length());
    }

    public HeaderElement[] getElements() throws ParseException {
        ParserCursor parserCursor = new ParserCursor(0, this.buffer.length());
        parserCursor.updatePos(this.valuePos);
        return BasicHeaderValueParser.DEFAULT.parseElements(this.buffer, parserCursor);
    }

    public int getValuePos() {
        return this.valuePos;
    }

    public CharArrayBuffer getBuffer() {
        return this.buffer;
    }

    public String toString() {
        return this.buffer.toString();
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
