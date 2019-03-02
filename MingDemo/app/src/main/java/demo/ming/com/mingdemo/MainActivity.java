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
/*
* 主页面
* */
public class MainActivity extends Activity implements View.OnClickListener {
    private Button b1;
    private Button b2;
    private Button b3;
    private Button b4;
    private Button b5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = findViewById(R.id.m_b_1);
        b2 = findViewById(R.id.m_b_2);
        b3 = findViewById(R.id.m_b_3);
        b4 = findViewById(R.id.m_b_4);
//        b5 = findViewById(R.id.m_b_5);
        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
//        b5.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.m_b_1) {
            Intent i1 = new Intent(MainActivity.this,T1Activity.class);
            startActivity(i1);
        }else if (v.getId() == R.id.m_b_2){
            Intent i1 = new Intent(MainActivity.this,T2Activity.class);
            startActivity(i1);
        }else if (v.getId() == R.id.m_b_3){
            Intent i1 = new Intent(MainActivity.this,T3Activity.class);
            startActivity(i1);
        }else if (v.getId() == R.id.m_b_4){
            Intent i1 = new Intent(MainActivity.this,T4Activity.class);
            startActivity(i1);
        }
    }
}
