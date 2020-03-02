package com.zundrel.voxelmontoolkit.voxelmon;

import java.util.ArrayList;

public class VoxelmonBreeding {
    private int hatchTimeMax, hatchTimeMin;
    private ArrayList<String> eggGroups = new ArrayList<>();

    public VoxelmonBreeding() {

    }

    public int getHatchTimeMax() {
        return hatchTimeMax;
    }

    public void setHatchTimeMax(int hatchTimeMax) {
        this.hatchTimeMax = hatchTimeMax;
    }

    public int getHatchTimeMin() {
        return hatchTimeMin;
    }

    public void setHatchTimeMin(int hatchTimeMin) {
        this.hatchTimeMin = hatchTimeMin;
    }

    public ArrayList<String> getEggGroups() {
        return eggGroups;
    }

    public void setEggGroups(ArrayList<String> eggGroups) {
        this.eggGroups = eggGroups;
    }

    public void setGroup(String type) {
        this.eggGroups.add(type);
    }

    public String getGroup(int index) {
        return this.eggGroups.get(index);
    }
}