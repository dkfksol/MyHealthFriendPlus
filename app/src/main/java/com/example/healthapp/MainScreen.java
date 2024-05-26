package com.example.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainScreen extends AppCompatActivity {

    private boolean backPressedOnce = false;

    private FloatingActionButton inputDataButton;
    private Button intputFoodButton;
    private Button button;

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

        intputFoodButton = findViewById(R.id.FoodInsertButton);
        intputFoodButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainScreen.this, FoodMainActivity.class);
            startActivity(intent);
        });

        // 인바디 정보 설정
        TextView weightTextView = findViewById(R.id.weight);
        TextView bodyFatPercentageTextView = findViewById(R.id.bodyFatPercentage);
        TextView muscleMassTextView = findViewById(R.id.muscleMass);

        weightTextView.setText("체중: 70kg");
        bodyFatPercentageTextView.setText("체지방률: 15%");
        muscleMassTextView.setText("근육량: 55kg");

        button = findViewById(R.id.asktomirror);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainScreen.this, TempTest_12.class);
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