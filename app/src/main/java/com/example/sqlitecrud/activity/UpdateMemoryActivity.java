package com.example.sqlitecrud.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.sqlitecrud.R;
import com.example.sqlitecrud.helpers.DatabaseHelper;
import com.example.sqlitecrud.helpers.MemoryContract;
import com.example.sqlitecrud.helpers.MemoryDbHelper;
import com.example.sqlitecrud.model.Memory;
import com.example.sqlitecrud.model.TeachersModel;

import java.io.IOException;
import java.io.InputStream;

public class UpdateMemoryActivity extends AppCompatActivity {

    private static final int GALLERY_REQUEST_CODE = 100;
    private static final int CAMERA_REQUEST_CODE = 200;
    private ImageView selectedImageView;
    private EditText titleEditText;
    private Memory memory;
    private MemoryDbHelper memoryDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_memory);

        memoryDbHelper = new MemoryDbHelper(this);

        Intent intent = getIntent();
        int position = intent.getExtras().getInt("memories");


//
//        ImageView selectedImageView = new ImageView();

        selectedImageView = (ImageView) findViewById(R.id.update_memory_selected_image);
        titleEditText = (EditText) findViewById(R.id.update_memory_title);
        Toast.makeText(this, "posisi : " +position, Toast.LENGTH_SHORT).show();

//        titleEditText.setText(memory.getTitle());

    }

    public void openUpdateGallery(View view) {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), GALLERY_REQUEST_CODE);
    }

    public void openUpdateCamera(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, CAMERA_REQUEST_CODE);
//            Toast.makeText(this, "Success CAPTURED IMAGE", Toast.LENGTH_SHORT).show();

        }
    }

    public void cancelUpdate(View view) {
        finish();
    }

    public void saveUpdate(View view) {
        Bitmap image = ((BitmapDrawable) selectedImageView.getDrawable()).getBitmap();
        new MemoryDbHelper(this).addMemory(new Memory(titleEditText.getText().toString(), image));
        finish();
    }

    public void deleteUpdate(View view) {
//        memoryDbHelper.deleteMemory(MemoryContract.MemoryEntry._ID);
        Toast.makeText(getApplicationContext(), "Delete successfully!!!", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == GALLERY_REQUEST_CODE) {
            try {
                Uri selectedImage = data.getData();
                InputStream imageStream = getContentResolver().openInputStream(selectedImage);
                selectedImageView.setImageBitmap(BitmapFactory.decodeStream(imageStream));
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        }

        if (requestCode == CAMERA_REQUEST_CODE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            selectedImageView.setImageBitmap(imageBitmap);
        }
    }
}