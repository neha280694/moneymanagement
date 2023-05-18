package com.ftpl.moneymanagement;

import android.app.DatePickerDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.provider.Settings;
import android.widget.DatePicker;
import android.widget.TextView;

import com.instacart.library.truetime.TrueTime;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Util {
    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
    public static SimpleDateFormat dateFormatterOther = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat dateFormatterOthers = new SimpleDateFormat("dd MMM EEEE");

    // date picker
    public static void getDateTime(Context con, final TextView txt){
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datepicker = new DatePickerDialog(con, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                txt.setText("" + dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datepicker.show();
    }



    public static void getDateTimee(Context con, final TextView txt){
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datepicker = new DatePickerDialog(con, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                txt.setText("" + dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datepicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

        datepicker.show();
    }




    public static void getDateTimeeEE(Context con, final TextView txt){
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datepicker = new DatePickerDialog(con, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                txt.setText("" + dateFormatterOthers.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datepicker.show();
    }


    public static void getDateTimeeE(Context con, final TextView txt){
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datepicker = new DatePickerDialog(con, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                txt.setText("" + dateFormatterOther.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.DAY_OF_MONTH), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.YEAR));
        datepicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

        datepicker.show();
    }




    public static void getDateTimeeEe(Context con, final TextView txt){
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datepicker = new DatePickerDialog(con, new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                txt.setText("" + dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.DAY_OF_MONTH), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.YEAR));
        datepicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);

        datepicker.show();
    }



    public static void showDialogWarning(Context con, String message){
        new SweetAlertDialog(con, SweetAlertDialog.ERROR_TYPE)
                .setTitleText("Oops...")
                .setContentText(message)
                .show();
    }


    public static void showDialogSuccess(Context con, String message){
        new SweetAlertDialog(con, SweetAlertDialog.SUCCESS_TYPE)
                .setTitleText("Success")
                .setContentText(message)
                .show();
    }

    public static void showDialogConfirm(Context con, String message){
        new SweetAlertDialog(con, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("Success")
                .setContentText(message)
                .show();
    }

    public static boolean isNetworkAvailable(Context mContext) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // get today date
    public static String getTodayDateLocal() {
        String formattedDate = null;
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            formattedDate = df.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }

    // get today date
    public static String getTodayDate() {
        String formattedDate = null;
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd MMM EEEE");
            formattedDate = df.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }
    public static String getTodayDateee() {
        String formattedDate = null;
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            formattedDate = df.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }




    public static String getTodayDateu() {
        String formattedDate = null;
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            formattedDate = df.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }






    public static String getTodayDateuu() {
        String formattedDate = null;
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
            formattedDate = df.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }


    public static String getTodayDateuuu() {
        String formattedDate = null;
        try {
            Calendar c = Calendar.getInstance();
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
            formattedDate = df.format(c.getTime());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formattedDate;
    }





    // get local time in device
    public static String getTime() {
        SimpleDateFormat formats = null;
        Date currentLocalTime = null;
        try {
            formats = new SimpleDateFormat("hh:mm a", Locale.getDefault());
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC+05:30"));
            currentLocalTime = cal.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formats.format(currentLocalTime);
    }

    // get local time in device
    public static String getTimeAmPm() {
        SimpleDateFormat formats = null;
        Date currentLocalTime = null;
        try {
            formats = new SimpleDateFormat("HH:mm:ss", Locale.getDefault());
            Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC+05:30"));
            currentLocalTime = cal.getTime();
            Date mTime = new Date();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return formats.format(currentLocalTime);
    }

    public static String RandNum(){
        try {
            Random random = new Random();
            String id = String.format("%04d", random.nextInt(10000));
            return id;
        } catch (Exception e) {
            e.printStackTrace();
            return "4532";
        }
    }

    // sweet progress dialog
    public static void sweetProgressDialog(SweetAlertDialog pDialog){
        pDialog.show();
        pDialog.setCancelable(false);
    }

    public static void sweetProgressDialogHide(SweetAlertDialog pDialog){
        if (pDialog.isShowing())
            pDialog.hide();
        pDialog.dismiss();
    }


    // get android secure id
    public static String getAndroidId(Context context){
        return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
    }

    public static String convert12hrsTo24hrs(String time){
        String time24 = "";
        try {
            SimpleDateFormat inFormat = new SimpleDateFormat("hh:mm a");
            SimpleDateFormat outFormat = new SimpleDateFormat("HH:mm:s");
            time24 = outFormat.format(inFormat.parse(time));
        } catch (Exception e) {
        }
        return time24;
    }

    public static String getSERVERDate(){
        try {
            Date trueTime = TrueTime.now();
            return  Util.formatDate(trueTime,"yyyy-MM-dd hh:mm a", TimeZone.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String calculateHrsToDate(String fDate, String tDate){
        String str = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy hh:mma", Locale.ENGLISH);
            Date date1 = simpleDateFormat.parse(fDate);
            Date date2 = simpleDateFormat.parse(tDate);

            long difference = date2.getTime() - date1.getTime();
            int days = (int) (difference / (1000*60*60*24));
            int hours = (int) ((difference - (1000*60*60*24*days)) / (1000*60*60));
            int min = (int) (difference - (1000*60*60*24*days) - (1000*60*60*hours)) / (1000*60);

            str = hours+" Hrs "+min +" Min";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  str;
    }

    public static String getServerDateDateMonthYear(){
        try {
            Date trueTime = TrueTime.now();
            return  Util.formatDate(trueTime,"dd-MMM-yyyy", TimeZone.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getServerDateYearMonthDate(){
        try {
            Date trueTime = TrueTime.now();
            return  Util.formatDate(trueTime,"yyyy-MM-dd", TimeZone.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public static String getServerDateYearMonthDatee(){
        try {
            Date trueTime = TrueTime.now();
            return  Util.formatDate(trueTime,"dd/MM/yyyy", TimeZone.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }


    public static String formatDate(Date date, String pattern, TimeZone timeZone) {
        try {
            DateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
            format.setTimeZone(timeZone);
            return format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getServerTime(){
        try {
            Date trueTime = TrueTime.now();
            return  Util.formatDate(trueTime,"hh:mm a", TimeZone.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String formatDatee(Date date, String pattern, TimeZone timeZone) {
        DateFormat format = new SimpleDateFormat(pattern, Locale.ENGLISH);
        format.setTimeZone(timeZone);
        return format.format(date);
    }

    public static String convertDatetimeToTime(String fDate){
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);
            String dateString = formatter.format(new Date(Long.parseLong(fDate)));
            return  dateString;
        } catch (NumberFormatException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static int calculateHrsToDay(String fDate, String tDate){
        int str = 0;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date1 = simpleDateFormat.parse(fDate);
            Date date2 = simpleDateFormat.parse(tDate);

            long difference = date2.getTime() - date1.getTime();

            int days = (int) (difference / (1000*60*60*24));
            int hours = (int) ((difference - (1000*60*60*24*days)) / (1000*60*60));
            int min = (int) (difference - (1000*60*60*24*days) - (1000*60*60*hours)) / (1000*60);

            str = (days+1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  str;
    }

    public static String calculateHrsToweek(String tDate){
        String daysName = "";
        try {
            SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);

            Date date = df.parse(tDate.trim());
            SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
            daysName  = outFormat.format(date);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return daysName;
    }

    public static int calculateHrsToDayOTHER(String fDate, String tDate){
        int str = 0;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd", Locale.ENGLISH);
            Date date1 = simpleDateFormat.parse(fDate);
            Date date2 = simpleDateFormat.parse(tDate);

            long difference = date2.getTime() - date1.getTime();

            int days = (int) (difference / (1000*60*60*24));
            int hours = (int) ((difference - (1000*60*60*24*days)) / (1000*60*60));
            int min = (int) (difference - (1000*60*60*24*days) - (1000*60*60*hours)) / (1000*60);

            str = (days+1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  str;
    }

    public static String calculateHrsToDayOTHERrr(String fDate, String tDate){
        String str = "";
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date1 = simpleDateFormat.parse(fDate);
            Date date2 = simpleDateFormat.parse(tDate);
            long diff = date2.getTime() - date1.getTime();
            long seconds = diff / 1000;
            long minutes = seconds / 60;
            long hours = minutes / 60;
            long days = hours / 24;
            int year = (int) diff / 365;
            int rest = (int) diff % 365;
            int month = rest / 30;
            rest = rest % 30;
            int weeks = rest / 7;
            int dayss = rest % 7;
            long diffMillis= Math.abs(date2.getTime() - date1.getTime());
            long differenceInDays = TimeUnit.DAYS.convert(diffMillis, TimeUnit.MILLISECONDS);
            str = (differenceInDays) +"day";
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  str;
    }


    public static String getServerYear(){
        try {
            Date trueTime = TrueTime.now();
            return  Util.formatDate(trueTime,"yyyy", TimeZone.getDefault());
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void getDatePickerWithDaysCal(Context con, final TextView txt, final String fromDate, final TextView txtTotalDays, final TextView txtDays) {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datepicker = new DatePickerDialog(con, new DatePickerDialog.OnDateSetListener()
        {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                txt.setText("" + dateFormatterOther.format(newDate.getTime()));
                int dayss = calculateHrsToDayYearMonth(fromDate, txt.getText().toString());
                txtTotalDays.setText(""+dayss);

                if (dayss > 1)
                    txtDays.setText("Days");
                else
                    txtDays.setText("Day");
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datepicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datepicker.show();
    }

    public static void getDatePickerWithDaysCaLl(Context con, final TextView txt, final String fromDate, final TextView txtTotalDays, final TextView txtDays) {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datepicker = new DatePickerDialog(con, new DatePickerDialog.OnDateSetListener()
        {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                txt.setText("" + dateFormatter.format(newDate.getTime()));
                int dayss = calculateHrsToDayYearMonthhh(fromDate, txt.getText().toString());
                txtTotalDays.setText(""+dayss);

                if (dayss > 1)
                    txtDays.setText("Days");
                else
                    txtDays.setText("Day");
            }
        }, newCalendar.get(Calendar.DAY_OF_MONTH), newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH));
        datepicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datepicker.show();
    }


    public static int calculateHrsToDayYearMonth(String fDate, String tDate){
        int str = 1;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date date1 = simpleDateFormat.parse(fDate);
            Date date2 = simpleDateFormat.parse(tDate);
            long difference = date2.getTime() - date1.getTime();
            int days = (int) (difference / (1000*60*60*24));
            str = (days+1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  str;
    }





    public static int calculateHrsToDayYearMonthhh(String fDate, String tDate){
        int str = 1;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
            Date date1 = simpleDateFormat.parse(fDate);
            Date date2 = simpleDateFormat.parse(tDate);
            long difference = date2.getTime() - date1.getTime();
            int days = (int) (difference / (1000*60*60*24));
            str = (days+1);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return  str;
    }

    public static void getDateT(Context con, final TextView txt) {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datepicker = new DatePickerDialog(con, new DatePickerDialog.OnDateSetListener()
        {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                txt.setText("" + dateFormatterOther.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datepicker.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        datepicker.show();
    }

}

