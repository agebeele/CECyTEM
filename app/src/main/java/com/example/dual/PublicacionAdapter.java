package com.example.dual;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PublicacionAdapter extends RecyclerView.Adapter<PublicacionAdapter.PublicacionViewHolder> {
    private List<item_publicacion>itemPublicacionList;

    public PublicacionAdapter(List<item_publicacion> itemPublicacionList) {
        this.itemPublicacionList = itemPublicacionList;
    }

    @NonNull
    @Override
    public PublicacionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_publicacion_adapter, parent, false);
        return new PublicacionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PublicacionViewHolder holder, int position) {
        item_publicacion itemPublicacion = itemPublicacionList.get(position);
        holder.imagen.setImageResource(itemPublicacion.getImagen());
        holder.titulo.setText(itemPublicacion.getTitulo());
        holder.descripcion.setText(itemPublicacion.getDescripcion());
        holder.fecha.setText(itemPublicacion.getFecha());
        holder.hora.setText(itemPublicacion.getHora());
    }

    @Override
    public int getItemCount() {
        return itemPublicacionList.size();
    }

    public static class PublicacionViewHolder extends RecyclerView.ViewHolder{
        ImageView imagen;
        TextView titulo, descripcion, fecha, hora;

        public PublicacionViewHolder(@NonNull View itemView) {
            super(itemView);
            imagen = itemView.findViewById(R.id.imagen_publicacion);
            titulo = itemView.findViewById(R.id.titulo_publicacion);
            descripcion = itemView.findViewById(R.id.descripcion_publicacion);
            fecha = itemView.findViewById(R.id.fecha_publicacion);
            hora = itemView.findViewById(R.id.hora_publicacion);
        }
    }
}