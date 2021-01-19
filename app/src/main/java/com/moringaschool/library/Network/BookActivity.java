package com.moringaschool.library.Network;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.moringaschool.library.R;

public class BookActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        // hiding the default actionbar
        getSupportActionBar().hide();

        // Receiving data

        String name  = getIntent().getExtras().getString("book_name");
        String description = getIntent().getExtras().getString("book_description");
        String studio = getIntent().getExtras().getString("book_publisher") ;
        String category = getIntent().getExtras().getString("book_kategori");
        int nb_episode = getIntent().getExtras().getInt("book_nb_pages") ;
        String rating = getIntent().getExtras().getString("book_rating") ;
        String image_url = getIntent().getExtras().getString("book_img") ;

        // ini views

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView tv_name = findViewById(R.id.aa_anime_name);
        TextView tv_publisher = findViewById(R.id.aa_publisher);
        TextView tv_kategori = findViewById(R.id.aa_kategori) ;
        TextView tv_description = findViewById(R.id.aa_description);
        TextView tv_rating  = findViewById(R.id.aa_rating) ;
        ImageView img = findViewById(R.id.aa_thumbnail);

        // setting values to each view

        tv_name.setText(name);
        tv_kategori.setText(kategori);
        tv_description.setText(description);
        tv_rating.setText(rating);
        tv_publisher.setText(publisher);

        collapsingToolbarLayout.setTitle(name);


        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // set image using Glide
        Glide.with(this).load(image_url).apply(requestOptions).into(img);





    }

    private ActionBar getSupportActionBar() {
        return null;
    }
}
