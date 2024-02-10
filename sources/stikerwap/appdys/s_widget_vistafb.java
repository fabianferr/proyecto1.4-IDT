package stikerwap.appdys;

import android.content.Intent;
import android.widget.RemoteViewsService;

public class s_widget_vistafb extends RemoteViewsService {
    public RemoteViewsService.RemoteViewsFactory onGetViewFactory(Intent intent) {
        return new vistafbRemoteViewsFactory(getApplicationContext(), intent);
    }
}
