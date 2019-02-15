package demo.ming.com.mingdemo;

import android.os.Bundle;
import android.app.Activity;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends Activity {
    //用户名输入框
    private EditText p1;
    //密码输入框
    private EditText p2;
    //登录按钮
    private Button p3;
    //清空按钮
    private Button p4;
    //去注册按钮
    private Button p5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }
}
