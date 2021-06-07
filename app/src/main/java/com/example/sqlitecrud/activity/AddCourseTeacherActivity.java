package com.example.sqlitecrud.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitecrud.R;
import com.example.sqlitecrud.helpers.DatabaseHelper;

public class AddCourseTeacherActivity extends AppCompatActivity {

    private Button btnStore;
    private EditText etcourse, etphone;

    private DatabaseHelper databaseHelper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_course_teacher);

        databaseHelper = new DatabaseHelper(this);

        btnStore = (Button) findViewById(R.id.btnstore);
        final EditText etname = (EditText) findViewById(R.id.et_name);
        etcourse = (EditText) findViewById(R.id.et_course);
        final EditText etemail = (EditText) findViewById(R.id.et_email);
        etphone = (EditText) findViewById(R.id.et_phone);



        btnStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = etname.getText().toString();
                if (TextUtils.isEmpty(name)){
                    etname.setError("Enter Name");
                    etname.requestFocus();
                    return;
                }

                databaseHelper.addTeachersDetail(
                        etname.getText().toString(),
                        etcourse.getText().toString(),
                        etemail.getText().toString(),
                        etphone.getText().toString());

                etcourse.setText("");
                etphone.setText("");

                Toast.makeText(AddCourseTeacherActivity.this, "Stored Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(AddCourseTeacherActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}