package com.ist.servicemotorapi.spring.core.helpers;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormater {
    public static String getCurrentDate(){

        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String currentDate = dateFormat.format(date);
        
        return currentDate;
    }
    
}
