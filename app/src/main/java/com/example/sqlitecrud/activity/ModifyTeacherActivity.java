package com.example.sqlitecrud.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitecrud.R;
import com.example.sqlitecrud.helpers.DatabaseHelper;
import com.example.sqlitecrud.model.TeachersModel;

public class ModifyTeacherActivity extends AppCompatActivity {

    private TeachersModel teachersModel;
    private EditText etname, etcourse, etemail, etphone;
    private Button btnupdate, btndelete;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_teacher);

        Intent intent = getIntent();
        teachersModel = (TeachersModel) intent.getSerializableExtra("teachers");

        databaseHelper = new DatabaseHelper(this);

        etname = (EditText) findViewById(R.id.etname);
        etcourse = (EditText) findViewById(R.id.etcourse);
        etemail = (EditText) findViewById(R.id.etemail);
        etphone = (EditText) findViewById(R.id.etphone);
        btndelete = (Button) findViewById(R.id.btndelete);
        btnupdate = (Button) findViewById(R.id.btnupdate);

        etname.setText(teachersModel.getName());
        etcourse.setText(teachersModel.getCourse());
        etemail.setText(teachersModel.getEmail());
        etphone.setText(teachersModel.getPhone());

        btnupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.updateTeachers(teachersModel.getId(),etname.getText().toString(),etcourse.getText().toString(),etemail.getText().toString(), etphone.getText().toString());
                Toast.makeText(ModifyTeacherActivity.this, "Updated Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ModifyTeacherActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

        btndelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databaseHelper.deleteUSer(teachersModel.getId());
                Toast.makeText(ModifyTeacherActivity.this, "Deleted Successfully!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(ModifyTeacherActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
}