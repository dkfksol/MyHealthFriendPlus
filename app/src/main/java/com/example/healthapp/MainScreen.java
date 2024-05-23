package com.example.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainScreen extends AppCompatActivity {

    private boolean backPressedOnce = false;

    private FloatingActionButton inputDataButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputDataButton = findViewById(R.id.inputDataButton);
        // "+" 버튼 클릭 이벤트 설정
        inputDataButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainScreen.this, InputData.class);
            startActivity(intent);
        });
    }

    @Override
    public void onBackPressed() {
        // 뒤로 가기 버튼 처리
        if (backPressedOnce) {
            super.onBackPressed();
            finishAffinity();
            return;
        }

        this.backPressedOnce = true;
        Toast.makeText(this, "한 번 더 누르면 종료합니다.", Toast.LENGTH_SHORT).show();

        new android.os.Handler().postDelayed(() -> backPressedOnce = false, 2000);
    }
}