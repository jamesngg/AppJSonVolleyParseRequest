package br.com.local.appjsonvolleyparserequest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<Herois> arrayList = new ArrayList<>();

    public RecyclerAdapter(ArrayList<Herois> arrayList) {

        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.modelo_lista, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);

        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.id.setText(arrayList.get(position).getId());
        holder.nome.setText(arrayList.get(position).getNome());
        holder.nomereal.setText(arrayList.get(position).getNomereal());
        holder.idade.setText(arrayList.get(position).getIdade());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView id, nome, nomereal, idade;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.txtId);
            nome = itemView.findViewById(R.id.txtNome);
            nomereal = itemView.findViewById(R.id.txtNomereal);
            idade = itemView.findViewById(R.id.txtIdade);
        }
    }
}