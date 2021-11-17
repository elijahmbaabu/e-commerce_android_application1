package com.example.assignment1;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PurchaseFragment extends Fragment {

    RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_purchase, container, false);
        recyclerView = view.findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        Ebuy_store[] ebuy_store = new Ebuy_store[]{
                new Ebuy_store("Laptop Bag", "$15.99", R.drawable.laptop_bag),
                new Ebuy_store("Microsoft Surface Laptop", "$455.69", R.drawable.tecno_spark7),
                new Ebuy_store("Oppo reno 6", "$233.55", R.drawable.oppo_smartphone),
                new Ebuy_store("Tecno Spark 7", "$210.99", R.drawable.spark),
                new Ebuy_store("Travelling Suit Case", "$22.99", R.drawable.travelling_bag),
                new Ebuy_store("32GB See Dete Flash", "$33.99", R.drawable.seedeteflash),
                new Ebuy_store("Xiaomi 9C", "$133", R.drawable.redmie)
        };
Items_adapterHolder items_adapterHolder = new Items_adapterHolder(ebuy_store,PurchaseFragment.this);
recyclerView.setAdapter(items_adapterHolder);
        return view;

    }
}