package br.com.ricardofelix.futtrademobile.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.ricardofelix.futtrademobile.R;

public class MainActivity extends AppCompatActivity {
    EditText textName,textValorCompra,textValorVenda;
    TextView textLucro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textLucro = findViewById(R.id.textLucro);
        textName = findViewById(R.id.textName);
        textValorCompra = findViewById(R.id.textValorCompra);
        textValorVenda = findViewById(R.id.textValorVenda);

        FloatingActionButton fab = findViewById(R.id.okBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLucro(calcularLucro());
            }
        });

    }


    public void setLucro(double lucro){

        if(lucro > 0){

            textLucro.setTextColor(Color.GREEN);
            textLucro.setText("Lucro: "+lucro+" coins");
        }

        if(lucro < 0){

            textLucro.setTextColor(Color.RED);
            textLucro.setText("Prejuízo: "+lucro+" coins");
        }else{
            textLucro.setText("Lucro: "+lucro+" coins");
        }






    }

    public double calcularLucro(){
        double lucro;
        int compra = Integer.parseInt(textValorCompra.getText().toString());
        int venda = Integer.parseInt(textValorVenda.getText().toString());
        lucro = (float) 5 / 100 * venda;
        Toast.makeText(this, compra+" - "+venda+"\n"+lucro, Toast.LENGTH_SHORT).show();
        lucro =  venda - lucro - compra;

        lucro = Math.round(lucro);

        return lucro;


    }
}
