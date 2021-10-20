package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;

public class MainActivity extends AppCompatActivity {

    TextView textViewInput;
    TextView textViewResultado;
    String input = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Objects.requireNonNull(getSupportActionBar()).hide();
        setContentView(R.layout.activity_main);
        initTextView();
    }

    private void initTextView() {
        textViewInput = (TextView) findViewById(R.id.textViewInput);
        textViewResultado = (TextView) findViewById(R.id.textViewResultado);
    }

    private void setInput(String valorBoton) {
        input = input + valorBoton;
        textViewInput.setText(input);
    }

    public void resultadoOnClick(View view) {
        Double resultado = null;
        ScriptEngine engine = new ScriptEngineManager().getEngineByName("rhino");

        try {
            resultado = (double) engine.eval(input);
        } catch (ScriptException e) {
            Toast.makeText(this, "Entrada invalida", Toast.LENGTH_LONG).show();
        }
        if (resultado != null) {
            textViewResultado.setText(String.valueOf(resultado.doubleValue()));
            input = "";
            textViewInput.setText("0");
        }
    }

    public void puntoOnClick(View view) {
        setInput(".");
    }

    public void ceroOnClick(View view) {
        setInput("0");
    }

    public void sumarOnClick(View view) {
        setInput("+");
    }

    public void tresOnClick(View view) {
        setInput("3");
    }

    public void dosOnClick(View view) {
        setInput("2");
    }

    public void unoOnClick(View view) {
        setInput("1");
    }

    public void restarOnClick(View view) {
        setInput("-");
    }

    public void seisOnClick(View view) {
        setInput("6");
    }

    public void cincoOnClick(View view) {
        setInput("5");
    }

    public void cuatroOnClick(View view) {
        setInput("4");
    }

    public void multiplicarOnClick(View view) {
        setInput("*");
    }

    public void nueveOnClick(View view) {
        setInput("9");
    }

    public void ochoOnClick(View view) {
        setInput("8");
    }

    public void sieteOnClick(View view) {
        setInput("7");
    }

    public void dividirOnClick(View view) {
        setInput("/");
    }

    public void limpiarOnClick(View view) {
        textViewInput.setText("0");
        input = "";
        textViewResultado.setText("0");
    }
}