package com.rairmmd.facedetect.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @author Rair
 * @date 2018/1/15
 * <p>
 * desc:
 */

public class DateUtils {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss", Locale.CHINA);

    public static String getNowTime() {
        return sdf.format(new Date());
    }
}
