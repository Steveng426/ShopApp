package com.example.shopapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;
import java.util.zip.Inflater;

public class Adaptador extends RecyclerView.Adapter<Adaptador.Holder> {
    List<modeloProducto> lista;

    public Adaptador(List<modeloProducto> lista) {
        this.lista = lista;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card,parent,false);
        Adaptador.Holder holder = new Adaptador.Holder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.nombre.setText(lista.get(position).getNombre());
        holder.categoria.setText(lista.get(position).getCategoria());
        holder.catidad.setText(""+lista.get(position).getCantidad());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        private TextView nombre, categoria, catidad;
        private CardView cardView;
        public Holder(@NonNull View itemView) {
            super(itemView);
            nombre= itemView.findViewById(R.id.itemnombre);
            categoria=itemView.findViewById(R.id.itemcategoria);
            catidad=itemView.findViewById(R.id.itemcantidad);
            cardView=itemView.findViewById(R.id.cardview1);

        }
    }
}
