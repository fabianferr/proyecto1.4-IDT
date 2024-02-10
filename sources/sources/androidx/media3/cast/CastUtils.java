package androidx.media3.cast;

import androidx.media3.common.Format;
import androidx.media3.common.util.Util;
import com.google.android.gms.cast.CastStatusCodes;
import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaTrack;

final class CastUtils {
    public static long getStreamDurationUs(MediaInfo mediaInfo) {
        if (mediaInfo == null) {
            return -9223372036854775807L;
        }
        long streamDuration = mediaInfo.getStreamDuration();
        if (streamDuration != -1) {
            return Util.msToUs(streamDuration);
        }
        return -9223372036854775807L;
    }

    public static String getLogString(int i) {
        if (i == 0) {
            return "Success.";
        }
        if (i == 2100) {
            return "The in-progress request failed.";
        }
        if (i == 2103) {
            return "The request's progress is no longer being tracked because another request of the same type has been made before the first request completed.";
        }
        if (i == 7) {
            return "Network I/O error.";
        }
        if (i == 8) {
            return "An internal error has occurred.";
        }
        if (i == 2200) {
            return "The Cast Remote Display service could not be created.";
        }
        if (i == 2201) {
            return "The Cast Remote Display service was disconnected.";
        }
        switch (i) {
            case 13:
                return "An unknown, unexpected error has occurred.";
            case 14:
                return "A blocking call was interrupted while waiting and did not run to completion.";
            case 15:
                return "An operation has timed out.";
            default:
                switch (i) {
                    case 2000:
                        return "Authentication failure.";
                    case 2001:
                        return "An invalid request was made.";
                    case 2002:
                        return "An in-progress request has been canceled, most likely because another action has preempted it.";
                    case 2003:
                        return "The request was disallowed and could not be completed.";
                    case 2004:
                        return "A requested application could not be found.";
                    case 2005:
                        return "A requested application is not currently running.";
                    case 2006:
                        return "A message could not be sent because it is too large.";
                    case 2007:
                        return "A message could not be sent because there is not enough room in the send buffer at this time.";
                    default:
                        return CastStatusCodes.getStatusCodeString(i);
                }
        }
    }

    public static Format mediaTrackToFormat(MediaTrack mediaTrack) {
        return new Format.Builder().setId(mediaTrack.getContentId()).setContainerMimeType(mediaTrack.getContentType()).setLanguage(mediaTrack.getLanguage()).build();
    }

    private CastUtils() {
    }
}
