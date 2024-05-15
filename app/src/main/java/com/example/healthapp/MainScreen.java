package com.example.healthapp;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainScreen extends AppCompatActivity {

    private boolean backPressedOnce = false;

    private FloatingActionButton menuButton;
    private DrawerLayout drawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton menuButton = findViewById(R.id.menuButton);
        FloatingActionButton helpButton = findViewById(R.id.helpButton);

        // 메뉴 버튼 클릭 이벤트 설정
        // toggleButton.setOnClickListener(v -> toggleSideMenu());

        // 사이드 메뉴 아이템 클릭 이벤트 핸들러 설정 (예시)
        /*
        findViewById(R.id.menu_item1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainScreen.this, "메뉴 아이템 1 클릭", Toast.LENGTH_SHORT).show();
                // 여기에 메뉴 아이템을 클릭했을 때 수행할 동작을 추가하세요.
            }
        });
        */

        // 메뉴 버튼 클릭 이벤트 설정
        menuButton.setOnClickListener(view -> {
            // 메뉴 버튼을 클릭했을 때 수행할 동작 추가
            // 예: 도움말 화면 열기 등
            Toast.makeText(MainScreen.this, "메뉴 버튼 클릭", Toast.LENGTH_SHORT).show();
        });
        
        // 도움말 버튼 클릭 이벤트 설정
        helpButton.setOnClickListener(view -> {
            // 도움말 버튼을 클릭했을 때 수행할 동작 추가
            // 예: 도움말 화면 열기 등
            Toast.makeText(MainScreen.this, "도움말 버튼 클릭", Toast.LENGTH_SHORT).show();
        });
    }

    // 사이드바 메뉴를 열거나 닫는 메소드
    /*
    private void toggleSideMenu() {
        if (sideMenuLayout.getVisibility() == View.VISIBLE) {
            sideMenuLayout.setVisibility(View.GONE); // 메뉴가 열려있으면 닫기
        } else {
            sideMenuLayout.setVisibility(View.VISIBLE); // 메뉴가 닫혀있으면 열기
        }
    }
    */

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        // 네비게이션 드로어 토글 버튼 이벤트 처리
        // 예: 네비게이션 드로어 열고 닫기
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        // 뒤로 가기 버튼 처리
        // 예: 한 번 더 누르면 종료
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
