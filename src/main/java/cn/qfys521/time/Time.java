package cn.qfys521.time;

import cn.qfys521.string.SuppressWarningsStrings;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class provides utility methods for working with time.
 */
@SuppressWarnings(SuppressWarningsStrings.UNUSED)
public class Time {

    /**
     * Gets the current date and time as a {@link java.util.Date} object.
     *
     * @return The current date and time as a Date object.
     */
    public static Date getNowTime() {
        return new Date();
    }

    /**
     * Gets the current date and time as a formatted string using the default format of the platform.
     *
     * @return The current date and time as a formatted string.
     */
    public static String getNowTimeStr() {
        return getNowTime().toString();
    }

    /**
     * Gets the current date and time as a formatted string using a specified format pattern.
     *
     * @param format The format pattern string used for formatting the date and time. See
     *               {@link java.text.SimpleDateFormat} for details on format patterns.
     *
     * @return The current date and time as a formatted string.
     */
    public static String getNowTimeStr(String format) {
        return new SimpleDateFormat(format).format(getNowTime());
    }

    /**
     * Gets the current system time in milliseconds since epoch (January 1, 1970, 00:00:00 GMT).
     *
     * @return The current system time in milliseconds.
     */
    public static long getSystemTime() {
        return System.currentTimeMillis();
    }

    /**
     * Converts a system time in milliseconds to a {@link java.util.Date} object.
     *
     * @param time The system time in milliseconds since epoch.
     *
     * @return The Date object representing the provided system time.
     */
    public static Date getSystemTimeToDate(long time) {
        return new Date(time);
    }

    /**
     * Gets the current system time as a formatted string using a specified format pattern. This method combines
     * {@link #getSystemTime()} and {@link #getSystemTimeToDate(long)} internally before formatting.
     *
     * @param format The format pattern string used for formatting the date and time. See
     *               {@link java.text.SimpleDateFormat} for details on format patterns.
     *
     * @return The current system time as a formatted string.
     */
    public static String getSystemTimeStr(String format) {
        return new SimpleDateFormat(format).format(getSystemTimeToDate(getSystemTime()));
    }
}