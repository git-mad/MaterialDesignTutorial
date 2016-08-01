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

public class TextListFabFragment extends Fragment {

    // Data variables
    private List<TextContent> textContentList = new ArrayList<>();

    // UI variables
    private SwipeRefreshLayout srl;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public TextListFabFragment() {
    }

    public static TextListFabFragment newInstance() {
        TextListFabFragment fragment = new TextListFabFragment();
        return fragment;
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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View view = inflater.inflate(R.layout.fragment_text_list, container, false);

        // Mock data
        textContentList.add(new TextContent("Testing"));

        // Set up recycler view
        recyclerView = (RecyclerView) view.findViewById(R.id.app_list_recycler_view);
        layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Set up swipe-up-to-refresh layout
        srl = (SwipeRefreshLayout) view.findViewById(R.id.swipeRefreshLayout);
        srl.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                refreshRecyclerView();
                srl.setRefreshing(false);
            }
        });

        // Reset the recycler view to set the adapter
        refreshRecyclerView();

        final AtomicInteger atomicInteger = new AtomicInteger(0);
        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textContentList.add(new TextContent("Test " + atomicInteger.getAndIncrement()));
            }
        });

        return view;
    }

    private void refreshRecyclerView() {

        // Set up the adapter
        adapter = new TextContentAdapter(textContentList,
                new TextContentAdapter.FeedInteractionListener() {
                    @Override
                    public void onAppClicked(TextContent app, int index) {
                    }
                });
        recyclerView.setAdapter(adapter);
    }
}
