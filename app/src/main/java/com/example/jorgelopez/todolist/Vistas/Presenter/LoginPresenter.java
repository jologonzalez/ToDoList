package com.example.jorgelopez.todolist.Vistas.Presenter;

import com.example.jorgelopez.todolist.Dominio.CallBackInteractor;
import com.example.jorgelopez.todolist.Dominio.ILUsuario;
import com.example.jorgelopez.todolist.Dominio.LUsuario;
import com.example.jorgelopez.todolist.Vistas.Fragmentos.ILoginFragmentView;

/**
 * Created by Jorge Lopez on 24/10/2017.
 */

public class LoginPresenter implements ILoginPresenter{

    private ILoginFragmentView view;
    private ILUsuario lUsuario;

    public LoginPresenter(ILoginFragmentView view){
        this.view = view;
        lUsuario = new LUsuario();
    }

    @Override
    public void login(String email, String password) {
        view.deshabilitarVistas();
        view.mostrarProgress();

        try {
            lUsuario.authUsuario(email, password, new CallBackInteractor<String>() {
                @Override
                public void success(String data) {
                    view.habilitarVistas();
                    view.ocultarProgress();
                    view.finalizarLogin();
                }

                @Override
                public void error(String error) {
                    view.habilitarVistas();
                    view.ocultarProgress();
                    view.mostrarError(error);
                }
            });
        }catch (Exception e){
            view.habilitarVistas();
            view.ocultarProgress();
            view.mostrarError(e.getMessage());
        }
    }

}
