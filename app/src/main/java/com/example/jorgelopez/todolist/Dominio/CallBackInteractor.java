package com.example.jorgelopez.todolist.Dominio;

/**
 * Created by Jorge Lopez on 24/10/2017.
 */

public interface CallBackInteractor<T> {

    void success(T data);

    void error(String error);

}
