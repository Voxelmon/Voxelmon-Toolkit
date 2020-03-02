package com.zundrel.voxelmontoolkit.voxelmon.stats;

public class VoxelmonStats {
    private VoxelmonBaseStats base;
    private VoxelmonEVYield yield;

    public VoxelmonStats() {

    }

    public VoxelmonStats(VoxelmonBaseStats stats, VoxelmonEVYield yield) {
        this.base = stats;
        this.yield = yield;
    }

    public VoxelmonBaseStats getBase() {
        return base;
    }

    public void setBase(VoxelmonBaseStats base) {
        this.base = base;
    }

    public VoxelmonEVYield getYield() {
        return yield;
    }

    public void setYield(VoxelmonEVYield yield) {
        this.yield = yield;
    }
}