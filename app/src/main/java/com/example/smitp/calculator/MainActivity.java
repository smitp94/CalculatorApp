package com.example.smitp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setResult(String str){
        result = (TextView) findViewById(R.id.result);
        String operation = "";

        if(str.compareTo("CC") == 0){
            operation = "";
        }
        else{
            operation = result.getText().toString();
            Toast.makeText(this, operation, Toast.LENGTH_LONG).show();
            operation = operation.concat(" ").concat(str);
        }
        result.setText(operation);

        Toast.makeText(this, operation, Toast.LENGTH_LONG).show();


    }

    public void onClickBtn(View v)
    {
        Button b = (Button)v;
        String buttonText = b.getText().toString();
        Toast.makeText(this, "Clicked on Button " + buttonText, Toast.LENGTH_LONG).show();
        setResult(buttonText);
    }


}


