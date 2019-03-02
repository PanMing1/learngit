package demo.ming.com.mingdemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
/*
* 跑马灯
* */

public class T1Activity extends Activity implements View.OnClickListener {
    private TextView t1;
    private boolean boo1 = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t1);
        t1 = findViewById(R.id.t_t_1);
        t1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.t_t_1){
            boo1 = !boo1;
            if (boo1){
                t1.setFocusable(false);
                t1.setFocusableInTouchMode(false);
            }else {
                t1.setFocusable(true);
                t1.setFocusableInTouchMode(true);
            }
        }
    }
}
