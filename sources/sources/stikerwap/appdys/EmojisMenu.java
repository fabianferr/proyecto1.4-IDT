package stikerwap.appdys;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.view.ViewCompat;

public class EmojisMenu extends Dialog implements View.OnClickListener {
    Context c;
    private EditText et;

    public EmojisMenu(EditText editText, Context context) {
        super(context);
        this.et = editText;
        this.c = context;
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        requestWindowFeature(1);
        setContentView(R.layout.emojis);
        getWindow().setBackgroundDrawable(new ColorDrawable(0));
        int[] iArr = {128512, 128513, 128514, 128515, 128516, 128517, 128518, 128521, 128522, 128523, 128526, 128525, 128536, 128529, 128566, 128547, 128549, 128558, 128559, 128554, 128555, 128564, 128524, 128539, 128540, 128541, 128530, 128533, 128562, 128534, 128542, 128536, 128543, 128548, 128546, 128557, 128550, 128551, 128552, 128553, 128556, 128560, 128561, 128563, 128565, 128545, 128544, 128567, 128519, 128520, 128127, 128121, 128122, 128128, 128123, 128125, 128126, 128586, 128584, 128585, 128116, 128117, 128104, 128105, 128084, 128110, 128130, 128119, 128120, 128112, 128124, 128118, 128694, 127939, 128131, 128111, 128107, 128143, 128106, 127968, 128072, 128073, 128070, 128071, 9757, 9996, 128076, 128170, 128077, 128078, 9994, 128074, 128075, 128079, 128588, 128591, 128066, 128069, 128064, 128139, 128149, 128152, 10084, 128148, 128166, 128168, 127769, 9728, 128054, 128052, 128014, 128055, 128017, 128024, 128048, 128020, 128035, 128056, 128034, 128051, 128044, 128031, 128012, 128029, 127801, 127804, 127796, 127808, 127828, 127831, 127829, 127848, 127849, 127874, 127856, 127853, 128663, 128690, 128674, 9992, 128640, 8986, 9200, 8987, 9924, 127877, 127875, 127876, 127881, 127882, 127886, 127873, 127926, 127908, 127911, 128251, 127942, 128176, 128184, 128179, 9917, 9918, 127936, 127944, 127934, 9971, 127938, 127946, 127927, 127928, 127929, 127930};
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.ll_emojis);
        int dp_to_px = config.dp_to_px(this.c, 10);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        LinearLayout linearLayout2 = null;
        int i = 0;
        for (int i2 = 0; i2 < 172; i2++) {
            int i3 = iArr[i2];
            i++;
            if (i == 1) {
                linearLayout2 = new LinearLayout(this.c);
                linearLayout2.setBackgroundColor(Color.parseColor("#dddddd"));
                linearLayout2.setPadding(dp_to_px, dp_to_px, dp_to_px, dp_to_px);
                linearLayout2.setLayoutParams(layoutParams);
            }
            TextView textView = new TextView(this.c);
            textView.setLayoutParams(layoutParams2);
            textView.setPadding(dp_to_px, dp_to_px, dp_to_px, dp_to_px);
            textView.setTextColor(ViewCompat.MEASURED_STATE_MASK);
            textView.setTextSize(24.0f);
            textView.setText(new String(Character.toChars(i3)));
            textView.setTag(Integer.valueOf(i3));
            textView.setOnClickListener(this);
            linearLayout2.addView(textView);
            if (i == 4) {
                linearLayout.addView(linearLayout2);
                i = 0;
            }
        }
        if (i > 0) {
            linearLayout.addView(linearLayout2);
        }
    }

    public void onClick(View view) {
        int intValue = ((Integer) view.getTag()).intValue();
        if (intValue != 0) {
            int max = Math.max(this.et.getSelectionStart(), 0);
            int max2 = Math.max(this.et.getSelectionEnd(), 0);
            String str = new String(Character.toChars(intValue));
            this.et.getText().replace(Math.min(max, max2), Math.max(max, max2), str, 0, str.length());
        }
        dismiss();
    }
}
