package com.teragence.library;

import android.content.Context;
import android.content.pm.PackageManager;
import com.teragence.client.i;

public class g implements f {
    private final Context a;

    public g(Context context) {
        this.a = context;
    }

    public String toString() {
        try {
            return this.a.getPackageManager().getApplicationInfo(this.a.getPackageName(), 128).metaData.getString("teragencePartnerId");
        } catch (PackageManager.NameNotFoundException e) {
            i.b("OwnerKeyFromMetaData", "Failed to load meta-data, NameNotFound: " + e.getMessage());
            throw new RuntimeException("An 'owner key' must be specify in AndroidManifest.xml as an meta-data tag with name = 'teragencePartnerId' and value of your key", e);
        } catch (NullPointerException e2) {
            i.b("OwnerKeyFromMetaData", "Failed to load meta-data, NullPointer: " + e2.getMessage());
            throw new RuntimeException("An 'owner key' must be specify in AndroidManifest.xml as an meta-data tag with name = 'teragencePartnerId' and value of your key", e2);
        }
    }
}
