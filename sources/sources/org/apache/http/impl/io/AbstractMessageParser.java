package org.apache.http.impl.io;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.ParseException;
import org.apache.http.ProtocolException;
import org.apache.http.io.HttpMessageParser;
import org.apache.http.io.SessionInputBuffer;
import org.apache.http.message.BasicLineParser;
import org.apache.http.message.LineParser;
import org.apache.http.params.CoreConnectionPNames;
import org.apache.http.params.HttpParams;
import org.apache.http.util.CharArrayBuffer;

public abstract class AbstractMessageParser implements HttpMessageParser {
    private static final int HEADERS = 1;
    private static final int HEAD_LINE = 0;
    private final List headerLines;
    protected final LineParser lineParser;
    private final int maxHeaderCount;
    private final int maxLineLen;
    private HttpMessage message;
    private final SessionInputBuffer sessionBuffer;
    private int state;

    /* access modifiers changed from: protected */
    public abstract HttpMessage parseHead(SessionInputBuffer sessionInputBuffer) throws IOException, HttpException, ParseException;

    public AbstractMessageParser(SessionInputBuffer sessionInputBuffer, LineParser lineParser2, HttpParams httpParams) {
        if (sessionInputBuffer == null) {
            throw new IllegalArgumentException("Session input buffer may not be null");
        } else if (httpParams != null) {
            this.sessionBuffer = sessionInputBuffer;
            this.maxHeaderCount = httpParams.getIntParameter(CoreConnectionPNames.MAX_HEADER_COUNT, -1);
            this.maxLineLen = httpParams.getIntParameter(CoreConnectionPNames.MAX_LINE_LENGTH, -1);
            this.lineParser = lineParser2 == null ? BasicLineParser.DEFAULT : lineParser2;
            this.headerLines = new ArrayList();
            this.state = 0;
        } else {
            throw new IllegalArgumentException("HTTP parameters may not be null");
        }
    }

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer, int i, int i2, LineParser lineParser2) throws HttpException, IOException {
        if (lineParser2 == null) {
            lineParser2 = BasicLineParser.DEFAULT;
        }
        return parseHeaders(sessionInputBuffer, i, i2, lineParser2, new ArrayList());
    }

    public static Header[] parseHeaders(SessionInputBuffer sessionInputBuffer, int i, int i2, LineParser lineParser2, List list) throws HttpException, IOException {
        int i3;
        if (sessionInputBuffer == null) {
            throw new IllegalArgumentException("Session input buffer may not be null");
        } else if (lineParser2 == null) {
            throw new IllegalArgumentException("Line parser may not be null");
        } else if (list != null) {
            CharArrayBuffer charArrayBuffer = null;
            CharArrayBuffer charArrayBuffer2 = null;
            while (true) {
                if (charArrayBuffer == null) {
                    charArrayBuffer = new CharArrayBuffer(64);
                } else {
                    charArrayBuffer.clear();
                }
                i3 = 0;
                if (sessionInputBuffer.readLine(charArrayBuffer) == -1 || charArrayBuffer.length() < 1) {
                    Header[] headerArr = new Header[list.size()];
                } else {
                    if ((charArrayBuffer.charAt(0) == ' ' || charArrayBuffer.charAt(0) == 9) && charArrayBuffer2 != null) {
                        while (i3 < charArrayBuffer.length() && ((r3 = charArrayBuffer.charAt(i3)) == ' ' || r3 == 9)) {
                            i3++;
                        }
                        if (i2 <= 0 || ((charArrayBuffer2.length() + 1) + charArrayBuffer.length()) - i3 <= i2) {
                            charArrayBuffer2.append(' ');
                            charArrayBuffer2.append(charArrayBuffer, i3, charArrayBuffer.length() - i3);
                        } else {
                            throw new IOException("Maximum line length limit exceeded");
                        }
                    } else {
                        list.add(charArrayBuffer);
                        charArrayBuffer2 = charArrayBuffer;
                        charArrayBuffer = null;
                    }
                    if (i > 0 && list.size() >= i) {
                        throw new IOException("Maximum header count exceeded");
                    }
                }
            }
            Header[] headerArr2 = new Header[list.size()];
            while (i3 < list.size()) {
                try {
                    headerArr2[i3] = lineParser2.parseHeader((CharArrayBuffer) list.get(i3));
                    i3++;
                } catch (ParseException e) {
                    throw new ProtocolException(e.getMessage());
                }
            }
            return headerArr2;
        } else {
            throw new IllegalArgumentException("Header line list may not be null");
        }
    }

    public HttpMessage parse() throws IOException, HttpException {
        int i = this.state;
        if (i == 0) {
            try {
                this.message = parseHead(this.sessionBuffer);
                this.state = 1;
            } catch (ParseException e) {
                throw new ProtocolException(e.getMessage(), e);
            }
        } else if (i != 1) {
            throw new IllegalStateException("Inconsistent parser state");
        }
        this.message.setHeaders(parseHeaders(this.sessionBuffer, this.maxHeaderCount, this.maxLineLen, this.lineParser, this.headerLines));
        HttpMessage httpMessage = this.message;
        this.message = null;
        this.headerLines.clear();
        this.state = 0;
        return httpMessage;
    }
}
