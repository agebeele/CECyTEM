package com.example.dual.solicitudServicioSocial;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dual.R;

import java.util.List;

public class servicio_adapter extends RecyclerView.Adapter<servicio_adapter.servicio_adapterViewHolder> {

    private OnItemClickListener listener;
    private List<String> nombreList ;
    private List<String> GrupoList;
    private List<String> NombreDependenciaList ;
    private List<String> TurnoList ;

    public servicio_adapter(List<String> nombreList, List<String> GrupoList,List<String> NombreDependenciaList, List<String> TurnoList) {
        this.nombreList = nombreList;
        this.GrupoList = GrupoList;
        this.NombreDependenciaList =NombreDependenciaList ;
        this.TurnoList = TurnoList ;
    }

    @NonNull
    @Override
    public servicio_adapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_servicio_adapter, parent, false);
        return new servicio_adapterViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull servicio_adapterViewHolder holder, int position) {
        holder.nombre.setText(nombreList.get(position));
        holder.grupo.setText(GrupoList.get(position));
        holder.turno.setText(TurnoList.get(position));
        holder.nombredependencia.setText(NombreDependenciaList.get(position));
    }

    @Override
    public int getItemCount() {
        return nombreList.size();
    }

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    public class servicio_adapterViewHolder extends RecyclerView.ViewHolder {
        TextView nombre, grupo, turno, nombredependencia;

        public servicio_adapterViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre = itemView.findViewById(R.id.nombreAlumno);
            grupo = itemView.findViewById(R.id.grupoAlumno);
            turno = itemView.findViewById(R.id.turnoAlumno);
            nombredependencia = itemView.findViewById(R.id.dependenciaAlumno);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION && listener != null) {
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }
}