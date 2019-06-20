package com.example.allwidgetsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Random;

public class ToastActivity extends AppCompatActivity {
Button simpletoastbtn;
ImageButton imageButton;
private void init()
{
    imageButton = findViewById(R.id.button2);
    simpletoastbtn = findViewById(R.id.button);
}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        init();
        simpletoastbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToastActivity.this, "SimpleToast", Toast.LENGTH_SHORT).show();
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
        showPokeToast();
            }
        });
        
    }
    private void showPokeToast()
    {
        View layout = getLayoutInflater().inflate(R.layout.pokemon_toast,(ViewGroup)findViewById(R.id.custom_toastlayout)); //inflator is used to create a object for view to show pokemon ball.
       //(ViewGroup) is used to typecast the object
        ImageView img = layout.findViewById(R.id.img);
       // int randomNum = ((int)(Math.random()*10))% 6;
      Random random = new Random();
        int num = random.nextInt(6);
        switch (num)
        {
            case 0: img.setImageDrawable(getDrawable(R.drawable.pok1)); break;
            case 1 : img.setImageDrawable(getDrawable(R.drawable.pok3));break;
            case 2: img.setImageDrawable(getDrawable(R.drawable.poke2));break;
            case 3: img.setImageDrawable(getDrawable(R.drawable.poke5));break;
            case 4: img.setImageDrawable(getDrawable(R.drawable.poke4));break;
            case 5: img.setImageDrawable(getDrawable(R.drawable.pok1));break;
            case 6: img.setImageDrawable(getDrawable(R.drawable.pok3));break;
            case 7: img.setImageDrawable(getDrawable(R.drawable.poke2));break;
            case 8: img.setImageDrawable(getDrawable(R.drawable.poke5));break;
            case 9: img.setImageDrawable(getDrawable(R.drawable.pok1));break;
        }

        Log.d("randomNum1","num : "+num );

        Toast toast = new Toast(ToastActivity.this);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
        toast.setView(layout);
        //toast.setView(layout.findViewById(R.id.img1));

        toast.show();
    }
}
