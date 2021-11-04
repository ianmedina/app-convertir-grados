package facci.pabloproano.convertapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv_derecha, tv_izquierda, tv_gc, tv_gf, tv_resultado;
    private EditText et_valor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Asignaciones
        tv_derecha = (TextView) findViewById(R.id.tv_derecha);
        tv_izquierda = (TextView) findViewById(R.id.tv_izquierda);
        tv_gc = (TextView) findViewById(R.id.tv_gc);
        tv_gf = (TextView) findViewById(R.id.tv_gf);
        tv_resultado = (TextView) findViewById(R.id.tv_resultado);
        et_valor = (EditText) findViewById(R.id.et_valor);

    }

    // Presionar cambio de conversión
    public void changeConversion(View view){

        // Controlar cambio de conversión
        String verify_change = tv_izquierda.getText().toString();

        if(verify_change.equals("°C")){
            tv_derecha.setText(R.string.degrees_celsius);
            tv_izquierda.setText(R.string.degrees_fahrenheit);
            tv_gc.setText(R.string.title_fahrenheit);
            tv_gf.setText(R.string.title_celsius);
        }else{
            tv_derecha.setText(R.string.degrees_fahrenheit);
            tv_izquierda.setText(R.string.degrees_celsius);
            tv_gc.setText(R.string.title_celsius);
            tv_gf.setText(R.string.title_fahrenheit);
        }
    }

    // Presionar convertir
    public void convert(View view){

        // Extrae el valor ingresado
        String valueString = et_valor.getText().toString();
        float valueFloat = Float.parseFloat(valueString);

        // Controlar el estado de conversión
        String verify_change = tv_izquierda.getText().toString();

        if(verify_change.equals("°C")){
            float fahrenheit = celsiusAFahrenheit(valueFloat);
            double roundFahrenheit = round(fahrenheit);
            String result = Double.toString(roundFahrenheit);
            tv_resultado.setText(result);
        }else{
            float celsius = fahrenheitACelsius(valueFloat);
            double roundCelsius = round(celsius);
            String result = Double.toString(roundCelsius);
            tv_resultado.setText(result);
        }
    }

    // Métodos para la conversión y redondear
    public static float celsiusAFahrenheit(float celsius) {
        return (celsius * 1.8f) + 32;
    }

    public static float fahrenheitACelsius(float fahrenheit) {
        return (fahrenheit - 32) / 1.8f;
    }

    private static double round(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
}