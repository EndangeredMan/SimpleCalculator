package com.cs407.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText first, second;
    TextView t1;
    int num1, num2;
    String s1, s2, s3;

    public boolean getNumbers(){
        first = (EditText) findViewById(R.id.editTextNumber);
        second = (EditText) findViewById(R.id.editTextNumber2);
        t1 = (TextView) findViewById(R.id.error);
        s1 = first.getText().toString();
        s2 = second.getText().toString();

        if(s1.equals(null) || s1.equals("")){
            String err = ("Please enter first number");
            t1.setText(err);
            return false;
        } else if(s2.equals(null) || s2.equals("")){
            String err = ("Please enter first number");
            t1.setText(err);
            return false;
        } else{
            num1 = Integer.parseInt(s1);
            num2 = Integer.parseInt(s2);
        }
        Toast.makeText(MainActivity.this, "got numbers", Toast.LENGTH_LONG).show();
        return true;
    }

    public void addFunction(View view){
        if(getNumbers()){
            Integer sol = num1 + num2;
            goToActivity(sol.toString());
        }
        else{
            t1.setText("Error");
        }
    }

    public void subFunction(View view){
        if(getNumbers()){
            Integer sol = num1 - num2;
            goToActivity(sol.toString());
        }
        else{
            t1.setText("Error");
        }
    }

    public void multFunction(View view){
        if(getNumbers()){
            Integer sol = num1 * num2;
            goToActivity(sol.toString());
        }
        else{
            t1.setText("Error");
        }
    }

    public void divFunction(View view){
        if(getNumbers()){
            if(num2 == 0){
                t1.setText("Cannot divide by zero");
            }
            else {
                Double sol = (double) (num1 / num2);
                goToActivity(sol.toString());
            }
        }
        else{
            t1.setText("Error");
        }
    }

    public void goToActivity(String x){
        Intent intent=new Intent(this,solutionActivity.class);
        intent.putExtra("solution", x);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}