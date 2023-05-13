package com.yiriba.recyclerapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.yiriba.recyclerapp.adapter.Adapter;
import com.yiriba.recyclerapp.adapter.ItemClickListener;
import com.yiriba.recyclerapp.model.Vaccine;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    // 1 - AdapterView: RecyclerView
    RecyclerView recyclerview;

    // 2- Data source:
    Vaccine[] myListData;


    // 3- Adapter
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerview = findViewById(R.id.recycler_view);
        myListData = new Vaccine[]{
                new Vaccine(R.drawable.covid19, "Coronavirus"),
                new Vaccine(R.drawable.moderna, "Moderna"),
                new Vaccine(R.drawable.pfizer, "Pfizer"),
                new Vaccine(R.drawable.hepb, "Hepatitis B"),
                new Vaccine(R.drawable.hepc, "Hepatitis C"),
                new Vaccine(R.drawable.janssen, "J&J"),
                new Vaccine(R.drawable.malaria, "Malaria"),
                new Vaccine(R.drawable.yellow, "Yellow Fever"),
                new Vaccine(R.drawable.tetanus, "Tetanus")
        };

        // Adapter
        adapter = new Adapter(myListData);
        recyclerview.setHasFixedSize(true);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);

        //  handling click events
        adapter.setClickListener(this);
    }

    @Override
    public void onClick(View view, int position) {
        Toast.makeText(this, "Vaccine name: "+ myListData[position].getTitle(), Toast.LENGTH_SHORT).show();
    }
}