package com.jones.tuto_glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String image = getIntent().getStringExtra("Image");
        String text = getIntent().getStringExtra("texte");

        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText(text);

        ImageView imageView = (ImageView) findViewById(R.id.image);

        ImageLoader.load(this,image,imageView);

    }

    public void back(View v) {
        this.finish();
    }
}
