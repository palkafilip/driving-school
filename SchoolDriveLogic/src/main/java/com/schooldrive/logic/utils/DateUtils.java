package com.schooldrive.logic.utils;

import java.text.SimpleDateFormat;

/**
 * Created by Filip on 02.12.2017.
 */
public final class DateUtils {

    public static SimpleDateFormat dateWithTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm");
    }

    public static SimpleDateFormat dateWithoutTime() {
        return new SimpleDateFormat("yyyy-MM-dd");
    }

    public static SimpleDateFormat dateYearOnly() {
        return new SimpleDateFormat("yyyy");
    }
}
