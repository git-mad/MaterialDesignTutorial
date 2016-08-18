package com.gitmad.tejasvinareddyteju.materialdesign.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.graphics.Palette;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.gitmad.tejasvinareddyteju.materialdesign.R;
import com.gitmad.tejasvinareddyteju.materialdesign.model.ImageContent;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

/**
 * A Recycler View Adapter that can display tiles of images in a grid. Each tile is loaded with a defaultImage and a
 * color
 * based on the defaultImage.
 *
 * @author nareddyt
 */
public class ImageContentAdapter extends RecyclerView.Adapter<ImageContentAdapter.ViewHolder> {

    private final List<ImageContent> imageContentList;
    private final Random random;
    private Context context = null;

    public ImageContentAdapter(List<ImageContent> items) {
        imageContentList = items;
        random = new Random();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();

        View view = LayoutInflater.from(context).inflate(R.layout.image_grid_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        // Get the correct id from the list, then set the text in the view
        holder.mIdView.setText(imageContentList.get(position).getId());

        final int width = random.nextInt(20) + 90;
        final int height = random.nextInt(20) + 90;

        // VERY hacky way to get a random defaultImage. Note that this happens asynchronously
        // Tbh the defaultImage should be a part of the ImageContent, but this kinda works and is easier to implement
        Picasso.with(context).load("https://placeimg.com/" + width + "/" + height + "/tech").fit().into(holder
                .mImageView, new Callback.EmptyCallback() {
            @Override
            public void onSuccess() {
                // Get the bitmap from the defaultImage view holder
                Bitmap bitmap = ((BitmapDrawable) holder.mImageView.getDrawable()).getBitmap();

                // TODO Use the Palette to determine a prominent color in the defaultImage
                // TODO Then set the background color of the card view
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageContentList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // Fields in the view
        public final TextView mIdView;
        public final ImageView mImageView;
        public final CardView mCardView;

        public ViewHolder(View view) {
            super(view);
            mIdView = (TextView) view.findViewById(R.id.id);
            mImageView = (ImageView) view.findViewById(R.id.content);
            mCardView = (CardView) view.findViewById(R.id.item_card);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mImageView.toString() + "'";
        }
    }
}
