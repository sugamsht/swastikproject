package com.sanjogstha.np.swastik1.adapter;

import android.content.Context;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.sanjogstha.np.swastik1.Constant;
import com.sanjogstha.np.swastik1.GalleryActivity;
import com.sanjogstha.np.swastik1.R;
import com.squareup.picasso.Picasso;

/**
 * Created by Sugam on 5/15/2016.
 */
public class ImageAdapter extends BaseAdapter {

    Context context;

    LayoutInflater layoutInflater;
    ImageView galleryImageView;
    private String[] imageList;
    private String urlPath;

    public  ImageAdapter(GalleryActivity galleryActivity)
    {
        context = galleryActivity;
        imageList= Constant.imageList;
        urlPath=Constant.urlPath;

    }


    @Override
    public int getCount() {
        return imageList.length;
    }

    @Override
    public Object getItem(int position) {
        return imageList[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //ImageView imageView =new ImageView(context);

        if(layoutInflater==null){
            layoutInflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.gallery_gridview_items,null);
        }

        galleryImageView=(ImageView) convertView.findViewById(R.id.gridImageView);

        //imageView.setImageResource(R.drawable.menu_ic);

        Picasso.with(context)
                .load(urlPath+ imageList[position])
                .into(galleryImageView);


        System.out.println("url" + urlPath + imageList[position]);
        //galleryImageView.setLayoutParams(new GridView.LayoutParams(320,320));

        return galleryImageView;
    }
}
