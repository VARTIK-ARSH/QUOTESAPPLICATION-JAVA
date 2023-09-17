package com.google.quotesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textQuotes;
    private ImageView imagereset,imageshare;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textQuotes = findViewById(R.id.textquotes);
        imagereset = findViewById(R.id.imagereset);
        imageshare = findViewById(R.id.imageshare);

        imageshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT,textQuotes.getText().toString());
                startActivity(Intent.createChooser(intent,"share now"));
            }
        });

        imagereset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Quotestring quotestring = new Quotestring();
                textQuotes.setText(quotestring.getrandomquotes());
            }
        });
    }
}