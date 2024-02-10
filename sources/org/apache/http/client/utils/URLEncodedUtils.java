package org.apache.http.client.utils;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

public class URLEncodedUtils {
    public static final String CONTENT_TYPE = "application/x-www-form-urlencoded";
    private static final String NAME_VALUE_SEPARATOR = "=";
    private static final String PARAMETER_SEPARATOR = "&";

    public static List<NameValuePair> parse(URI uri, String str) {
        List<NameValuePair> emptyList = Collections.emptyList();
        String rawQuery = uri.getRawQuery();
        if (rawQuery == null || rawQuery.length() <= 0) {
            return emptyList;
        }
        ArrayList arrayList = new ArrayList();
        parse(arrayList, new Scanner(rawQuery), str);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List<org.apache.http.NameValuePair> parse(org.apache.http.HttpEntity r5) throws java.io.IOException {
        /*
            java.util.List r0 = java.util.Collections.emptyList()
            org.apache.http.Header r1 = r5.getContentType()
            r2 = 0
            if (r1 == 0) goto L_0x0028
            org.apache.http.HeaderElement[] r1 = r1.getElements()
            int r3 = r1.length
            if (r3 <= 0) goto L_0x0028
            r3 = 0
            r1 = r1[r3]
            java.lang.String r3 = r1.getName()
            java.lang.String r4 = "charset"
            org.apache.http.NameValuePair r1 = r1.getParameterByName(r4)
            if (r1 == 0) goto L_0x0025
            java.lang.String r2 = r1.getValue()
        L_0x0025:
            r1 = r2
            r2 = r3
            goto L_0x0029
        L_0x0028:
            r1 = r2
        L_0x0029:
            if (r2 == 0) goto L_0x004e
            java.lang.String r3 = "application/x-www-form-urlencoded"
            boolean r2 = r2.equalsIgnoreCase(r3)
            if (r2 == 0) goto L_0x004e
            java.lang.String r2 = "ASCII"
            java.lang.String r5 = org.apache.http.util.EntityUtils.toString(r5, r2)
            if (r5 == 0) goto L_0x004e
            int r2 = r5.length()
            if (r2 <= 0) goto L_0x004e
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.Scanner r2 = new java.util.Scanner
            r2.<init>(r5)
            parse(r0, r2, r1)
        L_0x004e:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.http.client.utils.URLEncodedUtils.parse(org.apache.http.HttpEntity):java.util.List");
    }

    public static boolean isEncoded(HttpEntity httpEntity) {
        Header contentType = httpEntity.getContentType();
        if (contentType != null) {
            HeaderElement[] elements = contentType.getElements();
            if (elements.length > 0) {
                return elements[0].getName().equalsIgnoreCase("application/x-www-form-urlencoded");
            }
        }
        return false;
    }

    public static void parse(List<NameValuePair> list, Scanner scanner, String str) {
        scanner.useDelimiter(PARAMETER_SEPARATOR);
        while (scanner.hasNext()) {
            String[] split = scanner.next().split(NAME_VALUE_SEPARATOR);
            if (split.length == 0 || split.length > 2) {
                throw new IllegalArgumentException("bad parameter");
            }
            list.add(new BasicNameValuePair(decode(split[0], str), split.length == 2 ? decode(split[1], str) : null));
        }
    }

    public static String format(List<? extends NameValuePair> list, String str) {
        StringBuilder sb = new StringBuilder();
        for (NameValuePair nameValuePair : list) {
            String encode = encode(nameValuePair.getName(), str);
            String value = nameValuePair.getValue();
            String encode2 = value != null ? encode(value, str) : "";
            if (sb.length() > 0) {
                sb.append(PARAMETER_SEPARATOR);
            }
            sb.append(encode);
            sb.append(NAME_VALUE_SEPARATOR);
            sb.append(encode2);
        }
        return sb.toString();
    }

    private static String decode(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLDecoder.decode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    private static String encode(String str, String str2) {
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        try {
            return URLEncoder.encode(str, str2);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
