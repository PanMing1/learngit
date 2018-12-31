package demo.ming.com.universal;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 作者：Administrator on 2018/12/31 11:08
 * 邮箱：xjs250@163.com
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    protected LayoutInflater cInflater;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
