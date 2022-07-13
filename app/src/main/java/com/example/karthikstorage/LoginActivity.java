package com.example.karthikstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText mobileEdt;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String mobileStr;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        mobileEdt=findViewById(R.id.mobile_edt);
        CreateSharedPerf();

    }

    private void CreateSharedPerf() {
        sharedPreferences=getSharedPreferences("LOGINMODE",MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void login(View view) {

        mobileStr=mobileEdt.getText().toString();

        editor.putString("mobile",mobileStr);
        editor.putBoolean("login",true);
        editor.commit();

        finish();
        startActivity(new Intent(LoginActivity.this,HomeActivity2.class));
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(sharedPreferences.getBoolean("login",false)==true)
        {
            finish();
            startActivity(new Intent(LoginActivity.this,HomeActivity2.class));

        }
        else
        {
            Toast.makeText(this, "Please Login", Toast.LENGTH_SHORT).show();
        }
    }
}