package com.example.tutorial_6;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText email,pass;
    Button login;
    SharedPreferences sharedPreferences;
    //so create Shard preference name and also create Key name
    private static  final String SHARED_PREF_NAME="mypref";
    private static final String KEY_EMAIL="email";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email =findViewById(R.id.email);
        pass =findViewById(R.id.password);
        login = findViewById(R.id.login);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME,MODE_PRIVATE);

        //when open activity frst check data is avelable or not

        String name = sharedPreferences.getString(KEY_EMAIL,null);
        if (name != null){
            // if data is avelable so directly call on Homeactivity
            Intent intent =new Intent(MainActivity.this,HomeActivity.class);
            startActivity(intent);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

//                String emailadd= email.getText().toString().trim();
                if (email.getText().toString().equals("admin@gmail.com")&& pass.getText().toString().equals("admin"))
                {
                    Intent intent  = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                }
                if (pass.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Enter Password...", Toast.LENGTH_SHORT).show();
                    pass.requestFocus();
                }
                if(email.getText().toString().equals(""))
                {
                    Toast.makeText(MainActivity.this, "Enter Valid MailAddredss", Toast.LENGTH_SHORT).show();
                    email.requestFocus();
                }
//                SharedPreferences.Editor editor=sharedPreferences.edit();
//                editor.putString(KEY_EMAIL,email.getText().toString());
//                editor.apply();
            }
        });

//        login.setOnClickListener(new View.OnClickListener(){
//            @Override
//            public void onClick(View v){
//                String email=email.getText().toString().trim();
//                if (email.getText().toString().equals("admin@gmail.com") && pass.getText().toString().equals("admin"))
//                {
//                    Intent intent= new Intent(MainActivity.this,HomeActivity.class);
//                    startActivity(intent);
//                }
//                SharedPreferences.Editor editor=sharedPreferences.edit();
//                editor.putString(KEY_NAME,email.getText().toString());
//                editor.putString(KEY_EMAIL,pass.getText().toString());
//                editor.apply();
//
//                Toast.makeText(MainActivity.this, "Login Sucseefully...", Toast.LENGTH_SHORT).show();
//
//            }
//        });

    }
}