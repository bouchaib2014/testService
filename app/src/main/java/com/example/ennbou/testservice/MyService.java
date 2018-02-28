package com.example.ennbou.testservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service {



    private static boolean running = false;

    public MyService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.running = true;
        Log.d("service", "create");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("service", "start command");
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        running = false;
        Log.d("service", "died");
    }

    public static boolean isRunning() {
        return running;
    }

 /*   private boolean isServiceRunning() {
        ActivityManager manager = (ActivityManager) getSystemService(ACTIVITY_SERVICE);
        for (RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)){
            if("com.example.MyNeatoIntentService".equals(service.service.getClassName())) {
                return true;
            }
        }
        return false;
    }*/
}
