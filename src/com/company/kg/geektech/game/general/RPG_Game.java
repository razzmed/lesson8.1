package com.company.kg.geektech.game.general;


import com.company.kg.geektech.game.players.*;

public class RPG_Game {
    public static void start() {
        Boss boss = new Boss(400, 50);
        Warrior warrior = new Warrior(230, 10, 0);
        Tank tank = new Tank(210, 10, 50);
        Magic magic = new Magic(260, 10, 5);
        Medic medic = new Medic(250, 2, 15);
        Medic youngMedic = new Medic(290, 5, 5);

        Hero[] heroes = {warrior, tank, magic, medic, youngMedic};

        printStatistics(boss, heroes);
        while (!isFinished(boss, heroes)) {
            round(boss, heroes);
        }
    }

    private static void heroesApplySuperAbility(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            heroes[i].applySuperAbility(boss, heroes);
        }
    }

    private static void round(Boss boss, Hero[] heroes) {
        bossHits(boss, heroes);
        heroHit(boss, heroes);
        heroesApplySuperAbility(boss, heroes);
        printStatistics(boss, heroes);
    }

    private static void printStatistics(Boss boss, Hero[] heroes) {
        System.out.println("___________________________");
        System.out.println("Boss heals: " + boss.getHealth());
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i].getClass().getSimpleName() + " heals: " + heroes[i].getHealth());
        }
        System.out.println("___________________________");
    }

    private static void heroHit(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (boss.getHealth() > 0) {
                boss.setHealth(boss.getHealth() - heroes[i].getDamage());
            }
        }
    }

    private static void bossHits(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth() - boss.getDamage());
            }
        }
    }


    private static boolean isFinished(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDied = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDied = false;
                break;
            }

        }
        if (allHeroesDied) {
            System.out.println("Boss won!!!");
        }

        return allHeroesDied;
    }
}
