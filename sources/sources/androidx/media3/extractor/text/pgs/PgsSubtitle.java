package androidx.media3.extractor.text.pgs;

import androidx.media3.common.text.Cue;
import androidx.media3.extractor.text.Subtitle;
import java.util.List;

final class PgsSubtitle implements Subtitle {
    private final List<Cue> cues;

    public long getEventTime(int i) {
        return 0;
    }

    public int getEventTimeCount() {
        return 1;
    }

    public int getNextEventTimeIndex(long j) {
        return -1;
    }

    public PgsSubtitle(List<Cue> list) {
        this.cues = list;
    }

    public List<Cue> getCues(long j) {
        return this.cues;
    }
}
