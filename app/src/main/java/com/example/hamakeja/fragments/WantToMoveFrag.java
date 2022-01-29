package com.example.hamakeja.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hamakeja.R;
import com.example.hamakeja.adapter.TruckAdapter;
import com.example.hamakeja.model.Truck;

import java.util.ArrayList;
import java.util.List;

public class WantToMoveFrag extends Fragment {
    List<Truck> mTruckList;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mTruckList = new ArrayList<>();
    }

    public WantToMoveFrag() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.frag_want_to_move, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);
        TruckAdapter truckAdapter = new TruckAdapter(getContext(), mTruckList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(truckAdapter);
        return view;


    }
}