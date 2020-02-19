package com.company.kg.geektech.game.players;

public class Tank extends Hero {

    private int doubleHit;

    public Tank(int health, int damage, int doubleHit) {
        super(health, damage, SuperAbility.SAVE_DAMAGE_AND_REVERT);
        this.doubleHit = doubleHit;
    }

    public int getDoubleHit() {
        return doubleHit;
    }

    public void setDoubleHit(int doubleHit) {
        this.doubleHit = doubleHit;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

       boss.setHealth(boss.getHealth() - doubleHit);


    }
}
