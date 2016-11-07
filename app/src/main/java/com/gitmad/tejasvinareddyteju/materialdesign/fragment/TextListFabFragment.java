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

        // Set up recycler view and the layout
        recyclerView = (RecyclerView) view.findViewById(R.id.app_list_recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);

        // Set up swipe-up-to-refresh layout
        // Note that the following code can be found in the slides
        // TODO instantiate the SwipeRefreshLayout from the XML. Note the SRL is declared on line 32
        // TODO set the proper OnRefreshListener
        // HINT: You will have to figure which XML the SRL is in, and then the correct element id for the SRL
        // HINT: What does line 54 tell you about this class? What about line 26?

        // Reset the recycler view to set the adapter (automatically)
        refreshRecyclerView();

        // Some of the code for the FAB can be found in the slides. Doing the onClickListener is the hardest part
        // TODO instantiate the FAB from the XML
        // TODO create an on click listener that will add a new TextContent item to the textContentList
        // Construct the TextContent with some text that you want to be displayed
        // HINT: You will have to figure which XML the FAB is in, and then the correct element id for the FAB
        // Challenge: Try to get a number to show up with the text, incrementing the number each time the FAB is pressed. Test it out! It's not as easy at it sounds :)

        return view;
    }

    private void refreshRecyclerView() {
        // Set up the adapter
        RecyclerView.Adapter adapter = new TextContentAdapter(textContentList);
        recyclerView.setAdapter(adapter);
    }
}
