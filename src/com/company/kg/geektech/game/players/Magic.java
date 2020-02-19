package com.company.kg.geektech.game.players;

public class Magic extends Hero {

    private int upDamage;

    public Magic(int health, int damage, int upDamage) {
        super(health, damage, SuperAbility.BOOST);
        this.upDamage = upDamage;
    }

    public int getUpDamage() {
        return upDamage;
    }

    public void setUpDamage(int upDamage) {
        this.upDamage = upDamage;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (!heroes[i].getAbility().equals(SuperAbility.BOOST)) {
            }
            boss.setHealth(boss.getHealth() - upDamage);

        }
    }
}
