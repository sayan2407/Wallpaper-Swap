package com.example.wallpaperservice;

import android.app.Service;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.IBinder;
import android.service.wallpaper.WallpaperService;

import androidx.annotation.Nullable;

import java.io.IOException;

public class wallpaper extends Service implements Runnable {

    int[] imageId = {R.drawable.genie, R.drawable.food12} ;
    private int time,flag=0;

    private Bitmap b1,b2;
    private Thread t;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void run() {

            while (true)
            {
                if (flag == 0)
                {
                    try {
                        this.setWallpaper(b1);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    flag++ ;
                }
                else {
                    try {
                        this.setWallpaper(b2);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    flag-- ;
                }
                try {
                    Thread.sleep(time * 1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }


    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);

        Bundle b =  intent.getExtras() ;
        time = b.getInt("k") ;

        b1 = BitmapFactory.decodeResource(getResources() , imageId[0]) ;
        b2 = BitmapFactory.decodeResource(getResources() , imageId[1]) ;

        t = new Thread(wallpaper.this) ;
        t.start();
        return  START_STICKY ;
    }
}
