package androidx.media3.extractor.text.subrip;

import androidx.media3.common.text.Cue;
import androidx.media3.common.util.Assertions;
import androidx.media3.common.util.Util;
import androidx.media3.extractor.text.Subtitle;
import java.util.Collections;
import java.util.List;

final class SubripSubtitle implements Subtitle {
    private final long[] cueTimesUs;
    private final Cue[] cues;

    public SubripSubtitle(Cue[] cueArr, long[] jArr) {
        this.cues = cueArr;
        this.cueTimesUs = jArr;
    }

    public int getNextEventTimeIndex(long j) {
        int binarySearchCeil = Util.binarySearchCeil(this.cueTimesUs, j, false, false);
        if (binarySearchCeil < this.cueTimesUs.length) {
            return binarySearchCeil;
        }
        return -1;
    }

    public int getEventTimeCount() {
        return this.cueTimesUs.length;
    }

    public long getEventTime(int i) {
        boolean z = true;
        Assertions.checkArgument(i >= 0);
        if (i >= this.cueTimesUs.length) {
            z = false;
        }
        Assertions.checkArgument(z);
        return this.cueTimesUs[i];
    }

    public List<Cue> getCues(long j) {
        int binarySearchFloor = Util.binarySearchFloor(this.cueTimesUs, j, true, false);
        if (binarySearchFloor == -1 || this.cues[binarySearchFloor] == Cue.EMPTY) {
            return Collections.emptyList();
        }
        return Collections.singletonList(this.cues[binarySearchFloor]);
    }
}