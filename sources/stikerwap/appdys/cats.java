package stikerwap.appdys;

import android.app.ExpandableListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class cats extends ExpandableListActivity {
    /* access modifiers changed from: private */
    public String[][] children;
    config globales;
    /* access modifiers changed from: private */
    public String[] groups;
    private int[][] ids;
    ExpandableListAdapter mAdapter;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        config config = (config) getApplicationContext();
        this.globales = config;
        if (config.c1 == null) {
            this.globales.recuperar_vars();
        }
        config.aplicar_color_top(this, this.globales.c1);
        SQLiteDatabase readableDatabase = new bd(getApplicationContext()).getReadableDatabase();
        Cursor rawQuery = readableDatabase.rawQuery("SELECT _id,idcat,descr FROM cats WHERE idcat=0 ORDER BY descr", (String[]) null);
        this.groups = new String[rawQuery.getCount()];
        this.children = new String[rawQuery.getCount()][];
        this.ids = new int[rawQuery.getCount()][];
        if (rawQuery.moveToFirst()) {
            while (!rawQuery.isAfterLast()) {
                this.groups[rawQuery.getPosition()] = rawQuery.getString(rawQuery.getColumnIndex("descr"));
                int i = rawQuery.getInt(rawQuery.getColumnIndex("_id"));
                Cursor rawQuery2 = readableDatabase.rawQuery("SELECT _id,idcat,descr FROM cats WHERE idcat=" + i + " ORDER BY descr", (String[]) null);
                String[] strArr = new String[(rawQuery2.getCount() + 1)];
                strArr[0] = getResources().getString(R.string.todo);
                int[] iArr = new int[(rawQuery2.getCount() + 1)];
                iArr[0] = i;
                if (rawQuery2.moveToFirst()) {
                    while (!rawQuery2.isAfterLast()) {
                        strArr[rawQuery2.getPosition() + 1] = rawQuery2.getString(rawQuery2.getColumnIndex("descr"));
                        iArr[rawQuery2.getPosition() + 1] = rawQuery2.getInt(rawQuery2.getColumnIndex("_id"));
                        rawQuery2.moveToNext();
                    }
                }
                rawQuery2.close();
                this.children[rawQuery.getPosition()] = strArr;
                this.ids[rawQuery.getPosition()] = iArr;
                rawQuery.moveToNext();
            }
        }
        rawQuery.close();
        readableDatabase.close();
        if (getResources().getBoolean(R.bool.es_rtl)) {
            getExpandableListView().setTextDirection(4);
        }
        MyExpandableListAdapter myExpandableListAdapter = new MyExpandableListAdapter();
        this.mAdapter = myExpandableListAdapter;
        setListAdapter(myExpandableListAdapter);
    }

    public boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        Intent intent = new Intent();
        intent.putExtra("idcat", this.ids[i][i2]);
        if (i2 == 0) {
            intent.putExtra("cat", this.groups[i]);
        } else {
            intent.putExtra("cat", this.children[i][i2]);
        }
        setResult(-1, intent);
        finish();
        return true;
    }

    public class MyExpandableListAdapter extends BaseExpandableListAdapter {
        public long getChildId(int i, int i2) {
            return (long) i2;
        }

        public long getGroupId(int i) {
            return (long) i;
        }

        public boolean hasStableIds() {
            return true;
        }

        public boolean isChildSelectable(int i, int i2) {
            return true;
        }

        public MyExpandableListAdapter() {
        }

        public Object getChild(int i, int i2) {
            return cats.this.children[i][i2];
        }

        public int getChildrenCount(int i) {
            return cats.this.children[i].length;
        }

        public TextView getGenericView() {
            AbsListView.LayoutParams layoutParams = new AbsListView.LayoutParams(-1, 64);
            TextView textView = new TextView(cats.this);
            textView.setLayoutParams(layoutParams);
            textView.setGravity(8388627);
            if (cats.this.getResources().getBoolean(R.bool.es_rtl)) {
                textView.setTextDirection(4);
            }
            textView.setPadding(80, 0, 80, 0);
            return textView;
        }

        public View getChildView(int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            TextView genericView = getGenericView();
            genericView.setText(getChild(i, i2).toString());
            return genericView;
        }

        public Object getGroup(int i) {
            return cats.this.groups[i];
        }

        public int getGroupCount() {
            return cats.this.groups.length;
        }

        public View getGroupView(int i, boolean z, View view, ViewGroup viewGroup) {
            TextView genericView = getGenericView();
            genericView.setText(getGroup(i).toString());
            return genericView;
        }
    }
}
