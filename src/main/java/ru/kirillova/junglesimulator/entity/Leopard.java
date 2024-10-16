package ru.kirillova.junglesimulator.entity;

public class Leopard {

    // 100 hp
    // 100 energy
    // коэффициент зубов - энергия, получаемая от еды

    private int health = 100;
    private int energy = 100;
    private double fangs = 2.5;

    public void setHealth(int health) {
        this.health = health;
    }

    public int getHealth() {
        return this.health;
    }

    public void setEnergy(int energy) {
        this.energy = energy;
    }
    public int getEnergy() {
        return this.energy;
    }
    public double getFangs() {
        return this.fangs;
    }

}


