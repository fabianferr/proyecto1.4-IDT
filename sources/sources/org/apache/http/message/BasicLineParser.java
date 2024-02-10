package org.apache.http.message;

import org.apache.http.Header;
import org.apache.http.HttpVersion;
import org.apache.http.ParseException;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.StatusLine;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.CharArrayBuffer;

public class BasicLineParser implements LineParser {
    public static final BasicLineParser DEFAULT = new BasicLineParser();
    protected final ProtocolVersion protocol;

    public BasicLineParser(ProtocolVersion protocolVersion) {
        this.protocol = protocolVersion == null ? HttpVersion.HTTP_1_1 : protocolVersion;
    }

    public BasicLineParser() {
        this((ProtocolVersion) null);
    }

    public static final ProtocolVersion parseProtocolVersion(String str, LineParser lineParser) throws ParseException {
        if (str != null) {
            if (lineParser == null) {
                lineParser = DEFAULT;
            }
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
            charArrayBuffer.append(str);
            return lineParser.parseProtocolVersion(charArrayBuffer, new ParserCursor(0, str.length()));
        }
        throw new IllegalArgumentException("Value to parse may not be null.");
    }

    public ProtocolVersion parseProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        if (charArrayBuffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        } else if (parserCursor != null) {
            String protocol2 = this.protocol.getProtocol();
            int length = protocol2.length();
            int pos = parserCursor.getPos();
            int upperBound = parserCursor.getUpperBound();
            skipWhitespace(charArrayBuffer, parserCursor);
            int pos2 = parserCursor.getPos();
            int i = pos2 + length;
            if (i + 4 <= upperBound) {
                boolean z = false;
                boolean z2 = true;
                int i2 = 0;
                while (z2 && i2 < length) {
                    z2 = charArrayBuffer.charAt(pos2 + i2) == protocol2.charAt(i2);
                    i2++;
                }
                if (z2) {
                    if (charArrayBuffer.charAt(i) == '/') {
                        z = true;
                    }
                    z2 = z;
                }
                if (z2) {
                    int i3 = pos2 + length + 1;
                    int indexOf = charArrayBuffer.indexOf(46, i3, upperBound);
                    if (indexOf != -1) {
                        try {
                            int parseInt = Integer.parseInt(charArrayBuffer.substringTrimmed(i3, indexOf));
                            int i4 = indexOf + 1;
                            int indexOf2 = charArrayBuffer.indexOf(32, i4, upperBound);
                            if (indexOf2 == -1) {
                                indexOf2 = upperBound;
                            }
                            try {
                                int parseInt2 = Integer.parseInt(charArrayBuffer.substringTrimmed(i4, indexOf2));
                                parserCursor.updatePos(indexOf2);
                                return createProtocolVersion(parseInt, parseInt2);
                            } catch (NumberFormatException unused) {
                                throw new ParseException(new StringBuffer("Invalid protocol minor version number: ").append(charArrayBuffer.substring(pos, upperBound)).toString());
                            }
                        } catch (NumberFormatException unused2) {
                            throw new ParseException(new StringBuffer("Invalid protocol major version number: ").append(charArrayBuffer.substring(pos, upperBound)).toString());
                        }
                    } else {
                        throw new ParseException(new StringBuffer("Invalid protocol version number: ").append(charArrayBuffer.substring(pos, upperBound)).toString());
                    }
                } else {
                    throw new ParseException(new StringBuffer("Not a valid protocol version: ").append(charArrayBuffer.substring(pos, upperBound)).toString());
                }
            } else {
                throw new ParseException(new StringBuffer("Not a valid protocol version: ").append(charArrayBuffer.substring(pos, upperBound)).toString());
            }
        } else {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }
    }

    /* access modifiers changed from: protected */
    public ProtocolVersion createProtocolVersion(int i, int i2) {
        return this.protocol.forVersion(i, i2);
    }

    public boolean hasProtocolVersion(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        if (charArrayBuffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        } else if (parserCursor != null) {
            int pos = parserCursor.getPos();
            String protocol2 = this.protocol.getProtocol();
            int length = protocol2.length();
            boolean z = false;
            if (charArrayBuffer.length() < length + 4) {
                return false;
            }
            if (pos < 0) {
                pos = (charArrayBuffer.length() - 4) - length;
            } else if (pos == 0) {
                while (pos < charArrayBuffer.length() && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
                    pos++;
                }
            }
            int i = pos + length;
            if (i + 4 > charArrayBuffer.length()) {
                return false;
            }
            boolean z2 = true;
            int i2 = 0;
            while (z2 && i2 < length) {
                z2 = charArrayBuffer.charAt(pos + i2) == protocol2.charAt(i2);
                i2++;
            }
            if (!z2) {
                return z2;
            }
            if (charArrayBuffer.charAt(i) == '/') {
                z = true;
            }
            return z;
        } else {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }
    }

    public static final RequestLine parseRequestLine(String str, LineParser lineParser) throws ParseException {
        if (str != null) {
            if (lineParser == null) {
                lineParser = DEFAULT;
            }
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
            charArrayBuffer.append(str);
            return lineParser.parseRequestLine(charArrayBuffer, new ParserCursor(0, str.length()));
        }
        throw new IllegalArgumentException("Value to parse may not be null.");
    }

    public RequestLine parseRequestLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        if (charArrayBuffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        } else if (parserCursor != null) {
            int pos = parserCursor.getPos();
            int upperBound = parserCursor.getUpperBound();
            try {
                skipWhitespace(charArrayBuffer, parserCursor);
                int pos2 = parserCursor.getPos();
                int indexOf = charArrayBuffer.indexOf(32, pos2, upperBound);
                if (indexOf >= 0) {
                    String substringTrimmed = charArrayBuffer.substringTrimmed(pos2, indexOf);
                    parserCursor.updatePos(indexOf);
                    skipWhitespace(charArrayBuffer, parserCursor);
                    int pos3 = parserCursor.getPos();
                    int indexOf2 = charArrayBuffer.indexOf(32, pos3, upperBound);
                    if (indexOf2 >= 0) {
                        String substringTrimmed2 = charArrayBuffer.substringTrimmed(pos3, indexOf2);
                        parserCursor.updatePos(indexOf2);
                        ProtocolVersion parseProtocolVersion = parseProtocolVersion(charArrayBuffer, parserCursor);
                        skipWhitespace(charArrayBuffer, parserCursor);
                        if (parserCursor.atEnd()) {
                            return createRequestLine(substringTrimmed, substringTrimmed2, parseProtocolVersion);
                        }
                        throw new ParseException(new StringBuffer("Invalid request line: ").append(charArrayBuffer.substring(pos, upperBound)).toString());
                    }
                    throw new ParseException(new StringBuffer("Invalid request line: ").append(charArrayBuffer.substring(pos, upperBound)).toString());
                }
                throw new ParseException(new StringBuffer("Invalid request line: ").append(charArrayBuffer.substring(pos, upperBound)).toString());
            } catch (IndexOutOfBoundsException unused) {
                throw new ParseException(new StringBuffer("Invalid request line: ").append(charArrayBuffer.substring(pos, upperBound)).toString());
            }
        } else {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }
    }

    /* access modifiers changed from: protected */
    public RequestLine createRequestLine(String str, String str2, ProtocolVersion protocolVersion) {
        return new BasicRequestLine(str, str2, protocolVersion);
    }

    public static final StatusLine parseStatusLine(String str, LineParser lineParser) throws ParseException {
        if (str != null) {
            if (lineParser == null) {
                lineParser = DEFAULT;
            }
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
            charArrayBuffer.append(str);
            return lineParser.parseStatusLine(charArrayBuffer, new ParserCursor(0, str.length()));
        }
        throw new IllegalArgumentException("Value to parse may not be null.");
    }

    public StatusLine parseStatusLine(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) throws ParseException {
        if (charArrayBuffer == null) {
            throw new IllegalArgumentException("Char array buffer may not be null");
        } else if (parserCursor != null) {
            int pos = parserCursor.getPos();
            int upperBound = parserCursor.getUpperBound();
            try {
                ProtocolVersion parseProtocolVersion = parseProtocolVersion(charArrayBuffer, parserCursor);
                skipWhitespace(charArrayBuffer, parserCursor);
                int pos2 = parserCursor.getPos();
                int indexOf = charArrayBuffer.indexOf(32, pos2, upperBound);
                if (indexOf < 0) {
                    indexOf = upperBound;
                }
                String substringTrimmed = charArrayBuffer.substringTrimmed(pos2, indexOf);
                int i = 0;
                while (i < substringTrimmed.length()) {
                    if (Character.isDigit(substringTrimmed.charAt(i))) {
                        i++;
                    } else {
                        throw new ParseException(new StringBuffer().append("Status line contains invalid status code: ").append(charArrayBuffer.substring(pos, upperBound)).toString());
                    }
                }
                return createStatusLine(parseProtocolVersion, Integer.parseInt(substringTrimmed), indexOf < upperBound ? charArrayBuffer.substringTrimmed(indexOf, upperBound) : "");
            } catch (NumberFormatException unused) {
                throw new ParseException(new StringBuffer().append("Status line contains invalid status code: ").append(charArrayBuffer.substring(pos, upperBound)).toString());
            } catch (IndexOutOfBoundsException unused2) {
                throw new ParseException(new StringBuffer("Invalid status line: ").append(charArrayBuffer.substring(pos, upperBound)).toString());
            }
        } else {
            throw new IllegalArgumentException("Parser cursor may not be null");
        }
    }

    /* access modifiers changed from: protected */
    public StatusLine createStatusLine(ProtocolVersion protocolVersion, int i, String str) {
        return new BasicStatusLine(protocolVersion, i, str);
    }

    public static final Header parseHeader(String str, LineParser lineParser) throws ParseException {
        if (str != null) {
            if (lineParser == null) {
                lineParser = DEFAULT;
            }
            CharArrayBuffer charArrayBuffer = new CharArrayBuffer(str.length());
            charArrayBuffer.append(str);
            return lineParser.parseHeader(charArrayBuffer);
        }
        throw new IllegalArgumentException("Value to parse may not be null");
    }

    public Header parseHeader(CharArrayBuffer charArrayBuffer) throws ParseException {
        return new BufferedHeader(charArrayBuffer);
    }

    /* access modifiers changed from: protected */
    public void skipWhitespace(CharArrayBuffer charArrayBuffer, ParserCursor parserCursor) {
        int pos = parserCursor.getPos();
        int upperBound = parserCursor.getUpperBound();
        while (pos < upperBound && HTTP.isWhitespace(charArrayBuffer.charAt(pos))) {
            pos++;
        }
        parserCursor.updatePos(pos);
    }
}
