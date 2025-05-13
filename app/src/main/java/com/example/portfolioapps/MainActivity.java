package com.example.portfolioapps;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

import soup.neumorphism.NeumorphCardView;

public class MainActivity extends AppCompatActivity {

    private ViewPager2 viewPager;
    private GridView gridView;
    private NeumorphCardView neumorphCard;
    private Handler sliderHandler;
    private Runnable sliderRunnable;

    private final List<Integer> sliderImages = new ArrayList<>();

    private final int[] images = {
            R.drawable.icon, R.drawable.boi, R.drawable.gal1,
            R.drawable.life, R.drawable.cv, R.drawable.blue, R.drawable.cv, R.drawable.cv
    };

    private final String[] titles = {
            "CEO Profile", "Written Book", "Photo Gallery",
            "Life Story In Video", "Life Story Content", "Blue Dream Group", "Question Pattern", "Others"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        gridView = findViewById(R.id.gridview);

        neumorphCard = findViewById(R.id.myNeumorphCard);


        ValueAnimator animator = ValueAnimator.ofFloat(6f, 1f, 6f);
        animator.setDuration(4000);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setRepeatMode(ValueAnimator.REVERSE);

        animator.addUpdateListener(animation -> {
            float value = (float) animation.getAnimatedValue();
            neumorphCard.setShadowElevation(value);
        });

        animator.start();



        sliderImages.add(R.drawable.pic1);
        sliderImages.add(R.drawable.pic2);
        sliderImages.add(R.drawable.pic3);
        sliderImages.add(R.drawable.pic4);

        SliderAdapter sliderAdapter = new SliderAdapter(sliderImages);
        viewPager.setAdapter(sliderAdapter);

        sliderHandler = new Handler(Looper.getMainLooper());
        sliderRunnable = () -> {
            int next = (viewPager.getCurrentItem() + 1) % sliderImages.size();
            viewPager.setCurrentItem(next, true);
            sliderHandler.postDelayed(sliderRunnable, 9000);
        };
        sliderHandler.postDelayed(sliderRunnable, 9000);

        // GridView setup
        GridAdapter adapter = new GridAdapter(this, images, titles);
        gridView.setAdapter(adapter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 9000);
    }


    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setMessage("Are you sure you want to exit?")
                .setPositiveButton("Yes", (dialog, which) -> {
                    // Exit the app
                    finishAffinity(); // Closes all activities
                })
                .setNegativeButton("No", (dialog, which) -> {
                    dialog.dismiss(); // Close the dialog and do nothing
                })
                .show();
    }


    // Slider Adapter
    public static class SliderAdapter extends RecyclerView.Adapter<SliderAdapter.ViewHolder> {
        private final List<Integer> images;

        public SliderAdapter(List<Integer> images) {
            this.images = images;
        }

        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.imageView.setImageResource(images.get(position));
        }

        @Override
        public int getItemCount() {
            return images.size();
        }

        static class ViewHolder extends RecyclerView.ViewHolder {
            ImageView imageView;

            ViewHolder(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.sliderImageView);
            }
        }
    }

    // Grid Adapter with left-right animation
    // Grid Adapter with left-right animation
    public class GridAdapter extends BaseAdapter {
        private final Context context;
        private final int[] images;
        private final String[] titles;

        public GridAdapter(Context context, int[] images, String[] titles) {
            this.context = context;
            this.images = images;
            this.titles = titles;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
            }

            ImageView imageView = convertView.findViewById(R.id.imageView);
            TextView textView = convertView.findViewById(R.id.titleTextView);

            imageView.setImageResource(images[position]);
            textView.setText(titles[position]);

            convertView.setOnClickListener(v -> {
                Intent intent;
                switch (position) {
                    case 0:
                        intent = new Intent(context, Activity1.class);
                        break;
                    case 1:
                        intent = new Intent(context, Activity2.class);
                        break;
                    case 2:
                        intent = new Intent(context, Activity3.class);
                        break;
                    case 3:
                        intent = new Intent(context, ActivityEm1.class);
                        break;
                    case 4:
                        intent = new Intent(context, Activity5.class);
                        break;
                    case 5:
                        intent = new Intent(context, Activity6.class);
                        break;
                    case 6:
                        intent = new Intent(context, Activity7.class);
                        break;
                    case 7:
                        intent = new Intent(context, Activity8.class);
                        break;
                    default:
                        return;
                }
                context.startActivity(intent);
            });

            return convertView;
        }

    }
}