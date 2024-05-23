package com.example.healthapp;

import static java.sql.Types.NULL;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class InputData extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;
    private EditText editText4;
    private EditText editText5;
    private Button confirmButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputdata); // activity_input_data 레이아웃 파일을 설정

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        confirmButton = findViewById(R.id.confirmButton);

        // 확인 버튼 클릭 이벤트 설정
        confirmButton.setOnClickListener(view -> {
            int inputData1 = Integer.parseInt(editText1.getText().toString());
            int inputData2 = Integer.parseInt(editText2.getText().toString());
            int inputData3 = Integer.parseInt(editText3.getText().toString());
            String inputData4 = editText4.getText().toString();
            String inputData5 = editText5.getText().toString();

            if (inputData1 != NULL && inputData2 != NULL &&
                inputData3 != NULL && !inputData4.isEmpty() &&
                !inputData5.isEmpty()) {
                Toast.makeText(InputData.this, "입력된 데이터: " + inputData1 + ", " + inputData2 + ", "
                        + inputData3 + ", " + inputData4 + ", " + inputData5, Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(InputData.this, MainScreen.class);
                startActivity(intent);
            } else {
                Toast.makeText(InputData.this, "데이터를 입력하세요", Toast.LENGTH_SHORT).show();
            }
        });
    }
}