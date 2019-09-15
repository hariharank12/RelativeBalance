package org.me.accounts.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by hariharank12 on 15/09/19.
 */
public class DateUtil {
    public static Date getDate(String dateString) {
        try {
            return new SimpleDateFormat("dd/mm/yyyy HH:mm:ss").parse(dateString);
        } catch (ParseException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

}
