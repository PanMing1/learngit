package demo.ming.com.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 作者：Administrator
 * 时间：2019/1/5 09:54
 * 作用：操作类   SharedPreferences
 */

public class SpUtils {
    private static final String SPFILENAME = "app";

//    没看懂，好像是判断APP是否启动过
    public static Boolean getBoolean(Context context, String strKey) {
        SharedPreferences spPreferences = context.getSharedPreferences(SPFILENAME,Context.MODE_PRIVATE);
        Boolean result = spPreferences.getBoolean(strKey,false);
        return result;
    }
}
