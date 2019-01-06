package ru.olegshulika.asmeet7_recyclerview;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

@interface Command {
    int INVALID = -1;
    int STOP = 0;
    int START = 1;
}

public class TextService extends Service {
    public static final String  KEY_BROADCAST = "ru.olegshulika.asmeet7.LOCAL_BROADCAST";
    public static final String  KEY_TIME = "LOCAL_BROADCAST_TIME";
    public static final String  KEY_TYPE = "LOCAL_BROADCAST_ITEMTYPE";

    private static final String TAG = "_TextService";
    private static final int MODE = Service.START_NOT_STICKY;
    private static final String KEY_COMMAND = "text.service.cmd";
    private static final int SERVICE_WORKTIME_LIMIT = 1800000;     // 30 min
    private static final int SERVICE_SLEEP_TIME = 5000;            // wait 5 sec
    private static final int SERVICE_MAXITEMTYPES = 3;             // item types 1-3

    private boolean serviceStarted = false;
    private boolean isServiceStarted() {
        return serviceStarted;
    }
    private void setServiceStarted(boolean serviceStarted) {
        this.serviceStarted = serviceStarted;
    }

    private LocalBroadcastManager localBroadcastManager;

    @Override
    public synchronized int onStartCommand(Intent intent, int flags, final int startId) {
        Log.d(TAG, " onStartCommand "+flags+" "+startId);
        switch (getCommand(intent)) {
            case Command.START:
                if (isServiceStarted())
                    return MODE;
                Log.d(TAG, " starting..." + startId);
                setServiceStarted(true);
                startSrv();
                break;
            case Command.STOP:
                if (!isServiceStarted())
                    return MODE;
                Log.d(TAG, " stopping...");
                stopSelf(startId);
                setServiceStarted(false);
                break;
            default:
                Log.d(TAG, " Invalid command");
                break;
        }
        return MODE;
    }

    private void startSrv() {              // Service workout thread
        new Thread(new Runnable() {         // Start service
            @Override
            public void run() {
                setServiceStarted(true);
                int workTime=SERVICE_WORKTIME_LIMIT;
                while (workTime>0 && isServiceStarted()){
                    workTime -= SERVICE_SLEEP_TIME;
                    try {
                        Thread.sleep(SERVICE_SLEEP_TIME);
                        sendLocalBroadcast(System.currentTimeMillis());
                    } catch (Exception ex){
                        Log.d(TAG,ex.getMessage());
                    }
                }
                stopSelf();
                setServiceStarted(false);
            }
        }).start();
    }

    private void sendLocalBroadcast(long sysTime) {
        int itemType = (int)(sysTime % SERVICE_MAXITEMTYPES) + 1;
        Intent broadcastIntent = new Intent(KEY_BROADCAST);
        broadcastIntent.putExtra(KEY_TIME, sysTime);
        broadcastIntent.putExtra(KEY_TYPE, itemType);
        localBroadcastManager.sendBroadcast(broadcastIntent);
        Log.d(TAG,"sendLocalBroadcast "+sysTime+" t="+itemType);
    }

    public static final Intent newIntent(Context context, int serviceCommand){
        Intent intent = new Intent(context, TextService.class);
        intent.putExtra(KEY_COMMAND, serviceCommand);
        return intent;
    }

    public int getCommand (Intent intent) {
        return intent.getIntExtra(KEY_COMMAND, Command.INVALID);
    }

    @Override
    public void onCreate() {
        Log.d(TAG, " onCreate");
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        super.onCreate();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.d(TAG, " onBind");
        return null;
    }


    @Override
    public void onDestroy() {
        Log.d(TAG, " onDestroy");
        stopSelf();
        setServiceStarted(false);
        super.onDestroy();
    }
}
