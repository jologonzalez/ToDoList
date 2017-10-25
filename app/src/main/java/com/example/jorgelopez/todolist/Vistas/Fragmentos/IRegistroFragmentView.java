package com.example.jorgelopez.todolist.Vistas.Fragmentos;

/**
 * Created by Jorge Lopez on 24/10/2017.
 */

public interface IRegistroFragmentView {

    void habilitarControles();
    void deshabilitarControles();
    void mostrarProgress();
    void ocultarProgress();
    void registrar();
    void mostrarError(String error);
    void irALogin();
    void finalizarRegistro();

}
