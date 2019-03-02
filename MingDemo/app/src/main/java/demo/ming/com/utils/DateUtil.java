package demo.ming.com.utils;

import android.annotation.SuppressLint;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 作者：Created by Administrator on 2019/2/17 16 : 49
 * 作用：使用日期
 */

public class DateUtil {
    @SuppressLint("SimpleDateFormat")
    //立即获取日期时间
    public static String getNowDateTime(){
        //SimpleDateFormat:简单日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddhhmmss");
        return sdf.format(new Date());
    }
    //得到现在的时间
    public static String getNowTime(){
        @SuppressLint("SimpleDateFormat") SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        return sdf.format(new Date());
    }
}
