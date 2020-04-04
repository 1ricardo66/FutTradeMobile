package br.com.ricardofelix.futtrademobile.activity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import br.com.ricardofelix.futtrademobile.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    public HomeFragment() {
        // Required empty public constructor
    }

    EditText textName,textValorCompra,textValorVenda;
    TextView textLucro;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view  = inflater.inflate(R.layout.fragment_home, container, false);

        textLucro = view.findViewById(R.id.textLucro);
        textName = view.findViewById(R.id.textName);
        textValorCompra = view.findViewById(R.id.textValorCompra);
        textValorVenda = view.findViewById(R.id.textValorVenda);

        FloatingActionButton fab = view.findViewById(R.id.okBtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setLucro(calcularLucro());
            }
        });


        return view;
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
        Toast.makeText(getContext(), compra+" - "+venda+"\n"+lucro, Toast.LENGTH_SHORT).show();
        lucro =  venda - lucro - compra;

        lucro = Math.round(lucro);

        return lucro;


    }

}
