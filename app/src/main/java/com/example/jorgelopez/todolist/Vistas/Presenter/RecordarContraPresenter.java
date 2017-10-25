package com.example.jorgelopez.todolist.Vistas.Presenter;

import com.example.jorgelopez.todolist.Dominio.CallBackInteractor;
import com.example.jorgelopez.todolist.Dominio.ILUsuario;
import com.example.jorgelopez.todolist.Dominio.LUsuario;
import com.example.jorgelopez.todolist.Vistas.Fragmentos.IRecordarContraFragmentView;

/**
 * Created by Jorge Lopez on 24/10/2017.
 */

public class RecordarContraPresenter implements IRecordarContraPresenter{

    private IRecordarContraFragmentView view;
    private ILUsuario lUsuario;

    public RecordarContraPresenter(IRecordarContraFragmentView view){
        this.view = view;
        lUsuario = new LUsuario();
    }

    @Override
    public void recuperarContra(String email) {

        view.deshabilitarVistas();

        try {
            lUsuario.recuperarContra(email, new CallBackInteractor<String>() {
                @Override
                public void success(String data) {
                    view.habilitarVistas();
                    view.irALogin();
                }

                @Override
                public void error(String error) {
                    view.habilitarVistas();
                    view.mostrarError(error);
                }
            });
        }catch (Exception e){
            view.habilitarVistas();
            view.mostrarError(e.getMessage());
        }
    }
}
