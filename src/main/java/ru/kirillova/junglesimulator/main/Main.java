package ru.kirillova.junglesimulator.main;

import ru.kirillova.junglesimulator.entity.Leopard;
import ru.kirillova.junglesimulator.util.EventSimulator;

public class Main {

    public static void main(String[] args) {
    Leopard leopard = new Leopard();
    EventSimulator eventSimulator = new EventSimulator();
    eventSimulator.startSimulation(leopard);
    }
}
