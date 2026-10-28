package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== CHARACTER MANAGER TP3 ===");

        Character arjuna =
                new Character(1, "Arjuna", CharacterType.WARRIOR, 5);

        Character merlin =
                new Character(2, "Merlin", CharacterType.MAGE, 3);

        Character athena =
                new Character(3, "Athena", CharacterType.ARCHER, 4);

        System.out.println("\n--- Daftar Karakter ---");
        System.out.println(arjuna);
        System.out.println(merlin);
        System.out.println(athena);

        System.out.println("\n--- Demo Level Up ---");
        System.out.println("Level Arjuna sebelum: " + arjuna.getLevel());

        arjuna.levelUp();

        System.out.println("Level Arjuna sesudah: " + arjuna.getLevel());
        System.out.println("HP Arjuna: " + arjuna.getHitPoints());
        System.out.println("Attack Arjuna: " + arjuna.getAttackPower());

        System.out.println("\n--- Mini-Challenge TP3 ---");

        Character zombie =
                new Character(4, "Zombie", CharacterType.HEALER);

        zombie.setMana(50);

        System.out.println(zombie);
        System.out.println("Mana Zombie: " + zombie.getMana());
        System.out.println("Apakah Zombie hidup? " + zombie.isAlive());

        System.out.println("\n--- Validasi Mana ---");

        try {
            zombie.setMana(-10);
        } catch (IllegalArgumentException e) {
            System.out.println("Validasi berhasil: " + e.getMessage());
        }

        System.out.println("\nTotal karakter dibuat: "
                + Character.getTotalCharacterCreated());
    }
}