package com.jones.tuto_glide;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;


/**
 * Created by Marie on 10/5/17.
 */

public class GlideAdapter extends RecyclerView.Adapter<GlideAdapter.ViewHolder> {

    private String[] mImages = new String[]{
            "https://cdn.pixabay.com/photo/2015/03/26/09/39/cupcakes-690040_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/08/30/11/31/candy-2696734_960_720.jpg",
            "https://cdn.pixabay.com/photo/2016/05/03/02/01/eclairs-1368343_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/07/30/10/35/ice-2553926_960_720.jpg",
            "https://cdn.pixabay.com/photo/2016/11/03/05/40/cookies-1793555_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/08/09/15/31/jars-2614897_960_720.jpg",
            "https://cdn.pixabay.com/photo/2014/11/08/15/50/ice-cream-sandwich-522384_960_720.jpg",
            "https://cdn.pixabay.com/photo/2010/12/14/14/58/jelly-beans-3150_960_720.jpg",
            "https://cdn.pixabay.com/photo/2015/08/27/10/16/kit-kat-909833_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/01/07/20/40/candy-1961539_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/08/29/08/48/mouse-bacon-2692474_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/03/31/05/35/almond-2190456_960_720.jpg",
            "https://cdn.pixabay.com/photo/2017/08/07/02/32/glass-2598884_960_720.jpg"
    };

    private String[] mTexts = new String[]{
            "Cupcake",
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "Kit Kat",
            "Lollipop",
            "Marshmallow",
            "Nougat",
            "Oreo"
    };

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_view, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Context context = holder.mView.getContext();
        String url = this.mImages[position];
        ImageView imageView = holder.mImageView;

        ImageLoader.load(context, url, imageView);

        holder.mImage = this.mImages[position];
        holder.mText = this.mTexts[position];
    }

    @Override
    public int getItemCount() {
        return this.mImages.length;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public View mView;
        public ImageView mImageView;
        public String mImage;
        public String mText;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mImageView = (ImageView) view.findViewById(R.id.image_view);

            mView.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mView.getContext(), DetailActivity.class);
                    intent.putExtra("Image", mImage);
                    intent.putExtra("texte", mText);

                    mView.getContext().startActivity(intent);
                }
            });
        }
    }

}