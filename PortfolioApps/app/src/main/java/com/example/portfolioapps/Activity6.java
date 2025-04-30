package com.example.portfolioapps;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import soup.neumorphism.NeumorphCardView;

public class Activity6 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6); // Make sure the layout filename matches

        NeumorphCardView bludream = findViewById(R.id.bludream);
        NeumorphCardView fabric = findViewById(R.id.fabric);
        NeumorphCardView interior = findViewById(R.id.interior);
        NeumorphCardView leather = findViewById(R.id.leather);
        NeumorphCardView realstate = findViewById(R.id.realstate);
        NeumorphCardView asian = findViewById(R.id.Asian);

        bludream.setOnClickListener(v -> startActivity(new Intent(this, bluedream.class)));
        fabric.setOnClickListener(v -> startActivity(new Intent(this, fabric.class)));
        interior.setOnClickListener(v -> startActivity(new Intent(this, interior.class)));
        leather.setOnClickListener(v -> startActivity(new Intent(this, leather.class)));
        realstate.setOnClickListener(v -> startActivity(new Intent(this, realstate.class)));
        asian.setOnClickListener(v -> startActivity(new Intent(this, asian.class)));
    }
}
