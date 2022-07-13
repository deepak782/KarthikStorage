package com.example.karthikstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    String getSavedValue;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        textView=findViewById(R.id.textView);
        CreateSharedPerf();

        getSavedValue=sharedPreferences.getString("refname1","");
        textView.setText(""+getSavedValue);

    }

    private void CreateSharedPerf() {
        sharedPreferences=getSharedPreferences("MODE1",MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

}