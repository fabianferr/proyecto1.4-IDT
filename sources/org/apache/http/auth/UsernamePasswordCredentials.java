package org.apache.http.auth;

import java.io.Serializable;
import java.security.Principal;
import org.apache.http.util.LangUtils;

public class UsernamePasswordCredentials implements Credentials, Serializable {
    private static final long serialVersionUID = 243343858802739403L;
    private final String password;
    private final BasicUserPrincipal principal;

    public UsernamePasswordCredentials(String str) {
        if (str != null) {
            int indexOf = str.indexOf(58);
            if (indexOf >= 0) {
                this.principal = new BasicUserPrincipal(str.substring(0, indexOf));
                this.password = str.substring(indexOf + 1);
                return;
            }
            this.principal = new BasicUserPrincipal(str);
            this.password = null;
            return;
        }
        throw new IllegalArgumentException("Username:password string may not be null");
    }

    public UsernamePasswordCredentials(String str, String str2) {
        if (str != null) {
            this.principal = new BasicUserPrincipal(str);
            this.password = str2;
            return;
        }
        throw new IllegalArgumentException("Username may not be null");
    }

    public Principal getUserPrincipal() {
        return this.principal;
    }

    public String getUserName() {
        return this.principal.getName();
    }

    public String getPassword() {
        return this.password;
    }

    public int hashCode() {
        return this.principal.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UsernamePasswordCredentials) || !LangUtils.equals((Object) this.principal, (Object) ((UsernamePasswordCredentials) obj).principal)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return this.principal.toString();
    }
}
