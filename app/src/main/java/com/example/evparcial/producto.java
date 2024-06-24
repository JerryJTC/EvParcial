package com.example.evparcial;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class producto {

    private String titulo;
    private String categoria;
    private String precio;
    private String descripcion;
    private String imagen;

    public producto(JSONObject a) throws JSONException {

        titulo =  a.getString("title").toString();

        categoria =  a.getString("category").toString() ;
        precio=  a.getString("price").toString() ;
        descripcion = a.getString("description").toString() ;
        imagen =  a.getString("image").toString();


    }
    public static ArrayList<producto> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<producto> productos = new ArrayList<>();

        for (int i = 0; i < datos.length() && i<20; i++) {
            productos.add(new producto(datos.getJSONObject(i)));
        }
        return productos;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public String getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getImagen() {
        return imagen;
    }
}
