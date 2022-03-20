package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

public class Information extends AppCompatActivity {

    private static final String TAG = "myLogs";
    private Toolbar toolbar_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information);

        toolbar_info = (Toolbar) findViewById(R.id.toolbar);
        toolBarSet();

        ImageButton imageButton = (ImageButton) findViewById(R.id.my_github);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.my_github)));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d(TAG, "Не получается обработать намерение запуска github!");
                }
            }
        });

        imageButton.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast toast = Toast.makeText(getApplicationContext(), "Кнопку надо отпускать :)", Toast.LENGTH_SHORT);
                toast.show();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.my_github)));
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d(TAG, "Не получается обработать намерение запуска github!");
                }
                return false;
            }
        });

    }

    private void toolBarSet() {
        setSupportActionBar(toolbar_info);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }
        getSupportActionBar().setTitle("Информация");
    }

    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Information: onStart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "MainActivity: OnDestroy");
    }
}