package com.example.jorgelopez.todolist.Vistas.Fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.jorgelopez.todolist.R;
import com.example.jorgelopez.todolist.Vistas.Presenter.IRecordarContraPresenter;
import com.example.jorgelopez.todolist.Vistas.Presenter.RecordarContraPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Jorge Lopez
 */
public class RecordarContraFragment extends Fragment implements IRecordarContraFragmentView {

    @BindView(R.id.txtEmailLogin)
    EditText txtEmailLogin;

    @BindView(R.id.btnRecuperarContra)
    Button btnRecuperarContra;

    private IRecordarContraPresenter recordarContraPresenter;

    private OnRecordarContraInteractionListener mListener;

    public RecordarContraFragment() {
        // Required empty public constructor
    }

    public static RecordarContraFragment newInstance() {
        RecordarContraFragment fragment = new RecordarContraFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recordar_contra, container, false);

        ButterKnife.bind(this, view);

        recordarContraPresenter = new RecordarContraPresenter(this);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnRecordarContraInteractionListener) {
            mListener = (OnRecordarContraInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnRecordarContraInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void habilitarVistas() {
        txtEmailLogin.setEnabled(true);
        btnRecuperarContra.setEnabled(true);
    }

    @Override
    public void deshabilitarVistas() {
        txtEmailLogin.setEnabled(false);
        btnRecuperarContra.setEnabled(false);
    }

    @OnClick(R.id.btnRecuperarContra)
    @Override
    public void recuperarContra() {
        String email = txtEmailLogin.getText().toString();

        recordarContraPresenter.recuperarContra(email);
    }

    @Override
    public void irALogin() {
        if(mListener != null){
            mListener.irALogin();
        }
    }

    @Override
    public void mostrarError(String mensaje) {
        Snackbar.make(getView(), mensaje, Snackbar.LENGTH_SHORT).show();
    }

    public interface OnRecordarContraInteractionListener {

        void irALogin();

    }
}
