package com.example.portfolioapps;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import soup.neumorphism.NeumorphCardView;

public class Activity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_1);
        ImageView profileImage = findViewById(R.id.profileImage);

// State to track zoom
        final boolean[] isZoomed = {false};

        profileImage.setOnClickListener(v -> {
            if (!isZoomed[0]) {
                profileImage.animate()
                        .scaleX(1.5f)
                        .scaleY(1.5f)
                        .setDuration(300)
                        .start();
            } else {
                profileImage.animate()
                        .scaleX(1f)
                        .scaleY(1f)
                        .setDuration(300)
                        .start();
            }
            isZoomed[0] = !isZoomed[0];
        });


        NeumorphCardView eduCard = findViewById(R.id.eduCard);
        NeumorphCardView perCard = findViewById(R.id.perCard);
        NeumorphCardView socialCard = findViewById(R.id.socialCard);

        eduCard.setOnClickListener(v -> {
            Intent intent = new Intent(Activity1.this, EducationalActivity.class);
            startActivity(intent);
        });

        perCard.setOnClickListener(v -> {
            Intent intent = new Intent(Activity1.this, PersonalActivity.class);
            startActivity(intent);
        });

        socialCard.setOnClickListener(v -> {
            Intent intent = new Intent(Activity1.this, SocialActivity.class);
            startActivity(intent);
        });














    }
}