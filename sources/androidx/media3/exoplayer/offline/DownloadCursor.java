package androidx.media3.exoplayer.offline;

import com.android.tools.r8.annotations.SynthesizedClassV2;
import java.io.Closeable;

public interface DownloadCursor extends Closeable {
    void close();

    int getCount();

    Download getDownload();

    int getPosition();

    boolean isAfterLast();

    boolean isBeforeFirst();

    boolean isClosed();

    boolean isFirst();

    boolean isLast();

    boolean moveToFirst();

    boolean moveToLast();

    boolean moveToNext();

    boolean moveToPosition(int i);

    boolean moveToPrevious();

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: androidx.media3.exoplayer.offline.DownloadCursor$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static boolean $default$moveToFirst(DownloadCursor _this) {
            return _this.moveToPosition(0);
        }

        public static boolean $default$moveToLast(DownloadCursor _this) {
            return _this.moveToPosition(_this.getCount() - 1);
        }

        public static boolean $default$moveToNext(DownloadCursor _this) {
            return _this.moveToPosition(_this.getPosition() + 1);
        }

        public static boolean $default$moveToPrevious(DownloadCursor _this) {
            return _this.moveToPosition(_this.getPosition() - 1);
        }

        public static boolean $default$isFirst(DownloadCursor _this) {
            return _this.getPosition() == 0 && _this.getCount() != 0;
        }

        public static boolean $default$isLast(DownloadCursor _this) {
            int count = _this.getCount();
            return _this.getPosition() == count + -1 && count != 0;
        }

        public static boolean $default$isBeforeFirst(DownloadCursor _this) {
            if (_this.getCount() == 0 || _this.getPosition() == -1) {
                return true;
            }
            return false;
        }

        public static boolean $default$isAfterLast(DownloadCursor _this) {
            if (_this.getCount() == 0 || _this.getPosition() == _this.getCount()) {
                return true;
            }
            return false;
        }
    }
}
