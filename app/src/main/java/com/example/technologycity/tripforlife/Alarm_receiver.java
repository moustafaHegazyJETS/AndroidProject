package com.example.technologycity.tripforlife;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * Created by TECHNOLOGY CITY on 01/02/2018.
 */

public class Alarm_receiver extends BroadcastReceiver {

    boolean flag=false;

//    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    public void onReceive(Context context, Intent intent) {
        Log.i("receiver", "onReceive: sssssssssssssssssssssss ");

        String key = intent.getExtras().getString("Ex");



        Intent service_intent = new Intent(context,RingtonePlayingService.class);

        //pass the key
        service_intent.putExtra("Ex",key);
        service_intent.putExtra("id",intent.getExtras().getString("id"));

        Log.i(key, "onReceive: ");
        if(key.equals("on")&&!flag)
        {
            context.startService(service_intent);
            flag=true;

        }
        else
            if(key.equals("off"))
            {
                context.startService(service_intent);
                flag=false;
            }






    }
}
