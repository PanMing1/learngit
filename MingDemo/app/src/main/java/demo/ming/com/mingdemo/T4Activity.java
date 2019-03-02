package demo.ming.com.mingdemo;

import android.os.Bundle;
import android.app.Activity;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;

import java.util.Date;

public class T4Activity extends Activity implements View.OnClickListener, View.OnLongClickListener {
    private TextView t1;
    private TextView t2;
    private String[] s1 = {"你吃饭了吗？", "今天天气真好呀。",
            "我中奖啦！", "我们去看电影吧", "晚上干什么好呢？"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t4);
        t1 = findViewById(R.id.t4_t_1);
        t2 = findViewById(R.id.t4_t_2);
        t1.setOnClickListener(this);
        t1.setOnLongClickListener(this);
        t2.setOnClickListener(this);
        t2.setOnLongClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.t4_t_1 || v.getId() == R.id.t4_t_2){
            int r1 = (int) (Math.random() * 10) % 5;
            String s2 = String.format("%s/n%s %s", t2.getText().toString());
        }
    }

    @Override
    public boolean onLongClick(View v) {
        if (v.getId() == R.id.t4_t_1){

        }
        return false;
    }
}
