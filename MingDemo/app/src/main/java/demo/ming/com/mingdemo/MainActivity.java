package demo.ming.com.mingdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
    private TextView t1;
    private EditText e1;
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1 = findViewById(R.id.m_t_a);
//        t1.setText("今天阴天！");
        t1.setTextColor(Color.GREEN);
        t1.setTextSize(20);
        e1 = findViewById(R.id.m_e_a);
        b1 = findViewById(R.id.m_b_1);
        b2 = findViewById(R.id.m_b_2);
        b3 = findViewById(R.id.m_b_3);
        b4 = findViewById(R.id.m_b_4);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);

        b5 = findViewById(R.id.m_b_5);
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(MainActivity.this,T1Activity.class);
                startActivity(i1);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.m_b_1) {
            boolean boo1 = TextUtils.isEmpty(e1.getText());
            String s1 = String.format("输入框的内容%s空的",boo1?"是":"不是");
            t1.setText(s1);
        }else if (v.getId() == R.id.m_b_2){
            int length = TextUtils.getTrimmedLength(e1.getText());
            String s2 = String.format("去掉空格的长度是%d",length);
            t1.setText(s2);
        }else if (v.getId() == R.id.m_b_3){
            boolean boo2 = TextUtils.isDigitsOnly(e1.getText());
            String s3 = String.format("是否全是数字：%s",boo2?"是":"不是");
            t1.setText(s3);
        }else if (v.getId() == R.id.m_b_4){
            float f1 = e1.getTextSize() * 3;
            CharSequence cs1 = TextUtils.ellipsize(e1.getText(),e1.getPaint(),f1, TextUtils.TruncateAt.END);
            t1.setText("输入框省略后的样式为："+ cs1);
        }
    }
}
