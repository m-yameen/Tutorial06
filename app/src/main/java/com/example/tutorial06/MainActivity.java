package com.example.tutorial06;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pref = getSharedPreferences("users",MODE_PRIVATE);
        edit = pref.edit();

        String user = pref.getString("username","");
        if (!user.equals(""))
        {
            Intent dir = new Intent(this,Welcome.class);
            startActivity(dir);
            finish();
        }
    }
    public void log(View v)
    {
        EditText user = findViewById(R.id.email);
        EditText pass = findViewById(R.id.password);
        String email = user.getText().toString();
        String pas = pass.getText().toString();
        if (email.equals("admin@gmail.com") && pas.equals("123456"))
        {
            edit.putString("username",email);
            edit.commit();
            Intent dir = new Intent(this,Welcome.class);
            startActivity(dir);
            finish();
        }
        else
        {
            Toast.makeText(this, "Username or Password is wrong.", Toast.LENGTH_SHORT).show();
        }
    }
}