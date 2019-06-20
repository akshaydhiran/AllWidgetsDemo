package com.example.allwidgetsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
Button a1,a2,a3,a4,a5;
private void init()
{
    a1 = findViewById(R.id.a1);
    a2 = findViewById(R.id.a2);
    a3 = findViewById(R.id.a3);
    a4 = findViewById(R.id.a4);
    a5 = findViewById(R.id.a5);
    a1.setOnClickListener(this);
    a2.setOnClickListener(this);
    a3.setOnClickListener(this);
    a4.setOnClickListener(this);
    a5.setOnClickListener(this);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
init();



    }

    @Override
    public void onClick(View v) {  //

    int id = v.getId(); // v is an object is a object for View Onclick class.
        Intent intent = null; // intent is used to show messages.
        switch (id){  // here we use switch for giving id for multiple butttons we used for to distinguish.
            case R.id.a1 : intent = new Intent(MainActivity.this, ToastActivity.class); break;

        }
        if (intent!=null)
        startActivity(intent);  // here we use startACtivity for using other buttons because it is crash instead.
    }
}
