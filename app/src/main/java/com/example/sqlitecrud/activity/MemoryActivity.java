package com.example.sqlitecrud.activity;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sqlitecrud.R;
import com.example.sqlitecrud.adapter.MemoriesAdapter;
import com.example.sqlitecrud.food.Food;
import com.example.sqlitecrud.food.FoodActivity;
import com.example.sqlitecrud.food.FoodListActivity;
import com.example.sqlitecrud.food.FoodListAdapter;
import com.example.sqlitecrud.helpers.MemoryDbHelper;
import com.example.sqlitecrud.model.Memory;

import java.util.ArrayList;


public class MemoryActivity extends AppCompatActivity {
    private MemoryDbHelper dbHelper;
    private GridView gridView;
    private ArrayList<Memory> memoryArrayList;
    private ImageView imageView;

    private MemoriesAdapter memoriesAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        this.gridView = (GridView) findViewById(R.id.activity_main_grid_view);

//        memoryArrayList = dbHelper.readAllMemories();
//        memoriesAdapter = new MemoriesAdapter(this, R.layout.memory_list_item, memoryArrayList);
//        gridView.setAdapter(memoriesAdapter);
        // get all data from sqlite
//        Cursor cursor = dbHelper.readAllMemories();
//        memoryArrayList.clear();
        /*while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            byte[] image = cursor.getBlob(2);

            memoryArrayList.add(new Memory(title, image, id));
        }*/
//        memoriesAdapter.notifyDataSetChanged();






        this.dbHelper = new MemoryDbHelper(this);
        this.gridView.setAdapter(new MemoriesAdapter(this, this.dbHelper.readAllMemories(), false));
        this.gridView.setEmptyView(findViewById(R.id.activity_main_empty_view));

        ///setonclick
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MemoryActivity.this, UpdateMemoryActivity.class);
                Cursor cursor = dbHelper.readAllMemories();
                ArrayList<Integer> arrID = new ArrayList<Integer>();
                while (cursor.moveToNext()){
                    arrID.add(cursor.getInt(0));
                }

                intent.putExtra("memories", position);
                startActivity(intent);
            }
        });

        ///set on long click
        gridView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                CharSequence[] items = {"Update", "Delete"};
                AlertDialog.Builder dialog = new AlertDialog.Builder(MemoryActivity.this);
                dialog.setTitle("Choose an action");
                dialog.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if (which == 0){
                            ///update
                            Cursor cursor = dbHelper.readAllMemories();
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (cursor.moveToNext()){
                                arrID.add(cursor.getInt(0));
                            }
                            // show dialog update at here
                            showDialogUpdate( MemoryActivity.this, arrID.get(position));
                        }
                        else {
                            Cursor c = dbHelper.readAllMemories();
                            ArrayList<Integer> arrID = new ArrayList<Integer>();
                            while (c.moveToNext()){
                                arrID.add(c.getInt(0));
                            }
                            showDialogDelete(arrID.get(position));
                        }
                    }
                });


                dialog.show();
                return true;
            }
        });

    }

    private void showDialogDelete(int idMemory) {
        final AlertDialog.Builder dialogDelete = new AlertDialog.Builder(MemoryActivity.this);

        dialogDelete.setTitle("Warning!!");
        dialogDelete.setMessage("Are you sure you want to this delete?");
        dialogDelete.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    dbHelper.deleteMemory(idMemory);
//                    Intent intent = new Intent(MemoryActivity.)
                    Toast.makeText(getApplicationContext(), "Delete successfully!!!",Toast.LENGTH_SHORT).show();
                } catch (Exception e){
                    Log.e("error", e.getMessage());
                }
//                updateMemory();
            }
        });
        dialogDelete.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        dialogDelete.show();
    }

    private void updateMemory(){
        // get all data from sqlite
        Cursor cursor = dbHelper.readAllMemories();
        memoryArrayList.clear();
        /*while (cursor.moveToNext()) {
            int id = cursor.getInt(0);
            String title = cursor.getString(1);
            byte[] image = cursor.getBlob(2);

            memoryArrayList.add(new Memory(title, image, id));
        }*/
        memoriesAdapter.notifyDataSetChanged();
    }

    private void showDialogUpdate(Activity memoryActivity, int position) {
        final Dialog dialog = new Dialog(memoryActivity);
        dialog.setContentView(R.layout.activity_update_memory);

        dialog.setTitle("Update");

        Intent intent = new Intent(MemoryActivity.this, UpdateMemoryActivity.class);
        intent.putExtra("memories", position);
        startActivity(intent);

        imageView = (ImageView) dialog.findViewById(R.id.update_memory_selected_image);
        final EditText edtName = (EditText) dialog.findViewById(R.id.update_memory_title);
        Button btnUpdate = (Button) dialog.findViewById(R.id.btnUpdate_memory);

//
        // set width for dialog
        int width = (int) (memoryActivity.getResources().getDisplayMetrics().widthPixels * 0.95);
        // set height for dialog
        int height = (int) (memoryActivity.getResources().getDisplayMetrics().heightPixels * 0.7);
        dialog.getWindow().setLayout(width, height);
        dialog.show();
//
//        imageView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // request photo library
//                ActivityCompat.requestPermissions(
//                        MemoryActivity.this,
//                        new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
//                        888
//                );
//            }
//        });
//
//        btnUpdate.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                try {
//                    dbHelper.updateMemory(
//                            edtName.getText().toString().trim(),
//                            FoodActivity.imageViewToByte(imageView),
//                            position
//                    );
//                    dialog.dismiss();
//                    Toast.makeText(getApplicationContext(), "Update successfully!!!",Toast.LENGTH_SHORT).show();
//                }
//                catch (Exception error) {
//                    Log.e("Update error", error.getMessage());
//                }
//                updateMemory();
//            }
//        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        ((CursorAdapter)gridView.getAdapter()).swapCursor(this.dbHelper.readAllMemories());
    }

    public void addNewMemory(View view) {
        Intent intent = new Intent(this, NewMemoryActivity.class);
        startActivity(intent);
    }
}