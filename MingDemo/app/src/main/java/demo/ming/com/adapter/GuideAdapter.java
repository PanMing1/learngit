package demo.ming.com.adapter;

import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * 作者：Administrator on 2019/1/4 10:54
 * 作用：引导页的适配器
 */

public class GuideAdapter extends PagerAdapter {
    private List<View> imageViews;

    public GuideAdapter(List<View> imageViews) {
        this.imageViews = imageViews;
    }

//  获取当前要显示对象的数量
    @Override
    public int getCount() {
        return imageViews.size();
    }

//  判断是否用对象生成界面
    @Override
    public boolean isViewFromObject(View view, Object o) {
        return view == o;
    }
//  从ViewGroup中移除当前对象（图片）

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(imageViews.get(position));
    }
//    当前要显示的对象（图片）

    @NonNull
    @Override
    public Object instantiateItem( ViewGroup container, int position) {
        container.addView(imageViews.get(position));
        return imageViews.get(position);
    }
}
