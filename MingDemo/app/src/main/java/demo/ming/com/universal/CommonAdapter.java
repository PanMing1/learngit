package demo.ming.com.universal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * 作者：Administrator on 2018/12/31 11:08
 * 邮箱：xjs250@163.com
 */

public abstract class CommonAdapter<T> extends BaseAdapter {
    protected LayoutInflater cInflater;
    protected List<T> mDatas;
    protected Context mContext;
    private int mLayoutId;

    public CommonAdapter(List<T> mDatas, Context mContext,int mLayoutId) {
        cInflater = LayoutInflater.from(mContext);
        this.mDatas = mDatas;
        this.mContext = mContext;
        this.mLayoutId = mLayoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View converView, ViewGroup parent) {
        ViewHolder holder = ViewHolder.get(mContext,converView,parent,position,mLayoutId);
        convert(holder,getItem(position));
        return holder.gethView();
    }

    public abstract void convert(ViewHolder holder, T t);
}
