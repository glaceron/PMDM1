package com.example.pmdm1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    EditText num;
    TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num = findViewById(R.id.numBox);
        resultado = findViewById(R.id.resultadoPrimo);
    }

    public void SaveButton(View view)
    {
        String dato = num.getText().toString();
        if(dato.isEmpty())
        {
            Toast.makeText(this, "Introduce un número", Toast.LENGTH_SHORT).show();
            resultado.setText("");
        }
        else
        {
            try
            {
                int numero = Integer.parseInt(dato);
                if(numero <= 0)
                {
                    Toast.makeText(this, "El número tiene que ser mayor que 0", Toast.LENGTH_SHORT).show();
                    num.setText("");
                    resultado.setText("");
                }
                else
                {
                    boolean primo = esPrimo(numero);
                    if(primo)
                    {
                        resultado.setText("El número " + numero + " es primo");
                    }
                    else
                    {
                        resultado.setText("El número " + numero + " no es primo");
                    }
                }
            }
            catch (NumberFormatException ex)
            {
                Toast.makeText(this, "Introduce un número válido, mayor que 0", Toast.LENGTH_SHORT).show();
                num.setText("");
                resultado.setText("");
            }
        }
    }

    public static boolean esPrimo(int numero)
    {
        boolean primo = true;
        if (numero == 1)
        primo = false;
        else
        {
            int contador = 2;
            while ((primo) && (contador != numero))
            {
                if (numero % contador == 0)
                    primo = false;
                contador ++;
            }
        }
        return primo;
    }
}