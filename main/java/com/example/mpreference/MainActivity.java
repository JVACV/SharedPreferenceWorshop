package com.example.mpreference;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
   EditText et1,et2;
   Button btn1,btn2;
   private CheckBox eCheckbox1;
   private CheckBox eCheckbox2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et1=findViewById(R.id.editText);
        et2=findViewById(R.id.editText2);
        btn1=findViewById(R.id.button);
        btn2=findViewById(R.id.buttonCancel);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        eCheckbox1=findViewById(R.id.eCheckbox1);
        eCheckbox2=findViewById(R.id.eCheckbox2);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.button:
                save(view);
                break;
            case  R.id.buttonCancel:
                next(view);
                break;

            default:
                break;
        }
    }
    public void save(View view){
        String newLine = System.getProperty("line.separator");

        StringBuffer  buffer= new StringBuffer();

        if(eCheckbox1.isChecked()){
            buffer.append("Diploma Passed");
        }
        else{
            buffer.append("NO Diploma");
        }
        if (eCheckbox2.isChecked()){
            buffer.append(newLine);
            buffer.append("SSLC Passed");
        }
        else{
            buffer.append(newLine);
            buffer.append("NO SSLC");
        }
        Toast.makeText(this,buffer.toString(),Toast.LENGTH_LONG).show();
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
          SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("name",et1.getText().toString());
        editor.putString("password",et2.getText().toString());
        editor.putString("qualification",buffer.toString());
        editor.commit();
        Toast.makeText(this,"data saved successfully",Toast.LENGTH_SHORT).show();
    }
    public  void next(View view){
        Toast.makeText(this,"next",Toast.LENGTH_SHORT).show();
        Intent intent=  new Intent(this,SecondActivity.class);
        startActivity(intent);
    }



}
