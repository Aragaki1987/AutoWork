package com.san.auto.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by nguye on 3/25/2017.
 */
public class DateUtil {

    public static String convertDateString(Date startdate) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MMM/yy");
        return sdf.format(startdate);
    }
}
