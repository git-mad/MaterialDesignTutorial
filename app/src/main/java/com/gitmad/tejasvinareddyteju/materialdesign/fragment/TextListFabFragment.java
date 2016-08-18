package com.gitmad.tejasvinareddyteju.materialdesign.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.gitmad.tejasvinareddyteju.materialdesign.R;
import com.gitmad.tejasvinareddyteju.materialdesign.adapter.TextContentAdapter;
import com.gitmad.tejasvinareddyteju.materialdesign.model.TextContent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A fragment that displays cards of text
 *
 * @author nareddyt
 */
public class TextListFabFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener {

    // Data variables
    private List<TextContent> textContentList = new ArrayList<>();

    // UI variables
    private SwipeRefreshLayout srl;
    private RecyclerView recyclerView;

    public TextListFabFragment() {
        // Mandatory empty constructor
    }

    public static TextListFabFragment newInstance() {
        return new TextListFabFragment();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onRefresh() {
        refreshRecyclerView();
        srl.setRefreshing(false);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_text_list, container, false);

        // Mock data
        textContentList.add(new TextContent("Testing"));

        // TODO instantiate the RecyclerView from the XML
        // TODO set up the recycler view to use a linear layout manager

        // Set up swipe-up-to-refresh layout
        // TODO instantiate the SwipeRefreshLayout from the XML
        // TODO set the proper OnRefreshListener

        // Reset the recycler view to set the adapter (automatically)
        refreshRecyclerView();

        // Set up the FAB button to add a new item to the list whenever its clicked
        // Use an atomic integer to maintain the int across multiple threads (the onClickListener happens in a
        // different thread each time)
        final AtomicInteger atomicInteger = new AtomicInteger(0);

        // TODO instantiate the FAB from the XML
        // TODO create an on click listener that will add a new item to the textContentList. Make sure to use the
        // atomic integer to as a way to ID the text

        return view;
    }

    private void refreshRecyclerView() {
        // Set up the adapter
        RecyclerView.Adapter adapter = new TextContentAdapter(textContentList);
        recyclerView.setAdapter(adapter);
    }
}
