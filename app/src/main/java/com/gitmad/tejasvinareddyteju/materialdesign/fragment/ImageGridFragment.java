package com.gitmad.tejasvinareddyteju.materialdesign.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gitmad.tejasvinareddyteju.materialdesign.R;
import com.gitmad.tejasvinareddyteju.materialdesign.adapter.ImageContentAdapter;
import com.gitmad.tejasvinareddyteju.materialdesign.model.ImageContent;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment that displays the the grid of items. Is customizable to display the grid in different-sized columns.
 *
 * @author nareddyt
 */
public class ImageGridFragment extends Fragment {

    // Data variables
    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount;

    public ImageGridFragment() {
        // Mandatory empty constructor
    }

    public static ImageGridFragment newInstance(int columnCount) {
        ImageGridFragment fragment = new ImageGridFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image_list, container, false);

        // Set up the recycler view
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;

            // Set up the layout manager based on the column count
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }

            // Create the dummy image content
            List<ImageContent> imageContentList = new ArrayList<>();
            for (int i = 1; i <= 10; i++) {
                imageContentList.add(new ImageContent(String.valueOf(i)));
            }

            // Set the adapter with the dummy list
            recyclerView.setAdapter(new ImageContentAdapter(imageContentList));
        }
        return view;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
