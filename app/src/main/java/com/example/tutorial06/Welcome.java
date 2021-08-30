package com.example.tutorial06;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class Welcome extends AppCompatActivity
{
    TextView txt;
    SharedPreferences pref;
    SharedPreferences.Editor edit;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        txt = findViewById(R.id.textView);

        pref = getSharedPreferences("users", MODE_PRIVATE);
        edit = pref.edit();


        String user = pref.getString("username","");
        txt.setText("Welcome " + user);
        Toast.makeText(this, user, Toast.LENGTH_SHORT).show();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.general_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.mnuAbout:
                break;
            case R.id.mnuLogout:
                edit.remove("username");
                edit.commit();
                Intent intent = new Intent(Welcome.this,MainActivity.class);
                startActivity(intent);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}