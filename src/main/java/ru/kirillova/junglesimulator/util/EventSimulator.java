package ru.kirillova.junglesimulator.util;

import ru.kirillova.junglesimulator.entity.Leopard;

public class EventSimulator {

  //0 -10  //леопард поспал - +25 энергии
   // 10 - 15 // леопард побегал - 10 энергии
   // 15- 20 //на леопарда напали гиены - 35 здоровья
   // 20 - 30 //на леопарда напал браконьер - 23 здоровья
    // 30 - 35//леопард переплывает реку - 15 энергии
   //35 - 40 //леопард съел антилопу - 5 энергия; коэфф * 8 здоровья
    // 40 - 50//леопард съел птицу  + 3 здоровья
   // 50 = 60 //леопард съел зебру - 5 энергия; коэфф * 8 здоровья
    // 60 - 80 //леопард отдыхает + 8 энергия
   //80 - 100 //леопард охотится - 10 энергия
    //энергия = 0 то -7 здоровья

    public void startSimulation(Leopard leopard) {
        while(checkStatus(leopard)) {
            int eventNumber = (int) (Math.random() * 100);
            if (eventNumber <= 0 && eventNumber < 10) {
                sleepEvent(leopard);
            } else if (eventNumber >= 10 && eventNumber < 15) {
                move(leopard);
            } else if (eventNumber >= 15 && eventNumber < 20) {
                hyenasAttack(leopard);
            } else if (eventNumber >= 20 && eventNumber < 30) {
                poacherAttack(leopard);
            } else if (eventNumber >= 30 && eventNumber < 35) {
                swim(leopard);
            } else if (eventNumber >= 35 && eventNumber < 40) {
                leopardEatAntelope(leopard);
            }  else if (eventNumber >= 40 && eventNumber < 50) {
                leopardEatBird(leopard);
            } else if (eventNumber >= 50 && eventNumber < 60) {
                leopardEatZebra(leopard);
            } else if (eventNumber >= 60 && eventNumber < 80) {
                restEvent(leopard);
            } else if (eventNumber >= 80 && eventNumber < 100) {
                huntEvent(leopard);
            }
        }
        System.out.println("Леопард умер! The end!");
}
    private void sleepEvent(Leopard leopard) {
        int energy = leopard.getEnergy();
        energy = energy + 25;
        if(energy > 100) {
            energy = 100;
        }
        leopard.setEnergy(energy);
        checkEnergy(leopard);
        System.out.println("Леопард поспал! + 20 энергии. Текущая энергия: " + leopard.getEnergy());
    }

    private void move(Leopard leopard) {
        int energy = leopard.getEnergy();
        energy = energy - 10;
        if(energy < 0) {
            energy = 0;
        }
        leopard.setEnergy(energy);
        checkEnergy(leopard);
        System.out.println("Леопард побегал! -10 энергии. Текущая энергия: " + leopard.getEnergy());
    }

    private void hyenasAttack(Leopard leopard) {
        int health = leopard.getHealth();
        health = health - 35;
        if(health < 0) {
            health = 0;
        }
        leopard.setHealth(health);
        checkEnergy(leopard);
        System.out.println("На леопарда напали гиены! - 35 здоровья. Текущее здоровье: " + leopard.getHealth());
    }

    private void poacherAttack(Leopard leopard) {
        int health = leopard.getHealth();
        health = health - 23;
        if(health < 0) {
            health = 0;
        }
        leopard.setHealth(health);
        checkEnergy(leopard);
        System.out.println("На леопарда напал браконьер! - 25 здоровья. Текущее здоровье: " + leopard.getHealth());
    }

    private void swim(Leopard leopard) {
        int energy = leopard.getEnergy();
        energy = energy - 15;
        if(energy < 0) {
            energy = 0;
        }
        leopard.setEnergy(energy);
        checkEnergy(leopard);
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
        checkEnergy(leopard);
        System.out.println("Леопард съел антилопу! Текущая энергия: " + leopard.getEnergy() + " Текущее здоровье: " + leopard.getHealth());
    }

    private void leopardEatBird(Leopard leopard) {
        int health = leopard.getHealth();
        health = health + 3;
        if(health > 100) {
            health = 100;
        }
        leopard.setHealth(health);
        checkEnergy(leopard);
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
        checkEnergy(leopard);
        System.out.println("Леопард съел зебру! Текущая энергия: " + leopard.getEnergy() + " Текущее здоровье: " + leopard.getHealth());
    }

    private void restEvent(Leopard leopard) {
        int energy = leopard.getEnergy();
        energy = energy + 8;
        if(energy > 100) {
            energy = 100;
        }
        leopard.setEnergy(energy);
        checkEnergy(leopard);
        System.out.println("Леопард отдохнул! + 6 энергии. Текущая энергия: " + leopard.getEnergy());
    }

    private void huntEvent(Leopard leopard) {
        int energy = leopard.getEnergy();

        energy = energy - 10;
        if (energy < 0) {
            energy = 0;
        }
        leopard.setEnergy(energy);
        checkEnergy(leopard);
        System.out.println("Леопард охотится! - 10 энергии. Текущая энергия: " + leopard.getEnergy());
    }
    private boolean checkStatus(Leopard leopard) {
        System.out.println("hp: " + leopard.getHealth() + " energy: " + leopard.getEnergy());
        if (leopard.getHealth() <= 0) {
            return false;
        } else {
            return true;
        }
    }

    private void checkEnergy(Leopard leopard) {
        if(leopard.getEnergy() <= 0) {
            int health = leopard.getHealth();
            health = health - 7;
            if(health < 0) {
                health = 0;
            }
            leopard.setHealth(health);
        }
    }
}
