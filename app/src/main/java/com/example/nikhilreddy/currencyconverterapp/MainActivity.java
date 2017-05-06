package com.example.nikhilreddy.currencyconverterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    double amount = 0;
    double result = 0;
    double euroRate = 0.877805;
    double pesosRate = 17.3088;
    double rupeeRate = 66.2800;
    DecimalFormat curr = new DecimalFormat("##,###.#");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText currencyEntered = (EditText)findViewById(R.id.txtCurrency);
        final RadioButton DolToEur = (RadioButton)findViewById(R.id.radDolToEur);
        final RadioButton DolToPes = (RadioButton)findViewById(R.id.radDolToPes);
        final RadioButton DolToRup = (RadioButton)findViewById(R.id.radDolToRup);
        final Button currency = (Button)findViewById(R.id.btnCurrency);
        final TextView convertedCurrency = (TextView)findViewById(R.id.txtResult);


        currency.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount = Double.parseDouble(currencyEntered.getText().toString());

                if (DolToEur.isChecked())
                {
                    if(amount < 100000)
                    {
                        result = amount * euroRate;
                        convertedCurrency.setText(curr.format(result) + " Euros ");
                    }
                    else
                    {
                        String message = "Amount entered must be less than 100000 dollars";
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                    }

                }
                if(DolToPes.isChecked())
                {
                    if(amount < 100000)
                    {
                        result = amount * pesosRate;
                        convertedCurrency.setText(curr.format(result) + " Pesos ");
                    }
                    else
                    {
                        String message = "Amount entered must be less than 100000 dollars";
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                    }
                }
                if(DolToRup.isChecked())
                {
                    if(amount < 100000)
                    {
                        result = amount * rupeeRate;
                        convertedCurrency.setText(curr.format(result) + " Rupees ");
                    }
                    else
                    {
                        String message = "Amount entered must be less than 100000 dollars";
                        Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                    }
                }
            }
        });



    }
}
