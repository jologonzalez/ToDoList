package com.example.jorgelopez.todolist;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jorgelopez.todolist.Vistas.ListActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GetTokenResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegistroActivity extends AppCompatActivity {

    @BindView(R.id.txtNombre)
    EditText txtNombre;

    @BindView(R.id.txtCorreo)
    EditText txtCorreo;

    @BindView(R.id.txtContra)
    EditText txtContra;

    @BindView(R.id.textView)
    TextView textView;

    @BindView(R.id.btnRegistrar)
    Button btnRegistrar;

    private FirebaseAuth auth;

    private FirebaseDatabase database;

    private DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        ButterKnife.bind(this);

        auth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();

        reference = database.getReference("Usuarios");

    }

    @OnClick(R.id.btnRegistrar)
    public void clickRegistrar() {

        final String nombre = txtNombre.getText().toString();
        String email = txtCorreo.getText().toString();
        String contra = txtContra.getText().toString();

        btnRegistrar.setEnabled(false);

        auth.createUserWithEmailAndPassword(email, contra).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {

                Intent intent = new Intent(RegistroActivity.this, ListActivity.class);

                startActivity(intent);

                finish();

            }
        });
    }

    @OnClick(R.id.textView)
    public void clickYaTengoUsusario() {

        textView.setEnabled(false);

        Intent intent = new Intent(RegistroActivity.this, IngresoActivity.class);

        startActivity(intent);

        finish();

    }

}
