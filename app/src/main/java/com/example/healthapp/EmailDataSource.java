package com.example.healthapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.widget.Toast;

public class EmailDataSource {

    private SQLiteDatabase database;
    private DatabaseHelper dbHelper;
    private Context mContext;

    public EmailDataSource(Context context) {
        mContext = context;
        dbHelper = new DatabaseHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    public void close() {
        dbHelper.close();
    }

    public void insertEmail(String email) {
        // 이메일이 비어있는지 확인
        if (TextUtils.isEmpty(email)) {
            // 이메일이 비어있을 경우 경고 메시지 표시
            Toast.makeText(mContext, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show();
            return; // 메서드 종료
        }

        ContentValues values = new ContentValues();
        values.put(DatabaseHelper.COLUMN_EMAIL, email);
        long insertId = database.insert(DatabaseHelper.TABLE_NAME, null, values);
        if (insertId == -1) {
            // 삽입이 실패한 경우 처리할 코드를 여기에 추가
            Toast.makeText(mContext, "이메일 저장에 실패했습니다.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(mContext, "이메일이 성공적으로 저장되었습니다.", Toast.LENGTH_SHORT).show();
        }
    }
}

