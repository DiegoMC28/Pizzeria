package com.example.pizzeria;

import androidx.annotation.XmlRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.text.Layout;
import android.util.Log;
import android.util.Xml;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.ServiceConfigurationError;

import Modelo.Servicio;

public class ActivityConfiguracion extends AppCompatActivity implements View.OnClickListener {
    ConstraintLayout layoutDeAqui;
    Spinner colores;
    ArrayList arrayColores;
    Button btnCambiaColor;
    Servicio servicio;
    TextView textoSeleccionaFondo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        textoSeleccionaFondo = findViewById(R.id.textoSeleccionaFondo);
        servicio = new Servicio(this);
        arrayColores = new ArrayList<>();
        arrayColores.add("Rojo");
        arrayColores.add("Azul");
        arrayColores.add("Verde");
        arrayColores.add("Blanco");
        arrayColores.add("Morado");
        arrayColores.add("Negro");

        ArrayAdapter adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, arrayColores);


        colores = findViewById(R.id.spColores);
        colores.setAdapter(adaptador);
        colores.setBackgroundColor(Color.BLACK);

        btnCambiaColor = findViewById(R.id.btnCambiaColor);
        layoutDeAqui = findViewById(R.id.layout1);
        ActivityAHeredar.cambiaColor(layoutDeAqui, this);

        if(ActivityAHeredar.colorFondo == android.R.color.black){

            btnCambiaColor.setTextColor(Color.WHITE);
            btnCambiaColor.setBackgroundColor(Color.rgb(200, 0, 0));
            textoSeleccionaFondo.setTextColor(Color.WHITE);

        }else if(ActivityAHeredar.colorFondo == android.R.color.white){

            btnCambiaColor.setTextColor(Color.WHITE);
            btnCambiaColor.setBackgroundColor(Color.rgb(200, 0, 0));
            textoSeleccionaFondo.setTextColor(Color.BLACK);

        }else{
            btnCambiaColor.setTextColor(Color.WHITE);
            btnCambiaColor.setBackgroundColor(Color.BLACK);
            textoSeleccionaFondo.setTextColor(Color.BLACK);
        }
        //layoutDeAqui.setBackgroundColor(ContextCompat.getColor(this, android.R.color.holo_red_dark));
        //Log.i("info", "" + android.R.color.holo_red_dark);
    }


    @Override
    public void onClick(View view) {

        if(view.getId() == btnCambiaColor.getId()){

            if(colores.getSelectedItem().equals("Rojo")){
                //layoutDeAqui.setBackgroundColor(ContextCompat.getColor(this, android.R.color.background_light));
                ActivityAHeredar.colorFondo = android.R.color.holo_red_dark;
                ActivityAHeredar.cambiaColor(layoutDeAqui, this);
                SharedPreferences preferencias = getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("ultimoColor", colores.getSelectedItem().toString());
                editor.apply();
            }
            if(colores.getSelectedItem().equals("Verde")){
                ActivityAHeredar.colorFondo = android.R.color.holo_green_dark;
                ActivityAHeredar.cambiaColor(layoutDeAqui, this);
                SharedPreferences preferencias = getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("ultimoColor", colores.getSelectedItem().toString());
                editor.apply();
            }
            if(colores.getSelectedItem().equals("Azul")){
                ActivityAHeredar.colorFondo = android.R.color.holo_blue_dark;
                ActivityAHeredar.cambiaColor(layoutDeAqui, this);
                SharedPreferences preferencias = getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("ultimoColor", colores.getSelectedItem().toString());
                editor.apply();
            }
            if(colores.getSelectedItem().equals("Negro")){
                ActivityAHeredar.colorFondo = android.R.color.black;
                ActivityAHeredar.cambiaColor(layoutDeAqui, this);
                SharedPreferences preferencias = getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("ultimoColor", colores.getSelectedItem().toString());
                editor.apply();
            }
            if(colores.getSelectedItem().equals("Morado")){
                ActivityAHeredar.colorFondo = android.R.color.holo_purple;
                ActivityAHeredar.cambiaColor(layoutDeAqui, this);
                SharedPreferences preferencias = getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("ultimoColor", colores.getSelectedItem().toString());
                editor.apply();
            }

            if(colores.getSelectedItem().equals("Blanco")){
                ActivityAHeredar.colorFondo = android.R.color.white;
                ActivityAHeredar.cambiaColor(layoutDeAqui, this);
                SharedPreferences preferencias = getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("ultimoColor", colores.getSelectedItem().toString());
                editor.apply();
            }

        }
        if(ActivityAHeredar.colorFondo == android.R.color.black){

            btnCambiaColor.setTextColor(Color.WHITE);
            btnCambiaColor.setBackgroundColor(Color.rgb(200, 0, 0));
            textoSeleccionaFondo.setTextColor(Color.WHITE);

        }else if(ActivityAHeredar.colorFondo == android.R.color.white){

            btnCambiaColor.setTextColor(Color.WHITE);
            btnCambiaColor.setBackgroundColor(Color.rgb(200, 0, 0));
            textoSeleccionaFondo.setTextColor(Color.BLACK);

        }else{
            btnCambiaColor.setTextColor(Color.WHITE);
            btnCambiaColor.setBackgroundColor(Color.BLACK);
            textoSeleccionaFondo.setTextColor(Color.BLACK);
        }

    }

    @Override
    public  void onBackPressed(){

        Intent i = new Intent(ActivityConfiguracion.this, ActivityMenu.class);
        i.putExtra("usuario", servicio.obtenerUltimoUsuarioIniciado().getUsuario());
        startActivity(i);
        finish();

    }
}