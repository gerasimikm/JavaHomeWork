package com.pb.dn131081gmm.hw11;

import sun.util.resources.LocaleData;

import java.time.format.DateTimeFormatter;
import java.util.Calendar;

public class DateBirth implements Comparable<DateBirth> {
    final private int year;
    final private int month;
    final  private int day;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    DateBirth(int yyyy, int month, int day) {
        this.year = setYear(yyyy);
        this.month = setMonth(month);
        this.day = setDay(day);

    }
    int setYear(int yyyy){
        if (yyyy < 1900 || ((Calendar.getInstance().get(Calendar.YEAR) + 1) < yyyy)) {
            throw new IllegalArgumentException("Недопустимый год рождения");
        } else {
            return yyyy;
        }
    }
    int setMonth(int month){
        if(month <= 0 || month > 12 ){
            throw new IllegalArgumentException("Недопустимое значение месяца");
        }
        else{
            return month;
        }
    }
    int setDay(int day){
        if(month <= 0 || day > 31 ){
            throw new IllegalArgumentException("Недопустимый день месяца");
        }
        else{
            return day;
        }
    }

    public String getDate(){
        return toString();
    }
    public static DateBirth parse(CharSequence text){
        String s1;
        s1 = text.toString();
        s1= s1.replaceAll("[^\\d]", "").substring(0,8);
        int y,m,d;
        y = Integer.parseInt(s1.substring(0,4)); //преобразует в int елементы строки [0] [1] [2] [3] ([4] не включается)
        m = Integer.parseInt(s1.substring(4,6)); //преобразует в int елементы строки [4] [5] ([6]  не включается)
        d = Integer.parseInt(s1.substring(6));   //преобразует в int елементы строки с [6] включительно  (substring с одним параметром [6] включается)
        return new DateBirth(y,m,d);

    }
    @Override
    public String toString() {
        String mSt = null;
        String dSt = null;
        if(month < 10)
            mSt = "0"+month;
        else
            mSt = String.valueOf(month);
        if (day < 10)
            dSt = "0"  + day;
        else
            dSt = String.valueOf(day); //Преобразование int к String
        return "{ "+ this.year+ '-' + mSt + '-' + dSt + " }";
    }
    @Override
    public int compareTo(DateBirth o) {
        if (this.year == o.getYear() && this.month == o.month && this.day == o.getDay() )
            return 0;
        else
            return -1;
    }
}

