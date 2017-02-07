package com.example.vv.myapplication;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.Vibrator;
import android.util.Log;

import java.util.Date;

public class MyService extends Service {

    String TAG = "MyService";
    Thread alarm;
    int min;
    int hour;

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        min = intent.getIntExtra("m", -1);
        hour = intent.getIntExtra("h", -1);
        if (alarm == null){
            alarm = new Thread() {
                public void run() {
                    long t =0;
                    while (!interrupted()) {
                        Date date = new Date();
                        int curMin = date.getMinutes();
                        int curHour = date.getHours();
                        if (curHour == hour && curMin == min) {
                            break;
                        }
                        try {
                            Thread.sleep(1000);
                            Log.d("Alarm", ""+t);
                            t++;
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                }};

        alarm.start();}
        return super.onStartCommand(intent, flags, startId);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
