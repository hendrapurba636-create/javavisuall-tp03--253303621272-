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

    // Constructor pertama
    public Character(int id, String name, CharacterType type, int level) {
        validateName(name);

        if (type == null) {
            throw new IllegalArgumentException("Tipe karakter tidak boleh null.");
        }

        if (level < 1) {
            throw new IllegalArgumentException("Level minimal 1.");
        }

        this.id = id;
        this.name = name;
        this.type = type;
        this.level = level;
        this.mana = 0;

        calculateStats();
        totalCharacterCreated++;
    }

    // Constructor kedua
    public Character(int id, String name, CharacterType type) {
        this(id, name, type, 1);
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Nama tidak boleh kosong.");
        }
    }

    private void calculateStats() {
        switch (type) {
            case WARRIOR:
                hitPoints = 100 + level * 20;
                attackPower = 15 + level * 5;
                break;

            case MAGE:
                hitPoints = 70 + level * 10;
                attackPower = 25 + level * 7;
                break;

            case ARCHER:
                hitPoints = 85 + level * 12;
                attackPower = 20 + level * 6;
                break;

            case HEALER:
                hitPoints = 100 + level * 15;
                attackPower = 10 + level * 3;
                break;
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        validateName(name);
        this.name = name;
    }

    public CharacterType getType() {
        return type;
    }

    public void setType(CharacterType type) {
        if (type == null) {
            throw new IllegalArgumentException("Tipe karakter tidak boleh null.");
        }

        this.type = type;
        calculateStats();
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        if (level < 1) {
            throw new IllegalArgumentException("Level minimal 1.");
        }

        this.level = level;
        calculateStats();
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        if (hitPoints < 0) {
            throw new IllegalArgumentException("HP tidak boleh negatif.");
        }

        this.hitPoints = hitPoints;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        if (attackPower < 0) {
            throw new IllegalArgumentException("Attack tidak boleh negatif.");
        }

        this.attackPower = attackPower;
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        if (mana < 0) {
            throw new IllegalArgumentException("Mana tidak boleh negatif.");
        }

        this.mana = mana;
    }

    public boolean isAlive() {
        return hitPoints > 0;
    }

    public void levelUp() {
        setLevel(level + 1);
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
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
                ", isAlive=" + isAlive() +
                '}';
    }
}