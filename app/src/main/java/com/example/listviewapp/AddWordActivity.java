package com.example.listviewapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddWordActivity extends AppCompatActivity {
    EditText etWord, etDefinition;
    Button btnAddWord;
    Button btnOpenDictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        etWord = findViewById(R.id.etWord);
        etDefinition = findViewById(R.id.etMeaning);
        btnAddWord = findViewById(R.id.btnAddWord);
        btnOpenDictionary = findViewById(R.id.btnOpenDictionary);

        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Save();
            }    
        });


    }

    private void Save() {
        try {
            PrintStream ps = new PrintStream(openFileOutput("word.txt", MODE_PRIVATE/ MODE_APPEND));
            ps.println(etWord.getText().toString()+ "->" + etDefinition.getText().toString());
            Toast.makeText(this, "Saved to" + getFilesDir(), Toast.LENGTH_SHORT).show();
        }
          catch (IOException e){
            e.printStackTrace();
          }
    }
}