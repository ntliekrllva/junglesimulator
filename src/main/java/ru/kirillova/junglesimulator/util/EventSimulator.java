package ru.kirillova.junglesimulator.util;

import ru.kirillova.junglesimulator.entity.Leopard;

public class EventSimulator {

    //леопард поспал - +20 энергии
    //леопард побегал - 10 энергии
    //на леопарда напали гиены - 35 здоровья
    //на леопарда напал браконьер - 25 здоровья
    //леопард переплывает реку - 15 энергии
    //леопард съел антилопу - 8 энергия; коэфф * 8 здоровья
    //леопард съел птицу  + 3 здоровья
    //леопард съел зебру - 5 энергия; коэфф * 8 здоровья
    //леопард отдыхает + 6 энергия
    //леопард охотится - 10 энергия
    //энергия = 0 то -7 здоровья

    public void activateEvent() {

    }

    private void sleepEvent(Leopard leopard) {
        int energy = leopard.getEnergy();
        energy = energy + 20;
        if(energy > 100) {
            energy = 100;
        }
        leopard.setEnergy(energy);
        System.out.println("Леопард поспал! + 20 энергии. Текущая энергия: " + leopard.getEnergy());
    }

    private void move(Leopard leopard) {
        int energy = leopard.getEnergy();
        energy = energy - 10;
        if(energy < 0) {
            energy = 0;
        }
        leopard.setEnergy(energy);
        System.out.println("Леопард побегал! -10 энергии. Текущая энергия: " + leopard.getEnergy());
    }

    private void hyenasAttack(Leopard leopard) {
        int health = leopard.getHealth();
        health = health - 35;
        if(health < 0) {
            health = 0;
        }
        leopard.setHealth(health);
        System.out.println("На леопарда напали гиены! - 35 здоровья. Текущее здоровье: " + leopard.getHealth());
    }

    private void poacherAttack(Leopard leopard) {
        int health = leopard.getHealth();
        health = health - 25;
        if(health < 0) {
            health = 0;
        }
        leopard.setHealth(health);
        System.out.println("На леопарда напал браконьер! - 25 здоровья. Текущее здоровье: " + leopard.getHealth());
    }

    private void swim(Leopard leopard) {
        int energy = leopard.getEnergy();
        energy = energy - 15;
        if(energy < 0) {
            energy = 0;
        }
        leopard.setEnergy(energy);
        System.out.println("Леопард переплывает реку! - 15 энергии. Текущая энергия: " + leopard.getEnergy());
    }

    private void leopardEatAntelope(Leopard leopard) {
        int energy = leopard.getEnergy();
        int health = leopard.getHealth();
        energy = energy - 5;
        if(energy < 0) {
            energy = 0;
        }
        health = health + (int) (leopard.getFangs() * 8);
        if(health > 100) {
            health = 100;
        }
        leopard.setEnergy(energy);
        leopard.setHealth(health);
        System.out.println("Леопард съел антилопу! Текущая энергия: " + leopard.getEnergy() + " Текущее здоровье: " + leopard.getHealth());
    }

    private void leopardEatBird(Leopard leopard) {
        int health = leopard.getHealth();
        health = health + 3;
        if(health > 100) {
            health = 100;
        }
        leopard.setHealth(health);
        System.out.println("Леопард съел птицу! Текущее здоровье: " + leopard.getHealth());
    }

    private void leopardEatZebra(Leopard leopard) {
        int energy = leopard.getEnergy();
        int health = leopard.getHealth();
        energy = energy - 8;
        if(energy < 0) {
            energy = 0;
        }
        health = health + (int) (leopard.getFangs() * 8);
        if(health > 100) {
            health = 100;
        }
        leopard.setEnergy(energy);
        leopard.setHealth(health);
        System.out.println("Леопард съел зебру! Текущая энергия: " + leopard.getEnergy() + " Текущее здоровье: " + leopard.getHealth());
    }

    private void restEvent(Leopard leopard) {
        int energy = leopard.getEnergy();
        energy = energy + 6;
        if(energy > 100) {
            energy = 100;
        }
        leopard.setEnergy(energy);
        System.out.println("Леопард отдохнул! + 6 энергии. Текущая энергия: " + leopard.getEnergy());
    }

    private void huntEvent(Leopard leopard) {
        int energy = leopard.getEnergy();
        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        leopard.setEnergy(energy);
        System.out.println("Леопард охотится! - 10 энергии. Текущая энергия: " + leopard.getEnergy());
    }
    private boolean statusChecker(Leopard leopard) {
        if (leopard.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }
}
