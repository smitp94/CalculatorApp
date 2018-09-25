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

    public void setResult(String input){
        result = (TextView) findViewById(R.id.result);
        String operation = result.getText().toString();;
        if(input.compareTo("CC") == 0){
            operation = "";
        }
        else if (operation.length() > 2 && input.compareTo("=") == 0){

            String[] array = operation.split(" ");
            double op1 = Double.parseDouble(array[0]);
            String op = (String) array[1];
            double op2 =  Double.parseDouble(array[2]);

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
        else if(operation.length() == 0 && input.matches("[+,\\-,x,/,=]")){
            Toast.makeText(this, "Input number first", Toast.LENGTH_LONG).show();
            operation = "";
        }
        else{
            operation = result.getText().toString();
            if(operation.length() > 0 && (input.matches("[+,\\-,x,/]") || operation.substring(operation.length() - 1).matches("[+,\\-,x,/]"))) {
                operation = operation.concat(" ").concat(input);
            }
            else{
                operation = operation.concat(input);
            }
        }
        result.setText(operation);
    //Add constraints
        /*
        1. .......
        2. + - x
        3. -1 + 4
         */
    }

    public void onClickBtn(View v)
    {
        Button b = (Button)v;
        String buttonText = b.getText().toString();
        setResult(buttonText);
    }


}


