package com.example.portfolioapps;



import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import java.util.Arrays;
import java.util.List;

public class FullscreenActivity extends AppCompatActivity {

    private final List<Integer> imageList = Arrays.asList(
            R.drawable.pic1,
            R.drawable.pic2,
            R.drawable.pic3,
            R.drawable.pic4
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

         ViewPager2 viewPager = findViewById(R.id.viewPager);

        int imageResId = getIntent().getIntExtra("imageResId", -1);
        int startPosition = imageList.indexOf(imageResId);

        FullscreenImageAdapter adapter = new FullscreenImageAdapter(this, imageList);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(startPosition != -1 ? startPosition : 0, false);
    }
}
