package com.example.collinsyaimok0497;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.squareup.picasso.Picasso;

public class PretparkDetail extends AppCompatActivity {
    private DatabaseReference mDatabase;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pretpark_detail);

        Bundle extras = getIntent().getExtras();
        String bericht = extras.getString("categorie");


        imageView = findViewById(R.id.imageView);
        Picasso.get().load(bericht).into(imageView);
    }
}


