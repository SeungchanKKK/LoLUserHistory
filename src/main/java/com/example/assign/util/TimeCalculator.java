package com.example.assign.util;

import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class TimeCalculator {
    public  String getTimestampToDate(long timestamp){
        Date date = new Date(timestamp);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }

    public String getTimefromSec(long sec){
        long minutes = sec / 60;
        long remainingSeconds = sec % 60;
        String value =minutes + "분 " + remainingSeconds + "초";
        return value;
    }
}
