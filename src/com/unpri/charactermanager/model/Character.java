
package com.unpri.charactermanager.model;

public class Character {

    private int id;
    private String name;
    private CharacterType type;
    private int level;
    private int hitPoints;
    private int attackPower;
    private int mana;

    private static int totalCharacterCreated = 0;

    // Constructor sederhana
    public Character(String name, CharacterType type) {
        this(name, type, 1, 100, 10);
    }

    // Constructor dengan atribut lengkap
    public Character(String name, CharacterType type,
                     int level, int hitPoints, int attackPower) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong");
        }

        if (type == null) {
            throw new IllegalArgumentException("Tipe tidak boleh kosong");
        }

        if (level < 1 || hitPoints < 1 || attackPower < 0) {
            throw new IllegalArgumentException("Nilai karakter tidak valid");
        }

        this.id = ++totalCharacterCreated;
        this.name = name;
        this.type = type;
        this.level = level;
        this.hitPoints = hitPoints;
        this.attackPower = attackPower;
        this.mana = 0;
    }

    // Constructor dengan level
    public Character(String name, CharacterType type, int level) {
        this(name, type, level, 100, 10);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        this.type = type;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getAttack() {
        return attackPower;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttack(int attackPower) {
        this.attackPower = attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public void levelUp() {
        level++;
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Character)) return false;

        Character other = (Character) obj;

        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public int hashCode() {
        return name.toLowerCase().hashCode();
    }

    @Override
    public String toString() {
        return "Character{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", level=" + level +
                ", hitPoints=" + hitPoints +
                ", attackPower=" + attackPower +
                ", mana=" + mana +
                '}';
    }
}
