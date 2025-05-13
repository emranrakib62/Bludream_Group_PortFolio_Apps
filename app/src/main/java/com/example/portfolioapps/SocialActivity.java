package com.example.portfolioapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import soup.neumorphism.NeumorphCardView;

public class SocialActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_social);

        NeumorphCardView fbBtn = findViewById(R.id.neumorph_button_1);
        NeumorphCardView instaBtn = findViewById(R.id.neumorph_button_2);
        NeumorphCardView linkedinBtn = findViewById(R.id.neumorph_button_3);
        NeumorphCardView twitterBtn = findViewById(R.id.neumorph_button_4);

        fbBtn.setOnClickListener(v -> startActivity(new Intent(this, fbactivity.class)));
        //instaBtn.setOnClickListener(v -> startActivity(new Intent(this, InstagramActivity.class)));
        //linkedinBtn.setOnClickListener(v -> startActivity(new Intent(this, Linkactivity.class)));
        //twitterBtn.setOnClickListener(v -> startActivity(new Intent(this, TwitterActivity.class)));
    }
}
