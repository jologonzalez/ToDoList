package com.example.jorgelopez.todolist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.jorgelopez.todolist.Vistas.ListActivity;
import com.facebook.AccessToken;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FacebookAuthProvider;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class IngresoActivity extends AppCompatActivity {

    @BindView(R.id.txtCorreo)
    EditText txtCorreo;

    @BindView(R.id.txtContra)
    EditText txtContra;

    @BindView(R.id.btnIngresar)
    Button btnIngresar;

    @BindView(R.id.btnFacebook)
    LoginButton btnFacebook;

    private FirebaseAuth auth;

    private CallbackManager callbackManager;

    private FirebaseAuth.AuthStateListener authListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingreso);

        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance();

        callbackManager = CallbackManager.Factory.create();

        authListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {

                FirebaseUser user = firebaseAuth.getCurrentUser();

                if (user != null) {
                    Log.d("Login", user.getUid());
                } else {
                    Intent intent = new Intent(IngresoActivity.this, ListActivity.class);
                    startActivity(intent);
                    Log.d("Login", "Sing out");
                }

            }
        };

    }

    @OnClick(R.id.btnIngresar)
    public void clickIngresar() {

        String correo = txtCorreo.getText().toString();
        String contra = txtContra.getText().toString();

        btnIngresar.setEnabled(false);

        auth.signInWithEmailAndPassword(correo, contra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Intent intent = new Intent(IngresoActivity.this, ListActivity.class);

                    startActivity(intent);

                    finish();
                }

            }
        });

    }

    @OnClick(R.id.btnRegistrar)
    public void clickRegistrar() {

        Intent intent = new Intent(IngresoActivity.this, RegistroActivity.class);

        startActivity(intent);

    }


    @OnClick(R.id.btnFacebook)
    public void clickIngresoFacebook() {

        btnFacebook.setReadPermissions("email");

        btnFacebook.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {

                signInWithFacebook(loginResult.getAccessToken());

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException error) {

            }
        });

    }


    @Override
    protected void onStart() {
        super.onStart();
        auth.addAuthStateListener(authListener);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (authListener != null) {
            auth.removeAuthStateListener(authListener);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }

    private void signInWithFacebook(AccessToken accessToken) {

        AuthCredential authCredential = FacebookAuthProvider.getCredential(accessToken.getToken());

        auth.signInWithCredential(authCredential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                if (task.isSuccessful()) {

                    Intent intent = new Intent(IngresoActivity.this, ListActivity.class);

                    startActivity(intent);

                    finish();
                }

            }
        });

    }

}
