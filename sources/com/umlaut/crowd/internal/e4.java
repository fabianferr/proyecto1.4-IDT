package com.umlaut.crowd.internal;

import java.io.Serializable;

public class e4 implements Cloneable, Serializable {
    private static final long a = -884736715180732782L;
    public String AutonomousSystemNumber = "";
    public String AutonomousSystemOrganization = "";
    public String IpAddress = "";
    public String IspName = "";
    public String IspOrganizationalName = "";
    public boolean SuccessfulIspLookup = false;
    public b4 ipLocationData = null;

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
