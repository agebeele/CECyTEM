package com.example.dual;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdapterCE extends RecyclerView.Adapter<AdapterCE.AdapterCEViewHolder> {

    private List<item_ce> item_ceList;

    public AdapterCE(List<item_ce> item_ceList) {
        this.item_ceList = item_ceList;
    }

    @NonNull
    @Override
    public AdapterCE.AdapterCEViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_adapter_ce, parent, false);
        return new AdapterCEViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCE.AdapterCEViewHolder holder, int position) {
        item_ce itemce = item_ceList.get(position);
        holder.imagen.setImageResource(itemce.getImagen());
        holder.titulo.setText(itemce.getTitulo());
        holder.descripcion.setText(itemce.getDescripcion());
        holder.fecha.setText(itemce.getFecha());
        holder.hora.setText(itemce.getHora());
    }

    @Override
    public int getItemCount() {
        return item_ceList.size();
    }
    public static class AdapterCEViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView titulo, descripcion, fecha, hora;

        public AdapterCEViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_publicacion);
            titulo = itemView.findViewById(R.id.titulo_publicacion);
            descripcion = itemView.findViewById(R.id.descripcion_publicacion);
            fecha = itemView.findViewById(R.id.fecha_publicacion);
            hora = itemView.findViewById(R.id.hora_publicacion);
        }
    }
}