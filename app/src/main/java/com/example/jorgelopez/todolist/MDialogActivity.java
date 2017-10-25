package com.example.jorgelopez.todolist;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

import butterknife.ButterKnife;


public class MDialogActivity extends DialogFragment {

    private int dia, mes, ano;

    private String TareaT, FechaT;

    FirebaseAuth auth;

    FirebaseDatabase database;

    private DatabaseReference reference;

    private IListenerDialog listenerDialog;

    public MDialogActivity() {
    }

    public void setCallback(IListenerDialog listenerDialog){
        this.listenerDialog = listenerDialog;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        final View view = getActivity().getLayoutInflater().inflate(R.layout.activity_mdialog, null);

        ButterKnife.bind(this, view);

        final EditText txtDTarea = (EditText)view.findViewById(R.id.txtDTarea);
        final TextView tvFecha = (TextView) view.findViewById(R.id.tvFecha);
        final Button btnFecha = (Button) view.findViewById(R.id.btnFecha);

        auth = FirebaseAuth.getInstance();

        database = FirebaseDatabase.getInstance();

        reference = database.getReference("Usuarios");

        final String Uid = auth.getCurrentUser().getUid();

        builder.setView(view);

        btnFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                dia = calendar.get(Calendar.DAY_OF_MONTH);
                mes = calendar.get(Calendar.MONTH);
                ano = calendar.get(Calendar.YEAR);

                DatePickerDialog datePickerDialog = new DatePickerDialog(v.getContext(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {

                        tvFecha.setText(dayOfMonth + "/" + (month + 1) + "/" + year);
                    }
                }, dia, mes, ano);

                datePickerDialog.show();
            }
        });

        builder.setTitle("Agregar tarea")
                .setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        TareaT = txtDTarea.getText().toString();
                        FechaT = tvFecha.getText().toString();

                        listenerDialog.onClickAceptar(TareaT, FechaT);

                        String key =  reference.child(Uid).push().getKey();
                        reference.child(Uid).child(key).child("Tarea").setValue(TareaT);
                        reference.child(Uid).child(key).child("Fecha").setValue(FechaT);

                    }
                }).setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        final AlertDialog dialog = builder.create();

        return dialog;

    }

    public interface IListenerDialog{
        void onClickAceptar(String descTarea1, String fecha);
    }

}
