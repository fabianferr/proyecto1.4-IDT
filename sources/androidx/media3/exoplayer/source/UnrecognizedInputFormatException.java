package androidx.media3.exoplayer.source;

import android.net.Uri;
import androidx.media3.common.ParserException;

public class UnrecognizedInputFormatException extends ParserException {
    public final Uri uri;

    public UnrecognizedInputFormatException(String str, Uri uri2) {
        super(str, (Throwable) null, false, 1);
        this.uri = uri2;
    }
}
