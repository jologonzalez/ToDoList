package com.example.jorgelopez.todolist.Repositorio;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.jorgelopez.todolist.Modelo.Tarea;

/**
 * Created by Jorge Lopez on 3/10/2017.
 */

@Database(entities = {Tarea.class}, version = 1)
public abstract class AppDB extends RoomDatabase{

    private static AppDB instancia = null;

    public static void init(Context context){

        if(instancia == null){
            instancia = Room.databaseBuilder(context, AppDB.class, "tareas-db")
                    .allowMainThreadQueries()
                    .build();
        }

    }

    public static AppDB getIntance(){
        return instancia;
    }

    public abstract TareaDAO getTareaDAO();

}
