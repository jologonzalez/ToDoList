package com.example.jorgelopez.todolist.Vistas.Fragmentos;

/**
 * Created by Jorge Lopez on 24/10/2017.
 */

public interface IRecordarContraFragmentView {

    void habilitarVistas();
    void deshabilitarVistas();
    void recuperarContra();
    void irALogin();
    void mostrarError(String mensaje);

}
