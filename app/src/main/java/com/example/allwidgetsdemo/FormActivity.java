package com.example.allwidgetsdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {
EditText name, email,dob,contactnumber,address,experience;
Button register;
RadioGroup radioGroup;
TextView applicationform;
ImageView goldmansachs1;
CheckBox checkBox;
int id;
private void init()
{
    name = findViewById(R.id.name);
    email = findViewById(R.id.email);
    dob = findViewById(R.id.dob);
    contactnumber = findViewById(R.id.contactnumber);
    address = findViewById(R.id.address);
    experience = findViewById(R.id.experience);
    register = findViewById(R.id.register);
    radioGroup = findViewById(R.id.radiogroup);
    applicationform = findViewById(R.id.applicationform);
    goldmansachs1 = findViewById(R.id.goldmansachs1);
    checkBox = findViewById(R.id.checkbox);

}
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        init();
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = null; // intent is used to show messages.
                switch (id){  // here we use switch for giving id for multiple butttons we used for to distinguish.
                    case R.id.register : intent = new Intent(FormActivity.this, ShowDetailsActivity.class); break;

                }
                if (intent!=null)
                    startActivity(intent);  // here we use startACtivity for using other buttons because it is crash instead.



                    String Name, Email, ContactNumber, Gender, Dob, Experience;
                    Name = name.getText().toString();
                    Email = email.getText().toString();
                    ContactNumber = contactnumber.getText().toString();
                    Dob = dob.getText().toString();
                    RadioButton rb = findViewById(radioGroup.getCheckedRadioButtonId());
                    Gender = rb.getText().toString();
                    StringBuffer buffer = new StringBuffer();
                    buffer.append("Name : " + name + "\n");
                    buffer.append("Email : " + email + "\n");
                    buffer.append("Date of Birth : " + dob + "\n");
                    buffer.append("Contact Number : " + contactnumber + "\n");
                    buffer.append("Address : " + address + "\n");
                    buffer.append("Experience Years : " + experience + "\n");


                    applicationform.setText(buffer.toString());

            }
        });
}
}
