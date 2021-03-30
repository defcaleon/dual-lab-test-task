package com.company.code;

import java.time.LocalTime;

public class ExternalComparisonLogic {


    public  int externalTimeComp(LocalTime time1, LocalTime time2){
        int hour1=time1.getHour();
        int hour2=time2.getHour();
        if(hour1==23&&hour2==0) {
            return -1;
        }
        if(hour1==0&&hour2==23){
            return 1;
        }else{
            int comparison= Integer.compare(hour1, hour2);
            if(comparison==0){
                int min1=time1.getMinute();
                int min2=time2.getMinute();
                return Integer.compare(min1, min2);
            }else
                return comparison;
        }


    }
}
