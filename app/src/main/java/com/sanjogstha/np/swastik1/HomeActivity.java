package com.sanjogstha.np.swastik1;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.DialogInterface;

import com.sanjogstha.np.swastik1.api.ApiService;
import com.sanjogstha.np.swastik1.api.RetroClient;
import com.sanjogstha.np.swastik1.model.Contact;
import com.sanjogstha.np.swastik1.model.Content;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Sugam on 5/1/2016.
 */
public class HomeActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    String username=null;
    private TextView userTextView;

    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;

    private Toolbar mToolbar;
    private ArrayList<Contact> contactArrayList;


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homeactivity);
        Intent getValue = getIntent();


        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawerLayout);
        mNavigationView=(NavigationView)findViewById(R.id.navigation);
        mNavigationView.setNavigationItemSelectedListener(this);



        mToolbar =(Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(R.string.app_name);
        mToolbar.setTitleTextColor(0xFFFFFFFF);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,mDrawerLayout, mToolbar, R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        getApicall();



    }

    private void getApicall() {
        //Creating an object of our api interface
        ApiService api = RetroClient.getApiService();

        contactArrayList = new ArrayList<>();
        /**
         * Calling JSON
         */
        Call<Content> call = api.getMyJSON();

        /**
         * Enqueue Callback will be call when get response...
         */
        call.enqueue(new Callback<Content>() {
            @Override
            public void onResponse(Call<Content> call, Response<Content> response) {


                if(response.isSuccessful()) {
                    String name=null;
                    String email=null;
                    String gender=null;
                    String address=null;
                    Contact.Phone phone=null;
                    contactArrayList = response.body().getContacts();
                    for (int i = 0; i < contactArrayList.size(); i++) {
                        Contact contact = contactArrayList.get(i);
                        name=contact.getName();
                        email=contact.getEmail();
                        gender=contact.getGender();
                        address=contact.getAddress();
                        phone=contact.getPhone();
                        System.out.println("output="+name+email+gender+address+phone.getHome());
                    }
                    System.out.println("conact="+contactArrayList);


                } else {

                }
            }

            @Override
            public void onFailure(Call<Content> call, Throwable t) {
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.item_faculty:
                Intent faculty =new Intent(HomeActivity.this, FacultyActivity.class);
                startActivity(faculty);
                break;
            case R.id.item_about_us:
                Toast.makeText(HomeActivity.this, "We are anonymous.", Toast.LENGTH_LONG).show();
                break;
            case R.id.item_gallery:
                Intent gallery =new Intent(HomeActivity.this, GalleryActivity.class);
                startActivity(gallery);
                break;
            case R.id.item_programs:
                break;
            case R.id.item_settings:
                break;
            case R.id.item_contact_us:
                break;
            case R.id.item_location:
                Intent location = new Intent(HomeActivity.this,MapsActivity.class);
                startActivity(location);
                break;
        }
        return false;
    }


    @Override
    public void onClick(View v) {
        mDrawerLayout.openDrawer(GravityCompat.START);

    }

    public void onBackPressed() {

        //super.onBackPressed();
        Log.d("back button", "back button pressed");
        android.support.v7.app.AlertDialog.Builder ad1=new android.support.v7.app.AlertDialog.Builder(this);
        ad1.setMessage("Are you sure you want to exit? ");
        ad1.setCancelable(false);


        ad1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {


            }
        });

        ad1.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface arg0, int arg1) {
                finish();
            }
        });
        android.support.v7.app.AlertDialog alert=ad1.create();
        alert.show();

    }

}
