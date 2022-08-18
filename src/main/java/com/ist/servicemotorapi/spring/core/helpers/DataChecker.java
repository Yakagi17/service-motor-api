package com.ist.servicemotorapi.spring.core.helpers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataChecker {
    public static Boolean isContain(String[] arrMatcher, String data){
        List<String> listMatcher = new ArrayList<>(Arrays.asList(arrMatcher));

        return listMatcher.contains(data);
    }
    
}
