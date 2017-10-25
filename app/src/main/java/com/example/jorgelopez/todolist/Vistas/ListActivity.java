package com.example.jorgelopez.todolist.Vistas;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.jorgelopez.todolist.MDialogActivity;
import com.example.jorgelopez.todolist.Modelo.Tarea;
import com.example.jorgelopez.todolist.R;
import com.example.jorgelopez.todolist.Vistas.Adaptadores.ToDoListAdapter;
import com.example.jorgelopez.todolist.Vistas.Presenter.IListPresenter;
import com.example.jorgelopez.todolist.Vistas.Presenter.ListPresenter;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ListActivity extends AppCompatActivity implements IListView, ToDoListAdapter.OnListenerItemCheck, MDialogActivity.IListenerDialog {

    private IListPresenter listPresenter;
    private ToDoListAdapter adapter;

    @BindView(R.id.rvListToDO)
    RecyclerView rvListToDo;

    public ListActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        listPresenter = new ListPresenter(this);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListToDo.setLayoutManager(llm);

        List<Tarea> lsTarea = listPresenter.obtenerTareas();

        adapter = new ToDoListAdapter(lsTarea, this);

        rvListToDo.setAdapter(adapter);

    }

    @OnClick(R.id.btnEnviar)
    @Override
    public void clickAddTarea() {
        MDialogActivity dialogFragment = new MDialogActivity();
        dialogFragment.setCallback(this);
        dialogFragment.show(getFragmentManager(), "undialogo");
    }

    @Override
    public void refrescarListaTareas(List<Tarea> lsTarea) {
        adapter.setDataset(lsTarea);

        rvListToDo.getAdapter().notifyDataSetChanged();

        rvListToDo.scrollToPosition(rvListToDo.getAdapter().getItemCount() - 1);
    }

    @Override
    public void refrescarTarea(Tarea tarea, int posicion) {
        adapter.setItemDataset(tarea, posicion);
        rvListToDo.getAdapter().notifyItemChanged(posicion);
    }

    @Override
    public void itemCambioEstado(int posicion, boolean realizada) {
        listPresenter.itemCambioEstado(posicion, realizada);
    }

    @Override
    public void onClickAceptar(String descTarea1, String fecha) {
        listPresenter.addTarea(descTarea1, fecha);
    }
}
