
package com.unpri.charactermanager;

import com.unpri.charactermanager.model.Character;
import com.unpri.charactermanager.model.CharacterType;
import com.unpri.charactermanager.model.CharacterManager;

public class Main {

    public static void main(String[] args) {

        System.out.println("===== CHARACTER MANAGER TP5 =====");

        CharacterManager manager = new CharacterManager();

        // 1. Tambah karakter
        System.out.println("\n--- 1. TAMBAH KARAKTER ---");

        manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 5));

        manager.addCharacter(
                new Character("Merlin", CharacterType.MAGE, 3));

        manager.addCharacter(
                new Character("Athena", CharacterType.ARCHER, 4));

        manager.addCharacter(
                new Character("Bima", CharacterType.WARRIOR, 8));

        manager.addCharacter(
                new Character("Luna", CharacterType.MAGE, 6));

        for (Character character : manager.getAllCharacters()) {
            System.out.println(character);
        }

        System.out.println("Total karakter: "
                + manager.getTotalCharacters());

        // 2. Tes nama duplikat
        System.out.println("\n--- 2. TES DUPLIKAT ---");

        boolean berhasil = manager.addCharacter(
                new Character("Arjuna", CharacterType.WARRIOR, 2));

        System.out.println("Tambah Arjuna kedua: "
                + (berhasil ? "BERHASIL" : "DITOLAK"));

        System.out.println("Total karakter: "
                + manager.getTotalCharacters());

        // 3. Tes pencarian
        System.out.println("\n--- 3. TES PENCARIAN ---");

        Character hasil = manager.findByName("Merlin");

        System.out.println(hasil != null
                ? "Ditemukan: " + hasil
                : "Merlin tidak ditemukan");

        // 4. Tes rata-rata level
        System.out.println("\n--- 4. RATA-RATA LEVEL ---");

        System.out.println("Rata-rata level: "
                + manager.getAverageLevel());

        // 5. Tes pencarian berdasarkan tipe
        System.out.println("\n--- 5. PENCARIAN BERDASARKAN TIPE ---");

        for (Character character :
                manager.findByType(CharacterType.WARRIOR)) {
            System.out.println(character);
        }

        // 6. Fitur sendiri: karakter dengan attack tertinggi
        System.out.println("\n--- 6. KARAKTER TERKUAT ---");

        Character strongest = manager.findStrongest();

        System.out.println(strongest != null
                ? strongest
                : "Belum ada karakter");

        // 7. Tes defensive copy
        System.out.println("\n--- 7. TES DEFENSIVE COPY ---");

        int totalAwal = manager.getTotalCharacters();

        manager.getAllCharacters().clear();

        System.out.println("Total sebelum: " + totalAwal);

        System.out.println("Total setelah salinan dibersihkan: "
                + manager.getTotalCharacters());

        // 8. Tes penghapusan
        System.out.println("\n--- 8. TES PENGHAPUSAN ---");

        boolean dihapus = manager.removeCharacter("Athena");

        System.out.println("Athena berhasil dihapus: "
                + (dihapus ? "YA" : "TIDAK"));

        System.out.println("Total setelah penghapusan: "
                + manager.getTotalCharacters());

        System.out.println("\n===== PENGUJIAN TP5 SELESAI =====");
    }
}
