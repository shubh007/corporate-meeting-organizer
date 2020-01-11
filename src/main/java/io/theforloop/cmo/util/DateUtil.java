package io.theforloop.cmo.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Shubham
 */
public class DateUtil {

    private static String stringDateFormat = "dd/MM/yyyy";
    private static String stringTimeFormat = "hh:mm";

    public static Date getDate(String sDate){
        Date date = null;
        try {
            date = new SimpleDateFormat(stringDateFormat).parse(sDate);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getStringDate(Date date){
        String sDate = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(stringDateFormat);
            sDate = dateFormat.format(date);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return sDate;
    }
    public static Date getTime(String sDate){
        Date date = null;
        try {
            date = new SimpleDateFormat(stringTimeFormat).parse(sDate);
        }catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }

    public static String getStringTime(Date date){
        String sDate = null;
        try {
            DateFormat dateFormat = new SimpleDateFormat(stringTimeFormat);
            sDate = dateFormat.format(date);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return sDate;
    }

}
