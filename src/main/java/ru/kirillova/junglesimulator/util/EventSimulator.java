package ru.kirillova.junglesimulator.util;

import ru.kirillova.junglesimulator.entity.Leopard;

public class EventSimulator {

    //леопард поспал - +20 энергии
    //леопард побегал - 10 энергии
    //на леопарда напали гиены - 35 здоровья
    //на леопарда напал браконьер - 25 здоровья
    //леопард переплывает реку - 15 энергии
    //леопард съел антилопу - 5 энергия; + 15 здоровья
    //леопард съел птицу  + 5 здоровья
    //леопард съел зебру - 3 энергия; + 12 здоровья
    //леопард отдыхает + 6 энергия
    //леопард охотится - 10 энергия
    //энергия = 0 то -7 здоровья

    public void activateEvent() {

    }

    private void sleepEvent(Leopard leopard) {
        int energy = leopard.getEnergy();
        energy = energy + 20;
        if(energy > 100){
            energy = 100;
        }
        leopard.setEnergy(energy);
        System.out.println("Леопард поспал! + 20 энергии. Текущая энергия: " + leopard.getEnergy());
    }

    private void move(Leopard leopard){
        int energy = leopard.getEnergy();
        energy = energy - 10;
        if(energy < 0) {
            energy = 0;
        }
        leopard.setEnergy(energy);
        System.out.println("Леопард побегал! -10 энергии. Текущая энергия:" + leopard.getEnergy());
    }

    private void hyenasAttack(Leopard leopard) {
        int health = leopard.getHealth();
        health = health - 35;
        if(health < 0) {
            health = 0;
        }
        leopard.setHealth(health);
        System.out.println("На леопарда напали гиены! - 35 здоровья. Текущее здоровье:" + leopard.getHealth());
    }

    private void poacherAttack(Leopard leopard) {
        int health = leopard.getHealth();
        health = health - 25;
        if(health < 0) {
            health = 0;
        }
        leopard.setHealth(health);
        System.out.println("На леопарда напал браконьер! - 25 здоровья. Текущее здоровье:" + leopard.getHealth());
    }




}
