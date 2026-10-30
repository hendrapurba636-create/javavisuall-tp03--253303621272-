package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== Character Manager v0.1 ===");
        System.out.println();

        // Membuat tiga karakter menggunakan constructor pertama
        Character hero = new Character(
                "Arjuna", CharacterType.WARRIOR, 5);

        Character wizard = new Character(
                "Merlin", CharacterType.MAGE, 3);

        Character scout = new Character(
                "Athena", CharacterType.ARCHER, 4);

        // Menampilkan tiga karakter
        System.out.println("=== Daftar Karakter ===");
        System.out.println(hero);
        System.out.println(wizard);
        System.out.println(scout);

        // Demo level up
        System.out.println();
        System.out.println("=== Demo Level Up ===");
        System.out.println(">> " + hero.getName() + " level up!");

        hero.setLevel(hero.getLevel() + 1);

        System.out.println("After level up: " + hero);

        // Menampilkan informasi karakter
        System.out.println();
        System.out.println("=== Informasi Hero ===");
        System.out.println("Nama: " + hero.getName());
        System.out.println("Jenis: " + hero.getType());
        System.out.println("Level: " + hero.getLevel());
        System.out.println("HP: " + hero.getHitPoints());
        System.out.println("Attack: " + hero.getAttackPower());

        // Mini-Challenge: membuat karakter baru
        System.out.println();
        System.out.println("=== Mini-Challenge: Mana dan isAlive ===");

        Character healer = new Character(
                "Luna", CharacterType.HEALER, 2);

        healer.setMana(80);

        System.out.println("Karakter baru: " + healer);
        System.out.println("Mana Luna: " + healer.getMana());
        System.out.println("Apakah Luna masih hidup? "
                + healer.isAlive());

        // Menguji isAlive ketika HP mencapai nol
        healer.setHitPoints(0);

        System.out.println("HP Luna setelah berubah: "
                + healer.getHitPoints());

        System.out.println("Apakah Luna masih hidup? "
                + healer.isAlive());

        // Jumlah objek yang dibuat
        System.out.println();
        System.out.println("Total karakter dibuat: "
                + Character.getTotalCharacterCreated());
    }
}