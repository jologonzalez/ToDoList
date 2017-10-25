package com.example.jorgelopez.todolist.Vistas.Presenter;

import com.example.jorgelopez.todolist.Dominio.CallBackInteractor;
import com.example.jorgelopez.todolist.Dominio.ILUsuario;
import com.example.jorgelopez.todolist.Dominio.LUsuario;
import com.example.jorgelopez.todolist.Modelo.Usuario;
import com.example.jorgelopez.todolist.Vistas.Fragmentos.IRegistroFragmentView;

/**
 * Created by Jorge Lopez on 24/10/2017.
 */

public class RegistroPresenter implements IRegistroPresenter{

    private IRegistroFragmentView view;
    private ILUsuario lUsuario;

    public RegistroPresenter(IRegistroFragmentView view) {
        this.view = view;
        lUsuario = new LUsuario();
    }

    @Override
    public void registrar(String nombre, String email, String password) {

        view.deshabilitarControles();
        view.mostrarProgress();

        try {
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setNombre(nombre);

            lUsuario.crearUsuario(usuario, password, new CallBackInteractor<String>() {
                @Override
                public void success(String data) {
                    view.habilitarControles();
                    view.ocultarProgress();
                    view.finalizarRegistro();
                }

                @Override
                public void error(String error) {
                    view.deshabilitarControles();
                    view.ocultarProgress();
                    view.mostrarError(error);
                }
            });


        } catch (Exception e) {
            view.deshabilitarControles();
            view.ocultarProgress();
            view.mostrarError(e.getMessage());
        }

    }
}
