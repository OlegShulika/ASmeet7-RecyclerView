package ru.olegshulika.asmeet7_recyclerview;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;
    private LinearLayoutManager mLayoutManager;
    private LocalBroadcastManager localBroadcastManager;
    private LocalBroadcastReceiver localBroadcstReceiver;

    private class LocalBroadcastReceiver extends BroadcastReceiver {
        LocalBroadcastReceiver(){super();}
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            Log.d(TAG,"onReceive "+action);
            if(TextService.KEY_BROADCAST.equals(action)) {
                String sysTime = "time="+intent.getLongExtra(TextService.KEY_TIME, 0);
                int itemType  = intent.getIntExtra(TextService.KEY_TYPE, -1);
                mAdapter.AddItem(itemType, sysTime+"/"+itemType);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, " onCreate");
        initViews();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);
        localBroadcstReceiver = new LocalBroadcastReceiver();
    }

    private void initViews(){
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recycler_view);
        mLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mAdapter = new CustomAdapter();
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    protected void onStart() {
        Log.d(TAG, " onStart");
        super.onStart();
        startService(TextService.newIntent(MainActivity.this, Command.START));
    }

    @Override
    protected void onResume() {
        Log.d(TAG, " onResume");
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(TextService.KEY_BROADCAST);
        localBroadcastManager.registerReceiver(localBroadcstReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        Log.d(TAG, " onPause");
        super.onPause();
        localBroadcastManager.unregisterReceiver(localBroadcstReceiver);

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, " onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, " onDestroy");
    }

}
