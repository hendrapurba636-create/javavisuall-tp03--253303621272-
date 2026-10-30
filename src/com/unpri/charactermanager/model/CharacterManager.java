
package com.unpri.charactermanager.model;

import java.util.ArrayList;

public class CharacterManager {

    private final ArrayList<Character> characters = new ArrayList<>();

    /**
     * Menambahkan karakter jika nama belum digunakan.
     */
    public boolean addCharacter(Character character) {
        if (character == null || findByName(character.getName()) != null) {
            return false;
        }

        characters.add(character);
        return true;
    }

    /**
     * Mencari karakter berdasarkan nama tanpa membedakan huruf besar/kecil.
     */
    public Character findByName(String name) {
        if (name == null) {
            return null;
        }

        for (Character character : characters) {
            if (character.getName().equalsIgnoreCase(name)) {
                return character;
            }
        }

        return null;
    }

    /**
     * Menghapus karakter berdasarkan nama.
     */
    public boolean removeCharacter(String name) {
        Character character = findByName(name);

        if (character == null) {
            return false;
        }

        characters.remove(character);
        return true;
    }

    /**
     * Mengembalikan jumlah karakter yang tersimpan.
     */
    public int getTotalCharacters() {
        return characters.size();
    }

    /**
     * Mengembalikan salinan daftar karakter.
     */
    public ArrayList<Character> getAllCharacters() {
        return new ArrayList<>(characters);
    }

    /**
     * Menghitung rata-rata level karakter. Mengembalikan 0 jika kosong.
     */
    public double getAverageLevel() {
        if (characters.isEmpty()) {
            return 0.0;
        }

        int total = 0;

        for (Character character : characters) {
            total += character.getLevel();
        }

        return (double) total / characters.size();
    }

    /**
     * Mengembalikan daftar karakter berdasarkan tipe.
     */
    public ArrayList<Character> findByType(CharacterType type) {
        ArrayList<Character> result = new ArrayList<>();

        if (type == null) {
            return result;
        }

        for (Character character : characters) {
            if (character.getType() == type) {
                result.add(character);
            }
        }

        return result;
    }

    /**
     * Mencari karakter dengan attack power tertinggi.
     * Mengembalikan null jika daftar kosong.
     */
    public Character findStrongest() {
        if (characters.isEmpty()) {
            return null;
        }

        Character strongest = characters.get(0);

        for (Character character : characters) {
            if (character.getAttackPower() > strongest.getAttackPower()) {
                strongest = character;
            }
        }

        return strongest;
    }
}
