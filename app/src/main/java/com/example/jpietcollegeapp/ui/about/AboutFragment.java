package com.example.jpietcollegeapp.ui.about;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;
import com.example.jpietcollegeapp.R;

import java.util.ArrayList;
import java.util.List;


public class AboutFragment extends Fragment {
    private ViewPager viewPager;
    private CourseAdapter adapter;
    private List<CourseModel>list;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_about, container, false);

        list=new ArrayList<>();
        list.add(new CourseModel(R.drawable.ic_cs ,"Computer Science","hello"));
        list.add(new CourseModel(R.drawable.ic_mech ,"Mechanical","Mechanical engineering is an engineering branch that combines engineering physics and mathematics principles with materials science to design, analyze, manufacture, and maintain mechanical systems. It is one of the oldest and broadest of the engineering branches."));
        list.add(new CourseModel(R.drawable.ic_elec ,"Electrical","Electrical engineering is one of the newer branches of engineering, and dates back to the late 19th century. It is the branch of engineering that deals with the technology of electricity. Electrical engineers work on a wide range of components, devices and systems, from tiny microchips to huge power station generators."));

        adapter=new CourseAdapter(getContext(),list);
        viewPager=view.findViewById(R.id.viewPager);
        viewPager.setAdapter(adapter);

        ImageView imageView=view.findViewById(R.id.college_image);
        Glide.with(getContext()).load("https://firebasestorage.googleapis.com/v0/b/jpiet-admin-app.appspot.com/o/jpiet%20images%2Fjp1.jpg?alt=media&token=a9ea7a09-f730-4070-bb87-0790adbfaa2e").centerCrop().into(imageView);
        return view;
    }
}