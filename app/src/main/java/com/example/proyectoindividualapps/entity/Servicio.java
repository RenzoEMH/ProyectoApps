package com.example.proyectoindividualapps.entity;

public class Servicio {

    private String nombre;
    private String foto;
    private double latitud;

    private double longitud;
    private String telefono;
    private int tipo;



    public Servicio(){}

    public Servicio(String url, String nombre, String telefono, int tipo, double latitud, double longitud) {
        this.nombre = nombre;
        this.foto = url;
        this.telefono = telefono;
        this.tipo = tipo;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }


    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    public double getLatitud() {
        return latitud;
    }

    public void setLatitud(double latitud) {
        this.latitud = latitud;
    }

    public double getLongitud() {
        return longitud;
    }

    public void setLongitud(double longitud) {
        this.longitud = longitud;
    }



}
