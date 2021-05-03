package com.goldenshoe.onlinestore.utils;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

/**
 * Created by aliyussef on 02/05/2021
 */
public final class DateExtension {

    /**
     * Convert Date to LocalDate.
     */
    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }
}
