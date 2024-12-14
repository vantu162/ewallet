package com.example.vimass_e_wallet.tool;

import java.security.MessageDigest;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.logging.Logger;

public class Func {

    public static Func instance;
    static {
        instance = new Func();
    }

    public static String getMD5(String input) {

        StringBuffer sb = new StringBuffer();
        try {
            input = input.trim();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(input.getBytes());

            byte byteData[] = md.digest();

            // convert the byte to hex format method 1

            for (int i = 0; i < byteData.length; i++) {
                sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16)
                        .substring(1));
            }
        } catch (Exception e) {

        }
        return sb.toString();
    }

    public static String convertLongTimeFull(long time)
    {
        String dateText = "";
        try {
            Date date=new Date(time);
            SimpleDateFormat df2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            dateText = df2.format(date);
        }catch (Exception e)
        {
            Logger.getLogger("error: " + e.getMessage());
        }
        if(dateText.contains("AM"))
        {
            dateText = dateText.replace("AM","Sáng");
        }
        else if (dateText.contains("PM"))
        {
            dateText = dateText.replace("PM","Chiều");
        }
        return dateText;
    }

    public static String getVNDFormat(double money)
    {
        if(money>=0)
        {
            DecimalFormat df;
            df = new DecimalFormat("#");
            df.setMaximumFractionDigits(8);
            String m = new StringBuilder(df.format(money)).reverse().toString();
            for(int i=0;i<m.length();i++)
            {
                if(i==3 || i ==7 || i == 11|| i == 15)
                {
                    m = new StringBuffer(m).insert(i, ".").toString();
                }
            }
            return new StringBuilder(m).reverse().toString();
        }
        else
        {
            money = Math.abs(money);
            DecimalFormat df;
            df = new DecimalFormat("#");
            df.setMaximumFractionDigits(8);
            String m = new StringBuilder(df.format(money)).reverse().toString();
            for(int i=0;i<m.length();i++)
            {
                if(i==3 || i ==7 || i == 11|| i == 15)
                {
                    m = new StringBuffer(m).insert(i, ".").toString();
                }
            }
            String str = new StringBuilder(m).reverse().toString();
            return "-" + str;
        }

    }


    public static String getVNDFormatTypeInt(int money)
    {
        if(money>=0)
        {
            DecimalFormat df;
            df = new DecimalFormat("#");
            df.setMaximumFractionDigits(8);
            String m = new StringBuilder(df.format(money)).reverse().toString();
            for(int i=0;i<m.length();i++)
            {
                if(i==3 || i ==7 || i == 11|| i == 15)
                {
                    m = new StringBuffer(m).insert(i, ".").toString();
                }
            }
            return new StringBuilder(m).reverse().toString();
        }
        else
        {
            money = Math.abs(money);
            DecimalFormat df;
            df = new DecimalFormat("#");
            df.setMaximumFractionDigits(8);
            String m = new StringBuilder(df.format(money)).reverse().toString();
            for(int i=0;i<m.length();i++)
            {
                if(i==3 || i ==7 || i == 11|| i == 15)
                {
                    m = new StringBuffer(m).insert(i, ".").toString();
                }
            }
            String str = new StringBuilder(m).reverse().toString();
            return "-" + str;
        }

    }

    public long converFullDateTimeToLongTime(String fullDateTime)
    {
//        Logger.getLogger("full = " + fullDateTime);
        long millis = 0;
        try {
            // Define the date format
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy HH:mm:ss");

            Date date = sdf.parse(fullDateTime);

            // Convert to milliseconds
            millis = date.getTime();

//            System.out.println("Milliseconds: " + millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return millis;
    }

    public long converFullDateTime(String fullDateTime)
    {
//        Logger.getLogger("full = " + fullDateTime);
        long millis = 0;
        try {
            // Define the date format
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

            Date date = sdf.parse(fullDateTime);

            // Convert to milliseconds
            millis = date.getTime();

//            System.out.println("Milliseconds: " + millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return millis;
    }


    public long timeCurrentMillis(int hh, int ss, int mm){
        long timeMillis = 0;

        try{
            LocalDate today = LocalDate.now();
            LocalDateTime startOfDay = LocalDateTime.of(today, LocalTime.of(hh, ss, mm));
            timeMillis = startOfDay.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
            System.out.println("timeMillis of the day (millis): " + timeMillis);
        }catch (Exception e){
            System.out.println("timeCurrentMillis e: " + e.getMessage());
        }

        return timeMillis;
    }


    public boolean isNumeric(String strNum)
    {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            System.out.println("khong phai so " + strNum);
            return false;
        }
        return true;
    }
}
