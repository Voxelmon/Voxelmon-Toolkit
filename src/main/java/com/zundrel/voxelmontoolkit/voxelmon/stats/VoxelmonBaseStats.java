package com.zundrel.voxelmontoolkit.voxelmon.stats;

public class VoxelmonBaseStats {
    private int hp, atk, def, spatk, spdef, speed, friendship;

    public VoxelmonBaseStats() {

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getAtk() {
        return atk;
    }

    public void setAtk(int atk) {
        this.atk = atk;
    }

    public int getDef() {
        return def;
    }

    public void setDef(int def) {
        this.def = def;
    }

    public int getSpatk() {
        return spatk;
    }

    public void setSpatk(int spatk) {
        this.spatk = spatk;
    }

    public int getSpdef() {
        return spdef;
    }

    public void setSpdef(int spdef) {
        this.spdef = spdef;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getFriendship() {
        return friendship;
    }

    public void setFriendship(int friendship) {
        this.friendship = friendship;
    }

    public void setStats(int hp, int atk, int def, int spatk, int spdef, int speed, int friendship) {
        this.hp = hp;
        this.atk = atk;
        this.def = def;
        this.spatk = spatk;
        this.spdef = spdef;
        this.speed = speed;
        this.friendship = friendship;
    }
}