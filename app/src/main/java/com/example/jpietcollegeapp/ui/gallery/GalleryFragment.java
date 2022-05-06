package com.example.jpietcollegeapp.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jpietcollegeapp.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {
    RecyclerView albumRecycler,inceptraRecycler,other_eventsRecycler;
    GalleryAdapter adapter;
    DatabaseReference reference;


    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);
        albumRecycler=view.findViewById(R.id.albumRecycler);
        inceptraRecycler=view.findViewById(R.id.inceptraRecycler);
        other_eventsRecycler=view.findViewById(R.id.other_eventsRecycler);

        reference= FirebaseDatabase.getInstance().getReference().child("gallery");
        getAlbumImage();
        getInceptraImage();
        getOtherImage();
        return view;

    }

    private void getAlbumImage() {
        reference.child("College Album").addValueEventListener(new ValueEventListener() {

            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);
                }
                adapter=new GalleryAdapter(getContext(),imageList);
                albumRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                albumRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });


    }



    private void getInceptraImage() {

        reference.child("Inceptra Pics").addValueEventListener(new ValueEventListener() {

            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);
                }
                adapter=new GalleryAdapter(getContext(),imageList);
                inceptraRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                inceptraRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }




    private void getOtherImage() {

        reference.child("Other events").addValueEventListener(new ValueEventListener() {

            List<String> imageList=new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1:snapshot.getChildren()){
                    String data= (String) snapshot1.getValue();
                    imageList.add(data);
                }
                adapter=new GalleryAdapter(getContext(),imageList);
                other_eventsRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                other_eventsRecycler.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

    }
}