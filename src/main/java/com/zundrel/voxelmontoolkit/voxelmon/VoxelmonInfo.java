package com.zundrel.voxelmontoolkit.voxelmon;

import java.util.ArrayList;

public class VoxelmonInfo {
    private int maleChance;
    private String levelRate;
    private int catchRate;
    private ArrayList<String> types = new ArrayList<>();

    public VoxelmonInfo() {

    }

    public int getMaleChance() {
        return maleChance;
    }

    public void setMaleChance(int maleChance) {
        this.maleChance = maleChance;
    }

    public String getLevelRate() {
        return levelRate;
    }

    public void setLevelRate(String levelRate) {
        this.levelRate = levelRate;
    }

    public int getCatchRate() {
        return catchRate;
    }

    public void setCatchRate(int catchRate) {
        this.catchRate = catchRate;
    }

    public ArrayList<String> getTypes() {
        return types;
    }

    public void setTypes(ArrayList<String> types) {
        this.types = types;
    }

    public void addType(String type) {
        this.types.add(type);
    }

    public String getType(int index) {
        return this.types.get(index);
    }
}