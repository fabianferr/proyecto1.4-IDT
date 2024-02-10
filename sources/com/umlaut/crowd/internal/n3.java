package com.umlaut.crowd.internal;

public class n3 implements Cloneable {
    public long AppBuildVersion = -1;
    public i AppCategory = i.Unknown;
    public String AppName = "";
    public String AppPackageName = "";
    public j[] AppPermissions = new j[0];
    public k AppStandbyBucket = k.Unknown;
    public int AppTargetVersion = -1;
    public r BackgroundDataRestrictionState = r.Unknown;

    public Object clone() throws CloneNotSupportedException {
        n3 n3Var = (n3) super.clone();
        n3Var.AppPermissions = new j[this.AppPermissions.length];
        int i = 0;
        while (true) {
            j[] jVarArr = this.AppPermissions;
            if (i >= jVarArr.length) {
                return n3Var;
            }
            n3Var.AppPermissions[i] = (j) jVarArr[i].clone();
            i++;
        }
    }
}
