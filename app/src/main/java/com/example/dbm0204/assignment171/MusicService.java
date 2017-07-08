package com.example.dbm0204.assignment171;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.NotificationCompat;

/**
 * Created by Ashutosh on 08-07-2017.
 */
//Creating class by extending Service class and work as a Seervice.
public class MusicService extends Service
{

    MediaPlayer musicPlayer;  //Creating object of MediaPlayer.
    @Nullable
    @Override
    //onBind method.
    public IBinder onBind(Intent intent)
    {
        return null;
    }

    @Override
    //onCreate method for service.
    public void onCreate()
    {
        //Setting MediaPPlayer object with its Id.
        musicPlayer = MediaPlayer.create(getApplicationContext(),R.raw.mujhe_haq_hai);
        super.onCreate();
    }
    @Override
    //onStartCommand method.
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        musicPlayer.start();   //Starting musicPlayer.
        musicPlayer.setLooping(false);   //Selecting looping as false.
        return START_STICKY;   //this Service will last even if Activity is Destroyed.
    }
    @Override
    //onDestroy method.
    public void onDestroy()
    {
        musicPlayer.release();   //releasing MediaPlayer object.

        //Creating object of Notification Builder and assigning prperties to it.
        NotificationCompat.Builder builder =
                (NotificationCompat.Builder) new NotificationCompat.Builder(this)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("Assignment_17.1")
                        .setContentText("Notification released and focus taken to MainActivity.");

        //Intent to switch to MainActivity.
        Intent notificationIntent = new Intent(MusicService.this, MainActivity.class);

        //Pending Intent which will take Notification to MainActivity.
        PendingIntent contentIntent = PendingIntent.getActivity(this, 0, notificationIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        //Setting Intent to Builder.
        builder.setContentIntent(contentIntent);

        // Add as notification
        NotificationManager manager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(0, builder.build());   //notify.

        super.onDestroy();
    }
}
