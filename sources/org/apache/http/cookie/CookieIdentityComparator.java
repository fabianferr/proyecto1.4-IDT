package org.apache.http.cookie;

import java.io.Serializable;
import java.util.Comparator;

public class CookieIdentityComparator implements Serializable, Comparator<Cookie> {
    private static final long serialVersionUID = 4466565437490631532L;

    public int compare(Cookie cookie, Cookie cookie2) {
        int compareTo = cookie.getName().compareTo(cookie2.getName());
        if (compareTo == 0) {
            String domain = cookie.getDomain();
            String str = "";
            if (domain == null) {
                domain = str;
            } else if (domain.indexOf(46) == -1) {
                domain = domain + ".local";
            }
            String domain2 = cookie2.getDomain();
            if (domain2 != null) {
                if (domain2.indexOf(46) == -1) {
                    str = domain2 + ".local";
                } else {
                    str = domain2;
                }
            }
            compareTo = domain.compareToIgnoreCase(str);
        }
        if (compareTo != 0) {
            return compareTo;
        }
        String path = cookie.getPath();
        String str2 = "/";
        if (path == null) {
            path = str2;
        }
        String path2 = cookie2.getPath();
        if (path2 != null) {
            str2 = path2;
        }
        return path.compareTo(str2);
    }
}
