package com.example.karthikstorage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText typeHere;
    Button save,read,clear;
    TextView displayValue;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    String convertStr,getStrValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        typeHere=findViewById(R.id.edt);
        save=findViewById(R.id.save);
        read=findViewById(R.id.read);
        clear=findViewById(R.id.clear);
        displayValue=findViewById(R.id.display_txt);

        save.setOnClickListener(this);
        read.setOnClickListener(this);
        clear.setOnClickListener(this);

        CreateSharedPerf();
    }

    private void CreateSharedPerf() {
        sharedPreferences=getSharedPreferences("MODE1",MODE_PRIVATE);
        editor=sharedPreferences.edit();
    }

    @Override
    public void onClick(View view) {

        convertStr=typeHere.getText().toString();
        switch (view.getId())
        {
            case R.id.save:

                editor.putString("refname1",""+convertStr);
                editor.commit();
                Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();

                break;
            case R.id.read:

               /* CreateSharedPerf();
                getStrValue=sharedPreferences.getString("refname1","");
                displayValue.setText(""+getStrValue);*/

                startActivity(new Intent(MainActivity.this,HomeActivity.class));


                break;
            case R.id.clear:
                CreateSharedPerf();
                editor.clear();
                editor.commit();

                Toast.makeText(this, "Clear", Toast.LENGTH_SHORT).show();
                break;

        }
    }
}