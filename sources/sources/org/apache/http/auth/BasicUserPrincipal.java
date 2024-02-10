package org.apache.http.auth;

import java.io.Serializable;
import java.security.Principal;
import org.apache.http.util.LangUtils;

public final class BasicUserPrincipal implements Principal, Serializable {
    private static final long serialVersionUID = -2266305184969850467L;
    private final String username;

    public BasicUserPrincipal(String str) {
        if (str != null) {
            this.username = str;
            return;
        }
        throw new IllegalArgumentException("User name may not be null");
    }

    public String getName() {
        return this.username;
    }

    public int hashCode() {
        return LangUtils.hashCode(17, (Object) this.username);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BasicUserPrincipal) || !LangUtils.equals((Object) this.username, (Object) ((BasicUserPrincipal) obj).username)) {
            return false;
        }
        return true;
    }

    public String toString() {
        return "[principal: " + this.username + "]";
    }
}
