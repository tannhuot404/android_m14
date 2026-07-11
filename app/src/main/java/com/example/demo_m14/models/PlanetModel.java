package com.example.demo_m14.models;

public class PlanetModel {
    private String name;
    private int totalMoon;
    private int img;

    public PlanetModel(String name, int totalMoon, int img) {
        this.name = name;
        this.totalMoon = totalMoon;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTotalMoon() {
        return totalMoon;
    }

    public void setTotalMoon(int totalMoon) {
        this.totalMoon = totalMoon;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
