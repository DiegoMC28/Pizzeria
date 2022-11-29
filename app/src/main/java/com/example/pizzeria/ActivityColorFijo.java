package com.example.pizzeria;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.os.Bundle;

public class ActivityColorFijo extends AppCompatActivity {
public static int colorFondo = android.R.color.white;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aheredar);



    }


    public static void cambiaColor(ConstraintLayout layout, Context context){


        layout.setBackgroundColor(ContextCompat.getColor(context, colorFondo));

    }

}