package androidx.webkit.internal;

import androidx.webkit.WebMessageCompat;
import org.chromium.support_lib_boundary.WebMessagePayloadBoundaryInterface;

public class WebMessagePayloadAdapter implements WebMessagePayloadBoundaryInterface {
    private final WebMessageCompat mMessageCompat;

    public String[] getSupportedFeatures() {
        return new String[0];
    }

    public WebMessagePayloadAdapter(WebMessageCompat webMessageCompat) {
        this.mMessageCompat = webMessageCompat;
    }

    public int getType() {
        int type = this.mMessageCompat.getType();
        if (type == 0) {
            return 0;
        }
        if (type == 1) {
            return 1;
        }
        throw WebViewFeatureInternal.getUnsupportedOperationException();
    }

    public String getAsString() {
        return this.mMessageCompat.getData();
    }

    public byte[] getAsArrayBuffer() {
        return this.mMessageCompat.getArrayBuffer();
    }
}
