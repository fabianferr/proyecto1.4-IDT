package org.apache.http.params;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class BasicHttpParams extends AbstractHttpParams implements Serializable, Cloneable {
    private static final long serialVersionUID = -7086398485908701455L;
    private final HashMap parameters = new HashMap();

    public Object getParameter(String str) {
        return this.parameters.get(str);
    }

    public HttpParams setParameter(String str, Object obj) {
        this.parameters.put(str, obj);
        return this;
    }

    public boolean removeParameter(String str) {
        if (!this.parameters.containsKey(str)) {
            return false;
        }
        this.parameters.remove(str);
        return true;
    }

    public void setParameters(String[] strArr, Object obj) {
        for (String parameter : strArr) {
            setParameter(parameter, obj);
        }
    }

    public boolean isParameterSet(String str) {
        return getParameter(str) != null;
    }

    public boolean isParameterSetLocally(String str) {
        return this.parameters.get(str) != null;
    }

    public void clear() {
        this.parameters.clear();
    }

    public HttpParams copy() {
        try {
            return (HttpParams) clone();
        } catch (CloneNotSupportedException unused) {
            throw new UnsupportedOperationException("Cloning not supported");
        }
    }

    public Object clone() throws CloneNotSupportedException {
        BasicHttpParams basicHttpParams = (BasicHttpParams) super.clone();
        copyParams(basicHttpParams);
        return basicHttpParams;
    }

    /* access modifiers changed from: protected */
    public void copyParams(HttpParams httpParams) {
        for (Map.Entry entry : this.parameters.entrySet()) {
            if (entry.getKey() instanceof String) {
                httpParams.setParameter((String) entry.getKey(), entry.getValue());
            }
        }
    }
}
