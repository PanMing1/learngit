package demo.ming.com.mingdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

import demo.ming.com.adapter.GuideAdapter;
import demo.ming.com.global.AppConstants;
import demo.ming.com.utils.SpUtils;

/**
 * 作者：Administrator
 * 时间：2019/1/5 09:39
 * 作用：引导页
 */

public class GuideActivity extends Activity implements View.OnClickListener {
    //    声明ViewPager、适配器、List数列、上下文
    private ViewPager vPager;
    private GuideAdapter gAdapter;
    private List<View> imageViews;
    private Context context;
    //    引导页图片资源
    private static int[] images = {R.layout.guide_one, R.layout.guide_two, R.layout.guide_three};
    //    小圆点
    private ImageView[] dots;
    //    记录当前选中位置
    private int dqxzwz;
    //    最后一张引导页上的按钮
    private Button glast_but;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        context = GuideActivity.this;
        imageViews = new ArrayList<>();

//        初始化引导页视图列表
        for (int i = 0; i < images.length; i++) {
            View view = LayoutInflater.from(context).inflate(images[i], null);
//            判断引导页是否是最后一页
            if (i == images.length - 1) {
                glast_but = view.findViewById(R.id.glast_button);
//                给按钮添加一个额外的数据 然后用getTag()取出
                glast_but.setTag("enter");
                glast_but.setOnClickListener(this);
            }
            imageViews.add(view);
        }
        vPager = findViewById(R.id.guide_pager);
        gAdapter = new GuideAdapter(imageViews);
        vPager.setAdapter(gAdapter);
        vPager.setOnPageChangeListener(new PageChangeListener());

        initDots();
    }

   /* @Override
    protected void onRestart() {
        super.onRestart();
    }*/

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() { //停顿
        super.onPause();
        // 如果切换到后台，就设置下次不进入功能引导页
        SpUtils.putBoolean(GuideActivity.this, AppConstants.FIRST_OPEN, true);
        finish();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initDots() {
        LinearLayout linearLayout = findViewById(R.id.guide_linear);
        dots = new ImageView[images.length];
        //判断小圆点的数量，从0开始，0表示第一个  循环获得小数点图片
        for (int i = 0; i < images.length; i++) {
//            得到一个LinearLayout下面的每一个子元素
//            getChildAt(i) 获取一个布局中的的view，removeViewAt(i)表示删除一个布局中的view
            dots[i] = (ImageView) linearLayout.getChildAt(i);
//            都设置为灰色
//            setEnabled 设置是否可用  是否拥有权限  是否启用该功能 等等
            dots[i].setEnabled(false);
            dots[i].setOnClickListener(this);
            dots[i].setTag(i);
        }
        dqxzwz = 0;
//        设置为选中状态
        dots[dqxzwz].setEnabled(true);
    }

    @Override
    public void onClick(View view) {
        if (view.getTag().equals("enter")) { //如果传过来的值是引导页最后一页的按钮
            enterMainActivity();
            return;
        }
        int postion = (int) view.getTag();//传过来是点
        setCurView(postion);
        setCurDot(postion);
    }

    private void setCurDot(int postion) {
        if (postion < 0 || postion > images.length || dqxzwz == postion){
            return;
        }
        dots[postion].setEnabled(true);
        dots[dqxzwz].setEnabled(false);
        dqxzwz = postion;
    }

    private void setCurView(int postion) {
        if (postion < 0 || postion >= images.length){
            return;
        }
        vPager.setCurrentItem(postion);
    }

    private void enterMainActivity() {
        Intent intent = new Intent(context,StartUpActivity.class);
        startActivity(intent);
//        AppConstants应用常数
        SpUtils.putBoolean(context, AppConstants.FIRST_OPEN,true);
        finish();
    }

    private class PageChangeListener implements ViewPager.OnPageChangeListener {
        // 当滑动状态改变时调用
        @Override
        public void onPageScrollStateChanged(int position) {
            // arg0 ==1的时辰默示正在滑动，arg0==2的时辰默示滑动完毕了，arg0==0的时辰默示什么都没做。

        }

        // 当前页面被滑动时调用
        @Override
        public void onPageScrolled(int position, float arg1, int arg2) {
            // arg0 :当前页面，及你点击滑动的页面
            // arg1:当前页面偏移的百分比
            // arg2:当前页面偏移的像素位置

        }

        // 当新的页面被选中时调用
        @Override
        public void onPageSelected(int position) {
            // 设置底部小点选中状态
            setCurDot(position);
        }

    }
}























/*

    //当前页面的索引值来设置小圆点的状态
    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dots.length; i++) {
            if (position == i) {
                dots[i].setSelected(true);
            } else {
                dots[i].setSelected(false);
            }
        }
    }
*/