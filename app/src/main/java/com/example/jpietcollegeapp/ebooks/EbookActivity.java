package com.example.jpietcollegeapp.ebooks;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.jpietcollegeapp.R;
import com.facebook.shimmer.ShimmerFrameLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class EbookActivity extends AppCompatActivity {
    private RecyclerView ebookRecycler;
    private DatabaseReference reference;
    private List<EbookData>list;
    private EbookAdapter adapter;
    ShimmerFrameLayout shimmerFrameLayout;
    LinearLayout shimmer_layout;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ebook);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Ebooks");
        ebookRecycler=findViewById(R.id.ebookRecycler);
        shimmerFrameLayout=findViewById(R.id.shimmer_view_container);
        shimmer_layout=findViewById(R.id.shimmer_layout);
        searchView=findViewById(R.id.searchView);
        reference= FirebaseDatabase.getInstance().getReference().child("pdf");

        getData();
    }

    private void getData() {
        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                list=new ArrayList<>();

                for(DataSnapshot snapshot1:snapshot.getChildren()){
                    EbookData data=snapshot1.getValue(EbookData.class);
                    list.add(data);


                }
                adapter=new EbookAdapter(EbookActivity.this,list);
                ebookRecycler.setLayoutManager(new LinearLayoutManager(EbookActivity.this));
                ebookRecycler.setAdapter(adapter);
                shimmerFrameLayout.stopShimmer();
                shimmer_layout.setVisibility(View.GONE);


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

                Toast.makeText(EbookActivity.this,error.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                filter(s);
                return true;
            }
        });
    }

    private void filter(String s) {

        ArrayList<EbookData> filterList = new ArrayList<>();
        for (EbookData item : list){
            if(item.getPdfTite().toLowerCase().contains(s.toLowerCase())){
                filterList.add(item);
            }
        }
        adapter.FilteredList(filterList);
    }


    @Override
    protected void onPause() {
        shimmerFrameLayout.stopShimmer();
        super.onPause();
    }

    @Override
    protected void onResume() {
        shimmerFrameLayout.startShimmer();
        super.onResume();
    }
}