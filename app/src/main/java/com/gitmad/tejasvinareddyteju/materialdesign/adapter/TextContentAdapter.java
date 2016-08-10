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
 * A Recycler View Adapter to display cards of text in a list. Each card is loaded with a the text and defaultImage.
 *
 * @author nareddyt
 */
public class TextContentAdapter extends RecyclerView.Adapter<TextContentAdapter.ViewHolder> {

    private List<TextContent> textContentList;

    public TextContentAdapter(List<TextContent> textContentList) {
        this.textContentList = textContentList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.text_list_view, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int i) {
        viewHolder.name.setText(textContentList.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return textContentList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // Fields in the view
        public TextView name;
        public ImageView defaultImage;

        public ViewHolder(View appViewLayout) {
            super(appViewLayout);
            name = (TextView) appViewLayout.findViewById(R.id.app_name);
            defaultImage = (ImageView) appViewLayout.findViewById(R.id.app_image);
        }
    }
}
