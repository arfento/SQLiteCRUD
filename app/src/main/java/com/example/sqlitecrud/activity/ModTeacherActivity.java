package com.example.sqlitecrud.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.sqlitecrud.R;
import com.example.sqlitecrud.adapter.CustomMod;
import com.example.sqlitecrud.helpers.DatabaseHelper;
import com.example.sqlitecrud.model.TeachersModel;

import java.util.ArrayList;

public class ModTeacherActivity extends AppCompatActivity {

    private ListView listView;
    private ArrayList<TeachersModel> teachersModelArrayList;
    private CustomMod customMod;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mod_teacher);

        listView = (ListView) findViewById(R.id.teachers_lvi);

        databaseHelper = new DatabaseHelper(this);

        teachersModelArrayList = databaseHelper.getAllTeachers();

        customMod = new CustomMod(this,teachersModelArrayList);
        listView.setAdapter(customMod);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ModTeacherActivity.this,ModifyTeacherActivity.class);
                intent.putExtra("teachers",teachersModelArrayList.get(position));
                startActivity(intent);
            }

        });
    }
}