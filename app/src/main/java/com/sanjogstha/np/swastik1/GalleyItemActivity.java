package com.sanjogstha.np.swastik1;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class GalleyItemActivity extends AppCompatActivity {

    ImageView galleryItemImageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galley_item);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        galleryItemImageView=(ImageView) findViewById(R.id.galleyItemImageView);

        if (toolbar !=null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            toolbar.setTitle("Swastik Photo");
        }

        Intent getPosition= getIntent();
        int position=getPosition.getIntExtra("position",0);

        Picasso.with(this)
                .load(Constant.urlPath+ Constant.imageList[position])
                .into(galleryItemImageView);


    }

}
