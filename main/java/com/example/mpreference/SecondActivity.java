package com.example.mpreference;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {
    TextView tv1,tv2,tv3,textView5,textView4,textView6;
    Button btn3,btn4;
    public  static final String DEFAULT="N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tv1=findViewById(R.id.textView);
        tv2=findViewById(R.id.textView2);
        tv3=findViewById(R.id.tv3);
        textView5=findViewById(R.id.textView5);
        textView4=findViewById(R.id.textView4);
        textView6=findViewById(R.id.textView6);
        btn3=findViewById(R.id.btn3);
        btn4=findViewById(R.id.btn4);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId())
        {
            case R.id.btn3:
                load(view);
                break;
            case  R.id.btn4:
                previous(view);
                break;
            default:
                break;
        }
    }

    public void  load(View view){
     SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
     String userName=   sharedPreferences.getString("name",DEFAULT);
     String password =   sharedPreferences.getString("password",DEFAULT);
     String qualification = sharedPreferences.getString("qualification",DEFAULT);
       if(userName.equals(DEFAULT) || password.equals(DEFAULT) || qualification.equals(DEFAULT))
       {
           Toast.makeText(this,"Data not found",Toast.LENGTH_SHORT).show();

       }
       else {
           Toast.makeText(this,"Data loaded successfully",Toast.LENGTH_SHORT).show();
           textView5.setText(userName);
           textView4.setText(password);
           textView6.setText(qualification);
       }

    }
    public void previous(View view){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);

    }
}
