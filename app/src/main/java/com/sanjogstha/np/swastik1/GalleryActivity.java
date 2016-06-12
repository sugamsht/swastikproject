package com.sanjogstha.np.swastik1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.sanjogstha.np.swastik1.adapter.ImageAdapter;

/**
 * Created by Sugam on 5/15/2016.
 */
public class GalleryActivity extends AppCompatActivity {
    GridView galleryGridView;
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        galleryGridView=(GridView) findViewById(R.id.item_gallery);
        galleryGridView.setAdapter(new ImageAdapter(this));

        toolbar=(Toolbar) findViewById(R.id.toolbar);


        if (toolbar !=null) {
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        galleryGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                Intent galleryItem=new Intent(GalleryActivity.this, GalleyItemActivity.class);
                galleryItem.putExtra("position",position);
                startActivity(galleryItem);
            }
        });

    }
}
