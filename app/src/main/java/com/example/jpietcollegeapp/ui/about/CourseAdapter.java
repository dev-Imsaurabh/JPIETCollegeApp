package com.example.jpietcollegeapp.ui.about;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.jpietcollegeapp.R;

import java.util.Calendar;
import java.util.List;

public class CourseAdapter extends PagerAdapter {
    private Context context;
    private List<CourseModel>list;

    public CourseAdapter(Context context, List<CourseModel> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return view.equals(object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view=LayoutInflater.from(context).inflate(R.layout.course_item_layout,container,false);
        ImageView course_icon;
        TextView course_description,course_title;
        
        
        course_icon=view.findViewById(R.id.course_icon);
        
        course_title=view.findViewById(R.id.course_title);
        
        course_description=view.findViewById(R.id.course_description);
       
       
        
        course_icon.setImageResource(list.get(position).getImg());

        course_title.setText(list.get(position).getTitle());

        course_description.setText(list.get(position).getDescription());
        
        container.addView(view,0);
        return view;
        
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
