package ru.kirillova.junglesimulator.util;

import ru.kirillova.junglesimulator.entity.Leopard;

public class EventSimulator {

    //леопард поспал - +20 энергии
    //леопард побегал - 7 энергии
    //на леопарда напали гиены - 35 здоровья
    //на леопарда напал браконьер - 25 здоровья
    //энергия = 0 то -7 здоровья
    //леопард съел антилопу - 8 энергия; + 15 здоровья
    //леопард съел птицу - 3 энергия; + 5 здоровья
    //леопард съел зебру - 7 энергия; + 12 здоровья
    //леопард отдыхает + 5 энергия
    //леопард охотится - 15 энергия

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

}
