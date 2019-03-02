package demo.ming.com.mingdemo;

import android.graphics.Color;
import android.os.Bundle;
import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
* 按钮判断EditText中的内容变化
* */
public class T3Activity extends Activity implements View.OnClickListener {
    private TextView t1;
    private EditText e1;
    private Button t3b1;
    private Button t3b2;
    private Button t3b3;
    private Button t3b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t3);
        t1 = findViewById(R.id.m_t_a);
        t1.setTextColor(Color.GREEN);
        t1.setTextSize(20);
        e1 = findViewById(R.id.m_e_a);
        t3b1 = findViewById(R.id.t3_b_1);
        t3b2 = findViewById(R.id.t3_b_2);
        t3b3 = findViewById(R.id.t3_b_3);
        t3b4 = findViewById(R.id.t3_b_4);
        t3b1.setOnClickListener(this);
        t3b2.setOnClickListener(this);
        t3b3.setOnClickListener(this);
        t3b4.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.t3_b_1) {
            boolean boo1 = TextUtils.isEmpty(e1.getText());
            String s1 = String.format("输入框的内容%s空的", boo1 ? "是" : "不是");
            t1.setText(s1);
        } else if (v.getId() == R.id.t3_b_2) {
            int length = TextUtils.getTrimmedLength(e1.getText());
            String s2 = String.format("去掉空格的长度是%d", length);
            t1.setText(s2);
        } else if (v.getId() == R.id.t3_b_3) {
            boolean boo2 = TextUtils.isDigitsOnly(e1.getText());
            String s3 = String.format("是否全是数字：%s", boo2 ? "是" : "不是");
            t1.setText(s3);
        } else if (v.getId() == R.id.t3_b_4) {
            float f1 = e1.getTextSize() * 3;
            CharSequence cs1 = TextUtils.ellipsize(e1.getText(), e1.getPaint(), f1, TextUtils.TruncateAt.END);
            t1.setText("输入框省略后的样式为：" + cs1);
        }
    }
}
