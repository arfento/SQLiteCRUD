package com.example.sqlitecrud.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;;

import com.example.sqlitecrud.R;
import com.example.sqlitecrud.adapter.CustomAdapterTeacher;
import com.example.sqlitecrud.food.FoodActivity;
import com.example.sqlitecrud.helpers.DatabaseHelper;
import com.example.sqlitecrud.model.TeachersModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button addTeachers;
    Button modTeachers;
    Button btnHistory;
    Button btnOpenMap;
    Button btnCameraMap;
    Button btnFood;

    private ListView listView;
    private ArrayList<TeachersModel> teachersModelArrayList;
    private CustomAdapterTeacher customAdapterTeacher;
    private DatabaseHelper databaseHelper;

    public  void addTeachersActivity(){
        addTeachers= (Button)findViewById(R.id.btn_add_teacher);
        addTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addTeachersr = new Intent(MainActivity.this, AddCourseTeacherActivity.class);
                startActivity(addTeachersr);

            }
        });
    }
    public  void openMapActivity(){
        btnOpenMap= (Button)findViewById(R.id.btn_map);
        btnOpenMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentOpenMap = new Intent(MainActivity.this, MapActivity.class);
                startActivity(intentOpenMap);

            }
        });
    }
    public  void openCameraActivity(){
        btnCameraMap= (Button)findViewById(R.id.btn_camera);
        btnCameraMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCamera = new Intent(MainActivity.this, MemoryActivity.class);
                startActivity(intentCamera);

            }
        });
    }



    public void modTeachersActivity(){
        modTeachers= (Button)findViewById(R.id.btn_teacher_modify);
        modTeachers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent modTeachersr = new Intent(MainActivity.this, ModTeacherActivity.class);
                startActivity(modTeachersr);

            }
        });
    }

    public void btnHistoryActivity(){
        btnHistory= (Button)findViewById(R.id.btn_history);
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentHistory = new Intent(MainActivity.this, HistoryActivity.class);
                startActivity(intentHistory);

            }
        });
    }
    public void openFood(){
        btnFood= (Button)findViewById(R.id.btn_food);
        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentFood = new Intent(MainActivity.this, FoodActivity.class);
                startActivity(intentFood);

            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTeachersActivity();
        modTeachersActivity();
        btnHistoryActivity();
        openMapActivity();
        openCameraActivity();
        openFood();


        listView = (ListView) findViewById(R.id.teachers_lv);

        databaseHelper = new DatabaseHelper(this);

        teachersModelArrayList = databaseHelper.getAllTeachers();

        customAdapterTeacher = new CustomAdapterTeacher(this,teachersModelArrayList);
        listView.setAdapter(customAdapterTeacher);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this,ModifyTeacherActivity.class);
                intent.putExtra("teachers",teachersModelArrayList.get(position));
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.search_menu, menu);
        MenuItem item  = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) item.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener(){
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }
            @Override
            public boolean onQueryTextChange(String newText) {
                customAdapterTeacher.getFilter().filter(newText);
                return false;
            }

        });


        return super.onCreateOptionsMenu(menu);

    }
}