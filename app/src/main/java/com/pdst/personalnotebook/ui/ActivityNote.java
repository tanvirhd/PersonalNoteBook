package com.pdst.personalnotebook.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.pdst.personalnotebook.R;

public class ActivityNote extends AppCompatActivity {
    Button button ;

    Spinner spinner = (Spinner) findViewById(R.id.spinner);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.category, android.R.layout.simple_spinner_item);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        button = findViewById(R.id.button);
    }

    public void home(View view) {
        Intent in = new Intent(ActivityNote.this, ActivityHome.class);
        startActivity(in);
    }
}