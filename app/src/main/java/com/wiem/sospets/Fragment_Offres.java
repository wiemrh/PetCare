package com.wiem.sospets;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

public class Fragment_Offres extends Fragment {

    FloatingActionButton add ;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.Adapter adapter;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View result =  inflater.inflate(R.layout.fragment_offres, container, false);
        add = result.findViewById(R.id.fab);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 getFragmentManager().beginTransaction().replace(R.id.fragment_container , new Fragment_Add_Offer()).commit(); }});


        recyclerView = result.findViewById(R.id.recycler_view);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter();
        recyclerView.setAdapter(adapter);



              return result ; }


}
