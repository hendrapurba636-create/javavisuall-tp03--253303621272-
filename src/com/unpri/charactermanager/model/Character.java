package com.unpri.charactermanager.model;

import java.util.Objects;

/**
 * Merepresentasikan karakter dalam aplikasi Character Manager.
 */
public class Character {

    // Atribut private (encapsulation)
    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    // Menghitung jumlah objek yang dibuat
    private static int totalCharacterCreated = 0;

    // Constructor 1: membuat karakter baru
    public Character(String name, CharacterType type, int level) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama tidak boleh kosong");
        }

        if (type == null) {
            throw new IllegalArgumentException(
                    "Tipe karakter tidak boleh null");
        }

        if (level < 1) {
            throw new IllegalArgumentException(
                    "Level minimal adalah 1");
        }

        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
        this.mana = 0;

        totalCharacterCreated++;
    }

    // Constructor 2: membuat karakter dari data yang sudah ada
    public Character(int id, String name, CharacterType type,
                     int level, int hitPoints, int attackPower) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama tidak boleh kosong");
        }

        if (type == null) {
            throw new IllegalArgumentException(
                    "Tipe karakter tidak boleh null");
        }

        if (level < 1) {
            throw new IllegalArgumentException(
                    "Level minimal adalah 1");
        }

        if (hitPoints < 0 || attackPower < 0) {
            throw new IllegalArgumentException(
                    "HP dan attack tidak boleh negatif");
        }

        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = 0;

        totalCharacterCreated++;
    }

    // Menghitung HP berdasarkan level
    private int calculateBaseHP() {
        return 100 + (level * 10);
    }

    // Menghitung attack berdasarkan level
    private int calculateBaseAttack() {
        return 10 + (level * 5);
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public CharacterType getType() {
        return type;
    }

    public int getLevel() {
        return level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getMana() {
        return mana;
    }

    // Setter
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Nama tidak boleh kosong");
        }

        this.name = name;
    }

    public void setType(CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException(
                    "Tipe karakter tidak boleh null");
        }

        this.type = type;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException(
                    "Level minimal adalah 1");
        }

        this.level = level;

        // HP dan attack dihitung ulang ketika level berubah
        this.hitPoints = calculateBaseHP();
        this.attackPower = calculateBaseAttack();
    }

    public void setHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            throw new IllegalArgumentException(
                    "HP tidak boleh negatif");
        }

        this.hitPoints = hitPoints;
    }

    public void setAttackPower(int attackPower) {
        if (attackPower < 0) {
            throw new IllegalArgumentException(
                    "Attack tidak boleh negatif");
        }

        this.attackPower = attackPower;
    }

    // Mini-Challenge: setter mana dengan validasi
    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException(
                    "Mana tidak boleh negatif");
        }

        this.mana = mana;
    }

    // Mini-Challenge: memeriksa apakah karakter masih hidup
    public boolean isAlive() {
        return hitPoints > 0;
    }

    // Mendapatkan jumlah karakter yang dibuat
    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    // Dua karakter dianggap sama jika namanya sama
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof Character)) {
            return false;
        }

        Character other = (Character) obj;
        return Objects.equals(this.name, other.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    // Menampilkan informasi karakter, termasuk mana
    @Override
    public String toString() {
        return "Character{id=" + id
                + ", name='" + name + '\''
                + ", type=" + type
                + ", level=" + level
                + ", hp=" + hitPoints
                + ", atk=" + attackPower
                + ", mana=" + mana
                + '}';
    }
}