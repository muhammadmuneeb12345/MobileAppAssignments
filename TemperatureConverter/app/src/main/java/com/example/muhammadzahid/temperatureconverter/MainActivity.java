package com.example.muhammadzahid.temperatureconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btn;
    RadioGroup radioGroup;
    RadioButton radioButton;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        converter();
    }
    public void converter()
    {
        btn = (Button)findViewById(R.id.button);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        editText = (EditText)findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{


                int selected_id = radioGroup.getCheckedRadioButtonId();
                radioButton = (RadioButton)findViewById(selected_id);

                String res = radioButton.getText().toString();
                String ET = editText.getText().toString();
                Double num = Double.valueOf(ET);
                if(res.equals("Celsius to Fahrenheit")){
                Double fahrenheit  = (9.0/5.0)*num + 32;
                    Toast.makeText(MainActivity.this, "Fehrenheight :"+String.valueOf(fahrenheit), Toast.LENGTH_SHORT).show();
                }
                if(res.equals("Fahrenheit to Celsius")){
                    double celsius = (5.0/9.0)*(num - 32);
                    Toast.makeText(MainActivity.this, "Celsius :"+String.valueOf(celsius), Toast.LENGTH_SHORT).show();
                }
                }
                catch (Exception e)
                {
                    Toast.makeText(MainActivity.this, "Please give a valid number", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
