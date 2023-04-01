package com.example.android.binaryclock;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity{

    private Date dateNow;
    private SimpleDateFormat formatterH = new SimpleDateFormat("HH", Locale.ENGLISH);
    private SimpleDateFormat formatterM = new SimpleDateFormat("mm", Locale.ENGLISH);
    private SimpleDateFormat formatterS = new SimpleDateFormat("ss", Locale.ENGLISH);
    private ImageView scoreView;
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
    private ImageView scoreView17;
    private String h;
    private String m;
    private String s;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreView =  findViewById(R.id.Hour1);
        scoreView2 =  findViewById(R.id.Hour2);
        scoreView3 =  findViewById(R.id.Hour4);
        scoreView4 =  findViewById(R.id.Hour8);
        scoreView5 =  findViewById(R.id.Hour16);
        scoreView6 =  findViewById(R.id.Minute1);
        scoreView7 =  findViewById(R.id.Minute2);
        scoreView8 =  findViewById(R.id.Minute4);
        scoreView9 =  findViewById(R.id.Minute8);
        scoreView10 =  findViewById(R.id.Minute16);
        scoreView11 =  findViewById(R.id.Minute32);
        scoreView12 =  findViewById(R.id.Second1);
        scoreView13 =  findViewById(R.id.Second2);
        scoreView14 =  findViewById(R.id.Second4);
        scoreView15 =  findViewById(R.id.Second8);
        scoreView16 =  findViewById(R.id.Second16);
        scoreView17 =  findViewById(R.id.Second32);
        Timer timer = new Timer();
        long delay=0;
        long period =1000;
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                dateNow = new Date();
                h = binary(dateNow, formatterH);
                m = binary(dateNow, formatterM);
                s = binary(dateNow, formatterS);
                runOnUiThread(() -> {
                    if(arrayMaking(h)[0].equals("1"))
                        scoreView.setImageResource(R.drawable.green_circle);
                    else
                        scoreView.setImageResource(0);
                    if(arrayMaking(h)[1].equals("1"))
                        scoreView2.setImageResource(R.drawable.green_circle);
                    else
                        scoreView2.setImageResource(0);
                    if(arrayMaking(h)[2].equals("1"))
                        scoreView3.setImageResource(R.drawable.green_circle);
                    else
                        scoreView3.setImageResource(0);
                    if(arrayMaking(h)[3].equals("1"))
                        scoreView4.setImageResource(R.drawable.green_circle);
                    else
                        scoreView4.setImageResource(0);
                    if(arrayMaking(h)[4].equals("1"))
                        scoreView5.setImageResource(R.drawable.green_circle);
                    else
                        scoreView5.setImageResource(0);
                    if(arrayMaking(m)[0].equals("1"))
                        scoreView6.setImageResource(R.drawable.green_circle);
                    else
                        scoreView6.setImageResource(0);
                    if(arrayMaking(m)[1].equals("1"))
                        scoreView7.setImageResource(R.drawable.green_circle);
                    else
                        scoreView7.setImageResource(0);
                    if(arrayMaking(m)[2].equals("1"))
                        scoreView8.setImageResource(R.drawable.green_circle);
                    else
                        scoreView8.setImageResource(0);
                    if(arrayMaking(m)[3].equals("1"))
                        scoreView9.setImageResource(R.drawable.green_circle);
                    else
                        scoreView9.setImageResource(0);
                    if(arrayMaking(m)[4].equals("1"))
                        scoreView10.setImageResource(R.drawable.green_circle);
                    else
                        scoreView10.setImageResource(0);
                    if(arrayMaking(m)[5].equals("1"))
                        scoreView11.setImageResource(R.drawable.green_circle);
                    else
                        scoreView11.setImageResource(0);
                    if(arrayMaking(s)[0].equals("1"))
                        scoreView12.setImageResource(R.drawable.green_circle);
                    else
                        scoreView12.setImageResource(0);
                    if(arrayMaking(s)[1].equals("1"))
                        scoreView13.setImageResource(R.drawable.green_circle);
                    else
                        scoreView13.setImageResource(0);
                    if(arrayMaking(s)[2].equals("1"))
                        scoreView14.setImageResource(R.drawable.green_circle);
                    else
                        scoreView14.setImageResource(0);
                    if(arrayMaking(s)[3].equals("1"))
                        scoreView15.setImageResource(R.drawable.green_circle);
                    else
                        scoreView15.setImageResource(0);
                    if(arrayMaking(s)[4].equals("1"))
                        scoreView16.setImageResource(R.drawable.green_circle);
                    else
                        scoreView16.setImageResource(0);
                    if(arrayMaking(s)[5].equals("1"))
                        scoreView17.setImageResource(R.drawable.green_circle);
                    else
                        scoreView17.setImageResource(0);
                });
            }
        },delay,period);


    }


    public String binary (Date date, SimpleDateFormat formatter){
        int i =Integer.parseInt(formatter.format(date));
        return Integer.toString(i, 2);
    }
    public String[] arrayMaking (String string) {
        String[] array = {"0", "0", "0", "0", "0", "0"};
        int i =0;
        for (int j = string.length()-1; j >= 0; j--) {
            array[i] = string.substring(j, j + 1);
            i++;
        }
        return array;
    }
    public void date(View v){
        Intent intent = new Intent(MainActivity.this, ActivityDate.class);
        startActivity(intent);

    }
}



