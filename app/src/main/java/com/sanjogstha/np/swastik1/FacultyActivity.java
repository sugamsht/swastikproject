package com.sanjogstha.np.swastik1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

/**
 * Created by Sugam on 5/14/2016.
 */
public class FacultyActivity extends AppCompatActivity
{
    ListView facultyListView;
    Toolbar toolbar;

    String[] facultyList=
            {
            "Suraj Karki",
            "Murari Karki",
            "Bishnu Rawal",
            "Deep Bhujel",
            "Thaneswor Paneru",
            "Anju Khadka",
            "Bikram Rawat",
            "Samir Giri",
            "Sushil Nepal",
            "Ganesh Joshi",
            "Rakesh K. Bachhan",
            "Rajendra Shrestha",
            "Visiting Faculties",


    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        facultyListView=(ListView) findViewById(R.id.item_faculty);
        toolbar=(Toolbar) findViewById(R.id.toolbar);



        if (toolbar !=null){
            setSupportActionBar(toolbar);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        }


        ArrayAdapter adapter = new ArrayAdapter<String>(this,R.layout.list_item,facultyList);
        facultyListView.setAdapter(adapter);

        facultyListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(FacultyActivity.this, facultyList[position], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
