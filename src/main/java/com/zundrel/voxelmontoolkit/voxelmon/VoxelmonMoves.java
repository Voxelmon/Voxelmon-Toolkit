package com.zundrel.voxelmontoolkit.voxelmon;

import java.util.ArrayList;
import java.util.HashMap;

public class VoxelmonMoves {
    private ArrayList<String> learnableMoves = new ArrayList<>();
    private HashMap<Integer, ArrayList<String>> levelMoves = new HashMap<>();
    private ArrayList<String> eggMoves = new ArrayList<>();
    private ArrayList<String> evolutionMoves = new ArrayList<>();

    public ArrayList<String> getLearnableMoves() {
        return learnableMoves;
    }

    public void setLearnableMoves(ArrayList<String> learnableMoves) {
        this.learnableMoves = learnableMoves;
    }

    public void setLearnableMove(String move) {
        this.learnableMoves.add(move);
    }

    public String getLearnableMove(int index) {
        return this.learnableMoves.get(index);
    }

    public HashMap<Integer, ArrayList<String>> getLevelMoves() {
        return levelMoves;
    }

    public void setLevelMoves(HashMap<Integer, ArrayList<String>> levelMoves) {
        this.levelMoves = levelMoves;
    }

    public ArrayList<String> getLevelArray(int level) {
        return getLevelMoves().get(level);
    }

    public void setLevelArray(int level, ArrayList<String> array) {
        getLevelMoves().put(level, array);
    }

    public void setLevelMove(int level, String move) {
        getLevelMoves().putIfAbsent(level, new ArrayList<String>());
        getLevelArray(level).add(move);
    }

    public String getLevelMove(int level, int index) {
        getLevelMoves().putIfAbsent(level, new ArrayList<String>());
        return getLevelArray(level).get(index);
    }

    public ArrayList<String> getEggMoves() {
        return eggMoves;
    }

    public void setEggMoves(ArrayList<String> eggMoves) {
        this.eggMoves = eggMoves;
    }

    public void setEggMove(String move) {
        this.eggMoves.add(move);
    }

    public String getEggMove(int index) {
        return this.eggMoves.get(index);
    }

    public ArrayList<String> getEvolutionMoves() {
        return evolutionMoves;
    }

    public void setEvolutionMoves(ArrayList<String> evolutionMoves) {
        this.evolutionMoves = evolutionMoves;
    }

    public void setEvolutionMove(String move) {
        this.evolutionMoves.add(move);
    }

    public String getEvolutionMove(int index) {
        return this.evolutionMoves.get(index);
    }
}