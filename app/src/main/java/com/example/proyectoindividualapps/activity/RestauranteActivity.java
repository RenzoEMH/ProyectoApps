package com.example.proyectoindividualapps.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.proyectoindividualapps.R;
import com.example.proyectoindividualapps.entity.Servicio;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class RestauranteActivity extends AppCompatActivity {

    private int numero;
    private TextView titulo;
    private Button btnFood,btnPoll;
    private String nombre,foto;
    private double lat,lon;
    ServiciosAdapter serviciosAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurante);

        Intent inte = getIntent();
        numero = inte.getIntExtra("numero",0);

        titulo = findViewById(R.id.tituloLista);
        btnFood = findViewById(R.id.btnFood);
        btnPoll = findViewById(R.id.btnPoll);

        if(numero==1){
            titulo.setText("Lista de SuperMercados");
            btnFood.setVisibility(View.GONE);
            btnPoll.setVisibility(View.GONE);

            DatabaseReference superRef = FirebaseDatabase.getInstance().getReference().child("Supermercados");

            superRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    ArrayList<Servicio> lista = new ArrayList<>();

                    for (DataSnapshot data : dataSnapshot.getChildren()){
                        Servicio serv = new Servicio();
                        nombre = data.child("nombre").getValue(String.class);
                        foto = data.child("foto").getValue(String.class);
                        lat = data.child("lat").getValue(Double.class);
                        lon = data.child("lon").getValue(Double.class);
                        serv.setNombre(nombre);
                        serv.setFoto(foto);
                        serv.setLatitud(lat);
                        serv.setLongitud(lon);
                        serv.setTipo(1);
                        lista.add(serv);
                    }

                    serviciosAdapter = new ServiciosAdapter(lista,RestauranteActivity.this);
                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                   // recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(RestauranteActivity.this));
                    recyclerView.setAdapter(serviciosAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });


        }else if (numero==2){
            titulo.setText("Lista de Pollerías/Comida Rápida");
            btnFood.setVisibility(View.VISIBLE);
            btnPoll.setVisibility(View.VISIBLE);

            DatabaseReference superRef = FirebaseDatabase.getInstance().getReference().child("Pollerias");

            superRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    ArrayList<Servicio> lista = new ArrayList<>();

                    for (DataSnapshot data : dataSnapshot.getChildren()){
                        Servicio serv = new Servicio();
                        nombre = data.child("nombre").getValue(String.class);
                        foto = data.child("foto").getValue(String.class);
                        lat = data.child("lat").getValue(Double.class);
                        lon = data.child("lon").getValue(Double.class);
                        serv.setLatitud(lat);
                        serv.setLongitud(lon);
                        serv.setNombre(nombre);
                        serv.setFoto(foto);
                        serv.setTipo(2);

                        lista.add(serv);
                    }

                    serviciosAdapter = new ServiciosAdapter(lista,RestauranteActivity.this);
                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    // recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(RestauranteActivity.this));
                    recyclerView.setAdapter(serviciosAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

            btnFood.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseReference superRef = FirebaseDatabase.getInstance().getReference().child("Comida Rapida");

                    superRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            ArrayList<Servicio> lista = new ArrayList<>();

                            for (DataSnapshot data : dataSnapshot.getChildren()){
                                Servicio serv = new Servicio();
                                nombre = data.child("nombre").getValue(String.class);
                                foto = data.child("foto").getValue(String.class);
                                lat = data.child("lat").getValue(Double.class);
                                lon = data.child("lon").getValue(Double.class);
                                serv.setLatitud(lat);
                                serv.setLongitud(lon);
                                serv.setNombre(nombre);
                                serv.setFoto(foto);
                                serv.setTipo(3);
                                lista.add(serv);
                            }

                            serviciosAdapter = new ServiciosAdapter(lista,RestauranteActivity.this);
                            RecyclerView recyclerView = findViewById(R.id.recyclerView);
                            // recyclerView.setHasFixedSize(true);
                            recyclerView.setLayoutManager(new LinearLayoutManager(RestauranteActivity.this));
                            recyclerView.setAdapter(serviciosAdapter);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            });

            btnPoll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    DatabaseReference superRef = FirebaseDatabase.getInstance().getReference().child("Pollerias");

                    superRef.addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                            ArrayList<Servicio> lista = new ArrayList<>();

                            for (DataSnapshot data : dataSnapshot.getChildren()){
                                Servicio serv = new Servicio();
                                nombre = data.child("nombre").getValue(String.class);
                                foto = data.child("foto").getValue(String.class);
                                lat = data.child("lat").getValue(Double.class);
                                lon = data.child("lon").getValue(Double.class);
                                serv.setLatitud(lat);
                                serv.setLongitud(lon);
                                serv.setNombre(nombre);
                                serv.setFoto(foto);
                                serv.setTipo(2);
                                lista.add(serv);
                            }

                            serviciosAdapter = new ServiciosAdapter(lista,RestauranteActivity.this);
                            RecyclerView recyclerView = findViewById(R.id.recyclerView);
                            // recyclerView.setHasFixedSize(true);
                            recyclerView.setLayoutManager(new LinearLayoutManager(RestauranteActivity.this));
                            recyclerView.setAdapter(serviciosAdapter);
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            });

        }else{
            titulo.setText("Lista de Restaurantes");
            btnFood.setVisibility(View.GONE);
            btnPoll.setVisibility(View.GONE);

            DatabaseReference superRef = FirebaseDatabase.getInstance().getReference().child("Restaurantes");

            superRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    ArrayList<Servicio> lista = new ArrayList<>();

                    for (DataSnapshot data : dataSnapshot.getChildren()){
                        Servicio serv = new Servicio();
                        nombre = data.child("nombre").getValue(String.class);
                        foto = data.child("foto").getValue(String.class);
                        lat = data.child("lat").getValue(Double.class);
                        lon = data.child("lon").getValue(Double.class);
                        serv.setLatitud(lat);
                        serv.setLongitud(lon);
                        serv.setNombre(nombre);
                        serv.setFoto(foto);
                        serv.setTipo(4);
                        lista.add(serv);
                    }

                    serviciosAdapter = new ServiciosAdapter(lista,RestauranteActivity.this);
                    RecyclerView recyclerView = findViewById(R.id.recyclerView);
                    // recyclerView.setHasFixedSize(true);
                    recyclerView.setLayoutManager(new LinearLayoutManager(RestauranteActivity.this));
                    recyclerView.setAdapter(serviciosAdapter);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });

        }

    }
}