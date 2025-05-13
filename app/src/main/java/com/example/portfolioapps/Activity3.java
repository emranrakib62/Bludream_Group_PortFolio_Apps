package com.example.portfolioapps;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.*;

import java.util.Arrays;
import java.util.List;

public class Activity3 extends AppCompatActivity{

    private RecyclerView recyclerView; // Use class field only

    private final List<Integer> imageList = Arrays.asList(
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4,
            R.drawable.profile
    );

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3); // Make sure this layout has recyclerView

        recyclerView = findViewById(R.id.recyclerView); // Assign to class field
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));

        ImageAdapter adapter = new ImageAdapter(this, imageList, imageResId -> {
            Intent intent = new Intent(Activity3.this, FullscreenActivity.class);
            intent.putExtra("imageResId", imageResId);
            startActivity(intent);
        });

        recyclerView.setAdapter(adapter);
    }
}
