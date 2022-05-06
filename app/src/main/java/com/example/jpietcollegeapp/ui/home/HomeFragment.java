package com.example.jpietcollegeapp.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.jpietcollegeapp.R;
import com.smarteist.autoimageslider.DefaultSliderView;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderLayout;


public class HomeFragment extends Fragment {
    private SliderLayout sliderLayout;
    private ImageView map;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_home, container, false);

        sliderLayout=view.findViewById(R.id.slider);
        sliderLayout.setIndicatorAnimation(IndicatorAnimations.FILL);
        sliderLayout.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderLayout.setScrollTimeInSec(10);


        setSliderViews();
        map=view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });
        return view;
    }

    private void openMap() {
        Uri uri= Uri.parse("geo:0,0?q=JP Institute of Engineering and Technology Meerut");
        Intent intent=new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    private void setSliderViews() {
        for(int i=0;i<8;i++){
            DefaultSliderView sliderView=new DefaultSliderView(getContext());
            switch (i){
                case 0:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jpiet-admin-app.appspot.com/o/jpiet%20images%2Fjp1.jpg?alt=media&token=a9ea7a09-f730-4070-bb87-0790adbfaa2e");
                    break;
                case 1:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jpiet-admin-app.appspot.com/o/jpiet%20images%2Fjp2.jpg?alt=media&token=b20f8e7d-e47f-46c8-b281-b40072774e18");
                    break;
                case 2:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jpiet-admin-app.appspot.com/o/jpiet%20images%2Fjp3.jpeg?alt=media&token=5a98344e-9753-494d-802e-3016ff88ad0c");
                    break;
                case 3:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jpiet-admin-app.appspot.com/o/jpiet%20images%2Fjp4.jpeg?alt=media&token=0501292f-fe7b-4885-b9c5-22dd48ded06d");
                    break;
                case 4:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jpiet-admin-app.appspot.com/o/jpiet%20images%2Fjp5.jpeg?alt=media&token=037b53b1-7d59-431d-a9f2-ce75767dae45");
                    break;
                case 5:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jpiet-admin-app.appspot.com/o/jpiet%20images%2Fjp6.jpeg?alt=media&token=372740cb-a2f8-4d4c-ba55-e84a8e0279b7");
                    break;
                case 6:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jpiet-admin-app.appspot.com/o/jpiet%20images%2Fjp7.jpeg?alt=media&token=0927fb7e-2970-4f8d-a188-ca18fee6be9c");
                    break;
                 case 7:
                    sliderView.setImageUrl("https://firebasestorage.googleapis.com/v0/b/jpiet-admin-app.appspot.com/o/jpiet%20images%2Fjp8.jpeg?alt=media&token=6160aba7-88c0-4d43-8736-b237843f2d04");
                    break;

            }
            sliderView.setImageScaleType(ImageView.ScaleType.FIT_XY);
            sliderLayout.addSliderView(sliderView);

        }
    }
}