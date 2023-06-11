package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class display extends AppCompatActivity {
    RecyclerView recyclerView;
    FloatingActionButton add_button;

    DatabaseHelper db ;
    ArrayList <String> id, operation, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        db = new DatabaseHelper(display.this);
        id =new ArrayList<>();
        operation =new ArrayList<>();
        result =new ArrayList<>();

        storeDataInArray();
    }

    void storeDataInArray(){
        Cursor cursor = db.readAllData();
        if (cursor.getCount()==0){
            Toast.makeText(this, "No data available", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()){
                id.add((cursor.getString(0)));
                operation.add((cursor.getString(1)));
                result.add((cursor.getString(2)));
            }
        }
    }
}