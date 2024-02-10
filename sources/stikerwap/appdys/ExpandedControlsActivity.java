package stikerwap.appdys;

import android.os.Bundle;
import android.view.Menu;
import com.google.android.gms.cast.framework.CastButtonFactory;
import com.google.android.gms.cast.framework.media.widget.ExpandedControllerActivity;

public class ExpandedControlsActivity extends ExpandedControllerActivity {
    public void onCreate(Bundle bundle) {
        setTheme(2131952127);
        super.onCreate(bundle);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.m_cast, menu);
        CastButtonFactory.setUpMediaRouteButton(this, menu, R.id.media_route_menu_item);
        return true;
    }
}
