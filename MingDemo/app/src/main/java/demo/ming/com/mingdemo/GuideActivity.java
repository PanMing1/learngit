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

//引导页

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
                /*
                *   button1.setTag(1);
                *   button1.setOnClickListener(this);
                *   public void onClick(View v) {
                *   int tag = (Integer) v.getTag();
                *   switch (tag){
                *   case 1:
                *   System.out.println("button1 click");
                *   break;
                * */
                glast_but.setTag("enter");
                glast_but.setOnClickListener(this);
            }
            imageViews.add(view);
        }
        vPager = findViewById(R.id.guide_pager);
        gAdapter = new GuideAdapter(imageViews);
        vPager.setAdapter(gAdapter);

        initDots();
    }

    private void initDots() {
        LinearLayout linearLayout = findViewById(R.id.guide_linear);
        dots = new ImageView[images.length];
        //判断小圆点的数量，从0开始，0表示第一个  循环获得小数点图片
        for (int i = 0; i < imageViews.size(); i++) {
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
//        设置为白色，即选中状态
        dots[dqxzwz].setEnabled(true);
    }
//setCurrentItem(int index)方法主要用来制定初始化的页面。例如加入3个页面通过setCurrentItem(0)制定第一个页面为当前页面
    @Override
    public void onClick(View view) {
        String str = (String) view.getTag();
        if (str.equals("enter")) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
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
}
