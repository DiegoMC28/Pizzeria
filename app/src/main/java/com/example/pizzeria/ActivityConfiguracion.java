package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

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
        ActivityColorFijo.cambiaColor(layoutDeAqui, this);

        if(ActivityColorFijo.colorFondo == android.R.color.black){

            btnCambiaColor.setTextColor(Color.WHITE);
            btnCambiaColor.setBackgroundColor(Color.rgb(200, 0, 0));
            textoSeleccionaFondo.setTextColor(Color.WHITE);

        }else if(ActivityColorFijo.colorFondo == android.R.color.white){

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
                ActivityColorFijo.colorFondo = android.R.color.holo_red_dark;
                ActivityColorFijo.cambiaColor(layoutDeAqui, this);
                SharedPreferences preferencias = getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("ultimoColor", colores.getSelectedItem().toString());
                editor.apply();
            }
            if(colores.getSelectedItem().equals("Verde")){
                ActivityColorFijo.colorFondo = android.R.color.holo_green_dark;
                ActivityColorFijo.cambiaColor(layoutDeAqui, this);
                SharedPreferences preferencias = getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("ultimoColor", colores.getSelectedItem().toString());
                editor.apply();
            }
            if(colores.getSelectedItem().equals("Azul")){
                ActivityColorFijo.colorFondo = android.R.color.holo_blue_dark;
                ActivityColorFijo.cambiaColor(layoutDeAqui, this);
                SharedPreferences preferencias = getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("ultimoColor", colores.getSelectedItem().toString());
                editor.apply();
            }
            if(colores.getSelectedItem().equals("Negro")){
                ActivityColorFijo.colorFondo = android.R.color.black;
                ActivityColorFijo.cambiaColor(layoutDeAqui, this);
                SharedPreferences preferencias = getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("ultimoColor", colores.getSelectedItem().toString());
                editor.apply();
            }
            if(colores.getSelectedItem().equals("Morado")){
                ActivityColorFijo.colorFondo = android.R.color.holo_purple;
                ActivityColorFijo.cambiaColor(layoutDeAqui, this);
                SharedPreferences preferencias = getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("ultimoColor", colores.getSelectedItem().toString());
                editor.apply();
            }

            if(colores.getSelectedItem().equals("Blanco")){
                ActivityColorFijo.colorFondo = android.R.color.white;
                ActivityColorFijo.cambiaColor(layoutDeAqui, this);
                SharedPreferences preferencias = getSharedPreferences("ultimoColor", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString("ultimoColor", colores.getSelectedItem().toString());
                editor.apply();
            }

        }
        if(ActivityColorFijo.colorFondo == android.R.color.black){

            btnCambiaColor.setTextColor(Color.WHITE);
            btnCambiaColor.setBackgroundColor(Color.rgb(200, 0, 0));
            textoSeleccionaFondo.setTextColor(Color.WHITE);

        }else if(ActivityColorFijo.colorFondo == android.R.color.white){

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