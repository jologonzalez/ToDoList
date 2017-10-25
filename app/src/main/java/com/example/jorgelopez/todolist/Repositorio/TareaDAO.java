package com.example.jorgelopez.todolist.Repositorio;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.jorgelopez.todolist.Modelo.Tarea;

import java.util.List;

/**
 * Created by Jorge Lopez on 3/10/2017.
 */

@Dao
public interface TareaDAO {

    @Insert
    void insert(Tarea... tareas);

    @Update
    void update(Tarea... tareas);

    @Delete
    void delete(Tarea tarea);

    @Query("select * from tareas")
    List<Tarea> obtenerTodos();

    @Query("select * from tareas where id = :id")
    Tarea obtenerXID(int id);

}
