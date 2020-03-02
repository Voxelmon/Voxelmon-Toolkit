package com.zundrel.voxelmontoolkit.voxelmon;

import com.zundrel.voxelmontoolkit.voxelmon.stats.VoxelmonStats;

public class VoxelmonObject {
    private String region;
    private VoxelmonInfo info;
    private VoxelmonBreeding breeding;
    private VoxelmonStats stats;
    private VoxelmonMoves moves;
    private VoxelmonPokedex pokedex;

    public VoxelmonObject() {

    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public VoxelmonInfo getInfo() {
        return info;
    }

    public void setInfo(VoxelmonInfo info) {
        this.info = info;
    }

    public VoxelmonBreeding getBreeding() {
        return breeding;
    }

    public void setBreeding(VoxelmonBreeding breeding) {
        this.breeding = breeding;
    }

    public VoxelmonStats getStats() {
        return stats;
    }

    public void setStats(VoxelmonStats stats) {
        this.stats = stats;
    }

    public VoxelmonMoves getMoves() {
        return moves;
    }

    public void setMoves(VoxelmonMoves moves) {
        this.moves = moves;
    }

    public VoxelmonPokedex getPokedex() {
        return pokedex;
    }

    public void setPokedex(VoxelmonPokedex pokedex) {
        this.pokedex = pokedex;
    }

	public void setAll(VoxelmonInfo info, VoxelmonBreeding breeding, VoxelmonStats stats, VoxelmonMoves moves, VoxelmonPokedex pokedex) {
    	this.info = info;
    	this.breeding = breeding;
    	this.stats = stats;
    	this.moves = moves;
		this.pokedex = pokedex;
	}
}
