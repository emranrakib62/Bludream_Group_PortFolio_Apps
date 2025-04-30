package com.example.portfolioapps;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class FullScreenActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);

        ImageView imageView = findViewById(R.id.fullImageView);

        int imageResId = getIntent().getIntExtra("imageResId", -1);
        if (imageResId != -1) {
            imageView.setImageResource(imageResId);
        }
    }
}
