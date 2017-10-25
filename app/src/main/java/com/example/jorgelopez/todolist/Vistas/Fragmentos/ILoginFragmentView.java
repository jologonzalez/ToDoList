package com.example.jorgelopez.todolist.Vistas.Fragmentos;

/**
 * Created by Jorge Lopez on 24/10/2017.
 */

public interface ILoginFragmentView {

    void habilitarVistas();
    void deshabilitarVistas();
    void mostrarProgress();
    void ocultarProgress();
    void login();
    void irARegistro();
    void irARecordarContra();
    void finalizarLogin();
    void mostrarError(String mensaje);

}
