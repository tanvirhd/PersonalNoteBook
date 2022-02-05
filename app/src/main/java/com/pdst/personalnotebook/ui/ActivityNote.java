package com.pdst.personalnotebook.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.pdst.personalnotebook.R;
import com.pdst.personalnotebook.model.ModelNote;
import com.pdst.personalnotebook.viewmodel.ViewModelNote;

import java.util.Locale;

public class ActivityNote extends AppCompatActivity {
    private Button button;
    private EditText etNoteTitle;
    private EditText etNoteDes;


    private ViewModelNote viewModelNote;

    /*Spinner spinner = (Spinner) findViewById(R.id.spinner);
    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
            R.array.category, android.R.layout.simple_spinner_item);*/



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);
        /*adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);*/

        init();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etNoteTitle.getText().toString().isEmpty() && etNoteDes.getText().toString().isEmpty()){
                    Toast.makeText(ActivityNote.this, "Something went wrong!", Toast.LENGTH_SHORT).show();
                }else{
                    insertNewNote();
                    Toast.makeText(ActivityNote.this, "Note added!", Toast.LENGTH_SHORT).show();

                    Intent in = new Intent(ActivityNote.this, ActivityHome.class);
                    startActivity(in);
                }
            }
        });


    }

    private void init(){
        button = findViewById(R.id.button);
        etNoteTitle=findViewById(R.id.etNoteTitle);
        etNoteDes=findViewById(R.id.etNoteDes);

        viewModelNote=new ViewModelProvider.AndroidViewModelFactory(getApplication()).create(ViewModelNote.class);
    }

    private void insertNewNote(){
        viewModelNote.insertNewNote(new ModelNote(
                etNoteTitle.getText().toString(),
                etNoteDes.getText().toString(),
                "02/02/2022",
                1,
                false,
                false,
                true,
                "1234"
        ));
    }

}