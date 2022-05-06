package com.example.jpietcollegeapp.ui.about;

public class CourseModel {
    private int img;
    private String title,description;


    public CourseModel(int img, String title, String description) {
        this.img = img;
        this.title = title;
        this.description = description;

    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
