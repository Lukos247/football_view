package com.football.cal.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.football.cal.BaseAdapter;
import com.football.cal.BaseListener;
import com.football.cal.R;
import com.football.cal.model.BaseMatch;
import com.football.cal.model.BaseModel;

import java.util.ArrayList;

/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment implements BaseListener {

    ArrayList<BaseModel> array;

    public static PlaceholderFragment newInstance(ArrayList<BaseModel> array) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("array", array);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("array",array);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState!=null && savedInstanceState.containsKey("array")) array = savedInstanceState.getParcelableArrayList("array");
        else if(getArguments()!=null) array = getArguments().getParcelableArrayList("array");
    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);
        BaseAdapter adapter = new BaseAdapter(array);
        final RecyclerView recyclerView  = root.findViewById(R.id.recycler);
        adapter.setBaseListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return root;
    }

    @Override
    public void click(BaseMatch match) {

    }
}