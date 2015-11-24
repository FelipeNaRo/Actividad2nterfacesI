package com.example.dam2.actividad2nterfacesi;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Layout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.Collection;

public class Actividad2 extends Activity {
    private Button boton1;
    private Button boton2;
    private LinearLayout fondo2;
    private CheckBox op;
    private EditText oculto;
    private EditText largo;
    private RatingBar estrellas;
    private EditText valor;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        boton1 = (Button) findViewById(R.id.boton);
        boton2 = (Button) findViewById(R.id.boton2);
        fondo2 = (LinearLayout) findViewById(R.id.fondo2);
        op = (CheckBox) findViewById(R.id.op);
        oculto = (EditText) findViewById(R.id.oculto);
        largo = (EditText) findViewById(R.id.largo);
        estrellas = (RatingBar) findViewById(R.id.estrellas);
        valor = (EditText) findViewById(R.id.valor);
        valor.setText(String.valueOf(estrellas.getRating()));

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambioFondo();
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cambioLetras();
            }
        });


        op.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                mostrarTexto();
            }
        });

        largo.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mostrarPanel();
                return false;
            }
        });

        estrellas.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                int v= (int)rating;
                valor.setText("["+String.valueOf(v)+"/5]");
            }
        });


    }


    public void mostrarPanel(){
        Toast.makeText(this, "GRACIAS", Toast.LENGTH_SHORT).show();
    }
    public void mostrarTexto(){

        String m="Este es el mensaje oculto...";
        if(op.isChecked()){
            oculto.setText(m);
        }else{
            oculto.setText(null);

        }
    }
    public void cambioLetras(){
        if (boton2.getText().equals("LETRAS NEGRAS")){
            boton2.setTextColor(Color.BLACK);
            boton2.setText("LETRAS ROJAS");}else{
            boton2.setTextColor(Color.RED);
            boton2.setText("LETRAS NEGRAS");
        }
    }
    public void cambioFondo(){

        if (boton1.getText().equals("FONDO ROJO")){
        fondo2.setBackgroundColor(Color.RED);
        boton1.setText("FONDO BLANCO");}else{
            fondo2.setBackgroundColor(Color.WHITE);
            boton1.setText("FONDO ROJO");
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_actividad2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
