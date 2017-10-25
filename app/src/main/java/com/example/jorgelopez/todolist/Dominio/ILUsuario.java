package com.example.jorgelopez.todolist.Dominio;

import com.example.jorgelopez.todolist.Modelo.Usuario;

/**
 * Created by Jorge Lopez on 24/10/2017.
 */

public interface ILUsuario {

    void crearUsuario(Usuario usuario, String password, CallBackInteractor<String> callBackInteractor);

    void authUsuario(String email, String password, CallBackInteractor<String> callBackInteractor);

    void recuperarContra(String email, CallBackInteractor<String> callBackInteractor);

}
