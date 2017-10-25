package com.example.jorgelopez.todolist.Vistas.Adaptadores;

import android.graphics.Paint;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jorgelopez.todolist.Modelo.Tarea;
import com.example.jorgelopez.todolist.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Jorge Lopez on 12/09/2017.
 */

public class ToDoListAdapter extends RecyclerView.Adapter<ToDoListAdapter.ItemToDoList> {

    private List<Tarea> dataset;
    private OnListenerItemCheck onListenerItemCheck;

    public ToDoListAdapter(List<Tarea> dataset, OnListenerItemCheck onListenerItemCheck) {
        super();
        this.dataset = dataset;
        this.onListenerItemCheck = onListenerItemCheck;
    }

    @Override
    public ItemToDoList onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_list, parent, false);

        return new ItemToDoList(view);
    }

    @Override
    public void onBindViewHolder(ItemToDoList holder, int position) {
        Tarea tarea = dataset.get(position);

        if (tarea.isRealizado()) {
            holder.tvTarea.setPaintFlags(holder.tvTarea.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        } else {
            holder.tvTarea.setPaintFlags(holder.tvTarea.getPaintFlags() & ~Paint.STRIKE_THRU_TEXT_FLAG);
        }

        holder.tvTarea.setText(tarea.getNombre());
        holder.tvFechaItem.setText(tarea.getFecha());
        holder.chkTarea.setChecked(tarea.isRealizado());
    }

    public void setDataset(List<Tarea> dataset){
        this.dataset = dataset;
    }

    public void setItemDataset(Tarea tarea, int index){
        this.dataset.set(index, tarea);
    }

    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ItemToDoList extends RecyclerView.ViewHolder {

        @BindView(R.id.chkTarea)
        AppCompatCheckBox chkTarea;

        @BindView(R.id.tvTarea)
        TextView tvTarea;

        @BindView(R.id.tvFechaItem)
        TextView tvFechaItem;

        public ItemToDoList(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

            if (onListenerItemCheck != null) {
                chkTarea.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onListenerItemCheck.itemCambioEstado(getAdapterPosition(), chkTarea.isChecked());
                    }
                });
            }

        }
    }

    public interface OnListenerItemCheck {

        void itemCambioEstado(int posicion, boolean realizada);

    }

}
