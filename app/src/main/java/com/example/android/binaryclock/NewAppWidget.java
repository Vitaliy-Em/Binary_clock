package com.example.android.binaryclock;

import android.app.AlarmManager;
import android.app.IntentService;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RemoteViews;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Implementation of App Widget functionality.
 */
public class NewAppWidget extends AppWidgetProvider {

    private static Date dateNow;
    private static SimpleDateFormat formatterH = new SimpleDateFormat("HH", Locale.ENGLISH);
    private static SimpleDateFormat formatterM = new SimpleDateFormat("mm", Locale.ENGLISH);

    private static String h;
    private static String m;
    private static String[]hour;
    private  static String[]minute;




    public static String binary(Date date, SimpleDateFormat formatter){
        int i =Integer.parseInt(formatter.format(date));
        return Integer.toString(i, 2);
    }
    public static String[] arrayMaking(String string) {
        String[] array = {"0", "0", "0", "0", "0", "0"};
        int i =0;
        for (int j = string.length()-1; j >= 0; j--) {
            array[i] = string.substring(j, j + 1);
            i++;
        }
        return array;
    }

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {


        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_app_widget);
        dateNow = new Date();
        h = binary(dateNow, formatterH);
        m = binary(dateNow, formatterM);
        hour= arrayMaking(h);
        minute= arrayMaking(m);
        if(hour[0].equals("1"))
            views.setImageViewResource(R.id.Hour1_1,R.drawable.shar);
        else
            views.setImageViewResource(R.id.Hour1_1,0);
        if(hour[1].equals("1"))
            views.setImageViewResource(R.id.Hour2_1,R.drawable.shar);
        else
            views.setImageViewResource(R.id.Hour2_1,0);
        if(hour[2].equals("1"))
            views.setImageViewResource(R.id.Hour4_1,R.drawable.shar);
        else
            views.setImageViewResource(R.id.Hour4_1, 0);
        if(hour[3].equals("1"))
            views.setImageViewResource(R.id.Hour8_1,R.drawable.shar);
        else
            views.setImageViewResource(R.id.Hour8_1,0);
        if(hour[4].equals("1"))
            views.setImageViewResource(R.id.Hour16_1,R.drawable.shar);
        else
            views.setImageViewResource(R.id.Hour16_1,0);
        if(minute[0].equals("1"))
            views.setImageViewResource(R.id.Minute1_1,R.drawable.shar);
        else
            views.setImageViewResource(R.id.Minute1_1,0);
        if(minute[1].equals("1"))
            views.setImageViewResource(R.id.Minute2_1,R.drawable.shar);
        else
            views.setImageViewResource(R.id.Minute2_1,0);
        if(minute[2].equals("1"))
            views.setImageViewResource(R.id.Minute4_1,R.drawable.shar);
        else
            views.setImageViewResource(R.id.Minute4_1, 0);
        if(minute[3].equals("1"))
            views.setImageViewResource(R.id.Minute8_1,R.drawable.shar);
        else
            views.setImageViewResource(R.id.Minute8_1,0);
        if(minute[4].equals("1"))
            views.setImageViewResource(R.id.Minute16_1,R.drawable.shar);
        else
            views.setImageViewResource(R.id.Minute16_1,0);
        if(minute[5].equals("1"))
            views.setImageViewResource(R.id.Minute32_1,R.drawable.shar);
        else
            views.setImageViewResource(R.id.Minute32_1,0);

        //нажатие на виджет (обновление)
        Intent updateIntent = new Intent(context, NewAppWidget.class);
        updateIntent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        updateIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, new int[] { appWidgetId });
        PendingIntent pIntent = PendingIntent.getBroadcast(context, appWidgetId, updateIntent, 0);
        views.setOnClickPendingIntent(R.id.reFRESH, pIntent);

        appWidgetManager.updateAppWidget(appWidgetId, views);


    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {

        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {

    }

    @Override
    public void onDisabled(Context context) {

    }
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

    }

}


