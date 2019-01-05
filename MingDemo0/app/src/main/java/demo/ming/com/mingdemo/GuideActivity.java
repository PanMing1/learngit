package demo.ming.com.mingdemo;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;

import demo.ming.com.adapter.GuideAdapter;

//引导页

public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {
    private ViewPager vPager;
    private GuideAdapter gAdapter;
    private static int[] images = {R.drawable.icon_guide_one, R.drawable.icon_guide_two, R.drawable.icon_guide_three};
    private ArrayList<ImageView> imageViews;
    private ImageView[] dotViews; //小圆点
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        context = GuideActivity.this;
        //设置每一张图片都填充窗口
        ViewPager.LayoutParams mParams = new ViewPager.LayoutParams();
        imageViews = new ArrayList<>();
        for (int i = 0; i < images.length; i++) {
            ImageView iv = new ImageView(this);
            //设置布局
            iv.setLayoutParams(mParams);
            //为ImageView添加图片资源
            iv.setImageResource(images[i]);
            //这里是一个图片的适配
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            imageViews.add(iv);
            //为最后一张图片添加点击事件
            if (i == images.length - 1) {
                iv.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View view, MotionEvent motionEvent) {
                        //跳转到主界面
                        Intent intent = new Intent(context, MainActivity.class);
                        startActivity(intent);
                        return true;
                    }
                });
            }
        }
        //小圆点数量判断以及小圆点之间的间隔&小圆点默认启动显示的位置
        LinearLayout linearLayout = findViewById(R.id.guide_linear);
        LinearLayout.LayoutParams mParamsa = new LinearLayout.LayoutParams(20, 20);
        //设置小圆点左右之间的间隔
        mParamsa.setMargins(10, 0, 10, 0);
        dotViews = new ImageView[images.length];
        //判断小圆点的数量，从0开始，0表示第一个
        for (int i = 0; i < imageViews.size(); i++) {
            ImageView imageView = new ImageView(this);
            imageView.setLayoutParams(mParamsa);
            imageView.setImageResource(R.drawable.xiaoyuandian);
            if (i == 0) {
                //默认启动时，选中第一个小圆点
                imageView.setSelected(true);
            } else {
                imageView.setSelected(false);
            }
            //得到每个小圆点的引用，用于滑动页面时，（onPageSelected方法中）更改它们的状态。
            dotViews[i] = imageView;
            //添加到布局里面显示
            linearLayout.addView(imageView);
        }
        vPager = findViewById(R.id.guide_pager);
        gAdapter = new GuideAdapter(imageViews);
        vPager.setAdapter(gAdapter);
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }
    //当前页面的索引值来设置小圆点的状态
    @Override
    public void onPageSelected(int position) {
        for (int i = 0; i < dotViews.length; i++) {
            if (position == i) {
                dotViews[i].setSelected(true);
            } else {
                dotViews[i].setSelected(false);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }
}
