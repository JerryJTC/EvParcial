package com.example.evparcial;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import WebService.Asynchtask;
import WebService.WebService;

public class MainActivity extends AppCompatActivity implements Asynchtask{

    ListView lstproduc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);


            Map<String, String> datos = new HashMap<String, String>();
            WebService ws= new WebService("https://fakestoreapi.com/products",
                    datos, MainActivity.this,MainActivity.this);
            ws.execute("GET");


            lstproduc = (ListView) findViewById(R.id.lstProcut);

            View header = getLayoutInflater().inflate(R.layout.lyencab, null);
            lstproduc.addHeaderView(header);
        }
    @Override
    public void processFinish(String result) throws JSONException {
        JSONObject JSONlista =  new JSONObject(result);
        JSONArray JSONlistapro=  JSONlista.getJSONArray("data");

        ArrayList<producto> datosProduc = producto.JsonObjectsBuild(JSONlistapro);

        adapproduc adaproduc = new adapproduc(this, datosProduc);

        lstproduc.setAdapter(adaproduc);




    }
    }
