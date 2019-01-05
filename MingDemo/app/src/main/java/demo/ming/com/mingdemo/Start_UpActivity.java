package demo.ming.com.mingdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import demo.ming.com.global.AppConstants;
import demo.ming.com.utils.SpUtils;

/**
 * 作者：Administrator
 * 时间：2019/1/5 09:39
 * 作用：启动页
 * 使用SharedPreference来保存app启动状态，如果为true，则进入功能导航，否则延迟2秒之后进入主页面。
 */

public class Start_UpActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        判断是否是第一次启动APP
        Boolean boo = SpUtils.getBoolean(this, AppConstants.FIRST_OPEN);
//        如果是第一次启动应用就跳转引导页
        if (!boo){
            Intent intenta = new Intent(this,GuideActivity.class);
            startActivity(intenta);
            finish();
            return;
        }
//        不是第一次启动就跳转欢迎页
        setContentView(R.layout.activity_start_up);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                enterHomeActivity();
            }
        },3000);
    }

    private void enterHomeActivity() {
        Intent intentb = new Intent(this,MainActivity.class);
        startActivity(intentb);
        finish();
    }
}
