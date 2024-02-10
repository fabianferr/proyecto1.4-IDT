package org.apache.http.impl.entity;

import org.apache.http.Header;
import org.apache.http.HttpException;
import org.apache.http.HttpMessage;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolException;
import org.apache.http.entity.ContentLengthStrategy;
import org.apache.http.protocol.HTTP;

public class StrictContentLengthStrategy implements ContentLengthStrategy {
    public long determineLength(HttpMessage httpMessage) throws HttpException {
        if (httpMessage != null) {
            Header firstHeader = httpMessage.getFirstHeader("Transfer-Encoding");
            Header firstHeader2 = httpMessage.getFirstHeader("Content-Length");
            if (firstHeader != null) {
                String value = firstHeader.getValue();
                if (HTTP.CHUNK_CODING.equalsIgnoreCase(value)) {
                    if (!httpMessage.getProtocolVersion().lessEquals(HttpVersion.HTTP_1_0)) {
                        return -2;
                    }
                    throw new ProtocolException(new StringBuffer("Chunked transfer encoding not allowed for ").append(httpMessage.getProtocolVersion()).toString());
                } else if (HTTP.IDENTITY_CODING.equalsIgnoreCase(value)) {
                    return -1;
                } else {
                    throw new ProtocolException(new StringBuffer("Unsupported transfer encoding: ").append(value).toString());
                }
            } else if (firstHeader2 == null) {
                return -1;
            } else {
                String value2 = firstHeader2.getValue();
                try {
                    return Long.parseLong(value2);
                } catch (NumberFormatException unused) {
                    throw new ProtocolException(new StringBuffer("Invalid content length: ").append(value2).toString());
                }
            }
        } else {
            throw new IllegalArgumentException("HTTP message may not be null");
        }
    }
}
