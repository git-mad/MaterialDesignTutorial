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
import com.gitmad.tejasvinareddyteju.materialdesign.fragment.ImageGridFragment.OnListFragmentInteractionListener;
import com.gitmad.tejasvinareddyteju.materialdesign.model.ImageContent.DummyItem;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.Random;

/**
 * {@link RecyclerView.Adapter} that can display a {@link DummyItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 */
public class ImageContentAdapter extends RecyclerView.Adapter<ImageContentAdapter.ViewHolder> {

    private final List<DummyItem> mValues;
    private final OnListFragmentInteractionListener mListener;
    private final Random random;
    private Context context = null;

    public ImageContentAdapter(List<DummyItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
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
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);

        final int width = random.nextInt(20) + 90;
        final int height = random.nextInt(20) + 90;
        Picasso.with(context).load("https://placeimg.com/" + width + "/" + height + "/tech").fit().into(holder
                .mContentView, new Callback.EmptyCallback() {
            @Override
            public void onSuccess() {
                Bitmap bitmap = ((BitmapDrawable) holder.mContentView.getDrawable()).getBitmap();

                Palette palette = Palette.from(bitmap).generate();

                holder.mCardView.setCardBackgroundColor(palette.getVibrantColor(255));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final ImageView mContentView;
        public final CardView mCardView;
        public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.id);
            mContentView = (ImageView) view.findViewById(R.id.content);
            mCardView = (CardView) view.findViewById(R.id.item_card);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mContentView.toString() + "'";
        }
    }
}
