package com.example.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    private boolean backPressedOnce = false;
    private EditText editTxt;
    private EmailDataSource dataSource;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTxt = findViewById(R.id.edit_txt);
        Button button1 = findViewById(R.id.button1);

        dataSource = new EmailDataSource(this);
        dataSource.open();

        button1.setOnClickListener(v -> {
            String email = editTxt.getText().toString();
            if (TextUtils.isEmpty(email)) {
                // 이메일이 비어있을 경우 경고 메시지 표시
                Toast.makeText(Login.this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
            } else {
                // 이메일이 비어있지 않을 경우 데이터베이스에 저장(데이터베이스에 이메일이 없을 경우만)
                if (dataSource.isEmailExists(email)) {
                    // 화면 전환 코드
                    Intent intent = new Intent(Login.this, MainScreen.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                }
                else {
                    dataSource.insertEmail(email);
                    // 화면 전환 코드
                    Intent intent = new Intent(Login.this, MainScreen.class);
                    intent.putExtra("email", email);
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        dataSource.close();
    }

    @Override
    public void onBackPressed() {
        if (backPressedOnce) {
            super.onBackPressed();
            return;
        }

        this.backPressedOnce = true;
        Toast.makeText(this, "한번 더 누르면 종료합니다.", Toast.LENGTH_SHORT).show();

        new android.os.Handler().postDelayed(() -> backPressedOnce = false, 2000);
    }
}
