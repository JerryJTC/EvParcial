package com.example.evparcial;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class adapproduc extends ArrayAdapter<producto> {

    public adapproduc(Context context, ArrayList<producto> datos) {
        super(context, R.layout.lyitem, datos);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitem, null);

        TextView lblTitulo = (TextView)item.findViewById(R.id.lbltitulo);
        lblTitulo.setText(getItem(position).getTitulo());

        TextView lblCate = (TextView)item.findViewById(R.id.lblcategoria);
        lblCate.setText(getItem(position).getCategoria());

        TextView lblPrecio= (TextView)item.findViewById(R.id.lblprecio);
        lblPrecio.setText(getItem(position).getPrecio());

        TextView lblDesc= (TextView)item.findViewById(R.id.lbldescripcion);
        lblDesc.setText(getItem(position).getDescripcion());

        ImageView imageView = (ImageView)item.findViewById(R.id.imgprod);
        Glide.with(this.getContext())
                .load(getItem(position).getImagen())
                .into(imageView);


        return(item);

    }
}