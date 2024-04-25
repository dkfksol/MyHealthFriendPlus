package com.example.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainScreen extends AppCompatActivity {

    private boolean backPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    @Override
    public void onBackPressed() {
        if (backPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.backPressedOnce = true;
        Toast.makeText(this, "한 번 더 누르면 종료 됩니다.", Toast.LENGTH_SHORT).show();

        new android.os.Handler().postDelayed(() -> backPressedOnce = false, 2000);
    }
}
