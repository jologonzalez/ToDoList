package com.example.jorgelopez.todolist.App;

import android.app.Application;

import com.example.jorgelopez.todolist.Repositorio.AppDB;
import com.facebook.FacebookButtonBase;
import com.facebook.FacebookSdk;
import com.facebook.appevents.AppEventsLogger;

/**
 * Created by Jorge Lopez on 20/09/2017.
 */

public class ToDoListAplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        FacebookSdk.sdkInitialize(getApplicationContext());
        AppEventsLogger.activateApp(this);

        AppDB.init(getApplicationContext());

    }
}
