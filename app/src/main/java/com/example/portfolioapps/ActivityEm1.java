package com.example.portfolioapps;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import soup.neumorphism.NeumorphCardView;

public class ActivityEm1 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_em1);

        NeumorphCardView neumorphButton = findViewById(R.id.neumorph_button);

        neumorphButton.setOnClickListener(v -> {
            Intent intent = new Intent(ActivityEm1.this, ActivityEm2.class);
            startActivity(intent);
        });
    }
}
