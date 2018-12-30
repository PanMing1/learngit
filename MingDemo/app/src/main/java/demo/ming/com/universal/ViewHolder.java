package demo.ming.com.universal;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

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
}
