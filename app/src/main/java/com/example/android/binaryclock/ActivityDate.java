package com.example.android.binaryclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;

import android.os.Bundle;

import android.view.View;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class ActivityDate extends AppCompatActivity {

    private Date dateNow;
    private SimpleDateFormat formatterD = new SimpleDateFormat("d", Locale.ENGLISH);
    private SimpleDateFormat formatterM = new SimpleDateFormat("M", Locale.ENGLISH);
    private SimpleDateFormat formatterY = new SimpleDateFormat("yy", Locale.ENGLISH);
    private ImageView scoreView1;
    private ImageView scoreView2;
    private ImageView scoreView3;
    private ImageView scoreView4;
    private ImageView scoreView5;
    private ImageView scoreView6;
    private ImageView scoreView7;
    private ImageView scoreView8;
    private ImageView scoreView9;
    private ImageView scoreView10;
    private ImageView scoreView11;
    private ImageView scoreView12;
    private ImageView scoreView13;
    private ImageView scoreView14;
    private ImageView scoreView15;
    private ImageView scoreView16;
    private String d;
    private String m;
    private String y;
    private String[]day;
    private String[]month;
    private String[]year;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date);
        scoreView1 =  findViewById(R.id.Day1);
        scoreView2 =  findViewById(R.id.Day2);
        scoreView3 =  findViewById(R.id.Day4);
        scoreView4 =  findViewById(R.id.Day8);
        scoreView5 =  findViewById(R.id.Day16);
        scoreView6 =  findViewById(R.id.Month1);
        scoreView7 =  findViewById(R.id.Month2);
        scoreView8 =  findViewById(R.id.Month4);
        scoreView9 =  findViewById(R.id.Month8);
        scoreView10 =  findViewById(R.id.Year1);
        scoreView11 =  findViewById(R.id.Year2);
        scoreView12 =  findViewById(R.id.Year4);
        scoreView13 =  findViewById(R.id.Year8);
        scoreView14 =  findViewById(R.id.Year16);
        scoreView15 =  findViewById(R.id.Year32);
        scoreView16 =  findViewById(R.id.Year64);
                dateNow = new Date();
                d = binary(dateNow, formatterD);
                m = binary(dateNow, formatterM);
                y = binary(dateNow, formatterY);
                day=arrayMaking(d);
                month=arrayMaking(m);
                year=arrayMaking(y);

                    if (day[0].equals("1"))
                        scoreView1.setImageResource(R.drawable.green_circle);
                    else
                        scoreView1.setImageResource(0);
                    if (day[1].equals("1"))
                        scoreView2.setImageResource(R.drawable.green_circle);
                    else
                        scoreView2.setImageResource(0);
                    if (day[2].equals("1"))
                        scoreView3.setImageResource(R.drawable.green_circle);
                    else
                        scoreView3.setImageResource(0);

                    if (day[3].equals("1"))
                        scoreView4.setImageResource(R.drawable.green_circle);
                    else
                        scoreView4.setImageResource(0);

                    if (day[4].equals("1"))
                        scoreView5.setImageResource(R.drawable.green_circle);
                    else
                        scoreView5.setImageResource(0);

                    if(month[0].equals("1"))
                        scoreView6.setImageResource(R.drawable.green_circle);
                    else
                        scoreView6.setImageResource(0);
                    if(month[1].equals("1"))
                        scoreView7.setImageResource(R.drawable.green_circle);
                    else
                        scoreView7.setImageResource(0);
                    if(month[2].equals("1"))
                        scoreView8.setImageResource(R.drawable.green_circle);
                    else
                        scoreView8.setImageResource(0);
                    if(month[3].equals("1"))
                        scoreView9.setImageResource(R.drawable.green_circle);
                    else
                        scoreView9.setImageResource(0);
                    if(year[0].equals("1"))
                        scoreView10.setImageResource(R.drawable.green_circle);
                    else
                        scoreView10.setImageResource(0);
                    if(year[1].equals("1"))
                        scoreView11.setImageResource(R.drawable.green_circle);
                    else
                        scoreView11.setImageResource(0);
                    if(year[2].equals("1"))
                        scoreView12.setImageResource(R.drawable.green_circle);
                    else
                        scoreView12.setImageResource(0);
                    if(year[3].equals("1"))
                        scoreView13.setImageResource(R.drawable.green_circle);
                    else
                        scoreView13.setImageResource(0);
                    if(year[4].equals("1"))
                        scoreView14.setImageResource(R.drawable.green_circle);
                    else
                        scoreView14.setImageResource(0);
                    if(year[5].equals("1"))
                        scoreView15.setImageResource(R.drawable.green_circle);
                    else
                        scoreView15.setImageResource(0);
                    if(year[6].equals("1"))
                        scoreView16.setImageResource(R.drawable.green_circle);
                    else
                        scoreView16.setImageResource(0);

    }


    public String binary (Date date, SimpleDateFormat formatter){
        int i =Integer.parseInt(formatter.format(date));
        return Integer.toString(i, 2);
    }
    public String[] arrayMaking (String string) {
        String[] array = {"0", "0", "0", "0", "0", "0", "0", "0"};
        int i =0;
        for (int j = string.length()-1; j >= 0; j--) {
            array[i] = string.substring(j, j + 1);
            i++;
        }
        return array;
    }
    public void time(View v){
        Intent intent = new Intent(ActivityDate.this, MainActivity.class);
        startActivity(intent);

    }
}