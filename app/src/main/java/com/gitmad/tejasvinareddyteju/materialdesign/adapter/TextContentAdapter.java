package com.gitmad.tejasvinareddyteju.materialdesign.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.gitmad.tejasvinareddyteju.materialdesign.R;
import com.gitmad.tejasvinareddyteju.materialdesign.model.TextContent;

import java.util.List;

/**
 * Adapter for displaying cardviews that represent apps in a RecyclerView.
 */
public class TextContentAdapter extends RecyclerView.Adapter<TextContentAdapter
        .ViewHolder> {

    private List<TextContent> apps;
    private FeedInteractionListener listener;

    public TextContentAdapter(List<TextContent> apps, FeedInteractionListener
            feedInteractionListener) {
        this.apps = apps;
        listener = feedInteractionListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_list_view, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.packageName.setText(apps.get(i).getPackageName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onAppClicked(apps.get(i), i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return apps.size();
    }

    public interface FeedInteractionListener {
        void onAppClicked(TextContent app, int index);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView packageName;
        public ImageView image;

        public ViewHolder(View appViewLayout) {
            super(appViewLayout);
            packageName = (TextView) appViewLayout.findViewById(R.id.app_name);
            image = (ImageView) appViewLayout.findViewById(R.id.app_image);
        }
    }
}
