package org.example;

import lombok.SneakyThrows;

import java.text.SimpleDateFormat;
import java.util.Date;

public final class DateUtils {
    // Private constructor to prevent accidental creating an instance due to unproper usage
    private DateUtils() {}

    // @SneakyThrows allows to throw a checked exception without declaring them or using try-catch
    @SneakyThrows
    public static Date parseDate(String dateString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.parse(dateString);
    }
}
