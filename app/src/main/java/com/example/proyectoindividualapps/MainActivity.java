package com.example.proyectoindividualapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.proyectoindividualapps.activity.RestauranteActivity;
import com.example.proyectoindividualapps.activity.SuperMercadoActivity;
import com.example.proyectoindividualapps.activity.TiendaActivity;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class MainActivity extends AppCompatActivity {

    private ImageView imagenPortada;
    private ImageButton supermercado,tienda,restaurante;
    private StorageReference storageReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storageReference = FirebaseStorage.getInstance().getReference();
        imagenPortada = findViewById(R.id.imageView);
        restaurante = findViewById(R.id.restaurant);
        tienda = findViewById(R.id.shop);
        supermercado = findViewById(R.id.supermarket);

        StorageReference fotoRef = storageReference.child("fotos/portada.png");
        Glide.with(this).load(fotoRef).into(imagenPortada);


        supermercado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, SuperMercadoActivity.class);
                int i= 1;
                Intent intent = new Intent(MainActivity.this, RestauranteActivity.class);
                intent.putExtra("numero",i);

                startActivity(intent);
            }
        });
        tienda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(MainActivity.this, TiendaActivity.class);
                int i= 2;
                Intent intent = new Intent(MainActivity.this, RestauranteActivity.class);
                intent.putExtra("numero",i);
                startActivity(intent);
            }
        });
        restaurante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i= 3;
                Intent intent = new Intent(MainActivity.this, RestauranteActivity.class);
                intent.putExtra("numero",i);
                startActivity(intent);
            }
        });


    }
}