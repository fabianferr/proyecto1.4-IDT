package androidx.core.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.android.tools.r8.annotations.SynthesizedClassV2;

public interface MenuProvider {

    @SynthesizedClassV2(kind = 8, versionHash = "7a5b85d3ee2e0991ca3502602e9389a98f55c0576b887125894a7ec03823f8d3")
    /* renamed from: androidx.core.view.MenuProvider$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static void $default$onMenuClosed(MenuProvider _this, Menu menu) {
        }

        public static void $default$onPrepareMenu(MenuProvider _this, Menu menu) {
        }
    }

    void onCreateMenu(Menu menu, MenuInflater menuInflater);

    void onMenuClosed(Menu menu);

    boolean onMenuItemSelected(MenuItem menuItem);

    void onPrepareMenu(Menu menu);
}
