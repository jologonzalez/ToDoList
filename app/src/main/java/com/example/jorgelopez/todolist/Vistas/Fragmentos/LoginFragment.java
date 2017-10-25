package com.example.jorgelopez.todolist.Vistas.Fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.example.jorgelopez.todolist.R;
import com.example.jorgelopez.todolist.Vistas.Presenter.ILoginPresenter;
import com.example.jorgelopez.todolist.Vistas.Presenter.LoginPresenter;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Jorge Lopez
 */
public class LoginFragment extends Fragment implements ILoginFragmentView{

    @BindView(R.id.txtEmailLogin)
    EditText txtEmailLogin;

    @BindView(R.id.txtPasswordLogin)
    EditText txtPasswordLogin;

    @BindView(R.id.progress)
    ProgressBar progress;

    @BindView(R.id.btnIngresarLogin)
    Button btnIngresarLogin;

    @BindView(R.id.CrearCuenta)
    Button CrearCuenta;

    @BindView(R.id.tvRecordar_contra)
    TextView tvRecordar_contra;

    private ILoginPresenter loginPresenter;

    private OnLoginFramentInteraction mListener;

    public LoginFragment() {
        // Required empty public constructor
    }

    public static LoginFragment newInstance() {
        LoginFragment fragment = new LoginFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login, container, false);

        ButterKnife.bind(this, view);

        loginPresenter = new LoginPresenter(this);

        return view;
    }

    @OnClick(R.id.btnIngresarLogin)
    @Override
    public void login() {

        String email = txtEmailLogin.getText().toString();
        String password = txtPasswordLogin.getText().toString();

        loginPresenter.login(email, password);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLoginFramentInteraction) {
            mListener = (OnLoginFramentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnLoginFragmentInteraction");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void habilitarVistas() {
        txtPasswordLogin.setEnabled(true);
        txtEmailLogin.setEnabled(true);
        btnIngresarLogin.setEnabled(true);
        CrearCuenta.setEnabled(true);
    }

    @Override
    public void deshabilitarVistas() {
        txtPasswordLogin.setEnabled(false);
        txtEmailLogin.setEnabled(false);
        btnIngresarLogin.setEnabled(false);
        CrearCuenta.setEnabled(false);
    }

    @Override
    public void mostrarProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarProgress() {
        progress.setVisibility(View.GONE);
    }

    @OnClick(R.id.CrearCuenta)
    @Override
    public void irARegistro() {
        if(mListener != null){
            mListener.irARegistro();
        }
    }

    @OnClick(R.id.tvRecordar_contra)
    @Override
    public void irARecordarContra() {
        if(mListener != null){
            mListener.irARecordarContra();
        }
    }

    @Override
    public void finalizarLogin() {
        if(mListener != null){
            mListener.finalizarLogin();
        }
    }

    @Override
    public void mostrarError(String mensaje) {
        Snackbar.make(getView(), mensaje, Snackbar.LENGTH_SHORT).show();
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnLoginFramentInteraction{

        void finalizarLogin();

        void irARegistro();

        void irARecordarContra();
    }
}
