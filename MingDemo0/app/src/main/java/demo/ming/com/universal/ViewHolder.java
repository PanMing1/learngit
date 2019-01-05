package demo.ming.com.universal;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * 作者：Administrator on 2018/12/29 17:34
 * 邮箱：xjs250@163.com
 */

public class ViewHolder {
    //    SparseArray:稀疏阵列 取代HashMap
    private SparseArray<View> saView;
    private View hView;
    private int hPosition;

    //    converView:转换视图 是一个能够重复使用的View
    //    ViewGroup:视图组
    public ViewHolder(Context context, View converView, ViewGroup viewGroup, int mLayoutId, int position) {
        this.hPosition = position;
        this.saView = new SparseArray<>();
        hView = LayoutInflater.from(context).inflate(mLayoutId, viewGroup, false);
        hView.setTag(this);
    }

    public static ViewHolder get(Context context, View converView, ViewGroup viewGroup, int mLayoutId, int position) {
        if (converView == null) {
            return new ViewHolder(context, converView, viewGroup, mLayoutId, position);
        } else {
            ViewHolder holder = (ViewHolder) converView.getTag();
            holder.hPosition = position;
            return holder;
        }
    }

    public <T extends View> T getView(int mViewId) {
        View view = saView.get(mViewId);
        if (view == null) {
            view = hView.findViewById(mViewId);
            saView.put(mViewId, view);
        }
        return (T) view;
    }

    public View gethView() {
        return hView;
    }

    //    设置TextView的值
    public ViewHolder setText(int viewId, String text) {
        TextView tv = getView(viewId);
        tv.setText(text);
        return this;
    }

    public ViewHolder setImageResource(int viewId, int resId) {
        ImageView iv = getView(viewId);
        iv.setImageResource(resId);
        return this;
    }

    public ViewHolder setImageBitmap(int viewId, Bitmap bitmap) {
        ImageView iv = getView(viewId);
        iv.setImageBitmap(bitmap);
        return this;
    }
}
