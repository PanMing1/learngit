package demo.ming.com.mingdemo;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.EditText;

/**
 * 作者：Administrator
 * 时间：2019/2/14 13:15
 * 作用：自定义EditText
 */

public class M1 extends EditText {
    //声明一个图片，用作删除
    private Drawable p1;
    private Context p2;
    //声明一个AttributeSet（属性集） p2
    public M1(Context p2, AttributeSet p3) {
        super(p2,p3);
        this.p2 = p2;
        init();
    }

    private void init() {
        p1 = p2.getResources().getDrawable(R.drawable.m1);
        addTextChangedListener(new TextWatcher() {
            //            内容变化前
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }
            //            内容变化中
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }
            //            内容变化后
            @Override
            public void afterTextChanged(Editable s) {
                M2();
            }
        });
    }

    //    绘制删除图片
    private void M2() {
        if (length() < 1){
            //  setCompoundDrawablesWithIntrinsicBounds：设置具有内在界限的复合可绘图文件
            setCompoundDrawablesWithIntrinsicBounds(null,null,null,null);
        }else {
            setCompoundDrawablesWithIntrinsicBounds(null,null,p1,null);
        }
    }

    //    当触摸范围在右侧时，触发删除方法，清空输入框，调用M2()方面隐藏图片
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (p1 != null && event.getAction() == MotionEvent.ACTION_UP){
            //将点击坐标赋值
            int RX = (int) event.getRawX();
            int RY = (int) event.getRawY();
            //声明一个Rect（矩形）r1
            Rect r1 = new Rect();
            //getGlobalVisibleRect:获取全局可见矩形
            getGlobalVisibleRect(r1);
            //矩形的左边和右边距离是一百，高度是输入框高度
            r1.left = r1.right - 100;
            //判断点击的范围是不是在矩形性内
            if (r1.contains(RX,RY)){
                //清空输入框
                setText("");
            }
        }
        return super.onTouchEvent(event);
    }

    //    finalize()是做什么的？它最主要的用途是回收特殊渠道申请的内存
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
    }
}
