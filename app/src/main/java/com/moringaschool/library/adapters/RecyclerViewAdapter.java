package com.moringaschool.library.adapters;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import com.moringaschool.library.Network.BookActivity;
import com.moringaschool.library.R;
import com.moringaschool.library.models.Book;

import java.util.List;



public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Book> mData ;
    RequestOptions option;


    public RecyclerViewAdapter(Context mContext, List<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;

        // Request option for image
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.book_row_item,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, BookActivity.class);
                i.putExtra("book_name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("book_description",mData.get(viewHolder.getAdapterPosition()).getDescription());
                i.putExtra("book_publisher",mData.get(viewHolder.getAdapterPosition()).getPublisher());
                i.putExtra("book_kategori",mData.get(viewHolder.getAdapterPosition()).getKategori());
                i.putExtra("book_nb_pages",mData.get(viewHolder.getAdapterPosition()).getNb_pages());
                i.putExtra("book_rating",mData.get(viewHolder.getAdapterPosition()).getRating());
                i.putExtra("book_img",mData.get(viewHolder.getAdapterPosition()).getImage_url());

                mContext.startActivity(i);

            }
        });




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.tv_name.setText(mData.get(position).getName());
        holder.tv_rating.setText(mData.get(position).getRating());
        holder.tv_publisher.setText(mData.get(position).getPublisher());
        holder.tv_kategori.setText(mData.get(position).getKategori());

        // Loading Image from the internet and setting it into Imageview

        Glide.with(mContext).load(mData.get(position).getImage_url()).apply(option).into(holder.img_thumbnail);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_name ;
        TextView tv_rating ;
        TextView tv_publisher ;
        TextView tv_kategori;
        ImageView img_thumbnail;
        LinearLayout view_container;





        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);
            tv_name = itemView.findViewById(R.id.book_name);
            tv_kategori = itemView.findViewById(R.id.kategori);
            tv_rating = itemView.findViewById(R.id.rating);
            tv_publisher = itemView.findViewById(R.id.publisher);
            img_thumbnail = itemView.findViewById(R.id.thumbnail);

        }
    }

}
