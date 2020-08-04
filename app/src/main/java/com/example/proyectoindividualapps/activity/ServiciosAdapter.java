package com.example.proyectoindividualapps.activity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.proyectoindividualapps.R;
import com.example.proyectoindividualapps.entity.Servicio;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class ServiciosAdapter extends RecyclerView.Adapter<ServiciosAdapter.ServicioViewHolder> {

    private ArrayList<Servicio> listaServicios;
    private static Context context;

    private static String url;



    public ServiciosAdapter(ArrayList<Servicio> servicioData, Context context){
        Log.d("TAGGGG", "adapter initialized");
        this.listaServicios = servicioData;
        this.context = context;

    }

    public static class ServicioViewHolder extends RecyclerView.ViewHolder{

        TextView textview;
        ImageView imageview;
        ImageButton imagebtn;

        public ServicioViewHolder( View itemView) {
            super(itemView);
            textview = itemView.findViewById(R.id.nombreServicio);
            imageview = itemView.findViewById(R.id.logo);
            imagebtn = itemView.findViewById(R.id.detallesServ);
        }

        public void asignarDatos(Servicio servicio) {
            textview.setText(servicio.getNombre());
            url = servicio.getFoto();
            StorageReference fotoRef = FirebaseStorage.getInstance().getReference().child("fotos/"+url);
            Glide.with(context).load(fotoRef).into(imageview);

        }

        public void botonDetalles(final Servicio servicio) {

            try{
                imagebtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(context, DetallesActivity.class);
                        intent.putExtra("nombre",servicio.getNombre());
                        intent.putExtra("tipo",servicio.getTipo());
                        intent.putExtra("foto",servicio.getFoto());
                        intent.putExtra("lat", servicio.getLatitud());
                        intent.putExtra("lon", servicio.getLongitud());

                        context.startActivity(intent);
                    }
                });
            }catch (NullPointerException exception){

            }
        }

    }

    @NonNull
    @Override
    public ServicioViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_rv, parent, false);
        ServicioViewHolder servicioViewHolder = new ServicioViewHolder(itemView);
        return servicioViewHolder;
    }

    @Override
    public void onBindViewHolder(ServicioViewHolder holder, int position) {

        holder.asignarDatos(listaServicios.get(position));
        holder.botonDetalles(listaServicios.get(position));
    }

    @Override
    public int getItemCount() {
        if (listaServicios != null){
            return listaServicios.size();
        } else {
            return 0;
        }
    }
}
