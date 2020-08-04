package com.example.proyectoindividualapps.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.proyectoindividualapps.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DetallesActivity extends FragmentActivity implements OnMapReadyCallback {

    GoogleMap map;

    private ImageView logo;
    private TextView nombre,telefono;
    private String nombreRecibido,fotoRecibido;
    private int tipoRecibido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent inte = getIntent();
        nombreRecibido = inte.getStringExtra("nombre");
        tipoRecibido = inte.getIntExtra("tipo",0);
        fotoRecibido = inte.getStringExtra("foto");

        logo = findViewById(R.id.logo2);
        nombre = findViewById(R.id.nombreServ);
        telefono = findViewById(R.id.tlfServ);


        if(tipoRecibido == 1){
            DatabaseReference superRef = FirebaseDatabase.getInstance().getReference().child("Supermercados");

            superRef.addValueEventListener(new ValueEventListener() {
                String title,foto,telef;

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot keyId : dataSnapshot.getChildren()){
                        if(keyId.child("nombre").getValue().equals(nombreRecibido)){
                            title = keyId.child("nombre").getValue(String.class);
                            telef = keyId.child("telefono").getValue(String.class);
                            break;
                        }
                    }
                    nombre.setText(title);
                    telefono.setText(telef);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            StorageReference fotoRef = FirebaseStorage.getInstance().getReference().child("fotos/"+fotoRecibido);
            Glide.with(this).load(fotoRef).into(logo);
        }else if (tipoRecibido == 2){
            DatabaseReference superRef = FirebaseDatabase.getInstance().getReference().child("Pollerias");

            superRef.addValueEventListener(new ValueEventListener() {
                String title,foto,telef;

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot keyId : dataSnapshot.getChildren()){
                        if(keyId.child("nombre").getValue().equals(nombreRecibido)){
                            title = keyId.child("nombre").getValue(String.class);
                            telef = keyId.child("telefono").getValue(String.class);
                            break;
                        }
                    }
                    nombre.setText(title);
                    telefono.setText(telef);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            StorageReference fotoRef = FirebaseStorage.getInstance().getReference().child("fotos/"+fotoRecibido);
            Glide.with(this).load(fotoRef).into(logo);
        }else if(tipoRecibido == 3){
            DatabaseReference superRef = FirebaseDatabase.getInstance().getReference().child("Comida Rapida");

            superRef.addValueEventListener(new ValueEventListener() {
                String title,foto,telef;

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot keyId : dataSnapshot.getChildren()){
                        if(keyId.child("nombre").getValue().equals(nombreRecibido)){
                            title = keyId.child("nombre").getValue(String.class);
                            telef = keyId.child("telefono").getValue(String.class);
                            break;
                        }
                    }
                    nombre.setText(title);
                    telefono.setText(telef);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            StorageReference fotoRef = FirebaseStorage.getInstance().getReference().child("fotos/"+fotoRecibido);
            Glide.with(this).load(fotoRef).into(logo);
        }else{
            DatabaseReference superRef = FirebaseDatabase.getInstance().getReference().child("Restaurantes");

            superRef.addValueEventListener(new ValueEventListener() {
                String title,foto,telef;

                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    for (DataSnapshot keyId : dataSnapshot.getChildren()){
                        if(keyId.child("nombre").getValue().equals(nombreRecibido)){
                            title = keyId.child("nombre").getValue(String.class);
                            telef = keyId.child("telefono").getValue(String.class);
                            break;
                        }
                    }
                    nombre.setText(title);
                    telefono.setText(telef);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
            StorageReference fotoRef = FirebaseStorage.getInstance().getReference().child("fotos/"+fotoRecibido);
            Glide.with(this).load(fotoRef).into(logo);
        }

    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        Intent intent = getIntent();
        Log.d("ROLLL",String.valueOf(intent.getDoubleExtra("lat", 0)));
        Log.d("ROLLL22",String.valueOf(intent.getDoubleExtra("lon", 0)));

        LatLng latLng = new LatLng(intent.getDoubleExtra("lat", 0), intent.getDoubleExtra("lon", 0));
        map.addMarker(new MarkerOptions().position(latLng).title("Incidencia 1"));

        map.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 16.0f));

    }
}