package com.example.karthikstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class HomeActivity2 extends AppCompatActivity {

    TextView displayMobile;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String mobileStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        displayMobile=findViewById(R.id.mobile_txt);
        CreateSharedPerf();

        mobileStr=sharedPreferences.getString("mobile","");
        displayMobile.setText(""+mobileStr);

    }

    private void CreateSharedPerf() {
        sharedPreferences=getSharedPreferences("LOGINMODE",MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    public void logout(View view) {

        CreateSharedPerf();
        editor.clear();
        editor.commit();
        finish();

        startActivity(new Intent(HomeActivity2.this, LoginActivity.class));
    }
}