package com.example.smitp.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private String[] calcStack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setResult(String str){
        result = (TextView) findViewById(R.id.result);
        String operation = "";
//        String answer = "";
        if(str.compareTo("CC") == 0){
            operation = "";
        }
        else if (str.compareTo("=") == 0){

            //perform operation
            operation = result.getText().toString();
            Toast.makeText(this, operation, Toast.LENGTH_LONG).show();
            String[] array = operation.split(" ");
            Toast.makeText(this, array[1], Toast.LENGTH_LONG).show();
            double op1 = Double.parseDouble(array[1]);
            String op = (String) array[2];
            double op2 =  Double.parseDouble(array[3]);

            if(op.compareTo("+") == 0){
                operation = (op1 + op2) + "";
            }
            if(op.compareTo("-") == 0){
                operation = (op1 - op2) + "";
            }
            if(op.compareTo("x") == 0){
                operation = (op1 * op2) + "";
            }
            if(op.compareTo("/") == 0){
                operation = (op1 / op2) + "";
            }

        }
        else{
            operation = result.getText().toString();
            Toast.makeText(this, operation, Toast.LENGTH_LONG).show();
            operation = operation.concat(" ").concat(str);
        }
        result.setText(operation);

//        Toast.makeText(this, operation, Toast.LENGTH_LONG).show();

        //enforce constraints

    }

    public void onClickBtn(View v)
    {
        Button b = (Button)v;
        String buttonText = b.getText().toString();
        Toast.makeText(this, "Clicked on Button " + buttonText, Toast.LENGTH_LONG).show();
        setResult(buttonText);
    }


}


