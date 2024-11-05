package se.tommy.adventure.model;

public abstract class Entity {


    int health;
    int damage;
    String name;

    public Entity(int health, int damage) {
        this.health = health;
        this.damage = damage;
    }

    public void takeHit(int hit) {
        this.health -= hit;
    }

    public void punch(Entity toPunch) {
        toPunch.takeHit(this.damage);
    }

    public boolean isConcious() {
        return this.health > 0;
    }

    public int getHealth() {
        return this.health;
    }

    public int getDamage() {
        return this.damage;
    }

    public String getName() {
        return this.name;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }
}
