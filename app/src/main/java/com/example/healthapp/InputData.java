package com.example.healthapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inputdata);

        editText1 = findViewById(R.id.editText1);
        editText2 = findViewById(R.id.editText2);
        editText3 = findViewById(R.id.editText3);
        editText4 = findViewById(R.id.editText4);
        editText5 = findViewById(R.id.editText5);
        confirmButton = findViewById(R.id.confirmButton);

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1 = editText1.getText().toString();
                String input2 = editText2.getText().toString();
                String input3 = editText3.getText().toString();
                String input4 = editText4.getText().toString();
                String input5 = editText5.getText().toString();

                if (!input1.isEmpty() && !input2.isEmpty() && !input3.isEmpty() && !input4.isEmpty() && !input5.isEmpty()) {
                    int inputData1 = Integer.parseInt(input1);
                    int inputData2 = Integer.parseInt(input2);
                    int inputData3 = Integer.parseInt(input3);

                    String message = "입력된 데이터: " + inputData1 + ", " + inputData2 + ", " + inputData3 + ", " + input4 + ", " + input5;
                    Toast.makeText(InputData.this, message, Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(InputData.this, MainScreen.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(InputData.this, "데이터를 입력하세요", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
