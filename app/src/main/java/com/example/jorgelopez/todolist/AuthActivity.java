package com.example.jorgelopez.todolist;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.jorgelopez.todolist.R;
import com.example.jorgelopez.todolist.Vistas.Fragmentos.LoginFragment;
import com.example.jorgelopez.todolist.Vistas.Fragmentos.RecordarContraFragment;
import com.example.jorgelopez.todolist.Vistas.Fragmentos.RegistroFragment;
import com.example.jorgelopez.todolist.Vistas.ListActivity;

public class AuthActivity extends AppCompatActivity implements LoginFragment.OnLoginFramentInteraction, RegistroFragment.OnRegistroInteractionListener, RecordarContraFragment.OnRecordarContraInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        initFragment();

    }

    private void initFragment() {

        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frameAuthActivity, LoginFragment.newInstance());
        transaction.commit();

    }

    @Override
    public void finalizarLogin() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void irARegistro() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frameAuthActivity, RegistroFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void irARecordarContra() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frameAuthActivity, RecordarContraFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void irALogin() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frameAuthActivity, LoginFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void finalizarRegistro() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
        finish();
    }
}
